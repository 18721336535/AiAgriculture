import request from '@/utils/request'

// 查询设备组管理列表
export function listEqpgroup(query) {
  return request({
    url: '/manage/eqpgroup/list',
    method: 'get',
    params: query
  })
}

// 查询设备组管理详细
export function getEqpgroup(id) {
  return request({
    url: '/manage/eqpgroup/' + id,
    method: 'get'
  })
}

// 新增设备组管理
export function addEqpgroup(data) {
  return request({
    url: '/manage/eqpgroup',
    method: 'post',
    data: data
  })
}

// 修改设备组管理
export function updateEqpgroup(data) {
  return request({
    url: '/manage/eqpgroup',
    method: 'put',
    data: data
  })
}

// 删除设备组管理
export function delEqpgroup(id) {
  return request({
    url: '/manage/eqpgroup/' + id,
    method: 'delete'
  })
}
