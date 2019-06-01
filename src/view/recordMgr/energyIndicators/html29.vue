<template>
  <div class="wrapper">
    <Form ref="formRecord" :model="formRecord" label-position="right" :rules="ruleRecord">
      <h1>家用太阳能热水系统-修订能源效率标识备案表</h1>
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
          <h2>三、能源效率标识备案信息</h2>
          <FormItem prop="c1" label="生产者名称" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c1" placeholder="生产者名称" readonly disabled />
          </FormItem>
          <FormItem prop="c3" label="制造单位" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c3" :disabled='disabledoff' placeholder="制造单位"/>
          </FormItem>
          <FormItem prop="c59" label="备案方" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c59" :disabled='disabledoff' placeholder="备案方"/>
          </FormItem>
          <FormItem prop="c2" label="产品规格型号" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c2" :disabled='!disabledoff' placeholder="规格型号"/>
          </FormItem>
          <FormItem prop="c4" label="商标" style="width:100%" :label-width="180">
            <Input type="text" v-model="formRecord.c4" :disabled='disabledoff' placeholder="商标"/>
          </FormItem>
          <FormItem prop="c200" label="依据国家标准" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c200" placeholder="依据国家标准" readonly disabled/>
          </FormItem>
          <FormItem prop="c64" label="能效等级" style="width:100%;" :label-width="180">
            <RadioGroup v-model="formRecord.c64">
              <Radio label="1" :disabled='disabledoff'>1级</Radio>
              <Radio label="2" :disabled='disabledoff'>2级</Radio>
              <Radio label="3" :disabled='disabledoff'>3级</Radio>
            </RadioGroup>
          </FormItem>
          <table id="table1">
            <!-- <tr>
              <th>项目</th>
              <th>额定值</th>
              <th>实测值</th>
              <th>备注</th>
            </tr> -->
            <tr>
              <td align="center">能效系数(CTP)</td>
              <td>
                <FormItem prop="c5" label="标称值:" style="width:100%;" :label-width="70">
                  <Input type="text" v-model="formRecord.c5" :disabled='disabledoff' placeholder="两位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c6" label="实测值:" style="width:100%;" :label-width="70">
                  <Input type="text" v-model="formRecord.c6" :disabled='disabledoff' placeholder="两位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c60" label="备注:" style="width:100%;" :label-width="70">
                  <Input type="text" v-model="formRecord.c60" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center">日有用得热量 Qs(e) [Mj/m²]</td>
              <td>
                <FormItem prop="c7" label="标称值:" style="width:100%;" :label-width="70">
                  <Input type="text" v-model="formRecord.c7" :disabled='disabledoff' placeholder="一位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c8" label="实测值:" style="width:100%;" :label-width="70">
                  <Input type="text" v-model="formRecord.c8" :disabled='disabledoff' placeholder="一位小数"/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c61" label="备注:" style="width:100%;" :label-width="70">
                  <Input type="text" v-model="formRecord.c61" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center">平均热损因数 Usl(e) [W/(m³·K)]</td>
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
                <FormItem prop="c62" label="备注:" style="width:100%;" :label-width="70">
                  <Input type="text" v-model="formRecord.c62" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
          </table>
        </Card>
      </div>
      <div class="part part4">
        <Card :bordered="false">
          <h2>四、初始使用日期</h2>
          <FormItem prop="c11" label="备案标识开始使用日期" style="width:100%;">
            <DatePicker type="date" :options="dataInit" style="width: 200px" v-model="formRecord.c11" :disabled='disabledoff'></DatePicker>
          </FormItem>
        </Card>
      </div>
      <div class="part part5">
        <Card :bordered="false">
          <h2>五、其他信息</h2>
          <h3>样品描述</h3>
          <table id="table3">
            <tr>
              <td align="right"><span style="color:red">*</span>辅助能源类别</td>
              <td colspan="3">
                <FormItem prop="c12" style="width:100%;" :label-width="30">
                  <RadioGroup v-model="formRecord.c12">
                    <Radio label="电" :disabled='disabledoff'>电</Radio>
                    <Radio label="燃气" :disabled='disabledoff'>燃气</Radio>
                    <Radio label="热泵" :disabled='disabledoff'>热泵</Radio>
                    <Radio label="无辅助能源" :disabled='disabledoff'>无辅助能源</Radio>
                    <Radio label="其他" :disabled='disabledoff'>其他</Radio>
                  </RadioGroup>
                  <FormItem prop="c63">
                    <Input type="text" v-model="formRecord.c63" style="width:200px;" :disabled='disabledoff || forbidden.c63'/>
                  </FormItem>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span style="color:red">*</span>类别</td>
              <td colspan="3">
                <FormItem prop="c13" style="width:100%;" :label-width="30">
                  <RadioGroup v-model="formRecord.c13">
                    <Radio label="紧凑式" :disabled='disabledoff'>紧凑式</Radio>
                    <Radio label="分离直接式(分体单回路)" :disabled='disabledoff'>分离直接式(分体单回路)</Radio>
                    <Radio label="分离间接式(分体双回路)" :disabled='disabledoff'>分离间接式(分体双回路)</Radio>
                    <Radio label="闷晒式" :disabled='disabledoff'>闷晒式</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span style="color:red">*</span>集热器类型及面积</td>
              <td colspan="3">
                <FormItem prop="c14" style="width:100%;" :label-width="30">
                  <RadioGroup v-model="formRecord.c14">
                    <Radio label="真空管型" :disabled='disabledoff'>真空管型</Radio>
                    <Radio label="平板型" :disabled='disabledoff'>平板型</Radio>
                  </RadioGroup>
                  <FormItem prop="c15">
                    面积<Input type="text" v-model="formRecord.c15" style="width:200px;" :disabled='disabledoff'/>m²(两位小数)
                  </FormItem>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right" rowspan="3"><span style="color:red">*</span>真空管型集热器</td>
              <td align="left">类型</td>
              <td>
                <FormItem prop="c16" style="width:100%;" :label-width="30">
                  <RadioGroup v-model="formRecord.c16">
                    <Radio label="全玻璃" :disabled='disabledoff'>全玻璃</Radio>
                    <Radio label="其他" :disabled='disabledoff'>其他</Radio>
                  </RadioGroup>
                </FormItem>
                <FormItem prop="c17" :label-width="10">
                    <Input type="text" v-model="formRecord.c17" style="width:200px;" :disabled='disabledoff'/>
                </FormItem>
              </td>
             </tr>
             <tr>
              <td align="left">热管型</td>
              <td colspan="2">
                <FormItem prop="c18" style="width:100%;" :label-width="30">
                  <RadioGroup v-model="formRecord.c18">
                    <Radio label="玻璃-金属封接" :disabled='disabledoff'>玻璃-金属封接</Radio>
                    <Radio label="内置带翅片的金属热管" :disabled='disabledoff'>内置带翅片的金属热管</Radio>
                    <Radio label="全玻璃热管" :disabled='disabledoff'>全玻璃热管</Radio>
                    <Radio label="其他" :disabled='disabledoff'>其他</Radio>
                  </RadioGroup>
                </FormItem>
                <FormItem prop="c19" :label-width="10">
                    <Input type="text" v-model="formRecord.c19" style="width:200px;" :disabled='disabledoff'/>
                </FormItem>
              </td>
             </tr>
             <tr>
              <td align="left">尺寸</td>
              <td colspan="2">
                <FormItem prop="c20" label="长度:" :label-width="10">
                    <Input type="text" v-model="formRecord.c20" style="width:200px;" :disabled='disabledoff'/>
                    <label>m(一位小数)></label>
                </FormItem>
                <FormItem prop="c21" label="直径:" :label-width="10">
                    <Input type="text" v-model="formRecord.c21" style="width:200px;" :disabled='disabledoff'/>
                    <label>mm</label>
                </FormItem>
                <FormItem prop="c22" label="根数:" :label-width="10">
                    <Input type="text" v-model="formRecord.c22" style="width:200px;" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>

            <!-- <tr>
              <td align="right" rowspan="9"><span style="color:red">*</span>平板型集热器</td>
              <td align="left">吸热板材质</td>
              <td>
                <FormItem prop="c23" style="width:100%;" :label-width="30">
                  <RadioGroup v-model="formRecord.c23">
                    <Radio label="铜板" :disabled='disabledoff'>铜板</Radio>
                    <Radio label="铝板" :disabled='disabledoff'>铝板</Radio>
                    <Radio label="其他" :disabled='disabledoff'>其他</Radio>
                  </RadioGroup>
                </FormItem>
                <FormItem prop="c24" :label-width="10">
                    <Input type="text" v-model="formRecord.c24" style="width:200px;" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td align="left">吸热板厚度(mm)</td>
              <td>
                <FormItem prop="c25" :label-width="10">
                    <Input type="text" v-model="formRecord.c25" style="width:200px;" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td align="left">吸收涂层工艺</td>
              <td>
                <FormItem prop="c26" style="width:100%;" :label-width="30">
                  <RadioGroup v-model="formRecord.c26">
                    <Radio label="阳极氧化" :disabled='disabledoff'>阳极氧化</Radio>
                    <Radio label="镀铬" :disabled='disabledoff'>镀铬</Radio>
                    <Radio label="磁控溅射" :disabled='disabledoff'>磁控溅射</Radio>
                    <Radio label="其他" :disabled='disabledoff'>其他</Radio>
                  </RadioGroup>
                </FormItem>
                <FormItem prop="c27" :label-width="10">
                    <Input type="text" v-model="formRecord.c27" style="width:200px;" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td align="left">集热器用户传热工质接触部位的材料</td>
              <td>
                <FormItem prop="c28" style="width:100%;" :label-width="30">
                  <RadioGroup v-model="formRecord.c28">
                    <Radio label="铜管" :disabled='disabledoff'>铜管</Radio>
                    <Radio label="铝管" :disabled='disabledoff'>铝管</Radio>
                    <Radio label="其他" :disabled='disabledoff'>其他</Radio>
                  </RadioGroup>
                </FormItem>
                <FormItem prop="c29" :label-width="10">
                    <Input type="text" v-model="formRecord.c29" style="width:200px;" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td align="left">集热器用户传热工质接触部位的材料厚度(mm)</td>
              <td>
                <FormItem prop="c30" :label-width="10">
                    <Input type="text" v-model="formRecord.c30" style="width:200px;" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td align="left">集热器盖板类型</td>
              <td>
                <FormItem prop="c31" style="width:100%;" :label-width="30">
                  <RadioGroup v-model="formRecord.c31">
                    <Radio label="钢化玻璃" :disabled='disabledoff'>钢化玻璃</Radio>
                    <Radio label="普通玻璃" :disabled='disabledoff'>普通玻璃</Radio>
                    <Radio label="布纹玻璃" :disabled='disabledoff'>布纹玻璃</Radio>
                    <Radio label="其他" :disabled='disabledoff'>其他</Radio>
                  </RadioGroup>
                </FormItem>
                <FormItem prop="c32" :label-width="10">
                    <Input type="text" v-model="formRecord.c32" style="width:200px;" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td align="left">集热器盖板厚度</td>
              <td>
                <FormItem prop="c33" style="width:100%;" :label-width="30">
                  <RadioGroup v-model="formRecord.c33">
                    <Radio label="3 mm" :disabled='disabledoff'>3 mm</Radio>
                    <Radio label="4 mm" :disabled='disabledoff'>4 mm</Radio>
                    <Radio label="5 mm" :disabled='disabledoff'>5 mm</Radio>
                    <Radio label="其他" :disabled='disabledoff'>其他（mm）</Radio>
                  </RadioGroup>
                </FormItem>
                <FormItem prop="c34" :label-width="10">
                    <Input type="text" v-model="formRecord.c34" style="width:200px;" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td align="left">保温棉材料</td>
              <td>
                <FormItem prop="c35" style="width:100%;" :label-width="30">
                  <RadioGroup v-model="formRecord.c35">
                    <Radio label="岩棉" :disabled='disabledoff'>岩棉</Radio>
                    <Radio label="玻璃棉" :disabled='disabledoff'>玻璃棉</Radio>
                    <Radio label="聚氨酯" :disabled='disabledoff'>聚氨酯</Radio>
                    <Radio label="其他" :disabled='disabledoff'>其他</Radio>
                  </RadioGroup>
                </FormItem>
                <FormItem prop="c36" :label-width="10">
                    <Input type="text" v-model="formRecord.c36" style="width:200px;" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td align="left">集热器背板材料</td>
              <td>
                <FormItem prop="c37" style="width:100%;" :label-width="30">
                  <RadioGroup v-model="formRecord.c37">
                    <Radio label="镀锌板" :disabled='disabledoff'>镀锌板</Radio>
                    <Radio label="铝板" :disabled='disabledoff'>铝板</Radio>
                    <Radio label="彩板" :disabled='disabledoff'>彩板</Radio>
                    <Radio label="其他" :disabled='disabledoff'>其他</Radio>
                  </RadioGroup>
                </FormItem>
                <FormItem prop="c38" :label-width="10">
                    <Input type="text" v-model="formRecord.c38" style="width:200px;" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span style="color:red">*</span>支架外形、材质、颜色</td>
              <td>
                <FormItem prop="c39" label="外形:" :label-width="10">
                    <Input type="text" v-model="formRecord.c39" style="width:100px;" :disabled='disabledoff'/>
                </FormItem>
                <FormItem prop="c73" label="材质:" :label-width="10">
                    <Input type="text" v-model="formRecord.c73" style="width:100px;" :disabled='disabledoff'/>
                </FormItem>
                <FormItem prop="c74" label="颜色:" :label-width="10">
                    <Input type="text" v-model="formRecord.c74" style="width:100px;" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span style="color:red">*</span>水箱外形、材质、颜色</td>
              <td>
                <FormItem prop="c40" label="外形:" :label-width="10">
                    <Input type="text" v-model="formRecord.c40" style="width:100px;" :disabled='disabledoff'/>
                </FormItem>
                <FormItem prop="c76" label="材质:" :label-width="10">
                    <Input type="text" v-model="formRecord.c76" style="width:100px;" :disabled='disabledoff'/>
                </FormItem>
                <FormItem prop="c77" label="颜色:" :label-width="10">
                    <Input type="text" v-model="formRecord.c77" style="width:100px;" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span style="color:red">*</span>贮热水箱容积m³(三位小数)</td>
              <td>
                <FormItem prop="c41" :label-width="10">
                    <Input type="text" v-model="formRecord.c41" style="width:100px;" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td></td>
            </tr>
            <tr>
              <td align="right"><span style="color:red">*</span>贮热水箱换热器材质</td>
              <td>
                <FormItem prop="c42" style="width:100%;" :label-width="30">
                  <RadioGroup v-model="formRecord.c42">
                    <Radio label="不锈钢板" :disabled='disabledoff'>不锈钢板</Radio>
                    <Radio label="紫铜管" :disabled='disabledoff'>紫铜管</Radio>
                    <Radio label="铝及铝合金板" :disabled='disabledoff'>铝及铝合金板</Radio>
                    <Radio label="碳钢管" :disabled='disabledoff'>碳钢管</Radio>
                    <Radio label="碳钢板" :disabled='disabledoff'>碳钢板</Radio>
                    <Radio label="其他" :disabled='disabledoff'>其他</Radio>
                  </RadioGroup>
                </FormItem>
                <FormItem prop="c43" :label-width="10">
                    <Input type="text" v-model="formRecord.c43" style="width:200px;" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span style="color:red">*</span>贮热水箱换热器结构</td>
              <td>
                <FormItem prop="c44" style="width:100%;" :label-width="30">
                  <RadioGroup v-model="formRecord.c44">
                    <Radio label="夹层水箱" :disabled='disabledoff'>夹层水箱</Radio>
                    <Radio label="外置板换" :disabled='disabledoff'>外置板换</Radio>
                    <Radio label="盘管" :disabled='disabledoff'>盘管</Radio>
                    <Radio label="其他" :disabled='disabledoff'>其他</Radio>
                  </RadioGroup>
                </FormItem>
                <FormItem prop="c45" :label-width="10">
                    <Input type="text" v-model="formRecord.c45" style="width:200px;" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span style="color:red">*</span>贮热水箱用于隔热体材料</td>
              <td>
                <FormItem prop="c46" style="width:100%;" :label-width="30">
                  <RadioGroup v-model="formRecord.c46">
                    <Radio label="聚氨酯泡沫塑料" :disabled='disabledoff'>聚氨酯泡沫塑料</Radio>
                    <Radio label="聚苯乙烯泡沫塑料" :disabled='disabledoff'>聚苯乙烯泡沫塑料</Radio>
                    <Radio label="其他" :disabled='disabledoff'>其他</Radio>
                  </RadioGroup>
                </FormItem>
                <FormItem prop="c47" :label-width="10">
                    <Input type="text" v-model="formRecord.c47" style="width:200px;" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span style="color:red">*</span>内胆厚度（mm）</td>
              <td>
                <FormItem prop="c52" :label-width="10">
                    <Input type="text" v-model="formRecord.c52" style="width:100px;" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td></td>
            </tr>
            <tr>
              <td align="right"><span style="color:red">*</span>内胆形状</td>
              <td>
                <FormItem prop="c48" style="width:100%;" :label-width="30">
                  <RadioGroup v-model="formRecord.c48">
                    <Radio label="圆柱形" :disabled='disabledoff'>圆柱形</Radio>
                    <Radio label="非圆柱形" :disabled='disabledoff'>非圆柱形</Radio>
                    <Radio label="其他" :disabled='disabledoff'>其他</Radio>
                  </RadioGroup>
                </FormItem>
                <FormItem prop="c49" :label-width="10">
                    <Input type="text" v-model="formRecord.c49" style="width:200px;" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span style="color:red">*</span>内胆材质</td>
              <td>
                <FormItem prop="c50" style="width:100%;" :label-width="30">
                  <RadioGroup v-model="formRecord.c50">
                    <Radio label="不锈钢" :disabled='disabledoff'>不锈钢</Radio>
                    <Radio label="搪瓷" :disabled='disabledoff'>搪瓷</Radio>
                    <Radio label="塑料" :disabled='disabledoff'>塑料</Radio>
                    <Radio label="其他" :disabled='disabledoff'>其他</Radio>
                  </RadioGroup>
                </FormItem>
                <FormItem prop="c51" :label-width="10">
                    <Input type="text" v-model="formRecord.c51" style="width:200px;" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span style="color:red">*</span>最大试验压力(×106Pa)</td>
              <td>
                <FormItem prop="c54" :label-width="10">
                    <Input type="text" v-model="formRecord.c54" style="width:200px;" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td align="right"><span style="color:red">*</span>额定工作压力(×106Pa)</td>
              <td>
                <FormItem prop="c55" :label-width="10">
                    <Input type="text" v-model="formRecord.c55" style="width:200px;" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span style="color:red">*</span>是否带有阳极保护材料</td>
              <td>
               <FormItem prop="c53" style="width:100%;" :label-width="30">
                  <RadioGroup v-model="formRecord.c53">
                    <Radio label="是" :disabled='disabledoff'>是</Radio>
                    <Radio label="否" :disabled='disabledoff'>否</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td align="right"><span style="color:red">*</span>是否为一体机</td>
              <td>
                <FormItem prop="c71" style="width:100%;" :label-width="30">
                  <RadioGroup v-model="formRecord.c71">
                    <Radio label="是" :disabled='disabledoff'>是</Radio>
                    <Radio label="否" :disabled='disabledoff'>否</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span style="color:red">*</span>一体机外形尺寸(长×宽×高)(mm×mm×mm)</td>
              <td>
                <FormItem prop="c56" style="width:60px;">
                  <Input type="text" v-model="formRecord.c56" :disabled='disabledoff'/>
                </FormItem>
                <FormItem><b>×</b></FormItem>
                <FormItem prop="c65" style="width:60px;">
                  <Input type="text" v-model="formRecord.c65" :disabled='disabledoff'/>
                </FormItem>
                <FormItem><b>×</b></FormItem>
                <FormItem prop="c66" style="width:60px;">
                  <Input type="text" v-model="formRecord.c66" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span style="color:red">*</span>贮热水箱及其附件外形尺寸(长×宽×高)(mm×mm×mm)</td>
              <td>
                <FormItem prop="c57" style="width:60px;">
                  <Input type="text" v-model="formRecord.c57" :disabled='disabledoff'/>
                </FormItem>
                <FormItem><b>×</b></FormItem>
                <FormItem prop="c67" style="width:60px;">
                  <Input type="text" v-model="formRecord.c67" :disabled='disabledoff'/>
                </FormItem>
                <FormItem><b>×</b></FormItem>
                <FormItem prop="c68" style="width:60px;">
                  <Input type="text" v-model="formRecord.c68" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span style="color:red">*</span>集热器外形尺寸(长×宽×高)(mm×mm×mm)</td>
              <td>
                <FormItem prop="c58" style="width:60px;">
                  <Input type="text" v-model="formRecord.c58" :disabled='disabledoff'/>
                </FormItem>
                <FormItem><b>×</b></FormItem>
                <FormItem prop="c69" style="width:60px;">
                  <Input type="text" v-model="formRecord.c69" :disabled='disabledoff'/>
                </FormItem>
                <FormItem><b>×</b></FormItem>
                <FormItem prop="c70" style="width:60px;">
                  <Input type="text" v-model="formRecord.c70" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr> -->
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
              <th colspan="2">规格/型号/物料代码</th>
              <th colspan="2">材质</th>
              <th>生产者（全称）</th>
            </tr>
            <tr>
              <td align="center">1</td>
              <td align="center">集热器</td>
              <td colspan="2">
                <FormItem prop="c78" style="width:100%;">
                  <Input type="text" v-model="formRecord.c78" :disabled='disabledoff' />
                </FormItem>
              </td>
              <td colspan="2">
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
              <td align="center">2</td>
              <td align="center">集热器</td>
              <td colspan="2">
                <FormItem prop="c81" style="width:100%;">
                  <Input type="text" v-model="formRecord.c81" :disabled='disabledoff' />
                </FormItem>
              </td>
              <td colspan="2">
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
              <td align="center">3</td>
              <td align="center">保温材料</td>
              <td align="center">厚度</td>
              <td>
                <FormItem prop="c84" style="width:100%;">
                  <Input type="text" v-model="formRecord.c84" :disabled='disabledoff' />
                </FormItem>
              </td>
              <td colspan="2">
                <FormItem prop="c85" style="width:100%;">
                  <Input type="text" v-model="formRecord.c85" :disabled='disabledoff' />
                </FormItem>
              </td>
              <td>
                <FormItem prop="c86" style="width:100%;">
                  <Input type="text" v-model="formRecord.c86" :disabled='disabledoff' />
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center">4</td>
              <td align="center">保温材料</td>
              <td align="center">厚度</td>
              <td>
                <FormItem prop="c87" style="width:100%;">
                  <Input type="text" v-model="formRecord.c87" :disabled='disabledoff' />
                </FormItem>
              </td>
              <td colspan="2">
                <FormItem prop="c88" style="width:100%;">
                  <Input type="text" v-model="formRecord.c88" :disabled='disabledoff' />
                </FormItem>
              </td>
              <td>
                <FormItem prop="c89" style="width:100%;">
                  <Input type="text" v-model="formRecord.c89" :disabled='disabledoff' />
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center" rowspan="2">5</td>
              <td align="center" rowspan="2">水箱</td>
              <td align="center">外壳厚度（mm）</td>
              <td>
                <FormItem prop="c90" style="width:100%;">
                  <Input type="text" v-model="formRecord.c90" :disabled='disabledoff' />
                </FormItem>
              </td>
              <td align="center">水箱外壳</td>
              <td>
                <FormItem prop="c91" style="width:100%;">
                  <Input type="text" v-model="formRecord.c91" :disabled='disabledoff' />
                </FormItem>
              </td>
              <td rowspan="2">
                <FormItem prop="c92" style="width:100%;">
                  <Input type="text" v-model="formRecord.c92" :disabled='disabledoff' />
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center">内胆厚度（mm）</td>
              <td>
                <FormItem prop="c93" style="width:100%;">
                  <Input type="text" v-model="formRecord.c93" :disabled='disabledoff' />
                </FormItem>
              </td>
              <td align="center">水箱内胆</td>
              <td>
                <FormItem prop="c94" style="width:100%;">
                  <Input type="text" v-model="formRecord.c94" :disabled='disabledoff' />
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center" rowspan="2">6</td>
              <td align="center" rowspan="2">水箱</td>
              <td align="center">外壳厚度（mm）</td>
              <td>
                <FormItem prop="c95" style="width:100%;">
                  <Input type="text" v-model="formRecord.c95" :disabled='disabledoff' />
                </FormItem>
              </td>
              <td align="center">水箱外壳</td>
              <td>
                <FormItem prop="c96" style="width:100%;">
                  <Input type="text" v-model="formRecord.c96" :disabled='disabledoff' />
                </FormItem>
              </td>
              <td rowspan="2">
                <FormItem prop="c97" style="width:100%;">
                  <Input type="text" v-model="formRecord.c97" :disabled='disabledoff' />
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center">内胆厚度（mm）</td>
              <td>
                <FormItem prop="c98" style="width:100%;">
                  <Input type="text" v-model="formRecord.c98" :disabled='disabledoff' />
                </FormItem>
              </td>
              <td align="center">水箱内胆</td>
              <td>
                <FormItem prop="c99" style="width:100%;">
                  <Input type="text" v-model="formRecord.c99" :disabled='disabledoff' />
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center" colspan="7">注：如果上述关键零部件/原材料属多个制造商，均应按上述要求逐一填写。</td>
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
          <div class="application" v-if='$store.state.app.pageType'>
            <span><i class="red">*</i>{{$store.state.app.pageType==="extend"?'扩展':'变更'}}申请书</span>
            <Button type="primary" @click="modal5=true">填写{{$store.state.app.pageType==="extend"?'扩展':'变更'}}申请书</Button>
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
                <div>
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
              <td colspan="3" v-if="pltId != 244">
                根据企业提交的相关能效指标，系统直接生成能效表示样本
                <Button type="primary" @click="showTemplate">查看模板</Button>
              </td>
              <td colspan="3" v-else>提交备案后，需企业自行上传能效标识样本</td>
            </tr>
            <tr>
              <td>OEM声明</td>
              <td>(JPG/PNG)</td>
              <td>
                <div class="lookOver" v-show="uploadParam.filePath26">
                  <Button @click="showImg(uploadParam.filePath26)" icon="ios-glasses-outline" type="primary">查看</Button>
                </div>
                <div>
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
              <td>关系证明</td>
              <td>（PDF）</td>
              <td>
                <div class="lookOver" v-show="uploadParam.filePath27">
                  <Button @click="showImg(uploadParam.filePath27)" icon="ios-glasses-outline" type="primary">查看</Button>
                </div>
                <div>
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
                <div>
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
                <div>
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
              <td>进口商企业信息表</td>
              <td>(PDF)</td>
              <td>
                <div class="lookOver" v-show="uploadParam.filePath30">
                  <Button @click="showImg(uploadParam.filePath30)" icon="ios-glasses-outline" type="primary">查看</Button>
                </div>
                <div>
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
              <td>进口商营业执照或登记注册证明复印件</td>
              <td>（PDF）</td>
              <td>
                <div class="lookOver" v-show="uploadParam.filePath31">
                  <Button @click="showImg(uploadParam.filePath31)" icon="ios-glasses-outline" type="primary">查看</Button>
                </div>
                <div>
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
              <td>进口商与境外生产者订立的相关合同副本</td>
              <td>(PDF)</td>
              <td>
                <div class="lookOver" v-show="uploadParam.filePath32">
                  <Button @click="showImg(uploadParam.filePath32)" icon="ios-glasses-outline" type="primary">查看</Button>
                </div>
                <div>
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
                <div>
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
                    <Icon type="ios-checkmark" v-show="checkmark76"/>
                  </Upload>
                </div>
              </td>
            </tr>
          </table>
          <p class="red">注：保存到草稿时，不保存附件！<br/>所有附件上传文件大小需要控制在2M以内。</p>
        </Card>
      </div>
      <div>
        <CheckboxGroup v-model="confirmData">
          <Checkbox label="1"><span style="color:red;font-weight:bold;">我已确认以上数据填写无误！</span></Checkbox>
        </CheckboxGroup>
      </div>
      <div class="tc">
        <Button type="primary" @click="prevStep">上一步</Button>
        <Button type="primary" @click="saveRecord" v-if='!$store.state.app.pageType' :disabled="saveDisabled">保存到草稿</Button>
        <Button type="primary" @click="showConfirm">提交备案审核申请</Button>
      </div>
    </Form>
    <Modal v-model="modal1" title="提交确认" width="960" ok-text="提交备案" cancel-text="再看看" @on-ok="submitRecord">
      <p v-if="boolFlag.length" style="font-size:16px;font-weight: bolder;text-align: center">
        以下是实验室报告带入项数值被修改的地方，请您再次确认！</p>
      <div v-if="boolFlag.length" class="diffList">
        <table>
          <thead>
          <tr>
            <th>名称</th>
            <th>原始值</th>
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
      <p v-if="!boolFlag.length" style="font-size:16px;font-weight: bolder; text-align: center">请再次确认备案信息填写无误！</p>
      <p style="font-size:16px;font-weight: bolder;text-align: center">若确认，请点击“提交备案”按钮</p>
    </Modal>
    <Modal v-model="modal3" :width=820 :footer-hide=true>
      <img :src="templatePic"/>
    </Modal>
    <Modal v-model="modal4" :width=820 :footer-hide=true>
      <img :src="uploadPic"/>
    </Modal>
    <Modal v-model="modal5" class="basic-info" :width=650 ok-text="保存" @on-ok="submitBasic" cancel-text="关闭">
      <h2>标识型号{{$store.state.app.pageType==="extend"?'扩展':'变更'}}备案申请书</h2>
      <p class="org">中国标准化研究院能效标识管理中心：</p>
      <div class="pro-info">
        我 <span class="f-company">{{formRecord.c1}}</span>
        公司生产的 <span class="f-brand">{{formRecord.c5}}</span>
        品牌的 <span class="f-model">{{formRecord.c4}}</span>
        型号的 <span class="f-product">家用电冰箱-2015版</span>产品。
      </div>
      <dl v-if="$store.state.app.pageType==='extend'">
        <dt>
          现提出型号扩展备案申请的 <span class="f-model"></span>
          型号是以上述型号为基础开发扩展的型号：
        </dt>
        <dd>a) 其与基础型号同属一个系列；</dd>
        <dd>b) 其整机结构与基础型号基本相同；</dd>
        <dd>c) 其产品的能效性能与基础型号一致；</dd>
        <dd>d) 其在基础型号上只作如下变更（差异描述）：<br>
          <Input class="valid" v-model="formRecord.ec_master_kuozhan_text" type="textarea"
                 :autosize="{minRows: 2,maxRows: 5}" placeholder="描述"/>
          <span class="textarea-annotation">（注：提供相应证明材料） </span><b class="color-red">（请删除上述描述中多余的空格和空行，否则可能打印不完整。）</b>
        </dd>
        <dd>
          特提出免检备案申请，扩展型号的初始使用日期：
          <span class="f-date">{{formatDate(formRecord[thisDateCV])}}</span>
        </dd>
        <dd>请中国标准化研究院能效标识管理中心核准。</dd>
      </dl>
      <dl v-if="$store.state.app.pageType==='update'">
        <dd>现申请该幸好申请的备案信息如下变更：<br>
          (描述信息产品技术参数等信息)
          <Input class="valid" v-model="formRecord.ec_master_kuozhan_text" type="textarea"
                 :autosize="{minRows: 2,maxRows: 5}" placeholder="描述"/>
          <b class="color-red">（请删除上述描述中多余的空格和空行，否则可能打印不完整。）</b>
        </dd>
        <dd>
          该型号的相关信息变更后的初始使用日期：
          <span class="f-date">{{formatDate(formRecord[thisDateCV])}}</span>
        </dd>
        <dd>请中国标准化研究院能效标识管理中心核准。</dd>
      </dl>
      <div class="record-attached">
        附：{{$store.state.app.pageType==="extend"?'扩展':'变更'}}型号产品的能效标识样本{{$store.state.app.pageType==="extend"?'':'以及检测报告'}}
      </div>
    </Modal>
  </div>
