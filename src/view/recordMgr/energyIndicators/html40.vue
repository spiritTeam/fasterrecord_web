<!--9、家用电磁灶 2014版-->
<!--创建日期:2019年6月12日-->
<!--创建人:YCL-->
<template>
  <div class="wrapper">
    <Form ref="formRecord" :model="formRecord" label-position="right" :rules="pageType!='extend'?ruleRecord:extendRule">
      <h1>家用电磁灶-能源效率标识备案表</h1>
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
               <th><i class="red">*</i>实验室名称</th>
               <th><i class="red">*</i>检测报告条形码</th>
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
          <FormItem prop="c3" label="制造单位" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c3" placeholder="制造单位" :disabled='disabledoff'/>
          </FormItem>
          <FormItem prop="c20" label="备案方" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c20" placeholder="备案方" :disabled='disabledoff'/>
          </FormItem>
          <FormItem prop="c4" label="产品规格型号" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c4" placeholder="规格型号" :disabled='!disabledoff'/>
          </FormItem>
          <FormItem prop="c2" label="商标" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c2" placeholder="商标" :disabled='pageType=="view"'/>
          </FormItem>
          <FormItem prop="c200" label="依据国家标准" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c200" placeholder="依据国家标准" disabled readonly/>
          </FormItem>
          <FormItem prop="c7" label="能效等级" style="width:100%;" :label-width="180">
            <RadioGroup v-model="formRecord.c7">
              <Radio label="1" :disabled='disabledoff'>1级</Radio>
              <Radio label="2" :disabled='disabledoff'>2级</Radio>
              <Radio label="3" :disabled='disabledoff'>3级</Radio>
            </RadioGroup>
          </FormItem>
          <table id="table1">
            <tr>
              <th>项目</th>
              <th><i class="red">*</i>标注值</th>
              <th><i class="red">*</i>实测值</th>
              <th>备注</th>
            </tr>
            <tr>
              <td>热效率（%）</td>
              <td>
                <FormItem prop="c5">
                  <Input type="text" v-model="formRecord.c5" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c29">
                  <Input type="text" v-model="formRecord.c29" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c27">
                  <Input type="text" v-model="formRecord.c27" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>待机状态功率（W）</td>
              <td>
                <FormItem prop="c6">
                  <Input type="text" v-model="formRecord.c6" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c30">
                  <Input type="text" v-model="formRecord.c30" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c28">
                  <Input type="text" v-model="formRecord.c28" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
          </table>
        </Card>
      </div>
      <div class="part part4">
        <Card :bordered="false">
          <h2>四、初始使用日期</h2>
          <!-- <Form ref="formRecord" :model="formRecord" label-position="left" :label-width="180" :rules="ruleRecord"> -->
          <FormItem prop="c8" label="备案标识开始使用日期" style="width:100%;">
            <DatePicker type="date" :options="dataInit" style="width: 200px" v-model="formRecord.c8"></DatePicker>
          </FormItem>
        </Card>
      </div>
      <div class="part part5">
        <Card :bordered="false">
          <h2>五、样品描述</h2>
          <table id="table3">
            <tr>
              <td><i class="red">*</i>电源类型</td>
              <td>
                <FormItem prop="c11">
                  <RadioGroup v-model="formRecord.c11">
                    <Radio label="AC" :disabled='disabledoff'>AC</Radio>
                    <Radio label="DC" :disabled='disabledoff'>DC</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td><i class="red">*</i>额定电压（V）</td>
              <td>
                <FormItem prop="c26">
                  <Input type="text" v-model="formRecord.c26" :disabled='disabledoff || forbidden.c26'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td><i class="red">*</i>额定频率（Hz）</td>
              <td>
                <FormItem prop="c25">
                  <Input type="text" v-model="formRecord.c25" :disabled='disabledoff || forbidden.c26'/>
                </FormItem>
              </td>
              <td><i class="red">*</i>额定功率（W）</td>
              <td>
                <FormItem prop="c24">
                  <Input type="text" v-model="formRecord.c24" :disabled='disabledoff || forbidden.c26'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td><i class="red">*</i>最大功率档位</td>
              <td>
                <FormItem prop="c32">
                  <Input type="text" v-model="formRecord.c32" :disabled='disabledoff || forbidden.c26'/>
                </FormItem>
              </td>
              <td><i class="red">*</i>防触电保护类型</td>
              <td>
                <FormItem prop="c9">
                  <RadioGroup v-model="formRecord.c9">
                    <Radio label="Ⅰ类" :disabled='disabledoff'>Ⅰ类</Radio>
                    <Radio label="Ⅱ类" :disabled='disabledoff'>Ⅱ类</Radio>
                    <Radio label="Ⅲ类" :disabled='disabledoff'>Ⅲ类</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td><i class="red">*</i>防护等级</td>
              <td>
                <FormItem><label>IP</label></FormItem>
                <FormItem prop="c10">
                  <Input type="text" v-model="formRecord.c10" :disabled='disabledoff || forbidden.c26'/>
                </FormItem>
              </td>
              <td><i class="red">*</i>输入插口</td>
              <td>
                <FormItem prop="c12">
                  <RadioGroup v-model="formRecord.c12">
                    <Radio label="有" :disabled='disabledoff'>有</Radio>
                    <Radio label="无" :disabled='disabledoff'>无</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td><i class="red">*</i>温控器</td>
              <td>
                <FormItem prop="c13">
                  <RadioGroup v-model="formRecord.c13">
                    <Radio label="有" :disabled='disabledoff'>有</Radio>
                    <Radio label="无" :disabled='disabledoff'>无</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td><i class="red">*</i>控制方式</td>
              <td>
                <FormItem prop="c16">
                  <RadioGroup v-model="formRecord.c16">
                    <Radio label="机械控制" :disabled='disabledoff || forbidden.c16'>机械控制</Radio>
                    <Radio label="电子控制" :disabled='disabledoff || forbidden.c16'>电子控制</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td><i class="red">*</i>热断路器类型</td>
              <td colspan="3" style="border-bottom:none;">
                <FormItem prop="c14">
                  <CheckboxGroup v-model="formRecord.c14">
                    <Checkbox label="热敏电阻" :disabled='disabledoff'>热敏电阻</Checkbox>
                    <Checkbox label="双金属片式" :disabled='disabledoff'>双金属片式</Checkbox>
                    <Checkbox label="自复位式" :disabled='disabledoff'>自复位式</Checkbox>
                    <Checkbox label="非自复位式" :disabled='disabledoff'>非自复位式</Checkbox>
                    <Checkbox label="软件" :disabled='disabledoff'>软件</Checkbox>
                    <Checkbox label="其它" :disabled='disabledoff'>其它</Checkbox>
                  </CheckboxGroup>
                </FormItem>
                <FormItem prop="c21">
                  <Input type="text" v-model="formRecord.c21" :disabled='disabledoff || forbidden.c21'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td><i class="red">*</i>器具类型</td>
              <td colspan="3">
                <FormItem prop="c15">
                  <RadioGroup v-model="formRecord.c15">
                    <Radio label="单灶" :disabled='disabledoff'>单灶</Radio>
                    <Radio label="双灶" :disabled='disabledoff'>双灶</Radio>
                    <Radio label="多灶" :disabled='disabledoff'>多灶</Radio>
                  </RadioGroup>
                </FormItem>
                <br/>
                <FormItem prop="c31">
                  <RadioGroup v-model="formRecord.c31">
                    <Radio label="便携式" :disabled='disabledoff'>便携式</Radio>
                    <Radio label="驻立式" :disabled='disabledoff'>驻立式</Radio>
                    <Radio label="嵌入式" :disabled='disabledoff'>嵌入式</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td><i class="red">*</i>二次供电方式</td>
              <td colspan="3">
                <FormItem prop="c17">
                  <RadioGroup v-model="formRecord.c17">
                    <Radio label="安全隔离变压器" :disabled='disabledoff'>安全隔离变压器</Radio>
                    <Radio label="开关电源" :disabled='disabledoff'>开关电源</Radio>
                    <Radio label="其它" :disabled='disabledoff'>其它</Radio>
                  </RadioGroup>
                </FormItem>
                <FormItem prop="c18">
                  <Input type="text" v-model="formRecord.c18" :disabled='disabledoff || forbidden.c18'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td><i class="red">*</i>外形尺寸（长×宽×高）（mm×mm×mm）</td>
              <td colspan="3" class="w19">
                <FormItem prop="c19">
                  <Input style="vertical-align:top" type="text" v-model="formRecord.c19" :disabled='disabledoff'/>
                </FormItem>
                <FormItem><b>×</b></FormItem>
                <FormItem prop="c22">
                  <Input type="text" v-model="formRecord.c22" :disabled='disabledoff'/>
                </FormItem>
                <FormItem><b>×</b></FormItem>
                <FormItem prop="c23">
                  <Input type="text" v-model="formRecord.c23" :disabled='disabledoff'/>
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
              <th>序号</th>
              <th>名称</th>
              <th>牌号及规格/型号/物料代码</th>
              <th>生产者（全称）</th>
            </tr>
            <tr>
              <td>1</td>
              <td>大功率晶体管（IGBT）</td>
              <td>
                <FormItem prop="c33">
                  <Input type="text" v-model="formRecord.c33" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c34">
                  <Input type="text" v-model="formRecord.c34" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>2</td>
              <td>大功率晶体管（IGBT）</td>
              <td>
                <FormItem prop="c35">
                  <Input type="text" v-model="formRecord.c35" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c36">
                  <Input type="text" v-model="formRecord.c36" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>3</td>
              <td>大功率晶体管（IGBT）</td>
              <td>
                <FormItem prop="c37">
                  <Input type="text" v-model="formRecord.c37" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c38">
                  <Input type="text" v-model="formRecord.c38" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>4</td>
              <td>电路板</td>
              <td>
                <FormItem prop="c39">
                  <Input type="text" v-model="formRecord.c39" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c40">
                  <Input type="text" v-model="formRecord.c40" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>5</td>
              <td>电路板</td>
              <td>
                <FormItem prop="c41">
                  <Input type="text" v-model="formRecord.c41" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c42">
                  <Input type="text" v-model="formRecord.c42" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>6</td>
              <td>电路板</td>
              <td>
                <FormItem prop="c43">
                  <Input type="text" v-model="formRecord.c43" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c44">
                  <Input type="text" v-model="formRecord.c44" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>7</td>
              <td>灶面材料</td>
              <td>
                <FormItem prop="c45">
                  <Input type="text" v-model="formRecord.c45" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c46">
                  <Input type="text" v-model="formRecord.c46" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>8</td>
              <td>灶面材料</td>
              <td>
                <FormItem prop="c47">
                  <Input type="text" v-model="formRecord.c47" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c48">
                  <Input type="text" v-model="formRecord.c48" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>9</td>
              <td>灶面材料</td>
              <td>
                <FormItem prop="c49">
                  <Input type="text" v-model="formRecord.c49" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c50">
                  <Input type="text" v-model="formRecord.c50" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>10</td>
              <td>线圈盘</td>
              <td>
                <FormItem prop="c51">
                  <Input type="text" v-model="formRecord.c51" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c52">
                  <Input type="text" v-model="formRecord.c52" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>11</td>
              <td>线圈盘</td>
              <td>
                <FormItem prop="c53">
                  <Input type="text" v-model="formRecord.c53" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c54">
                  <Input type="text" v-model="formRecord.c54" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>12</td>
              <td>线圈盘</td>
              <td>
                <FormItem prop="c55">
                  <Input type="text" v-model="formRecord.c55" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c56">
                  <Input type="text" v-model="formRecord.c56" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td colspan="4">备注：如上述零部件属多个生产者，均应按上述要求逐一填写。</td>
            </tr>
          </table>
        </Card>
      </div>
      <div class="part part7">
        <Card :bordered="false">
          <h2>七、其它认证信息</h2>
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
          <div class="application" v-if='pageType && pageType!="view"'>
            <span><i class="red">*</i>{{pageType==="extend"?'扩展':'变更'}}申请书</span>
            <Button type="primary" @click="modal5=true">填写{{pageType==="extend"?'扩展':'变更'}}申请书</Button>
            <span>{{formRecord.ec_master_kuozhan_text===''?'未填写':'已填写'}}</span>
          </div>
          <table>
            <tr>
              <td><span class="red">*</span>产品正面图片</td>
              <td>(JPG/PNG)</td>
              <td>
                <div class="lookOver" v-show="uploadParam.filePath24"><Button @click="showImg(uploadParam.filePath24)" icon="ios-glasses-outline"  type="primary">查看</Button></div>
                <div v-if="pageType!='view'">
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
              <td v-show="pageType==='view'">能效标识样本</td>
              <td v-show="pageType==='view'">(PNG)</td>
              <td colspan="3" v-if="pageType !=='view' && pltId != 244">
                根据企业提交的相关信息，系统直接生成能效标识样本，请提交备案后在"备案查询"功能中下载
                <!-- <Button type="primary" @click="showTemplate">查看</Button> -->
              </td>
              <td v-else-if="pageType==='view'">
                <Button v-show="pltPic" type="primary" @click="showTemplate">查看</Button>
              </td>
              <td colspan="3" v-else>提交备案后，需企业自行上传能效标识样本</td>
            </tr>
            <tr>
              <td>OEM声明<p class="red" v-if="pageType!='view'">请生产者根据自身情况自行上传该附件</p></td>
              <td>(JPG/PNG)</td>
              <td>
                <div class="lookOver" v-show="uploadParam.filePath26"><Button @click="showImg(uploadParam.filePath26)" icon="ios-glasses-outline"  type="primary">查看</Button></div>
                <div v-if="pageType!='view'">
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
              <td>关系证明 <p class="red" v-if="pageType!='view'">境外生产者请上传该附件</p ></td>
              <td>（PDF）</td>
              <td>
                <div class="lookOver" v-show="uploadParam.filePath27"><Button @click="showImg(uploadParam.filePath27)" icon="ios-glasses-outline"  type="primary">查看</Button></div>
                <div v-if="pageType!='view'">
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
                <div v-if="pageType!='view'">
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
              <td>（PDF）</td>
              <td>
                <div class="lookOver" v-show="uploadParam.filePath29"><Button @click="showImg(uploadParam.filePath29)" icon="ios-glasses-outline"  type="primary">查看</Button></div>
                <div v-if="pageType!='view'">
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
              <td>生产者和进口商企业信息表
                <p class="red" v-if="pageType!='view'">境外生产者请上传该附件</p>
              </td>
              <td>(PDF)</td>
              <td>
                <div class="lookOver" v-show="uploadParam.filePath30"><Button @click="showImg(uploadParam.filePath30)" icon="ios-glasses-outline"  type="primary">查看</Button></div>
                <div v-if="pageType!='view'">
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
              <td>生产者和进口商营业执照或登记注册证明复印件
                <p class="red" v-if="pageType!='view'">境外生产者请上传该附件</p>
              </td>
              <td>（PDF）</td>
              <td>
                <div class="lookOver" v-show="uploadParam.filePath31"><Button @click="showImg(uploadParam.filePath31)" icon="ios-glasses-outline"  type="primary">查看</Button></div>
                <div v-if="pageType!='view'">
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
              <td>生产者和进口商与境外生产者订立的相关合同副本
                <p class="red" v-if="pageType!='view'">境外生产者请上传该附件</p>
              </td>
              <td>(PDF)</td>
              <td>
                <div class="lookOver" v-show="uploadParam.filePath32"><Button @click="showImg(uploadParam.filePath32)" icon="ios-glasses-outline"  type="primary">查看</Button></div>
                <div v-if="pageType!='view'">
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
              <td>（PDF/JPG/PNG）</td>
              <td>
                <div class="lookOver" v-show="uploadParam.filePath76"><Button @click="showImg(uploadParam.filePath76)" icon="ios-glasses-outline"  type="primary">查看</Button></div>
                <div v-if="pageType!='view'">
                  <Upload
                    id=76
                    :show-upload-list=false
                    :format="['jpg','jpeg','png','pdf']"
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
          <p class="red" v-if="pageType!='view'">注：<br />1、标“*”内容为必填项；<br />2、所有附件上传文件大小需要控制在2M以内。</p >
        </Card>
      </div>
      <div v-if="pageType!='view'">
        <CheckboxGroup v-model="confirmData">
          <Checkbox label="1"><span style="color:red;font-weight:bold;">我已确认以上数据填写无误！</span></Checkbox>
        </CheckboxGroup>
      </div>
      <div class="tc" v-if="pageType!='view'">
        <Button type="primary" @click="prevStep">上一步</Button>
        <Button type="primary" @click="saveRecord" v-if='!pageType' :disabled="saveDisabled">保存到草稿</Button>
        <!-- <Button type="primary" @click="submitRecord" :disabled="submitDisabled">提交申请</Button> -->
        <Button type="primary" @click="showConfirm">提交申请</Button>
      </div>
      <div class="tc" v-else>
        <Button type="primary" @click="viewClose">关闭</Button>
      </div>
    </Form>
    <Modal v-model="modal1" class="pageStyle" title="提交确认" width="960" ok-text="提交备案" cancel-text="再看看" @on-ok="submitRecord">
      <p v-if="boolFlag.length" style="font-size:16px;font-weight: bolder;text-align: center">以下是实验室报告带入项数值被修改的地方，请您再次确认！</p>
      <div v-if="boolFlag.length" class="diffList">
        <table >
          <thead>
          <tr>
            <th>名称</th>
            <th>实验室报告带入值</th>
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
      <p class="red submitTips" v-if="!boolFlag.length">请再次确认备案信息填写无误！</p>
      <p  class="red submitTips" >若确认，请点击“提交备案”按钮，系统将直接公告备案信息，请务必再次确认信息无误。</p>
    </Modal>
    <!--<Modal v-model="modal2" title="提交工单" @on-ok="submitWorkorder">
      <p style="font-size:18px;margin-bottom:10px;">实验室数值：{{currentValue}}</p>
      <Input type="textarea" :rows="3" placeholder="请描述问题" v-model="qus"></Input>
    </Modal>-->
    <Modal v-model="modal3" :width=820 :footer-hide=true>
      <img :src="templatePic" />
    </Modal>
  <Modal v-model="modal4" :width=820 :footer-hide=true>
    <p v-show="loadText && !uploadPic.includes('.pdf')" style="text-align:center">加载中···</p>
    <img class="lookPdf" v-if="!uploadPic.includes('.pdf')" width="790" :src="uploadPic" @load="templateLoad" />
    <embed class="lookPdf" v-else :src="uploadPic" width="600" height="400" @load="templateLoad" type="application/pdf"  internalinstanceid="81" />
  </Modal>
     <Modal v-model="modal5" class="basic-info pageStyle"  :width=650 ok-text="保存"  @on-ok="submitBasic" cancel-text="关闭">
       <h2>标识型号{{pageType==="extend"?'扩展':'变更'}}备案申请书</h2>
       <p class="org">中国标准化研究院能效标识管理中心：</p>
       <div class="pro-info">
          我 <span  class="f-company">{{formRecord.c1}}</span>
          公司生产的 <span class="f-brand">{{formRecord.c2}}</span>
          品牌的 <span  class="f-model">{{pageType==='extend'?mainModel:formRecord.c4}}</span>
          型号的 <span  class="f-product">家用电磁灶 2014版</span>产品{{pageType==="update"?'已通过能效标识备案':''}}。
       </div>
       <div v-if="pageType==='extend'" class="org regress">
         <p><span></span>正在办理能效标识备案</p>
         <p><span class="bgs"></span>已通过能效标识备案</p>
       </div>
       <div class="org">备案编号:{{recordno}}</div>
       <dl v-if="pageType==='extend'">
          <dt>
              现提出型号扩展备案申请的 <span class="f-model">{{formRecord[thisGZXHCV]}}</span>
              型号是以上述型号为基础开发扩展的型号：
          </dt>
          <dd>a) 其与基础型号同属一个系列；</dd>
          <dd>b) 其整机结构与基础型号基本相同；</dd>
          <dd>c) 其产品的能效性能与基础型号一致；</dd>
          <dd>d) 其在基础型号上只作如下变更（差异描述）：<br>
              <Input class="valid" v-model="formRecord.ec_master_kuozhan_text"  type="textarea" :autosize="{minRows: 2,maxRows: 5}" placeholder="描述"></Input>
              <span class="textarea-annotation">（注：提供相应证明材料） </span><b class="color-red">（请删除上述描述中多余的空格和空行，否则可能打印不完整。）</b>
          </dd>
          <dd>
              特提出免检备案申请，扩展型号的初始使用日期：
              <span class="f-date">{{formatDate(formRecord[thisDateCV])}}</span>
          </dd>
          <dd>请中国标准化研究院能效标识管理中心核准。</dd>
      </dl>
      <dl v-if="pageType==='update'">
          <dd>现申请该型号产品的备案信息如下变更：<br>
              (描述信息产品技术参数等信息)
              <Input class="valid" v-model="formRecord.ec_master_kuozhan_text"  type="textarea" :autosize="{minRows: 2,maxRows: 5}" placeholder="描述"></Input>
              <b class="color-red">（请删除上述描述中多余的空格和空行，否则可能打印不完整。）</b>
          </dd>
          <dd>
              该型号的相关信息变更后的初始使用日期：
              <span class="f-date">{{formatDate(formRecord[thisDateCV])}}</span>
          </dd>
          <dd>请中国标准化研究院能效标识管理中心核准。</dd>
      </dl>
      <div class="record-attached">附：{{pageType==="extend"?'扩展':'变更'}}型号产品的能效标识样本{{pageType==="extend"?'':'以及检测报告'}}</div>
    </Modal>
  </div>
