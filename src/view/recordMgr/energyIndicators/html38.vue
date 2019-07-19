<!--复印机、打印机和传真机 2014版-->
<!--创建日期:2019年5月27日-->
<!--创建人:YCL-->
<template>
  <div class="wrapper">
    <Form ref="formRecord" :model="formRecord" label-position="right" :rules="ruleRecord">
      <h1>复印机、打印机和传真机-能源效率标识备案表</h1>
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
          <FormItem prop="c4" label="规格型号" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c4" :disabled='!disabledoff' placeholder="规格型号"/>
          </FormItem>
          <FormItem prop="c5" label="商标" style="width:100%" :label-width="180">
            <Input type="text" v-model="formRecord.c5" :disabled='disabledoff' placeholder="商标"/>
          </FormItem>
          <FormItem prop="c200" label="依据国家标准" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c200" placeholder="依据国家标准" readonly disabled/>
          </FormItem>
          <FormItem prop="c6" label="能效等级" style="width:100%;" :label-width="180">
            <RadioGroup v-model="formRecord.c6">
              <Radio label="1" :disabled='disabledoff'>1级</Radio>
              <Radio label="2" :disabled='disabledoff'>2级</Radio>
              <Radio label="3" :disabled='disabledoff'>3级</Radio>
            </RadioGroup>
          </FormItem>
          <FormItem prop="c7" label="产品类型" :label-width="180">
            <Select v-model="formRecord.c7" style="width:200px">
              <Option value="单色复印机">单色复印机</Option>
              <Option value="单色打印机">单色打印机</Option>
              <Option value="单色传真机">单色传真机</Option>
              <Option value="彩色复印机">彩色复印机</Option>
              <Option value="彩色打印机">彩色打印机</Option>
              <Option value="彩色传真机">彩色传真机</Option>
              <Option value="单色多功能一体机">单色多功能一体机</Option>
              <Option value="彩色多功能一体机">彩色多功能一体机</Option>
              <Option value="喷墨打印机">喷墨打印机</Option>
              <Option value="针式打印机">针式打印机</Option>
              <Option value="喷墨多功能一体机">喷墨多功能一体机</Option>
              <Option value="喷墨传真机">喷墨传真机</Option>
            </Select>
          </FormItem>
          <table id="table1">
            <tr>
              <th></th>
              <th>项目</th>
              <th><i class="red">*</i>额定值</th>
              <th><i class="red">*</i>实测值</th>
              <th>备注</th>
            </tr>
            <tr>
              <td rowspan="2">单色复印机<br>单色打印机<br>单色传真机</td>
              <td>输出速度p(页/分钟)</td>
              <td>
                <FormItem prop="c8">
                  <Input type="text" v-model="formRecord.c8" :disabled='disabledoff || forbidden.c7_1'
                         placeholder="两位有效数字"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c9">
                  <Input type="text" v-model="formRecord.c9" :disabled='disabledoff || forbidden.c7_1'
                         placeholder="三位有效数字"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c10">
                  <Input type="text" v-model="formRecord.c10" :disabled='disabledoff || forbidden.c7_1'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>典型能耗(kW·h)</td>
              <td>
                <FormItem prop="c11">
                  <Input type="text" v-model="formRecord.c11" :disabled='disabledoff || forbidden.c7_1'
                         placeholder="两位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c12">
                  <Input type="text" v-model="formRecord.c12" :disabled='disabledoff || forbidden.c7_1'
                         placeholder="三位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c13">
                  <Input type="text" v-model="formRecord.c13" :disabled='disabledoff || forbidden.c7_1'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td rowspan="2">彩色复印机<br>彩色打印机<br>彩色传真机</td>
              <td>输出速度p(页/分钟)</td>
              <td>
                <FormItem prop="c14">
                  <Input type="text" v-model="formRecord.c14" :disabled='disabledoff || forbidden.c7_2'
                         placeholder="两位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c15">
                  <Input type="text" v-model="formRecord.c15" :disabled='disabledoff || forbidden.c7_2'
                         placeholder="三位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c16">
                  <Input type="text" v-model="formRecord.c16" :disabled='disabledoff || forbidden.c7_2'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>典型能耗(kW·h)</td>
              <td>
                <FormItem prop="c17">
                  <Input type="text" v-model="formRecord.c17" :disabled='disabledoff || forbidden.c7_2'
                         placeholder="两位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c18">
                  <Input type="text" v-model="formRecord.c18" :disabled='disabledoff || forbidden.c7_2'
                         placeholder="三位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c19">
                  <Input type="text" v-model="formRecord.c19" :disabled='disabledoff || forbidden.c7_2'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td rowspan="2">单色多功能一体机</td>
              <td>输出速度p(页/分钟)</td>
              <td>
                <FormItem prop="c20">
                  <Input type="text" v-model="formRecord.c20" :disabled='disabledoff || forbidden.c7_3'
                         placeholder="两位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c21">
                  <Input type="text" v-model="formRecord.c21" :disabled='disabledoff || forbidden.c7_3'
                         placeholder="三位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c22">
                  <Input type="text" v-model="formRecord.c22" :disabled='disabledoff || forbidden.c7_3'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>典型能耗(kW·h)</td>
              <td>
                <FormItem prop="c23">
                  <Input type="text" v-model="formRecord.c23" :disabled='disabledoff || forbidden.c7_3'
                         placeholder="两位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c24">
                  <Input type="text" v-model="formRecord.c24" :disabled='disabledoff || forbidden.c7_3'
                         placeholder="三位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c25">
                  <Input type="text" v-model="formRecord.c25" :disabled='disabledoff || forbidden.c7_3'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td rowspan="2">彩色多功能一体机</td>
              <td>输出速度p(页/分钟)</td>
              <td>
                <FormItem prop="c26">
                  <Input type="text" v-model="formRecord.c26" :disabled='disabledoff || forbidden.c7_4'
                         placeholder="两位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c27">
                  <Input type="text" v-model="formRecord.c27" :disabled='disabledoff || forbidden.c7_4'
                         placeholder="三位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c28">
                  <Input type="text" v-model="formRecord.c28" :disabled='disabledoff || forbidden.c7_4'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>典型能耗(kW·h)</td>
              <td>
                <FormItem prop="c29">
                  <Input type="text" v-model="formRecord.c29" :disabled='disabledoff || forbidden.c7_4'
                         placeholder="两位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c30">
                  <Input type="text" v-model="formRecord.c30" :disabled='disabledoff || forbidden.c7_4'
                         placeholder="三位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c31">
                  <Input type="text" v-model="formRecord.c31" :disabled='disabledoff || forbidden.c7_4'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td rowspan="5">喷墨打印机<br>针式打印机</td>
              <td>打印速度p(页/分钟)</td>
              <td>
                <FormItem prop="c32">
                  <Input type="text" v-model="formRecord.c32" :disabled='disabledoff || forbidden.c7_5'
                         placeholder="两位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c33">
                  <Input type="text" v-model="formRecord.c33" :disabled='disabledoff || forbidden.c7_5'
                         placeholder="三位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c34">
                  <Input type="text" v-model="formRecord.c34" :disabled='disabledoff || forbidden.c7_5'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>操作模式功率Pom（W）</td>
              <td>
                <FormItem prop="c35">
                  <Input type="text" v-model="formRecord.c35" :disabled='disabledoff || forbidden.c7_5'
                         placeholder="两位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c36">
                  <Input type="text" v-model="formRecord.c36" :disabled='disabledoff || forbidden.c7_5'
                         placeholder="三位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c37">
                  <Input type="text" v-model="formRecord.c37" :disabled='disabledoff || forbidden.c7_5'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>待机功率（W）</td>
              <td>
                <FormItem prop="c38">
                  <Input type="text" v-model="formRecord.c38" :disabled='disabledoff || forbidden.c7_5'
                         placeholder="两位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c39">
                  <Input type="text" v-model="formRecord.c39" :disabled='disabledoff || forbidden.c7_5'
                         placeholder="三位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c40">
                  <Input type="text" v-model="formRecord.c40" :disabled='disabledoff || forbidden.c7_5'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>预设延迟时间td（min）</td>
              <td>
                <FormItem prop="c41">
                  <Input type="text" v-model="formRecord.c41" :disabled='disabledoff || forbidden.c7_5'
                         placeholder="两位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c42">
                  <Input type="text" v-model="formRecord.c42" :disabled='disabledoff || forbidden.c7_5'
                         placeholder="三位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c43">
                  <Input type="text" v-model="formRecord.c43" :disabled='disabledoff || forbidden.c7_5'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>附加功能功率因子之和(W)</td>
              <td>
                <FormItem prop="c44">
                  <Input type="text" v-model="formRecord.c44" :disabled='disabledoff || forbidden.c7_5'
                         placeholder="两位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c45">
                  <Input type="text" v-model="formRecord.c45" :disabled='disabledoff || forbidden.c7_5'
                         placeholder="三位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c46">
                  <Input type="text" v-model="formRecord.c46" :disabled='disabledoff || forbidden.c7_5'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td rowspan="5">喷墨多功能一体机</td>
              <td>输出速度p(页/分钟)</td>
              <td>
                <FormItem prop="c47">
                  <Input type="text" v-model="formRecord.c47" :disabled='disabledoff || forbidden.c7_6'
                         placeholder="两位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c48">
                  <Input type="text" v-model="formRecord.c48" :disabled='disabledoff || forbidden.c7_6'
                         placeholder="三位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c49">
                  <Input type="text" v-model="formRecord.c49" :disabled='disabledoff || forbidden.c7_6'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>操作模式功率Pom（W）</td>
              <td>
                <FormItem prop="c50">
                  <Input type="text" v-model="formRecord.c50" :disabled='disabledoff || forbidden.c7_6'
                         placeholder="两位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c51">
                  <Input type="text" v-model="formRecord.c51" :disabled='disabledoff || forbidden.c7_6'
                         placeholder="三位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c52">
                  <Input type="text" v-model="formRecord.c52" :disabled='disabledoff || forbidden.c7_6'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>待机功率（W）</td>
              <td>
                <FormItem prop="c53">
                  <Input type="text" v-model="formRecord.c53" :disabled='disabledoff || forbidden.c7_6'
                         placeholder="两位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c54">
                  <Input type="text" v-model="formRecord.c54" :disabled='disabledoff || forbidden.c7_6'
                         placeholder="三位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c55">
                  <Input type="text" v-model="formRecord.c55" :disabled='disabledoff || forbidden.c7_6'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>预设延迟时间td（min）</td>
              <td>
                <FormItem prop="c56">
                  <Input type="text" v-model="formRecord.c56" :disabled='disabledoff || forbidden.c7_6'
                         placeholder="两位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c57">
                  <Input type="text" v-model="formRecord.c57" :disabled='disabledoff || forbidden.c7_6'
                         placeholder="三位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c58">
                  <Input type="text" v-model="formRecord.c58" :disabled='disabledoff || forbidden.c7_6'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>附加功能功率因子之和(W)</td>
              <td>
                <FormItem prop="c59">
                  <Input type="text" v-model="formRecord.c59" :disabled='disabledoff || forbidden.c7_6'
                         placeholder="两位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c60">
                  <Input type="text" v-model="formRecord.c60" :disabled='disabledoff || forbidden.c7_6'
                         placeholder="三位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c61">
                  <Input type="text" v-model="formRecord.c61" :disabled='disabledoff || forbidden.c7_6'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td rowspan="5">喷墨传真机</td>
              <td>传真速度p(页/分钟)</td>
              <td>
                <FormItem prop="c62">
                  <Input type="text" v-model="formRecord.c62" :disabled='disabledoff || forbidden.c7_7'
                         placeholder="两位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c63">
                  <Input type="text" v-model="formRecord.c63" :disabled='disabledoff || forbidden.c7_7'
                         placeholder="三位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c64">
                  <Input type="text" v-model="formRecord.c64" :disabled='disabledoff || forbidden.c7_7'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>操作模式功率Pom（W）</td>
              <td>
                <FormItem prop="c65">
                  <Input type="text" v-model="formRecord.c65" :disabled='disabledoff || forbidden.c7_7'
                         placeholder="两位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c66">
                  <Input type="text" v-model="formRecord.c66" :disabled='disabledoff || forbidden.c7_7'
                         placeholder="三位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c67">
                  <Input type="text" v-model="formRecord.c67" :disabled='disabledoff || forbidden.c7_7'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>待机功率（W）</td>
              <td>
                <FormItem prop="c68">
                  <Input type="text" v-model="formRecord.c68" :disabled='disabledoff || forbidden.c7_7'
                         placeholder="两位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c69">
                  <Input type="text" v-model="formRecord.c69" :disabled='disabledoff || forbidden.c7_7'
                         placeholder="三位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c70">
                  <Input type="text" v-model="formRecord.c70" :disabled='disabledoff || forbidden.c7_7'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>预设延迟时间td（min）</td>
              <td>
                <FormItem prop="c71">
                  <Input type="text" v-model="formRecord.c71" :disabled='disabledoff || forbidden.c7_7'
                         placeholder="两位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c72">
                  <Input type="text" v-model="formRecord.c72" :disabled='disabledoff || forbidden.c7_7'
                         placeholder="三位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c73">
                  <Input type="text" v-model="formRecord.c73" :disabled='disabledoff || forbidden.c7_7'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>附加功能功率因子之和(W)</td>
              <td>
                <FormItem prop="c74">
                  <Input type="text" v-model="formRecord.c74" :disabled='disabledoff || forbidden.c7_7'
                         placeholder="两位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c75">
                  <Input type="text" v-model="formRecord.c75" :disabled='disabledoff || forbidden.c7_7'
                         placeholder="三位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c76">
                  <Input type="text" v-model="formRecord.c76" :disabled='disabledoff || forbidden.c7_7'/>
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
          <FormItem prop="c77" label="备案标识开始使用日期" style="width:100%;">
            <DatePicker type="date" :options="dataInit" style="width: 200px" v-model="formRecord.c77"></DatePicker>
          </FormItem>
        </Card>
      </div>
      <div class="part part5">
        <Card :bordered="false">
          <h2>五、样品描述</h2>
          <table id="table3">
            <tr>
              <td rowspan="2" width="170" class="right-align"><i class="red">*</i>产品类型
              </td>
              <td colspan="3" width="241">
                <FormItem prop="c112">
                  <RadioGroup v-model="formRecord.c112">
                    <Radio label="热敏" :disabled='disabledoff'>热敏</Radio>
                    <Radio label="热升华" :disabled='disabledoff'>热升华</Radio>
                    <Radio label="电子映像" :disabled='disabledoff'>电子映像</Radio>
                    <Radio label="固体喷蜡" :disabled='disabledoff'>固体喷蜡</Radio>
                    <Radio label="热转印技术" :disabled='disabledoff'>热转印技术</Radio>
                    <Radio label="高性能喷墨技术" :disabled='disabledoff'>高性能喷墨技术</Radio>
                  </RadioGroup>
                </FormItem>
                <br/><br/>
                <hr>
                <FormItem prop="c114">
                  <RadioGroup v-model="formRecord.c114">
                    <Radio label="喷墨" :disabled='disabledoff'>喷墨</Radio>
                    <Radio label="针式击打技术" :disabled='disabledoff'>针式击打技术</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td colspan="3">
                <FormItem prop="c113">
                  <RadioGroup v-model="formRecord.c113">
                    <Radio label="单色复印机" :disabled='disabledoff'>单色复印机</Radio>
                    <Radio label="单色打印机" :disabled='disabledoff'>单色打印机</Radio>
                    <Radio label="单色传真机" :disabled='disabledoff'>单色传真机</Radio>
                    <Radio label="彩色复印机" :disabled='disabledoff'>彩色复印机</Radio>
                    <Radio label="彩色传真机" :disabled='disabledoff'>彩色传真机</Radio>
                    <Radio label="彩色打印机" :disabled='disabledoff'>彩色打印机</Radio>
                    <Radio label="单色多功能一体机" :disabled='disabledoff'>单色多功能一体机</Radio>
                    <Radio label="彩色多功能一体机" :disabled='disabledoff'>彩色多功能一体机</Radio>
                  </RadioGroup>
                </FormItem>
                <hr>
                <FormItem prop="c115">
                  <RadioGroup v-model="formRecord.c115">
                    <Radio label="喷墨打印机" :disabled='disabledoff'>喷墨打印机</Radio>
                    <Radio label="针式打印机" :disabled='disabledoff'>针式打印机</Radio>
                    <Radio label="喷墨传真机" :disabled='disabledoff'>喷墨传真机</Radio>
                    <Radio label="喷墨多功能一体机" :disabled='disabledoff'>喷墨多功能一体机</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="right-align"><i class="red">*</i>设备移动性</td>
              <td colspan="3">
                <FormItem prop="c79">
                  <RadioGroup v-model="formRecord.c79">
                    <Radio label="台式" :disabled='disabledoff'>台式</Radio>
                    <Radio label="落地式" :disabled='disabledoff'>落地式</Radio>
                    <Radio label="便携式" :disabled='disabledoff'>便携式</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="right-align"><i class="red">*</i>输出速度 p(页/分 钟)</td>
              <td colspan="3">
                <FormItem prop="c80">
                  <CheckboxGroup v-model="formRecord.c80">
                    <Checkbox label="黑白速度" :disabled='disabledoff'>黑白速度</Checkbox>
                  </CheckboxGroup>
                </FormItem>
                <FormItem prop="c81">
                  <Input type="text" v-model="formRecord.c81" :disabled='disabledoff || forbidden.c81'/>
                </FormItem>
                <FormItem>
                  <CheckboxGroup v-model="formRecord.c80">
                    <Checkbox label="彩色速度" :disabled='disabledoff'>彩色速度</Checkbox>
                  </CheckboxGroup>
                </FormItem>
                <FormItem prop="c82">
                  <Input type="text" v-model="formRecord.c82" :disabled='disabledoff || forbidden.c82'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="right-align"><i class="red">*</i>最大幅面<br>(最大输出纸路宽度)(mm)</td>
              <td>
                <FormItem prop="c83">
                  <Input type="text" v-model="formRecord.c83" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td colspan="2"></td>
            </tr>
            <tr>
              <td class="right-align"><i class="red">*</i>基础功能</td>
              <td colspan="3">
                <FormItem prop="c84">
                  <CheckboxGroup v-model="formRecord.c84">
                    <Checkbox label="复印" :disabled='disabledoff'>复印</Checkbox>
                    <Checkbox label="打印" :disabled='disabledoff'>打印</Checkbox>
                    <Checkbox label="传真" :disabled='disabledoff'>传真</Checkbox>
                    <Checkbox label="其它" :disabled='disabledoff'>其它</Checkbox>
                  </CheckboxGroup>
                </FormItem>
                <FormItem prop="c85">
                  <Input type="text" v-model="formRecord.c85" :disabled='disabledoff || forbidden.c85'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="right-align"><i class="red">*</i>扩展功能</td>
              <td colspan="3">
                <FormItem prop="c86">
                  <CheckboxGroup v-model="formRecord.c86">
                    <Checkbox label="复印" :disabled='disabledoff'>复印</Checkbox>
                    <Checkbox label="打印" :disabled='disabledoff'>打印</Checkbox>
                    <Checkbox label="传真" :disabled='disabledoff'>传真</Checkbox>
                    <Checkbox label="扫描" :disabled='disabledoff'>扫描</Checkbox>
                    <Checkbox label="其它" :disabled='disabledoff'>其它</Checkbox>
                  </CheckboxGroup>
                </FormItem>
                <FormItem prop="c87">
                  <Input type="text" v-model="formRecord.c87" :disabled='disabledoff || forbidden.c87'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="right-align"><i class="red">*</i>图像输出方式</td>
              <td colspan="3">
                <FormItem prop="c88">
                  <CheckboxGroup v-model="formRecord.c88">
                    <Checkbox label="彩色" :disabled='disabledoff'>彩色</Checkbox>
                    <Checkbox label="单色" :disabled='disabledoff'>单色</Checkbox>
                    <Checkbox label="单面" :disabled='disabledoff'>单面</Checkbox>
                    <Checkbox label="自动双面" :disabled='disabledoff'>自动双面</Checkbox>
                  </CheckboxGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="right-align"><i class="red">*</i>附加功能功率因子表
              </td>
              <td colspan="3">见附表1</td>
            </tr>
            <tr>
              <td class="right-align"><i class="red">*</i>附加功能功率因子之和(W)
              </td>
              <td>
                <FormItem prop="c89">
                  <Input type="text" v-model="formRecord.c89" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td class="right-align"><i class="red">*</i>电源直流输出功率
                (W)
              </td>
              <td>
                <FormItem prop="c90">
                  <Input type="text" v-model="formRecord.c90" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="right-align"><i class="red">*</i>测试接口</td>
              <td>
                <FormItem prop="c91">
                  <Input type="text" v-model="formRecord.c91" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td class="right-align"><i class="red">*</i>额定电压(V)</td>
              <td>
                <FormItem prop="c92">
                  <Input type="text" v-model="formRecord.c92" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="right-align"><i class="red">*</i>额定电流(A)</td>
              <td>
                <FormItem prop="c93">
                  <Input type="text" v-model="formRecord.c93" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td class="right-align"><i class="red">*</i>额定功率(W)</td>
              <td>
                <FormItem prop="c94">
                  <Input type="text" v-model="formRecord.c94" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="right-align"><i class="red">*</i>外形尺寸（长×宽×高）（mm×mm×mm）</td>
              <td colspan="3" class="w19">
                <FormItem prop="c95">
                  <Input type="text" v-model="formRecord.c95" :disabled='disabledoff'/>
                </FormItem>
                <FormItem><b>×</b></FormItem>
                <FormItem prop="c96">
                  <Input type="text" v-model="formRecord.c96" :disabled='disabledoff'/>
                </FormItem>
                <FormItem><b>×</b></FormItem>
                <FormItem prop="c97">
                  <Input type="text" v-model="formRecord.c97" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
          </table>
        </Card>
        <Card :bordered="false">
          <h2>附表1:产品附加功能功率因子表</h2>
          <table>
            <tr>
              <th>序号</th>
              <th>是否有该项附加功能</th>
              <th>附加功能</th>
              <th>附加功能功率功率因子Pfa（W）</th>
            </tr>
            <tr>
              <td>1</td>
              <td>
                <FormItem prop="c98">
                  <RadioGroup v-model="formRecord.c98">
                    <Radio label="是" :disabled='disabledoff'>是</Radio>
                    <Radio label="否" :disabled='disabledoff'>否</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td>传输速率小于2.0Mbps的有线接口</td>
              <td>0.2</td>
            </tr>
            <tr>
              <td>2</td>
              <td>
                <FormItem prop="c99">
                  <RadioGroup v-model="formRecord.c99">
                    <Radio label="是" :disabled='disabledoff'>是</Radio>
                    <Radio label="否" :disabled='disabledoff'>否</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td>传输速率大于等于20Mbps且小于500Mbps的有线接口</td>
              <td>0.4</td>
            </tr>
            <tr>
              <td>3</td>
              <td>
                <FormItem prop="c100">
                  <RadioGroup v-model="formRecord.c100">
                    <Radio label="是" :disabled='disabledoff'>是</Radio>
                    <Radio label="否" :disabled='disabledoff'>否</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td>传输速率大于等于500Mbps的有线接口</td>
              <td>0.5</td>
            </tr>
            <tr>
              <td>4</td>
              <td>
                <FormItem prop="c101">
                  <RadioGroup v-model="formRecord.c101">
                    <Radio label="是" :disabled='disabledoff'>是</Radio>
                    <Radio label="否" :disabled='disabledoff'>否</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td>其它有线接口</td>
              <td>0.2</td>
            </tr>
            <tr>
              <td>5</td>
              <td>
                <FormItem prop="c102">
                  <RadioGroup v-model="formRecord.c102">
                    <Radio label="是" :disabled='disabledoff'>是</Radio>
                    <Radio label="否" :disabled='disabledoff'>否</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td>传真调制解调器</td>
              <td>0.2</td>
            </tr>
            <tr>
              <td>6</td>
              <td>
                <FormItem prop="c103">
                  <RadioGroup v-model="formRecord.c103">
                    <Radio label="是" :disabled='disabledoff'>是</Radio>
                    <Radio label="否" :disabled='disabledoff'>否</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td>无线射频数据接口</td>
              <td>2.0</td>
            </tr>
            <tr>
              <td>7</td>
              <td>
                <FormItem prop="c104">
                  <RadioGroup v-model="formRecord.c104">
                    <Radio label="是" :disabled='disabledoff'>是</Radio>
                    <Radio label="否" :disabled='disabledoff'>否</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td>无线红外数据接口</td>
              <td>0.1</td>
            </tr>
            <tr>
              <td>8</td>
              <td>
                <FormItem prop="c105">
                  <RadioGroup v-model="formRecord.c105">
                    <Radio label="是" :disabled='disabledoff'>是</Radio>
                    <Radio label="否" :disabled='disabledoff'>否</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td>无线话筒</td>
              <td>0.8</td>
            </tr>
            <tr>
              <td>9</td>
              <td>
                <FormItem prop="c106">
                  <RadioGroup v-model="formRecord.c106">
                    <Radio label="是" :disabled='disabledoff'>是</Radio>
                    <Radio label="否" :disabled='disabledoff'>否</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td>每1GB内存</td>
              <td>0.5</td>
            </tr>
            <tr>
              <td>10</td>
              <td>
                <FormItem prop="c107">
                  <RadioGroup v-model="formRecord.c107">
                    <Radio label="是" :disabled='disabledoff'>是</Radio>
                    <Radio label="否" :disabled='disabledoff'>否</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td>扫描功能</td>
              <td>0.5</td>
            </tr>
            <tr>
              <td>11</td>
              <td>
                <FormItem prop="c108">
                  <RadioGroup v-model="formRecord.c108">
                    <Radio label="是" :disabled='disabledoff'>是</Radio>
                    <Radio label="否" :disabled='disabledoff'>否</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td>电源直流输出功能</td>
              <td>当总额定输出功率(POUT )大于10W时,用以下公式计算:<br>0.02 X
                (POUT -10.0)
              </td>
            </tr>
            <tr>
              <td>12</td>
              <td>
                <FormItem prop="c109">
                  <RadioGroup v-model="formRecord.c109">
                    <Radio label="是" :disabled='disabledoff'>是</Radio>
                    <Radio label="否" :disabled='disabledoff'>否</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td>触摸板显示屏</td>
              <td>0.2</td>
            </tr>
            <tr>
              <td>13</td>
              <td>
                <FormItem prop="c110">
                  <RadioGroup v-model="formRecord.c110">
                    <Radio label="是" :disabled='disabledoff'>是</Radio>
                    <Radio label="否" :disabled='disabledoff'>否</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td>内部磁盘驱动器</td>
              <td>0.15</td>
            </tr>
          </table>
        </Card>
      </div>
      <div class="part part6">
        <h2 class="pl-34">六、产品基本配置清单</h2>
        <Card :bordered="false">
          <h2>复印机:</h2>
          <table id="table4">
            <tr>
              <th>序号</th>
              <th>部件名称</th>
              <th>位号</th>
              <th>型号规格</th>
              <th>技术参数</th>
              <th>生产者（全称）</th>
            </tr>
            <tr>
              <td>1</td>
              <td>电源管理芯片</td>
              <td>
                <FormItem prop="c116">
                  <Input type="text" v-model="formRecord.c116" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c117">
                  <Input type="text" v-model="formRecord.c117" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c118">
                  <Input type="text" v-model="formRecord.c118" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c119">
                  <Input type="text" v-model="formRecord.c119" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>2</td>
              <td>电源管理芯片</td>
              <td>
                <FormItem prop="c120">
                  <Input type="text" v-model="formRecord.c120" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c121">
                  <Input type="text" v-model="formRecord.c121" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c122">
                  <Input type="text" v-model="formRecord.c122" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c123">
                  <Input type="text" v-model="formRecord.c123" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>3</td>
              <td>主电源变压器</td>
              <td>
                <FormItem prop="c124">
                  <Input type="text" v-model="formRecord.c124" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c125">
                  <Input type="text" v-model="formRecord.c125" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c126">
                  <Input type="text" v-model="formRecord.c126" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c127">
                  <Input type="text" v-model="formRecord.c127" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>4</td>
              <td>主电源变压器</td>
              <td>
                <FormItem prop="c128">
                  <Input type="text" v-model="formRecord.c128" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c129">
                  <Input type="text" v-model="formRecord.c129" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c130">
                  <Input type="text" v-model="formRecord.c130" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c131">
                  <Input type="text" v-model="formRecord.c131" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>5</td>
              <td>辅电源变压器</td>
              <td>
                <FormItem prop="c132">
                  <Input type="text" v-model="formRecord.c132" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c133">
                  <Input type="text" v-model="formRecord.c133" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c134">
                  <Input type="text" v-model="formRecord.c134" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c135">
                  <Input type="text" v-model="formRecord.c135" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>6</td>
              <td>辅电源变压器</td>
              <td>
                <FormItem prop="c136">
                  <Input type="text" v-model="formRecord.c136" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c137">
                  <Input type="text" v-model="formRecord.c137" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c138">
                  <Input type="text" v-model="formRecord.c138" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c139">
                  <Input type="text" v-model="formRecord.c139" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>7</td>
              <td>待机控制电路(主板)</td>
              <td>
                <FormItem prop="c140">
                  <Input type="text" v-model="formRecord.c140" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c141">
                  <Input type="text" v-model="formRecord.c141" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c142">
                  <Input type="text" v-model="formRecord.c142" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c143">
                  <Input type="text" v-model="formRecord.c143" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>8</td>
              <td>待机控制电路(主板)</td>
              <td>
                <FormItem prop="c144">
                  <Input type="text" v-model="formRecord.c144" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c145">
                  <Input type="text" v-model="formRecord.c145" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c146">
                  <Input type="text" v-model="formRecord.c146" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c147">
                  <Input type="text" v-model="formRecord.c147" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>9</td>
              <td>待机控制电(CPU)</td>
              <td>
                <FormItem prop="c148">
                  <Input type="text" v-model="formRecord.c148" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c149">
                  <Input type="text" v-model="formRecord.c149" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c150">
                  <Input type="text" v-model="formRecord.c150" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c151">
                  <Input type="text" v-model="formRecord.c151" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>10</td>
              <td>待机控制电(CPU)</td>
              <td>
                <FormItem prop="c152">
                  <Input type="text" v-model="formRecord.c152" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c153">
                  <Input type="text" v-model="formRecord.c153" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c154">
                  <Input type="text" v-model="formRecord.c154" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c155">
                  <Input type="text" v-model="formRecord.c155" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
          </table>
        </Card>
        <Card :bordered="false">
          <h2>打印机和传真机：</h2>
          <table>
            <tr>
              <th>序号</th>
              <th>部件名称</th>
              <th>位号</th>
              <th>型号规格</th>
              <th colspan="2">技术参数</th>
              <th>生产者（全称）</th>
            </tr>
            <tr>
              <td>1</td>
              <td>主板</td>
              <td>
                <FormItem prop="c156">
                  <Input type="text" v-model="formRecord.c156" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c157">
                  <Input type="text" v-model="formRecord.c157" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td colspan="2">
                <FormItem prop="c158">
                  <Input type="text" v-model="formRecord.c158" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c159">
                  <Input type="text" v-model="formRecord.c159" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>2</td>
              <td>主板</td>
              <td>
                <FormItem prop="c160">
                  <Input type="text" v-model="formRecord.c160" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c161">
                  <Input type="text" v-model="formRecord.c161" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td colspan="2">
                <FormItem prop="c162">
                  <Input type="text" v-model="formRecord.c162" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c163">
                  <Input type="text" v-model="formRecord.c163" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td rowspan="5">3</td>
              <td rowspan="5">适配器（外接电源）</td>
              <td rowspan="5">

                <FormItem prop="c164">
                  <Input type="text" v-model="formRecord.c164" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td rowspan="5">

                <FormItem prop="c165">
                  <Input type="text" v-model="formRecord.c165" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>输入电压</td>
              <td>
                <FormItem prop="c166">
                  <Input type="text" v-model="formRecord.c166" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td rowspan="5">

                <FormItem prop="c167">
                  <Input type="text" v-model="formRecord.c167" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>输入电流/功率</td>
              <td>
                <FormItem prop="c168">
                  <Input type="text" v-model="formRecord.c168" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>输入频率</td>
              <td>
                <FormItem prop="c169">
                  <Input type="text" v-model="formRecord.c169" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>输出电压</td>
              <td>
                <FormItem prop="c170">
                  <Input type="text" v-model="formRecord.c170" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>输出电流/功率</td>
              <td>
                <FormItem prop="c171">
                  <Input type="text" v-model="formRecord.c171" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td rowspan="5">4</td>
              <td rowspan="5">适配器（外接电源）</td>
              <td rowspan="5">

                <FormItem prop="c172">
                  <Input type="text" v-model="formRecord.c172" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td rowspan="5">

                <FormItem prop="c173">
                  <Input type="text" v-model="formRecord.c173" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>输入电压</td>
              <td>
                <FormItem prop="c174">
                  <Input type="text" v-model="formRecord.c174" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td rowspan="5">

                <FormItem prop="c175">
                  <Input type="text" v-model="formRecord.c175" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>输入电流/功率</td>
              <td>
                <FormItem prop="c176">
                  <Input type="text" v-model="formRecord.c176" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>输入频率</td>
              <td>
                <FormItem prop="c177">
                  <Input type="text" v-model="formRecord.c177" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>输出电压</td>
              <td>
                <FormItem prop="c178">
                  <Input type="text" v-model="formRecord.c178" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>输出电流/功率</td>
              <td>
                <FormItem prop="c179">
                  <Input type="text" v-model="formRecord.c179" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>5</td>
              <td>主电源板</td>
              <td>
                <FormItem prop="c180">
                  <Input type="text" v-model="formRecord.c180" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c181">
                  <Input type="text" v-model="formRecord.c181" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td colspan="2">
                <FormItem prop="c182">
                  <Input type="text" v-model="formRecord.c182" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c183">
                  <Input type="text" v-model="formRecord.c183" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>6</td>
              <td>主电源板</td>
              <td>
                <FormItem prop="c184">
                  <Input type="text" v-model="formRecord.c184" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c185">
                  <Input type="text" v-model="formRecord.c185" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td colspan="2">
                <FormItem prop="c186">
                  <Input type="text" v-model="formRecord.c186" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c187">
                  <Input type="text" v-model="formRecord.c187" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>7</td>
              <td>主电源变压器</td>
              <td>
                <FormItem prop="c188">
                  <Input type="text" v-model="formRecord.c188" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c189">
                  <Input type="text" v-model="formRecord.c189" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td colspan="2">
                <FormItem prop="c190">
                  <Input type="text" v-model="formRecord.c190" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c191">
                  <Input type="text" v-model="formRecord.c191" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>8</td>
              <td>主电源变压器</td>
              <td>
                <FormItem prop="c192">
                  <Input type="text" v-model="formRecord.c192" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c193">
                  <Input type="text" v-model="formRecord.c193" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td colspan="2">
                <FormItem prop="c194">
                  <Input type="text" v-model="formRecord.c194" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c195">
                  <Input type="text" v-model="formRecord.c195" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>9</td>
              <td>电源管理芯片</td>
              <td>
                <FormItem prop="c196">
                  <Input type="text" v-model="formRecord.c196" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c197">
                  <Input type="text" v-model="formRecord.c197" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td colspan="2">
                <FormItem prop="c198">
                  <Input type="text" v-model="formRecord.c198" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c199">
                  <Input type="text" v-model="formRecord.c199" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>10</td>
              <td>电源管理芯片</td>
              <td>
                <FormItem prop="c221">
                  <Input type="text" v-model="formRecord.c221" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c202">
                  <Input type="text" v-model="formRecord.c202" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td colspan="2">
                <FormItem prop="c203">
                  <Input type="text" v-model="formRecord.c203" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c204">
                  <Input type="text" v-model="formRecord.c204" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>11</td>
              <td>辅电源板</td>
              <td>
                <FormItem prop="c205">
                  <Input type="text" v-model="formRecord.c205" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c206">
                  <Input type="text" v-model="formRecord.c206" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td colspan="2">
                <FormItem prop="c207">
                  <Input type="text" v-model="formRecord.c207" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c208">
                  <Input type="text" v-model="formRecord.c208" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>12</td>
              <td>辅电源板</td>
              <td>
                <FormItem prop="c209">
                  <Input type="text" v-model="formRecord.c209" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c210">
                  <Input type="text" v-model="formRecord.c210" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td colspan="2">
                <FormItem prop="c211">
                  <Input type="text" v-model="formRecord.c211" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c212">
                  <Input type="text" v-model="formRecord.c212" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>13</td>
              <td>辅电源变压器</td>
              <td>
                <FormItem prop="c213">
                  <Input type="text" v-model="formRecord.c213" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c214">
                  <Input type="text" v-model="formRecord.c214" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td colspan="2">
                <FormItem prop="c215">
                  <Input type="text" v-model="formRecord.c215" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c216">
                  <Input type="text" v-model="formRecord.c216" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>14</td>
              <td>辅电源变压器</td>
              <td>
                <FormItem prop="c217">
                  <Input type="text" v-model="formRecord.c217" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c218">
                  <Input type="text" v-model="formRecord.c218" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td colspan="2">
                <FormItem prop="c219">
                  <Input type="text" v-model="formRecord.c219" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c220">
                  <Input type="text" v-model="formRecord.c220" :disabled='disabledoff'/>
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
              <td><Input type="text" v-model="formRecord.c222" :disabled='disabledoff'/></td>
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
        型号的 <span class="f-product">复印机、打印机和传真机 2014版</span>产品{{pageType==="update"?'已通过能效标识备案':''}}。
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
        thisDateCV: "c77",
        // 当前能效等级 对应的C值
        thisLevelCV: "c6",
        // 当前规格型号 对应的C值
        thisGZXHCV: "c4",
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
        mainModel: '',
        formRecord: {
          ec_master_kuozhan_text: '',
          c1: '',
          c2: '',
          c3: '',
          c4: '',
          c5: '',
          c200: '',
          c6: '',
          c7: '',
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
          c77: new Date(),
          c112: '',
          c114: '',
          c113: '',
          c115: '',
          c79: '',
          c80: [],
          c81: '',
          c82: '',
          c83: '',
          c84: [],
          c85: '',
          c86: [],
          c87: '',
          c88: [],
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
          c107: '',
          c108: '',
          c109: '',
          c110: '',
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
          c139: '',
          c140: '',
          c141: '',
          c142: '',
          c143: '',
          c144: '',
          c145: '',
          c146: '',
          c147: '',
          c148: '',
          c149: '',
          c150: '',
          c151: '',
          c152: '',
          c153: '',
          c154: '',
          c155: '',
          c156: '',
          c157: '',
          c158: '',
          c159: '',
          c160: '',
          c161: '',
          c162: '',
          c163: '',
          c164: '',
          c165: '',
          c166: '',
          c167: '',
          c168: '',
          c169: '',
          c170: '',
          c171: '',
          c172: '',
          c173: '',
          c174: '',
          c175: '',
          c176: '',
          c177: '',
          c178: '',
          c179: '',
          c180: '',
          c181: '',
          c182: '',
          c183: '',
          c184: '',
          c185: '',
          c186: '',
          c187: '',
          c188: '',
          c189: '',
          c190: '',
          c191: '',
          c192: '',
          c193: '',
          c194: '',
          c195: '',
          c196: '',
          c197: '',
          c198: '',
          c199: '',
          c221: '',
          c202: '',
          c203: '',
          c204: '',
          c205: '',
          c206: '',
          c207: '',
          c208: '',
          c209: '',
          c210: '',
          c211: '',
          c212: '',
          c213: '',
          c214: '',
          c215: '',
          c216: '',
          c217: '',
          c218: '',
          c219: '',
          c220: '',
          c222: '',
          ec_model_no: 38,
          attach_list: ''
        },
        forbidden: {
          c7_1: true,
          c7_2: true,
          c7_3: true,
          c7_4: true,
          c7_5: true,
          c7_6: true,
          c7_7: true,
          c81: true,
          c82: true,
          c85: true,
          c87: true,
        },
        c7V: ''
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
        this.forbidden.c7_1 = true
        this.forbidden.c7_2 = true
        this.forbidden.c7_3 = true
        this.forbidden.c7_4 = true
        this.forbidden.c7_5 = true
        this.forbidden.c7_6 = true
        this.forbidden.c7_7 = true

        if (this.c7V !== "" && this.c7V !== this.formRecord.c7) {
          this.formRecord.c8 = ''
          this.formRecord.c9 = ''
          this.formRecord.c10 = ''
          this.formRecord.c11 = ''
          this.formRecord.c12 = ''
          this.formRecord.c13 = ''
          this.formRecord.c14 = ''
          this.formRecord.c15 = ''
          this.formRecord.c16 = ''
          this.formRecord.c17 = ''
          this.formRecord.c18 = ''
          this.formRecord.c19 = ''
          this.formRecord.c20 = ''
          this.formRecord.c21 = ''
          this.formRecord.c22 = ''
          this.formRecord.c23 = ''
          this.formRecord.c24 = ''
          this.formRecord.c25 = ''
          this.formRecord.c26 = ''
          this.formRecord.c27 = ''
          this.formRecord.c28 = ''
          this.formRecord.c29 = ''
          this.formRecord.c30 = ''
          this.formRecord.c31 = ''
          this.formRecord.c32 = ''
          this.formRecord.c33 = ''
          this.formRecord.c34 = ''
          this.formRecord.c35 = ''
          this.formRecord.c36 = ''
          this.formRecord.c37 = ''
          this.formRecord.c38 = ''
          this.formRecord.c39 = ''
          this.formRecord.c40 = ''
          this.formRecord.c41 = ''
          this.formRecord.c42 = ''
          this.formRecord.c43 = ''
          this.formRecord.c44 = ''
          this.formRecord.c45 = ''
          this.formRecord.c46 = ''
          this.formRecord.c47 = ''
          this.formRecord.c48 = ''
          this.formRecord.c49 = ''
          this.formRecord.c50 = ''
          this.formRecord.c51 = ''
          this.formRecord.c52 = ''
          this.formRecord.c53 = ''
          this.formRecord.c54 = ''
          this.formRecord.c55 = ''
          this.formRecord.c56 = ''
          this.formRecord.c57 = ''
          this.formRecord.c58 = ''
          this.formRecord.c59 = ''
          this.formRecord.c60 = ''
          this.formRecord.c61 = ''
          this.formRecord.c62 = ''
          this.formRecord.c63 = ''
          this.formRecord.c64 = ''
          this.formRecord.c65 = ''
          this.formRecord.c66 = ''
          this.formRecord.c67 = ''
          this.formRecord.c68 = ''
          this.formRecord.c69 = ''
          this.formRecord.c70 = ''
          this.formRecord.c71 = ''
          this.formRecord.c72 = ''
          this.formRecord.c73 = ''
          this.formRecord.c74 = ''
          this.formRecord.c75 = ''
          this.formRecord.c76 = ''
        }
        this.c7V = this.formRecord.c7
        if (this.formRecord.c7 === '单色复印机' || this.formRecord.c7 === '单色打印机' || this.formRecord.c7 === '单色传真机') {
          this.forbidden.c7_1 = false
        } else if (this.formRecord.c7 === '彩色复印机' || this.formRecord.c7 === '彩色打印机' || this.formRecord.c7 === '彩色传真机') {
          this.forbidden.c7_2 = false
        } else if (this.formRecord.c7 === '单色多功能一体机') {
          this.forbidden.c7_3 = false
        } else if (this.formRecord.c7 === '彩色多功能一体机') {
          this.forbidden.c7_4 = false
        } else if (this.formRecord.c7 === '喷墨打印机' || this.formRecord.c7 === '针式打印机') {
          this.forbidden.c7_5 = false
        } else if (this.formRecord.c7 === '喷墨多功能一体机') {
          this.forbidden.c7_6 = false
        } else if (this.formRecord.c7 === '喷墨传真机') {
          this.forbidden.c7_7 = false
        }

        if (this.formRecord.c80.join('').indexOf('黑白速度') > -1) {
          this.forbidden.c81 = false
        } else {
          this.formRecord.c81 = ''
          this.forbidden.c81 = true
        }
        if (this.formRecord.c80.join('').indexOf('彩色速度') > -1) {
          this.forbidden.c82 = false
        } else {
          this.formRecord.c82 = ''
          this.forbidden.c82 = true
        }
        if (this.formRecord.c84.join('').indexOf('其它') > -1) {
          this.forbidden.c85 = false
        } else {
          this.formRecord.c85 = ''
          this.forbidden.c85 = true
        }
        if (this.formRecord.c86.join('').indexOf('其它') > -1) {
          this.forbidden.c87 = false
        } else {
          this.formRecord.c87 = ''
          this.forbidden.c87 = true
        }

        var c11 = parseFloat(this.formRecord.c11);
        var c12 = parseFloat(this.formRecord.c12);
        var c17 = parseFloat(this.formRecord.c17);
        var c18 = parseFloat(this.formRecord.c18);
        var c44 = parseFloat(this.formRecord.c44);
        var c35 = parseFloat(this.formRecord.c35);
        var c38 = parseFloat(this.formRecord.c38);
        var c23 = parseFloat(this.formRecord.c23);
        var c24 = parseFloat(this.formRecord.c24);
        var c29 = parseFloat(this.formRecord.c29);
        var c30 = parseFloat(this.formRecord.c30);
        var c36 = parseFloat(this.formRecord.c36);
        var c39 = parseFloat(this.formRecord.c39);
        var c51 = parseFloat(this.formRecord.c51);
        var c53 = parseFloat(this.formRecord.c53);
        var c54 = parseFloat(this.formRecord.c54);
        var c66 = parseFloat(this.formRecord.c66);
        var c68 = parseFloat(this.formRecord.c68);
        var c69 = parseFloat(this.formRecord.c69);
        var nxdj = 0;
        var zhlkd = parseFloat(this.formRecord.c83);//最大幅面
        var c7 = this.formRecord.c7;//产品类型
        var c50 = parseFloat(this.formRecord.c50);
        var c59 = parseFloat(this.formRecord.c59);
        var cz = Math.round(c50 * 100);//操作模式功率Pom标称值2.2*100=220
        var dj = Math.round(c53 * 100);//待机功率（W）标称值0.5*100=50
        var yz = Math.round(c59 * 100);//附加功能功率因子之和(W)标称值1.6*100=160
        var c65 = parseFloat(this.formRecord.c65);
        var c74 = parseFloat(this.formRecord.c74);

        let checkc12 = (rule, value, callback) => {
          if (c12 > c11) {
            callback(" 单色复印机、单色打印机、单色传真机典型能耗实测值应小于等于标称值！");
          } else {
            callback()
          }
        }

        let checkc18 = (rule, value, callback) => {
          if (c18 > c17) {
            callback("彩色复印机、彩色打印机、彩色传真机典型能耗实测值应小于等于标称值！");
          } else {
            callback()
          }
        }


        let checkc24 = (rule, value, callback) => {
          if (c24 > c23) {
            callback("单色多功能一体机典型能耗实测值应小于等于标称值！");
          } else {
            callback()
          }
        }

        let checkc30 = (rule, value, callback) => {
          if (c30 > c29) {
            callback("彩色多功能一体机典型能耗实测值应小于等于标称值！");
          } else {
            callback()
          }
        }


        let checkc36 = (rule, value, callback) => {
          if (c36 > c35) {
            callback("喷墨打印机、针式打印机操作模式功率Pom（W）实测值应小于等于标称值！");
          } else {
            callback()
          }
        }

        let checkc39 = (rule, value, callback) => {
          if (c39 > c38) {
            callback("喷墨打印机、针式打印机待机功率（W）实测值应小于等于标称值！");
          } else {
            callback()
          }
        }

        let checkc51 = (rule, value, callback) => {
          if (c51 > c50) {
            callback("喷墨多功能一体机操作模式功率Pom（W）实测值应小于等于标称值！");
          } else {
            callback()
          }
        }

        let checkc54 = (rule, value, callback) => {
          if (c54 > c53) {
            callback("喷墨多功能一体机待机功率（W）实测值应小于等于标称值！");
          } else {
            callback()
          }
        }

        let checkc66 = (rule, value, callback) => {
          if (c66 > c65) {
            callback("喷墨传真机操作模式功率Pom（W）实测值应小于等于标称值！");
          } else {
            callback()
          }
        }

        let checkc69 = (rule, value, callback) => {
          if (c69 > c68) {
            callback("喷墨传真机待机功率（W）实测值应小于等于标称值！");
          } else {
            callback()
          }
        }


        if (zhlkd < 275) { //最大幅面210< 275
          if (c7 === "单色复印机" || c7 === "单色打印机" || c7 === "单色传真机") {
            let speed = parseFloat(this.formRecord.c8);
            let c11 = parseFloat(this.formRecord.c11);
            let dxnh = Math.round(c11 * 100);
            if (speed <= 5) {
              if (dxnh <= 20) {
                nxdj = 1;
              } else if (dxnh <= 30 && dxnh > 20) {
                nxdj = 2;
              } else if (dxnh <= 100 && dxnh > 30) {
                nxdj = 3;
              }
            } else if (speed > 5 && speed <= 20) {
              if (dxnh <= speed * 3 + 3) {
                nxdj = 1;
              } else if (dxnh <= speed * 4 + 10) {
                nxdj = 2;
              } else if (dxnh <= speed * 6 + 65) {
                nxdj = 3;
              }
            } else if (speed > 20 && speed <= 30) {
              if (dxnh <= speed * 3 + 2) {
                nxdj = 1;
              } else if (dxnh <= speed * 6 - 30 && dxnh > speed * 3 + 2) {
                nxdj = 2;
              } else if (dxnh <= speed * 10 - 20 && dxnh > speed * 6 - 30) {
                nxdj = 3;
              }
            } else if (speed > 30 && speed <= 40) {
              if (dxnh <= speed * 6 - 90) {
                nxdj = 1;
              } else if (dxnh <= speed * 11 - 180 && dxnh > speed * 6 - 90) {
                nxdj = 2;
              } else if (dxnh <= speed * 10 - 20 && dxnh > speed * 11 - 180) {
                nxdj = 3;
              }
            } else if (speed > 40 && speed <= 65) {
              if (dxnh <= speed * 9 - 210) {
                nxdj = 1;
              } else if (dxnh <= speed * 16 - 380 && dxnh > speed * 9 - 210) {
                nxdj = 2;
              } else if (dxnh <= speed * 35 - 1030 && dxnh > speed * 16 - 380) {
                nxdj = 3;
              }
            } else if (speed > 65) {
              if (dxnh <= speed * 9 - 210) {
                nxdj = 1;
              } else if (dxnh <= speed * 20 - 640 && dxnh > speed * 9 - 210) {
                nxdj = 2;
              } else if (dxnh <= speed * 35 - 1030 && dxnh > speed * 20 - 640) {
                nxdj = 3;
              }
            }
          }
          if (c7 === "彩色复印机" || c7 === "彩色打印机" || c7 === "彩色传真机") {
            let speed = parseFloat(this.formRecord.c14);
            let c17 = parseFloat(this.formRecord.c17);
            let dxnh = Math.round(c17 * 100);
            if (speed <= 10) {
              if (dxnh <= 70) {
                nxdj = 1;
              } else if (dxnh <= 130 && dxnh > 70) {
                nxdj = 2;
              } else if (dxnh <= speed * 10 + 280 && dxnh > 130) {
                nxdj = 3;
              }
            } else if (speed > 10 && speed <= 15) {
              if (dxnh <= speed * 4 + 30) {
                nxdj = 1;
              } else if (dxnh <= speed * 6 + 70 && dxnh > speed * 4 + 30) {
                nxdj = 2;
              } else if (dxnh <= speed * 10 + 280 && dxnh > speed * 6 + 70) {
                nxdj = 3;
              }
            } else if (speed > 15 && speed <= 30) {
              if (dxnh <= speed * 4 + 30) {
                nxdj = 1;
              } else if (dxnh <= speed * 15 - 65 && dxnh > speed * 4 + 30) {
                nxdj = 2;
              } else if (dxnh <= speed * 10 + 280 && dxnh > speed * 15 - 65) {
                nxdj = 3;
              }
            } else if (speed > 30) {
              if (dxnh <= speed * 9 - 120) {
                nxdj = 1;
              } else if (dxnh <= speed * 20 - 215 && dxnh > speed * 9 - 120) {
                nxdj = 2;
              } else if (dxnh <= speed * 35 - 500 && dxnh > speed * 20 - 215) {
                nxdj = 3;
              }
            }
          }
          if (c7 === "单色多功能一体机") {
            let speed = parseFloat(this.formRecord.c20);
            let c23 = parseFloat(this.formRecord.c23);
            let dxnh = Math.round(c23 * 100);
            if (speed <= 5) {
              if (dxnh <= 30) {
                nxdj = 1;
              } else if (dxnh <= 40 && dxnh > 30) {
                nxdj = 2;
              } else if (dxnh <= 150 && dxnh > 40) {
                nxdj = 3;
              }
            } else if (speed > 5 && speed <= 30) {
              if (dxnh <= speed * 3 + 15) {
                nxdj = 1;
              } else if (dxnh <= speed * 7 + 5 && dxnh > speed * 3 + 15) {
                nxdj = 2;
              } else if (dxnh <= speed * 13 + 85 && dxnh > speed * 7 + 5) {
                nxdj = 3;
              }
            } else if (speed > 30 && speed <= 50) {
              if (dxnh <= speed * 8 - 140) {
                nxdj = 1;
              } else if (dxnh <= speed * 11 - 115 && dxnh > speed * 8 - 140) {
                nxdj = 2;
              } else if (dxnh <= speed * 35 - 600 && dxnh > speed * 11 - 115) {
                nxdj = 3;
              }
            } else if (speed > 50) {
              if (dxnh <= speed * 9 - 190) {
                nxdj = 1;
              } else if (dxnh <= speed * 25 - 815 && dxnh > speed * 9 - 190) {
                nxdj = 2;
              } else if (dxnh <= speed * 35 - 600 && dxnh > speed * 25 - 815) {
                nxdj = 3;
              }
            }
          }
          if (c7 === "彩色多功能一体机") {
            let speed = parseFloat(this.formRecord.c26);
            let c29 = parseFloat(this.formRecord.c29);
            let dxnh = Math.round(c29 * 100);
            if (speed <= 10) {
              if (dxnh <= 100) {
                nxdj = 1;
              } else if (dxnh <= 150 && dxnh > 100) {
                nxdj = 2;
              } else if (dxnh <= speed * 10 + 350 && dxnh > 150) {
                nxdj = 3;
              }
            } else if (speed > 10 && speed <= 15) {
              if (dxnh <= speed * 2 + 80) {
                nxdj = 1;
              } else if (dxnh <= speed * 10 + 50 && dxnh > speed * 2 + 80) {
                nxdj = 2;
              } else if (dxnh <= speed * 10 + 350 && dxnh > speed * 10 + 50) {
                nxdj = 3;
              }
            } else if (speed > 15 && speed <= 30) {
              if (dxnh <= speed * 6 + 20) {
                nxdj = 1;
              } else if (dxnh <= speed * 13 + 5 && dxnh > speed * 6 + 20) {
                nxdj = 2;
              } else if (dxnh <= speed * 19 + 200 && dxnh > speed * 13 + 5) {
                nxdj = 3;
              }
            } else if (speed > 30) {
              if (dxnh <= speed * 9 - 70) {
                nxdj = 1;
              } else if (dxnh <= speed * 20 - 205 && dxnh > speed * 9 - 70) {
                nxdj = 2;
              } else if (dxnh <= speed * 35 - 300 && dxnh > speed * 20 - 205) {
                nxdj = 3;
              }
            }
          }
        } else {
          if (c7 === "单色复印机" || c7 === "单色打印机" || c7 === "单色传真机") {
            let speed = parseFloat(this.formRecord.c8);
            let c11 = parseFloat(this.formRecord.c11);
            let dxnh = Math.round(c11 * 100);
            if (speed <= 5) {
              if (dxnh <= 50) {
                nxdj = 1;
              } else if (dxnh <= 60 && dxnh > 50) {
                nxdj = 2;
              } else if (dxnh <= 130 && dxnh > 60) {
                nxdj = 3;
              }
            } else if (speed > 5 && speed <= 20) {
              if (dxnh <= speed * 3 + 33) {
                nxdj = 1;
              } else if (dxnh <= speed * 4 + 40) {
                nxdj = 2;
              } else if (dxnh <= speed * 6 + 95) {
                nxdj = 3;
              }
            } else if (speed > 20 && speed <= 30) {
              if (dxnh <= speed * 3 + 32) {
                nxdj = 1;
              } else if (dxnh <= speed * 6 && dxnh > speed * 3 + 32) {
                nxdj = 2;
              } else if (dxnh <= speed * 10 + 10 && dxnh > speed * 6) {
                nxdj = 3;
              }
            } else if (speed > 30 && speed <= 40) {
              if (dxnh <= speed * 6 - 60) {
                nxdj = 1;
              } else if (dxnh <= speed * 11 - 150 && dxnh > speed * 6 - 60) {
                nxdj = 2;
              } else if (dxnh <= speed * 10 + 10 && dxnh > speed * 11 - 150) {
                nxdj = 3;
              }
            } else if (speed > 40 && speed <= 65) {
              if (dxnh <= speed * 9 - 180) {
                nxdj = 1;
              } else if (dxnh <= speed * 16 - 350 && dxnh > speed * 9 - 180) {
                nxdj = 2;
              } else if (dxnh <= speed * 35 - 1000 && dxnh > speed * 16 - 350) {
                nxdj = 3;
              }
            } else if (speed > 65) {
              if (dxnh <= speed * 9 - 180) {
                nxdj = 1;
              } else if (dxnh <= speed * 20 - 610 && dxnh > speed * 9 - 180) {
                nxdj = 2;
              } else if (dxnh <= speed * 35 - 1000 && dxnh > speed * 20 - 610) {
                nxdj = 3;
              }
            }
          }
          if (c7 === "彩色复印机" || c7 === "彩色打印机" || c7 === "彩色传真机") {
            let speed = parseFloat(this.formRecord.c14);
            let c17 = parseFloat(this.formRecord.c17);
            let dxnh = Math.round(c17 * 100);
            if (speed <= 10) {
              if (dxnh <= 100) {
                nxdj = 1;
              } else if (dxnh <= 160 && dxnh > 100) {
                nxdj = 2;
              } else if (dxnh <= speed * 10 + 310 && dxnh > 160) {
                nxdj = 3;
              }
            } else if (speed > 10 && speed <= 15) {
              if (dxnh <= speed * 4 + 60) {
                nxdj = 1;
              } else if (dxnh <= speed * 6 + 100 && dxnh > speed * 4 + 60) {
                nxdj = 2;
              } else if (dxnh <= speed * 10 + 310 && dxnh > speed * 6 + 100) {
                nxdj = 3;
              }
            } else if (speed > 15 && speed <= 30) {
              if (dxnh <= speed * 4 + 30 + 30) {
                nxdj = 1;
              } else if (dxnh <= speed * 15 - 35 && dxnh > speed * 4 + 60) {
                nxdj = 2;
              } else if (dxnh <= speed * 10 + 310 && dxnh > speed * 15 - 35) {
                nxdj = 3;
              }
            } else if (speed > 30) {
              if (dxnh <= speed * 9 - 90) {
                nxdj = 1;
              } else if (dxnh <= speed * 20 - 185 && dxnh > speed * 9 - 90) {
                nxdj = 2;
              } else if (dxnh <= speed * 35 - 470 && dxnh > speed * 20 - 185) {
                nxdj = 3;
              }
            }
          }
          if (c7 === "单色多功能一体机") {
            let speed = parseFloat(this.formRecord.c20);//输出速度43
            let c23 = parseFloat(this.formRecord.c23);//典型能耗2.25
            let dxnh = Math.round(c23 * 100);//225
            if (speed <= 5) {
              if (dxnh <= 60) {
                nxdj = 1;
              } else if (dxnh <= 70 && dxnh > 60) {
                nxdj = 2;
              } else if (dxnh <= 180 && dxnh > 70) {
                nxdj = 3;
              }
            } else if (speed > 5 && speed <= 30) {
              if (dxnh <= speed * 3 + 45) {
                nxdj = 1;
              } else if (dxnh <= speed * 7 + 35 && dxnh > speed * 3 + 45) {
                nxdj = 2;
              } else if (dxnh <= speed * 13 + 115 && dxnh > speed * 7 + 35) {
                nxdj = 3;
              }
            } else if (speed > 30 && speed <= 50) {
              if (dxnh <= speed * 8 - 110) {//234
                nxdj = 1;
              } else if (dxnh <= speed * 11 - 85 && dxnh > speed * 8 - 110) {
                nxdj = 2;
              } else if (dxnh <= speed * 35 - 570 && dxnh > speed * 11 - 85) {
                nxdj = 3;
              }
            } else if (speed > 50) {
              if (dxnh <= speed * 9 - 160) {
                nxdj = 1;
              } else if (dxnh <= speed * 25 - 785 && dxnh > speed * 9 - 160) {
                nxdj = 2;
              } else if (dxnh <= speed * 35 - 570 && dxnh > speed * 25 - 785) {
                nxdj = 3;
              }
            }
          }
          if (c7 === "彩色多功能一体机") {
            let speed = parseFloat(this.formRecord.c26);
            let c29 = parseFloat(this.formRecord.c29);
            let dxnh = Math.round(c29 * 100);
            if (speed <= 10) {
              if (dxnh <= 130) {
                nxdj = 1;
              } else if (dxnh <= 180 && dxnh > 130) {
                nxdj = 2;
              } else if (dxnh <= speed * 10 + 380 && dxnh > 180) {
                nxdj = 3;
              }
            } else if (speed > 10 && speed <= 15) {
              if (dxnh <= speed * 2 + 110) {
                nxdj = 1;
              } else if (dxnh <= speed * 10 + 80 && dxnh > speed * 2 + 110) {
                nxdj = 2;
              } else if (dxnh <= speed * 10 + 380 && dxnh > speed * 10 + 80) {
                nxdj = 3;
              }
            } else if (speed > 15 && speed <= 30) {
              if (dxnh <= speed * 6 + 50) {
                nxdj = 1;
              } else if (dxnh <= speed * 13 + 35 && dxnh > speed * 6 + 50) {
                nxdj = 2;
              } else if (dxnh <= speed * 19 + 230 && dxnh > speed * 13 + 35) {
                nxdj = 3;
              }
            } else if (speed > 30) {
              if (dxnh <= speed * 9 - 40) {
                nxdj = 1;
              } else if (dxnh <= speed * 20 - 175 && dxnh > speed * 9 - 40) {
                nxdj = 2;
              } else if (dxnh <= speed * 35 - 270 && dxnh > speed * 20 - 175) {
                nxdj = 3;
              }
            }
          }
        }

        let checkc41;

        if (c7 === "喷墨打印机" || c7 === "针式打印机") {
          var c32 = parseFloat(this.formRecord.c32);
          var c41 = parseFloat(this.formRecord.c41);
          var dysd = Math.round(c32 * 10);
          checkc41 = (rule, value, callback) => {
            if (dysd <= 100) {
              if (c41 > 5) {
                callback("预设延迟时间大于最大允许值");
              } else {
                callback()
              }
            }
            if (dysd > 100 && dysd <= 200) {
              if (c41 > 15) {
                callback("预设延迟时间大于最大允许值");
              } else {
                callback()
              }
            }
            if (dysd > 200 && dysd <= 300) {
              if (c41 > 30) {
                callback("预设延迟时间大于最大允许值");
              } else {
                callback()
              }
            }
            if (dysd > 300) {
              if (c41() > 60) {
                callback("预设延迟时间大于最大允许值");
              } else {
                callback()
              }
            }
            callback()
          }


          if (c7 === "喷墨打印机") {
            if (cz <= 60 + yz) {
              if (dj <= 50) {
                nxdj = 1;
              }
            } else if (cz <= 100 + yz && cz > 60 + yz) {
              if (dj <= 50) {
                nxdj = 2;
              }
            } else if (cz <= 140 + yz && cz > 100 + yz) {
              if (dj <= 100) {
                nxdj = 3;
              }
            }
          }
          if (c7 === "针式打印机") {
            if (cz <= 60 + yz) {
              if (dj <= 50) {
                nxdj = 1;
              }
            } else if (cz <= 260 + yz && cz > 60 + yz) {
              if (dj <= 50) {
                nxdj = 2;
              }
            } else if (cz <= 460 + yz && cz > 260 + yz) {
              if (dj <= 100) {
                nxdj = 3;
              }
            }
          }
        }

        let checkc56;
        if (c7 === "喷墨多功能一体机") {
          var c47 = parseFloat(this.formRecord.c47);//输出速度p(页/分钟)_标称值25.0
          var c56 = parseFloat(this.formRecord.c56);//预设延迟时间td（min）标称值60
          var dyspm = Math.round(c47 * 10);//250
          checkc56 = (rule, value, callback) => {
            if (dyspm <= 100) {
              if (c56 > 15) {
                callback("预设延迟时间大于最大允许值");
              } else {
                callback()
              }
            }
            if (dyspm > 100 && dyspm <= 200) {
              if (c56 > 30) {
                callback("预设延迟时间大于最大允许值");
              } else {
                callback()
              }
            }
            if (dyspm > 200) {
              if (c56 > 60) {
                callback("预设延迟时间大于最大允许值");
              } else {
                callback()
              }
            }
            callback()
          }

          if (cz <= 60 + yz) {
            if (dj <= 50) {
              nxdj = 1;
            }
          }
          if (cz <= 100 + yz && cz > 60 + yz) {
            if (dj <= 50) {
              nxdj = 2;
            }
          }
          if (cz <= 140 + yz && cz > 100 + yz) {
            if (dj <= 100) {
              nxdj = 3;
            }
          }
        }

        let checkc71;
        if (c7 === "喷墨传真机") {
          var c71 = parseFloat(this.formRecord.c71);
          checkc71 = (rule, value, callback) => {
            if (c71 > 5) {
              callback("预设延迟时间大于最大允许值");
            } else {
              callback()
            }
          }

          if (cz <= 60 + yz) {
            if (dj <= 50) {
              nxdj = 1;
            }
          } else if (cz <= 100 + yz && cz > 60 + yz) {
            if (dj <= 50) {
              nxdj = 2;
            }
          } else if (cz <= 140 + yz && cz > 100 + yz) {
            if (dj <= 100) {
              nxdj = 3;
            }
          }
        }
        var c6 = this.formRecord.c6;
        let checkc6 = (rule, value, callback) => {
          if (nxdj === 0) {
            callback("能效数据不再备案范围");
          }
          if (nxdj != c6) {
            callback("所选能效等级与计算结果不符！》》所选能效等级：" + c6 + "||计算结果为：" + nxdj);
          }
          callback()
        }

        return {
          c2: [
            {
              required: true,
              trigger: 'change,blur',
              message: '制造单位不能为空'
            }
          ],
          c3: [
            {
              required: true,
              trigger: 'change,blur',
              message: '备案方不能为空'
            }
          ],
          c4: [
            {
              required: true,
              trigger: 'change,blur',
              message: '产品规格型号不能为空'
            }
          ],
          c5: [
            {
              required: true,
              trigger: 'change,blur',
              message: '商标不能为空'
            }
          ],
          c6: [
            {
              required: true,
              trigger: 'change,blur',
              message: '能效等级不能为空'
            },
            {
              validator: checkc6,
              trigger: 'change,blur'
            }
          ],
          c7: [
            {
              required: true,
              trigger: 'change,blur',
              message: '产品类型不能为空'
            }
          ],
          c8: [
            {
              required: !this.forbidden.c7_1,
              trigger: 'change,blur',
              message: '标称值不能为空'
            }
          ],
          c9: [
            {
              required: !this.forbidden.c7_1,
              trigger: 'change,blur',
              message: '实测值不能为空'
            }
          ],
          c11: [
            {
              required: !this.forbidden.c7_1,
              trigger: 'change,blur',
              message: '标称值不能为空'
            },
            {
              validator: !this.forbidden.c7_1 ? twoDecimals : check,
              trigger: 'change,blur'
            }
          ],
          c12: [
            {
              required: !this.forbidden.c7_1,
              trigger: 'change,blur',
              message: '实测值不能为空'
            },
            {
              validator: !this.forbidden.c7_1 ? atLeastThreeDecimals : check,
              trigger: 'change,blur'
            },
            {
              validator: checkc12,
              trigger: 'change,blur'
            }
          ],
          c14: [
            {
              required: !this.forbidden.c7_2,
              trigger: 'change,blur',
              message: '标称值不能为空'
            }
          ],
          c15: [
            {
              required: !this.forbidden.c7_2,
              trigger: 'change,blur',
              message: '实测值不能为空'
            }
          ],
          c17: [
            {
              required: !this.forbidden.c7_2,
              trigger: 'change,blur',
              message: '标称值不能为空'
            },
            {
              validator: !this.forbidden.c7_2 ? twoDecimals : check,
              trigger: 'change,blur'
            }
          ],
          c18: [
            {
              required: !this.forbidden.c7_2,
              trigger: 'change,blur',
              message: '实测值不能为空'
            },
            {
              validator: !this.forbidden.c7_2 ? atLeastThreeDecimals : check,
              trigger: 'change,blur'
            },
            {
              validator: checkc18,
              trigger: 'change,blur'
            }
          ],
          c20: [
            {
              required: !this.forbidden.c7_3,
              trigger: 'change,blur',
              message: '标称值不能为空'
            }
          ],
          c21: [
            {
              required: !this.forbidden.c7_3,
              trigger: 'change,blur',
              message: '实测值不能为空'
            }
          ],
          c23: [
            {
              required: !this.forbidden.c7_3,
              trigger: 'change,blur',
              message: '标称值不能为空'
            },
            {
              validator: !this.forbidden.c7_3 ? twoDecimals : check,
              trigger: 'change,blur'
            }
          ],
          c24: [
            {
              required: !this.forbidden.c7_3,
              trigger: 'change,blur',
              message: '实测值不能为空'
            },
            {
              validator: !this.forbidden.c7_3 ? atLeastThreeDecimals : check,
              trigger: 'change,blur'
            },
            {
              validator: checkc24,
              trigger: 'change,blur'
            }
          ],
          c26: [
            {
              required: !this.forbidden.c7_4,
              trigger: 'change,blur',
              message: '标称值不能为空'
            }
          ],
          c27: [
            {
              required: !this.forbidden.c7_4,
              trigger: 'change,blur',
              message: '实测值不能为空'
            }
          ],
          c29: [
            {
              required: !this.forbidden.c7_4,
              trigger: 'change,blur',
              message: '标称值不能为空'
            },
            {
              validator: !this.forbidden.c7_4 ? twoDecimals : check,
              trigger: 'change,blur'
            }
          ],
          c30: [
            {
              required: !this.forbidden.c7_4,
              trigger: 'change,blur',
              message: '实测值不能为空'
            },
            {
              validator: !this.forbidden.c7_4 ? atLeastThreeDecimals : check,
              trigger: 'change,blur'
            },
            {
              validator: checkc30,
              trigger: 'change,blur'
            }
          ],
          c32: [
            {
              required: !this.forbidden.c7_5,
              trigger: 'change,blur',
              message: '标称值不能为空'
            },
            {
              validator: !this.forbidden.c7_5 ? oneDecimals : check,
              trigger: 'change,blur'
            }
          ],
          c33: [
            {
              required: !this.forbidden.c7_5,
              trigger: 'change,blur',
              message: '实测值不能为空'
            }
          ],
          c35: [
            {
              required: !this.forbidden.c7_5,
              trigger: 'change,blur',
              message: '标称值不能为空'
            },
            {
              validator: !this.forbidden.c7_5 ? oneDecimals : check,
              trigger: 'change,blur'
            }
          ],
          c36: [
            {
              required: !this.forbidden.c7_5,
              trigger: 'change,blur',
              message: '实测值不能为空'
            },
            {
              validator: !this.forbidden.c7_5 ? atLeastTwoDecimals : check,
              trigger: 'change,blur'
            },
            {
              validator: checkc36,
              trigger: 'change,blur'
            }
          ],
          c38: [
            {
              required: !this.forbidden.c7_5,
              trigger: 'change,blur',
              message: '标称值不能为空'
            },
            {
              validator: !this.forbidden.c7_5 ? oneDecimals : check,
              trigger: 'change,blur'
            }
          ],
          c39: [
            {
              required: !this.forbidden.c7_5,
              trigger: 'change,blur',
              message: '实测值不能为空'
            },
            {
              validator: !this.forbidden.c7_5 ? atLeastTwoDecimals : check,
              trigger: 'change,blur'
            },
            {
              validator: checkc39,
              trigger: 'change,blur'
            }
          ],
          c41: [
            {
              required: !this.forbidden.c7_5,
              trigger: 'change,blur',
              message: '标称值应为整数'
            },
            {
              validator: !this.forbidden.c7_5 ? numberCheck : check,
              trigger: 'change,blur'
            },
            {
              validator: checkc41,
              trigger: 'change,blur'
            }
          ],
          c42: [
            {
              required: !this.forbidden.c7_5,
              trigger: 'change,blur',
              message: '实测值不能为空'
            },
            {
              validator: !this.forbidden.c7_5 ? oneDecimals : check,
              trigger: 'change,blur'
            }
          ],
          c44: [
            {
              required: !this.forbidden.c7_5,
              trigger: 'change,blur',
              message: '标称值不能为空'
            },
            {
              validator: !this.forbidden.c7_5 ? oneDecimals : check,
              trigger: 'change,blur'
            }
          ],
          c45: [
            {
              required: !this.forbidden.c7_5,
              trigger: 'change,blur',
              message: '实测值不能为空'
            },
            {
              validator: !this.forbidden.c7_5 ? atLeastTwoDecimals : check,
              trigger: 'change,blur'
            }
          ],
          c47: [
            {
              required: !this.forbidden.c7_6,
              trigger: 'change,blur',
              message: '标称值不能为空'
            },
            {
              validator: !this.forbidden.c7_6 ? oneDecimals : check,
              trigger: 'change,blur'
            }
          ],
          c48: [
            {
              required: !this.forbidden.c7_6,
              trigger: 'change,blur',
              message: '实测值不能为空'
            }
          ],
          c50: [
            {
              required: !this.forbidden.c7_6,
              trigger: 'change,blur',
              message: '标称值不能为空'
            },
            {
              validator: !this.forbidden.c7_6 ? oneDecimals : check,
              trigger: 'change,blur'
            }
          ],
          c51: [
            {
              required: !this.forbidden.c7_6,
              trigger: 'change,blur',
              message: '实测值不能为空'
            },
            {
              validator: !this.forbidden.c7_6 ? atLeastTwoDecimals : check,
              trigger: 'change,blur'
            },
            {
              validator: checkc51,
              trigger: 'change,blur'
            }
          ],
          c53: [
            {
              required: !this.forbidden.c7_6,
              trigger: 'change,blur',
              message: '标称值不能为空'
            },
            {
              validator: !this.forbidden.c7_6 ? oneDecimals : check,
              trigger: 'change,blur'
            }
          ],
          c54: [
            {
              required: !this.forbidden.c7_6,
              trigger: 'change,blur',
              message: '实测值不能为空'
            },
            {
              validator: !this.forbidden.c7_6 ? atLeastTwoDecimals : check,
              trigger: 'change,blur'
            },
            {
              validator: checkc54,
              trigger: 'change,blur'
            }
          ],
          c56: [
            {
              required: !this.forbidden.c7_6,
              trigger: 'change,blur',
              message: '标称值不能为空'
            },
            {
              validator: checkc56,
              trigger: 'change,blur'
            }
          ],
          c57: [
            {
              required: !this.forbidden.c7_6,
              trigger: 'change,blur',
              message: '实测值不能为空'
            },
            {
              validator: !this.forbidden.c7_6 ? oneDecimals : check,
              trigger: 'change,blur'
            }
          ],
          c59: [
            {
              required: !this.forbidden.c7_6,
              trigger: 'change,blur',
              message: '标称值不能为空'
            },
            {
              validator: !this.forbidden.c7_6 ? oneDecimals : check,
              trigger: 'change,blur'
            }
          ],
          c60: [
            {
              required: !this.forbidden.c7_6,
              trigger: 'change,blur',
              message: '实测值不能为空'
            },
            {
              validator: !this.forbidden.c7_6 ? atLeastTwoDecimals : check,
              trigger: 'change,blur'
            }
          ],
          c62: [
            {
              required: !this.forbidden.c7_7,
              trigger: 'change,blur',
              message: '标称值不能为空'
            },
            {
              validator: !this.forbidden.c7_7 ? oneDecimals : check,
              trigger: 'change,blur'
            }
          ],
          c63: [
            {
              required: !this.forbidden.c7_7,
              trigger: 'change,blur',
              message: '实测值不能为空'
            }
          ],
          c65: [
            {
              required: !this.forbidden.c7_7,
              trigger: 'change,blur',
              message: '标称值不能为空'
            },
            {
              validator: !this.forbidden.c7_7 ? oneDecimals : check,
              trigger: 'change,blur'
            }
          ],
          c66: [
            {
              required: !this.forbidden.c7_7,
              trigger: 'change,blur',
              message: '实测值不能为空'
            },
            {
              validator: !this.forbidden.c7_7 ? atLeastTwoDecimals : check,
              trigger: 'change,blur'
            },
            {
              validator: checkc66,
              trigger: 'change,blur'
            }
          ],
          c68: [
            {
              required: !this.forbidden.c7_7,
              trigger: 'change,blur',
              message: '标称值不能为空'
            },
            {
              validator: !this.forbidden.c7_7 ? oneDecimals : check,
              trigger: 'change,blur'
            }
          ],
          c69: [
            {
              required: !this.forbidden.c7_7,
              trigger: 'change,blur',
              message: '实测值不能为空'
            },
            {
              validator: !this.forbidden.c7_7 ? atLeastTwoDecimals : check,
              trigger: 'change,blur'
            },
            {
              validator: checkc69,
              trigger: 'change,blur'
            }
          ],
          c71: [
            {
              required: !this.forbidden.c7_7,
              trigger: 'change,blur',
              message: '标称值不能为空'
            },
            {
              validator: checkc71,
              trigger: 'change,blur'
            }
          ],
          c72: [
            {
              required: !this.forbidden.c7_7,
              trigger: 'change,blur',
              message: '实测值不能为空'
            },
            {
              validator: !this.forbidden.c7_7 ? oneDecimals : check,
              trigger: 'change,blur'
            }
          ],
          c74: [
            {
              required: !this.forbidden.c7_7,
              trigger: 'change,blur',
              message: '标称值不能为空'
            },
            {
              validator: !this.forbidden.c7_7 ? oneDecimals : check,
              trigger: 'change,blur'
            }
          ],
          c75: [
            {
              required: !this.forbidden.c7_7,
              trigger: 'change,blur',
              message: '实测值不能为空'
            },
            {
              validator: !this.forbidden.c7_7 ? atLeastTwoDecimals : check,
              trigger: 'change,blur'
            }
          ],
          c77: [
            {
              required: true,
              message: '备案标识开始使用日期不能为空'
            }
          ],
          c112: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c114: [
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
              message: '设备移动性不能为空'
            }
          ],
          c80: [
            {
              required: true,
              message: '输出速度不能为空'
            }
          ],
          c81: [
            {
              required: this.formRecord.c80.join('').indexOf('黑白速度') > -1,
              trigger: 'change,blur',
              message: '黑白速度不能为空'
            }
          ],
          c82: [
            {
              required: this.formRecord.c80.join('').indexOf('彩色速度') > -1,
              trigger: 'change,blur',
              message: '彩色速度不能为空'
            }
          ],
          c83: [
            {
              required: true,
              trigger: 'change,blur',
              message: '最大幅面不能为空'
            }
          ],
          c84: [
            {
              required: true,
              message: '基础功能不能为空'
            }
          ],
          c85: [
            {
              required: this.formRecord.c84.join('').indexOf('其它') > -1,
              trigger: 'change,blur',
              message: '基础功能其它不能为空'
            }
          ],
          c86: [
            {
              required: true,
              message: '扩展功能不能为空'
            }
          ],
          c87: [
            {
              required: this.formRecord.c86.join('').indexOf('其它') > -1,
              trigger: 'change,blur',
              message: '扩展功能其它不能为空'
            }
          ],
          c88: [
            {
              required: true,
              message: '图像输出方式不能为空'
            }
          ],
          c89: [
            {
              required: true,
              trigger: 'change,blur',
              message: '附加功能功率因子之和不能为空'
            }
          ],
          c90: [
            {
              required: true,
              trigger: 'change,blur',
              message: '电源直流输出功率不能为空'
            }
          ],
          c91: [
            {
              required: true,
              trigger: 'change,blur',
              message: '测试接口不能为空'
            }
          ],
          c92: [
            {
              required: true,
              trigger: 'change,blur',
              message: '额定电压不能为空'
            }
          ],
          c93: [
            {
              required: true,
              trigger: 'change,blur',
              message: '额定电流不能为空'
            }
          ],
          c94: [
            {
              required: true,
              trigger: 'change,blur',
              message: '额定功率不能为空'
            }
          ],
          c95: [
            {
              required: true,
              trigger: 'change,blur',
              message: '长不能为空'
            }
          ],
          c96: [
            {
              required: true,
              trigger: 'change,blur',
              message: '宽不能为空'
            }
          ],
          c97: [
            {
              required: true,
              trigger: 'change,blur',
              message: '高不能为空'
            }
          ],
          c98: [
            {
              required: true,
              trigger: 'change,blur',
              message: '附加因子表1不能为空'
            }
          ],
          c99: [
            {
              required: true,
              trigger: 'change,blur',
              message: '附加因子表2不能为空'
            }
          ],
          c100: [
            {
              required: true,
              trigger: 'change,blur',
              message: '附加因子表3不能为空'
            }
          ],
          c101: [
            {
              required: true,
              trigger: 'change,blur',
              message: '附加因子表4不能为空'
            }
          ],
          c102: [
            {
              required: true,
              trigger: 'change,blur',
              message: '附加因子表5不能为空'
            }
          ],
          c103: [
            {
              required: true,
              trigger: 'change,blur',
              message: '附加因子表6不能为空'
            }
          ],
          c104: [
            {
              required: true,
              trigger: 'change,blur',
              message: '附加因子表7不能为空'
            }
          ],
          c105: [
            {
              required: true,
              trigger: 'change,blur',
              message: '附加因子表8不能为空'
            }
          ],
          c106: [
            {
              required: true,
              trigger: 'change,blur',
              message: '附加因子表9不能为空'
            }
          ],
          c107: [
            {
              required: true,
              trigger: 'change,blur',
              message: '附加因子表10不能为空'
            }
          ],
          c108: [
            {
              required: true,
              trigger: 'change,blur',
              message: '附加因子表11不能为空'
            }
          ],
          c109: [
            {
              required: true,
              trigger: 'change,blur',
              message: '附加因子表12不能为空'
            }
          ],
          c110: [
            {
              required: true,
              trigger: 'change,blur',
              message: '附加因子表13不能为空'
            }
          ],
          c116: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c117: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c118: [
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
          c124: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c125: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c126: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c127: [
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
          ],
          c134: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c135: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c140: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c141: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c142: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c143: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c148: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c149: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c150: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c151: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c156: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c157: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c158: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c159: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c164: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c165: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c166: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c167: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c168: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c169: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c170: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c171: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c180: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c181: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c182: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c183: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c188: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c189: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c190: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c191: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c196: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c197: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c198: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c199: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c205: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c206: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c207: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c208: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c213: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c214: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c215: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c216: [
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

