import request from '@/utils/request'

// 查询地块管理列表
export function listPlot(query) {
  return request({
    url: '/manage/plot/list',
    method: 'get',
    params: query
  })
}

// 查询地块管理详细
export function getPlot(id) {
  return request({
    url: '/manage/plot/' + id,
    method: 'get'
  })
}

// 新增地块管理
export function addPlot(data) {
  return request({
    url: '/manage/plot',
    method: 'post',
    data: data
  })
}

// 修改地块管理
export function updatePlot(data) {
  return request({
    url: '/manage/plot',
    method: 'put',
    data: data
  })
}

// 删除地块管理
export function delPlot(id) {
  return request({
    url: '/manage/plot/' + id,
    method: 'delete'
  })
}
