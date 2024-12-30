<template>
    <el-table :data="tableData" style="width: 100%" height="50">
      <el-table-column fixed prop="date" label="时间"  />
      <el-table-column prop="typeName" label="类型"  />
      <el-table-column prop="state" label="状态"  />
    </el-table>
</template>
  
  <script lang="ts" setup>

    import { defineProps } from 'vue';
    
    const props = defineProps({
      tableData: []
    });
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
    ]
  </script>
  