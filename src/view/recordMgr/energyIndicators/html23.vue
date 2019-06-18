<template>
  <div class="wrapper">
    <Form ref="formRecord" :model="formRecord" label-position="right" :rules="ruleRecord">
      <h1>房间空气调节器 修订-能源效率标识备案表</h1>
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
                  <Input type="text" :value="$store.state.app.labName" readonly></Input>
                </td>
                <td>
                  <Input type="text" :value="$store.state.app.barcode" readonly></Input>
                </td>
              </tr>
            </tbody>
          </table>
        </Card>
      </div>
      <div class="part part3">
        <Card :bordered="false">
          <h2>三、能源效率标识备案信息</h2>
          <FormItem prop="c1" label="生产者名称" style="width:1000px;" :label-width="180">
            <Input type="text" v-model="formRecord.c1" placeholder="生产者名称" readonly :disabled="help.c1"></Input>
            <Icon type="ios-help-circle-outline" size="20" v-if="help.c1" @click="showModal2('c1')"></Icon>
          </FormItem>
          <FormItem prop="c2" label="制造单位" style="width:1000px;" :label-width="180">
            <Input type="text" v-model="formRecord.c2" placeholder="制造单位" :disabled="help.c2"></Input>
            <Icon type="ios-help-circle-outline" size="20" v-if="help.c2" @click="showModal2('c2')"></Icon>
          </FormItem>
          <FormItem prop="c50" label="备案方" style="width:1000px;" :label-width="180">
            <Input type="text" v-model="formRecord.c50" placeholder="备案方" :disabled="help.c50"></Input>
            <Icon type="ios-help-circle-outline" size="20" v-if="help.c50" @click="showModal2('c50')"></Icon>
          </FormItem>
          <FormItem prop="c3" label="产品规格型号" style="width:1000px;" :label-width="180">
            <Input type="text" v-model="formRecord.c3" placeholder="规格型号" readonly :disabled="help.c3"></Input>
            <Icon type="ios-help-circle-outline" size="20" v-if="help.c3" @click="showModal2('c3')"></Icon>
          </FormItem>
          <FormItem prop="c4" label="商标" style="width:1000px;" :label-width="180">
            <Input type="text" v-model="formRecord.c4" placeholder="商标" :disabled="help.c4"></Input>
            <Icon type="ios-help-circle-outline" size="20" v-if="help.c4" @click="showModal2('c4')"></Icon>
          </FormItem>
          <FormItem prop="c200" label="依据国家标准" style="width:1000px;" :label-width="180">
            <Input type="text" v-model="formRecord.c200" placeholder="依据国家标准" readonly disabled></Input>
            <Icon type="ios-help-circle-outline" size="20" v-if="help.c200" @click="showModal2('c200')"></Icon>
          </FormItem>
          <FormItem prop="c5" label="产品结构" style="width:440px;display:inline-block;" :label-width="180">
            <RadioGroup v-model="formRecord.c5" @on-change="formRecord.c62=''">
              <Radio label="挂壁式" :disabled="help.c5">挂壁式</Radio>
              <Radio label="落地式" :disabled="help.c5">落地式</Radio>
              <Radio label="窗式" :disabled="help.c5">窗式</Radio>
              <Radio label="其他" :disabled="help.c5">其他</Radio>
            </RadioGroup>
            <Icon type="ios-help-circle-outline" size="20" v-if="help.c5" @click="showModal2('c5')"></Icon>
          </FormItem>
          <FormItem prop="c62" style="width:300px;display:inline-block;" :label-width="0">
            <Input type="text" v-model="formRecord.c62" :disabled="formRecord.c5 !== '其他' || help.c62"></Input>
            <Icon type="ios-help-circle-outline" size="20" v-if="help.c62" @click="showModal2('c62')"></Icon>
          </FormItem>
          <FormItem prop="c51" label="能效等级" style="width:1000px;" :label-width="180">
            <RadioGroup v-model="formRecord.c51">
              <Radio label="1" :disabled="help.c51">1级</Radio>
              <Radio label="2" :disabled="help.c51">2级</Radio>
              <Radio label="3" :disabled="help.c51">3级</Radio>
            </RadioGroup>
            <Icon type="ios-help-circle-outline" size="20" v-if="help.c51" @click="showModal2('c51')"></Icon>
          </FormItem>
          <table id="table1">
            <tr>
              <th>项目</th>
              <th>标称值</th>
              <th>实测值</th>
              <th>备注</th>
            </tr>
            <tr>
              <td>制冷量(W)</td>
              <td>
                <FormItem prop="c6">
                  <Input type="text" v-model="formRecord.c6" :disabled="help.c6"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c6" @click="showModal2('c6')"></Icon>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c7">
                  <Input type="text" v-model="formRecord.c7" :disabled="help.c7"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c7" @click="showModal2('c7')"></Icon>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c8">
                  <Input type="text" v-model="formRecord.c8" :disabled="help.c8"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c8" @click="showModal2('c8')"></Icon>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>输入功率(W)</td>
              <td>
                <FormItem prop="c9">
                  <Input type="text" v-model="formRecord.c9" :disabled="help.c9"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c9" @click="showModal2('c9')"></Icon>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c10">
                  <Input type="text" v-model="formRecord.c10" :disabled="help.c10"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c10" @click="showModal2('c10')"></Icon>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c11">
                  <Input type="text" v-model="formRecord.c11" :disabled="help.c11"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c11" @click="showModal2('c11')"></Icon>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>能效比(W/W)</td>
              <td>
                <FormItem prop="c12">
                  <Input type="text" v-model="formRecord.c12" :disabled="help.c12"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c12" @click="showModal2('c12')"></Icon>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c13">
                  <Input type="text" v-model="formRecord.c13" :disabled="help.c13"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c13" @click="showModal2('c13')"></Icon>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c14">
                  <Input type="text" v-model="formRecord.c14" :disabled="help.c14"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c14" @click="showModal2('c14')"></Icon>
                </FormItem>
              </td>
            </tr>
          </table>
        </Card>
      </div>
      <div class="part part4">
        <Card :bordered="false">
          <h2>四、初始使用日期</h2>
          <FormItem prop="c15" label="备案标识开始使用日期" style="width:1000px;">
            <DatePicker type="date" style="width: 200px" v-model="formRecord.c15" :disabled="help.c15"></DatePicker>
            <Icon type="ios-help-circle-outline" size="20" v-if="help.c15" @click="showModal2('c15')"></Icon>
          </FormItem>
        </Card>
      </div>
      <div class="part part5">
        <Card :bordered="false">
          <h2>五、样品描述</h2>
          <table id="table3">
            <tr>
              <td>产品类型</td>
              <td width="30%">
                <FormItem prop="c16">
                  <RadioGroup v-model="formRecord.c16">
                    <Radio label="分体式" :disabled="help.c16">分体式</Radio>
                    <Radio label="整体式" :disabled="help.c16">整体式</Radio>
                  </RadioGroup>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c16" @click="showModal2('c16')"></Icon>
                </FormItem>
              </td>
              <td>电源类型</td>
              <td width="30%">
                <FormItem prop="c17">
                  <RadioGroup v-model="formRecord.c17">
                    <Radio label="三相" :disabled="help.c17">三相</Radio>
                    <Radio label="单相" :disabled="help.c17">单相</Radio>
                  </RadioGroup>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c17" @click="showModal2('c17')"></Icon>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>电热元件</td>
              <td>
                <FormItem prop="c18">
                  <RadioGroup v-model="formRecord.c18">
                    <Radio label="有" :disabled="help.c18">有</Radio>
                    <Radio label="无" :disabled="help.c18">无</Radio>
                  </RadioGroup>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c18" @click="showModal2('c18')"></Icon>
                </FormItem>
              </td>
              <td>开关（全极断开）</td>
              <td>
                <FormItem prop="c19">
                  <RadioGroup v-model="formRecord.c19">
                    <Radio label="有" :disabled="help.c19">有</Radio>
                    <Radio label="无" :disabled="help.c19">无</Radio>
                  </RadioGroup>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c19" @click="showModal2('c19')"></Icon>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>机械温控器</td>
              <td>
                <FormItem prop="c20">
                  <RadioGroup v-model="formRecord.c20">
                    <Radio label="有" :disabled="help.c20">有</Radio>
                    <Radio label="无" :disabled="help.c20">无</Radio>
                  </RadioGroup>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c20" @click="showModal2('c20')"></Icon>
                </FormItem>
              </td>
              <td>温控器以外的其他控制装置</td>
              <td>
                <FormItem prop="c21">
                  <RadioGroup v-model="formRecord.c21">
                    <Radio label="有" :disabled="help.c21">有</Radio>
                    <Radio label="无" :disabled="help.c21">无</Radio>
                  </RadioGroup>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c21" @click="showModal2('c21')"></Icon>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>用于非正常工作保护的薄弱零件</td>
              <td>
                <FormItem prop="c22">
                  <RadioGroup v-model="formRecord.c22">
                    <Radio label="有" :disabled="help.c22">有</Radio>
                    <Radio label="无" :disabled="help.c22">无</Radio>
                  </RadioGroup>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c22" @click="showModal2('c22')"></Icon>
                </FormItem>
              </td>
              <td>电子控制线路</td>
              <td>
                <FormItem prop="c23">
                  <RadioGroup v-model="formRecord.c23">
                    <Radio label="有" :disabled="help.c23">有</Radio>
                    <Radio label="无" :disabled="help.c23">无</Radio>
                  </RadioGroup>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c23" @click="showModal2('c23')"></Icon>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>不可拆卸插头的电源线</td>
              <td>
                <FormItem prop="c24">
                  <RadioGroup v-model="formRecord.c24">
                    <Radio label="有" :disabled="help.c24">有</Radio>
                    <Radio label="无" :disabled="help.c24">无</Radio>
                  </RadioGroup>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c24" @click="showModal2('c24')"></Icon>
                </FormItem>
              </td>
              <td>单独的控制面板</td>
              <td>
                <FormItem prop="c25">
                  <RadioGroup v-model="formRecord.c25">
                    <Radio label="有" :disabled="help.c25">有</Radio>
                    <Radio label="无" :disabled="help.c25">无</Radio>
                  </RadioGroup>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c25" @click="showModal2('c25')"></Icon>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>线控器</td>
              <td>
                <FormItem prop="c26">
                  <RadioGroup v-model="formRecord.c26">
                    <Radio label="有" :disabled="help.c26">有</Radio>
                    <Radio label="无" :disabled="help.c26">无</Radio>
                  </RadioGroup>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c26" @click="showModal2('c26')"></Icon>
                </FormItem>
              </td>
              <td>遥控器</td>
              <td>
                <FormItem prop="c27">
                  <RadioGroup v-model="formRecord.c27">
                    <Radio label="有" :disabled="help.c27">有</Radio>
                    <Radio label="无" :disabled="help.c27">无</Radio>
                  </RadioGroup>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c27" @click="showModal2('c27')"></Icon>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>是否接风管</td>
              <td>
                <FormItem prop="c59">
                  <RadioGroup v-model="formRecord.c59">
                    <Radio label="是" :disabled="help.c59">是</Radio>
                    <Radio label="否" :disabled="help.c59">否</Radio>
                  </RadioGroup>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c59" @click="showModal2('c59')"></Icon>
                </FormItem>
              </td>
              <td>额定电压（V）</td>
              <td>
                <FormItem prop="c28">
                  <Input type="text" v-model="formRecord.c28" :disabled="help.c28"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c28" @click="showModal2('c28')"></Icon>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>额定频率（Hz）</td>
              <td>
                <FormItem prop="c29">
                  <Input type="text" v-model="formRecord.c29" :disabled="help.c29"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c29" @click="showModal2('c29')"></Icon>
                </FormItem>
              </td>
              <td>额定电流(A)</td>
              <td>
                <FormItem prop="c30">
                  <Input type="text" v-model="formRecord.c30" :disabled="help.c30"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c30" @click="showModal2('c30')"></Icon>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>防触电保护类别</td>
              <td>
                <FormItem prop="c31">
                  <Input type="text" v-model="formRecord.c31" :disabled="help.c31"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c31" @click="showModal2('c31')"></Icon>
                </FormItem>
              </td>
              <td>防水等级</td>
              <td>
                <FormItem prop="c32">
                  <Input type="text" v-model="formRecord.c32" :disabled="help.c32"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c32" @click="showModal2('c32')"></Icon>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>制热功能</td>
              <td colspan="3">
                <FormItem prop="c61">
                  <RadioGroup v-model="formRecord.c61">
                    <Radio label="有" :disabled="help.c61">有</Radio>
                    <Radio label="无" :disabled="help.c61">无</Radio>
                  </RadioGroup>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c61" @click="showModal2('c61')"></Icon>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>热泵制热量，不含电加热(W)</td>
              <td>
                <FormItem prop="c35">
                  <Input type="text" v-model="formRecord.c35" :disabled="formRecord.c61 !== '有' || help.c35"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c35" @click="showModal2('c35')"></Icon>
                </FormItem>
              </td>
              <td>热泵制热消耗功率，不含电加热(W)</td>
              <td>
                <FormItem prop="c36">
                  <Input type="text" v-model="formRecord.c36" :disabled="formRecord.c61 !== '有' || help.c36"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c36" @click="showModal2('c36')"></Icon>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>电加热装置制热消耗功率(W)</td>
              <td>
                <FormItem prop="c37">
                  <Input type="text" v-model="formRecord.c37" :disabled="formRecord.c61 !== '有' || help.c37"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c37" @click="showModal2('c37')"></Icon>
                </FormItem>
              </td>
              <td>最大制热输入功率(W)</td>
              <td>
                <FormItem prop="c38">
                  <Input type="text" v-model="formRecord.c38" :disabled="formRecord.c61 !== '有' || help.c38"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c38" @click="showModal2('c38')"></Icon>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>最大制热输入电流(A)</td>
              <td colspan="3">
                <FormItem prop="c39">
                  <Input type="text" v-model="formRecord.c39" :disabled="formRecord.c61 !== '有' || help.c39"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c39" @click="showModal2('c39')"></Icon>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>最大制冷输入功率(W)</td>
              <td>
                <FormItem prop="c33">
                  <Input type="text" v-model="formRecord.c33" :disabled="help.c33"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c33" @click="showModal2('c33')"></Icon>
                </FormItem>
              </td>
              <td>最大制冷输入电流(A)</td>
              <td>
                <FormItem prop="c34">
                  <Input type="text" v-model="formRecord.c34" :disabled="help.c34"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c34" @click="showModal2('c34')"></Icon>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>室内机噪声dB（A）</td>
              <td>
                <FormItem prop="c40">
                  <Input type="text" v-model="formRecord.c40" :disabled="help.c40"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c40" @click="showModal2('c40')"></Icon>
                </FormItem>
              </td>
              <td>室外机噪声dB（A）</td>
              <td>
                <FormItem prop="c41">
                  <Input type="text" v-model="formRecord.c41" :disabled="help.c41"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c41" @click="showModal2('c41')"></Icon>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>适用面积（㎡）</td>
              <td>
                <FormItem prop="c42">
                  <Input type="text" v-model="formRecord.c42" :disabled="help.c42"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c42" @click="showModal2('c42')"></Icon>
                </FormItem>
              </td>
              <td>循环风量（m³/h）</td>
              <td>
                <FormItem prop="c56">
                  <Input type="text" v-model="formRecord.c56" :disabled="help.c56"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c56" @click="showModal2('c56')"></Icon>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>室内机质量（kg）</td>
              <td>
                <FormItem prop="c57">
                  <Input type="text" v-model="formRecord.c57" :disabled="help.c57"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c57" @click="showModal2('c57')"></Icon>
                </FormItem>
              </td>
              <td>室外机质量（kg）</td>
              <td>
                <FormItem prop="c58">
                  <Input type="text" v-model="formRecord.c58" :disabled="help.c58"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c58" @click="showModal2('c58')"></Icon>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>制热量(W)</td>
              <td>
                <FormItem prop="c43">
                  <Input type="text" v-model="formRecord.c43" :disabled="formRecord.c61 !== '有' || help.c43"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c43" @click="showModal2('c43')"></Icon>
                </FormItem>
              </td>
              <td>制热消耗功率(W)</td>
              <td>
                <FormItem prop="c44">
                  <Input type="text" v-model="formRecord.c44" :disabled="formRecord.c61 !== '有' || help.c44"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c44" @click="showModal2('c44')"></Icon>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>性能系数（COP）(W/W)</td>
              <td colspan="3">
                <FormItem prop="c45">
                  <Input type="text" v-model="formRecord.c45" :disabled="formRecord.c61 !== '有' || help.c45"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c45" @click="showModal2('c45')"></Icon>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>整机或室内机外形尺寸(长×宽×高)（mm×mm×mm）</td>
              <td>
                <FormItem prop="c46">
                  <Input type="text" v-model="formRecord.c46" style="width:80px;" :disabled="help.c46"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c46" @click="showModal2('c46')"></Icon>
                </FormItem>
                <span style="display: inline-block;height: 32px;line-height: 32px;">x</span>
                <FormItem prop="c52">
                  <Input type="text" v-model="formRecord.c52" style="width:80px;" :disabled="help.c52"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c52" @click="showModal2('c52')"></Icon>
                </FormItem>
                <span style="display: inline-block;height: 32px;line-height: 32px;">x</span>
                <FormItem prop="c53">
                  <Input type="text" v-model="formRecord.c53" style="width:80px;" :disabled="help.c53"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c53" @click="showModal2('c53')"></Icon>
                </FormItem>
              </td>
              <td>室外机外形尺寸(长×宽×高)（mm×mm×mm）</td>
              <td>
                <FormItem prop="c47">
                  <Input type="text" v-model="formRecord.c47" style="width:80px;" :disabled="help.c47"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c47" @click="showModal2('c47')"></Icon>
                </FormItem>
                <span style="display: inline-block;height: 32px;line-height: 32px;">x</span>
                <FormItem prop="c54">
                  <Input type="text" v-model="formRecord.c54" style="width:80px;" :disabled="help.c54"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c54" @click="showModal2('c54')"></Icon>
                </FormItem>
                <span style="display: inline-block;height: 32px;line-height: 32px;">x</span>
                <FormItem prop="c55">
                  <Input type="text" v-model="formRecord.c55" style="width:80px;" :disabled="help.c55"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c55" @click="showModal2('c55')"></Icon>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>制冷剂名称</td>
              <td>
                <FormItem prop="c48">
                  <Input type="text" v-model="formRecord.c48" :disabled="help.c48"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c48" @click="showModal2('c48')"></Icon>
                </FormItem>
              </td>
              <td>制冷剂灌注量(kg)</td>
              <td>
                <FormItem prop="c49">
                  <Input type="text" v-model="formRecord.c49" :disabled="help.c49"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c49" @click="showModal2('c49')"></Icon>
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
                <FormItem prop="c63">
                  <Input type="text" v-model="formRecord.c63" :disabled="help.c63"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c63" @click="showModal2('c63')"></Icon>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c64">
                  <Input type="text" v-model="formRecord.c64" :disabled="help.c64"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c64" @click="showModal2('c64')"></Icon>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c65">
                  <Input type="text" v-model="formRecord.c65" :disabled="help.c65"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c65" @click="showModal2('c65')"></Icon>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c66">
                  <Input type="text" v-model="formRecord.c66" :disabled="help.c66"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c66" @click="showModal2('c66')"></Icon>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c67">
                  <Input type="text" v-model="formRecord.c67" :disabled="help.c67"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c67" @click="showModal2('c67')"></Icon>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>
                <FormItem prop="c68">
                  <Input type="text" v-model="formRecord.c68" :disabled="help.c68"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c68" @click="showModal2('c68')"></Icon>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c69">
                  <Input type="text" v-model="formRecord.c69" :disabled="help.c69"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c69" @click="showModal2('c69')"></Icon>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c70">
                  <Input type="text" v-model="formRecord.c70" :disabled="help.c70"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c70" @click="showModal2('c70')"></Icon>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c71">
                  <Input type="text" v-model="formRecord.c71" :disabled="help.c71"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c71" @click="showModal2('c71')"></Icon>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c72">
                  <Input type="text" v-model="formRecord.c72" :disabled="help.c72"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c72" @click="showModal2('c72')"></Icon>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>
                <FormItem prop="c72">
                  <Input type="text" v-model="formRecord.c73" :disabled="help.c73"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c73" @click="showModal2('c73')"></Icon>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c72">
                  <Input type="text" v-model="formRecord.c74" :disabled="help.c74"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c74" @click="showModal2('c74')"></Icon>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c72">
                  <Input type="text" v-model="formRecord.c75" :disabled="help.c75"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c75" @click="showModal2('c75')"></Icon>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c72">
                  <Input type="text" v-model="formRecord.c76" :disabled="help.c76"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c76" @click="showModal2('c76')"></Icon>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c72">
                  <Input type="text" v-model="formRecord.c77" :disabled="help.c77"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c77" @click="showModal2('c77')"></Icon>
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
          <h2>七、其他认证信息</h2>
          <table>
            <tr>
              <td class="tc">3C认证证书编号</td>
              <td><Input type="text" v-model="formRecord.c202"></Input></td>
            </tr>
          </table>
        </Card>
      </div>
      <div class="part part8">
        <Card :bordered="false">
          <h2>八、附件部分</h2>
          <table>
            <tr>
              <td><span class="red">*</span>产品正面图片</td>
              <td>(JPG/PNG)</td>
              <td>
                <Upload
                  :show-upload-list=false
                  :format="['jpg','jpeg','png']"
                  :before-upload="fileHandleBeforeUpload24"
                  :data="uploadParam.fileData24"
                  :on-success="getFile24"
                  style="display:inline-block;"
                  :action="uploadUrl">
                  <Button icon="ios-cloud-upload-outline" type="primary">上传</Button>
                  <Icon type="ios-checkmark" v-show="checkmark24" />
                </Upload>
              </td>
              <td colspan="3">
                根据企业提交的相关能效指标，系统直接生成能效表示样本
                <Button type="primary" @click="showTemplate">查看模板</Button>
              </td>
            </tr>
            <tr>
              <td>OEM声明</td>
              <td>(JPG/PNG)</td>
              <td>
                <Upload
                  :show-upload-list=false
                  :format="['jpg','jpeg','png']"
                  :before-upload="fileHandleBeforeUpload26"
                  :data="uploadParam.fileData26"
                  :on-success="getFile26"
                  style="display:inline-block;"
                  :action="uploadUrl">
                  <Button icon="ios-cloud-upload-outline" type="primary">上传</Button>
                  <Icon type="ios-checkmark" v-show="checkmark26" />
                </Upload>
              </td>
              <td>关系证明</td>
              <td>（PDF）</td>
              <td>
                <Upload
                  :show-upload-list=false
                  :format="['pdf']"
                  :before-upload="fileHandleBeforeUpload27"
                  :data="uploadParam.fileData27"
                  :on-success="getFile27"
                  style="display:inline-block;"
                  :action="uploadUrl">
                  <Button icon="ios-cloud-upload-outline" type="primary">上传</Button>
                  <Icon type="ios-checkmark" v-show="checkmark27" />
                </Upload>
              </td>
            </tr>
            <tr>
              <td>品牌使用授权书</td>
              <td>(PDF)</td>
              <td>
                <Upload
                  :show-upload-list=false
                  :format="['pdf']"
                  :before-upload="fileHandleBeforeUpload28"
                  :data="uploadParam.fileData28"
                  :on-success="getFile28"
                  style="display:inline-block;"
                  :action="uploadUrl">
                  <Button icon="ios-cloud-upload-outline" type="primary">上传</Button>
                  <Icon type="ios-checkmark" v-show="checkmark28" />
                </Upload>
              </td>
              <td>委托代理文件</td>
              <td>（PDF）</td>
              <td>
                <Upload
                  :show-upload-list=false
                  :format="['pdf']"
                  :before-upload="fileHandleBeforeUpload29"
                  :data="uploadParam.fileData29"
                  :on-success="getFile29"
                  style="display:inline-block;"
                  :action="uploadUrl">
                  <Button icon="ios-cloud-upload-outline" type="primary">上传</Button>
                  <Icon type="ios-checkmark" v-show="checkmark29" />
                </Upload>
              </td>
            </tr>
            <tr>
              <td>进口商企业信息表</td>
              <td>(PDF)</td>
              <td>
                <Upload
                  :show-upload-list=false
                  :format="['pdf']"
                  :before-upload="fileHandleBeforeUpload30"
                  :data="uploadParam.fileData30"
                  :on-success="getFile30"
                  style="display:inline-block;"
                  :action="uploadUrl">
                  <Button icon="ios-cloud-upload-outline" type="primary">上传</Button>
                  <Icon type="ios-checkmark" v-show="checkmark30" />
                </Upload>
              </td>
              <td>进口商营业执照或登记注册证明复印件</td>
              <td>（PDF）</td>
              <td>
                <Upload
                  :show-upload-list=false
                  :format="['pdf']"
                  :before-upload="fileHandleBeforeUpload31"
                  :data="uploadParam.fileData31"
                  :on-success="getFile31"
                  style="display:inline-block;"
                  :action="uploadUrl">
                  <Button icon="ios-cloud-upload-outline" type="primary">上传</Button>
                  <Icon type="ios-checkmark" v-show="checkmark31" />
                </Upload>
              </td>
            </tr>
            <tr>
              <td>进口商与境外生产者订立的相关合同副本</td>
              <td>(PDF)</td>
              <td>
                <Upload
                  :show-upload-list=false
                  :format="['pdf']"
                  :before-upload="fileHandleBeforeUpload32"
                  :data="uploadParam.fileData32"
                  :on-success="getFile32"
                  style="display:inline-block;"
                  :action="uploadUrl">
                  <Button icon="ios-cloud-upload-outline" type="primary">上传</Button>
                  <Icon type="ios-checkmark" v-show="checkmark32" />
                </Upload>
              </td>
              <td><span class="red">*</span>铭牌照片</td>
              <td>（PDF/JPG/PNG）</td>
              <td>
                <Upload
                  :show-upload-list=false
                  :format="['jpg','jpeg','png']"
                  :before-upload="fileHandleBeforeUpload76"
                  :data="uploadParam.fileData76"
                  :on-success="getFile76"
                  style="display:inline-block;"
                  :action="uploadUrl">
                  <Button icon="ios-cloud-upload-outline" type="primary">上传</Button>
                  <Icon type="ios-checkmark" v-show="checkmark76" />
                </Upload>
              </td>
            </tr>
          </table>
          <p class="red">注：保存到草稿时，不保存附件！<br />所有附件上传文件大小需要控制在2M以内。</p>
        </Card>
      </div>
      <div>
        <CheckboxGroup v-model="confirmData">
          <Checkbox label="1"><span style="color:red;font-weight:bold;">我已确认以上数据填写无误！</span></Checkbox>
        </CheckboxGroup>
      </div>
      <div class="tc">
        <Button type="primary" @click="prevStep">上一步</Button>
        <Button type="primary" @click="saveRecord" :disabled="saveDisabled">保存到草稿</Button>
        <Button type="primary"  @click="showConfirm">提交备案审核申请</Button>
      </div>
    </Form>
    <Modal v-model="modal1" title="提交确认" ok-text="提交备案" cancel-text="再看看" @on-ok="submitRecord">
      <p style="font-size:16px;">请再次确认备案信息填写无误！</p>
      <p style="font-size:16px;">若确认，请点击“提交备案”按钮</p>
    </Modal>
    <Modal v-model="modal2" title="提交工单" @on-ok="submitWorkorder">
      <p style="font-size:18px;margin-bottom:10px;">实验室数值：{{currentValue}}</p>
      <Input type="textarea" :rows="3" placeholder="请描述问题" v-model="qus"></Input>
    </Modal>
    <Modal v-model="modal3" :width=820 :footer-hide=true>
      <img :src="templatePic" />
    </Modal>
  </div>
