<!--平板电视 2013版->
<!--创建日期:2019年6月18日-->
<!--创建人:YCL-->
<template>
  <div class="wrapper">
    <Form ref="formRecord" :model="formRecord" label-position="right" :rules="ruleRecord">
      <h1>平板电视-能源效率标识备案表</h1>
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
          <FormItem prop="c2" label="制造单位" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c2" placeholder="制造单位" :disabled='disabledoff'/>
          </FormItem>
          <FormItem prop="c29" label="备案方" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c29" placeholder="备案方" :disabled='disabledoff'/>
          </FormItem>
          <FormItem prop="c3" label="产品规格型号" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c3" placeholder="规格型号" :disabled='!disabledoff'/>
          </FormItem>
          <FormItem prop="c4" label="商标" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c4" placeholder="商标" :disabled='pageType=="view"'/>
          </FormItem>
          <FormItem prop="c200" label="依据国家标准" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c200" placeholder="依据国家标准" readonly disabled/>
          </FormItem>
          <FormItem prop="c31" label="能效等级" style="width:100%;" :label-width="180">
            <RadioGroup v-model="formRecord.c31">
              <Radio label="1" :disabled='disabledoff'>1级</Radio>
              <Radio label="2" :disabled='disabledoff'>2级</Radio>
              <Radio label="3" :disabled='disabledoff'>3级</Radio>
            </RadioGroup>
          </FormItem>
          <FormItem prop="c16" label="平板电视类型" style="width:100%;" :label-width="180">
            <RadioGroup v-model="formRecord.c16">
              <Radio label="LCD" :disabled='disabledoff'>LCD</Radio>
              <Radio label="PDP" :disabled='disabledoff'>PDP</Radio>
              <Radio label="其它" :disabled='disabledoff'>其它</Radio>
            </RadioGroup>
          </FormItem>
          <FormItem prop="c17" :label-width="360" style="margin-top: -57px" >
            <Input type="text" v-model="formRecord.c17" style="width: 170px" :disabled='disabledoff || forbidden.c17'/>
          </FormItem>

          <table id="table1">
            <tr>
              <th></th>
              <th>项目</th>
              <th><i class="red">*</i>标注值</th>
              <th><i class="red">*</i>实测值</th>
              <th>备注</th>
            </tr>
            <tr>
              <td rowspan="2">LCD</td>
              <td>被动待机功率(W)</td>
              <td>
                <FormItem prop="c5">
                  <Input type="text" v-model="formRecord.c5" :disabled='disabledoff || forbidden.c16_LCD'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c32">
                  <Input type="text" v-model="formRecord.c32" :disabled='disabledoff || forbidden.c16_LCD'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c6">
                  <Input type="text" v-model="formRecord.c6" :disabled='disabledoff || forbidden.c16_LCD'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>液晶电视能效指数EEILCD</td>
              <td>
                <FormItem prop="c7">
                  <Input type="text" v-model="formRecord.c7" :disabled='disabledoff || forbidden.c16_LCD'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c33">
                  <Input type="text" v-model="formRecord.c33" :disabled='disabledoff || forbidden.c16_LCD'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c8">
                  <Input type="text" v-model="formRecord.c8" :disabled='disabledoff || forbidden.c16_LCD'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td rowspan="2">PDP</td>
              <td>被动待机功率(W)</td>
              <td>
                <FormItem prop="c9">
                  <Input type="text" v-model="formRecord.c9" :disabled='disabledoff || forbidden.c16_PDP'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c34">
                  <Input type="text" v-model="formRecord.c34" :disabled='disabledoff || forbidden.c16_PDP'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c10">
                  <Input type="text" v-model="formRecord.c10" :disabled='disabledoff || forbidden.c16_PDP'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>等离子电视能效指数EEIPDP</td>
              <td>
                <FormItem prop="c11">
                  <Input type="text" v-model="formRecord.c11" :disabled='disabledoff || forbidden.c16_PDP'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c35">
                  <Input type="text" v-model="formRecord.c35" :disabled='disabledoff || forbidden.c16_PDP'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c12">
                  <Input type="text" v-model="formRecord.c12" :disabled='disabledoff || forbidden.c16_PDP'/>
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
          <FormItem prop="c13" label="备案标识开始使用日期" style="width:100%;">
            <DatePicker type="date" :options="dataInit" style="width: 200px" v-model="formRecord.c13"></DatePicker>
          </FormItem>
        </Card>
      </div>
      <div class="part part5">
        <Card :bordered="false">
          <h2>五、样品描述</h2>
          <table id="table3">
            <tr>
              <td><i class="red">*</i>屏幕有效尺寸（长×宽）（mm×mm）</td>
              <td colspan="3" class="w19">
                <FormItem prop="c14">
                  <Input type="text" v-model="formRecord.c14" :disabled='disabledoff'/>
                </FormItem>
                <FormItem><b>×</b></FormItem>
                <FormItem prop="c15">
                  <Input type="text" v-model="formRecord.c15" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td><i class="red">*</i>附加功能</td>
              <td colspan="3">
                <FormItem prop="c18">
                  <CheckboxGroup v-model="formRecord.c18">
                    <Checkbox label="视盘播放" :disabled='disabledoff'>视盘播放</Checkbox>
                    <Checkbox label="计算机" :disabled='disabledoff'>计算机</Checkbox>
                    <Checkbox label="网络" :disabled='disabledoff'>网络</Checkbox>
                    <Checkbox label="录像" :disabled='disabledoff'>录像</Checkbox>
                    <Checkbox label="其它" :disabled='disabledoff'>其它</Checkbox>
                  </CheckboxGroup>
                </FormItem>
                <FormItem prop="c19">
                  <Input type="text" v-model="formRecord.c19" :disabled='disabledoff || forbidden.c19'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td><i class="red">*</i>固有分辨率（像素数）（水平×垂直）</td>
              <td colspan="3">
                <FormItem prop="c20">
                  <Input type="text" v-model="formRecord.c20" :disabled='disabledoff'/>
                </FormItem>
                <FormItem><b>×</b></FormItem>
                <FormItem prop="c21">
                  <Input type="text" v-model="formRecord.c21" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td><i class="red">*</i>供电方式（W）</td>
              <td colspan="3">
                <FormItem prop="c22">
                  <RadioGroup v-model="formRecord.c22">
                    <Radio label="内置电源" :disabled='disabledoff'>内置电源</Radio>
                    <Radio label="外部电源，输出功率（W）" :disabled='disabledoff'>外部电源，输出功率（W）</Radio>
                  </RadioGroup>
                </FormItem>
                <FormItem prop="c23">
                  <Input type="text" v-model="formRecord.c23" :disabled='disabledoff || forbidden.c23'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td rowspan="2"><i class="red">*</i>信号处理功率（W）</td>
              <td colspan="3" style="border-bottom:none;">
                <FormItem prop="c24">
                  <CheckboxGroup v-model="formRecord.c24">
                    <Checkbox label="模拟射频接口输入（4W）" :disabled='disabledoff'>模拟射频接口输入（4W）</Checkbox>
                    <Checkbox label="数字射频接口输入（8W）" :disabled='disabledoff'>数字射频接口输入（8W）</Checkbox>
                  </CheckboxGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td colspan="3" style="border-top:none;">
                <FormItem>
                  <CheckboxGroup v-model="formRecord.c24">
                    <Checkbox label="其它接口输入" :disabled='disabledoff'>其它接口输入</Checkbox>
                  </CheckboxGroup>
                </FormItem>
                <FormItem prop="c30">
                  <Input type="text" v-model="formRecord.c30" :disabled='disabledoff || forbidden.c30'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td><i class="red">*</i>额定功率（W）</td>
              <td>
                <FormItem prop="c25">
                  <Input type="text" v-model="formRecord.c25" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td><i class="red">*</i>电压（V）</td>
              <td>
                <FormItem prop="c26">
                  <Input type="text" v-model="formRecord.c26" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td><i class="red">*</i>电流（A）</td>
              <td>
                <FormItem prop="c27">
                  <Input type="text" v-model="formRecord.c27" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td><i class="red">*</i>频率（Hz）</td>
              <td>
                <FormItem prop="c28">
                  <Input type="text" v-model="formRecord.c28" :disabled='disabledoff'/>
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
              <th>部件名称</th>
              <th>位号</th>
              <th>型号规格</th>
              <th colspan="2">技术参数</th>
              <th>生产者（全称）</th>
            </tr>
            <tr>
              <td rowspan="7">1</td>
              <td rowspan="7">电源模块/外部电源</td>
              <td rowspan="7">
                <FormItem prop="c36">
                  <Input type="text" v-model="formRecord.c36" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td rowspan="7">

                <FormItem prop="c37">
                  <Input type="text" v-model="formRecord.c37" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>输入电压</td>
              <td>
                <FormItem prop="c38">
                  <Input type="text" v-model="formRecord.c38" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td rowspan="7">
                <FormItem prop="c39">
                  <Input type="text" v-model="formRecord.c39" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>输入电流</td>
              <td>
                <FormItem prop="c40">
                  <Input type="text" v-model="formRecord.c40" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>输入功率</td>
              <td>
                <FormItem prop="c41">
                  <Input type="text" v-model="formRecord.c41" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>输入频率</td>
              <td>
                <FormItem prop="c42">
                  <Input type="text" v-model="formRecord.c42" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>输出电压</td>
              <td>
                <FormItem prop="c43">
                  <Input type="text" v-model="formRecord.c43" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>输出电流</td>
              <td>
                <FormItem prop="c44">
                  <Input type="text" v-model="formRecord.c44" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>输出功率</td>
              <td>
                <FormItem prop="c45">
                  <Input type="text" v-model="formRecord.c45" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td rowspan="7">2</td>
              <td rowspan="7">电源模块/外部电源</td>
              <td rowspan="7">
                <FormItem prop="c46">
                  <Input type="text" v-model="formRecord.c46" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td rowspan="7">
                <FormItem prop="c47">
                  <Input type="text" v-model="formRecord.c47" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>输入电压</td>
              <td>
                <FormItem prop="c48">
                  <Input type="text" v-model="formRecord.c48" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td rowspan="7">
                <FormItem prop="c49">
                  <Input type="text" v-model="formRecord.c49" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>输入电流</td>
              <td>
                <FormItem prop="c50">
                  <Input type="text" v-model="formRecord.c50" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>输入功率</td>
              <td>
                <FormItem prop="c51">
                  <Input type="text" v-model="formRecord.c51" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>输入频率</td>
              <td>
                <FormItem prop="c52">
                  <Input type="text" v-model="formRecord.c52" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>输出电压</td>
              <td>
                <FormItem prop="c53">
                  <Input type="text" v-model="formRecord.c53" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>输出电流</td>
              <td>
                <FormItem prop="c54">
                  <Input type="text" v-model="formRecord.c54" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>输出功率</td>
              <td>
                <FormItem prop="c55">
                  <Input type="text" v-model="formRecord.c55" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td rowspan="4">3</td>
              <td rowspan="4">显示屏</td>
              <td rowspan="4">
                <FormItem prop="c56">
                  <Input type="text" v-model="formRecord.c56" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td rowspan="4">
                <FormItem prop="c57">
                  <Input type="text" v-model="formRecord.c57" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>固有分辨率</td>
              <td>
                <FormItem prop="c58">
                  <Input type="text" v-model="formRecord.c58" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td rowspan="4">
                <FormItem prop="c59">
                  <Input type="text" v-model="formRecord.c59" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>屏幕尺寸</td>
              <td>
                <FormItem prop="c60">
                  <Input type="text" v-model="formRecord.c60" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>亮度</td>
              <td>
                <FormItem prop="c61">
                  <Input type="text" v-model="formRecord.c61" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>背光方式</td>
              <td>
                <FormItem prop="c62">
                  <Input type="text" v-model="formRecord.c62" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td rowspan="4">4</td>
              <td rowspan="4">显示屏</td>
              <td rowspan="4">
                <FormItem prop="c63">
                  <Input type="text" v-model="formRecord.c63" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td rowspan="4">
                <FormItem prop="c64">
                  <Input type="text" v-model="formRecord.c64" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>固有分辨率</td>
              <td>
                <FormItem prop="c65">
                  <Input type="text" v-model="formRecord.c65" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td rowspan="4">
                <FormItem prop="c66">
                  <Input type="text" v-model="formRecord.c66" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>屏幕尺寸</td>
              <td>
                <FormItem prop="c67">
                  <Input type="text" v-model="formRecord.c67" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>亮度</td>
              <td>
                <FormItem prop="c68">
                  <Input type="text" v-model="formRecord.c68" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>背光方式</td>
              <td>
                <FormItem prop="c69">
                  <Input type="text" v-model="formRecord.c69" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>5</td>
              <td>待机控制CPU</td>
              <td>
                <FormItem prop="c70">
                  <Input type="text" v-model="formRecord.c70" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c71">
                  <Input type="text" v-model="formRecord.c71" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td colspan="2">
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
              <td>6</td>
              <td>待机控制CPU</td>
              <td>
                <FormItem prop="c74">
                  <Input type="text" v-model="formRecord.c74" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c75">
                  <Input type="text" v-model="formRecord.c75" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td colspan="2">
                <FormItem prop="c76">
                  <Input type="text" v-model="formRecord.c76" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c77">
                  <Input type="text" v-model="formRecord.c77" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>7</td>
              <td>解码和图像处理芯</td>
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
              <td colspan="2">
                <FormItem prop="c80">
                  <Input type="text" v-model="formRecord.c80" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c81">
                  <Input type="text" v-model="formRecord.c81" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>8</td>
              <td>解码和图像处理芯</td>
              <td>
                <FormItem prop="c82">
                  <Input type="text" v-model="formRecord.c82" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c83">
                  <Input type="text" v-model="formRecord.c83" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td colspan="2">
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
              <td>9</td>
              <td>功放IC</td>
              <td>
                <FormItem prop="c86">
                  <Input type="text" v-model="formRecord.c86" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c87">
                  <Input type="text" v-model="formRecord.c87" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td colspan="2">
                <FormItem prop="c88">
                  <Input type="text" v-model="formRecord.c88" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c89">
                  <Input type="text" v-model="formRecord.c89" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>10</td>
              <td>功放IC</td>
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
              <td colspan="2">
                <FormItem prop="c92">
                  <Input type="text" v-model="formRecord.c92" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c93">
                  <Input type="text" v-model="formRecord.c93" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td colspan="7">注：如果上述关键零部件/原材料属多个制造商，均应按上述要求逐一填写。</td>
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
          公司生产的 <span class="f-brand">{{formRecord.c4}}</span>
          品牌的 <span  class="f-model">{{pageType==='extend'?mainModel:formRecord.c3}}</span>
          型号的 <span  class="f-product">平板电视 2013版</span>产品{{pageType==="update"?'已通过能效标识备案':''}}。
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
    atLeastThreeDecimals,
    isInteger,
    isNumber,
    check
  } from '@/libs/utilExt'

  export default {
    data() {
      const timeDate=parseInt(this.$store.state.app.dateinit);
      const changeVal = (rule, value, callback) => {
        this.mainModel === value? callback('扩展备案需要变更型号名称') : callback()
      }
      return {
        // 当前初始使用日期 对应的C值
        thisDateCV: "c13",
        // 当前能效等级 对应的C值
        thisLevelCV: "c31",
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
        mainModel:'',
        formRecord: {
          ec_master_kuozhan_text: '',
          c1: '',
          c2: '',
          c29: '',
          c3: '',
          c4: '',
          c200: '',
          c31: '',
          c16: '',
          c17: '',
          c5: '',
          c32: '',
          c6: '',
          c7: '',
          c33: '',
          c8: '',
          c9: '',
          c34: '',
          c10: '',
          c11: '',
          c35: '',
          c12: '',
          c13: new Date(),
          c14: '',
          c15: '',
          c18: [],
          c19: '',
          c20: '',
          c21: '',
          c22: '',
          c23: '',
          c24: [],
          c30: '',
          c25: '',
          c26: '',
          c27: '',
          c28: '',
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
          ec_model_no: 34,
          attach_list: ''
        },
        forbidden: {
          c17: true,
          c19: true,
          c23: true,
          c30: true,
          c16_LCD: true,
          c16_PDP: true,
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
      templateLoad(){
        this.loadText=false;
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
        if(res.Status){
          this.$Spin.hide();
          this['checkmark' + id] = true
        }else{
          this['checkmark' + id] = false
          this.uploadParam['filePath'+id]=''
          this.$Message.warning('上传失败')
        }

      }
    },
    computed: {
      ...mapGetters([
        'pageType',
        'recordno'
      ]),
      disabledoff(){
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
        if (this.formRecord.c16 === '其它') {
          this.forbidden.c17 = false
        } else {
          this.formRecord.c17 = ''
          this.forbidden.c17 = true
        }

        if (this.formRecord.c18.join('').indexOf('其它') > -1) {
          this.forbidden.c19 = false
        } else {
          this.formRecord.c19 = ''
          this.forbidden.c19 = true
        }

        if (this.formRecord.c22 === '外部电源，输出功率（W）') {
          this.forbidden.c23 = false
        } else {
          this.formRecord.c23 = ''
          this.forbidden.c23 = true
        }

        if (this.formRecord.c24.join('').indexOf('其它接口输入') > -1) {
          this.forbidden.c30 = false
        } else {
          this.formRecord.c30 = ''
          this.forbidden.c30 = true
        }

        if (this.formRecord.c16 === 'LCD') {
          this.forbidden.c16_LCD = false
          this.forbidden.c16_PDP = true
          this.formRecord.c9 = ''
          this.formRecord.c34 = ''
          this.formRecord.c10 = ''
          this.formRecord.c11 = ''
          this.formRecord.c35 = ''
          this.formRecord.c12 = ''
        } else if (this.formRecord.c16 === 'PDP') {
          this.forbidden.c16_LCD = true
          this.forbidden.c16_PDP = false
          this.formRecord.c5 = ''
          this.formRecord.c32 = ''
          this.formRecord.c6 = ''
          this.formRecord.c7 = ''
          this.formRecord.c33 = ''
          this.formRecord.c8 = ''
        } else if (this.formRecord.c16 === '其它') {
          this.forbidden.c16_LCD = false
          this.forbidden.c16_PDP = false
        }

        let nxdj = "";
        let lcddjgl = parseFloat(this.formRecord.c5);             // LCD被动待机功率
        let pdpdjgl = parseFloat(this.formRecord.c9);             //PDP 被动待机功率
        let c32 = parseFloat(this.formRecord.c32);
        let c33 = parseFloat(this.formRecord.c33);
        let c34 = parseFloat(this.formRecord.c34);
        let c35 = parseFloat(this.formRecord.c35);
        let c11 = parseFloat(this.formRecord.c11);
        let c7 = parseFloat(this.formRecord.c7);
        let c16 = this.formRecord.c16;
        let c31 = this.formRecord.c31;

        const checkc5 = (rule, value, callback) => {
          if (lcddjgl != null && lcddjgl !== "" && lcddjgl > 0.5) {
            callback("LCD 被动待机功率应小于等于0.5！")
          } else {
            callback()
          }
        }

        const checkc9 = (rule, value, callback) => {
          if (pdpdjgl != null && pdpdjgl > 0.5) {
            callback("PDP 被动待机功率应小于等于0.5！")
          } else {
            callback()
          }
        }

        const checkc32 = (rule, value, callback) => {
          if (parseFloat(c32) != null && parseFloat(c32) > lcddjgl) {
            callback("LCD 被动待机功率实测值应小于标准规定值!")
          } else {
            callback()
          }
        }

        const checkc33 = (rule, value, callback) => {
          if (parseFloat(c33) != null && parseFloat(c33) < parseFloat(c7)) {
            callback("LCD能效指数实测值应大于或等于标准规定值!");
          } else {
            callback()
          }
        }

        const checkc34 = (rule, value, callback) => {
          if (parseFloat(c34) != null && parseFloat(c34) > parseFloat(pdpdjgl)) {
            callback("PDP被动待机功率实测值应小于标准规定值!");
          } else {
            callback()
          }
        }

        const checkc35 = (rule, value, callback) => {
          if (parseFloat(c35) != null && parseFloat(c35) < parseFloat(c11)) {
            callback("PDP能效指数实测值应大于或等于标准规定值!");
          } else {
            callback()
          }
        }

        if (c16 === "LCD") {
          if (parseFloat(c7) >= 2.7) {
            nxdj = "1";
          } else if (parseFloat(c7) >= 2) {
            nxdj = "2";
          } else if (parseFloat(c7) >= 1.3) {
            nxdj = "3";
          }
        } else if (c16 === "PDP") {
          if (parseFloat(c11) >= 2) {
            nxdj = "1";
          } else if (parseFloat(c11) >= 1.6) {
            nxdj = "2";
          } else if (parseFloat(c11) >= 1.2) {
            nxdj = "3";
          }
        }

        const checkc31 = (rule, value, callback) => {
          if (nxdj === "") {
            callback("能效数据不在备案范围");
          }else if (c31 !== nxdj) {
            callback("所选能效等级与计算结果不符！");
          } else {
            callback()
          }
        }


        return {
          c2: [
            {
              required: true,
              trigger: 'change,blur',
              message: '制造单位不能为空'
            }
          ],
          c29: [
            {
              required: true,
              trigger: 'change,blur',
              message: '备案方不能为空'
            }
          ],
          c3: [
            {
              required: true,
              trigger: 'change,blur',
              message: '产品规格型号不能为空'
            }
          ],
          c4: [
            {
              required: true,
              trigger: 'change,blur',
              message: '商标不能为空'
            }
          ],
          c200: [
            {
              required: true,
              trigger: 'change,blur',
              message: '依据国家标准不能为空'
            }
          ],
          c31: [
            {
              required: true,
              trigger: 'change,blur',
              message: '能效等级不能为空'
            },
            {
              validator: checkc31,
              trigger: 'change,blur',
            },
          ],
          c16: [
            {
              required: true,
              trigger: 'change,blur',
              message: '平板电视类型不能为空'
            }
          ],
          c17: [
            {
              required: this.formRecord.c16 === '其它',
              trigger: 'change,blur',
              message: '其它不能为空'
            }
          ],
          c5: [
            {
              required: !this.forbidden.c16_LCD,
              trigger: 'change,blur',
              message: '标称值不能为空'
            },
            {
              validator: !this.forbidden.c16_LCD ? twoDecimals : check,
              trigger: 'change,blur',
            },
            {
              validator: checkc5,
              trigger: 'change,blur',
            }
          ],
          c32: [
            {
              required: !this.forbidden.c16_LCD,
              trigger: 'change,blur',
              message: '实测值不能为空'
            },
            {
              validator: !this.forbidden.c16_LCD ? atLeastThreeDecimals : check,
              trigger: 'change,blur',
            },
            {
              validator: checkc32,
              trigger: 'change,blur',
            }
          ],
          c7: [
            {
              required: !this.forbidden.c16_LCD,
              trigger: 'change,blur',
              message: '标称值不能为空'
            },
            {
              validator: !this.forbidden.c16_LCD ? oneDecimals : check,
              trigger: 'change,blur',
            }
          ],
          c33: [
            {
              required: !this.forbidden.c16_LCD,
              trigger: 'change,blur',
              message: '实测值不能为空'
            },
            {
              validator: !this.forbidden.c16_LCD ? atLeastTwoDecimals : check,
              trigger: 'change,blur',
            },
            {
              validator: checkc33,
              trigger: 'change,blur',
            }
          ],
          c9: [
            {
              required: !this.forbidden.c16_PDP,
              trigger: 'change,blur',
              message: '标称值不能为空'
            },
            {
              validator: !this.forbidden.c16_PDP ? twoDecimals : check,
              trigger: 'change,blur',
            },
            {
              validator: checkc9,
              trigger: 'change,blur',
            }
          ],
          c34: [
            {
              required: !this.forbidden.c16_PDP,
              trigger: 'change,blur',
              message: '实测值不能为空'
            },
            {
              validator: !this.forbidden.c16_PDP ? atLeastThreeDecimals : check,
              trigger: 'change,blur',
            },
            {
              validator: checkc34,
              trigger: 'change,blur',
            }
          ],
          c11: [
            {
              required: !this.forbidden.c16_PDP,
              trigger: 'change,blur',
              message: '标称值不能为空'
            },
            {
              validator: !this.forbidden.c16_PDP ? oneDecimals : check,
              trigger: 'change,blur',
            }
          ],
          c35: [
            {
              required: !this.forbidden.c16_PDP,
              trigger: 'change,blur',
              message: '实测值不能为空'
            },
            {
              validator: !this.forbidden.c16_PDP ? atLeastTwoDecimals : check,
              trigger: 'change,blur',
            },
            {
              validator: checkc35,
              trigger: 'change,blur',
            }
          ],
          c13: [
            {
              required: true,
              message: '备案标识开始使用日期不能为空'
            }
          ],
          c14: [
            {
              required: true,
              trigger: 'change,blur',
              message: '屏幕有效尺寸长不能为空'
            }
          ],
          c15: [
            {
              required: true,
              trigger: 'change,blur',
              message: '屏幕有效尺寸宽不能为空'
            }
          ],
          c18: [
            {
              required: true,
              message: '附件功能不能为空'
            }
          ],
          c19: [
            {
              required: this.formRecord.c18.join('').indexOf('其它') > -1,
              trigger: 'change,blur',
              message: '其它不能为空'
            }
          ],
          c20: [
            {
              required: true,
              trigger: 'change,blur',
              message: '固有分辨率水平不能为空'
            }
          ],
          c21: [
            {
              required: true,
              trigger: 'change,blur',
              message: '固有分辨率垂直不能为空'
            }
          ],
          c22: [
            {
              required: true,
              trigger: 'change,blur',
              message: '供电方式不能为空'
            }
          ],
          c23: [
            {
              required: this.formRecord.c22 === '外部电源，输出功率（W）',
              trigger: 'change,blur',
              message: '外部电源不能为空'
            }
          ],
          c24: [
            {
              required: true,
              message: '信号处理功率不能为空'
            }
          ],
          c30: [
            {
              required: this.formRecord.c24.join('').indexOf('其它接口输入') > -1,
              trigger: 'change,blur',
              message: '其它接口输入不能为空'
            }
          ],
          c25: [
            {
              required: true,
              trigger: 'change,blur',
              message: '额定功率不能为空'
            }
          ],
          c26: [
            {
              required: true,
              trigger: 'change,blur',
              message: '电压不能为空'
            }
          ],
          c27: [
            {
              required: true,
              trigger: 'change,blur',
              message: '电流不能为空'
            }
          ],
          c28: [
            {
              required: true,
              trigger: 'change,blur',
              message: '频率不能为空'
            }
          ],
          c36: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c37: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c38: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c39: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c40: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c41: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c42: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c43: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c44: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c45: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c56: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c57: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c58: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c59: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c60: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c61: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c62: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c70: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c71: [
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
          c78: [
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
              message: '不能为空'
            }
          ],
          c80: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c81: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c86: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c87: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c88: [
            {
              required: true,
              trigger: 'change,blur',
              message: '不能为空'
            }
          ],
          c89: [
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
