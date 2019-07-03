<template>
  <div class="wrapper">
    <Form ref="formRecord" :model="formRecord" label-position="right" :rules="ruleRecord">
      <h1>商用燃气灶具能源效率标识备案表</h1>
      <div class="part part1">
        <Card :bordered="false">
          <h2>一、备案方声明</h2>
          <p>本组织保证如下：</p>
          <p>使用的能源效率标识信息与备案信息一致；</p>
          <p>本型号产品变更能源效率标识时，向授权机构更新备案；</p>
          <p>确保该型号产品始终符合能源效率标识使用的相关要求。</p>
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
          <h2>三、能源效率标识标注的信息</h2>
          <FormItem prop="c1" label="生产者名称" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c1" placeholder="生产者名称" disabled />
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
            <Input type="text" v-model="formRecord.c2" :disabled='disabledoff' placeholder="商标"/>
          </FormItem>
          <FormItem prop="c200" label="依据国家标准" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c200" placeholder="依据国家标准" disabled/>
          </FormItem>
          <FormItem prop="c7" label="能效等级" style="width:100%;" :label-width="180">
            <RadioGroup v-model="formRecord.c7">
              <Radio label="1" :disabled='disabledoff'>1级</Radio>
              <Radio label="2" :disabled='disabledoff'>2级</Radio>
              <Radio label="3" :disabled='disabledoff'>3级</Radio>
            </RadioGroup>
          </FormItem>
          <table id="table1">
            <tr>
              <td align="center">热效率(%)</td>
              <td>
                <FormItem prop="c8" label="标注值:" style="width:100%;" :label-width="70">
                  <Input type="text" v-model="formRecord.c8" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c9" label="实测值:" style="width:100%;" :label-width="70">
                  <Input type="text" v-model="formRecord.c9" :disabled='disabledoff' placeholder="一位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c10" label="备注:" style="width:100%;" :label-width="70">
                  <Input type="text" v-model="formRecord.c10" :disabled='disabledoff'/>
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
            <DatePicker type="date" :options="dataInit" style="width: 200px" v-model="formRecord.c14" :disabled='disabledoff'></DatePicker>
          </FormItem>
        </Card>
      </div>
      <div class="part part5">
        <Card :bordered="false">
          <h2>五、其他信息</h2>
          <h3>样品描述</h3>
          <table id="table3">
            <tr>
              <td  width="150" align="right"><span style="color:red">*</span>燃气类别</td>
              <td colspan="3">
                <FormItem prop="c15">
                  <FormItem prop="c16">
                    <RadioGroup v-model="formRecord.c15">
                      <Radio label="人工煤气灶具" :disabled='disabledoff'>人工煤气</Radio>
                      <RadioGroup v-model="formRecord.c16">
                        <Radio label="5R" :disabled='disabledoff || forbidden.c16_a'>5R</Radio>
                        <Radio label="6R" :disabled='disabledoff || forbidden.c16_a'>6R</Radio>
                        <Radio label="7R" :disabled='disabledoff || forbidden.c16_a'>7R</Radio>
                      </RadioGroup>
                      <br><br>
                      <Radio label="天然气灶具" :disabled='disabledoff'>天然气</Radio>
                      <RadioGroup v-model="formRecord.c16">
                        <Radio label="4T" :disabled='disabledoff || forbidden.c16_b'>4T</Radio>
                        <Radio label="6T" :disabled='disabledoff || forbidden.c16_b'>6T</Radio>
                        <Radio label="10T" :disabled='disabledoff || forbidden.c16_b'>10T</Radio>
                        <Radio label="12T" :disabled='disabledoff || forbidden.c16_b'>12T</Radio>
                      </RadioGroup>
                        <br><br>
                      <Radio label="液化石油气灶具" :disabled='disabledoff'>液化石油气</Radio>
                      <RadioGroup v-model="formRecord.c16">
                        <Radio label="19Y" :disabled='disabledoff || forbidden.c16_c'>19Y</Radio>
                        <Radio label="20Y" :disabled='disabledoff || forbidden.c16_c'>20Y</Radio>
                        <Radio label="22Y" :disabled='disabledoff || forbidden.c16_c'>22Y</Radio>
                      </RadioGroup>
                      <br><br>
                    </RadioGroup>
                  </FormItem>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span style="color:red">*</span>电源</td>
              <td colspan="3">
                <FormItem prop="c17">
                  <RadioGroup v-model="formRecord.c17">
                    <Radio label="直流" :disabled='disabledoff'>直流</Radio>
                    <Radio label="交流" :disabled='disabledoff'>交流</Radio>
                  </RadioGroup>
                </FormItem>
                <FormItem prop="c18" style="width:200px;" :label-width="0">
                  <Input type="text" v-model="formRecord.c18" :disabled='disabledoff'/>
                </FormItem>
                <FormItem :label-width="10">V</FormItem>
                <FormItem prop="c19" style="width:200px;" :label-width="0">
                  <Input type="text" v-model="formRecord.c19" :disabled='disabledoff'/>
                </FormItem>
                <FormItem :label-width="10">mA</FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span style="color:red">*</span>稳压器</td>
              <td colspan="3">
                <FormItem prop="c20">
                  <RadioGroup v-model="formRecord.c20">
                    <Radio label="有" :disabled='disabledoff'>有</Radio>
                    <Radio label="无" :disabled='disabledoff'>无</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span style="color:red">*</span>额定功率(kW)</td>
              <td width="350">
                <FormItem prop="c21" style="width:200px;" :label-width="0">
                  <Input type="text" v-model="formRecord.c21" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td align="right" width="350"><span style="color:red">*</span>运行噪声等级</td>
              <td width="350">
                <FormItem prop="c22" style="width:200px;" :label-width="0">
                  <Input type="text" v-model="formRecord.c22" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span style="color:red">*</span>产品类别</td>
              <td>
                <FormItem prop="c23">
                  <RadioGroup v-model="formRecord.c23">
                    <Radio label="中餐燃气炒菜灶" :disabled='disabledoff'>中餐燃气炒菜灶</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c23">
                  <RadioGroup v-model="formRecord.c23">
                    <Radio label="炊用燃气大锅灶" :disabled='disabledoff'>炊用燃气大锅灶</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c23">
                  <RadioGroup v-model="formRecord.c23">
                    <Radio label="燃气蒸箱" :disabled='disabledoff'>燃气蒸箱</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span style="color:red">*</span>空气供给方式</td>
              <td>
                <FormItem prop="c24">
                  <RadioGroup v-model="formRecord.c24">
                    <Radio label="鼓风预混式" :disabled='disabledoff || forbidden.zcrqccz'>鼓风预混式</Radio>
                    <Radio label="鼓风扩散式" :disabled='disabledoff || forbidden.zcrqccz'>鼓风扩散式</Radio>
                    <Radio label="引射大气式" :disabled='disabledoff || forbidden.zcrqccz'>引射大气式</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c25">
                  <RadioGroup v-model="formRecord.c25">
                    <Radio label="强制排气式" :disabled='disabledoff || forbidden.yyrqdgz'>强制排气式</Radio>
                    <Radio label="鼓风预混式" :disabled='disabledoff || forbidden.yyrqdgz'>鼓风预混式</Radio>
                    <Radio label="鼓风扩散式" :disabled='disabledoff || forbidden.yyrqdgz'>鼓风扩散式</Radio>
                    <Radio label="引射大气式" :disabled='disabledoff || forbidden.yyrqdgz'>引射大气式</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c26">
                  <RadioGroup v-model="formRecord.c26">
                    <Radio label="强制排气式" :disabled='disabledoff || forbidden.rqzx'>强制排气式</Radio>
                    <Radio label="鼓风预混式" :disabled='disabledoff || forbidden.rqzx'>鼓风预混式</Radio>
                    <Radio label="鼓风扩散式" :disabled='disabledoff || forbidden.rqzx'>鼓风扩散式</Radio>
                    <Radio label="引射大气式" :disabled='disabledoff || forbidden.rqzx'>引射大气式</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span style="color:red">*</span>灶眼数</td>
              <td>
                <FormItem prop="c27">
                  <RadioGroup v-model="formRecord.c27">
                    <Radio label="单眼灶" :disabled='disabledoff || forbidden.zcrqccz'>单眼灶</Radio>
                    <Radio label="双眼灶" :disabled='disabledoff || forbidden.zcrqccz'>双眼灶</Radio>
                    <Radio label="多眼灶" :disabled='disabledoff || forbidden.zcrqccz'>多眼灶</Radio>
                  </RadioGroup>
                </FormItem>
                <FormItem prop="c28" style="width:80px;" :label-width="0">
                  <Input type="text" v-model="formRecord.c28" :disabled='disabledoff || forbidden.c28 || forbidden.zcrqccz'/>
                </FormItem>
                <FormItem>眼灶</FormItem>
              </td>
              <td>
                <FormItem prop="c29">
                  <RadioGroup v-model="formRecord.c29">
                    <Radio label="单眼灶" :disabled='disabledoff || forbidden.yyrqdgz'>单眼灶</Radio>
                    <Radio label="双眼灶" :disabled='disabledoff || forbidden.yyrqdgz'>双眼灶</Radio>
                    <Radio label="多眼灶" :disabled='disabledoff || forbidden.yyrqdgz'>多眼灶</Radio>
                  </RadioGroup>
                </FormItem>
                <FormItem prop="c30" style="width:80px;" :label-width="0">
                  <Input type="text" v-model="formRecord.c30" :disabled='disabledoff || forbidden.c30 || forbidden.yyrqdgz'/>
                </FormItem>
                <FormItem>眼灶</FormItem>
              </td>
              <td align="center">/</td>
            </tr>
            <tr>
              <td align="right"><span style="color:red">*</span>点火方式/<br>常明火点火方式</td>
              <td>
                <FormItem prop="c31">
                  <CheckboxGroup v-model="formRecord.c31">
                    <Checkbox label="常明火(必选)" :disabled='disabledoff || forbidden.zcrqccz'>常明火(必选)</Checkbox>
                    <Checkbox label="人工点火装置" :disabled='disabledoff || forbidden.zcrqccz'>人工点火装置</Checkbox>
                    <Checkbox label="电点火器" :disabled='disabledoff || forbidden.zcrqccz'>电点火器</Checkbox>
                  </CheckboxGroup>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c32">
                  <CheckboxGroup v-model="formRecord.c32">
                    <Checkbox label="点火燃烧器(必选)" :disabled='disabledoff || forbidden.yyrqdgz'>点火燃烧器(必选)</Checkbox>
                    <Checkbox label="人工点火装置" :disabled='disabledoff || forbidden.yyrqdgz'>人工点火装置</Checkbox>
                    <Checkbox label="电点火器" :disabled='disabledoff || forbidden.yyrqdgz'>电点火器</Checkbox>
                  </CheckboxGroup>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c33">
                  <CheckboxGroup v-model="formRecord.c33">
                    <Checkbox label="常明火" :disabled='disabledoff || forbidden.rqzx'>常明火</Checkbox>
                    <Checkbox label="自动程序控制点火" :disabled='disabledoff || forbidden.rqzx'>自动程序控制点火</Checkbox>
                  </CheckboxGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span style="color:red">*</span>熄火保护装置形式/<br>火焰监控装置形式</td>
              <td>
                <FormItem prop="c34">
                  <CheckboxGroup v-model="formRecord.c34">
                    <Checkbox label="热电偶方式" :disabled='disabledoff || forbidden.zcrqccz'>热电偶方式</Checkbox>
                    <Checkbox label="离子感应式" :disabled='disabledoff || forbidden.zcrqccz'>离子感应式</Checkbox><br>
                    <Checkbox label="其它方式" :disabled='disabledoff || forbidden.zcrqccz'>其它方式</Checkbox>
                  </CheckboxGroup>
                </FormItem>
                <FormItem prop="c35" style="width:120px;margin-top:30px;margin-left:-115px;" :label-width="0">
                    <Input type="text" v-model="formRecord.c35" :disabled='disabledoff || forbidden.c35 || forbidden.zcrqccz'/>
                </FormItem>
                <FormItem style="margin-top:30px;">(可选)</FormItem>
              </td>
              <td>
                <FormItem prop="c36">
                  <CheckboxGroup v-model="formRecord.c36">
                    <Checkbox label="热电偶方式" :disabled='disabledoff || forbidden.yyrqdgz'>热电偶方式</Checkbox>
                    <Checkbox label="离子感应式" :disabled='disabledoff || forbidden.yyrqdgz'>离子感应式</Checkbox><br>
                    <Checkbox label="其它方式" :disabled='disabledoff || forbidden.yyrqdgz'>其它方式</Checkbox>
                  </CheckboxGroup>
                </FormItem>
                <FormItem prop="c37" style="width:120px;margin-top:30px;margin-left:-115px;" :label-width="0">
                   <Input type="text" v-model="formRecord.c37" :disabled='disabledoff || forbidden.c37 || forbidden.yyrqdgz'/>
                </FormItem>
                <FormItem style="margin-top:30px;">(必选)</FormItem>
              </td>
              <td>
                <FormItem prop="c38">
                  <CheckboxGroup v-model="formRecord.c38">
                    <Checkbox label="热电偶方式" :disabled='disabledoff || forbidden.rqzx'>热电偶方式</Checkbox>
                    <Checkbox label="离子感应式" :disabled='disabledoff || forbidden.rqzx'>离子感应式</Checkbox><br>
                    <Checkbox label="其它方式" :disabled='disabledoff || forbidden.rqzx'>其它方式</Checkbox>
                  </CheckboxGroup>
                </FormItem>
                <FormItem prop="c39" style="width:120px;margin-top:30px;margin-left:-115px;" :label-width="0">
                  <Input type="text" v-model="formRecord.c39" :disabled='disabledoff || forbidden.c39 || forbidden.rqzx'/>
                </FormItem>
                <FormItem style="margin-top:30px;">(必选)</FormItem>
              </td>
            </tr>
            <tr>
              <td align="right" rowspan="7"><span style="color:red">*</span>灶眼直径/热负荷</td>
              <td>
                <FormItem prop="c61" label="灶眼名称(主火):" style="width:100%;" :label-width="130">
                  <Input type="text" v-model="formRecord.c61" :disabled='disabledoff || forbidden.zcrqccz' />
                </FormItem>
                <br>
                <FormItem prop="c40" label="炉口直径(mm):" style="width:100%;margin-top:20px;" :label-width="130">
                  <Input type="text" v-model="formRecord.c40" :disabled='disabledoff || forbidden.zcrqccz' />
                </FormItem>
                <br>
                <FormItem prop="c11" label="额定热负荷(kW能效标识标注值):" style="width:100%;margin-top:20px;" :label-width="130">
                  <Input type="text" v-model="formRecord.c11" :disabled='disabledoff || forbidden.zcrqccz' style="margin-top:10px;"/>
                </FormItem>
                 <br>
                <FormItem prop="c12" label="实测热负荷(kW):" style="width:100%;margin-top:20px;" :label-width="130">
                  <Input type="text" v-model="formRecord.c12" :disabled='disabledoff || forbidden.zcrqccz' />
                </FormItem>
                 <br>
                <FormItem prop="c63" label="额定热效率(%):" style="width:100%;margin-top:20px;" :label-width="130">
                  <Input type="text" v-model="formRecord.c63" :disabled='disabledoff || forbidden.zcrqccz' />
                </FormItem>
                 <br>
                <FormItem prop="c64" label="实测热效率(%):" style="width:100%;margin-top:20px;" :label-width="130">
                  <Input type="text" v-model="formRecord.c64" :disabled='disabledoff || forbidden.zcrqccz' />
                </FormItem>
              </td>
              <td>
                <FormItem prop="c89" label="灶眼名称(主火):" style="width:100%;" :label-width="130">
                  <Input type="text" v-model="formRecord.c89" :disabled='disabledoff || forbidden.yyrqdgz'/>
                </FormItem>
                <FormItem prop="c48" label="炉口直径(mm):" style="width:100%;margin-top:20px;" :label-width="130">
                  <Input type="text" v-model="formRecord.c48" :disabled='disabledoff || forbidden.yyrqdgz'/>
                </FormItem>
                <FormItem prop="c49" label="额定热负荷(kW能效标识标注值):" style="width:100%;margin-top:20px;" :label-width="130">
                  <Input type="text" v-model="formRecord.c49" :disabled='disabledoff || forbidden.yyrqdgz' style="margin-top:10px;"/>
                </FormItem>
                <FormItem prop="c90" label="实测热负荷(kW):" style="width:100%;margin-top:20px;" :label-width="130">
                  <Input type="text" v-model="formRecord.c90" :disabled='disabledoff || forbidden.yyrqdgz'/>
                </FormItem>
                <FormItem prop="c91" label="额定热效率(%):" style="width:100%;margin-top:20px;" :label-width="130">
                  <Input type="text" v-model="formRecord.c91" :disabled='disabledoff || forbidden.yyrqdgz'/>
                </FormItem>
                <FormItem prop="c92" label="实测热效率(%):" style="width:100%;margin-top:20px;" :label-width="130">
                  <Input type="text" v-model="formRecord.c92" :disabled='disabledoff || forbidden.yyrqdgz'/>
                </FormItem>
              </td>
              <td rowspan="6">
                <FormItem prop="c56" label="水胆容量(L):" style="width:100%;" :label-width="130">
                  <Input type="text" v-model="formRecord.c56" :disabled='disabledoff || forbidden.rqzx'/>
                </FormItem>
                <FormItem prop="c57" label="额定热负荷(kW):" style="width:100%;margin-top:20px;" :label-width="130">
                  <Input type="text" v-model="formRecord.c57" :disabled='disabledoff || forbidden.rqzx'/>
                </FormItem>
                <FormItem prop="c117" label="实测热负荷(kW):" style="width:100%;margin-top:20px;" :label-width="130">
                  <Input type="text" v-model="formRecord.c117" :disabled='disabledoff || forbidden.rqzx'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>
                <FormItem prop="c65" label="灶眼名称(主火):" style="width:100%;" :label-width="130">
                  <Input type="text" v-model="formRecord.c65" :disabled='disabledoff || forbidden.zcrqccz'/>
                </FormItem>
                <FormItem prop="c42" label="炉口直径(mm):" style="width:100%;margin-top:20px;" :label-width="130">
                  <Input type="text" v-model="formRecord.c42" :disabled='disabledoff || forbidden.zcrqccz'/>
                </FormItem>
                <FormItem prop="c43" label="额定热负荷(kW):" style="width:100%;margin-top:20px;" :label-width="130">
                  <Input type="text" v-model="formRecord.c43" :disabled='disabledoff || forbidden.zcrqccz'/>
                </FormItem>
                <FormItem prop="c66" label="实测热负荷(kW):" style="width:100%;margin-top:20px;" :label-width="130">
                  <Input type="text" v-model="formRecord.c66" :disabled='disabledoff || forbidden.zcrqccz'/>
                </FormItem>
                <FormItem prop="c67" label="额定热效率(%):" style="width:100%;margin-top:20px;" :label-width="130">
                  <Input type="text" v-model="formRecord.c67" :disabled='disabledoff || forbidden.zcrqccz'/>
                </FormItem>
                <FormItem prop="c68" label="实测热效率(%):" style="width:100%;margin-top:20px;" :label-width="130">
                  <Input type="text" v-model="formRecord.c68" :disabled='disabledoff || forbidden.zcrqccz'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c93" label="灶眼名称(主火):" style="width:100%;" :label-width="130">
                  <Input type="text" v-model="formRecord.c93" :disabled='disabledoff || forbidden.yyrqdgz'/>
                </FormItem>
                <FormItem prop="c50" label="炉口直径(mm):" style="width:100%;margin-top:20px;" :label-width="130">
                  <Input type="text" v-model="formRecord.c50" :disabled='disabledoff || forbidden.yyrqdgz'/>
                </FormItem>
                <FormItem prop="c51" label="额定热负荷(kW):" style="width:100%;margin-top:20px;" :label-width="130">
                  <Input type="text" v-model="formRecord.c51" :disabled='disabledoff || forbidden.yyrqdgz'/>
                </FormItem>
                <FormItem prop="c94" label="实测热负荷(kW):" style="width:100%;margin-top:20px;" :label-width="130">
                  <Input type="text" v-model="formRecord.c94" :disabled='disabledoff || forbidden.yyrqdgz'/>
                </FormItem>
                <FormItem prop="c95" label="额定热效率(%):" style="width:100%;margin-top:20px;" :label-width="130">
                  <Input type="text" v-model="formRecord.c95" :disabled='disabledoff || forbidden.yyrqdgz'/>
                </FormItem>
                <FormItem prop="c96" label="实测热效率(%):" style="width:100%;margin-top:20px;" :label-width="130">
                  <Input type="text" v-model="formRecord.c96" :disabled='disabledoff || forbidden.yyrqdgz'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>
                <FormItem prop="c69" label="灶眼名称(主火):" style="width:100%;" :label-width="130">
                  <Input type="text" v-model="formRecord.c69" :disabled='disabledoff || forbidden.zcrqccz'/>
                </FormItem>
                <FormItem prop="c44" label="炉口直径(mm):" style="width:100%;margin-top:20px;" :label-width="130">
                  <Input type="text" v-model="formRecord.c44" :disabled='disabledoff || forbidden.zcrqccz'/>
                </FormItem>
                <FormItem prop="c45" label="额定热负荷(kW):" style="width:100%;margin-top:20px;" :label-width="130">
                  <Input type="text" v-model="formRecord.c45" :disabled='disabledoff || forbidden.zcrqccz'/>
                </FormItem>
                <FormItem prop="c70" label="实测热负荷(kW):" style="width:100%;margin-top:20px;" :label-width="130">
                  <Input type="text" v-model="formRecord.c70" :disabled='disabledoff || forbidden.zcrqccz'/>
                </FormItem>
                <FormItem prop="c71" label="额定热效率(%):" style="width:100%;margin-top:20px;" :label-width="130">
                  <Input type="text" v-model="formRecord.c71" :disabled='disabledoff || forbidden.zcrqccz'/>
                </FormItem>
                <FormItem prop="c72" label="实测热效率(%):" style="width:100%;margin-top:20px;" :label-width="130">
                  <Input type="text" v-model="formRecord.c72" :disabled='disabledoff || forbidden.zcrqccz'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c97" label="灶眼名称(主火):" style="width:100%;" :label-width="130">
                  <Input type="text" v-model="formRecord.c97" :disabled='disabledoff || forbidden.yyrqdgz'/>
                </FormItem>
                <FormItem prop="c52" label="炉口直径(mm):" style="width:100%;margin-top:20px;" :label-width="130">
                  <Input type="text" v-model="formRecord.c52" :disabled='disabledoff || forbidden.yyrqdgz'/>
                </FormItem>
                <FormItem prop="c53" label="额定热负荷(kW):" style="width:100%;margin-top:20px;" :label-width="130">
                  <Input type="text" v-model="formRecord.c53" :disabled='disabledoff || forbidden.yyrqdgz'/>
                </FormItem>
                <FormItem prop="c98" label="实测热负荷(kW):" style="width:100%;margin-top:20px;" :label-width="130">
                  <Input type="text" v-model="formRecord.c98" :disabled='disabledoff || forbidden.yyrqdgz'/>
                </FormItem>
                <FormItem prop="c99" label="额定热效率(%):" style="width:100%;margin-top:20px;" :label-width="130">
                  <Input type="text" v-model="formRecord.c99" :disabled='disabledoff || forbidden.yyrqdgz'/>
                </FormItem>
                <FormItem prop="c100" label="实测热效率(%):" style="width:100%;margin-top:20px;" :label-width="130">
                  <Input type="text" v-model="formRecord.c100" :disabled='disabledoff || forbidden.yyrqdgz'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>
                <FormItem prop="c73" label="灶眼名称(主火):" style="width:100%;" :label-width="130">
                  <Input type="text" v-model="formRecord.c73" :disabled='disabledoff || forbidden.zcrqccz'/>
                </FormItem>
                <FormItem prop="c46" label="炉口直径(mm):" style="width:100%;margin-top:20px;" :label-width="130">
                  <Input type="text" v-model="formRecord.c46" :disabled='disabledoff || forbidden.zcrqccz'/>
                </FormItem>
                <FormItem prop="c47" label="额定热负荷(kW):" style="width:100%;margin-top:20px;" :label-width="130">
                  <Input type="text" v-model="formRecord.c47" :disabled='disabledoff || forbidden.zcrqccz'/>
                </FormItem>
                <FormItem prop="c74" label="实测热负荷(kW):" style="width:100%;margin-top:20px;" :label-width="130">
                  <Input type="text" v-model="formRecord.c74" :disabled='disabledoff || forbidden.zcrqccz'/>
                </FormItem>
                <FormItem prop="c75" label="额定热效率(%):" style="width:100%;margin-top:20px;" :label-width="130">
                  <Input type="text" v-model="formRecord.c75" :disabled='disabledoff || forbidden.zcrqccz'/>
                </FormItem>
                <FormItem prop="c76" label="实测热效率(%):" style="width:100%;margin-top:20px;" :label-width="130">
                  <Input type="text" v-model="formRecord.c76" :disabled='disabledoff || forbidden.zcrqccz'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c101" label="灶眼名称(主火):" style="width:100%;" :label-width="130">
                  <Input type="text" v-model="formRecord.c101" :disabled='disabledoff || forbidden.yyrqdgz'/>
                </FormItem>
                <FormItem prop="c54" label="炉口直径(mm):" style="width:100%;margin-top:20px;" :label-width="130">
                  <Input type="text" v-model="formRecord.c54" :disabled='disabledoff || forbidden.yyrqdgz'/>
                </FormItem>
                <FormItem prop="c55" label="额定热负荷(kW):" style="width:100%;margin-top:20px;" :label-width="130">
                  <Input type="text" v-model="formRecord.c55" :disabled='disabledoff || forbidden.yyrqdgz'/>
                </FormItem>
                <FormItem prop="c102" label="实测热负荷(kW):" style="width:100%;margin-top:20px;" :label-width="130">
                  <Input type="text" v-model="formRecord.c102" :disabled='disabledoff || forbidden.yyrqdgz'/>
                </FormItem>
                <FormItem prop="c103" label="额定热效率(%):" style="width:100%;margin-top:20px;" :label-width="130">
                  <Input type="text" v-model="formRecord.c103" :disabled='disabledoff || forbidden.yyrqdgz'/>
                </FormItem>
                <FormItem prop="c104" label="实测热效率(%):" style="width:100%;margin-top:20px;" :label-width="130">
                  <Input type="text" v-model="formRecord.c104" :disabled='disabledoff || forbidden.yyrqdgz'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>
                <FormItem prop="c77" label="灶眼名称(主火):" style="width:100%;" :label-width="130">
                  <Input type="text" v-model="formRecord.c77" :disabled='disabledoff || forbidden.zcrqccz'/>
                </FormItem>
                <FormItem prop="c78" label="炉口直径(mm):" style="width:100%;margin-top:20px;" :label-width="130">
                  <Input type="text" v-model="formRecord.c78" :disabled='disabledoff || forbidden.zcrqccz'/>
                </FormItem>
                <FormItem prop="c79" label="额定热负荷(kW):" style="width:100%;margin-top:20px;" :label-width="130">
                  <Input type="text" v-model="formRecord.c79" :disabled='disabledoff || forbidden.zcrqccz'/>
                </FormItem>
                <FormItem prop="c80" label="实测热负荷(kW):" style="width:100%;margin-top:20px;" :label-width="130">
                  <Input type="text" v-model="formRecord.c80" :disabled='disabledoff || forbidden.zcrqccz'/>
                </FormItem>
                <FormItem prop="c81" label="额定热效率(%):" style="width:100%;margin-top:20px;" :label-width="130">
                  <Input type="text" v-model="formRecord.c81" :disabled='disabledoff || forbidden.zcrqccz'/>
                </FormItem>
                <FormItem prop="c82" label="实测热效率(%):" style="width:100%;margin-top:20px;" :label-width="130">
                  <Input type="text" v-model="formRecord.c82" :disabled='disabledoff || forbidden.zcrqccz'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c105" label="灶眼名称(主火):" style="width:100%;" :label-width="130">
                  <Input type="text" v-model="formRecord.c105" :disabled='disabledoff || forbidden.yyrqdgz'/>
                </FormItem>
                <FormItem prop="c106" label="炉口直径(mm):" style="width:100%;margin-top:20px;" :label-width="130">
                  <Input type="text" v-model="formRecord.c106" :disabled='disabledoff || forbidden.yyrqdgz'/>
                </FormItem>
                <FormItem prop="c107" label="额定热负荷(kW):" style="width:100%;margin-top:20px;" :label-width="130">
                  <Input type="text" v-model="formRecord.c107" :disabled='disabledoff || forbidden.yyrqdgz'/>
                </FormItem>
                <FormItem prop="c108" label="实测热负荷(kW):" style="width:100%;margin-top:20px;" :label-width="130">
                  <Input type="text" v-model="formRecord.c108" :disabled='disabledoff || forbidden.yyrqdgz'/>
                </FormItem>
                <FormItem prop="c109" label="额定热效率(%):" style="width:100%;margin-top:20px;" :label-width="130">
                  <Input type="text" v-model="formRecord.c109" :disabled='disabledoff || forbidden.yyrqdgz'/>
                </FormItem>
                <FormItem prop="c110" label="实测热效率(%):" style="width:100%;margin-top:20px;" :label-width="130">
                  <Input type="text" v-model="formRecord.c110" :disabled='disabledoff || forbidden.yyrqdgz'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>
                <FormItem prop="c83" label="灶眼名称(主火):" style="width:100%;margin-top:20px;" :label-width="130">
                  <Input type="text" v-model="formRecord.c83" :disabled='disabledoff || forbidden.zcrqccz'/>
                </FormItem>
                <FormItem prop="c84" label="炉口直径(mm):" style="width:100%;margin-top:20px;" :label-width="130">
                  <Input type="text" v-model="formRecord.c84" :disabled='disabledoff || forbidden.zcrqccz'/>
                </FormItem>
                <FormItem prop="c85" label="额定热负荷(kW):" style="width:100%;margin-top:20px;" :label-width="130">
                  <Input type="text" v-model="formRecord.c85" :disabled='disabledoff || forbidden.zcrqccz'/>
                </FormItem>
                <FormItem prop="c86" label="实测热负荷(kW):" style="width:100%;margin-top:20px;" :label-width="130">
                  <Input type="text" v-model="formRecord.c86" :disabled='disabledoff || forbidden.zcrqccz'/>
                </FormItem>
                <FormItem prop="c87" label="额定热效率(%):" style="width:100%;margin-top:20px;" :label-width="130">
                  <Input type="text" v-model="formRecord.c87" :disabled='disabledoff || forbidden.zcrqccz'/>
                </FormItem>
                <FormItem prop="c88" label="实测热效率(%):" style="width:100%;margin-top:20px;" :label-width="130">
                  <Input type="text" v-model="formRecord.c88" :disabled='disabledoff || forbidden.zcrqccz'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c111" label="灶眼名称(主火):" style="width:100%;margin-top:20px;" :label-width="130">
                  <Input type="text" v-model="formRecord.c111" :disabled='disabledoff || forbidden.yyrqdgz'/>
                </FormItem>
                <FormItem prop="c112" label="炉口直径(mm):" style="width:100%;margin-top:20px;" :label-width="130">
                  <Input type="text" v-model="formRecord.c112" :disabled='disabledoff || forbidden.yyrqdgz'/>
                </FormItem>
                <FormItem prop="c113" label="额定热负荷(kW):" style="width:100%;margin-top:20px;" :label-width="130">
                  <Input type="text" v-model="formRecord.c113" :disabled='disabledoff || forbidden.yyrqdgz'/>
                </FormItem>
                <FormItem prop="c114" label="实测热负荷(kW):" style="width:100%;margin-top:20px;" :label-width="130">
                  <Input type="text" v-model="formRecord.c114" :disabled='disabledoff || forbidden.yyrqdgz'/>
                </FormItem>
                <FormItem prop="c115" label="额定热效率(%):" style="width:100%;margin-top:20px;" :label-width="130">
                  <Input type="text" v-model="formRecord.c115" :disabled='disabledoff || forbidden.yyrqdgz'/>
                </FormItem>
                <FormItem prop="c116" label="实测热效率(%):" style="width:100%;margin-top:20px;" :label-width="130">
                  <Input type="text" v-model="formRecord.c116" :disabled='disabledoff || forbidden.yyrqdgz'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td colspan="3"><span style="color:red">额定热负荷和额定热效率是整数，实测热负荷和实测热效率至少保留一位小数</span></td>
            </tr>
            <tr>
              <td align="right"><span style="color:red">*</span>外形尺寸(长×宽×高)(mm×mm×mm)</td>
              <td colspan="3">
                <FormItem prop="c58" style="width:100px;" :label-width="10">
                  <Input type="text" v-model="formRecord.c58" :disabled='disabledoff'/>
                </FormItem>
                <FormItem :label-width="10"><b>×</b></FormItem>
                <FormItem prop="c59" style="width:100px;" :label-width="10">
                  <Input type="text" v-model="formRecord.c59" :disabled='disabledoff'/>
                </FormItem>
                <FormItem :label-width="10"><b>×</b></FormItem>
                <FormItem prop="c60" style="width:100px;" :label-width="10">
                  <Input type="text" v-model="formRecord.c60" :disabled='disabledoff'/>
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
              <th>型号规格</th>
              <th  width="400">技术参数</th>
              <th>生产者（全称）</th>
            </tr>
            <tr>
              <td align="center" rowspan="4">1</td>
              <td align="center" rowspan="4">燃烧器</td>
            </tr>
            <tr>
              <td>
                <FormItem prop="c118" style="width:100%;">
                  <Input type="text" v-model="formRecord.c118" :disabled='disabledoff' />
                </FormItem>
              </td>
              <td>
                <FormItem prop="c119">
                  <CheckboxGroup v-model="formRecord.c119" class="overwrite1">
                    <Checkbox label="陶瓷" :disabled='disabledoff' class="overwrite2">陶瓷</Checkbox>
                    <Checkbox label="金属网" :disabled='disabledoff' class="overwrite2">金属网</Checkbox>
                    <Checkbox label="硬质不锈钢" :disabled='disabledoff' class="overwrite2">硬质不锈钢</Checkbox>
                    <Checkbox label="铁质" :disabled='disabledoff' class="overwrite2">铁质</Checkbox>
                    <Checkbox label="其他" :disabled='disabledoff' class="overwrite2">其他</Checkbox>
                  </CheckboxGroup>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c120" style="width:100%;">
                  <Input type="text" v-model="formRecord.c120" :disabled='disabledoff' />
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>
                <FormItem prop="c121" style="width:100%;">
                  <Input type="text" v-model="formRecord.c121" :disabled='disabledoff' />
                </FormItem>
              </td>
              <td>
                <FormItem prop="c122">
                  <CheckboxGroup v-model="formRecord.c122" class="overwrite1">
                    <Checkbox label="陶瓷" :disabled='disabledoff' class="overwrite2">陶瓷</Checkbox>
                    <Checkbox label="金属网" :disabled='disabledoff' class="overwrite2">金属网</Checkbox>
                    <Checkbox label="硬质不锈钢" :disabled='disabledoff' class="overwrite2">硬质不锈钢</Checkbox>
                    <Checkbox label="铁质" :disabled='disabledoff' class="overwrite2">铁质</Checkbox>
                    <Checkbox label="其他" :disabled='disabledoff' class="overwrite2">其他</Checkbox>
                  </CheckboxGroup>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c123" style="width:100%;">
                  <Input type="text" v-model="formRecord.c123" :disabled='disabledoff' />
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>
                <FormItem prop="c124" style="width:100%;">
                  <Input type="text" v-model="formRecord.c124" :disabled='disabledoff' />
                </FormItem>
              </td>
              <td>
                <FormItem prop="c125">
                  <CheckboxGroup v-model="formRecord.c125" class="overwrite1">
                    <Checkbox label="陶瓷" :disabled='disabledoff' class="overwrite2">陶瓷</Checkbox>
                    <Checkbox label="金属网" :disabled='disabledoff' class="overwrite2">金属网</Checkbox>
                    <Checkbox label="硬质不锈钢" :disabled='disabledoff' class="overwrite2">硬质不锈钢</Checkbox>
                    <Checkbox label="铁质" :disabled='disabledoff' class="overwrite2">铁质</Checkbox>
                    <Checkbox label="其他" :disabled='disabledoff' class="overwrite2">其他</Checkbox>
                  </CheckboxGroup>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c126" style="width:100%;">
                  <Input type="text" v-model="formRecord.c126" :disabled='disabledoff' />
                </FormItem>
              </td>
            </tr>
            <tr><td colspan="7">注：如上述零部件属多个生产者，均应按上述要求逐一填写。</td></tr>
          </table>
        </Card>
      </div>
      <div class="part part7">
        <Card :bordered="false">
          <h2>七、其他认证信息</h2>
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
              <td colspan="3" v-if="pltId != 244">
                根据企业提交的相关信息，系统直接生成能效标识样本，请提交备案后在"备案查询"功能中下载
                <!-- <Button type="primary" @click="showTemplate">查看</Button> -->
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
                    :format="['jpg','jpeg','png']"
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
          <p class="red" v-if="pageType!='view'">注：保存到草稿时，不保存附件！<br />所有附件上传文件大小需要控制在2M以内。</p>
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
        <!-- <Button type="primary" @click="submitRecord" :disabled="submitDisabled">提交备案审核申请</Button> -->
        <Button type="primary" @click="showConfirm">提交备案审核申请</Button>
      </div>
      <div class="tc" v-else>
        <Button type="primary" @click="viewClose">关闭</Button>
      </div>
    </Form>
    <Modal v-model="modal1" title="提交确认" width="960" ok-text="提交备案" cancel-text="再看看" @on-ok="submitRecord">
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
      <img :src="uploadPic" />
    </Modal>
     <Modal v-model="modal5" class="basic-info"  :width=650 ok-text="保存"  @on-ok="submitBasic" cancel-text="关闭">
       <h2>标识型号{{pageType==="extend"?'扩展':'变更'}}备案申请书</h2>
       <p class="org">中国标准化研究院能效标识管理中心：</p>
       <div class="pro-info">
          我 <span  class="f-company">{{formRecord.c1}}</span>
          公司生产的 <span class="f-brand">{{formRecord.c2}}</span>
          品牌的 <span  class="f-model">{{formRecord.c4}}</span>
          型号的 <span  class="f-product">商用燃气灶具 2014版</span>产品。
       </div>
       <dl v-if="pageType==='extend'">
          <dt>
              现提出型号扩展备案申请的 <span class="f-model"></span>
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
          <dd>现申请该幸好申请的备案信息如下变更：<br>
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
    isIntegerNotZero,
    check
  } from '@/libs/utilExt'
  export default {
    data () {
      const timeDate=parseInt(this.$store.state.app.dateinit);
    return {
      // 当前初始使用日期 对应的C值
      thisDateCV: 'c14',
      // 当前能效等级 对应的C值
      thisLevelCV: 'c7',
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
        disabledDate (date) {
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
      formRecord: {
        ec_master_kuozhan_text: '',
        c1: '',
        c2: '',
        c3: '',
        c4: '',
        c5: '',
        c7: '',
        c8: '',
        c9: '',
        c10: '',
        c11: '',
        c12: '',
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
        c31: [],
        c32: [],
        c33: [],
        c34: [],
        c35: '',
        c36: [],
        c37: '',
        c38: [],
        c39: '',
        c40: '',
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
        c107: '',
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
        c119: [], 
        c120: '',
        c121: '',
        c122: [],
        c123: '',
        c124: '',
        c125: [],
        c126: '',
        c200: '',
        c202: '',
        ec_model_no: 41,
        attach_list: ''
      },
      forbidden: {
        c28:true,
        c30:true,
        c35:true,
        c37:true,
        c39:true,
        c16_a: true,
        c16_b: true,
        c16_c: true,
        zcrqccz:true,
        yyrqdgz:true,
        rqzx:true
      }
    }
  },
  mounted () {
    
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
    },
    clearZcrqcczData(){//中餐燃气炒菜灶
        this.formRecord.c24=''
        this.formRecord.c27=''
        this.formRecord.c28=''
        this.formRecord.c31=[]
        this.formRecord.c34=[]
        this.formRecord.c35=''
        this.formRecord.c61=''
        this.formRecord.c40=''
        this.formRecord.c11=''
        this.formRecord.c12=''
        this.formRecord.c63=''
        this.formRecord.c64=''
        this.formRecord.c65=''
        this.formRecord.c42=''
        this.formRecord.c43=''
        this.formRecord.c66=''
        this.formRecord.c67=''
        this.formRecord.c68=''
        this.formRecord.c69=''
        this.formRecord.c44=''
        this.formRecord.c45=''
        this.formRecord.c70=''
        this.formRecord.c71=''
        this.formRecord.c72=''
        this.formRecord.c73=''
        this.formRecord.c46=''
        this.formRecord.c47=''
        this.formRecord.c74=''
        this.formRecord.c75=''
        this.formRecord.c76=''
        this.formRecord.c77=''
        this.formRecord.c78=''
        this.formRecord.c79=''
        this.formRecord.c80=''
        this.formRecord.c81=''
        this.formRecord.c82=''
        this.formRecord.c83=''
        this.formRecord.c84=''
        this.formRecord.c85=''
        this.formRecord.c86=''
        this.formRecord.c87=''
        this.formRecord.c88=''
    },
    clearYyrqdgzData(){// 炊用燃气大锅灶
        this.formRecord.c25=''
        this.formRecord.c29=''
        this.formRecord.c30=''
        this.formRecord.c32=[]
        this.formRecord.c36=[]
        this.formRecord.c37=''
        this.formRecord.c89=''
        this.formRecord.c48=''
        this.formRecord.c49=''
        this.formRecord.c90=''
        this.formRecord.c91=''
        this.formRecord.c92=''
        this.formRecord.c93=''
        this.formRecord.c50=''
        this.formRecord.c51=''
        this.formRecord.c94=''
        this.formRecord.c95=''
        this.formRecord.c96=''
        this.formRecord.c97=''
        this.formRecord.c52=''
        this.formRecord.c53=''
        this.formRecord.c98=''
        this.formRecord.c99=''
        this.formRecord.c100=''
        this.formRecord.c101=''
        this.formRecord.c54=''
        this.formRecord.c55=''
        this.formRecord.c102=''
        this.formRecord.c103=''
        this.formRecord.c104=''
        this.formRecord.c105=''
        this.formRecord.c106=''
        this.formRecord.c107=''
        this.formRecord.c108=''
        this.formRecord.c109=''
        this.formRecord.c110=''
        this.formRecord.c111=''
        this.formRecord.c112=''
        this.formRecord.c113=''
        this.formRecord.c114=''
        this.formRecord.c115=''
        this.formRecord.c116=''
    },
    clearRqzxData(){// 燃气蒸箱
        this.formRecord.c26=''
        this.formRecord.c33=[]
        this.formRecord.c38=[]
        this.formRecord.c39=''
        this.formRecord.c56=''
        this.formRecord.c57=''
        this.formRecord.c117=''
    }
  },
  computed: {
    ...mapGetters([
      'pageType'
    ]),
    disabledoff(){
      return  this.pageType==='extend';
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
    ruleRecord () {

      //燃气类别
      if (this.formRecord.c15 === '人工煤气灶具') {
        this.forbidden.c16_a = false
        this.forbidden.c16_b = true
        this.forbidden.c16_c = true
      } else if (this.formRecord.c15 === '天然气灶具') {
        this.forbidden.c16_a = true
        this.forbidden.c16_b = false
        this.forbidden.c16_c = true
      } else if (this.formRecord.c15 === '液化石油气灶具') {
        this.forbidden.c16_a = true
        this.forbidden.c16_b = true
        this.forbidden.c16_c = false
      }

      //产品类别
      var  c23_V=this.formRecord.c23;
      if(c23_V==='中餐燃气炒菜灶'){
          this.clearYyrqdgzData()
          this.clearRqzxData()
          this.forbidden.zcrqccz=false
          this.forbidden.yyrqdgz=true
          this.forbidden.rqzx=true
      }else if(c23_V==='炊用燃气大锅灶'){
          this.clearZcrqcczData()
          this.clearRqzxData()
          this.forbidden.zcrqccz=true
          this.forbidden.yyrqdgz=false
          this.forbidden.rqzx=true
      }else if(c23_V==='燃气蒸箱'){
          this.clearZcrqcczData()
          this.clearYyrqdgzData()
          this.forbidden.zcrqccz=true
          this.forbidden.yyrqdgz=true
          this.forbidden.rqzx=false
      }

      //中餐燃气炒菜灶-多眼灶
      if (this.formRecord.c27 == '多眼灶') {
          this.forbidden.c28 = false
      } else {
          this.formRecord.c28 = ''
          this.forbidden.c28 = true
      }

      //炊用燃气大锅灶-多眼灶
      if (this.formRecord.c29 == '多眼灶') {
          this.forbidden.c30 = false
      } else {
          this.formRecord.c30 = ''
          this.forbidden.c30 = true
      }

      //中餐燃气炒菜灶-熄火保护装置形式/火焰监控装置形式
      if (this.formRecord.c34.join('').indexOf('其它方式') > -1) {
          this.forbidden.c35 = false
      } else {
          this.formRecord.c35 = ''
          this.forbidden.c35 = true
      }

      //炊用燃气大锅灶-熄火保护装置形式/火焰监控装置形式
      if (this.formRecord.c36.join('').indexOf('其它方式') > -1) {
          this.forbidden.c37 = false
      } else {
          this.formRecord.c37 = ''
          this.forbidden.c37 = true
      }

      //燃气蒸箱-熄火保护装置形式/火焰监控装置形式
      if (this.formRecord.c38.join('').indexOf('其它方式') > -1) {
          this.forbidden.c39 = false
      } else {
          this.formRecord.c39 = ''
          this.forbidden.c39 = true
      }
      
      //热效率实测值应大于标注值
      var c8v = this.formRecord.c8;
      var c9v = this.formRecord.c9;
      const checkc9 = (rule, value, callback) => {
        if (c8v >= c9v) {
          callback('热效率实测值应大于标注值')
        }else{
          callback()
        }
      }

      var nxdjch = this.formRecord.c7;
      var cplb = this.formRecord.c23;
      var nxdj = "";
      if (cplb == "中餐燃气炒菜灶") {
          if (parseFloat(c8v) >= 45) {
              nxdj = "1";
          } else if (parseFloat(c8v) >= 35) {
              nxdj = "2";
          } else if (parseFloat(c8v) >= 25) {
              nxdj = "3";
          }
      } else if (cplb == "炊用燃气大锅灶") {
          if (parseFloat(c8v) >= 65) {
              nxdj = "1";
          } else if (parseFloat(c8v) >= 55) {
              nxdj = "2";
          } else if (parseFloat(c8v) >= 45) {
              nxdj = "3";
          }
      } else if (cplb == "燃气蒸箱") {
          if (parseFloat(c8v) >= 90) {
              nxdj = "1";
          } else if (parseFloat(c8v) >= 80) {
              nxdj = "2";
          } else if (parseFloat(c8v) >= 70) {
              nxdj = "3";
          }
      }

      const checkc8 = (rule, value, callback) => {
        if (parseFloat(c8v) > 100 || nxdj == "") {
          callback('能效数据不在备案范围')
        }else{
          callback()
        }
      }

      const checkc7 = (rule, value, callback) => {
        if (nxdjch != nxdj) {
          callback('所选能效等级与计算结果不符！')
        }else{
          callback()
        }
      }

      return {
        c3: [
          {
            required: true,
            trigger: 'change,blur',
            message: '请输入制造单位'
          }
        ],
        c5: [
          {
            required: true,
            trigger: 'change,blur',
            message: '请输入备案方'
          }
        ],
        c4: [
          {
            required: true,
            trigger: 'change,blur',
            message: '请输入规格型号'
          }
        ],
        c2: [
          {
            required: true,
            trigger: 'change,blur',
            message: '请输入商标'
          }
        ],
        c7: [
          {
            required: true,
            trigger: 'change,blur',
            message: '请选择能源效率等级'
          },
          {
            validator: checkc7,
            trigger: 'change,blur'
          }
        ],
        c8: [
          {
            required: true,
            trigger: 'change,blur',
            message: '请输入热效率标注值'
          },
          {
            validator: isIntegerNotZero,
            trigger: 'change,blur'
          },
          {
            validator: checkc8,
            trigger: 'change,blur'
          }
        ],
        c9: [
          {
            required: true,
            trigger: 'change,blur',
            message: '请输入热效率实测值'
          },
          {
            validator: oneDecimals,
            trigger: 'change,blur'
          },
          {
            validator: checkc9,
            trigger: 'change,blur'
          }
        ],
        c11: [
          {
            required: this.formRecord.c23 === '中餐燃气炒菜灶',
            trigger: 'change,blur',
            message: '请输入热负荷标注值'
          },
          {
            validator: this.formRecord.c11 != ''? isIntegerNotZero:check,
            trigger: 'change,blur'
          }
        ],
        c12: [
          {
            required: this.formRecord.c23 === '中餐燃气炒菜灶',
            trigger: 'change,blur',
            message: '请输入热负荷实测值'
          },
          {
            validator: this.formRecord.c12 != ''? oneDecimals:check,
            trigger: 'change,blur'
          }

        ],
        c14: [
          {
            required: true,
            message: '请选择初始使用日期'
          }
        ],
        c15: [
          {
            required: true,
            trigger: 'change,blur',
            message: '请选择燃气类别'
          }
        ],
        c16: [
          {
            required: true,
            trigger: 'change,blur',
            message: '请选择燃气类别值'
          }
        ],
        c17: [
          {
            required: true,
            trigger: 'change,blur',
            message: '请选择电源类别'
          }
        ],
        c18: [
          {
            required: true,
            trigger: 'change,blur',
            message: '请输入电源电压'
          }
        ],
        c19: [
          {
            required: true,
            trigger: 'change,blur',
            message: '请输入电源电流'
          }
        ],
        c20: [
          {
            required: true,
            trigger: 'change,blur',
            message: '请选择是否有稳压器'
          }
        ],
        c21: [
          {
            required: true,
            trigger: 'change,blur',
            message: '请输入额定功率'
          }
        ],
        c22: [
          {
            required: true,
            trigger: 'change,blur',
            message: '请输入运行噪声等级'
          }
        ],
        c23: [
          {
            required: true,
            trigger: 'change,blur',
            message: '请选择产品类别'
          }
        ],
        c24: [
          {
            required: this.formRecord.c23 === '中餐燃气炒菜灶',
            trigger: 'change,blur',
            message: '请选择空气供给方式'
          }
        ],
        c25: [
          {
            required: this.formRecord.c23 === '炊用燃气大锅灶',
            trigger: 'change,blur',
            message: '请选择空气供给方式'
          }
        ],
        c26: [
          {
            required: this.formRecord.c23 === '燃气蒸箱',
            trigger: 'change,blur',
            message: '请选择空气供给方式'
          }
        ],
        c27: [
          {
            required: this.formRecord.c23 === '中餐燃气炒菜灶',
            trigger: 'change,blur',
            message: '请选择灶眼数'
          }
        ],
        c28: [
          {
            required: this.formRecord.c27 === '多眼灶',
            trigger: 'change,blur',
            message: '请输入灶眼数'
          }
        ],
        c29: [
          {
            required: this.formRecord.c23 === '炊用燃气大锅灶',
            trigger: 'change,blur',
            message: '请选择灶眼数'
          }
        ],
        c30: [
          {
            required: this.formRecord.c29 === '多眼灶',
            trigger: 'change,blur',
            message: '请输入灶眼数'
          }
        ],
        c31: [
          {
            required: this.formRecord.c23 === '中餐燃气炒菜灶',
            message: '请选择点火方式/常明火点火方式'
          }
        ],
        c32: [
          {
            required: this.formRecord.c23 === '炊用燃气大锅灶',
            message: '请选择点火方式/常明火点火方式'
          }
        ],
        c33: [
          {
            required: this.formRecord.c23 === '燃气蒸箱',
            message: '请选择点火方式/常明火点火方式'
          }
        ],
        c35: [
          {
            required: this.formRecord.c34.join('').indexOf('其它方式') > -1,
            trigger: 'change,blur',
            message: '请输入其它方式'
          }
        ],
        c36: [
          {
            required: this.formRecord.c23 === '炊用燃气大锅灶',
            message: '请选择'
          }
        ],
        c37: [
          {
            required: this.formRecord.c36.join('').indexOf('其它方式') > -1,
            trigger: 'change,blur',
            message: '请输入其它方式'
          }
        ],
        c38: [
          {
            required: this.formRecord.c23 === '燃气蒸箱',
            message: '请选择'
          }
        ],
        c39: [
          {
            required: this.formRecord.c38.join('').indexOf('其它方式') > -1,
            trigger: 'change,blur',
            message: '请输入其它方式'
          }
        ],
        c40: [
          {
            required: this.formRecord.c23 === '中餐燃气炒菜灶',
            trigger: 'change,blur',
            message: '请输入炉口直径值'
          }
        ],
        c41: [
          {
            required: true,
            trigger: 'change,blur',
            message: '请输入额定热负荷值'
          }
        ],
        c42: [
          {
            required: this.formRecord.c23 === '中餐燃气炒菜灶',
            trigger: 'change,blur',
            message: '请输入炉口直径值'
          }
        ],
        c43: [
          {
            required: this.formRecord.c23 === '中餐燃气炒菜灶',
            trigger: 'change,blur',
            message: '请输入额定热负荷值'
          }
        ],
        c44: [
          {
            required: this.formRecord.c23 === '中餐燃气炒菜灶',
            trigger: 'change,blur',
            message: '请输入炉口直径值'
          }
        ],
        c45: [
          {
            required: this.formRecord.c23 === '中餐燃气炒菜灶',
            trigger: 'change,blur',
            message: '请输入额定热负荷值'
          }
        ],
        c46: [
          {
            required: this.formRecord.c23 === '中餐燃气炒菜灶',
            trigger: 'change,blur',
            message: '请输入炉口直径值'
          }
        ],
        c47: [
          {
            required: this.formRecord.c23 === '中餐燃气炒菜灶',
            trigger: 'change,blur',
            message: '请输入额定热负荷值'
          }
        ],
        c48: [
          {
            required: this.formRecord.c23 === '炊用燃气大锅灶',
            trigger: 'change,blur',
            message: '请输入炉口直径值'
          }
        ],
        c49: [
          {
            required: this.formRecord.c23 === '炊用燃气大锅灶',
            trigger: 'change,blur',
            message: '请输入额定热负荷值'
          }
        ],
        c50: [
          {
            required: this.formRecord.c23 === '炊用燃气大锅灶',
            trigger: 'change,blur',
            message: '请输入炉口直径值'
          }
        ],
        c51: [
          {
            required: this.formRecord.c23 === '炊用燃气大锅灶',
            trigger: 'change,blur',
            message: '请输入额定热负荷值'
          }
        ],
        c52: [
          {
            required: this.formRecord.c23 === '炊用燃气大锅灶',
            trigger: 'change,blur',
            message: '请输入炉口直径值'
          }
        ],
        c53: [
          {
            required: this.formRecord.c23 === '炊用燃气大锅灶',
            trigger: 'change,blur',
            message: '请输入额定热负荷值'
          }
        ],
        c54: [
          {
            required: this.formRecord.c23 === '炊用燃气大锅灶',
            trigger: 'change,blur',
            message: '请输入炉口直径值'
          }
        ],
        c55: [
          {
            required: this.formRecord.c23 === '炊用燃气大锅灶',
            trigger: 'change,blur',
            message: '请输入额定热负荷值'
          }
        ],
        c56: [
          {
            required: this.formRecord.c23 === '燃气蒸箱',
            trigger: 'change,blur',
            message: '请输入水胆容量'
          }
        ],
        c57: [
          {
            required: this.formRecord.c23 === '燃气蒸箱',
            trigger: 'change,blur',
            message: '请输入额定热负荷值'
          }
        ],
        c58: [
          {
            required: true,
            trigger: 'change,blur',
            message: '请输入外形尺寸(长)'
          },
          {
            validator: isIntegerNotZero,
            trigger: 'change,blur'
          }
        ],
        c59: [
          {
            required: true,
            trigger: 'change,blur',
            message: '请输入外形尺寸(宽)'
          },
          {
            validator: isIntegerNotZero,
            trigger: 'change,blur'
          }
        ],
        c60: [
          {
            required: true,
            trigger: 'change,blur',
            message: '请输入外形尺寸(高)'
          },
          {
            validator: isIntegerNotZero,
            trigger: 'change,blur'
          }
        ],
        c118: [
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
        c123: [
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
        c126: [
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
  .overwrite2 > span > span {
    width: 14px !important;
  }
  .overwrite1 span {
    width: auto  !important;
  }
</style>
