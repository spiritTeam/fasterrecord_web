<template>
  <Tabs type="card" v-model="tabName">
    <TabPane label="工单信息" name="tab1">
      <Form ref="formCreate" :model="formCreate" label-position="right" :label-width="100">
        <FormItem label="生产者名称:" style="width:1000px;">
          <p>{{formCreate.ename === null ? '/' : formCreate.ename}}</p>
        </FormItem>
        <FormItem prop="submitPerson" label="提出人:" style="width:1000px;">
          <p>{{formCreate.submitPerson === null ? '/' : formCreate.submitPerson}}</p>
        </FormItem>
        <FormItem prop="department" label="隶属部门:" style="width:1000px;">
          <p>{{formCreate.department === null ? '/' : formCreate.department}}</p>
        </FormItem>
        <FormItem prop="submitTime" label="提出日期:" style="width:1000px;">
          <p>{{formCreate.submitTime}}</p>
        </FormItem>
        <FormItem prop="contactPhone" label="联系电话:" style="width:1000px;">
          {{formCreate.contactPhone === null ? '/' : formCreate.contactPhone}}
        </FormItem>
        <FormItem prop="email" label="联系邮箱:" style="width:1000px;">
          <p>{{formCreate.email === null ? '/' : formCreate.email}}</p>
        </FormItem>
        <FormItem prop="productType" label="产品类别:" style="width:1000px;">
          <p>{{formCreate.productType === null ? '/' : productTypeFormat(formCreate.productType)}}</p>
        </FormItem>
        <FormItem prop="productModel" label="型号:" style="width:1000px;">
          <p>{{formCreate.productModel === null ? '/' : formCreate.productModel}}</p>
        </FormItem>
        <FormItem prop="preNum" label="预审号:" style="width:1000px;">
          <p>{{formCreate.preNum === null ? '/' : formCreate.preNum}}</p>
        </FormItem>
        <FormItem prop="recordNum" label="备案号:" style="width:1000px;">
          <p>{{formCreate.recordNum === null ? '/' : formCreate.recordNum}}</p>
        </FormItem>
        <FormItem prop="problemTime" label="问题发生日期:" style="width:1000px;">
          <p>{{formCreate.problemTime}}</p>
        </FormItem>
        <FormItem prop="page" label="具体页面:" style="width:1000px;">
          <p>{{formCreate.page === null ?  '/' : formCreate.page}}</p>
        </FormItem>
        <FormItem prop="details" label="详细描述:" style="width:1000px;">
          <p>{{formCreate.details}}</p>
        </FormItem>
      </Form>
    </TabPane>
  </Tabs>
</template>
<script>
let editor
import axios from 'axios'
import {getCookie} from '@/libs/util'
axios.defaults.headers['contentType'] = 'application/json charset=utf-8'
export default {
  data () {
    return {
      workOrderCode: '',
      tabName: 'tab1',
      columns: [
        {
          title: '工单号',
          key: 'workOrderCodeSub'
        },
        {
          title: '预审号',
          key: 'preNum'
        },
        {
          title: '备案号',
          key: 'recordNum'
        },
        {
          title: '型号',
          key: 'productModel'
        }
      ],
      workorderList: [],
      formCreate: {}
    }
  },
  methods: {
    getOrderInfo (code) {
      this.tabName = 'tab1'
      this.workOrderCode = code
      axios.get('/workorder/getWorkOrder.do', {
        params: {
          workOrderCode: code
        }
      }).then(res => {
        if (res.data.result === true) {
          this.formCreate = res.data.msg
          this.formCreate.submitTime = this.dateFormat(this.formCreate.submitTime)
          this.formCreate.problemTime = this.dateFormat(this.formCreate.problemTime)
        }
      })
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
    productTypeFormat (type) {
      switch (type) {
        case 'T4': return '单元式空气调节机 2004版';break
        case 'T6': return '高压钠灯 2004版';break
        case 'T7': return '中小型三相异步电动机 2012版';break
        case 'T8': return '冷水机组 2004版';break
        case 'T9': return '燃气热水器 2006版';break
        case 'T12': return '多联式空调（热泵）机组 2008版';break
        case 'T13': return '储水式电热水器 2008版';break
        case 'T15': return '计算机显示器 2008版';break
        case 'T16': return '自动电饭锅 2008版';break
        case 'T17': return '交流电风扇 2008版';break
        case 'T18': return '交流接触器 2008版';break
        case 'T19': return '容积式空气压缩机 2009版';break
        case 'T20': return '家用电冰箱 2008版';break
        case 'T21': return '电力变压器 2009版';break
        case 'T22': return '通风机 2009版';break
        case 'T23': return '房间空气调节器 2010版';break
        case 'T25': return '家用和类似用途微波炉 2010版';break
        case 'T27': return '数字电视接收器 2010版';break
        case 'T28': return '远置冷凝机组冷藏陈列柜 2011版';break
        case 'T29': return '家用太阳能热水系统 2011版';break
        case 'T30': return '微型计算机 2012版';break
        case 'T31': return '电动洗衣机 2013版';break
        case 'T32': return '自镇流荧光灯 2013版';break
        case 'T33': return '转速可控型房间空气调节器 2013版';break
        case 'T34': return '平板电视 2013版';break
        case 'T37': return '热泵热水机（器） 2013版';break
        case 'T38': return '复印机、打印机和传真机 2014版';break
        case 'T39': return '吸油烟机 2013版';break
        case 'T40': return '家用电磁灶 2014版';break
        case 'T41': return '商用燃气灶具 2014版';break
        case 'T42': return '家用燃气灶具 2014版';break
        case 'T43': return '溴化锂吸收式冷水机组 2013版';break
        case 'T44': return '水(地)源热泵机组 2014版';break
        case 'T45': return '普通照明用非定向自镇流LED灯 2013版';break
        case 'T46': return '计算机显示器 2015版';break
        case 'T47': return '家用电冰箱 2015版';break
        case 'T48': return '家用燃气快速热水器燃气采暖热水炉 2015版';break
        case 'T49': return '投影机 2015版';break
        case 'T50': return '冷水机组 2015版';break
        case 'T51': return '电饭锅 2017版';break
        case 'T52': return '家用和类似用途微波炉 2017版';break
        case 'T53': return '家用和类似用途交流换气扇 2015版';break
        case 'T54': return '自携冷凝机组商用冷柜 2015版';break
      }
    }
  }
}
</script>
<style lang="less" scoped>
.ivu-form-item{
  margin-bottom:0;
}
.ivu-modal-wrap{
  z-index:8888
}
.ivu-col-span-9{
  font-weight:bold;
  line-height:40px;
}
.ivu-col-span-9,.opList li{
  line-height:36px;
  font-size:14px;
}
.ivu-modal-mask{
  z-index:9999;
}
</style>
