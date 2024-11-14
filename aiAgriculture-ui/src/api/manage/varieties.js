import request from '@/utils/request'

// 查询品种管理列表
export function listVarieties(query) {
  return request({
    url: '/manage/varieties/list',
    method: 'get',
    params: query
  })
}

// 查询品种管理详细
export function getVarieties(id) {
  return request({
    url: '/manage/varieties/' + id,
    method: 'get'
  })
}

// 新增品种管理
export function addVarieties(data) {
  return request({
    url: '/manage/varieties',
    method: 'post',
    data: data
  })
}

// 修改品种管理
export function updateVarieties(data) {
  return request({
    url: '/manage/varieties',
    method: 'put',
    data: data
  })
}

// 删除品种管理
export function delVarieties(id) {
  return request({
    url: '/manage/varieties/' + id,
    method: 'delete'
  })
}
