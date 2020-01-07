<template>
  <div style="background: gray;height: 50px;color: black">
    <el-button type="text" style="color: black;font-size: medium"
               @click="toHome()">首页</el-button>
    <el-button type="text" style="color: black;font-size: medium;float: right"
               @click="toLogin()">退出</el-button>
    <el-button type="text" style="color: black;font-size: medium;float: right">个人中心</el-button>
    <el-button type="text" style="color: black;font-size: medium;float: right"
               @click="toChat()">消息中心</el-button>
    <el-button type="text" style="color: black;font-size: medium;float: right"
               @click="addChat()">联系xxx企业</el-button>
<!--  点击消息中心后，只有chatlist为空才会添加默认客服，需要该入口手动添加  -->
    <el-button type="text" style="color: black;font-size: medium;float: right"
               @click="lianxikefu()">联系客服</el-button>
  </div>
</template>

<style>

</style>

<script>

  import {logout} from '@/api/login'
  import {lianxiSeller} from '@/api/chat'

  export default {
    name: 'Navbar',
    data() {
      return {
        seller:{
          id: 4000
        },
        kefu:{
          id: 2000
        }
      }
    },
    methods: {
      toHome() {
        this.$router.push('/home')
      },
      toLogin() {
        logout();
        this.$router.push('/login')
      },
      toChat() {
        this.$router.push('/chat')
      },
      lianxikefu() {
        lianxiSeller(this.kefu).then(response => {
          this.$router.push('/chat');
        })
      },
      addChat() {
        lianxiSeller(this.seller).then(response => {
          this.$router.push('/chat');
        })
      }
    }
  }
</script>
