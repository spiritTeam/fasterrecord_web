<template>
  <Card>
    <p slot="title">绑定备案系统账号</p>
    <Form class="form" ref="formBind" :model="formBind" label-position="right" :label-width="150" :rules="ruleBind">
      <FormItem prop="fastRecordLoginName" label="本系统账号" style="width:400px;">
        <Input type="text" v-model="formBind.fastRecordLoginName"></Input>
      </FormItem>
      <FormItem prop="energyLabelLoginName" label="备案系统账号" style="width:400px;">
        <Input type="text" v-model="formBind.energyLabelLoginName"></Input>
      </FormItem>
      <FormItem prop="energyLabeluserId" label="备案系统用户ID" style="width:400px;">
        <Input type="text" v-model="formBind.energyLabeluserId"></Input>
      </FormItem>
    </Form>
    <div class="tc"><Button type="primary" @click="bindFun">绑定</Button></div>
  </Card>
</template>
<script>
import axios from 'axios'
export default {
  data () {
    return {
      formBind: {
        fastRecordLoginName: '',
        energyLabelLoginName: '',
        energyLabeluserId: ''
      },
      ruleBind: {
        fastRecordLoginName: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        energyLabelLoginName: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        energyLabeluserId: [
          {
            required: true,
            message: '不能为空'
          }
        ]
      }
    }
  },
  methods: {
    bindFun () {
      axios('/user/bindEnergyLabelUser.do', {
        params: this.formBind
      }).then(res => {
        if (res.data.result === true) {
          this.$Message.success('绑定成功！')
        } else {
          this.$Message.warning(res.data.msg)
        }
      })
    }
  }
}
</script>

<style lang="less" scoped>
.form{
  width:400px;
  margin:0 auto;
}
.tc{
  text-align:center;
}
</style>
