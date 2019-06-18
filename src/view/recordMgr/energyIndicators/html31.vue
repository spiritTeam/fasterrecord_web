<template>
  <div class="wrapper">
    <Form ref="formRecord" :model="formRecord" label-position="right" :rules="ruleRecord">
      <h1>电动洗衣机 修订-能源效率标识备案表</h1>
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
          <FormItem prop="c3" label="制造单位" style="width:1000px;" :label-width="180">
            <Input type="text" v-model="formRecord.c3" placeholder="制造单位" :disabled="help.c3"></Input>
            <Icon type="ios-help-circle-outline" size="20" v-if="help.c3" @click="showModal2('c3')"></Icon>
          </FormItem>
          <FormItem prop="c36" label="备案方" style="width:1000px;" :label-width="180">
            <Input type="text" v-model="formRecord.c36" placeholder="备案方" :disabled="help.c36"></Input>
            <Icon type="ios-help-circle-outline" size="20" v-if="help.c36" @click="showModal2('c36')"></Icon>
          </FormItem>
          <FormItem prop="c2" label="产品规格型号" style="width:1000px;" :label-width="180">
            <Input type="text" v-model="formRecord.c2" placeholder="规格型号" readonly :disabled="help.c2"></Input>
            <Icon type="ios-help-circle-outline" size="20" v-if="help.c2" @click="showModal2('c2')"></Icon>
          </FormItem>
          <FormItem prop="c4" label="商标" style="width:1000px;" :label-width="180">
            <Input type="text" v-model="formRecord.c4" placeholder="商标" :disabled="help.c4"></Input>
            <Icon type="ios-help-circle-outline" size="20" v-if="help.c4" @click="showModal2('c4')"></Icon>
          </FormItem>
          <FormItem prop="c200" label="依据国家标准" style="width:1000px;" :label-width="180">
            <Input type="text" v-model="formRecord.c200" placeholder="依据国家标准" readonly disabled></Input>
            <Icon type="ios-help-circle-outline" size="20" v-if="help.c200" @click="showModal2('c200')"></Icon>
          </FormItem>
          <FormItem prop="c6" label="能效等级" style="width:1000px;" :label-width="180">
            <RadioGroup v-model="formRecord.c6">
              <Radio label="1" :disabled="help.c6">1级</Radio>
              <Radio label="2" :disabled="help.c6">2级</Radio>
              <Radio label="3" :disabled="help.c6">3级</Radio>
              <Radio label="4" :disabled="help.c6">4级</Radio>
              <Radio label="5" :disabled="help.c6">5级</Radio>
            </RadioGroup>
            <Icon type="ios-help-circle-outline" size="20" v-if="help.c6" @click="showModal2('c6')"></Icon>
          </FormItem>
          <table id="table1">
            <tr>
              <th>项目</th>
              <th>标称值</th>
              <th>实测值</th>
              <th>备注</th>
            </tr>
            <tr>
              <td>耗电量（千瓦时/工作周期）</td>
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
              <td>/</td>
            </tr>
            <tr>
              <td>单位功效耗电量</td>
              <td colspan="3">
                <FormItem prop="c37">
                  <Input type="text" v-model="formRecord.c37" :disabled="help.c37"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c37" @click="showModal2('c37')"></Icon>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>用水量（升/工作周期）</td>
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
              <td>/</td>
            </tr>
            <tr>
              <td>单位功效用水量</td>
              <td colspan="3">
                <FormItem prop="c38">
                  <Input type="text" v-model="formRecord.c38" :disabled="help.c38"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c38" @click="showModal2('c38')"></Icon>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>洗净比</td>
              <td>
                <FormItem prop="c11">
                  <Input type="text" v-model="formRecord.c11" :disabled="help.c11"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c11" @click="showModal2('c11')"></Icon>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c12">
                  <Input type="text" v-model="formRecord.c12" :disabled="help.c12"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c12" @click="showModal2('c12')"></Icon>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c39">
                  <Input type="text" v-model="formRecord.c39" :disabled="help.c39"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c39" @click="showModal2('c39')"></Icon>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>额定洗涤容量（公斤）</td>
              <td>
                <FormItem prop="c29">
                  <Input type="text" v-model="formRecord.c29" :disabled="help.c29"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c29" @click="showModal2('c29')"></Icon>
                </FormItem>
              </td>
              <td>/</td>
              <td>
                <FormItem prop="c43">
                  <Input type="text" v-model="formRecord.c43" :disabled="help.c43"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c43" @click="showModal2('c43')"></Icon>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>额定脱水容量（公斤）</td>
              <td>
                <FormItem prop="c30">
                  <Input type="text" v-model="formRecord.c30" :disabled="help.c30"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c30" @click="showModal2('c30')"></Icon>
                </FormItem>
              </td>
              <td>/</td>
              <td>
                <FormItem prop="c44">
                  <Input type="text" v-model="formRecord.c44" :disabled="help.c44"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c44" @click="showModal2('c44')"></Icon>
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
              <td rowspan="3" width="20%">产品类型</td>
              <td colspan="3">
                <FormItem prop="c27">
                  <RadioGroup v-model="formRecord.c27">
                    <Radio label="波轮式" :disabled="help.c27">波轮式</Radio>
                    <Radio label="滚筒式" :disabled="help.c27">滚筒式</Radio>
                    <Radio label="搅拌式" :disabled="help.c27">搅拌式</Radio>
                  </RadioGroup>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c27" @click="showModal2('c27')"></Icon>
                </FormItem>
                <FormItem prop="c59">
                  <Input type="text" v-model="formRecord.c59" :disabled="formRecord.c27 !== '其他' || help.c59"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c59" @click="showModal2('c59')"></Icon>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td colspan="3">
                <FormItem prop="c40">
                  <RadioGroup v-model="formRecord.c40">
                    <Radio label="双桶" :disabled="help.c40">双桶</Radio>
                    <Radio label="单桶" :disabled="help.c40">单桶</Radio>
                    <Radio label="套桶" :disabled="help.c40">套桶</Radio>
                  </RadioGroup>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c40" @click="showModal2('c40')"></Icon>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td colspan="3">
                <FormItem prop="c26">
                  <RadioGroup v-model="formRecord.c26">
                    <Radio label="普通型洗衣机" :disabled="help.c26">普通型洗衣机</Radio>
                    <Radio label="半自动型洗衣机" :disabled="help.c26">半自动型洗衣机</Radio>
                    <Radio label="全自动型洗衣机" :disabled="help.c26">全自动型洗衣机</Radio>
                  </RadioGroup>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c26" @click="showModal2('c26')"></Icon>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>电源类型</td>
              <td width="30%">
                <FormItem prop="c41">
                  <RadioGroup v-model="formRecord.c41">
                    <Radio label="单相" :disabled="help.c41">单相</Radio>
                    <Radio label="三相" :disabled="help.c41">三相</Radio>
                  </RadioGroup>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c41" @click="showModal2('c41')"></Icon>
                </FormItem>
              </td>
              <td width="20%">控制方式</td>
              <td width="30%">
                <FormItem prop="c25">
                  <RadioGroup v-model="formRecord.c25">
                    <Radio label="机械" :disabled="help.c25">机械</Radio>
                    <Radio label="电子" :disabled="help.c25">电子</Radio>
                  </RadioGroup>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c25" @click="showModal2('c25')"></Icon>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>电容器</td>
              <td>
                <FormItem prop="c45">
                  <RadioGroup v-model="formRecord.c45">
                    <Radio label="有" :disabled="help.c45">有</Radio>
                    <Radio label="无" :disabled="help.c45">无</Radio>
                  </RadioGroup>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c45" @click="showModal2('c45')"></Icon>
                </FormItem>
              </td>
              <td>电动机</td>
              <td>
                <FormItem prop="c46">
                  <RadioGroup v-model="formRecord.c46">
                    <Radio label="电容电动机" :disabled="help.c25">电容电动机</Radio>
                    <Radio label="直流无刷电动机" :disabled="help.c25">直流无刷电动机</Radio>
                    <Radio label="串励电动机" :disabled="help.c25">串励电动机</Radio>
                    <Radio label="交流变频电动机" :disabled="help.c25">交流变频电动机</Radio>
                  </RadioGroup>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c25" @click="showModal2('c25')"></Icon>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>进水阀</td>
              <td>
                <FormItem prop="c47">
                  <RadioGroup v-model="formRecord.c47">
                    <Radio label="有" :disabled="help.c47">有</Radio>
                    <Radio label="无" :disabled="help.c47">无</Radio>
                  </RadioGroup>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c47" @click="showModal2('c47')"></Icon>
                </FormItem>
              </td>
              <td>定时器</td>
              <td>
                <FormItem prop="c50">
                  <RadioGroup v-model="formRecord.c50">
                    <Radio label="有" :disabled="help.c50">有</Radio>
                    <Radio label="无" :disabled="help.c50">无</Radio>
                  </RadioGroup>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c50" @click="showModal2('c50')"></Icon>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>排水方式</td>
              <td>
                <FormItem prop="c48">
                  <RadioGroup v-model="formRecord.c48">
                    <Radio label="排水泵" :disabled="help.c48">排水泵</Radio>
                    <Radio label="排水牵引器" :disabled="help.c48">排水牵引器</Radio>
                    <Radio label="其他" :disabled="help.c48">其他</Radio>
                  </RadioGroup>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c48" @click="showModal2('c48')"></Icon>
                </FormItem>
                <FormItem prop="c49">
                  <Input type="text" v-model="formRecord.c49" :disabled="formRecord.c48 !== '其他' || help.c49" style="width:50px;"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c49" @click="showModal2('c49')"></Icon>
                </FormItem>
              </td>
              <td>加热功能</td>
              <td>
                <FormItem prop="c28">
                  <RadioGroup v-model="formRecord.c28">
                    <Radio label="有" :disabled="help.c28">有</Radio>
                    <Radio label="无" :disabled="help.c28">无</Radio>
                  </RadioGroup>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c28" @click="showModal2('c28')"></Icon>
                </FormItem>
                <FormItem prop="c65" label="额定洗涤加热功率（W）" :label-width="170">
                  <Input type="text" v-model="formRecord.c65" :disabled="formRecord.c28 !== '有' || help.c65"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c65" @click="showModal2('c65')"></Icon>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>波轮直径</td>
              <td>
                <FormItem prop="c31">
                  <Input type="text" v-model="formRecord.c31" :disabled="help.c31"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c31" @click="showModal2('c31')"></Icon>
                </FormItem>
              </td>
              <td>波轮材料</td>
              <td>
                <FormItem prop="c32">
                  <Input type="text" v-model="formRecord.c32" :disabled="help.c32"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c32" @click="showModal2('c32')"></Icon>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>内筒直径</td>
              <td>
                <FormItem prop="c51">
                  <Input type="text" v-model="formRecord.c51" :disabled="help.c51"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c51" @click="showModal2('c51')"></Icon>
                </FormItem>
              </td>
              <td>内筒材料</td>
              <td>
                <FormItem prop="c34">
                  <Input type="text" v-model="formRecord.c34" :disabled="help.c34"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c34" @click="showModal2('c34')"></Icon>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>额定电压(V)</td>
              <td>
                <FormItem prop="c52">
                  <Input type="text" v-model="formRecord.c52" :disabled="help.c52"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c52" @click="showModal2('c52')"></Icon>
                </FormItem>
              </td>
              <td>额定频率(Hz)</td>
              <td>
                <FormItem prop="c53">
                  <Input type="text" v-model="formRecord.c53" :disabled="help.c53"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c53" @click="showModal2('c53')"></Icon>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>额定洗涤功率(W)<br />(按铭牌填写)</td>
              <td>
                <FormItem prop="c62">
                  <Input type="text" v-model="formRecord.c62" :disabled="help.c62"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c62" @click="showModal2('c62')"></Icon>
                </FormItem>
              </td>
              <td>额定脱水功率(W)<br />(按铭牌填写)</td>
              <td>
                <FormItem prop="c63">
                  <Input type="text" v-model="formRecord.c63" :disabled="help.c63"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c63" @click="showModal2('c63')"></Icon>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>额定烘干功率(W)<br />(按铭牌填写)</td>
              <td>
                <FormItem prop="c64">
                  <Input type="text" v-model="formRecord.c64" :disabled="help.c64"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c64" @click="showModal2('c64')"></Icon>
                </FormItem>
              </td>
              <td>额定功率(W)<br />(按铭牌填写)</td>
              <td>
                <FormItem prop="c66">
                  <Input type="text" v-model="formRecord.c66" :disabled="help.c66"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c66" @click="showModal2('c66')"></Icon>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>内桶尺寸（mm×mm×mm）</td>
              <td>
                <FormItem prop="c33">
                  <Input type="text" v-model="formRecord.c33" style="width:80px;" :disabled="help.c33"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c33" @click="showModal2('c33')"></Icon>
                </FormItem>
                <span style="display: inline-block;height: 32px;line-height: 32px;">x</span>
                <FormItem prop="c57">
                  <Input type="text" v-model="formRecord.c57" style="width:80px;" :disabled="help.c57"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c57" @click="showModal2('c57')"></Icon>
                </FormItem>
                <span style="display: inline-block;height: 32px;line-height: 32px;">x</span>
                <FormItem prop="c58">
                  <Input type="text" v-model="formRecord.c58" style="width:80px;" :disabled="help.c58"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c58" @click="showModal2('c58')"></Icon>
                </FormItem>
              </td>
              <td>外形尺寸（长×宽×高）（mm×mm×mm）</td>
              <td>
                <FormItem prop="c35">
                  <Input type="text" v-model="formRecord.c35" style="width:80px;" :disabled="help.c35"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c35" @click="showModal2('c35')"></Icon>
                </FormItem>
                <span style="display: inline-block;height: 32px;line-height: 32px;">x</span>
                <FormItem prop="c55">
                  <Input type="text" v-model="formRecord.c55" style="width:80px;" :disabled="help.c55"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c55" @click="showModal2('c55')"></Icon>
                </FormItem>
                <span style="display: inline-block;height: 32px;line-height: 32px;">x</span>
                <FormItem prop="c56">
                  <Input type="text" v-model="formRecord.c56" style="width:80px;" :disabled="help.c56"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c56" @click="showModal2('c56')"></Icon>
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
              <th width="100">部件名称</th>
              <th>规格型号</th>
              <th colspan="3">技术参数</th>
              <th>生产者（全称）</th>
            </tr>
            <tr>
              <td rowspan="3" class="tc">1</td>
              <td rowspan="3">电动机</td>
              <td class="tc">/</td>
              <td class="tc">额定电压</td>
              <td class="tc">输出功率（W）</td>
              <td class="tc">转速</td>
              <td class="tc">/</td>
            </tr>
            <tr>
              <td>
                <FormItem prop="c67">
                  <Input type="text" v-model="formRecord.c67" :disabled="help.c67"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c67" @click="showModal2('c67')"></Icon>
                </FormItem>
              </td>
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
            </tr>
            <tr>
              <td>
                <FormItem prop="c72">
                  <Input type="text" v-model="formRecord.c72" :disabled="help.c72"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c72" @click="showModal2('c72')"></Icon>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c73">
                  <Input type="text" v-model="formRecord.c73" :disabled="help.c73"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c73" @click="showModal2('c73')"></Icon>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c74">
                  <Input type="text" v-model="formRecord.c74" :disabled="help.c74"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c74" @click="showModal2('c74')"></Icon>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c75">
                  <Input type="text" v-model="formRecord.c75" :disabled="help.c75"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c75" @click="showModal2('c75')"></Icon>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c76">
                  <Input type="text" v-model="formRecord.c76" :disabled="help.c76"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c76" @click="showModal2('c76')"></Icon>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>/</td>
              <td>/</td>
              <td>/</td>
              <td colspan="3" class="tc">额定电压</td>
              <td>/</td>
            </tr>
            <tr>
              <td>2</td>
              <td>定时器</td>
              <td>
                <FormItem prop="c77">
                  <Input type="text" v-model="formRecord.c77" :disabled="help.c77"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c77" @click="showModal2('c77')"></Icon>
                </FormItem>
              </td>
              <td colspan="3" class="tc">
                <FormItem prop="c78">
                  <Input type="text" v-model="formRecord.c78" :disabled="help.c78"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c78" @click="showModal2('c78')"></Icon>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c79">
                  <Input type="text" v-model="formRecord.c79" :disabled="help.c79"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c79" @click="showModal2('c79')"></Icon>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>3</td>
              <td>定时器</td>
              <td>
                <FormItem prop="c80">
                  <Input type="text" v-model="formRecord.c80" :disabled="help.c80"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c80" @click="showModal2('c80')"></Icon>
                </FormItem>
              </td>
              <td colspan="3" class="tc">
                <FormItem prop="c81">
                  <Input type="text" v-model="formRecord.c81" :disabled="help.c81"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c81" @click="showModal2('c81')"></Icon>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c82">
                  <Input type="text" v-model="formRecord.c82" :disabled="help.c82"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c82" @click="showModal2('c82')"></Icon>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>4</td>
              <td>程控器</td>
              <td>
                <FormItem prop="c83">
                  <Input type="text" v-model="formRecord.c83" :disabled="help.c83"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c83" @click="showModal2('c83')"></Icon>
                </FormItem>
              </td>
              <td colspan="3" class="tc">
                <FormItem prop="c84">
                  <Input type="text" v-model="formRecord.c84" :disabled="help.c84"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c84" @click="showModal2('c84')"></Icon>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c85">
                  <Input type="text" v-model="formRecord.c85" :disabled="help.c85"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c85" @click="showModal2('c85')"></Icon>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>5</td>
              <td>程控器</td>
              <td>
                <FormItem prop="c86">
                  <Input type="text" v-model="formRecord.c86" :disabled="help.c86"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c86" @click="showModal2('c86')"></Icon>
                </FormItem>
              </td>
              <td colspan="3" class="tc">
                <FormItem prop="c87">
                  <Input type="text" v-model="formRecord.c87" :disabled="help.c87"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c87" @click="showModal2('c87')"></Icon>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c88">
                  <Input type="text" v-model="formRecord.c88" :disabled="help.c88"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c88" @click="showModal2('c88')"></Icon>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>6</td>
              <td>电脑版</td>
              <td>
                <FormItem prop="c89">
                  <Input type="text" v-model="formRecord.c89" :disabled="help.c89"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c89" @click="showModal2('c89')"></Icon>
                </FormItem>
              </td>
              <td colspan="3" class="tc">
                <FormItem prop="c90">
                  <Input type="text" v-model="formRecord.c90" :disabled="help.c90"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c90" @click="showModal2('c90')"></Icon>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c91">
                  <Input type="text" v-model="formRecord.c91" :disabled="help.c91"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c91" @click="showModal2('c91')"></Icon>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>7</td>
              <td>电脑版</td>
              <td>
                <FormItem prop="c92">
                  <Input type="text" v-model="formRecord.c92" :disabled="help.c92"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c92" @click="showModal2('c92')"></Icon>
                </FormItem>
              </td>
              <td colspan="3" class="tc">
                <FormItem prop="c93">
                  <Input type="text" v-model="formRecord.c93" :disabled="help.c93"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c93" @click="showModal2('c93')"></Icon>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c94">
                  <Input type="text" v-model="formRecord.c94" :disabled="help.c94"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c94" @click="showModal2('c94')"></Icon>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>8</td>
              <td>电热管</td>
              <td>
                <FormItem prop="c95">
                  <Input type="text" v-model="formRecord.c95" :disabled="help.c95"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c95" @click="showModal2('c95')"></Icon>
                </FormItem>
              </td>
              <td colspan="3" class="tc">
                <FormItem prop="c96">
                  <Input type="text" v-model="formRecord.c96" :disabled="help.c96"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c96" @click="showModal2('c96')"></Icon>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c97">
                  <Input type="text" v-model="formRecord.c97" :disabled="help.c97"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c97" @click="showModal2('c97')"></Icon>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>9</td>
              <td>电热管</td>
              <td>
                <FormItem prop="c98">
                  <Input type="text" v-model="formRecord.c98" :disabled="help.c98"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c98" @click="showModal2('c98')"></Icon>
                </FormItem>
              </td>
              <td colspan="3" class="tc">
                <FormItem prop="c99">
                  <Input type="text" v-model="formRecord.c99" :disabled="help.c99"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c99" @click="showModal2('c99')"></Icon>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c100">
                  <Input type="text" v-model="formRecord.c100" :disabled="help.c100"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c100" @click="showModal2('c100')"></Icon>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>10</td>
              <td>排水泵</td>
              <td>
                <FormItem prop="c101">
                  <Input type="text" v-model="formRecord.c101" :disabled="help.c101"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c101" @click="showModal2('c101')"></Icon>
                </FormItem>
              </td>
              <td colspan="3" class="tc">
                <FormItem prop="c102">
                  <Input type="text" v-model="formRecord.c102" :disabled="help.c102"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c102" @click="showModal2('c102')"></Icon>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c103">
                  <Input type="text" v-model="formRecord.c103" :disabled="help.c103"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c103" @click="showModal2('c103')"></Icon>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>11</td>
              <td>排水泵</td>
              <td>
                <FormItem prop="c104">
                  <Input type="text" v-model="formRecord.c104" :disabled="help.c104"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c104" @click="showModal2('c104')"></Icon>
                </FormItem>
              </td>
              <td colspan="3" class="tc">
                <FormItem prop="c105">
                  <Input type="text" v-model="formRecord.c105" :disabled="help.c105"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c105" @click="showModal2('c105')"></Icon>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c106">
                  <Input type="text" v-model="formRecord.c106" :disabled="help.c106"></Input>
                  <Icon type="ios-help-circle-outline" size="20" v-if="help.c106" @click="showModal2('c106')"></Icon>
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
        c6: '',
        c7: '',
        c8: '',
        c9: '',
        c10: '',
        c11: '',
        c12: '',
        c15: new Date(),
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
        c55: '',
        c56: '',
        c57: '',
        c58: '',
        c59: '',
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
        c100: '',
        c101: '',
        c102: '',
        c103: '',
        c104: '',
        c105: '',
        c106: '',
        c200: '',
        c202: '',
        ec_model_no: 31,
        attach_list: ''
      },
      help: {
        c1: false,
        c2: false,
        c3: false,
        c4: false,
        c6: false,
        c7: false,
        c8: false,
        c9: false,
        c10: false,
        c11: false,
        c12: false,
        c15: false,
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
        c55: false,
        c56: false,
        c57: false,
        c58: false,
        c59: false,
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
        c78: false,
        c79: false,
        c80: false,
        c81: false,
        c82: false,
        c83: false,
        c84: false,
        c85: false,
        c86: false,
        c87: false,
        c88: false,
        c89: false,
        c90: false,
        c91: false,
        c92: false,
        c93: false,
        c94: false,
        c95: false,
        c96: false,
        c97: false,
        c98: false,
        c99: false,
        c100: false,
        c101: false,
        c102: false,
        c103: false,
        c104: false,
        c105: false,
        c106: false,
        c200: false,
        c202: false
      }
    }
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
          productType: 'T31',
          productTypeName: '电动洗衣机2013版',
          productModel: this.formRecord.c2,
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
          if (e.recId === 'c6') {
            if (parseInt(e.labValue) !== 1 && parseInt(e.labValue) !== 2 && parseInt(e.labValue) !== 3 && parseInt(e.labValue) !== 4 && parseInt(e.labValue) !== 5) {
              that.formRecord[e.recId] = '1'
            } else {
              that.formRecord[e.recId] = parseInt(e.labValue).toString()
            }
          } else if (e.recId === 'c15' && isNaN(e.labValue)) {
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
      this.formRecord.ptid = this.$store.state.app.ptId
      this.formRecord.pltId = this.$store.state.app.pltId
      this.formRecord.record_type = 0
      this.formRecord.ec_labreport_id = this.$store.state.app.rid
      this.formRecord.ec_labreport_no = this.$store.state.app.barcode
      this.formRecord.ec_labname = this.$store.state.app.labName
      this.formRecord.attach_list = JSON.stringify(this.filesArr)
      this.formRecord.c15 = this.formatDate(this.formRecord.c15)
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
      let decimal310 = /^(([1-9]{1}\d*)|(0{1}))(\.\d{3,10})$/
      let decimal410 = /^(([1-9]{1}\d*)|(0{1}))(\.\d{4,10})$/

      let checkc8 = (rule, value, callback) => {
        if (!this.help.c8 && this.formRecord.c8 !== '' && !decimal410.test(this.help.c8)) {
          callback('至少四位小数')
        } else {
          callback()
        }
        let c8 = parseFloat(this.formRecord.c8)
        let c7 = parseFloat(this.formRecord.c7)
        if (c8 !== "" && c7 !== "") {
          if (c8 * 0.93 > c7) {
            callback("耗电量实测值不满足标准允许的偏差，实测值*0.93<=标称值")
          } else {
            callback()
          }
        } else {
          callback()
        }
      }
      let checkc10 = (rule, value, callback) => {
        if (!this.help.c10 && this.formRecord.c10 !== '' && !decimal1.test(this.help.c10)) {
          callback('一位小数')
        } else {
          callback()
        }
        let c10 = parseFloat(this.formRecord.c10)
        let c9 = parseFloat(this.formRecord.c9)
        if (c10 !== "" && c9 !== "") {
          if (c10 * 0.95 > c9) {
            callback("用水量实测值不满足标准允许的偏差，实测值*0.95<=标称值")
          } else {
            callback()
          }
        } else {
          callback()
        }
      }
      let checkc12 = (rule, value, callback) => {
        if (!this.help.c12 && this.formRecord.c12 !== '' && !decimal310.test(this.help.c12)) {
          callback('至少三位小数')
        } else {
          callback()
        }
        let c11 = parseFloat(this.formRecord.c11)
        let c12 = parseFloat(this.formRecord.c12)
        if (c12 !== "" && c11 !== "") {
          if (c12 + 0.035 < c11) {
            callback("洗净比实测值值不满足标准允许的偏差，实测值+0.035>=标称值")
          } else {
            callback()
          }
        } else {
          callback()
        }
      }
      let checkc11 = (rule, value, callback) => {
        if (!this.help.c11 && this.formRecord.c11 !== '' && !decimal2.test(this.help.c11)) {
          callback('两位小数')
        } else {
          callback()
        }
        let nxdj = 0
        let c27 = this.formRecord.c27
        let c11 = parseFloat(this.formRecord.c11)
        let c6 = Number(this.formRecord.c6)
        if (c27 === "波轮式") {
          if (c6 === 1 && c11 < 0.90) {
            callback('>=0.90')
          } else {
            callback()
          }
          if (c6 === 2 && c11 < 0.80) {
            callback('>=0.80')
          } else {
            callback()
          }
        } else {
          callback()
        }
      }
      let checkc29 = (rule, value, callback) => {
        if (!this.help.c29 && this.formRecord.c29 !== '' && !decimal1.test(this.help.c29)) {
          callback('一位小数')
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
      let checkc38 = (rule, value, callback) => {
        if (!this.help.c38 && this.formRecord.c38 !== '' && !decimal1.test(this.help.c38)) {
          callback('一位小数')
        } else {
          callback()
        }
      }
      let checkc7 = (rule, value, callback) => {
        if (!this.help.c7 && this.formRecord.c7 !== '' && !decimal3.test(this.help.c7)) {
          callback('三位小数')
        } else {
          callback()
        }
      }
      let checkc37 = (rule, value, callback) => {
        if (!this.help.c37 && this.formRecord.c37 !== '' && !decimal410.test(this.help.c37)) {
          callback('至少四位小数')
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
          // {
          //   pattern: decimal3,
          //   message: '三位小数'
          // },
          {
            validator: checkc7,
            trigger: 'blur'
          }
        ],
        c8: [
          {
            required: true,
            message: '不能为空'
          },
          // {
          //   pattern: decimal410,
          //   message: '至少四位小数'
          // },
          {
            validator: checkc8,
            trigger: 'blur'
          }
        ],
        c9: [
          {
            required: true,
            message: '不能为空'
          },
          {
            number: true,
            message: '整数'
          }
        ],
        c10: [
          {
            required: true,
            message: '不能为空'
          },
          // {
          //   pattern: decimal1,
          //   message: '一位小数'
          // },
          {
            validator: checkc10,
            trigger: 'blur'
          }
        ],
        c11: [
          {
            required: true,
            message: '不能为空'
          },
          // {
          //   pattern: decimal2,
          //   message: '两位小数'
          // },
          {
            validator: checkc11,
            trigger: 'blur'
          }
        ],
        c12: [
          {
            required: true,
            message: '不能为空'
          },
          // {
          //   pattern: decimal310,
          //   message: '至少三位小数'
          // },
          {
            validator: checkc12,
            trigger: 'blur'
          }
        ],
        c15: [
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
          },
          // {
          //   pattern: decimal1,
          //   message: '一位小数'
          // }
          {
            validator: checkc29,
            trigger: 'blur'
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
          // }
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
          }
        ],
        c35: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c36: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c37: [
          {
            required: true,
            message: '不能为空'
          },
          // {
          //   pattern: decimal410,
          //   message: '至少四位小数'
          // },
          {
            validator: checkc37,
            trigger: 'blur'
          }
        ],
        c38: [
          {
            required: true,
            message: '不能为空'
          },
          // {
          //   pattern: decimal1,
          //   message: '一位小数'
          // },
          {
            validator: checkc38,
            trigger: 'blur'
          }
        ],
        c39: [
          {
            required: true,
            message: '不能为空'
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
        c43: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c44: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c45: [
          {
            required: true,
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
            required: this.formRecord.c48 === '其他',
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
            required: this.formRecord.c27 === '其他',
            message: '不能为空'
          }
        ],
        c62: [
          {
            required: true,
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
            required: this.formRecord.c28 === '有',
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
        ],
        c68: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c69: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c70: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c71: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c77: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c78: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c79: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c83: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c84: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c85: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c89: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c90: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c91: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c95: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c96: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c97: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c101: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c102: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c103: [
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
