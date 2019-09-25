<template>
  <div class="wrapper">
    <div class="block">
      <Card :bordered="false">
         <p slot="title">新备案系统账号信息</p>
        <div class="recordSystemInfo">
          <div v-show="accountMsg.a" class="flex">
            <p class="flex-left">登录账号：</p>
            <p class="flex-right"><b>{{accountMsg.a}}</b></p>
          </div>
          <div v-show="accountMsg.b" class="flex">
            <p class="flex-left">账号类型：</p>
            <p class="flex-right"><b>{{accountMsg.c}}</b></p>
          </div>
          <div v-show="accountMsg.d" class="flex">
            <p class="flex-left">制造单位名称:</p>
            <p class="flex-right"><b>{{accountMsg.d}}</b></p>
          </div>
          <div v-show="accountMsg.e" class="flex">
            <p class="flex-left">生产者名称:</p>
            <p class="flex-right"><b>{{accountMsg.e}}</b></p>
          </div>
        </div>
      </Card>
    </div>
    <div class="block">
      <Card :bordered="false">
        <p slot="title">原备案系统绑定账号信息</p>
        <div class="recordSystemInfo">
          <div v-show="accountMsg.a" class="flex">
            <p class="flex-left">登录账号：</p>
            <p class="flex-right"><b>{{accountMsg.a}}</b></p>
          </div>
        </div>
      </Card>
    </div>
    <div class="block">
      <Card :bordered="false">
        <p slot="title">新备案系统可备案产品类别信息</p>
        <div class="recordSystemInfo">
          <div v-for="item in accountMsg.f" :key="item" style="padding-left:80px">
              {{item}}
          </div>
        </div>
      </Card>
    </div>
  </div>
</template>
<script>
import axios from 'axios'
export default {
  data () {
    return {
      accountMsg: {
        "a": "",
        "c": "",
        "d": "",
        "e": "",
        "f": [],
        "g": [],
        "h": "",
        "i": ""
      }
    }
  },
  methods: {
    getInfo () {
      axios.get('/enterprise/info.do').then(res => {
        if (res.data.result) {
          console.log(res.data)
          this.accountMsg = res.data.msg
        }else{
          this.$Message.error(res.data.msg)
        }
      })
    }
  },
  mounted () {
    this.getInfo()
  }
}
</script>

<style lang="less" scoped>
.block{
  background:#eee;
  padding:15px;
}
.systemInfo span{
  display:inline-block;
  font-size:16px;
  line-height:36px;
  width:150px;
  text-align:right;
}
.systemInfo b{
  font-size:16px;
  line-height:36px;
}
.flex{
  display:flex;
}
.flex-left{
  width:150px;
  text-align:right;
  font-size:16px;
  line-height:36px;
}
.flex-right{
  font-size:16px;
  line-height:36px;
}
.flex-column{
  display: flex;
  flex-direction: column;
}
</style>
