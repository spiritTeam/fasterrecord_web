<template>
  <div class="wrapper">
    <Form ref="formRecord" :model="formRecord" label-position="right" :rules="ruleRecord">
      <h1>电饭锅-能源效率标识备案表</h1>
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
            <Input type="text" v-model="formRecord.c1" placeholder="生产者名称" disabled />
          </FormItem>
          <FormItem prop="c4" label="制造单位" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c4" :disabled='disabledoff' placeholder="制造单位"/>
          </FormItem>
          <FormItem prop="c28" label="备案方" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c28" :disabled='disabledoff' placeholder="备案方"/>
          </FormItem>
          <FormItem prop="c3" label="产品规格型号" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c3" :disabled='!disabledoff' placeholder="产品规格型号"/>
          </FormItem>
          <FormItem prop="c2" label="商标" style="width:100%" :label-width="180">
            <Input type="text" v-model="formRecord.c2" :disabled='pageType=="view"' placeholder="商标"/>
          </FormItem>
          <FormItem prop="c200" label="依据国家标准" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c200" placeholder="依据国家标准" readonly disabled/>
          </FormItem>
          <FormItem prop="c29" label="能效等级" style="width:100%;" :label-width="180">
            <RadioGroup v-model="formRecord.c29">
              <Radio label="1" :disabled='disabledoff'>1级</Radio>
              <Radio label="2" :disabled='disabledoff'>2级</Radio>
              <Radio label="3" :disabled='disabledoff'>3级</Radio>
              <Radio label="4" :disabled='disabledoff'>4级</Radio>
              <Radio label="5" :disabled='disabledoff'>5级</Radio>
            </RadioGroup>
          </FormItem>
          <table id="table3">
            <tr>
              <td align="center">热效率值（%）</td>
              <td>
                <FormItem prop="c5" label="标称值:" style="width:100%;" :label-width="70">
                  <Input type="text" v-model="formRecord.c5" :disabled='disabledoff' placeholder="整数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c30" label="实测值:" style="width:100%;" :label-width="70">
                  <Input type="text" v-model="formRecord.c30" :disabled='disabledoff' placeholder="至少一位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c6" label="备注:" style="width:100%;" :label-width="70">
                  <Input type="text" v-model="formRecord.c6" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center">加热方式</td>
              <td colspan="3">
                <FormItem prop="c15">
                  <RadioGroup v-model="formRecord.c15">
                    <Radio label="电热元件式" :disabled='disabledoff'>电热元件式</Radio>
                    <Radio label="电磁感应式" :disabled='disabledoff'>电磁感应式</Radio>
                    <Radio label="其它" :disabled='disabledoff'>其它</Radio>
                  </RadioGroup>
                </FormItem>
                <FormItem prop="c16">
                  <Input type="text" v-model="formRecord.c16" style="width:200px;" :disabled='disabledoff || forbidden.c16'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center">功能</td>
              <td colspan="3">
                <i class="red">*</i>
                <FormItem prop="c23">
                  <CheckboxGroup v-model="formRecord.c23">
                    <Checkbox label="待机功能" :disabled='disabledoff'>待机功能</Checkbox>
                    <Checkbox label="保温功能" :disabled='disabledoff'>保温功能</Checkbox>
                    <Checkbox label="其它" :disabled='disabledoff'>其它</Checkbox>
                  </CheckboxGroup>
                </FormItem>
                <FormItem prop="c24">
                  <Input type="text" v-model="formRecord.c24" style="width:200px;" :disabled='disabledoff || forbidden.c24'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center">通讯协议功能</td>
              <td colspan="3">
                <i class="red">*</i>
                <FormItem prop="c90">
                  <CheckboxGroup v-model="formRecord.c90">
                    <Checkbox label="WIFI" :disabled='disabledoff || forbidden.c90_a'>WIFI</Checkbox>
                    <Checkbox label="蓝牙" :disabled='disabledoff || forbidden.c90_b'>蓝牙</Checkbox>
                    <Checkbox label="其它" :disabled='disabledoff || forbidden.c90_c'>其它</Checkbox>
                    <FormItem prop="c91">
                      <Input type="text" v-model="formRecord.c91" style="width:200px;" :disabled='disabledoff || forbidden.c91'/>
                    </FormItem>
                    <Checkbox label="无" :disabled='disabledoff'>无</Checkbox>
                  </CheckboxGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center">待机功率（W）</td>
              <td>
                <FormItem prop="c7" label="标称值:" style="width:100%;" :label-width="70">
                  <Input type="text" v-model="formRecord.c7" :disabled='disabledoff' placeholder="一位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c32" label="实测值:" style="width:100%;" :label-width="70">
                  <Input type="text" v-model="formRecord.c32" :disabled='disabledoff' placeholder="至少两位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c8" label="备注:" style="width:100%;" :label-width="70">
                  <Input type="text" v-model="formRecord.c8" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center">保温能耗（W·h）</td>
              <td>
                <FormItem prop="c9" label="标称值:" style="width:100%;" :label-width="70">
                  <Input type="text" v-model="formRecord.c9" :disabled='disabledoff' placeholder="整数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c33" label="实测值:" style="width:100%;" :label-width="70">
                  <Input type="text" v-model="formRecord.c33" :disabled='disabledoff' placeholder="至少一位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c10" label="备注:" style="width:100%;" :label-width="70">
                  <Input type="text" v-model="formRecord.c10" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center">内锅材质（金属或非金属）</td>
              <td colspan="3">
                <i class="red">*</i>
                <FormItem prop="c22">
                  <RadioGroup v-model="formRecord.c22">
                    <Radio label="金属" :disabled='disabledoff'>金属</Radio>
                    <Radio label="非金属" :disabled='disabledoff'>非金属</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
          </table>
        </Card>
      </div>
      <div class="part part4">
        <Card :bordered="false">
          <h2>四、初始使用日期</h2>
          <FormItem prop="c13" label="备案标识开始使用日期" style="width:100%;">
            <DatePicker type="date" :options="dataInit" style="width: 200px" v-model="formRecord.c13"></DatePicker>
          </FormItem>
        </Card>
      </div>
      <div class="part part5">
        <Card :bordered="false">
          <h2>五、其它信息</h2>
          <h3>样品描述</h3>
          <table id="table3">
            <tr>
              <td align="right"><span style="color:red">*</span>电源类型</td>
              <td>
                <FormItem prop="c14" style="width:100%;" :label-width="10">
                  <RadioGroup v-model="formRecord.c14">
                    <Radio label="交流" :disabled='disabledoff'>交流</Radio>
                    <Radio label="直流" :disabled='disabledoff'>直流</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td align="right"><span style="color:red">*</span>附加保温元件</td>
              <td>
                <FormItem prop="c17" style="width:100%;" :label-width="10">
                  <RadioGroup v-model="formRecord.c17">
                    <Radio label="有" :disabled='disabledoff'>有</Radio>
                    <Radio label="无" :disabled='disabledoff'>无</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span style="color:red">*</span>温控器</td>
              <td>
                <FormItem prop="c18" style="width:100%;" :label-width="10">
                  <RadioGroup v-model="formRecord.c18">
                    <Radio label="有" :disabled='disabledoff'>有</Radio>
                    <Radio label="无" :disabled='disabledoff'>无</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td align="right"><span style="color:red">*</span>热断路器</td>
              <td>
                <FormItem prop="c19" style="width:100%;" :label-width="10">
                  <RadioGroup v-model="formRecord.c19">
                    <Radio label="有" :disabled='disabledoff'>有</Radio>
                    <Radio label="无" :disabled='disabledoff'>无</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span style="color:red">*</span>程序控制</td>
              <td>
                <FormItem prop="c20" style="width:100%;" :label-width="10">
                  <RadioGroup v-model="formRecord.c20">
                    <Radio label="有" :disabled='disabledoff'>有</Radio>
                    <Radio label="无" :disabled='disabledoff'>无</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td align="right"><span style="color:red">*</span>控制方式</td>
              <td>
                <FormItem prop="c21" style="width:100%;" :label-width="10">
                  <RadioGroup v-model="formRecord.c21">
                    <Radio label="机械式" :disabled='disabledoff'>机械式</Radio>
                    <Radio label="电子式" :disabled='disabledoff'>电子式</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span style="color:red">*</span>额定功率（W）</td>
              <td>
                <FormItem prop="c25" :label-width="10">
                    <Input type="text" v-model="formRecord.c25" style="width:200px;" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td align="right"><span style="color:red">*</span>额定容积（L）</td>
              <td>
                <FormItem prop="c26" :label-width="10">
                    <Input type="text" v-model="formRecord.c26" style="width:200px;" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span style="color:red">*</span>额定电压（V）</td>
              <td>
                <FormItem prop="c34" :label-width="10">
                    <Input type="text" v-model="formRecord.c34" style="width:200px;" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td align="right"><span style="color:red">*</span>额定频率（Hz）</td>
              <td>
                <FormItem prop="c35" :label-width="10">
                    <Input type="text" v-model="formRecord.c35" style="width:200px;" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span style="color:red">*</span>外形尺寸（长×宽×高）<br/>（mm×mm×mm）</td>
              <td colspan="3">
                <FormItem prop="c27" style="width:100px;" :label-width="10">
                  <Input type="text" v-model="formRecord.c27" :disabled='disabledoff'/>
                </FormItem>
                <FormItem :label-width="10"><b>×</b></FormItem>
                <FormItem prop="c37" style="width:100px;" :label-width="10">
                  <Input type="text" v-model="formRecord.c37" :disabled='disabledoff'/>
                </FormItem>
                <FormItem :label-width="10"><b>×</b></FormItem>
                <FormItem prop="c38" style="width:100px;" :label-width="10">
                  <Input type="text" v-model="formRecord.c38" :disabled='disabledoff'/>
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
              <th width="110">名称</th>
              <th colspan="2">牌号及规格/型号/物料代码</th>
              <th colspan="2">技术参数</th>
              <th>生产者（全称）</th>
            </tr>
            <tr>
              <td align="center" rowspan="2">1</td>
              <td align="center" rowspan="2">发热盘</td>
              <td colspan="2" rowspan="2">
                <FormItem prop="c39" style="width:100%;">
                  <Input type="text" v-model="formRecord.c39" :disabled='disabledoff' />
                </FormItem>
              </td>
              <td align="center">直径<br>（cm）</td>
              <td>
                <FormItem prop="c40" style="width:100%;">
                  <Input type="text" v-model="formRecord.c40" :disabled='disabledoff' />
                </FormItem>
              </td>
              <td rowspan="2">
                <FormItem prop="c41" style="width:100%;">
                  <Input type="text" v-model="formRecord.c41" :disabled='disabledoff' />
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center">材料</td>
              <td>
                <FormItem prop="c42" style="width:100%;">
                  <Input type="text" v-model="formRecord.c42" :disabled='disabledoff' />
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center" rowspan="2">2</td>
              <td align="center" rowspan="2">发热盘</td>
              <td colspan="2" rowspan="2">
                <FormItem prop="c43" style="width:100%;">
                  <Input type="text" v-model="formRecord.c43" :disabled='disabledoff' />
                </FormItem>
              </td>
              <td align="center">直径<br>（cm）</td>
              <td>
                <FormItem prop="c44" style="width:100%;">
                  <Input type="text" v-model="formRecord.c44" :disabled='disabledoff' />
                </FormItem>
              </td>
              <td rowspan="2">
                <FormItem prop="c45" style="width:100%;">
                  <Input type="text" v-model="formRecord.c45" :disabled='disabledoff' />
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center">材料</td>
              <td>
                <FormItem prop="c46" style="width:100%;">
                  <Input type="text" v-model="formRecord.c46" :disabled='disabledoff' />
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center" rowspan="2">3</td>
              <td align="center" rowspan="2">发热盘</td>
              <td colspan="2" rowspan="2">
                <FormItem prop="c47" style="width:100%;">
                  <Input type="text" v-model="formRecord.c47" :disabled='disabledoff' />
                </FormItem>
              </td>
              <td align="center">直径<br>（cm）</td>
              <td>
                <FormItem prop="c48" style="width:100%;">
                  <Input type="text" v-model="formRecord.c48" :disabled='disabledoff' />
                </FormItem>
              </td>
              <td rowspan="2">
                <FormItem prop="c49" style="width:100%;">
                  <Input type="text" v-model="formRecord.c49" :disabled='disabledoff' />
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center">材料</td>
              <td>
                <FormItem prop="c50" style="width:100%;">
                  <Input type="text" v-model="formRecord.c50" :disabled='disabledoff' />
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center" rowspan="2">4</td>
              <td align="center" rowspan="2">线圈盘</td>
              <td colspan="2" rowspan="2">
                <FormItem prop="c92" style="width:100%;">
                  <Input type="text" v-model="formRecord.c92" :disabled='disabledoff' />
                </FormItem>
              </td>
              <td align="center">线圈盘线径<br>（mm）</td>
              <td>
                <FormItem prop="c93" style="width:100%;">
                  <Input type="text" v-model="formRecord.c93" :disabled='disabledoff' />
                </FormItem>
              </td>
              <td rowspan="2">
                <FormItem prop="c94" style="width:100%;">
                  <Input type="text" v-model="formRecord.c94" :disabled='disabledoff' />
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center">线圈盘电感量<br>(µH)</td>
              <td>
                <FormItem prop="c95" style="width:100%;">
                  <Input type="text" v-model="formRecord.c95" :disabled='disabledoff' />
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center" rowspan="2">5</td>
              <td align="center" rowspan="2">线圈盘</td>
              <td colspan="2" rowspan="2">
                <FormItem prop="c96" style="width:100%;">
                  <Input type="text" v-model="formRecord.c96" :disabled='disabledoff' />
                </FormItem>
              </td>
              <td align="center">线圈盘线径<br>（mm）</td>
              <td>
                <FormItem prop="c97" style="width:100%;">
                  <Input type="text" v-model="formRecord.c97" :disabled='disabledoff' />
                </FormItem>
              </td>
              <td rowspan="2">
                <FormItem prop="c98" style="width:100%;">
                  <Input type="text" v-model="formRecord.c98" :disabled='disabledoff' />
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center">线圈盘电感量<br>(µH)</td>
              <td>
                <FormItem prop="c99" style="width:100%;">
                  <Input type="text" v-model="formRecord.c99" :disabled='disabledoff' />
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center" rowspan="2">6</td>
              <td align="center" rowspan="2">线圈盘</td>
              <td colspan="2" rowspan="2">
                <FormItem prop="c100" style="width:100%;">
                  <Input type="text" v-model="formRecord.c100" :disabled='disabledoff' />
                </FormItem>
              </td>
              <td align="center">线圈盘线径<br>（mm）</td>
              <td>
                <FormItem prop="c101" style="width:100%;">
                  <Input type="text" v-model="formRecord.c101" :disabled='disabledoff' />
                </FormItem>
              </td>
              <td rowspan="2">
                <FormItem prop="c102" style="width:100%;">
                  <Input type="text" v-model="formRecord.c102" :disabled='disabledoff' />
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center">线圈盘电感量<br>(µH)</td>
              <td>
                <FormItem prop="c103" style="width:100%;">
                  <Input type="text" v-model="formRecord.c103" :disabled='disabledoff' />
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center">7</td>
              <td align="center">电路板</td>
              <td colspan="4">
                <FormItem prop="c51" style="width:100%;">
                  <Input type="text" v-model="formRecord.c51" :disabled='disabledoff' />
                </FormItem>
              </td>
              <td>
                <FormItem prop="c52" style="width:100%;">
                  <Input type="text" v-model="formRecord.c52" :disabled='disabledoff' />
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center">8</td>
              <td align="center">电路板</td>
              <td colspan="4">
                <FormItem prop="c53" style="width:100%;">
                  <Input type="text" v-model="formRecord.c53" :disabled='disabledoff' />
                </FormItem>
              </td>
              <td>
                <FormItem prop="c54" style="width:100%;">
                  <Input type="text" v-model="formRecord.c54" :disabled='disabledoff' />
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center">9</td>
              <td align="center">电路板</td>
              <td colspan="4">
                <FormItem prop="c55" style="width:100%;">
                  <Input type="text" v-model="formRecord.c55" :disabled='disabledoff' />
                </FormItem>
              </td>
              <td>
                <FormItem prop="c56" style="width:100%;">
                  <Input type="text" v-model="formRecord.c56" :disabled='disabledoff' />
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center">10</td>
              <td align="center">温控器</td>
              <td colspan="4">
                <FormItem prop="c57" style="width:100%;">
                  <Input type="text" v-model="formRecord.c57" :disabled='disabledoff' />
                </FormItem>
              </td>
              <td>
                <FormItem prop="c58" style="width:100%;">
                  <Input type="text" v-model="formRecord.c58" :disabled='disabledoff' />
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center">11</td>
              <td align="center">温控器</td>
              <td colspan="4">
                <FormItem prop="c59" style="width:100%;">
                  <Input type="text" v-model="formRecord.c59" :disabled='disabledoff' />
                </FormItem>
              </td>
              <td>
                <FormItem prop="c60" style="width:100%;">
                  <Input type="text" v-model="formRecord.c60" :disabled='disabledoff' />
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center">12</td>
              <td align="center">温控器</td>
              <td colspan="4">
                <FormItem prop="c61" style="width:100%;">
                  <Input type="text" v-model="formRecord.c61" :disabled='disabledoff' />
                </FormItem>
              </td>
              <td>
                <FormItem prop="c62" style="width:100%;">
                  <Input type="text" v-model="formRecord.c62" :disabled='disabledoff' />
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center" rowspan="2">13</td>
              <td align="center" rowspan="2">内锅</td>
              <td align="center" rowspan="2">材料</td>
              <td rowspan="2">
                <FormItem prop="c63" style="width:100%;">
                  <Input type="text" v-model="formRecord.c63" :disabled='disabledoff' />
                </FormItem>
              </td>
              <td align="center">直径<br>（cm）</td>
              <td>
                <FormItem prop="c64" style="width:100%;">
                  <Input type="text" v-model="formRecord.c64" :disabled='disabledoff' />
                </FormItem>
              </td>
              <td rowspan="2">
                <FormItem prop="c65" style="width:100%;">
                  <Input type="text" v-model="formRecord.c65" :disabled='disabledoff' />
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center">厚度<br>（cm）</td>
              <td>
                <FormItem prop="c66" style="width:100%;">
                  <Input type="text" v-model="formRecord.c66" :disabled='disabledoff' />
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center" rowspan="2">14</td>
              <td align="center" rowspan="2">内锅</td>
              <td align="center" rowspan="2">材料</td>
              <td rowspan="2">
                <FormItem prop="c67" style="width:100%;">
                  <Input type="text" v-model="formRecord.c67" :disabled='disabledoff' />
                </FormItem>
              </td>
              <td align="center">直径<br>（cm）</td>
              <td>
                <FormItem prop="c68" style="width:100%;">
                  <Input type="text" v-model="formRecord.c68" :disabled='disabledoff' />
                </FormItem>
              </td>
              <td rowspan="2">
                <FormItem prop="c69" style="width:100%;">
                  <Input type="text" v-model="formRecord.c69" :disabled='disabledoff' />
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center">厚度<br>（cm）</td>
              <td>
                <FormItem prop="c70" style="width:100%;">
                  <Input type="text" v-model="formRecord.c70" :disabled='disabledoff' />
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center" rowspan="2">15</td>
              <td align="center" rowspan="2">内锅</td>
              <td align="center" rowspan="2">材料</td>
              <td rowspan="2">
                <FormItem prop="c71" style="width:100%;">
                  <Input type="text" v-model="formRecord.c71" :disabled='disabledoff' />
                </FormItem>
              </td>
              <td align="center">直径<br>（cm）</td>
              <td>
                <FormItem prop="c72" style="width:100%;">
                  <Input type="text" v-model="formRecord.c72" :disabled='disabledoff' />
                </FormItem>
              </td>
              <td rowspan="2">
                <FormItem prop="c73" style="width:100%;">
                  <Input type="text" v-model="formRecord.c73" :disabled='disabledoff' />
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center">厚度<br>（cm）</td>
              <td>
                <FormItem prop="c74" style="width:100%;">
                  <Input type="text" v-model="formRecord.c74" :disabled='disabledoff' />
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center">16</td>
              <td align="center">保温层</td>
              <td align="center">材料</td>
              <td>
                <FormItem prop="c75" style="width:100%;">
                  <Input type="text" v-model="formRecord.c75" :disabled='disabledoff' />
                </FormItem>
              </td>
              <td align="center">厚度<br>（cm）</td>
              <td>
                <FormItem prop="c76" style="width:100%;">
                  <Input type="text" v-model="formRecord.c76" :disabled='disabledoff' />
                </FormItem>
              </td>
              <td>
                <FormItem prop="c77" style="width:100%;">
                  <Input type="text" v-model="formRecord.c77" :disabled='disabledoff' />
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center">17</td>
              <td align="center">保温层</td>
              <td align="center">材料</td>
              <td>
                <FormItem prop="c78" style="width:100%;">
                  <Input type="text" v-model="formRecord.c78" :disabled='disabledoff' />
                </FormItem>
              </td>
              <td align="center">厚度<br>（cm）</td>
              <td>
                <FormItem prop="c79" style="width:100%;">
                  <Input type="text" v-model="formRecord.c79" :disabled='disabledoff' />
                </FormItem>
              </td>
              <td>
                <FormItem prop="c80" style="width:100%;">
                  <Input type="text" v-model="formRecord.c80" :disabled='disabledoff' />
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center">18</td>
              <td align="center">保温层</td>
              <td align="center">材料</td>
              <td>
                <FormItem prop="c81" style="width:100%;">
                  <Input type="text" v-model="formRecord.c81" :disabled='disabledoff' />
                </FormItem>
              </td>
              <td align="center">厚度<br>（cm）</td>
              <td>
                <FormItem prop="c82" style="width:100%;">
                  <Input type="text" v-model="formRecord.c82" :disabled='disabledoff' />
                </FormItem>
              </td>
              <td>
                <FormItem prop="c83" style="width:100%;">
                  <Input type="text" v-model="formRecord.c83" :disabled='disabledoff' />
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center">19</td>
              <td align="center">附加保温元件</td>
              <td align="center">材料</td>
              <td>
                <FormItem prop="c84" style="width:100%;">
                  <Input type="text" v-model="formRecord.c84" :disabled='disabledoff' />
                </FormItem>
              </td>
              <td colspan="3">
                <FormItem prop="c85" style="width:100%;">
                  <Input type="text" v-model="formRecord.c85" :disabled='disabledoff' />
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center">20</td>
              <td align="center">附加保温元件</td>
              <td align="center">材料</td>
              <td>
                <FormItem prop="c86" style="width:100%;">
                  <Input type="text" v-model="formRecord.c86" :disabled='disabledoff' />
                </FormItem>
              </td>
              <td colspan="3">
                <FormItem prop="c87" style="width:100%;">
                  <Input type="text" v-model="formRecord.c87" :disabled='disabledoff' />
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center">21</td>
              <td align="center">附加保温元件</td>
              <td align="center">材料</td>
              <td>
                <FormItem prop="c88" style="width:100%;">
                  <Input type="text" v-model="formRecord.c88" :disabled='disabledoff' />
                </FormItem>
              </td>
              <td colspan="3">
                <FormItem prop="c89" style="width:100%;">
                  <Input type="text" v-model="formRecord.c89" :disabled='disabledoff' />
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center" colspan="7">备注：如上述零部件属多个生产者，均应按上述要求逐一填写。</td>
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
                  <Input type="text" v-model="formRecord.c202" :disabled='disabledoff'/>
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
              <td>OEM声明<p class="red" v-if="pageType!='view'">请企业根据自身情况自行上传该附件</p></td>
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
              <td>关系证明</td>
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
              <td>进口商企业信息表
                <p class="red" v-if="pageType!='view'">境外企业请自行上传该附件</p>
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
              <td>进口商营业执照或登记注册证明复印件
                <p class="red" v-if="pageType!='view'">境外企业请自行上传该附件</p>
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
              <td>进口商与境外生产者订立的相关合同副本
                <p class="red" v-if="pageType!='view'">境外企业请自行上传该附件</p>
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
        <!--<Button type="primary" @click="saveRecord" v-if='!pageType' :disabled="saveDisabled">保存到草稿</Button>-->
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
          公司生产的 <span class="f-brand">{{formRecord.c2}}</span>
         品牌的 <span class="f-model">{{pageType==='extend'?mainModel:formRecord.c3}}</span>
         型号的 <span class="f-product">电饭锅 2017版</span>产品{{pageType==="update"?'已通过能效标识备案':''}}。
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
      const timeDate = parseInt(this.$store.state.app.dateinit);
      return {
        // 当前初始使用日期 对应的C值
        thisDateCV: 'c13',
        // 当前能效等级 对应的C值
        thisLevelCV: 'c29',
        thisGZXHCV: "c3",// 当前规格型号 对应的C值
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
          c8: '',
          c9: '',
          c10: '',
          c13: new Date(),
          c14: '',
          c15: '',
          c16: '',
          c17: '',
          c18: '',
          c19: '',
          c20: '',
          c21: '',
          c22: '',
          c23: [],
          c24: '',
          c25: '',
          c26: '',
          c27: '',
          c28: '',
          c29: '',
          c30: '',
          c32: '',
          c33: '',
          c34: '',
          c35: '',
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
          c90: [],
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
          c200: '',
          c202: '',
          ec_model_no: 51,
          attach_list: ''
        },
        forbidden: {
          c16: true,
          c24: true,
          c91: true,
          c90_a: false,
          c90_b: false,
          c90_c: false
        },
        extendRule: {
          c3: [
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

        //加热方式-其它
        if (this.formRecord.c15 == '其它') {
          this.forbidden.c16 = false
        } else {
          this.formRecord.c16 = ''
          this.forbidden.c16 = true
        }

        //功能-其它
        if (this.formRecord.c23.join('').indexOf('其它') > -1) {
          this.forbidden.c24 = false
        } else {
          this.formRecord.c24 = ''
          this.forbidden.c24 = true
        }

        //通讯协议功能-其它
        if (this.formRecord.c90.join('').indexOf('其它') > -1) {
          this.forbidden.c91 = false
        } else {
          this.formRecord.c91 = ''
          this.forbidden.c91 = true
        }
        if (this.formRecord.c90.join('').indexOf('无') > -1) {
          this.formRecord.c90 = ['无']
          this.forbidden.c90_a = true
          this.forbidden.c90_b = true
          this.forbidden.c90_c = true
          this.forbidden.c91 = true
          this.formRecord.c91 = ''
        } else {
          this.forbidden.c90_a = false
          this.forbidden.c90_b = false
          this.forbidden.c90_c = false
        }


        const checkc30 = (rule, value, callback) => {
          if (this.formRecord.c30 != "") {
            if (parseFloat(this.formRecord.c30) < parseFloat(this.formRecord.c5)) {
              callback("热效率值（实测值）应大于等于热效率值（标称值）！");
            } else {
              callback()
            }
          } else {
            callback()
          }
        }

        const checkc32 = (rule, value, callback) => {
          if (this.formRecord.c32 != "") {
            if (parseFloat(this.formRecord.c32) > parseFloat(this.formRecord.c7)) {
              callback("待机功率（标称值）应不小于待机功率（实测值）！");
            } else {
              callback()
            }
          } else {
            callback()
          }
        }

        const checkc33 = (rule, value, callback) => {
          if (this.formRecord.c33 != "") {
            if (parseFloat(this.formRecord.c33) > parseFloat(this.formRecord.c9)) {
              callback("保温能耗（标称值）应不小于保温能耗（实测值）！");
            } else {
              callback()
            }
          } else {
            callback()
          }
        }

        //新版电饭锅增加一些备案条件
        //c25 额定功率
        //c9 保温能耗
        //c5 热效率值
        var nxdj = "";
        var c9 = parseInt(this.formRecord.c9);
        var c5 = parseInt(this.formRecord.c5);
        var c25 = parseFloat(this.formRecord.c25);
        if (c25 <= 400) {
          if (c9 != '' && c9) {
            if (c9 <= 19) {
              if (c5 >= 87) {
                nxdj = "1";
              }
              if (c5 >= 81 && c5 < 87) {
                nxdj = "2";
              }
            }
            if (c9 <= 40) {
              if (c5 >= 76 && c5 < 81) {
                nxdj = "3";
              }
              if (c5 >= 72 && c5 < 76) {
                nxdj = "4";
              }
              if (c5 >= 68 && c5 < 72) {
                nxdj = "5";
              }
            }
          } else {
            if (c5 >= 87) {
              nxdj = "1";
            }
            if (c5 >= 81 && c5 < 87) {
              nxdj = "2";
            }
            if (c5 >= 76 && c5 < 81) {
              nxdj = "3";
            }
            if (c5 >= 72 && c5 < 76) {
              nxdj = "4";
            }
            if (c5 >= 68 && c5 < 72) {
              nxdj = "5";
            }
          }
        }
        if (c25 <= 600 && c25 > 400) {
          if (c9 != '' && c9) {
            if (c9 <= 21) {
              if (c5 >= 88) {
                nxdj = "1";
              }
              if (c5 >= 82 && c5 < 88) {
                nxdj = "2";
              }
            }
            if (c9 <= 50) {
              if (c5 >= 77 && c5 < 82) {
                nxdj = "3";
              }
              if (c5 >= 75 && c5 < 77) {
                nxdj = "4";
              }
              if (c5 >= 71 && c5 < 75) {
                nxdj = "5";
              }
            }
          } else {
            if (c5 >= 88) {
              nxdj = "1";
            }
            if (c5 >= 82 && c5 < 88) {
              nxdj = "2";
            }
            if (c5 >= 77 && c5 < 82) {
              nxdj = "3";
            }
            if (c5 >= 75 && c5 < 77) {
              nxdj = "4";
            }
            if (c5 >= 71 && c5 < 75) {
              nxdj = "5";
            }
          }
        }
        if (c25 <= 1000 && c25 > 600) {
          if (c9 != '' && c9) {
            if (c9 <= 33) {
              if (c5 >= 89) {
                nxdj = "1";
              }
              if (c5 >= 83 && c5 < 89) {
                nxdj = "2";
              }
            }
            if (c9 <= 68) {
              if (c5 >= 78 && c5 < 83) {
                nxdj = "3";
              }
              if (c5 >= 76 && c5 < 78) {
                nxdj = "4";
              }
              if (c5 >= 73 && c5 < 76) {
                nxdj = "5";
              }
            }
          } else {
            if (c5 >= 89) {
              nxdj = "1";
            }
            if (c5 >= 83 && c5 < 89) {
              nxdj = "2";
            }
            if (c5 >= 78 && c5 < 83) {
              nxdj = "3";
            }
            if (c5 >= 76 && c5 < 78) {
              nxdj = "4";
            }
            if (c5 >= 73 && c5 < 76) {
              nxdj = "5";
            }
          }
        }
        if (c25 <= 2000 && c25 > 1000) {
          if (c9 != '' && c9) {
            if (c9 <= 35) {
              if (c5 >= 90) {
                nxdj = "1";
              }
              if (c5 >= 86 && c5 < 90) {
                nxdj = "2";
              }
            }
            if (c9 <= 78) {
              if (c5 >= 81 && c5 < 86) {
                nxdj = "3";
              }
              if (c5 >= 78 && c5 < 81) {
                nxdj = "4";
              }
              if (c5 >= 74 && c5 < 78) {
                nxdj = "5";
              }
            }
          } else {
            if (c5 >= 90) {
              nxdj = "1";
            }
            if (c5 >= 86 && c5 < 90) {
              nxdj = "2";
            }
            if (c5 >= 81 && c5 < 86) {
              nxdj = "3";
            }
            if (c5 >= 78 && c5 < 81) {
              nxdj = "4";
            }
            if (c5 >= 74 && c5 < 78) {
              nxdj = "5";
            }
          }
        }

        //绑定额定功率
        const checkc25 = (rule, value, callback) => {
          if (c25 > 2000) {
            callback("额定功率不能大于2000");
          } else {
            callback()
          }
        }

        //绑定加入方式 c15
        var nxdjch = parseFloat(this.formRecord.c29);
        var djgl = parseFloat(this.formRecord.c7);
        var djglCheck = this.formRecord.c15;
        const checkc15 = (rule, value, callback) => {
          if (djglCheck == "电热元件式") {
            if (nxdjch == 1 || nxdjch == 2) {
              if (djgl > 1.0) {
                callback("能效数据不在备案范围");
              } else {
                callback()
              }
            } else if (nxdjch == 3 || nxdjch == 4 || nxdjch == 5) {
              if (djgl > 1.8) {
                callback("能效数据不在备案范围");
              } else {
                callback()
              }
            } else {
              callback()
            }
          } else if (djglCheck == "电磁感应式") {
            if (nxdjch == 1 || nxdjch == 2) {
              if (djgl > 1.8) {
                callback("能效数据不在备案范围");
              } else {
                callback();
              }
            } else if (nxdjch == 3 || nxdjch == 4 || nxdjch == 5) {
              if (djgl > 2.0) {
                callback("能效数据不在备案范围");
              } else {
                callback("能效数据不在备案范围");
              }
            } else {
              callback();
            }
          } else {
            callback();
          }
        }

        //待机功能选择有选择通讯协议，待机功率和保温功耗不能填写。
        var c9 = this.formRecord.c9;
        var c23 = this.formRecord.c23;

        //绑定功能 c23
        const checkc23 = (rule, value, callback) => {
          if (djgl != "" && djgl != undefined) {
            if (c23 == "" || c23 == undefined) {
              callback("能效数据不在备案范围");
            } else {
              callback();
            }
          } else {
            callback();
          }
        }

        //保温能耗 c9
        const checkc9 = (rule, value, callback) => {
          if (c9 != "" && c9 != undefined) {
            if (c23 == "" || c23 == undefined) {
              callback("能效数据不在备案范围");
            } else {
              callback();
            }
          } else {
            callback();
          }
        }

        //绑定待机功率 c7
        const checkc7 = (rule, value, callback) => {
          if (c23 == "待机功能") {
            var txxy = this.formRecord.c90;
            if (txxy != undefined && txxy != "" && txxy != "无") {
              if (djgl != "" && djgl != undefined) {
                callback("同时选择待机功能和通讯协议，待机功率不能填写。");
              } else {
                callback();
              }
            } else {
              callback();
            }
          } else {
            callback();
          }
        }

        //绑定能效等级 c29
        const checkc29 = (rule, value, callback) => {
          if (nxdj == "") {
            callback("能效数据不在备案范围");
          } else {
            if (nxdjch != nxdj) {
              callback("所选能效等级与计算结果不符！");
            } else {
              callback();
            }
          }
        }
        const changeVal = (rule, value, callback) => {
          this.mainModel === value ? callback('扩展备案需要变更型号名称') : callback()
        }
        if (this.pageType === 'view') {
          return {};
        } else if (this.pageType === 'extend') {
          return {
            c3: [
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
            c16: [
              {
                required: this.formRecord.c15 === '其它',
                message: '加热方式选项其它的值不能为空',
                trigger: 'change,blur'
              }
            ],
            c24: [
              {
                required: this.formRecord.c23.join('').indexOf('其它') > -1,
                message: '功能选项其它的值不能为空',
                trigger: 'change,blur'
              }
            ],
            c4: [
              {
                required: true,
                message: '制造单位不能为空',
                trigger: 'change,blur'
              }
            ],
            c28: [
              {
                required: true,
                message: '备案方不能为空',
                trigger: 'change,blur'
              }
            ],
            c3: [
              {
                required: true,
                message: '规格型号不能为空',
                trigger: 'change,blur'
              }
            ],
            c2: [
              {
                required: true,
                message: '商标不能为空',
                trigger: 'change,blur'
              }
            ],
            c29: [
              {
                required: true,
                message: '能效等级不能为空',
                trigger: 'change,blur'
              },
              {
                validator: checkc29,
                trigger: 'change,blur'
              }
            ],
            c5: [
              {
                required: true,
                message: '标称值不能为空',
                trigger: 'change,blur'
              },
              {
                validator: numberCheck,
                trigger: 'change,blur'
              }
            ],
            c30: [
              {
                required: true,
                message: '实测值不能为空',
                trigger: 'change,blur'
              },
              {
                validator: atLeastOneDecimals,
                trigger: 'change,blur'
              },
              {
                validator: checkc30,
                trigger: 'change,blur'
              }
            ],
            c23: [
              {
                required: true,
                message: '功能选项不能为空'
              },
              {
                validator: checkc23,
                trigger: 'blur'
              }
            ],
            c90: [
              {
                required: true,
                message: '通讯协议功能不能为空'
              }
            ],
            c91: [
              {
                required: this.formRecord.c90.join('').indexOf('其它') > -1,
                message: '通讯协议其它值不能为空',
                trigger: 'change,blur'
              }
            ],
            c7: [
              {
                required: true,
                message: '不能为空',
                trigger: 'change,blur'
              },
              {
                validator: oneDecimals,
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
                message: '不能为空',
                trigger: 'change,blur'
              },
              {
                validator: numberCheck,
                trigger: 'change,blur'
              },
              {
                validator: checkc9,
                trigger: 'change,blur'
              }
            ],
            c32: [
              {
                required: true,
                message: '不能为空',
                trigger: 'change,blur'
              },
              {
                validator: atLeastTwoDecimals,
                trigger: 'change,blur'
              },
              {
                validator: checkc32,
                trigger: 'change,blur'
              }
            ],
            c33: [
              {
                required: true,
                message: '不能为空',
                trigger: 'change,blur'
              },
              {
                validator: atLeastOneDecimals,
                trigger: 'change,blur'
              },
              {
                validator: checkc33,
                trigger: 'change,blur'
              }
            ],
            c22: [
              {
                required: true,
                message: '内锅材质不能为空',
                trigger: 'change,blur'
              }
            ],
            c13: [
              {
                required: true,
                message: '初始使用日期不能为空'
              }
            ],
            c14: [
              {
                required: true,
                message: '电源类型不能为空',
                trigger: 'change,blur'
              }
            ],
            c15: [
              {
                required: true,
                message: '加热方式不能为空',
                trigger: 'change,blur'
              },
              {
                validator: checkc15,
                trigger: 'change,blur'
              }
            ],
            c17: [
              {
                required: true,
                message: '附加保温元件不能为空',
                trigger: 'change,blur'
              }
            ],
            c18: [
              {
                required: true,
                message: '温控器不能为空',
                trigger: 'change,blur'
              }
            ],
            c19: [
              {
                required: true,
                message: '热断路器不能为空',
                trigger: 'change,blur'
              }
            ],
            c20: [
              {
                required: true,
                message: '程序控制不能为空',
                trigger: 'change,blur'
              }
            ],
            c21: [
              {
                required: true,
                message: '控制方式不能为空',
                trigger: 'change,blur'
              }
            ],
            c25: [
              {
                required: true,
                message: '额定功率不能为空',
                trigger: 'change,blur'
              },
              {
                validator: checkc25,
                trigger: 'change,blur'
              }
            ],
            c26: [
              {
                required: true,
                message: '额定容积不能为空',
                trigger: 'change,blur'
              }
            ],
            c34: [
              {
                required: true,
                message: '额定电压不能为空',
                trigger: 'change,blur'
              }
            ],
            c35: [
              {
                required: true,
                message: '额定频率不能为空',
                trigger: 'change,blur'
              }
            ],
            c27: [
              {
                required: true,
                message: '长不能为空',
                trigger: 'change,blur'
              }
            ],
            c37: [
              {
                required: true,
                message: '宽不能为空',
                trigger: 'change,blur'
              }
            ],
            c38: [
              {
                required: true,
                message: '高不能为空',
                trigger: 'change,blur'
              }
            ],
            c39: [
              {
                required: true,
                message: '不能为空',
                trigger: 'change,blur'
              }
            ],
            c40: [
              {
                required: true,
                message: '不能为空',
                trigger: 'change,blur'
              }
            ],
            c41: [
              {
                required: true,
                message: '不能为空',
                trigger: 'change,blur'
              }
            ],
            c42: [
              {
                required: true,
                message: '不能为空',
                trigger: 'change,blur'
              }
            ],
            c51: [
              {
                required: true,
                message: '不能为空',
                trigger: 'change,blur'
              }
            ],
            c52: [
              {
                required: true,
                message: '不能为空',
                trigger: 'change,blur'
              }
            ],
            c57: [
              {
                required: true,
                message: '不能为空',
                trigger: 'change,blur'
              }
            ],
            c58: [
              {
                required: true,
                message: '不能为空',
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
            c75: [
              {
                required: true,
                message: '不能为空',
                trigger: 'change,blur'
              }
            ],
            c76: [
              {
                required: true,
                message: '不能为空',
                trigger: 'change,blur'
              }
            ],
            c77: [
              {
                required: true,
                message: '不能为空',
                trigger: 'change,blur'
              }
            ],
            c84: [
              {
                required: true,
                message: '不能为空',
                trigger: 'change,blur'
              }
            ],
            c85: [
              {
                required: true,
                message: '不能为空',
                trigger: 'change,blur'
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
