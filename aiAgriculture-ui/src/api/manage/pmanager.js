import request from '@/utils/request'

// 查询人工管理列表
export function listPmanager(query) {
  return request({
    url: '/manage/pmanager/list',
    method: 'get',
    params: query
  })
}

// 查询人工管理详细
export function getPmanager(id) {
  return request({
    url: '/manage/pmanager/' + id,
    method: 'get'
  })
}

// 新增人工管理
export function addPmanager(data) {
  return request({
    url: '/manage/pmanager',
    method: 'post',
    data: data
  })
}

// 修改人工管理
export function updatePmanager(data) {
  return request({
    url: '/manage/pmanager',
    method: 'put',
    data: data
  })
}

// 删除人工管理
export function delPmanager(id) {
  return request({
    url: '/manage/pmanager/' + id,
    method: 'delete'
  })
}
