<template>
    <el-tabs v-model="activeName" class="demo-tabs" @tab-click="handleClick">
      <el-tab-pane label="Exceptions" name="first"><Exceptions/></el-tab-pane>
      <el-tab-pane label="Eqpments Status" name="second"><EqpmentsStatus/></el-tab-pane>
      <el-tab-pane label="History" name="third">History</el-tab-pane>
    </el-tabs>
  </template>
  <script lang="ts" setup>
    import { ref } from 'vue'
    import type { TabsPaneContext } from 'element-plus'

    import Exceptions from '@/views/manage/MonitorControl/monitorTabs/ExceptionGrid.vue'
    import EqpmentsStatus from '@/views/manage/MonitorControl/monitorTabs/EqpmentsStatus.vue'
    
    const activeName = ref('first')
    
    const handleClick = (tab: TabsPaneContext, event: Event) => {
        console.log(tab, event)
    }
  </script>
  
  <style>
  .demo-tabs > .el-tabs__content {
    padding: 32px;
    color: #6b778c;
    font-size: 32px;
    font-weight: 600;
  }
  </style>