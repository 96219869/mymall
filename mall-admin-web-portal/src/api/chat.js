import request from '@/utils/request'

export function getHistory(params) {
  return request({
    url: '/chat/getHistory',
    method: 'get',
    params:params
  })
}

export function getChatList() {
  return request({
    url: '/chat/getChatList',
    method: 'get'
  })
}

export function lianxiSeller(data) {
  return request({
    url: '/chat/lianxiSeller',
    method: 'post',
    data: data
  })
}

export function havenewTo0(sendid,recid) {
  return request({
    url: '/chat/havenewTo0',
    method: 'post',
    data: {
      myid: sendid,
      targetid: recid
    }
  })
}
