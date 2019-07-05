<!--家用燃气灶具-2014版-->
<!--创建日期:2019年6月10日-->
<!--创建人:YPH-->
<template>
  <div class="wrapper">
    <Form ref="formRecord" :model="formRecord" label-position="right" :rules="ruleRecord">
      <h1>家用燃气灶具能源效率标识备案表</h1>
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
            <Input type="text" v-model="formRecord.c3" :disabled='disabledoff' placeholder="制造单位"/>
          </FormItem>
          <FormItem prop="c5" label="备案方" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c5" :disabled='disabledoff' placeholder="备案方"/>
          </FormItem>
          <FormItem prop="c4" label="规格型号" style="width:100%;" :label-width="180">
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
          <FormItem prop="c18" label="灶具类型" :label-width="180">
            <RadioGroup v-model="formRecord.c18">
              <Radio :disabled='disabledoff' label="大气式灶">大气式灶</Radio>
              <Radio :disabled='disabledoff' label="红外线灶">红外线灶</Radio>
            </RadioGroup>
          </FormItem>
          <FormItem prop="c19" label="结构形式" :label-width="180">
            <RadioGroup v-model="formRecord.c19">
              <Radio :disabled='disabledoff' label="台式">台式</Radio>
              <Radio :disabled='disabledoff' label="嵌入式">嵌入式</Radio>
              <Radio :disabled='disabledoff' label="集成灶">集成灶</Radio>
              <Radio :disabled='disabledoff' label="其他">其他</Radio>
            </RadioGroup>
          </FormItem>
          <FormItem prop="c20" style="margin-top:-55.8px" :label-width="440">
            <Input type="text" style="width:150px" v-model="formRecord.c20" :disabled='disabledoff || forbidden.c20'/>
          </FormItem>
          <table>
            <tbody>
            <tr>
              <td rowspan="2">序号</td>
              <td rowspan="2">灶眼名称</td>
              <td colspan="2">热负荷(KW)</td>
              <td colspan="2">热效率(%)</td>
            </tr>
            <tr>
              <td>额定值(保留一位小数)</td>
              <td>实测值(至少保留两位小数)</td>
              <td>额定值(整数)</td>
              <td>实测值(保留一位小数)</td>
            </tr>
            <tr>
              <td>1</td>
              <td>
                <FormItem prop="c38">
                  <Input type="text" v-model="formRecord.c38" :disabled='disabledoff'/>
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
              <td>
                <FormItem prop="c54">
                  <Input type="text" v-model="formRecord.c54" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c60">
                  <Input type="text" v-model="formRecord.c60" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td width="">2</td>
              <td width="">
                <FormItem prop="c39">
                  <Input type="text" v-model="formRecord.c39" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td width="">
                <FormItem prop="c44">
                  <Input type="text" v-model="formRecord.c44" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td width="">
                <FormItem prop="c49">
                  <Input type="text" v-model="formRecord.c49" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td width="">
                <FormItem prop="c55">
                  <Input type="text" v-model="formRecord.c55" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td width="">
                <FormItem prop="c61">
                  <Input type="text" v-model="formRecord.c61" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td width="">3</td>
              <td width="">
                <FormItem prop="c40">
                  <Input type="text" v-model="formRecord.c40" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td width="">
                <FormItem prop="c45">
                  <Input type="text" v-model="formRecord.c45" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td width="">
                <FormItem prop="c50">
                  <Input type="text" v-model="formRecord.c50" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td width="">
                <FormItem prop="c56">
                  <Input type="text" v-model="formRecord.c56" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td width="">
                <FormItem prop="c62">
                  <Input type="text" v-model="formRecord.c62" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td width="">4</td>
              <td width="">
                <FormItem prop="c41">
                  <Input type="text" v-model="formRecord.c41" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td width="">
                <FormItem prop="c46">
                  <Input type="text" v-model="formRecord.c46" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td width="">
                <FormItem prop="c51">
                  <Input type="text" v-model="formRecord.c51" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td width="">
                <FormItem prop="c57">
                  <Input type="text" v-model="formRecord.c57" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td width="">
                <FormItem prop="c63">
                  <Input type="text" v-model="formRecord.c63" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td width="">5</td>
              <td width="">
                <FormItem prop="c42">
                  <Input type="text" v-model="formRecord.c42" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td width="">
                <FormItem prop="c47">
                  <Input type="text" v-model="formRecord.c47" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td width="">
                <FormItem prop="c52">
                  <Input type="text" v-model="formRecord.c52" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td width="">
                <FormItem prop="c58">
                  <Input type="text" v-model="formRecord.c58" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td width="">
                <FormItem prop="c64">
                  <Input type="text" v-model="formRecord.c64" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td width="">6</td>
              <td width="">
                <FormItem prop="c43">
                  <Input type="text" v-model="formRecord.c43" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td width="">
                <FormItem prop="c48">
                  <Input type="text" v-model="formRecord.c48" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td width="">
                <FormItem prop="c53">
                  <Input type="text" v-model="formRecord.c53" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td width="">
                <FormItem prop="c59">
                  <Input type="text" v-model="formRecord.c59" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td width="">
                <FormItem prop="c65">
                  <Input type="text" v-model="formRecord.c65" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td colspan="4">/</td>
              <td width="">
                <FormItem prop="c8">
                  <Input type="text" v-model="formRecord.c8" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td width="">
                <FormItem prop="c9">
                  <Input type="text" v-model="formRecord.c9" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td width="" colspan="2">灶具类型<br>(如：台式大气式灶)</td>
              <td width="" colspan="3">
                <FormItem prop="c14">
                  <Input type="text" v-model="formRecord.c14" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td width="">备注:
                <FormItem prop="c16">
                  <Input type="text" v-model="formRecord.c16" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            </tbody>
          </table>
        </Card>
      </div>
      <div class="part part4">
        <Card :bordered="false">
          <h2>四、初始使用日期</h2>
          <!-- <Form ref="formRecord" :model="formRecord" label-position="left" :label-width="180" :rules="ruleRecord"> -->
          <FormItem prop="c17" label="备案标识开始使用日期" style="width:100%;">
            <DatePicker type="date" :options="dataInit" style="width: 200px" v-model="formRecord.c17"></DatePicker>
          </FormItem>
        </Card>
      </div>
      <div class="part part5">
        <Card :bordered="false">
          <h2>五、样品描述</h2>
          <table id="table3">
            <tbody>
            <tr>
              <td>灶眼数量</td>
              <td colspan="3">
                <FormItem prop="c6">
                  <RadioGroup v-model="formRecord.c6">
                    <Radio label="单眼灶" :disabled='disabledoff'>单眼灶</Radio>
                    <Radio label="双眼灶" :disabled='disabledoff'>双眼灶</Radio>
                    <Radio label="多眼灶" :disabled='disabledoff'>
                      <FormItem prop="c15">
                        <Input type="text" v-model="formRecord.c15" :disabled='disabledoff || forbidden.c15'/> 眼灶
                      </FormItem>
                    </Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>燃气类别</td>
              <td>
                <FormItem prop="c21">
                  <RadioGroup v-model="formRecord.c21">
                    <FormItem prop="c22">
                      <Radio label="人工煤气灶具" :disabled='disabledoff'>人工煤气</Radio>
                      <RadioGroup v-model="formRecord.c22">
                        <Radio label="5R" :disabled='disabledoff || forbidden.c22_a'>5R</Radio>
                        <Radio label="6R" :disabled='disabledoff || forbidden.c22_a'>6R</Radio>
                        <Radio label="7R" :disabled='disabledoff || forbidden.c22_a'>7R</Radio>
                      </RadioGroup>
                      <br>
                      <Radio label="天然气灶具" :disabled='disabledoff'>天然气</Radio>
                      <RadioGroup v-model="formRecord.c22">
                        <Radio label="4T" :disabled='disabledoff || forbidden.c22_b'>4T</Radio>
                        <Radio label="6T" :disabled='disabledoff || forbidden.c22_b'>6T</Radio>
                        <Radio label="10T" :disabled='disabledoff || forbidden.c22_b'>10T</Radio>
                        <Radio label="12T" :disabled='disabledoff || forbidden.c22_b'>12T</Radio>
                      </RadioGroup>
                      <br>
                      <Radio label="液化石油气灶具" :disabled='disabledoff'>液化石油气</Radio>
                      <RadioGroup v-model="formRecord.c22">
                        <Radio label="19Y" :disabled='disabledoff || forbidden.c22_c'>19Y</Radio>
                        <Radio label="20Y" :disabled='disabledoff || forbidden.c22_c'>20Y</Radio>
                        <Radio label="22Y" :disabled='disabledoff || forbidden.c22_c'>22Y</Radio>
                      </RadioGroup>
                    </FormItem>
                  </RadioGroup>
                  <br/><br>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td><span class="color-red">*</span>点火方式</td>
              <td colspan="3">
                <FormItem prop="c23">
                  <RadioGroup v-model="formRecord.c23">
                    <Radio label="人工点火" :disabled='disabledoff'>人工点火</Radio>
                    <Radio label="脉冲点火" :disabled='disabledoff'>脉冲点火</Radio>
                    <Radio label="压电点火" :disabled='disabledoff'>压电点火</Radio>
                    <Radio label="其他" :disabled='disabledoff'>其他</Radio>
                    <FormItem prop="c24">
                      <Input type="text" v-model="formRecord.c24" :disabled='disabledoff || forbidden.c24'/>
                    </FormItem>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td><span class="color-red">*</span>熄火保护装置</td>
              <td>
                <FormItem prop="c25">
                  <RadioGroup v-model="formRecord.c25">
                    <Radio label="离子式" :disabled='disabledoff'>离子式</Radio>
                    <Radio label="热电式" :disabled='disabledoff'>热电式</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td><span class="color-red">*</span>调风装置</td>
              <td>
                <FormItem prop="c26">
                  <RadioGroup v-model="formRecord.c26">
                    <Radio label="可调" :disabled='disabledoff'>可调</Radio>
                    <Radio label="不可调" :disabled='disabledoff'>不可调</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="right-align"><span class="color-red">*</span>额定电压(V)</td>
              <td>
                <FormItem prop="c27">
                  <Input type="text" v-model="formRecord.c27" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td class="right-align"><span class="color-red">*</span>额定频率(Hz)</td>
              <td>
                <FormItem prop="c28">
                  <Input type="text" v-model="formRecord.checkmark28" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="right-align"><span class="color-red">*</span>额定燃气供气压力(Pa)
              </td>
              <td colspan="3">
                <FormItem prop="c29">
                  <RadioGroup v-model="formRecord.c29">
                    <Radio label="2000" :disabled='disabledoff'>2000</Radio>
                    <Radio label="2800" :disabled='disabledoff'>2800</Radio>
                    <Radio label="1000" :disabled='disabledoff'>1000</Radio>
                    <Radio label="其他" :disabled='disabledoff'>其他</Radio>
                    <FormItem prop="c30">
                      <Input type="text" v-model="formRecord.c30" :disabled='disabledoff || forbidden.c30'/>
                    </FormItem>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td><span class="color-red">*</span>挖孔尺寸(长×宽)(mm×mm)
              </td>
              <td colspan="3">
                <FormItem prop="c32">
                  <Input type="text" v-model="formRecord.c32" :disabled='disabledoff' style="width:80px;"/>
                </FormItem>
                x
                <FormItem prop="c33">
                  <Input type="text" v-model="formRecord.c33" :disabled='disabledoff' style="width:80px;"/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="right-align"><span class="color-red">*</span>外形尺寸(长×宽×高)(mm×mm×mm)</td>
              <td colspan="3" class="w19">
                <FormItem prop="c35">
                  <Input type="text" v-model="formRecord.c35" :disabled='disabledoff' style="width:80px;"/>
                </FormItem>
                x
                <FormItem prop="c36">
                  <Input type="text" v-model="formRecord.c36" :disabled='disabledoff' style="width:80px;"/>
                </FormItem>
                x
                <FormItem prop="c37">
                  <Input type="text" v-model="formRecord.c37" :disabled='disabledoff' style="width:80px;"/>
                </FormItem>
              </td>
            </tr>
            </tbody>
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
              <td rowspan="3" width="80">1</td>
              <td rowspan="3">燃烧器</td>
            </tr>
            <tr>
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
            </tr>
            <tr>
              <td>
                <FormItem prop="c69">
                  <Input type="text" v-model="formRecord.c69" :disabled='disabledoff'/>
                </FormItem>
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
            </tr>
            <tr>
              <td rowspan="3" width="80">2</td>
              <td rowspan="3">燃烧器</td>
            </tr>
            <tr>
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
              <td>
                <FormItem prop="c75">
                  <Input type="text" v-model="formRecord.c75" :disabled='disabledoff'/>
                </FormItem>
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
            </tr>
            <tr>
              <td rowspan="3" width="80">3</td>
              <td rowspan="3">燃烧器</td>
            </tr>
            <tr>
              <td>
                <FormItem prop="c78">
                  <Input type="text" v-model="formRecord.c78" :disabled='disabledoff'/>
                </FormItem>
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
            </tr>
            <tr>
              <td>
                <FormItem prop="c81">
                  <Input type="text" v-model="formRecord.c81" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c82">
                  <Input type="text" v-model="formRecord.c82" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c83">
                  <Input type="text" v-model="formRecord.c83" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td width="80">4</td>
              <td>阀门总成</td>
              <td>
                <FormItem prop="c84">
                  <Input type="text" v-model="formRecord.c84" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c85">
                  <Input type="text" v-model="formRecord.c85" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c86">
                  <Input type="text" v-model="formRecord.c86" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td width="80">5</td>
              <td>阀门总成</td>
              <td>
                <FormItem prop="c87">
                  <Input type="text" v-model="formRecord.c87" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c88">
                  <Input type="text" v-model="formRecord.c88" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c89">
                  <Input type="text" v-model="formRecord.c89" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td width="80">6</td>
              <td>阀门总成</td>
              <td>
                <FormItem prop="c90">
                  <Input type="text" v-model="formRecord.c90" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c91">
                  <Input type="text" v-model="formRecord.c91" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c92">
                  <Input type="text" v-model="formRecord.c92" :disabled='disabledoff'/>
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
                根据企业提交的相关信息，系统直接生成能效标识样本，请提交备案后在"备案查询"功能中下载
                <!-- <Button type="primary" @click="showTemplate">查看</Button> -->
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
      <img class="lookPdf" v-if="!uploadPic.includes('.pdf')" :src="uploadPic" />
      <embed class="lookPdf" v-else :src="uploadPic" width="600" height="400" type="application/pdf"  internalinstanceid="81" />
    </Modal>
    <Modal v-model="modal5" class="basic-info"  :width=650 ok-text="保存"  @on-ok="submitBasic" cancel-text="关闭">
      <h2>标识型号{{pageType==="extend"?'扩展':'变更'}}备案申请书</h2>
      <p class="org">中国标准化研究院能效标识管理中心：</p>
      <div class="pro-info">
        我 <span  class="f-company">{{formRecord.c1}}</span>
        公司生产的 <span class="f-brand">{{formRecord.c2}}</span>
        品牌的 <span  class="f-model">{{formRecord.c4}}</span>
        型号的 <span  class="f-product">家用燃气灶具 2014版</span>产品。
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
    data() {
      const timeDate = this.$store.state.app.dateinit;
      return {
        // 当前初始使用日期 对应的C值
        thisDateCV: "c17",
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
          c16: '',
          c17: new Date(),
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
          c202: '',
          ec_model_no: 42,
          attach_list: ''
        },
        forbidden: {
          c24: true,
          c26: true,
          c22_a: true,
          c22_b: true,
          c22_c: true
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

        if (this.formRecord.c19 === '其他') {
          this.forbidden.c20 = false
        } else {
          this.formRecord.c20 = ''
          this.forbidden.c20 = true
        }

        if (this.formRecord.c29 === '其他') {
          this.forbidden.c30 = false
        } else {
          this.formRecord.c30 = ''
          this.forbidden.c30 = true
        }

        if (this.formRecord.c23 === '其他') {
          this.forbidden.c24 = false
        } else {
          this.formRecord.c24 = ''
          this.forbidden.c24 = true
        }

        if (this.formRecord.c6 === '多眼灶') {
          this.forbidden.c15 = false
        } else {
          this.formRecord.c15 = ''
          this.forbidden.c15 = true
        }

        if (this.formRecord.c21 === '人工煤气灶具') {
          this.forbidden.c22_a = false
          this.forbidden.c22_b = true
          this.forbidden.c22_c = true
        } else if (this.formRecord.c21 === '天然气灶具') {
          this.forbidden.c22_a = true
          this.forbidden.c22_b = false
          this.forbidden.c22_c = true
        } else if (this.formRecord.c21 === '液化石油气灶具') {
          this.forbidden.c22_a = true
          this.forbidden.c22_b = true
          this.forbidden.c22_c = false
        }


        //0803
        var biaozhu = this.formRecord.c8
        var shice = this.formRecord.c9
        const checkc9 = (rule, value, callback) => {
          if (biaozhu >= shice) {
            callback("热效率实测值应大于标注值")
          } else {
            callback()
          }
        }
        //0803
        var nxdjch = this.formRecord.c7
        var zjlx = this.formRecord.c18
        var jgxs = this.formRecord.c19
        var rxlz = this.formRecord.c8
        var nxdj = "";
        if (zjlx == "大气式灶") {
          if (jgxs == "台式") {
            if (rxlz >= 66) {
              nxdj = "1";
            } else if (rxlz >= 62) {
              nxdj = "2";
            } else if (rxlz >= 58) {
              nxdj = "3";
            }
          } else if (jgxs == "嵌入式") {
            if (rxlz >= 63) {
              nxdj = "1";
            } else if (rxlz >= 59) {
              nxdj = "2";
            } else if (rxlz >= 55) {
              nxdj = "3";
            }
          } else if (jgxs == "集成灶") {
            if (rxlz >= 59) {
              nxdj = "1";
            } else if (rxlz >= 56) {
              nxdj = "2";
            } else if (rxlz >= 53) {
              nxdj = "3";
            }
          }
        } else if (zjlx == "红外线灶") {
          if (jgxs == "台式") {
            if (rxlz >= 68) {
              nxdj = "1";
            } else if (rxlz >= 64) {
              nxdj = "2";
            } else if (rxlz >= 60) {
              nxdj = "3";
            }
          } else if (jgxs == "嵌入式") {
            if (rxlz >= 65) {
              nxdj = "1";
            } else if (rxlz >= 61) {
              nxdj = "2";
            } else if (rxlz >= 57) {
              nxdj = "3";
            }
          } else if (jgxs == "集成灶") {
            if (rxlz >= 61) {
              nxdj = "1";
            } else if (rxlz >= 58) {
              nxdj = "2";
            } else if (rxlz >= 55) {
              nxdj = "3";
            }
          }
        }
        const checkc7a = (rule, value, callback) => {
          if (rxlz > 100 || nxdj == "") {
            callback('能效数据不在备案范围')
          } else {
            callback()
          }
        }
        const checkc7b = (rule, value, callback) => {
          if (nxdjch != nxdj) {
            callback('所选能效等级与计算结果不符！')
          } else {
            callback()
          }
        }
        return {
          c3: [
            {
              trigger: 'change,blur', required: true,
              message: '请输入制造单位'
            }
          ],
          c5: [
            {
              trigger: 'change,blur', required: true,
              message: '请输入备案方'
            }
          ],
          c2: [
            {
              trigger: 'change,blur', required: true,
              message: '请填写商标'
            }
          ],
          c7: [
            {
              trigger: 'change,blur', required: true,
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
          c4: [
            {
              trigger: 'change,blur', required: true,
              message: '请输入规格型号'
            }
          ],
          c18: [
            {
              trigger: 'change,blur', required: true,
              message: '请选择灶具类型'
            }
          ],
          c19: [
            {
              trigger: 'change,blur', required: true,
              message: '请选择结构形式'
            }
          ],
          c20: [
            {
              trigger: 'change,blur', required: this.formRecord.c19 === '其他',
              message: '请输入其它结构形式'
            }
          ],
          c8: [
            {
              trigger: 'change,blur', required: true,
              message: '请输入热效率标注值'
            },
            {
              validator: numberCheck,
              trigger: 'blur'
            }
          ],
          c9: [
            {
              trigger: 'change,blur', required: true,
              message: '睡眠状态功率(W)实测值不能为空'
            },
            {
              validator: oneDecimals,
              trigger: 'blur'
            },
            {
              validator: checkc9,
              trigger: 'blur'
            }

          ],
          c11: [
            {
              trigger: 'change,blur', required: true,
              message: '请输入热负荷标注值'
            },
            {
              validator: oneDecimals,
              trigger: 'blur'
            }
          ],
          c12: [
            {
              trigger: 'change,blur', required: true,
              message: '请输入热负荷实测值'
            }
          ],
          c6: [
            {
              trigger: 'change,blur', required: true,
              message: '请选择灶眼数量'
            }
          ],
          c15: [
            {
              trigger: 'change,blur', required: this.formRecord.c6 === '多眼灶',
              message: '请输入多眼灶灶眼数量'
            }
          ],
          c21: [
            {
              trigger: 'change,blur', required: true,
              message: '请选择燃气类别'
            }
          ],
          c22: [
            {
              required: true,
              message: '请选择燃气类别值'
            }
          ],
          c23: [
            {
              trigger: 'change,blur', required: true,
              message: '请选择点火方式'
            }
          ],
          c24: [
            {
              trigger: 'change,blur', required: this.formRecord.c23 === '其他',
              message: '请输入其他点火方式'
            }
          ],
          c25: [
            {
              trigger: 'change,blur', required: true,
              message: '请选择熄火保护装置'
            }
          ],
          c26: [
            {
              trigger: 'change,blur', required: true,
              message: '请选择调风装置'
            }
          ],
          c28: [
            {
              trigger: 'change,blur', required: true,
              message: '请输入额定频率'
            }
          ],
          c27: [
            {
              trigger: 'change,blur', required: true,
              message: '请输入额定电压'
            }
          ],
          c29: [
            {
              trigger: 'change,blur', required: true,
              message: '请选择额定燃气供气压力'
            }
          ],
          c30: [
            {
              trigger: 'change,blur', required: this.formRecord.c29 === '其他',
              message: '请输入额定燃气供气压力其他值'
            }
          ],
          c31: [
            {
              trigger: 'change,blur', required: true,
              message: '请输入额定热负荷'
            }
          ],
          c32: [
            {
              trigger: 'change,blur', required: true,
              message: '请输入挖孔尺寸（长）'
            }
          ],
          c33: [
            {
              trigger: 'change,blur', required: true,
              message: '请输入挖孔尺寸（宽）'
            }
          ],
          c35: [
            {
              trigger: 'change,blur', required: true,
              message: '请输入外形尺寸（长）'
            }
          ],
          c36: [
            {
              trigger: 'change,blur', required: true,
              message: '请输入外形尺寸（宽）'
            }
          ],
          c37: [
            {
              trigger: 'change,blur', required: true,
              message: '请输入外形尺寸（高）'
            }
          ],
          c66: [
            {
              trigger: 'change,blur', required: true,
              message: '不能为空'
            }
          ],
          c67: [
            {
              trigger: 'change,blur', required: true,
              message: '不能为空'
            }
          ],
          c68: [
            {
              trigger: 'change,blur', required: true,
              message: '不能为空'
            }
          ],
          c69: [
            {
              trigger: 'change,blur', required: true,
              message: '不能为空'
            }
          ],
          c70: [
            {
              trigger: 'change,blur', required: true,
              message: '不能为空'
            }
          ],
          c71: [
            {
              trigger: 'change,blur', required: true,
              message: '不能为空'
            }
          ],
          c84: [
            {
              trigger: 'change,blur', required: true,
              message: '不能为空'
            }
          ],
          c85: [
            {
              trigger: 'change,blur', required: true,
              message: '不能为空'
            }
          ],
          c86: [
            {
              trigger: 'change,blur', required: true,
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
