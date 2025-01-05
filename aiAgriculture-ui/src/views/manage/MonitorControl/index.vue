<template>
  <!-- 第一部分：标题行 -->
  <div style="border: #e9eeee solid 1px;border-radius: 1px;padding: 2px;width: 1300px;">
    <el-header style="height: 50px;font-size: 15px;"> 种植编号:P0000001 </el-header>
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
        <div style="background-color: yellow;">
          <span> {{inrudersAlertmsg}} </span>
          <!-- <el-alert  title= {{inrudersAlertmsg}} type="error" effect="dark" /> -->
        </div>
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

    <InfoTabs />
    <!-- 第四部分 -->
    
  </div>
</template>
<script setup name="ControlPane" lang="ts">
  import { ref, reactive, onMounted, onUnmounted, toRefs } from 'vue';
  import InfoTabs from '@/views/manage/MonitorControl/monitorTabs/InfoTabs.vue'
  import axios from 'axios';
  import { useExceptionStore } from '@/store/modules/exception'
  const fanMachineSwitchValue = ref(true);
  const fanMachine2SwitchValue = ref(true);
  const wateringSwitchValue = ref(true);
  const windowSwitchValue = ref(true);
  let intervalId = 0;
  let intervalId2 = 0;
  let cmd = 0;
  const backendPath = "http://localhost:8080";

  const filename = 'frame.jpg'; // 想要的文件名
  const mimeType = 'image/jpeg'; // 图片的MIME类型


  const sensorData = reactive({
    temperature: "46",
    humidity: "60",
    lightIntensity: "500",
    PM25: 30,
    CO2: "450",
    windSpeed: "10",
    pressure: "101.325",
    soilMoisture: 70,
    ultravioletRays: "800",
    existInruder: 0,
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
    ultravioletRays,
    existInruder,
  } = toRefs(sensorData);

  const existInruders = ref('N')
  const inrudersAlertmsg = ref('')

  const operationHistory = ref([]);

  const exceptionStore = useExceptionStore();

  const tableData = [
      {
        date: new Date().toLocaleTimeString(),
        typeName: '温度',
        state: '温度过高',
      },
      {
        date: new Date().toLocaleTimeString(),
        typeName: '可疑目标',
        state: '检测到人脸',
      },
    ];
  const urlTofiles = function urlTofile (url, filename, mimeType) {
    return (fetch(url)
      .then(res => res.arrayBuffer())
      .then(buffer => new Blob([buffer], { type: mimeType }))
      .then(blob => new File([blob], filename, { type: mimeType }))
    );
  };

  onMounted(() => {

    const video = document.querySelector('video');
    // 注意：navigator.getUserMedia语法已废弃，此处使用最新语法：navigator.mediaDevices.getUserMedia
    navigator.mediaDevices.getUserMedia({ audio: false, video: true })
      .then(stream => video.srcObject = stream)
      .catch(err => console.log(err));

    // 页面加载完成后，启动定时器
    intervalId = setInterval(async () => {
      try {
        const response = await axios.get( backendPath + '/manage/iot/machine/getTemperature' );
        temperature.value = response.data.data.temperature;
        humidity.value = response.data.data.humidity;
        exceptionStore.$patch({ temperature: {date:"2024-12-01",typeName:"温度", state:response.data.data.humidity}});
      } catch (error) {
        console.error(error);
      }
    }, 3000); // 每隔3秒钟调用一次API
  });

  // 每隔一定时间抓取一次图片
  intervalId2 = setInterval(function() {
    const video = document.getElementById('remote-camera'); // 使用video标签的id获取Video元素
    const canvas = document.createElement('canvas'); // 创建Canvas元素
    const ctx = canvas.getContext('2d'); // 获取绘图上下文对象
  
    // 设置Canvas的宽度和高度与视频一致
    // canvas.width = "200px";
    // canvas.height = "200px";
  
    // 在Canvas上绘制当前视频帧
    ctx.drawImage(video, 0, 0, canvas.width, canvas.height);
  
    // 将Canvas转换为图片URL
    const frameImageUrl = canvas.toDataURL();

    // 输出图片URL
    console.log(frameImageUrl);
    
    urlTofiles(frameImageUrl, filename, mimeType).then(file => {
      const formData = new FormData();
      formData.append('file', file); // 将文件添加到FormData
      formData.append('jsonParam', JSON.stringify({data:"new data"})); // 将JSON参数转换为字符串并添加
      axios.post( backendPath + '/manage/iot/machine/upload/image', formData, {headers: { 'Content-Type': 'multipart/form-data'}})
        .then(response => { 
          // useExceptionStore.$patch({ errorList: tableData});
          if (response.data.data.faceExist == "Y") {
            existInruders.value=response.data.data.faceExist;
            inrudersAlertmsg.value = " 请注意，有入侵者进入园地！";
            exceptionStore.$patch({ intruder: {date:"2024-12-01",typeName:"入侵异常",state:response.data.data.faceExist}});
          };
          if (response.data.data.faceExist == "N") {
            existInruders.value=response.data.data.faceExist;
            inrudersAlertmsg.value = "";
          };
          console.log(response.data); 
        })
        .catch(error => { console.error(error); });
    }).catch(error => console.error(error)); // 处理错误
 }, 10000); // 每10秒抓取一次


  onUnmounted(() => {
    // 页面卸载前，清除定时器
      clearInterval(intervalId);
      clearInterval(intervalId2);
  });

  // 控制按钮的方法
  const handleSwitchChange = async (value) => {
    console.log('handleSwitchChange value:', value);
    cmd = (value == 1) ? "11001":"01001"
    const response = await axios.get( backendPath + '/manage/iot/machine/' + cmd );
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
    const newId = exceptionStore.operationHistory.length + 1;
    const newRecord = {
      id: newId,
      equipmentName: equipmentName,
      equipmentStatus: equipmentStatus,
      operationTime: new Date().toLocaleString(),
      operator: operator
    };
    // operationHistory.value.unshift(newRecord);
    exceptionStore.$patch({ operationHistory:[...exceptionStore.operationHistory, newRecord]});
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
    height: 600px;
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
    height: 500px;
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

</style>