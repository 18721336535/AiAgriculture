<template>
  <!-- 第一部分：标题行 -->
  <div style="border: #e9eeee solid 1px;border-radius: 1px;padding: 2px;width: 1300px;">
    <el-header style="height: 50px;font-size: 15px;"> 大棚编号/位置:L001/JXGZ </el-header>
    <div class="flex-container">
      <!-- 第二部分1：环境参数展示和视频展示 -->
      <el-aside style="border: #e9eeee solid 1px;border-radius: 1px; width: 15%;">
        <h3 style="text-align:center">当前环境</h3>
        <hr style="border: #e9eeee solid 1px">
        <div class="sensor-item" style="text-align: center;">
          <text>
            <span style="font-size: 13px;">温度:</span> 
            <span :style="{ color: getFontColor(temperature) }">{{ temperature }}°C</span>
          </text>
        </div>
        <div class="sensor-item" style="text-align: center;">
          <text><span style="font-size: 13px;">湿度:</span> <span>{{ humidity }}RH</span></text>
        </div>
        <div class="sensor-item" style="text-align: center;">
          <text><span style="font-size: 13px;">光照强度:</span> <span>{{ lightIntensity }}lx</span></text>
        </div>
        <div class="sensor-item" style="text-align: center;">
          <text><span style="font-size: 13px;">PM25:</span> <span>{{ PM25 }}</span></text>
        </div>
        <div class="sensor-item" style="text-align: center;">
          <text><span style="font-size: 13px;">CO2浓度:</span> <span>{{ CO2 }}ppmv</span></text>
        </div>
        <div class="sensor-item" style="text-align: center;">
          <text><span style="font-size: 13px;">风速:</span> <span>{{ windSpeed }}m/s</span></text>
        </div>
        <div class="sensor-item" style="text-align: center;">
          <text><span style="font-size: 13px;">气压:</span> <span>{{ pressure }}kPa</span></text>
        </div>
        <div class="sensor-item" style="text-align: center;">
          <text><span style="font-size: 13px;">土壤湿度:</span> <span>{{ soilMoisture }}</span></text>
        </div>
        <div class="sensor-item" style="text-align: center;">
          <text><span style="font-size: 13px;">紫外线:</span> <span>{{ ultravioletRays }}mW/m²</span></text>
        </div>
        <!-- <div v-for="(value, key) in sensorData" :key="key" class="sensor-item" style="text-align: center;">
        <text ><span style="font-size: 13px;">{{ key }}:</span> <span :style="{ color: getFontColor(value) }">{{ value }}</span></text> 
      </div> -->
      </el-aside>

      <!-- 第二部分3：视频区域 -->
      <el-main>
        <video id="remote-camera" controls autoplay>
          您的浏览器不支持 video 标签。
        </video>
      </el-main>

      <!-- 第二部分2：控制按钮区域 -->
      <el-aside style="border: #e9eeee solid 1px;border-radius: 1px; width: 15%;">
        <h3 style="text-align:center">控制区</h3>
        <hr style="border: #e9eeee solid 1px">
        <div class="controlButtons">

          <el-switch label="风机1开关" size="large" v-model="fanMachineSwitchValue" class="mb-2" inline-prompt
            style="margin: 0 25px; --el-switch-off-color: #13ce66" active-text="关闭风机" inactive-text="打开风机" active-value="1" inactive-value="0"
            @change="handleSwitchChange" />

          <el-switch label="风扇2开关" size="large" v-model="fanMachine2SwitchValue" class="mb-2" inline-prompt
            style="margin: 0 25px;--el-switch-off-color: #13ce66" active-text="关闭风机2" inactive-text="打开风机2" active-value="1" inactive-value="0"
            @change="handle2SwitchChange" />

          <el-switch label="滴灌开关" size="large" v-model="wateringSwitchValue" class="mb-2" inline-prompt
            style="margin: 0 25px;--el-switch-off-color: #13ce66" active-text="关闭滴灌" inactive-text="打开滴灌" active-value="1" inactive-value="0"
            @change="handle3SwitchChange" />

          <el-switch label="天窗开关" size="large" v-model="windowSwitchValue" class="mb-2" inline-prompt
            style="margin: 0 25px;--el-switch-off-color: #13ce66" active-text="关闭天窗" inactive-text="打开天窗" active-value="1" inactive-value="0"
            @change="handle4SwitchChange" />

        </div>
      </el-aside>
    </div>
    <!-- 第四部分：操作历史 -->
    <div>
      <div class="controlAudit">
        <h4>设备当前状态</h4>
        <el-table :data="operationHistory">
          <el-table-column prop="id" label="ID"></el-table-column>
          <el-table-column prop="equipmentName" label="设备名称"></el-table-column>
          <el-table-column prop="equipmentStatus" label="设备状态"></el-table-column>
          <el-table-column prop="operationTime" label="操作时间"></el-table-column>
          <el-table-column prop="operator" label="操作人"></el-table-column>
        </el-table>
      </div>
    </div>
  </div>
