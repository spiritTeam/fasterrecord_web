<template>
  <Card :bordered="false">
    <p class="mgrTit" slot="title">
      企业备案查询
    </p>
    <p v-show="enterprise_name" style="margin-bottom:10px; font-size:16px; font-weight:bold">
      企业名称：{{enterprise_name }} ({{enterprise_desc}}) 
    </p>
    <Form ref="formQuery" :model="formQuery" inline>
      <FormItem>
        <Select v-model="formQuery.category_id" style="width:400px">
            <Option v-for="(item,idx) in seletVal" :key="idx" :value="item.ec_model_no">{{item.ec_model_title}}</Option>
        </Select>
      </FormItem>
      <FormItem>
        <Input type="text" style="width:400px" v-model.trim="formQuery.record_no" placeholder="备案号"></Input>
      </FormItem>
      <FormItem>
        <Input type="text" style="width:400px" v-model.trim="formQuery.bar_code" placeholder="实验室报告号"></Input>
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
    
  </Card>
</template>
<script>
import axios from 'axios'
import { getFormatTime } from '@/libs/tools'
export default {
  data () {
    
    return {
      formQuery:{
        category_id:'',
        bar_code:'',
        record_no:'',
        user_id:'',
        pageSize: 10,
        pageNum: 1
      },
      enterprise_name:'',
      enterprise_desc:'',
      seletVal:[
      ],
      total:0,
      columns1: [
        {
          title:'大类',
          key:'category_name',
          align:'center'
        },
        {
          title: '唯一码',
          key: 'user_name',
          align: 'center'
        },
        {
          title: '备案号',
          key: 'record_no',
          align: 'center'
        },
        {
          title: '实验室报告号',
          key: 'bar_code',
          align: 'center'
        },
        {
          title: '型号',
          key: 'product_model',
          align: 'center'
        },
         {
          title: '主型号',
          key: 'p_product_model',
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
          title: '状态',
          key: 'state_name',
          align: 'center'
        },
        {
          title: '公告时间',
          key: 'publish_time',
          align: 'center'
        },
        {
          title: '操作',
          key: 'action',
          align: 'center',
          render: (h, params) => {
            return h('div', [
            
            ])
          }
        }
      ],
      recordData: []
    }
  },
  methods: {
    getList () {
      axios.get('/markingmanage/listAll.do', {
        params: this.formQuery
      }).then(res => {
        //console.log(res.data)
        this.recordData = res.data.data.list
        this.total = res.data.data.total
      })
    },
    searchFun(){
      this.getList();
    },
    changeList (pNum) {
      this.formQuery.pageNum = pNum
      this.getList();
    },
    getCategory(id){
      axios.get('/markingmanage/getCategoryList.do', {
        params: {
          user_id: id
        }
      }).then(res => {
        this.seletVal= res.data.data
      })
    }
  },
  created(){
    console.log(this.$route.params)
    let userid = this.$route.params.el_user_id || 0
    if(userid){
       this.enterprise_name=this.$route.params.enterprise_name
       this.enterprise_desc=this.$route.params.enterprise_desc
    }
    this.getCategory(userid)
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
