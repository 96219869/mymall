<template>
  <div>
    <el-container>
      <el-aside width="300px">
        <div style="width:100%; height:500px; overflow-y: scroll;
                    padding: 25px">
          <ul type="circle">
            <li v-for="(l, index) in chatlist" :key="l.id">
              <div style="margin: 20px">
                <img :src="(l.targetavator==null||l.targetavator==undefined||l.targetavator=='')?defalutavator:l.targetavator" width="50px" height="40px">
                <span @click="shiftTarget(index)">{{l.targetname}}</span>
                <el-badge class="Badge" value="new" :hidden="l.havenew==1?false:true">
                </el-badge>
              </div>
            </li>
          </ul>
        </div>
      </el-aside>
      <el-main>

  <div class="chat-box">
    <!--    客服使用-->
    <header>{{targetname}}</header>
    <div class="msg-box" ref="msg-box">
      <div
        v-for="(i,index) in list"
        :key="index"
        class="msg"
        :style="i.sendid == param.sendid?'flex-direction:row-reverse':''"
      >
        <div class="user-head">
          <img :src="i.sendid == param.sendid?myavator:targetavator" height="30" width="30">
        </div>
        <div class="user-msg">
          <span :style="i.sendid == param.sendid?' float: right;':''" :class="i.sendid == param.sendid?'right':'left'">{{i.content}}</span>
        </div>
      </div>
    </div>
    <div class="input-box">
      <input type="text" ref="sendMsg" v-model="contentText" @keyup.enter="sendText()" />
      <div class="btn" :class="{['btn-active']:contentText}" @click="sendText()">发送</div>
    </div>
  </div>
      </el-main>
    </el-container>
  </div>
</template>

<script>
  import {getHistory, getChatList, havenewTo0} from '@/api/chat'
  import img from '@/assets/images/404.png'
  import img1 from '@/assets/images/404_cloud.png'

  export default {
    data() {
      return {
        aaa:true,
        defalutavator: img,
        chatlist: [],//侧边栏需要的数据
        //聊天界面需要数据
        param:{ //用于获取历史消息
          sendid:'',
          recid:'',
          pageSize:5,
          pageNum:0
        },
        targetname: "客服",// 对方昵称，在首栏显示
        myavator: img, // 我的头像
        targetavator: img, //对方头像
        list: [], // 聊天记录的数组

        contentText: "", // input输入的值
        ws: null //websocket对象
      };
    },
    created() {
      this.initChatList();
      //axios是异步调用，下面两个方法依赖前面param初始化
      //如果这样写，param还没被赋值，下面两个方法会报错
      // this.initList();
      // this.initWebSocket();
    },
    mounted() {
    },
    destroyed() {
      // 离开页面时关闭websocket连接
      this.ws.onclose(undefined);
    },
    methods: {
      initChatList() {
        getChatList().then(response => {
          this.chatlist = response.data;
          this.shiftTarget(0);
          let avator = this.chatlist[0].myavator;
          this.myavator = (avator==null||avator==undefined||avator=='')?this.defalutavator:avator;
          // this.param.sendid = response.data[0].myid;
          // this.param.recid = response.data[0].targetid;
          // //这样写
          // this.initList();
          // this.initWebSocket();
        });
      },
      shiftTarget(index) {//切换聊天对象
        if(this.ws != null) this.ws.onclose(undefined);
        this.param.sendid = this.chatlist[index].myid;
        this.param.recid = this.chatlist[index].targetid;
        this.initList();
        this.initWebSocket();
        if(this.chatlist[index].havenew == 1){
          this.chatlist[index].havenew = 0;
          this.shezhiyidu();
        }
        this.targetname = this.chatlist[index].targetname;
        let avator = this.chatlist[index].targetavator;
        this.targetavator = (avator==null||avator==undefined||avator=='')?this.defalutavator:avator;
      },
      //设置已读
      shezhiyidu() {
        havenewTo0(this.param.sendid, this.param.recid).then(response => {
        });
      },
      //获取历史数据
      initList() {
        getHistory(this.param).then(response => {
          this.list = response.data;
        });
      },
      // 发送聊天信息
      sendText() {
        let _this = this;
        _this.$refs["sendMsg"].focus();
        if (!_this.contentText) {
          return;
        }
        // let params = {
        //   userId: _this.userId,
        //   username: _this.username,
        //   myavator: _this.myavator,
        //   msg: _this.contentText,
        // };
        // _this.ws.send(JSON.stringify(params.msg)); //调用WebSocket send()发送信息的方法
        _this.ws.send(JSON.stringify(_this.contentText)); //调用WebSocket send()发送信息的方法
        _this.contentText = "";
        setTimeout(() => {
          _this.scrollBottm();
        }, 500);
      },
      // 进入页面创建websocket连接
      initWebSocket() {
        let _this = this;
        // 判断页面有没有存在websocket连接
        if (window.WebSocket) {
          var serverHot =  window.location.hostname;

          // `ws://127.0.0.1/8081/Chat/sendid/recid/type`
          var url = 'ws://' + serverHot + ':8081' + '/Chat/'
            + _this.param.sendid + '/' + _this.param.recid + '/1';

          let ws = new WebSocket(url);
          _this.ws = ws;
          ws.onopen = function(e) {
            console.log("服务器连接成功: " + url);
          };
          ws.onclose = function(e) {
            console.log("服务器连接关闭: " + url);
          };
          ws.onerror = function() {
            console.log("服务器连接出错: " + url);
          };
          ws.onmessage = function(e) {
            //接收服务器返回的数据
            console.log("收到消息");
            // let resData = JSON.parse(e.data);
            _this.list.push(JSON.parse(e.data));
            console.log("push消息");
            console.log(_this.list);
            setTimeout(() => {
              _this.scrollBottm();
            }, 500);
          };
        }
      },
      // 滚动条到底部
      scrollBottm() {
        let el = this.$refs["msg-box"];
        el.scrollTop = el.scrollHeight;
      }
    }
  };