</template>
<script setup name="ControlPane" lang="ts">
  import { ref, reactive, onMounted, onUnmounted, toRefs } from 'vue';
  import axios from 'axios';
  const fanMachineSwitchValue = ref(true);
  const fanMachine2SwitchValue = ref(true);
  const wateringSwitchValue = ref(true);
  const windowSwitchValue = ref(true);
  let intervalId = 0;
  let cmd = 0;

  const sensorData = reactive({
    temperature: "46",
    humidity: "60",
    lightIntensity: "500",
    PM25: 30,
    CO2: "450",
    windSpeed: "10",
    pressure: "101.325",
    soilMoisture: 70,
    ultravioletRays: "800"
  });
  const {
    temperature,
    humidity,
    lightIntensity,
    PM25,
    CO2,
    windSpeed,
    pressure,
    soilMoisture,
    ultravioletRays
  } = toRefs(sensorData);

  const operationHistory = ref([]);

  onMounted(() => {

    const video = document.querySelector('video');
    // 注意：navigator.getUserMedia语法已废弃，此处使用最新语法：navigator.mediaDevices.getUserMedia
    navigator.mediaDevices.getUserMedia({ audio: false, video: true })
      .then(stream => video.srcObject = stream)
      .catch(err => console.log(err));

    // 页面加载完成后，启动定时器
    intervalId = setInterval(async () => {
      try {
        const response = await axios.get('http://localhost:8080/manage/iot/machine/getTemperature');
        temperature.value = response.data.data.temperature;
        humidity.value = response.data.data.humidity;
      } catch (error) {
        console.error(error);
      }
    }, 3000); // 每隔3秒钟调用一次API
  });


  onUnmounted(() => {
    // 页面卸载前，清除定时器
    if (intervalId) {
      clearInterval(intervalId);
    }
  });

  // 控制按钮的方法
  const handleSwitchChange = async (value) => {
    console.log('handleSwitchChange value:', value);
    cmd = (value == 1) ? "11001":"01001"
    const response = await axios.get('http://localhost:8080/manage/iot/machine/' + cmd);
    console.log('风扇开关状态：', response.data);
    addOperationHistory('风机1', value == 1 ? '打开了' : '关闭了', 'Andy');
  };

  const handle2SwitchChange = (value) => {
    console.log('风扇开关状态：', value);
    addOperationHistory('风扇', '关闭', 'Andy');
  };

  const handle3SwitchChange = () => {
    addOperationHistory('2号滴灌', '打开', 'Andy');
  };

  const handle4SwitchChange = () => {
    addOperationHistory('2号天窗', '关闭', 'Andy');
  };

  const getFontColor = (value) => {
    if (value > 40 || value <= 10) {
      return 'red';
    } else if (value > 35) {
      return 'orange';
    } else {
      return 'green';
    }
  };

  const addOperationHistory = (equipmentName, equipmentStatus, operator) => {
    const newId = operationHistory.value.length + 1;
    const newRecord = {
      id: newId,
      equipmentName: equipmentName,
      equipmentStatus: equipmentStatus,
      operationTime: new Date().toLocaleString(),
      operator: operator
    };
    operationHistory.value.unshift(newRecord);
  };
</script>
<style scoped>
  /* 全局样式 */
  .flex-container {
    width: 100%;
    display: flex;
    flex-direction: row;
    padding: 10px;
    border: #e9eeee solid 1px;
    border-radius: 1px;
  }

  /* 标题行 */
  .el-header {
    background-color: #f0f2f5;
    color: #333;
    text-align: center;
    line-height: 50px;
    font-size: 20px;
    margin-top: 1px;
    margin-bottom: 10px;
  }

  .sensor-item {
    margin-bottom: 10px;
    font-size: 16px;
    border: #e9eeee solid 1px;
    border-radius: 1px;
  }

  .controlButtons {
    height: 85%;
    display: flex;
    flex-direction: column;
    justify-content: space-evenly;
    align-items: baseline;
    /* border: #e9eeee solid 1px; */
    border-radius: 1px;
  }

  /* 视频展示 */
  #remote-camera {
    width: 100%;
    /* height: 100%; */
    object-fit: cover;
  }

  /* 控制按钮区域 */
  .el-footer {
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    align-items: flex-start;
    padding: 10px;
    border-top: 1px solid #e4e7ed;
  }

  .el-footer>div {
    flex: 1;
  }

  .el-footer .el-button+.el-button {
    margin-left: 10px;
  }

  /* 操作历史表格 */
  .el-table {
    width: 100%;
    margin-top: 10px;
  }

  .controlAudit {
    margin-top: 5px;
    border: #e9eeee solid 1px;
    padding: 10px;
    width: 100%;
  }
</style>