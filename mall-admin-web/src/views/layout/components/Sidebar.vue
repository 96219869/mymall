<template>
  <div>
    <el-menu
      class="el-menu-vertical-demo"
      background-color="#304156"
      text-color="#bfcbd9"
      active-text-color="#409EFF"
    >
      <el-menu-item index="1" @click="shouye">
        <i class="el-icon-star-on"></i>
        <span slot="title">首页</span>
      </el-menu-item>

      <el-submenu index="2">
        <template slot="title">
          <i class="el-icon-goods"></i>
          <span>商品</span>
        </template>
          <el-menu-item index="1-1" @click="shangpinList">商品列表</el-menu-item>
          <el-menu-item index="1-2" @click="shangpinAdd">添加商品</el-menu-item>
      </el-submenu>

      <el-submenu index="3">
        <template slot="title">
          <i class="el-icon-tickets"></i>
          <span>订单</span>
        </template>
        <el-menu-item index="1-1">订单列表</el-menu-item>
      </el-submenu>

      <el-menu-item index="4" @click="quit">
        <i class="el-icon-error"></i>
        <span slot="title">退出</span>
      </el-menu-item>
    </el-menu>
  </div>
</template>

<style>
  .el-menu-vertical-demo:not(.el-menu--collapse) {
    width: 200px;
    min-height: 100%;
  }
</style>

<script>
  export default {
    name: 'Sidebar',
    methods: {
      shouye() {
        this.$router.push({path: '/'});
      },
      quit() {
        this.$router.push({path: '/login'});
      },
      shangpinList() {
        this.$router.push({path: '/pms/product'});
      },
      shangpinAdd() {
        this.$router.push({path: '/pms/addProduct'});
      },
    }
  }
</script>