</template>
<script>
import axios from 'axios'
export default {
  data () {
    return {
      modal3: false,
      templatePic: '',
      modal2: false,
      currentValue: '',
      qus: '',
      currentCValue: '',
      confirmData: [],
      modal1: false,
      saveDisabled: false,
      submitDisabled: false,
      uploadUrl: '',
      uploadParam: {
        fileData24: {},
        uploadFileList24: [],
        fileData26: {},
        uploadFileList26: [],
        fileData27: {},
        uploadFileList27: [],
        fileData28: {},
        uploadFileList28: [],
        fileData29: {},
        uploadFileList29: [],
        fileData30: {},
        uploadFileList30: [],
        fileData31: {},
        uploadFileList31: [],
        fileData32: {},
        uploadFileList32: [],
        fileData76: {},
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
        c1: '',
        c2: '',
        c3: '',
        c4: '',
        c5: '',
        c7: '',
        c8: '',
        c9: '',
        c10: '',
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
      help: {
        c1: false,
        c2: false,
        c3: false,
        c4: false,
        c5: false,
        c7: false,
        c8: false,
        c9: false,
        c10: false,
        c12: false,
        c13: false,
        c14: false,
        c15: false,
        c16: false,
        c17: false,
        c18: false,
        c19: false,
        c20: false,
        c21: false,
        c22: false,
        c23: false,
        c24: false,
        c25: false,
        c26: false,
        c27: false,
        c28: false,
        c29: false,
        c30: false,
        c31: false,
        c32: false,
        c33: false,
        c34: false,
        c35: false,
        c36: false,
        c37: false,
        c38: false,
        c39: false,
        c40: false,
        c41: false,
        c42: false,
        c43: false,
        c44: false,
        c45: false,
        c46: false,
        c47: false,
        c48: false,
        c49: false,
        c50: false,
        c51: false,
        c52: false,
        c53: false,
        c54: false,
        c55: false,
        c56: false,
        c57: false,
        c58: false,
        c59: false,
        c61: false,
        c62: false,
        c63: false,
        c64: false,
        c65: false,
        c66: false,
        c67: false,
        c68: false,
        c69: false,
        c70: false,
        c71: false,
        c72: false,
        c73: false,
        c74: false,
        c75: false,
        c76: false,
        c77: false,
        c200: false,
        c202: false
      }
    }
  },
  mounted () {
    //this.removeStyle()
  },
  methods: {
    showTemplate () {
      this.templatePic = this.$store.state.app.pltPic
      this.modal3 = true
    },
    submitWorkorder () {
      if (this.qus === '') {
        this.$Message.warning('请描述问题！')
        //this.modal2 = true
        return
      }
      axios.get('/workorder/save.do', {
        params: {
          productType: 'T23',
          productTypeName: '房间空气调节器2010版',
          productModel: this.formRecord.c3,
          page: '备案页',
          details: this.currentCValue + '-' + this.currentValue + '-' + this.qus
        }
      }).then(res => {
        if (res.data.result === true) {
          this.$Message.success('提交成功！')
        }
      })
    },
    showModal2 (c) {
      this.currentCValue = c
      this.currentValue = this.formRecord[c]
      this.qus = ''
      this.modal2 = true
    },
    prevStep () {
      this.$emit('prevStep')
    },
    getRandom (type) {
      return (Math.random().toString().slice(2)) + type
    },
    getImgPath (dir) {
      let imgDir = dir
      let nowDate = new Date()
      let year = nowDate.getFullYear()
      let month = nowDate.getMonth() > 8 ? (nowDate.getMonth() + 1) : '0' + (nowDate.getMonth() + 1)
      let date = nowDate.getDate() > 9 ? nowDate.getDate() : '0' + nowDate.getDate()
      imgDir += year + '/' + month + '/' + date + '/'
      this.dir = imgDir
    },
    fileHandleBeforeUpload24 (file) {
      let _this = this
      let fileObj = {}
      this.uploadParam.uploadFileList24 = []
      const Fname = file.name
      const seat = Fname.lastIndexOf('.')
      const extension = Fname.substring(seat).toLowerCase()
      const gname = this.getRandom(extension)
      fileObj.ec_attach_id = '24'
      fileObj.ec_attach_originalname = file.name
      fileObj.ec_attach_file = gname
      Object.defineProperty(file, 'name', {
        writable: true,
        value: gname
      })
      return new Promise(function (resolve, reject) {
        axios.get('/oss/token.do').then(res => {
          if (_this.uploadParam.uploadFileList24.length > 0) {
            _this.$Notice.warning({
              title: '最多上传1个附件'
            })
            return false
          }
          let reader = new FileReader()
          reader.readAsDataURL(file)
          reader.onloadend = (e) => {
            file.url = reader.result
            _this.uploadParam.uploadFileList24.push(file)
          }
          _this.getImgPath(res.data.dir)
          _this.uploadParam.fileData24['key'] = _this.dir + file.name
          _this.uploadParam.fileData24['policy'] = res.data.policy
          _this.uploadParam.fileData24['OSSAccessKeyId'] = res.data.accessid
          _this.uploadParam.fileData24['success_action_status'] = '200'
          _this.uploadParam.fileData24['signature'] = res.data.signature
          _this.uploadUrl = res.data.host
          fileObj.ec_attach_path = res.data.host + _this.dir + file.name
          _this.filesArr.push(fileObj)
          resolve()
        })
      })
    },
    fileHandleBeforeUpload26 (file) {
      let _this = this
      let fileObj = {}
      this.uploadParam.uploadFileList26 = []
      const Fname = file.name
      const seat = Fname.lastIndexOf('.')
      const extension = Fname.substring(seat).toLowerCase()
      const gname = this.getRandom(extension)
      fileObj.ec_attach_id = '26'
      fileObj.ec_attach_originalname = file.name
      fileObj.ec_attach_file = gname
      Object.defineProperty(file, 'name', {
        writable: true,
        value: gname
      })
      return new Promise(function (resolve, reject) {
        axios.get('/oss/token.do').then(res => {
          if (_this.uploadParam.uploadFileList26.length > 0) {
            _this.$Notice.warning({
              title: '最多上传1个附件'
            })
            return false
          }
          let reader = new FileReader()
          reader.readAsDataURL(file)
          reader.onloadend = (e) => {
            file.url = reader.result
            _this.uploadParam.uploadFileList26.push(file)
          }
          _this.getImgPath(res.data.dir)
          _this.uploadParam.fileData26['key'] = _this.dir + file.name
          _this.uploadParam.fileData26['policy'] = res.data.policy
          _this.uploadParam.fileData26['OSSAccessKeyId'] = res.data.accessid
          _this.uploadParam.fileData26['success_action_status'] = '200'
          _this.uploadParam.fileData26['signature'] = res.data.signature
          _this.uploadUrl = res.data.host
          fileObj.ec_attach_path = res.data.host + _this.dir + file.name
          _this.filesArr.push(fileObj)
          resolve()
        })
      })
    },
    fileHandleBeforeUpload27 (file) {
      let _this = this
      let fileObj = {}
      this.uploadParam.uploadFileList27 = []
      const Fname = file.name
      const seat = Fname.lastIndexOf('.')
      const extension = Fname.substring(seat).toLowerCase()
      const gname = this.getRandom(extension)
      fileObj.ec_attach_id = '27'
      fileObj.ec_attach_originalname = file.name
      fileObj.ec_attach_file = gname
      Object.defineProperty(file, 'name', {
        writable: true,
        value: gname
      })
      return new Promise(function (resolve, reject) {
        axios.get('/oss/token.do').then(res => {
          if (_this.uploadParam.uploadFileList27.length > 0) {
            _this.$Notice.warning({
              title: '最多上传1个附件'
            })
            return false
          }
          let reader = new FileReader()
          reader.readAsDataURL(file)
          reader.onloadend = (e) => {
            file.url = reader.result
            _this.uploadParam.uploadFileList27.push(file)
          }
          _this.getImgPath(res.data.dir)
          _this.uploadParam.fileData27['key'] = _this.dir + file.name
          _this.uploadParam.fileData27['policy'] = res.data.policy
          _this.uploadParam.fileData27['OSSAccessKeyId'] = res.data.accessid
          _this.uploadParam.fileData27['success_action_status'] = '200'
          _this.uploadParam.fileData27['signature'] = res.data.signature
          _this.uploadUrl = res.data.host
          fileObj.ec_attach_path = res.data.host + _this.dir + file.name
          _this.filesArr.push(fileObj)
          resolve()
        })
      })
    },
    fileHandleBeforeUpload28 (file) {
      let _this = this
      let fileObj = {}
      this.uploadParam.uploadFileList28 = []
      const Fname = file.name
      const seat = Fname.lastIndexOf('.')
      const extension = Fname.substring(seat).toLowerCase()
      const gname = this.getRandom(extension)
      fileObj.ec_attach_id = '28'
      fileObj.ec_attach_originalname = file.name
      fileObj.ec_attach_file = gname
      Object.defineProperty(file, 'name', {
        writable: true,
        value: gname
      })
      return new Promise(function (resolve, reject) {
        axios.get('/oss/token.do').then(res => {
          if (_this.uploadParam.uploadFileList28.length > 0) {
            _this.$Notice.warning({
              title: '最多上传1个附件'
            })
            return false
          }
          let reader = new FileReader()
          reader.readAsDataURL(file)
          reader.onloadend = (e) => {
            file.url = reader.result
            _this.uploadParam.uploadFileList28.push(file)
          }
          _this.getImgPath(res.data.dir)
          _this.uploadParam.fileData28['key'] = _this.dir + file.name
          _this.uploadParam.fileData28['policy'] = res.data.policy
          _this.uploadParam.fileData28['OSSAccessKeyId'] = res.data.accessid
          _this.uploadParam.fileData28['success_action_status'] = '200'
          _this.uploadParam.fileData28['signature'] = res.data.signature
          _this.uploadUrl = res.data.host
          fileObj.ec_attach_path = res.data.host + _this.dir + file.name
          _this.filesArr.push(fileObj)
          resolve()
        })
      })
    },
    fileHandleBeforeUpload29 (file) {
      let _this = this
      let fileObj = {}
      this.uploadParam.uploadFileList29 = []
      const Fname = file.name
      const seat = Fname.lastIndexOf('.')
      const extension = Fname.substring(seat).toLowerCase()
      const gname = this.getRandom(extension)
      fileObj.ec_attach_id = '29'
      fileObj.ec_attach_originalname = file.name
      fileObj.ec_attach_file = gname
      Object.defineProperty(file, 'name', {
        writable: true,
        value: gname
      })
      return new Promise(function (resolve, reject) {
        axios.get('/oss/token.do').then(res => {
          if (_this.uploadParam.uploadFileList29.length > 0) {
            _this.$Notice.warning({
              title: '最多上传1个附件'
            })
            return false
          }
          let reader = new FileReader()
          reader.readAsDataURL(file)
          reader.onloadend = (e) => {
            file.url = reader.result
            _this.uploadParam.uploadFileList29.push(file)
          }
          _this.getImgPath(res.data.dir)
          _this.uploadParam.fileData29['key'] = _this.dir + file.name
          _this.uploadParam.fileData29['policy'] = res.data.policy
          _this.uploadParam.fileData29['OSSAccessKeyId'] = res.data.accessid
          _this.uploadParam.fileData29['success_action_status'] = '200'
          _this.uploadParam.fileData29['signature'] = res.data.signature
          _this.uploadUrl = res.data.host
          fileObj.ec_attach_path = res.data.host + _this.dir + file.name
          _this.filesArr.push(fileObj)
          resolve()
        })
      })
    },
    fileHandleBeforeUpload30 (file) {
      let _this = this
      let fileObj = {}
      this.uploadParam.uploadFileList30 = []
      const Fname = file.name
      const seat = Fname.lastIndexOf('.')
      const extension = Fname.substring(seat).toLowerCase()
      const gname = this.getRandom(extension)
      fileObj.ec_attach_id = '30'
      fileObj.ec_attach_originalname = file.name
      fileObj.ec_attach_file = gname
      Object.defineProperty(file, 'name', {
        writable: true,
        value: gname
      })
      return new Promise(function (resolve, reject) {
        axios.get('/oss/token.do').then(res => {
          if (_this.uploadParam.uploadFileList30.length > 0) {
            _this.$Notice.warning({
              title: '最多上传1个附件'
            })
            return false
          }
          let reader = new FileReader()
          reader.readAsDataURL(file)
          reader.onloadend = (e) => {
            file.url = reader.result
            _this.uploadParam.uploadFileList30.push(file)
          }
          _this.getImgPath(res.data.dir)
          _this.uploadParam.fileData30['key'] = _this.dir + file.name
          _this.uploadParam.fileData30['policy'] = res.data.policy
          _this.uploadParam.fileData30['OSSAccessKeyId'] = res.data.accessid
          _this.uploadParam.fileData30['success_action_status'] = '200'
          _this.uploadParam.fileData30['signature'] = res.data.signature
          _this.uploadUrl = res.data.host
          fileObj.ec_attach_path = res.data.host + _this.dir + file.name
          _this.filesArr.push(fileObj)
          resolve()
        })
      })
    },
    fileHandleBeforeUpload31 (file) {
      let _this = this
      let fileObj = {}
      this.uploadParam.uploadFileList31 = []
      const Fname = file.name
      const seat = Fname.lastIndexOf('.')
      const extension = Fname.substring(seat).toLowerCase()
      const gname = this.getRandom(extension)
      fileObj.ec_attach_id = '31'
      fileObj.ec_attach_originalname = file.name
      fileObj.ec_attach_file = gname
      Object.defineProperty(file, 'name', {
        writable: true,
        value: gname
      })
      return new Promise(function (resolve, reject) {
        axios.get('/oss/token.do').then(res => {
          if (_this.uploadParam.uploadFileList31.length > 0) {
            _this.$Notice.warning({
              title: '最多上传1个附件'
            })
            return false
          }
          let reader = new FileReader()
          reader.readAsDataURL(file)
          reader.onloadend = (e) => {
            file.url = reader.result
            _this.uploadParam.uploadFileList31.push(file)
          }
          _this.getImgPath(res.data.dir)
          _this.uploadParam.fileData31['key'] = _this.dir + file.name
          _this.uploadParam.fileData31['policy'] = res.data.policy
          _this.uploadParam.fileData31['OSSAccessKeyId'] = res.data.accessid
          _this.uploadParam.fileData31['success_action_status'] = '200'
          _this.uploadParam.fileData31['signature'] = res.data.signature
          _this.uploadUrl = res.data.host
          fileObj.ec_attach_path = res.data.host + _this.dir + file.name
          _this.filesArr.push(fileObj)
          resolve()
        })
      })
    },
    fileHandleBeforeUpload32 (file) {
      let _this = this
      let fileObj = {}
      this.uploadParam.uploadFileList32 = []
      const Fname = file.name
      const seat = Fname.lastIndexOf('.')
      const extension = Fname.substring(seat).toLowerCase()
      const gname = this.getRandom(extension)
      fileObj.ec_attach_id = '32'
      fileObj.ec_attach_originalname = file.name
      fileObj.ec_attach_file = gname
      Object.defineProperty(file, 'name', {
        writable: true,
        value: gname
      })
      return new Promise(function (resolve, reject) {
        axios.get('/oss/token.do').then(res => {
          if (_this.uploadParam.uploadFileList32.length > 0) {
            _this.$Notice.warning({
              title: '最多上传1个附件'
            })
            return false
          }
          let reader = new FileReader()
          reader.readAsDataURL(file)
          reader.onloadend = (e) => {
            file.url = reader.result
            _this.uploadParam.uploadFileList32.push(file)
          }
          _this.getImgPath(res.data.dir)
          _this.uploadParam.fileData32['key'] = _this.dir + file.name
          _this.uploadParam.fileData32['policy'] = res.data.policy
          _this.uploadParam.fileData32['OSSAccessKeyId'] = res.data.accessid
          _this.uploadParam.fileData32['success_action_status'] = '200'
          _this.uploadParam.fileData32['signature'] = res.data.signature
          _this.uploadUrl = res.data.host
          fileObj.ec_attach_path = res.data.host + _this.dir + file.name
          _this.filesArr.push(fileObj)
          resolve()
        })
      })
    },
    fileHandleBeforeUpload76 (file) {
      let _this = this
      let fileObj = {}
      this.uploadParam.uploadFileList76 = []
      const Fname = file.name
      const seat = Fname.lastIndexOf('.')
      const extension = Fname.substring(seat).toLowerCase()
      const gname = this.getRandom(extension)
      fileObj.ec_attach_id = '76'
      fileObj.ec_attach_originalname = file.name
      fileObj.ec_attach_file = gname
      Object.defineProperty(file, 'name', {
        writable: true,
        value: gname
      })
      return new Promise(function (resolve, reject) {
        axios.get('/oss/token.do').then(res => {
          if (_this.uploadParam.uploadFileList76.length > 0) {
            _this.$Notice.warning({
              title: '最多上传1个附件'
            })
            return false
          }
          let reader = new FileReader()
          reader.readAsDataURL(file)
          reader.onloadend = (e) => {
            file.url = reader.result
            _this.uploadParam.uploadFileList76.push(file)
          }
          _this.getImgPath(res.data.dir)
          _this.uploadParam.fileData76['key'] = _this.dir + file.name
          _this.uploadParam.fileData76['policy'] = res.data.policy
          _this.uploadParam.fileData76['OSSAccessKeyId'] = res.data.accessid
          _this.uploadParam.fileData76['success_action_status'] = '200'
          _this.uploadParam.fileData76['signature'] = res.data.signature
          _this.uploadUrl = res.data.host
          fileObj.ec_attach_path = res.data.host + _this.dir + file.name
          _this.filesArr.push(fileObj)
          resolve()
        })
      })
    },
    removeStyle () {
      let eArr1 = document.getElementById('table1').getElementsByClassName('ivu-form-item-content')
      let eArr3 = document.getElementById('table3').getElementsByClassName('ivu-form-item-content')
      let eArr4 = document.getElementById('table4').getElementsByClassName('ivu-form-item-content')
      for (let i=0;i<eArr1.length;i++) {
        eArr1[i].removeAttribute("style")
      }
      for (let i=0;i<eArr3.length;i++) {
        eArr3[i].removeAttribute("style")
      }
      for (let i=0;i<eArr4.length;i++) {
        eArr4[i].removeAttribute("style")
      }
    },
    fillDraftData (data) {
      let that = this
      for(let i in data) {
        if (i === 'title' || i === 'result_code') {

        } else if (i === 'marking') {
          that.$store.commit('setPtId', data[i].ptid)
          that.$store.commit('setPltId', data[i].pltId)
          that.$store.commit('setRid', data[i].ec_labreport_id)
          that.$store.commit('setBarcode', data[i].ec_labreport_no)
          that.$store.commit('setLabName', data[i].ec_labname)
          that.formRecord.id = data[i].id
        } else {
          that.formRecord[i] = data[i]
        }
      }
    },
    fillDefaultData () {
      let that = this
      this.formRecord.c200 = this.$store.state.app.gb
      this.$store.state.app.defaultData.forEach((e) => {
        if (e.labValue === '/'  || e.labValue == null) {
          that.formRecord[e.recId] = ''
        } else {
          this.help[e.recId] = true
          if (e.recId === 'c51') {
            if (parseInt(e.labValue) !== 1 && parseInt(e.labValue) !== 2 && parseInt(e.labValue) !== 3) {
              that.formRecord[e.recId] = '1'
            } else {
              that.formRecord[e.recId] = parseInt(e.labValue).toString()
            }
          } else if (e.recId === 'c9' && isNaN(e.labValue)) {
            that.formRecord[e.recId] = new Date()
          } else {
            that.formRecord[e.recId] = e.labValue
          }
        }
      })
    },
    showConfirm () {
      let _this = this
      if (this.uploadParam.uploadFileList24.length === 0) {
        this.$Message.warning('请上传产品正面图片！')
        return false
      }
      if (this.uploadParam.uploadFileList76.length === 0) {
        this.$Message.warning('请上传铭牌图片！')
        return false
      }
      this.$refs['formRecord'].validate((valid) => {
        if (valid) {
          if (this.confirmData.join('') == 1) {
            this.modal1 = true
          } else {
            this.$Message.warning('请勾选我已确认以上数据填写无误选项')
          }
        }
      })
    },
    submitRecord () {
      let _this = this
      this.formRecord.c15 = this.formatDate(this.formRecord.c15)
      this.formRecord.ptid = this.$store.state.app.ptId
      this.formRecord.pltId = this.$store.state.app.pltId
      this.formRecord.record_type = 0
      this.formRecord.ec_labreport_id = this.$store.state.app.rid
      this.formRecord.ec_labreport_no = this.$store.state.app.barcode
      this.formRecord.ec_labname = this.$store.state.app.labName
      this.formRecord.attach_list = JSON.stringify(this.filesArr)
      axios({
        url: '/marking/save.do',
        method: 'POST',
        data: _this.formRecord,
        transformRequest: [function (data) {
          let ret = ''
          for (let it in data) {
            ret += encodeURIComponent(it) + '=' + encodeURIComponent(data[it]) + '&'
          }
          return ret
        }],
        headers: {
          'Content-Type': 'application/x-www-form-urlencoded'
        }
      })
      .then(res => {
        if (res.data.result_code === '1') {
          let txt = _this.$store.state.app.pltId === 244 ? '请自行上传标识图' : '备案正在自动公告中。'
          _this.$Modal.success({
            title: '提交成功',
            content: '<p>备案数据已经提交成功！</p><p>' + txt + '</p><p>完成操作后将同步到备案系统</p>',
            okText: '查看详情',
            onOk () {
              _this.$router.push('/queryRecord')
            }
          })
        } else {
          _this.$Message.warning(res.data.message)
          _this.submitDisabled = false
        }
      })
    },
    saveRecord () {
      this.saveDisabled = true
      let _this = this
      this.formRecord.c15 = this.formatDate(this.formRecord.c15)
      this.formRecord.ptid = this.$store.state.app.ptId
      this.formRecord.pltId = this.$store.state.app.pltId
      this.formRecord.record_type = 0
      this.formRecord.ec_labreport_id = this.$store.state.app.rid
      this.formRecord.ec_labreport_no = this.$store.state.app.barcode
      this.formRecord.ec_labname = this.$store.state.app.labName
      axios({
        url: '/marking/saveDraft.do',
        method: 'POST',
        data: this.formRecord,
        transformRequest: [function (data) {
          let ret = ''
          for (let it in data) {
            ret += encodeURIComponent(it) + '=' + encodeURIComponent(data[it]) + '&'
          }
          return ret
        }],
        headers: {
          'Content-Type': 'application/x-www-form-urlencoded'
        }
      })
      .then(res => {
        if (res.data.result_code === '1') {
          _this.$Modal.success({
            title: '保存成功',
            content: '<p>备案数据已经保存成功！</p>',
            okText: '查看详情',
            onOk () {
              _this.$router.push('/draftBox')
            }
          })
        } else {
          this.$Message.warning(res.data.message)
          this.saveDisabled = false
        }
      })
    },
    formatDate (d) {
      let date = new Date(d)
      let year = date.getFullYear()
      let month = date.getMonth() > 8 ? date.getMonth() + 1 : '0' + (date.getMonth() + 1)
      let day = date.getDate() > 9 ? date.getDate() : '0' + date.getDate()
      return year + '-' + month + '-' + day
    },
    getFile24 (res, file) {
      this.checkmark24 = true
    },
    getFile26 (res, file) {
      this.checkmark26 = true
    },
    getFile27 (res, file) {
      this.checkmark27 = true
    },
    getFile28 (res, file) {
      this.checkmark28 = true
    },
    getFile29 (res, file) {
      this.checkmark29 = true
    },
    getFile30 (res, file) {
      this.checkmark30 = true
    },
    getFile31 (res, file) {
      this.checkmark31 = true
    },
    getFile32 (res, file) {
      this.checkmark32 = true
    },
    getFile76 (res, file) {
      this.checkmark76 = true
    }
  },
  computed: {
    pltId () {
      return this.$store.state.app.pltId
    },
    pltPic () {
      return this.$store.state.app.pltPic
    },
    ruleRecord () {
      let decimal1 =/^(([1-9]{1}\d*)|(0{1}))(\.\d{1})$/
      let decimal2 = /^(([1-9]{1}\d*)|(0{1}))(\.\d{2})$/
      let decimal3 = /^(([1-9]{1}\d*)|(0{1}))(\.\d{3})$/
      let decimal25 = /^(([1-9]{1}\d*)|(0{1}))(\.\d{2,5})$/
      let decimal15 = /^(([1-9]{1}\d*)|(0{1}))(\.\d{1,5})$/
      let c51 = Number(this.formRecord.c51)
      let c16 = this.formRecord.c16
      let c6 = parseFloat(this.formRecord.c6)

      let getError = function (z, a, b, c) {
        switch (c51) {
          case 1: z = '>=' + a;break
          case 2: z = '>=' + b + '且<' + a;break
          case 3: z = '>=' + c + '且<' + b;break
        }
      }
      let checkc7 = (rule, value, callback) => {
        let c7 = parseFloat(this.formRecord.c7)
        if (c7 < (c6 * 0.95)) {
          callback("实测制冷量不应小于额定制冷量的95%")
        } else {
          callback()
        }
      }
      let checkc10 = (rule, value, callback) => {
        let c9 = parseFloat(this.formRecord.c9)
        let c10 = parseFloat(this.formRecord.c10)
        if (c10 > (c9 * 1.1)) {
          callback("实测制冷消耗功率不应大于额定制冷消耗功率的110%")
        } else {
          callback()
        }
      }
      let checkc12 = (rule, value, callback) => {
        if (!this.help.c12 && this.formRecord.c12 !== '' && !decimal2.test(this.help.c12)) {
          callback('两位小数')
        } else {
          callback()
        }
        let c9 = parseFloat(this.formRecord.c9)
        let c12 = parseFloat(this.formRecord.c12)
        let _c12val = (c6 / c9).toFixed(2)//能效比：_c12val ＝ C6／C9，保留两位小数
        //能效比标注值和国标比对
        let rangec12 = ''

        if (c16 === "分体式") {
          if (c6 <= 4500) {
            getError(rangec12, 3.60, 3.40, 3.20)
          } else if (c6 > 4500 && c6 <= 7100) {
            getError(rangec12, 3.50, 3.30, 3.10)
          } else if (c6 > 7100 && c6 <= 14000) {
            getError(rangec12, 3.40, 3.20, 3.00)
          }
        } else {
          getError(rangec12, 3.30, 3.10, 2.90)
        }
        if (c12 < _c12val) {
          callback('能效比标称值应>=' + _c12val)
        } else {
          if (rangec12 !== '') {
            callback(rangec12)
          } else {
            callback()
          }
        }
      }
      let checkc13 = (rule, value, callback) => {
        if (!this.help.c13 && this.formRecord.c13 !== '' && !decimal2.test(this.help.c13)) {
          callback('两位小数')
        } else {
          callback()
        }
        let rangec13 = ''
        //实测能效比不应小于能效限定值
        let c13 = parseFloat(this.formRecord.c13)
        if (c16 === "分体式") {
          if (c6 <= 4500) {
            getError(rangec13, 3.60, 3.40, 3.20)
          } else if (c6 > 4500 && c6 <= 7100) {
            getError(rangec13, 3.50, 3.30, 3.10)
          } else if (c6 > 7100 && c6 <= 14000) {
            getError(rangec13, 3.40, 3.20, 3.00)
          }
        } else {
          getError(rangec13, 3.30, 3.10, 2.90)
        }
        //实测能效比大于等于能效限定值
        if (c13 < rangec13) {
          callback("实测能效比不应小于能效限定值范围"+rangec13)
        } else {
          callback()
        }
      }
      let checkc30 = (rule, value, callback) => {
        if (!this.help.c30 && this.formRecord.c30 !== '' && !decimal1.test(this.help.c30)) {
          callback('一位小数')
        } else {
          callback()
        }
      }
      let checkc34 = (rule, value, callback) => {
        if (!this.help.c34 && this.formRecord.c34 !== '' && !decimal1.test(this.help.c34)) {
          callback('一位小数')
        } else {
          callback()
        }
      }
      let checkc39 = (rule, value, callback) => {
        if (!this.help.c39 && this.formRecord.c39 !== '' && !decimal1.test(this.help.c39)) {
          callback('一位小数')
        } else {
          callback()
        }
      }
      return {
        c2: [
          {
            required: true,
            message: '请填写制造单位'
          }
        ],
        c50: [
          {
            required: true,
            message: '请填写备案方'
          }
        ],
        c4: [
          {
            required: true,
            message: '请填写商标'
          }
        ],
        c5: [
          {
            required: true,
            message: '请选择类型'
          }
        ],
        c51: [
          {
            required: true,
            message: '请选择能效等级'
          }
        ],
        c6: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c7: [
          {
            required: true,
            message: '不能为空'
          },
          {
            validator: checkc7,
            trigger: 'blur'
          }
        ],
        c9: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c10: [
          {
            required: true,
            message: '不能为空'
          },
          {
            validator: checkc10,
            trigger: 'blur'
          }
        ],
        c12: [
          {
            required: true,
            message: '不能为空'
          },
          // {
          //   pattern: decimal2,
          //   message: '两位小数'
          // },
          {
            validator: checkc12,
            trigger: 'blur'
          }
        ],
        c13: [
          {
            required: true,
            message: '不能为空'
          },
          // {
          //   pattern: decimal2,
          //   message: '两位小数'
          // },
          {
            validator: checkc13,
            trigger: 'blur'
          }
        ],
        c15: [
          {
            required: true,
            message: '不能为空'
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
            required: true,
            message: '不能为空'
          }
        ],
        c18: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c19: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c20: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c21: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c22: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c23: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c24: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c25: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c26: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c27: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c28: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c29: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c30: [
          {
            required: true,
            message: '不能为空'
          },
          // {
          //   pattern: decimal1,
          //   message: '一位小数'
          // },
          {
            validator: checkc30,
            trigger: 'blur'
          }
        ],
        c31: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c32: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c33: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c34: [
          {
            required: true,
            message: '不能为空'
          },
          // {
          //   pattern: decimal1,
          //   message: '一位小数'
          // },
          {
            validator: checkc34,
            trigger: 'blur'
          }
        ],
        c35: [
          {
            required: this.formRecord.c61 === '有',
            message: '不能为空'
          }
        ],
        c36: [
          {
            required: this.formRecord.c61 === '有',
            message: '不能为空'
          }
        ],
        c37: [
          {
            required: this.formRecord.c61 === '有',
            message: '不能为空'
          }
        ],
        c38: [
          {
            required: this.formRecord.c61 === '有',
            message: '不能为空'
          }
        ],
        c39: [
          {
            required: this.formRecord.c61 === '有',
            message: '不能为空'
          },
          // {
          //   pattern: decimal1,
          //   message: '一位小数'
          // },
          {
            validator: checkc39,
            trigger: 'blur'
          }
        ],
        c40: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c41: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c42: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c43: [
          {
            required: this.formRecord.c61 === '有',
            message: '不能为空'
          }
        ],
        c44: [
          {
            required: this.formRecord.c61 === '有',
            message: '不能为空'
          }
        ],
        c45: [
          {
            required: this.formRecord.c61 === '有',
            message: '不能为空'
          }
        ],
        c46: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c47: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c48: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c49: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c50: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c51: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c52: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c53: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c54: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c55: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c56: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c57: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c58: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c59: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c60: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c61: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c62: [
          {
            required: this.formRecord.c5 === '其他',
            message: '不能为空'
          }
        ],
        c63: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c64: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c65: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c66: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c67: [
          {
            required: true,
            message: '不能为空'
          }
        ]
      }
    }
  }
}
</script>
<style lang="less" scoped>
h1{
  font-size:20px;
}
h2{
  font-size:18px;
  margin:10px 0;
}
.part{
  background:#eee;
  padding: 15px;
  margin: 15px 0;
}
.part1 p{
  text-indent:2em;
  font-size:16px;
  line-height:36px;
}
table{
  width:1000px;
  border-collapse:collapse;
  margin-bottom:10px;
}
table th{
  background-color: rgb(245, 245, 246);
}
table td,table th{
  border:1px solid #dddee1;
  padding:10px;
}
.part6 td>div{
  margin-bottom:5px;
}
.part6 td span{
  display:inline-block;
  width:100px;
  text-align:center;
}
.tc{
  text-align:center;
}
.part8 td{
  text-align:center;
}
.red{
  color:red;
}
#table1 td,#table2 td,#table3 td,#table4 td{
  padding:20px 10px;
}
#table1 .ivu-form-item,#table2 .ivu-form-item,#table3 .ivu-form-item,#table4 .ivu-form-item{
  margin-bottom:0!important;
}
#table2 .ivu-form-item,#table3 .ivu-form-item,#table4 .ivu-form-item{
  display:inline-block;
}
#table1 .ivu-form-item-content{
  margin-left:0!important;
}
.ivu-icon-ios-help-circle-outline{
  position:absolute;
  top:-8px;
  right:-2px;
}
.ivu-icon-ios-help-circle-outline:before{
  content:"\F446";
}
</style>
