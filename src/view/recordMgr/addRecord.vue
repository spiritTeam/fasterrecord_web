<template>
  <Card>
    <p slot="title" v-if="step === 2 || step === 1">{{titleValue}}</p>
    <div>
      <ReportCode v-show="step === 1" @toStep2="showTemple"></ReportCode>
      <SelectSample ref="selectSample" v-show="step === 2" @toStep3="showRecordTab"></SelectSample>
      <Tabs type="card" v-show="step === 3" class="pageStyle">
        <TabPane label="能效指标">
          <!-- <EnergyIndicators ref="energyIndicators"></EnergyIndicators> -->
          <Html4 v-if="category == 4" ref="energyIndicators4" @prevStep="step = 2"></Html4>
          <Html6 v-if="category == 6" ref="energyIndicators6" @prevStep="step = 2"></Html6>
          <Html12 v-if="category == 12" ref="energyIndicators12" @prevStep="step = 2"></Html12>
          <Html13 v-if="category == 13" ref="energyIndicators13" @prevStep="step = 2"></Html13>
          <Html17 v-if="category == 17" ref="energyIndicators17" @prevStep="step = 2"></Html17>
          <Html19 v-if="category == 19" ref="energyIndicators19" @prevStep="step = 2"></Html19>
          <Html23 v-if="category == 23" ref="energyIndicators23" @prevStep="step = 2"></Html23>
          <Html27 v-if="category == 27" ref="energyIndicators27" @prevStep="step = 2"></Html27>
          <Html28 v-if="category == 28" ref="energyIndicators28" @prevStep="step = 2"></Html28>
          <Html29 v-if="category == 29" ref="energyIndicators29" @prevStep="step = 2"></Html29>
          <Html30 v-if="category == 30" ref="energyIndicators30" @prevStep="step = 2"></Html30>
          <Html31 v-if="category == 31" ref="energyIndicators31" @prevStep="step = 2"></Html31>
          <Html33 v-if="category == 33" ref="energyIndicators33" @prevStep="step = 2"></Html33>
          <Html34 v-if="category == 34" ref="energyIndicators34" @prevStep="step = 2"></Html34>
          <Html37 v-if="category == 37" ref="energyIndicators37" @prevStep="step = 2"></Html37>
          <Html38 v-if="category == 38" ref="energyIndicators38" @prevStep="step = 2"></Html38>
          <Html39 v-if="category == 39" ref="energyIndicators39" @prevStep="step = 2"></Html39>
          <Html40 v-if="category == 40" ref="energyIndicators40" @prevStep="step = 2"></Html40>
          <Html41 v-if="category == 41" ref="energyIndicators41" @prevStep="step = 2"></Html41>
          <Html42 v-if="category == 42" ref="energyIndicators42" @prevStep="step = 2"></Html42>
          <Html44 v-if="category == 44" ref="energyIndicators44" @prevStep="step = 2"></Html44>
          <Html46 v-if="category == 46" ref="energyIndicators46" @prevStep="step = 2"></Html46>
          <Html47 v-if="category == 47" ref="energyIndicators47" @prevStep="step = 2"></Html47>
          <Html48 v-if="category == 48" ref="energyIndicators48" @prevStep="step = 2"></Html48>
          <Html49 v-if="category == 49" ref="energyIndicators49" @prevStep="step = 2"></Html49>
          <Html50 v-if="category == 50" ref="energyIndicators50" @prevStep="step = 2"></Html50>
          <Html53 v-if="category == 53" ref="energyIndicators53" @prevStep="step = 2"></Html53>
          <Html51 v-if="category == 51" ref="energyIndicators51" @prevStep="step = 2"></Html51>
          <Html52 v-if="category == 52" ref="energyIndicators52" @prevStep="step = 2"></Html52>
          <Html54 v-if="category == 54" ref="energyIndicators54" @prevStep="step = 2"></Html54>
        </TabPane>
        <!-- <TabPane label="性能指标">
          <PerformanceIndicators></PerformanceIndicators>
        </TabPane>
        <TabPane label="安全指标">
          <SecurityIndicators></SecurityIndicators>
        </TabPane> -->
      </Tabs>
    </div>
    <Modal v-model="modal1" title="提示：" @on-ok="setNoTips">
      <p style="font-size:18px;margin-bottom:10px;">已将实验师报告相关数据带入了对应表单项。如果您发现数据有问题，请点击右侧<Icon type="ios-help-circle-outline" size="20"></Icon>图标，一键上报问题。我们会及时修改！</p>
      <CheckboxGroup v-model="noTips">
        <Checkbox label="1">不再出现该提示</Checkbox>
      </CheckboxGroup>
    </Modal>
  </Card>
