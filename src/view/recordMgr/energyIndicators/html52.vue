/*
* 家用和类似用途微波炉 2017版
* 创建日期：2019年6月14号
* 创建人：wlq
* 1556854411400282556
*/
<template>
  <div class="wrapper">
    <Form ref="formRecord" :model="formRecord" label-position="right" :rules="pageType!='extend'?ruleRecord:{}">
      <h1>家用和类似用途微波炉-能源效率标识备案表</h1>
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
                <Input type="text" :value="$store.state.app.labName"/>
              </td>
              <td>
                <Input type="text" :value="$store.state.app.barcode"/>
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
          <FormItem prop="c32" label="备案方" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c32" :disabled='disabledoff' placeholder="备案方"/>
          </FormItem>
          <FormItem prop="c3" label="产品规格型号" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c3" :disabled='!disabledoff' placeholder="产品规格型号"/>
          </FormItem>
          <FormItem prop="c4" label="商标" style="width:100%" :label-width="180">
            <Input type="text" v-model="formRecord.c4" :disabled='pageType=="view"' placeholder="商标"/>
          </FormItem>
          <FormItem prop="c200" label="依据国家标准" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c200" placeholder="依据国家标准" disabled/>
          </FormItem>
          <FormItem prop="c33" label="能效等级" style="width:100%;" :label-width="180">
            <RadioGroup v-model="formRecord.c33">
              <Radio label="1" :disabled='disabledoff'>1级</Radio>
              <Radio label="2" :disabled='disabledoff'>2级</Radio>
              <Radio label="3" :disabled='disabledoff'>3级</Radio>
            </RadioGroup>
          </FormItem>
          <table id="table1">
            <tr>
              <td align="center"><span class="red">*</span>待机功能</td>
              <td>
                <FormItem prop="c35">
                  <RadioGroup v-model="formRecord.c35">
                    <Radio :disabled='disabledoff' label="有">有</Radio>
                    <Radio :disabled='disabledoff' label="无">无</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td align="center"><span class="red">*</span> 关机功能</td>
              <td>
                <FormItem prop="c37">
                  <RadioGroup v-model="formRecord.c37">
                    <Radio :disabled='disabledoff' label="有">有</Radio>
                    <Radio :disabled='disabledoff' label="无">无</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center"><span class="red">*</span> 待机模式（信息或状态显示）</td>
              <td colspan="3">
                <FormItem prop="c18">
                  <RadioGroup v-model="formRecord.c18">
                    <Radio :disabled='disabledoff || forbidden.c18' label="待机模式时具有信息或状态显示（包括时钟）功能">
                      待机模式时具有信息或状态显示（包括时钟）功能
                    </Radio>
                    <br/>
                    <Radio :disabled='disabledoff || forbidden.c18' label="待机模式时没有信息或状态显示（包括时钟）功能">
                      待机模式时没有信息或状态显示（包括时钟）功能
                    </Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center"><span class="red">*</span> 烧烤功能</td>
              <td colspan="3">
                <FormItem prop="c39">
                  <RadioGroup v-model="formRecord.c39">
                    <Radio :disabled='disabledoff' label="有">有</Radio>
                    <Radio :disabled='disabledoff' label="无">无</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center">通讯协议功能</td>
              <td colspan="3">
                <FormItem prop="c100">
                  <CheckboxGroup v-model="formRecord.c100">
                    <Checkbox :disabled='disabledoff || forbidden.c100' label="WIFI">WIFI</Checkbox>
                    <Checkbox :disabled='disabledoff || forbidden.c100' label="蓝牙">蓝牙</Checkbox>
                    <Checkbox :disabled='disabledoff || forbidden.c100' label="其它">其它</Checkbox>
                    <FormItem prop="c101" style="margin-top: -33px;margin-left: 175px;width: 150px">
                      <Input type="text" v-model="formRecord.c101"
                             :disabled='disabledoff || forbidden.c101 || forbidden.c100'/>
                    </FormItem>
                    <Checkbox :disabled='disabledoff' style="margin-left: 345px;position: relative;top: -33px;" label="无">无</Checkbox>
                  </CheckboxGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center">效率值（%）</td>
              <td>
                <FormItem prop="c5" label="标注值：" style="width:100%;" :label-width="80">
                  <Input type="text" v-model="formRecord.c5" :disabled='disabledoff || forbidden.c5'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c34" label="实测值：" style="width:100%;" :label-width="80">
                  <Input type="text" v-model="formRecord.c34" :disabled='disabledoff || forbidden.c34'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c6" label="备注：" style="width:100%;" :label-width="80">
                  <Input type="text" v-model="formRecord.c6" :disabled='disabledoff || forbidden.c6'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center">待机功率（W）</td>
              <td>
                <FormItem prop="c7" label="标注值：" style="width:100%;" :label-width="80">
                  <Input type="text" v-model="formRecord.c7" :disabled='disabledoff || forbidden.c7'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c36" label="实测值：" style="width:100%;" :label-width="80">
                  <Input type="text" v-model="formRecord.c36" :disabled='disabledoff || forbidden.c36'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c8" label="备注：" style="width:100%;" :label-width="80">
                  <Input type="text" v-model="formRecord.c8" :disabled='disabledoff || forbidden.c8'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center">关机功率（W）</td>
              <td>
                <FormItem prop="c9" label="标注值：" style="width:100%;" :label-width="80">
                  <Input type="text" v-model="formRecord.c9" :disabled='disabledoff || forbidden.c9'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c38" label="实测值：" style="width:100%;" :label-width="80">
                  <Input type="text" v-model="formRecord.c38" :disabled='disabledoff || forbidden.c38'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c10" label="备注：" style="width:100%;" :label-width="80">
                  <Input type="text" v-model="formRecord.c10" :disabled='disabledoff || forbidden.c10'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center">烧烤能耗（W·h）</td>
              <td>
                <FormItem prop="c11" label="标注值：" style="width:100%;" :label-width="80">
                  <Input type="text" v-model="formRecord.c11" :disabled='disabledoff || forbidden.c11'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c40" label="实测值：" style="width:100%;" :label-width="80">
                  <Input type="text" v-model="formRecord.c40" :disabled='disabledoff || forbidden.c40'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c12" label="备注：" style="width:100%;" :label-width="80">
                  <Input type="text" v-model="formRecord.c12" :disabled='disabledoff || forbidden.c12'/>
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
          <FormItem prop="c13" label="备案标识开始使用日期" style="width:100%;">
            <DatePicker type="date" :options="dataInit" style="width: 200px" v-model="formRecord.c13"></DatePicker>
          </FormItem>
        </Card>
      </div>
      <div class="part part5">
        <Card :bordered="false">
          <h2>五、其它信息</h2>
          <br/>
          <h3>样品描述</h3>
          <br/>
          <table id="table3">
            <tr>
              <td align="right"><span class="red">*</span>电源类型</td>
              <td>
                <FormItem prop="c14">
                  <RadioGroup v-model="formRecord.c14">
                    <Radio :disabled='disabledoff' label="交流">交流</Radio>
                    <Radio :disabled='disabledoff' label="直流">直流</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td align="right"><span class="red">*</span>转盘方式</td>
              <td>
                <FormItem prop="c17">
                  <RadioGroup v-model="formRecord.c17">
                    <Radio :disabled='disabledoff' label="有">有</Radio>
                    <Radio :disabled='disabledoff' label="无">无</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span class="red">*</span>类型</td>
              <td colspan="3">
                <FormItem prop="c15">
                  <RadioGroup v-model="formRecord.c15">
                    <Radio :disabled='disabledoff' label="嵌装式">嵌装式</Radio>
                    <Radio :disabled='disabledoff' label="便携式">便携式</Radio>
                    <Radio :disabled='disabledoff' label="驻立式">驻立式</Radio>
                    <Radio :disabled='disabledoff' label="固定式">固定式</Radio>
                    <Radio :disabled='disabledoff' label="其它">其它</Radio>
                  </RadioGroup>
                </FormItem>
                <FormItem prop="c16">
                  <Input type="text" v-model="formRecord.c16" :disabled='disabledoff || forbidden.c16'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span class="red">*</span>控制方式</td>
              <td>
                <FormItem prop="c19" style="width:100%">
                  <RadioGroup v-model="formRecord.c19">
                    <Radio :disabled='disabledoff' label="机械式">机械式</Radio>
                    <Radio :disabled='disabledoff' label="电子式">电子式</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td align="right"><span class="red">*</span>温控器</td>
              <td>
                <FormItem prop="c20" style="width:100%">
                  <RadioGroup v-model="formRecord.c20">
                    <Radio :disabled='disabledoff' label="有">有</Radio>
                    <Radio :disabled='disabledoff' label="无">无</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span class="red">*</span>热断路器</td>
              <td>
                <FormItem prop="c21" style="width:100%">
                  <RadioGroup v-model="formRecord.c21">
                    <Radio :disabled='disabledoff' label="有">有</Radio>
                    <Radio :disabled='disabledoff' label="无">无</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td align="right"><span class="red">*</span>电热元件</td>
              <td>
                <FormItem prop="c22" style="width:100%">
                  <RadioGroup v-model="formRecord.c22">
                    <Radio :disabled='disabledoff' label="有">有</Radio>
                    <Radio :disabled='disabledoff' label="无">无</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span class="red">*</span>定时器</td>
              <td>
                <FormItem prop="c23" style="width:100%">
                  <RadioGroup v-model="formRecord.c23">
                    <Radio :disabled='disabledoff' label="有">有</Radio>
                    <Radio :disabled='disabledoff' label="无">无</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td align="right"><span class="red">*</span>程序控制</td>
              <td>
                <FormItem prop="c24" style="width:100%">
                  <RadioGroup v-model="formRecord.c24">
                    <Radio :disabled='disabledoff' label="有">有</Radio>
                    <Radio :disabled='disabledoff' label="无">无</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span class="red">*</span>腔体材料</td>
              <td colspan="3">
                <FormItem prop="c25" style="width:100%">
                  <RadioGroup v-model="formRecord.c25">
                    <Radio :disabled='disabledoff' label="不锈钢">不锈钢</Radio>
                    <Radio :disabled='disabledoff' label="钢板喷涂">钢板喷涂</Radio>
                    <Radio :disabled='disabledoff' label="其它">其它</Radio>
                  </RadioGroup>
                </FormItem>
                <FormItem prop="c26" style="margin-top:-34px; margin-left:227px">
                  <Input type="text" v-model="formRecord.c26" :disabled='disabledoff || forbidden.c26'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span class="red">*</span>额定电压（V）</td>
              <td>
                <FormItem prop="c41" style="width: 100%">
                  <Input type="text" v-model="formRecord.c41" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td align="right"><span class="red">*</span>额定频率（Hz）</td>
              <td>
                <FormItem prop="c42" style="width: 100%">
                  <Input type="text" v-model="formRecord.c42" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span class="red">*</span>微波工作频率（MHz）</td>
              <td>
                <FormItem prop="c43" style="width: 100%">
                  <Input type="text" v-model="formRecord.c43" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td align="right"><span class="red">*</span>微波额定输入功率（W）</td>
              <td>
                <FormItem prop="c27" style="width: 100%">
                  <Input type="text" v-model="formRecord.c27" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span class="red">*</span>微波额定输出功率（W）</td>
              <td>
                <FormItem prop="c28" style="width: 100%">
                  <Input type="text" v-model="formRecord.c28" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td align="right"><span class="red">*</span>烧烤额定输入功率（W）</td>
              <td>
                <FormItem prop="c29" style="width: 100%">
                  <Input type="text" v-model="formRecord.c29" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span class="red">*</span>腔体容积（L）</td>
              <td>
                <FormItem prop="c30" style="width: 100%">
                  <Input type="text" v-model="formRecord.c30" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td align="right"><span class="red">*</span>外形尺寸（长×宽×高）（mm×mm×mm）</td>
              <td>
                <FormItem prop="c31" style="width:25%">
                  <Input type="text" style="width:40px" v-model="formRecord.c31" :disabled='disabledoff'/>
                </FormItem>
                ×&nbsp;&nbsp;&nbsp;&nbsp;
                <FormItem prop="c44" style="width:25%">
                  <Input type="text" style="width:40px" v-model="formRecord.c44" :disabled='disabledoff'/>
                </FormItem>
                ×&nbsp;&nbsp;&nbsp;&nbsp;
                <FormItem prop="c45" style="width:25%">
                  <Input type="text" style="width:40px" v-model="formRecord.c45" :disabled='disabledoff'/>
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
              <th>名称</th>
              <th>型号规格/类型</th>
              <th colspan="4">技术参数</th>
              <th>生产者（全称）</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td width="80">1</td>
              <td align="center">磁控管</td>
              <td>
                <FormItem prop="c46">
                  <Input type="text" v-model="formRecord.c46" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td align="center">灯丝电压（V）</td>
              <td>
                <FormItem prop="c47">
                  <Input type="text" v-model="formRecord.c47" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td align="center">输出频率（MHz）</td>
              <td>
                <FormItem prop="c48">
                  <Input type="text" v-model="formRecord.c48" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c49">
                  <Input type="text" v-model="formRecord.c49" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td width="80">2</td>
              <td align="center">磁控管</td>
              <td>
                <FormItem prop="c50">
                  <Input type="text" v-model="formRecord.c50" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td align="center">灯丝电压（V）</td>
              <td>
                <FormItem prop="c51">
                  <Input type="text" v-model="formRecord.c51" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td align="center">输出频率（MHz）</td>
              <td>
                <FormItem prop="c52">
                  <Input type="text" v-model="formRecord.c52" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c53">
                  <Input type="text" v-model="formRecord.c53" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td width="80">3</td>
              <td align="center">高压变压器或变频变压器</td>
              <td>
                <FormItem prop="c54">
                  <Input type="text" v-model="formRecord.c54" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td align="center">电压（V）</td>
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
              <td width="80">4</td>
              <td align="center">高压变压器或变频变压器</td>
              <td>
                <FormItem prop="c59">
                  <Input type="text" v-model="formRecord.c59" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td align="center">电压（V）</td>
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
            </tr>
            <tr>
              <td width="80">5</td>
              <td align="center">电源板低压变压器或开关型电源变压器</td>
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
              <td width="80">6</td>
              <td align="center">电源板低压变压器或开关型电源变压器</td>
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
              <td>
                <FormItem prop="c75">
                  <Input type="text" v-model="formRecord.c75" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td width="80">7</td>
              <td align="center">电机（含转盘电机或风扇电机等）</td>
              <td>
                <FormItem prop="c76">
                  <Input type="text" v-model="formRecord.c76" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td align="center">电压（V）</td>
              <td>
                <FormItem prop="c77">
                  <Input type="text" v-model="formRecord.c77" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td align="center">功率（W）</td>
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
            </tr>
            <tr>
              <td width="80">8</td>
              <td align="center">电机（含转盘电机或风扇电机等）</td>
              <td>
                <FormItem prop="c80">
                  <Input type="text" v-model="formRecord.c80" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td align="center">电压（V）</td>
              <td>
                <FormItem prop="c81">
                  <Input type="text" v-model="formRecord.c81" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td align="center">功率（W）</td>
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
              <td width="80">9</td>
              <td align="center">电热元件</td>
              <td>
                <FormItem prop="c84">
                  <Input type="text" v-model="formRecord.c84" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td align="center">电压（V）</td>
              <td>
                <FormItem prop="c85">
                  <Input type="text" v-model="formRecord.c85" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td align="center">功率（W）</td>
              <td>
                <FormItem prop="c86">
                  <Input type="text" v-model="formRecord.c86" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c87">
                  <Input type="text" v-model="formRecord.c87" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td width="80">10</td>
              <td align="center">电热元件</td>
              <td>
                <FormItem prop="c88">
                  <Input type="text" v-model="formRecord.c88" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td align="center">电压（V）</td>
              <td>
                <FormItem prop="c89">
                  <Input type="text" v-model="formRecord.c89" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td align="center">功率（W）</td>
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
            </tr>
            <tr>
              <td width="80">11</td>
              <td align="center">温控器</td>
              <td>
                <FormItem prop="c92">
                  <Input type="text" v-model="formRecord.c92" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td align="center">动作温度（℃）</td>
              <td>
                <FormItem prop="c93">
                  <Input type="text" v-model="formRecord.c93" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td align="center">复位温度（℃）</td>
              <td>
                <FormItem prop="c94">
                  <Input type="text" v-model="formRecord.c94" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c95">
                  <Input type="text" v-model="formRecord.c95" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td width="80">12</td>
              <td align="center">温控器</td>
              <td>
                <FormItem prop="c96">
                  <Input type="text" v-model="formRecord.c96" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td align="center">动作温度（℃）</td>
              <td>
                <FormItem prop="c97">
                  <Input type="text" v-model="formRecord.c97" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td align="center">复位温度（℃）</td>
              <td>
                <FormItem prop="c98">
                  <Input type="text" v-model="formRecord.c98" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c99">
                  <Input type="text" v-model="formRecord.c99" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            </tbody>
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
                <div class="lookOver" v-show="uploadParam.filePath24">
                  <Button @click="showImg(uploadParam.filePath24)" icon="ios-glasses-outline" type="primary">查看</Button>
                </div>
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
                    <Icon type="ios-checkmark" v-show="checkmark24"/>
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
                <div class="lookOver" v-show="uploadParam.filePath26">
                  <Button @click="showImg(uploadParam.filePath26)" icon="ios-glasses-outline" type="primary">查看</Button>
                </div>
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
                    <Icon type="ios-checkmark" v-show="checkmark26"/>
                  </Upload>
                </div>
              </td>
              <td>关系证明 <p class="red" v-if="pageType!='view'">境外生产者请上传该附件</p></td>
              <td>（PDF）</td>
              <td>
                <div class="lookOver" v-show="uploadParam.filePath27">
                  <Button @click="showImg(uploadParam.filePath27)" icon="ios-glasses-outline" type="primary">查看</Button>
                </div>
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
                    <Icon type="ios-checkmark" v-show="checkmark28"/>
                  </Upload>
                </div>
              </td>
              <td>委托代理文件</td>
              <td>（PDF）</td>
              <td>
                <div class="lookOver" v-show="uploadParam.filePath29">
                  <Button @click="showImg(uploadParam.filePath29)" icon="ios-glasses-outline" type="primary">查看</Button>
                </div>
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
                    <Icon type="ios-checkmark" v-show="checkmark29"/>
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
                <div class="lookOver" v-show="uploadParam.filePath30">
                  <Button @click="showImg(uploadParam.filePath30)" icon="ios-glasses-outline" type="primary">查看</Button>
                </div>
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
                    <Icon type="ios-checkmark" v-show="checkmark30"/>
                  </Upload>
                </div>
              </td>
              <td>生产者和进口商营业执照或登记注册证明复印件
                <p class="red" v-if="pageType!='view'">境外生产者请上传该附件</p>
              </td>
              <td>（PDF）</td>
              <td>
                <div class="lookOver" v-show="uploadParam.filePath31">
                  <Button @click="showImg(uploadParam.filePath31)" icon="ios-glasses-outline" type="primary">查看</Button>
                </div>
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
                    <Icon type="ios-checkmark" v-show="checkmark31"/>
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
                <div class="lookOver" v-show="uploadParam.filePath32">
                  <Button @click="showImg(uploadParam.filePath32)" icon="ios-glasses-outline" type="primary">查看</Button>
                </div>
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
                    <Icon type="ios-checkmark" v-show="checkmark32"/>
                  </Upload>
                </div>
              </td>
              <td><span class="red">*</span>铭牌照片</td>
              <td>（PDF/JPG/PNG）</td>
              <td>
                <div class="lookOver" v-show="uploadParam.filePath76">
                  <Button @click="showImg(uploadParam.filePath76)" icon="ios-glasses-outline" type="primary">查看</Button>
                </div>
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
                    <Icon type="ios-checkmark" v-show="checkmark76"/>
                  </Upload>
                </div>
              </td>
            </tr>
          </table>
          <p class="red" v-if="pageType!='view'">注：<br/>1、标“*”内容为必填项；<br/>2、所有附件上传文件大小需要控制在2M以内。</p>
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
    <Modal v-model="modal1" class="pageStyle" title="提交确认" width="960" ok-text="提交备案" cancel-text="再看看"
           @on-ok="submitRecord">
      <p v-if="boolFlag.length" style="font-size:16px;font-weight: bolder;text-align: center">
        以下是实验室报告带入项数值被修改的地方，请您再次确认！</p>
      <div v-if="boolFlag.length" class="diffList">
        <table>
          <thead>
          <tr>
            <th>名称</th>
            <th>实验室报告带入值</th>
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
      <p class="red submitTips" v-if="!boolFlag.length">请再次确认备案信息填写无误！</p>
      <p class="red submitTips">若确认，请点击“提交备案”按钮，系统将直接公告备案信息，请务必再次确认信息无误。</p>
    </Modal>
    <!--<Modal v-model="modal2" title="提交工单" @on-ok="submitWorkorder">
      <p style="font-size:18px;margin-bottom:10px;">实验室数值：{{currentValue}}</p>
      <Input type="textarea" :rows="3" placeholder="请描述问题" v-model="qus"></Input>
    </Modal>-->
    <Modal v-model="modal3" :width=820 :footer-hide=true>
      <img :src="templatePic"/>
    </Modal>
    <Modal v-model="modal4" :width=820 :footer-hide=true>
      <img class="lookPdf" v-if="!uploadPic.includes('.pdf')" :src="uploadPic"/>
      <embed class="lookPdf" v-else :src="uploadPic" width="600" height="400" type="application/pdf"
             internalinstanceid="81"/>
    </Modal>
    <Modal v-model="modal5" class="basic-info pageStyle" :width=650 ok-text="保存" @on-ok="submitBasic" cancel-text="关闭">
      <h2>标识型号{{pageType==="extend"?'扩展':'变更'}}备案申请书</h2>
      <p class="org">中国标准化研究院能效标识管理中心：</p>
      <div class="pro-info">
        我 <span class="f-company">{{formRecord.c1}}</span>
        公司生产的 <span class="f-brand">{{formRecord.c4}}</span>
        品牌的 <span class="f-model">{{pageType==='extend'?mainModel:formRecord.c3}}</span>
        型号的 <span class="f-product">家用和类似用途微波炉 2017版</span>产品{{pageType==="update"?'已通过能效标识备案':''}}。
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
          <Input class="valid" v-model="formRecord.ec_master_kuozhan_text" type="textarea"
                 :autosize="{minRows: 2,maxRows: 5}" placeholder="描述"></Input>
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
          <Input class="valid" v-model="formRecord.ec_master_kuozhan_text" type="textarea"
                 :autosize="{minRows: 2,maxRows: 5}" placeholder="描述"></Input>
          <b class="color-red">（请删除上述描述中多余的空格和空行，否则可能打印不完整。）</b>
        </dd>
        <dd>
          该型号的相关信息变更后的初始使用日期：
          <span class="f-date">{{formatDate(formRecord[thisDateCV])}}</span>
        </dd>
        <dd>请中国标准化研究院能效标识管理中心核准。</dd>
      </dl>
      <div class="record-attached">附：{{pageType==="extend"?'扩展':'变更'}}型号产品的能效标识样本{{pageType==="extend"?'':'以及检测报告'}}
      </div>
    </Modal>
  </div>
