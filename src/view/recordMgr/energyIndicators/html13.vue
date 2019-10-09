<!--9、储水式电热水器 2008版-->
<!--创建日期:2019年5月27日-->
<!--创建人:YCL-->
<template>
  <div class="wrapper">
    <Form ref="formRecord" :model="formRecord" label-position="right" :rules="ruleRecord">
      <h1>储水式电热水器-能源效率标识备案表</h1>
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
            <Input type="text" v-model="formRecord.c3" placeholder="制造单位" :disabled='disabledoff'/>
          </FormItem>
          <FormItem prop="c22" label="备案方" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c22" placeholder="备案方" :disabled='disabledoff'/>
          </FormItem>
          <FormItem prop="c4" label="产品规格型号" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c4" placeholder="规格型号" :disabled='!disabledoff'/>
          </FormItem>
          <FormItem prop="c2" label="商标" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c2" placeholder="商标" :disabled='pageType=="view"'/>
          </FormItem>
          <FormItem prop="c200" label="依据国家标准" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c200" placeholder="依据国家标准" disabled/>
          </FormItem>
          <FormItem prop="c7" label="能效等级" style="width:100%;" :label-width="180">
            <RadioGroup v-model="formRecord.c7">
              <Radio label="1" :disabled='disabledoff'>1级</Radio>
              <Radio label="2" :disabled='disabledoff'>2级</Radio>
              <Radio label="3" :disabled='disabledoff'>3级</Radio>
              <Radio label="4" :disabled='disabledoff'>4级</Radio>
              <Radio label="5" :disabled='disabledoff'>5级</Radio>
            </RadioGroup>
          </FormItem>
          <table id="table1">
            <tr>
              <th>项目</th>
              <th><i class="red">*</i>标注值</th>
              <th><i class="red">*</i>实测值</th>
              <th>备注</th>
            </tr>
            <tr>
              <td>24h固有能耗系数（ε）</td>
              <td>
                <FormItem prop="c5">
                  <Input type="text" v-model="formRecord.c5" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c23">
                  <Input type="text" v-model="formRecord.c23" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c24">
                  <Input type="text" v-model="formRecord.c24" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>热水输出率（μ）</td>
              <td>
                <FormItem prop="c6">
                  <Input type="text" v-model="formRecord.c6" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c25">
                  <Input type="text" v-model="formRecord.c25" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c26">
                  <Input type="text" v-model="formRecord.c26" :disabled='disabledoff'/>
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
          <FormItem prop="c8" label="备案标识开始使用日期" style="width:100%;">
            <DatePicker type="date" :options="dataInit" style="width: 200px" v-model="formRecord.c8"></DatePicker>
          </FormItem>
        </Card>
      </div>
      <div class="part part5">
        <Card :bordered="false">
          <h2>五、样品描述</h2>
          <table id="table3">
            <tr>
              <td><i class="red">*</i>电源类型</td>
              <td>
                <FormItem prop="c9">
                  <RadioGroup v-model="formRecord.c9">
                    <Radio label="AC" :disabled='disabledoff'>AC</Radio>
                    <Radio label="DC" :disabled='disabledoff'>DC</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td><i class="red">*</i>电源性质</td>
              <td>
                <FormItem prop="c10">
                  <RadioGroup v-model="formRecord.c10">
                    <Radio label="单相" :disabled='disabledoff'>单相</Radio>
                    <Radio label="三相" :disabled='disabledoff'>三相</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td><i class="red">*</i>结构形式</td>
              <td colspan="3">
                <FormItem prop="c11">
                  <RadioGroup v-model="formRecord.c11">
                    <Radio label="封闭式" :disabled='disabledoff'>封闭式</Radio>
                    <Radio label="出口敞开式" :disabled='disabledoff'>出口敞开式</Radio>
                    <Radio label="水槽供水式" :disabled='disabledoff'>水槽供水式</Radio>
                    <Radio label="水箱式" :disabled='disabledoff'>水箱式</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td><i class="red">*</i>安装使用形式</td>
              <td colspan="3">
                <FormItem prop="c12">
                  <RadioGroup v-model="formRecord.c12">
                    <Radio label="立式" :disabled='disabledoff'>立式</Radio>
                    <Radio label="卧式" :disabled='disabledoff'>卧式</Radio>
                  </RadioGroup>
                </FormItem>
                <br/>
                <FormItem prop="c40">
                  <RadioGroup v-model="formRecord.c40">
                    <Radio label="壁挂式" :disabled='disabledoff'>壁挂式</Radio>
                    <Radio label="落地式" :disabled='disabledoff'>落地式</Radio>
                    <Radio label="其它" :disabled='disabledoff'>其它</Radio>
                  </RadioGroup>
                </FormItem>
                <FormItem prop="c13">
                  <Input type="text" v-model="formRecord.c13" :disabled='disabledoff || forbidden.c13'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td><i class="red">*</i>加热方式</td>
              <td colspan="3">
                <FormItem prop="c14">
                  <RadioGroup v-model="formRecord.c14">
                    <Radio label="电热管加热" :disabled='disabledoff'>电热管加热</Radio>
                    <Radio label="电磁加热" :disabled='disabledoff'>电磁加热</Radio>
                    <Radio label="其它" :disabled='disabledoff'>其它</Radio>
                  </RadioGroup>
                </FormItem>
                <FormItem prop="c15">
                  <Input type="text" v-model="formRecord.c15" :disabled='disabledoff || forbidden.c15'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td><i class="red">*</i>电热元件</td>
              <td colspan="3">
                <FormItem prop="c16">
                  <RadioGroup v-model="formRecord.c16">
                    <Radio label="仅有一个电热元件" :disabled='disabledoff'>仅有一个电热元件</Radio>
                    <Radio label="有两个或两个以上的电热元件" :disabled='disabledoff'>有两个或两个以上的电热元件</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td rowspan="4"><i class="red">*</i>控制及保护装置</td>
              <td colspan="3">
                <FormItem prop="c17">
                  <CheckboxGroup v-model="formRecord.c17">
                    <Checkbox label="带有开关" :disabled='disabledoff'>带有开关</Checkbox>
                    <FormItem prop="c33">
                      <RadioGroup v-model="formRecord.c33">
                        <Radio label="机械开关" :disabled='disabledoff || forbidden.c33'>机械开关</Radio>
                        <Radio label="电子开关" :disabled='disabledoff || forbidden.c33'>电子开关</Radio>
                      </RadioGroup>
                    </FormItem>
                  </CheckboxGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td colspan="3">
                <FormItem prop="c17">
                  <CheckboxGroup v-model="formRecord.c17">
                    <FormItem prop="c34">
                      <RadioGroup v-model="formRecord.c34">
                        <Checkbox label="带有温控器" :disabled='disabledoff'>带有温控器</Checkbox>
                        <Radio label="机械式温控器" :disabled='disabledoff || forbidden.c34'>机械式温控器</Radio>
                        <Radio label="电子式温控器" :disabled='disabledoff || forbidden.c34'>电子式温控器</Radio>
                      </RadioGroup>
                    </FormItem>
                  </CheckboxGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td colspan="3">
                <FormItem prop="c17">
                  <CheckboxGroup v-model="formRecord.c17">
                    <Checkbox label="带有热断路器" :disabled='disabledoff'>带有热断路器</Checkbox>
                  </CheckboxGroup>
                </FormItem>
                <FormItem prop="c35">
                  <CheckboxGroup v-model="formRecord.c35">
                    <Checkbox label="自复位型" :disabled='disabledoff || forbidden.c35'>自复位型</Checkbox>
                    <Checkbox label="非自复位型" :disabled='disabledoff || forbidden.c35'>非自复位型</Checkbox>
                    <Checkbox label="双极断开型" :disabled='disabledoff || forbidden.c35'>双极断开型</Checkbox>
                  </CheckboxGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td colspan="3">
                <FormItem prop="c17">
                  <CheckboxGroup v-model="formRecord.c17">
                    <Checkbox label="带有热熔断器" :disabled='disabledoff'>带有热熔断器</Checkbox>
                    <Checkbox label="带有漏电保护器" :disabled='disabledoff'>带有漏电保护器</Checkbox>
                    <Checkbox label="带有压力释放装置" :disabled='disabledoff'>带有压力释放装置</Checkbox>
                  </CheckboxGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td><i class="red">*</i>控制方式</td>
              <td colspan="3">
                <FormItem prop="c18">
                  <CheckboxGroup v-model="formRecord.c18">
                    <Checkbox label="使用电源软线" :disabled='disabledoff'>使用电源软线</Checkbox>
                    <Checkbox label="软线上带有不可重接插头" :disabled='disabledoff'>软线上带有不可重接插头</Checkbox>
                    <Checkbox label="提供电源引线" :disabled='disabledoff'>提供电源引线</Checkbox>
                    <Checkbox label="提供接线端子" :disabled='disabledoff'>提供接线端子</Checkbox>
                  </CheckboxGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td rowspan="4"><i class="red">*</i>主体结构</td>
              <td colspan="3">
                <FormItem prop="c37">
                  <label style="margin: 25px;font-size: 14px!important;">外壳:</label>
                  <RadioGroup v-model="formRecord.c37">
                    <Radio label="金属外壳(两端部为非金属材料)" :disabled='disabledoff'>金属外壳(两端部为非金属材料)</Radio>
                    <Radio label="非金属外壳" :disabled='disabledoff'>非金属外壳</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td colspan="3">
                <FormItem prop="c38">
                  <label style="margin: 25px;font-size: 14px!important;">内胆形状:</label>
                  <RadioGroup v-model="formRecord.c38">
                    <Radio label="圆形内胆" :disabled='disabledoff'>圆形内胆</Radio>
                    <Radio label="非圆形内胆" :disabled='disabledoff'>非圆形内胆</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td colspan="3">
                <FormItem prop="c39">
                  <label style="margin: 25px;font-size: 14px!important;">内胆材质:</label>
                  <RadioGroup v-model="formRecord.c39">
                    <Radio label="搪瓷内胆" :disabled='disabledoff'>搪瓷内胆</Radio>
                    <Radio label="不锈钢内胆" :disabled='disabledoff'>不锈钢内胆</Radio>
                    <Radio label="其它内胆" :disabled='disabledoff'>其它内胆</Radio>
                  </RadioGroup>
                </FormItem>
                <FormItem prop="c20">
                  <Input type="text" v-model="formRecord.c20" :disabled='disabledoff || forbidden.c20'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td colspan="3">
                <FormItem prop="c19">
                  <CheckboxGroup v-model="formRecord.c19">
                    <Checkbox label="带有阳极保护材料" :disabled='disabledoff'>带有阳极保护材料</Checkbox>
                    <Checkbox label="整体发泡层" :disabled='disabledoff'>整体发泡层</Checkbox>
                    <Checkbox label="预制保温层" :disabled='disabledoff'>预制保温层</Checkbox>
                  </CheckboxGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td><i class="red">*</i>外形尺寸（长×宽×高）（mm×mm×mm）</td>
              <td colspan="3">
                <FormItem prop="c21">
                  <Input type="text" v-model="formRecord.c21" :disabled='disabledoff'/>
                </FormItem>
                <FormItem><b>×</b></FormItem>
                <FormItem prop="c27">
                  <Input type="text" v-model="formRecord.c27" :disabled='disabledoff'/>
                </FormItem>
                <FormItem><b>×</b></FormItem>
                <FormItem prop="c28">
                  <Input type="text" v-model="formRecord.c28" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td><i class="red">*</i>额定容量（L）</td>
              <td>
                <FormItem prop="c29">
                  <Input type="text" v-model="formRecord.c29" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td><i class="red">*</i>额定电压（V）</td>
              <td>
                <FormItem prop="c30">
                  <Input type="text" v-model="formRecord.c30" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td><i class="red">*</i>额定功率（W）</td>
              <td>
                <FormItem prop="c31">
                  <Input type="text" v-model="formRecord.c31" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td><i class="red">*</i>额定压力（MPa）</td>
              <td>
                <FormItem prop="c32">
                  <Input type="text" v-model="formRecord.c32" :disabled='disabledoff'/>
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
              <th>序号</th>
              <th>名称</th>
              <th colspan="2">规格/型号/物料代码</th>
              <th colspan="2">技术参数</th>
              <th>生产者（全称）</th>
            </tr>
            <tr>
              <td rowspan="2">1</td>
              <td rowspan="2">
                电热管(电热元件)
              </td>
              <td colspan="2">
                <FormItem prop="c41" width="250">
                  <Input type="text" v-model="formRecord.c41" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>电压(V)</td>
              <td>
                <FormItem prop="c42">
                  <Input type="text" v-model="formRecord.c42" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td rowspan="2">
                <FormItem prop="c43" width="250">
                  <Input type="text" v-model="formRecord.c43" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td colspan="2">
                <FormItem prop="c44" width="250">
                  <Input type="text" v-model="formRecord.c44" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>功率(W)</td>
              <td>
                <FormItem prop="c45">
                  <Input type="text" v-model="formRecord.c45" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td rowspan="2">2</td>
              <td rowspan="2">
                电热管(电热元件)
              </td>
              <td colspan="2">
                <FormItem prop="c46">
                  <Input type="text" v-model="formRecord.c46" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>电压(V)</td>
              <td>
                <FormItem prop="c47">
                  <Input type="text" v-model="formRecord.c47" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td rowspan="2">
                <FormItem prop="c48">
                  <Input type="text" v-model="formRecord.c48" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td colspan="2">
                <FormItem prop="c49">
                  <Input type="text" v-model="formRecord.c49" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>功率(W)</td>
              <td>
                <FormItem prop="c50">
                  <Input type="text" v-model="formRecord.c50" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td rowspan="2">3</td>
              <td rowspan="2">
                电热管(电热元件)
              </td>
              <td colspan="2">
                <FormItem prop="c51">
                  <Input type="text" v-model="formRecord.c51" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>电压(V)</td>
              <td>
                <FormItem prop="c52">
                  <Input type="text" v-model="formRecord.c52" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td rowspan="2">
                <FormItem prop="c53">
                  <Input type="text" v-model="formRecord.c53" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td colspan="2">
                <FormItem prop="c54">
                  <Input type="text" v-model="formRecord.c54" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>功率(W)</td>
              <td>
                <FormItem prop="c55">
                  <Input type="text" v-model="formRecord.c55" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>4</td>
              <td>
                温控器(机械式)
              </td>
              <td colspan="4">
                <FormItem prop="c56">
                  <Input type="text" style="width:450px" v-model="formRecord.c56" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c57">
                  <Input type="text" v-model="formRecord.c57" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>5</td>
              <td>
                温控器(机械式)
              </td>
              <td colspan="4">
                <FormItem prop="c58">
                  <Input type="text" style="width:450px" v-model="formRecord.c58" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c59">
                  <Input type="text" v-model="formRecord.c59" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>6</td>
              <td>
                温控器(机械式)
              </td>
              <td colspan="4">
                <FormItem prop="c60">
                  <Input type="text" style="width:450px" v-model="formRecord.c60" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c61">
                  <Input type="text" v-model="formRecord.c61" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>7</td>
              <td>
                控温电路板(电子式)
              </td>
              <td colspan="4">
                <FormItem prop="c62">
                  <Input type="text" style="width:450px" v-model="formRecord.c62" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c63">
                  <Input type="text" v-model="formRecord.c63" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>8</td>
              <td>
                控温电路板(电子式)
              </td>
              <td colspan="4">
                <FormItem prop="c64">
                  <Input type="text" style="width:450px" v-model="formRecord.c64" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c65">
                  <Input type="text" v-model="formRecord.c65" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>9</td>
              <td>
                控温电路板(电子式)
              </td>
              <td colspan="4">
                <FormItem prop="c66">
                  <Input type="text" style="width:450px" v-model="formRecord.c66" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c67">
                  <Input type="text" v-model="formRecord.c67" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>10</td>
              <td>
                内胆
              </td>
              <td colspan="2">
                <FormItem prop="c68">
                  <Input type="text" v-model="formRecord.c68" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>材质</td>
              <td>
                <FormItem prop="c69">
                  <Input type="text" v-model="formRecord.c69" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c70">
                  <Input type="text" v-model="formRecord.c70" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>11</td>
              <td>
                内胆
              </td>
              <td colspan="2">
                <FormItem prop="c71">
                  <Input type="text" v-model="formRecord.c71" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>材质</td>
              <td>
                <FormItem prop="c72">
                  <Input type="text" v-model="formRecord.c72" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c73">
                  <Input type="text" v-model="formRecord.c73" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>12</td>
              <td>
                内胆
              </td>
              <td colspan="2">
                <FormItem prop="c74">
                  <Input type="text" v-model="formRecord.c74" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>材质</td>
              <td>
                <FormItem prop="c75">
                  <Input type="text" v-model="formRecord.c75" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c76">
                  <Input type="text" v-model="formRecord.c76" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>13</td>
              <td>
                外壳
              </td>
              <td colspan="2">
                <FormItem prop="c77">
                  <Input type="text" v-model="formRecord.c77" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>材质</td>
              <td>
                <FormItem prop="c78">
                  <Input type="text" v-model="formRecord.c78" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c79">
                  <Input type="text" v-model="formRecord.c79" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>14</td>
              <td>
                外壳
              </td>
              <td colspan="2">
                <FormItem prop="c80">
                  <Input type="text" v-model="formRecord.c80" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>材质</td>
              <td>
                <FormItem prop="c81">
                  <Input type="text" v-model="formRecord.c81" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c82">
                  <Input type="text" v-model="formRecord.c82" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>15</td>
              <td>
                外壳
              </td>
              <td colspan="2">
                <FormItem prop="c83">
                  <Input type="text" v-model="formRecord.c83" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>材质</td>
              <td>
                <FormItem prop="c84">
                  <Input type="text" v-model="formRecord.c84" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c85">
                  <Input type="text" v-model="formRecord.c85" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>16</td>
              <td>
                保温及隔热材料
              </td>
              <td width="70">材质</td>
              <td>
                <FormItem prop="c86">
                  <Input type="text" v-model="formRecord.c86" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>厚度</td>
              <td>
                <FormItem prop="c87">
                  <Input type="text" v-model="formRecord.c87" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c88">
                  <Input type="text" v-model="formRecord.c88" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>17</td>
              <td>
                保温及隔热材料
              </td>
              <td width="70">材质</td>
              <td>
                <FormItem prop="c89">
                  <Input type="text" v-model="formRecord.c89" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>厚度</td>
              <td>
                <FormItem prop="c90">
                  <Input type="text" v-model="formRecord.c90" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c91">
                  <Input type="text" v-model="formRecord.c91" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>18</td>
              <td>
                保温及隔热材料
              </td>
              <td width="70">材质</td>
              <td>
                <FormItem prop="c92">
                  <Input type="text" v-model="formRecord.c92" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>厚度</td>
              <td>
                <FormItem prop="c93">
                  <Input type="text" v-model="formRecord.c93" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c94">
                  <Input type="text" v-model="formRecord.c94" :disabled='disabledoff'/>
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
          品牌的 <span  class="f-model">{{pageType==='extend'?mainModel:formRecord.c4}}</span>
          型号的 <span  class="f-product">储水式电热水器 2008版</span>产品{{pageType==="update"?'已通过能效标识备案':''}}。
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
    check,
    numberCheck
  } from '@/libs/utilExt'

  export default {
    data() {
      const timeDate = parseInt(this.$store.state.app.dateinit);
      return {
        // 当前初始使用日期 对应的C值
        thisDateCV: "c8",
        // 当前能效等级 对应的C值
        thisLevelCV: "c7",
        // 当前规格型号 对应的C值
        thisGZXHCV: "c4",
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
          c8: new Date(),
          c9: '',
          c10: '',
          c12: '',
          c13: '',
          c14: '',
          c15: '',
          c16: '',
          c17: [],
          c18: [],
          c19: [],
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
          c35: [],
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
          c90: '',
          c91: '',
          c92: '',
          c93: '',
          c94: '',
          c200: '',
          c202: '',
          ec_model_no: 13,
          attach_list: ''
        },
        forbidden: {
          c13: true,
          c15: true,
          c20: true,
          c33: true,
          c34: true,
          c35: true
        },
        click_c35: [],
        extendRule: {
          c4: [
            {
              trigger: 'change,blur',
              required: true,
              message: '产品规格型号不能为空'
            },
            {
              validator: (rule, value, callback) => {
                this.mainModel === value ? callback('扩展备案需要变更型号名称') : callback()
              },
              trigger: 'change,blur'
            }
          ]
        }
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
        if (this.formRecord.c40 === '其它') {
          this.forbidden.c13 = false
        } else {
          this.formRecord.c13 = ''
          this.forbidden.c13 = true
        }

        if (this.formRecord.c14 === '其它') {
          this.forbidden.c15 = false
        } else {
          this.formRecord.c15 = ''
          this.forbidden.c15 = true
        }

        if (this.formRecord.c39 === '其它内胆') {
          this.forbidden.c20 = false
        } else {
          this.formRecord.c20 = ''
          this.forbidden.c20 = true
        }

        if (this.formRecord.c17.join('').indexOf('带有开关') > -1) {
          this.forbidden.c33 = false
        } else {
          this.formRecord.c33 = ''
          this.forbidden.c33 = true
        }

        if (this.formRecord.c17.join('').indexOf('带有温控器') > -1) {
          this.forbidden.c34 = false
        } else {
          this.formRecord.c34 = ''
          this.forbidden.c34 = true
        }
        if (this.formRecord.c17.join('').indexOf('带有热断路器') > -1) {
          this.forbidden.c35 = false
        } else {
          this.formRecord.c35 = []
          this.forbidden.c35 = true
        }

        let c35 = this.formRecord.c35.filter(item => !this.click_c35.includes(item)).join('')
        if (c35 === '自复位型') {
          this.formRecord.c35 = this.formRecord.c35.filter(item => item !== '非自复位型')
        } else if (c35 === '非自复位型') {
          this.formRecord.c35 = this.formRecord.c35.filter(item => item !== '自复位型')
        }
        this.click_c35 = this.formRecord.c35

        //提交前数据规则验证
        var gynhxs = parseFloat(this.formRecord.c5);   //24小时固有能耗系数
        var rsscl = parseFloat(this.formRecord.c6);			//热水输出率
        var nxdj = "";            //结果能效等级
        var nxdjch = this.formRecord.c7   //能耗等级
        //1、24h固有能耗系数（实测值）小于等于24h固有能耗系数（标准规定值）
        const checkc23 = (rule, value, callback) => {
          if (this.formRecord.c23 != "") {
            if (parseFloat(this.formRecord.c23) > gynhxs) {
              callback("24h固有能耗系数（实测值）应小于等于24h固有能耗系数（标准规定值）！")
            } else {
              callback()
            }
          }
        }

        //2、热水输出率（实测值）大于等于热水输出率（标准规定值）
        const checkc25 = (rule, value, callback) => {
          if (this.formRecord.c25 != "") {
            if (parseFloat(this.formRecord.c25) < rsscl) {
              callback("热水输出率（实测值）应大于等于热水输出率（标准规定值）！")
            } else {
              callback()
            }
          }
        }

        const checkc7a = (rule, value, callback) => {
          if (gynhxs > 1 || rsscl < 50) {
            callback("能效数据不在备案范围")
          } else {
            callback()
          }
        }

        if (gynhxs <= 0.6 && rsscl >= 70) {
          nxdj = "1";
        } else if (gynhxs <= 0.7 && rsscl >= 60) {
          nxdj = "2";
        } else if (gynhxs <= 0.8 && rsscl >= 55) {
          nxdj = "3";
        } else if (gynhxs <= 0.9 && rsscl >= 55) {
          nxdj = "4";
        } else if (gynhxs <= 1.0 && rsscl >= 50) {
          nxdj = "5";
        }
        const checkc7b = (rule, value, callback) => {
          if (nxdj == "") {
            callback("能效数据不在备案范围")
          } else {
            callback()
          }
        }

        const checkc7c = (rule, value, callback) => {
          if (nxdj != nxdjch) {
            callback("所选能效等级与计算结果不符")
          } else {
            callback()
          }
        }
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
        }else{
          return {
            c1: [
              {
                required: true,
                message: '生产者名称不能为空',
                trigger: 'change,blur'
              }
            ],
            c3: [
              {
                required: true,
                message: '制造单位不能为空',
                trigger: 'change,blur'
              }
            ],
            c22: [
              {
                required: true,
                message: '备案方不能为空',
                trigger: 'change,blur'
              }
            ],
            c4: [
              {
                required: true,
                message: '产品规格型号不能为空',
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
            c200: [
              {
                required: true,
                message: '依据国家标准字段不能为空',
                trigger: 'change,blur'
              }
            ],
            c7: [
              {
                required: true,
                message: '能效等级不能为空',
                trigger: 'change,blur'
              },
              {
                validator: checkc7a,
                trigger: 'change,blur'
              },
              {
                validator: checkc7b,
                trigger: 'change,blur'
              },
              {
                validator: checkc7c,
                trigger: 'change,blur'
              }
            ],
            c5: [
              {
                required: true,
                message: '标注值不能为空',
                trigger: 'change,blur'
              },
              {
                validator: oneDecimals,
                trigger: 'change,blur'
              }
            ],
            c23: [
              {
                required: true,
                message: '实测值不能为空',
                trigger: 'change,blur'
              },
              {
                validator: isNumber,
                trigger: 'change,blur'
              },
              {
                validator: checkc23,
                trigger: 'change,blur'
              }
            ],
            c6: [
              {
                required: true,
                message: '标注值不能为空',
                trigger: 'change,blur'
              },
              {
                validator: numberCheck,
                trigger: 'change,blur'
              }
            ],
            c25: [
              {
                required: true,
                message: '实测值不能为空',
                trigger: 'change,blur'
              },
              {
                validator: isNumber,
                trigger: 'change,blur'
              },
              {
                validator: checkc25,
                trigger: 'change,blur'
              }
            ],
            c8: [
              {
                required: true,
                message: '备案标识开始使用日期不能为空'
              }
            ],
            c9: [
              {
                required: true,
                message: '电源类型不能为空',
                trigger: 'change,blur'
              }
            ],
            c10: [
              {
                required: true,
                message: '电源性质不能为空',
                trigger: 'change,blur'
              }
            ],
            c11: [
              {
                required: true,
                message: '结构形式不能为空',
                trigger: 'change,blur'
              }
            ],
            c12: [
              {
                required: true,
                message: '安装使用形式1不能为空',
                trigger: 'change,blur'
              }
            ],
            c40: [
              {
                required: true,
                message: '安装使用形式2不能为空',
                trigger: 'change,blur'
              }
            ],
            c13: [
              {
                required: this.formRecord.c40 === '其它',
                message: '其它不能为空',
                trigger: 'change,blur'
              }
            ],
            c14: [
              {
                required: true,
                message: '加热方式不能为空',
                trigger: 'change,blur'
              }
            ],
            c15: [
              {
                required: this.formRecord.c14 === '其它',
                message: '其它不能为空',
                trigger: 'change,blur'
              }
            ],
            c16: [
              {
                required: true,
                message: '电热元件不能为空',
                trigger: 'change,blur'
              }
            ],
            c33: [
              {
                required: this.formRecord.c17.join('').indexOf('带有开关') > -1,
                message: '带有开关不能为空',
              }
            ],
            c34: [
              {
                required: this.formRecord.c17.join('').indexOf('带有温控器') > -1,
                message: '带有温控器不能为空',
                trigger: 'change,blur'
              }
            ],
            c35: [
              {
                required: this.formRecord.c17.join('').indexOf('带有热断路器') > -1,
                message: '带有热断路器不能为空',
              }
            ],
            c17: [
              {
                required: true,
                message: '控制及保护装置不能为空',
              }
            ],
            c18: [
              {
                required: true,
                message: '控制方式不能为空',
              }
            ],
            c37: [
              {
                required: true,
                message: '主体结构-外壳不能为空',
                trigger: 'change,blur'
              }
            ],
            c38: [
              {
                required: true,
                message: '内胆形状不能为空',
                trigger: 'change,blur'
              }
            ],
            c39: [
              {
                required: true,
                message: '内胆材质不能为空',
                trigger: 'change,blur'
              }
            ],
            c21: [
              {
                required: true,
                message: '长不能为空',
                trigger: 'change,blur'
              }
            ],
            c27: [
              {
                required: true,
                message: '宽不能为空',
                trigger: 'change,blur'
              }
            ],
            c28: [
              {
                required: true,
                message: '高不能为空',
                trigger: 'change,blur'
              }
            ],
            c29: [
              {
                required: true,
                message: '额定容量不能为空',
                trigger: 'change,blur'
              }
            ],
            c30: [
              {
                required: true,
                message: '额定电压不能为空',
                trigger: 'change,blur'
              }
            ],
            c31: [
              {
                required: true,
                message: '额定功率不能为空',
                trigger: 'change,blur'
              }
            ],
            c32: [
              {
                required: true,
                message: '额定压力不能为空',
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
            c43: [
              {
                required: true,
                message: '不能为空',
                trigger: 'change,blur'
              }
            ],
            c44: [
              {
                required: true,
                message: '不能为空',
                trigger: 'change,blur'
              }
            ],
            c45: [
              {
                required: true,
                message: '不能为空',
                trigger: 'change,blur'
              }
            ],
            c56: [
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
            c62: [
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
            c68: [
              {
                required: true,
                message: '不能为空',
                trigger: 'change,blur'
              }
            ],
            c69: [
              {
                required: true,
                message: '不能为空',
                trigger: 'change,blur'
              }
            ],
            c70: [
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
            c78: [
              {
                required: true,
                message: '不能为空',
                trigger: 'change,blur'
              }
            ],
            c79: [
              {
                required: true,
                message: '不能为空',
                trigger: 'change,blur'
              }
            ],
            c86: [
              {
                required: true,
                message: '不能为空',
                trigger: 'change,blur'
              }
            ],
            c87: [
              {
                required: true,
                message: '不能为空',
                trigger: 'change,blur'
              }
            ],
            c88: [
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
