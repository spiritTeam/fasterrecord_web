<template>
  <Card :bordered="false">
    <p class="mgrTit" slot="title">
      企业信息列表 
    </p>
    <Form ref="formQuery" :model="formQuery" inline>
      <FormItem>
        <Input type="text" v-model.trim="formQuery.username" placeholder="用户账号"></Input>
      </FormItem>
      <FormItem>
        <Input type="text" v-model.trim="formQuery.ename" placeholder="生产者名称"></Input>
      </FormItem>
      <FormItem>
        <Button type="primary" @click="searchFun">搜索</Button>
      </FormItem>
    </Form>
    <Table border class="tableList" :columns="columns1" :data="recordData"></Table>
    <Page :total="total" :page-size="formQuery.pageSize"
      :current="formQuery.pageNum"
      @on-change="changeList"
      style="margin-top:10px; text-align: right">
    </Page>
    <Modal
        v-model="modalTask"
        title="企业信息同步任务创建"
        cancel-text="确定"
        ok-text="同步信息"
        :mask-closable="false"
        :loading="loading"
        @on-ok= "taskOk(nba.user_name)"
        @on-cancel="taskCancel">
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
    </Modal>
  </Card>
</template>
<script>
import axios from 'axios'
import { getFormatTime } from '@/libs/tools'
export default {
  data () {
    const viewBtn = (h, params) => h('Button', {
      props: {
        type: 'primary',
        size: 'small',
        long: 'long'
      },
      style: {
        margin: '1px'
      },
      on: {
        click: () => {
          this.viewHandle(params.row)
        }
      }
    }, '查看信息')
    const syncBtn = (h, params) => h('Button', {
      props: {
        type: 'primary',
        size: 'small',
        long: 'long'
      },
      style: {
        margin: '1px'
      },
      on: {
        click: () => {
          this.taskOk(params.row.user_name)
        }
      }
    }, '同步信息')
    const beianBtn = (h, params) => h('Button', {
      props: {
        type: 'primary',
        size: 'small',
        long: 'long'
      },
      style: {
        margin: '1px'
      },
      on: {
        click: () => {
          this.beianHandle(params.row)
        }
      }
    }, '查看备案信息')
    return {
      modalTask:false,
      loading: true,
      formQuery:{
        username:'',
        ename:'',
        pageSize: 10,
        pageNum: 1
      },
      total:0,
      nba: {
        "user_name": "", 
        "user_type_name":"",// 用户类型(生产者账号/制造单位账号), 
        "producer_name": "",//生产者名称, 
        "sub_producer_name":"",// 制造单位名称, 
        "account_status": "",//账号状态, 
        "edit_category_names":[],// [可备案大类], 
        "search_category_names": []//[可编辑大类]
      },
      columns1: [
        {
          title:'id企业ID',
          key:'eid',
          align:'center'
        },
        {
          title: '用户名',
          key: 'user_name',
          align: 'center'
        },
        {
          title: '用户类型',
          key: 'user_type_name',
          align: 'center'
        },
        {
          title: '生产者名称',
          key: 'producer_name',
          align: 'center'
        },
        {
          title: '制造单位名称',
          key: 'sub_producer_name',
          align: 'center'
        },
         {
          title: '原系统用户ID',
          key: 'el_user_id',
          align: 'center'
        },
         {
          title: '新系统用户ID',
          key: 'user_id',
          align: 'center'
        },
         {
          title: '锁定',
          key: 'lock_value',
          align: 'center'
        },
        {
          title: '操作',
          key: 'action',
          align: 'center',
          render: (h, params) => {
            return h('div', [
              viewBtn(h, params),
              syncBtn(h,params),
              beianBtn(h,params)
            ])
          }
        }
      ],
      recordData: []
    }
  },
  methods: {
    getList () {
      axios.get('/enterprise/list.do', {
        params: this.formQuery
      }).then(res => {
        //console.log(res.data)
        this.recordData = res.data.data.list
        this.total = res.data.data.total
      })
    },
    
    taskOk(username){
      axios.get('/usersync/add.do', {
        params:{
          username:username || this.nba.user_name
        }
      }).then(res => {
        setTimeout(() => {
            if(res.data.result){
              this.$Modal.confirm({
                title: '',
                content: '同步已创建',
                okText:'确定',
                cancelText:'前往任务列表',
                onOk:()=>{
                  this.getList();
                  this.modalTask = false;
                },
                onCancel:()=>{
                  this.$router.push({
                    name: 'enterpriseList',
                  })
                }
              });
            }else{
              this.modalTask = false;
              this.loading=false
              this.$Modal.error({
                  title: '',
                  content: res.data.msg
              });
            }
        }, 2000);
      })
    },
    taskCancel(){

    },
    searchFun(){
      this.getList();
    },
    changeList (pNum) {
      this.formQuery.pageNum = pNum
      this.getList();
    },
    viewHandle(params){
      axios.get('/enterprise/enterpriseInfo.do', {
        params: {
          username:params.user_name
        }
      }).then(res => {
        this.nba = res.data.data
        //this.$Message.info(res.data.msg);
        this.modalTask=true;
      })
    },
    syncHandle(params){

    },
    beianHandle(params){
      this.$router.push({
        name:'enterpriseQuery',
        params
      })
    },
    createTask(){

    }
  },
  mounted () {
    this.getList()
  }
}
</script>

<style lang="less" scoped>

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
  text-align:left;
  font-size:16px;
  line-height:36px;
}
.flex-right{
  font-size:16px;
  line-height:36px;
}

</style>
