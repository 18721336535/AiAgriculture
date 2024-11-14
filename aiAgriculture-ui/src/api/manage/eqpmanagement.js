import request from '@/utils/request'

// 查询设备管理列表
export function listEqpmanagement(query) {
  return request({
    url: '/manage/eqpmanagement/list',
    method: 'get',
    params: query
  })
}

// 查询设备管理详细
export function getEqpmanagement(id) {
  return request({
    url: '/manage/eqpmanagement/' + id,
    method: 'get'
  })
}

// 新增设备管理
export function addEqpmanagement(data) {
  return request({
    url: '/manage/eqpmanagement',
    method: 'post',
    data: data
  })
}

// 修改设备管理
export function updateEqpmanagement(data) {
  return request({
    url: '/manage/eqpmanagement',
    method: 'put',
    data: data
  })
}

// 删除设备管理
export function delEqpmanagement(id) {
  return request({
    url: '/manage/eqpmanagement/' + id,
    method: 'delete'
  })
}
