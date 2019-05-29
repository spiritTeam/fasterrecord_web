import axios from 'axios'

export const XhandleFormatError = (file, id, that) => {
  that.uploadParam['filePath' + id] = ''
  that.filesArr.splice(that.filesArr.indexOf(id), 1)
  that.$Notice.warning({
    title: '上传文件，类型错误',
    desc: '请选择正确的类型文件'
  });
}
export const XfileHandleBeforeUpload = (file, id, that) => {
  let _this = that
  let fileObj = {}
  _this.uploadParam['uploadFileList' + id] = []
  const Fname = file.name
  const seat = Fname.lastIndexOf('.')
  const extension = Fname.substring(seat).toLowerCase()
  const gname = _this.getRandom(extension)
  fileObj.ec_attach_id = id
  fileObj.ec_attach_originalname = file.name
  fileObj.ec_attach_file = gname
  Object.defineProperty(file, 'name', {
    writable: true,
    value: gname
  })
  return new Promise(function (resolve, reject) {
    axios.get('/oss/token.do').then(res => {
      if (_this.uploadParam['uploadFileList' + id].length > 0) {
        _this.$Notice.warning({
          title: '最多上传1个附件'
        })
        return false
      }
      let reader = new FileReader()
      reader.readAsDataURL(file)
      reader.onloadend = (e) => {
        file.url = reader.result
        //console.log(_this.uploadParam['uploadFileList'+id])
        _this.uploadParam['uploadFileList' + id].push(file)
      }
      getImgPath(res.data.dir, _this)
      _this.uploadParam['fileData' + id]['key'] = _this.dir + file.name
      _this.uploadParam['fileData' + id]['policy'] = res.data.policy
      _this.uploadParam['fileData' + id]['OSSAccessKeyId'] = res.data.accessid
      _this.uploadParam['fileData' + id]['success_action_status'] = '200'
      _this.uploadParam['fileData' + id]['signature'] = res.data.signature
      _this.uploadUrl = res.data.host
      fileObj.ec_attach_path = _this.uploadParam['filePath' + id] = res.data.host + _this.dir + file.name
      _this.filesArr.push(fileObj)
      resolve()
    })
  })
}
export const getImgPath = (dir, that) => {
  let imgDir = dir
  let nowDate = new Date()
  let year = nowDate.getFullYear()
  let month = nowDate.getMonth() > 8 ? (nowDate.getMonth() + 1) : '0' + (nowDate.getMonth() + 1)
  let date = nowDate.getDate() > 9 ? nowDate.getDate() : '0' + nowDate.getDate()
  imgDir += year + '/' + month + '/' + date + '/'
  that.dir = imgDir
}

// /* 数据来源  扩展备案 */
export const XfillExtendData = (params, that) => {
  // let that = this
  let data = params.data;
  let mark = params.marking;
  that.$store.commit('setPtId', mark.ptid)
  that.$store.commit('setPltId', mark.pltId)
  that.$store.commit('setRid', mark.ec_labreport_id)
  that.$store.commit('setBarcode', mark.ec_labreport_no)
  that.$store.commit('setLabName', mark.ec_labname)
  that.formRecord.id = mark.id
  for (let i in data) {
    if (that.formRecord[i] != null && that.formRecord[i].constructor === Array) {
      that.formRecord[i] = []
      data[i].split(';').forEach((v) => {
        that.formRecord[i].push(v)
      })
    } else if (i === that.thisDateCV) {
      if (data[i] != undefined) that.formRecord[i] = that.formatDate(data[i]);
    } else {
      that.formRecord[i] = data[i]
    }
  }
}

