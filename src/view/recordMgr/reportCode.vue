<template>
  <div>
    <h1>请输入实验室报告条码</h1>
    <Input type="text" v-model.trim="reportCode" placeholder="请输入实验室报告条码"></Input>
    <Button type="primary" @click="confirmCode">确定</Button>
  </div>
</template>
<script>
import axios from 'axios'
export default {
  data () {
    return {
      reportCode: ''
    }
  },
  methods: {
    confirmCode () {
      if(!this.reportCode){
        return;
      }
      let updateId=0;
      if(this.$store.state.app.pageType=='update'){
          updateId=this.$store.state.app.updateId;
      }
      axios.get('/lab/getReport.do', {
        params: {
          barcode: this.reportCode,
          id:updateId
        }
      }).then(res => {
        if (res.data.result === true) {
          this.$store.commit('setDefaultData', res.data.msg.params)
          this.$store.commit('setRid', res.data.msg.rid)
          this.$store.commit('setDateInit', res.data.msg.upddate)
          this.$store.commit('setBarcode', res.data.msg.barcode)
          this.$store.commit('setLabName', res.data.msg.labName)
          this.$store.commit('setModelNo', res.data.msg.modelNo)
          this.$store.commit('setTemplate', res.data.msg.templates)
          //this.$store.commit('setOem',res.data.msg.oem)
          this.$emit('toStep2')
        } else {
          //this.$Message.warning(res.data.msg)
          this.$Modal.warning({
              title: '提示',
              content: res.data.msg
          });
          this.reportCode = ''
        }
      })
    }
  }
}
</script>
<style lang="less" scoped>
div{
  width:500px;
  text-align:center;
  margin:0 auto;
}
h1{
  font-size:20px;
  margin-bottom:20px;
}
button{
  margin-top:20px;
}
</style>
