<!--11、家用和类似用途交流换气扇 2015版	-->
<!--创建日期:2019年6月10日-->
<!--创建人:YCL-->
<template>
  <div class="wrapper">
    <Form ref="formRecord" :model="formRecord" label-position="right" :rules="ruleRecord">
      <h1>家用和类似用途交流换气扇-能源效率标识备案表</h1>
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
          <FormItem prop="c2" label="制造单位" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c2" placeholder="制造单位" :disabled='disabledoff'/>
          </FormItem>
          <FormItem prop="c3" label="备案方" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c3" placeholder="备案方" :disabled='disabledoff'/>
          </FormItem>
          <FormItem prop="c4" label="产品规格型号" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c4" placeholder="规格型号" :disabled='!disabledoff'/>
          </FormItem>
          <FormItem prop="c5" label="商标" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c5" placeholder="商标" :disabled='disabledoff'/>
          </FormItem>
          <FormItem prop="c200" label="依据国家标准" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c200" placeholder="依据国家标准" readonly disabled/>
          </FormItem>
          <FormItem prop="c6" label="能效等级" style="width:100%;" :label-width="180">
            <RadioGroup v-model="formRecord.c6">
              <Radio label="1" :disabled='disabledoff'>1级</Radio>
              <Radio label="2" :disabled='disabledoff'>2级</Radio>
              <Radio label="3" :disabled='disabledoff'>3级</Radio>
            </RadioGroup>
          </FormItem>
          <table id="table1">
            <tr>
              <th>项目</th>
              <th><i class="red">*</i>标称值</th>
              <th><i class="red">*</i>实测值</th>
              <th>备注</th>
            </tr>
            <tr>
              <td>能效值[m³/( min·W)]</td>
              <td>
                <FormItem prop="c7">
                  <Input type="text" v-model="formRecord.c7" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c8">
                  <Input type="text" v-model="formRecord.c8" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c9">
                  <Input type="text" v-model="formRecord.c9" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>额定输入功率（W）</td>
              <td>
                <FormItem prop="c10">
                  <Input type="text" v-model="formRecord.c10" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c11">
                  <Input type="text" v-model="formRecord.c11" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c12">
                  <Input type="text" v-model="formRecord.c12" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>标称风量（m³/min）</td>
              <td>
                <FormItem prop="c13">
                  <Input type="text" v-model="formRecord.c13" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c14">
                  <Input type="text" v-model="formRecord.c14" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c15">
                  <Input type="text" v-model="formRecord.c15" :disabled='disabledoff'/>
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
          <FormItem prop="c16" label="备案标识开始使用日期" style="width:100%;">
            <DatePicker type="date" :options="dataInit" style="width: 200px" v-model="formRecord.c16"></DatePicker>
          </FormItem>
        </Card>
      </div>
      <div class="part part5">
        <Card :bordered="false">
          <h2>五、样品描述</h2>
          <table id="table3">
            <tr>
              <td>电源线插头形式</td>
              <td>
                <FormItem prop="c17">
                  <RadioGroup v-model="formRecord.c17">
                    <Radio label="两极" :disabled='disabledoff'>两极</Radio>
                    <Radio label="三极" :disabled='disabledoff'>三极</Radio>
                    <Radio label="其它" :disabled='disabledoff'>其它</Radio>
                  </RadioGroup>
                </FormItem>
                <FormItem prop="c18">
                  <Input type="text" v-model="formRecord.c18" :disabled='disabledoff || forbidden.c18'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>额定电压（V）</td>
              <td>
                <FormItem prop="c19">
                  <Input type="text" v-model="formRecord.c19" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>种类</td>
              <td>
                <FormItem prop="c20">
                  <RadioGroup v-model="formRecord.c20">
                    <Radio label="A型换气扇" :disabled='disabledoff'>A型换气扇</Radio>
                    <Radio label="A型非管道天花板换气扇" :disabled='disabledoff'>A型非管道天花板换气扇</Radio>
                    <Radio label="B型换气扇" :disabled='disabledoff'>B型换气扇</Radio>
                    <Radio label="D型换气扇" :disabled='disabledoff'>D型换气扇</Radio>
                    <Radio label="进风口中心线和出风口中心线重合或平行的离心式D型换气扇" :disabled='disabledoff'>进风口中心线和出风口中心线重合或平行的离心式D型换气扇
                    </Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>规格（mm）</td>
              <td>
                <FormItem prop="c21">
                  <Input type="text" v-model="formRecord.c21" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>电动机种类</td>
              <td>
                <FormItem prop="c22">
                  <RadioGroup v-model="formRecord.c22">
                    <Radio label="电容式" :disabled='disabledoff'>电容式</Radio>
                    <Radio label="罩极式" :disabled='disabledoff'>罩极式</Radio>
                    <Radio label="其它" :disabled='disabledoff'>其它</Radio>
                  </RadioGroup>
                </FormItem>
                <FormItem prop="c23">
                  <Input type="text" v-model="formRecord.c23" :disabled='disabledoff || forbidden.c23'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>控制方式</td>
              <td>
                <FormItem prop="c24">
                  <RadioGroup v-model="formRecord.c24">
                    <Radio label="机械" :disabled='disabledoff'>机械</Radio>
                    <Radio label="电子" :disabled='disabledoff'>电子</Radio>
                    <Radio label="其它" :disabled='disabledoff'>其它</Radio>
                  </RadioGroup>
                </FormItem>
                <FormItem prop="c25">
                  <Input type="text" v-model="formRecord.c25" :disabled='disabledoff || forbidden.c25'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>定时器</td>
              <td>
                <FormItem prop="c26">
                  <RadioGroup v-model="formRecord.c26">
                    <Radio label="有" :disabled='disabledoff'>有</Radio>
                    <Radio label="无" :disabled='disabledoff'>无</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>叶轮材质</td>
              <td>
                <FormItem prop="c27">
                  <RadioGroup v-model="formRecord.c27">
                    <Radio label="ABS" :disabled='disabledoff'>ABS</Radio>
                    <Radio label="PP" :disabled='disabledoff'>PP</Radio>
                    <Radio label="其它" :disabled='disabledoff'>其它</Radio>
                  </RadioGroup>
                </FormItem>
                <FormItem prop="c28">
                  <Input type="text" v-model="formRecord.c28" :disabled='disabledoff || forbidden.c28'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>换气扇外壳材质</td>
              <td>
                <FormItem prop="c29">
                  <RadioGroup v-model="formRecord.c29">
                    <Radio label="ABS" :disabled='disabledoff'>ABS</Radio>
                    <Radio label="PP" :disabled='disabledoff'>PP</Radio>
                    <Radio label="其它" :disabled='disabledoff'>其它</Radio>
                  </RadioGroup>
                </FormItem>
                <FormItem prop="c30">
                  <Input type="text" v-model="formRecord.c30" :disabled='disabledoff || forbidden.c30'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td><i class="red">*</i>外形尺寸（长×宽×高）（mm×mm×mm）</td>
              <td>
                <FormItem prop="c31">
                  <Input type="text" v-model="formRecord.c31" :disabled='disabledoff'/>
                </FormItem>
                <FormItem><b>×</b></FormItem>
                <FormItem prop="c32">
                  <Input type="text" v-model="formRecord.c32" :disabled='disabledoff'/>
                </FormItem>
                <FormItem><b>×</b></FormItem>
                <FormItem prop="c33">
                  <Input type="text" v-model="formRecord.c33" :disabled='disabledoff'/>
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
              <th>部件名称</th>
              <th colspan="2">规格型号</th>
              <th colspan="2">技术参数</th>
              <th>生产者（全称）</th>
            </tr>
            <tr>
              <td rowspan="2">1</td>
              <td rowspan="2">
                扇叶驱动用电动机
              </td>
              <td colspan="2" rowspan="2">
                <FormItem prop="c34">
                  <Input type="text" v-model="formRecord.c34" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td width="70">功率(W)</td>
              <td>
                <FormItem prop="c35">
                  <Input type="text" v-model="formRecord.c35" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td rowspan="2">
                <FormItem prop="c36">
                  <Input type="text" v-model="formRecord.c36" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
            </tr>
            <tr>
              <td rowspan="2">2</td>
              <td rowspan="2">
                扇叶驱动用电动机
              </td>
              <td colspan="2" rowspan="2">
                <FormItem prop="c37">
                  <Input type="text" v-model="formRecord.c37" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td width="70">功率(W)</td>
              <td>
                <FormItem prop="c38">
                  <Input type="text" v-model="formRecord.c38" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td rowspan="2">
                <FormItem prop="c39">
                  <Input type="text" v-model="formRecord.c39" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
            </tr>
            <tr>
              <td rowspan="2">3</td>
              <td rowspan="2">
                扇叶驱动用电动机
              </td>
              <td colspan="2" rowspan="2">
                <FormItem prop="c40">
                  <Input type="text" v-model="formRecord.c40" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td width="70">功率(W)</td>
              <td>
                <FormItem prop="c41">
                  <Input type="text" v-model="formRecord.c41" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td rowspan="2">
                <FormItem prop="c42">
                  <Input type="text" v-model="formRecord.c42" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
            </tr>
            <tr>
              <td rowspan="2">4</td>
              <td rowspan="2">扇叶</td>
              <td colspan="2" rowspan="2">
                <FormItem prop="c43">
                  <Input type="text" v-model="formRecord.c43" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td width="70">材质</td>
              <td>
                <FormItem prop="c44">
                  <Input type="text" v-model="formRecord.c44" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td rowspan="2">
                <FormItem prop="c45">
                  <Input type="text" v-model="formRecord.c45" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td width="70">片数</td>
              <td>
                <FormItem prop="c46">
                  <Input type="text" v-model="formRecord.c46" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td rowspan="2">5</td>
              <td rowspan="2">扇叶</td>
              <td colspan="2" rowspan="2">
                <FormItem prop="c47">
                  <Input type="text" v-model="formRecord.c47" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td width="70">材质</td>
              <td>
                <FormItem prop="c48">
                  <Input type="text" v-model="formRecord.c48" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td rowspan="2">
                <FormItem prop="c49">
                  <Input type="text" v-model="formRecord.c49" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td width="70">片数</td>
              <td>
                <FormItem prop="c50">
                  <Input type="text" v-model="formRecord.c50" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td rowspan="2">6</td>
              <td rowspan="2">扇叶</td>
              <td colspan="2" rowspan="2">
                <FormItem prop="c51">
                  <Input type="text" v-model="formRecord.c51" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td width="70">材质</td>
              <td>
                <FormItem prop="c52">
                  <Input type="text" v-model="formRecord.c52" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td rowspan="2">
                <FormItem prop="c53">
                  <Input type="text" v-model="formRecord.c53" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td width="70">片数</td>
              <td>
                <FormItem prop="c54">
                  <Input type="text" v-model="formRecord.c54" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td rowspan="2">7</td>
              <td rowspan="2">电机运转用电容器</td>
              <td colspan="2" rowspan="2">
                <FormItem prop="c55">
                  <Input type="text" v-model="formRecord.c55" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td width="70">电压(V)</td>
              <td>
                <FormItem prop="c56">
                  <Input type="text" v-model="formRecord.c56" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td rowspan="2">
                <FormItem prop="c57">
                  <Input type="text" v-model="formRecord.c57" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td width="70">电容量</td>
              <td>
                <FormItem prop="c58">
                  <Input type="text" v-model="formRecord.c58" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td rowspan="2">8</td>
              <td rowspan="2">电机运转用电容器</td>
              <td colspan="2" rowspan="2">
                <FormItem prop="c59">
                  <Input type="text" v-model="formRecord.c59" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td width="70">电压(V)</td>
              <td>
                <FormItem prop="c60">
                  <Input type="text" v-model="formRecord.c60" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td rowspan="2">
                <FormItem prop="c61">
                  <Input type="text" v-model="formRecord.c61" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td width="70">电容量</td>
              <td>
                <FormItem prop="c62">
                  <Input type="text" v-model="formRecord.c62" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td rowspan="2">9</td>
              <td rowspan="2">电机运转用电容器</td>
              <td colspan="2" rowspan="2">
                <FormItem prop="c63">
                  <Input type="text" v-model="formRecord.c63" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td width="70">电压(V)</td>
              <td>
                <FormItem prop="c64">
                  <Input type="text" v-model="formRecord.c64" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td rowspan="2">
                <FormItem prop="c65">
                  <Input type="text" v-model="formRecord.c65" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td width="70">电容量</td>
              <td>
                <FormItem prop="c66">
                  <Input type="text" v-model="formRecord.c66" :disabled='disabledoff'/>
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
      <img class="lookPdf" v-if="!uploadPic.includes('.pdf')" :src="uploadPic" />
      <embed class="lookPdf" v-else :src="uploadPic" width="600" height="400" type="application/pdf"  internalinstanceid="81" />
    </Modal>
     <Modal v-model="modal5" class="basic-info pageStyle"  :width=650 ok-text="保存"  @on-ok="submitBasic" cancel-text="关闭">
       <h2>标识型号{{pageType==="extend"?'扩展':'变更'}}备案申请书</h2>
       <p class="org">中国标准化研究院能效标识管理中心：</p>
       <div class="pro-info">
          我 <span  class="f-company">{{formRecord.c1}}</span>
          公司生产的 <span class="f-brand">{{formRecord.c5}}</span>
         品牌的 <span class="f-model">{{pageType==='extend'?mainModel:formRecord.c4}}</span>
         型号的 <span class="f-product">家用和类似用途交流换气扇 2015版</span>产品{{pageType==="update"?'已通过能效标识备案':''}}。
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
    numberCheck,
    numberOr1,
    decimalOr2,
    numberOrn,
    atLeastThreeDecimals
  } from '@/libs/utilExt'

  export default {
    data() {
      const timeDate=parseInt(this.$store.state.app.dateinit);
      return {
        // 当前初始使用日期 对应的C值
        thisDateCV: "c16",
        // 当前能效等级 对应的C值
        thisLevelCV: "c6",
        thisGZXHCV: "c4",// 当前规格型号 对应的C值
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
          c3: '',
          c5: '',
          c4: '',
          c2: '',
          c200: '',
          c7: '',
          c18: '',
          c19: '',
          c20: '',
          c38: '',
          c11: '',
          c12: '',
          c54: '',
          c60: '',
          c39: '',
          c44: '',
          c49: '',
          c55: '',
          c61: '',
          c40: '',
          c45: '',
          c50: '',
          c56: '',
          c62: '',
          c41: '',
          c46: '',
          c51: '',
          c57: '',
          c63: '',
          c42: '',
          c47: '',
          c52: '',
          c58: '',
          c64: '',
          c43: '',
          c48: '',
          c53: '',
          c59: '',
          c65: '',
          c8: '',
          c9: '',
          c14: '',
          c16: new Date(),
          c17: '',
          c6: '',
          c15: '',
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
          c35: '',
          c36: '',
          c37: '',
          c66: '',
          c67: '',
          c68: '',
          ec_model_no: 53,
          attach_list: ''
        },
        forbidden: {
          c18: true,
          c23: true,
          c25: true,
          c28: true,
          c30: true,
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
        if (this.formRecord.c17 === '其它') {
          this.forbidden.c18 = false
        } else {
          this.formRecord.c18 = ''
          this.forbidden.c18 = true
        }
        if (this.formRecord.c22 === '其它') {
          this.forbidden.c23 = false
        } else {
          this.formRecord.c23 = ''
          this.forbidden.c23 = true
        }
        if (this.formRecord.c24 === '其它') {
          this.forbidden.c25 = false
        } else {
          this.formRecord.c25 = ''
          this.forbidden.c25 = true
        }
        if (this.formRecord.c27 === '其它') {
          this.forbidden.c28 = false
        } else {
          this.formRecord.c28 = ''
          this.forbidden.c28 = true
        }
        if (this.formRecord.c29 === '其它') {
          this.forbidden.c30 = false
        } else {
          this.formRecord.c30 = ''
          this.forbidden.c30 = true
        }

        const checkc10 = (rule, value, callback) => {
          if (parseInt(this.formRecord.c10) > 500) {
              callback("额定输入功率不能大于500");
            } else {
            callback()
          }
        }

        const checkc7 = (rule, value, callback) => {
          if (parseFloat(this.formRecord.c7) > parseFloat(this.formRecord.c8)) {
            callback("能效值标称值不能大于实测值");
          } else {
            callback()
          }
        }

        // 额定输入功率 标注值 实测值
        var edsrgl = parseInt(this.formRecord.c10);
        var edsrglscz = parseInt(this.formRecord.c11);
        const checkc11 = (rule, value, callback) => {
          if (edsrgl > 25 && edsrgl <= 300) {
            if (edsrgl * 1.2 < edsrglscz) {
              callback("实测功率不能大于额定功率的120");
            } else {
              callback()
            }
          } else if (edsrgl > 300) {
            if (edsrgl * 1.15 < edsrglscz || (edsrglscz - edsrgl) > 60) {
              callback("实测功率不能大于额定功率的115%或额定功率+60");
            } else {
              callback()
            }
          }
        }

        var eddy = this.formRecord.c19;
        const checkc19 = (rule, value, callback) => {
          if (eddy > 250) {
            callback("额定电压不能大于250");
          } else {
            callback()
          }
        }
        var nxdj = "";
        //规格(mm)
        var guige = parseInt(this.formRecord.c21);
        var ggfunc = (num) => {
          var gg = num;
          if (gg < 125) {
            gg = 100;
          } else if (gg > 125 && gg <= 175) {
            gg = 150;
          } else if (gg > 175 && gg <= 225) {
            gg = 200;
          } else if (gg > 225 && gg <= 275) {
            gg = 250;
          } else if (gg > 275 && gg <= 325) {
            gg = 300;
          } else if (gg > 325 && gg <= 375) {
            gg = 350;
          } else if (gg > 375 && gg <= 425) {
            gg = 400;
          } else if (gg > 425 && gg <= 475) {
            gg = 450;
          } else if (gg > 475) {
            gg = 500;
          }
          return gg;
        };
        var num = ggfunc(guige);
        //能效值 标称值
        var nxz = parseFloat(this.formRecord.c7);
        //标称风量 标注值
        var bcfl = parseFloat(this.formRecord.c13);

        /*//能效值 实测值 zkb
        var nxz_scz = parseFloat($("#c8").val());
        //能效值 标注值应 小于等于 实测值。
        if (nxz > nxz_scz) {
            alert("能效值的标注值应 小于等于 实测值！");0
            validate.bool = false;
            return;
        }*/

        //种类
        var zl = this.formRecord.c20;
        //换气扇种类
        var hqszl = this.formRecord.c22;

        const check = () => {
          if (zl === "A型换气扇") {
            if (parseFloat(this.formRecord.c12) * 0.9 >= parseFloat(this.formRecord.c14)) {
              return "c14:标称风量实测值应大于等于标注值的90%";
            }
            if (guige <= 500) {
              if (hqszl === "罩极式") {
                if (num === 100) {
                  if (nxz >= 0.13) {
                    nxdj = 1;
                  }
                  if (nxz >= 0.10 && nxz < 0.13) {
                    nxdj = 2;
                  }
                  if (nxz >= 0.07 && nxz < 0.10) {
                    nxdj = 3;
                  }
                } else if (num === 150) {
                  if (nxz >= 0.23) {
                    nxdj = 1;
                  }
                  if (nxz >= 0.17 && nxz < 0.23) {
                    nxdj = 2;
                  }
                  if (nxz >= 0.11 && nxz < 0.17) {
                    nxdj = 3;
                  }
                } else if (num === 200) {
                  if (nxz >= 0.26) {
                    nxdj = 1;
                  }
                  if (nxz >= 0.21 && nxz < 0.26) {
                    nxdj = 2;
                  }
                  if (nxz >= 0.13 && nxz < 0.21) {
                    nxdj = 3;
                  }
                } else {
                  return "c21:规格不在备案范围";
                }
              } else if (hqszl === "电容式") {
                if (num === 150) {
                  if (nxz >= 0.24) {
                    nxdj = 1;
                  }
                  if (nxz >= 0.20 && nxz < 0.24) {
                    nxdj = 2;
                  }
                  if (nxz >= 0.15 && nxz < 0.20) {
                    nxdj = 3;
                  }
                } else if (num === 200) {
                  if (nxz >= 0.38) {
                    nxdj = 1;
                  }
                  if (nxz >= 0.32 && nxz < 0.38) {
                    nxdj = 2;
                  }
                  if (nxz >= 0.25 && nxz < 0.32) {
                    nxdj = 3;
                  }
                } else if (num === 250) {
                  if (nxz >= 0.46) {
                    nxdj = 1;
                  }
                  if (nxz >= 0.40 && nxz < 0.46) {
                    nxdj = 2;
                  }
                  if (nxz >= 0.34 && nxz < 0.40) {
                    nxdj = 3;
                  }
                } else if (num === 300) {
                  if (nxz >= 0.50) {
                    nxdj = 1;
                  }
                  if (nxz >= 0.42 && nxz < 0.50) {
                    nxdj = 2;
                  }
                  if (nxz >= 0.38 && nxz < 0.42) {
                    nxdj = 3;
                  }
                } else if (num === 350) {
                  if (nxz >= 0.51) {
                    nxdj = 1;
                  }
                  if (nxz >= 0.43 && nxz < 0.51) {
                    nxdj = 2;
                  }
                  if (nxz >= 0.32 && nxz < 0.43) {
                    nxdj = 3;
                  }
                } else if (num === 400) {
                  if (nxz >= 0.45) {
                    nxdj = 1;
                  }
                  if (nxz >= 0.41 && nxz < 0.45) {
                    nxdj = 2;
                  }
                  if (nxz >= 0.31 && nxz < 0.41) {
                    nxdj = 3;
                  }
                } else if (num === 450) {
                  if (nxz >= 0.41) {
                    nxdj = 1;
                  }
                  if (nxz >= 0.36 && nxz < 0.41) {
                    nxdj = 2;
                  }
                  if (nxz >= 0.30 && nxz < 0.36) {
                    nxdj = 3;
                  }
                } else if (num === 500) {
                  if (nxz >= 0.40) {
                    nxdj = 1;
                  }
                  if (nxz >= 0.35 && nxz < 0.40) {
                    nxdj = 2;
                  }
                  if (nxz >= 0.26 && nxz < 0.35) {
                    nxdj = 3;
                  }
                } else {
                  return "c21:规格不在备案范围";
                }
              } else {
                return "c22:电动机种类不在备案范围";
              }
            } else {
              return "c21:规格不能大于500";
            }
          } else if (zl === "A型非管道天花板换气扇") {
            if (parseFloat(this.formRecord.c13) * 0.9 >= parseFloat(this.formRecord.c14)) {
              return "c14:标称风量实测值应大于等于标注值的90%";
            }
            if (guige <= 500) {
              if (hqszl === "电容式") {
                if (num === 150) {
                  if (nxz >= 0.20) {
                    nxdj = 1;
                  }
                  if (nxz >= 0.16 && nxz < 0.20) {
                    nxdj = 2;
                  }
                  if (nxz >= 0.11 && nxz < 0.16) {
                    nxdj = 3;
                  }
                } else if (num === 200) {
                  if (nxz >= 0.34) {
                    nxdj = 1;
                  }
                  if (nxz >= 0.24 && nxz < 0.34) {
                    nxdj = 2;
                  }
                  if (nxz >= 0.17 && nxz < 0.24) {
                    nxdj = 3;
                  }
                } else if (num === 250) {
                  if (nxz >= 0.42) {
                    nxdj = 1;
                  }
                  if (nxz >= 0.32 && nxz < 0.42) {
                    nxdj = 2;
                  }
                  if (nxz >= 0.25 && nxz < 0.32) {
                    nxdj = 3;
                  }
                } else if (num === 300) {
                  if (nxz >= 0.45) {
                    nxdj = 1;
                  }
                  if (nxz >= 0.35 && nxz < 0.45) {
                    nxdj = 2;
                  }
                  if (nxz >= 0.27 && nxz < 0.35) {
                    nxdj = 3;
                  }
                } else {
                  return "c21:规格不在备案范围";
                }
              } else {
                return "c22:电动机种类不在备案范围";
              }
            } else {
              return "c21:规格不能大于500";
            }
          } else if (zl === "B型换气扇") {
            if (parseFloat(this.formRecord.c13) * 0.95 >= parseFloat(this.formRecord.c14)) {
              return "c14:标称风量实测值应大于等于标注值的95%";
            }
            if (hqszl === "电容式") {
              if (bcfl <= 2.5) {
                if (nxz >= 0.08) {
                  nxdj = 1;
                }
                if (nxz >= 0.06 && nxz < 0.08) {
                  nxdj = 2;
                }
                if (nxz >= 0.04 && nxz < 0.06) {
                  nxdj = 3;
                }
              }
              if (bcfl <= 4.0 && bcfl > 2.5) {
                if (nxz >= 0.10) {
                  nxdj = 1;
                }
                if (nxz >= 0.08 && nxz < 0.10) {
                  nxdj = 2;
                }
                if (nxz >= 0.06 && nxz < 0.08) {
                  nxdj = 3;
                }
              }
              if (bcfl > 4.0) {
                if (nxz >= 0.12) {
                  nxdj = 1;
                }
                if (nxz >= 0.09 && nxz < 0.12) {
                  nxdj = 2;
                }
                if (nxz >= 0.07 && nxz < 0.09) {
                  nxdj = 3;
                }
              }
            } else {
              return "c22:电动机种类不在备案范围";
            }
          } else if (zl === "D型换气扇") {
            if (parseFloat(this.formRecord.c13) * 0.95 >= parseFloat(this.formRecord.c14)) {
              return "c14:标称风量实测值应大于等于标注值的95%";
            }
            if (hqszl === "电容式") {
              if (bcfl <= 2.5) {
                if (nxz >= 0.14) {
                  nxdj = 1;
                }
                if (nxz >= 0.10 && nxz < 0.14) {
                  nxdj = 2;
                }
                if (nxz >= 0.06 && nxz < 0.10) {
                  nxdj = 3;
                }
              }
              if (bcfl <= 10 && bcfl > 2.5) {
                if (nxz >= 0.18) {
                  nxdj = 1;
                }
                if (nxz >= 0.13 && nxz < 0.18) {
                  nxdj = 2;
                }
                if (nxz >= 0.11 && nxz < 0.13) {
                  nxdj = 3;
                }
              }
              if (bcfl > 10) {
                if (nxz >= 0.17) {
                  nxdj = 1;
                }
                if (nxz >= 0.09 && nxz < 0.17) {
                  nxdj = 2;
                }
                if (nxz >= 0.07 && nxz < 0.09) {
                  nxdj = 3;
                }
              }
            } else {
              return "c22:电动机种类不在备案范围";
            }
          } else if (zl === "进风口中心线和出风口中心线重合或平行的离心式D型换气扇") {
            if (parseFloat(this.formRecord.c13) * 0.95 >= parseFloat(this.formRecord.c14)) {
              return "c14:标称风量实测值应大于等于标注值的95%"
            }
            if (hqszl === "电容式") {
              if (bcfl <= 2.5) {
                if (nxz >= 0.119) {
                  nxdj = 1;
                }
                if (nxz >= 0.085 && nxz < 0.119) {
                  nxdj = 2;
                }
                if (nxz >= 0.051 && nxz < 0.085) {
                  nxdj = 3;
                }
              }
              if (bcfl <= 10 && bcfl > 2.5) {
                if (nxz >= 0.153) {
                  nxdj = 1;
                }
                if (nxz >= 0.1105 && nxz < 0.153) {
                  nxdj = 2;
                }
                if (nxz >= 0.0935 && nxz < 0.1105) {
                  nxdj = 3;
                }
              }
              if (bcfl > 10) {
                if (nxz >= 0.1445) {
                  nxdj = 1;
                }
                if (nxz >= 0.0765 && nxz < 0.1445) {
                  nxdj = 2;
                }
                if (nxz >= 0.0595 && nxz < 0.0765) {
                  nxdj = 3;
                }
              }
            } else {
              return "c22:电动机种类不在备案范围";
            }
          }
        }

        const checkc22 = (rule, value, callback) => {
          let messages = (check() || "").split(":")
          if (messages[0] === "c22") {
            callback(messages[1]);
          }else {
            callback()
          }
        }
        const checkc14 = (rule, value, callback) => {
          let messages = (check() || "").split(":")
          if (messages[0] === "c14") {
            callback(messages[1]);
          } else {
            callback()
          }
        }
        const checkc21 = (rule, value, callback) => {
          let messages = (check() || "").split(":")
          if (messages[0] === "c21") {
            callback(messages[1]);
          }else {
            callback()
          }
        }

        //能效等级
        var nxdjch = this.formRecord.c6;
        const checkc6 = (rule, value, callback) => {
          check()
          if (nxdjch != nxdj) {
            callback("所选能效等级与计算结果不符！");
          }else {
            callback()
          }
        }

        return {
          c1: [
            {
              trigger: 'change,blur',
              required: true,
              message: '生产者名称不能为空'
            }
          ],
          c2: [
            {
              trigger: 'change,blur',
              required: true,
              message: '制造单位不能为空'
            }
          ],
          c3: [
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
              message: '规格型号不能为空'
            }
          ],
          c5: [
            {
              trigger: 'change,blur',
              required: true,
              message: '商标不能为空'
            }
          ],
          c6: [
            {
              trigger: 'change,blur',
              required: true,
              message: '能效等级不能为空'
            },
            {
              validator: checkc6,
              trigger: 'blur'
            }
          ],
          c7: [
            {
              trigger: 'change,blur',
              required: true,
              message: '能效值不能为空'
            },
            {
              validator: twoDecimals,
              trigger: 'blur'
            }
          ],
          c8: [
            {
              trigger: 'change,blur',
              required: true,
              message: '实测值不能为空'
            },
            {
              validator: atLeastThreeDecimals,
              trigger: 'blur'
            }
          ],
          c10: [
            {
              trigger: 'change,blur',
              validator: numberOr1,
            }
          ],
          c11: [
            {
              trigger: 'change,blur',
              required: true,
              message: '实测值不能为空'
            }
          ],
          c13: [
            {
              trigger: 'change,blur',
              required: true,
              message: '标称风量不能为空'
            },
            {
              validator: numberOrn,
              trigger: 'blur'
            }
          ],
          c14: [
            {
              trigger: 'change,blur',
              required: true,
              message: '实测值不能为空'
            },
            {
              validator: checkc14,
              trigger: 'blur'
            }
          ],
          c16: [
            {
              required: true,
              message: '不能为空'
            }
          ],
          c17: [
            {
              trigger: 'change,blur',
              required: true,
              message: '电源线插头形式不能为空'
            }
          ],
          c19: [
            {
              trigger: 'change,blur',
              required: true,
              message: '额定电压不能为空'
            }
          ],
          c20: [
            {
              trigger: 'change,blur',
              required: true,
              message: '种类不能为空'
            }
          ],
          c21: [
            {
              trigger: 'change,blur',
              required: true,
              message: '规格不能为空'
            },
            {
              validator: checkc21,
              trigger: 'blur'
            }
          ],
          c22: [
            {
              trigger: 'change,blur',
              required: true,
              message: '电动机种类不能为空'
            },
            {
              validator: checkc22,
              trigger: 'blur'
            }
          ],
          c24: [
            {
              trigger: 'change,blur',
              required: true,
              message: '控制方式不能为空'
            }
          ],
          c26: [
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
          c29: [
            {
              trigger: 'change,blur',
              required: true,
              message: '不能为空'
            }
          ],
          c31: [
            {
              trigger: 'change,blur',
              required: true,
              message: '不能为空'
            }
          ],
          c32: [
            {
              trigger: 'change,blur',
              required: true,
              message: '不能为空'
            }
          ],
          c33: [
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
