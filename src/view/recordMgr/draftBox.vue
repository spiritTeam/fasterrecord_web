<template>
  <Card>
    <p slot="title">草稿箱</p>
    <Form ref="formDraft" :model="formDraft" inline>
      <FormItem>
        <Select v-model="formDraft.category_id" placeholder="选择品类" style="width:300px;">
          <Option v-for="item in categoryList" :value="item.ec_model_no" :key="item.ec_model_no">{{ item.ec_model_title }}</Option>
        </Select>
      </FormItem>
      <FormItem>
        <Input type="text" v-model="formDraft.model_name" placeholder="产品型号"></Input>
      </FormItem>
      <FormItem>
        <Input type="text" v-model="formDraft.bar_code" placeholder="实验室报告条码"></Input>
      </FormItem>
      <FormItem>
        <Button type="primary" @click="searchFun">搜索</Button>
        <Button type="primary" @click="clearFun">清空</Button>
      </FormItem>
    </Form>
    <Table border :columns="columns1" :data="recordData"></Table>
    <Page :total="total" :page-size=10
      @on-change="changeList"
      style="margin-top:10px; text-align: right">
    </Page>
  </Card>
</template>
<script>
import axios from 'axios'
export default {
  data () {
    return {
      total: 0,
      formDraft: {
        category_id:'',
        model_name: '',
        bar_code: '',
        pageSize: 10,
        pageNum: 1
      },
      categoryList: [
        {
          ec_model_no: '47',
          ec_model_title: '家用电冰箱 2015版'
        }
      ],
      columns1: [
        {
          title: '大类',
          key: 'category_name',
          align: 'center'
        },
        {
          title: '型号',
          key: 'model_name',
          align: 'center'
        },
        {
          title: '实验室报告条码',
          key: 'bar_code',
          align: 'center'
        },
        {
          title: '备案类型',
          key: 'type',
          align: 'center',
          render: (h, params) => {//备案类型:0主型号1扩展2变更
            return h('span', {}, params.row.type === '0' ? '主型号' :
                                 params.row.state === '1' ? '扩展' :
                                 params.row.state === '2' ? '变更' : '')
          }
        },
        {
          title: '状态',
          key: 'state',
          align: 'center',
          render: (h, params) => {//1草稿2标识图制作中3数据同步中10已公告
            return h('span', {}, params.row.state === 1 ? '草稿' :
                                 params.row.state === 2 ? '标识图制作中' :
                                 params.row.state === 3 ? '数据同步中' :
                                 params.row.state === 10 ? '已公告' : '')
          }
        },
        {
          title: '操作',
          key: 'action',
          align: 'center',
          render: (h, params) => {
            return h('Button', {
              props: {
                type: 'primary',
                size: 'small'
              },
              on: {
                click: () => {
                  this.editFun(params.row.id)
                }
              }
            }, '继续填写')
          }
        }
      ],
      recordData: []
    }
  },
  mounted () {
    this.getCategoryList()
    this.reqData()
  },
  methods: {
    reqData () {
      axios.get('/marking/draftList.do', {
        params: this.formDraft
      }).then(res => {
        this.recordData = res.data.list
        this.total = res.data.total
      })
    },
    editFun (id) {
      axios.get('/marking/getDraftInfo.do', {
        params: {
          id: id
        }
      }).then(res => {
        if (res.data.result_code === '1') {
          //this.$store.commit('setDraftData',res.data)
          this.$router.push({name:'addRecord',params:{step:3,draftData:res.data}})
          this.$store.commit('setDateInit', res.data.lab.upddate)
          this.$store.commit('setModelNo',res.data.marking.ec_model_no)
          this.$store.commit('setOem',res.data.lab.oem)
        } else {
          this.$Message.warning(res.data.return_msg)
        }
      })
    },
    searchFun () {
      this.formDraft.pageNum = 1
      this.reqData()
    },
    clearFun () {
      this.formDraft.category_id = ''
      this.formDraft.model_name = ''
      this.formDraft.bar_code = ''
      this.searchFun()
    },
    changeList (pNum) {
      this.formDraft.pageNum = pNum
      this.reqData()
    },
    getCategoryList () {
      axios.get('/marking/getCategoryList.do').then(res => {
        if (res.data.result_code === '1') {
          this.categoryList = res.data.data
        }
      })
    }
  }
}
</script>
