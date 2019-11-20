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
        <Select v-model="formQuery.category_id" style="width:300px">
            <Option v-for="(item,idx) in seletVal" :key="idx" :value="item.ec_model_no">{{item.ec_model_title}}</Option>
        </Select>
      </FormItem>
      <FormItem>
        <Input type="text" style="width:300px" v-model.trim="formQuery.record_no" placeholder="备案号"></Input>
      </FormItem>
      <FormItem>
        <Input type="text" style="width:200px" v-model.trim="formQuery.bar_code" placeholder="实验室报告号"></Input>
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
        cancel-text="确定"
        ok-text="同步信息"
        :footer-hide="true"
        :mask-closable="false">
          <Tabs value="name1" style="margin-top:16px;">
              <TabPane label="标识信息" name="name1" style="text-align:center">
                 <img :src="bsUrl" width="400" /> 
                 <Button type="primary" @click="resetPic">重新生成标识图</Button>
              </TabPane>
              <TabPane  label="标识模板信息" name="name2" style="text-align:center">
                <img :src="tempUrl" width="400"/>
              </TabPane>
          </Tabs>
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
      },
      style:{
        marginBottom:'1px'
      },
      on: {
        click: () => {
          this.viewHandle(params.row.id)
        }
      }
    }, '查看备案信息')
    const viewTempBtn = (h, params) => h('Button', {
      props: {
        type: 'primary',
        size: 'small',
      },
      on: {
        click: () => {
          this.viewTempHandle(params.row.id)
        }
      }
    }, '查看标识信息')
    return {
      modalTask:false,
      bsUrl:'',
      tempId:0,
      tempUrl:'',
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
          key: 'uid',
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
          width: 120,
          render: (h, params) => {
            return h('span', [
              //viewBtn(h,params),
              viewTempBtn(h,params)
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
    },
    viewHandle (id) {
      axios.get('/marking/getInfo.do', {
        params: {
          id: id
        }
      }).then(res => {
        if (res.data.result_code === '1') {
          this.$router.push({
            name: 'addRecord',
            params: {
              step: 3,
              type: 'view',
              id: id,
              pageNum: this.formQuery.pageNum,
              viewData: res.data
            }
          })
          this.$store.commit('setModelNo', res.data.marking.ec_model_no)
        }
      })
    },
    viewTempHandle (id) {
      this.modalTask=true;
      axios.get('/markingmanage/getELImg.do', {
        params: {
           id
        }
      }).then(res => {
        if (res.data.result) {
           this.tempId=res.data.data.id
           this.bsUrl=res.data.data.url;
           this.tempUrl=res.data.data.tempUrl
        }
      })
    },
    resetPic(){
      axios.get('/markingmanage/getELImg.do', {
        params: {
           id:this.tempId
        }
      }).then(res => {
        if (res.data.result) {
            this.$Message.success(res.data.msg)
            this.modalTask=false;
        }else{
            this.$Message.error(res.data.msg)
        }
      })
    }
  },
  created(){
    console.log(this.$route.params)
    let userid = this.$route.params.el_user_id || 0
    if(userid){
       this.formQuery.user_id=userid
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
