<template>
  <Card>
    <p slot="title">工单列表</p>
    <Form ref="formList" :model="formList" inline>
      <FormItem>
        <Input type="text" v-model="formList.workOrderCode" placeholder="工单号精准查询"></Input>
      </FormItem>
      <FormItem>
        <Input type="text" v-model="formList.productModel" placeholder="型号"></Input>
      </FormItem>
      <FormItem style="width:250px;">
        <Select v-model="formList.productType" placeholder="产品类别">
          <Option v-for="item in productTypeList" :value="item.code" :key="item.code">{{ item.text }}</Option>
        </Select>
      </FormItem>
      <FormItem>
        <Button @click="searchSubmit" type="primary">查询</Button>
        <Button @click="resetFrom" type="ghost">重置</Button>
      </FormItem>
    </Form>
    <Table border :columns="columns" :data="workorderList"></Table>
    <Page :total="totals" show-elevator
      @on-change="changeList" :page-size='10' :current="formList.pn"
      style="margin-top:10px; text-align: right">
    </Page>
    <Modal
      v-model="modal2"
      :z-index=800
      width="1100"
      :footer-hide=true
      title="查看工单信息">
      <ViewOrder ref="viewForm" @updateList="reqData"></ViewOrder>
    </Modal>
  </Card>
