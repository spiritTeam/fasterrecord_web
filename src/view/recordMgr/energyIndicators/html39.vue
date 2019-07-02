/*
* 13、吸油烟机 2013版
* 创建日期:2019年6月9日
* 创建人:WH
*/
<template>
  <div class="wrapper">
    <Form ref="formRecord" :model="formRecord" label-position="right" :rules="ruleRecord">
      <h1>吸油烟机-能源效率标识备案表</h1>
      <div class="part part1">
        <Card :bordered="false">
          <h2>一、备案方声明</h2>
          <p>本组织保证如下：</p>
          <p>使用的能效合格标志与备案信息一致；</p>
          <p>本型号产品变更能源效率标识时，向授权机构重新备案；</p>
          <p>确保该型号产品始终符合能效合格标志使用的相关要求。</p>
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
              <td width="40%">
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
            <Input type="text" v-model="formRecord.c1" placeholder="生产者名称" disabled/>
          </FormItem>
          <FormItem prop="c2" label="制造单位" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c2" :disabled='disabledoff' placeholder="制造单位"/>
          </FormItem>
          <FormItem prop="c3" label="备案方" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c3" :disabled='disabledoff' placeholder="备案方"/>
          </FormItem>
          <FormItem prop="c4" label="规格型号" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c4" :disabled='!disabledoff' placeholder="规格型号" readonly/>
          </FormItem>
          <FormItem prop="c5" label="商标" style="width:100%" :label-width="180">
            <Input type="text" v-model="formRecord.c5" :disabled='disabledoff' placeholder="商标"/>
          </FormItem>
          <FormItem prop="c200" label="依据国家标准" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c200" placeholder="依据国家标准" readonly disabled/>
          </FormItem>
          <FormItem prop="c21" label="能效等级" style="width:100%;" :label-width="180">
            <RadioGroup v-model="formRecord.c21">
              <Radio label="1" :disabled='disabledoff'>1级</Radio>
              <Radio label="2" :disabled='disabledoff'>2级</Radio>
              <Radio label="3" :disabled='disabledoff'>3级</Radio>
              <Radio label="4" :disabled='disabledoff'>4级</Radio>
              <Radio label="5" :disabled='disabledoff'>5级</Radio>
            </RadioGroup>
          </FormItem>
          <FormItem prop="c40" label="产品类型" style="width:100%;" :label-width="180">
            <Select v-model="formRecord.c40" style="width:200px">
              <Option value="全部都有">全部都有</Option>
              <Option value="无待机功率">无待机功率</Option>
              <Option value="无关机功率">无关机功率</Option>
            </Select>
          </FormItem>
          <div class="ivu-form-item ivu-form-item-required ivu-form-item-error" v-if="checkC21C40Msg!=''">
            <div class="ivu-form-item-content" style="margin-left:100px;">
              <div class="ivu-form-item-error-tip">{{checkC21C40Msg}}</div>
            </div>
          </div>
          <table id="table1">
            <tr>
              <td class="t_label">全压效率（%）</td>
              <td class="t_label" style="border-right:none;"><span class="red">*</span>标称值:</td>
              <td style="border-left:none;">
                <FormItem prop="c6">
                  <Input type="text" v-model="formRecord.c6" :disabled='disabledoff' placeholder="整数"/>
                </FormItem>
              </td>
              <td class="t_label" style="border-right:none;"><span class="red">*</span>实测值:</td>
              <td style="border-left:none;">
                <FormItem prop="c7">
                  <Input type="text" v-model="formRecord.c7" :disabled='disabledoff' placeholder="至少一位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c8" label="备注:" :label-width="70">
                  <Input type="text" v-model="formRecord.c8" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="t_label">待机功率（W）</td>
              <td class="t_label" style="border-right:none;"><span class="red" v-if="!forbidden.djgl">*</span>标称值:</td>
              <td style="border-left:none;">
                <FormItem prop="c9">
                  <Input type="text" v-model="formRecord.c9" :disabled='disabledoff||forbidden.djgl' placeholder="一位小数"/>
                </FormItem>
              </td>
              <td class="t_label" style="border-right:none;"><span class="red" v-if="!forbidden.djgl">*</span>实测值:</td>
              <td style="border-left:none;">
                <FormItem prop="c10">
                  <Input type="text" v-model="formRecord.c10" :disabled='disabledoff||forbidden.djgl' placeholder="至少两位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c11" label="备注:" :label-width="70">
                  <Input type="text" v-model="formRecord.c11" :disabled='disabledoff||forbidden.djgl'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="t_label">关机功率（W）</td>
              <td class="t_label" style="border-right:none;"><span class="red" v-if="!forbidden.gjgl">*</span>标称值:</td>
              <td style="border-left:none;">
                <FormItem prop="c12">
                  <Input type="text" v-model="formRecord.c12" :disabled='disabledoff||forbidden.gjgl' placeholder="一位小数"/>
                </FormItem>
              </td>
              <td class="t_label" style="border-right:none;"><span class="red" v-if="!forbidden.gjgl">*</span>实测值:</td>
              <td style="border-left:none;">
                <FormItem prop="c13">
                  <Input type="text" v-model="formRecord.c13" :disabled='disabledoff||forbidden.gjgl' placeholder="至少两位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c14" label="备注:" :label-width="70">
                  <Input type="text" v-model="formRecord.c14" :disabled='disabledoff||forbidden.gjgl'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="t_label">常态气味降低度（%）</td>
              <td class="t_label" style="border-right:none;"><span class="red">*</span>标称值:</td>
              <td style="border-left:none;">
                <FormItem prop="c15">
                  <Input type="text" v-model="formRecord.c15" :disabled='disabledoff' placeholder="整数"/>
                </FormItem>
              </td>
              <td class="t_label" style="border-right:none;"><span class="red">*</span>实测值:</td>
              <td style="border-left:none;">
                <FormItem prop="c16">
                  <Input type="text" v-model="formRecord.c16" :disabled='disabledoff' placeholder="至少一位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c17" label="备注:" :label-width="70">
                  <Input type="text" v-model="formRecord.c17" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="t_label">油脂分离度（%）</td>
              <td class="t_label" style="border-right:none;"><span class="red">*</span>标称值:</td>
              <td style="border-left:none;">
                <FormItem prop="c18">
                  <Input type="text" v-model="formRecord.c18" :disabled='disabledoff' placeholder="整数"/>
                </FormItem>
              </td>
              <td class="t_label" style="border-right:none;"><span class="red">*</span>实测值:</td>
              <td style="border-left:none;">
                <FormItem prop="c19">
                  <Input type="text" v-model="formRecord.c19" :disabled='disabledoff' placeholder="至少一位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c20" label="备注:" :label-width="70">
                  <Input type="text" v-model="formRecord.c20" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
          </table>
        </Card>
      </div>
      <div class="part part4">
        <Card :bordered="false">
          <h2>四、初始使用日期</h2>
          <FormItem prop="c22" label="备案标识开始使用日期" style="width:100%;">
            <DatePicker type="date" :Options="dataInit" style="width: 200px" v-model="formRecord.c22" :disabled='disabledoff'></DatePicker>
          </FormItem>
        </Card>
      </div>
      <div class="part part5">
        <Card :bordered="false">
          <h2>五、样品描述</h2>
          <table id="table3">
            <tr>
              <td class="t_label"><span class="red">*</span>电源性质</td>
              <td>
                <FormItem prop="c23">
                  <RadioGroup v-model="formRecord.c23">
                    <Radio label="交流" :disabled='disabledoff'></Radio>
                    <Radio label="直流" :disabled='disabledoff'></Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td class="t_label"><span class="red">*</span>控制方式</td>
              <td>
                <FormItem prop="c27">
                  <RadioGroup v-model="formRecord.c27">
                    <Radio label="机械" :disabled='disabledoff'></Radio>
                    <Radio label="电子" :disabled='disabledoff'></Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="t_label"><span class="red">*</span>额定电压（V）</td>
              <td>
                <FormItem prop="c24">
                  <Input type="text" v-model="formRecord.c24" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td class="t_label"><span class="red">*</span>额定频率（Hz）</td>
              <td>
                <FormItem prop="c25">
                  <Input type="text" v-model="formRecord.c25" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="t_label"><span class="red">*</span>安装方式</td>
              <td colspan="3">
                <FormItem prop="c26">
                  <RadioGroup v-model="formRecord.c26">
                    <Radio label="壁挂式" :disabled='disabledoff'></Radio>
                    <Radio label="岛式" :disabled='disabledoff'></Radio>
                    <Radio label="嵌入式" :disabled='disabledoff'></Radio>
                    <Radio label="分体式" :disabled='disabledoff'></Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="t_label"><span class="red">*</span>外观形式</td>
              <td colspan="3">
                <FormItem prop="c28">
                  <RadioGroup v-model="formRecord.c28">
                    <Radio label="薄型" :disabled='disabledoff'></Radio>
                    <Radio label="深型" :disabled='disabledoff'></Radio>
                    <Radio label="塔型" :disabled='disabledoff'></Radio>
                    <Radio label="侧吸型" :disabled='disabledoff'></Radio>
                    <Radio label="其它" :disabled='disabledoff'></Radio>
                  </RadioGroup>
                </FormItem>
                <FormItem prop="c29">
                  <Input type="text" v-model="formRecord.c29" :disabled="disabledoff||formRecord.c28!='其它'"/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="t_label"><span class="red">*</span>过滤网</td>
              <td>
                <FormItem prop="c30">
                  <RadioGroup v-model="formRecord.c30">
                    <Radio label="有" :disabled='disabledoff'></Radio>
                    <Radio label="无" :disabled='disabledoff'></Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td class="t_label"><span class="red">*</span>主电机额定输入功率（W）</td>
              <td>
                <FormItem prop="c31">
                  <Input type="text" v-model="formRecord.c31" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="t_label"><span class="red">*</span>最大照明输入功率（W）</td>
              <td>
                <FormItem prop="c32">
                  <Input type="text" v-model="formRecord.c32" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td class="t_label"><span class="red">*</span>整机额定输入功率（W）</td>
              <td>
                <FormItem prop="c33">
                  <Input type="text" v-model="formRecord.c33" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="t_label"><span class="red">*</span>风量（m³/min）</td>
              <td>
                <FormItem prop="c34">
                  <Input type="text" v-model="formRecord.c34" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td class="t_label"><span class="red">*</span>最大静压（Pa）</td>
              <td>
                <FormItem prop="c35">
                  <Input type="text" v-model="formRecord.c35" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="t_label"><span class="red">*</span>风压（Pa）<br/>（规定风量时的静压）</td>
              <td>
                <FormItem prop="c36">
                  <Input type="text" v-model="formRecord.c36" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td class="t_label"><span class="red">*</span>噪声（dB（A））</td>
              <td>
                <FormItem prop="c37">
                  <Input type="text" v-model="formRecord.c37" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="t_label"><span class="red">*</span>外形长度尺寸（mm）</td>
              <td>
                <FormItem prop="c38">
                  <Input type="text" v-model="formRecord.c38" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td class="t_label"><span class="red">*</span>出风罩（或风管座）<br/>内径尺寸（mm）</td>
              <td>
                <FormItem prop="c39">
                  <Input type="text" v-model="formRecord.c39" :disabled='disabledoff'/>
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
            <thead>
            <tr>
              <th style="width:30%">名称</th>
              <th style="width:35%">牌号及规格/型号</th>
              <th style="width:35%">生产者（全称）</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td class="t_label"><span class="red">*</span>主电动机（IGBT）</td>
              <td>
                <FormItem prop="c41" style="width:100%">
                  <Input type="text" v-model="formRecord.c41" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c42" style="width:100%">
                  <Input type="text" v-model="formRecord.c42" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="t_label">主电动机（IGBT）</td>
              <td>
                <FormItem prop="c43" style="width:100%">
                  <Input type="text" v-model="formRecord.c43" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c44" style="width:100%">
                  <Input type="text" v-model="formRecord.c44" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="t_label">主电动机（IGBT）</td>
              <td>
                <FormItem prop="c45" style="width:100%">
                  <Input type="text" v-model="formRecord.c45" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c46" style="width:100%">
                  <Input type="text" v-model="formRecord.c46" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="t_label"><span class="red">*</span>电源板低压变压器或开关型电源变压器</td>
              <td>
                <FormItem prop="c47" style="width:100%">
                  <Input type="text" v-model="formRecord.c47" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c48" style="width:100%">
                  <Input type="text" v-model="formRecord.c48" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="t_label">电源板低压变压器或开关型电源变压器</td>
              <td>
                <FormItem prop="c49" style="width:100%">
                  <Input type="text" v-model="formRecord.c49" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c50" style="width:100%">
                  <Input type="text" v-model="formRecord.c50" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="t_label">电源板低压变压器或开关型电源变压器</td>
              <td>
                <FormItem prop="c51" style="width:100%">
                  <Input type="text" v-model="formRecord.c51" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c52" style="width:100%">
                  <Input type="text" v-model="formRecord.c52" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td colspan="3">注：如果上述关键零部件属多个制造商，均应按上述要求逐一填写。</td>
            </tr>
            </tbody>
          </table>
        </Card>
      </div>
      <div class="part part7">
        <Card :bordered="false">
          <h2>七、其他认证信息</h2>
          <table>
            <tr>
              <td class="tc">3C认证证书编号</td>
              <td><Input type="text" v-model="formRecord.c202" :disabled='disabledoff'/></td>
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
                <div class="lookOver" v-show="uploadParam.filePath24">
                  <Button @click="showImg(uploadParam.filePath24)" icon="ios-glasses-outline" type="primary">查看</Button>
                </div>
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
                    <Icon type="ios-checkmark" v-show="checkmark24"/>
                  </Upload>
                </div>
              </td>
              <td colspan="3" v-if="pltId!=244">根据企业提交的相关能效指标，系统直接生成能效表示样本
                <Button type="primary" @click="showTemplate">查看</Button>
              </td>
              <td colspan="3" v-else>提交备案后，需企业自行上传能效标识样本</td>
            </tr>
            <tr>
              <td><span v-if='$store.state.app.oem' class="red">*</span>OEM声明</td>
              <td>(JPG/PNG)</td>
              <td>
                <div class="lookOver" v-show="uploadParam.filePath26">
                  <Button @click="showImg(uploadParam.filePath26)" icon="ios-glasses-outline" type="primary">查看</Button>
                </div>
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
                    <Icon type="ios-checkmark" v-show="checkmark26"/>
                  </Upload>
                </div>
              </td>
              <td>关系证明</td>
              <td>(PDF)</td>
              <td>
                <div class="lookOver" v-show="uploadParam.filePath27">
                  <Button @click="showImg(uploadParam.filePath27)" icon="ios-glasses-outline" type="primary">查看</Button>
                </div>
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
                    <Icon type="ios-checkmark" v-show="checkmark27"/>
                  </Upload>
                </div>
              </td>
            </tr>
            <tr>
              <td>品牌使用授权书</td>
              <td>(PDF)</td>
              <td>
                <div class="lookOver" v-show="uploadParam.filePath28">
                  <Button @click="showImg(uploadParam.filePath28)" icon="ios-glasses-outline" type="primary">查看</Button>
                </div>
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
                    <Icon type="ios-checkmark" v-show="checkmark28"/>
                  </Upload>
                </div>
              </td>
              <td>委托代理文件</td>
              <td>(PDF)</td>
              <td>
                <div class="lookOver" v-show="uploadParam.filePath29">
                  <Button @click="showImg(uploadParam.filePath29)" icon="ios-glasses-outline" type="primary">查看</Button>
                </div>
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
                    <Icon type="ios-checkmark" v-show="checkmark29"/>
                  </Upload>
                </div>
              </td>
            </tr>
            <tr>
              <td>进口商企业信息表</td>
              <td>(PDF)</td>
              <td>
                <div class="lookOver" v-show="uploadParam.filePath30">
                  <Button @click="showImg(uploadParam.filePath30)" icon="ios-glasses-outline" type="primary">查看</Button>
                </div>
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
                    <Icon type="ios-checkmark" v-show="checkmark30"/>
                  </Upload>
                </div>
              </td>
              <td>进口商营业执照或登记注册证明复印件</td>
              <td>(PDF)</td>
              <td>
                <div class="lookOver" v-show="uploadParam.filePath31">
                  <Button @click="showImg(uploadParam.filePath31)" icon="ios-glasses-outline" type="primary">查看</Button>
                </div>
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
                    <Icon type="ios-checkmark" v-show="checkmark31"/>
                  </Upload>
                </div>
              </td>
            </tr>
            <tr>
              <td>进口商与境外生产者订立的相关合同副本</td>
              <td>(PDF)</td>
              <td>
                <div class="lookOver" v-show="uploadParam.filePath32">
                  <Button @click="showImg(uploadParam.filePath32)" icon="ios-glasses-outline" type="primary">查看</Button>
                </div>
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
                    <Icon type="ios-checkmark" v-show="checkmark32"/>
                  </Upload>
                </div>
              </td>
              <td><span class="red">*</span>铭牌照片</td>
              <td>(PDF/JPG/PNG)</td>
              <td>
                <div class="lookOver" v-show="uploadParam.filePath76">
                  <Button @click="showImg(uploadParam.filePath76)" icon="ios-glasses-outline" type="primary">查看</Button>
                </div>
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
                    <Icon type="ios-checkmark" v-show="checkmark76"/>
                  </Upload>
                </div>
              </td>
            </tr>
          </table>
          <p class="red">注：保存到草稿时，不保存附件！<br/>所有附件上传文件大小需要控制在2M以内。</p>
        </Card>
      </div>
      <div>
        <CheckboxGroup v-model="confirmData">
          <Checkbox label="1"><span style="color:red;font-weight:bold;">我已确认以上数据填写无误！</span></Checkbox>
        </CheckboxGroup>
      </div>
      <div class="tc" v-if="$store.state.app.pageType!='view'">
        <Button type="primary" @click="prevStep">上一步</Button>
        <Button type="primary" @click="saveRecord" v-if='!$store.state.app.pageType' :disabled="saveDisabled">保存到草稿
        </Button>
        <!-- <Button type="primary" @click="submitRecord" :disabled="submitDisabled">提交备案审核申请</Button> -->
        <Button type="primary" @click="showConfirm">提交备案审核申请</Button>
      </div>
      <div class="tc" v-else>
        <Button type="primary" @click="viewClose">关闭</Button>
      </div>
    </Form>
    <Modal v-model="modal1" title="提交确认" width="960" ok-text="提交备案" cancel-text="再看看" @on-ok="submitRecord">
      <p v-if="boolFlag.length" style="font-size:16px;font-weight: bolder;text-align: center">
        以下是实验室报告带入项数值被修改的地方，请您再次确认！</p>
      <div v-if="boolFlag.length" class="diffList">
        <table>
          <thead>
          <tr>
            <th>名称</th>
            <th>原始值</th>
            <th>修改值</th>
          </tr>
          </thead>
          <tbody>
          <tr v-for="(item,idx) in boolFlag" :key='idx'>
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
    <!--<Modal v-model="modal2" title="提交工单" @on-ok="submitWorkorder">
      <p style="font-size:18px;margin-bottom:10px;">实验室数值：{{currentValue}}</p>
      <Input type="textarea" :rows="3" placeholder="请描述问题" v-model="qus"></Input>
    </Modal>-->
    <Modal v-model="modal3" :width=820 :footer-hide=true>
      <img :src="templatePic"/>
    </Modal>
    <Modal v-model="modal4" :width=820 :footer-hide=true>
      <img :src="uploadPic"/>
    </Modal>
    <Modal v-model="modal5" class="basic-info" :width=650 ok-text="保存" @on-ok="submitBasic" cancel-text="关闭">
      <h2>标识型号{{$store.state.app.pageType==="extend"?'扩展':'变更'}}备案申请书</h2>
      <p class="org">中国标准化研究院能效标识管理中心：</p>
      <div class="pro-info">
        我 <span class="f-company">{{formRecord.c1}}</span>
        公司生产的 <span class="f-brand">{{formRecord.c5}}</span>
        品牌的 <span class="f-model">{{formRecord.c4}}</span>
        型号的 <span class="f-product">家用电冰箱-2015版</span>产品。
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
          <Input class="valid" v-model="formRecord.ec_master_kuozhan_text" type="textarea" :autosize="{minRows: 2,maxRows: 5}" placeholder="描述"/>
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
          <Input class="valid" v-model="formRecord.ec_master_kuozhan_text" type="textarea" :autosize="{minRows: 2,maxRows: 5}" placeholder="描述"/>
          <b class="color-red">（请删除上述描述中多余的空格和空行，否则可能打印不完整。）</b>
        </dd>
        <dd>
          该型号的相关信息变更后的初始使用日期：
          <span class="f-date">{{formatDate(formRecord[thisDateCV])}}</span>
        </dd>
        <dd>请中国标准化研究院能效标识管理中心核准。</dd>
      </dl>
      <div class="record-attached">
        附：{{$store.state.app.pageType==="extend"?'扩展':'变更'}}型号产品的能效标识样本{{$store.state.app.pageType==="extend"?'':'以及检测报告'}}
      </div>
    </Modal>
  </div>
