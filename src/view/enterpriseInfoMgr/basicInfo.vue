<template>
  <div class="wrapper">
    <div class="block">
      <Card :bordered="false">
        <p slot="title">本系统信息</p>
        <div class="systemInfo">
          <p>
            <span>登录账号：</span>
            <b>{{accountMsg.fastRecordLoginName}}</b>
          </p>
          <!--<p>
            <span>联系人：</span>
            <b>{{accountMsg.displayName}}</b>
          </p>
          <p>
            <span>手机：</span>
            <b>{{accountMsg.contactPhone}}</b>
          </p>-->
        </div>
      </Card>
    </div>
    <div class="block">
      <Card :bordered="false">
        <p slot="title">绑定的能效备案系统信息</p>
        <div class="recordSystemInfo">
          <div class="flex">
            <p class="flex-left">登录账号：</p>
            <p class="flex-right"><b>{{accountMsg.energyLabelLoginName}}</b></p>
          </div>
          <div class="flex">
            <p class="flex-left">生产者名称：</p>
            <p class="flex-right"><b>{{accountMsg.ename}}</b></p>
          </div>
          <!--<div class="flex">
            <p class="flex-left">产品类型包括：</p>
            <p class="flex-right flex-column">
              <b v-for="(item,idx) in this.accountMsg.productTypeList" :key="idx">{{item}}</b>
            </p>
          </div>-->
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
        fastRecordUserId:null,
        energyLabeluserId:null,
        eid:null,
        ename:"",
        energyLabelLoginName:"",
        fastRecordLoginName:"",
        displayName:"",
        contactPhone:"",
        productTypeList:[]
      }
    }
  },
  methods: {
    getInfo () {
      axios.get('/user/getUserInfo.do').then(res => {
        if (res.data.result) {
          console.log(res.data)
          this.accountMsg = res.data.msg
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
