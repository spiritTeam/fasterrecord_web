/*
* 24、水（地）源热泵机组 2014版
* 创建日期:2019年6月19日
* 创建人:WH
*/
<template>
  <div class="wrapper">
    <Form ref="formRecord" :model="formRecord" label-position="right" :rules="ruleRecord">
      <h1>水(地)源热泵机组2014版-能源效率标识备案表</h1>
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
          <FormItem prop="c4" label="产品规格型号" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c4" :disabled='!disabledoff' placeholder="规格型号"/>
          </FormItem>
          <FormItem prop="c2" label="商标" style="width:100%" :label-width="180">
            <Input type="text" v-model="formRecord.c2" :disabled='pageType=="view"' placeholder="商标"/>
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
          <FormItem prop="c8" label="类型" style="width:100%;" :label-width="180">
            <Select v-model="formRecord.c8" style="width:200px">
              <Option value="冷热风型">冷热风型</Option>
              <Option value="冷热水型">冷热水型</Option>
            </Select>
          </FormItem>
          <div class="ivu-form-item ivu-form-item-required ivu-form-item-error"
               v-if="checkComplex!='' && pageType !='extend'">
            <div class="ivu-form-item-content" style="margin-left:100px;">
              <div class="ivu-form-item-error-tip">{{checkComplex}}</div>
            </div>
          </div>
          <table id="table1">
            <tr>
              <th>项目</th>
              <th width="200">单位</th>
              <th><i class="red">*</i>额定值</th>
              <th><i class="red">*</i>实测值</th>
              <th>备注</th>
            </tr>
            <tr>
              <td>全年综合性能系数/(W/W)</td>
              <td>/</td>
              <td>
                <FormItem prop="c9">
                  <Input type="text" v-model="formRecord.c9" :disabled='pageType=="view"' placeholder="两位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c10">
                  <Input type="text" v-model="formRecord.c10" :disabled='pageType=="view"' placeholder="三位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c11">
                  <Input type="text" v-model="formRecord.c11" :disabled='pageType=="view"'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>名义制冷量</td>
              <td>
                <FormItem prop="c49">
                  <RadioGroup v-model="formRecord.c49">
                    <Radio label="kW" :disabled='pageType=="view"'></Radio>
                    <Radio label="W" :disabled='pageType=="view"'></Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c12">
                  <Input type="text" v-model="formRecord.c12" :disabled='pageType=="view"'
                         :placeholder='formRecord.c49=="kW"?"一位小数":"整数"'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c13">
                  <Input type="text" v-model="formRecord.c13" :disabled='pageType=="view"'
                         :placeholder='formRecord.c49=="kW"?"至少两位小数":"至少一位小数"'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c14">
                  <Input type="text" v-model="formRecord.c11" :disabled='pageType=="view"'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>名义制冷消耗功率</td>
              <td>
                <FormItem prop="c50">
                  <RadioGroup v-model="formRecord.c50">
                    <Radio label="kW" :disabled='pageType=="view"'></Radio>
                    <Radio label="W" :disabled='pageType=="view"'></Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c15">
                  <Input type="text" v-model="formRecord.c15" :disabled='pageType=="view"'
                         :placeholder='formRecord.c50=="kW"?"一位小数":"整数"'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c16">
                  <Input type="text" v-model="formRecord.c16" :disabled='pageType=="view"'
                         :placeholder='formRecord.c50=="kW"?"至少两位小数":"至少一位小数"'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c17">
                  <Input type="text" v-model="formRecord.c17" :disabled='pageType=="view"'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>名义制热量</td>
              <td>
                <FormItem prop="c51">
                  <RadioGroup v-model="formRecord.c51">
                    <Radio label="kW" :disabled='pageType=="view"'></Radio>
                    <Radio label="W" :disabled='pageType=="view"'></Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c18">
                  <Input type="text" v-model="formRecord.c18" :disabled='pageType=="view"'
                         :placeholder='formRecord.c51=="kW"?"一位小数":"整数"'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c19">
                  <Input type="text" v-model="formRecord.c19" :disabled='pageType=="view"'
                         :placeholder='formRecord.c51=="kW"?"至少两位小数":"至少一位小数"'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c20">
                  <Input type="text" v-model="formRecord.c11" :disabled='pageType=="view"'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>名义制热消耗功率</td>
              <td>
                <FormItem prop="c52">
                  <RadioGroup v-model="formRecord.c52">
                    <Radio label="kW" :disabled='pageType=="view"'></Radio>
                    <Radio label="W" :disabled='pageType=="view"'></Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c21">
                  <Input type="text" v-model="formRecord.c21" :disabled='pageType=="view"'
                         :placeholder='formRecord.c52=="kW"?"一位小数":"整数"'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c22">
                  <Input type="text" v-model="formRecord.c22" :disabled='pageType=="view"'
                         :placeholder='formRecord.c52=="kW"?"至少两位小数":"至少一位小数"'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c23">
                  <Input type="text" v-model="formRecord.c11" :disabled='pageType=="view"'/>
                </FormItem>
              </td>
            </tr>
          </table>
        </Card>
      </div>
      <div class="part part4">
        <Card :bordered="false">
          <h2>四、初始使用日期</h2>
          <FormItem prop="c24" label="备案标识开始使用日期" style="width:100%;">
            <DatePicker type="date" :Options="dataInit" style="width: 200px" v-model="formRecord.c24"></DatePicker>
          </FormItem>
        </Card>
      </div>
      <div class="part part5">
        <Card :bordered="false">
          <h2>五、样品描述</h2>
          <table id="table3">
            <tr>
              <td><span class="red">*</span>机器类型</td>
              <td colspan="3">
                <FormItem prop="c25">
                  <RadioGroup v-model="formRecord.c25">
                    <Radio label="冷热风型" :disabled='disabledoff'></Radio>
                    <Radio label="冷热水型" :disabled='disabledoff'></Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td><span class="red">*</span>冷(热)源类型</td>
              <td colspan="3">
                <FormItem prop="c26">
                  <CheckboxGroup v-model="formRecord.c26">
                    <Checkbox label="水环式" :disabled='disabledoff'></Checkbox>
                    <Checkbox label="地下水式" :disabled='disabledoff'></Checkbox>
                    <Checkbox label="地埋管式" :disabled='disabledoff'></Checkbox>
                    <Checkbox label="地表水式" :disabled='disabledoff'></Checkbox>
                  </CheckboxGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td><span class="red">*</span>结构形式</td>
              <td colspan="3">
                <FormItem prop="c27">
                  <RadioGroup v-model="formRecord.c27">
                    <Radio label="整体式" :disabled='disabledoff'></Radio>
                    <Radio label="分体式" :disabled='disabledoff'></Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td><span class="red">*</span>换热器(水/制冷剂)</td>
              <td colspan="3">
                <FormItem prop="c28">
                  <CheckboxGroup v-model="formRecord.c28">
                    <Checkbox label="板式" :disabled='disabledoff'></Checkbox>
                    <Checkbox label="套管式" :disabled='disabledoff'></Checkbox>
                    <Checkbox label="壳管式" :disabled='disabledoff'></Checkbox>
                    <Checkbox label="其它" :disabled='disabledoff'></Checkbox>
                  </CheckboxGroup>
                </FormItem>
                <FormItem prop="c29">
                  <Input type="text" style="width:200px;" v-model="formRecord.c29"
                         :disabled="disabledoff||formRecord.c28.join('').indexOf('其它')==-1"/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td><span class="red">*</span>节流装置</td>
              <td colspan="3">
                <FormItem prop="c30">
                  <CheckboxGroup v-model="formRecord.c30">
                    <Checkbox label="电子膨胀阀" :disabled='disabledoff'></Checkbox>
                    <Checkbox label="热力膨胀阀" :disabled='disabledoff'></Checkbox>
                    <Checkbox label="电动调节阀" :disabled='disabledoff'></Checkbox>
                    <Checkbox label="毛细管" :disabled='disabledoff'></Checkbox>
                    <Checkbox label="其它" :disabled='disabledoff'></Checkbox>
                  </CheckboxGroup>
                </FormItem>
                <FormItem prop="c31">
                  <Input type="text" v-model="formRecord.c31"
                         :disabled="disabledoff||formRecord.c30.join('').indexOf('其它')==-1"/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td><span class="red">*</span>模块化</td>
              <td>
                <FormItem prop="c32">
                  <RadioGroup v-model="formRecord.c32">
                    <Radio label="是" :disabled='disabledoff'></Radio>
                    <Radio label="否" :disabled='disabledoff'></Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td><span class="red">*</span>部分负荷运行</td>
              <td>
                <FormItem prop="c33">
                  <RadioGroup v-model="formRecord.c33">
                    <Radio label="可以" :disabled='disabledoff'></Radio>
                    <Radio label="不可以" :disabled='disabledoff'></Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td><span class="red">*</span>油分离器</td>
              <td>
                <FormItem prop="c34">
                  <RadioGroup v-model="formRecord.c34">
                    <Radio label="有" :disabled='disabledoff'></Radio>
                    <Radio label="无" :disabled='disabledoff'></Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td><span class="red">*</span>储液器</td>
              <td>
                <FormItem prop="c35">
                  <RadioGroup v-model="formRecord.c35">
                    <Radio label="有" :disabled='disabledoff'></Radio>
                    <Radio label="无" :disabled='disabledoff'></Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td><span class="red">*</span>辅助电加热器</td>
              <td colspan="3">
                <FormItem prop="c36">
                  <RadioGroup v-model="formRecord.c36">
                    <Radio label="有" :disabled='disabledoff'></Radio>
                    <Radio label="无" :disabled='disabledoff'></Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td><span class="red">*</span>控制类型</td>
              <td colspan="3">
                <FormItem prop="c37">
                  <RadioGroup v-model="formRecord.c37">
                    <Radio label="单片机" :disabled='disabledoff'></Radio>
                    <Radio label="可编程(PLC)控制" :disabled='disabledoff'></Radio>
                    <Radio label="其它" :disabled='disabledoff'></Radio>
                  </RadioGroup>
                </FormItem>
                <FormItem prop="c38">
                  <Input type="text" v-model="formRecord.c38" :disabled="disabledoff||formRecord.c37!='其它'"/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td><span class="red">*</span>电源类型</td>
              <td colspan="3">
                <FormItem prop="c39">
                  <RadioGroup v-model="formRecord.c39">
                    <Radio label="交流220V" :disabled='disabledoff'></Radio>
                    <Radio label="交流380V" :disabled='disabledoff'></Radio>
                    <Radio label="交流6000V" :disabled='disabledoff'></Radio>
                    <Radio label="交流10000V" :disabled='disabledoff'></Radio>
                    <Radio label="其它" :disabled='disabledoff'></Radio>
                  </RadioGroup>
                </FormItem>
                <FormItem prop="c40">
                  <Input type="text" v-model="formRecord.c40" :disabled="disabledoff||formRecord.c39!='其它'"/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td><span class="red">*</span>制冷剂</td>
              <td>
                <FormItem prop="c41">
                  <Input type="text" v-model="formRecord.c41" :disabled="disabledoff"/>
                </FormItem>
              </td>
              <td><span class="red">*</span>灌注量(kg)</td>
              <td>
                <FormItem prop="c45">
                  <Input type="text" v-model="formRecord.c45" :disabled="disabledoff"/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td><span class="red">*</span>整体或室外机外形尺寸<br/>(长×宽×高)(mm×mm×mm)</td>
              <td>
                <FormItem prop="c42" style="width:90px;">
                  <Input type="text" v-model="formRecord.c42" :disabled='disabledoff'/>
                </FormItem>
                <FormItem>×</FormItem>
                <FormItem prop="c43" style="width:90px;">
                  <Input type="text" v-model="formRecord.c43" :disabled='disabledoff'/>
                </FormItem>
                <FormItem>×</FormItem>
                <FormItem prop="c44" style="width:90px;">
                  <Input type="text" v-model="formRecord.c44" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td><span class="red">*</span>室内机外形尺寸<br/>(长×宽×高)(mm×mm×mm)</td>
              <td>
                <FormItem prop="c46" style="width:90px;">
                  <Input type="text" v-model="formRecord.c46" :disabled='disabledoff'/>
                </FormItem>
                <FormItem>×</FormItem>
                <FormItem prop="c47" style="width:90px;">
                  <Input type="text" v-model="formRecord.c47" :disabled='disabledoff'/>
                </FormItem>
                <FormItem>×</FormItem>
                <FormItem prop="c48" style="width:90px;">
                  <Input type="text" v-model="formRecord.c48" :disabled='disabledoff'/>
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
              <th style="width:5%">序号</th>
              <th style="width:10%">部件名称</th>
              <th style="width:15%">型号规格</th>
              <th style="width:*" colspan="3">技术参数</th>
              <th style="width:15%">生产者（全称）</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td rowspan="4">1</td>
              <td rowspan="4">压缩机</td>
              <td style="text-align:center">具体型号</td>
              <td style="text-align:center">制冷量（瓦）</td>
              <td style="text-align:center">输入功率（瓦）</td>
              <td style="text-align:center">COP值</td>
              <td style="text-align:center">/</td>
            </tr>
            <tr>
              <td>
                <FormItem prop="c53" style="width:100%">
                  <Input type="text" v-model="formRecord.c53" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c54" style="width:100%">
                  <Input type="text" v-model="formRecord.c54" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c55" style="width:100%">
                  <Input type="text" v-model="formRecord.c55" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c56" style="width:100%">
                  <Input type="text" v-model="formRecord.c56" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c57" style="width:100%">
                  <Input type="text" v-model="formRecord.c57" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>
                <FormItem prop="c58" style="width:100%">
                  <Input type="text" v-model="formRecord.c58" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c59" style="width:100%">
                  <Input type="text" v-model="formRecord.c59" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c60" style="width:100%">
                  <Input type="text" v-model="formRecord.c60" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c61" style="width:100%">
                  <Input type="text" v-model="formRecord.c61" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c62" style="width:100%">
                  <Input type="text" v-model="formRecord.c62" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>
                <FormItem prop="c63" style="width:100%">
                  <Input type="text" v-model="formRecord.c63" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c64" style="width:100%">
                  <Input type="text" v-model="formRecord.c64" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c65" style="width:100%">
                  <Input type="text" v-model="formRecord.c65" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c66" style="width:100%">
                  <Input type="text" v-model="formRecord.c66" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c67" style="width:100%">
                  <Input type="text" v-model="formRecord.c67" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td rowspan="4">2</td>
              <td rowspan="4">风机</td>
              <td style="text-align:center">具体型号</td>
              <td style="text-align:center">风量（m3/h）</td>
              <td style="text-align:center">全压（Pa）</td>
              <td style="text-align:center">静压（Pa）</td>
              <td style="text-align:center">/</td>
            </tr>
            <tr>
              <td>
                <FormItem prop="c68" style="width:100%">
                  <Input type="text" v-model="formRecord.c68" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c69" style="width:100%">
                  <Input type="text" v-model="formRecord.c69" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c70" style="width:100%">
                  <Input type="text" v-model="formRecord.c70" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c71" style="width:100%">
                  <Input type="text" v-model="formRecord.c71" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c72" style="width:100%">
                  <Input type="text" v-model="formRecord.c72" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>
                <FormItem prop="c73" style="width:100%">
                  <Input type="text" v-model="formRecord.c73" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c74" style="width:100%">
                  <Input type="text" v-model="formRecord.c74" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c75" style="width:100%">
                  <Input type="text" v-model="formRecord.c75" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c76" style="width:100%">
                  <Input type="text" v-model="formRecord.c76" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c77" style="width:100%">
                  <Input type="text" v-model="formRecord.c77" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>
                <FormItem prop="c78" style="width:100%">
                  <Input type="text" v-model="formRecord.c78" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c79" style="width:100%">
                  <Input type="text" v-model="formRecord.c79" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c80" style="width:100%">
                  <Input type="text" v-model="formRecord.c80" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c81" style="width:100%">
                  <Input type="text" v-model="formRecord.c81" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c82" style="width:100%">
                  <Input type="text" v-model="formRecord.c82" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td rowspan="4">3</td>
              <td rowspan="4">换热器（水）</td>
              <td style="text-align:center">具体型号</td>
              <td style="text-align:center">换热管内表面积（m2）</td>
              <td style="text-align:center">换热器形式</td>
              <td style="text-align:center">/</td>
              <td style="text-align:center">/</td>
            </tr>
            <tr>
              <td>
                <FormItem prop="c83" style="width:100%">
                  <Input type="text" v-model="formRecord.c83" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c84" style="width:100%">
                  <Input type="text" v-model="formRecord.c84" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c85" style="width:100%">
                  <Input type="text" v-model="formRecord.c85" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c86" style="width:100%">
                  <Input type="text" v-model="formRecord.c86" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c87" style="width:100%">
                  <Input type="text" v-model="formRecord.c87" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>
                <FormItem prop="c88" style="width:100%">
                  <Input type="text" v-model="formRecord.c88" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c89" style="width:100%">
                  <Input type="text" v-model="formRecord.c89" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c90" style="width:100%">
                  <Input type="text" v-model="formRecord.c90" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c91" style="width:100%">
                  <Input type="text" v-model="formRecord.c91" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c92" style="width:100%">
                  <Input type="text" v-model="formRecord.c92" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>
                <FormItem prop="c93" style="width:100%">
                  <Input type="text" v-model="formRecord.c93" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c94" style="width:100%">
                  <Input type="text" v-model="formRecord.c94" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c95" style="width:100%">
                  <Input type="text" v-model="formRecord.c95" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c96" style="width:100%">
                  <Input type="text" v-model="formRecord.c96" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c97" style="width:100%">
                  <Input type="text" v-model="formRecord.c97" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td colspan="7">注：如果上述关键零部件属多个制造商，均应按上述要求逐一填写。</td>
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
        型号的 <span class="f-product">水（地）源热泵机组 2014版</span>产品{{pageType==="update"?'已通过能效标识备案':''}}。
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
        checkComplex: "",
        thisDateCV: "c24",  //当前初始使用日期 对应的C值
        thisLevelCV: "c7", //当前能效等级 对应的C值
        thisGZXHCV: "c4",// 当前规格型号 对应的C值
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
          c3: '',
          c5: '',
          c4: '',
          c2: '',
          c200: '',
          c7: '',
          c8: '',
          c9: '',
          c10: '',
          c11: '',
          c49: '',
          c12: '',
          c13: '',
          c14: '',
          c50: '',
          c15: '',
          c16: '',
          c17: '',
          c51: '',
          c18: '',
          c19: '',
          c20: '',
          c52: '',
          c21: '',
          c22: '',
          c23: '',
          c24: new Date(),
          c25: '',
          c26: [],
          c27: '',
          c28: [],
          c29: '',
          c30: [],
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
          c45: '',
          c42: '',
          c43: '',
          c44: '',
          c46: '',
          c47: '',
          c48: '',
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
          c202: '',
          ec_model_no: 44,
          attach_list: ''
        }
      }
    },
    mounted() {
      //this.disabledoff=(this.$store.state.app.pageType=="extend" ? true : false)
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
        //拿出需要检测的变量
        let _c7 = this.formRecord.c7;//能效等级
        let _c8 = this.formRecord.c8;//类型
        let _c26 = this.formRecord.c26;//冷(热)源类型

        let _c9 = parseFloat(this.formRecord.c9);
        let _c10 = parseFloat(this.formRecord.c10);
        let _c49 = this.formRecord.c49;
        let _c12 = parseFloat(this.formRecord.c12);
        let _c13 = parseFloat(this.formRecord.c13);
        let _c50 = this.formRecord.c50;
        let _c15 = parseFloat(this.formRecord.c15);
        let _c16 = parseFloat(this.formRecord.c16);
        let _c51 = this.formRecord.c51;
        let _c18 = parseFloat(this.formRecord.c18);
        let _c19 = parseFloat(this.formRecord.c19);
        let _c52 = this.formRecord.c52;
        let _c21 = parseFloat(this.formRecord.c21);
        let _c22 = parseFloat(this.formRecord.c22);

        /**一、以下为检测函数 */
        /**1.0-基础校验 */
        let checkC12 = (rule, value, callback) => {
          let _msg = null;
          if (_c49 == 'kW' && !sCheck.number.isOneDecimal(value)) _msg = '一位小数';
          else if (_c49 == 'W' && !sCheck.number.isInteger(value)) _msg = '整数';
          if (_msg) callback(_msg);
          else callback();
        }
        let checkC13 = (rule, value, callback) => {
          let _msg = null;
          if (_c49 == 'kW' && !sCheck.number.atLeastTwoDecimals(value)) _msg = '至少两位小数';
          else if (_c49 == 'W' && !sCheck.number.atLeastOneDecimals(value)) _msg = '至少一位小数';
          if (_msg) callback(_msg);
          else callback();
        }
        let checkC15 = (rule, value, callback) => {
          let _msg = null;
          if (_c50 == 'kW' && !sCheck.number.isOneDecimal(value)) _msg = '一位小数';
          else if (_c50 == 'W' && !sCheck.number.isInteger(value)) _msg = '整数';
          if (_msg) callback(_msg);
          else callback();
        }
        let checkC16 = (rule, value, callback) => {
          let _msg = null;
          if (_c50 == 'kW' && !sCheck.number.atLeastTwoDecimals(value)) _msg = '至少两位小数';
          else if (_c50 == 'W' && !sCheck.number.atLeastOneDecimals(value)) _msg = '至少一位小数';
          if (_msg) callback(_msg);
          else callback();
        }
        let checkC18 = (rule, value, callback) => {
          let _msg = null;
          if (_c51 == 'kW' && !sCheck.number.isOneDecimal(value)) _msg = '一位小数';
          else if (_c51 == 'W' && !sCheck.number.isInteger(value)) _msg = '整数';
          if (_msg) callback(_msg);
          else callback();
        }
        let checkC19 = (rule, value, callback) => {
          let _msg = null;
          if (_c51 == 'kW' && !sCheck.number.atLeastTwoDecimals(value)) _msg = '至少两位小数';
          else if (_c51 == 'W' && !sCheck.number.atLeastOneDecimals(value)) _msg = '至少一位小数';
          if (_msg) callback(_msg);
          else callback();
        }
        let checkC21 = (rule, value, callback) => {
          let _msg = null;
          if (_c52 == 'kW' && !sCheck.number.isOneDecimal(value)) _msg = '一位小数';
          else if (_c52 == 'W' && !sCheck.number.isInteger(value)) _msg = '整数';
          if (_msg) callback(_msg);
          else callback();
        }
        let checkC22 = (rule, value, callback) => {
          let _msg = null;
          if (_c52 == 'kW' && !sCheck.number.atLeastTwoDecimals(value)) _msg = '至少两位小数';
          else if (_c52 == 'W' && !sCheck.number.atLeastOneDecimals(value)) _msg = '至少一位小数';
          if (_msg) callback(_msg);
          if (_msg) callback(_msg);
          else callback();
        }
        /**1.1-实测值与标称值关系 */
        let checkC12C13 = (rule, value, callback) => {
          let _msg = null;
          if (_c12 && _c13 && _c13 < _c12 * 0.95) _msg = "名义制冷量实测值不应小于额定值的95%。";
          if (_msg) callback(_msg); else callback();
        }
        let checkC15C16 = (rule, value, callback) => {
          let _msg = null;
          if (_c15 && _c16 && _c16 > _c15 * 1.1) _msg = "名义制冷消耗功率实测值不应大于额定值的110%。";
          if (_msg) callback(_msg); else callback();
        }
        let checkC18C19 = (rule, value, callback) => {
          let _msg = null;
          if (_c18 && _c19 && _c19 < _c18 * 0.95) _msg = "名义制热量实测值不应小于额定值的95%。";
          if (_msg) callback(_msg); else callback();
        }
        let checkC21C22 = (rule, value, callback) => {
          let _msg = null;
          if (_c21 && _c22 && _c22 > _c21 * 1.1) _msg = "名义制热消耗功率实测值不应大于额定值的110%。";
          if (_msg) callback(_msg); else callback();
        }
        /**1.2-能效等级、产品类型与各实测值标称值之间关系 */
        let _nxdj = [];
        var _c10val = [];
        if (_c8 == "冷热风型") {
          for (let thisC26 of _c26) {
            if (thisC26 == "水环式") {
              if (_c9 >= 4.20) _nxdj.push("1"), _c10val.push("4.20");
              else if (_c9 >= 3.90 && _c9 < 4.20) _nxdj.push("2"), _c10val.push("3.90");
              else if (_c9 >= 3.50 && _c9 < 3.90) _nxdj.push("3"), _c10val.push("3.50");
            }
            else if (thisC26 == "地下水式") {
              if (_c9 >= 4.50) _nxdj.push("1"), _c10val.push("4.50");
              else if (_c9 >= 4.20 && _c9 < 4.50) _nxdj.push("2"), _c10val.push("4.20");
              else if (_c9 >= 3.80 && _c9 < 4.20) _nxdj.push("3"), _c10val.push("3.8");
            }
            else if (thisC26 == "地埋管式") {
              if (_c9 >= 4.20) _nxdj.push("1"), _c10val.push("4.20");
              else if (_c9 >= 3.90 && _c9 < 4.20) _nxdj.push("2"), _c10val.push("3.90");
              else if (_c9 >= 3.50 && _c9 < 3.90) _nxdj.push("3"), _c10val.push("3.50");
            }
            else if (thisC26 == "地表水式") {
              if (_c9 >= 4.20) _nxdj.push("1"), _c10val.push("4.20");
              else if (_c9 >= 3.90 && _c9 < 4.20) _nxdj.push("2"), _c10val.push("3.90");
              else if (_c9 >= 3.50 && _c9 < 3.90) _nxdj.push("3"), _c10val.push("3.50");
            }
          }
        } else if (_c8 == "冷热水型") {
          let str150 = (_c49 == "kW" ? 150 : (_c49 == "W" ? 150 * 1000 : 0));
          for (let thisC26 of _c26) {
            if (thisC26 == "水环式") {
              if (_c12 <= str150) {
                if (_c9 >= 5.0) _nxdj.push("1"), _c10val.push("5.0");
                else if (_c9 >= 4.60 && _c9 < 5.00) _nxdj.push("2"), _c10val.push("4.60");
                else if (_c9 >= 3.80 && _c9 < 4.60) _nxdj.push("3"), _c10val.push("3.80");
              } else {
                if (_c9 >= 5.4) _nxdj.push("1"), _c10val.push("5.4");
                else if (_c9 >= 5.00 && _c9 < 5.40) _nxdj.push("2"), _c10val.push("5.00");
                else if (_c9 >= 4.00 && _c9 < 5.00) _nxdj.push("3"), _c10val.push("4.00");
              }
            } else if (thisC26 == "地下水式") {
              if (_c12 <= str150) {
                if (_c9 >= 5.3) _nxdj.push("1"), _c10val.push("5.3");
                else if (_c9 >= 4.90 && _c9 < 5.30) _nxdj.push("2"), _c10val.push("4.90");
                else if (_c9 >= 3.90 && _c9 < 4.90) _nxdj.push("3"), _c10val.push("3.90");
              } else {
                if (_c9 >= 5.90) _nxdj.push("1"), _c10val.push("5.90");
                else if (_c9 >= 5.50 && _c9 < 5.90) _nxdj.push("2"), _c10val.push("5.50");
                else if (_c9 >= 4.40 && _c9 < 5.50) _nxdj.push("3"), _c10val.push("4.40");
              }
            } else if (thisC26 == "地埋管式") {
              if (_c12 <= str150) {
                if (_c9 >= 5.0) _nxdj.push("1"), _c10val.push("5.0");
                else if (_c9 >= 4.60 && _c9 < 5.00) _nxdj.push("2"), _c10val.push("4.60");
                else if (_c9 >= 3.80 && _c9 < 4.60) _nxdj.push("3"), _c10val.push("3.80");
              } else {
                if (_c9 >= 5.40) _nxdj.push("1"), _c10val.push("5.4");
                else if (_c9 >= 5.00 && _c9 < 5.40) _nxdj.push("2"), _c10val.push("5.00");
                else if (_c9 >= 4.00 && _c9 < 5.00) _nxdj.push("3"), _c10val.push("4.00");
              }
            } else if (thisC26 == "地表水式") {
              if (_c12 <= str150) {
                if (_c9 >= 5.0) _nxdj.push("1"), _c10val.push("5.0");
                else if (_c9 >= 4.60 && _c9 < 5.0) _nxdj.push("2"), _c10val.push("4.60");
                else if (_c9 >= 3.80 && _c9 < 4.60) _nxdj.push("3"), _c10val.push("3.80");
              } else {
                if (_c9 >= 5.4) _nxdj.push("1"), _c10val.push("5.4");
                else if (_c9 >= 5.00 && _c9 < 5.4) _nxdj.push("2"), _c10val.push("5.00");
                else if (_c9 >= 4.00 && _c9 < 5.00) _nxdj.push("3"), _c10val.push("4.00");
              }
            }
          }
        }
        let _nxdjMax = 0;
        let _c10xd = "";
        if (_nxdj.length > 0 && _c10val.length > 0 && _nxdj.length == _c10val.length) {
          _nxdjMax = _nxdj[0];
          _c10xd = _c10val[0];
          for (let i = 1; i < _nxdj.length - 1; i++) {
            if (_nxdj[i] > _nxdjMax) _nxdjMax = nxdjstr[i];
          }
          for (let i = 0; i < _c10val.length - 1; i++) {
            if (_c10xd < _c10val[i]) c10xd = _c10val[i];
          }
        }
        this.checkComplex = "";
        if (_c10 < _c10xd) this.checkComplex += "全年综合性能系数实测值不应小于该能效等级限定标准值";
        if (_nxdjMax == 0) this.checkComplex += "能效数据不在备案范围";
        if (_c7 != _nxdjMax) this.checkComplex += "所选能效等级与计算结果不符！";
        if (this.checkComplex) this.modal1 = false;

        if (this.formRecord.c25 == '冷热风型') this.formRecord.c8 = '冷热风型';
        if (this.formRecord.c25 == '冷热水型') this.formRecord.c8 = '冷热水型';
        if (this.formRecord.c8 == '冷热风型') this.formRecord.c25 = '冷热风型';
        if (this.formRecord.c8 == '冷热水型') this.formRecord.c25 = '冷热水型';

        const changeVal = (rule, value, callback) => {
          this.mainModel === value ? callback('扩展备案需要变更型号名称') : callback()
        }
        if (this.pageType === 'view') {
          return {};
        } else if (this.pageType === 'extend') {
          return {
            c4: [
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
        } else {
          return {
            c3: [{
              required: true, message: '制造单位不能为空'
            }],
            c5: [{
              required: true, message: '备案方不能为空'
            }],
            c4: [{
              required: true, message: '规格型号不能为空'
            }],
            c2: [{
              required: true, message: '商标不能为空'
            }],
            c7: [{
              required: true, message: '请选择能效等级', trigger: 'change'
            }],
            c8: [{
              required: true, message: '请选择类型', trigger: 'change'
            }],
            c9: [{
              required: true, message: '标注值不能为空', trigger: 'change,blur'
            }, {
              validator: twoDecimals, trigger: 'change,blur'
            }],
            c10: [{
              required: true, message: '实测值不能为空', trigger: 'change,blur'
            }, {
              validator: threeDecimals, trigger: 'change,blur'
            }],
            c49: [{
              required: true, message: '请选择名义制冷量单位', trigger: 'change'
            }],
            c12: [{
              required: true, message: '标注值不能为空', trigger: 'change,blur'
            }, {
              validator: checkC12, trigger: 'change,blur'
            }, {
              validator: checkC12C13, trigger: 'change,blur'
            }],
            c13: [{
              required: true, message: '实测值不能为空', trigger: 'change,blur'
            }, {
              validator: checkC13, trigger: 'change,blur'
            }, {
              validator: checkC12C13, trigger: 'change,blur'
            }],
            c50: [{
              required: true, message: '请选择名义制冷消耗功率单位', trigger: 'change'
            }],
            c15: [{
              required: true, message: '标注值不能为空', trigger: 'change,blur'
            }, {
              validator: checkC15, trigger: 'change,blur'
            }, {
              validator: checkC15C16, trigger: 'change,blur'
            }],
            c16: [{
              required: true, message: '实测值不能为空', trigger: 'change,blur'
            }, {
              validator: checkC16, trigger: 'change,blur'
            }, {
              validator: checkC15C16, trigger: 'change,blur'
            }],
            c51: [{
              required: true, message: '请选择名义制热量单位', trigger: 'change'
            }],
            c18: [{
              required: true, message: '标注值不能为空', trigger: 'change,blur'
            }, {
              validator: checkC18, trigger: 'change,blur'
            }, {
              validator: checkC18C19, trigger: 'change,blur'
            }],
            c19: [{
              required: true, message: '实测值不能为空', trigger: 'change,blur'
            }, {
              validator: checkC19, trigger: 'change,blur'
            }, {
              validator: checkC18C19, trigger: 'change,blur'
            }],
            c52: [{
              required: true, message: '请选择名义制热消耗功率单位', trigger: 'change'
            }],
            c21: [{
              required: true, message: '标注值不能为空', trigger: 'change,blur'
            }, {
              validator: checkC21, trigger: 'change,blur'
            }, {
              validator: checkC21C22, trigger: 'change,blur'
            }],
            c22: [{
              required: true, message: '实测值不能为空', trigger: 'change,blur'
            }, {
              validator: checkC22, trigger: 'change,blur'
            }, {
              validator: checkC21C22, trigger: 'change,blur'
            }],
            c24: [{
              required: true, message: '备案标识开始使用日期不能为空'
            }],
            c25: [{
              required: true, message: '机器类型不能为空', trigger: 'change'
            }],
            c26: [{
              required: true, message: '冷(热)源类型不能为空'
            }],
            c27: [{
              required: true, message: '结构形式不能为空', trigger: 'change'
            }],
            c28: [{
              required: true, message: '换热器(水/制冷剂)不能为空'
            }, {
              validator: (rule, value, callback) => {
                if (value.join('').indexOf('其它') == -1) this.formRecord.c29 = "";
                callback();
              }, trigger: 'change'
            }],
            c29: [{
              required: this.formRecord.c28.join('').indexOf('其它') > -1,
              message: '其它换热器(水/制冷剂)不能为空',
              trigger: 'change,blur'
            }],
            c30: [{
              required: true, message: '节流装置不能为空'
            }, {
              validator: (rule, value, callback) => {
                if (value.join('').indexOf('其它') == -1) this.formRecord.c31 = "";
                callback();
              }, trigger: 'change'
            }],
            c31: [{
              required: this.formRecord.c30.join('').indexOf('其它') > -1, message: '其它节流装置不能为空', trigger: 'change,blur'
            }],
            c32: [{
              required: true, message: '模块化不能为空'
            }],
            c33: [{
              required: true, message: '部分负荷运行不能为空'
            }],
            c34: [{
              required: true, message: '油分离器不能为空'
            }],
            c35: [{
              required: true, message: '储液器不能为空'
            }],
            c36: [{
              required: true, message: '辅助电加热器不能为空'
            }],
            c37: [{
              required: true, message: '控制类型不能为空', trigger: 'change'
            }, {
              validator: (rule, value, callback) => {
                if (value != '其它') this.formRecord.c38 = "";
                callback();
              }, trigger: 'change'
            }],
            c38: [{
              required: this.formRecord.c37 == '其它', message: '其它控制类型不能为空', trigger: 'change,blur'
            }],
            c39: [{
              required: true, message: '电源类型不能为空', trigger: 'change'
            }, {
              validator: (rule, value, callback) => {
                if (value != '其它') this.formRecord.c40 = "";
                callback();
              }, trigger: 'change'
            }],
            c40: [{
              required: this.formRecord.c39 == '其它', message: '其它电源类型不能为空', trigger: 'change,blur'
            }],
            c41: [{
              required: true, message: '制冷剂不能为空'
            }],
            c45: [{
              required: true, message: '灌注量不能为空'
            }],
            c42: [{
              required: true, message: '长不能为空'
            }],
            c43: [{
              required: true, message: '宽不能为空'
            }],
            c44: [{
              required: true, message: '高不能为空'
            }],
            c46: [{
              required: true, message: '长不能为空'
            }],
            c47: [{
              required: true, message: '宽不能为空'
            }],
            c48: [{
              required: true, message: '高不能为空'
            }],
            c53: [{
              required: true, message: '不能为空'
            }],
            c54: [{
              required: true, message: '不能为空'
            }],
            c55: [{
              required: true, message: '不能为空'
            }],
            c56: [{
              required: true, message: '不能为空'
            }],
            c57: [{
              required: true, message: '不能为空'
            }],
            c68: [{
              required: true, message: '不能为空'
            }],
            c69: [{
              required: true, message: '不能为空'
            }],
            c70: [{
              required: true, message: '不能为空'
            }],
            c71: [{
              required: true, message: '不能为空'
            }],
            c72: [{
              required: true, message: '不能为空'
            }],
            c83: [{
              required: true, message: '不能为空'
            }],
            c84: [{
              required: true, message: '不能为空'
            }],
            c85: [{
              required: true, message: '不能为空'
            }],
            c86: [{
              required: true, message: '不能为空'
            }],
            c87: [{
              required: true, message: '不能为空'
            }]
          }
        }
      }
    }
  }
</script>
<style>
  @import '../../../css/comm.css';
</style>
