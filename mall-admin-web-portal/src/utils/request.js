import axios from 'axios'
axios.defaults.withCredentials=true;
import { Message, MessageBox } from 'element-ui'
import store from '../store'
import router from '../router'

// 创建axios实例
const service = axios.create({
  baseURL: process.env.BASE_API, // api的base_url
  timeout: 15000 // 请求超时时间
})

// // request拦截器
// service.interceptors.request.use(config => {
//   if (store.getters.token) {
//     config.headers['Authorization'] = getToken() // 让每个请求携带自定义token 请根据实际情况自行修改
//   }
//   return config
// }, error => {
//   // Do something with request error
//   console.log(error) // for debug
//   Promise.reject(error)
// })

// respone拦截器
service.interceptors.response.use(
  response => {
  /**
  * code为非200是抛错 可结合自己业务进行修改
  */
    const res = response.data
    if (res.code !== 200) {
      Message({ //弹出错误信息
        message: res.message,
        type: 'error',
        duration: 3 * 1000
      })
      // 401:未登录，跳转到登录界面;
      if (res.code === 401||res.code === 403) {
        router.push('/login');
      }
      return Promise.reject('error')
    } else {//200正常返回
      return response.data
    }
  },
  error => {
    console.log('err' + error)// for debug
    Message({
      message: error.message,
      type: 'error',
      duration: 3 * 1000
    })
    return Promise.reject(error)
  }
)

export default service