</template>
<script>
  import {mapGetters} from 'vuex';
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
      const timeDate = parseInt(this.$store.state.app.dateinit);
      return {
        // 当前初始使用日期 对应的C值
        thisDateCV: 'c13',
        // 当前能效等级 对应的C值
        thisLevelCV: 'c33',
        thisGZXHCV: "c3",// 当前规格型号 对应的C值
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
        mainModel: '',
        formRecord: {
          ec_master_kuozhan_text: '',
          c1: '',
          c2: '',
          c32: '',
          c3: '',
          c4: '',
          c200: '',
          c33: '',
          c35: '',
          c37: '',
          c18: '',
          c39: '',
          c100: [],
          c101: '',
          c5: '',
          c34: '',
          c6: '',
          c7: '',
          c36: '',
          c8: '',
          c9: '',
          c38: '',
          c10: '',
          c11: '',
          c40: '',
          c12: '',
          c13: new Date(),
          c14: '',
          c17: '',
          c15: '',
          c16: '',
          c19: '',
          c20: '',
          c21: '',
          c22: '',
          c23: '',
          c24: '',
          c25: '',
          c26: '',
          c41: '',
          c42: '',
          c43: '',
          c27: '',
          c28: '',
          c29: '',
          c30: '',
          c31: '',
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
          c93: '',
          c94: '',
          c95: '',
          c96: '',
          c97: '',
          c98: '',
          c99: '',
          c202: '',
          ec_model_no: 52,
          attach_list: ''
        },
        forbidden: {
          c101: true,
          c100: true,
          c36: true,
          c38: true,
          c40: true,
          c12: true,
          c11: true,
          c10: true,
          c8: true,
          c7: true,
          c9: true,
          c37: true,
          c16: true,
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
      disabledoff() {
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
        if (this.formRecord.c100.join('').indexOf('无') > -1) {
          this.formRecord.c100=['无']
          this.forbidden.c100 = true
          this.forbidden.c91 = true
          this.formRecord.c91 = ''
        } else {
          this.forbidden.c100 = false
        }

        if (this.formRecord.c100.join('').indexOf('其它') > -1) {
          this.forbidden.c101 = false
        } else {
          this.formRecord.c101 = ''
          this.forbidden.c101 = true
        }

        if (this.formRecord.c35 === '有') {
          this.forbidden.c18 = false
          this.forbidden.c36 = false
          this.forbidden.c8 = false
          this.forbidden.c7 = false
        } else {
          this.formRecord.c18 = ''
          this.forbidden.c18 = true
          this.formRecord.c36 = ''
          this.forbidden.c36 = true
          this.formRecord.c8 = ''
          this.forbidden.c8 = true
          this.formRecord.c7 = ''
          this.forbidden.c7 = true
        }

        if (this.formRecord.c37 === '有') {
          this.forbidden.c9 = false
          this.forbidden.c38 = false
          this.forbidden.c10 = false
        } else {
          this.formRecord.c38 = ''
          this.forbidden.c38 = true
          this.formRecord.c10 = ''
          this.forbidden.c10 = true
          this.formRecord.c9 = ''
          this.forbidden.c9 = true
        }

        if (this.formRecord.c39 === '有') {
          this.forbidden.c40 = false
          this.forbidden.c12 = false
          this.forbidden.c11 = false
        } else {
          this.formRecord.c40 = ''
          this.forbidden.c40 = true
          this.formRecord.c12 = ''
          this.forbidden.c12 = true
          this.formRecord.c11 = ''
          this.forbidden.c11 = true
        }

        if (this.formRecord.c15 === '其它') {
          this.forbidden.c16 = false
        } else {
          this.formRecord.c16 = ''
          this.forbidden.c16 = true
        }

        if (this.formRecord.c25 === '其它') {
          this.forbidden.c26 = false
        } else {
          this.formRecord.c26 = ''
          this.forbidden.c26 = true
        }

        var nxhs;
        var checkc34 = null;
        var checkc36 = null;
        var checkc38 = null;
        var checkc40 = null;
        var checknxdj = null;
        var checkc9 = null;
        var checkc7 = null;
        var checkc11 = null;
        var gjgn = this.formRecord.c37;
        var djgn = this.formRecord.c35;

        if ("" != (parseFloat(this.formRecord.c34))) {
          if (parseFloat(this.formRecord.c34) < parseFloat(this.formRecord.c5)) {
            checkc34 = (rule, value, callback) => {
              callback("效率值（实测值）应大于等于效率值（标称值）！");
            }
          }
        }

        if ("" != (parseFloat(this.formRecord.c36))) {
          if (parseFloat(this.formRecord.c36) > parseFloat(this.formRecord.c7)) {
            checkc36 = (rule, value, callback) => {
              callback("待机功耗（实测值）应小于等于待机功耗（标称值）！");
            }
          }
        }

        if ("" != (parseFloat(this.formRecord.c38))) {
          if (parseFloat(this.formRecord.c38) > parseFloat(this.formRecord.c9)) {
            checkc38 = (rule, value, callback) => {
              callback("关机功耗（实测值）应小于等于关机功耗（标称值）！");
            }
          }
        }

        if ("" != (parseFloat(this.formRecord.c40))) {
          if (parseFloat(this.formRecord.c40) > parseFloat(this.formRecord.c11)) {
            checkc40 = (rule, value, callback) => {
              callback("烧烤功耗（实测值）应小于等于烧烤功耗（标称值）！");
            }
          }
        }

        //效率值换算能效等级
        if (parseFloat(this.formRecord.c5) >= 60) {
          nxhs = "1";
        } else if (parseFloat(this.formRecord.c5) < 52) {
          checknxdj = (rule, value, callback) => {
            callback("备案数据不在备案范围");
          }
        } else if (parseFloat(this.formRecord.c5) >= 56 && parseFloat(this.formRecord.c5) < 60) {
          nxhs = "2";
        } else if (parseFloat(this.formRecord.c5) >= 52 && parseFloat(this.formRecord.c5) < 56) {
          nxhs = "3";
        }

        //有关机功能时判断
        if (gjgn == "有") {
          if (parseFloat(this.formRecord.c9) > 0.5) {
            checkc9 = (rule, value, callback) => {
              callback("关机功率应小于0.5!");
            }
          }
        }
        //有待机功能时判断
        if (djgn == "有") {
          var nodisplay = this.formRecord.c18;
          if (nodisplay == "待机模式时具有信息或状态显示（包括时钟）功能") {
            if (parseFloat(this.formRecord.c7) > 1) {
              checkc7 = (rule, value, callback) => {
                callback("待机功率应小于1.0");
              }
            }
          }
          if (nodisplay == "待机模式时没有信息或状态显示（包括时钟）功能") {
            if (parseFloat(this.formRecord.c7) > 0.5) {
              checkc7 = (rule, value, callback) => {
                callback("待机功率应小于0.5");
              }
            }
          }
        }

        //具有通讯协议功能的微波炉，有待机功能和关机功能，但是一旦选择了具有通讯协议功能，那些待机功率和关机功率是不允许填写数值的。
        if (djgn == "有" && gjgn == "有") {
          var txxy = this.formRecord.c100;
          if (txxy == "" || txxy == null || txxy == "无") {
            var djgl = this.formRecord.c7;
            var gjgl = this.formRecord.c9;
            if (djgn == "有") {
              if (djgl == null || djgl == "") {
                checkc7 = (rule, value, callback) => {
                  callback("待机功率不能为空");
                }
              }
            }
            if (gjgn == "有") {
              if (gjgl == null || gjgl == "") {
                checkc9 = (rule, value, callback) => {
                  callback("关机功率不能为空");
                }
              }
            }
          } else {
            var gjgl = this.formRecord.c9;
            var djgl = this.formRecord.c7;
            if (gjgl != null && gjgl != "") {
              checkc9 = (rule, value, callback) => {
                callback("选择有待机功能、有关机功能、选择具有通讯协议功能,待机功率和关机功率不允许填写");
              }
            }
            if (djgl != null && djgl != "") {
              checkc7 = (rule, value, callback) => {
                callback("选择有待机功能、有关机功能、选择具有通讯协议功能,待机功率和关机功率不允许填写");
              }
            }
          }
        }

        //有烧烤功能时判断
        var skgn = this.formRecord.c39;
        if (skgn == "有") {
          if (parseFloat(this.formRecord.c11) > 1.2) {
            checkc11 = (rule, value, callback) => {
              callback("烧烤功能应小于1.2");
            }
          }
        }

        //能效等级
        var nxdj = this.formRecord.c33;
        //一致性校验
        if (nxhs != nxdj) {
          checknxdj = (rule, value, callback) => {
            callback("所填效率值与所选能效等级不符！");
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
          c32: [
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
          c200: [
            {
              required: true,
              trigger: 'change,blur',
              message: '依据国家标准不能为空'
            }
          ],
          c35: [
            {
              required: true,
              trigger: 'change,blur',
              message: '待机功能不能为空'
            }
          ],
          c37: [
            {
              required: true,
              trigger: 'change,blur',
              message: '关机功能不能为空'
            }
          ],
          c33: [
            {
              required: true,
              trigger: 'change,blur',
              message: '能效等级不能为空'
            },
            {
              validator: checknxdj,
              trigger: 'change,blur'
            }
          ],
          c18: [
            {
              required: this.formRecord.c35 === '有',
              trigger: 'change,blur',
              message: '待机模式不能为空'
            }
          ],
          c39: [
            {
              required: true,
              trigger: 'change,blur',
              message: '烧烤功能不能为空'
            }
          ],
          c100: [
            {
              required: true,
              message: '通讯协议不能为空'
            }
          ],
          c101: [
            {
              required: this.formRecord.c100.join('').indexOf('其它') > -1,
              trigger: 'change,blur',
              message: '其它不能为空'
            }
          ],
          c5: [
            {
              required: true,
              trigger: 'change,blur',
              message: '标称值不能为空'
            },
            {
              validator: numberCheck,
              trigger: 'change,blur'
            }
          ],
          c34: [
            {
              required: true,
              trigger: 'change,blur',
              message: '实测值不能为空'
            },
            {
              validator: atLeastOneDecimals,
              trigger: 'change,blur'
            },
            {
              validator: checkc34,
              trigger: 'change,blur'
            }
          ],
          c9: [
            {
              validator: !this.forbidden.c10 ? oneDecimals : check,
              trigger: 'change,blur'
            },
            {
              validator: !this.forbidden.c10 ? checkc9 : check,
              trigger: 'change,blur'
            }
          ],
          c38: [
            {
              validator: !this.forbidden.c38 ? atLeastTwoDecimals : check,
              trigger: 'change,blur'
            },
            {
              validator: checkc38,
              trigger: 'change,blur'
            }
          ],
          c11: [
            {
              required: !this.forbidden.c40,
              trigger: 'change,blur',
              message: '标称值不能为空'
            },
            {
              validator: !this.forbidden.c40 ? oneDecimals : check,
              trigger: 'change,blur'
            },
            {
              validator: !this.forbidden.c40 ? checkc11 : check,
              trigger: 'change,blur'
            }
          ],
          c40: [
            {
              required: this.formRecord.c39 === '有',
              trigger: 'change,blur',
              message: '实测值不能为空'
            },
             {
               validator: !this.forbidden.c40 ? atLeastTwoDecimals : check,
               trigger: 'change,blur'
             },
            {
              validator: checkc40,
              trigger: 'change,blur'
            }
          ],
          c13: [
            {
              required: true,
              message: '备案标识开始使用日期不能为空'
            }
          ],
          c14: [
            {
              required: true,
              trigger: 'change,blur',
              message: '电源类型不能为空'
            }
          ],
          c16: [
            {
              required: this.formRecord.c15 === '其它',
              trigger: 'change,blur',
              message: '其它不能为空'
            }
          ],
          c17: [
            {
              required: true,
              trigger: 'change,blur',
              message: '转盘方式不能为空'
            }
          ],
          c15: [
            {
              required: true,
              trigger: 'change,blur',
              message: '类型不能为空'
            }
          ],
          c19: [
            {
              required: true,
              trigger: 'change,blur',
              message: '控制方式不能为空'
            }
          ],
          c20: [
            {
              required: true,
              trigger: 'change,blur',
              message: '温控器不能为空'
            }
          ],
          c21: [
            {
              required: true,
              trigger: 'change,blur',
              message: '热断路器不能为空'
            }
          ],
          c22: [
            {
              required: true,
              trigger: 'change,blur',
              message: '电热元件不能为空'
            }
          ],
          c23: [
            {
              required: true,
              trigger: 'change,blur',
              message: '定时器不能为空'
            }
          ],
          c24: [
            {
              required: true,
              trigger: 'change,blur',
              message: '程序控制不能为空'
            }
          ],
          c25: [
            {
              required: true,
              trigger: 'change,blur',
              message: '腔体材料不能为空'
            }
          ],
          c26: [
            {
              required: this.formRecord.c25 === '其它',
              trigger: 'change,blur',
              message: '其它不能为空'
            }
          ],
          c41: [
            {
              required: true,
              trigger: 'change,blur',
              message: '额定电压不能为空'
            },
            {
              validator: isInteger,
              trigger: 'change,blur'
            }
          ],
          c42: [
            {
              required: true,
              trigger: 'change,blur',
              message: '额定频率不能为空'
            },
            {
              validator: isInteger,
              trigger: 'change,blur'
            }
          ],
          c43: [
            {
              required: true,
              trigger: 'change,blur',
              message: '微波工作频率不能为空'
            },
            {
              validator: isInteger,
              trigger: 'change,blur'
            }
          ],
          c27: [
            {
              required: true,
              trigger: 'change,blur',
              message: '微波额定输入功率不能为空'
            },
            {
              validator: isInteger,
              trigger: 'change,blur'
            }
          ],
          c28: [
            {
              required: true,
              trigger: 'change,blur',
              message: '微波额定输出功率不能为空'
            },
            {
              validator: isInteger,
              trigger: 'change,blur'
            }
          ],
          c30: [
            {
              required: true,
              trigger: 'change,blur',
              message: '腔体容积不能为空'
            },
            {
              validator: isInteger,
              trigger: 'change,blur'
            }
          ],
          c31: [
            {
              required: true,
              trigger: 'change,blur',
              message: '长不能为空'
            }
          ],
          c44: [
            {
              required: true,
              trigger: 'change,blur',
              message: '宽不能为空'
            }
          ],
          c45: [
            {
              required: true,
              trigger: 'change,blur',
              message: '高不能为空'
            }
          ],
          c46: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c47: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c7: [
            {
              validator: !this.forbidden.c8 ? oneDecimals : check,
              trigger: 'change,blur'
            },
            {
              validator: !this.forbidden.c8 ? checkc7 : check,
              trigger: 'change,blur'
            }
          ],
          c36: [
             {
               validator: !this.forbidden.c36 ? atLeastTwoDecimals : check,
               trigger: 'change,blur'
             },
            {
              validator: checkc36,
              trigger: 'change,blur'
            }
          ],
          c48: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c49: [
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
          c55: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c56: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c57: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c58: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c64: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c65: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c66: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c67: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c68: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c69: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c76: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c77: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c78: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c79: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c84: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c85: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c86: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c87: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c92: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c93: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c94: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c95: [
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
