<template>
  <div class="wrapper">
    <Form ref="formRecord" :model="formRecord" label-position="right" :rules="ruleRecord">
      <h1>商用燃气灶具能源效率标识备案表</h1>
      <div class="part part1">
        <Card :bordered="false">
          <h2>一、备案方声明</h2>
          <p>本组织保证如下：</p>
          <p>使用的能源效率标识信息与备案信息一致；</p>
          <p>本型号产品变更能源效率标识时，向授权机构更新备案；</p>
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
          <h2>三、能源效率标识标注的信息</h2>
          <FormItem prop="c1" label="生产者名称" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c1" placeholder="生产者名称" readonly disabled />
          </FormItem>
          <FormItem prop="c3" label="制造单位" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c3" :disabled='disabledoff' placeholder="制造单位"/>
          </FormItem>
          <FormItem prop="c5" label="备案方" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c5" :disabled='disabledoff' placeholder="备案方"/>
          </FormItem>
          <FormItem prop="c4" label="产品规格型号" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c4" :disabled='!disabledoff' placeholder="规格型号"/>
          </FormItem>
          <FormItem prop="c2" label="商标" style="width:100%" :label-width="180">
            <Input type="text" v-model="formRecord.c2" :disabled='disabledoff' placeholder="商标"/>
          </FormItem>
          <FormItem prop="c200" label="依据国家标准" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c200" placeholder="依据国家标准" readonly disabled/>
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
              <td align="center">热效率(%)</td>
              <td>
                <FormItem prop="c8" label="标注值:" style="width:100%;" :label-width="70">
                  <Input type="text" v-model="formRecord.c8" :disabled='disabledoff' placeholder="两位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c9" label="实测值:" style="width:100%;" :label-width="70">
                  <Input type="text" v-model="formRecord.c9" :disabled='disabledoff' placeholder="两位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c10" label="备注:" style="width:100%;" :label-width="70">
                  <Input type="text" v-model="formRecord.c10" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
          </table>
        </Card>
      </div>
      <div class="part part4">
        <Card :bordered="false">
          <h2>四、初始使用日期</h2>
          <FormItem prop="c14" label="备案标识开始使用日期" style="width:100%;">
            <DatePicker type="date" :options="dataInit" style="width: 200px" v-model="formRecord.c14" :disabled='disabledoff'></DatePicker>
          </FormItem>
        </Card>
      </div>
      <div class="part part5">
        <Card :bordered="false">
          <h2>五、其他信息</h2>
          <h3>样品描述</h3>
          <table id="table3">
            <tr>
              <td align="right" rowspan="3"><span style="color:red">*</span>燃气类别</td>
              <td colspan="3">
                <FormItem prop="c15">
                  <RadioGroup v-model="formRecord.c15">
                    <Radio label="人工煤气" :disabled='disabledoff'>人工煤气</Radio>
                      <FormItem prop="c16">
                        <RadioGroup v-model="formRecord.c16">
                          <Radio label="5R" :disabled='disabledoff'>5R</Radio>
                          <Radio label="6R" :disabled='disabledoff'>6R</Radio>
                          <Radio label="7R" :disabled='disabledoff'>7R</Radio>
                        </RadioGroup>
                      </FormItem><br><br>
                    <Radio label="天然气" :disabled='disabledoff'>天然气灶具</Radio>
                      <FormItem prop="c16">
                        <RadioGroup v-model="formRecord.c16">
                          <Radio label="4T" :disabled='disabledoff'>4T</Radio>
                          <Radio label="6T" :disabled='disabledoff'>6T</Radio>
                          <Radio label="10T" :disabled='disabledoff'>10T</Radio>
                          <Radio label="12T" :disabled='disabledoff'>12T</Radio>
                        </RadioGroup>
                      </FormItem><br><br>
                    <Radio label="液化石油气" :disabled='disabledoff'>液化石油气灶具</Radio>
                      <FormItem prop="c16">
                        <RadioGroup v-model="formRecord.c16">
                          <Radio label="19Y" :disabled='disabledoff'>19Y</Radio>
                          <Radio label="20Y" :disabled='disabledoff'>20Y</Radio>
                          <Radio label="22Y" :disabled='disabledoff'>22Y</Radio>
                        </RadioGroup>
                    </FormItem><br><br>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span style="color:red">*</span>电源</td>
              <td colspan="3">
                <FormItem prop="c17">
                  <RadioGroup v-model="formRecord.c17">
                    <Radio label="直流" :disabled='disabledoff'>直流</Radio>
                    <FormItem prop="c18" style="width:100%;" :label-width="0">
                      <Input type="text" v-model="formRecord.c18" :disabled='disabledoff'/>V
                    </FormItem>
                    <FormItem prop="c19" style="width:100%;" :label-width="0">
                      <Input type="text" v-model="formRecord.c19" :disabled='disabledoff'/>mA
                    </FormItem>
                    <Radio label="交流" :disabled='disabledoff'>交流</Radio>
                    <FormItem prop="c18" style="width:100%;" :label-width="0">
                      <Input type="text" v-model="formRecord.c18" :disabled='disabledoff'/>V
                    </FormItem>
                    <FormItem prop="c19" style="width:100%;" :label-width="0">
                      <Input type="text" v-model="formRecord.c19" :disabled='disabledoff'/>mA
                    </FormItem>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span style="color:red">*</span>稳压器</td>
              <td colspan="3">
                <FormItem prop="c20">
                  <RadioGroup v-model="formRecord.c20">
                    <Radio label="有" :disabled='disabledoff'>有</Radio>
                    <Radio label="无" :disabled='disabledoff'>无</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span style="color:red">*</span>额定功率(kW)</td>
              <td>
                <FormItem prop="c21" style="width:100%;" :label-width="0">
                  <Input type="text" v-model="formRecord.c21" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td align="right"><span style="color:red">*</span>运行噪声等级</td>
              <td>
                <FormItem prop="c22" style="width:100%;" :label-width="0">
                  <Input type="text" v-model="formRecord.c22" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span style="color:red">*</span>产品类别</td>
              <td>
                <FormItem prop="c23">
                  <RadioGroup v-model="formRecord.c23">
                    <Radio label="中餐燃气炒菜灶" :disabled='disabledoff'>中餐燃气炒菜灶</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c23">
                  <RadioGroup v-model="formRecord.c23">
                    <Radio label="炊用燃气大锅灶" :disabled='disabledoff'>炊用燃气大锅灶</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c23">
                  <RadioGroup v-model="formRecord.c23">
                    <Radio label="燃气蒸箱" :disabled='disabledoff'>燃气蒸箱</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span style="color:red">*</span>空气供给方式</td>
              <td>
                <FormItem prop="c24">
                  <RadioGroup v-model="formRecord.c24">
                    <Radio label="鼓风预混式" :disabled='disabledoff'>鼓风预混式</Radio>
                    <Radio label="鼓风扩散式" :disabled='disabledoff'>鼓风扩散式</Radio>
                    <Radio label="引射大气式" :disabled='disabledoff'>引射大气式</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c25">
                  <RadioGroup v-model="formRecord.c25">
                    <Radio label="强制排气式" :disabled='disabledoff'>强制排气式</Radio>
                    <Radio label="鼓风预混式" :disabled='disabledoff'>鼓风预混式</Radio>
                    <Radio label="鼓风扩散式" :disabled='disabledoff'>鼓风扩散式</Radio>
                    <Radio label="引射大气式" :disabled='disabledoff'>引射大气式</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c26">
                  <RadioGroup v-model="formRecord.c26">
                    <Radio label="强制排气式" :disabled='disabledoff'>强制排气式</Radio>
                    <Radio label="鼓风预混式" :disabled='disabledoff'>鼓风预混式</Radio>
                    <Radio label="鼓风扩散式" :disabled='disabledoff'>鼓风扩散式</Radio>
                    <Radio label="引射大气式" :disabled='disabledoff'>引射大气式</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span style="color:red">*</span>灶眼数</td>
              <td>
                <FormItem prop="c27">
                  <RadioGroup v-model="formRecord.c27">
                    <Radio label="单眼灶" :disabled='disabledoff'>单眼灶</Radio>
                    <Radio label="双眼灶" :disabled='disabledoff'>双眼灶</Radio>
                    <Radio label="多眼灶" :disabled='disabledoff'></Radio>
                    <FormItem prop="c28" style="width:100%;" :label-width="0">
                      <Input type="text" v-model="formRecord.c28" :disabled='disabledoff'/>眼灶
                    </FormItem>
                  </RadioGroup>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c29">
                  <RadioGroup v-model="formRecord.c29">
                    <Radio label="单眼灶" :disabled='disabledoff'>单眼灶</Radio>
                    <Radio label="双眼灶" :disabled='disabledoff'>双眼灶</Radio>
                    <Radio label="多眼灶" :disabled='disabledoff'></Radio>
                  </RadioGroup>
                </FormItem>
                <FormItem prop="c30" style="width:100%;" :label-width="0">
                  <Input type="text" v-model="formRecord.c30" :disabled='disabledoff'/>眼灶
                </FormItem>
              </td>
              <td align="center">/</td>
            </tr>
            <tr>
              <td align="right"><span style="color:red">*</span>点火方式/<br>常明火点火方式</td>
              <td>
                <FormItem prop="c31">
                  <CheckboxGroup v-model="formRecord.c31">
                    <Checkbox label="常明火(必选)" :disabled='disabledoff'>常明火(必选)</Checkbox>
                    <Checkbox label="人工点火装置" :disabled='disabledoff'>人工点火装置</Checkbox>
                    <Checkbox label="电点火器" :disabled='disabledoff'>电点火器</Checkbox>
                  </CheckboxGroup>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c32">
                  <CheckboxGroup v-model="formRecord.c32">
                    <Checkbox label="点火燃烧器(必选)" :disabled='disabledoff'>点火燃烧器(必选)</Checkbox>
                    <Checkbox label="人工点火装置" :disabled='disabledoff'>人工点火装置</Checkbox>
                    <Checkbox label="电点火器" :disabled='disabledoff'>电点火器</Checkbox>
                  </CheckboxGroup>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c33">
                  <CheckboxGroup v-model="formRecord.c33">
                    <Checkbox label="常明火" :disabled='disabledoff'>常明火</Checkbox>
                    <Checkbox label="自动程序控制点火" :disabled='disabledoff'>自动程序控制点火</Checkbox>
                  </CheckboxGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span style="color:red">*</span>熄火保护装置形式/<br>火焰监控装置形式</td>
              <td>
                <FormItem prop="c34">
                  <CheckboxGroup v-model="formRecord.c34">
                    <Checkbox label="热电偶方式" :disabled='disabledoff'>热电偶方式</Checkbox>
                    <Checkbox label="离子感应式" :disabled='disabledoff'>离子感应式</Checkbox>
                    <Checkbox label="其它方式" :disabled='disabledoff'>其它方式</Checkbox>
                  </CheckboxGroup>
                </FormItem>
                <FormItem prop="c35" style="width:100%;" :label-width="0">
                  <Input type="text" v-model="formRecord.c35" :disabled='disabledoff'/>(可选)
                </FormItem>
              </td>
              <td>
                <FormItem prop="c36">
                  <CheckboxGroup v-model="formRecord.c36">
                    <Checkbox label="热电偶方式" :disabled='disabledoff'>热电偶方式</Checkbox>
                    <Checkbox label="离子感应式" :disabled='disabledoff'>离子感应式</Checkbox>
                    <Checkbox label="其它方式" :disabled='disabledoff'>其它方式</Checkbox>
                  </CheckboxGroup>
                </FormItem>
                <FormItem prop="c37" style="width:100%;" :label-width="0">
                  <Input type="text" v-model="formRecord.c37" :disabled='disabledoff'/>(必选)
                </FormItem>
              </td>
              <td>
                <FormItem prop="c38">
                  <CheckboxGroup v-model="formRecord.c38">
                    <Checkbox label="热电偶方式" :disabled='disabledoff'>热电偶方式</Checkbox>
                    <Checkbox label="离子感应式" :disabled='disabledoff'>离子感应式</Checkbox>
                    <Checkbox label="其它方式" :disabled='disabledoff'>其它方式</Checkbox>
                  </CheckboxGroup>
                </FormItem>
                <FormItem prop="c39" style="width:100%;" :label-width="0">
                  <Input type="text" v-model="formRecord.c39" :disabled='disabledoff'/>(必选)
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right" rowspan="7"><span style="color:red">*</span>灶眼直径/热负荷</td>
              <td>
                <FormItem prop="c61" lable="灶眼名称(主火):" style="width:100%;" :label-width="0">
                  <Input type="text" v-model="formRecord.c61" :disabled='disabledoff'/>
                </FormItem>
                <FormItem prop="c40" lable="炉口直径(mm):" style="width:100%;" :label-width="0">
                  <Input type="text" v-model="formRecord.c40" :disabled='disabledoff'/>
                </FormItem>
                <FormItem prop="c11" lable="额定热负荷(kW能效标识标注值):" style="width:100%;" :label-width="0">
                  <Input type="text" v-model="formRecord.c11" :disabled='disabledoff'/>
                </FormItem>
                <FormItem prop="c12" lable="实测热负荷(kW):" style="width:100%;" :label-width="0">
                  <Input type="text" v-model="formRecord.c12" :disabled='disabledoff'/>
                </FormItem>
                <FormItem prop="c63" lable="额定热效率(%):" style="width:100%;" :label-width="0">
                  <Input type="text" v-model="formRecord.c63" :disabled='disabledoff'/>
                </FormItem>
                <FormItem prop="c64" lable="实测热效率(%):" style="width:100%;" :label-width="0">
                  <Input type="text" v-model="formRecord.c64" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c89" lable="灶眼名称(主火):" style="width:100%;" :label-width="0">
                  <Input type="text" v-model="formRecord.c89" :disabled='disabledoff'/>
                </FormItem>
                <FormItem prop="c48" lable="炉口直径(mm):" style="width:100%;" :label-width="0">
                  <Input type="text" v-model="formRecord.c48" :disabled='disabledoff'/>
                </FormItem>
                <FormItem prop="c49" lable="额定热负荷(kW能效标识标注值):" style="width:100%;" :label-width="0">
                  <Input type="text" v-model="formRecord.c49" :disabled='disabledoff'/>
                </FormItem>
                <FormItem prop="c90" lable="实测热负荷(kW):" style="width:100%;" :label-width="0">
                  <Input type="text" v-model="formRecord.c90" :disabled='disabledoff'/>
                </FormItem>
                <FormItem prop="c91" lable="额定热效率(%):" style="width:100%;" :label-width="0">
                  <Input type="text" v-model="formRecord.c91" :disabled='disabledoff'/>
                </FormItem>
                <FormItem prop="c92" lable="实测热效率(%):" style="width:100%;" :label-width="0">
                  <Input type="text" v-model="formRecord.c92" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td rowspan="6">
                <FormItem prop="c56" lable="水胆容量(L):" style="width:100%;" :label-width="0">
                  <Input type="text" v-model="formRecord.c56" :disabled='disabledoff'/>
                </FormItem>
                <FormItem prop="c57" lable="额定热负荷(kW):" style="width:100%;" :label-width="0">
                  <Input type="text" v-model="formRecord.c57" :disabled='disabledoff'/>
                </FormItem>
                <FormItem prop="c117" lable="实测热负荷(kW):" style="width:100%;" :label-width="0">
                  <Input type="text" v-model="formRecord.c117" :disabled='disabledoff'/>
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
              <th width="100">部件名称</th>
              <th>型号规格</th>
              <th>技术参数</th>
              <th>生产者（全称）</th>
            </tr>
            <tr>
              <td align="center" rowspan="4">1</td>
              <td align="center" rowspan="4">燃烧器</td>
            </tr>
            <tr>
              <td>
                <FormItem prop="c118" style="width:100%;">
                  <Input type="text" v-model="formRecord.c118" :disabled='disabledoff' />
                </FormItem>
              </td>
              <td>
                <FormItem prop="c119">
                  <CheckboxGroup v-model="formRecord.c119">
                    <Checkbox label="陶瓷" :disabled='disabledoff'>陶瓷</Checkbox>
                    <Checkbox label="金属网" :disabled='disabledoff'>金属网</Checkbox>
                    <Checkbox label="硬质不锈钢" :disabled='disabledoff'>硬质不锈钢</Checkbox>
                    <Checkbox label="铁质" :disabled='disabledoff'>铁质</Checkbox>
                    <Checkbox label="其他" :disabled='disabledoff'>其他</Checkbox>
                  </CheckboxGroup>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c120" style="width:100%;">
                  <Input type="text" v-model="formRecord.c120" :disabled='disabledoff' />
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>
                <FormItem prop="c121" style="width:100%;">
                  <Input type="text" v-model="formRecord.c121" :disabled='disabledoff' />
                </FormItem>
              </td>
              <td>
                <FormItem prop="c122">
                  <CheckboxGroup v-model="formRecord.c122">
                    <Checkbox label="陶瓷" :disabled='disabledoff'>陶瓷</Checkbox>
                    <Checkbox label="金属网" :disabled='disabledoff'>金属网</Checkbox>
                    <Checkbox label="硬质不锈钢" :disabled='disabledoff'>硬质不锈钢</Checkbox>
                    <Checkbox label="铁质" :disabled='disabledoff'>铁质</Checkbox>
                    <Checkbox label="其他" :disabled='disabledoff'>其他</Checkbox>
                  </CheckboxGroup>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c123" style="width:100%;">
                  <Input type="text" v-model="formRecord.c123" :disabled='disabledoff' />
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
        <!-- <Button type="primary" @click="submitRecord" :disabled="submitDisabled">提交备案审核申请</Button> -->
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
    <!--<Modal v-model="modal2" title="提交工单" @on-ok="submitWorkorder">
      <p style="font-size:18px;margin-bottom:10px;">实验室数值：{{currentValue}}</p>
      <Input type="textarea" :rows="3" placeholder="请描述问题" v-model="qus"></Input>
    </Modal>-->
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
      thisDateCV: 'c11',
      // 当前能效等级 对应的C值
      thisLevelCV: 'c64',
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
        c11: new Date(),
        c12: '',
        c13: '',
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
        c51: true,
        c56: false,
        c65: false,
        c66: false,
        c57: false,
        c67: false,
        c68: false,
        c58: false,
        c69: false,
        c70: false,
        zkgx: true,
        pbx: true
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
    },
    getNxdj(type, ctp){
       if (type == "紧凑式") {
            if (ctp >= 0.5) {
                return "1";
            } else if (ctp >= 0.32 && ctp < 0.5) {
                return "2";
            } else if (ctp >= 0.1 && ctp < 0.32) {
                return "3";
            } else {
                return "error";
            }
        } else if (type == "分离直接式(分体单回路)") {
            if (ctp >= 0.48) {
                return "1";
            } else if (ctp >= 0.3 && ctp < 0.48) {
                return "2";
            } else if (ctp >= 0.1 && ctp < 0.30) {
                return "3";
            } else {
                return "error";
            }
        } else if (type == "分离间接式(分体双回路)") {
            if (ctp >= 0.45) {
                return "1";
            } else if (ctp >= 0.28 && ctp < 0.45) {
                return "2";
            } else if (ctp >= 0.1 && ctp < 0.28) {
                return "3";
            } else {
                return "error";
            }
        } else if (type == "闷晒式") {
            if (ctp >= 0.6) {
                return "1";
            } else if (ctp >= 0.4 && ctp < 0.6) {
                return "2";
            } else if (ctp >= 0.1 && ctp < 0.4) {
                return "3";
            } else {
                return "error";
            }
        }
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
      //let _c5=this.formRecord.c5;
      //辅助能源类别-其他 启用/禁用
      if (this.formRecord.c12 == '其他') {
          this.forbidden.c63 = false
      } else {
          this.formRecord.c63 = ''
          this.forbidden.c63 = true
      }

      //真空管型集热器-类型 启用/禁用
      if (this.formRecord.c16 == '其他') {
          this.forbidden.c17 = false
      } else {
          this.formRecord.c17 = ''
          this.forbidden.c17 = true
      }

      //热管型 启用/禁用
      if (this.formRecord.c18 == '其他') {
          this.forbidden.c19 = false
      } else {
          this.formRecord.c19 = ''
          this.forbidden.c19 = true
      }

      //吸热板材质 启用/禁用
      if (this.formRecord.c23 == '其他') {
          this.forbidden.c24 = false
      } else {
          this.formRecord.c24 = ''
          this.forbidden.c24 = true
      }

      //吸收涂层工艺 启用/禁用
      if (this.formRecord.c26 == '其他') {
          this.forbidden.c27 = false
      } else {
          this.formRecord.c27 = ''
          this.forbidden.c27 = true
      }

      //集热器用户传热工质接触部位的材料 启用/禁用
      if (this.formRecord.c28 == '其他') {
          this.forbidden.c29 = false
      } else {
          this.formRecord.c29 = ''
          this.forbidden.c29 = true
      }

      //集热器盖板类型 启用/禁用
      if (this.formRecord.c31 == '其他') {
          this.forbidden.c32 = false
      } else {
          this.formRecord.c32 = ''
          this.forbidden.c32 = true
      }

      //集热器盖板厚度 启用/禁用
      if (this.formRecord.c33 == '其他') {
          this.forbidden.c34 = false
      } else {
          this.formRecord.c34 = ''
          this.forbidden.c34 = true
      }

      //保温棉材料 启用/禁用
      if (this.formRecord.c35 == '其他') {
          this.forbidden.c36 = false
      } else {
          this.formRecord.c36 = ''
          this.forbidden.c36 = true
      }

      //集热器背板材料 启用/禁用
      if (this.formRecord.c37 == '其他') {
          this.forbidden.c38 = false
      } else {
          this.formRecord.c38 = ''
          this.forbidden.c38 = true
      }

      //贮热水箱换热器材质 启用/禁用
      if (this.formRecord.c42 == '其他') {
          this.forbidden.c43 = false
      } else {
          this.formRecord.c43 = ''
          this.forbidden.c43 = true
      }

      //贮热水箱换热器结构 启用/禁用
      if (this.formRecord.c44 == '其他') {
          this.forbidden.c45 = false
      } else {
          this.formRecord.c45 = ''
          this.forbidden.c45 = true
      }

      //贮热水箱用于隔热体材料 启用/禁用
      if (this.formRecord.c46 == '其他') {
          this.forbidden.c47 = false
      } else {
          this.formRecord.c47 = ''
          this.forbidden.c47 = true
      }

      //内胆形状 启用/禁用
      if (this.formRecord.c48 == '其他') {
          this.forbidden.c49 = false
      } else {
          this.formRecord.c49 = ''
          this.forbidden.c49 = true
      }

      //内胆材质 启用/禁用
      if (this.formRecord.c50 == '其他') {
          this.forbidden.c51 = false
      } else {
          this.formRecord.c51 = ''
          this.forbidden.c51 = true
      }

      //集热器类型及面积
      if (this.formRecord.c14 == '真空管型') {
          this.forbidden.zkgx=false
          this.forbidden.pbx=true
          this.formRecord.c23 = ''
          this.formRecord.c24 = ''
          this.formRecord.c25 = ''
          this.formRecord.c26 = ''
          this.formRecord.c27 = ''
          this.formRecord.c28 = ''
          this.formRecord.c29 = ''
          this.formRecord.c30 = ''
          this.formRecord.c31 = ''
          this.formRecord.c32 = ''
          this.formRecord.c33 = ''
          this.formRecord.c34 = ''
          this.formRecord.c35 = ''
          this.formRecord.c36 = ''
          this.formRecord.c37 = ''
          this.formRecord.c38 = ''
      }else{
          this.forbidden.pbx=false
          this.forbidden.zkgx=true
          this.formRecord.c16 = ''
          this.formRecord.c17 = ''
          this.formRecord.c18 = ''
          this.formRecord.c19 = ''
          this.formRecord.c20 = ''
          this.formRecord.c21 = ''
          this.formRecord.c22 = ''
      }

      //是否为一体机 启用/禁用
      if (this.formRecord.c71 == '是') {
          this.formRecord.c57 = ''
          this.formRecord.c67 = ''
          this.formRecord.c68 = ''
          this.formRecord.c58 = ''
          this.formRecord.c69 = ''
          this.formRecord.c70 = ''
          this.forbidden.c57 = true
          this.forbidden.c67 = true
          this.forbidden.c68 = true
          this.forbidden.c58 = true
          this.forbidden.c69 = true
          this.forbidden.c70 = true
          this.forbidden.c56 = false
          this.forbidden.c65 = false
          this.forbidden.c66 = false
      } else {
          this.forbidden.c57 = false
          this.forbidden.c67 = false
          this.forbidden.c68 = false
          this.forbidden.c58 = false
          this.forbidden.c69 = false
          this.forbidden.c70 = false
          this.formRecord.c56 = ''
          this.formRecord.c65 = ''
          this.formRecord.c66 = ''
          this.forbidden.c56 = true
          this.forbidden.c65 = true
          this.forbidden.c66 = true
      }

      var c13 = this.formRecord.c13;
      var c5 = this.formRecord.c5;
      var result = this.getNxdj(c13, c5);
      const checkc64 = (rule, value, callback) => {
           if (result == "error") {
              callback('系统提示备案数据不在备案范围，校验结束。')
           }else{
             var nxdj = this.formRecord.c64;
              if (result != nxdj) {
                callback('能效等级校验错误。')
              } else {
                callback()
              }
           }
      }

      return {
        c3: [
          {
            required: true,
            message: '请输入制造单位',
            trigger: 'change,blur'
          }
        ],
        c59: [
          {
            required: true,
            message: '请输入备案方',
            trigger: 'change,blur'
          }
        ],
        c2: [
          {
            required: true,
            message: '请输入产品规格型号',
            trigger: 'change,blur'
          }
        ],
        c4: [
          {
            required: true,
            message: '请输入商标',
            trigger: 'change,blur'
          }
        ],
        c200: [
          {
            required: true,
            message: '请输入依据国家标准',
            trigger: 'change,blur'
          }
        ],
        c64: [
          {
            required: true,
            message: '请选择能效等级',
            trigger: 'change,blur'
          },
          {
            validator: checkc64,
            trigger: 'change,blur'
          }
        ],
        c5: [
          {
            required: true,
            message: '请输入',
            trigger: 'change,blur'
          },
          {
            validator: twoDecimals,
            trigger: 'change,blur'
          }
        ],
        c6: [
          {
            required: true,
            message: '请输入',
            trigger: 'change,blur'
          },
          {
            validator: twoDecimals,
            trigger: 'change,blur'
          }
        ],
        c7: [
          {
            required: true,
            message: '请输入',
            trigger: 'change,blur'
          },
          {
            validator: oneDecimals,
            trigger: 'change,blur'
          }
        ],
        c8: [
          {
            required: true,
            message: '请输入',
            trigger: 'change,blur'
          },
          {
            validator: oneDecimals,
            trigger: 'change,blur'
          }
        ],
        c9: [
          {
            required: true,
            message: '请输入',
            trigger: 'change,blur'
          }
        ],
        c10: [
          {
            required: true,
            message: '请输入',
            trigger: 'change,blur'
          }
        ],
        c11: [
          {
            required: true,
            message: '请输入备案起始日期'
          }
        ],
        c12: [
          {
            required: true,
            message: '请选择',
            trigger: 'change,blur'
          }
        ],
        c63: [
          {
              required: this.formRecord.c12 === '其他',
              message: '其他不能为空',
            trigger: 'change,blur'
          }
        ],
        c13: [
          {
            required: true,
            message: '请选择',
            trigger: 'change,blur'
          }
        ],
        c14: [
          {
            required: true,
            message: '请选择',
            trigger: 'change,blur'
          }
        ],
        c15: [
          {
            required: true,
            message: '请输入',
            trigger: 'change,blur'
          },
          {
            validator: twoDecimals,
            trigger: 'change,blur'
          }
        ],
        c16: [
          {
            required: this.formRecord.c14 == '真空管型',
            message: '请选择',
            trigger: 'change,blur'
          }
        ],
        c17: [
          {
            required: this.formRecord.c16 === '其他',
            message: '其他不能为空',
            trigger: 'change,blur'
          }
        ],
        c18: [
          {
            required: this.formRecord.c14 == '真空管型',
            message: '请选择',
            trigger: 'change,blur'
          }
        ],
        c19: [
          {
            required: this.formRecord.c18 === '其他',
            message: '其他不能为空',
            trigger: 'change,blur'
          }
        ],
        c20: [
          {
            required: this.formRecord.c14 == '真空管型',
            message: '请输入',
            trigger: 'change,blur'
          },
          {
            validator: this.formRecord.c14 === '真空管型' ? oneDecimals : check,
            trigger: 'change,blur'
          }
        ],
        c21: [
          {
            required: this.formRecord.c14 == '真空管型',
            message: '请输入',
            trigger: 'change,blur'
          }
        ],
        c22: [
          {
            required: this.formRecord.c14 == '真空管型',
            message: '请输入',
            trigger: 'change,blur'
          }
        ],
        c23: [
          {
            required: this.formRecord.c14 == '平板型',
            message: '请选择',
            trigger: 'change,blur'
          }
        ],
        c24: [
          {
            required: this.formRecord.c23 === '其他',
            message: '其他不能为空',
            trigger: 'change,blur'
          }
        ],
        c25: [
          {
            required: this.formRecord.c14 == '平板型',
            message: '请输入',
            trigger: 'change,blur'
          }
        ],
        c26: [
          {
            required: this.formRecord.c14 == '平板型',
            message: '请选择',
            trigger: 'change,blur'
          }
        ],
        c27: [
          {
            required: this.formRecord.c26 === '其他',
            message: '其他不能为空',
            trigger: 'change,blur'
          }
        ],
        c28: [
          {
            required: this.formRecord.c14 == '平板型',
            message: '请选择',
            trigger: 'change,blur'
          }
        ],
        c29: [
          {
            required: this.formRecord.c28 === '其他',
            message: '其他不能为空',
            trigger: 'change,blur'
          }
        ],
        c30: [
          {
            required: this.formRecord.c14 == '平板型',
            message: '请输入',
            trigger: 'change,blur'
          }
        ],
        c31: [
          {
            required: this.formRecord.c14 == '平板型',
            message: '请选择',
            trigger: 'change,blur'
          }
        ],
        c32: [
          {
            required: this.formRecord.c31 === '其他',
            message: '其他不能为空',
            trigger: 'change,blur'
          }
        ],
        c33: [
          {
            required: this.formRecord.c14 == '平板型',
            message: '请选择',
            trigger: 'change,blur'
          }
        ],
        c34: [
          {
            required: this.formRecord.c33 === '其他',
            message: '其他不能为空',
            trigger: 'change,blur'
          }
        ],
        c35: [
          {
            required: this.formRecord.c14 == '平板型',
            message: '请选择',
            trigger: 'change,blur'
          }
        ],
        c36: [
          {
            required: this.formRecord.c35 === '其他',
            message: '其他不能为空',
            trigger: 'change,blur'
          }
        ],
        c37: [
          {
            required: this.formRecord.c14 == '平板型',
            message: '请选择',
            trigger: 'change,blur'
          }
        ],
        c38: [
          {
            required: this.formRecord.c37 === '其他',
            message: '其他不能为空',
            trigger: 'change,blur'
          }
        ],
        c39: [
          {
            required: true,
            message: '请输入',
            trigger: 'change,blur'
          }
        ],
        c73: [
          {
            required: true,
            message: '请输入',
            trigger: 'change,blur'
          }
        ],
        c74: [
          {
            required: true,
            message: '请输入',
            trigger: 'change,blur'
          }
        ],
        c40: [
          {
            required: true,
            message: '请输入',
            trigger: 'change,blur'
          }
        ],
        c76: [
          {
            required: true,
            message: '请输入',
            trigger: 'change,blur'
          }
        ],
        c77: [
          {
            required: true,
            message: '请输入',
            trigger: 'change,blur'
          }
        ],
        c41: [
          {
            required: true,
            message: '请输入',
            trigger: 'change,blur'
          },
          {
            validator: threeDecimals,
            trigger: 'change,blur'
          }
        ],
        c42: [
          {
            required: true,
            message: '请选择',
            trigger: 'change,blur'
          }
        ],
        c43: [
          {
            required: this.formRecord.c42 === '其他',
            message: '其他不能为空',
            trigger: 'change,blur'
          }
        ],
        c44: [
          {
            required: true,
            message: '请选择',
            trigger: 'change,blur'
          }
        ],
        c45: [
          {
            required: this.formRecord.c44 === '其他',
            message: '其他不能为空',
            trigger: 'change,blur'
          },
          {
            validator: this.formRecord.c44 === '其他' ? twoDecimals : check,
            trigger: 'change,blur'
          }
        ],
        c46: [
          {
            required: true,
            message: '请选择',
            trigger: 'change,blur'
          }
        ],
        c47: [
          {
            required: this.formRecord.c46 === '其他',
            message: '其他不能为空',
            trigger: 'change,blur'
          }
        ],
        c48: [
          {
            required: true,
            message: '请选择',
            trigger: 'change,blur'
          }
        ],
        c49: [
          {
            required: this.formRecord.c48 === '其他',
            message: '其他不能为空',
            trigger: 'change,blur'
          }
        ],
        c50: [
          {
            required: true,
            message: '请选择',
            trigger: 'change,blur'
          }
        ],
        c51: [
          {
            required: this.formRecord.c50 === '其他',
            message: '其他不能为空',
            trigger: 'change,blur'
          }
        ],
        c54: [
          {
            required: true,
            message: '请输入',
            trigger: 'change,blur'
          }
        ],
        c55: [
          {
            required: true,
            message: '请输入',
            trigger: 'change,blur'
          }
        ],
        c53: [
          {
            required: true,
            message: '请选择',
            trigger: 'change,blur'
          }
        ],
        c71: [
          {
            required: true,
            message: '请选择',
            trigger: 'change,blur'
          }
        ],
        c56: [
          {
            required: this.formRecord.c71 === '是',
            message: '请输入'
          }
        ],
        c57: [
          {
            required: this.formRecord.c71 === '否',
            message: '请输入',
            trigger: 'change,blur'
          }
        ],
        c58: [
          {
            required: this.formRecord.c71 === '否',
            message: '请输入',
            trigger: 'change,blur'
          }
        ],
        c65: [
          {
            required: this.formRecord.c71 === '是',
            message: '请输入',
            trigger: 'change,blur'
          }
        ],
        c66: [
          {
            required: this.formRecord.c71 === '是',
            message: '请输入',
            trigger: 'change,blur'
          }
        ],
        c67: [
          {
            required: this.formRecord.c71 === '否',
            message: '请输入',
            trigger: 'change,blur'
          }
        ],
        c68: [
          {
            required: this.formRecord.c71 === '否',
            message: '请输入',
            trigger: 'change,blur'
          }
        ],
        c69: [
          {
           required: this.formRecord.c71 === '否',
            message: '请输入',
            trigger: 'change,blur'
          }
        ],
        c52: [
          {
            required: true,
            message: '请输入',
            trigger: 'change,blur'
          }
        ],
        c70: [
          {
            required: this.formRecord.c71 === '否',
            message: '请输入',
            trigger: 'change,blur'
          }
        ],
        c78: [
          {
            required: true,
            message: '不能为空',
            trigger: 'change,blur'
          }
        ],
        c79: [
          {
            required: true,
            message: '不能为空',
            trigger: 'change,blur'
          }
        ],
        c80: [
          {
            required: true,
            message: '不能为空',
            trigger: 'change,blur'
          }
        ],
        c84: [
          {
            required: true,
            message: '不能为空',
            trigger: 'change,blur'
          }
        ],
        c85: [
          {
            required: true,
            message: '不能为空',
            trigger: 'change,blur'
          }
        ],
        c86: [
          {
            required: true,
            message: '不能为空',
            trigger: 'change,blur'
          }
        ],
        c90: [
          {
            required: true,
            message: '不能为空',
            trigger: 'change,blur'
          }
        ],
        c91: [
          {
            required: true,
            message: '不能为空',
            trigger: 'change,blur'
          }
        ],
        c92: [
          {
            required: true,
            message: '不能为空',
            trigger: 'change,blur'
          }
        ],
        c93: [
          {
            required: true,
            message: '不能为空',
            trigger: 'change,blur'
          }
        ],
        c94: [
          {
            required: true,
            message: '不能为空',
            trigger: 'change,blur'
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
<style lang="less" scoped>

</style>
