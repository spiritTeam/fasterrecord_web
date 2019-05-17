<template>
  <div>
    <h2>一、安全指标信息</h2>
    <Form ref="formSecurity" :model="formSecurity" label-position="right" :label-width="100" :rules="ruleSecurity">
      <FormItem prop="c_val" label="证书编号" style="width:1000px;">
        <Input type="text" v-model="formSecurity.c_val" placeholder="证书编号"></Input>
      </FormItem>
      <FormItem prop="issuing_time" label="发证日期" style="width:1000px;">
        <DatePicker type="date" v-model="formSecurity.issuing_time"></DatePicker>
      </FormItem>
      <FormItem prop="expire_time" label="证书到期日期" style="width:1000px;">
        <DatePicker type="date" v-model="formSecurity.expire_time"></DatePicker>
      </FormItem>
      <FormItem prop="issuing_mech" label="发证机构" style="width:1000px;">
        <Input type="text" v-model="formSecurity.issuing_mech" placeholder="发证机构"></Input>
      </FormItem>
      <FormItem prop="marking_name" label="产品名称" style="width:1000px;">
        <Input type="text" v-model="formSecurity.marking_name" placeholder="产品名称"></Input>
      </FormItem>
      <FormItem prop="detemech_name" label="检测机构名称" style="width:1000px;">
        <Input type="text" v-model="formSecurity.detemech_name" placeholder="检测机构名称"></Input>
      </FormItem>
      <FormItem prop="detection_time" label="检测时间" style="width:1000px;">
        <DatePicker type="date" v-model="formSecurity.detection_time"></DatePicker>
      </FormItem>
      <FormItem prop="" label="是否做节能认证" style="width:1000px;">
        <RadioGroup v-model="formSecurity.is_enerconser">
          <Radio label="是">是</Radio>
          <Radio label="否">否</Radio>
        </RadioGroup>
      </FormItem>
    </Form>
    <h2>二、附件部分</h2>
    <table>
      <tr>
        <td>证书附件</td>
        <td>(PDF/JPG/PNG)</td>
        <td>
          <Upload action="/">
            <Button icon="ios-cloud-upload-outline" type="primary">上传</Button>
          </Upload>
        </td>
        <td>节能附件</td>
        <td>（PDF）</td>
        <td>
          <Upload action="/">
            <Button icon="ios-cloud-upload-outline" type="primary">上传</Button>
          </Upload>
        </td>
      </tr>
    </table>
    <div style="width:1000px;text-align:center;"><Button type="primary">保存</Button></div>
  </div>
</template>
<script>
export default {
  data () {
    return {
      formSecurity: {
        c_val: '',
        issuing_time: '',
        expire_time: '',
        issuing_mech: '',
        marking_name: '',
        detemech_name: '',
        detection_time: '',
        is_enerconser: ''
      },
      ruleSecurity: {}
    }
  }
}
</script>
<style lang="less" scoped>
h2{
  font-size:18px;
  margin:10px 0;
}
table{
  width:1000px;
  border-collapse:collapse;
  margin-bottom:10px;
}
table td{
  border:1px solid #dddee1;
  padding:10px;
  text-align:center;
}
</style>