</template>
<script>
import axios from 'axios'
import {
    getImgPath,
    XfillExtendData,
    XfillDraftData,
    XfillDefaultData,
    XhandleFormatError,
    XfileHandleBeforeUpload,
    XshowConfirm,
    diffRecord,
    XsubmitRecord,
    XsaveRecord,
    XformatDate,
    threeDecimals,
    twoDecimals,
    oneDecimals,
    significantDigits22,
    significantDigits33,
    numberCheck
  } from '@/libs/utilExt'
export default {
  data () {
    const timeDate = this.$store.state.app.dateinit
    return {
      // 当前初始使用日期 对应的C值
      thisDateCV: 'c11',
      // 当前能效等级 对应的C值
      thisLevelCV: 'c64',
      modal3: false,
      modal4: false,
      modal5: false,
      templatePic: '',
      disabledoff: true,
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
        c6: '',
        c7: '',
        c8: '',
        c9: '',
        c10: '',
        c11: new Date(),
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
        c73: '',
        c74: '',
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
        c200: '',
        c202: '',
        ec_model_no: 29,
        attach_list: ''
      },
      forbidden: {
        c63: true
      }
    }
  },
  mounted () {
    this.disabledoff = this.$store.state.app.pageType == "extend" ? true : false
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

      //辅助能源类别-其他 启用/禁用
      if (this.formRecord.c12 == '其他') {
          this.forbidden.c63 = false
      } else {
          this.formRecord.c63 = ''
          this.forbidden.c63 = true
      }

      return {
        c3: [
          {
            required: true,
            message: '请输入制造单位'
          }
        ],
        c59: [
          {
            required: true,
            message: '请输入备案方'
          }
        ],
        c2: [
          {
            required: true,
            message: '请输入产品规格型号'
          }
        ],
        c4: [
          {
            required: true,
            message: '请输入商标'
          }
        ],
        c200: [
          {
            required: true,
            message: '请输入依据国家标准'
          }
        ],
        c64: [
          {
            required: true,
            message: '请选择能效等级'
          }
        ],
        c5: [
          {
            required: true,
            message: '请输入'
          },
          {
            validator: twoDecimals,
            trigger: 'blur'
          }
        ],
        c6: [
          {
            required: true,
            message: '请输入'
          },
          {
            validator: twoDecimals,
            trigger: 'blur'
          }
        ],
        c7: [
          {
            required: true,
            message: '请输入'
          },
          {
            validator: oneDecimals,
            trigger: 'blur'
          }
        ],
        c8: [
          {
            required: true,
            message: '请输入'
          },
          {
            validator: oneDecimals,
            trigger: 'blur'
          }
        ],
        c9: [
          {
            required: true,
            message: '请输入'
          }
        ],
        c10: [
          {
            required: true,
            message: '请输入'
          }
        ],
        c11: [
          {
            required: true,
            message: '请输入备案起始日期'
          }
        ],
        c12: [
          {
            required: true,
            message: '请选择'
          }
        ],
        c63: [
          {
              required: this.formRecord.c12 === '其他',
              message: '其他不能为空'
          }
        ],
        c13: [
          {
            required: true,
            message: '请选择'
          }
        ],
        c14: [
          {
            required: true,
            message: '请选择'
          }
        ],
        c15: [
          {
            required: true,
            message: '请输入'
          },
          {
            validator: twoDecimals,
            trigger: 'blur'
          }
        ],
        c16: [
          {
            required: true,
            message: '请选择'
          }
        ],
        c17: [
          {
            required: true,
            message: '请输入'
          }
        ],
        c18: [
          {
            required: true,
            message: '请选择'
          }
        ],
        c19: [
          {
            required: true,
            message: '请输入'
          }
        ],
        c20: [
          {
            required: true,
            message: '请输入'
          },
          {
            validator: oneDecimals,
            trigger: 'blur'
          }
        ],
        c21: [
          {
            required: true,
            message: '请输入'
          }
        ],
        c22: [
          {
            required: true,
            message: '请输入'
          }
        ],
        c23: [
          {
            required: true,
            message: '请选择'
          }
        ],
        c24: [
          {
            required: true,
            message: '请输入'
          }
        ],
        c25: [
          {
            required: true,
            message: '请输入'
          }
        ],
        c26: [
          {
            required: true,
            message: '请选择'
          }
        ],
        c27: [
          {
            required: true,
            message: '请输入'
          }
        ],
        c28: [
          {
            required: true,
            message: '请选择'
          }
        ],
        c29: [
          {
            required: true,
            message: '请输入'
          }
        ],
        c30: [
          {
            required: true,
            message: '请输入'
          }
        ],
        c31: [
          {
            required: true,
            message: '请选择'
          }
        ],
        c32: [
          {
            required: true,
            message: '请输入'
          }
        ],
        c33: [
          {
            required: true,
            message: '请选择'
          }
        ],
        c34: [
          {
            required: true,
            message: '请输入'
          }
        ],
        c35: [
          {
            required: true,
            message: '请选择'
          }
        ],
        c36: [
          {
            required: true,
            message: '请输入'
          }
        ],
        c37: [
          {
            required: true,
            message: '请选择'
          }
        ],
        c38: [
          {
            required: true,
            message: '请输入'
          }
        ],
        c39: [
          {
            required: true,
            message: '请输入'
          }
        ],
        c73: [
          {
            required: true,
            message: '请输入'
          }
        ],
        c74: [
          {
            required: true,
            message: '请输入'
          }
        ],
        c40: [
          {
            required: true,
            message: '请输入'
          }
        ],
        c76: [
          {
            required: true,
            message: '请输入'
          }
        ],
        c77: [
          {
            required: true,
            message: '请输入'
          }
        ],
        c41: [
          {
            required: true,
            message: '请输入'
          },
          {
            validator: threeDecimals,
            trigger: 'blur'
          }
        ],
        c45: [
          {
            required: true,
            message: '请输入'
          },
          {
            validator: twoDecimals,
            trigger: 'blur'
          }
        ],
        c42: [
          {
            required: true,
            message: '请选择'
          }
        ],
        c43: [
          {
            required: true,
            message: '请输入'
          }
        ],
        c44: [
          {
            required: true,
            message: '请选择'
          }
        ],
        c45: [
          {
            required: true,
            message: '请输入'
          }
        ],
        c46: [
          {
            required: true,
            message: '请选择'
          }
        ],
        c47: [
          {
            required: true,
            message: '请输入'
          }
        ],
        c48: [
          {
            required: true,
            message: '请选择'
          }
        ],
        c49: [
          {
            required: true,
            message: '请输入'
          }
        ],
        c50: [
          {
            required: true,
            message: '请选择'
          }
        ],
        c51: [
          {
            required: true,
            message: '请输入'
          }
        ],
        c54: [
          {
            required: true,
            message: '请输入'
          }
        ],
        c55: [
          {
            required: true,
            message: '请输入'
          }
        ],
        c53: [
          {
            required: true,
            message: '请选择'
          }
        ],
        c71: [
          {
            required: true,
            message: '请选择'
          }
        ],
        c56: [
          {
            required: true,
            message: '请输入'
          }
        ],
        c57: [
          {
            required: true,
            message: '请输入'
          }
        ],
        c58: [
          {
            required: true,
            message: '请输入'
          }
        ],
        c65: [
          {
            required: true,
            message: '请输入'
          }
        ],
        c66: [
          {
            required: true,
            message: '请输入'
          }
        ],
        c67: [
          {
            required: true,
            message: '请输入'
          }
        ],
        c68: [
          {
            required: true,
            message: '请输入'
          }
        ],
        c69: [
          {
            required: true,
            message: '请输入'
          }
        ],
        c52: [
          {
            required: true,
            message: '请输入'
          }
        ],
        c70: [
          {
            required: true,
            message: '请输入'
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
        c80: [
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
        c86: [
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
        c92: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c93: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c94: [
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
<style>
@import '../../../css/comm.css';
</style>
<style lang="less" scoped>

</style>