/* 数据来源 草稿箱 */
export const XfillDraftData = (params, that) => {
  // let that = this
  let data = params.data;
  let mark = params.marking;
  let attachList = that.filesArr = params.attachList;
  attachList.forEach((item, idx) => {
    if (item.ec_attach_id == 25) {
      that.$store.commit('setPltPic', item.ec_attach_path)
    } else {
      that.uploadParam['filePath' + item.ec_attach_id] = item.ec_attach_path;
    }
  })

  that.$store.commit('setDefaultData', params.lab.params)
  that.$store.commit('setPtId', mark.ptid)
  that.$store.commit('setPltId', mark.pltId)
  that.$store.commit('setRid', mark.ec_labreport_id)
  that.$store.commit('setBarcode', mark.ec_labreport_no)
  that.$store.commit('setLabName', mark.ec_labname)
  that.formRecord.id = mark.id
  for (let i in data) {
    if (that.formRecord[i] != null && that.formRecord[i].constructor === Array) {
      that.formRecord[i] = []
      data[i].split(';').forEach((v) => {
        that.formRecord[i].push(v)
      })
    } else if (i === that.thisDateCV) {
      //this.$store.commit('setDateInit', data[i])
      if (data[i] != undefined) {
        that.formRecord[i] = that.formatDate(data[i]);
      }
    } else {
      that.formRecord[i] = data[i]
    }
  }
}
/* 数据来源 新增备案 */
export const XfillDefaultData = (params, that) => {
  // let that = this;
  that.formRecord.c200 = that.$store.state.app.gb
  that.$store.state.app.defaultData.forEach((e) => {
    if (that.formRecord[e.recId] != null && that.formRecord[e.recId].constructor === Array) {
      that.formRecord[e.recId] = []
      if (e.labValue === '/' || e.labValue == null || e.labValue == '') {
        return
      }
      that.formRecord[e.recId] = e.labValue.replace(/\s+/g, '').split(';')
    } else {
      if (e.labValue === '/' || e.labValue == null || e.labValue == '') {
        that.formRecord[e.recId] = ''
      } else {
        let labVal = e.labValue.replace(/（/g, '(').replace(/）/g, ')')
        if (e.recId === that.thisLevelCV) {
          if (parseInt(labVal) !== 1 && parseInt(labVal) !== 2 && parseInt(labVal) !== 3 && parseInt(labVal) !== 4 && parseInt(labVal) !== 5) {
            that.formRecord[e.recId] = '1'
          } else {
            that.formRecord[e.recId] = parseInt(labVal).toString();
          }
        } else if (e.recId === that.thisDateCV && isNaN(labVal)) {
          that.formRecord[e.recId] = new Date()
        } else {
          that.formRecord[e.recId] = labVal
        }
      }
    }
  })
}
export const XshowConfirm = (that) => {
  let _this = that
  let pageType = _this.$store.state.app.pageType;
  if (_this.uploadParam.filePath24 === '') {
    _this.$Message.warning('请上传产品正面图片！')
    return false
  }
  if (_this.uploadParam.filePath76 === '') {
    _this.$Message.warning('请上传铭牌图片！')
    return false
  }
  if (pageType === "extend" || pageType === "update") {
    if (_this.formRecord.ec_master_kuozhan_text === '') {
      let text = pageType === "extend" ? '扩展' : '变更'
      _this.$Message.warning('请填写' + text + '申请书！')
    } else {
      _this.modal1 = true;
    }
    return;
  }
  _this.$refs['formRecord'].validate((valid) => {
    if (valid) {
      if (_this.confirmData.join('') == 1) {
        _this.boolFlag = XdiffRecord(_this.$store.state.app.defaultData, _this.formRecord, _this);
        _this.modal1 = true
      } else {
        _this.$Message.warning('请勾选我已确认以上数据填写无误选项')
      }
    }
  })
}
export const XdiffRecord = (orgin, target, that) => {
  let newArr = []
  for (let i = 0; i < orgin.length; i++) {
    let v = orgin[i];
    if (target.hasOwnProperty(v.recId)) {
      if (Object.prototype.toString.call(target[v.recId]) == '[object Array]') {
        let oldarr = (v.labValue).split(';').sort().join(';'),
          newarr = (target[v.recId]).sort().join(";");
        if (oldarr != newarr) {
          v.updateVal = target[v.recId];
          newArr.push(v);
        }
      } else {
        if (v.labValue != target[v.recId]) {
          if (v.recId == that.thisLevelCV) {
            if (parseInt(v.labValue) != target[v.recId]) {
              v.updateVal = target[v.recId] + '级';
              newArr.push(v);
            }
          } else {
            v.updateVal = target[v.recId]
            newArr.push(v);
          }
        }
      }
    }
  }
  return newArr;
}

export const XsubmitRecord = (that) => {
  let _this = that
  let pageType = _this.$store.state.app.pageType;
  _this.formRecord[_this.thisDateCV] = _this.formatDate(_this.formRecord[_this.thisDateCV])
  _this.formRecord.ptid = _this.$store.state.app.ptId
  _this.formRecord.pltId = _this.$store.state.app.pltId
  _this.formRecord.record_type = 0
  _this.formRecord.ec_labreport_id = _this.$store.state.app.rid
  _this.formRecord.ec_labreport_no = _this.$store.state.app.barcode
  _this.formRecord.ec_labname = _this.$store.state.app.labName
  let file25 = {
    ec_attach_id: '25',
    ec_attach_originalname: '',
    ec_attach_file: '',
    ec_attach_path: _this.$store.state.app.pltPic
  };
  let flag = false
  _this.filesArr.forEach(item => {
    if (item.ec_attach_id == 25) {
      flag = true
    }
  })
  if (!flag) {
    _this.filesArr.push(file25)
  }
  _this.formRecord.attach_list = JSON.stringify(_this.filesArr)
  _this.formRecord.id = _this.$store.state.app.updateId || 0
  if (pageType === "extend" || pageType === "update") {
    let submitUrl = pageType === 'extend' ? '/marking/saveExpand.do' : '/marking/saveChange.do';
    axios({
      url: submitUrl,
      method: 'POST',
      data: _this.formRecord,
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
      if (res.data.result_code === '1') {
        //let txt = _this.$store.state.app.pltId === 244 ? '请自行上传标识图' : '备案正在自动公告中。'
        _this.$Modal.success({
          title: '提交成功',
          content: '<p>备案数据已经提交成功！</p>',
          okText: '查看详情',
          onOk() {
            _this.$router.push('/queryRecord')
          }
        })
      } else {
        _this.$Message.warning(res.data.message)
        //_this.submitDisabled = false
      }
    })
  } else {
    axios({
      url: '/marking/save.do',
      method: 'POST',
      data: _this.formRecord,
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
      if (res.data.result_code === '1') {
        let txt = _this.$store.state.app.pltId === 244 ? '请自行上传标识图' : '备案正在自动公告中。'
        _this.$Modal.success({
          title: '提交成功',
          content: '<p>备案数据已经提交成功！</p><p>' + txt + '</p><p>完成操作后将同步到备案系统</p>',
          okText: '查看详情',
          onOk() {
            _this.$router.push('/queryRecord')
          }
        })
      } else {
        _this.$Message.warning(res.data.message)
        _this.submitDisabled = false
      }
    })
  }
}

