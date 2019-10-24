<!--远置冷凝机组冷藏陈列柜 2011版-->
<!--创建日期:2019年9月11日-->
<!--创建人:wlq-->
<template>
  <div class="wrapper">
    <Form ref="formRecord" :model="formRecord" label-position="right" :rules="ruleRecord">
      <h1>远置冷凝机组冷藏陈列柜-能源效率标识备案表</h1>
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
            <Input type="text" v-model="formRecord.c1" disabled placeholder="生产者名称"/>
          </FormItem>
          <FormItem prop="c3" label="制造单位" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c3" :disabled='disabledoff' placeholder="制造单位"/>
          </FormItem>
          <FormItem prop="c29" label="备案方" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c29" :disabled='disabledoff' placeholder="备案方"/>
          </FormItem>
          <FormItem prop="c2" label="规格型号" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c2" :disabled='!disabledoff' placeholder="规格型号"/>
          </FormItem>
          <FormItem prop="c4" label="商标" style="width:100%" :label-width="180">
            <Input type="text" v-model="formRecord.c4" :disabled='pageType=="view"' placeholder="商标"/>
          </FormItem>
          <FormItem prop="c200" label="依据国家标准" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c200" placeholder="依据国家标准" readonly disabled/>
          </FormItem>
          <FormItem prop="c35" label="能效等级" style="width:100%;" :label-width="180">
            <RadioGroup v-model="formRecord.c35">
              <Radio label="1" :disabled='disabledoff'>1级</Radio>
              <Radio label="2" :disabled='disabledoff'>2级</Radio>
              <Radio label="3" :disabled='disabledoff'>3级</Radio>
              <Radio label="4" :disabled='disabledoff'>4级</Radio>
              <Radio label="5" :disabled='disabledoff'>5级</Radio>
            </RadioGroup>
          </FormItem>
          <table id="table1">
            <tr>
              <td align="center">陈列柜类型及分级</td>
              <td>
                <FormItem prop="c9">
                  <Select v-model="formRecord.c9" style="width:100%">
                    <Option value="RS1">RS1</Option>
                    <Option value="RS2">RS2</Option>
                    <Option value="RS3">RS3</Option>
                    <Option value="RS4">RS4</Option>
                    <Option value="RS5">RS5</Option>
                    <Option value="RS6">RS6</Option>
                    <Option value="RS7">RS7</Option>
                    <Option value="RS8">RS8</Option>
                    <Option value="RS9">RS9</Option>
                    <Option value="RS10">RS10</Option>
                    <Option value="RS11">RS11</Option>
                    <Option value="RS12">RS12</Option>
                    <Option value="RS13">RS13</Option>
                    <Option value="RS14">RS14</Option>
                    <Option value="RS15">RS15</Option>
                    <Option value="RS16">RS16</Option>
                    <Option value="RS17">RS17</Option>
                    <Option value="RS18">RS18</Option>
                    <Option value="RS19">RS19</Option>
                    <Option value="RS20">RS20</Option>
                  </Select>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c10">
                  <Select v-model="formRecord.c10" style="width:100%">
                    <Option value="非照明搁架">非照明搁架</Option>
                    <Option value="照明搁架">照明搁架</Option>
                  </Select>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c13">
                  <Select v-model="formRecord.c13" style="width:100%">
                    <Option value="M1">M1</Option>
                    <Option value="M2">M2</Option>
                    <Option value="H1">H1</Option>
                    <Option value="H2">H2</Option>
                    <Option value="L1">L1</Option>
                    <Option value="L2">L2</Option>
                    <Option value="L3">L3</Option>
                    <Option value="S">S</Option>
                  </Select>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center">总能量消耗(kWh/24h)</td>
              <td>
                <FormItem prop="c5" label="标称值:" :label-width="70">
                  <Input type="text" v-model="formRecord.c5" :disabled='disabledoff' placeholder="两位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c6" label="实测值:" :label-width="70">
                  <Input type="text" v-model="formRecord.c6" :disabled='disabledoff' placeholder="三位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c30" label="备注:" :label-width="70">
                  <Input type="text" v-model="formRecord.c30" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center">总展示面积(m²)</td>
              <td>
                <FormItem prop="c7" label="标称值:" :label-width="70">
                  <Input type="text" v-model="formRecord.c7" :disabled='disabledoff' placeholder="两位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c8" label="实测值:" :label-width="70">
                  <Input type="text" v-model="formRecord.c8" :disabled='disabledoff' placeholder="三位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c31" label="备注:" :label-width="70">
                  <Input type="text" v-model="formRecord.c31" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center">气候类型3下的能效限定值</td>
              <td colspan="2">
                <FormItem prop="c38">
                  <Input type="text" v-model="formRecord.c38" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c39" label="备注:" :label-width="70">
                  <Input type="text" v-model="formRecord.c39" :disabled='disabledoff'/>
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
          <FormItem prop="c11" label="备案标识开始使用日期" style="width:100%;">
            <DatePicker type="date" :options="dataInit" style="width: 200px" v-model="formRecord.c11"></DatePicker>
          </FormItem>
        </Card>
      </div>
      <div class="part part5">
        <Card :bordered="false">
          <h2>五、其他信息</h2>
          <table id="table3">
            <tr>
              <td align="right"><i class="red">*</i>额定气候类型</td>
              <td>气候类型3</td>
              <td align="right"><i class="red">*</i>总展示面积(㎡)(两位小数)</td>
              <td>
                <FormItem prop="c18">
                  <Input type="text" v-model="formRecord.c18" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><i class="red">*</i>额定电压(V)</td>
              <td>
                <FormItem prop="c15">
                  <Input type="text" v-model="formRecord.c15" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td align="right"><i class="red">*</i>额定频率(Hz)</td>
              <td>
                <FormItem prop="c16">
                  <Input type="text" v-model="formRecord.c16" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><i class="red">*</i>额定功率(W)</td>
              <td>
                <FormItem prop="c17">
                  <Input type="text" v-model="formRecord.c17" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td align="right"><i class="red">*</i>额定能效指数(%)</td>
              <td>
                <FormItem prop="c19">
                  <Input type="text" v-model="formRecord.c19" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><i class="red">*</i>是否附有夜盖(帘)</td>
              <td>
                <FormItem prop="c20">
                  <RadioGroup v-model="formRecord.c20">
                    <Radio :disabled='disabledoff' label="是">是</Radio>
                    <Radio :disabled='disabledoff' label="否">否</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td align="right"><i class="red">*</i>是否有手动照明开关</td>
              <td>
                <FormItem prop="c21">
                  <RadioGroup v-model="formRecord.c21">
                    <Radio :disabled='disabledoff' label="是">是</Radio>
                    <Radio :disabled='disabledoff' label="否">否</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td width="200px" align="right"><i class="red">*</i>是否有时钟、智能感应器或类似的自动化装置控制照明</td>
              <td>
                <FormItem prop="c22">
                  <RadioGroup v-model="formRecord.c22">
                    <Radio :disabled='disabledoff' label="是">是</Radio>
                    <Radio :disabled='disabledoff' label="否">否</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td align="right" width="200px"><i class="red">*</i>是否有时钟、智能感应器或类似的自动化装置控制防凝露加热器</td>
              <td>
                <FormItem prop="c23">
                  <RadioGroup v-model="formRecord.c23">
                    <Radio :disabled='disabledoff' label="是">是</Radio>
                    <Radio :disabled='disabledoff' label="否">否</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><i class="red">*</i>制冷剂国际编号</td>
              <td>
                <FormItem prop="c24">
                  <Input type="text" v-model="formRecord.c24" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td align="right"><i class="red">*</i>有效容积(L)</td>
              <td>
                <FormItem prop="c36">
                  <Input type="text" v-model="formRecord.c36" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><i class="red">*</i>试验期间最热M-包的最高温度(℃)(一位小数)</td>
              <td colspan="3">
                <FormItem prop="c25" style="width: 80%">
                  <Input type="text" v-model="formRecord.c25" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><i class="red">*</i>试验期间所有M-包的平均温度(℃)(一位小数)</td>
              <td colspan="3">
                <FormItem prop="c26" style="width: 80%">
                  <Input type="text" v-model="formRecord.c26" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right">
                <FormItem prop="c37" style="font-size: 14px !important;">
                  <i class="red">*</i>试验期间
                  <Select v-model="formRecord.c37" style="width: 120px;text-align: left !important;">
                    <Option value="最冷" style="text-align: left !important;">最冷</Option>
                    <Option value="最热" style="text-align: left !important;">最热</Option>
                  </Select>
                  M-包的最低温度(℃)(一位小数)
                </FormItem>
              </td>
              <td colspan="3">
                <FormItem prop="c27" style="width: 80%">
                  <Input type="text" v-model="formRecord.c27" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><i class="red">*</i>外形尺寸(长×宽×高)(mm×mm×mm)</td>
              <td colspan="3">
                <FormItem prop="c28">
                  <Input type="text" v-model="formRecord.c28" :disabled='disabledoff'/>
                </FormItem>
                <FormItem><b>×</b></FormItem>
                <FormItem prop="c33">
                  <Input type="text" v-model="formRecord.c33" :disabled='disabledoff'/>
                </FormItem>
                <FormItem><b>×</b></FormItem>
                <FormItem prop="c34">
                  <Input type="text" v-model="formRecord.c34" :disabled='disabledoff'/>
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
              <th colspan="2">规格型号</th>
              <th colspan="2">技术参数</th>
              <th>生产者（全称）</th>
            </tr>
            </thead>
            <tbody align="center">
            <tr>
              <td width="80" rowspan="3">1</td>
              <td rowspan="3">压缩机（如有）</td>
              <td rowspan="3" colspan="2">
                <FormItem prop="c41" style="width: 100%">
                  <Input type="text" v-model="formRecord.c41" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>功率</td>
              <td>
                <FormItem prop="c42" style="width: 100%">
                  <Input type="text" v-model="formRecord.c42" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td rowspan="3">
                <FormItem prop="c43" style="width: 100%">
                  <Input type="text" v-model="formRecord.c43" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>压制冷剂</td>
              <td>
                <FormItem prop="c44" style="width: 100%">
                  <Input type="text" v-model="formRecord.c44" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>数量</td>
              <td>
                <FormItem prop="c45" style="width: 100%">
                  <Input type="text" v-model="formRecord.c45" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td width="80" rowspan="3">2</td>
              <td rowspan="3">压缩机（如有）</td>
              <td rowspan="3" colspan="2">
                <FormItem prop="c46" style="width: 100%">
                  <Input type="text" v-model="formRecord.c46" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>功率</td>
              <td>
                <FormItem prop="c47" style="width: 100%">
                  <Input type="text" v-model="formRecord.c47" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td rowspan="3">
                <FormItem prop="c48" style="width: 100%">
                  <Input type="text" v-model="formRecord.c48" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>压制冷剂</td>
              <td>
                <FormItem prop="c49" style="width: 100%">
                  <Input type="text" v-model="formRecord.c49" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>数量</td>
              <td>
                <FormItem prop="c50" style="width: 100%">
                  <Input type="text" v-model="formRecord.c50" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td width="80">3</td>
              <td>冷凝器（如有）</td>
              <td colspan="2">
                <FormItem prop="c51" style="width: 100%">
                  <Input type="text" v-model="formRecord.c51" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>换热表面积(m2)</td>
              <td>
                <FormItem prop="c52" style="width: 100%">
                  <Input type="text" v-model="formRecord.c52" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c53" style="width: 100%">
                  <Input type="text" v-model="formRecord.c53" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td width="80">4</td>
              <td>冷凝器（如有）</td>
              <td colspan="2">
                <FormItem prop="c54" style="width: 100%">
                  <Input type="text" v-model="formRecord.c54" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>换热表面积(m2)</td>
              <td>
                <FormItem prop="c55" style="width: 100%">
                  <Input type="text" v-model="formRecord.c55" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c56" style="width: 100%">
                  <Input type="text" v-model="formRecord.c56" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td width="80" rowspan="3">5</td>
              <td rowspan="3">冷凝器风机（如有）</td>
              <td>风机整机型号</td>
              <td>
                <FormItem prop="c57" style="width: 100%">
                  <Input type="text" v-model="formRecord.c57" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>叶轮直径(mm)</td>
              <td>
                <FormItem prop="c58" style="width: 100%">
                  <Input type="text" v-model="formRecord.c58" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td rowspan="3">
                <FormItem prop="c59" style="width: 100%">
                  <Input type="text" v-model="formRecord.c59" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>电机	</td>
              <td>
                <FormItem prop="c60" style="width: 100%">
                  <Input type="text" v-model="formRecord.c60" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>功率(W)</td>
              <td>
                <FormItem prop="c61" style="width: 100%">
                  <Input type="text" v-model="formRecord.c61" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>扇叶</td>
              <td>
                <FormItem prop="c62" style="width: 100%">
                  <Input type="text" v-model="formRecord.c62" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>数量</td>
              <td>
                <FormItem prop="c63" style="width: 100%">
                  <Input type="text" v-model="formRecord.c63" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td width="80" rowspan="3">6</td>
              <td rowspan="3">冷凝器风机（如有）</td>
              <td>风机整机型号</td>
              <td>
                <FormItem prop="c64" style="width: 100%">
                  <Input type="text" v-model="formRecord.c64" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>叶轮直径(mm)</td>
              <td>
                <FormItem prop="c65" style="width: 100%">
                  <Input type="text" v-model="formRecord.c65" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td rowspan="3">
                <FormItem prop="c66" style="width: 100%">
                  <Input type="text" v-model="formRecord.c66" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>电机</td>
              <td>
                <FormItem prop="c67" style="width: 100%">
                  <Input type="text" v-model="formRecord.c67" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>功率(W)</td>
              <td>
                <FormItem prop="c68" style="width: 100%">
                  <Input type="text" v-model="formRecord.c68" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>扇叶</td>
              <td>
                <FormItem prop="c69" style="width: 100%">
                  <Input type="text" v-model="formRecord.c69" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>数量</td>
              <td>
                <FormItem prop="c70" style="width: 100%">
                  <Input type="text" v-model="formRecord.c70" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td width="80">7</td>
              <td>蒸发器</td>
              <td colspan="2">
                <FormItem prop="c71" style="width: 100%">
                  <Input type="text" v-model="formRecord.c71" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>换热表面积(m2)</td>
              <td>
                <FormItem prop="c72" style="width: 100%">
                  <Input type="text" v-model="formRecord.c72" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c73" style="width: 100%">
                  <Input type="text" v-model="formRecord.c73" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td width="80">8</td>
              <td>蒸发器</td>
              <td colspan="2">
                <FormItem prop="c74" style="width: 100%">
                  <Input type="text" v-model="formRecord.c74" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>换热表面积(m2)</td>
              <td>
                <FormItem prop="c75" style="width: 100%">
                  <Input type="text" v-model="formRecord.c75" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c76" style="width: 100%">
                  <Input type="text" v-model="formRecord.c76" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td width="80" rowspan="3">9</td>
              <td rowspan="3">蒸发器风机（如有）</td>
              <td>风机整机型号</td>
              <td>
                <FormItem prop="c77" style="width: 100%">
                  <Input type="text" v-model="formRecord.c77" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>叶轮直径(mm)</td>
              <td>
                <FormItem prop="c78" style="width: 100%">
                  <Input type="text" v-model="formRecord.c78" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td rowspan="3">
                <FormItem prop="c79" style="width: 100%">
                  <Input type="text" v-model="formRecord.c79" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>电机</td>
              <td>
                <FormItem prop="c80" style="width: 100%">
                  <Input type="text" v-model="formRecord.c80" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>功率(W)</td>
              <td>
                <FormItem prop="c81" style="width: 100%">
                  <Input type="text" v-model="formRecord.c81" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>扇叶</td>
              <td>
                <FormItem prop="c82" style="width: 100%">
                  <Input type="text" v-model="formRecord.c82" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>数量</td>
              <td>
                <FormItem prop="c83" style="width: 100%">
                  <Input type="text" v-model="formRecord.c83" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td width="80" rowspan="3">10</td>
              <td rowspan="3">蒸发器风机（如有）</td>
              <td>风机整机型号</td>
              <td>
                <FormItem prop="c84" style="width: 100%">
                  <Input type="text" v-model="formRecord.c84" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>叶轮直径(mm)</td>
              <td>
                <FormItem prop="c85" style="width: 100%">
                  <Input type="text" v-model="formRecord.c85" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td rowspan="3">
                <FormItem prop="c86" style="width: 100%">
                  <Input type="text" v-model="formRecord.c86" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>电机</td>
              <td>
                <FormItem prop="c87" style="width: 100%">
                  <Input type="text" v-model="formRecord.c87" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>功率(W)</td>
              <td>
                <FormItem prop="c88" style="width: 100%">
                  <Input type="text" v-model="formRecord.c88" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>扇叶</td>
              <td>
                <FormItem prop="c89" style="width: 100%">
                  <Input type="text" v-model="formRecord.c89" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>数量</td>
              <td>
                <FormItem prop="c90" style="width: 100%">
                  <Input type="text" v-model="formRecord.c90" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td width="80">11</td>
              <td>节流装置</td>
              <td colspan="2" align="left">
                <FormItem prop="c91">
                  <CheckboxGroup v-model="formRecord.c91" class="overwrite1">
                    <Checkbox label="膨胀阀" :disabled='disabledoff' class="overwrite2">膨胀阀</Checkbox>
                    <Checkbox label="毛细管" :disabled='disabledoff' class="overwrite2">毛细管</Checkbox>
                  </CheckboxGroup>
                </FormItem>
              </td>
              <td>膨胀阀芯</td>
              <td>
                <FormItem prop="c92" style="width: 100%">
                  <Input type="text" v-model="formRecord.c92" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c93" style="width: 100%">
                  <Input type="text" v-model="formRecord.c93" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td width="80">12</td>
              <td>节流装置</td>
              <td colspan="2" align="left">
                <FormItem prop="c94">
                    <CheckboxGroup v-model="formRecord.c94" class="overwrite1">
                      <Checkbox label="膨胀阀" :disabled='disabledoff' class="overwrite2">膨胀阀</Checkbox>
                      <Checkbox label="毛细管" :disabled='disabledoff' class="overwrite2">毛细管</Checkbox>
                    </CheckboxGroup>
                </FormItem>
              </td>
              <td>膨胀阀芯</td>
              <td>
                <FormItem prop="c95" style="width: 100%">
                  <Input type="text" v-model="formRecord.c95" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c96" style="width: 100%">
                  <Input type="text" v-model="formRecord.c96" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td width="80">13</td>
              <td>融霜加热器（如有）</td>
              <td colspan="2">
                <FormItem prop="c97" style="width: 100%">
                  <Input type="text" v-model="formRecord.c97" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>功率(W)</td>
              <td>
                <FormItem prop="c98" style="width: 100%">
                  <Input type="text" v-model="formRecord.c98" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c99" style="width: 100%">
                  <Input type="text" v-model="formRecord.c99" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td width="80">14</td>
              <td>融霜加热器（如有）</td>
              <td colspan="2">
                <FormItem prop="c100" style="width: 100%">
                  <Input type="text" v-model="formRecord.c100" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>功率(W)</td>
              <td>
                <FormItem prop="c101" style="width: 100%">
                  <Input type="text" v-model="formRecord.c101" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c102" style="width: 100%">
                  <Input type="text" v-model="formRecord.c102" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td width="80">15</td>
              <td>防凝露加热器(如有)</td>
              <td colspan="2">
                <FormItem prop="c103" style="width: 100%">
                  <Input type="text" v-model="formRecord.c103" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>功率(W)	</td>
              <td>
                <FormItem prop="c104" style="width: 100%">
                  <Input type="text" v-model="formRecord.c104" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c105" style="width: 100%">
                  <Input type="text" v-model="formRecord.c105" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td width="80">16</td>
              <td>防凝露加热器(如有)</td>
              <td colspan="2">
                <FormItem prop="c106" style="width: 100%">
                  <Input type="text" v-model="formRecord.c106" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>功率(W)</td>
              <td>
                <FormItem prop="c107" style="width: 100%">
                  <Input type="text" v-model="formRecord.c107" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c108" style="width: 100%">
                  <Input type="text" v-model="formRecord.c108" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td width="80" rowspan="3">17</td>
              <td rowspan="3">照明灯(如有)</td>
              <td rowspan="3" colspan="2">
                <FormItem prop="c109" style="width: 100%">
                  <Input type="text" v-model="formRecord.c109" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>功率(W)</td>
              <td>
                <FormItem prop="c110" style="width: 100%">
                  <Input type="text" v-model="formRecord.c110" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td rowspan="3">
                <FormItem prop="c111" style="width: 100%">
                  <Input type="text" v-model="formRecord.c111" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>类型</td>
              <td>
                <FormItem prop="c112" style="width: 100%">
                  <Input type="text" v-model="formRecord.c112" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>数量</td>
              <td>
                <FormItem prop="c113" style="width: 100%">
                  <Input type="text" v-model="formRecord.c113" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td width="80" rowspan="3">18</td>
              <td rowspan="3">照明灯(如有)	</td>
              <td rowspan="3" colspan="2">
                <FormItem prop="c114" style="width: 100%">
                  <Input type="text" v-model="formRecord.c114" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>功率(W)</td>
              <td>
                <FormItem prop="c115" style="width: 100%">
                  <Input type="text" v-model="formRecord.c115" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td rowspan="3">
                <FormItem prop="c116" style="width: 100%">
                  <Input type="text" v-model="formRecord.c116" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>类型</td>
              <td>
                <FormItem prop="c117" style="width: 100%">
                  <Input type="text" v-model="formRecord.c117" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>数量</td>
              <td>
                <FormItem prop="c118" style="width: 100%">
                  <Input type="text" v-model="formRecord.c118" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td width="80" rowspan="3">19</td>
              <td rowspan="3">夜帘(如有)</td>
              <td rowspan="3" colspan="2">
                <FormItem prop="c119" style="width: 100%">
                  <Input type="text" v-model="formRecord.c119" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>厚度（mm）</td>
              <td>
                <FormItem prop="c120" style="width: 100%">
                  <Input type="text" v-model="formRecord.c120" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td rowspan="3">
                <FormItem prop="c121" style="width: 100%">
                  <Input type="text" v-model="formRecord.c121" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>材质</td>
              <td>
                <FormItem prop="c122" style="width: 100%">
                  <Input type="text" v-model="formRecord.c122" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>个数</td>
              <td>
                <FormItem prop="c123" style="width: 100%">
                  <Input type="text" v-model="formRecord.c123" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td width="80" rowspan="3">20</td>
              <td rowspan="3">夜帘(如有)	</td>
              <td rowspan="3" colspan="2">
                <FormItem prop="c124" style="width: 100%">
                  <Input type="text" v-model="formRecord.c124" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>厚度（mm）</td>
              <td>
                <FormItem prop="c125" style="width: 100%">
                  <Input type="text" v-model="formRecord.c125" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td rowspan="3">
                <FormItem prop="c126" style="width: 100%">
                  <Input type="text" v-model="formRecord.c126" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>材质</td>
              <td>
                <FormItem prop="c127" style="width: 100%">
                  <Input type="text" v-model="formRecord.c127" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>个数</td>
              <td>
                <FormItem prop="c128" style="width: 100%">
                  <Input type="text" v-model="formRecord.c128" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td width="80" rowspan="3">21</td>
              <td rowspan="3">门玻璃(如有)</td>
              <td rowspan="3" colspan="2">
                <FormItem prop="c129" style="width: 100%">
                  <Input type="text" v-model="formRecord.c129" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>厚度（mm）</td>
              <td>
                <FormItem prop="c130" style="width: 100%">
                  <Input type="text" v-model="formRecord.c130" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td rowspan="3">
                <FormItem prop="c131" style="width: 100%">
                  <Input type="text" v-model="formRecord.c131" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>传热系数K</td>
              <td>
                <FormItem prop="c132" style="width: 100%">
                  <Input type="text" v-model="formRecord.c132" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>可见光透射比</td>
              <td>
                <FormItem prop="c133" style="width: 100%">
                  <Input type="text" v-model="formRecord.c133" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td width="80" rowspan="3">22</td>
              <td rowspan="3">门玻璃(如有)</td>
              <td rowspan="3" colspan="2">
                <FormItem prop="c134" style="width: 100%">
                  <Input type="text" v-model="formRecord.c134" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>厚度（mm）</td>
              <td>
                <FormItem prop="c135" style="width: 100%">
                  <Input type="text" v-model="formRecord.c135" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td rowspan="3">
                <FormItem prop="c136" style="width: 100%">
                  <Input type="text" v-model="formRecord.c136" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>传热系数K</td>
              <td>
                <FormItem prop="c137" style="width: 100%">
                  <Input type="text" v-model="formRecord.c137" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>可见光透射比</td>
              <td>
                <FormItem prop="c138" style="width: 100%">
                  <Input type="text" v-model="formRecord.c138" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td colspan="7" align="center">注：如上述零部件属多个生产者，均应按上述要求逐一填写。</td>
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
        <!--<Button type="primary" @click="saveRecord" v-if='!pageType' :disabled="saveDisabled">保存到草稿</Button>-->
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
      <p v-show="loadText && !uploadPic.includes('.pdf')" style="text-align:center">加载中···</p>
      <img class="lookPdf" v-if="!uploadPic.includes('.pdf')" width="790" :src="uploadPic" @load="templateLoad"/>
      <embed class="lookPdf" v-else :src="uploadPic" width="600" height="400" @load="templateLoad"
             type="application/pdf" internalinstanceid="81"/>
    </Modal>
    <Modal v-model="modal5" class="basic-info pageStyle" :width=650 ok-text="保存" @on-ok="submitBasic" cancel-text="关闭">
      <h2>标识型号{{pageType==="extend"?'扩展':'变更'}}备案申请书</h2>
      <p class="org">中国标准化研究院能效标识管理中心：</p>
      <div class="pro-info">
        我 <span class="f-company">{{formRecord.c1}}</span>
        公司生产的 <span class="f-brand">{{formRecord.c2}}</span>
        品牌的 <span class="f-model">{{pageType==='extend'?mainModel:formRecord.c4}}</span>
        型号的 <span class="f-product">远置冷凝机组冷藏陈列柜 2011版</span>产品{{pageType==="update"?'已通过能效标识备案':''}}。
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
    check
  } from '@/libs/utilExt'

  export default {
    data() {
      const timeDate = parseInt(this.$store.state.app.dateinit);
      return {
        // 当前初始使用日期 对应的C值
        thisDateCV: "c11",
        // 当前能效等级 对应的C值
        thisLevelCV: "c35",
        thisGZXHCV: "c2",// 当前规格型号 对应的C值
        modal3: false,
        modal4: false,
        modal5: false,
        templatePic: '',
        loadText: true,
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
        mainModel: '',
        formRecord: {
          ec_master_kuozhan_text: '',
          c1: '',
          c3: '',
          c29: '',
          c2: '',
          c4: '',
          c200: '',
          c35: '',
          c9: '',
          c10: '',
          c13: '',
          c5: '',
          c6: '',
          c30: '',
          c7: '',
          c8: '',
          c31: '',
          c38: '',
          c39: '',
          c11: new Date(),
          c18: '',
          c15: '',
          c16: '',
          c17: '',
          c19: '',
          c20: '',
          c21: '',
          c22: '',
          c23: '',
          c24: '',
          c36: '',
          c25: '',
          c26: '',
          c37: '',
          c27: '',
          c28: '',
          c33: '',
          c34: '',
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
          c82: '',
          c83: '',
          c84: '',
          c85: '',
          c86: '',
          c87: '',
          c88: '',
          c89: '',
          c90: '',
          c91: [],
          c92: '',
          c93: '',
          c94: [],
          c95: '',
          c96: '',
          c97: '',
          c98: '',
          c99: '',
          c100: '',
          c101: '',
          c102: '',
          c103: '',
          c104: '',
          c105: '',
          c106: '',
          c108: '',
          c109: '',
          c110: '',
          c111: '',
          c112: '',
          c113: '',
          c114: '',
          c115: '',
          c116: '',
          c117: '',
          c118: '',
          c119: '',
          c120: '',
          c121: '',
          c122: '',
          c123: '',
          c124: '',
          c125: '',
          c126: '',
          c127: '',
          c128: '',
          c129: '',
          c130: '',
          c131: '',
          c132: '',
          c133: '',
          c134: '',
          c135: '',
          c136: '',
          c137: '',
          c138: '',
          c202: '',
          ec_model_no: 28,
          attach_list: ''
        },
        forbidden: {}
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
      templateLoad() {
        this.loadText = false;
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
        if (res.Status) {
          this.$Spin.hide();
          this['checkmark' + id] = true
        } else {
          this['checkmark' + id] = false
          this.uploadParam['filePath' + id] = ''
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
        let c6 = this.formRecord.c6;
        let c5 = this.formRecord.c5;
        let c8 = this.formRecord.c8;
        let c7 = this.formRecord.c7;
        const checkc6 = (rule, value, callback) => {
          if (parseFloat(c6) != null && parseFloat(c6) > (parseFloat(c5) * 1.05)) {
            callback("总能量消耗实测值不能大于额定值的105%！")
          } else {
            callback()
          }
        }

        const checkc8 = (rule, value, callback) => {
          if (parseFloat(c8) != null && parseFloat(c8) < (parseFloat(c7) * 0.98)) {
            callback("总展示面积实测值大于等于额定值的98%！");
          } else {
            callback()
          }
        }

        const checkc26 = (rule, value, callback) => {
          if (parseFloat(this.formRecord.c37) != null && "最冷" !== parseFloat(this.formRecord.c37)) {
            if (parseFloat(this.formRecord.c26) > parseFloat(this.formRecord.c25) || parseFloat(this.formRecord.c26) < parseFloat(this.formRecord.c27)) {
              callback("试验期间所有M-包的平均温度数值必须在最高和最低温度之间");
            } else {
              callback()
            }
          } else {
            callback()
          }
        }

        var nxdj = 0;
        var n = parseFloat(this.formRecord.c19)
        if (n <= 55) {
          nxdj = 1;
        } else if (n <= 65) {
          nxdj = 2;
        } else if (n <= 80) {
          nxdj = 3;
        } else if (n <= 90) {
          nxdj = 4;
        } else if (n <= 100) {
          nxdj = 5;
        }

        const checkc35 = (rule, value, callback) => {
          if (nxdj === 0) {
            callback("能效数据不在备案范围")
          } else if (parseFloat(this.formRecord.c35) != nxdj) {
            callback("能效等级与额定能效指数不匹配！")
          } else {
            callback()
          }
        }
        const changeVal = (rule, value, callback) => {
          this.mainModel === value ? callback('扩展备案需要变更型号名称') : callback()
        }
        if (this.pageType === 'view') {
          return {};
        } else if (this.pageType === 'extend') {
          return {
            c2: [
              {
                trigger: 'change,blur',
                required: true,
                message: '产品规格型号不能为空'
              },
              {
                validator: changeVal,
                trigger: 'change,blur'
              }
            ]
          }
        }else{
          return {
            c1: [
              {
                required: true,
                trigger: 'change,blur',
                message: '生产者名称不能为空'
              }
            ],
            c3: [
              {
                required: true,
                trigger: 'change,blur',
                message: '制造单位不能为空'
              }
            ],
            c29: [
              {
                required: true,
                trigger: 'change,blur',
                message: '备案方不能为空'
              }
            ],
            c2: [
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
            c35: [
              {
                required: true,
                trigger: 'change,blur',
                message: '能效等级不能为空'
              },
              {
                validator: checkc35,
                trigger: 'change,blur'
              }
            ],
            c9: [
              {
                required: true,
                trigger: 'change,blur',
                message: '陈列柜类型及分级不能为空'
              }
            ],
            c10: [
              {
                required: true,
                trigger: 'change,blur',
                message: '陈列柜类型及分级不能为空'
              }
            ],
            c13: [
              {
                required: true,
                trigger: 'change,blur',
                message: '陈列柜类型及分级不能为空'
              }
            ],
            c5: [
              {
                required: true,
                trigger: 'change,blur',
                message: '标称值不能为空'
              },
              {
                validator: twoDecimals,
                trigger: 'change,blur'
              }
            ],
            c6: [
              {
                required: true,
                trigger: 'change,blur',
                message: '实测值不能为空'
              },
              {
                validator: threeDecimals,
                trigger: 'change,blur'
              },
              {
                validator: checkc6,
                trigger: 'change,blur'
              }
            ],
            c30: [
              {
                required: true,
                trigger: 'change,blur',
                message: '备注不能为空'
              }
            ],
            c7: [
              {
                required: true,
                trigger: 'change,blur',
                message: '标称值不能为空'
              },
              {
                validator: twoDecimals,
                trigger: 'change,blur'
              }
            ],
            c8: [
              {
                required: true,
                trigger: 'change,blur',
                message: '实测值不能为空'
              },
              {
                validator: twoDecimals,
                trigger: 'change,blur'
              },
              {
                validator: checkc8,
                trigger: 'change,blur'
              }
            ],
            c31: [
              {
                required: true,
                trigger: 'change,blur',
                message: '备注不能为空'
              }
            ],
            c11: [
              {
                required: true,
                message: '备案标识开始使用日期不能为空'
              }
            ],
            c18: [
              {
                required: true,
                trigger: 'change,blur',
                message: '总展示面积'
              },
              {
                validator: twoDecimals,
                trigger: 'change,blur'
              }
            ],
            c20: [
              {
                required: true,
                trigger: 'change,blur',
                message: '夜盖不能为空'
              }
            ],
            c21: [
              {
                required: true,
                trigger: 'change,blur',
                message: '不能为空'
              }
            ],
            c22: [
              {
                required: true,
                trigger: 'change,blur',
                message: '不能为空 '
              }
            ],
            c23: [
              {
                required: true,
                trigger: 'change,blur',
                message: '不能为空'
              }
            ],
            c15: [
              {
                required: true,
                trigger: 'change,blur',
                message: '额定电压不能为空'
              }
            ],
            c16: [
              {
                required: true,
                trigger: 'change,blur',
                message: '额定频率不能为空'
              }
            ],
            c17: [
              {
                required: true,
                trigger: 'change,blur',
                message: '额定功率不能为空'
              }
            ],
            c19: [
              {
                required: true,
                trigger: 'change,blur',
                message: '额定能效指数不能为空'
              }
            ],
            c24: [
              {
                required: true,
                trigger: 'change,blur',
                message: '制冷剂国际编号不能为空'
              }
            ],
            c25: [
              {
                required: true,
                trigger: 'change,blur',
                message: '试验期间最热 包的最高温度不能为空'
              },
              {
                validator: oneDecimals,
                trigger: 'change,blur'
              }
            ],
            c26: [
              {
                required: true,
                trigger: 'change,blur',
                message: '试验期间所有 包的平均温度不能为空'
              },
              {
                validator: oneDecimals,
                trigger: 'change,blur'
              },
              {
                validator: checkc26,
                trigger: 'change,blur'
              }
            ],
            c36: [
              {
                required: true,
                trigger: 'change,blur',
                message: '有效容积不能为空'
              }
            ],
            c37: [
              {
                required: true,
                trigger: 'change,blur',
                message: '试验期间不能为空'
              }
            ],
            c27: [
              {
                required: true,
                trigger: 'change,blur',
                message: '包的最低温度不能为空'
              },
              {
                validator: oneDecimals,
                trigger: 'change,blur'
              }
            ],
            c28: [
              {
                required: true,
                trigger: 'change,blur',
                message: '外形尺寸长不能为空'
              }
            ],
            c33: [
              {
                required: true,
                trigger: 'change,blur',
                message: '外形尺寸宽不能为空'
              }
            ],
            c34: [
              {
                required: true,
                trigger: 'change,blur',
                message: '外形尺寸高不能为空'
              }
            ],
            c38: [
              {
                required: true,
                trigger: 'change,blur',
                message: '气候类型3下的能效限定值不能为空'
              }
            ],
            c41: [
              {
                required: true,
                trigger: 'change,blur',
                message: '不能为空'
              }
            ],
            c42: [
              {
                required: true,
                trigger: 'change,blur',
                message: '不能为空'
              }
            ],
            c43: [
              {
                required: true,
                trigger: 'change,blur',
                message: '不能为空'
              }
            ],
            c44: [
              {
                required: true,
                trigger: 'change,blur',
                message: '不能为空'
              }
            ],
            c45: [
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
            ],
            c63: [
              {
                required: true,
                trigger: 'change,blur',
                message: '不能为空'
              }
            ],
            c71: [
              {
                required: true,
                trigger: 'change,blur',
                message: '不能为空'
              }
            ],
            c72: [
              {
                required: true,
                trigger: 'change,blur',
                message: '不能为空'
              }
            ],
            c73: [
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
            c80: [
              {
                required: true,
                trigger: 'change,blur',
                message: '不能为空'
              }
            ],
            c81: [
              {
                required: true,
                trigger: 'change,blur',
                message: '不能为空'
              }
            ],
            c82: [
              {
                required: true,
                trigger: 'change,blur',
                message: '不能为空'
              }
            ],
            c83: [
              {
                required: true,
                trigger: 'change,blur',
                message: '不能为空'
              }
            ],
            c91: [
              {
                required: true,
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
            c97: [
              {
                required: true,
                trigger: 'change,blur',
                message: '不能为空'
              }
            ],
            c98: [
              {
                required: true,
                trigger: 'change,blur',
                message: '不能为空'
              }
            ],
            c99: [
              {
                required: true,
                trigger: 'change,blur',
                message: '不能为空'
              }
            ],
            c103: [
              {
                required: true,
                trigger: 'change,blur',
                message: '不能为空'
              }
            ],
            c104: [
              {
                required: true,
                trigger: 'change,blur',
                message: '不能为空'
              }
            ],
            c105: [
              {
                required: true,
                trigger: 'change,blur',
                message: '不能为空'
              }
            ],
            c109: [
              {
                required: true,
                trigger: 'change,blur',
                message: '不能为空'
              }
            ],
            c110: [
              {
                required: true,
                trigger: 'change,blur',
                message: '不能为空'
              }
            ],
            c112: [
              {
                required: true,
                trigger: 'change,blur',
                message: '不能为空'
              }
            ],
            c113: [
              {
                required: true,
                trigger: 'change,blur',
                message: '不能为空'
              }
            ],
            c119: [
              {
                required: true,
                trigger: 'change,blur',
                message: '不能为空'
              }
            ],
            c120: [
              {
                required: true,
                trigger: 'change,blur',
                message: '不能为空'
              }
            ],
            c121: [
              {
                required: true,
                trigger: 'change,blur',
                message: '不能为空'
              }
            ],
            c122: [
              {
                required: true,
                trigger: 'change,blur',
                message: '不能为空'
              }
            ],
            c123: [
              {
                required: true,
                trigger: 'change,blur',
                message: '不能为空'
              }
            ],
            c129: [
              {
                required: true,
                trigger: 'change,blur',
                message: '不能为空'
              }
            ],
            c130: [
              {
                required: true,
                trigger: 'change,blur',
                message: '不能为空'
              }
            ],
            c131: [
              {
                required: true,
                trigger: 'change,blur',
                message: '不能为空'
              }
            ],
            c132: [
              {
                required: true,
                trigger: 'change,blur',
                message: '不能为空'
              }
            ],
            c133: [
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
  }
</script>
<style>
  @import '../../../css/comm.css';
  .overwrite1 /deep/ span {
    width: 14px !important;
  }
  .overwrite2 /deep/ .ivu-checkbox-inner{
    width: 14px !important;
  }
</style>
