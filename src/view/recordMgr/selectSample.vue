<template>
  <div>
    <h2>请选择标识模板样式</h2>
    <Row>
      <!--<Col span="4" v-for="(item,idx) in sampleList" :offset="idx === 0 ? offsetNum : 0" :key="item.id">
        <img :src="item.pic2 == null ? defaultImg : item.pic2" @click="viewImg(item.pic1)" />
      </Col>-->
    </Row>
    <Row>
      <Col span="4" v-for="(item,idx) in sampleList" :offset="idx === 0 ? offsetNum : 0" :key="item.id">
        <RadioGroup v-model="sample" size="large">
          <!-- <Radio class="radioItem"  :label="item.id" :disabled="!template.includes(item.id)" :data-pic="item.pic1"> <img :src="item.pic2 == null ? defaultImg : item.pic2" @click="viewImg(item.pic1)" /></Radio> -->
          <Radio class="radioItem"  :label="item.id" :data-pic="item.pic1"> <img :src="item.pic2 == null ? defaultImg : item.pic2" @click="viewImg(item.pic1)" /></Radio>
        </RadioGroup>
      </Col>
    </Row>
    <Button type="primary" style="margin-top:50px;" @click="confirmSample">提交</Button>
    <Modal v-model="modal1" :width=820 :footer-hide=true>
      <img :src="viewBigPic" />
    </Modal>
  </div>
</template>
<script>
import axios from 'axios'
import defaultImg from '@/assets/images/defaultImg.jpg'
export default {
  data () {
    return {
      defaultImg: defaultImg,
      sample: '',
      sampleList: [],
      template:[],
      modal1: false,
      viewBigPic: ''
    }
  },
  mounted () {

    //this.getSampleList()
    //this.setStyle()
  },
  computed: {
    offsetNum () {
      switch (this.$store.state.app.modelNo) {
        case 47 : return 2;break
        case 33 : return 8;break
        case 31 : return 10;break
        case 23 : return 10;break
        default: return 0
      }
    }
  },
  methods: {
    viewImg (img) {
      if (img !== null) {
        this.viewBigPic = img
        this.modal1 = true
      }
    },
    getSampleList () {
      let that = this
      axios.get('/marking/getTemplate.do', {
        params: {
          model_no: this.$store.state.app.modelNo
        }
      }).then(res => {
        //let res = {}
        //res.data = [{"id":241,"pt_id":49,"name":"模板1","pic1":"http://zip.el.bbqkimg.cn/templates/sample/47/1.png","pic2":"http://zip.el.bbqkimg.cn/templates/sample/47/1s.png"},{"id":242,"pt_id":49,"name":"模板2","pic1":"http://zip.el.bbqkimg.cn/templates/sample/47/2.png","pic2":"http://zip.el.bbqkimg.cn/templates/sample/47/2s.png"},{"id":245,"pt_id":49,"name":"模板4","pic1":"http://zip.el.bbqkimg.cn/templates/sample/47/4.png","pic2":"http://zip.el.bbqkimg.cn/templates/sample/47/4s.png"},{"id":246,"pt_id":49,"name":"模板5","pic1":"http://zip.el.bbqkimg.cn/templates/sample/47/5.png","pic2":"http://zip.el.bbqkimg.cn/templates/sample/47/5s.png"},{"id":244,"pt_id":49,"name":"模板3","pic1":null,"pic2":null}]
        if (res.data.length > 0) {
          this.sampleList = res.data
          this.template=this.$store.state.app.templates;
          this.$store.commit('setPtId', res.data[0].pt_id)
          //this.setStyle()
        }
      })
    },
    confirmSample () {
      if (this.sample === '') {
        this.$Message.warning('请选择标识模板样式！')
      } else {
        this.$store.commit('setPltId', this.sample)
        let newobj=this.sampleList.filter((item,idx)=>{
          return item.id==this.sample
        })
        this.$store.commit('setPltPic', newobj[0].pic1)
        axios.get('/marking/getTemplateItem.do', {
          params: {
            model_no: this.$store.state.app.modelNo,
            ptid: this.$store.state.app.ptId,
            pltId: this.$store.state.app.pltId
          }
        }).then(res => {
          if (res.data.result_code === '1') {
            this.$store.commit('setRequiredStr', res.data.required.toLowerCase() + ',')
            this.$store.commit('setGb', res.data.GB)
            this.$emit('toStep3')
          }
        })
      }
    }
  }
}
</script>
<style lang="less" scoped>
h2{
  margin:50px 0;
}
div,.ivu-col-span-4{
  text-align:center;
}
.ivu-radio-large .ivu-radio-inner{
  top:20px!important;
  left:62px!important;
}
  .radioItem{
    display: flex;
    flex-direction: column-reverse;
  }
.radioItem img{ margin-bottom: 10px;}
</style>
