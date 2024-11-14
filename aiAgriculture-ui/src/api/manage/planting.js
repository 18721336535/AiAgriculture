import request from '@/utils/request'

// 查询种植管理列表
export function listPlanting(query) {
  return request({
    url: '/manage/planting/list',
    method: 'get',
    params: query
  })
}

// 查询种植管理详细
export function getPlanting(id) {
  return request({
    url: '/manage/planting/' + id,
    method: 'get'
  })
}

// 新增种植管理
export function addPlanting(data) {
  return request({
    url: '/manage/planting',
    method: 'post',
    data: data
  })
}

// 修改种植管理
export function updatePlanting(data) {
  return request({
    url: '/manage/planting',
    method: 'put',
    data: data
  })
}

// 删除种植管理
export function delPlanting(id) {
  return request({
    url: '/manage/planting/' + id,
    method: 'delete'
  })
}