</template>

<script>
import axios from 'axios'
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
  atLeastThreeDecimals,
  atLeastFourDecimals,
  isInteger,
  isNumber,
  check
} from '@/libs/utilExt'
import sCheck from '@/libs/util.check.js'

export default {
  data() {
    const timeDate=this.$store.state.app.dateinit;
    return {
      checkC21C40Msg: "",
      thisDateCV: "c22",  //当前初始使用日期 对应的C值
      thisLevelCV: "c21", //当前能效等级 对应的C值
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
        disabledDate(date) {
          return date && date.valueOf() < timeDate;
        }
      },
      /*以下为文件处理相关*/
      uploadUrl: '',
      uploadParam: {
        fileData24: {}, filePath24: '', uploadFileList24: [],
        fileData26: {}, filePath26: '', uploadFileList26: [],
        fileData27: {}, filePath27: '', uploadFileList27: [],
        fileData28: {}, filePath28: '', uploadFileList28: [],
        fileData29: {}, filePath29: '', uploadFileList29: [],
        fileData30: {}, filePath30: '', uploadFileList30: [],
        fileData31: {}, filePath31: '', uploadFileList31: [],
        fileData32: {}, filePath32: '', uploadFileList32: [],
        fileData76: {}, filePath76: '', uploadFileList76: []
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
        c200: '',
        c21: '',
        c40: '',
        c6: '',
        c7: '',
        c8: '',
        c9: '',
        c10: '',
        c11: '',
        c12: '',
        c13: '',
        c14: '',
        c15: '',
        c16: '',
        c17: '',
        c18: '',
        c19: '',
        c20: '',
        c22: new Date(),
        c23: '',
        c27: '',
        c24: '',
        c25: '',
        c26: '',
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
        c202: '',
        ec_model_no: 39,
        attach_list: ''
      },
      forbidden: {
        djgl: true,
        gjgl: true,
      }
    }
  },
  mounted() {
    //this.disabledoff=(this.$store.state.app.pageType=="extend" ? true : false)
  },
  methods: {
    showTemplate() {
      this.templatePic=this.$store.state.app.pltPic
      this.modal3=true
    },
    prevStep() {
      this.$emit('prevStep')
    },
    getRandom(type) {
      return (Math.random().toString().slice(2))+type
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
      this.uploadPic=path;
      this.modal4=true
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
      this['checkmark'+id]=true
    }
  },
  computed: {
    disabledoff() {
      return this.$store.state.app.pageType === 'extend';
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
    ruleRecord() {
      //拿出需要检测的变量
      let _c21=this.formRecord.c21;//能效等级
      let _c40=this.formRecord.c40;//产品类型

      let  _c6=parseFloat( this.formRecord.c6);
      let  _c7=parseFloat( this.formRecord.c7);
      let  _c9=parseFloat( this.formRecord.c9);
      let _c10=parseFloat(this.formRecord.c10);
      let _c12=parseFloat(this.formRecord.c12);
      let _c13=parseFloat(this.formRecord.c13);
      let _c15=parseFloat(this.formRecord.c15);
      let _c16=parseFloat(this.formRecord.c16);
      let _c18=parseFloat(this.formRecord.c18);
      let _c19=parseFloat(this.formRecord.c19);

      /**一、以下为检测函数 */
      /**1.0-基础校验 */
      let checkC9=(rule, value, callback) => {
        let _msg=null;
        if (!this.forbidden.djgl&&!sCheck.number.isOneDecimal(value)) _msg='一位小数';
        if (_msg) callback(_msg);
        else callback();
      }
      let checkC10=(rule, value, callback) => {
        let _msg=null;
        if (!this.forbidden.djgl&&!sCheck.number.atLeastTwoDecimals(value)) _msg='至少两位小数';
        if (_msg) callback(_msg);
        else callback();
      }
      let checkC12=(rule, value, callback) => {
        let _msg=null;
        if (!this.forbidden.gjgl&&!sCheck.number.isOneDecimal(value)) _msg='一位小数';
        if (_msg) callback(_msg);
        else callback();
      }
      let checkC13=(rule, value, callback) => {
        let _msg=null;
        if (!this.forbidden.gjgl&&!sCheck.number.atLeastTwoDecimals(value)) _msg='至少两位小数';
        if (_msg) callback(_msg);
        else callback();
      }
      /**1.1-实测值与标称值关系 */
      let checkC6C7=(rule, value, callback) => {
        let _msg=null;
        if (_c6&&_c7&&_c6>_c7) _msg="全压效率实测值必须大于标称值";
        if (_msg) callback(_msg); else callback();
      }
      let checkC9C10=(rule, value, callback) => {
        let _msg=null;
        if (!this.forbidden.djgl&&_c9&&_c10&&_c9<_c10) _msg="待机功率实测值必须小于标称值";
        if (_msg) callback(_msg); else callback();
      }
      let checkC12C13=(rule, value, callback) => {
        let _msg=null;
        if (!this.forbidden.gjgl&&_c12&&_c13&&_c12<_c13) _msg="关机功率实测值必须小于标称值";
        if (_msg) callback(_msg); else callback();
      }
      let checkC15C16=(rule, value, callback) => {
        let _msg=null;
        if (_c15&&_c16&&(_c15*0.95<_c16)) _msg="常态气味降低度实测值必须大于等于标称值的95%";
        if (_msg) callback(_msg);
        else callback();
      }
      let checkC18C19=(rule, value, callback) => {
        let _msg=null;
        if (_c18&&_c19&&_c18>_c19) _msg="油脂分离度实测值必须大于等于标称值";
        if (_msg) callback(_msg);
        else callback();
      }
      /**1.2-能效等级、产品类型与各实测值标称值之间关系 */
      let checkC21C40=(rule, value, callback) => {
        if (!_c40) callback();
        //this.checkC21C40Msg="请选择产品类型"
        if (!_c21||(_c21!='1'&&_c21!='2'&&_c21!='3'&&_c21!='4'&&_c21!='5')) callback();
        //this.checkC21C40Msg="未选择能效等级，无法校验，请先选择能效等级"

        let _msg="当：产品类型="+_c40+",能效等级="+_c21+"。"
        let _errMsg=""
        if (_c40=="全部都有") {
          this.forbidden.djgl=false;
          this.forbidden.gjgl=false;
          if (_c21==5) {
            if (!(_c6>=15))   _errMsg+="[全压效率（%）标称值]应>=15;";
            if (!(_c9<=3.0))  _errMsg+="[待机功率标称值]应<=3.0;";
            if (!(_c12<=1.5)) _errMsg+="[关机功率标称值]应<=1.5;";
            if (!(_c15>=90))  _errMsg+="[常态气味降低度标称值]应>=90;";
            if (!(_c18>=80))  _errMsg+="[油脂分离度标称值]应>=80;";
          } else if (_c21==4) {
            if (!(_c6>=17))   _errMsg+="[全压效率（%）标称值]应>=17;";
            if (!(_c9<=3.0))  _errMsg+="[待机功率标称值]应<=3.0;";
            if (!(_c12<=1.5)) _errMsg+="[关机功率标称值]应<=1.5;";
            if (!(_c15>=90))  _errMsg+="[常态气味降低度标称值]应>=90;";
            if (!(_c18>=80))  _errMsg+="[油脂分离度标称值]应>=80;";
          } else if (_c21==3) {
            if (!(_c6>=19))   _errMsg+="[全压效率（%）标称值]应>=19;";
            if (!(_c9<=3.0))  _errMsg+="[待机功率标称值]应<=3.0;";
            if (!(_c12<=1.5)) _errMsg+="[关机功率标称值]应<=1.5;";
            if (!(_c15>=90))  _errMsg+="[常态气味降低度标称值]应>=90;";
            if (!(_c18>=80))  _errMsg+="[油脂分离度标称值]应>=80;";
          } else if (_c21==2) {
            if (!(_c6>=21))   _errMsg+="[全压效率（%）标称值]应>=21;";
            if (!(_c9<=2.0))  _errMsg+="[待机功率标称值]应<=2.0;";
            if (!(_c12<=1.0)) _errMsg+="[关机功率标称值]应<=1.0;";
            if (!(_c15>=95))  _errMsg+="[常态气味降低度标称值]应>=95;";
            if (!(_c18>=80))  _errMsg+="[油脂分离度标称值]应>=80;";
          } else if (_c21==1) {
            if (!(_c6>=23))   _errMsg+="[全压效率（%）标称值]应>=23;";
            if (!(_c9<=2.0))  _errMsg+="[待机功率标称值]应<=2.0;";
            if (!(_c12<=1.0)) _errMsg+="[关机功率标称值]应<=1.0;";
            if (!(_c15>=95))  _errMsg+="[常态气味降低度标称值]应>=95;";
            if (!(_c18>=80))  _errMsg+="[油脂分离度标称值]应>=80;";
          }
        } else if (_c40=="无待机功率") {
          this.forbidden.djgl=true;
          this.forbidden.gjgl=false;
          this.formRecord.c9="";
          this.formRecord.c10="";
          _c9="";
          _c10="";

          if (_c21==5) {
            if (!(_c6>=15))   _errMsg+="[全压效率（%）标称值]应>=15;";
            if (!(_c12<=1.5)) _errMsg+="[关机功率标称值]应<=1.5;";
            if (!(_c15>=90))  _errMsg+="[常态气味降低度标称值]应>=90;";
            if (!(_c18>=80))  _errMsg+="[油脂分离度标称值]应>=80;";
          } else if (_c21==4) {
            if (!(_c6>=17))   _errMsg+="[全压效率（%）标称值]应>=17;";
            if (!(_c12<=1.5)) _errMsg+="[关机功率标称值]应<=1.5;";
            if (!(_c15>=90))  _errMsg+="[常态气味降低度标称值]应>=90;";
            if (!(_c18>=80))  _errMsg+="[油脂分离度标称值]应>=80;";
          } else if (_c21==3) {
            if (!(_c6>=19))   _errMsg+="[全压效率（%）标称值]应>=19;";
            if (!(_c12<=1.5)) _errMsg+="[关机功率标称值]应<=1.5;";
            if (!(_c15>=90))  _errMsg+="[常态气味降低度标称值]应>=90;";
            if (!(_c18>=80))  _errMsg+="[油脂分离度标称值]应>=80;";
          } else if (_c21==2) {
            if (!(_c6>=21))   _errMsg+="[全压效率（%）标称值]应>=21;";
            if (!(_c12<=1.0)) _errMsg+="[关机功率标称值]应<=1.0;";
            if (!(_c15>=95))  _errMsg+="[常态气味降低度标称值]应>=95";
            if (!(_c18>=80))  _errMsg+="[油脂分离度标称值]应>=80";
          } else if (_c21==1) {
            if (!(_c6>=23))   _errMsg+="[全压效率（%）标称值]应>=23;";
            if (!(_c12<=1.0)) _errMsg+="[关机功率标称值]应<=1.0;";
            if (!(_c15>=95))  _errMsg+="[常态气味降低度标称值]应>=95;";
            if (!(_c18>=80))  _errMsg+="[油脂分离度标称值]应>=80;";
          }
        } else if (_c40=="无关机功率") {
          this.forbidden.djgl=false;
          this.forbidden.gjgl=true;
          this.formRecord.c12="";
          this.formRecord.c13="";
          _c12="";
          _c13="";

          if (_c21==5) {
            if (!(_c6>=15))   _errMsg+="[全压效率（%）标称值]应>=15;";
            if (!(_c9<=3.0))  _errMsg+="[待机功率标称值]应<=3.0;";
            if (!(_c15>=90))  _errMsg+="[常态气味降低度标称值]应>=90;";
            if (!(_c18>=80))  _errMsg+="[油脂分离度标称值]应>=80;";
          } else if (_c21==4) {
            if (!(_c6>=17))   _errMsg+="[全压效率（%）标称值]应>=17;";
            if (!(_c9<=3.0))  _errMsg+="[待机功率标称值]应<=3.0;";
            if (!(_c15>=90))  _errMsg+="[常态气味降低度标称值]应>=90;";
            if (!(_c18>=80))  _errMsg+="[油脂分离度标称值]应>=80;";
          } else if (_c21==3) {
            if (!(_c6>=19))   _errMsg+="[全压效率（%）标称值]应>=19;";
            if (!(_c9<=3.0))  _errMsg+="[待机功率标称值]应<=3.0;";
            if (!(_c15>=90))  _errMsg+="[常态气味降低度标称值]应>=90;";
            if (!(_c18>=80))  _errMsg+="[油脂分离度标称值]应>=80;";
          } else if (_c21==2) {
            if (!(_c6>=21))   _errMsg+="[全压效率（%）标称值]应>=21;";
            if (!(_c9<=2.0))  _errMsg+="[待机功率标称值]应<=2.0;";
            if (!(_c15>=95))  _errMsg+="[常态气味降低度标称值]应>=95;";
            if (!(_c18>=80))  _errMsg+="[油脂分离度标称值]应>=80;";
          } else if (_c21==1) {
            if (!(_c6>=23))   _errMsg+="[全压效率（%）标称值]应>=23;";
            if (!(_c9<=2.0))  _errMsg+="[待机功率标称值]应<=2.0;";
            if (!(_c15>=95))  _errMsg+="[常态气味降低度标称值]应>=95;";
            if (!(_c18>=80))  _errMsg+="[油脂分离度标称值]应>=80;";
          }
        }
        this.checkC21C40Msg=(_errMsg?(_msg+_errMsg):"");
        if (this.checkC21C40Msg) this.modal1=false;
        callback();
      }
      /**1.3-标称值根据能效等级、产品类型进行检验 */
      let checkC6_C21=(rule, value, callback) => {
        let typeStr="当：能效等级="+_c21+"。[标称值]应";

        let _errMsg="";
        if (_c21=='5'&&!(value>=15)) _errMsg=">=15";
        else
        if (_c21=='4'&&!(value>=17)) _errMsg=">=17";
        else
        if (_c21=='3'&&!(value>=19)) _errMsg=">=19";
        else
        if (_c21=='2'&&!(value>=21)) _errMsg=">=21";
        else
        if (_c21=='1'&&!(value>=23)) _errMsg=">=23";

        if (_errMsg) callback(typeStr+_errMsg);
        else callback();
      }
      let checkC9_C21C40=(rule, value, callback) => {
        let typeStr="当：能效等级="+_c21+"。[标称值]应";

        let _errMsg="";
        if (_c40=="全部都有"||_c40=="无关机功率") {
          if (_c21==5&&!(_c9<=3.0)) _errMsg+="<=3.0;";
          else
          if (_c21==4&&!(_c9<=3.0)) _errMsg+="<=3.0;";
          else
          if (_c21==3&&!(_c9<=3.0)) _errMsg+="<=3.0;";
          else
          if (_c21==2&&!(_c9<=2.0)) _errMsg+="<=2.0;";
          else
          if (_c21==1&&!(_c9<=2.0)) _errMsg+="<=2.0;";
        }

        if (_errMsg) callback(typeStr+_errMsg);
        else callback();
      }
      let checkC12_C21C40=(rule, value, callback) => {
        let typeStr="当：能效等级="+_c21+"。[标称值]应";

        let _errMsg="";
        if (_c40=="全部都有"||_c40=="无待机功率") {
          if (_c21==5&&!(_c12<=1.5)) _errMsg+="<=1.5;";
          else
          if (_c21==4&&!(_c12<=1.5)) _errMsg+="<=1.5;";
          else
          if (_c21==3&&!(_c12<=1.5)) _errMsg+="<=1.5;";
          else
          if (_c21==2&&!(_c12<=1.0)) _errMsg+="<=1.0;";
          else
          if (_c21==1&&!(_c12<=1.0)) _errMsg+="<=1.0;";
        }

        if (_errMsg) callback(typeStr+_errMsg);
        else callback();
      }
      let checkC15_C21=(rule, value, callback) => {
        let typeStr="当：能效等级="+_c21+"。[标称值]应";

        let _errMsg="";
        if (_c21==5&&!(_c15>=90)) _errMsg+=">=90;";
        else
        if (_c21==4&&!(_c15>=90)) _errMsg+=">=90;";
        else
        if (_c21==3&&!(_c15>=90)) _errMsg+=">=90;";
        else
        if (_c21==2&&!(_c15>=95)) _errMsg+=">=95;";
        else
        if (_c21==1&&!(_c15>=95)) _errMsg+=">=95;";
        if (_errMsg) callback(typeStr+_errMsg);
        else callback();
      }
      let checkC18_C21=(rule, value, callback) => {
        let typeStr="当：能效等级="+_c21+"。[标称值]应";

        let _errMsg="";
        if (_c21==5&&!(_c18>=80)) _errMsg+=">=80;";
        else
        if (_c21==4&&!(_c18>=80)) _errMsg+=">=80;";
        else
        if (_c21==3&&!(_c18>=80)) _errMsg+=">=80;";
        else
        if (_c21==2&&!(_c18>=80)) _errMsg+=">=80;";
        else
        if (_c21==1&&!(_c18>=80)) _errMsg+=">=80;";

        if (_errMsg) callback(typeStr+_errMsg);
        else callback();
      }

      return {
        c2: [{
          required: true, message: '请填写制造单位'
        }],
        c3: [{
          required: true, message: '请填写备案方'
        }],
        c4: [{
          required: true, message: '请填写规格型号'
        }],
        c5: [{
          required: true, message: '请填写商标'
        }],
        c21: [{
          required: true, message: '请选择能效等级', trigger: 'change'
        }, {
          validator: checkC21C40, trigger: 'change'
        }],
        c40: [{
          required: true, message: '请选择产品类型', trigger: 'change'
        }, {
          validator: checkC21C40, trigger: 'change'
        }],
        c6: [{
          required: true, message: '请输入全压效率标称值', trigger: 'change,blur'
        }, {
          validator: isInteger, trigger: 'change,blur'
        }, {
          validator: checkC6C7, trigger: 'change,blur'
        }, {
          validator: checkC6_C21, trigger: 'change,blur'
        }],
        c7: [{
          required: true, message: '请输入全压效率实测值', trigger: 'change,blur'
        }, {
          validator: atLeastOneDecimals, trigger: 'change,blur'
        }, {
          validator: checkC6C7, trigger: 'change,blur'
        }],
        c9: [{
          required: !this.forbidden.djgl, message: '请输入待机功率标称值', trigger: 'change,blur'
        }, {
          validator: checkC9, trigger: 'change,blur'
        }, {
          validator: checkC9C10, trigger: 'change,blur'
        }, {
          validator: checkC9_C21C40, trigger: 'change,blur'
        }],
        c10: [{
          required: !this.forbidden.djgl, message: '请输入待机功率实测值', trigger: 'change,blur'
        }, {
          validator: checkC10, trigger: 'change,blur'
        }, {
          validator: checkC9C10, trigger: 'change,blur'
        }],
        c12: [{
          required:!this.forbidden.gjgl, message:'请输入关机功率标称值', trigger:'change,blur'
        }, {
          validator:checkC12, trigger:'change,blur'
        }, {
          validator:checkC12C13, trigger:'change,blur'
        }, {
          validator:checkC12_C21C40, trigger:'change,blur'
        }],
        c13: [{
          required:!this.forbidden.gjgl, message:'请输入关机功率实测值', trigger:'change,blur'
        }, {
          validator:checkC13, trigger: 'change,blur'
        }, {
          validator:checkC12C13, trigger: 'change,blur'
        }],
        c15: [{
          required: true, message: '请输入常态气味降低度标称值', trigger: 'change,blur'
        }, {
          validator: isInteger, trigger: 'change,blur'
        }, {
          validator: checkC15C16, trigger: 'change,blur'
        }, {
          validator: checkC15_C21, trigger: 'change,blur'
        }],
        c16: [{
          required: true, message: '请输入常态气味降低度实测值'
        }, {
          validator: atLeastOneDecimals, trigger: 'change,blur'
        }, {
          validator: checkC15C16, trigger: 'change,blur'
        }],
        c18: [{
          required: true, message: '请输入油脂分离度标称值', trigger: 'change,blur'
        }, {
          validator: isInteger, trigger: 'change,blur'
        }, {
          validator: checkC18C19, trigger: 'change,blur'
        }, {
          validator: checkC18_C21, trigger: 'change,blur'
        }],
        c19: [{
          required: true, message: '请输入油脂分离度实测值'
        }, {
          validator: atLeastOneDecimals, trigger: 'change,blur'
        }, {
          validator: checkC18C19, trigger: 'change,blur'
        }],
        c22: [{
          required:true, message:'备案标识开始使用日期不能为空'
        }],
        c23: [{
          required: true, message: '请选择电源性质', trigger: 'change,blur'
        }],
        c27: [{
          required: true, message: '请选择控制方式', trigger: 'change,blur'
        }],
        c24: [{
          required: true, message: '请输入额定电压', trigger: 'change,blur'
        }],
        c25: [{
          required: true, message: '请输入额定频率', trigger: 'change,blur'
        }],
        c26: [{
          required: true, message: '请选择安装方式', trigger: 'change,blur'
        }],
        c28: [{
          required: true, message: '请选择外观形式', trigger: 'change'
        }, {
          validator: (rule, value, callback) => {
            if (value!='其它') this.formRecord.c29="";
            callback();
          }, trigger: 'change'
        }],
        c29: [{
          required: this.formRecord.c28=='其它', message: '请输入其它外观形式', trigger: 'change,blur'
        }],
        c30: [{
          required: true, message: '请选择过滤网', trigger: 'change,blur'
        }],
        c31: [{
          required: true, message: '请输入主电机额定输入功率', trigger: 'change,blur'
        }],
        c32: [{
          required: true, message: '请输入最大照明输入功率', trigger: 'change,blur'
        }],
        c33: [{
          required: true, message: '请输入整机额定输入功率', trigger: 'change,blur'
        }],
        c34: [{
          required: true, message: '请输入风量', trigger: 'change,blur'
        }],
        c35: [{
          required: true, message: '请输入最大静压', trigger: 'change,blur'
        }],
        c36: [{
          required: true, message: '请输入风压', trigger: 'change,blur'
        }],
        c37: [{
          required: true, message: '请输入噪声', trigger: 'change,blur'
        }],
        c38: [{
          required: true, message: '请输入外形长度尺寸', trigger: 'change,blur'
        }],
        c39: [{
          required: true, message: '请输入出风罩', trigger: 'change,blur'
        }],
        c41: [{
          required: true, message: '请输入牌号及规格/型号', trigger: 'change,blur'
        }],
        c42: [{
          required: true, message: '请输入生产者', trigger: 'change,blur'
        }],
        c47: [{
          required: true, message: '请输入牌号及规格/型号', trigger: 'change,blur'
        }],
        c48: [{
          required: true, message: '请输入生产者', trigger: 'change,blur'
        }]
      }
    }
  }
}
</script>
<style>
@import '../../../css/comm.css';
</style>
