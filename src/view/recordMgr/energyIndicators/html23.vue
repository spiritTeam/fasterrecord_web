<template>
  <div class="wrapper">
    <Form ref="formRecord" :model="formRecord" label-position="right" :rules="pageType!='extend'?ruleRecord:{}">
      <h1>房间空气调节器 修订-能源效率标识备案表</h1>
      <div class="part part1">
        <Card :bordered="false">
          <h2>一、备案方声明</h2>
          <p>本组织保证如下：</p>
          <p>使用的能源效率标识信息与备案信息一致；</p>
          <p>本型号产品变更能源效率标识时，向授权机构重新备案；</p>
          <p>确保该型号产品始终符合能源效率标识使用的相关要求。</p>
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
          <h2>三、能源效率标识备案信息</h2>
          <FormItem prop="c1" label="生产者名称" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c1" placeholder="生产者名称" disabled/>
          </FormItem>
          <FormItem prop="c2" label="制造单位" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c2" :disabled='disabledoff' placeholder="制造单位"/>
          </FormItem>
          <FormItem prop="c50" label="备案方" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c50" :disabled='disabledoff' placeholder="备案方"/>
          </FormItem>
          <FormItem prop="c3" label="产品规格型号" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c3" :disabled='!disabledoff' placeholder="规格型号"/>
          </FormItem>
          <FormItem prop="c4" label="商标" style="width:100%" :label-width="180">
            <Input type="text" v-model="formRecord.c4" :disabled='pageType=="view"' placeholder="商标"/>
          </FormItem>
          <FormItem prop="c200" label="依据国家标准" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c200" placeholder="依据国家标准" disabled/>
          </FormItem>
          <FormItem prop="c5" label="产品结构" style="width:100%;" :label-width="180">
            <RadioGroup v-model="formRecord.c5">
              <Radio label="挂壁式" :disabled='disabledoff'>挂壁式</Radio>
              <Radio label="落地式" :disabled='disabledoff'>落地式</Radio>
              <Radio label="窗式" :disabled='disabledoff'>窗式</Radio>
              <Radio label="其它" :disabled='disabledoff'>其它</Radio>
            </RadioGroup>
          </FormItem>
          <FormItem prop="c62" style="margin-top:-55.8px;" :label-width="440">
            <Input type="text" v-model="formRecord.c62" style="width:200px;" :disabled='disabledoff || forbidden.c62'/>
          </FormItem>
          <FormItem prop="c51" label="能效等级" style="width:100%;" :label-width="180">
            <RadioGroup v-model="formRecord.c51">
              <Radio label="1" :disabled='disabledoff'>1级</Radio>
              <Radio label="2" :disabled='disabledoff'>2级</Radio>
              <Radio label="3" :disabled='disabledoff'>3级</Radio>
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
              <td align="center">制冷量(W)</td>
              <td>
                <FormItem prop="c6" label="标称值:" style="width:100%;" :label-width="70">
                  <Input type="text" v-model="formRecord.c6" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c7" label="实测值:" style="width:100%;" :label-width="70">
                  <Input type="text" v-model="formRecord.c7" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c8" label="备注:" style="width:100%;" :label-width="70">
                  <Input type="text" v-model="formRecord.c8" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center">输入功率(W)</td>
              <td>
                <FormItem prop="c9" label="标称值:" style="width:100%;" :label-width="70">
                  <Input type="text" v-model="formRecord.c9" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c10" label="实测值:" style="width:100%;" :label-width="70">
                  <Input type="text" v-model="formRecord.c10" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c11" label="备注:" style="width:100%;" :label-width="70">
                  <Input type="text" v-model="formRecord.c11" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center">能效比(W/W)</td>
              <td>
                <FormItem prop="c12" label="标称值:" style="width:100%;" :label-width="70">
                  <Input type="text" v-model="formRecord.c12" :disabled='disabledoff' placeholder="两位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c13" label="实测值:" style="width:100%;" :label-width="70">
                  <Input type="text" v-model="formRecord.c13" :disabled='disabledoff' placeholder="两位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c14" label="备注:" style="width:100%;" :label-width="70">
                  <Input type="text" v-model="formRecord.c14" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
          </table>
        </Card>
      </div>
      <div class="part part4">
        <Card :bordered="false">
          <h2>四、初始使用日期</h2>
          <FormItem prop="c15" label="备案标识开始使用日期" style="width:100%;">
            <DatePicker type="date" :options="dataInit" style="width: 200px" v-model="formRecord.c15"></DatePicker>
          </FormItem>
        </Card>
      </div>
      <div class="part part5">
        <Card :bordered="false">
          <h2>五、样品描述</h2>
          <table id="table3">
            <tr>
              <td align="right"><span style="color:red">*</span>产品类型</td>
              <td>
                <FormItem prop="c16" style="width:100%;" :label-width="30">
                  <RadioGroup v-model="formRecord.c16">
                    <Radio label="分体式" :disabled='disabledoff'>分体式</Radio>
                    <Radio label="整体式" :disabled='disabledoff'>整体式</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td align="right"><span style="color:red">*</span>电源类型</td>
              <td>
                <FormItem prop="c17" style="width:100%;" :label-width="30">
                  <RadioGroup v-model="formRecord.c17">
                    <Radio label="单相" :disabled='disabledoff'>单相</Radio>
                    <Radio label="三相" :disabled='disabledoff'>三相</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span style="color:red">*</span>电热元件</td>
              <td>
                <FormItem prop="c18" style="width:100%;" :label-width="30">
                  <RadioGroup v-model="formRecord.c18">
                    <Radio label="有" :disabled='disabledoff'>有</Radio>
                    <Radio label="无" :disabled='disabledoff'>无</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td align="right"><span style="color:red">*</span>开关（全极断开）</td>
              <td>
                <FormItem prop="c19" style="width:100%;" :label-width="30">
                  <RadioGroup v-model="formRecord.c19">
                    <Radio label="有" :disabled='disabledoff'>有</Radio>
                    <Radio label="无" :disabled='disabledoff'>无</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span style="color:red">*</span>机械温控器</td>
              <td>
                <FormItem prop="c20" style="width:100%;" :label-width="30">
                  <RadioGroup v-model="formRecord.c20">
                    <Radio label="有" :disabled='disabledoff'>有</Radio>
                    <Radio label="无" :disabled='disabledoff'>无</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td align="right"><span style="color:red">*</span>温控器以外的其它控制装置</td>
              <td>
                <FormItem prop="c21" style="width:100%;" :label-width="30">
                  <RadioGroup v-model="formRecord.c21">
                    <Radio label="有" :disabled='disabledoff'>有</Radio>
                    <Radio label="无" :disabled='disabledoff'>无</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span style="color:red">*</span>用于非正常工作保护的薄弱零件</td>
              <td>
                <FormItem prop="c22" style="width:100%;" :label-width="30">
                  <RadioGroup v-model="formRecord.c22">
                    <Radio label="有" :disabled='disabledoff'>有</Radio>
                    <Radio label="无" :disabled='disabledoff'>无</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td align="right"><span style="color:red">*</span>电子控制线路</td>
              <td>
                <FormItem prop="c23" style="width:100%;" :label-width="30">
                  <RadioGroup v-model="formRecord.c23">
                    <Radio label="有" :disabled='disabledoff'>有</Radio>
                    <Radio label="无" :disabled='disabledoff'>无</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span style="color:red">*</span>不可拆卸插头的电源线</td>
              <td>
                <FormItem prop="c24" style="width:100%;" :label-width="30">
                  <RadioGroup v-model="formRecord.c24">
                    <Radio label="有" :disabled='disabledoff'>有</Radio>
                    <Radio label="无" :disabled='disabledoff'>无</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td align="right"><span style="color:red">*</span>单独的控制面板</td>
              <td>
                <FormItem prop="c25" style="width:100%;" :label-width="30">
                  <RadioGroup v-model="formRecord.c25">
                    <Radio label="有" :disabled='disabledoff'>有</Radio>
                    <Radio label="无" :disabled='disabledoff'>无</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span style="color:red">*</span>线控器</td>
              <td>
                <FormItem prop="c26" style="width:100%;" :label-width="30">
                  <RadioGroup v-model="formRecord.c26">
                    <Radio label="有" :disabled='disabledoff'>有</Radio>
                    <Radio label="无" :disabled='disabledoff'>无</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td align="right"><span style="color:red">*</span>遥控器</td>
              <td>
                <FormItem prop="c27" style="width:100%;" :label-width="30">
                  <RadioGroup v-model="formRecord.c27">
                    <Radio label="有" :disabled='disabledoff'>有</Radio>
                    <Radio label="无" :disabled='disabledoff'>无</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span style="color:red">*</span>是否接风管</td>
              <td>
                <FormItem prop="c59" style="width:100%;" :label-width="30">
                  <RadioGroup v-model="formRecord.c59">
                    <Radio label="有" :disabled='disabledoff'>有</Radio>
                    <Radio label="无" :disabled='disabledoff'>无</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td align="right"><span style="color:red">*</span>额定电压（V）</td>
              <td>
                <FormItem prop="c28" style="width:100%;">
                  <Input type="text" v-model="formRecord.c28" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span style="color:red">*</span>额定频率（Hz）</td>
              <td>
                <FormItem prop="c29" style="width:100%;">
                  <Input type="text" v-model="formRecord.c29" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td align="right"><span style="color:red">*</span>额定电流(A)（一位小数）</td>
              <td>
                <FormItem prop="c30" style="width:100%;">
                  <Input type="text" v-model="formRecord.c30" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span style="color:red">*</span>防触电保护类别</td>
              <td>
                <FormItem prop="c31" style="width:100%;">
                  <Input type="text" v-model="formRecord.c31" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td align="right"><span style="color:red">*</span>防水等级</td>
              <td>
                <FormItem prop="c32" style="width:100%;">
                  <Input type="text" v-model="formRecord.c32" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span style="color:red">*</span>制热功能</td>
              <td colspan="3">
                <FormItem prop="c61" style="width:100%;" :label-width="30">
                  <RadioGroup v-model="formRecord.c61">
                    <Radio label="有" :disabled='disabledoff'>有</Radio>
                    <Radio label="无" :disabled='disabledoff'>无</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span style="color:red">*</span>热泵制热量，不含电加热(W)</td>
              <td>
                <FormItem prop="c35" style="width:100%;">
                  <Input type="text" v-model="formRecord.c35" :disabled='disabledoff || forbidden.c35'/>
                </FormItem>
              </td>
              <td align="right"><span style="color:red">*</span>热泵制热消耗功率，不含电加热(W)</td>
              <td>
                <FormItem prop="c36" style="width:100%;">
                  <Input type="text" v-model="formRecord.c36" :disabled='disabledoff || forbidden.c36'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span style="color:red">*</span>电加热装置制热消耗功率(W)</td>
              <td>
                <FormItem prop="c37" style="width:100%;">
                  <Input type="text" v-model="formRecord.c37" :disabled='disabledoff || forbidden.c37'/>
                </FormItem>
              </td>
              <td align="right"><span style="color:red">*</span>最大制热输入功率(W)</td>
              <td>
                <FormItem prop="c38" style="width:100%;">
                  <Input type="text" v-model="formRecord.c38" :disabled='disabledoff || forbidden.c38'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span style="color:red">*</span>最大制热输入电流(A)（一位小数）</td>
              <td>
                <FormItem prop="c39" style="width:100%;">
                  <Input type="text" v-model="formRecord.c39" :disabled='disabledoff || forbidden.c39'/>
                </FormItem>
              </td>
              <td></td>
              <td>
              </td>
            </tr>
            <tr>
              <td align="right"><span style="color:red">*</span>最大制冷输入功率(W)</td>
              <td>
                <FormItem prop="c33" style="width:100%;">
                  <Input type="text" v-model="formRecord.c33" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td align="right"><span style="color:red">*</span>最大制冷输入电流(A)（一位小数）</td>
              <td>
                <FormItem prop="c34" style="width:100%;">
                  <Input type="text" v-model="formRecord.c34" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span style="color:red">*</span>室内机噪声dB（A）</td>
              <td>
                <FormItem prop="c40" style="width:100%;">
                  <Input type="text" v-model="formRecord.c40" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td align="right"><span style="color:red">*</span>室外机噪声dB（A）</td>
              <td>
                <FormItem prop="c41" style="width:100%;">
                  <Input type="text" v-model="formRecord.c41" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span style="color:red">*</span>适用面积（㎡）</td>
              <td>
                <FormItem prop="c42" style="width:100%;">
                  <Input type="text" v-model="formRecord.c42" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td align="right"><span style="color:red">*</span>循环风量（m³/h）</td>
              <td>
                <FormItem prop="c56" style="width:100%;">
                  <Input type="text" v-model="formRecord.c56" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span style="color:red">*</span>室内机质量（kg）</td>
              <td>
                <FormItem prop="c57" style="width:100%;">
                  <Input type="text" v-model="formRecord.c57" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td align="right"><span style="color:red">*</span>室外机质量（kg）</td>
              <td>
                <FormItem prop="c58" style="width:100%;">
                  <Input type="text" v-model="formRecord.c58" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span style="color:red">*</span>制热量(W)</td>
              <td>
                <FormItem prop="c43" style="width:100%;">
                  <Input type="text" v-model="formRecord.c43" :disabled='disabledoff || forbidden.c43'/>
                </FormItem>
              </td>
              <td align="right"><span style="color:red">*</span>制热消耗功率(W)</td>
              <td>
                <FormItem prop="c44" style="width:100%;">
                  <Input type="text" v-model="formRecord.c44" :disabled='disabledoff || forbidden.c44'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span style="color:red">*</span>性能系数（COP）(W/W)</td>
              <td>
                <FormItem prop="c45" style="width:100%;">
                  <Input type="text" v-model="formRecord.c45" :disabled='disabledoff || forbidden.c45'/>
                </FormItem>
              </td>
              <td colspan="2"></td>
            </tr>
            <tr>
              <td align="right"><span style="color:red">*</span>整机或室内机外形尺寸(长×宽×高)（mm×mm×mm）</td>
              <td>
                <FormItem prop="c46" style="width:60px;">
                  <Input type="text" v-model="formRecord.c46" :disabled='disabledoff'/>
                </FormItem>
                <FormItem><b>×</b></FormItem>
                <FormItem prop="c52" style="width:60px;">
                  <Input type="text" v-model="formRecord.c52" :disabled='disabledoff'/>
                </FormItem>
                <FormItem><b>×</b></FormItem>
                <FormItem prop="c53" style="width:60px;">
                  <Input type="text" v-model="formRecord.c53" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td align="right"><span style="color:red">*</span>室外机(长×宽×高)（mm×mm×mm）</td>
              <td>
                <FormItem prop="c47" style="width:60px;">
                  <Input type="text" v-model="formRecord.c47" :disabled='disabledoff'/>
                </FormItem>
                <FormItem><b>×</b></FormItem>
                <FormItem prop="c54" style="width:60px;">
                  <Input type="text" v-model="formRecord.c54" :disabled='disabledoff'/>
                </FormItem>
                <FormItem><b>×</b></FormItem>
                <FormItem prop="c55" style="width:60px;">
                  <Input type="text" v-model="formRecord.c55" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span style="color:red">*</span>制冷剂名称</td>
              <td>
                <FormItem prop="c48" style="width:100%;">
                  <Input type="text" v-model="formRecord.c48" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td align="right"><span style="color:red">*</span>制冷剂灌注量(kg)</td>
              <td>
                <FormItem prop="c49" style="width:100%;">
                  <Input type="text" v-model="formRecord.c49" :disabled='disabledoff'/>
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
              <td rowspan="4" align="center">压缩机</td>
              <td class="tc">/</td>
              <td class="tc">制冷量（W）</td>
              <td class="tc">输入功率（kW）</td>
              <td class="tc">COP值</td>
              <td class="tc">/</td>
            </tr>
            <tr>
              <td>
                <FormItem prop="c63" style="width:100%;">
                  <Input type="text" v-model="formRecord.c63" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c64" style="width:100%;">
                  <Input type="text" v-model="formRecord.c64" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c65" style="width:100%;">
                  <Input type="text" v-model="formRecord.c65" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c66" style="width:100%;">
                  <Input type="text" v-model="formRecord.c66" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c67" style="width:100%;">
                  <Input type="text" v-model="formRecord.c67" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>
                <FormItem prop="c68" style="width:100%;">
                  <Input type="text" v-model="formRecord.c68" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c69" style="width:100%;">
                  <Input type="text" v-model="formRecord.c69" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c70" style="width:100%;">
                  <Input type="text" v-model="formRecord.c70" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c71" style="width:100%;">
                  <Input type="text" v-model="formRecord.c71" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c72" style="width:100%;">
                  <Input type="text" v-model="formRecord.c72" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>
                <FormItem prop="c73" style="width:100%;">
                  <Input type="text" v-model="formRecord.c73" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c74" style="width:100%;">
                  <Input type="text" v-model="formRecord.c74" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c75" style="width:100%;">
                  <Input type="text" v-model="formRecord.c75" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c76" style="width:100%;">
                  <Input type="text" v-model="formRecord.c76" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c77" style="width:100%;">
                  <Input type="text" v-model="formRecord.c77" :disabled='disabledoff'/>
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
      <p v-show="loadText && !uploadPic.includes('.pdf')" style="text-align:center">加载中···</p>
      <img class="lookPdf" v-if="!uploadPic.includes('.pdf')" width="790" :src="uploadPic" @load="templateLoad" />
      <embed class="lookPdf" v-else :src="uploadPic" width="600" height="400" @load="templateLoad" type="application/pdf"  internalinstanceid="81" />
    </Modal>
    <Modal v-model="modal5" class="basic-info pageStyle"  :width=650 ok-text="保存"  @on-ok="submitBasic" cancel-text="关闭">
      <h2>标识型号{{pageType==="extend"?'扩展':'变更'}}备案申请书</h2>
      <p class="org">中国标准化研究院能效标识管理中心：</p>
      <div class="pro-info">
        我 <span  class="f-company">{{formRecord.c1}}</span>
        公司生产的 <span class="f-brand">{{formRecord.c4}}</span>
        品牌的 <span  class="f-model">{{pageType==='extend'?mainModel:formRecord.c3}}</span>
        型号的 <span  class="f-product">房间空气调节器 2010版</span>产品{{pageType==="update"?'已通过能效标识备案':''}}。
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
    check,
    numberCheck
  } from '@/libs/utilExt'

  export default {
    data() {
      const timeDate = parseInt(this.$store.state.app.dateinit);
      return {
        // 当前初始使用日期 对应的C值
        thisDateCV: 'c15',
        // 当前能效等级 对应的C值
        thisLevelCV: 'c51',
        // 当前规格型号 对应的C值
        thisGZXHCV: "c3",
        modal3: false,
        modal4: false,
        modal5: false,
        templatePic: '',
        loadText:true,
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
          c9: '',
          c10: '',
          c11: '',
          c12: '',
          c13: '',
          c14: '',
          c15: new Date(),
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
          c200: '',
          c202: '',
          ec_model_no: 23,
          attach_list: ''
        },
        forbidden: {
          c62: true,
          c35: true,
          c36: true,
          c37: true,
          c38: true,
          c39: true,
          c43: true,
          c44: true,
          c45: true,
        },
        xdz1: 0
      }
    },
    mounted() {
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
      templateLoad(){
        this.loadText=false;
      },
      /* 数据来源 新增备案 */
      fillDefaultData(params) {
        let flag = XfillDefaultData(params, this)
        this.formRecord.c12 = Math.round(parseFloat(this.formRecord.c6) / parseFloat(this.formRecord.c9) * 100) /100 + "";
        return flag
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

      },
      getNxdj(z, a, b, c) {
        if (z >= a) {
          return "1";
        } else if (z >= b && z < a) {
          this.xdz1 = a;
          return "2";
        } else if (z >= c && z < b) {
          this.xdz1 = b;
          return "3";
        } else {
          return "0";
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
        //产品结构-其它 禁用
        if (this.formRecord.c5 == '其它') {
          this.forbidden.c62 = false
        } else {
          this.formRecord.c62 = ''
          this.forbidden.c62 = true
        }
        //制热功能-有、无 禁用
        if (this.formRecord.c61 == '有') {
          this.forbidden.c35 = false
          this.forbidden.c36 = false
          this.forbidden.c37 = false
          this.forbidden.c38 = false
          this.forbidden.c39 = false
          this.forbidden.c43 = false
          this.forbidden.c44 = false
          this.forbidden.c45 = false
        } else {
          this.formRecord.c35 = ''
          this.forbidden.c35 = true
          this.formRecord.c36 = ''
          this.forbidden.c36 = true
          this.formRecord.c37 = ''
          this.forbidden.c37 = true
          this.formRecord.c38 = ''
          this.forbidden.c38 = true
          this.formRecord.c39 = ''
          this.forbidden.c39 = true
          this.formRecord.c43 = ''
          this.forbidden.c43 = true
          this.formRecord.c44 = ''
          this.forbidden.c44 = true
          this.formRecord.c45 = ''
          this.forbidden.c45 = true
        }

        const callback = (rule, value, callback) => {
          callback()
        }

        //制冷量（C7）实测值≥制冷量（C6）标注值的95%
        var c6 = parseFloat(this.formRecord.c6);
        var c7 = parseFloat(this.formRecord.c7);
        const checkc7 = (rule, value, callback) => {
          if (c7 < (c6 * 0.95)) {
            callback('实测制冷量不应小于额定制冷量的95%')
          } else {
            callback()
          }
        }
        //输入功率（C10）实测值≤输入功率（C9）标注值的110%
        var c9 = parseFloat(this.formRecord.c9);
        var c10 = parseFloat(this.formRecord.c10);
        const checkc10 = (rule, value, callback) => {
          if (c10 > (c9 * 1.1)) {
            callback('实测制冷消耗功率不应大于额定制冷消耗功率的110%')
          } else {
            callback()
          }
        }

        //能效比：C12 ＝ C6／C9，保留两位小数
        var c12 = parseFloat(this.formRecord.c12);
        var _c12 = c6 / c9 + "";
        var _c12val = parseFloat(_c12.substring(0, _c12.lastIndexOf('.') + 3));

        // // //能效比标注值和国标比对
        var c16 = this.formRecord.c16;
        var c51 = this.formRecord.c51;

        // // //20160520 等级限定值
        var xdz1 = this.xdz1;

        var dj;
        if (c16 == "分体式") {
          if (c6 <= 4500) {
            dj = this.getNxdj(c12, 3.60, 3.40, 3.20);
          } else if (c6 > 4500 && c6 <= 7100) {
            dj = this.getNxdj(c12, 3.50, 3.30, 3.10);
          } else if (c6 > 7100 && c6 <= 14000) {
            dj = this.getNxdj(c12, 3.40, 3.20, 3.00);
          }
        } else {
          dj = this.getNxdj(c12, 3.30, 3.10, 2.90);
        }

        const checkc12 = (rule, value, callback) => {
          if (xdz1 != 0) {
            if (c12 >= xdz1 || c12 < _c12val) {
              callback('能效比（EER）标准值不正确')
            } else {
              callback()
            }
          } else {
            callback()
          }
        }

        // // //实测能效比不应小于能效限定值
        var c13 = parseFloat(this.formRecord.c13);
        var xdz = 0;
        if (c16 == "分体式") {
          if (dj == "1") {
            if (c6 <= 4500) {
              xdz = 3.60;
            } else if (c6 > 4500 && c6 <= 7100) {
              xdz = 3.50;
            } else if (c6 > 7100 && c6 <= 14000) {
              xdz = 3.40;
            }
          }
          if (dj == "2") {
            if (c6 <= 4500) {
              xdz = 3.40;
            } else if (c6 > 4500 && c6 <= 7100) {
              xdz = 3.30;
            } else if (c6 > 7100 && c6 <= 14000) {
              xdz = 3.20;
            }
          }
          if (dj == "3") {
            if (c6 <= 4500) {
              xdz = 3.20;
            } else if (c6 > 4500 && c6 <= 7100) {
              xdz = 3.10;
            } else if (c6 > 7100 && c6 <= 14000) {
              xdz = 3.00;
            }
          }
        } else {
          if (dj == "1") {
            xdz = 3.30;
          }
          if (dj == "2") {
            xdz = 3.10;
          }
          if (dj == "3") {
            xdz = 2.90;
          }
        }

        const checkc13 = (rule, value, callback) => {
          if (c13 < xdz) {
            callback('实测能效比不应小于能效限定值')
          } else {
            callback()
          }
        }

        const checkc51 = (rule, value, callback) => {
          if (dj == "0") {
            callback('计算所得能效等级与页面中选择的能效等级不符')
          } else {
            if (c51 != dj) {
              callback('计算所得能效等级与页面中选择的能效等级不符')
            } else {
              callback()
            }
          }
        }

        return {
          c1: [
            {
              required: true,
              message: '生产者名称不能为空',
              trigger: 'change,blur'
            }
          ],
          c2: [
            {
              required: true,
              message: '制造单位不能为空',
              trigger: 'change,blur'
            }
          ],
          c50: [
            {
              required: true,
              message: '备案方不能为空',
              trigger: 'change,blur'
            }
          ],
          c4: [
            {
              required: true,
              message: '商标不能为空',
              trigger: 'change,blur'
            }
          ],
          c5: [
            {
              required: true,
              message: '产品结构不能为空',
              trigger: 'change,blur'
            }
          ],
          c62: [
            {
              required: this.formRecord.c5 === '其它',
              message: '其它不能为空',
              trigger: 'change,blur'
            }
          ],
          c51: [
            {
              required: true,
              message: '能效等级不能为空',
              trigger: 'change,blur'
            },
            {
              validator: checkc51,
              trigger: 'change,blur'
            }
          ],
          c6: [
            {
              required: true,
              message: '标称值不能为空',
              trigger: 'change,blur'
            }
          ],
          c7: [
            {
              required: true,
              message: '实测值不能为空',
              trigger: 'change,blur'
            },
            {
              validator: checkc7,
              trigger: 'change,blur'
            }
          ],
          c9: [
            {
              required: true,
              message: '标称值不能为空',
              trigger: 'change,blur'
            }
          ],
          c10: [
            {
              required: true,
              message: '实测值不能为空',
              trigger: 'change,blur'
            },
            {
              validator: checkc10,
              trigger: 'change,blur'
            }
          ],
          c12: [
            {
              required: true,
              message: '标称值不能为空',
              trigger: 'change,blur'
            },
            {
              validator: twoDecimals,
              trigger: 'change,blur'
            },
            {
              validator: checkc12,
              trigger: 'change,blur'
            }
          ],
          c13: [
            {
              required: true,
              message: '实测值不能为空',
              trigger: 'change,blur'
            },
            {
              validator: twoDecimals,
              trigger: 'change,blur'
            },
            {
              validator: checkc13,
              trigger: 'change,blur'
            }
          ],
          c15: [
            {
              required: true,
              message: '不能为空',
            }
          ],
          c16: [
            {
              required: true,
              message: '产品类型不能为空',
              trigger: 'change,blur'
            }
          ],
          c17: [
            {
              required: true,
              message: '电源类型不能为空',
              trigger: 'change,blur'
            }
          ],
          c18: [
            {
              required: true,
              message: '电热元件不能为空',
              trigger: 'change,blur'
            }
          ],
          c19: [
            {
              required: true,
              message: '开关不能为空',
              trigger: 'change,blur'
            }
          ],
          c20: [
            {
              required: true,
              message: '机械温控器不能为空',
              trigger: 'change,blur'
            }
          ],
          c21: [
            {
              required: true,
              message: '温控器以外的其它控制装置不能为空',
              trigger: 'change,blur'
            }
          ],
          c22: [
            {
              required: true,
              message: '用于非正常工作保护的薄弱零件不能为空',
              trigger: 'change,blur'
            }
          ],
          c23: [
            {
              required: true,
              message: '电子控制线路不能为空',
              trigger: 'change,blur'
            }
          ],
          c24: [
            {
              required: true,
              message: '不可拆卸插头的电源线不能为空',
              trigger: 'change,blur'
            }
          ],
          c25: [
            {
              required: true,
              message: '单独的控制面板不能为空',
              trigger: 'change,blur'
            }
          ],
          c26: [
            {
              required: true,
              message: '线控器不能为空',
              trigger: 'change,blur'
            }
          ],
          c27: [
            {
              required: true,
              message: '遥控器不能为空',
              trigger: 'change,blur'
            }
          ],
          c59: [
            {
              required: true,
              message: '是否接风管不能为空',
              trigger: 'change,blur'
            }
          ],
          c28: [
            {
              required: true,
              message: '额定电压不能为空',
              trigger: 'change,blur'
            }
          ],
          c29: [
            {
              required: true,
              message: '额定频率不能为空',
              trigger: 'change,blur'
            }
          ],
          c30: [
            {
              required: true,
              message: '额定电流不能为空',
              trigger: 'change,blur'
            },
            {
              validator: oneDecimals,
              trigger: 'change,blur'
            }
          ],
          c31: [
            {
              required: true,
              message: '防触电保护类别不能为空',
              trigger: 'change,blur'
            }
          ],
          c32: [
            {
              required: true,
              message: '防水等级不能为空',
              trigger: 'change,blur'
            }
          ],
          c33: [
            {
              required: true,
              message: '最大制冷输入功率不能为空',
              trigger: 'change,blur'
            }
          ],
          c34: [
            {
              required: true,
              message: '最大制冷输入电流不能为空',
              trigger: 'change,blur'
            },
            {
              validator: oneDecimals,
              trigger: 'change,blur'
            }
          ],
          c40: [
            {
              required: true,
              message: '室内机噪声dB不能为空',
              trigger: 'change,blur'
            }
          ],
          c41: [
            {
              required: true,
              message: '室外机噪声dB不能为空',
              trigger: 'change,blur'
            }
          ],
          c42: [
            {
              required: true,
              message: '适用面积不能为空',
              trigger: 'change,blur'
            }
          ],
          c56: [
            {
              required: true,
              message: '循环风量不能为空',
              trigger: 'change,blur'
            }
          ],
          c57: [
            {
              required: true,
              message: '室内机质量不能为空',
              trigger: 'change,blur'
            }
          ],
          c58: [
            {
              required: true,
              message: '室外机质量不能为空',
              trigger: 'change,blur'
            }
          ],
          c61: [
            {
              required: true,
              message: '制热功能不能为空',
              trigger: 'change,blur'
            }
          ],
          c35: [
            {
              required: this.formRecord.c61 == '有',
              message: '热泵制热量不能为空',
              trigger: 'change,blur'
            }
          ],
          c36: [
            {
              required: this.formRecord.c61 == '有',
              message: '热泵制热消耗功率不能为空',
              trigger: 'change,blur'
            }
          ],
          c37: [
            {
              required: this.formRecord.c61 == '有',
              message: '电加热装置制热消耗功率不能为空',
              trigger: 'change,blur'
            }
          ],
          c38: [
            {
              required: this.formRecord.c61 == '有',
              message: '最大制热输入功率不能为空',
              trigger: 'change,blur'
            }
          ],
          c39: [
            {
              required: this.formRecord.c61 == '有',
              message: '最大制热输入电流不能为空',
              trigger: 'change,blur'
            },
            {
              validator: this.formRecord.c61 == '有' ? oneDecimals : callback,
              trigger: 'change,blur'
            }
          ],
          c43: [
            {
              required: this.formRecord.c61 == '有',
              message: '制热量不能为空',
              trigger: 'change,blur'
            }
          ],
          c44: [
            {
              required: this.formRecord.c61 == '有',
              message: '制热消耗功率不能为空',
              trigger: 'change,blur'
            }
          ],
          c45: [
            {
              required: this.formRecord.c61 == '有',
              message: '性能系数不能为空',
              trigger: 'change,blur'
            }
          ],
          c46: [
            {
              required: true,
              message: '长不能为空',
              trigger: 'change,blur'
            },
            {
              validator: numberCheck,
              trigger: 'change,blur'
            }
          ],
          c52: [
            {
              required: true,
              message: '宽不能为空',
              trigger: 'change,blur'
            },
            {
              validator: numberCheck,
              trigger: 'change,blur'
            }
          ],
          c53: [
            {
              required: true,
              message: '高不能为空',
              trigger: 'change,blur'
            },
            {
              validator: numberCheck,
              trigger: 'change,blur'
            }
          ],
          c47: [
            {
              required: true,
              message: '长不能为空',
              trigger: 'change,blur'
            },
            {
              validator: numberCheck,
              trigger: 'change,blur'
            }
          ],
          c54: [
            {
              required: true,
              message: '宽不能为空',
              trigger: 'change,blur'
            },
            {
              validator: numberCheck,
              trigger: 'change,blur'
            }
          ],
          c55: [
            {
              required: true,
              message: '高不能为空',
              trigger: 'change,blur'
            },
            {
              validator: numberCheck,
              trigger: 'change,blur'
            }
          ],
          c48: [
            {
              required: true,
              message: '制冷剂名称不能为空',
              trigger: 'change,blur'
            }
          ],
          c49: [
            {
              required: true,
              message: '制冷剂灌注量不能为空',
              trigger: 'change,blur'
            }
          ],
          c63: [
            {
              required: true,
              message: '不能为空',
              trigger: 'change,blur'
            }
          ],
          c64: [
            {
              required: true,
              message: '不能为空',
              trigger: 'change,blur'
            }
          ],
          c65: [
            {
              required: true,
              message: '不能为空',
              trigger: 'change,blur'
            }
          ],
          c66: [
            {
              required: true,
              message: '不能为空',
              trigger: 'change,blur'
            }
          ],
          c67: [
            {
              required: true,
              message: '不能为空',
              trigger: 'change,blur'
            }
          ],

        }
      }
    }
  }
</script>
<style>
  @import '../../../css/comm.css';
</style>
<style lang="less" scoped>
  .span-red {
    color: red;
    font-size: 13px;
  }
</style>
