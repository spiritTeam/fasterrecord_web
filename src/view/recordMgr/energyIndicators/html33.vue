<!--转速可控型房间空气调节器 2013版-->
<!--创建日期:2019年5月27日-->
<!--创建人:YCL-->
<template>
  <div class="wrapper">
    <Form ref="formRecord" :model="formRecord" label-position="right" :rules="pageType!='extend'?ruleRecord:{}">
      <h1>转速可控型房间空气调节器-能源效率标识备案表</h1>
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
          <FormItem prop="c30" label="备案方" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c30" placeholder="备案方" :disabled='disabledoff'/>
          </FormItem>
          <FormItem prop="c4" label="产品规格型号" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c4" placeholder="规格型号" :disabled='!disabledoff'/>
          </FormItem>
          <FormItem prop="c2" label="商标" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c2" placeholder="商标" :disabled='disabledoff'/>
          </FormItem>
          <FormItem prop="c200" label="依据国家标准" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c200" placeholder="依据国家标准" readonly disabled/>
          </FormItem>
          <FormItem prop="c8" label="能效等级" style="width:100%;" :label-width="180">
            <RadioGroup v-model="formRecord.c8">
              <Radio label="1" :disabled='disabledoff'>1级</Radio>
              <Radio label="2" :disabled='disabledoff'>2级</Radio>
              <Radio label="3" :disabled='disabledoff'>3级</Radio>
            </RadioGroup>
          </FormItem>
          <FormItem prop="c11" label="类型" style="width:100%;" :label-width="180">
            <RadioGroup v-model="formRecord.c11">
              <Radio label="分体式" :disabled='disabledoff'>分体式</Radio>
              <Radio label="整体式" :disabled='disabledoff'>整体式</Radio>
            </RadioGroup>
          </FormItem>
          <FormItem prop="c57" style="width:100%;" :label-width="180">
            <RadioGroup v-model="formRecord.c57">
              <Radio label="单冷式" :disabled='disabledoff'>单冷式</Radio>
              <Radio label="热泵型" :disabled='disabledoff'>热泵型</Radio>
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
              <td>额定制冷量(W)</td>
              <td>
                <FormItem prop="c5">
                  <Input type="text" v-model="formRecord.c5" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c31">
                  <Input type="text" v-model="formRecord.c31" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c32">
                  <Input type="text" v-model="formRecord.c32" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>额定制热量(W)</td>
              <td>
                <FormItem prop="c25">
                  <Input type="text" v-model="formRecord.c25" :disabled='disabledoff || forbidden.c25'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c33">
                  <Input type="text" v-model="formRecord.c33" :disabled='disabledoff || forbidden.c33'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c34">
                  <Input type="text" v-model="formRecord.c34" :disabled='disabledoff || forbidden.c34'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>制冷季节耗电量(kW·h)（按照全年制冷运行1136小时计算）</td>
              <td>
                <FormItem prop="c7">
                  <Input type="text" v-model="formRecord.c7" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c40">
                  <Input type="text" v-model="formRecord.c40" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c41">
                  <Input type="text" v-model="formRecord.c41" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>制热季节耗电量(kW·h)（按照全年制热运行433小时计算）</td>
              <td>
                <FormItem prop="c42">
                  <Input type="text" v-model="formRecord.c42" :disabled='disabledoff || forbidden.c42'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c43">
                  <Input type="text" v-model="formRecord.c43" :disabled='disabledoff || forbidden.c43'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c44">
                  <Input type="text" v-model="formRecord.c44" :disabled='disabledoff || forbidden.c44'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>制冷季节能源消耗效率[W·h/(W·h)]</td>
              <td>
                <FormItem prop="c6">
                  <Input type="text" v-model="formRecord.c6" :disabled='disabledoff || forbidden.c6'/>
                </FormItem>
              </td>
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
              <td>全年能源消耗效率[W·h/(W·h)]</td>
              <td>
                <FormItem prop="c37">
                  <Input type="text" v-model="formRecord.c37" :disabled='disabledoff || forbidden.c37'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c38">
                  <Input type="text" v-model="formRecord.c38" :disabled='disabledoff || forbidden.c38'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c39">
                  <Input type="text" v-model="formRecord.c39" :disabled='disabledoff || forbidden.c39'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td colspan="4">
                备注：额定制冷量、额定制热量、全年能源消耗效率、制冷季节耗电量、制热季节耗电量为热泵型转速可控型房间空气调节器必填项；额定制冷量、制冷季节能源消耗效率、制冷季节耗电量为单冷式转速可控型房间空气调节器必填项。
              </td>
            </tr>
          </table>
        </Card>
      </div>
      <div class="part part4">
        <Card :bordered="false">
          <h2>四、初始使用日期</h2>
          <!-- <Form ref="formRecord" :model="formRecord" label-position="left" :label-width="180" :rules="ruleRecord"> -->
          <FormItem prop="c9" label="备案标识开始使用日期" style="width:100%;">
            <DatePicker type="date" :options="dataInit" style="width: 200px" v-model="formRecord.c9"></DatePicker>
          </FormItem>
        </Card>
      </div>
      <div class="part part5">
        <Card :bordered="false">
          <h2>五、样品描述</h2>
          <table id="table3">
            <tr>
              <td><i class="red">*</i>电源性质</td>
              <td width="30%">
                <FormItem prop="c10">
                  <RadioGroup v-model="formRecord.c10">
                    <Radio label="三相" :disabled='disabledoff'>三相</Radio>
                    <Radio label="单相" :disabled='disabledoff'>单相</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td><i class="red">*</i>开关（全极断开）</td>
              <td width="30%">
                <FormItem prop="c15">
                  <RadioGroup v-model="formRecord.c15">
                    <Radio label="有" :disabled='disabledoff'>有</Radio>
                    <Radio label="无" :disabled='disabledoff'>无</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td><i class="red">*</i>压缩机调速方式</td>
              <td colspan="3">
                <FormItem prop="c12">
                  <RadioGroup v-model="formRecord.c12">
                    <Radio label="交流调速" :disabled='disabledoff'>交流调速</Radio>
                    <Radio label="直流调速" :disabled='disabledoff'>直流调速</Radio>
                    <Radio label="其它" :disabled='disabledoff'>其它</Radio>
                  </RadioGroup>
                </FormItem>
                <FormItem prop="c13">
                  <Input type="text" v-model="formRecord.c13" style="width:80px;"
                         :disabled='disabledoff || forbidden.c13'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td><i class="red">*</i>电加热装置</td>
              <td colspan="3">
                <FormItem prop="c14">
                  <RadioGroup v-model="formRecord.c14">
                    <Radio label="有" :disabled='disabledoff'>有</Radio>
                    <Radio label="无" :disabled='disabledoff'>无</Radio>
                  </RadioGroup>
                </FormItem>
                <FormItem prop="c48">
                  <Input type="text" placeholder="电加热装置输入功率(W)" v-model="formRecord.c48" style="width:200px;"
                         :disabled='disabledoff || forbidden.c48'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td><i class="red">*</i>最大输入功率（W）</td>
              <td>
                <FormItem prop="c58">
                  <Input type="text" v-model="formRecord.c58" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td><i class="red">*</i>最大输入电流（A）</td>
              <td>
                <FormItem prop="c59">
                  <Input type="text" v-model="formRecord.c59" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td><i class="red">*</i>单极开关</td>
              <td>
                <FormItem prop="c16">
                  <RadioGroup v-model="formRecord.c16">
                    <Radio label="有" :disabled='disabledoff'>有</Radio>
                    <Radio label="无" :disabled='disabledoff'>无</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td>机械温控器</td>
              <td>
                <FormItem prop="c17">
                  <RadioGroup v-model="formRecord.c17">
                    <Radio label="有" :disabled='disabledoff'>有</Radio>
                    <Radio label="无" :disabled='disabledoff'>无</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td><i class="red">*</i>温控器以外的其它控制装置</td>
              <td>
                <FormItem prop="c18">
                  <RadioGroup v-model="formRecord.c18">
                    <Radio label="有" :disabled='disabledoff'>有</Radio>
                    <Radio label="无" :disabled='disabledoff'>无</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td><i class="red">*</i>用于非正常工作保护的薄弱零件</td>
              <td>
                <FormItem prop="c19">
                  <RadioGroup v-model="formRecord.c19">
                    <Radio label="有" :disabled='disabledoff'>有</Radio>
                    <Radio label="无" :disabled='disabledoff'>无</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td><i class="red">*</i>电子控制线路</td>
              <td>
                <FormItem prop="c20">
                  <RadioGroup v-model="formRecord.c20">
                    <Radio label="有" :disabled='disabledoff'>有</Radio>
                    <Radio label="无" :disabled='disabledoff'>无</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td><i class="red">*</i>不可拆线插头的电源线</td>
              <td>
                <FormItem prop="c21">
                  <RadioGroup v-model="formRecord.c21">
                    <Radio label="有" :disabled='disabledoff'>有</Radio>
                    <Radio label="无" :disabled='disabledoff'>无</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td><i class="red">*</i>单独的控制面板</td>
              <td>
                <FormItem prop="c22">
                  <RadioGroup v-model="formRecord.c22">
                    <Radio label="有" :disabled='disabledoff'>有</Radio>
                    <Radio label="无" :disabled='disabledoff'>无</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td><i class="red">*</i>线控器</td>
              <td>
                <FormItem prop="c23">
                  <RadioGroup v-model="formRecord.c23">
                    <Radio label="有" :disabled='disabledoff'>有</Radio>
                    <Radio label="无" :disabled='disabledoff'>无</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td><i class="red">*</i>遥控器</td>
              <td>
                <FormItem prop="c24">
                  <RadioGroup v-model="formRecord.c24">
                    <Radio label="有" :disabled='disabledoff'>有</Radio>
                    <Radio label="无" :disabled='disabledoff'>无</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td><i class="red">*</i>是否接风管</td>
              <td>
                <FormItem prop="c56">
                  <RadioGroup v-model="formRecord.c56">
                    <Radio label="有" :disabled='disabledoff'>是</Radio>
                    <Radio label="无" :disabled='disabledoff'>否</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td><i class="red">*</i>额定电压(V)</td>
              <td>
                <FormItem prop="c45">
                  <Input type="text" v-model="formRecord.c45" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td><i class="red">*</i>额定电流(A)</td>
              <td>
                <FormItem prop="c47">
                  <Input type="text" v-model="formRecord.c47" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td><i class="red">*</i>额定频率（Hz）</td>
              <td>
                <FormItem prop="c46">
                  <Input type="text" v-model="formRecord.c46" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td><i class="red">*</i>制热季节能源消耗效率</td>
              <td>
                <FormItem prop="c26">
                  <Input type="text" v-model="formRecord.c26" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td><i class="red">*</i>制冷剂</td>
              <td>
                <FormItem prop="c29">
                  <Input type="text" v-model="formRecord.c29" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td><i class="red">*</i>灌注量(g)</td>
              <td>
                <FormItem prop="c53">
                  <Input type="text" v-model="formRecord.c53" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td><i class="red">*</i>整机或室内机外形尺寸(长×宽×高)（mm×mm×mm）</td>
              <td>
                <FormItem prop="c27">
                  <Input type="text" v-model="formRecord.c27" style="width:80px;" :disabled='disabledoff'/>
                </FormItem>
                <span style="display: inline-block;height: 32px;line-height: 32px;">×</span>
                <FormItem prop="c49">
                  <Input type="text" v-model="formRecord.c49" style="width:80px;" :disabled='disabledoff'/>
                </FormItem>
                <span style="display: inline-block;height: 32px;line-height: 32px;">×</span>
                <FormItem prop="c50">
                  <Input type="text" v-model="formRecord.c50" style="width:80px;" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>室外机外形尺寸(长×宽×高)（mm×mm×mm）</td>
              <td>
                <FormItem prop="c28">
                  <Input type="text" v-model="formRecord.c28" style="width:80px;" :disabled='disabledoff'/>
                </FormItem>
                <span style="display: inline-block;height: 32px;line-height: 32px;">×</span>
                <FormItem prop="c51">
                  <Input type="text" v-model="formRecord.c51" style="width:80px;" :disabled='disabledoff'/>
                </FormItem>
                <span style="display: inline-block;height: 32px;line-height: 32px;">×</span>
                <FormItem prop="c52">
                  <Input type="text" v-model="formRecord.c52" style="width:80px;" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td><i class="red">*</i>整机或室内机噪声dB（A）</td>
              <td>
                <FormItem prop="c54">
                  <Input type="text" v-model="formRecord.c54" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td><i class="red">*</i>室外机噪声dB（A）</td>
              <td>
                <FormItem prop="c55">
                  <Input type="text" v-model="formRecord.c55" :disabled='disabledoff'/>
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
              <th>规格型号/类型</th>
              <th colspan="3">技术参数</th>
              <th>生产者（全称）</th>
            </tr>
            <tr>
              <td rowspan="4" class="tc">1</td>
              <td rowspan="4">压缩机</td>
              <td class="tc">/</td>
              <td class="tc">制冷量（W）</td>
              <td class="tc">输入功率（W）</td>
              <td class="tc">COP值</td>
              <td class="tc">/</td>
            </tr>
            <tr>
              <td>
                <FormItem prop="c60">
                  <Input type="text" v-model="formRecord.c60" :disabled='disabledoff'/>
                </FormItem>
              </td>
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
            </tr>
            <tr>
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
              <td>
                <FormItem prop="c67">
                  <Input type="text" v-model="formRecord.c67" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c68">
                  <Input type="text" v-model="formRecord.c68" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c69">
                  <Input type="text" v-model="formRecord.c69" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>
                <FormItem prop="c70">
                  <Input type="text" v-model="formRecord.c70" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c71">
                  <Input type="text" v-model="formRecord.c71" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c72">
                  <Input type="text" v-model="formRecord.c72" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c73">
                  <Input type="text" v-model="formRecord.c73" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c74">
                  <Input type="text" v-model="formRecord.c74" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td colspan="7">备注：如上述零部件属多个生产者，均应按上述要求逐一填写。</td>
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
        <!-- <Button type="primary" @click="submitRecord" :disabled="submitDisabled">提交备案审核申请</Button> -->
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
    <img class="lookPdf" v-if="!uploadPic.includes('.pdf')" :src="uploadPic" />
    <embed class="lookPdf" v-else :src="uploadPic" width="600" height="400" type="application/pdf"  internalinstanceid="81" />
  </Modal>
     <Modal v-model="modal5" class="basic-info pageStyle"  :width=650 ok-text="保存"  @on-ok="submitBasic" cancel-text="关闭">
       <h2>标识型号{{pageType==="extend"?'扩展':'变更'}}备案申请书</h2>
       <p class="org">中国标准化研究院能效标识管理中心：</p>
       <div class="pro-info">
          我 <span  class="f-company">{{formRecord.c1}}</span>
          公司生产的 <span class="f-brand">{{formRecord.c2}}</span>
          品牌的 <span  class="f-model">{{pageType==='extend'?mainModel:formRecord.c4}}</span>
          型号的 <span  class="f-product">转速可控型房间空气调节器 2013版</span>产品{{pageType==="update"?'已通过能效标识备案':''}}。
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
    check
  } from '@/libs/utilExt'

  export default {
    data() {
      const timeDate=parseInt(this.$store.state.app.dateinit);
      return {
        // 当前初始使用日期 对应的C值
        thisDateCV: "c9",
        // 当前能效等级 对应的C值
        thisLevelCV: "c8",
        // 当前规格型号 对应的C值
        thisGZXHCV: "c4",
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
          c2: '',
          c3: '',
          c4: '',
          c5: '',
          c6: '',
          c7: '',
          c8: '',
          c9: new Date(),
          c10: '',
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
          c72: '',
          c73: '',
          c74: '',
          c200: '',
          c202: '',
          ec_model_no: 33,
          attach_list: ''
        },
        forbidden: {
          c25: true,
          c33: true,
          c34: true,
          c42: true,
          c43: true,
          c44: true,
          c37: true,
          c38: true,
          c39: true,
          c6: true,
          c13: true,
          c48: true
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
      ruleRecord() {
        //能效等级
        var nxdj = this.formRecord.c8
        var c5 = parseFloat(parseFloat(this.formRecord.c5))
        var c8 = this.formRecord.c8
        var c6 = parseFloat(this.formRecord.c6)
        var c37 = parseFloat(this.formRecord.c37)
        var c57 = this.formRecord.c57


        if (this.formRecord.c57 === '热泵型') {
          this.forbidden.c25 = false
          this.forbidden.c33 = false
          this.forbidden.c34 = false
          this.forbidden.c42 = false
          this.forbidden.c43 = false
          this.forbidden.c44 = false
          this.forbidden.c37 = false
          this.forbidden.c38 = false
          this.forbidden.c39 = false
        } else {
          this.formRecord.c25 = ''
          this.formRecord.c33 = ''
          this.formRecord.c34 = ''
          this.formRecord.c42 = ''
          this.formRecord.c43 = ''
          this.formRecord.c44 = ''
          this.formRecord.c37 = ''
          this.formRecord.c38 = ''
          this.formRecord.c39 = ''
          this.forbidden.c25 = true
          this.forbidden.c33 = true
          this.forbidden.c34 = true
          this.forbidden.c42 = true
          this.forbidden.c43 = true
          this.forbidden.c44 = true
          this.forbidden.c37 = true
          this.forbidden.c38 = true
          this.forbidden.c39 = true
        }
        if (this.formRecord.c57 === '单冷式') {
          this.forbidden.c6 = false
        } else {
          this.formRecord.c6 = ''
          this.forbidden.c6 = true
        }

        if (this.formRecord.c12 === '其它') {
          this.forbidden.c13 = false
        } else {
          this.formRecord.c13 = ''
          this.forbidden.c13 = true
        }

        if (this.formRecord.c14 === '有') {
          this.forbidden.c48 = false
        } else {
          this.formRecord.c48 = ''
          this.forbidden.c48 = true
        }

        const checkc5 = (rule, value, callback) => {
          if (c5 > 14000) {
            callback("额定制冷量数据错误")
          } else {
            callback()
          }
        }
        if (c57 === "单冷式") {
          if (c5 <= 4500) {
            if (c6 >= 5.40) {
              nxdj = "1";
            } else if (c6 >= 5.00) {
              nxdj = "2";
            } else if (c6 >= 4.30) {
              nxdj = "3";
            }
          } else if (c5 <= 7100) {
            if (c6 >= 5.10) {
              nxdj = "1";
            } else if (c6 >= 4.40) {
              nxdj = "2";
            } else if (c6 >= 3.90) {
              nxdj = "3";
            }
          } else {
            if (c6 >= 4.70) {
              nxdj = "1";
            } else if (c6 >= 4.00) {
              nxdj = "2";
            } else if (c6 >= 3.50) {
              nxdj = "3";
            }
          }
        } else if (c57 === "热泵型") {
          if (c5 <= 4500) {
            if (c37 >= 4.50) {
              nxdj = "1";
            } else if (c37 >= 4.00) {
              nxdj = "2";
            } else if (c37 >= 3.50) {
              nxdj = "3";
            }
          } else if (c5 <= 7100) {
            if (c37 >= 4.00) {
              nxdj = "1";
            } else if (c37 >= 3.50) {
              nxdj = "2";
            } else if (c37 >= 3.30) {
              nxdj = "3";
            }
          } else {
            if (c37 >= 3.70) {
              nxdj = "1";
            } else if (c37 >= 3.30) {
              nxdj = "2";
            } else if (c37 >= 3.10) {
              nxdj = "3";
            }
          }
        }
        const checkc8 = (rule, value, callback) => {
          if (!nxdj) {
            callback("能效数据不在备案范围")
          } else if (nxdj != c8) {
            callback("所选能效等级与计算结果不符")
          } else {
            callback()
          }
        }

        return {
          c3: [
            {
              trigger: 'change,blur',
              required: true,
              message: '请填写制造单位'
            }
          ],
          c30: [
            {
              trigger: 'change,blur',
              required: true,
              message: '请填写备案方'
            }
          ],
          c2: [
            {
              trigger: 'change,blur',
              required: true,
              message: '请填写商标'
            }
          ],
          c11: [
            {
              trigger: 'change,blur',
              required: true,
              message: '请选择类型'
            }
          ],
          c57: [
            {
              trigger: 'change,blur',
              required: true,
              message: '请选择类型'
            }
          ],
          c8: [
            {
              trigger: 'change,blur',
              required: true,
              message: '请选择能效等级'
            },
            {
              validator: checkc8,
              trigger: 'blur'
            }
          ],
          c9: [
            {
              required: true,
              message: '不能为空'
            }
          ],
          c25: [
            {
              trigger: 'change,blur',
              required: this.formRecord.c57 === '热泵型',
              message: '不能为空'
            },
            {
              validator: this.formRecord.c57 === '热泵型' ? isNumber : check,
              trigger: 'blur'
            }
          ],
          c33: [
            {
              trigger: 'change,blur',
              required: this.formRecord.c57 === '热泵型',
              message: '不能为空'
            },
            {
              validator: this.formRecord.c57 === '热泵型' ? atLeastOneDecimals : check,
              trigger: 'blur'
            }
          ],
          c42: [
            {
              trigger: 'change,blur',
              required: this.formRecord.c57 === '热泵型',
              message: '不能为空'
            },
            {
              validator: this.formRecord.c57 === '热泵型' ? isNumber : check,
              trigger: 'blur'
            }
          ],
          c43: [
            {
              trigger: 'change,blur',
              required: this.formRecord.c57 === '热泵型',
              message: '不能为空'
            },
            {
              validator: this.formRecord.c57 === '热泵型' ? atLeastOneDecimals : check,
              trigger: 'blur'
            }
          ],
          c37: [
            {
              trigger: 'change,blur',
              required: this.formRecord.c57 === '热泵型',
              message: '不能为空'
            },
            {
              validator: this.formRecord.c57 === '热泵型' ? twoDecimals : check,
              trigger: 'blur'
            }
          ],
          c38: [
            {
              trigger: 'change,blur',
              required: this.formRecord.c57 === '热泵型',
              message: '不能为空'
            },
            {
              validator: this.formRecord.c57 === '热泵型' ? atLeastTwoDecimals : check,
              trigger: 'blur'
            }
          ],
          c6: [
            {
              trigger: 'change,blur',
              required: this.formRecord.c57 === '单冷式',
              message: '不能为空'
            },
            {
              validator: this.formRecord.c57 === '单冷式' ? twoDecimals : check,
              trigger: 'blur'
            }
          ],
          c5: [
            {
              trigger: 'change,blur',
              required: true,
              message: '不能为空'
            },
            {
              validator: isNumber,
              trigger: 'blur'
            }
            , {
              validator: checkc5,
              trigger: 'blur'
            }
          ],
          c7: [
            {
              trigger: 'change,blur',
              required: true,
              message: '不能为空'
            },
            {
              validator: isInteger,
              trigger: 'blur'
            }
          ],
          c31: [
            {
              trigger: 'change,blur',
              required: true,
              message: '不能为空'
            },
            {
              validator: atLeastOneDecimals,
              trigger: 'blur'
            }
          ],
          c35: [
            {
              trigger: 'change,blur',
              required: true,
              message: '不能为空'
            },
            {
              validator: atLeastTwoDecimals,
              trigger: 'blur'
            }
          ],
          c40: [
            {
              trigger: 'change,blur',
              required: true,
              message: '不能为空'
            },
            {
              validator: atLeastOneDecimals,
              trigger: 'blur'
            }
          ],
          c10: [
            {
              trigger: 'change,blur',
              required: true,
              message: '不能为空'
            }
          ],
          c15: [
            {
              trigger: 'change,blur',
              required: true,
              message: '不能为空'
            }
          ],
          c12: [
            {
              trigger: 'change,blur',
              required: true,
              message: '不能为空'
            }
          ],
          c13: [
            {
              trigger: 'change,blur',
              required: this.formRecord.c12 === '其它',
              message: '不能为空'
            }
          ],
          c14: [
            {
              trigger: 'change,blur',
              required: true,
              message: '不能为空'
            }
          ],
          c48: [
            {
              trigger: 'change,blur',
              required: this.formRecord.c14 === '有',
              message: '不能为空'
            }
          ],
          c58: [
            {
              trigger: 'change,blur',
              required: true,
              message: '不能为空'
            }
          ],
          c59: [
            {
              trigger: 'change,blur',
              required: true,
              message: '不能为空'
            },
            {
              validator: oneDecimals,
              trigger: 'blur'
            }
          ],
          c16: [
            {
              trigger: 'change,blur',
              required: true,
              message: '不能为空'
            }
          ],
          c17: [
            {
              trigger: 'change,blur',
              required: true,
              message: '不能为空'
            }
          ],
          c18: [
            {
              trigger: 'change,blur',
              required: true,
              message: '不能为空'
            }
          ],
          c19: [
            {
              trigger: 'change,blur',
              required: true,
              message: '不能为空'
            }
          ],
          c20: [
            {
              trigger: 'change,blur',
              required: true,
              message: '不能为空'
            }
          ],
          c21: [
            {
              trigger: 'change,blur',
              required: true,
              message: '不能为空'
            }
          ],
          c22: [
            {
              trigger: 'change,blur',
              required: true,
              message: '不能为空'
            }
          ],
          c23: [
            {
              trigger: 'change,blur',
              required: true,
              message: '不能为空'
            }
          ],
          c24: [
            {
              trigger: 'change,blur',
              required: true,
              message: '不能为空'
            }
          ],
          c56: [
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
          c47: [
            {
              trigger: 'change,blur',
              required: true,
              message: '不能为空'
            },
            {
              validator: oneDecimals,
              trigger: 'blur'
            }
          ],
          c46: [
            {
              trigger: 'change,blur',
              required: true,
              message: '不能为空'
            }
          ],
          c26: [
            {
              trigger: 'change,blur',
              required: true,
              message: '不能为空'
            }
          ],
          c29: [
            {
              trigger: 'change,blur',
              required: true,
              message: '不能为空'
            }
          ],
          c53: [
            {
              trigger: 'change,blur',
              required: true,
              message: '不能为空'
            }
          ],
          c27: [
            {
              trigger: 'change,blur',
              required: true,
              message: '不能为空'
            }
          ],
          c49: [
            {
              trigger: 'change,blur',
              required: true,
              message: '不能为空'
            }
          ],
          c50: [
            {
              trigger: 'change,blur',
              required: true,
              message: '不能为空'
            }
          ],
          c28: [
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
          ],
          c54: [
            {
              trigger: 'change,blur',
              required: true,
              message: '不能为空'
            }
          ],
          c55: [
            {
              trigger: 'change,blur',
              required: true,
              message: '不能为空'
            }
          ],
          c60: [
            {
              trigger: 'change,blur',
              required: true,
              message: '不能为空'
            }
          ],
          c61: [
            {
              trigger: 'change,blur',
              required: true,
              message: '不能为空'
            }
          ],
          c62: [
            {
              trigger: 'change,blur',
              required: true,
              message: '不能为空'
            }
          ],
          c63: [
            {
              trigger: 'change,blur',
              required: true,
              message: '不能为空'
            }
          ],
          c64: [
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