</template>
<script>
import {setCookie,getCookie} from '@/libs/util.js'
import ReportCode from './reportCode'
import SelectSample from './selectSample'
import PerformanceIndicators from './performanceIndicators'
import SecurityIndicators from './securityIndicators'
import {mapGetters} from 'vuex';
import Html4 from './energyIndicators/html4'
import Html6 from './energyIndicators/html6'
import Html12 from './energyIndicators/html12'
import Html13 from './energyIndicators/html13'
import Html17 from './energyIndicators/html17'
import Html19 from './energyIndicators/html19'
import Html23 from './energyIndicators/html23'
import Html27 from './energyIndicators/html27'
import Html28 from './energyIndicators/html28'
import Html29 from './energyIndicators/html29'
import Html30 from './energyIndicators/html30'
import Html31 from './energyIndicators/html31'
import Html33 from './energyIndicators/html33'
import Html34 from './energyIndicators/html34'
import Html37 from './energyIndicators/html37'
import Html38 from './energyIndicators/html38'
import Html39 from './energyIndicators/html39'
import Html40 from './energyIndicators/html40'
import Html41 from './energyIndicators/html41'
import Html42 from './energyIndicators/html42'
import Html44 from './energyIndicators/html44'
import Html46 from './energyIndicators/html46'
import Html47 from './energyIndicators/html47'
import Html48 from './energyIndicators/html48'
import Html49 from './energyIndicators/html49'
import Html50 from './energyIndicators/html50'
import Html53 from './energyIndicators/html53'
import Html51 from './energyIndicators/html51'
import Html52 from './energyIndicators/html52'
import Html54 from './energyIndicators/html54'


export default {
  data () {
    return {
      step: 1,
      category: this.$store.state.app.modelNo,
      noTips: [],
      modal1: false
    }
  },
  components: {
    ReportCode,
    SelectSample,
    PerformanceIndicators,
    SecurityIndicators,
    Html4,
    Html6,
    Html12,
    Html13,
    Html17,
    Html19,
    Html23,
    Html27,
    Html28,
    Html29,
    Html30,
    Html31,
    Html33,
    Html34,
    Html37,
    Html38,
    Html39,
    Html40,
    Html41,
    Html42,
    Html44,
    Html46,
    Html47,
    Html48,
    Html49,
    Html50,
    Html53,
    Html51,
    Html52,
    Html54
  },
  mounted () {
    if(this.$route.params.type){
      //if(this.$route.params.type==='update' || this.$route.params.type==='extend'){
          this.$store.commit('setPageType', this.$route.params.type)
          this.$store.commit('setUpdateId',this.$route.params.id)
      //}
    }else{
          this.$store.commit('setPageType', '')
          this.$store.commit('setUpdateId',0)
    };
    if (this.$route.params.step && this.$route.params.step === 3) {
      this.step = 3
      if (!getCookie('noTips') || getCookie('noTips') !== '1') {
        //this.modal1 = true
      }
      if(this.$route.params.draftData){
        this.$refs['energyIndicators' + this.category].fillDraftData(this.$route.params.draftData)
      }else if(this.$route.params.extendData){
        this.$refs['energyIndicators' + this.category].fillExtendData(this.$route.params.extendData)
      }else if(this.$route.params.viewData){
        this.$refs['energyIndicators' + this.category].fillDraftData(this.$route.params.viewData)
      }
    }
    let box = document.getElementsByClassName("ivu-card-head")[0]
    if (box && this.step === 3) {
      box.style.display='none'
    }else {
      box.style.display='block'
    }
  },
  methods: {
    setNoTips () {
      setCookie('noTips',this.noTips.join(''),1)
      console.log(this.noTips)
    },
    showTemple () {
      this.$refs.selectSample.getSampleList()
      this.step = 2
      this.category = this.$store.state.app.modelNo
    },
    showRecordTab () {
      this.step = 3
      if (!getCookie('noTips') || getCookie('noTips') !== '1') {
        //this.modal1 = true
      }
      this.$refs['energyIndicators' + this.category].fillDefaultData()
      var box = document.getElementsByClassName("ivu-card-head")[0]
      if (box) {
        box.style.display='none'
      }
    }
  },
  computed: {
    ...mapGetters([
      'pageType',
      'recordno'
    ]),
    titleValue () {
      let v = '“主型号“'
      if (this.pageType === "extend"){
        v = '“扩展“'
      }
      if (this.pageType === "update"){
        v = '“变更“'
      }
      return "新增" + v + "备案"
    }
  }
}
</script>
<style lang="less" scoped>
.ivu-radio-large .ivu-radio-inner{
  top:20px!important;
  left:62px!important;
}
.ivu-icon-ios-help-circle-outline:before{
  content:"\F446";
}
</style>
