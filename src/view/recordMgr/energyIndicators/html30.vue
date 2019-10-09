<template>
  <div class="wrapper">
    <Form ref="formRecord" :model="formRecord" label-position="right" :rules="ruleRecord">
      <h1>微型计算机-能源效率标识备案表</h1>
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
          <FormItem prop="c4" label="制造单位" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c4" :disabled='disabledoff' placeholder="制造单位"/>
          </FormItem>
          <FormItem prop="c63" label="备案方" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c63" :disabled='disabledoff' placeholder="备案方"/>
          </FormItem>
          <FormItem prop="c2" label="产品规格型号" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c2" :disabled='!disabledoff' placeholder="规格型号"/>
          </FormItem>
          <FormItem prop="c3" label="商标" style="width:100%" :label-width="180">
            <Input type="text" v-model="formRecord.c3" :disabled='pageType=="view"' placeholder="商标"/>
          </FormItem>
          <FormItem prop="c200" label="依据国家标准" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c200" placeholder="依据国家标准" readonly disabled/>
          </FormItem>
          <FormItem prop="c65" label="能效等级" style="width:100%;" :label-width="180">
            <RadioGroup v-model="formRecord.c65">
              <Radio label="1" :disabled='disabledoff'>1级</Radio>
              <Radio label="2" :disabled='disabledoff'>2级</Radio>
              <Radio label="3" :disabled='disabledoff'>3级</Radio>
            </RadioGroup>
          </FormItem>
          <table id="table1">
            <tr>
              <td align="center" rowspan="2">产品类型<span style="color:red">*</span></td>
              <td>
                <FormItem prop="c15" style="width:100%;">
                  <RadioGroup v-model="formRecord.c15" @on-change="initData">
                    <Radio label="台式微型计算机及一体机" :disabled='disabledoff'>台式微型计算机及一体机</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c16" style="width:100%;">
                  <RadioGroup v-model="formRecord.c16">
                    <Radio label="A类" :disabled='disabledoff || forbidden.c16'>A类</Radio>
                    <Radio label="B类" :disabled='disabledoff || forbidden.c16'>B类</Radio>
                    <Radio label="C类" :disabled='disabledoff || forbidden.c16'>C类</Radio>
                    <Radio label="D类" :disabled='disabledoff || forbidden.c16'>D类</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>
                <FormItem prop="c15" style="width:100%;">
                  <RadioGroup v-model="formRecord.c15" @on-change="initData">
                    <Radio label="便携式计算机" :disabled='disabledoff'>便携式计算机</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c17" style="width:100%;">
                  <RadioGroup v-model="formRecord.c17" @on-change="bxsjsjChange">
                    <Radio label="A类" :disabled='disabledoff || forbidden.c17'>A类</Radio>
                    <Radio label="B类" :disabled='disabledoff || forbidden.c17'>B类</Radio>
                    <Radio label="C类" :disabled='disabledoff || forbidden.c17'>C类</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center" rowspan="2">附加功能功耗因子之和（kWh）<span style="color:red">*</span></td>
              <td colspan="2">
                <FormItem prop="c22" style="width:100%;">
                  <Input type="text" v-model="formRecord.c22" :disabled='disabledoff' placeholder="一位小数"/>
                </FormItem>
              </td>
            </tr>
          </table>
          <table id="table1">
            <tr>
              <th>项目</th>
              <th>标注值</th>
              <th>实测值</th>
              <th>备注</th>
            </tr>
            <tr>
              <td align="center">典型能源消耗<span style="color:red">*</span></td>
              <td>
                <FormItem prop="c5" label="标称值:" style="width:100%;" :label-width="70">
                  <Input type="text" v-model="formRecord.c5" :disabled='disabledoff' placeholder="一位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c6" label="实测值:" style="width:100%;" :label-width="70">
                  <Input type="text" v-model="formRecord.c6" :disabled='disabledoff' placeholder="至少两位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c7" label="备注:" style="width:100%;" :label-width="70">
                  <Input type="text" v-model="formRecord.c7" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
          </table>
        </Card>
      </div>
      <div class="part part4">
        <Card :bordered="false">
          <h2>四、初始使用日期</h2>
          <FormItem prop="c14" label="备案标识开始使用日期" style="width:100%;">
            <DatePicker type="date" :options="dataInit" style="width: 200px" v-model="formRecord.c14"></DatePicker>
          </FormItem>
        </Card>
      </div>
      <div class="part part5">
        <Card :bordered="false">
          <h2>五、其它信息</h2>
          <table id="table3">
            <tr>
              <td align="right"><span style="color:red">*</span>内存(GB)</td>
              <td>
                <FormItem prop="c18" style="width:100%;">
                  <Input type="text" v-model="formRecord.c18" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td align="right"><span style="color:red">*</span>GPU类型</td>
              <td>
                <FormItem prop="c27" style="width:100%;">
                  <RadioGroup v-model="formRecord.c27" @on-change="gpuTypeChange">
                    <Radio label="集成" :disabled='disabledoff'>集成</Radio>
                    <Radio label="独立" :disabled='disabledoff'>独立</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span style="color:red">*</span>GPU型号</td>
              <td>
                <FormItem prop="c28" style="width:100%;">
                  <Input type="text" v-model="formRecord.c28" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td align="right"><span style="color:red">*</span>显存等效频率(MHz)</td>
              <td>
                <FormItem prop="c19" style="width:100%;">
                  <Input type="text" v-model="formRecord.c19" :disabled='disabledoff || forbidden.c19'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span style="color:red">*</span>显存位宽(位)</td>
              <td>
                <FormItem prop="c20" style="width:100%;">
                  <Input type="text" v-model="formRecord.c20" :disabled='disabledoff || forbidden.c20'/>
                </FormItem>
              </td>
              <td align="right"><span style="color:red">*</span>显存带宽（FBBW）(GB/s)</td>
              <td>
                <FormItem prop="c21" style="width:100%;">
                  <Input type="text" v-model="formRecord.c21" :disabled='disabledoff || forbidden.c21'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span style="color:red">*</span>附加功能功耗因子表</td>
              <td>
                见附表1
              </td>
              <td align="right"><span style="color:red">*</span>操作系统名称及版本</td>
              <td>
                <FormItem prop="c23" style="width:100%;">
                  <Input type="text" v-model="formRecord.c23" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span style="color:red">*</span>CPU型号</td>
              <td>
                <FormItem prop="c24" style="width:100%;">
                  <Input type="text" v-model="formRecord.c24" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td align="right"><span style="color:red">*</span>CPU最高主频(MHz)</td>
              <td>
                <FormItem prop="c25" style="width:100%;">
                  <Input type="text" v-model="formRecord.c25" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span style="color:red">*</span>CPU物理核心数量</td>
              <td>
                <FormItem prop="c26" style="width:100%;">
                  <Input type="text" v-model="formRecord.c26" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td align="right"><span style="color:red">*</span>额定功率(W)</td>
              <td>
                <FormItem prop="c29" style="width:100%;">
                  <Input type="text" v-model="formRecord.c29" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span style="color:red">*</span>额定电流(A)</td>
              <td>
                <FormItem prop="c30" style="width:100%;">
                  <Input type="text" v-model="formRecord.c30" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td align="right"><span style="color:red">*</span>硬盘个数(个)</td>
              <td>
                <FormItem prop="c31" style="width:100%;">
                  <Input type="text" v-model="formRecord.c31" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span style="color:red">*</span>硬盘大小(GB)</td>
              <td>
                <FormItem prop="c32" style="width:100%;">
                  <Input type="text" v-model="formRecord.c32" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td></td>
              <td></td>
            </tr>
          </table>
          <h3>附表1 微型计算机附加功能功耗因子表</h3>
          <table id="table3">
            <tr>
              <th rowspan="2" colspan="1" width="120">是否有该项附加功能</th>
              <th rowspan="1" colspan="4">附加功能功耗因子(kWh)</th>
              <th rowspan="2" colspan="2">附加功能说明</th>
            </tr>
            <tr>
              <th rowspan="1" colspan="1">台式微型计算机及一体机</th>
              <th rowspan="1" colspan="1">A类便携机</th>
              <th rowspan="1" colspan="1">B类便携机</th>
              <th rowspan="1" colspan="1">C类便携机</th>
            </tr>
            <tr>
              <td>
                <FormItem prop="c33" style="width:100%;" :label-width="10">
                  <RadioGroup v-model="formRecord.c33" @on-change="memoryChange">
                    <Radio label="是" :disabled='disabledoff || forbidden.c33'>是</Radio>
                    <Radio label="否" :disabled='disabledoff || forbidden.c33'>否</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c34">
                  <CheckboxGroup v-model="formRecord.c34">
                    <Checkbox label="1.0/（1GB)×（微型计算机总内存容量＿＿GB--基本内存容量＿＿GB）" :disabled='disabledoff || forbidden.c34'>
                      1.0 /(1GB)×(微型计算机总内存容量
                    </Checkbox>
                  </CheckboxGroup>
                </FormItem>
                <br>
                <FormItem prop="c35" style="width:50px;">
                  <Input type="text" v-model="formRecord.c35" :disabled='disabledoff || forbidden.c35'/>
                </FormItem>
                <FormItem>
                  GB-基本内存容量
                </FormItem>
                <FormItem prop="c36" style="width:50px;">
                  <Input type="text" v-model="formRecord.c36" :disabled='disabledoff || forbidden.c36'/>
                </FormItem>
                <FormItem>
                  GB)
                </FormItem>
              </td>
              <td colspan="3">
                <FormItem prop="c37">
                  <CheckboxGroup v-model="formRecord.c37">
                    <Checkbox label="0.4/（1GB)×（微型计算机总内存容量＿＿GB--基本内存容量＿＿GB）" :disabled='disabledoff || forbidden.c37'>
                      0.4/(1GB)×(微型计算机总内存容量
                    </Checkbox>
                  </CheckboxGroup>
                </FormItem>
                <br>
                <FormItem prop="c38" style="width:50px;">
                  <Input type="text" v-model="formRecord.c38" :disabled='disabledoff || forbidden.c38'/>
                </FormItem>
                <FormItem>
                  GB-基本内存容量
                </FormItem>
                <FormItem prop="c39" style="width:50px;">
                  <Input type="text" v-model="formRecord.c39" :disabled='disabledoff || forbidden.c39'/>
                </FormItem>
                <FormItem>
                  GB)
                </FormItem>
              </td>
              <td colspan="2">内存</td>
            </tr>
            <tr>
              <td>
                <FormItem prop="c40" style="width:100%;" :label-width="10">
                  <RadioGroup v-model="formRecord.c40">
                    <Radio label="是" :disabled='disabledoff || forbidden.c40'>是</Radio>
                    <Radio label="否" :disabled='disabledoff || forbidden.c40'>否</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c41">
                  <CheckboxGroup v-model="formRecord.c41">
                    <Checkbox label="46" :disabled='disabledoff || forbidden.c41'>46</Checkbox>
                  </CheckboxGroup>
                </FormItem>
              </td>
              <td>-</td>
              <td>
                <FormItem prop="c42">
                  <CheckboxGroup v-model="formRecord.c42">
                    <Checkbox label="4" :disabled='disabledoff || forbidden.c42'>4</Checkbox>
                  </CheckboxGroup>
                </FormItem>
              </td>
              <td>-</td>
              <td>G1类</td>
              <td rowspan="5">具有独立显示单元(GPU)</td>
            </tr>
            <tr>
              <td>
                <FormItem prop="c43" style="width:100%;" :label-width="10">
                  <RadioGroup v-model="formRecord.c43">
                    <Radio label="是" :disabled='disabledoff || forbidden.c43'>是</Radio>
                    <Radio label="否" :disabled='disabledoff || forbidden.c43'>否</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c44">
                  <CheckboxGroup v-model="formRecord.c44">
                    <Checkbox label="70" :disabled='disabledoff || forbidden.c44'>70</Checkbox>
                  </CheckboxGroup>
                </FormItem>
              </td>
              <td>-</td>
              <td>
                <FormItem prop="c45">
                  <CheckboxGroup v-model="formRecord.c45">
                    <Checkbox label="12" :disabled='disabledoff || forbidden.c45'>12</Checkbox>
                  </CheckboxGroup>
                </FormItem>
              </td>
              <td>-</td>
              <td>G2类</td>
            </tr>
            <tr>
              <td>
                <FormItem prop="c46" style="width:100%;" :label-width="10">
                  <RadioGroup v-model="formRecord.c46">
                    <Radio label="是" :disabled='disabledoff || forbidden.c46'>是</Radio>
                    <Radio label="否" :disabled='disabledoff || forbidden.c46'>否</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c47">
                  <CheckboxGroup v-model="formRecord.c47">
                    <Checkbox label="95" :disabled='disabledoff || forbidden.c47'>95</Checkbox>
                  </CheckboxGroup>
                </FormItem>
              </td>
              <td>-</td>
              <td>
                <FormItem prop="c48">
                  <CheckboxGroup v-model="formRecord.c48">
                    <Checkbox label="24" :disabled='disabledoff || forbidden.c48'>24</Checkbox>
                  </CheckboxGroup>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c49">
                  <CheckboxGroup v-model="formRecord.c49">
                    <Checkbox label="37" :disabled='disabledoff || forbidden.c49'>37</Checkbox>
                  </CheckboxGroup>
                </FormItem>
              </td>
              <td>G3类</td>
            </tr>
            <tr>
              <td>
                <FormItem prop="c50" style="width:100%;" :label-width="10">
                  <RadioGroup v-model="formRecord.c50">
                    <Radio label="是" :disabled='disabledoff || forbidden.c50'>是</Radio>
                    <Radio label="否" :disabled='disabledoff || forbidden.c50'>否</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c51">
                  <CheckboxGroup v-model="formRecord.c51">
                    <Checkbox label="140" :disabled='disabledoff || forbidden.c51'>140</Checkbox>
                  </CheckboxGroup>
                </FormItem>
              </td>
              <td>-</td>
              <td>
                <FormItem prop="c52">
                  <CheckboxGroup v-model="formRecord.c52">
                    <Checkbox label="36" :disabled='disabledoff || forbidden.c52'>36</Checkbox>
                  </CheckboxGroup>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c53">
                  <CheckboxGroup v-model="formRecord.c53">
                    <Checkbox label="49" :disabled='disabledoff || forbidden.c53'>49</Checkbox>
                  </CheckboxGroup>
                </FormItem>
              </td>
              <td>G4类</td>
            </tr>
            <tr>
              <td>
                <FormItem prop="c54" style="width:100%;" :label-width="10">
                  <RadioGroup v-model="formRecord.c54">
                    <Radio label="是" :disabled='disabledoff || forbidden.c54'>是</Radio>
                    <Radio label="否" :disabled='disabledoff || forbidden.c54'>否</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c55">
                  <CheckboxGroup v-model="formRecord.c55">
                    <Checkbox label="394" :disabled='disabledoff || forbidden.c55'>394</Checkbox>
                  </CheckboxGroup>
                </FormItem>
              </td>
              <td>-</td>
              <td>
                <FormItem prop="c56">
                  <CheckboxGroup v-model="formRecord.c56">
                    <Checkbox label="146" :disabled='disabledoff || forbidden.c56'>146</Checkbox>
                  </CheckboxGroup>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c57">
                  <CheckboxGroup v-model="formRecord.c57">
                    <Checkbox label="159" :disabled='disabledoff || forbidden.c57'>159</Checkbox>
                  </CheckboxGroup>
                </FormItem>
              </td>
              <td>G5类</td>
            </tr>
            <tr>
              <td>
                <FormItem prop="c58" style="width:100%;" :label-width="10">
                  <RadioGroup v-model="formRecord.c58" @on-change="storeInChange">
                    <Radio label="是" :disabled='disabledoff || forbidden.c58'>是</Radio>
                    <Radio label="否" :disabled='disabledoff || forbidden.c58'>否</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c59">
                  <CheckboxGroup v-model="formRecord.c59">
                    <Checkbox label="25×附加硬盘数＿＿" :disabled='disabledoff || forbidden.c59'>25×附加硬盘数</Checkbox>
                  </CheckboxGroup>
                </FormItem>
                <FormItem prop="c60" style="width:100px;">
                  <Input type="text" v-model="formRecord.c60" :disabled='disabledoff || forbidden.c60'/>
                </FormItem>
              </td>
              <td colspan="3">
                <FormItem prop="c61">
                  <CheckboxGroup v-model="formRecord.c61">
                    <Checkbox label="3×附加硬盘数＿＿" :disabled='disabledoff || forbidden.c61'>3×附加硬盘数</Checkbox>
                  </CheckboxGroup>
                </FormItem>
                <FormItem prop="c62" style="width:100px;">
                  <Input type="text" v-model="formRecord.c62" :disabled='disabledoff || forbidden.c62'/>
                </FormItem>
              </td>
              <td colspan="2">
                内部存储
              </td>
            </tr>
          </table>
          <h3>扩展型号</h3>
          <FormItem style="width:100%;" :label-width="70" prop="c64">
            <Input v-model="formRecord.c64" :disabled="pageType==='view'" type="textarea"
                   :autosize="{minRows: 5,maxRows: 5}"/>
          </FormItem>
          <label style="color: red;margin-left: 70px">多个型号, 使用英文“;”分隔</label>
        </Card>
      </div>
      <div class="part part6">
        <Card :bordered="false">
          <h2>六、产品基本配置清单</h2>
          <table id="table4">
            <tr>
              <th width="50">序号</th>
              <th width="100">部件名称</th>
              <th>型号规格</th>
              <th colspan="2">技术参数</th>
              <th>生产者（全称）</th>
            </tr>
            <tr>
              <td align="center">1</td>
              <td align="center">主板</td>
              <td>
                <FormItem prop="c66" style="width:100%;">
                  <Input type="text" v-model="formRecord.c66" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td colspan="2">
                <FormItem prop="c67" style="width:100%;">
                  <Input type="text" v-model="formRecord.c67" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c68" style="width:100%;">
                  <Input type="text" v-model="formRecord.c68" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center">2</td>
              <td align="center">主板</td>
              <td>
                <FormItem prop="c69" style="width:100%;">
                  <Input type="text" v-model="formRecord.c69" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td colspan="2">
                <FormItem prop="c70" style="width:100%;">
                  <Input type="text" v-model="formRecord.c70" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c71" style="width:100%;">
                  <Input type="text" v-model="formRecord.c71" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center" rowspan="5">3</td>
              <td align="center" rowspan="5">开关电源/适配器</td>
              <td rowspan="5">
                <FormItem prop="c72" style="width:100%;">
                  <Input type="text" v-model="formRecord.c72" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td align="center">输入电压</td>
              <td>
                <FormItem prop="c73" style="width:100%;">
                  <Input type="text" v-model="formRecord.c73" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td rowspan="5">
                <FormItem prop="c74" style="width:100%;">
                  <Input type="text" v-model="formRecord.c74" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center">输入电流/功率</td>
              <td>
                <FormItem prop="c75" style="width:100%;">
                  <Input type="text" v-model="formRecord.c75" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center">输入频率</td>
              <td>
                <FormItem prop="c76" style="width:100%;">
                  <Input type="text" v-model="formRecord.c76" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center">输出电压</td>
              <td>
                <FormItem prop="c77" style="width:100%;">
                  <Input type="text" v-model="formRecord.c77" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center">输出电流/功率</td>
              <td>
                <FormItem prop="c78" style="width:100%;">
                  <Input type="text" v-model="formRecord.c78" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center" rowspan="5">4</td>
              <td align="center" rowspan="5">开关电源/适配器</td>
              <td rowspan="5">
                <FormItem prop="c79" style="width:100%;">
                  <Input type="text" v-model="formRecord.c79" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td align="center">输入电压</td>
              <td>
                <FormItem prop="c80" style="width:100%;">
                  <Input type="text" v-model="formRecord.c80" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td rowspan="5">
                <FormItem prop="c81" style="width:100%;">
                  <Input type="text" v-model="formRecord.c81" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center">输入电流/功率</td>
              <td>
                <FormItem prop="c82" style="width:100%;">
                  <Input type="text" v-model="formRecord.c82" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center">输入频率</td>
              <td>
                <FormItem prop="c83" style="width:100%;">
                  <Input type="text" v-model="formRecord.c83" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center">输出电压</td>
              <td>
                <FormItem prop="c84" style="width:100%;">
                  <Input type="text" v-model="formRecord.c84" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center">输出电流/功率</td>
              <td>
                <FormItem prop="c85" style="width:100%;">
                  <Input type="text" v-model="formRecord.c85" :disabled='disabledoff'/>
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
              <td>
                <FormItem prop="c202">
                  <Input type="text" v-model="formRecord.c202" :disabled='disabledoff'/>
                </FormItem>
              </td>
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
        公司生产的 <span class="f-brand">{{formRecord.c3}}</span>
        品牌的 <span class="f-model">{{pageType==='extend'?mainModel:formRecord.c2}}</span>
        型号的 <span class="f-product">微型计算机 2012版</span>产品{{pageType==="update"?'已通过能效标识备案':''}}。
      </div>
      <div v-if="pageType==='extend'" class="org regress">
        <p><span></span>正在办理能效标识备案</p>
        <p><span class="bgs"></span>已通过能效标识备案</p>
      </div>
      <div class="org">备案编号:{{recordno}}</div>
      <dl v-if="pageType==='extend'">
        <dt>
          现提出型号扩展备案申请的 <span class="f-model"> {{formRecord[thisGZXHCV]}}</span>
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
      const changeVal = (rule, value, callback) => {
        if (this.c2 !== this.formRecord.c2) {
          this.c2 = this.formRecord.c2
          this.$refs['formRecord'].validate((valid) => {
          })
        }
        this.mainModel === value ? callback('扩展备案需要变更型号名称') : callback()
      }
      const repeat = (rule, value, callback) => {
        if (this.formRecord.c64.indexOf("；") > -1) {
          callback('扩展型号分隔符有非法字符，请使用英文输入法下的分号";"')
        }
        this.c2 = this.formRecord.c2
        let split1 = this.c64.split(";").filter(item => item !== "")
        let split2 = this.formRecord.c64.split(";").filter(item => item !== "")
        for (let i = 0; i < split1.length; i++) {
          for (let j = 0; j < split2.length; j++) {
            if (split1[i] === split2[j]) {
              callback("扩展型号与主型号备案中的规格型号或扩展型号重复")
            }
          }
        }

        for (let i = 0; i < split2.length; i++) {
          if (split2[i] === this.formRecord.c2) {
            callback("扩展型号与规格型号重复。")
          }
        }

        for (let i = 0; i < split2.length; i++) {
          for (let j = i + 1; j < split2.length; j++) {
            if (split2[i] === split2[j]) {
              callback("扩展型号重复。")
            }
          }
        }
        callback()
      }
      return {
        // 当前初始使用日期 对应的C值
        thisDateCV: 'c14',
        // 当前能效等级 对应的C值
        thisLevelCV: 'c65',
        // 当前规格型号 对应的C值
        thisGZXHCV: "c2",
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
          c3: '',
          c4: '',
          c5: '',
          c6: '',
          c7: '',
          c14: new Date(),
          c15: '',
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
          c34: [],
          c35: '',
          c36: '',
          c37: [],
          c38: '',
          c39: '',
          c40: '',
          c41: [],
          c42: [],
          c43: '',
          c44: [],
          c45: [],
          c46: '',
          c47: [],
          c48: [],
          c49: [],
          c50: '',
          c51: [],
          c52: [],
          c53: [],
          c54: '',
          c55: [],
          c56: [],
          c57: [],
          c58: '',
          c59: [],
          c60: '',
          c61: [],
          c62: '',
          c63: '',
          c64: '',
          c65: '',
          c200: '',
          ec_model_no: 30,
          attach_list: ''
        },
        forbidden: {
          c16: false,
          c17: false,
          c19: false,
          c20: false,
          c21: false,
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
          c60: false,
          c61: false,
          c62: false
        },
        c2: '',
        c64: ''
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
        var extendData = XfillExtendData(params, this);
        this.c64 = this.formRecord.c64
        this.c64 += ";" + this.mainModel
        this.formRecord.c64 = ''
        return extendData
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
        this.clearData()
        return XsubmitRecord(this)
      },
      viewClose() {
        return XviewClose(this)
      },
      /* 保存草稿箱 */
      saveRecord() {
        this.clearData()
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

      },
      clearData() {
        if (this.forbidden.c40 == true)
          this.formRecord.c40 = ''
        if (this.forbidden.c43 == true)
          this.formRecord.c43 = ''
        if (this.forbidden.c46 == true)
          this.formRecord.c46 = ''
        if (this.forbidden.c50 == true)
          this.formRecord.c50 = ''
        if (this.forbidden.c54 == true)
          this.formRecord.c54 = ''
      },
      initData() {
        this.formRecord.c16 = ''
        this.formRecord.c17 = ''

        this.formRecord.c27 = ''
        this.formRecord.c19 = ''
        this.formRecord.c20 = ''
        this.formRecord.c21 = ''

        this.formRecord.c33 = ''
        this.formRecord.c34 = []
        this.formRecord.c35 = ''
        this.formRecord.c36 = ''
        this.formRecord.c37 = []
        this.formRecord.c38 = ''
        this.formRecord.c39 = ''
        this.forbidden.c34 = true
        this.forbidden.c35 = true
        this.forbidden.c36 = true
        this.forbidden.c37 = true
        this.forbidden.c38 = true
        this.forbidden.c39 = true

        this.formRecord.c40 = '否'
        this.formRecord.c41 = []
        this.formRecord.c42 = []
        this.forbidden.c40 = true
        this.forbidden.c41 = true
        this.forbidden.c42 = true

        this.formRecord.c43 = '否'
        this.formRecord.c44 = []
        this.formRecord.c45 = []
        this.forbidden.c43 = true
        this.forbidden.c44 = true
        this.forbidden.c45 = true

        this.formRecord.c46 = '否'
        this.formRecord.c47 = []
        this.formRecord.c48 = []
        this.formRecord.c49 = []
        this.forbidden.c46 = true
        this.forbidden.c47 = true
        this.forbidden.c48 = true
        this.forbidden.c49 = true

        this.formRecord.c50 = '否'
        this.formRecord.c51 = []
        this.formRecord.c52 = []
        this.formRecord.c53 = []
        this.forbidden.c50 = true
        this.forbidden.c51 = true
        this.forbidden.c52 = true
        this.forbidden.c53 = true

        this.formRecord.c54 = '否'
        this.formRecord.c55 = []
        this.formRecord.c56 = []
        this.formRecord.c57 = []
        this.forbidden.c54 = true
        this.forbidden.c55 = true
        this.forbidden.c56 = true
        this.forbidden.c57 = true

        this.formRecord.c58 = ''
        this.formRecord.c59 = []
        this.formRecord.c60 = ''
        this.forbidden.c59 = true
        this.forbidden.c60 = true

        this.formRecord.c61 = []
        this.formRecord.c62 = ''
        this.forbidden.c61 = true
        this.forbidden.c62 = true
      },
      memoryChange() {
        var c15 = this.formRecord.c15
        var c33 = this.formRecord.c33
        if (c15 == "台式微型计算机及一体机") {
          if (c33 == '是') {
            this.formRecord.c34 = ['1.0/（1GB)×（微型计算机总内存容量＿＿GB--基本内存容量＿＿GB）']
            this.forbidden.c34 = false
            this.forbidden.c35 = false
            this.forbidden.c36 = false
          } else {
            this.formRecord.c34 = []
            this.formRecord.c35 = ''
            this.formRecord.c36 = ''
            this.forbidden.c34 = true
            this.forbidden.c35 = true
            this.forbidden.c36 = true
          }
        } else if (c15 == "便携式计算机") {
          if (c33 == '是') {
            this.formRecord.c37 = ['0.4/（1GB)×（微型计算机总内存容量＿＿GB--基本内存容量＿＿GB）']
            this.forbidden.c37 = false
            this.forbidden.c38 = false
            this.forbidden.c39 = false
          } else {
            this.formRecord.c37 = []
            this.formRecord.c38 = ''
            this.formRecord.c39 = ''
            this.forbidden.c37 = true
            this.forbidden.c38 = true
            this.forbidden.c39 = true
          }
        }
      },
      storeInChange() {
        var c15 = this.formRecord.c15
        var c58 = this.formRecord.c58
        if (c15 == "台式微型计算机及一体机") {
          if (c58 == '是') {
            this.formRecord.c59 = ['25×附加硬盘数＿＿']
            this.forbidden.c59 = false
            this.forbidden.c60 = false
          } else {
            this.formRecord.c59 = []
            this.formRecord.c60 = ''
            this.forbidden.c59 = true
            this.forbidden.c60 = true
          }
        } else if (c15 == "便携式计算机") {
          if (c58 == '是') {
            this.formRecord.c61 = ['3×附加硬盘数＿＿']
            this.forbidden.c61 = false
            this.forbidden.c62 = false
          } else {
            this.formRecord.c61 = []
            this.formRecord.c62 = ''
            this.forbidden.c61 = true
            this.forbidden.c62 = true
          }
        }
      },
      gpuTypeChange() {
        var c15 = this.formRecord.c15
        var c27 = this.formRecord.c27
        if (c27 == "集成") {
          this.formRecord.c19 = ''
          this.formRecord.c20 = ''
          this.formRecord.c21 = ''
          this.forbidden.c19 = true
          this.forbidden.c20 = true
          this.forbidden.c21 = true
        } else if (c27 == "独立") {
          this.forbidden.c19 = false
          this.forbidden.c20 = false
          this.forbidden.c21 = false
        }
        if (c15 == "台式微型计算机及一体机") {
          if (c27 == "集成") {
            this.formRecord.c40 = '否'
            this.formRecord.c41 = []
            this.forbidden.c40 = true
            this.forbidden.c41 = true
            this.formRecord.c43 = '否'
            this.formRecord.c44 = []
            this.forbidden.c43 = true
            this.forbidden.c44 = true
            this.formRecord.c46 = '否'
            this.formRecord.c47 = []
            this.forbidden.c46 = true
            this.forbidden.c47 = true
            this.formRecord.c50 = '否'
            this.formRecord.c51 = []
            this.forbidden.c50 = true
            this.forbidden.c51 = true
            this.formRecord.c54 = '否'
            this.formRecord.c55 = []
            this.forbidden.c54 = true
            this.forbidden.c55 = true
          } else if (c27 == "独立") {
            this.formRecord.c41 = []
            this.forbidden.c40 = false
            this.forbidden.c41 = false
            this.formRecord.c44 = []
            this.forbidden.c43 = false
            this.forbidden.c44 = false
            this.formRecord.c47 = []
            this.forbidden.c46 = false
            this.forbidden.c47 = false
            this.formRecord.c51 = []
            this.forbidden.c50 = false
            this.forbidden.c51 = false
            this.formRecord.c55 = []
            this.forbidden.c54 = false
            this.forbidden.c55 = false
          }
          if (this.formRecord.c40 == '是') {
            this.forbidden.c41 = false
            this.formRecord.c41 = ['46']
          } else {
            this.formRecord.c41 = []
            this.forbidden.c41 = true
          }
          if (this.formRecord.c43 == '是') {
            this.forbidden.c44 = false
            this.formRecord.c44 = ['70']
          } else {
            this.formRecord.c44 = []
            this.forbidden.c44 = true
          }
          if (this.formRecord.c46 == '是') {
            this.forbidden.c47 = false
            this.formRecord.c47 = ['95']
          } else {
            this.formRecord.c47 = []
            this.forbidden.c47 = true
          }
          if (this.formRecord.c50 == '是') {
            this.forbidden.c51 = false
            this.formRecord.c51 = ['140']
          } else {
            this.formRecord.c51 = []
            this.forbidden.c51 = true
          }
          if (this.formRecord.c54 == '是') {
            this.forbidden.c55 = false
            this.formRecord.c55 = ['394']
          } else {
            this.formRecord.c55 = []
            this.forbidden.c55 = true
          }
        } else if (c15 == "便携式计算机") {
          var c17 = this.formRecord.c17
          if (c17 == 'B类') {
            if (c27 == "集成") {
              this.formRecord.c40 = '否'
              this.forbidden.c40 = true
              this.formRecord.c42 = []
              this.forbidden.c42 = true
              this.formRecord.c43 = '否'
              this.forbidden.c43 = true
              this.formRecord.c45 = []
              this.forbidden.c45 = true
              this.formRecord.c46 = '否'
              this.forbidden.c46 = true
              this.formRecord.c48 = []
              this.forbidden.c48 = true
              this.formRecord.c50 = '否'
              this.forbidden.c50 = true
              this.formRecord.c52 = []
              this.forbidden.c52 = true
              this.formRecord.c54 = '否'
              this.forbidden.c56 = true
              this.formRecord.c54 = []
              this.forbidden.c56 = true
            } else if (c27 == "独立") {
              if (this.forbidden.c40 == true)
                this.forbidden.c40 = false
              if (this.formRecord.c40 == '是') {
                this.forbidden.c42 = false
                this.formRecord.c42 = ['4']
              } else {
                this.formRecord.c42 = []
                this.forbidden.c42 = true
              }
              if (this.forbidden.c43 == true)
                this.forbidden.c43 = false
              if (this.formRecord.c43 == '是') {
                this.forbidden.c45 = false
                this.formRecord.c45 = ['12']
              } else {
                this.formRecord.c45 = []
                this.forbidden.c45 = true
              }
              if (this.forbidden.c46 == true)
                this.forbidden.c46 = false
              if (this.formRecord.c46 == '是') {
                this.forbidden.c48 = false
                this.formRecord.c48 = ['24']
              } else {
                this.formRecord.c48 = []
                this.forbidden.c48 = true
              }
              if (this.forbidden.c50 == true)
                this.forbidden.c50 = false
              if (this.formRecord.c50 == '是') {
                this.forbidden.c52 = false
                this.formRecord.c52 = ['36']
              } else {
                this.formRecord.c52 = []
                this.forbidden.c52 = true
              }
              if (this.forbidden.c54 == true)
                this.forbidden.c54 = false
              if (this.formRecord.c54 == '是') {
                this.forbidden.c56 = false
                this.formRecord.c56 = ['146']
              } else {
                this.formRecord.c56 = []
                this.forbidden.c56 = true
              }
            }
          } else if (c17 == 'C类') {
            if (c27 == "集成") {
              this.formRecord.c46 = '否'
              this.forbidden.c46 = true
              this.formRecord.c49 = []
              this.forbidden.c49 = true
              this.formRecord.c50 = '否'
              this.forbidden.c50 = true
              this.formRecord.c53 = []
              this.forbidden.c53 = true
              this.formRecord.c54 = '否'
              this.forbidden.c54 = true
              this.formRecord.c57 = []
              this.forbidden.c57 = true
            } else if (c27 == "独立") {
              if (this.forbidden.c46 == true)
                this.forbidden.c46 = false
              if (this.formRecord.c46 == '是') {
                this.forbidden.c49 = false
                this.formRecord.c49 = ['37']
              } else {
                this.formRecord.c49 = []
                this.forbidden.c49 = true
              }
              if (this.forbidden.c50 == true)
                this.forbidden.c50 = false
              if (this.formRecord.c50 == '是') {
                this.forbidden.c53 = false
                this.formRecord.c53 = ['49']
              } else {
                this.formRecord.c53 = []
                this.forbidden.c53 = true
              }
              if (this.forbidden.c54 == true)
                this.forbidden.c54 = false
              if (this.formRecord.c54 == '是') {
                this.forbidden.c57 = false
                this.formRecord.c57 = ['159']
              } else {
                this.formRecord.c57 = []
                this.forbidden.c57 = true
              }
            }
          }
        }
      },
      bxsjsjChange() {
        this.formRecord.c40 = '否'
        this.formRecord.c41 = []
        this.formRecord.c42 = []
        this.forbidden.c40 = true
        this.forbidden.c41 = true
        this.forbidden.c42 = true

        this.formRecord.c43 = '否'
        this.formRecord.c44 = []
        this.formRecord.c45 = []
        this.forbidden.c43 = true
        this.forbidden.c44 = true
        this.forbidden.c45 = true

        this.formRecord.c46 = '否'
        this.formRecord.c47 = []
        this.formRecord.c48 = []
        this.formRecord.c49 = []
        this.forbidden.c46 = true
        this.forbidden.c47 = true
        this.forbidden.c48 = true
        this.forbidden.c49 = true

        this.formRecord.c50 = '否'
        this.formRecord.c51 = []
        this.formRecord.c52 = []
        this.formRecord.c53 = []
        this.forbidden.c50 = true
        this.forbidden.c51 = true
        this.forbidden.c52 = true
        this.forbidden.c53 = true

        this.formRecord.c54 = '否'
        this.formRecord.c55 = []
        this.formRecord.c56 = []
        this.formRecord.c57 = []
        this.forbidden.c54 = true
        this.forbidden.c55 = true
        this.forbidden.c56 = true
        this.forbidden.c57 = true

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
        var nxdj = 0;
        var c5 = parseFloat(this.formRecord.c5);
        var c6 = parseFloat(this.formRecord.c6);
        const checkc6 = (rule, value, callback) => {
          if (c5 < c6) {
            callback('典型能源消耗标注值（C5）要≥典型能源消耗实测值（C6）')
          } else {
            callback()
          }
        }
        var c64 = this.formRecord.c64;
        var c2 = this.formRecord.c2;
        const repeat = (rule, value, callback) => {
          if (this.pageType === 'extend') {
            if (c64.indexOf("；") > -1) {
              callback('扩展型号分隔符有非法字符，请使用英文输入法下的分号";"')
            }
            let split1 = this.c64.split(";").filter(item => item !== "")
            let split2 = c64.split(";").filter(item => item !== "")
            for (let i = 0; i < split1.length; i++) {
              for (let j = 0; j < split2.length; j++) {
                if (split1[i] === split2[j]) {
                  callback("扩展型号与主型号备案中的规格型号或扩展型号重复")
                }
              }
            }

            for (let i = 0; i < split2.length; i++) {
              if (split2[i] === c2) {
                callback("扩展型号与规格型号重复。")
              }
            }

            for (let i = 0; i < split2.length; i++) {
              for (let j = i + 1; j < split2.length; j++) {
                if (split2[i] === split2[j]) {
                  callback("扩展型号重复。")
                }
              }
            }
            callback()
          }else {
            if (c64.indexOf("；") > -1) {
              callback('扩展型号分隔符有非法字符，请使用英文输入法下的分号";"')
            }
            let split1 = this.c64.split(";").filter(item => item !== "")
            let split2 = c64.split(";").filter(item => item !== "")
            for (let i = 0; i < split1.length; i++) {
              for (let j = 0; j < split2.length; j++) {
                if (split1[i] === split2[j]) {
                  callback("扩展型号与主型号备案中的规格型号或扩展型号重复")
                }
              }
            }

            for (let i = 0; i < split2.length; i++) {
              if (split2[i] === c2) {
                callback("扩展型号与规格型号重复。")
              }
            }

            for (let i = 0; i < split2.length; i++) {
              for (let j = i + 1; j < split2.length; j++) {
                if (split2[i] === split2[j]) {
                  callback("扩展型号重复。")
                }
              }
            }
            callback()
          }
        }

        var c15 = this.formRecord.c15;
        var c22 = parseFloat(this.formRecord.c22);
        if (c15 == "台式微型计算机及一体机") {
          var c16 = this.formRecord.c16;
          if (c16 == "A类") {
            if (c5 <= 98.0 + c22) {
              nxdj = 1;
            } else if (c5 <= 148.0 + c22) {
              nxdj = 2;
            } else if (c5 <= 198.0 + c22) {
              nxdj = 3;
            }
          } else if (c16 == "B类") {
            if (c5 <= 125.0 + c22) {
              nxdj = 1;
            } else if (c5 <= 175.0 + c22) {
              nxdj = 2;
            } else if (c5 <= 225.0 + c22) {
              nxdj = 3;
            }
          } else if (c16 == "C类") {
            if (c5 <= 159.0 + c22) {
              nxdj = 1;
            } else if (c5 <= 209.0 + c22) {
              nxdj = 2;
            } else if (c5 <= 259.0 + c22) {
              nxdj = 3;
            }
          } else if (c16 == "D类") {
            if (c5 <= 184.0 + c22) {
              nxdj = 1;
            } else if (c5 <= 234.0 + c22) {
              nxdj = 2;
            } else if (c5 <= 284.0 + c22) {
              nxdj = 3;
            }
          }
        } else if (c15 == "便携式计算机") {
          var c17 = this.formRecord.c17;
          if (c17 == "A类") {
            if (c5 <= 20.0 + c22) {
              nxdj = 1;
            } else if (c5 <= 35.0 + c22) {
              nxdj = 2;
            } else if (c5 <= 45.0 + c22) {
              nxdj = 3;
            }
          } else if (c17 == "B类") {
            if (c5 <= 26.0 + c22) {
              nxdj = 1;
            } else if (c5 <= 45.0 + c22) {
              nxdj = 2;
            } else if (c5 <= 65.0 + c22) {
              nxdj = 3;
            }
          } else if (c17 == "C类") {
            if (c5 <= 54.5 + c22) {
              nxdj = 1;
            } else if (c5 <= 75.0 + c22) {
              nxdj = 2;
            } else if (c5 <= 123.5 + c22) {
              nxdj = 3;
            }
          }
        }

        var c65 = this.formRecord.c65;
        const checkc65 = (rule, value, callback) => {
          if (nxdj == 0) {
            callback('该产品不在备案范围内！')
          } else {
            if (c65 != nxdj) {
              callback('所选能效等级与计算结果不符或该产品不在备案范围内！')
            } else {
              callback()
            }
          }
        }

        //gpu类型
        this.gpuTypeChange();

        // if(c15 == "台式微型计算机及一体机"){
        //    console.log("123456")
        //     if(this.formRecord.c40 =='是'){
        //       console.log("aaa")
        //       this.formRecord.c41=['46']
        //       this.forbidden.c41=false
        //     }else{
        //       console.log("bbb")
        //       this.formRecord.c41=[]
        //       this.forbidden.c41=true
        //     }
        //     if(this.formRecord.c43 =='是'){
        //       this.forbidden.c44=false
        //       this.formRecord.c44=['70']
        //     }else{
        //       this.formRecord.c44=[]
        //       this.forbidden.c44=true
        //     }
        //     if(this.formRecord.c46 =='是'){
        //       this.forbidden.c47=false
        //       this.formRecord.c47=['95']
        //     }else{
        //       this.formRecord.c47=[]
        //       this.forbidden.c47=true
        //     }
        //     if(this.formRecord.c50 =='是'){
        //       this.forbidden.c51=false
        //       this.formRecord.c51=['140']
        //     }else{
        //       this.formRecord.c51=[]
        //       this.forbidden.c51=true
        //     }
        //     if(this.formRecord.c54 =='是'){
        //       this.forbidden.c55=false
        //       this.formRecord.c55=['394']
        //     }else{
        //       this.formRecord.c55=[]
        //       this.forbidden.c55=true
        //     }

        // }else if(c15 == "便携式计算机"){

        // }

        // if(c15 == "台式微型计算机及一体机"){

        //     this.forbidden.c33=false
        //     this.forbidden.c58=false
        //     this.forbidden.c16=false
        //     this.forbidden.c17=true
        //     this.formRecord.c17=''
        //     this.clearBxsjsj();//禁用便携式计算机
        //     //是否有内存
        //     if(this.formRecord.c33 =='是'){
        //       this.formRecord.c34=['1.0/（1GB)×（微型计算机总内存容量＿＿GB--基本内存容量＿＿GB）']
        //       this.forbidden.c34=false
        //       this.forbidden.c35=false
        //       this.forbidden.c36=false
        //     }else{
        //       this.formRecord.c34=[]
        //       this.formRecord.c35=''
        //       this.forbidden.c35=true
        //       this.formRecord.c36=''
        //       this.forbidden.c36=true
        //     }
        //     //是否有附加硬盘
        //     if(this.formRecord.c58 =='是'){
        //       this.formRecord.c59=['25×附加硬盘数＿＿']
        //       this.forbidden.c59=false
        //       this.forbidden.c60=false
        //     }else{
        //       this.formRecord.c59=[]
        //       this.forbidden.c59=true
        //       this.formRecord.c60=''
        //       this.forbidden.c60=true
        //     }
        //     //GPU类型
        //     if(this.formRecord.c27 =='集成'){
        //       this.forbidden.gpu=true
        //       this.formRecord.c19=''
        //       this.formRecord.c20=''
        //       this.formRecord.c21=''
        //       this.formRecord.c40='否'
        //       this.formRecord.c41=[]
        //       this.forbidden.c40=true
        //       this.forbidden.c41=true
        //       this.formRecord.c43='否'
        //       this.formRecord.c44=[]
        //       this.forbidden.c43=true
        //       this.forbidden.c44=true
        //       this.formRecord.c46='否'
        //       this.formRecord.c47=[]
        //       this.forbidden.c46=true
        //       this.forbidden.c47=true
        //       this.formRecord.c50='否'
        //       this.formRecord.c51=[]
        //       this.forbidden.c50=true
        //       this.forbidden.c51=true
        //       this.formRecord.c54='否'
        //       this.formRecord.c55=[]
        //       this.forbidden.c54=true
        //       this.forbidden.c55=true
        //     }else{//独立
        //       this.forbidden.gpu=false
        //       this.forbidden.c40=false
        //       //this.formRecord.c40='否'
        //       this.forbidden.c41=false
        //       //this.formRecord.c41=[]
        //       this.forbidden.c43=false
        //       //this.formRecord.c43='否'
        //       this.forbidden.c44=false
        //       //this.formRecord.c44=[]
        //       this.forbidden.c46=false
        //       //this.formRecord.c46='否'
        //       this.forbidden.c47=false
        //       //this.formRecord.c47=[]
        //       this.forbidden.c50=false
        //       //this.formRecord.c50='否'
        //       this.forbidden.c51=false
        //       //this.formRecord.c51=[]
        //       this.forbidden.c54=false
        //       //this.formRecord.c54='否'
        //       this.forbidden.c55=false
        //       //this.formRecord.c55=[]
        //     }

        //     if(this.formRecord.c40 =='是'){
        //         this.forbidden.c41=false
        //         this.formRecord.c41=['46']
        //     }else{
        //       this.formRecord.c41=[]
        //       this.forbidden.c41=true
        //     }
        //     if(this.formRecord.c43 =='是'){
        //       this.forbidden.c44=false
        //       this.formRecord.c44=['70']
        //     }else{
        //       this.formRecord.c44=[]
        //       this.forbidden.c44=true
        //     }
        //     if(this.formRecord.c46 =='是'){
        //       this.forbidden.c47=false
        //       this.formRecord.c47=['95']
        //     }else{
        //       this.formRecord.c47=[]
        //       this.forbidden.c47=true
        //     }
        //     if(this.formRecord.c50 =='是'){
        //       this.forbidden.c51=false
        //       this.formRecord.c51=['140']
        //     }else{
        //       this.formRecord.c51=[]
        //       this.forbidden.c51=true
        //     }
        //     if(this.formRecord.c54 =='是'){
        //       this.forbidden.c55=false
        //       this.formRecord.c55=['394']
        //     }else{
        //       this.formRecord.c55=[]
        //       this.forbidden.c55=true
        //     }
        // }else if(c15 == "便携式计算机"){
        //     this.forbidden.c17=false
        //     this.forbidden.c16=true
        //     this.formRecord.c16=''
        //     if(this.formRecord.c17 =='A类' && this.formRecord.c27 =='集成'){//集成
        //        this.forbidden.gpu=true

        //        //清除A类便携机
        //        this.clearAlbxj();

        //        //A类便携机-内存 启用
        //        this.forbidden.c33=false
        //        this.formRecord.c34=[]
        //        this.forbidden.c34=true
        //        this.formRecord.c35=''
        //        this.forbidden.c35=true
        //        this.formRecord.c36=''
        //        this.forbidden.c36=true
        //        if( this.formRecord.c33 =='是'){
        //           this.formRecord.c37=['0.4/（1GB)×（微型计算机总内存容量＿＿GB--基本内存容量＿＿GB）']
        //           this.forbidden.c37=false
        //           this.formRecord.c38=''
        //           this.forbidden.c38=false
        //           this.formRecord.c39=''
        //           this.forbidden.c39=false
        //        }else{
        //           this.formRecord.c37=[]
        //           this.forbidden.c37=true
        //           this.formRecord.c38=''
        //           this.forbidden.c38=true
        //           this.formRecord.c39=''
        //           this.forbidden.c39=true
        //        }
        //        //A类便携机-内部存储 启用
        //        this.forbidden.c58=false
        //        this.formRecord.c59=[]
        //        this.forbidden.c59=true
        //        this.formRecord.c60=''
        //        this.forbidden.c60=true
        //        if( this.formRecord.c58 =='是'){
        //           this.formRecord.c61=['3×附加硬盘数＿＿']
        //            this.forbidden.c61=false
        //           this.formRecord.c62=''
        //           this.forbidden.c62=false
        //        }else{
        //           this.formRecord.c61=[]
        //           this.forbidden.c61=true
        //           this.formRecord.c62=''
        //           this.forbidden.c62=true
        //        }
        //     }else if(this.formRecord.c17 =='B类' && this.formRecord.c27 =='独立'){//独立
        //         this.forbidden.gpu=false

        //         //清除无用选项
        //         this.clearBcty();

        //         this.formRecord.c49=[]
        //         this.formRecord.c53=[]
        //         this.formRecord.c57=[]

        //         this.forbidden.c40=false
        //         if(this.formRecord.c40 =='是'){
        //           this.forbidden.c42=false
        //           this.formRecord.c42=['4']
        //         }else{
        //           this.formRecord.c42=[]
        //           this.forbidden.c42=true
        //         }
        //         this.forbidden.c43=false
        //         if(this.formRecord.c43 =='是'){
        //           this.forbidden.c45=false
        //           this.formRecord.c45=['12']
        //         }else{
        //           this.formRecord.c45=[]
        //           this.forbidden.c45=true
        //         }
        //         this.forbidden.c46=false
        //         if(this.formRecord.c46 =='是'){
        //           this.forbidden.c48=false
        //           this.formRecord.c48=['24']
        //         }else{
        //           this.formRecord.c48=[]
        //           this.forbidden.c48=true
        //         }
        //         this.forbidden.c50=false
        //         if(this.formRecord.c50 =='是'){
        //           this.forbidden.c52=false
        //           this.formRecord.c52=['36']
        //         }else{
        //           this.formRecord.c52=[]
        //           this.forbidden.c52=true
        //         }
        //         this.forbidden.c54=false
        //         if(this.formRecord.c54 =='是'){
        //           this.forbidden.c56=false
        //           this.formRecord.c56=['146']
        //         }else{
        //           this.formRecord.c56=[]
        //           this.forbidden.c56=true
        //         }
        //     }else if(this.formRecord.c17 =='C类' && this.formRecord.c27 =='独立'){//C类
        //         this.forbidden.gpu=false
        //          //清除无用选项
        //         this.clearBcty();
        //         //----通用结束
        //         this.formRecord.c40='否'
        //         this.forbidden.c40=true
        //         this.formRecord.c43='否'
        //         this.forbidden.c43=true
        //         this.formRecord.c42=[]
        //         this.forbidden.c42=true
        //         this.formRecord.c45=[]
        //         this.forbidden.c45=true
        //         this.formRecord.c48=[]
        //         this.forbidden.c48=true
        //         this.formRecord.c52=[]
        //         this.forbidden.c52=true
        //         this.formRecord.c56=[]
        //         this.forbidden.c56=true

        //         this.forbidden.c46=false
        //         if(this.formRecord.c46 =='是'){
        //           this.forbidden.c49=false
        //           this.formRecord.c49=['37']
        //         }else{
        //           this.formRecord.c49=[]
        //           this.forbidden.c49=true
        //         }
        //         this.forbidden.c50=false
        //         if(this.formRecord.c50 =='是'){
        //           this.forbidden.c53=false
        //           this.formRecord.c53=['49']
        //         }else{
        //           this.formRecord.c53=[]
        //           this.forbidden.c53=true
        //         }
        //         this.forbidden.c54=false
        //         if(this.formRecord.c54 =='是'){
        //           this.forbidden.c57=false
        //           this.formRecord.c57=['159']
        //         }else{
        //           this.formRecord.c57=[]
        //           this.forbidden.c57=true
        //         }

        //     }
        // }
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
            ],
            c64: [
              {
                validator: repeat,
                trigger: 'change,blur'
              }
            ]
          }
        } else {
          return {
            c1: [
              {
                required: true,
                trigger: 'change,blur',
                message: '请输入生产者名称'
              }
            ],
            c4: [
              {
                required: true,
                trigger: 'change,blur',
                message: '请输入制造单位'
              }
            ],
            c63: [
              {
                required: true,
                trigger: 'change,blur',
                message: '请输入备案方'
              }
            ],
            c64: [
              {
                validator: repeat,
                trigger: 'change,blur'
              }
            ],
            c2: [
              {
                required: true,
                trigger: 'change,blur',
                message: '请输入产品规格型号'
              }
            ],
            c3: [
              {
                required: true,
                trigger: 'change,blur',
                message: '请输入商标'
              }
            ],
            c200: [
              {
                required: true,
                trigger: 'change,blur',
                message: '请输入依据国家标准'
              }
            ],
            c65: [
              {
                required: true,
                trigger: 'change,blur',
                message: '请选择能效等级'
              },
              {
                validator: checkc65,
                trigger: 'change,blur'
              }
            ],
            c15: [
              {
                required: true,
                trigger: 'change,blur',
                message: '请选择产品类型'
              }
            ],
            c16: [
              {
                required: this.formRecord.c15 === "台式微型计算机及一体机",
                trigger: 'change,blur',
                message: '请选择类型'
              }
            ],
            c17: [
              {
                required: this.formRecord.c15 === "便携式计算机",
                trigger: 'change,blur',
                message: '请选择类型'
              }
            ],
            c22: [
              {
                required: true,
                trigger: 'change,blur',
                message: '请输入附加功能功耗因子之和'
              },
              {
                validator: oneDecimals,
                trigger: 'change,blur'
              }
            ],
            /* c5: [
             {
               required: true,
               trigger: 'change,blur',
               message: '请输入典型能源消耗标称值'
             },
             {
               validator: oneDecimals,
               trigger: 'change,blur'
             }
           ],*/
            c6: [
              {
                required: true,
                trigger: 'change,blur',
                message: '请输入典型能源消耗实测值'
              },
              {
                validator: atLeastTwoDecimals,
                trigger: 'change,blur'
              },
              {
                validator: checkc6,
                trigger: 'change,blur'
              }
            ],
            c14: [
              {
                required: true,
                message: '请输入备案开始日期'
              }
            ],
            c18: [
              {
                required: true,
                trigger: 'change,blur',
                message: '请输入内存'
              }
            ],
            c27: [
              {
                required: true,
                trigger: 'change,blur',
                message: '请选择'
              }
            ],
            c28: [
              {
                required: true,
                trigger: 'change,blur',
                message: '请输入 型号'
              }
            ],
            c19: [
              {
                required: this.formRecord.c27 === '独立',
                trigger: 'change,blur',
                message: '请输入显存等效频率'
              }
            ],
            c20: [
              {
                required: this.formRecord.c27 === '独立',
                trigger: 'change,blur',
                message: '请输入显存位宽'
              }
            ],
            c21: [
              {
                required: this.formRecord.c27 === '独立',
                trigger: 'change,blur',
                message: '请输入显存带宽'
              }
            ],
            c23: [
              {
                required: true,
                trigger: 'change,blur',
                message: '请输入操作系统名称及版本'
              }
            ],
            c24: [
              {
                required: true,
                trigger: 'change,blur',
                message: '请输入型号'
              }
            ],
            c25: [
              {
                required: true,
                trigger: 'change,blur',
                message: '请输入最高主频'
              }
            ],
            c26: [
              {
                required: true,
                trigger: 'change,blur',
                message: '请输入物理核心数量'
              }
            ],
            c29: [
              {
                required: true,
                trigger: 'change,blur',
                message: '请输入额定功率'
              }
            ],
            c30: [
              {
                required: true,
                trigger: 'change,blur',
                message: '请输入额定电流'
              }
            ],
            c31: [
              {
                required: true,
                trigger: 'change,blur',
                message: '请输入硬盘个数'
              }
            ],
            c32: [
              {
                required: true,
                trigger: 'change,blur',
                message: '请输入硬盘大小'
              }
            ],
            c33: [
              {
                required: true,
                trigger: 'change,blur',
                message: '请选择'
              }
            ],
            c40: [
              {
                required: true,
                trigger: 'change,blur',
                message: '请选择'
              }
            ],
            c43: [
              {
                required: true,
                trigger: 'change,blur',
                message: '请选择'
              }
            ],
            c46: [
              {
                required: true,
                trigger: 'change,blur',
                message: '请选择'
              }
            ],
            c50: [
              {
                required: true,
                trigger: 'change,blur',
                message: '请选择'
              }
            ],
            c54: [
              {
                required: true,
                trigger: 'change,blur',
                message: '请选择'
              }
            ],
            c58: [
              {
                required: true,
                trigger: 'change,blur',
                message: '请选择'
              }
            ],
            c35: [
              {
                required: this.formRecord.c34.join('').indexOf('1.0/（1GB)×（微型计算机总内存容量＿＿GB--基本内存容量＿＿GB）') > -1,
                trigger: 'change,blur',
                message: '请输入'
              }
            ],
            c36: [
              {
                required: this.formRecord.c34.join('').indexOf('1.0/（1GB)×（微型计算机总内存容量＿＿GB--基本内存容量＿＿GB）') > -1,
                trigger: 'change,blur',
                message: '请输入'
              }
            ],
            c38: [
              {
                required: this.formRecord.c37.join('').indexOf('0.4/（1GB)×（微型计算机总内存容量＿＿GB--基本内存容量＿＿GB）') > -1,
                trigger: 'change,blur',
                message: '请输入'
              }
            ],
            c39: [
              {
                required: this.formRecord.c37.join('').indexOf('0.4/（1GB)×（微型计算机总内存容量＿＿GB--基本内存容量＿＿GB）') > -1,
                trigger: 'change,blur',
                message: '请输入'
              }
            ],
            c60: [
              {
                required: this.formRecord.c59.join('').indexOf('25×附加硬盘数＿＿') > -1,
                trigger: 'change,blur',
                message: '请输入'
              }
            ],
            c62: [
              {
                required: this.formRecord.c61.join('').indexOf('3×附加硬盘数＿＿') > -1,
                trigger: 'change,blur',
                message: '请输入'
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
            c74: [
              {
                required: true,
                trigger: 'change,blur',
                message: '不能为空'
              }
            ],
            c75: [
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
            ]
          }
        }
      }
    }
  }
</script>
<style>
  @import '../../../css/comm.css';
</style>