/* 保存草稿箱 */
export const XsaveRecord = (that) => {
  let _this = that
  _this.saveDisabled = true
  _this.formRecord[_this.thisDateCV] = _this.formatDate(_this.formRecord[_this.thisDateCV])
  _this.formRecord.ptid = _this.$store.state.app.ptId
  _this.formRecord.pltId = _this.$store.state.app.pltId
  _this.formRecord.record_type = 0
  _this.formRecord.ec_labreport_id = _this.$store.state.app.rid
  _this.formRecord.ec_labreport_no = _this.$store.state.app.barcode
  _this.formRecord.ec_labname = _this.$store.state.app.labName
  var file25 = {
    ec_attach_id: '25',
    ec_attach_originalname: '',
    ec_attach_file: '',
    ec_attach_path: _this.$store.state.app.pltPic
  }
  _this.filesArr.push(file25)
  _this.formRecord.attach_list = JSON.stringify(_this.filesArr)

  axios({
    url: '/marking/saveDraft.do',
    method: 'POST',
    data: _this.formRecord,
    // 只适用于 POST,PUT,PATCH，transformRequest`
    //允许在向服务器发送前，修改请求数据。后面数组中的函数必须返回一个字符串，
    //或 ArrayBuffer，或 Stream
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
  })
    .then(res => {
      if (res.data.result_code === '1') {
        _this.$Modal.success({
          title: '保存成功',
          content: '<p>备案数据已经保存成功！</p>',
          okText: '查看详情',
          onOk() {
            _this.$router.push('/draftBox')
          }
        })
      } else {
        _this.$Message.warning(res.data.message)
        _this.saveDisabled = false
      }
    })
}

export const XformatDate = (d) => {
  let date = new Date(d)
  let year = date.getFullYear()
  let month = date.getMonth() > 8 ? date.getMonth() + 1 : '0' + (date.getMonth() + 1)
  let day = date.getDate() > 9 ? date.getDate() : '0' + date.getDate()
  return year + '-' + month + '-' + day
}

var integer = /^[1-9][0-9]*$/;
var number = /-?(0|([1-9]\d*))\.?\d+/;
var decimal1 = /^(([1-9]{1}\d*)|(0{1}))(\.\d{1})$/
var decimal2 = /^(([1-9]{1}\d*)|(0{1}))(\.\d{2})$/
var decimal3 = /^(([1-9]{1}\d*)|(0{1}))(\.\d{3})$/
var atLeast1 = /^[0-9]\+?(\d*\.\d{1,5})$/;
var atLeast2 = /^[0-9]\+?(\d*\.\d{2,5})$/;
var significantDigits2 = /^[1-9]\d{1}$|^[1-9]\.\d{1}$|^0\.0*[0-9]{2}$/
var significantDigits3 = /^[1-9]\.?\d{2}$|^[1-9]{2}\.\d{1}$|^0\.0*[0-9]{3}$/

// 空校验规则
export const check = (rule, value, callback) => {
  callback()
}
export const threeDecimals = (rule, vaule, callback) => {
  decimal3.test(vaule) ? callback() : callback('三位小数');
}
export const twoDecimals = (rule, vaule, callback) => {
  decimal2.test(vaule) ? callback() : callback('两位小数');
}
export const oneDecimals = (rule, vaule, callback) => {
  decimal1.test(vaule) ? callback() : callback('一位小数');
}
export const significantDigits22 = (rule, vaule, callback) => {
  significantDigits2.test(vaule) ? callback() : callback('两位有效数字');
}
export const significantDigits33 = (rule, vaule, callback) => {
  significantDigits3.test(vaule) ? callback() : callback('三位有效数字');
}
export const atLeastOneDecimals = (rule, vaule, callback) => {
  atLeast1.test(vaule) ? callback() : callback('至少一位小数');
}
export const atLeastTwoDecimals = (rule, vaule, callback) => {
  atLeast2.test(vaule) ? callback() : callback('至少两位小数');
}
export const isInteger = (rule, vaule, callback) => {
  integer.test(vaule) ? callback() : callback('整数');
}
export const isNumber = (rule, vaule, callback) => {
  number.test(vaule) ? callback() : callback('请输入数字');
}
