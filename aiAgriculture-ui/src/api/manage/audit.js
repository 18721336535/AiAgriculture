import request from '@/utils/request'

// 查询控制操作审计列表
export function listAudit(query) {
  return request({
    url: '/manage/audit/list',
    method: 'get',
    params: query
  })
}

// 查询控制操作审计详细
export function getAudit(id) {
  return request({
    url: '/manage/audit/' + id,
    method: 'get'
  })
}

// 新增控制操作审计
export function addAudit(data) {
  return request({
    url: '/manage/audit',
    method: 'post',
    data: data
  })
}

// 修改控制操作审计
export function updateAudit(data) {
  return request({
    url: '/manage/audit',
    method: 'put',
    data: data
  })
}

// 删除控制操作审计
export function delAudit(id) {
  return request({
    url: '/manage/audit/' + id,
    method: 'delete'
  })
}