</template>
<script>
import axios from 'axios'
import ViewOrder from './viewOrder'
export default {
  data () {
    return {
      modal2: false,
      totals: 0,
      formList: {
        workOrderCode: '',
        productModel: '',
        productType: '',
        pn: 1,
        ps: 10
      },
      productTypeList: [
        {
          code: 'T4',
          text: '单元式空气调节机 2004版'
        },
        {
          code: 'T6',
          text: '高压钠灯 2004版'
        },
        {
          code: 'T7',
          text: '中小型三相异步电动机 2012版'
        },
        {
          code: 'T8',
          text: '冷水机组 2004版'
        },
        {
          code: 'T9',
          text: '燃气热水器 2006版'
        },
        {
          code: 'T12',
          text: '多联式空调（热泵）机组 2008版'
        },
        {
          code: 'T13',
          text: '储水式电热水器 2008版'
        },
        {
          code: 'T15',
          text: '计算机显示器 2008版'
        },
        {
          code: 'T16',
          text: '自动电饭锅 2008版'
        },
        {
          code: 'T17',
          text: '交流电风扇 2008版'
        },
        {
          code: 'T18',
          text: '交流接触器 2008版'
        },
        {
          code: 'T19',
          text: '容积式空气压缩机 2009版'
        },
        {
          code: 'T20',
          text: '家用电冰箱 2008版'
        },
        {
          code: 'T21',
          text: '电力变压器 2009版'
        },
        {
          code: 'T22',
          text: '通风机 2009版'
        },
        {
          code: 'T23',
          text: '房间空气调节器 2010版'
        },
        {
          code: 'T25',
          text: '家用和类似用途微波炉 2010版'
        },
        {
          code: 'T27',
          text: '数字电视接收器 2010版'
        },
        {
          code: 'T28',
          text: '远置冷凝机组冷藏陈列柜 2011版'
        },
        {
          code: 'T29',
          text: '家用太阳能热水系统 2011版'
        },
        {
          code: 'T30',
          text: '微型计算机 2012版'
        },
        {
          code: 'T31',
          text: '电动洗衣机 2013版'
        },
        {
          code: 'T32',
          text: '自镇流荧光灯 2013版'
        },
        {
          code: 'T33',
          text: '转速可控型房间空气调节器 2013版'
        },
        {
          code: 'T34',
          text: '平板电视 2013版'
        },
        {
          code: 'T37',
          text: '热泵热水机（器） 2013版'
        },
        {
          code: 'T38',
          text: '复印机、打印机和传真机 2014版'
        },
        {
          code: 'T39',
          text: '吸油烟机 2013版'
        },
        {
          code: 'T40',
          text: '家用电磁灶 2014版'
        },
        {
          code: 'T41',
          text: '商用燃气灶具 2014版'
        },
        {
          code: 'T42',
          text: '家用燃气灶具 2014版'
        },
        {
          code: 'T43',
          text: '溴化锂吸收式冷水机组 2013版'
        },
        {
          code: 'T44',
          text: '水(地)源热泵机组 2014版'
        },
        {
          code: 'T45',
          text: '普通照明用非定向自镇流LED灯 2013版'
        },
        {
          code: 'T46',
          text: '计算机显示器 2015版'
        },
        {
          code: 'T47',
          text: '家用电冰箱 2015版'
        },
        {
          code: 'T48',
          text: '家用燃气快速热水器燃气采暖热水炉 2015版'
        },
        {
          code: 'T49',
          text: '投影机 2015版'
        },
        {
          code: 'T50',
          text: '冷水机组 2015版'
        },
        {
          code: 'T51',
          text: '电饭锅 2017版'
        },
        {
          code: 'T52',
          text: '家用和类似用途微波炉 2017版'
        },
        {
          code: 'T53',
          text: '家用和类似用途交流换气扇 2015版'
        },
        {
          code: 'T54',
          text: '自携冷凝机组商用冷柜 2015版'
        }
      ],
      workorderList: [],
      columns: [
        {
          title: '序号',
          key: 'action',
          width: 100,
          align: 'center',
          render: (h, params) => {
            return h('p', {}, (this.formList.pn - 1)*10 + (params.index + 1))
          }
        },
        {
          title: '工单号',
          key: 'workOrderCode'
        },
        {
          title: '生产者名称',
          key: 'ename'
        },
        {
          title: '产品类型',
          key: 'action',
          render: (h, params) => {
            let type = ''
            switch (params.row.productType) {
              case 'T4': type = '单元式空气调节机 2004版';break
              case 'T6': type = '高压钠灯 2004版';break
              case 'T7': type = '中小型三相异步电动机 2012版';break
              case 'T8': type = '冷水机组 2004版';break
              case 'T9': type = '燃气热水器 2006版';break
              case 'T12': type = '多联式空调（热泵）机组 2008版';break
              case 'T13': type = '储水式电热水器 2008版';break
              case 'T15': type = '计算机显示器 2008版';break
              case 'T16': type = '自动电饭锅 2008版';break
              case 'T17': type = '交流电风扇 2008版';break
              case 'T18': type = '交流接触器 2008版';break
              case 'T19': type = '容积式空气压缩机 2009版';break
              case 'T20': type = '家用电冰箱 2008版';break
              case 'T21': type = '电力变压器 2009版';break
              case 'T22': type = '通风机 2009版';break
              case 'T23': type = '房间空气调节器 2010版';break
              case 'T25': type = '家用和类似用途微波炉 2010版';break
              case 'T27': type = '数字电视接收器 2010版';break
              case 'T28': type = '远置冷凝机组冷藏陈列柜 2011版';break
              case 'T29': type = '家用太阳能热水系统 2011版';break
              case 'T30': type = '微型计算机 2012版';break
              case 'T31': type = '电动洗衣机 2013版';break
              case 'T32': type = '自镇流荧光灯 2013版';break
              case 'T33': type = '转速可控型房间空气调节器 2013版';break
              case 'T34': type = '平板电视 2013版';break
              case 'T37': type = '热泵热水机（器） 2013版';break
              case 'T38': type = '复印机、打印机和传真机 2014版';break
              case 'T39': type = '吸油烟机 2013版';break
              case 'T40': type = '家用电磁灶 2014版';break
              case 'T41': type = '商用燃气灶具 2014版';break
              case 'T42': type = '家用燃气灶具 2014版';break
              case 'T43': type = '溴化锂吸收式冷水机组 2013版';break
              case 'T44': type = '水(地)源热泵机组 2014版';break
              case 'T45': type = '普通照明用非定向自镇流LED灯 2013版';break
              case 'T46': type = '计算机显示器 2015版';break
              case 'T47': type = '家用电冰箱 2015版';break
              case 'T48': type = '家用燃气快速热水器燃气采暖热水炉 2015版';break
              case 'T49': type = '投影机 2015版';break
              case 'T50': type = '冷水机组 2015版';break
              case 'T51': type = '电饭锅 2017版';break
              case 'T52': type = '家用和类似用途微波炉 2017版';break
              case 'T53': type = '家用和类似用途交流换气扇 2015版';break
              case 'T54': type = '自携冷凝机组商用冷柜 2015版';break
            }
            return h('p', {}, type)
          }
        },
        {
          title: '工单创建时间',
          key: 'action',
          render: (h, params) => {
            let date = this.dateFormat(params.row.createTime)
            return h('p', {}, date)
          }
        },
        {
          title: '状态',
          key: 'action',
          render: (h, params) => {
            let s = ''
            switch (params.row.status) {
              case 1 : s = '草稿'; break
              case 2 : s = '等待接单'; break
              case 3 : s = '接单确认中'; break
              case 4 : s = '被驳回'; break
              case 5 : s = '等待受理'; break
              case 6 : s = '受理中'; break
              case 7 : s = '受理完成'; break
              case 8 : s = '挂起'; break
            }
            return h('p', {}, s)
          }
        },
        {
          title: '操作',
          key: 'action',
          render: (h, params) => {
            return h('Button', {
              props: {
                type: 'primary',
                size: 'small'
              },
              on: {
                click: () => {
                  this.view(params.row.workOrderCode)
                }
              }
            }, '查看')
          }
        }
      ]
    }
  },
  mounted () {
    this.reqData()
  },
  components: {
    ViewOrder
  },
  methods: {
    searchSubmit () {
      this.formList.pn = 1
      this.reqData()
    },
    resetFrom () {
      this.formList.status = ''
      this.formList.workOrderCode = ''
      this.formList.eName = ''
      this.formList.productModel = ''
      this.formList.productType = ''
      this.formList.preNum = ''
      this.formList.recordNum = ''
    },
    reqData () {
      axios.get('/workorder/getWorkOrderList.do', {
        params: this.formList
      })
      .then(res => {
        if (res.data.result === true) {
          this.workorderList = res.data.msg.list
          this.totals = res.data.msg.total
        }
      })
    },
    changeList (pNum) {
      this.formList.pn = pNum
      this.reqData()
    },
    view (code) {
      this.$refs.viewForm.getOrderInfo(code)
      this.modal2 = true
    },
    dateFormat (date) {
      let st = new Date(date)
      let year = st.getFullYear()
      let month = st.getMonth() < 9 ? '0' + (st.getMonth() + 1) : (st.getMonth() + 1)
      let day = st.getDate() < 10 ? '0' + st.getDate() : st.getDate()
      let hour = st.getHours() < 10 ? '0' + st.getHours() : st.getHours()
      let minute = st.getMinutes() < 10 ? '0' + st.getMinutes() : st.getMinutes()
      let second = st.getSeconds() < 10 ? '0' + st.getSeconds() : st.getSeconds()
      return year + '-' + month + '-' + day + ' ' + hour + ':' + minute + ':' + second
    },
  }
}
</script>
