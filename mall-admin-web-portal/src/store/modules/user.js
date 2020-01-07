import { login, logout, getInfo } from '@/api/login'
import img from '@/assets/images/404.png'

const user = {
  state: {
    userId: '',
    userName: '',
    avatar: ''
  },

  mutations: {
    SET_NAME: (state, name) => {
      state.userName = name
    },
    SET_AVATAR: (state, avatar) => {
      if(avatar == null) avatar = img
      state.avatar = avatar
    },
    SET_ID: (state, id) => {
      state.userId = id
    }
  },

  actions: {
    // 登录
    Login({ commit }, userInfo) {
      const username = userInfo.username.trim()
      return new Promise((resolve, reject) => {
        login(username, userInfo.password).then(response => {
          commit('SET_ID', response.data.id)
          commit('SET_NAME', response.data.username)
          commit('SET_AVATAR', response.data.icon)
          resolve()
        }).catch(error => {
          reject(error)
        })
      })
    },

    // 前端 登出
    FedLogOut({ commit }) {
      return new Promise(resolve => {
        //应该清除store数据
        resolve()
      })
    }
  }
}

export default user
