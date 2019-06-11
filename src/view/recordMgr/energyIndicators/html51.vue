<template>
  <div class="wrapper">
    <Form ref="formRecord" :model="formRecord" label-position="right" :rules="ruleRecord">
      <h1>电饭锅-能源效率标识备案表</h1>
      <div class="part part1">
        <Card :bordered="false">
          <h2>一、备案方声明</h2>
          <p>本组织保证如下：</p>
          <p>使用的能源效率标识信息与备案信息一致；</p>
          <p>本型号产品变更能源效率标识时，向授权机构重新备案；</p>
          <p>确保该型号产品始终符合能源效率标识使用的相关要求。</p>
        </Card>
      </div>
      <div class="part part2">
        <Card :bordered="false">
          <h2>二、能源效率标识检测信息</h2>
          <table>
            <thead>
            <tr>
              <th>实验室名称</th>
              <th>检测报告条形码</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td width="60%">
                <Input type="text" :value="$store.state.app.labName" readonly/>
              </td>
              <td>
                <Input type="text" :value="$store.state.app.barcode" readonly/>
              </td>
            </tr>
            </tbody>
          </table>
        </Card>
      </div>
      <div class="part part3">
        <Card :bordered="false">
          <h2>三、能源效率标识备案信息</h2>
          <FormItem prop="c1" label="生产者名称" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c1" placeholder="生产者名称" readonly disabled />
          </FormItem>
          <FormItem prop="c4" label="制造单位" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c4" :disabled='disabledoff' placeholder="制造单位"/>
          </FormItem>
          <FormItem prop="c28" label="备案方" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c28" :disabled='disabledoff' placeholder="备案方"/>
          </FormItem>
          <FormItem prop="c3" label="产品规格型号" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c3" :disabled='!disabledoff' placeholder="产品规格型号"/>
          </FormItem>
          <FormItem prop="c2" label="商标" style="width:100%" :label-width="180">
            <Input type="text" v-model="formRecord.c2" :disabled='disabledoff' placeholder="商标"/>
          </FormItem>
          <FormItem prop="c200" label="依据国家标准" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c200" placeholder="依据国家标准" readonly disabled/>
          </FormItem>
          <FormItem prop="c29" label="能效等级" style="width:100%;" :label-width="180">
            <RadioGroup v-model="formRecord.c29">
              <Radio label="1" :disabled='disabledoff'>1级</Radio>
              <Radio label="2" :disabled='disabledoff'>2级</Radio>
              <Radio label="3" :disabled='disabledoff'>3级</Radio>
              <Radio label="4" :disabled='disabledoff'>4级</Radio>
              <Radio label="5" :disabled='disabledoff'>5级</Radio>
            </RadioGroup>
          </FormItem>
          <table id="table3">
            <tr>
              <td align="center">热效率值（%）</td>
              <td>
                <FormItem prop="c5" label="标称值:" style="width:100%;" :label-width="70">
                  <Input type="text" v-model="formRecord.c5" :disabled='disabledoff' placeholder="整数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c30" label="实测值:" style="width:100%;" :label-width="70">
                  <Input type="text" v-model="formRecord.c30" :disabled='disabledoff' placeholder="至少一位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c6" label="备注:" style="width:100%;" :label-width="70">
                  <Input type="text" v-model="formRecord.c6" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center">加热方式</td>
              <td colspan="3">
                <FormItem prop="c15">
                  <RadioGroup v-model="formRecord.c15">
                    <Radio label="电热元件式" :disabled='disabledoff'>电热元件式</Radio>
                    <Radio label="电磁感应式" :disabled='disabledoff'>电磁感应式</Radio>
                    <Radio label="其他" :disabled='disabledoff'>其他</Radio>
                  </RadioGroup>
                  <FormItem prop="c16">
                    <Input type="text" v-model="formRecord.c16" style="width:200px;" :disabled='disabledoff'/>
                  </FormItem>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center">功能</td>
              <td colspan="3">
                <FormItem prop="c23">
                  <RadioGroup v-model="formRecord.c23">
                    <Radio label="待机功能" :disabled='disabledoff'>待机功能</Radio>
                    <Radio label="保温功能" :disabled='disabledoff'>保温功能</Radio>
                    <Radio label="其他" :disabled='disabledoff'>其他</Radio>
                  </RadioGroup>
                </FormItem>
                <FormItem prop="c24">
                  <Input type="text" v-model="formRecord.c24" style="width:200px;" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center">通讯协议功能</td>
              <td colspan="3">
                <FormItem prop="c90">
                  <RadioGroup v-model="formRecord.c90">
                    <Radio label="WIFI" :disabled='disabledoff'>WIFI</Radio>
                    <Radio label="蓝牙" :disabled='disabledoff'>蓝牙</Radio>
                    <Radio label="其他" :disabled='disabledoff'>其他</Radio>
                    <Input type="text" v-model="formRecord.c91" style="width:200px;" :disabled='disabledoff'/>
                    <Radio label="无" :disabled='disabledoff'>无</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center">待机功率（W）</td>
              <td>
                <FormItem prop="c7" label="标称值:" style="width:100%;" :label-width="70">
                  <Input type="text" v-model="formRecord.c7" :disabled='disabledoff' placeholder="一位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c32" label="实测值:" style="width:100%;" :label-width="70">
                  <Input type="text" v-model="formRecord.c32" :disabled='disabledoff' placeholder="至少两位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c8" label="备注:" style="width:100%;" :label-width="70">
                  <Input type="text" v-model="formRecord.c8" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center">保温能耗（W·h）</td>
              <td>
                <FormItem prop="c9" label="标称值:" style="width:100%;" :label-width="70">
                  <Input type="text" v-model="formRecord.c9" :disabled='disabledoff' placeholder="整数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c33" label="实测值:" style="width:100%;" :label-width="70">
                  <Input type="text" v-model="formRecord.c33" :disabled='disabledoff' placeholder="至少一位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c10" label="备注:" style="width:100%;" :label-width="70">
                  <Input type="text" v-model="formRecord.c10" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center">内锅材质（金属或非金属）</td>
              <td colspan="3">
                <FormItem prop="c22">
                  <RadioGroup v-model="formRecord.c22">
                    <Radio label="金属" :disabled='disabledoff'>金属</Radio>
                    <Radio label="非金属" :disabled='disabledoff'>非金属</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
          </table>
        </Card>
      </div>
      <div class="part part4">
        <Card :bordered="false">
          <h2>四、初始使用日期</h2>
          <FormItem prop="c13" label="备案标识开始使用日期" style="width:100%;">
            <DatePicker type="date" :options="dataInit" style="width: 200px" v-model="formRecord.c13" :disabled='disabledoff'></DatePicker>
          </FormItem>
        </Card>
      </div>
      <div class="part part5">
        <Card :bordered="false">
          <h2>五、其他信息</h2>
          <h3>样品描述</h3>
          <table id="table3">
            <tr>
              <td align="right"><span style="color:red">*</span>电源类型</td>
              <td>
                <FormItem prop="c14" style="width:100%;" :label-width="10">
                  <RadioGroup v-model="formRecord.c14">
                    <Radio label="交流" :disabled='disabledoff'>交流</Radio>
                    <Radio label="直流" :disabled='disabledoff'>直流</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td align="right"><span style="color:red">*</span>附加保温元件</td>
              <td>
                <FormItem prop="c17" style="width:100%;" :label-width="10">
                  <RadioGroup v-model="formRecord.c17">
                    <Radio label="有" :disabled='disabledoff'>有</Radio>
                    <Radio label="无" :disabled='disabledoff'>无</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span style="color:red">*</span>温控器</td>
              <td>
                <FormItem prop="c18" style="width:100%;" :label-width="10">
                  <RadioGroup v-model="formRecord.c18">
                    <Radio label="有" :disabled='disabledoff'>有</Radio>
                    <Radio label="无" :disabled='disabledoff'>无</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td align="right"><span style="color:red">*</span>热断路器</td>
              <td>
                <FormItem prop="c19" style="width:100%;" :label-width="10">
                  <RadioGroup v-model="formRecord.c19">
                    <Radio label="有" :disabled='disabledoff'>有</Radio>
                    <Radio label="无" :disabled='disabledoff'>无</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span style="color:red">*</span>程序控制</td>
              <td>
                <FormItem prop="c20" style="width:100%;" :label-width="10">
                  <RadioGroup v-model="formRecord.c20">
                    <Radio label="有" :disabled='disabledoff'>有</Radio>
                    <Radio label="无" :disabled='disabledoff'>无</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td align="right"><span style="color:red">*</span>控制方式</td>
              <td>
                <FormItem prop="c21" style="width:100%;" :label-width="10">
                  <RadioGroup v-model="formRecord.c21">
                    <Radio label="机械式" :disabled='disabledoff'>机械式</Radio>
                    <Radio label="电子式" :disabled='disabledoff'>电子式</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span style="color:red">*</span>额定功率（W）</td>
              <td>
                <FormItem prop="c25" :label-width="10">
                    <Input type="text" v-model="formRecord.c25" style="width:200px;" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td align="right"><span style="color:red">*</span>额定容积（L）</td>
              <td>
                <FormItem prop="c26" :label-width="10">
                    <Input type="text" v-model="formRecord.c26" style="width:200px;" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span style="color:red">*</span>额定电压（V）</td>
              <td>
                <FormItem prop="c34" :label-width="10">
                    <Input type="text" v-model="formRecord.c34" style="width:200px;" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td align="right"><span style="color:red">*</span>额定频率（Hz）</td>
              <td>
                <FormItem prop="c35" :label-width="10">
                    <Input type="text" v-model="formRecord.c35" style="width:200px;" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span style="color:red">*</span>外形尺寸（长×宽×高）<br/>（mm×mm×mm）</td>
              <td colspan="3">
                <FormItem prop="c27" style="width:100px;" :label-width="10">
                  <Input type="text" v-model="formRecord.c27" :disabled='disabledoff'/>
                </FormItem>
                <FormItem :label-width="10"><b>×</b></FormItem>
                <FormItem prop="c37" style="width:100px;" :label-width="10">
                  <Input type="text" v-model="formRecord.c37" :disabled='disabledoff'/>
                </FormItem>
                <FormItem :label-width="10"><b>×</b></FormItem>
                <FormItem prop="c38" style="width:100px;" :label-width="10">
                  <Input type="text" v-model="formRecord.c38" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
          </table>
        </Card>
      </div>
      <div class="part part6">
        <Card :bordered="false">
          <h2>六、产品基本配置清单</h2>
           <table id="table4">
            <tr>
              <th width="50">序号</th>
              <th width="100">名称</th>
              <th colspan="2">牌号及规格/型号/物料代码</th>
              <th colspan="2">技术参数</th>
              <th>生产者（全称）</th>
            </tr>
            <tr>
              <td align="center" rowspan="2">1</td>
              <td align="center" rowspan="2">发热盘</td>
              <td colspan="2" rowspan="2">
                <FormItem prop="c39" style="width:100%;">
                  <Input type="text" v-model="formRecord.c39" :disabled='disabledoff' />
                </FormItem>
              </td>
              <td align="center">直径（cm）</td>
              <td>
                <FormItem prop="c40" style="width:100%;">
                  <Input type="text" v-model="formRecord.c40" :disabled='disabledoff' />
                </FormItem>
              </td>
              <td rowspan="2">
                <FormItem prop="c41" style="width:100%;">
                  <Input type="text" v-model="formRecord.c41" :disabled='disabledoff' />
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center">材料</td>
              <td>
                <FormItem prop="c42" style="width:100%;">
                  <Input type="text" v-model="formRecord.c42" :disabled='disabledoff' />
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center" rowspan="2">2</td>
              <td align="center" rowspan="2">发热盘</td>
              <td colspan="2" rowspan="2">
                <FormItem prop="c43" style="width:100%;">
                  <Input type="text" v-model="formRecord.c43" :disabled='disabledoff' />
                </FormItem>
              </td>
              <td align="center">直径（cm）</td>
              <td>
                <FormItem prop="c44" style="width:100%;">
                  <Input type="text" v-model="formRecord.c44" :disabled='disabledoff' />
                </FormItem>
              </td>
              <td rowspan="2">
                <FormItem prop="c45" style="width:100%;">
                  <Input type="text" v-model="formRecord.c45" :disabled='disabledoff' />
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center">材料</td>
              <td>
                <FormItem prop="c46" style="width:100%;">
                  <Input type="text" v-model="formRecord.c46" :disabled='disabledoff' />
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center" rowspan="2">3</td>
              <td align="center" rowspan="2">发热盘</td>
              <td colspan="2" rowspan="2">
                <FormItem prop="c47" style="width:100%;">
                  <Input type="text" v-model="formRecord.c47" :disabled='disabledoff' />
                </FormItem>
              </td>
              <td align="center">直径（cm）</td>
              <td>
                <FormItem prop="c48" style="width:100%;">
                  <Input type="text" v-model="formRecord.c48" :disabled='disabledoff' />
                </FormItem>
              </td>
              <td rowspan="2">
                <FormItem prop="c49" style="width:100%;">
                  <Input type="text" v-model="formRecord.c49" :disabled='disabledoff' />
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center">材料</td>
              <td>
                <FormItem prop="c50" style="width:100%;">
                  <Input type="text" v-model="formRecord.c50" :disabled='disabledoff' />
                </FormItem>
              </td>
            </tr>
          </table>
        </Card>
      </div>
      <div class="part part7">
        <Card :bordered="false">
          <h2>七、其他认证信息</h2>
          <table>
            <tr>
              <td class="tc">3C认证证书编号</td>
              <td>
                <FormItem prop="c202">
                  <Input type="text" v-model="formRecord.c202" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
          </table>
        </Card>
      </div>
      <div class="part part8">
        <Card :bordered="false">
          <h2>八、附件部分</h2>
          <div class="application" v-if='$store.state.app.pageType && $store.state.app.pageType!="view"'>
            <span><i class="red">*</i>{{$store.state.app.pageType==="extend"?'扩展':'变更'}}申请书</span>
            <Button type="primary" @click="modal5=true">填写{{$store.state.app.pageType==="extend"?'扩展':'变更'}}申请书</Button>
            <span>{{formRecord.ec_master_kuozhan_text===''?'未填写':'已填写'}}</span>
          </div>
          <table>
            <tr>
              <td><span class="red">*</span>产品正面图片</td>
              <td>(JPG/PNG)</td>
              <td>
                <div class="lookOver" v-show="uploadParam.filePath24"><Button @click="showImg(uploadParam.filePath24)" icon="ios-glasses-outline"  type="primary">查看</Button></div>
                <div v-if='$store.state.app.pageType!="view"'>
                  <Upload
                    :show-upload-list=false
                    :format="['jpg','jpeg','png']"
                    :before-upload="file=>fileHandleBeforeUpload(file,24)"
                    :data="uploadParam.fileData24"
                    :on-success="(res,file)=>getFile(res,file,24)"
                    :on-format-error="file=>handleFormatError(file,24)"
                    style="display:inline-block;"
                    :action="uploadUrl">
                    <Button icon="ios-cloud-upload-outline" type="primary">上传</Button>
                    <Icon type="ios-checkmark" v-show="checkmark24" />
                  </Upload>
                </div>
              </td>
              <td colspan="3" v-if="pltId != 244">根据企业提交的相关能效指标，系统直接生成能效表示样本
                <Button type="primary" @click="showTemplate">查看</Button>
              </td>
              <td colspan="3" v-else>提交备案后，需企业自行上传能效标识样本</td>
            </tr>
            <tr>
              <td><span v-if='$store.state.app.oem' class="red">*</span>OEM声明</td>
              <td>(JPG/PNG)</td>
              <td>
                <div class="lookOver" v-show="uploadParam.filePath26"><Button @click="showImg(uploadParam.filePath26)" icon="ios-glasses-outline"  type="primary">查看</Button></div>
                <div v-if='$store.state.app.pageType!="view"'>
                  <Upload
                    :show-upload-list=false
                    :format="['jpg','jpeg','png']"
                    :before-upload="file=>fileHandleBeforeUpload(file,26)"
                    :data="uploadParam.fileData26"
                    :on-success="(res,file)=>getFile(res,file,26)"
                    :on-format-error="file=>handleFormatError(file,26)"
                    style="display:inline-block;"
                    :action="uploadUrl">
                    <Button icon="ios-cloud-upload-outline" type="primary">上传</Button>
                    <Icon type="ios-checkmark" v-show="checkmark26" />
                  </Upload>
                </div>
              </td>
              <td>关系证明</td>
              <td>(PDF)</td>
              <td>
                <div class="lookOver" v-show="uploadParam.filePath27"><Button @click="showImg(uploadParam.filePath27)" icon="ios-glasses-outline"  type="primary">查看</Button></div>
                <div v-if='$store.state.app.pageType!="view"'>
                  <Upload
                    :show-upload-list=false
                    :format="['pdf']"
                    :before-upload="file=>fileHandleBeforeUpload(file,27)"
                    :data="uploadParam.fileData27"
                    :on-success="(res,file)=>getFile(res,file,27)"
                    :on-format-error="file=>handleFormatError(file,27)"
                    style="display:inline-block;"
                    :action="uploadUrl">
                    <Button icon="ios-cloud-upload-outline" type="primary">上传</Button>
                    <Icon type="ios-checkmark" v-show="checkmark27" />
                  </Upload>
                </div>
              </td>
            </tr>
            <tr>
              <td>品牌使用授权书</td>
              <td>(PDF)</td>
              <td>
                <div class="lookOver" v-show="uploadParam.filePath28"><Button @click="showImg(uploadParam.filePath28)" icon="ios-glasses-outline"  type="primary">查看</Button></div>
                <div v-if='$store.state.app.pageType!="view"'>
                  <Upload
                    :show-upload-list=false
                    :format="['pdf']"
                    :before-upload="file=>fileHandleBeforeUpload(file,28)"
                    :data="uploadParam.fileData28"
                    :on-success="(res,file)=>getFile(res,file, 28)"
                    :on-format-error="file=>handleFormatError(file,28)"
                    style="display:inline-block;"
                    :action="uploadUrl">
                    <Button icon="ios-cloud-upload-outline" type="primary">上传</Button>
                    <Icon type="ios-checkmark" v-show="checkmark28" />
                  </Upload>
                </div>
              </td>
              <td>委托代理文件</td>
              <td>(PDF)</td>
              <td>
                <div class="lookOver" v-show="uploadParam.filePath29"><Button @click="showImg(uploadParam.filePath29)" icon="ios-glasses-outline"  type="primary">查看</Button></div>
                <div v-if='$store.state.app.pageType!="view"'>
                  <Upload
                    :show-upload-list=false
                    :format="['pdf']"
                    :before-upload="file=>fileHandleBeforeUpload(file,29)"
                    :data="uploadParam.fileData29"
                    :on-success="(res,file)=>getFile(res,file, 29)"
                    :on-format-error="file=>handleFormatError(file,29)"
                    style="display:inline-block;"
                    :action="uploadUrl">
                    <Button icon="ios-cloud-upload-outline" type="primary">上传</Button>
                    <Icon type="ios-checkmark" v-show="checkmark29" />
                  </Upload>
                </div>
              </td>
            </tr>
            <tr>
              <td>进口商企业信息表</td>
              <td>(PDF)</td>
              <td>
                <div class="lookOver" v-show="uploadParam.filePath30"><Button @click="showImg(uploadParam.filePath30)" icon="ios-glasses-outline"  type="primary">查看</Button></div>
                <div v-if='$store.state.app.pageType!="view"'>
                  <Upload
                    :show-upload-list=false
                    :format="['pdf']"
                    :before-upload="file=>fileHandleBeforeUpload(file,30)"
                    :data="uploadParam.fileData30"
                    :on-success="(res,file)=>getFile(res,file, 30)"
                    :on-format-error="file=>handleFormatError(file,30)"
                    style="display:inline-block;"
                    :action="uploadUrl">
                    <Button icon="ios-cloud-upload-outline" type="primary">上传</Button>
                    <Icon type="ios-checkmark" v-show="checkmark30" />
                  </Upload>
                </div>
              </td>
              <td>进口商营业执照或登记注册证明复印件</td>
              <td>(PDF)</td>
              <td>
                <div class="lookOver" v-show="uploadParam.filePath31"><Button @click="showImg(uploadParam.filePath31)" icon="ios-glasses-outline"  type="primary">查看</Button></div>
                <div v-if='$store.state.app.pageType!="view"'>
                  <Upload
                    :show-upload-list=false
                    :format="['pdf']"
                    :before-upload="file=>fileHandleBeforeUpload(file,31)"
                    :data="uploadParam.fileData31"
                    :on-success="(res,file)=>getFile(res,file, 31)"
                    :on-format-error="file=>handleFormatError(file,31)"
                    style="display:inline-block;"
                    :action="uploadUrl">
                    <Button icon="ios-cloud-upload-outline" type="primary">上传</Button>
                    <Icon type="ios-checkmark" v-show="checkmark31" />
                  </Upload>
                </div>
              </td>
            </tr>
            <tr>
              <td>进口商与境外生产者订立的相关合同副本</td>
              <td>(PDF)</td>
              <td>
                <div class="lookOver" v-show="uploadParam.filePath32"><Button @click="showImg(uploadParam.filePath32)" icon="ios-glasses-outline"  type="primary">查看</Button></div>
                <div v-if='$store.state.app.pageType!="view"'>
                  <Upload
                    :show-upload-list=false
                    :format="['pdf']"
                    :before-upload="file=>fileHandleBeforeUpload(file,32)"
                    :data="uploadParam.fileData32"
                    :on-success="(res,file)=>getFile(res,file, 32)"
                    :on-format-error="file=>handleFormatError(file,32)"
                    style="display:inline-block;"
                    :action="uploadUrl">
                    <Button icon="ios-cloud-upload-outline" type="primary">上传</Button>
                    <Icon type="ios-checkmark" v-show="checkmark32" />
                  </Upload>
                </div>
              </td>
              <td><span class="red">*</span>铭牌照片</td>
              <td>(PDF/JPG/PNG)</td>
              <td>
                <div class="lookOver" v-show="uploadParam.filePath76"><Button @click="showImg(uploadParam.filePath76)" icon="ios-glasses-outline"  type="primary">查看</Button></div>
                <div v-if='$store.state.app.pageType!="view"'>
                  <Upload
                    id=76
                    :show-upload-list=false
                    :format="['jpg','jpeg','png']"
                    :before-upload="file=>fileHandleBeforeUpload(file,76)"
                    :data="uploadParam.fileData76"
                    :on-success="(res,file)=>getFile(res,file, 76)"
                    :on-format-error="file=>handleFormatError(file,76)"
                    style="display:inline-block;"
                    :action="uploadUrl">
                    <Button icon="ios-cloud-upload-outline" type="primary">上传</Button>
                    <Icon type="ios-checkmark" v-show="checkmark76" />
                  </Upload>
                </div>
              </td>
            </tr>
          </table>
          <p class="red">注：保存到草稿时，不保存附件！<br />所有附件上传文件大小需要控制在2M以内。</p>
        </Card>
      </div>
      <div>
        <CheckboxGroup v-model="confirmData">
          <Checkbox label="1"><span style="color:red;font-weight:bold;">我已确认以上数据填写无误！</span></Checkbox>
        </CheckboxGroup>
      </div>
      <div class="tc" v-if="$store.state.app.pageType!='view'">
        <Button type="primary" @click="prevStep">上一步</Button>
        <Button type="primary" @click="saveRecord" v-if='!$store.state.app.pageType' :disabled="saveDisabled">保存到草稿</Button>
        <Button type="primary" @click="showConfirm">提交备案审核申请</Button>
      </div>
      <div class="tc" v-else>
        <Button type="primary" @click="viewClose">关闭</Button>
      </div>
    </Form>
    <Modal v-model="modal1" title="提交确认" width="960" ok-text="提交备案" cancel-text="再看看" @on-ok="submitRecord">
      <p v-if="boolFlag.length" style="font-size:16px;font-weight: bolder;text-align: center">以下是实验室报告带入项数值被修改的地方，请您再次确认！</p>
      <div v-if="boolFlag.length" class="diffList">
        <table >
          <thead>
          <tr>
            <th>名称</th>
            <th>原始值</th>
            <th>修改值</th>
          </tr>
          </thead>
          <tbody>
          <tr v-for="(item,idx) in boolFlag" :key='idx' >
            <td width="50%">
              {{item.recName}}
            </td>
            <td align="center">
              {{item.labValue}}
            </td>
            <td align="center">
              {{item.updateVal}}
            </td>
          </tr>
          </tbody>
        </table>
      </div>
      <p v-if="!boolFlag.length" style="font-size:16px;font-weight: bolder; text-align: center">请再次确认备案信息填写无误！</p>
      <p style="font-size:16px;font-weight: bolder;text-align: center">若确认，请点击“提交备案”按钮</p>
    </Modal>
    <Modal v-model="modal3" :width=820 :footer-hide=true>
      <img :src="templatePic" />
    </Modal>
    <Modal v-model="modal4" :width=820 :footer-hide=true>
      <img :src="uploadPic" />
    </Modal>
    <Modal v-model="modal5" class="basic-info"  :width=650 ok-text="保存"  @on-ok="submitBasic" cancel-text="关闭">
      <h2>标识型号{{$store.state.app.pageType==="extend"?'扩展':'变更'}}备案申请书</h2>
      <p class="org">中国标准化研究院能效标识管理中心：</p>
      <div class="pro-info">
        我 <span  class="f-company">{{formRecord.c1}}</span>
        公司生产的 <span class="f-brand">{{formRecord.c5}}</span>
        品牌的 <span  class="f-model">{{formRecord.c4}}</span>
        型号的 <span  class="f-product">家用电冰箱-2015版</span>产品。
      </div>
      <dl v-if="$store.state.app.pageType==='extend'">
        <dt>
          现提出型号扩展备案申请的 <span class="f-model"></span>
          型号是以上述型号为基础开发扩展的型号：
        </dt>
        <dd>a) 其与基础型号同属一个系列；</dd>
        <dd>b) 其整机结构与基础型号基本相同；</dd>
        <dd>c) 其产品的能效性能与基础型号一致；</dd>
        <dd>d) 其在基础型号上只作如下变更（差异描述）：<br>
          <Input class="valid" v-model="formRecord.ec_master_kuozhan_text"  type="textarea" :autosize="{minRows: 2,maxRows: 5}" placeholder="描述" />
          <span class="textarea-annotation">（注：提供相应证明材料） </span><b class="color-red">（请删除上述描述中多余的空格和空行，否则可能打印不完整。）</b>
        </dd>
        <dd>
          特提出免检备案申请，扩展型号的初始使用日期：
          <span class="f-date">{{formatDate(formRecord[thisDateCV])}}</span>
        </dd>
        <dd>请中国标准化研究院能效标识管理中心核准。</dd>
      </dl>
      <dl v-if="$store.state.app.pageType==='update'">
        <dd>现申请该幸好申请的备案信息如下变更：<br>
          (描述信息产品技术参数等信息)
          <Input class="valid" v-model="formRecord.ec_master_kuozhan_text"  type="textarea" :autosize="{minRows: 2,maxRows: 5}" placeholder="描述" />
          <b class="color-red">（请删除上述描述中多余的空格和空行，否则可能打印不完整。）</b>
        </dd>
        <dd>
          该型号的相关信息变更后的初始使用日期：
          <span class="f-date">{{formatDate(formRecord[thisDateCV])}}</span>
        </dd>
        <dd>请中国标准化研究院能效标识管理中心核准。</dd>
      </dl>
      <div class="record-attached">附：{{$store.state.app.pageType==="extend"?'扩展':'变更'}}型号产品的能效标识样本{{$store.state.app.pageType==="extend"?'':'以及检测报告'}}</div>
    </Modal>
  </div>