</template>
<script>
  import { mapGetters } from 'vuex';
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
    check,
    numberCheck
  } from '@/libs/utilExt'

  export default {
    data() {
      const timeDate=parseInt(this.$store.state.app.dateinit);
      return {
        // 当前初始使用日期 对应的C值
        thisDateCV: "c8",
        // 当前能效等级 对应的C值
        thisLevelCV: "c7",
        // 当前规格型号 对应的C值
        thisGZXHCV: "c4",
        modal3: false,
        modal4: false,
        modal5: false,
        templatePic: '',
        loadText:true,
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
        mainModel:'',
        formRecord: {
          ec_master_kuozhan_text: '',
          c1: '',
          c3: '',
          c20: '',
          c4: '',
          c2: '',
          c200: '',
          c7: '',
          c5: '',
          c29: '',
          c27: '',
          c6: '',
          c30: '',
          c28: '',
          c8: new Date(),
          c11: '',
          c26: '',
          c25: '',
          c24: '',
          c32: '',
          c9: '',
          c10: '',
          c12: '',
          c13: '',
          c16: '',
          c14: [],
          c21: '',
          c15: '',
          c31: '',
          c17: '',
          c18: '',
          c19: '',
          c22: '',
          c23: '',
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
          c202: '',
          ec_model_no: 40,
          attach_list: ''
        },
        forbidden: {
          c18: true,
          c21: true
        }
      }
    },
    mounted() {
      // this.disabledoff = this.$store.state.app.pageType == "extend" ? true : false
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
      templateLoad(){
        this.loadText=false;
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
        console.log(res);
        if(res.Status){
          this['checkmark' + id] = true
        }else{
          this['checkmark' + id] = false
          this.uploadParam['filePath'+id]=''
          this.$Message.warning('上传失败')
        }

      }
    },
    computed: {
      ...mapGetters([
        'pageType',
        'recordno'
      ]),
      disabledoff(){
        return this.pageType === 'extend' || this.pageType === 'view'
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
      extendRule() {
        return {
          c4: [
            {
              trigger: 'change,blur', required: true,
              message: '产品规格型号不能为空'
            },
            {
              validator: (rule, value, callback) => {
                this.pageType === 'extend' && this.mainModel === this.formRecord[this.thisGZXHCV]? callback('扩展备案需要变更型号名称') : callback()
              },
              trigger: 'change,blur'
            }
          ]
        }
      },
      ruleRecord() {
        if (this.formRecord.c17 === '其它') {
          this.forbidden.c18 = false
        } else {
          this.formRecord.c18 = ''
          this.forbidden.c18 = true
        }
        if (this.formRecord.c14.join('').indexOf('其它') > -1) {
          this.forbidden.c21 = false
        } else {
          this.formRecord.c21 = ''
          this.forbidden.c21 = true
        }
        if (this.formRecord.c13 === '有') {
          this.forbidden.c16 = false
        } else {
          this.formRecord.c16 = ''
          this.forbidden.c16 = true
        }

        var c29 = parseFloat(this.formRecord.c29);
        var c5 = parseFloat(this.formRecord.c5);
        var c30 = parseFloat(this.formRecord.c30);
        var c6 = parseFloat(this.formRecord.c6);
        var nxdj = 0;
        var c24 = parseFloat(this.formRecord.c24);
        var c7 = parseInt(this.formRecord.c7);

        const checkc29 = (rule, value, callback) => {
          if (c29 < c5) {
            callback("热效率值（实测值）应大于等于热效率值（标称值）！");
          } else {
            callback()
          }
        }

        const checkc30 = (rule, value, callback) => {
          if (c30 > c6) {
            callback("待机状态功率（实测值）应小于等于待机状态功率（标称值）！");
          } else {
            callback()
          }
        }

        if (c24 > 1200 && c24 <= 3500) {
          if (c5 >= 90) {
            if (c6 > 0 && c6 <= 1.0) {
              nxdj = 1;
            }
          } else if (c5 >= 88 && c5 < 90) {
            if (c6 > 0 && c6 <= 1.0) {
              nxdj = 2;
            }
          } else if (c5 >= 86 && c5 < 88) {
            if (c6 > 0 && c6 <= 2.0) {
              nxdj = 3;
            }
          }
        } else if (c24 >= 700 && c24 <= 1200) {
          if (c5 >= 88) {
            if (c6 > 0 && c6 <= 1.0) {
              nxdj = 1;
            }
          } else if (c5 >= 86 && c5 < 88) {
            if (c6 > 0 && c6 <= 1.0) {
              nxdj = 2;
            }
          } else if (c5 >= 84 && c5 < 86) {
            if (c6 > 0 && c6 <= 2.0) {
              nxdj = 3;
            }
          }
        }

        const checkc7 = (rule, value, callback) => {
          if (nxdj === 0) {
            callback("能效数据不再备案范围");
          } else if (c7 != nxdj) {
            callback("所选能效等级与计算结果不符");
          } else {
            callback()
          }
        }


        return {
          c3: [
            {
              trigger: 'change,blur',
              required: true,
              message: '制造单位不能为空'
            }
          ],
          c20: [
            {
              trigger: 'change,blur',
              required: true,
              message: '备案方不能为空'
            }
          ],
          c4: [
            {
              trigger: 'change,blur',
              required: true,
              message: '产品规格型号不能为空'
            }
          ],
          c2: [
            {
              trigger: 'change,blur',
              required: true,
              message: '商标不能为空'
            }
          ],
          c200: [
            {
              trigger: 'change,blur',
              required: true,
              message: '依据国家标准不能为空'
            }
          ],
          c7: [
            {
              trigger: 'change,blur',
              required: true,
              message: '能效等级不能为空'
            },
            {
              validator: checkc7,
              trigger: 'blur'
            }
          ],
          c5: [
            {
              trigger: 'change,blur',
              required: true,
              message: '标称值不能为空'
            },
            {
              validator: oneDecimals,
              trigger: 'blur'
            }
          ],
          c29: [
            {
              trigger: 'change,blur',
              required: true,
              message: '实测值不能为空'
            },
            {
              validator: atLeastTwoDecimals,
              trigger: 'blur'
            },
            {
              validator: checkc29,
              trigger: 'blur'
            }
          ],
          c6: [
            {
              trigger: 'change,blur',
              required: true,
              message: '标称值不能为空'
            },
            {
              validator: oneDecimals,
              trigger: 'blur'
            }
          ],
          c30: [
            {
              trigger: 'change,blur',
              required: true,
              message: '实测值不能为空'
            },
            {
              validator: atLeastTwoDecimals,
              trigger: 'blur'
            },
            {
              validator: checkc30,
              trigger: 'blur'
            }
          ],
          c8: [
            {
              required: true,
              message: '备案标识开始使用日期不能为空'
            }
          ],
          c11: [
            {
              trigger: 'change,blur',
              required: true,
              message: '电源类型不能为空'
            }
          ],
          c26: [
            {
              trigger: 'change,blur',
              required: true,
              message: '额定电压不能为空 请输入数字'
            },
            {
              validator: isNumber,
              trigger: 'blur'
            }
          ],
          c25: [
            {
              trigger: 'change,blur',
              required: true,
              message: '额定频率不能为空 请输入数字'
            },
            {
              validator: isNumber,
              trigger: 'blur'
            }
          ],
          c24: [
            {
              trigger: 'change,blur',
              required: true,
              message: '额定功率不能为空 请输入数字'
            },
            {
              validator: isNumber,
              trigger: 'blur'
            }
          ],
          c32: [
            {
              trigger: 'change,blur',
              required: true,
              message: '最大功率档位不能为空'
            }
          ],
          c9: [
            {
              trigger: 'change,blur',
              required: true,
              message: '防触电保护类型不能为空'
            }
          ],
          c10: [
            {
              trigger: 'change,blur',
              required: true,
              message: '防护等级不能为空'
            }
          ],
          c12: [
            {
              trigger: 'change,blur',
              required: true,
              message: '输入插口不能为空'
            }
          ],
          c13: [
            {
              trigger: 'change,blur',
              required: true,
              message: '温控器不能为空'
            }
          ],
          c16: [
            {
              trigger: 'change,blur',
              required: this.formRecord.c13 === '有',
              message: '控制方式不能为空'
            }
          ],
          c14: [
            {
              required: true,
              message: '热断路器类型不能为空'
            }
          ],
          c21: [
            {
              trigger: 'change,blur',
              required: this.formRecord.c14.join('').indexOf('其它') > -1,
              message: '其它不能为空'
            }
          ],
          c15: [
            {
              trigger: 'change,blur',
              required: true,
              message: '器具类型不能为空'
            }
          ],
          c31: [
            {
              trigger: 'change,blur',
              required: true,
              message: '器具类型不能为空'
            }
          ],
          c17: [
            {
              trigger: 'change,blur',
              required: true,
              message: '二次供电方式不能为空'
            }
          ],
          c18: [
            {
              trigger: 'change,blur',
              required: this.formRecord.c17 === '其它',
              message: '其它不能为空'
            },

          ],
          c19: [
            {
              trigger: 'change,blur',
              required: true,
              message: '外形尺寸长不能为空'
            }
          ],
          c22: [
            {
              trigger: 'change,blur',
              required: true,
              message: '外形尺寸宽不能为空'
            }
          ],
          c23: [
            {
              trigger: 'change,blur',
              required: true,
              message: '外形尺寸高不能为空'
            }
          ],
          c33: [
            {
              trigger: 'change,blur',
              required: true,
              message: '不能为空'
            }
          ],
          c34: [
            {
              trigger: 'change,blur',
              required: true,
              message: '不能为空'
            }
          ],
          c39: [
            {
              trigger: 'change,blur',
              required: true,
              message: '不能为空'
            }
          ],
          c40: [
            {
              trigger: 'change,blur',
              required: true,
              message: '不能为空'
            }
          ],
          c45: [
            {
              trigger: 'change,blur',
              required: true,
              message: '不能为空'
            }
          ],
          c46: [
            {
              trigger: 'change,blur',
              required: true,
              message: '不能为空'
            }
          ],
          c51: [
            {
              trigger: 'change,blur',
              required: true,
              message: '不能为空'
            }
          ],
          c52: [
            {
              trigger: 'change,blur',
              required: true,
              message: '不能为空'
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
