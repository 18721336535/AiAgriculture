import {defineStore} from 'pinia'

export const useExceptionStore = defineStore('exception', {
  state: () => {
    return {
        temperature: {date:"2024",typeName:"1",state:"0"},
        intruder: {date:"",typeName:"",state:""},
        operationHistory:[{id:"123",equipmentName:"",equipmentStatus:"",operationTime:"",operator:""}],
        // 错误信息
        errorInfo: {},
        // 错误信息
        errorList: [],
        // 错误信息
        errorCount: 0,
    }
  },
  actions: {
    // 添加错误信息
    addErrorInfo(info) {
      this.errorInfo = info
    }
  }
})