</template>
<script>
import {
    getImgPath,
    XfillExtendData,
    XfillDraftData,
    XfillDefaultData,
    XhandleFormatError,
    XfileHandleBeforeUpload,
    XshowConfirm,
    XviewClose,
    diffRecord,
    XsubmitRecord,
    XsaveRecord,
    XformatDate,
    threeDecimals,
    twoDecimals,
    oneDecimals,
    significantDigits22,
    significantDigits33,
    atLeastOneDecimals,
    atLeastTwoDecimals,
    isInteger,
    isNumber,
    check
  } from '@/libs/utilExt'
  export default {
    data () {
      const timeDate = this.$store.state.app.dateinit
    return {
      // 当前初始使用日期 对应的C值
      thisDateCV: 'c13',
      // 当前能效等级 对应的C值
      thisLevelCV: 'c29',
      modal3: false,
      modal4: false,
      modal5: false,
      templatePic: '',
      uploadPic: '',
      modal2: false,
      currentValue: '',
      qus: '',
      boolFlag: [],
      currentCValue: '',
      confirmData: [],
      modal1: false,
      saveDisabled: false,
      submitDisabled: false,
      dataInit: {
        disabledDate (date) {
          return date && date.valueOf() < timeDate
        }
      },
      uploadUrl: '',
      uploadParam: {
        fileData24: {},
        filePath24: '',
        uploadFileList24: [],
        fileData26: {},
        filePath26: '',
        uploadFileList26: [],
        fileData27: {},
        filePath27: '',
        uploadFileList27: [],
        fileData28: {},
        filePath28: '',
        uploadFileList28: [],
        fileData29: {},
        filePath29: '',
        uploadFileList29: [],
        fileData30: {},
        filePath30: '',
        uploadFileList30: [],
        fileData31: {},
        filePath31: '',
        uploadFileList31: [],
        fileData32: {},
        filePath32: '',
        uploadFileList32: [],
        fileData76: {},
        filePath76: '',
        uploadFileList76: []
      },
      filesArr: [],
      checkmark24: false,
      checkmark26: false,
      checkmark27: false,
      checkmark28: false,
      checkmark29: false,
      checkmark30: false,
      checkmark31: false,
      checkmark32: false,
      checkmark76: false,
      formRecord: {
        ec_master_kuozhan_text: '',
        c1: '',
        c2: '',
        c3: '',
        c4: '',
        c5: '',
        c6: '',
        c7: '',
        c8: '',
        c9: '',
        c10: '',
        c11: '',
        c12: '',
        c13: new Date(),
        c14: '',
        c15: '',
        c16: '',
        c17: '',
        c18: '',
        c19: '',
        c20: '',
        c21: '',
        c22: '',
        c23: '',
        c24: '',
        c25: '',
        c26: '',
        c27: '',
        c28: '',
        c29: '',
        c30: '',
        c31: '',
        c32: '',
        c33: '',
        c34: '',
        c35: '',
        c36: '',
        c37: '',
        c38: '',
        c39: '',
        c40: '',
        c41: '',
        c42: '',
        c43: '',
        c44: '',
        c45: '',
        c46: '',
        c47: '',
        c48: '',
        c49: '',
        c50: '',
        c51: '',
        c52: '',
        c53: '',
        c54: '',
        c55: '',
        c56: '',
        c57: '',
        c58: '',
        c59: '',
        c60: '',
        c61: '',
        c62: '',
        c63: '',
        c64: '',
        c65: '',
        c66: '',
        c67: '',
        c68: '',
        c69: '',
        c70: '',
        c71: '',
        c73: '',
        c74: '',
        c76: '',
        c77: '',
        c78: '',
        c79: '',
        c80: '',
        c81: '',
        c82: '',
        c83: '',
        c84: '',
        c85: '',
        c86: '',
        c87: '',
        c88: '',
        c89: '',
        c90: '',
        c91: '',
        c92: '',
        c200: '',
        c202: '',
        ec_model_no: 29,
        attach_list: ''
      },
      forbidden: {
        c63: true,
        c17: true,
        c19: true,
        c24: true,
        c27: true,
        c29: true,
        c32: true,
        c34: true,
        c36: true,
        c38: true,
        c43: true,
        c45: true,
        c47: true,
        c49: true,
        c51: true
      }
    }
  },
  mounted () {
    
  },
  methods: {
    showTemplate() {
      this.templatePic = this.$store.state.app.pltPic
      this.modal3 = true
    },
    prevStep() {
      this.$emit('prevStep')
    },
    getRandom(type) {
      return (Math.random().toString().slice(2)) + type
    },
    handleFormatError(file, id) {
      return XhandleFormatError(file, id, this)
    },
    /* 数据来源  扩展备案 */
    fileHandleBeforeUpload(file, id) {
      return XfileHandleBeforeUpload(file, id, this)
    },
    /* 数据来源  扩展备案 */
    fillExtendData(params) {
      return XfillExtendData(params, this)
    },
    /* 数据来源 草稿箱 */
    fillDraftData(params) {
      return XfillDraftData(params, this)
    },
    showImg(path) {
      this.uploadPic = path;
      this.modal4 = true
    },
    /* 数据来源 新增备案 */
    fillDefaultData(params) {
      return XfillDefaultData(params, this)
    },
    showConfirm() {
      return XshowConfirm(this)
    },
    submitBasic() {
    },
    submitRecord() {
      return XsubmitRecord(this)
    },
    viewClose() {
      return XviewClose(this)
    },
    /* 保存草稿箱 */
    saveRecord() {
      return XsaveRecord(this)
    },
    formatDate(d) {
      return XformatDate(d)
    },
    getFile(res, file, id) {
      this['checkmark' + id] = true
    }
  },
  computed: {
    disabledoff(){
      return  this.$store.state.app.pageType==='extend';
    },
    pltId() {
      return this.$store.state.app.pltId
    },
    pltPic() {
      return this.$store.state.app.pltPic
    },
    requiredStr() {
      return this.$store.state.app.requiredStr
    },
    ruleRecord () {


      return {
        c1: [
          {
            required: true,
            message: '生产者名称不能为空'
          }
        ],
        c4: [
          {
            required: true,
            message: '制造单位不能为空'
          }
        ],
        c28: [
          {
            required: true,
            message: '备案方不能为空'
          }
        ],
        c3: [
          {
            required: true,
            message: '规格型号不能为空'
          }
        ],
        c2: [
          {
            required: true,
            message: '商标不能为空'
          }
        ],
        c29: [
          {
            required: true,
            message: '能效等级不能为空'
          }
        ]
      }
    }
  }
}
</script>
<style>
@import '../../../css/comm.css';
</style>
