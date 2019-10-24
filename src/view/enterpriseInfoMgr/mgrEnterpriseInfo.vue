<template>
  <div class="wrapper">
    <Card :bordered="false">
      <p slot="title">企业信息同步任务信息</p>
      <Row style="display:flex; justify-content: space-between;">
          <Col span="12">
            <Card >
              <p slot="title">
                   新备案系统
              </p>
              <div v-show="nba.user_name" class="flex">
                <p class="flex-left">用户名:</p>
                <p class="flex-right"><b>{{nba.user_name}}</b></p>
              </div>
              <div v-show="nba.user_type_name" class="flex">
                <p class="flex-left">用户类型：</p>
                <p class="flex-right"><b>{{nba.user_type_name}}</b></p>
              </div>
              <div v-show="nba.producer_name" class="flex">
                <p class="flex-left">生产者名称:</p>
                <p class="flex-right"><b>{{nba.producer_name}}</b></p>
              </div>
              <div v-show="nba.sub_producer_name" class="flex">
                <p class="flex-left">制造单位名称:</p>
                <p class="flex-right"><b>{{nba.sub_producer_name}}</b></p>
              </div>
              <div v-show="nba.account_status" class="flex">
                <p class="flex-left">账号状态:</p>
                <p class="flex-right"><b>{{nba.account_status}}</b></p>
              </div>
              <div class="itemblock">
                <h3 >
                   可备案大类：
                </h3>
                <div class="unitItem" v-for="(item,idx) in nba.edit_category_names" :key="idx">
                   {{item}}
                </div>
              </div>
              <div class="itemblock">
                <h3 >
                   可查询大类：
                </h3>
                <div class="unitItem" v-for="(item,idx) in nba.search_category_names" :key="idx">
                    {{item}}
                </div>
              </div>
            </Card>
          </Col>
          <Col span="12">
            <Card style="height: 100%;">
              <p slot="title">
                    原备案系统
              </p>
              <div v-show="ba.user_name" class="flex">
                <p class="flex-left">用户名:</p>
                <p class="flex-right"><b>{{ba.user_name}}</b></p>
              </div>
              <div v-show="ba.user_type_name" class="flex">
                <p class="flex-left">用户类型：</p>
                <p class="flex-right"><b>{{ba.user_type_name}}</b></p>
              </div>
              <div v-show="ba.producer_name" class="flex">
                <p class="flex-left">生产者名称:</p>
                <p class="flex-right"><b>{{ba.producer_name}}</b></p>
              </div>
              <div v-show="ba.sub_producer_name" class="flex">
                <p class="flex-left">制造单位名称:</p>
                <p class="flex-right"><b>{{ba.sub_producer_name}}</b></p>
              </div>
              <div v-show="ba.account_status" class="flex">
                <p class="flex-left">账号状态:</p>
                <p class="flex-right"><b>{{ba.account_status}}</b></p>
              </div>
              <div class="itemblock">
                <h3>
                   可备案大类：
                </h3>
                <div class="unitItem" v-for="(item,idx) in ba.edit_category_names" :key="idx">
                   {{item}}
                </div>
              </div>
            </Card>
          </Col>
      </Row>
      <Row style="margin-top:10px;">
        <Col v-show="btnState==2" span="24" style="text-align:right">
          <Button @click="cancleHandle">取消同步</Button>
          <Button type="primary" @click="confirmHandle">确认同步</Button>
        </Col>
      </Row>
    </Card>
  </div>
</template>
<script>
import axios from 'axios'
export default {
  data () {
    return {
      id:'',
      btnState:0,
      nba: {
        user_name:'',
        user_type_name:'',
        producer_name:'', 
        account_status:'',
        sub_producer_name:'',       
        edit_category_names:[],
        search_category_names:[]
      },
      ba:{
        user_name:'',
        user_type_name:'',
        producer_name:'', 
        account_status:'',
        sub_producer_name:'',       
        edit_category_names:[],
      }
    }
  },
  methods: {
    getInfo () {
      axios.get('/usersync/info.do', {
        params: {
          id:this.id
        }
      }).then(res => {
        if(res.data.result){
          this.nba = res.data.data.nba
          this.ba = res.data.data.ba
        }
        
      })
    },
    confirmHandle(){
      axios.get('/usersync/confirm.do', {
        params: {
          id:this.id
        }
      }).then(res => {
          if(res.data.result){
            this.$router.push({
              name: 'enterpriseList',
            })
          }
          this.$Message.info(res.data.msg);
      })
    },
    cancleHandle(){
      axios.get('/usersync/cancle.do', {
        params: {
          id:this.id
        }
      }).then(res => {
        if(res.data.result){
            this.$router.push({
              name: 'enterpriseList',
            })
          }
          this.$Message.info(res.data.msg);
      })
    }
  },
  created(){
    console.log(this.$route.params)
    if(this.$route.params){
      this.id=this.$route.params.id;
      this.btnState=this.$route.params.state;
    }else{
        this.$router.push({
          name: 'enterpriseList',
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
.itemblock{ margin-top:20px; }
.itemblock h3{ margin-bottom: 10px;}
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
