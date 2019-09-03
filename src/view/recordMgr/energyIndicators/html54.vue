/*
* 5、自携冷凝机组商用冷柜2015版
* 创建日期:2019年5月27日
* 创建人:WH
* --测试号：1539677641001253815
*/
<template>
  <div class="wrapper">
    <Form ref="formRecord" :model="formRecord" label-position="right" :rules="pageType!='extend'?ruleRecord:{}">
      <h1>商用制冷器具-能源效率标识备案表</h1>
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
          <FormItem prop="c2" label="制造单位" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c2" :disabled='disabledoff' placeholder="制造单位"/>
          </FormItem>
          <FormItem prop="c3" label="备案方" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c3" :disabled='disabledoff' placeholder="备案方"/>
          </FormItem>
          <FormItem prop="c4" label="产品规格型号" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c4" :disabled='!disabledoff' placeholder="规格型号"/>
          </FormItem>
          <FormItem prop="c5" label="商标" style="width:100%" :label-width="180">
            <Input type="text" v-model="formRecord.c5" :disabled='pageType=="view"' placeholder="商标"/>
          </FormItem>
          <FormItem prop="c200" label="依据国家标准" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c200" placeholder="依据国家标准" readonly disabled/>
          </FormItem>
          <FormItem prop="c30" label="能效等级" style="width:100%;" :label-width="180">
            <RadioGroup v-model="formRecord.c30">
              <Radio label="1" :disabled='disabledoff'>1级</Radio>
              <Radio label="2" :disabled='disabledoff'>2级</Radio>
              <Radio label="3" :disabled='disabledoff'>3级</Radio>
              <Radio label="4" :disabled='disabledoff'>4级</Radio>
              <Radio label="5" :disabled='disabledoff'>5级</Radio>
            </RadioGroup>
          </FormItem>
          <table id="table1">
            <tr>
              <td colspan="2" class="t_label">总能量消耗(kWh/24h)</td>
              <td>
                <FormItem prop="c6" label="标称值:" :label-width="70">
                  <Input type="text" v-model="formRecord.c6" :disabled='disabledoff' placeholder="两位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c7" label="实测值:" :label-width="70">
                  <Input type="text" v-model="formRecord.c7" :disabled='disabledoff' placeholder="至少三位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c8" label="备注" :label-width="70">
                  <Input type="text" v-model="formRecord.c8" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td colspan="2" class="t_label">总展示面积(m²)</td>
              <td>
                <FormItem prop="c9" label="标称值:" :label-width="70">
                  <Input type="text" v-model="formRecord.c9" :disabled='disabledoff' placeholder="两位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c10" label="实测值:" :label-width="70">
                  <Input type="text" v-model="formRecord.c10" :disabled='disabledoff' placeholder="至少三位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c11" label="备注:" :label-width="70">
                  <Input type="text" v-model="formRecord.c11" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td rowspan="4" class="t_label">净容积（总有效容积）</td>
              <td class="t_label"><span class="red">*</span>间室1净容积（有效容积）<br>
                <FormItem prop="c214">
                  <RadioGroup v-model="formRecord.c214">
                    <Radio label="（m³）" :disabled='disabledoff'></Radio>
                    <Radio label="（L）" :disabled='disabledoff'></Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c15" label="标称值:" :label-width="70">
                  <Input type="text" v-model="formRecord.c15" :disabled='disabledoff||formRecord.c214==""'
                         placeholder="(m³)三位小数,(L)整数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c16" label="实测值:" :label-width="70">
                  <Input type="text" v-model="formRecord.c16" :disabled='disabledoff||formRecord.c214==""'
                         placeholder="(m³)四位小数,(L)一位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c17" label="备注:" :label-width="70">
                  <Input type="text" v-model="formRecord.c17" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="t_label">间室2净容积（有效容积）<br>
                <FormItem prop="c215">
                  <RadioGroup v-model="formRecord.c215">
                    <Radio label="（m³）" :disabled='disabledoff'></Radio>
                    <Radio label="（L）" :disabled='disabledoff'></Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c18" label="标称值:" :label-width="70">
                  <Input type="text" v-model="formRecord.c18" :disabled='disabledoff||formRecord.c215==""'
                         placeholder="(m³)三位小数,(L)整数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c19" label="实测值:" :label-width="70">
                  <Input type="text" v-model="formRecord.c19" :disabled='disabledoff||formRecord.c215==""'
                         placeholder="(m³)四位小数,(L)一位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c20" label="备注:" :label-width="70">
                  <Input type="text" v-model="formRecord.c20" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="t_label">间室3净容积（有效容积）<br>
                <FormItem prop="c216">
                  <RadioGroup v-model="formRecord.c216">
                    <Radio label="（m³）" :disabled='disabledoff'></Radio>
                    <Radio label="（L）" :disabled='disabledoff'></Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c21" label="标称值:" :label-width="70">
                  <Input type="text" v-model="formRecord.c21" :disabled='disabledoff||formRecord.c216==""'
                         placeholder="(m³)三位小数,(L)整数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c22" label="实测值:" :label-width="70">
                  <Input type="text" v-model="formRecord.c22" :disabled='disabledoff||formRecord.c216==""'
                         placeholder="(m³)四位小数,(L)一位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c23" label="备注:" :label-width="70">
                  <Input type="text" v-model="formRecord.c23" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="t_label">间室4净容积（有效容积）<br>
                <FormItem prop="c217">
                  <RadioGroup v-model="formRecord.c217">
                    <Radio label="（m³）" :disabled='disabledoff'></Radio>
                    <Radio label="（L）" :disabled='disabledoff'></Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c24" label="标称值:" :label-width="70">
                  <Input type="text" v-model="formRecord.c24" :disabled='disabledoff||formRecord.c217==""'
                         placeholder="(m³)三位小数,(L)整数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c25" label="实测值:" :label-width="70">
                  <Input type="text" v-model="formRecord.c25" :disabled='disabledoff||formRecord.c217==""'
                         placeholder="(m³)四位小数,(L)一位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c26" label="备注:" :label-width="70">
                  <Input type="text" v-model="formRecord.c26" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td colspan="2" class="t_label">能效指数（%）</td>
              <td>
                <FormItem prop="c27" label="标称值:" :label-width="70">
                  <Input type="text" v-model="formRecord.c27" :disabled='disabledoff' placeholder="整数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c28" label="实测值:" :label-width="70">
                  <Input type="text" v-model="formRecord.c28" :disabled='disabledoff' placeholder="一位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c29" label="备注:" :label-width="70">
                  <Input type="text" v-model="formRecord.c29" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td colspan="2" class="t_label">总能量消耗的标准规定值（耗电量限定值）TECmax（kWh/24h）</td>
              <td colspan="3">
                <FormItem prop="c37">
                  <Input type="text" v-model="formRecord.c37" :disabled='disabledoff' placeholder="三位小数"/>
                </FormItem>
              </td>
            </tr>
          </table>
        </Card>
      </div>
      <div class="part part4">
        <Card :bordered="false">
          <h2>四、初始使用日期</h2>
          <FormItem prop="c31" label="备案标识开始使用日期" style="width:100%;">
            <DatePicker type="date" :Options="dataInit" style="width: 200px" v-model="formRecord.c31"></DatePicker>
          </FormItem>
        </Card>
      </div>
      <div class="part part5">
        <Card :bordered="false">
          <h2>五、其它信息</h2>
          <table id="table3">
            <tr>
              <td class="t_label"><span class="red">*</span>产品类型</td>
              <td colspan="3">
                <FormItem prop="c32">
                  <RadioGroup v-model="formRecord.c32">
                    <Radio label="陈列式商用冷柜" :disabled='disabledoff'></Radio>
                    <Radio label="饮料冷藏陈列柜" :disabled='disabledoff'></Radio>
                    <Radio label="实体门商用冷柜" :disabled='disabledoff'></Radio>
                    <Radio label="组合型商用冷柜" :disabled='disabledoff'></Radio>
                    <Radio label="其它" :disabled='disabledoff'></Radio>
                  </RadioGroup>
                </FormItem>
                <FormItem prop="c33">
                  <Input type="text" v-model="formRecord.c33" :disabled="disabledoff||formRecord.c32!='其它'"/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="t_label"><span class="red">*</span>独立间室数量(个)</td>
              <td colspan="3">
                <Select v-model="formRecord.c34" style="width:200px">
                  <Option value="1">1</Option>
                  <Option value="2">2</Option>
                  <Option value="3">3</Option>
                  <Option value="4">4</Option>
                </Select>
              </td>
            </tr>
            <tr>
              <td rowspan="10" class="t_label"><span class="red">*</span>间室1</td>
              <td colspan="3">
                <span class="red">*</span>系列代号:
                <Select v-model="formRecord.c35" style="width:200px">
                  <Option v-for="item in xldhOptions" :value="item.value" :key="item.value">{{ item.value }}</Option>
                </Select>
                <span class="red" style="margin-left:15px;">*</span>额定气候类型:
                <Select v-model="formRecord.c41" style="width:200px">
                  <Option v-for="item in qhlxOptions" :value="item.value" :key="item.value">{{ item.value }}</Option>
                </Select>
                <span class="red" style="margin-left:15px;">*</span>条件下的温度等级:
                <Select v-model="formRecord.c42" style="width:200px">
                  <Option v-for="item in wddjOptions" :value="item.value" :key="item.value">{{ item.value }}</Option>
                </Select>
              </td>
            </tr>
            <tr>
              <td class="t_label">最热M-包的最高温度</td>
              <td>
                <FormItem prop="c43" label="标准规定值:" :label-width="100" style="width:100%">
                  <Input type="text" v-model="formRecord.c43" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c44" label="实测值:" :label-width="70" style="width:100%">
                  <Input type="text" v-model="formRecord.c44" :disabled='disabledoff' placeholder="一位小数"/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="t_label">最冷（所有）M-包的最低温度</td>
              <td>
                <FormItem prop="c222" label="标准规定值:" :label-width="100" style="width:100%">
                  <Input type="text" v-model="formRecord.c222" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c223" label="实测值:" :label-width="70" style="width:100%">
                  <Input type="text" v-model="formRecord.c223" :disabled='disabledoff' placeholder="一位小数"/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td colspan="3">
                <span class="red" style="margin-left:15px;">*</span>能效检测气候类型:
                <Select v-model="formRecord.c45" style="width:200px">
                  <Option v-for="item in qhlxOptions" :value="item.value" :key="item.value">{{ item.value }}</Option>
                </Select>
                <span class="red" style="margin-left:15px;">*</span>条件下的温度等级:
                <Select v-model="formRecord.c46" style="width:200px">
                  <Option v-for="item in wddjOptions" :value="item.value" :key="item.value">{{ item.value }}</Option>
                </Select>
              </td>
            </tr>
            <tr>
              <td class="t_label">最热M-包的最高温度</td>
              <td>
                <FormItem prop="c224" label="标准规定值:" :label-width="100" style="width:100%">
                  <Input type="text" v-model="formRecord.c224" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c225" label="实测值:" :label-width="70" style="width:100%">
                  <Input type="text" v-model="formRecord.c225" :disabled='disabledoff' placeholder="一位小数"/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="t_label">最冷（所有）M-包的最低温度</td>
              <td>
                <FormItem prop="c47" label="标准规定值:" :label-width="100" style="width:100%">
                  <Input type="text" v-model="formRecord.c47" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c48" label="实测值:" :label-width="70" style="width:100%">
                  <Input type="text" v-model="formRecord.c48" :disabled='disabledoff' placeholder="一位小数"/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="t_label"><span class="red">*</span>基准耗电量Ebase（kWh/24h）(用实测展示面积计算)</td>
              <td colspan="2">
                <FormItem prop="c74" style="width:100%">
                  <Input type="text" v-model="formRecord.c74" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="t_label"><span class="red">*</span>能耗调整系数k</td>
              <td colspan="2">
                <FormItem prop="c79" style="width:100%">
                  <Input type="text" v-model="formRecord.c79" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="t_label"><span class="red">*</span>展示面积(实测值)</td>
              <td colspan="2">
                <FormItem prop="c243" style="width:100%">
                  <Input type="text" v-model="formRecord.c243" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="t_label"><span class="red">*</span>融霜方式</td>
              <td>
                <FormItem prop="c100">
                  <RadioGroup v-model="formRecord.c100">
                    <Radio label="敞开式" :disabled='disabledoff'></Radio>
                    <Radio label="封闭式" :disabled='disabledoff'></Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c218">
                  <RadioGroup v-model="formRecord.c218">
                    <Radio label="无自动融霜系统或自然化霜系统" :disabled='disabledoff||formRecord.c100!="封闭式"'></Radio>
                    <Radio label="自动加热融霜系统" :disabled='disabledoff||formRecord.c100!="封闭式"'></Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="t_label"><span class="red">*</span>额定电压（V）</td>
              <td>
                <FormItem prop="c83" style="width:100%">
                  <Input type="text" v-model="formRecord.c83" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td class="t_label"><span class="red">*</span>额定电流（A）</td>
              <td>
                <FormItem prop="c84" style="width:100%">
                  <Input type="text" v-model="formRecord.c84" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="t_label"><span class="red">*</span>额定频率（Hz）</td>
              <td>
                <FormItem prop="c85" style="width:100%">
                  <Input type="text" v-model="formRecord.c85" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td class="t_label"><span class="red">*</span>节流装置</td>
              <td>
                <FormItem prop="c93">
                  <RadioGroup v-model="formRecord.c93">
                    <Radio label="膨胀阀" :disabled='disabledoff'></Radio>
                    <Radio label="毛细管" :disabled='disabledoff'></Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="t_label" rowspan="5"><span class="red">*</span>功率（W）</td>
              <td class="t_label"><span class="red">*</span>额定功率(W):</td>
              <td colspan="2">
                <FormItem prop="c87" style="width:100%">
                  <Input type="text" v-model="formRecord.c87" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="t_label">融霜电加热功率(W)（如有）:</td>
              <td colspan="2">
                <FormItem prop="c88" style="width:100%">
                  <Input type="text" v-model="formRecord.c88" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="t_label">防凝露电加热功率(W)（如有）:</td>
              <td colspan="2">
                <FormItem prop="c89" style="width:100%">
                  <Input type="text" v-model="formRecord.c89" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="t_label">照明灯总功率(W)（如有）:</td>
              <td colspan="2">
                <FormItem prop="c90" style="width:100%">
                  <Input type="text" v-model="formRecord.c90" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="t_label">照明灯个数（如有）:</td>
              <td>
                <FormItem prop="c91" style="width:100%">
                  <Input type="text" v-model="formRecord.c91" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c92">
                  <CheckboxGroup v-model="formRecord.c92">
                    <Checkbox label="是" :disabled='disabledoff'>LED</Checkbox>
                  </CheckboxGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="t_label"><span class="red">*</span>是否附有夜盖（帘）</td>
              <td>
                <FormItem prop="c94">
                  <RadioGroup v-model="formRecord.c94">
                    <Radio label="有" :disabled='disabledoff'></Radio>
                    <Radio label="无" :disabled='disabledoff'></Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td class="t_label"><span class="red">*</span>是否有手动照明开关</td>
              <td>
                <FormItem prop="c95">
                  <RadioGroup v-model="formRecord.c95">
                    <Radio label="有" :disabled='disabledoff'></Radio>
                    <Radio label="无" :disabled='disabledoff'></Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="t_label"><span class="red">*</span>是否有时钟、智能感应器或<br>类似的自动化装置控制照明</td>
              <td>
                <FormItem prop="c96">
                  <RadioGroup v-model="formRecord.c96">
                    <Radio label="有" :disabled='disabledoff'></Radio>
                    <Radio label="无" :disabled='disabledoff'></Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td class="t_label"><span class="red">*</span>是否有时钟、智能感应器或<br>类似的自动化装置控制防凝露加热器</td>
              <td>
                <FormItem prop="c97">
                  <RadioGroup v-model="formRecord.c97">
                    <Radio label="有" :disabled='disabledoff'></Radio>
                    <Radio label="无" :disabled='disabledoff'></Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="t_label"><span class="red">*</span>是否为玻璃门（盖）式冷冻陈列柜</td>
              <td>
                <FormItem prop="c238">
                  <RadioGroup v-model="formRecord.c238">
                    <Radio label="有" :disabled='disabledoff'></Radio>
                    <Radio label="无" :disabled='disabledoff'></Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td colspan="2">
                <FormItem prop="c98">
                  <RadioGroup v-model="formRecord.c98">
                    <Radio label="有凝露面积" :disabled='disabledoff||formRecord.c238!="有"'>有凝露面积＞展示面积的5%</Radio>
                    <Radio label="无" :disabled='disabledoff||formRecord.c238!="有"'></Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="t_label">门（如有）</td>
              <td>
                <FormItem prop="c104">
                  <RadioGroup v-model="formRecord.c104">
                    <Radio label="实体" :disabled='disabledoff'></Radio>
                    <Radio label="玻璃" :disabled='disabledoff'></Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td class="t_label"><span class="red">*</span>围护结构</td>
              <td>
                <FormItem prop="c105">
                  <RadioGroup v-model="formRecord.c105">
                    <Radio label="实体" :disabled='disabledoff'></Radio>
                    <Radio label="玻璃" :disabled='disabledoff'></Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="t_label"><span class="red">*</span>蒸发器类型</td>
              <td>
                <FormItem prop="c106">
                  <RadioGroup v-model="formRecord.c106">
                    <Radio label="直冷" :disabled='disabledoff'></Radio>
                    <Radio label="风冷" :disabled='disabledoff'></Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td class="t_label"><span class="red">*</span>制冷剂/灌注量（g）</td>
              <td>
                <FormItem prop="c109" style="width:100%">
                  <Input type="text" v-model="formRecord.c109" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="t_label"><span class="red">*</span>保温层</td>
              <td colspan="3">
                <FormItem prop="c107">
                  <RadioGroup v-model="formRecord.c107">
                    <Radio label="聚氨酯" :disabled='disabledoff'></Radio>
                    <Radio label="聚苯乙烯" :disabled='disabledoff'></Radio>
                    <Radio label="真空隔热" :disabled='disabledoff'></Radio>
                    <Radio label="其它" :disabled='disabledoff'></Radio>
                  </RadioGroup>
                </FormItem>
                <FormItem prop="c108">
                  <Input type="text" v-model="formRecord.c108" :disabled="disabledoff||formRecord.c107!='其它'"/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="t_label"><span class="red">*</span>外形尺寸(长×宽×高)<br>(mm×mm×mm)</td>
              <td colspan="3">
                <FormItem prop="c110">
                  <Input type="text" v-model="formRecord.c110" :disabled='disabledoff'/>
                </FormItem>
                <span style="margin:0 10px;">×</span>
                <FormItem prop="c111">
                  <Input type="text" v-model="formRecord.c111" :disabled='disabledoff'/>
                </FormItem>
                <span style="margin:0 10px;">×</span>
                <FormItem prop="c112">
                  <Input type="text" v-model="formRecord.c112" :disabled='disabledoff'/>
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
              <th style="width:80px;">序号</th>
              <th>部件名称</th>
              <th colspan="2">规格型号</th>
              <th colspan="2" style="width:330px">技术参数</th>
              <th>生产者（全称）</th>
            </tr>
            <tr>
              <td rowspan="3" class="t_label">1</td>
              <td rowspan="3" class="t_label">压缩机</td>
              <td rowspan="3" colspan="2">
                <FormItem prop="c113" style="width:100%">
                  <Input type="text" v-model="formRecord.c113" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td class="t_label">功率(W)</td>
              <td>
                <FormItem prop="c114" style="width:100%">
                  <Input type="text" v-model="formRecord.c113" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td rowspan="3">
                <FormItem prop="c117" style="width:100%">
                  <Input type="text" v-model="formRecord.c117" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="t_label">制冷剂</td>
              <td>
                <FormItem prop="c115" style="width:100%">
                  <Input type="text" v-model="formRecord.c115" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="t_label">数量</td>
              <td>
                <FormItem prop="c116" style="width:100%">
                  <Input type="text" v-model="formRecord.c116" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td rowspan="3" class="t_label">2</td>
              <td rowspan="3" class="t_label">压缩机</td>
              <td rowspan="3" colspan="2">
                <FormItem prop="c162" style="width:100%">
                  <Input type="text" v-model="formRecord.c162" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td class="t_label">功率(W)</td>
              <td>
                <FormItem prop="c163" style="width:100%">
                  <Input type="text" v-model="formRecord.c163" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td rowspan="3">
                <FormItem prop="c166" style="width:100%">
                  <Input type="text" v-model="formRecord.c166" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="t_label">制冷剂</td>
              <td>
                <FormItem prop="c164" style="width:100%">
                  <Input type="text" v-model="formRecord.c164" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="t_label">数量</td>
              <td>
                <FormItem prop="c165" style="width:100%">
                  <Input type="text" v-model="formRecord.c165" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="t_label">3</td>
              <td class="t_label">冷凝器（如有）</td>
              <td colspan="2">
                <FormItem prop="c118" style="width:100%">
                  <Input type="text" v-model="formRecord.c118" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td class="t_label">换热表面积(m2)</td>
              <td>
                <FormItem prop="c119" style="width:100%">
                  <Input type="text" v-model="formRecord.c119" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c120" style="width:100%">
                  <Input type="text" v-model="formRecord.c120" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="t_label">4</td>
              <td class="t_label">冷凝器（如有）</td>
              <td colspan="2">
                <FormItem prop="c167" style="width:100%">
                  <Input type="text" v-model="formRecord.c167" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td class="t_label">换热表面积(m2)</td>
              <td>
                <FormItem prop="c168" style="width:100%">
                  <Input type="text" v-model="formRecord.c168" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c169" style="width:100%">
                  <Input type="text" v-model="formRecord.c169" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td rowspan="3" class="t_label">5</td>
              <td rowspan="3" class="t_label">冷凝器风机（如有）</td>
              <td class="t_label">风机整机型号</td>
              <td>
                <FormItem prop="c121" style="width:100%">
                  <Input type="text" v-model="formRecord.c121" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td class="t_label">叶轮直径(mm)</td>
              <td>
                <FormItem prop="c122" style="width:100%">
                  <Input type="text" v-model="formRecord.c122" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td rowspan="3">
                <FormItem prop="c127" style="width:100%">
                  <Input type="text" v-model="formRecord.c127" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="t_label">电机</td>
              <td>
                <FormItem prop="c123" style="width:100%">
                  <Input type="text" v-model="formRecord.c123" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td class="t_label">功率(W)</td>
              <td>
                <FormItem prop="c124" style="width:100%">
                  <Input type="text" v-model="formRecord.c124" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="t_label">扇叶</td>
              <td>
                <FormItem prop="c125" style="width:100%">
                  <Input type="text" v-model="formRecord.c125" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td class="t_label">数量</td>
              <td>
                <FormItem prop="c126" style="width:100%">
                  <Input type="text" v-model="formRecord.c126" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td rowspan="3" class="t_label">6</td>
              <td rowspan="3" class="t_label">冷凝器风机（如有）</td>
              <td class="t_label">风机整机型号</td>
              <td>
                <FormItem prop="c170" style="width:100%">
                  <Input type="text" v-model="formRecord.c121" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td class="t_label">叶轮直径(mm)</td>
              <td>
                <FormItem prop="c171" style="width:100%">
                  <Input type="text" v-model="formRecord.c171" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td rowspan="3">
                <FormItem prop="c176" style="width:100%">
                  <Input type="text" v-model="formRecord.c176" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="t_label">电机</td>
              <td>
                <FormItem prop="c172" style="width:100%">
                  <Input type="text" v-model="formRecord.c172" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td class="t_label">功率(W)</td>
              <td>
                <FormItem prop="c173" style="width:100%">
                  <Input type="text" v-model="formRecord.c173" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="t_label">扇叶</td>
              <td>
                <FormItem prop="c174" style="width:100%">
                  <Input type="text" v-model="formRecord.c174" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td class="t_label">数量</td>
              <td>
                <FormItem prop="c175" style="width:100%">
                  <Input type="text" v-model="formRecord.c175" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="t_label">7</td>
              <td class="t_label">蒸发器</td>
              <td colspan="2">
                <FormItem prop="c128" style="width:100%">
                  <Input type="text" v-model="formRecord.c128" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td class="t_label">换热表面积(m2)</td>
              <td>
                <FormItem prop="c129" style="width:100%">
                  <Input type="text" v-model="formRecord.c129" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c130" style="width:100%">
                  <Input type="text" v-model="formRecord.c130" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="t_label">8</td>
              <td class="t_label">蒸发器</td>
              <td colspan="2">
                <FormItem prop="c177" style="width:100%">
                  <Input type="text" v-model="formRecord.c177" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td class="t_label">换热表面积(m2)</td>
              <td>
                <FormItem prop="c178" style="width:100%">
                  <Input type="text" v-model="formRecord.c178" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c179" style="width:100%">
                  <Input type="text" v-model="formRecord.c179" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td rowspan="3" class="t_label">9</td>
              <td rowspan="3" class="t_label">蒸发器风机</td>
              <td class="t_label">风机整机型号</td>
              <td>
                <FormItem prop="c131" style="width:100%">
                  <Input type="text" v-model="formRecord.c131" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td class="t_label">叶轮直径(mm)</td>
              <td>
                <FormItem prop="c132" style="width:100%">
                  <Input type="text" v-model="formRecord.c132" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td rowspan="3">
                <FormItem prop="c137" style="width:100%">
                  <Input type="text" v-model="formRecord.c137" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="t_label">电机</td>
              <td>
                <FormItem prop="c133" style="width:100%">
                  <Input type="text" v-model="formRecord.c133" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td class="t_label">功率(W)</td>
              <td>
                <FormItem prop="c134" style="width:100%">
                  <Input type="text" v-model="formRecord.c134" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="t_label">扇叶</td>
              <td>
                <FormItem prop="c135" style="width:100%">
                  <Input type="text" v-model="formRecord.c135" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td class="t_label">数量</td>
              <td>
                <FormItem prop="c136" style="width:100%">
                  <Input type="text" v-model="formRecord.c136" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td rowspan="3" class="t_label">10</td>
              <td rowspan="3" class="t_label">蒸发器风机</td>
              <td class="t_label">风机整机型号</td>
              <td>
                <FormItem prop="c180" style="width:100%">
                  <Input type="text" v-model="formRecord.c180" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td class="t_label">叶轮直径(mm)</td>
              <td>
                <FormItem prop="c181" style="width:100%">
                  <Input type="text" v-model="formRecord.c181" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td rowspan="3">
                <FormItem prop="c186" style="width:100%">
                  <Input type="text" v-model="formRecord.c186" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="t_label">电机</td>
              <td>
                <FormItem prop="c182" style="width:100%">
                  <Input type="text" v-model="formRecord.c182" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td class="t_label">功率(W)</td>
              <td>
                <FormItem prop="c183" style="width:100%">
                  <Input type="text" v-model="formRecord.c183" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="t_label">扇叶</td>
              <td>
                <FormItem prop="c184" style="width:100%">
                  <Input type="text" v-model="formRecord.c184" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td class="t_label">数量</td>
              <td>
                <FormItem prop="c185" style="width:100%">
                  <Input type="text" v-model="formRecord.c185" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="t_label">11</td>
              <td class="t_label">节流装置</td>
              <td colspan="2">
                <FormItem prop="c138">
                  <CheckboxGroup v-model="formRecord.c138" class="overwrite1">
                    <Checkbox label="膨胀阀" :disabled='disabledoff' class="overwrite2"></Checkbox>
                    <Checkbox label="毛细管" :disabled='disabledoff' class="overwrite2"></Checkbox>
                  </CheckboxGroup>
                </FormItem>
              </td>
              <td class="t_label">膨胀阀芯</td>
              <td>
                <FormItem prop="c139" style="width:100%">
                  <Input type="text" v-model="formRecord.c139" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c140" style="width:100%">
                  <Input type="text" v-model="formRecord.c140" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="t_label">12</td>
              <td class="t_label">节流装置</td>
              <td colspan="2">
                <FormItem prop="c187">
                  <CheckboxGroup v-model="formRecord.c187" class="overwrite1">
                    <Checkbox label="膨胀阀" :disabled='disabledoff' class="overwrite2"></Checkbox>
                    <Checkbox label="毛细管" :disabled='disabledoff' class="overwrite2"></Checkbox>
                  </CheckboxGroup>
                </FormItem>
              </td>
              <td class="t_label">膨胀阀芯</td>
              <td>
                <FormItem prop="c188" style="width:100%">
                  <Input type="text" v-model="formRecord.c188" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c189" style="width:100%">
                  <Input type="text" v-model="formRecord.c189" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="t_label">13</td>
              <td class="t_label">融霜加热器（如有）</td>
              <td colspan="2">
                <FormItem prop="c141" style="width:100%">
                  <Input type="text" v-model="formRecord.c141" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td class="t_label">功率(W)</td>
              <td>
                <FormItem prop="c142" style="width:100%">
                  <Input type="text" v-model="formRecord.c142" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c143" style="width:100%">
                  <Input type="text" v-model="formRecord.c143" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="t_label">14</td>
              <td class="t_label">融霜加热器（如有）</td>
              <td colspan="2">
                <FormItem prop="c190" style="width:100%">
                  <Input type="text" v-model="formRecord.c190" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td class="t_label">功率(W)</td>
              <td>
                <FormItem prop="c191" style="width:100%">
                  <Input type="text" v-model="formRecord.c191" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c192" style="width:100%">
                  <Input type="text" v-model="formRecord.c192" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="t_label">15</td>
              <td class="t_label">防凝露加热器(如有)</td>
              <td colspan="2">
                <FormItem prop="c144" style="width:100%">
                  <Input type="text" v-model="formRecord.c144" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td class="t_label">功率(W)</td>
              <td>
                <FormItem prop="c145" style="width:100%">
                  <Input type="text" v-model="formRecord.c145" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c146" style="width:100%">
                  <Input type="text" v-model="formRecord.c146" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="t_label">16</td>
              <td class="t_label">防凝露加热器(如有)</td>
              <td colspan="2">
                <FormItem prop="c193" style="width:100%">
                  <Input type="text" v-model="formRecord.c193" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td class="t_label">功率(W)</td>
              <td>
                <FormItem prop="c194" style="width:100%">
                  <Input type="text" v-model="formRecord.c194" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c195" style="width:100%">
                  <Input type="text" v-model="formRecord.c195" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td rowspan="3" class="t_label">17</td>
              <td rowspan="3" class="t_label">照明灯(如有)</td>
              <td rowspan="3" colspan="2">
                <FormItem prop="c147" style="width:100%">
                  <Input type="text" v-model="formRecord.c147" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td class="t_label">功率(W)</td>
              <td>
                <FormItem prop="c148" style="width:100%">
                  <Input type="text" v-model="formRecord.c148" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td rowspan="3">
                <FormItem prop="c151" style="width:100%">
                  <Input type="text" v-model="formRecord.c151" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="t_label">类型</td>
              <td>
                <FormItem prop="c149" style="width:100%">
                  <Input type="text" v-model="formRecord.c149" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="t_label">数量</td>
              <td>
                <FormItem prop="c150" style="width:100%">
                  <Input type="text" v-model="formRecord.c150" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td rowspan="3" class="t_label">18</td>
              <td rowspan="3" class="t_label">照明灯(如有)</td>
              <td rowspan="3" colspan="2">
                <FormItem prop="c196" style="width:100%">
                  <Input type="text" v-model="formRecord.c196" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td class="t_label">功率(W)</td>
              <td>
                <FormItem prop="c197" style="width:100%">
                  <Input type="text" v-model="formRecord.c197" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td rowspan="3">
                <FormItem prop="c239" style="width:100%">
                  <Input type="text" v-model="formRecord.c239" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="t_label">类型</td>
              <td>
                <FormItem prop="c198" style="width:100%">
                  <Input type="text" v-model="formRecord.c198" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="t_label">数量</td>
              <td>
                <FormItem prop="c199" style="width:100%">
                  <Input type="text" v-model="formRecord.c199" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td rowspan="3" class="t_label">19</td>
              <td rowspan="3" class="t_label">夜帘(如有)</td>
              <td rowspan="3" colspan="2">
                <FormItem prop="c152" style="width:100%">
                  <Input type="text" v-model="formRecord.c152" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td class="t_label">厚度（mm）</td>
              <td>
                <FormItem prop="c153" style="width:100%">
                  <Input type="text" v-model="formRecord.c153" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td rowspan="3">
                <FormItem prop="c156" style="width:100%">
                  <Input type="text" v-model="formRecord.c156" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="t_label">材质</td>
              <td>
                <FormItem prop="c154" style="width:100%">
                  <Input type="text" v-model="formRecord.c154" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="t_label">个数</td>
              <td>
                <FormItem prop="c155" style="width:100%">
                  <Input type="text" v-model="formRecord.c155" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td rowspan="3" class="t_label">20</td>
              <td rowspan="3" class="t_label">夜帘(如有)</td>
              <td rowspan="3" colspan="2">
                <FormItem prop="c203" style="width:100%">
                  <Input type="text" v-model="formRecord.c203" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td class="t_label">厚度（mm）</td>
              <td>
                <FormItem prop="c204" style="width:100%">
                  <Input type="text" v-model="formRecord.c204" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td rowspan="3">
                <FormItem prop="c207" style="width:100%">
                  <Input type="text" v-model="formRecord.c207" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="t_label">材质</td>
              <td>
                <FormItem prop="c205" style="width:100%">
                  <Input type="text" v-model="formRecord.c205" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="t_label">个数</td>
              <td>
                <FormItem prop="c206" style="width:100%">
                  <Input type="text" v-model="formRecord.c206" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td rowspan="3" class="t_label">21</td>
              <td rowspan="3" class="t_label">门玻璃(如有)</td>
              <td rowspan="3" colspan="2">
                <FormItem prop="c157" style="width:100%">
                  <Input type="text" v-model="formRecord.c167" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td class="t_label">厚度（mm）</td>
              <td>
                <FormItem prop="c158" style="width:100%">
                  <Input type="text" v-model="formRecord.c158" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td rowspan="3">
                <FormItem prop="c161" style="width:100%">
                  <Input type="text" v-model="formRecord.c161" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="t_label">传热系数K</td>
              <td>
                <FormItem prop="c159" style="width:100%">
                  <Input type="text" v-model="formRecord.c159" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="t_label">可见光透射比</td>
              <td>
                <FormItem prop="c160" style="width:100%">
                  <Input type="text" v-model="formRecord.c160" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td rowspan="3" class="t_label">22</td>
              <td rowspan="3" class="t_label">门玻璃(如有)</td>
              <td rowspan="3" colspan="2">
                <FormItem prop="c208" style="width:100%">
                  <Input type="text" v-model="formRecord.c208" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td class="t_label">厚度（mm）</td>
              <td>
                <FormItem prop="c209" style="width:100%">
                  <Input type="text" v-model="formRecord.c209" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td rowspan="3">
                <FormItem prop="c212" style="width:100%">
                  <Input type="text" v-model="formRecord.c212" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="t_label">传热系数K</td>
              <td>
                <FormItem prop="c210" style="width:100%">
                  <Input type="text" v-model="formRecord.c210" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="t_label">可见光透射比</td>
              <td>
                <FormItem prop="c211" style="width:100%">
                  <Input type="text" v-model="formRecord.c211" :disabled='disabledoff'/>
                </FormItem>
              </td>
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
        公司生产的 <span class="f-brand">{{formRecord.c5}}</span>
        品牌的 <span class="f-model">{{pageType==='extend'?mainModel:formRecord.c4}}</span>
        型号的 <span class="f-product">自携冷凝机组商用冷柜 2015版</span>产品{{pageType==="update"?'已通过能效标识备案':''}}。
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
    oneDecimals,
    threeDecimals,
    twoDecimals,
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
      const timeDate = parseInt(this.$store.state.app.dateinit);
      return {
        thisDateCV: "c31",// 当前初始使用日期 对应的C值
        thisLevelCV: "c30",// 当前能效等级 对应的C值
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
        mainModel: '',
        formRecord: {
          ec_master_kuozhan_text: '',
          c1: '',
          c2: '',
          c3: '',
          c4: '',
          c5: '',
          c200: '',
          c30: '1',
          c6: '',
          c7: '',
          c8: '',
          c9: '',
          c10: '',
          c11: '',
          c214: '（L）',
          c15: '',
          c16: '',
          c17: '',
          c215: '',
          c18: '',
          c19: '',
          c20: '',
          c216: '',
          c21: '',
          c22: '',
          c23: '',
          c217: '',
          c24: '',
          c25: '',
          c26: '',
          c27: '',
          c28: '',
          c29: '',
          c37: '',
          c31: new Date(),
          c32: '',
          c33: '',
          c34: [],
          c35: [],
          c41: [],
          c42: [],
          c43: '',
          c44: '',
          c222: '',
          c223: '',
          c45: '0',
          c46: 'M1',
          c224: '',
          c225: '',
          c47: '',
          c48: '',
          c74: '',
          c79: '',
          c243: '',
          c100: '',
          c218: '',
          c83: '',
          c84: '',
          c85: '',
          c93: '',
          c87: '',
          c88: '',
          c89: '',
          c90: '',
          c91: '',
          c92: [],
          c94: '',
          c95: '',
          c96: '',
          c97: '',
          c238: '',
          c98: '',
          c104: '',
          c105: '',
          c106: '',
          c109: '',
          c107: '',
          c108: '',
          c110: '',
          c111: '',
          c112: '',
          c113: '',
          c114: '',
          c115: '',
          c116: '',
          c117: '',
          c162: '',
          c163: '',
          c164: '',
          c165: '',
          c166: '',
          c118: '',
          c119: '',
          c120: '',
          c167: '',
          c168: '',
          c169: '',
          c121: '',
          c123: '',
          c125: '',
          c122: '',
          c124: '',
          c126: '',
          c127: '',
          c170: '',
          c172: '',
          c174: '',
          c171: '',
          c173: '',
          c175: '',
          c176: '',
          c128: '',
          c129: '',
          c130: '',
          c177: '',
          c178: '',
          c179: '',
          c131: '',
          c133: '',
          c135: '',
          c132: '',
          c134: '',
          c136: '',
          c137: '',
          c180: '',
          c182: '',
          c184: '',
          c181: '',
          c183: '',
          c185: '',
          c186: '',
          c138: [],
          c139: '',
          c140: '',
          c187: [],
          c188: '',
          c189: '',
          c141: '',
          c142: '',
          c143: '',
          c190: '',
          c191: '',
          c192: '',
          c144: '',
          c145: '',
          c146: '',
          c193: '',
          c194: '',
          c195: '',
          c147: '',
          c148: '',
          c149: '',
          c150: '',
          c151: '',
          c196: '',
          c197: '',
          c198: '',
          c199: '',
          c239: '',
          c152: '',
          c153: '',
          c154: '',
          c155: '',
          c156: '',
          c203: '',
          c204: '',
          c205: '',
          c206: '',
          c207: '',
          c157: '',
          c158: '',
          c159: '',
          c160: '',
          c161: '',
          c208: '',
          c209: '',
          c210: '',
          c211: '',
          c212: '',
          c202: '',
          ec_model_no: 54,
          attach_list: ''
        },
        /* 下拉框相关 */
        xldhOptions: [
          {value: "HC1"}, {value: "HC2"}, {value: "HC3"}, {value: "HC4"},
          {value: "HC5-1"}, {value: "HC5-2"}, {value: "HC5-3"},
          {value: "HC6-1"}, {value: "HC6-2"}, {value: "HC6-3"},
          {value: "HC7"},
          {value: "HC8"},
          {value: "VC1"}, {value: "VC2"}, {value: "VC3"}, {value: "VC4"},
          {value: "YC1"}, {value: "YC2"}, {value: "YC3"}, {value: "YC4"},
          {value: "HF1"}, {value: "HF2"}, {value: "HF3"}, {value: "HF4"},
          {value: "HF5-1"}, {value: "HF5-2"}, {value: "HF5-3"},
          {value: "HF6-1"}, {value: "HF6-2"}, {value: "HF6-3"},
          {value: "HF7"},
          {value: "VF1"}, {value: "VF2"}, {value: "VF3"}, {value: "VF4"},
          {value: "YF1"}, {value: "YF2"}, {value: "YF3"}, {value: "YF4"},
          {value: "VC5"},
          {value: "HC9"},
          {value: "VF5"},
          {value: "HF9"}
        ],
        qhlxOptions: [
          {value: "0"}, {value: "1"}, {value: "2"}, {value: "3"}, {value: "4"}, {value: "5"}, {value: "6"}, {value: "7"}, {value: "8"}, {value: "9"}, {value: "10"}
        ],
        wddjOptions: [
          {value: "M1"}, {value: "M2"},
          {value: "H1"}, {value: "H2"},
          {value: "L1"}, {value: "L2"}, {value: "L3"},
          {value: "HA"},
          {value: "VHA"},
          {value: "L4"},
          {value: "L5"},
          {value: "S"},
          {value: "H3"}
        ]
      }
    },
    mounted() {
      //this.disabledoff=(this.$store.state.app.pageType == "extend" ? true : false)
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
        let _c6 = parseFloat(this.formRecord.c6);
        let _c7 = parseFloat(this.formRecord.c7);
        let _nxzs = this.formRecord.c27;//能效指数
        let _nxdj = this.formRecord.c30;//能效等级

        /**一、以下为检测函数 */
        /**1.1 */
        let checkC6C7 = (rule, value, callback) => {
          let _msg = null
          if (_c6 && _c7) {
            try {
              if (_c7 > (parseFloat(_c6) * 1.05)) {
                _msg = "总能量消耗实测值不能大于标称值(额定值)的105%！";
              }
            } catch (e) {
            }
          }
          if (_msg) callback(_msg);
          else callback();
        }
        let check_C27C30 = (rule, value, callback) => {
          let _msg = "";

          var nxdj = 0
          if (_nxzs <= 55) nxdj = 1; else if (55 < _nxzs && _nxzs <= 65) nxdj = 2; else if (65 < _nxzs && _nxzs <= 80) nxdj = 3; else if (80 < _nxzs && _nxzs <= 90) nxdj = 4; else if (90 < _nxzs && _nxzs <= 100) nxdj = 5;

          if (nxdj == 0) _msg = "能效数据不在备案范围"; else if (_nxdj != nxdj) _msg = "能效数据不在备案范围";

          if (_msg) callback(_msg);
          else callback();
        }

        return {
          c2: [{
            required: true, message: '请填写制造单位', trigger: 'change,blur'
          }],
          c3: [{
            required: true, message: '请填写备案方', trigger: 'change,blur'
          }],
          c4: [{
            required: true, message: '请填写规格型号', trigger: 'change,blur'
          }],
          c5: [{
            required: true, message: '请填写商标', trigger: 'change,blur'
          }],
          c30: [{
            required: true, message: '请选择能效等级', trigger: 'change,blur'
          }, {
            validator: check_C27C30, trigger: 'change,blur'
          }],
          c6: [{
            required: true, message: '请输入总能量消耗标称值', trigger: 'change,blur'
          }, {
            validator: twoDecimals, trigger: 'change,blur'
          }, {
            validator: checkC6C7, trigger: 'change,blur'
          }],
          c7: [{
            required: true, message: '请输入总能量消耗实测值', trigger: 'change,blur'
          }, {
            validator: atLeastThreeDecimals, trigger: 'change,blur'
          }, {
            validator: checkC6C7, trigger: 'change,blur'
          }],
          c9: [{
            validator: twoDecimals, trigger: 'change,blur'
          }],
          c10: [{
            validator: atLeastTwoDecimals, trigger: 'change,blur'
          }],
          c15: [{
            required: true, message: '请输入间室净容积标称值', trigger: 'change,blur'
          }, {
            validator: this.formRecord.c214 == "（L）" ? isInteger : (
              this.formRecord.c214 == "（m³）" ? atLeastThreeDecimals : ""
            ),
            trigger: 'change,blur'
          }],
          c16: [{
            required: true, message: '请输入间室净容积实际值', trigger: 'change,blur'
          }, {
            validator: this.formRecord.c214 == "（L）" ? atLeastOneDecimals : (
              this.formRecord.c214 == "（m³）" ? atLeastFourDecimals : ""
            ),
            trigger: 'change,blur'
          }],
          c18: [{
            validator: this.formRecord.c215 == "（L）" ? isInteger : (
              this.formRecord.c215 == "（m³）" ? atLeastThreeDecimals : ""
            ),
            trigger: 'change,blur'
          }],
          c19: [{
            validator: this.formRecord.c215 == "（L）" ? atLeastOneDecimals : (
              this.formRecord.c215 == "（m³）" ? atLeastFourDecimals : ""
            ),
            trigger: 'change,blur'
          }],
          c21: [{
            validator: this.formRecord.c216 == "（L）" ? isInteger : (
              this.formRecord.c216 == "（m³）" ? atLeastThreeDecimals : ""
            ),
            trigger: 'change,blur'
          }],
          c22: [{
            validator: this.formRecord.c216 == "（L）" ? atLeastOneDecimals : (
              this.formRecord.c216 == "（m³）" ? atLeastFourDecimals : ""
            ),
            trigger: 'change,blur'
          }],
          c24: [{
            validator: this.formRecord.c217 == "（L）" ? isInteger : (
              this.formRecord.c217 == "（m³）" ? atLeastThreeDecimals : ""
            ),
            trigger: 'change,blur'
          }],
          c25: [{
            validator: this.formRecord.c217 == "（L）" ? atLeastOneDecimals : (
              this.formRecord.c217 == "（m³）" ? atLeastFourDecimals : ""
            ),
            trigger: 'change,blur'
          }],
          c27: [{
            required: true, message: '请输入能效指数标称值', trigger: 'change,blur'
          }, {
            validator: (isInteger, check_C27C30), trigger: 'change,blur'
          }],
          c28: [{
            required: true, message: '请输入能效指数实际值', trigger: 'change,blur'
          }, {
            validator: atLeastOneDecimals, trigger: 'change,blur'
          }],
          c37: [{
            required: true, message: '请输入总能量消耗的标准规定值', trigger: 'change,blur'
          }, {
            validator: atLeastThreeDecimals, trigger: 'change,blur'
          }],
          c31: [{
            required: true, message: '备案标识开始使用日期不能为空'
          }],
          c32: [{
            required: true, message: '请选择产品类型', trigger: 'change,blur'
          }],
          c33: [{
            required: this.formRecord.c32 == '其它', message: '请输入其它产品类型'
          }],
          c34: [{
            required: true, message: '请选择独立间室数量', trigger: 'change,blur'
          }],
          c35: [{
            required: true, message: '请选择间室系列代号', trigger: 'change,blur'
          }],
          c41: [{
            required: true, message: '请选择额定气候类型', trigger: 'change,blur'
          }],
          c42: [{
            required: true, message: '请选择条件下的温度等级', trigger: 'change,blur'
          }],
          c43: [{
            required: true, message: '请输入标准规定值', trigger: 'change,blur'
          }],
          c44: [{
            required: true, message: '请输入实测值', trigger: 'change,blur'
          }, {
            validator: oneDecimals, trigger: 'change,blur'
          }],
          c222: [{
            required: true, message: '请输入标准规定值', trigger: 'change,blur'
          }],
          c223: [{
            required: true, message: '请输入实测值', trigger: 'change,blur'
          }, {
            validator: oneDecimals, trigger: 'change,blur'
          }],
          c45: [{
            required: true, message: '请选择额定气候类型', trigger: 'change,blur'
          }],
          c46: [{
            required: true, message: '请选择条件下的温度等级', trigger: 'change,blur'
          }],
          c224: [{
            required: true, message: '请输入标准规定值', trigger: 'change,blur'
          }],
          c225: [{
            required: true, message: '请输入实测值', trigger: 'change,blur'
          }, {
            validator: oneDecimals, trigger: 'change,blur'
          }],
          c47: [{
            required: true, message: '请输入标准规定值', trigger: 'change,blur'
          }],
          c48: [{
            required: true, message: '请输入实测值', trigger: 'change,blur'
          }, {
            validator: oneDecimals, trigger: 'change,blur'
          }],
          c74: [{
            required: true, message: '请输入基准耗电量', trigger: 'change,blur'
          }],
          c79: [{
            required: true, message: '请输入能耗调整系数k', trigger: 'change,blur'
          }],
          c243: [{
            required: true, message: '请输入展示面积(实测值)', trigger: 'change,blur'
          }],
          c100: [{
            required: true, message: '请选择融霜方式', trigger: 'change'
          }, {
            trigger: 'change',
            validator: this.formRecord.c100 == '敞开式' ? this.formRecord.c218 = "" : ""
          }],
          c83: [{
            required: true, message: '请输入额定电压', trigger: 'change,blur'
          }],
          c84: [{
            required: true, message: '请输入额定电流', trigger: 'change,blur'
          }],
          c85: [{
            required: true, message: '请输入额定频率', trigger: 'change,blur'
          }],
          c93: [{
            required: true, message: '请选择节流装置', trigger: 'change,blur'
          }],
          c87: [{
            required: true, message: '请输入额定功率', trigger: 'change,blur'
          }],
          c94: [{
            required: true, message: '请选择', trigger: 'change,blur'
          }],
          c95: [{
            required: true, message: '请选择', trigger: 'change,blur'
          }],
          c96: [{
            required: true, message: '请选择', trigger: 'change,blur'
          }],
          c97: [{
            required: true, message: '请选择', trigger: 'change,blur'
          }],
          c238: [{
            required: true, message: '请选择', trigger: 'change,blur'
          }, {
            trigger: 'change,blur',
            validator: this.formRecord.c238 == '无' ? this.formRecord.c218 = "" : ""
          }],
          c105: [{
            required: true, message: '请选择', trigger: 'change,blur'
          }],
          c106: [{
            required: true, message: '请选择', trigger: 'change,blur'
          }],
          c109: [{
            required: true, message: '请输入制冷剂/灌注量', trigger: 'change,blur'
          }],
          c107: [{
            required: true, message: '请选择保温层', trigger: 'change,blur'
          }],
          c108: [{
            required: this.formRecord.c107 == '其它', message: '请输入其它保温层'
          }],
          c110: [{
            required: true, message: '请输入长', trigger: 'change,blur'
          }],
          c111: [{
            required: true, message: '请输入宽', trigger: 'change,blur'
          }],
          c112: [{
            required: true, message: '请输入高', trigger: 'change,blur'
          }]
        }
      }
    }
  }
</script>
<style lang="less" scoped>
  @import '../../../css/comm.css';

  .overwrite1 /deep/ span {
    width: auto !important;
  }
  .overwrite2 /deep/ .ivu-checkbox-inner{
    width: 14px !important;
  }

</style>
