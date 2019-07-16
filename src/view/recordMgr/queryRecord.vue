<template>
  <Card>
    <p slot="title">备案查询</p>
    <Form ref="formQuery" :model="formQuery" inline>
      <FormItem>
        <Select v-model="formQuery.category_id" placeholder="选择品类" style="width:300px;">
          <Option v-for="item in categoryList" :value="item.ec_model_no" :key="item.ec_model_no">{{ item.ec_model_title }}</Option>
        </Select>
      </FormItem>
      <FormItem>
        <Input type="text" v-model="formQuery.model_name" placeholder="产品型号"></Input>
      </FormItem>
      <FormItem>
        <Input type="text" v-model="formQuery.bar_code" placeholder="实验室报告条码"></Input>
      </FormItem>
       <FormItem>
        <Input type="text" v-model="formQuery.record_no" placeholder="备案号"></Input>
      </FormItem>
      <FormItem>
        <Button type="primary" @click="searchFun">搜索</Button>
        <Button type="primary" @click="clearFun">清空</Button>
      </FormItem>
    </Form>
    <Table border class="tableList" :columns="columns1" :data="recordData"></Table>
    <Page :total="total" :page-size="formQuery.pageSize"
      :current="formQuery.pageNum"
      @on-change="changeList"
      style="margin-top:10px; text-align: right">
    </Page>
    <Modal
      v-model="modal1"
      title="上传标识图">
      <Upload
        :format="['png']"
        :before-upload="fileHandleBeforeUpload"
        :data="uploadParam.fileData"
        :on-success="getFile"
        style="display:inline-block;"
        :on-format-error="handleFormatError"
        :action="uploadUrl">

        <Button icon="ios-cloud-upload-outline" type="primary">上传</Button>
        <!-- <Icon type="ios-checkmark" v-show="checkmark" /> -->
      </Upload>
    </Modal>
    <Modal v-model="modal2" title="撤销申请" @on-ok="submitWorkorder" ok-text="提交">
        <Input type="textarea" :rows="3" placeholder="撤销申请" v-model="qus"></Input>
    </Modal>
    <Modal v-model="modal3" width='615' title="备案证明" >
        <img :src=' zmImgUrl' width="583" height="728" />
    </Modal>
  </Card>
</template>
<script>
import axios from 'axios'

