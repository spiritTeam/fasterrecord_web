/*
 * 数字电视接收器 2010版
 * 创建日期：2019年6月21号
 * 创建人：wlq
 * 1533201166247242745
 */
<template>
  <div class="wrapper">
    <Form ref="formRecord" :model="formRecord" label-position="right" :rules="ruleRecord">
      <h1>数字电视接收器-能源效率标识备案表</h1>
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
                <Input type="text" :value="$store.state.app.labName" />
              </td>
              <td>
                <Input type="text" :value="$store.state.app.barcode" />
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
          <FormItem prop="c27" label="备案方" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c27" :disabled='disabledoff' placeholder="备案方"/>
          </FormItem>
          <FormItem prop="c3" label="产品规格型号" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c3" :disabled='!disabledoff' placeholder="产品规格型号"/>
          </FormItem>
          <FormItem prop="c4" label="商标" style="width:100%" :label-width="180">
            <Input type="text" v-model="formRecord.c4" :disabled='disabledoff' placeholder="商标"/>
          </FormItem>
          <FormItem prop="c200" label="依据国家标准" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c200" placeholder="依据国家标准" disabled/>
          </FormItem>
          <FormItem prop="c28" label="能效等级" style="width:100%;" :label-width="180">
            <RadioGroup v-model="formRecord.c28">
              <Radio label="1" :disabled='disabledoff'>1级</Radio>
              <Radio label="2" :disabled='disabledoff'>2级</Radio>
              <Radio label="3" :disabled='disabledoff'>3级</Radio>
            </RadioGroup>
          </FormItem>
          <table id="table1">
            <tr>
              <td align="center">工作状态功率</td>
               <td>
                 <FormItem prop="c5" label="标注值：" style="width:100%;" :label-width="80">
                   <Input type="text" v-model="formRecord.c5"  :disabled='disabledoff'/>
                 </FormItem>
              </td>
              <td>
                 <FormItem prop="c6" label="实测值：" style="width:100%;" :label-width="80">
                   <Input type="text" v-model="formRecord.c6" :disabled='disabledoff'/>
                 </FormItem>
              </td>
              <td>
                 <FormItem prop="c7" label="备注："  style="width:100%;" :label-width="80">
                   <Input type="text" v-model="formRecord.c7" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center">被动待机功率</td>
               <td>
                 <FormItem prop="c8" label="标注值：" style="width:100%;" :label-width="80">
                   <Input type="text" v-model="formRecord.c8"  :disabled='disabledoff'/>
                 </FormItem>
              </td>
              <td>
                 <FormItem prop="c9" label="实测值：" style="width:100%;" :label-width="80">
                   <Input type="text" v-model="formRecord.c9" :disabled='disabledoff'/>
                 </FormItem>
              </td>
              <td>
                 <FormItem prop="c10" label="备注："  style="width:100%;" :label-width="80">
                   <Input type="text" v-model="formRecord.c10" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center">附加功能功率因子之和 </td>
               <td>
                 <FormItem prop="c11" label="标注值：" style="width:100%;" :label-width="80">
                   <Input type="text" v-model="formRecord.c11"  :disabled='disabledoff'/>
                 </FormItem>
              </td>
              <td>
                 <FormItem prop="c12" label="实测值：" style="width:100%;" :label-width="80">
                   <Input type="text" v-model="formRecord.c12" :disabled='disabledoff'/>
                 </FormItem>
              </td>
              <td>
                 <FormItem prop="c13" label="备注："  style="width:100%;" :label-width="80">
                   <Input type="text" v-model="formRecord.c13" :disabled='disabledoff'/>
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
          <FormItem prop="c14" label="备案标识开始使用日期" style="width:100%;">
            <DatePicker type="date" :options="dataInit" style="width: 200px" v-model="formRecord.c14" :disabled='disabledoff'></DatePicker>
          </FormItem>
        </Card>
      </div>
      <div class="part part5">
        <Card :bordered="false">
          <h2>五、样品描述</h2>
          <br/>
          <table id="table3">
            <tr>
              <td align="right"><span class="red">*</span>接收器类型</td>
              <td>
                <FormItem prop="c15">
                  <RadioGroup v-model="formRecord.c15">
                    <Radio :disabled='disabledoff' label="有线">有线</Radio>
                    <Radio :disabled='disabledoff' label="地面">地面</Radio>
                    <Radio :disabled='disabledoff' label="卫星">卫星</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td align="right"><span class="red">*</span>信号类型</td>
              <td>
                <FormItem prop="c16">
                  <RadioGroup v-model="formRecord.c16">
                    <Radio :disabled='disabledoff' label="高清">高清</Radio>
                    <Radio :disabled='disabledoff' label="标清">标清</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span class="red">*</span>附加功能</td>
              <td colspan="3">
                <FormItem prop="c17">
                    <CheckboxGroup  v-model="formRecord.c17">
                      <Checkbox :disabled='disabledoff' label="高清输出功能">高清输出功能</Checkbox>
                      <Checkbox :disabled='disabledoff' label="内部硬盘">内部硬盘</Checkbox>
                      <Checkbox :disabled='disabledoff' label="HDMI接口">HDMI接口</Checkbox>
                      <Checkbox :disabled='disabledoff' label="ADSL调制解调器">ADSL调制解调器</Checkbox>
                      <Checkbox :disabled='disabledoff' label="双调谐器">双调谐器</Checkbox>
                      <Checkbox :disabled='disabledoff' label="有线调制解调器">有线调制解调器</Checkbox>
                      <br/>
                      <Checkbox :disabled='disabledoff' label="以太网接口共">以太网接口共</Checkbox>
                      <FormItem prop="c18" style="width:70px">
                        <Input type="text" style="width:50px" v-model="formRecord.c18" :disabled='disabledoff || forbidden.c18'/>个
                      </FormItem>
                      <Checkbox :disabled='disabledoff' label="USB接口共">USB接口共</Checkbox>
                      <FormItem prop="c19" style="width:70px">
                        <Input type="text"  style="width:50px" v-model="formRecord.c19" :disabled='disabledoff || forbidden.c19'/>个
                      </FormItem>
                    </CheckboxGroup>
                </FormItem> 
              </td>
            </tr>
            <tr>
              <td align="right"><span class="red">*</span>测试工况</td>
              <td colspan="3">
                <FormItem prop="c20">
                    <CheckboxGroup  v-model="formRecord.c20">
                      <Checkbox :disabled='disabledoff' label="有线Ⅰ">有线Ⅰ</Checkbox>
                      <Checkbox :disabled='disabledoff' label="有线Ⅱ">有线Ⅱ</Checkbox>
                      <Checkbox :disabled='disabledoff' label="地面Ⅰ">地面Ⅰ</Checkbox>
                      <Checkbox :disabled='disabledoff' label=" 地面Ⅱ"> 地面Ⅱ</Checkbox>
                      <Checkbox :disabled='disabledoff' label="  卫星Ⅰ">  卫星Ⅰ</Checkbox>
                      <Checkbox :disabled='disabledoff' label=" 卫星Ⅱ"> 卫星Ⅱ</Checkbox>
                      <Checkbox :disabled='disabledoff' label=" 卫星Ⅲ"> 卫星Ⅲ</Checkbox>
                    </CheckboxGroup>
                </FormItem>
              </td>
            </tr>
             <tr>
              <td align="right"><span class="red">*</span>供电方式</td>
              <td colspan="3">
                <FormItem prop="c21">
                  <RadioGroup v-model="formRecord.c21">
                    <Radio :disabled='disabledoff' label="内置电源">内置电源</Radio>
                    <Radio :disabled='disabledoff' label="外部电源">外部电源</Radio>
                  </RadioGroup>
                </FormItem>
                <FormItem prop="c22" label="输出功率(W)" :label-width="120">
                   <Input type="text" v-model="formRecord.c22" :disabled='disabledoff || forbidden.c22'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span class="red">*</span>额定电压（V）</td>
              <td>
                <FormItem prop="c23" style="width: 100%">
                  <Input type="text" v-model="formRecord.c23" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td align="right"><span class="red">*</span>额定频率（Hz）</td>
              <td>
                <FormItem prop="c24" style="width: 100%">
                  <Input type="text" v-model="formRecord.c24" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span class="red">*</span>额定输入功率(W)</td>
              <td colspan="3">
                <FormItem prop="c25" style="width: 100%">
                  <Input type="text" v-model="formRecord.c25" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span class="red">*</span>外形尺寸（长×宽×高）mm×mm×mm）</td>
              <td colspan="3">
                <FormItem prop="c26">
                  <Input type="text" style="width:100px" v-model="formRecord.c26" :disabled='disabledoff'/>
                </FormItem>&nbsp;&nbsp;&nbsp;&nbsp;x&nbsp;&nbsp;&nbsp;&nbsp;
                <FormItem prop="c29">
                  <Input type="text" style="width:100px" v-model="formRecord.c29" :disabled='disabledoff'/>
                </FormItem>&nbsp;&nbsp;&nbsp;&nbsp;x&nbsp;&nbsp;&nbsp;&nbsp;
                <FormItem prop="c30">
                  <Input type="text" style="width:100px" v-model="formRecord.c30" :disabled='disabledoff'/>
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
              <th>序号</th>
              <th>部件名称</th>
              <th>位号</th>
              <th>规格型号</th>
              <th colspan="2">技术参数</th>
              <th>生产者（全称）</th>
            </tr>
            </thead>
            <tbody>
              <tr>
                <td width="80" rowspan="7">1</td>
                <td align="center" rowspan="7">电源板/适配器(外部电源)</td>
                <td rowspan="7">
                  <FormItem prop="c31">
                    <Input type="text" v-model="formRecord.c31" :disabled='disabledoff'/>
                  </FormItem>
                </td>
                <td rowspan="7">
                  <FormItem prop="c32">
                    <Input type="text" v-model="formRecord.c32" :disabled='disabledoff'/>
                  </FormItem>
                </td>
                <td align="center">输入电压</td>
                <td>
                  <FormItem prop="c33">
                    <Input type="text" v-model="formRecord.c33" :disabled='disabledoff'/>
                  </FormItem>
                </td>
                <td rowspan="7">
                  <FormItem prop="c34">
                    <Input type="text" v-model="formRecord.c34" :disabled='disabledoff'/>
                  </FormItem>
                </td>
              </tr>
              <tr>
                <td align="center">输入电压</td>
                <td>
                  <FormItem prop="c35">
                    <Input type="text" v-model="formRecord.c35" :disabled='disabledoff'/>
                  </FormItem>
                </td>
              </tr>
              <tr>
                <td align="center">输入电压</td>
                <td>
                  <FormItem prop="c36">
                    <Input type="text" v-model="formRecord.c36" :disabled='disabledoff'/>
                  </FormItem>
                </td>
              </tr>
              <tr>
                <td align="center">输入电流</td>
                <td>
                  <FormItem prop="c37">
                    <Input type="text" v-model="formRecord.c37" :disabled='disabledoff'/>
                  </FormItem>
                </td>
              </tr>
              <tr>
                <td align="center">输出电压</td>
                <td>
                  <FormItem prop="c38">
                    <Input type="text" v-model="formRecord.c38" :disabled='disabledoff'/>
                  </FormItem>
                </td>
              </tr>
              <tr>
                <td align="center">输出电流</td>
                <td>
                  <FormItem prop="c39">
                    <Input type="text" v-model="formRecord.c39" :disabled='disabledoff'/>
                  </FormItem>
                </td>
              </tr>
              <tr>
                <td align="center">输出功率</td>
                <td>
                  <FormItem prop="c40">
                    <Input type="text" v-model="formRecord.c40" :disabled='disabledoff'/>
                  </FormItem>
                </td>
              </tr>
              <tr>
                <td width="80" rowspan="7">2</td>
                <td align="center" rowspan="7">电源板/适配器(外部电源)</td>
                <td rowspan="7">
                  <FormItem prop="c41">
                    <Input type="text" v-model="formRecord.c41" :disabled='disabledoff'/>
                  </FormItem>
                </td>
                <td rowspan="7">
                  <FormItem prop="c42">
                    <Input type="text" v-model="formRecord.c42" :disabled='disabledoff'/>
                  </FormItem>
                </td>
                <td align="center">输入电压</td>
                <td>
                  <FormItem prop="c43">
                    <Input type="text" v-model="formRecord.c43" :disabled='disabledoff'/>
                  </FormItem>
                </td>
                <td rowspan="7">
                  <FormItem prop="c44">
                    <Input type="text" v-model="formRecord.c44" :disabled='disabledoff'/>
                  </FormItem>
                </td>
              </tr>
              <tr>
                <td align="center">输入电压</td>
                <td>
                  <FormItem prop="c45">
                    <Input type="text" v-model="formRecord.c45" :disabled='disabledoff'/>
                  </FormItem>
                </td>
              </tr>
              <tr>
                <td align="center">输入电压</td>
                <td>
                  <FormItem prop="c46">
                    <Input type="text" v-model="formRecord.c46" :disabled='disabledoff'/>
                  </FormItem>
                </td>
              </tr>
              <tr>
                <td align="center">输入电流</td>
                <td>
                  <FormItem prop="c47">
                    <Input type="text" v-model="formRecord.c47" :disabled='disabledoff'/>
                  </FormItem>
                </td>
              </tr>
              <tr>
                <td align="center">输出电压</td>
                <td>
                  <FormItem prop="c48">
                    <Input type="text" v-model="formRecord.c48" :disabled='disabledoff'/>
                  </FormItem>
                </td>
              </tr>
              <tr>
                <td align="center">输出电流</td>
                <td>
                  <FormItem prop="c49">
                    <Input type="text" v-model="formRecord.c49" :disabled='disabledoff'/>
                  </FormItem>
                </td>
              </tr>
              <tr>
                <td align="center">输出功率</td>
                <td>
                  <FormItem prop="c50">
                    <Input type="text" v-model="formRecord.c50" :disabled='disabledoff'/>
                  </FormItem>
                </td>
              </tr>
              
              <tr>
                <td width="80">3</td>
                <td align="center">解码芯片</td>
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
                <td align="center">解码格式</td>
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
                <td width="80">4</td>
                <td align="center">解码芯片</td>
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
                <td align="center">解码格式</td>
                <td>
                  <FormItem prop="c57">
                    <Input type="text" v-model="formRecord.c57" :disabled='disabledoff'/>
                  </FormItem>
                </td>
                <td>
                  <FormItem prop="c58">
                    <Input type="text" v-model="formRecord.c58" :disabled='disabledoff'/>
                  </FormItem>
                </td>
              </tr>
              <tr>
                <td width="80">5</td>
                <td align="center">解调芯片</td>
                <td>
                  <FormItem prop="c59">
                    <Input type="text" v-model="formRecord.c59" :disabled='disabledoff'/>
                  </FormItem>
                </td>
                <td>
                  <FormItem prop="c60">
                    <Input type="text" v-model="formRecord.c60" :disabled='disabledoff'/>
                  </FormItem>
                </td>
                <td align="center">解调方式</td>
                <td>
                  <FormItem prop="c61">
                    <Input type="text" v-model="formRecord.c61" :disabled='disabledoff'/>
                  </FormItem>
                </td>
                <td>
                  <FormItem prop="c62">
                    <Input type="text" v-model="formRecord.c62" :disabled='disabledoff'/>
                  </FormItem>
                </td>
              </tr>
              <tr>
                <td width="80">6</td>
                <td align="center">解调芯片</td>
                <td>
                  <FormItem prop="c63">
                    <Input type="text" v-model="formRecord.c63" :disabled='disabledoff'/>
                  </FormItem>
                </td>
                <td>
                  <FormItem prop="c64">
                    <Input type="text" v-model="formRecord.c64" :disabled='disabledoff'/>
                  </FormItem>
                </td>
                <td align="center">解调方式</td>
                <td>
                  <FormItem prop="c65">
                    <Input type="text" v-model="formRecord.c65" :disabled='disabledoff'/>
                  </FormItem>
                </td>
                <td>
                  <FormItem prop="c66">
                    <Input type="text" v-model="formRecord.c66" :disabled='disabledoff'/>
                  </FormItem>
                </td>
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
              <td colspan="3" v-if="pltId != 244">
                根据企业提交的相关信息，系统直接生成能效表示样本，请提交备案后在"备案查询"功能中下载
                <!-- <Button type="primary" @click="showTemplate">查看</Button> -->
              </td>
              <td colspan="3" v-else>提交备案后，需企业自行上传能效标识样本</td>
            </tr>
            <tr>
              <td>OEM声明<p class="red" v-if="pageType!='view'">请企业根据自身情况自行上传该附件</p></td>
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
              <td>关系证明</td>
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
              <td>进口商企业信息表
                <p class="red" v-if="pageType!='view'">境外企业请自行上传该附件</p>
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
              <td>进口商营业执照或登记注册证明复印件
                <p class="red" v-if="pageType!='view'">境外企业请自行上传该附件</p>
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
              <td>进口商与境外生产者订立的相关合同副本
                <p class="red" v-if="pageType!='view'">境外企业请自行上传该附件</p>
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
          <p class="red" v-if="pageType!='view'">注：保存到草稿时，不保存附件！<br />所有附件上传文件大小需要控制在2M以内。</p>
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
      <img :src="uploadPic" />
    </Modal>
     <Modal v-model="modal5" class="basic-info"  :width=650 ok-text="保存"  @on-ok="submitBasic" cancel-text="关闭">
       <h2>标识型号{{pageType==="extend"?'扩展':'变更'}}备案申请书</h2>
       <p class="org">中国标准化研究院能效标识管理中心：</p>
       <div class="pro-info">
          我 <span  class="f-company">{{formRecord.c1}}</span>
          公司生产的 <span class="f-brand">{{formRecord.c4}}</span>
          品牌的 <span  class="f-model">{{formRecord.c3}}</span>
          型号的 <span  class="f-product">数字电视接收器 2010版</span>产品。
       </div>
       <dl v-if="pageType==='extend'">
          <dt>
              现提出型号扩展备案申请的 <span class="f-model"></span>
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
          <dd>现申请该幸好申请的备案信息如下变更：<br>
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
    numberCheck,
    check
  } from '@/libs/utilExt'

  export default {
    data () {
    const timeDate=parseInt(this.$store.state.app.dateinit);
    return {
      // 当前初始使用日期 对应的C值
      thisDateCV: 'c14',
      // 当前能效等级 对应的C值
      thisLevelCV: 'c28',
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
        c27: '',
        c3: '',
        c4: '',
        c200: '',
        c28: '',
        c5: '',
        c6: '',
        c7: '',
        c8: '',
        c9: '',
        c10: '',
        c11: '',
        c12: '',
        c13: '',
        c14: new Date(),
        c17: [],
        c15: '',
        c16: '',
        c19: '',
        c20: [],
        c21: '',
        c22: '',
        c23: '',
        c24: '',
        c25: '',
        c26: '',
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
        c202: '',
        ec_model_no: 27,
        attach_list: ''
      },
      forbidden: {
        c22: true,
        c18: true,
        c19: true
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
      ...mapGetters([
        'pageType'
      ]),
      disabledoff(){
        return  this.pageType==='extend';
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
        if (this.formRecord.c21 === '外部电源') {
          this.forbidden.c22 = false
        } else {
          this.formRecord.c22 = ''
          this.forbidden.c22 = true
        }
        if (this.formRecord.c17.join('').indexOf('以太网接口共') > -1) {
          this.forbidden.c18 = false
        } else {
          this.formRecord.c18 = ''
          this.forbidden.c18 = true
        }
        if (this.formRecord.c17.join('').indexOf('USB接口共') > -1) {
          this.forbidden.c19 = false
        } else {
          this.formRecord.c19 = ''
          this.forbidden.c19 = true
        }


        var checknxdj =null;
        var checkc11 =null;
        var checkc5 =null;
        var checkc8 =null;

        var res = 0;
        var val = this.formRecord.c17;
        if (val == "内部硬盘") {
            res = res + 2.2;
        }
        if (val == "高清输出功能") {
            res = res + 3.0;
        }
        if (val == "HDMI接口") {
            res = res + 1.0;
        }
        if (val == "ADSL调制解调器") {
            res = res + 2.0;
        }
        if (val == "双调谐器") {
            res = res + 2.0;
        }
        if (val == "有线调制解调器") {
            res = res + 4.5;
        }
        if (val == "以太网接口") {
            res = res + 0.4 * parseInt(this.formRecord.c18);
        }
        if (val == "USB接口") {
            res = res + 0.3 * parseInt(this.formRecord.c19);
        }

        var vv = Math.pow(10, 1);
        res = Math.round(res * vv) / vv;
        if (res != parseFloat(this.formRecord.c11)) {
          checkc11 = (rule, value, callback) => {
            callback("附加功能功效因子之和∑Pfa的计算结果与所填数值不符！");
          }
        }
        if (this.formRecord.c6 != "" && parseFloat(this.formRecord.c5) < parseFloat(this.formRecord.c6)) {
          checkc5 = (rule, value, callback) => {
            callback("工作状态功率标准规定值应大于或等于实测值！");
          }
        }
        if (this.formRecord.c9 != "" && parseFloat(this.formRecord.c8) < parseFloat(this.formRecord.c9)) {
          checkc8 = (rule, value, callback) => {
            callback("被动待机功率标准规定值应大于或等于实测值！");
          }
        }
        //验证能效等级
        var nxdj = 0;
        if (this.formRecord.c15 == "有线" || this.formRecord.c15 == "地面") {
          if (parseFloat(this.formRecord.c5) <= (parseFloat(this.formRecord.c11) + 5.0) && parseFloat(this.formRecord.c8) <= 1) {
              nxdj = 1;
          } else if (parseFloat(this.formRecord.c5) <= (parseFloat(this.formRecord.c11) + 7.0) && parseFloat(this.formRecord.c8) <= 2) {
              nxdj = 2;
          } else if (parseFloat(this.formRecord.c5) <= (parseFloat(this.formRecord.c11) + 10.0) && parseFloat(this.formRecord.c8) <= 3) {
              nxdj = 3;
          }
        }
        if (this.formRecord.c15 == "卫星") {
          if (parseFloat(this.formRecord.c5) <= (parseFloat(this.formRecord.c11) + 7.0) && parseFloat(this.formRecord.c8) <= 1) {
              nxdj = 1;
          } else if (parseFloat(this.formRecord.c5) <= (parseFloat(this.formRecord.c11) + 9.0) && parseFloat(this.formRecord.c8) <= 2) {
              nxdj = 2;
          } else if (parseFloat(this.formRecord.c5) <= (parseFloat(this.formRecord.c11) + 12.0) && parseFloat(this.formRecord.c8) <= 3) {
              nxdj = 3;
          }
        }
        if (nxdj == 0) {
          checknxdj = (rule, value, callback) => {
            callback("能效数据不再备案范围");
          }
        }
        if (nxdj != this.formRecord.c28) {
           checknxdj = (rule, value, callback) => {
            callback("所选能效等级与计算结果不符！");
           }
        }

        return {
          c2: [
            {
              required: true,
              trigger: 'change,blur',
              message: '制造单位不能为空'
            }
          ],
          c27: [
            {
              required: true,
              trigger: 'change,blur',
              message: '备案方不能为空'
            }
          ],
          c3: [
            {
              required: true,
              trigger: 'change,blur',
              message: '产品规格型号不能为空'
            }
          ],
          c4: [
            {
              required: true,
              trigger: 'change,blur',
              message: '商标不能为空'
            }
          ],
                  
          c28: [
            {
              required: true,
              trigger: 'change,blur',
              message: '请选择能效等级'
            },
            {
              validator: checknxdj,
              trigger: 'change,blur'
            }
          ],
          c5: [
            {
              required: true,
              trigger: 'change,blur',
              message: '工作状态功率标称值不能为空'
            },
            {
              validator: oneDecimals,
              trigger: 'change,blur'
            },
            {
              validator: checkc5,
              trigger: 'change,blur'
            }
          ],
          c6: [
            {
              required: true,
              trigger: 'change,blur',
              message: '工作状态功率实测值不能为空'
            },
            {
              validator: atLeastTwoDecimals,
              trigger: 'change,blur'
            } 
          ],
          c8: [
            {
              required: true,
              trigger: 'change,blur',
              message: '被动待机功率标称值不能为空'
            },
            {
              validator: oneDecimals,
              trigger: 'change,blur'
            },
            {
              validator: checkc8,
              trigger: 'change,blur'
            }
          ],
          c9: [
            {
              required: true,
              trigger: 'change,blur',
              message: '被动待机功率实测值不能为空'
            },
            {
              required: true,
              trigger: 'change,blur',
              message: '工作状态功率实测值不能为空'
            },
          ],
          c11: [
            {
              required: true,
              trigger: 'change,blur',
              message: '附加功能功率因子之和标称值不能为空'
            },
            {
              validator: oneDecimals,
              trigger: 'change,blur'
            },
            {
              validator: checkc11,
              trigger: 'change,blur'
            } 
          ],
          c12: [
            {
              required: true,
              trigger: 'change,blur',
              message: '附加功能功率因子之和实测值不能为空'
            },
            {
              validator: oneDecimals,
              trigger: 'change,blur'
            }
          ],
          c14: [
            {
              required: true,
              message: '备案标识开始使用日期不能为空'
            }
          ],
          c15: [
            {
              required: true,
              trigger: 'change,blur',
              message: '请选择接收器类型'
            }
          ],
          c16: [
            {
              required: true,
              trigger: 'change,blur',
              message: '请选择信号类型'
            }
          ],
          c18: [
            {
              required: this.formRecord.c17.join('').indexOf('以太网接口共') > -1,
              trigger: 'change,blur',
              message: '以太网接口个数不能为空'
            },
            {
              validator: this.formRecord.c17.join('').indexOf('以太网接口共') > -1 ? numberCheck : check,
              trigger: 'change,blur'
            }
          ],
          c19: [
            {
              required: this.formRecord.c17.join('').indexOf('USB接口共') > -1,
              trigger: 'change,blur',
              message: 'USB接口个数不能为空'
            },
            {
              validator: this.formRecord.c17.join('').indexOf('USB接口共') > -1 ? numberCheck : check,
              trigger: 'change,blur'
            }
          ],
          c20: [
            {
              required: true,
              message: '请选择测试工况种类'
            }
          ],
          c21: [
            {
              required: true,
              trigger: 'change,blur',
              message: '请选择供电方式'
            }
          ],
          c22: [
            {
              required: this.formRecord.c21 === '外部电源',
              trigger: 'change,blur',
              message: '外部电源输出功率不能为空'
            }
          ],
          c23: [
            {
              required: true,
              trigger: 'change,blur',
              message: '额定电压不能为空'
            }
          ],
          c24: [
            {
              required: true,
              trigger: 'change,blur',
              message: '额定频率不能为空'
            }
          ],
          c25: [
            {
              required: true,
              trigger: 'change,blur',
              message: '额定输入功率不能为空'
            }
          ],
          c26: [
            {
              required: true,
              trigger: 'change,blur',
              message: '长不能为空'
            }
          ],
          c29: [
            {
              required: true,
              trigger: 'change,blur',
              message: '宽不能为空'
            }
          ],
          c30: [
            {
              required: true,
              trigger: 'change,blur',
              message: '高不能为空'
            }
          ],
          c31: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c32: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c33: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c34: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c35: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c36: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c37: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c38: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c39: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c40: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c51: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c52: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c53: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c54: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c59: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c60: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c61: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c62: [
            {
              required: true,
              trigger: 'change,blur',
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
