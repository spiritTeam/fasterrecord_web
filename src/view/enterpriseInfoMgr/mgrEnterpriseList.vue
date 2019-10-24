<template>
  <Card :bordered="false">
    <p class="mgrTit" slot="title">
      企业信息同步任务列表 
      <Button type="primary" @click="modalTask=true">新建任务</Button>
    </p>
    <Form ref="formQuery" :model="formQuery" inline>
      <FormItem>
        <Input type="text" v-model.trim="formQuery.username" placeholder="用户账号"></Input>
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
        ok-text="创建任务"
        cancel-text="取消"
        :mask-closable="false"
        :loading="loading"
        @on-ok="taskOk"
        @on-cancel="taskCancel">
        <Form ref="formTask" :model="formTask" inline>
          <FormItem>
            <Input type="text" v-model.trim="formTask.username" placeholder="用户名"></Input>
          </FormItem>
        </Form>
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
    }, '查看')
    return {
      modalTask:false,
      loading: true,
      formQuery:{
        username:'',
        pageSize: 10,
        pageNum: 1
      },
      formTask:{
        username:''
      },
      total:0,
      columns1: [
        {
          title:'',
          key:'id',
          align:'center'
        },
        {
          title: '同步用户名',
          key: 'user_name',
          align: 'center'
        },
        {
          title: '任务开始时间',
          key: 'start_time',
          align: 'center',
          render: (h, params) => {
            return h('div', getFormatTime(params.row.start_time,'year'))
          }
        },
        {
          title: '任务结束时间',
          key: 'end_time',
          align: 'center',
          render: (h, params) => {
            return h('div', getFormatTime(params.row.end_time,'year'))
          }
        },
        {
          title: '任务状态',
          key: 'state_name',
          align: 'center'
        },
        {
          title: '操作',
          key: 'action',
          align: 'center',
          render: (h, params) => {
            return h('div', [
              params.row.state!='1'?viewBtn(h, params):'-'
            ])
          }
        }
      ],
      recordData: []
    }
  },
  methods: {
    getList () {
      axios.get('/usersync/list.do', {
        params: this.formQuery
      }).then(res => {
        //console.log(res.data)
        this.recordData = res.data.data.list
        this.total = res.data.data.total
      })
    },
    
    taskOk(){
      axios.get('/usersync/add.do', {
        params: this.formTask
      }).then(res => {
        //this.$Message.info(res.data.msg);
        setTimeout(() => {
            if(res.data.result){
              this.modalTask = false;
              this.getList()
            }else{
              this.modalTask = true;
              this.loading=false
            }
            this.$Message.info(res.data.msg);
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
      this.$router.push({
        name: 'enterpriseInfo',
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

.mgrTit{
  height: auto;
  line-height: auto;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

</style>
