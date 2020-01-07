<template>
  <div class="app-wrapper" >
    <navbar></navbar>
    <div class="main-container">
      <app-main></app-main>
    </div>
  </div>
</template>

<script>
import { AppMain } from './components'
import Navbar from "./components/Navbar";
import Sidebar from "./components/Sidebar";
// import ResizeMixin from './mixin/ResizeHandler'

export default {
  name: 'layout',
  components: {
    Navbar,
    AppMain,
    Sidebar
  },
  computed: {
  }
}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
  /*@import "src/styles/mixin.scss";*/
  .app-wrapper {
    //@include clearfix;
    position: relative;
    height: 100%;
    width: 100%;
  }
</style>
