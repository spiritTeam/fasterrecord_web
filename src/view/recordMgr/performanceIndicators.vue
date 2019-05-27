<template>
  <div class="wrapper">
    <h2>一、性能能指标信息</h2>
    <Form ref="formPerformance" :model="formPerformance" label-position="right" :label-width="100" :rules="rulePerformance">
      <FormItem prop="p1" label="噪音(dB(A)):" style="width:1000px;">
        <Input type="text" v-model="formPerformance.p1" placeholder="噪音(dB(A))"></Input>
      </FormItem>
      <div style="width:1000px;text-align:center;"><Button type="primary">保存</Button></div>
    </Form>
  </div>
</template>
<script>
export default {
  data () {
    return {
      formPerformance: {
        p1: ''
      },
      rulePerformance: {
        p1: {
          required: true
        }
      }
    }
  }
}
</script>
<style lang="less" scoped>
h2{
  font-size:18px;
  margin:10px 0;
}
</style>