</script>

<style lang="scss" scoped>
  .Badge {
  }
  .chat-box {
    margin: 0 auto;
    background: #fafafa;
    position: absolute;
    height: 500px;
    width: 100%;
    max-width: 700px;
    header {
      position: fixed;
      width: 100%;
      height: 3rem;
      background: #409eff;
      max-width: 700px;
      display: flex;
      justify-content: center;
      align-items: center;
      font-weight: bold;
      color: white;
      font-size: 1rem;
    }
    .msg-box {
      position: absolute;
      height: calc(100% - 6.5rem);
      width: 100%;
      margin-top: 3rem;
      overflow-y: scroll;
      .msg {
        width: 95%;
        min-height: 2.5rem;
        margin: 1rem 0.5rem;
        position: relative;
        display: flex;
        justify-content: flex-start !important;
        .user-head {
          min-width: 2.5rem;
          width: 20%;
          width: 2.5rem;
          height: 2.5rem;
          border-radius: 50%;
          background: #f1f1f1;
          display: flex;
          justify-content: center;
          align-items: center;
          .head {
            width: 1.2rem;
            height: 1.2rem;
          }
          // position: absolute;
        }
        .user-msg {
          width: 80%;
          // position: absolute;
          word-break: break-all;
          position: relative;
          z-index: 5;
          span {
            display: inline-block;
            padding: 0.5rem 0.7rem;
            border-radius: 0.5rem;
            margin-top: 0.2rem;
            font-size: 0.88rem;
          }
          .left {
            background: white;
            animation: toLeft 0.5s ease both 1;
          }
          .right {
            background: #53a8ff;
            color: white;
            animation: toright 0.5s ease both 1;
          }
          @keyframes toLeft {
            0% {
              opacity: 0;
              transform: translateX(-10px);
            }
            100% {
              opacity: 1;
              transform: translateX(0px);
            }
          }
          @keyframes toright {
            0% {
              opacity: 0;
              transform: translateX(10px);
            }
            100% {
              opacity: 1;
              transform: translateX(0px);
            }
          }
        }
      }
    }
    .input-box {
      padding: 0 0.5rem;
      position: absolute;
      bottom: 0;
      width: 100%;
      height: 3.5rem;
      background: #fafafa;
      box-shadow: 0 0 5px #ccc;
      display: flex;
      justify-content: space-between;
      align-items: center;
      input {
        height: 2.3rem;
        display: inline-block;
        width: 100%;
        padding: 0.5rem;
        border: none;
        border-radius: 0.2rem;
        font-size: 0.88rem;
      }
      .btn {
        height: 2.3rem;
        min-width: 4rem;
        background: #e0e0e0;
        padding: 0.5rem;
        font-size: 0.88rem;
        color: white;
        text-align: center;
        border-radius: 0.2rem;
        margin-left: 0.5rem;
        transition: 0.5s;
      }
      .btn-active {
        background: #409eff;
      }
    }
  }
</style>
