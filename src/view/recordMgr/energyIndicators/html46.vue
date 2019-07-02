<!--计算机显示器2015版-->
<!--创建日期:2019年5月27日-->
<!--创建人:YCL-->
<template>
  <div class="wrapper">
    <Form ref="formRecord" :model="formRecord" label-position="right" :rules="ruleRecord">
      <h1>计算机显示器-能源效率标识备案表</h1>
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
            <Input type="text" v-model="formRecord.c1" disabled placeholder="生产者名称"/>
          </FormItem>
          <FormItem prop="c2" label="制造单位" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c2" :disabled='disabledoff' placeholder="制造单位"/>
          </FormItem>
          <FormItem prop="c3" label="备案方" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c3" :disabled='disabledoff' placeholder="备案方"/>
          </FormItem>
          <FormItem prop="c4" label="规格型号" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c4" :disabled='!disabledoff' placeholder="规格型号"/>
          </FormItem>
          <FormItem prop="c5" label="商标" style="width:100%" :label-width="180">
            <Input type="text" v-model="formRecord.c5" :disabled='disabledoff' placeholder="商标"/>
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
          <FormItem prop="c8" label="产品类型" :label-width="180">
            <RadioGroup v-model="formRecord.c8">
              <Radio :disabled='disabledoff' label="标准显示器">标准显示器</Radio>
              <Radio :disabled='disabledoff' label="高性能显示器">高性能显示器</Radio>
            </RadioGroup>
          </FormItem>
          <table id="table1">
            <tr>
              <th>项目</th>
              <th>额定值</th>
              <th>实测值</th>
              <th>备注</th>
            </tr>
            <tr>
              <td>能源效率（cd/W）</td>
              <td>
                <FormItem prop="c9">
                  <Input type="text" v-model="formRecord.c9" :disabled='disabledoff' placeholder="两位有效数字"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c12">
                  <Input type="text" v-model="formRecord.c12" :disabled='disabledoff' placeholder="三位有效数字"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c15">
                  <Input type="text" v-model="formRecord.c15" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>关闭状态功率（W）</td>
              <td>
                <FormItem prop="c10">
                  <Input type="text" v-model="formRecord.c10" :disabled='disabledoff' placeholder="两位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c13">
                  <Input type="text" v-model="formRecord.c13" :disabled='disabledoff' placeholder="三位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c16">
                  <Input type="text" v-model="formRecord.c16" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>睡眠状态功率（W）</td>
              <td>
                <FormItem prop="c11">
                  <Input type="text" v-model="formRecord.c11" :disabled='disabledoff' placeholder="两位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c14">
                  <Input type="text" v-model="formRecord.c14" :disabled='disabledoff' placeholder="三位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c17">
                  <Input type="text" v-model="formRecord.c17" :disabled='disabledoff'/>
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
          <FormItem prop="c18" label="备案标识开始使用日期" style="width:100%;">
            <DatePicker type="date" :options="dataInit" style="width: 200px" v-model="formRecord.c18"></DatePicker>
          </FormItem>
        </Card>
      </div>
      <div class="part part5">
        <Card :bordered="false">
          <h2>五、样品描述</h2>
          <table id="table3">
            <tr>
              <td>屏幕尺寸（长 × 宽）（mm × mm）</td>
              <td>
                <FormItem><b>长</b></FormItem>
                <FormItem prop="c19">
                  <Input style="vertical-align:top" type="text" v-model="formRecord.c19" :disabled='disabledoff'/>
                </FormItem>
                <FormItem><b>宽</b></FormItem>
                <FormItem prop="c20">
                  <Input type="text" v-model="formRecord.c20" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>固有分辨力（像素数）</td>
              <td>
                <FormItem prop="c21">
                  <Input type="text" v-model="formRecord.c21" :disabled='disabledoff'/>
                </FormItem>
                <FormItem><b>×</b></FormItem>
                <FormItem prop="c22">
                  <Input type="text" v-model="formRecord.c22" :disabled='disabledoff'/>
                </FormItem>
                <FormItem><b>(像素数)</b></FormItem>
              </td>
            </tr>
            <tr>
              <td>附加功能</td>
              <td>
                <FormItem prop="c23">
                  <CheckboxGroup v-model="formRecord.c23">
                    <Checkbox label="触摸" :disabled='disabledoff'>触摸</Checkbox>
                    <Checkbox label="无线接收" :disabled='disabledoff'>无线接收</Checkbox>
                    <Checkbox label="摄像头" :disabled='disabledoff'>摄像头</Checkbox>
                    <Checkbox label="其他" :disabled='disabledoff'>其他</Checkbox>
                  </CheckboxGroup>
                </FormItem>
                <FormItem prop="c24">
                  <Input type="text" v-model="formRecord.c24" :disabled='disabledoff || forbidden.c24'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>供电方式</td>
              <td>
                <FormItem prop="c25">
                  <RadioGroup v-model="formRecord.c25">
                    <Radio label="内置电源" :disabled='disabledoff'>内置电源</Radio>
                    <Radio label="外部电源，输出功率（W）" :disabled='disabledoff'>外部电源，输出功率（W）</Radio>
                  </RadioGroup>
                </FormItem>
                <FormItem prop="c26">
                  <Input type="text" v-model="formRecord.c26" :disabled='disabledoff || forbidden.c26'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>额定功率（W）</td>
              <td>
                <FormItem prop="c27">
                  <Input type="text" style="width: 440px" v-model="formRecord.c27" :disabled='disabledoff'
                         width="100px"/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>额定电压（V）</td>
              <td>
                <FormItem prop="c28">
                  <Input type="text" style="width: 440px" v-model="formRecord.c28" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>额定电流（A）</td>
              <td>
                <FormItem prop="c29">
                  <Input type="text" style="width: 440px" v-model="formRecord.c29" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>额定频率（Hz）</td>
              <td>
                <FormItem prop="c30">
                  <Input type="text" style="width: 440px" v-model="formRecord.c30" :disabled='disabledoff'/>
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
              <th>规格型号</th>
              <th>技术参数</th>
              <th>生产者（全称）</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td width="80">1</td>
              <td>显示器</td>
              <td>
                <FormItem prop="c31">
                  <Input type="text" v-model="formRecord.c31" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td width="330">
                <div>
                  <label class="mb7">
                    <span class="w70">分辨力：</span>
                    <FormItem prop="c32">
                      <Input type="text" v-model="formRecord.c32" :disabled='disabledoff'/>
                    </FormItem>
                  </label><br>
                  <label class="mb7">
                    <span class="w70">屏幕尺寸：</span>
                    <FormItem prop="c33">
                      <Input type="text" v-model="formRecord.c33" :disabled='disabledoff'/>
                    </FormItem>
                  </label><br>
                  <label class="mb7">
                    <span class="w70">亮度：</span>
                    <FormItem prop="c34">
                      <Input type="text" v-model="formRecord.c34" :disabled='disabledoff'/>
                    </FormItem>
                  </label>
                </div>
              </td>
              <td>
                <FormItem prop="c35">
                  <Input type="text" v-model="formRecord.c35" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td width="80">2</td>
              <td>
                显示器
              </td>
              <td>
                <FormItem prop="c48">
                  <Input type="text" v-model="formRecord.c48" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td class="tl" width="230">
                <div class="radio i-checks">
                  <label class="mb7"><span class="w70">分辨力：</span>
                    <FormItem prop="c49">
                      <Input type="text" v-model="formRecord.c49" :disabled='disabledoff'/>
                    </FormItem>
                  </label><br>
                  <label class="mb7"><span class="w70">屏幕尺寸：</span>
                    <FormItem prop="c50">
                      <Input type="text" v-model="formRecord.c50" :disabled='disabledoff'/>
                    </FormItem>
                  </label><br>
                  <label><span class="w70">亮度：</span>
                    <FormItem prop="c51">
                      <Input type="text" v-model="formRecord.c51" :disabled='disabledoff'/>
                    </FormItem>
                  </label>
                </div>
              </td>
              <td>
                <FormItem prop="c52">
                  <Input type="text" v-model="formRecord.c52" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td width="80">3</td>
              <td>
                显示器
              </td>
              <td>
                <FormItem prop="c53">
                  <Input type="text" v-model="formRecord.c53" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td class="tl" width="230">
                <div class="radio i-checks">
                  <label class="mb7"><span class="w70">分辨力：</span>
                    <FormItem prop="c54">
                      <Input type="text" v-model="formRecord.c54" :disabled='disabledoff'/>
                    </FormItem>
                  </label><br>
                  <label class="mb7"><span class="w70">屏幕尺寸：</span>
                    <FormItem prop="c55">
                      <Input type="text" v-model="formRecord.c55" :disabled='disabledoff'/>
                    </FormItem>
                  </label><br>
                  <label><span class="w70">亮度：</span>
                    <FormItem prop="c56">
                      <Input type="text" v-model="formRecord.c56" :disabled='disabledoff'/>
                    </FormItem>
                  </label>
                </div>
              </td>
              <td>
                <FormItem prop="c57">
                  <Input type="text" v-model="formRecord.c57" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td width="80">4</td>
              <td>
                变压器
              </td>
              <td>
                <FormItem prop="c36">
                  <Input type="text" v-model="formRecord.c36" :disabled='disabledoff'/>
                </FormItem>
              </td>
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
              <td width="80">5</td>
              <td>
                变压器
              </td>
              <td>
                <FormItem prop="c58">
                  <Input type="text" v-model="formRecord.c58" :disabled='disabledoff'/>
                </FormItem>
              </td>
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
            </tr>
            <tr>
              <td width="80">6</td>
              <td>
                变压器
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
            </tr>

            <tr>
              <td width="80">7</td>
              <td>
                主控IC
              </td>
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
              <td>
                <FormItem prop="c41">
                  <Input type="text" v-model="formRecord.c41" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td width="80">8</td>
              <td>
                主控IC
              </td>
              <td>
                <FormItem prop="c64">
                  <Input type="text" v-model="formRecord.c64" :disabled='disabledoff'/>
                </FormItem>
              </td>
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
            <tr>
              <td width="80">9</td>
              <td>
                主控IC
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
              <td width="80">10</td>
              <td>
                开关管
              </td>
              <td>
                <FormItem prop="c42">
                  <Input type="text" v-model="formRecord.c42" :disabled='disabledoff'/>
                </FormItem>
              </td>
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
              <td width="80">11</td>
              <td>
                开关管
              </td>
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
            </tr>
            <tr>
              <td width="80">12</td>
              <td>
                开关管
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
              <td>
                <FormItem prop="c75">
                  <Input type="text" v-model="formRecord.c75" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td width="80">13</td>
              <td>
                外部电源
              </td>
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
              <td>
                <FormItem prop="c47">
                  <Input type="text" v-model="formRecord.c47" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td width="80">14</td>
              <td>
                外部电源
              </td>
              <td>
                <FormItem prop="c76">
                  <Input type="text" v-model="formRecord.c76" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c77">
                  <Input type="text" v-model="formRecord.c77" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c78">
                  <Input type="text" v-model="formRecord.c78" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td width="60">15</td>
              <td>
                外部电源
              </td>
              <td>
                <FormItem prop="c79">
                  <Input type="text" v-model="formRecord.c79" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c80">
                  <Input type="text" v-model="formRecord.c80" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c81">
                  <Input type="text" v-model="formRecord.c81" :disabled='disabledoff'/>
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
          公司生产的 <span class="f-brand">{{formRecord.c5}}</span>
          品牌的 <span  class="f-model">{{formRecord.c4}}</span>
          型号的 <span  class="f-product">计算机显示器 2015版</span>产品。
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
    check
  } from '@/libs/utilExt'

  export default {
    data() {
      const timeDate=parseInt(this.$store.state.app.dateinit);
      return {

        // 当前初始使用日期 对应的C值
        thisDateCV: "c18",
        // 当前能效等级 对应的C值
        thisLevelCV: "c7",
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
        formRecord: {
          ec_master_kuozhan_text: '',
          c1: '',
          c2: '',
          c3: '',
          c4: '',
          c5: '',
          c7: '1',
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
          c18: new Date(),
          c19: '',
          c20: '',
          c21: '',
          c22: '',
          c23: [],
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
          c75: '',
          c76: '',
          c77: '',
          c78: '',
          c79: '',
          c80: '',
          c81: '',
          c202: '',
          ec_model_no: 46,
          attach_list: ''
        },
        forbidden: {
          c24: true,
          c26: true,
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
        //能效等级
        var nxdj = this.formRecord.c7
        //类型
        var lx = this.formRecord.c8
        //能源效率（cd/W）标注值
        var energyVal = parseFloat(this.formRecord.c9);
        //能源效率（cd/W）实测值
        var energyValsh = parseFloat(this.formRecord.c12);
        //关闭状态功率(W)标注值
        var closeVal = parseFloat(this.formRecord.c10)
        //关闭状态功率(W)实测值
        var closeValsh = parseFloat(this.formRecord.c13)
        //睡眠状态功率(W)标注值
        var sleepVal = parseFloat(this.formRecord.c11);
        //睡眠状态功率(W)实测值
        var sleepValsh = parseFloat(this.formRecord.c14);
        var nxdjst = "";

        if (this.formRecord.c23.join('').indexOf('其他') > -1) {
          this.forbidden.c24 = false
        } else {
          this.formRecord.c24 = ''
          this.forbidden.c24 = true
        }

        if (this.formRecord.c25 === '外部电源，输出功率（W）') {
          this.forbidden.c26 = false
        } else {
          this.formRecord.c26 = ''
          this.forbidden.c26 = true
        }
        const checkc9 = (rule, value, callback) => {
          if (energyVal > energyValsh) {
            callback('能源效率标注值应小于等于实测值')
          } else {
            callback()
          }
        }

        const checkc10 = (rule, value, callback) => {
          if (closeValsh > closeVal) {
            callback('关闭状态功率标注值应大于等于实测值')
          } else {
            callback()
          }
        }
        const checkc11 = (rule, value, callback) => {
          if (sleepValsh > sleepVal) {
            callback('睡眠状态功率标注值应大于等于实测值')
          } else {
            callback()
          }
        }

        var checkc10a
        var checkc11a
        var checkc10b
        var checkc11b
        if (lx != "") {
          if (lx == "标准显示器") {
            checkc10a = (rule, value, callback) => {
              if (closeVal > 0.5) {
                callback('关闭状态功率(W)标注值应小于等于0.50W')
              } else {
                callback()
              }
            }
            checkc11a = (rule, value, callback) => {
              if (sleepVal > 0.5) {
                callback('睡眠状态功率(W)标注值应小于等于0.50W')
              } else {
                callback()
              }
            }
            if (energyVal != "") {
              if (energyVal >= 2.0) {
                nxdjst = "1";
              }
              if (energyVal >= 1.5 && energyVal < 2.0) {
                nxdjst = "2";
              }
              if (energyVal >= 1.0 && energyVal < 1.5) {
                nxdjst = "3";
              }
            }
          } else if (lx == "高性能显示器") {
            checkc10b = (rule, value, callback) => {
              if (closeVal > 0.5) {
                callback('关闭状态功率(W)标注值应小于等于0.50W')
              } else {
                callback()
              }
            }
            checkc11b = (rule, value, callback) => {
              if (sleepVal > 1.2) {
                callback('睡眠状态功率(W)标注值应小于等于1.20W')
              } else {
                callback()
              }
            }
            if (energyVal != "") {
              if (energyVal >= 1.5) {
                nxdjst = "1";
              }
              if (energyVal >= 1.0 && energyVal < 1.5) {
                nxdjst = "2";
              }
              if (energyVal >= 0.50 && energyVal < 1.0) {
                nxdjst = "3";
              }
            }
          } else {
            nxdjst = "";
          }
        }

        const checkc7a = (rule, value, callback) => {
          if (nxdjst == "") {
            callback('能效数据不在备案范围')
          } else {
            callback()
          }
        }
        const checkc7b = (rule, value, callback) => {
          if (nxdjst != nxdj) {
            callback('所选能效等级与计算结果不符！')
          } else {
            callback()
          }
        }

        return {
          c2: [
            {
              trigger: 'change,blur',
              required: true,
              message: '请填写制造单位'
            }
          ],
          c3: [
            {
              trigger: 'change,blur',
              required: true,
              message: '请填写备案方'
            }
          ],
          c5: [
            {
              trigger: 'change,blur',
              required: true,
              message: '请填写商标'
            }
          ],
          c7: [
            {
              trigger: 'change,blur',
              required: true,
              message: '请选择能效等级'
            },
            {
              validator: checkc7a,
              trigger: 'blur'
            },
            {
              validator: checkc7b,
              trigger: 'blur'
            }
          ],
          c9: [
            {
              trigger: 'change,blur',
              required: true,
              message: '能源效率（cd/W）标注值不能为空',
            },
            {
              validator: significantDigits22,
              trigger: 'blur'
            },
            {
              validator: checkc9,
              trigger: 'blur'
            }
          ],
          c10: [
            {
              trigger: 'change,blur',
              required: true,
              message: '关闭状态功率(W)标注值不能为空',
            },
            {
              validator: twoDecimals,
              trigger: 'blur'
            },
            {
              validator: checkc10,
              trigger: 'blur'
            },
            {
              validator: checkc10a,
              trigger: 'blur'
            },
            {
              validator: checkc10b,
              trigger: 'blur'
            }
          ],
          c11: [
            {
              trigger: 'change,blur',
              required: true,
              message: '睡眠状态功率(W)标注值不能为空',
            },
            {
              validator: twoDecimals,
              trigger: 'blur'
            },
            {
              validator: checkc11a,
              trigger: 'blur'
            },
            {
              validator: checkc11b,
              trigger: 'blur'
            },
            {
              validator: checkc11,
              trigger: 'blur'
            }
          ],
          c12: [
            {
              trigger: 'change,blur',
              required: true,
              message: '能源效率（cd/W）实测值不能为空',
            },
            {
              validator: significantDigits33,
              trigger: 'blur'
            }
          ],
          c13: [
            {
              trigger: 'change,blur',
              required: true,
              message: '关闭状态功率(W)实测值不能为空',
            },
            {
              validator: threeDecimals,
              trigger: 'blur'
            }
          ],
          c14: [
            {
              trigger: 'change,blur',
              required: true,
              message: '睡眠状态功率(W)实测值不能为空',
            },
            {
              validator: threeDecimals,
              trigger: 'blur'
            }
          ],
          c19: [
            {
              trigger: 'change,blur',
              required: true,
              message: '屏幕尺寸长（mm）不能为空'
            }
          ],
          c20: [
            {
              trigger: 'change,blur',
              required: true,
              message: '屏幕尺寸宽（mm）不能为空'
            }
          ],
          c21: [
            {
              trigger: 'change,blur',
              required: true,
              message: '固有分辨力（像素数）值1不能为空'
            }
          ],
          c22: [
            {
              trigger: 'change,blur',
              required: true,
              message: '固有分辨力（像素数）值2不能为空'
            }
          ],
          c23: [
            {
              required: true,
              message: '附加功能不能为空'
            }
          ],
          c24: [
            {
              trigger: 'change,blur',
              required: this.formRecord.c23.join('').indexOf('其他') > -1,
              message: '附加功能其他不能为空'
            }
          ],
          c25: [
            {
              trigger: 'change,blur',
              required: true,
              message: '供电方式不能为空'
            }
          ],
          c26: [
            {
              trigger: 'change,blur',
              required: this.formRecord.c25 === '外部电源，输出功率（W）',
              message: '外部电源,输出功率(W)的值不能为空'
            }
          ],
          c27: [
            {
              trigger: 'change,blur',
              required: true,
              message: '额定功率（W）不能为空'
            }
          ],
          c28: [
            {
              trigger: 'change,blur',
              required: true,
              message: '额定电压（V）不能为空'
            }
          ],
          c29: [
            {
              trigger: 'change,blur',
              required: true,
              message: '额定电流（A）不能为空'
            }
          ],
          c30: [
            {
              trigger: 'change,blur',
              required: true,
              message: '额定频率（Hz）不能为空'
            }
          ],
          c31: [
            {
              trigger: 'change,blur',
              required: true,
              message: '显示屏型号规格不能为空'
            }
          ],
          c32: [
            {
              trigger: 'change,blur',
              required: true,
              message: '显示屏固有分辨力不能为空'
            }
          ],
          c33: [
            {
              trigger: 'change,blur',
              required: true,
              message: '显示屏屏幕尺寸不能为空'
            }
          ],
          c34: [
            {
              trigger: 'change,blur',
              required: true,
              message: '显示屏亮度不能为空'
            }
          ],
          c35: [
            {
              trigger: 'change,blur',
              required: true,
              message: '显示屏型号规格生产者（全称）不能为空'
            }
          ],
          c36: [
            {
              trigger: 'change,blur',
              required: true,
              message: '变压器型号规格不能为空'
            }
          ],
          c37: [
            {
              trigger: 'change,blur',
              required: true,
              message: '变压器技术参数不能为空'
            }
          ],
          c38: [
            {
              trigger: 'change,blur',
              required: true,
              message: '变压器生产者（全称）不能为空'
            }
          ],
          c39: [
            {
              trigger: 'change,blur',
              required: true,
              message: '主控IC型号规格不能为空'
            }
          ],
          c40: [
            {
              trigger: 'change,blur',
              required: true,
              message: '主控IC技术参数不能为空'
            }
          ],
          c41: [
            {
              trigger: 'change,blur',
              required: true,
              message: '主控IC生产者（全称）不能为空'
            }
          ],
          c42: [
            {
              trigger: 'change,blur',
              required: true,
              message: '开关管型号规格不能为空'
            }
          ],
          c43: [
            {
              trigger: 'change,blur',
              required: true,
              message: '开关管技术参数不能为空'
            }
          ],
          c44: [
            {
              trigger: 'change,blur',
              required: true,
              message: '开关管生产者（全称）不能为空'
            }
          ],
          c18: [
            {
              required: true,
              message: '不能为空'
            }
          ],
          c45: [
            {
              trigger: 'change,blur',
              required: true,
              message: '外部电源型号规格不能为空'
            }
          ],
          c46: [
            {
              trigger: 'change,blur',
              required: true,
              message: '外部电源技术参数不能为空'
            }
          ],
          c47: [
            {
              trigger: 'change,blur',
              required: true,
              message: '外部电源生产者（全称）不能为空'
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
