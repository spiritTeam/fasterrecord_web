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
  let fileObj = {}
  that.uploadParam['uploadFileList' + id] = []
  const Fname = file.name
  const seat = Fname.lastIndexOf('.')
  const extension = Fname.substring(seat).toLowerCase()
  const gname = that.getRandom(extension)
  fileObj.ec_attach_id = id
  fileObj.ec_attach_originalname = file.name
  fileObj.ec_attach_file = gname
  Object.defineProperty(file, 'name', {
    writable: true,
    value: gname
  })
  return new Promise(function (resolve, reject) {
    axios.get('/oss/token.do').then(res => {
      if (that.uploadParam['uploadFileList' + id].length > 0) {
        that.$Notice.warning({
          title: '最多上传1个附件'
        })
        return false
      }
      let reader = new FileReader()
      reader.readAsDataURL(file)
      reader.onloadend = (e) => {
        file.url = reader.result
        that.uploadParam['uploadFileList' + id].push(file)
      }
      getImgPath(res.data.dir, that)
      that.uploadParam['fileData' + id]['key'] = that.dir + file.name
      that.uploadParam['fileData' + id]['policy'] = res.data.policy
      that.uploadParam['fileData' + id]['OSSAccessKeyId'] = res.data.accessid
      that.uploadParam['fileData' + id]['success_action_status'] = '200'
      that.uploadParam['fileData' + id]['signature'] = res.data.signature
      that.uploadUrl = res.data.host
      fileObj.ec_attach_path = that.uploadParam['filePath' + id] = res.data.host + that.dir + file.name
      that.filesArr.push(fileObj)
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
      if (data[i] != undefined) that.formRecord[i] = that.formatDate(parseInt(data[i]))
      //console.log(that)
    } else {
      that.formRecord[i] = data[i]
    }
  }
}

/* 数据来源 草稿箱 */
export const XfillDraftData = (params, that) => {
  let data = params.data;
  let mark = params.marking;
  let attachList = that.filesArr = params.attachList;
  if (attachList && attachList.length > 0) {
    attachList.forEach((item, idx) => {
      if (item.ec_attach_id == 25) {
        that.$store.commit('setPltPic', item.ec_attach_path)
      } else {
        that.uploadParam['filePath' + item.ec_attach_id] = item.ec_attach_path;
      }
    })
  }

  if (params.lab) {
    that.$store.commit('setDefaultData', params.lab.params)
  }
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
      if (data[i] != undefined) that.formRecord[i] = that.formatDate(parseInt(data[i]));
    } else {
      that.formRecord[i] = data[i]
    }
  }

}
/* 数据来源 新增备案 */
export const XfillDefaultData = (params, that) => {
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
        } else if(e.recId==='c1' || e.recId==='c2'|| e.recId==='c3'){
          that.formRecord[e.recId] =e.labValue
        }else {
          that.formRecord[e.recId] = labVal
        }
      }
    }
  })
}

