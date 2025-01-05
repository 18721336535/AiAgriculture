<template>
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
</template>

<script setup name="ControlPane" lang="ts">
     import { useExceptionStore } from '@/store/modules/exception'
     import { storeToRefs } from 'pinia'
     import { ref, reactive, onMounted, onUnmounted, toRefs } from 'vue';
     const exceptionStore = useExceptionStore();
     const {operationHistory} = storeToRefs(exceptionStore);
    //  const newRecord = {
    //   id: '001',
    //   equipmentName: "风扇01",
    //   equipmentStatus: "关闭",
    //   operationTime: new Date().toLocaleString(),
    //   operator: "Admin"
    // };
    operationHistory.value.unshift(exceptionStore.operationHistory);
</script>

<style scoped>

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