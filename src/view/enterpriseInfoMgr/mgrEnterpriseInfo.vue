<template>
  <div class="wrapper">
    <div class="block">
      <Form ref="formQuery" :model="formQuery" inline>
        <FormItem>
          <Input type="text" v-model.trim="formQuery.a" placeholder="登录账号"></Input>
        </FormItem>
        <FormItem>
          <Button type="primary" @click="searchFun">搜索</Button>
        </FormItem>
      </Form>
    </div>
    <div v-show="searchResult">
      <div class="block">
        <Card :bordered="false">
          <p slot="title">用户信息</p>
          <div class="recordSystemInfo">
            <div v-show="accountMsg.a" class="flex">
              <p class="flex-left">登录用户名：</p>
              <p class="flex-right"><b>{{accountMsg.a}}</b></p>
            </div>
            <div v-show="accountMsg.b" class="flex">
              <p class="flex-left">用户类型：</p>
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
            <div v-show="accountMsg.i" class="flex">
              <p class="flex-left">原系统状态:</p>
              <p class="flex-right"><b>{{accountMsg.i}}</b></p>
            </div>
          </div>
        </Card>
      </div>
      <div class="block">
        <Card :bordered="false">
          <p slot="title">新系统大类信息</p>
          <div class="recordSystemInfo">
            <h4>可查询大类：</h4>
            <div v-for="item in accountMsg.f" :key="item" style="padding-left:80px">
                {{item}}
            </div>
            <h4>可备案大类：</h4>
            <div class="recordSystemInfo">
              <div v-for="item in accountMsg.g" :key="item" style="padding-left:80px">
                  {{item}}
              </div>
            </div>
          </div>
        </Card>

      </div>
      <div class="block" v-show="orginMsg.length>0">
        <Card :bordered="false">
          <p slot="title">原系统大类信息</p>
          <div class="recordSystemInfo">
            <div v-for="item in orginMsg" :key="item" style="padding-left:80px;">
                {{item}}
            </div>
          </div>
          <Button style="margin-left:80px" type="primary" @click="updateHandle">将 原系统 的“可备案大类”同步到 新系统 中</Button>
        </Card>
      </div>
    </div>
    <div v-show="!searchResult" style="text-align:center; color:red;">
      {{errMessage}}
    </div>
  </div>
</template>
<script>
import axios from 'axios'
export default {
  data () {
    return {
      formQuery:{
        a:'',
      },
      accountMsg: {
        "a": "",
        "c": "",
        "d": "",
        "e": "",
        "f": [],
        "g": [],
        "h": "",
        "i": ""
      },
      orginMsg:[],
      searchResult:false,
      errMessage:'',
      conut:0
    }
  },
  methods: {
    getInfo () {
      
    },
    searchFun(code){
      axios.get('/mgr/enterprise/info.do?a='+this.formQuery.a).then(res => {
        if (res.data.result) {
          this.searchResult=true;
          this.accountMsg = res.data.msg
          this.delayFun(this.accountMsg.h)
        }else{
          this.searchResult=false;
          this.errMessage=res.data.msg;
        }
      })
    },
    delayFun(code){
      //let conut=0;
      this.conut++;
      if(this.conut<2){
        let timer=setTimeout(()=>{
          axios.get('/mgr/enterprise/oldinfo.do?code='+code).then(res => {
            if (res.data.result) {
              this.orginMsg=res.data.msg
              clearTimeout(timer);
            }else{
              this.delayFun(this.accountMsg.h)
             // this.$Message.error(res.data.msg)
            }
          })
        },5000)
      }else{
        this.conut=0;
      }
    },
    updateHandle(){
      axios.get('/mgr/enterprise/sync.do?code='+this.accountMsg.h).then(res => {
        if(res.data.result){
          this.$Message.success(res.data.msg)
        }else{
          this.$Message.error(res.data.msg)
        }
      });
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
.recordSystemInfo{margin-bottom:20px;}
</style>