export const XshowConfirm = (that) => {
  // if (that.$store.state.app.requiredStr){
  //   console.log(that.$store.state.app.requiredStr)
  //   that.$store.state.app.requiredStr.substring(0,that.$store.state.app.requiredStr.length - 1).split(",").forEach((e) => {
  //     if (!that.formRecord[e]) {
  //       // that.$Message.warning(e + " 不能为空" + that.formRecord[e])
  //       console.log("值为" + e + " 不能为空" + that.formRecord[e])
  //       return false
  //     }
  //   })
  // }
  let pageType = that.pageType;
  if (that.uploadParam.filePath24 === '') {
    that.$Message.warning('请上传产品正面图片！')
    return false
  }
  if (that.uploadParam.filePath76 === '') {
    that.$Message.warning('请上传铭牌图片！')
    return false
  }
  if (pageType === "extend" || pageType === "update") {
    if (that.formRecord.ec_master_kuozhan_text === '') {
      let text = pageType === "extend" ? '扩展' : '变更'
      that.$Message.warning('请填写' + text + '申请书！')
      return false
    }
  }
  that.$refs['formRecord'].validate((valid) => {
    if (valid) {
      if (that.confirmData.join('') == 1) {
        that.boolFlag = XdiffRecord(that.$store.state.app.defaultData, that.formRecord, that);
        that.modal1 = true
      } else {
        that.$Message.warning('请勾选我已确认以上数据填写无误选项')
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
  let pageType = that.pageType;
  that.formRecord[that.thisDateCV] = that.formatDate(that.formRecord[that.thisDateCV])
  that.formRecord.ptid = that.$store.state.app.ptId
  that.formRecord.pltId = that.$store.state.app.pltId
  that.formRecord.record_type = 0
  that.formRecord.ec_labreport_id = that.$store.state.app.rid
  that.formRecord.ec_labreport_no = that.$store.state.app.barcode
  that.formRecord.ec_labname = that.$store.state.app.labName
  let file25 = {
    ec_attach_id: '25',
    ec_attach_originalname: '',
    ec_attach_file: '',
    ec_attach_path: that.$store.state.app.pltPic
  };
  let flag = false
  that.filesArr.forEach(item => {
    if (item.ec_attach_id == 25) {
      flag = true
    }
  })
  if (!flag) {
    that.filesArr.push(file25)
  }
  that.formRecord.attach_list = JSON.stringify(that.filesArr)
  that.formRecord.id = that.$store.state.app.updateId || 0
  if (pageType === "extend" || pageType === "update") {
    let submitUrl = pageType === 'extend' ? '/marking/saveExpand.do' : '/marking/saveChange.do';
    axios({
      url: submitUrl,
      method: 'POST',
      data: that.formRecord,
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
        that.$Modal.success({
          title: '提交成功',
          content: '<p>备案数据已经提交成功！</p>',
          okText: '查看详情',
          onOk() {
            that.$router.push('/queryRecord')
          }
        })
      } else {
        that.$Message.warning(res.data.message)
      }
    })
  } else {
    axios({
      url: '/marking/save.do',
      method: 'POST',
      data: that.formRecord,
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
        let txt = that.$store.state.app.pltId === 244 ? '请自行上传标识图' : '备案正在自动公告中。'
        that.$Modal.success({
          title: '提交成功',
          content: '<p>备案数据已经提交成功！</p><p>' + txt + '</p><p>完成操作后将同步到备案系统</p>',
          okText: '查看详情',
          onOk() {
            that.$router.push('/queryRecord')
          }
        })
      } else {
        that.$Message.warning(res.data.message)
        that.submitDisabled = false
      }
    })
  }
}

/* 保存草稿箱 */
export const XsaveRecord = (that) => {
  that.saveDisabled = true
  that.formRecord[that.thisDateCV] = that.formatDate(that.formRecord[that.thisDateCV])
  that.formRecord.ptid = that.$store.state.app.ptId
  that.formRecord.pltId = that.$store.state.app.pltId
  that.formRecord.record_type = 0
  that.formRecord.ec_labreport_id = that.$store.state.app.rid
  that.formRecord.ec_labreport_no = that.$store.state.app.barcode
  that.formRecord.ec_labname = that.$store.state.app.labName
  var file25 = {
    ec_attach_id: '25',
    ec_attach_originalname: '',
    ec_attach_file: '',
    ec_attach_path: that.$store.state.app.pltPic
  }
  that.filesArr.push(file25)
  that.formRecord.attach_list = JSON.stringify(that.filesArr)

  axios({
    url: '/marking/saveDraft.do',
    method: 'POST',
    data: that.formRecord,
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
        that.$Modal.success({
          title: '保存成功',
          content: '<p>备案数据已经保存成功！</p>',
          okText: '查看详情',
          onOk() {
            that.$router.push('/draftBox')
          }
        })
      } else {
        that.$Message.warning(res.data.message)
        that.saveDisabled = false
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

export const XviewClose= (that) => {
  that.$router.replace({
    name:'queryRecord'
  })
}

var integer = /^[1-9][0-9]*$/;
var number = /^[+-]?\d+(\.\d+)?$/;
var decimal1 = /^(([1-9]{1}\d*)|(0{1}))(\.\d{1})$/
var decimal2 = /^(([1-9]{1}\d*)|(0{1}))(\.\d{2})$/
var decimal3 = /^(([1-9]{1}\d*)|(0{1}))(\.\d{3})$/
var atLeast1 = /^[0-9]\+?(\d*\.\d{1,5})$/;
var atLeast2 = /^[0-9]\+?(\d*\.\d{2,5})$/;
var inputNumber = /^[0-9]\d*$/ //不包括0
var numberOr11 = /^[0-9]+([.]{1}[0-9]{1,1})?$/
var decimalOr22 = /^[0-9]+[.]{1}[0-9]{1,2}?$/

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
  let significantDigits2 = /^[1-9]\d{1}$|^[1-9]\.\d{1}$|^0\.0*[0-9]{2}$/
  significantDigits2.test(vaule) ? callback() : callback('两位有效数字');
}
export const significantDigits33 = (rule, vaule, callback) => {
  let tel = /^[1-9]\.?\d{2}$|^[1-9]{2}\.\d{1}$|^0\.0*[0-9]{3}$/
  tel.test(vaule) ? callback() : callback('三位有效数字');
}

export const numberCheck = (rule, vaule, callback) => {//整数中包含0
  inputNumber.test(vaule) ? callback() : callback('请输入整数');
}
export const atLeastOneDecimals = (rule, vaule, callback) => {
  atLeast1.test(vaule) ? callback() : callback('至少一位小数');
}
export const atLeastTwoDecimals = (rule, vaule, callback) => {
  atLeast2.test(vaule) ? callback() : callback('至少两位小数');
}
export const atLeastThreeDecimals = (rule, vaule, callback) => {
  var atLeast3=/^[0-9]\+?(\d*\.\d{3,})$/;
  atLeast3.test(vaule) ? callback() : callback('至少三位小数');
}
export const atLeastFourDecimals = (rule, vaule, callback) => {
  var atLeast3=/^[0-9]\+?(\d*\.\d{4,})$/;
  atLeast3.test(vaule) ? callback() : callback('至少四位小数');
}
export const isInteger = (rule, vaule, callback) => {//整数中不包含0,提示整数
  integer.test(vaule) ? callback() : callback('整数');
}
export const isIntegerNotZero = (rule, vaule, callback) => {//整数中不包含0，提示请输入整数
  integer.test(vaule) ? callback() : callback('请输入整数');
}
export const isNumber = (rule, vaule, callback) => {
  number.test(vaule) ? callback() : callback('请输入数字');
}
export const numberOr1 = (rule, vaule, callback) => {
  numberOr11.test(vaule) ? callback() : callback('整数或一位小数');
}
export const decimalOr2 = (rule, vaule, callback) => {
  decimalOr22.test(vaule) ? callback() : callback('一位小数或两位小数');
}
export const numberOrn = (rule, vaule, callback) => {
  let tel = /^[0-9]+([.]{1}[0-9]{1,5})?$/;
  tel.test(vaule) ? callback() : callback('整数或小数');
}