export default {

  data () {
    const downLoadCode = (h, params) => h('Button', {
      props: {
        type: 'primary',
        size: 'small',
        long: 'long'
      },
      style: {
        margin: '1px'
      },
      on: {
        click: () => {
          this.downloadQrcode(params.row.id)
        }
      }
    }, '下载二维码')
    const uploadBtn = (h, params) => h('Button', {
      props: {
        type: 'primary',
        size: 'small',
        long: 'long'
      },
      style: {
        margin: '1px'
      },
      on: {
        click: () => {
          this.uploadPic(params.row.id)
        }
      }
    }, '标识图上传')
    const downLoadRecord = (h, params) => h('Button', {
      props: {
        type: 'primary',
        size: 'small',
        long: 'long'
      },
      style: {
        margin: '1px'
      },
      on: {
        click: () => {
          this.downloadElImg(params.row.id)
        }
      }
    }, '下载能效标识图')
    const extendBtn = (h, params) => h('Button', {
      props: {
        type: 'primary',
        size: 'small',
        long: 'long'
      },
      style: {
        margin: '1px'
      },
      on: {
        click: () => {
          this.extendHandle(params.row.id,params.row.record_no)
        }
      }
    }, '扩展')
    const updateBtn = (h, params) => h('Button', {
      props: {
        type: 'primary',
        size: 'small',
        long: 'long'
      },
      style: {
        margin: '1px'
      },
      on: {
        click: () => {
          this.updateHandle(params.row.id,params.row.record_no)
        }
      }
    }, '变更')
    const viewBtn = (h, params) => h('Button', {
      props: {
        type: 'primary',
        size: 'small',
        long: 'long'
      },
      style: {
        margin: '1px'
      },
      on: {
        click: () => {
          this.viewHandle(params.row.id)
        }
      }
    }, '查看')
    const zmBtn = (h, params) => h('Button', {
      props: {
        type: 'primary',
        size: 'small',
        long: 'long'
      },
      style: {
        margin: '1px'
      },
      on: {
        click: () => {
          this.viewZmHandle(params.row.uid)
        }
      }
    }, '备案证明')
    const cancleBtn = (h, params) => h('Button', {
      props: {
        type: 'primary',
        size: 'small',
        long: 'long'
      },
      style: {
        margin: '1px'
      },
      on: {
        click: () => {
          this.cancleHandle(params.row.id)
        }
      }
    }, '撤销')

    return {
      total: 0,
      fileObj: {},
      modal1: false,
      modal2: false,
      modal3: false,
      qus: '',
      id: '',
      rowId: 0,
      zmImgUrl:'',
      uploadUrl: '',
      uploadParam: {
        fileData: {},
        uploadFileList: []
      },
      formQuery: {
        category_id: '',
        model_name: '',
        bar_code: '',
        record_no: '',
        pageSize: 10,
        pageNum: 1
      },
      categoryList: [],
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
          title: '主型号',
          key: 'p_model_name',
          align: 'center',
          render: (h, params) => {
            return h('a', {
              on: {
                click: () => {
                  this.viewHandle(params.row.p_id)
                }
              }
            }, params.row.p_model_name)
          }
        },
        {
          title: '实验室报告条码',
          key: 'bar_code',
          align: 'center'
        },
        {
          title: '备案号',
          key: 'record_no',
          align: 'center'
        },
        {
          title: '状态',
          key: 'state_name',
          align: 'center'
          // render: (h, params) => {//1草稿2标识图制作中3数据同步中10已公告
          //   return h('span', {}, params.row.state === 1 ? '草稿' :
          //                        params.row.state === 2 ? '标识图制作中' :
          //                        params.row.state === 3 ? '数据同步中' :
          //                        params.row.state === 10 ? '已公告' : '')
          // }
        },
        {
          title: '公告时间',
          key: 'publish_time',
          align: 'center'
        },
        {
          title: '备案类型',
          key: 'type_name',
          align: 'center'
        },
        {
          title: '操作',
          key: 'action',
          align: 'center',
          render: (h, params) => {
            return h('div', [
              viewBtn(h, params),
              downLoadCode(h, params),
              params.row.state === 2 ? uploadBtn(h, params) : downLoadRecord(h, params),
              params.row.kz ? extendBtn(h, params) : '',
              params.row.bg ? updateBtn(h, params) : '',
              params.row.cx ? cancleBtn(h, params) : '',
              params.row.zm ? zmBtn(h, params):''
            ])
          }
        }
      ],
      recordData: []
    }
  },
  created () {
    if (this.$route.params.pageNum) {
      this.formQuery.pageNum = this.$route.params.pageNum
    }
  },
  mounted () {
    this.getCategoryList()
    this.reqData()
  },
  methods: {
    reqData () {
      axios.get('/marking/list.do', {
        params: this.formQuery
      }).then(res => {
        this.recordData = res.data.list
        this.total = res.data.total
      })
    },
    handleFormatError () {
      this.$Notice.warning({
        title: '上传文件，类型错误',
        desc: '请选择正确的类型文件'
      })
    },
    changeList (pNum) {
      this.formQuery.pageNum = pNum
      this.reqData()
    },
    searchFun () {
      this.formQuery.pageNum = 1
      this.reqData()
    },
    clearFun () {
      this.formQuery.category_id = ''
      this.formQuery.model_name = ''
      this.formQuery.bar_code = ''
      this.formQuery.record_no = ''
      this.searchFun()
    },
    downloadQrcode (id) {
      window.open('/marking/downloadQrcode.do?id=' + id)
    },
    downloadElImg (id) {
      window.open('/marking/downloadELImg.do?id=' + id)
    },
    getRandom (type) {
      return (Math.random().toString().slice(2)) + type
    },
    getImgPath (dir) {
      let imgDir = dir
      let nowDate = new Date()
      let year = nowDate.getFullYear()
      let month = nowDate.getMonth() > 8 ? (nowDate.getMonth() + 1) : '0' + (nowDate.getMonth() + 1)
      let date = nowDate.getDate() > 9 ? nowDate.getDate() : '0' + nowDate.getDate()
      imgDir += year + '/' + month + '/' + date + '/'
      this.dir = imgDir
    },
    fileHandleBeforeUpload (file) {
      let _this = this
      this.uploadParam.uploadFileList = []
      const Fname = file.name
      const seat = Fname.lastIndexOf('.')
      const extension = Fname.substring(seat).toLowerCase()
      const gname = this.getRandom(extension)
      this.fileObj.id = this.id
      this.fileObj.ec_attach_originalname = file.name
      this.fileObj.ec_attach_file = gname
      Object.defineProperty(file, 'name', {
        writable: true,
        value: gname
      })
      return new Promise(function (resolve, reject) {
        axios.get('/oss/token.do').then(res => {
          if (_this.uploadParam.uploadFileList.length > 0) {
            _this.$Notice.warning({
              title: '最多上传1个附件'
            })
            return false
          }
          let reader = new FileReader()
          reader.readAsDataURL(file)
          reader.onloadend = (e) => {
            file.url = reader.result
            _this.uploadParam.uploadFileList.push(file)
          }
          _this.getImgPath(res.data.dir)
          console.log(_this.dir + file.name)
          _this.uploadParam.fileData['key'] = _this.dir + file.name
          _this.uploadParam.fileData['policy'] = res.data.policy
          _this.uploadParam.fileData['OSSAccessKeyId'] = res.data.accessid
          _this.uploadParam.fileData['success_action_status'] = '200'
          _this.uploadParam.fileData['signature'] = res.data.signature
          _this.uploadUrl = res.data.host
          _this.fileObj.ec_attach_path = res.data.host + _this.dir + file.name
          resolve()
        })
      })
    },
    uploadPic (id) {
      this.modal1 = true
      this.fileObj = {}
      this.id = id
    },
    getFile (res, file) {
      axios.get('/marking/uploadQrcode.do', {
        params: this.fileObj
      }).then(res => {
        if (res.data.result_code === '1') {
          this.modal1 = false
          this.pageNum = 1
          this.reqData()
        }
      })
    },
    getCategoryList () {
      axios.get('/marking/getCategoryList.do').then(res => {
        if (res.data.result_code === '1') {
          this.categoryList = res.data.data
        }
      })
    },
    cancleHandle (id) {
      this.rowId = id
      this.modal2 = true
    },
    submitWorkorder () {
      let _this = this
      if (this.qus === '') {
        this.$Message.error('撤销申请不能为空')
        return
      }
      axios.get('/marking/revoke.do', {
        params: {
          id: this.rowId,
          reason: this.qus
        }
      }).then(res => {
        if (res.data.result_code === '1') {
          _this.$Message.success(res.data.message)
          _this.qus = ''
          _this.reqData()
        } else {
          _this.$Message.warning(res.data.message)
        }
      })
    },
    viewHandle (id) {
      axios.get('/marking/getInfo.do', {
        params: {
          id: id
        }
      }).then(res => {
        if (res.data.result_code === '1') {
          this.$router.push({
            name: 'addRecord',
            params: {
              step: 3,
              type: 'view',
              id: id,
              pageNum: this.formQuery.pageNum,
              viewData: res.data
            }
          })
          this.$store.commit('setModelNo', res.data.marking.ec_model_no)
        }
      })
    },
    viewZmHandle(uid){
        this.modal3=true;

        this.zmImgUrl=`http://m3.bbqkimg.cn/cert/${uid}.jpg`;
    },
    updateHandle (id,record_no) {
      this.$store.commit('setRecordNo', record_no)
      this.$router.push({name: 'addRecord', params: {type: 'update', id: id}})
      // this.$store.commit('setPageType', 'update')
      // this.$store.commit('setUpdateId',id)
    },
    extendHandle (id,record_no) {
      axios.get('/marking/getInfoWithoutAttach.do', {
        params: {
          id: id
        }
      }).then(res => {
        if (res.data.result_code === '1') {
          this.$router.push({
            name: 'addRecord',
            params: {
              step: 3,
              type: 'extend',
              id: id,
              extendData: res.data
            }
          })
          this.$store.commit('setRecordNo', record_no)
          this.$store.commit('setModelNo', res.data.marking.ec_model_no)
          this.$store.commit('setDateInit', res.data.lab.upddate)
          // this.$store.commit('setOem',res.data.lab.oem)
        }
      })
    }
  }
}
</script>
<style>
.ivu-table-cell span{
    word-break: break-word;
}
</style>
