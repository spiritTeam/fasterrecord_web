<template>
  <Card>
    <p slot="title">登录密码修改</p>
    <Form class="form" ref="formModify" :model="formModify" label-position="right" :label-width="100">
      <FormItem prop="pwd1" label="当前密码" style="width:400px;">
        <Input type="password" v-model="formModify.pwd1"></Input>
      </FormItem>
      <FormItem prop="pwd2" label="新密码" style="width:400px;">
        <Input type="password" v-model="formModify.pwd2"></Input>
      </FormItem>
      <FormItem prop="pwd3" label="新密码确认" style="width:400px;">
        <Input type="password" v-model="formModify.pwd3"></Input>
      </FormItem>
    </Form>
    <div class="tc"><Button type="primary" @click="modifyFun">修改</Button></div>
  </Card>
</template>
<script>
import axios from 'axios'
export default {
  data () {
    return {
      formModify: {
        pwd1: '',
        pwd2: '',
        pwd3: ''
      }
    }
  },
  methods: {
    modifyFun () {
      if (this.formModify.pwd2 !== this.formModify.pwd3) {
        this.$Message.warning('两次输入的新密码不一致')
        return false
      }
      axios({
        url: '/user/password.do',
        method: 'POST',
        data: {
          oldPassword: this.formModify.pwd1,
          password: this.formModify.pwd2
        },
        transformRequest: [function (data) {
          let ret = ''
          for (let it in data) {
            ret += encodeURIComponent(it) + '=' + encodeURIComponent(data[it]) + '&'
          }
          return ret
        }],
        headers: {
          'Content-Type': 'application/x-www-form-urlencoded'
        }
      }).then(res => {
        if (res.data.result) {
          this.$Message.success('修改成功！')
          this.formModify.pwd1 = ''
          this.formModify.pwd2 = ''
          this.formModify.pwd3 = ''
          window.location.href = '/dist/index.html?r=' + Math.random();
        } else {
          this.$Message.warning(res.data.err_msg)
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
