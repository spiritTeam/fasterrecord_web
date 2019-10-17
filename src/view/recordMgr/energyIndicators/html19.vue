<!--容积式空气压缩机-->
<!--创建日期:2019年9月11日-->
<!--创建人:YPH-->
<template>
  <div class="wrapper">
    <Form ref="formRecord" :model="formRecord" label-position="right" :rules="ruleRecord">
      <h1>容积式空气压缩机-能源效率标识备案表</h1>
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
          <FormItem prop="c4" label="制造单位" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c4" :disabled='disabledoff' placeholder="制造单位"/>
          </FormItem>
          <FormItem prop="c19" label="备案方" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c19" :disabled='disabledoff' placeholder="备案方"/>
          </FormItem>
          <FormItem prop="c3" label="规格型号" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c3" :disabled='!disabledoff' placeholder="规格型号"/>
          </FormItem>
          <FormItem prop="c2" label="商标" style="width:100%" :label-width="180">
            <Input type="text" v-model="formRecord.c2" :disabled='pageType=="view"' placeholder="商标"/>
          </FormItem>
          <FormItem prop="c200" label="依据国家标准" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c200" placeholder="依据国家标准" readonly disabled/>
          </FormItem>
          <FormItem prop="c20" label="能效等级" style="width:100%;" :label-width="180">
            <RadioGroup v-model="formRecord.c20">
              <Radio label="1" :disabled='disabledoff'>1级</Radio>
              <Radio label="2" :disabled='disabledoff'>2级</Radio>
              <Radio label="3" :disabled='disabledoff'>3级</Radio>
            </RadioGroup>
          </FormItem>
          <FormItem prop="c10" label="压缩机类型" style="width:100%;" :label-width="180">
            <Select v-model="formRecord.c10" style="width:250px">
              <Option value="">--请选择--</Option>
              <Option value="一般用喷油滑片空气压缩机">一般用喷油滑片空气压缩机</Option>
              <Option value="一般用喷油单螺杆空气压缩机">一般用喷油单螺杆空气压缩机</Option>
              <Option value="一般用喷油螺杆空气压缩机">一般用喷油螺杆空气压缩机</Option>
              <Option value="一般用固定的往复活塞空气压缩机">一般用固定的往复活塞空气压缩机</Option>
              <Option value="全无油润滑往复活塞空气压缩机">全无油润滑往复活塞空气压缩机</Option>
              <Option value="微型往复活塞空气压缩机">微型往复活塞空气压缩机</Option>
              <Option value="直联便携式往复活塞空气压缩机">直联便携式往复活塞空气压缩机</Option>
              <Option value="无油润滑直联便携式往复活塞空气压缩机">无油润滑直联便携式往复活塞空气压缩机</Option>
            </Select>
          </FormItem>
          <table id="table1">
            <tr>
              <th>项目</th>
              <th><i class="red">*</i>标称值</th>
              <th><i class="red">*</i>实测值</th>
              <th>备注</th>
            </tr>
            <tr>
              <td>机组输入比功率(kW/(m³/min))</td>
              <td>
                <FormItem prop="c5">
                  <Input type="text" v-model="formRecord.c5" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c21">
                  <Input type="text" v-model="formRecord.c21" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c6">
                  <Input type="text" v-model="formRecord.c6" :disabled='disabledoff'/>
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
          <FormItem prop="c7" label="备案标识开始使用日期" style="width:100%;">
            <DatePicker type="date" :options="dataInit" style="width: 200px" v-model="formRecord.c7"></DatePicker>
          </FormItem>
        </Card>
      </div>
      <div class="part part5">
        <Card :bordered="false">
          <h2>五、样品描述</h2>
          <table id="table3">
            <tr>
              <td><i class="red">*</i>冷却方式</td>
              <td>
                <FormItem prop="c8">
                  <RadioGroup v-model="formRecord.c8">
                    <Radio label="风冷" :disabled='disabledoff'>风冷</Radio>
                    <Radio label="水冷" :disabled='disabledoff'>水冷</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td><i class="red">*</i>压缩级数</td>
              <td>
                <FormItem prop="c9">
                  <RadioGroup v-model="formRecord.c9">
                    <Radio label="单级" :disabled='disabledoff'>单级</Radio>
                    <Radio label="两级" :disabled='disabledoff'>两级</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td><i class="red">*</i>额定转速(r/min)</td>
              <td colspan="3">
                <FormItem prop="c11">
                  <Input type="text" v-model="formRecord.c11" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td><i class="red">*</i>驱动电动机输入额定功率(kW)</td>
              <td colspan="3">
                <FormItem prop="c12">
                  <Select v-model="formRecord.c12" style="width:200px">
                    <Option value="0.18">0.18</Option>
                    <Option value="0.25">0.25</Option>
                    <Option value="0.37">0.37</Option>
                    <Option value="0.55">0.55</Option>
                    <Option value="0.75">0.75</Option>
                    <Option value="1.1">1.1</Option>
                    <Option value="1.5">1.5</Option>
                    <Option value="1.8">1.8</Option>
                    <Option value="2.2">2.2</Option>
                    <Option value="2.6">2.6</Option>
                    <Option value="3">3</Option>
                    <Option value="4">4</Option>
                    <Option value="5.5">5.5</Option>
                    <Option value="7.5">7.5</Option>
                    <Option value="11">11</Option>
                    <Option value="15">15</Option>
                    <Option value="18.5">18.5</Option>
                    <Option value="22">22</Option>
                    <Option value="30">30</Option>
                    <Option value="37">37</Option>
                    <Option value="45">45</Option>
                    <Option value="55">55</Option>
                    <Option value="63">63</Option>
                    <Option value="75">75</Option>
                    <Option value="90">90</Option>
                    <Option value="110">110</Option>
                    <Option value="132">132</Option>
                    <Option value="160">160</Option>
                    <Option value="200">200</Option>
                    <Option value="250">250</Option>
                    <Option value="315">315</Option>
                    <Option value="355">355</Option>
                    <Option value="400">400</Option>
                    <Option value="450">450</Option>
                    <Option value="500">500</Option>
                    <Option value="560">560</Option>
                    <Option value="630">630</Option>
                  </Select>
                </FormItem>

                <FormItem prop="c30" style="margin-left: 30px">
                  <RadioGroup v-model="formRecord.c30">
                    <Radio label="单作用空压机" :disabled='disabledoff'>单作用空压机</Radio>
                    <Radio label="双作用空压机" :disabled='disabledoff'>双作用空压机</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td><i class="red">*</i>额定排气压力(MPa)(至少一位小数)</td>
              <td>
                <FormItem prop="c13">
                  <Input type="text" v-model="formRecord.c13" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td><i class="red">*</i>净重(kg)</td>
              <td>
                <FormItem prop="c23">
                  <Input type="text" v-model="formRecord.c23" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td><i class="red">*</i>电压(V)</td>
              <td>
                <FormItem prop="c26">
                  <Input type="text" v-model="formRecord.c26" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td><i class="red">*</i>频率(Hz)</td>
              <td>
                <FormItem prop="c27">
                  <Input type="text" v-model="formRecord.c27" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td><i class="red">*</i>公称容积流量(m³/min)(两位小数)</td>
              <td>
                <FormItem prop="c14">
                  <Input type="text" v-model="formRecord.c14" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td><i class="red">*</i>运动机构润滑方式</td>
              <td>
                <FormItem prop="c15">
                  <Input type="text" v-model="formRecord.c15" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td><i class="red">*</i>气缸润滑方式</td>
              <td colspan="3">
                <FormItem prop="c16">
                  <Input type="text" v-model="formRecord.c16" :disabled='disabledoff'/>
                </FormItem>
                <FormItem prop="c22" style="margin-left: 30px">
                  <RadioGroup v-model="formRecord.c22">
                    <Radio label="有油" :disabled='disabledoff'>有油</Radio>
                    <Radio label="无油" :disabled='disabledoff'>无油</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td><i class="red">*</i>驱动方式</td>
              <td colspan="3">
                <FormItem prop="c17">
                  <Input type="text" v-model="formRecord.c17" style="width: 500px" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>外形尺寸（长×宽×高）<br>（mm × mm × mm）</td>
              <td colspan="3">
                <FormItem prop="c18">
                  <Input type="text" v-model="formRecord.c18" :disabled='disabledoff'/>
                </FormItem>
                <FormItem><b>×</b></FormItem>
                <FormItem prop="c28">
                  <Input type="text" v-model="formRecord.c28" :disabled='disabledoff'/>
                </FormItem>
                <FormItem><b>×</b></FormItem>
                <FormItem prop="c29">
                  <Input type="text" v-model="formRecord.c29" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
          </table>
        </Card>
      </div>
      <div class="part part6">
        <Card :bordered="false">
          <h2>六、产品基本配置清单</h2>
          <h3>表1（空气压缩机：一般用喷油螺杆、一般用喷油单螺杆、一般用喷油滑片）</h3>
          <table class="table table-bordered dataTables-example dataTable bg-white"
                 aria-describedby="DataTables_Table_0_info" align="center">
            <thead>
            <tr>
              <th>序号</th>
              <th>部件名称</th>
              <th>规格/型号</th>
              <th colspan="4">技术参数</th>
              <th>生产者（全称）</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td rowspan="3">1</td>
              <td rowspan="3">压缩机主机</td>
              <td>具体型号</td>
              <td colspan="2">是否增速</td>
              <td colspan="2">主机数量</td>
              <td>/</td>
            </tr>
            <tr>
              <td>
                <FormItem prop="c31">
                  <Input type="text" v-model="formRecord.c31" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td colspan="2">
                <FormItem prop="c32">
                  <RadioGroup v-model="formRecord.c32" class="overwrite1">
                    <Radio label="有" :disabled='disabledoff' class="overwrite2">有</Radio>
                    <Radio label="无" :disabled='disabledoff' class="overwrite2">无</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td colspan="2">
                <FormItem prop="c33">
                  <Input type="text" v-model="formRecord.c31" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c34">
                  <Input type="text" v-model="formRecord.c34" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>
                <FormItem prop="c35">
                  <Input type="text" v-model="formRecord.c35" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td colspan="2">
                <FormItem prop="c36">
                  <RadioGroup v-model="formRecord.c36" class="overwrite1">
                    <Radio label="有" :disabled='disabledoff' class="overwrite2">有</Radio>
                    <Radio label="无" :disabled='disabledoff' class="overwrite2">无</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td colspan="2">
                <FormItem prop="c37">
                  <Input type="text" v-model="formRecord.c37" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c38">
                  <Input type="text" v-model="formRecord.c38" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td rowspan="2">2</td>
              <td rowspan="2">压缩机主机</td>
              <td>
                <FormItem prop="c39">
                  <Input type="text" v-model="formRecord.c39" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td colspan="2">
                <FormItem prop="c40">
                  <RadioGroup v-model="formRecord.c40" class="overwrite1">
                    <Radio label="有" :disabled='disabledoff' class="overwrite2">有</Radio>
                    <Radio label="无" :disabled='disabledoff' class="overwrite2">无</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td colspan="2">
                <FormItem prop="c41">
                  <Input type="text" v-model="formRecord.c41" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c42">
                  <Input type="text" v-model="formRecord.c42" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>
                <FormItem prop="c43">
                  <Input type="text" v-model="formRecord.c43" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td colspan="2">
                <FormItem prop="c44">
                  <RadioGroup v-model="formRecord.c44" class="overwrite1">
                    <Radio label="有" :disabled='disabledoff' class="overwrite2">有</Radio>
                    <Radio label="无" :disabled='disabledoff' class="overwrite2">无</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td colspan="2">
                <FormItem prop="c45">
                  <Input type="text" v-model="formRecord.c45" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c46">
                  <Input type="text" v-model="formRecord.c46" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td rowspan="2">3</td>
              <td rowspan="2">电机</td>
              <td>
                <FormItem prop="c47">
                  <Input type="text" v-model="formRecord.c47" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td rowspan="2">效率</td>
              <td>
                <FormItem prop="c48">
                  <Input type="text" v-model="formRecord.c48" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td rowspan="2">服务系数</td>
              <td>
                <FormItem prop="c49">
                  <Input type="text" v-model="formRecord.c49" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c50">
                  <Input type="text" v-model="formRecord.c50" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>
                <FormItem prop="c51">
                  <Input type="text" v-model="formRecord.c51" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c52">
                  <Input type="text" v-model="formRecord.c52" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c53">
                  <Input type="text" v-model="formRecord.c53" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c54">
                  <Input type="text" v-model="formRecord.c54" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td rowspan="2">4</td>
              <td rowspan="2">电机</td>
              <td>
                <FormItem prop="c55">
                  <Input type="text" v-model="formRecord.c55" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td rowspan="2">效率</td>
              <td>
                <FormItem prop="c56">
                  <Input type="text" v-model="formRecord.c56" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td rowspan="2">服务系数</td>
              <td>
                <FormItem prop="c57">
                  <Input type="text" v-model="formRecord.c57" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c58">
                  <Input type="text" v-model="formRecord.c58" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>
                <FormItem prop="c59">
                  <Input type="text" v-model="formRecord.c59" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c60">
                  <Input type="text" v-model="formRecord.c60" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c61">
                  <Input type="text" v-model="formRecord.c61" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c62">
                  <Input type="text" v-model="formRecord.c62" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>5</td>
              <td>油分离器桶</td>
              <td>
                <FormItem prop="c63">
                  <Input type="text" v-model="formRecord.c63" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td colspan="2">容积</td>
              <td colspan="2">
                <FormItem prop="c64">
                  <Input type="text" v-model="formRecord.c64" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c65">
                  <Input type="text" v-model="formRecord.c65" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>6</td>
              <td>油分离器桶</td>
              <td>
                <FormItem prop="c66">
                  <Input type="text" v-model="formRecord.c66" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td colspan="2">容积</td>
              <td colspan="2">
                <FormItem prop="c67">
                  <Input type="text" v-model="formRecord.c67" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c68">
                  <Input type="text" v-model="formRecord.c68" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>7</td>
              <td>空气滤清器</td>
              <td>
                <FormItem prop="c69">
                  <Input type="text" v-model="formRecord.c69" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td colspan="2">流量范围</td>
              <td colspan="2">
                <FormItem prop="c70">
                  <Input type="text" v-model="formRecord.c70" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c71">
                  <Input type="text" v-model="formRecord.c71" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>8</td>
              <td>空气滤清器</td>
              <td>
                <FormItem prop="c72">
                  <Input type="text" v-model="formRecord.c72" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td colspan="2">流量范围</td>
              <td colspan="2">
                <FormItem prop="c73">
                  <Input type="text" v-model="formRecord.c73" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c74">
                  <Input type="text" v-model="formRecord.c74" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>9</td>
              <td>进气阀</td>
              <td>
                <FormItem prop="c75">
                  <Input type="text" v-model="formRecord.c75" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td colspan="2">通径</td>
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
              <td>10</td>
              <td>进气阀</td>
              <td>
                <FormItem prop="c78">
                  <Input type="text" v-model="formRecord.c78" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td colspan="2">通径</td>
              <td colspan="2">
                <FormItem prop="c79">
                  <Input type="text" v-model="formRecord.c79" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c80">
                  <Input type="text" v-model="formRecord.c80" :disabled='disabledoff'/>
                </FormItem>
              </td>

            </tr>
            <tr>
              <td colspan="8">
                备注：1、如上述零部件属多个生产者，均应按上述要求逐一填写。2、在所用型式选。
              </td>
            </tr>
            </tbody>
          </table>
          <h3>表2（往复活塞空气压缩机：直联便携式、微型、全无有润滑、一般用固定的）</h3>
          <table class="table table-bordered dataTables-example dataTable bg-white"
                 aria-describedby="DataTables_Table_0_info" align="center">
            <thead>
            <tr>
              <th>序号</th>
              <th>部件名称</th>
              <th>型号规格</th>
              <th colspan="3">技术参数</th>
              <th>生产者（全称）</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td rowspan="2">1</td>
              <td rowspan="2">压缩机主机</td>
              <td>具体型号</td>
              <td>缸径X数量</td>
              <td colspan="2">气阀型式</td>
              <td>/</td>
            </tr>
            <tr>
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
              <td class="t1" colspan="2">
                <FormItem prop="c83">
                  <RadioGroup v-model="formRecord.c83" class="overwrite1">
                    <Radio label="环状阀 /网状阀" :disabled='disabledoff' class="overwrite2">环状阀 /网状阀</Radio>
                    <Radio label="舌簧阀" :disabled='disabledoff' class="overwrite2">舌簧阀</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c84">
                  <Input type="text" v-model="formRecord.c84" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>2</td>
              <td>压缩机主机</td>
              <td>
                <FormItem prop="c85">
                  <Input type="text" v-model="formRecord.c85" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c86">
                  <Input type="text" v-model="formRecord.c86" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td class="t1" colspan="2">
                <FormItem prop="c87">
                  <RadioGroup v-model="formRecord.c87" class="overwrite1">
                    <Radio label="环状阀 /网状阀" :disabled='disabledoff' class="overwrite2">环状阀 /网状阀</Radio>
                    <Radio label="舌簧阀" :disabled='disabledoff' class="overwrite2">舌簧阀</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c88">
                  <Input type="text" v-model="formRecord.c88" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td rowspan="2">3</td>
              <td rowspan="2">电机</td>
              <td>
                <FormItem prop="c89">
                  <Input type="text" v-model="formRecord.c89" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td rowspan="2">效率</td>
              <td colspan="2">
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
              <td>
                <FormItem prop="c92">
                  <Input type="text" v-model="formRecord.c92" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td colspan="2">
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
              <td rowspan="2">4</td>
              <td rowspan="2">电机</td>
              <td>
                <FormItem prop="c95">
                  <Input type="text" v-model="formRecord.c95" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td rowspan="2">效率</td>
              <td colspan="2">
                <FormItem prop="c96">
                  <Input type="text" v-model="formRecord.c96" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c97">
                  <Input type="text" v-model="formRecord.c97" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>
                <FormItem prop="c98">
                  <Input type="text" v-model="formRecord.c98" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td colspan="2">
                <FormItem prop="c99">
                  <Input type="text" v-model="formRecord.c99" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c100">
                  <Input type="text" v-model="formRecord.c100" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td rowspan="2">5</td>
              <td rowspan="2">进气消音器</td>
              <td>
                <FormItem prop="c101">
                  <Input type="text" v-model="formRecord.c101" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td rowspan="2">连接尺寸</td>
              <td colspan="2">
                <FormItem prop="c102">
                  <Input type="text" v-model="formRecord.c102" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c103">
                  <Input type="text" v-model="formRecord.c103" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>
                <FormItem prop="c104">
                  <Input type="text" v-model="formRecord.c104" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td colspan="2">
                <FormItem prop="c105">
                  <Input type="text" v-model="formRecord.c105" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c106">
                  <Input type="text" v-model="formRecord.c106" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td rowspan="2">6</td>
              <td rowspan="2">进气消音器</td>
              <td>
                <FormItem prop="c107">
                  <Input type="text" v-model="formRecord.c107" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td rowspan="2">连接尺寸</td>
              <td colspan="2">
                <FormItem prop="c108">
                  <Input type="text" v-model="formRecord.c108" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c109">
                  <Input type="text" v-model="formRecord.c109" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>
                <FormItem prop="c110">
                  <Input type="text" v-model="formRecord.c110" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td colspan="2">
                <FormItem prop="c111">
                  <Input type="text" v-model="formRecord.c111" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c112">
                  <Input type="text" v-model="formRecord.c112" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td colspan="8">
                备注：1、如上述零部件属多个生产者，均应按上述要求逐一填写。2、在所用型式选。
              </td>
            </tr>
            </tbody>
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
        公司生产的 <span class="f-brand">{{formRecord.c5}}</span>
        品牌的 <span class="f-model">{{pageType==='extend'?mainModel:formRecord.c4}}</span>
        型号的 <span class="f-product">投影机 2015版</span>产品{{pageType==="update"?'已通过能效标识备案':''}}。
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
        thisDateCV: "c7",
        // 当前能效等级 对应的C值
        thisLevelCV: "c20",
        thisGZXHCV: "c4",// 当前规格型号 对应的C值
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
          c4: '',
          c19: '',
          c3: '',
          c2: '',
          c200: '',
          c20: '',
          c10: '',
          c5: '',
          c21: '',
          c6: '',
          c7: new Date(),
          c8: '',
          c9: '',
          c11: '',
          c12: '',
          c30: '',
          c13: '',
          c23: '',
          c26: '',
          c27: '',
          c14: '',
          c15: '',
          c16: '',
          c22: '',
          c17: '',
          c18: '',
          c28: '',
          c29: '',
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
          c202: '',
          ec_model_no: 19,
          attach_list: ''
        },
        forbidden: {
          c18: true,
          c25: true,
          c27: true,
        },
        T_1_DJ: [[0, 0.25, 0.4, 0.5, 0.7, 0.8, 1.0],
          [0.25, 8.8, 10.5, 11.5, 13.2, 14, 15.5],
          [0.25, 9.3, 11, 12.1, 13.9, 14.7, 16.3],
          [0.25, 11.6, 13.8, 15.1, 17.4, 18.4, 20.4],
          [0.25, 10.5, 12.5, 13.7, 15.8, 16.7, 18.5],
          [0.37, 8.8, 10.5, 11.5, 13.2, 14, 15.5],
          [0.37, 9.3, 11, 12.1, 13.9, 14.7, 16.3],
          [0.37, 11.6, 13.8, 15.1, 17.4, 18.4, 20.4],
          [0.37, 10.5, 12.5, 13.7, 15.8, 16.7, 18.5],
          [0.55, 8.6, 10.1, 10.9, 12.6, 13.4, 14.9],
          [0.55, 9, 10.6, 11.5, 13.3, 14.1, 15.7],
          [0.55, 11.2, 13.3, 14.4, 16.6, 17.6, 19.6],
          [0.55, 10.2, 12.1, 13.1, 15.1, 16, 17.8],
          [0.75, 8.3, 9.8, 10.7, 12.3, 13, 14.3],
          [0.75, 8.7, 10.3, 11.3, 12.9, 13.7, 15],
          [0.75, 10.9, 12.9, 14.1, 16.2, 17.2, 18.8],
          [0.75, 9.9, 11.7, 12.8, 14.7, 15.6, 17.1],
          [1.1, 7.9, 9.4, 10.3, 11.8, 12.4, 13.9],
          [1.1, 8.3, 9.9, 10.8, 12.4, 13.1, 14.6],
          [1.1, 10.5, 12.4, 13.5, 15.5, 16.4, 18.3],
          [1.1, 9.5, 11.3, 12.3, 14.1, 14.9, 16.6],
          [1.5, 7.9, 9.2, 10, 11.5, 12.2, 13.6],
          [1.5, 8.3, 9.7, 10.5, 12.1, 12.8, 14.3],
          [1.5, 10.4, 12.1, 13.2, 15.2, 16.1, 17.9],
          [1.5, 9.4, 11, 12, 13.8, 14.6, 16.3],
          [1.8, 7.9, 9.2, 10, 11.5, 12.2, 13.6],
          [1.8, 8.3, 9.7, 10.5, 12.1, 12.8, 14.3],
          [1.8, 10.3, 12.1, 13.2, 15.2, 16.1, 17.9],
          [1.8, 9.4, 11, 12, 13.8, 14.6, 16.3],
          [2.2, 7.5, 9.1, 9.9, 11.3, 11.9, 13.2],
          [2.2, 7.9, 9.6, 10.4, 11.9, 12.5, 13.9],
          [2.2, 9.9, 12, 13.1, 14.9, 15.7, 17.4],
          [2.2, 9, 10.9, 11.9, 13.5, 14.3, 15.8],
          [2.6, 7.5, 9.1, 9.9, 11.3, 11.9, 13.2],
          [2.6, 7.9, 9.6, 10.4, 11.9, 12.5, 13.9],
          [2.6, 9.9, 12, 13.1, 14.9, 15.7, 17.4],
          [2.6, 9, 10.9, 11.9, 13.5, 14.3, 15.8],
          [3, 7.4, 8.7, 9.6, 11.1, 11.8, 12.9],
          [3, 7.8, 9.2, 10.1, 11.7, 12.4, 13.6],
          [3, 9.8, 11.6, 12.7, 14.6, 15.4, 17.1],
          [3, 8.9, 10.5, 11.5, 13.3, 14, 15.5]],
        T_1_LJ: [[0, 0.25, 0.4, 0.5, 0.7, 0.8, 1.0],
          [0.55, 0, 0, 0, 0, 0, 13.2],
          [0.55, 0, 0, 0, 0, 0, 13.9],
          [0.55, 0, 0, 0, 0, 0, 17.4],
          [0.55, 0, 0, 0, 0, 0, 15.8],
          [0.75, 0, 0, 0, 0, 0, 13],
          [0.75, 0, 0, 0, 0, 0, 13.7],
          [0.75, 0, 0, 0, 0, 0, 17.2],
          [0.75, 0, 0, 0, 0, 0, 15.6],
          [1.1, 0, 0, 0, 0, 0, 12.9],
          [1.1, 0, 0, 0, 0, 0, 13.6],
          [1.1, 0, 0, 0, 0, 0, 17.1],
          [1.1, 0, 0, 0, 0, 0, 15.5],
          [1.5, 0, 0, 0, 0, 0, 12.7],
          [1.5, 0, 0, 0, 0, 0, 13.4],
          [1.5, 0, 0, 0, 0, 0, 16.8],
          [1.5, 0, 0, 0, 0, 0, 15.3],
          [2.2, 0, 0, 0, 0, 0, 12.6],
          [2.2, 0, 0, 0, 0, 0, 13.3],
          [2.2, 0, 0, 0, 0, 0, 16.7],
          [2.2, 0, 0, 0, 0, 0, 15.2],
          [3, 0, 0, 0, 0, 0, 12.5],
          [3, 0, 0, 0, 0, 0, 13.2],
          [3, 0, 0, 0, 0, 0, 16.5],
          [3, 0, 0, 0, 0, 0, 15]],
        T_2_DJ: [[0, 0.25, 0.4, 0.5, 0.7, 0.8, 1.0],
          [0.25, 10.7, 12.7, 13.3, 14.7, 15.6, 16.2],
          [0.25, 11.3, 13.4, 14, 15.5, 16.4, 17.1],
          [0.25, 14.1, 16.7, 17.6, 19.5, 20.5, 21.3],
          [0.25, 12.8, 15.2, 16, 17.7, 18.6, 19.4],
          [0.37, 10.3, 12, 12.6, 14.1, 14.9, 16.2],
          [0.37, 10.8, 12.6, 13.3, 14.8, 15.7, 17.1],
          [0.37, 13.5, 15.8, 16.6, 18.5, 19.6, 21.3],
          [0.37, 12.3, 14.4, 15.1, 16.8, 17.8, 19.4],
          [0.55, 9.8, 11.3, 12, 13.4, 14.3, 15.8],
          [0.55, 10.3, 11.9, 12.6, 14.1, 15, 16.6],
          [0.55, 13, 14.9, 15.7, 17.6, 18.7, 20.7],
          [0.55, 11.8, 13.5, 14.3, 16, 17, 18.8],
          [0.75, 9.2, 10.7, 11.5, 12.8, 13.5, 15.1],
          [0.75, 9.7, 11.3, 12.1, 13.5, 14.2, 15.9],
          [0.75, 12.1, 14.1, 15.1, 16.8, 17.8, 19.9],
          [0.75, 11, 12.8, 13.7, 15.3, 16.2, 18.1],
          [1.1, 8.9, 10.5, 11.1, 12.4, 13.1, 14.7],
          [1.1, 9.4, 11.1, 11.7, 13, 13.8, 15.5],
          [1.1, 11.8, 13.9, 14.6, 16.3, 17.3, 19.4],
          [1.1, 10.7, 12.6, 13.3, 14.8, 15.7, 17.6],
          [1.5, 8.8, 10.3, 10.7, 12.2, 12.7, 14.3],
          [1.5, 9.3, 10.8, 11.3, 12.8, 13.4, 15],
          [1.5, 11.6, 13.5, 14.1, 16, 16.8, 18.8],
          [1.5, 10.5, 12.3, 12.8, 14.5, 15.3, 17.1],
          [1.8, 8.8, 10.3, 10.7, 12.2, 12.7, 14.3],
          [1.8, 9.3, 10.8, 11.3, 12.8, 13.4, 15],
          [1.8, 11.6, 13.5, 14.1, 16, 16.8, 18.8],
          [1.8, 10.5, 12.3, 12.8, 14.5, 15.3, 17.1],
          [2.2, 8.6, 10.1, 10.7, 12, 12.6, 14.1],
          [2.2, 9, 10.6, 11.3, 12.6, 13.3, 14.8],
          [2.2, 11.2, 13.3, 14.1, 15.7, 16.6, 18.5],
          [2.2, 10.2, 12.1, 12.8, 14.3, 15.1, 16.8],
          [2.6, 8.6, 10.1, 10.7, 12, 12.6, 14.1],
          [2.6, 9, 10.6, 11.3, 12.6, 13.3, 14.8],
          [2.6, 11.2, 13.3, 14.1, 15.7, 16.6, 18.5],
          [2.6, 10.2, 12.1, 12.8, 14.3, 15.1, 16.8],
          [3, 8.4, 9.8, 10.5, 11.5, 12.2, 13.7],
          [3, 8.8, 10.3, 11, 12.1, 12.8, 14.4],
          [3, 11, 12.9, 13.8, 15.2, 16.1, 18],
          [3, 10, 11.7, 12.5, 13.8, 14.6, 16.4]],
        T_2_LJ: [[0, 0.25, 0.4, 0.5, 0.7, 0.8, 1.0],
          [0.55, 0, 0, 0, 0, 0, 13.4],
          [0.55, 0, 0, 0, 0, 0, 14.1],
          [0.55, 0, 0, 0, 0, 0, 17.6],
          [0.55, 0, 0, 0, 0, 0, 16],
          [0.75, 0, 0, 0, 0, 0, 13.4],
          [0.75, 0, 0, 0, 0, 0, 14.1],
          [0.75, 0, 0, 0, 0, 0, 17.6],
          [0.75, 0, 0, 0, 0, 0, 16],
          [1.1, 0, 0, 0, 0, 0, 13.2],
          [1.1, 0, 0, 0, 0, 0, 13.9],
          [1.1, 0, 0, 0, 0, 0, 17.4],
          [1.1, 0, 0, 0, 0, 0, 15.8],
          [1.5, 0, 0, 0, 0, 0, 13.2],
          [1.5, 0, 0, 0, 0, 0, 13.9],
          [1.5, 0, 0, 0, 0, 0, 17.4],
          [1.5, 0, 0, 0, 0, 0, 15.8],
          [2.2, 0, 0, 0, 0, 0, 12.7],
          [2.2, 0, 0, 0, 0, 0, 13.4],
          [2.2, 0, 0, 0, 0, 0, 16.8],
          [2.2, 0, 0, 0, 0, 0, 15.3],
          [3, 0, 0, 0, 0, 0, 12.7],
          [3, 0, 0, 0, 0, 0, 13.4],
          [3, 0, 0, 0, 0, 0, 16.8],
          [3, 0, 0, 0, 0, 0, 15.3]],
        T_3_DJ: [[0, 0.25, 0.4, 0.5, 0.7, 0.8, 1, 1.25, 1.4],
          [0.18, 9.1, 10.8, 11.8, 13.6, 14.4, 15.9, 0, 0],
          [0.18, 9.8, 11.6, 12.7, 14.6, 15.5, 17.1, 0, 0],
          [0.18, 11, 13.1, 14.4, 16.6, 17.8, 19.4, 0, 0],
          [0.18, 10.9, 13, 14.3, 16.5, 17.7, 19.2, 0, 0],
          [0.25, 8.6, 10.2, 11.3, 12.9, 13.7, 15.2, 0, 0],
          [0.25, 9.3, 11, 12.1, 13.9, 14.7, 16.3, 0, 0],
          [0.25, 10.5, 12.5, 13.7, 15.8, 17, 18.5, 0, 0],
          [0.25, 10.4, 12.4, 13.6, 15.7, 16.9, 18.3, 0, 0],
          [0.37, 8.6, 10, 10.9, 12.6, 13.3, 14.8, 0, 0],
          [0.37, 9.2, 10.8, 11.7, 13.5, 14.3, 15.9, 0, 0],
          [0.37, 10, 11.7, 12.9, 14.8, 15.6, 17.4, 0, 0],
          [0.37, 9.9, 11.6, 12.8, 14.7, 15.5, 17.3, 0, 0],
          [0.55, 7.9, 9.2, 10, 11.5, 12.2, 13.6, 0, 0],
          [0.55, 8.5, 9.9, 10.8, 12.4, 13.1, 14.6, 0, 0],
          [0.55, 9.2, 10.9, 12, 13.7, 14.4, 16, 0, 0],
          [0.55, 9.1, 10.8, 11.9, 13.6, 14.3, 15.9, 0, 0],
          [0.75, 7.4, 8.7, 9.5, 10.9, 11.5, 12.8, 0, 0],
          [0.75, 8, 9.4, 10.2, 11.7, 12.4, 13.8, 0, 0],
          [0.75, 8.7, 10.4, 11.3, 12.9, 13.7, 15.2, 0, 0],
          [0.75, 8.6, 10.3, 11.2, 12.8, 13.6, 15.1, 0, 0],
          [1.1, 6.9, 8.2, 8.8, 10.2, 10.9, 12.1, 0, 0],
          [1.1, 7.4, 8.8, 9.5, 11, 11.7, 13, 0, 0],
          [1.1, 8.3, 9.7, 10.6, 12.2, 12.9, 14.4, 0, 0],
          [1.1, 8.2, 9.6, 10.5, 12.1, 12.8, 14.3, 0, 0],
          [1.5, 6.7, 7.9, 8.6, 9.8, 10.3, 11.5, 0, 0],
          [1.5, 7.2, 8.5, 9.2, 10.5, 11.1, 12.4, 0, 0],
          [1.5, 7.8, 9.4, 10.3, 11.7, 12.5, 13.8, 0, 0],
          [1.5, 7.7, 9.3, 10.2, 11.6, 12.4, 13.7, 0, 0],
          [2.2, 6.1, 7.3, 7.8, 9, 9.6, 10.6, 0, 0],
          [2.2, 6.6, 7.8, 8.4, 9.7, 10.3, 11.4, 0, 0],
          [2.2, 7.2, 8.6, 9.4, 10.8, 11.4, 12.7, 0, 0],
          [2.2, 7.1, 8.5, 9.3, 10.7, 11.3, 12.6, 0, 0],
          [3, 0, 7, 7.5, 8.7, 9.3, 10.3, 0, 0],
          [3, 0, 7.5, 8.1, 9.4, 10, 11.1, 0, 0],
          [3, 0, 8.3, 9.1, 10.5, 11.2, 12.4, 0, 0],
          [3, 0, 8.2, 9, 10.4, 11.1, 12.3, 0, 0],
          [4, 0, 6.6, 7.3, 8.4, 8.8, 9.9, 0, 0],
          [4, 0, 7.1, 7.8, 9, 9.5, 10.6, 0, 0],
          [4, 0, 7.9, 8.7, 10, 10.6, 11.8, 0, 0],
          [4, 0, 7.8, 8.6, 9.9, 10.5, 11.7, 0, 0],
          [5.5, 0, 6.5, 7.1, 8.3, 8.7, 9.6, 0, 0],
          [5.5, 0, 7, 7.6, 8.9, 9.4, 10.3, 0, 0],
          [5.5, 0, 7.7, 8.5, 9.8, 10.5, 11.5, 0, 0],
          [5.5, 0, 7.6, 8.4, 9.7, 10.4, 11.4, 0, 0],
          [7.5, 0, 6.4, 6.9, 8, 8.5, 0, 0, 0],
          [7.5, 0, 6.9, 7.4, 8.6, 9.1, 0, 0, 0],
          [7.5, 0, 7.7, 8.3, 9.6, 10.1, 0, 0, 0],
          [7.5, 0, 7.6, 8.2, 9.5, 10, 0, 0, 0],
          [11, 0, 6.2, 6.7, 7.7, 8.2, 0, 0, 0],
          [11, 0, 6.7, 7.2, 8.3, 8.8, 0, 0, 0],
          [11, 0, 7.5, 8.2, 9.3, 9.8, 0, 0, 0],
          [11, 0, 7.4, 8.1, 9.2, 9.7, 0, 0, 0],
          [15, 0, 6, 6.5, 7.5, 8, 0, 0, 0],
          [15, 0, 6.5, 7, 8.1, 8.6, 0, 0, 0],
          [15, 0, 7.2, 8, 9.1, 9.6, 0, 0, 0],
          [15, 0, 0, 7.9, 9, 9.5, 0, 0, 0],
          [18.5, 0, 0, 6.3, 0, 0, 0, 0, 0],
          [18.5, 0, 0, 6.8, 0, 0, 0, 0, 0],
          [18.5, 0, 0, 7.9, 0, 0, 0, 0, 0],
          [18.5, 0, 0, 7.8, 0, 0, 0, 0, 0]],
        T_3_LJ: [[0, 0.25, 0.4, 0.5, 0.7, 0.8, 1, 1.25, 1.4],
          [0.37, 0, 0, 0, 0, 0, 12.9, 13.7, 14.4],
          [0.37, 0, 0, 0, 0, 0, 13.9, 14.7, 15.5],
          [0.37, 0, 0, 0, 0, 0, 15.4, 17.1, 17.9],
          [0.37, 0, 0, 0, 0, 0, 15.3, 17, 17.8],
          [0.55, 0, 0, 0, 0, 0, 12.3, 12.9, 13.6],
          [0.55, 0, 0, 0, 0, 0, 13.2, 13.9, 14.6],
          [0.55, 0, 0, 0, 0, 0, 14.6, 16.1, 16.9],
          [0.55, 0, 0, 0, 0, 0, 14.5, 16, 16.8],
          [0.75, 0, 0, 0, 0, 0, 11.9, 12.6, 13.2],
          [0.75, 0, 0, 0, 0, 0, 12.8, 13.5, 14.2],
          [0.75, 0, 0, 0, 0, 0, 14.1, 15.7, 16.4],
          [0.75, 0, 0, 0, 0, 0, 14, 15.6, 16.3],
          [1.1, 0, 0, 0, 0, 0, 11.3, 12, 12.6],
          [1.1, 0, 0, 0, 0, 0, 12.2, 12.9, 13.5],
          [1.1, 0, 0, 0, 0, 0, 13.5, 15, 15.7],
          [1.1, 0, 0, 0, 0, 0, 13.4, 14.9, 15.6],
          [1.5, 0, 0, 0, 0, 0, 11, 11.7, 12.3],
          [1.5, 0, 0, 0, 0, 0, 11.8, 12.6, 13.2],
          [1.5, 0, 0, 0, 0, 0, 13.2, 14.6, 15.3],
          [1.5, 0, 0, 0, 0, 0, 13.1, 14.5, 15.2],
          [2.2, 0, 0, 0, 0, 0, 10.2, 10.9, 11.4],
          [2.2, 0, 0, 0, 0, 0, 11, 11.7, 12.3],
          [2.2, 0, 0, 0, 0, 0, 12.3, 13.6, 14.3],
          [2.2, 0, 0, 0, 0, 0, 12.2, 13.5, 14.2],
          [3, 0, 0, 0, 0, 0, 10.1, 10.7, 11.3],
          [3, 0, 0, 0, 0, 0, 10.9, 11.5, 12.1],
          [3, 0, 0, 0, 0, 0, 12.1, 13.5, 14.1],
          [3, 0, 0, 0, 0, 0, 12, 13.4, 14],
          [4, 0, 0, 0, 8.4, 8.8, 9.6, 10, 10.7],
          [4, 0, 0, 0, 9, 9.5, 10.3, 10.8, 11.5],
          [4, 0, 0, 0, 9.8, 10.5, 11.4, 12.5, 13.3],
          [4, 0, 0, 0, 9.7, 10.4, 11.3, 12.4, 13.2],
          [5.5, 0, 0, 0, 8.3, 8.7, 9.5, 10, 10.5],
          [5.5, 0, 0, 0, 8.9, 9.4, 10.2, 10.7, 11.3],
          [5.5, 0, 0, 0, 9.7, 10.2, 11.2, 12.4, 13],
          [5.5, 0, 0, 0, 9.6, 10.1, 11.1, 12.3, 12.9],
          [7.5, 0, 0, 0, 8.1, 8.6, 9.3, 9.8, 10.2],
          [7.5, 0, 0, 0, 8.7, 9.2, 10, 10.5, 11],
          [7.5, 0, 0, 0, 9.5, 10, 11, 12.1, 12.8],
          [7.5, 0, 0, 0, 9.4, 9.9, 10.9, 12, 12.7],
          [11, 0, 0, 0, 7.7, 8.2, 8.9, 9.5, 10],
          [11, 0, 0, 0, 8.3, 8.8, 9.6, 10.2, 10.8],
          [11, 0, 0, 0, 9.2, 9.7, 10.7, 11.9, 12.5],
          [11, 0, 0, 0, 9.1, 9.6, 10.6, 11.8, 12.4],
          [15, 0, 0, 0, 7.4, 7.9, 8.6, 9.2, 9.8],
          [15, 0, 0, 0, 8, 8.5, 9.3, 9.9, 10.5],
          [15, 0, 0, 0, 9, 9.5, 10.5, 11.6, 12.2],
          [15, 0, 0, 0, 8.9, 9.4, 10.4, 11.5, 12.1]],
        T_4_DJ: [[0, 0.4, 0.5, 0.7, 0.8, 1, 1.25, 1.4],
          [0.18, 13.7, 14.3, 14.9, 15.9, 0, 0, 0],
          [0.18, 14.6, 15.2, 15.9, 16.9, 0, 0, 0],
          [0.18, 16.4, 17.3, 19.1, 20.2, 0, 0, 0],
          [0.18, 16.2, 17.1, 18.9, 20, 0, 0, 0],
          [0.25, 12.3, 12.9, 14.3, 14.9, 0, 0, 0],
          [0.25, 13.1, 13.7, 15.2, 15.9, 0, 0, 0],
          [0.25, 14.8, 15.6, 17.3, 18.3, 0, 0, 0],
          [0.25, 14.7, 15.4, 17.1, 18.1, 0, 0, 0],
          [0.37, 11.3, 11.8, 13.2, 13.9, 0, 0, 0],
          [0.37, 12, 12.6, 14, 14.8, 0, 0, 0],
          [0.37, 13.5, 14.3, 15.9, 16.9, 0, 0, 0],
          [0.37, 13.4, 14.2, 15.7, 16.7, 0, 0, 0],
          [0.55, 10.2, 10.7, 12.1, 12.9, 0, 0, 0],
          [0.55, 10.9, 11.4, 12.9, 13.7, 0, 0, 0],
          [0.55, 12.2, 13, 14.6, 15.5, 0, 0, 0],
          [0.55, 12.1, 12.9, 14.5, 15.3, 0, 0, 0],
          [0.75, 9.9, 10.4, 11.5, 12.1, 13.8, 0, 0],
          [0.75, 10.5, 11.1, 12.2, 12.9, 14.7, 0, 0],
          [0.75, 11.8, 12.6, 13.8, 14.6, 16.5, 0, 0],
          [0.75, 11.7, 12.5, 13.7, 14.5, 16.3, 0, 0],
          [1.1, 9.3, 9.6, 10.7, 11.4, 12.9, 0, 0],
          [1.1, 9.9, 10.2, 11.4, 12.1, 13.7, 0, 0],
          [1.1, 11.1, 11.6, 13, 13.8, 15.4, 0, 0],
          [1.1, 11, 11.5, 12.9, 13.7, 15.2, 0, 0],
          [1.5, 8.9, 9.4, 10.3, 11, 12.1, 0, 0],
          [1.5, 9.5, 10, 11, 11.7, 12.9, 0, 0],
          [1.5, 10.7, 11.4, 12.6, 13.4, 14.6, 0, 0],
          [1.5, 10.6, 11.3, 12.5, 13.3, 14.5, 0, 0],
          [2.2, 8.2, 8.6, 9.5, 10.1, 11.5, 0, 0],
          [2.2, 8.7, 9.2, 10.1, 10.7, 12.2, 0, 0],
          [2.2, 9.8, 10.4, 11.5, 12.2, 13.8, 0, 0],
          [2.2, 9.7, 10.3, 11.4, 12.1, 13.7, 0, 0],
          [3, 7.8, 8.4, 9.2, 9.8, 0, 0, 0],
          [3, 8.3, 8.9, 9.8, 10.4, 0, 0, 0],
          [3, 9.3, 10.1, 11.2, 11.9, 0, 0, 0],
          [3, 9.2, 10, 11.1, 11.8, 0, 0, 0],
          [4, 7.4, 8, 8.7, 9.3, 0, 0, 0],
          [4, 7.9, 8.5, 9.3, 9.9, 0, 0, 0],
          [4, 8.9, 9.6, 10.7, 11.3, 0, 0, 0],
          [4, 8.8, 9.5, 10.6, 11.2, 0, 0, 0],
          [5.5, 7.4, 7.7, 8.6, 9, 0, 0, 0],
          [5.5, 7.9, 8.2, 9.1, 9.6, 0, 0, 0],
          [5.5, 8.8, 9.4, 10.4, 11, 0, 0, 0],
          [5.5, 8.7, 9.3, 10.3, 10.9, 0, 0, 0],
          [7.5, 7.2, 7.5, 8.3, 8.7, 0, 0, 0],
          [7.5, 7.7, 8, 8.8, 9.3, 0, 0, 0],
          [7.5, 8.6, 9.1, 10.2, 10.8, 0, 0, 0],
          [7.5, 8.5, 9, 10.1, 10.7, 0, 0, 0],
          [11, 7.1, 7.3, 8, 8.5, 0, 0, 0],
          [11, 7.5, 7.8, 8.5, 9, 0, 0, 0],
          [11, 8.4, 8.9, 9.9, 10.5, 0, 0, 0],
          [11, 8.3, 8.8, 9.8, 10.4, 0, 0, 0],
          [15, 6.8, 7.1, 7.8, 8.3, 0, 0, 0],
          [15, 7.2, 7.6, 8.3, 8.8, 0, 0, 0],
          [15, 8.1, 8.6, 9.7, 10.3, 0, 0, 0],
          [15, 8, 8.5, 9.6, 10.2, 0, 0, 0]],
        T_4_LJ_SL: [[0, 0.4, 0.5, 0.7, 0.8, 1, 1.25, 1.4],
          [2.2, 0, 0, 0, 0, 11, 11.7, 12.5],
          [2.2, 0, 0, 0, 0, 11.7, 12.4, 13.3],
          [2.2, 0, 0, 0, 0, 12.6, 14.7, 15.7],
          [2.2, 0, 0, 0, 0, 12.5, 14.6, 15.6],
          [3, 0, 0, 0, 0, 10.8, 11.5, 12.2],
          [3, 0, 0, 0, 0, 11.5, 12.2, 13],
          [3, 0, 0, 0, 0, 12.3, 14.4, 15.4],
          [3, 0, 0, 0, 0, 12.2, 14.3, 15.3],
          [4, 0, 0, 0, 0, 10.3, 10.9, 11.7],
          [4, 0, 0, 0, 0, 11, 11.6, 12.4],
          [4, 0, 0, 0, 0, 11.7, 13.7, 14.7],
          [4, 0, 0, 0, 0, 11.6, 13.6, 14.6],
          [5.5, 0, 0, 0, 0, 10.2, 10.5, 11.4],
          [5.5, 0, 0, 0, 0, 10.8, 11.2, 12.1],
          [5.5, 0, 0, 0, 0, 11.6, 13.3, 14.4],
          [5.5, 0, 0, 0, 0, 11.5, 13.2, 14.3],
          [7.5, 0, 0, 0, 0, 10, 10.4, 11.3],
          [7.5, 0, 0, 0, 0, 10.6, 11.1, 12],
          [7.5, 0, 0, 0, 0, 11.3, 13.2, 14.2],
          [7.5, 0, 0, 0, 0, 11.2, 13.1, 14.1],
          [11, 0, 0, 7.9, 8.4, 9.7, 9.8, 10.3],
          [11, 0, 0, 8.4, 8.9, 10.3, 10.4, 11],
          [11, 0, 0, 9.5, 10.1, 11.1, 12.4, 13],
          [11, 0, 0, 9.4, 10, 11, 12.3, 12.9],
          [15, 0, 0, 7.6, 8.1, 9.5, 9.5, 10],
          [15, 0, 0, 8.1, 8.6, 10.1, 10.1, 10.6],
          [15, 0, 0, 9.3, 9.9, 10.8, 11.9, 12.6],
          [15, 0, 0, 9.2, 9.8, 10.7, 11.8, 12.5],
          [18.5, 0, 0, 6.7, 7.1, 7.9, 8.4, 8.8],
          [18.5, 0, 0, 7.1, 7.5, 8.4, 8.9, 9.4],
          [18.5, 0, 0, 7.5, 8, 8.9, 10, 10.6],
          [18.5, 0, 0, 7.4, 7.9, 8.8, 9.9, 10.5],
          [22, 0, 0, 6.7, 7.1, 7.9, 8.4, 8.8],
          [22, 0, 0, 7.1, 7.5, 8.4, 8.9, 9.4],
          [22, 0, 0, 7.5, 8, 8.9, 10, 10.6],
          [22, 0, 0, 7.4, 7.9, 8.8, 9.9, 10.5]],
        T_4_LJ_FL: [[0, 0.4, 0.5, 0.7, 0.8, 1, 1.25, 1.4],
          [2.2, 0, 0, 0, 0, 11, 11.7, 12.5],
          [2.2, 0, 0, 0, 0, 11.7, 12.4, 13.3],
          [2.2, 0, 0, 0, 0, 12.6, 14.7, 15.7],
          [2.2, 0, 0, 0, 0, 12.5, 14.6, 15.6],
          [3, 0, 0, 0, 0, 10.8, 11.5, 12.2],
          [3, 0, 0, 0, 0, 11.5, 12.2, 13],
          [3, 0, 0, 0, 0, 12.3, 14.4, 15.4],
          [3, 0, 0, 0, 0, 12.2, 14.3, 15.3],
          [4, 0, 0, 0, 0, 10.3, 10.9, 11.7],
          [4, 0, 0, 0, 0, 11, 11.6, 12.4],
          [4, 0, 0, 0, 0, 11.7, 13.7, 14.7],
          [4, 0, 0, 0, 0, 11.6, 13.6, 14.6],
          [5.5, 0, 0, 0, 0, 10.2, 10.5, 11.4],
          [5.5, 0, 0, 0, 0, 10.8, 11.2, 12.1],
          [5.5, 0, 0, 0, 0, 11.6, 13.3, 14.4],
          [5.5, 0, 0, 0, 0, 11.5, 13.2, 14.3],
          [7.5, 0, 0, 0, 0, 10, 10.4, 11.3],
          [7.5, 0, 0, 0, 0, 10.6, 11.1, 12],
          [7.5, 0, 0, 0, 0, 11.3, 13.2, 14.2],
          [7.5, 0, 0, 0, 0, 11.2, 13.1, 14.1],
          [11, 0, 0, 7.9, 8.4, 9.7, 9.8, 10.3],
          [11, 0, 0, 8.4, 8.9, 10.3, 10.4, 11],
          [11, 0, 0, 9.5, 10.1, 11.1, 12.4, 13],
          [11, 0, 0, 9.4, 10, 11, 12.3, 12.9],
          [15, 0, 0, 7.6, 8.1, 9.5, 9.5, 10],
          [15, 0, 0, 8.1, 8.6, 10.1, 10.1, 10.6],
          [15, 0, 0, 9.3, 9.9, 10.8, 11.9, 12.6],
          [15, 0, 0, 9.2, 9.8, 10.7, 11.8, 12.5],
          [18.5, 0, 0, 7.3, 7.8, 9.1, 9.1, 9.5],
          [18.5, 0, 0, 7.8, 8.3, 9.7, 9.7, 10.1],
          [18.5, 0, 0, 8.9, 9.4, 10.4, 11.5, 12],
          [18.5, 0, 0, 8.8, 9.3, 10.3, 11.4, 11.9],
          [22, 0, 0, 7.3, 7.8, 9.1, 9.1, 9.5],
          [22, 0, 0, 7.8, 8.3, 9.7, 9.7, 10.1],
          [22, 0, 0, 8.9, 9.4, 10.4, 11.5, 12],
          [22, 0, 0, 8.8, 9.3, 10.3, 11.4, 11.9]],
        T_5_DZY: [
          [0, 0.7, 0.7, 0.7, 0.8, 0.8, 0.8, 1, 1, 1, 1.25, 1.25,
            1.25],
          [18.5, 6.2, 6.36, 6.69, 6.62, 6.79, 0, 7.42, 7.56, 7.84,
            7.84, 8, 8.28],
          [18.5, 6.81, 6.99, 7.35, 7.27, 7.46, 0, 8.15, 8.31, 8.62,
            8.61, 8.79, 9.1],
          [18.5, 7, 7.24, 7.6, 7.47, 7.72, 0, 8.34, 8.63, 9.06,
            9.32, 9.65, 10.13],
          [18.5, 6.93, 7.17, 7.52, 7.4, 7.64, 0, 8.26, 8.54, 8.97,
            9.23, 9.55, 10.03],
          [22, 6.17, 6.33, 6.66, 6.58, 6.75, 0, 7.38, 7.53, 7.81,
            7.8, 7.96, 8.24],
          [22, 6.78, 6.96, 7.32, 7.23, 7.42, 0, 8.11, 8.28, 8.58,
            8.57, 8.75, 9.05],
          [22, 6.97, 7.21, 7.57, 7.43, 7.69, 0, 8.3, 8.59, 9.02,
            9.28, 9.6, 10.08],
          [22, 6.9, 7.14, 7.49, 7.36, 7.61, 0, 8.22, 8.5, 8.93,
            9.19, 9.51, 9.98],
          [30, 5.97, 6.13, 6.46, 6.37, 6.54, 0, 7.34, 7.49, 7.76,
            7.75, 7.92, 8.19],
          [30, 6.56, 6.74, 7.1, 7, 7.19, 0, 8.07, 8.23, 8.53, 8.52,
            8.7, 9],
          [30, 6.93, 7.17, 7.53, 7.39, 7.65, 0, 8.25, 8.54, 8.97,
            9.23, 9.55, 10.03],
          [30, 6.86, 7.1, 7.46, 7.32, 7.57, 0, 8.17, 8.46, 8.88,
            9.14, 9.46, 9.93],
          [37, 5.97, 6.13, 6.46, 6.37, 6.54, 0, 7.34, 7.49, 7.76,
            7.75, 7.92, 8.19],
          [37, 6.56, 6.74, 7.1, 7, 7.19, 0, 8.07, 8.23, 8.53, 8.52,
            8.7, 9],
          [37, 6.93, 7.17, 7.53, 7.39, 7.65, 0, 8.25, 8.54, 8.97,
            9.23, 9.55, 10.03],
          [37, 6.86, 7.1, 7.46, 7.32, 7.57, 0, 8.17, 8.46, 8.88,
            9.14, 9.46, 9.93],
          [45, 5.66, 5.93, 6.27, 6.04, 6.32, 0, 6.68, 6.95, 7.43,
            7.16, 7.54, 7.92],
          [45, 6.22, 6.52, 6.89, 6.64, 6.95, 0, 7.34, 7.64, 8.17,
            7.87, 8.29, 8.7],
          [45, 6.41, 6.82, 7.24, 6.84, 7.27, 0, 7.62, 8.12, 8.62,
            8.53, 9.09, 9.64],
          [45, 6.35, 6.76, 7.17, 6.78, 7.2, 0, 7.55, 8.04, 8.54,
            8.45, 9, 9.55],

          [55, 5.64, 5.91, 6.25, 6.02, 6.31, 0, 6.66, 6.93, 7.41,
            7.14, 7.52, 7.89],
          [55, 6.2, 6.49, 6.87, 6.61, 6.93, 0, 7.32, 7.61, 8.14,
            7.85, 8.26, 8.67],
          [55, 6.38, 6.8, 7.21, 6.81, 7.25, 0, 7.6, 8.09, 8.59,
            8.51, 9.06, 9.6],
          [55, 6.32, 6.73, 7.14, 6.74, 7.18, 0, 7.53, 8.01, 8.51,
            8.43, 8.97, 9.5],

          [63, 5.4, 5.72, 6.1, 5.76, 6.11, 0, 6.42, 6.73, 7.25,
            6.87, 7.3, 7.89],
          [63, 5.93, 6.29, 6.7, 6.33, 6.71, 0, 7.05, 7.4, 7.97,
            7.55, 8.02, 8.67],
          [63, 6.09, 6.62, 7.21, 6.5, 7.06, 0, 7.26, 7.88, 8.59,
            8.12, 8.82, 9.6],
          [63, 6.03, 6.55, 7.14, 6.44, 6.99, 0, 7.17, 7.8, 8.5,
            8.04, 8.73, 9.5],
          [75, 5.4, 5.71, 6.09, 5.76, 6.1, 0, 6.41, 6.72, 7.24,
            6.86, 7.29, 7.88],
          [75, 5.93, 6.28, 6.69, 6.33, 6.7, 0, 7.04, 7.39, 7.96,
            7.54, 8.01, 8.66],
          [75, 6.08, 6.61, 7.2, 6.49, 7.05, 0, 7.25, 7.87, 8.58,
            8.11, 8.81, 9.59],
          [75, 6.02, 6.54, 7.13, 6.43, 6.8, 0, 7.18, 7.79, 8.49,
            8.03, 8.72, 9.5],
          [90, 5.31, 5.61, 0, 5.67, 5.98, 0, 6.34, 6.66, 0, 6.8,
            7.22, 0],
          [90, 5.84, 6.16, 0, 6.23, 6.57, 0, 6.97, 7.32, 0, 7.47,
            7.93, 0],
          [90, 6.02, 6.55, 0, 6.42, 6.99, 0, 7.17, 7.79, 0, 8.02,
            8.72, 0],
          [90, 5.96, 6.49, 0, 6.36, 6.92, 0, 7.1, 7.71, 0, 7.94,
            8.63, 0],
          [110, 5.27, 5.51, 0, 5.61, 5.87, 0, 6.27, 6.55, 0, 6.69,
            7.12, 0],
          [110, 5.79, 6.05, 0, 6.17, 6.45, 0, 6.89, 7.2, 0, 7.35,
            7.82, 0],
          [110, 6, 6.43, 0, 6.4, 6.86, 0, 7.14, 7.66, 0, 7.99, 8.57,
            0],
          [110, 5.94, 6.37, 0, 6.34, 6.79, 0, 7.07, 7.58, 0, 7.91,
            8.48, 0],
          [132, 5.25, 5.48, 0, 5.6, 5.84, 0, 6.24, 6.52, 0, 6.66,
            7.09, 0],
          [132, 5.77, 6.02, 0, 6.15, 6.42, 0, 6.86, 7.17, 0, 7.32,
            7.79, 0],
          [132, 6, 6.4, 0, 6.4, 6.83, 0, 7.11, 7.62, 0, 7.96, 8.53,
            0],
          [132, 5.94, 6.34, 0, 6.34, 6.76, 0, 7.04, 7.54, 0, 7.88,
            8.45, 0],
          [160, 5.25, 5.44, 0, 5.6, 5.81, 0, 6.21, 6.49, 0, 6.62,
            7.04, 0],
          [160, 5.77, 5.98, 0, 6.15, 6.38, 0, 6.82, 7.13, 0, 7.28,
            7.74, 0],
          [160, 6, 6.37, 0, 6.4, 6.79, 0, 7.07, 7.58, 0, 7.91, 8.48,
            0],
          [160, 5.94, 6.31, 0, 6.34, 6.72, 0, 7, 7.51, 0, 7.83, 8.4,
            0],
          [200, 5.25, 5.42, 0, 5.6, 5.79, 0, 6.19, 6.38, 0, 6.6,
            6.93, 0],
          [200, 5.77, 5.96, 0, 6.15, 6.36, 0, 6.8, 7.01, 0, 7.25,
            7.61, 0],
          [200, 5.99, 6.37, 0, 6.39, 6.79, 0, 7.07, 7.53, 0, 7.91,
            8.43, 0],
          [200, 5.93, 6.31, 0, 6.33, 6.72, 0, 7, 7.46, 0, 7.83,
            8.35, 0],
          [250, 5.25, 5.41, 0, 5.6, 5.77, 0, 6.19, 6.38, 0, 6.6,
            6.93, 0],
          [250, 5.77, 5.94, 0, 6.15, 6.34, 0, 6.8, 7.01, 0, 7.25,
            7.61, 0],
          [250, 5.99, 6.33, 0, 6.39, 6.75, 0, 7.07, 7.45, 0, 7.91,
            8.33, 0],
          [250, 5.93, 6.27, 0, 6.33, 6.68, 0, 7, 6.37, 0, 7.83,
            8.25, 0],
          [315, 5.23, 5.4, 0, 5.59, 5.75, 0, 6.16, 6.32, 0, 6.58,
            6.86, 0],
          [315, 5.75, 5.93, 0, 6.14, 6.32, 0, 6.77, 6.95, 0, 7.23,
            7.54, 0],
          [315, 5.95, 6.26, 0, 6.35, 6.68, 0, 7.07, 7.45, 0, 7.91,
            8.33, 0],
          [315, 5.89, 6.2, 0, 6.29, 6.61, 0, 7, 7.38, 0, 7.83, 8.25,
            0],
          [355, 5.22, 5.39, 0, 5.57, 5.74, 0, 6.16, 6.32, 0, 6.58,
            6.86, 0],
          [355, 5.74, 5.92, 0, 6.12, 6.31, 0, 6.77, 6.95, 0, 7.23,
            7.54, 0],
          [355, 5.94, 6.24, 0, 6.34, 6.66, 0, 7.07, 7.45, 0, 7.91,
            8.33, 0],
          [355, 5.88, 6.18, 0, 6.28, 6.59, 0, 7, 7.38, 0, 7.83,
            8.25, 0],
          [400, 5.21, 5.37, 0, 5.56, 5.73, 0, 6.16, 6.32, 0, 6.58,
            6.86, 0],
          [400, 5.73, 5.9, 0, 6.11, 6.3, 0, 6.77, 6.95, 0, 7.23,
            7.54, 0],
          [400, 5.93, 6.23, 0, 6.33, 6.65, 0, 7.07, 7.45, 0, 7.91,
            8.33, 0],
          [400, 5.87, 6.17, 0, 6.27, 6.58, 0, 7, 7.38, 0, 7.83,
            8.25, 0],
          [450, 5.2, 5.36, 0, 5.55, 5.71, 0, 0, 0, 0, 0, 0, 0],
          [450, 5.71, 5.89, 0, 6.1, 6.28, 0, 0, 0, 0, 0, 0, 0],
          [450, 5.89, 6.16, 0, 6.28, 6.57, 0, 0, 0, 0, 0, 0, 0],
          [450, 5.83, 6.1, 0, 6.22, 6.5, 0, 0, 0, 0, 0, 0, 0],
          [500, 5.2, 5.35, 0, 5.55, 5.71, 0, 0, 0, 0, 0, 0, 0],
          [500, 5.71, 5.88, 0, 6.1, 6.27, 0, 0, 0, 0, 0, 0, 0],
          [500, 5.88, 6.15, 0, 6.27, 6.56, 0, 0, 0, 0, 0, 0, 0],
          [500, 5.82, 6.09, 0, 6.21, 6.49, 0, 0, 0, 0, 0, 0, 0],
          [560, 5.19, 5.34, 0, 5.53, 5.7, 0, 0, 0, 0, 0, 0, 0],
          [560, 5.7, 5.87, 0, 6.08, 6.26, 0, 0, 0, 0, 0, 0, 0],
          [560, 5.87, 6.14, 0, 6.26, 6.55, 0, 0, 0, 0, 0, 0, 0],
          [560, 5.81, 6.08, 0, 6.2, 6.48, 0, 0, 0, 0, 0, 0, 0]],
        T_5_SZY: [
          [0, 0.7, 0.7, 0.7, 0.8, 0.8, 0.8, 1, 1, 1, 1.25, 1.25,
            1.25],
          [18.5, 6.2, 6.36, 6.69, 6.62, 6.79, 0, 7.42, 7.56, 7.84,
            7.84, 8, 8.28],
          [18.5, 6.81, 6.99, 7.35, 7.27, 7.46, 0, 8.15, 8.31, 8.62,
            8.61, 8.79, 9.1],
          [18.5, 7, 7.24, 7.6, 7.47, 7.72, 0, 8.34, 8.63, 9.06,
            9.32, 9.65, 10.13],
          [18.5, 6.93, 7.17, 7.52, 7.4, 7.64, 0, 8.26, 8.54, 8.97,
            9.23, 9.55, 10.03],
          [22, 6.17, 6.33, 6.66, 6.58, 6.75, 0, 7.38, 7.53, 7.81,
            7.8, 7.96, 8.24],
          [22, 6.78, 6.96, 7.32, 7.23, 7.42, 0, 8.11, 8.28, 8.58,
            8.57, 8.75, 9.05],
          [22, 6.97, 7.21, 7.57, 7.43, 7.69, 0, 8.3, 8.59, 9.02,
            9.28, 9.6, 10.08],
          [22, 6.9, 7.14, 7.49, 7.36, 7.61, 0, 8.22, 8.5, 8.93,
            9.19, 9.51, 9.98],
          [30, 5.97, 6.13, 6.46, 6.37, 6.54, 0, 7.34, 7.49, 7.76,
            7.75, 7.92, 8.19],
          [30, 6.56, 6.74, 7.1, 7, 7.19, 0, 8.07, 8.23, 8.53, 8.52,
            8.7, 9],
          [30, 6.93, 7.17, 7.53, 7.39, 7.65, 0, 8.25, 8.54, 8.97,
            9.23, 9.55, 10.03],
          [30, 6.86, 7.1, 7.46, 7.32, 7.57, 0, 8.17, 8.46, 8.88,
            9.14, 9.46, 9.93],
          [37, 5.97, 6.13, 6.46, 6.37, 6.54, 0, 7.34, 7.49, 7.76,
            7.75, 7.92, 8.19],
          [37, 6.56, 6.74, 7.1, 7, 7.19, 0, 8.07, 8.23, 8.53, 8.52,
            8.7, 9],
          [37, 6.93, 7.17, 7.53, 7.39, 7.65, 0, 8.25, 8.54, 8.97,
            9.23, 9.55, 10.03],
          [37, 6.86, 7.1, 7.46, 7.32, 7.57, 0, 8.17, 8.46, 8.88,
            9.14, 9.46, 9.93],
          [45, 5.66, 5.93, 6.27, 6.04, 6.32, 0, 6.68, 6.95, 7.43,
            7.16, 7.54, 7.92],
          [45, 6.22, 6.52, 6.89, 6.64, 6.95, 0, 7.34, 7.64, 8.17,
            7.87, 8.29, 8.7],
          [45, 6.41, 6.82, 7.24, 6.84, 7.27, 0, 7.62, 8.12, 8.62,
            8.53, 9.09, 9.64],
          [45, 6.35, 6.76, 7.17, 6.78, 7.2, 0, 7.55, 8.04, 8.54,
            8.45, 9, 9.55],

          [55, 5.4, 5.72, 6.1, 5.76, 6.11, 0, 6.42, 6.73, 7.25,
            6.87, 7.3, 7.89],
          [55, 5.93, 6.29, 6.7, 6.33, 6.71, 0, 7.05, 7.4, 7.97,
            7.55, 8.02, 8.67],
          [55, 6.09, 6.62, 7.21, 6.5, 7.06, 0, 7.26, 7.88, 8.59,
            8.12, 8.82, 9.6],
          [55, 6.03, 6.55, 7.14, 6.44, 6.99, 0, 7.17, 7.8, 8.5,
            8.04, 8.73, 9.5],

          [63, 5.4, 5.72, 6.1, 5.76, 6.11, 0, 6.42, 6.73, 7.25,
            6.87, 7.3, 7.89],
          [63, 5.93, 6.29, 6.7, 6.33, 6.71, 0, 7.05, 7.4, 7.97,
            7.55, 8.02, 8.67],
          [63, 6.09, 6.62, 7.21, 6.5, 7.06, 0, 7.26, 7.88, 8.59,
            8.12, 8.82, 9.6],
          [63, 6.03, 6.55, 7.14, 6.44, 6.99, 0, 7.17, 7.8, 8.5,
            8.04, 8.73, 9.5],
          [75, 5.4, 5.71, 6.09, 5.76, 6.1, 0, 6.41, 6.72, 7.24,
            6.86, 7.29, 7.88],
          [75, 5.93, 6.28, 6.69, 6.33, 6.7, 0, 7.04, 7.39, 7.96,
            7.54, 8.01, 8.66],
          [75, 6.08, 6.61, 7.2, 6.49, 7.05, 0, 7.25, 7.87, 8.58,
            8.11, 8.81, 9.59],
          [75, 6.02, 6.54, 7.13, 6.43, 6.8, 0, 7.18, 7.79, 8.49,
            8.03, 8.72, 9.5],
          [90, 5.31, 5.61, 0, 5.67, 5.98, 0, 6.34, 6.66, 0, 6.8,
            7.22, 0],
          [90, 5.84, 6.16, 0, 6.23, 6.57, 0, 6.97, 7.32, 0, 7.47,
            7.93, 0],
          [90, 6.02, 6.55, 0, 6.42, 6.99, 0, 7.17, 7.79, 0, 8.02,
            8.72, 0],
          [90, 5.96, 6.49, 0, 6.36, 6.92, 0, 7.1, 7.71, 0, 7.94,
            8.63, 0],
          [110, 5.27, 5.51, 0, 5.61, 5.87, 0, 6.27, 6.55, 0, 6.69,
            7.12, 0],
          [110, 5.79, 6.05, 0, 6.17, 6.45, 0, 6.89, 7.2, 0, 7.35,
            7.82, 0],
          [110, 6, 6.43, 0, 6.4, 6.86, 0, 7.14, 7.66, 0, 7.99, 8.57,
            0],
          [110, 5.94, 6.37, 0, 6.34, 6.79, 0, 7.07, 7.58, 0, 7.91,
            8.48, 0],
          [132, 5.25, 5.48, 0, 5.6, 5.84, 0, 6.24, 6.52, 0, 6.66,
            7.09, 0],
          [132, 5.77, 6.02, 0, 6.15, 6.42, 0, 6.86, 7.17, 0, 7.32,
            7.79, 0],
          [132, 6, 6.4, 0, 6.4, 6.83, 0, 7.11, 7.62, 0, 7.96, 8.53,
            0],
          [132, 5.94, 6.34, 0, 6.34, 6.76, 0, 7.04, 7.54, 0, 7.88,
            8.45, 0],
          [160, 5.25, 5.44, 0, 5.6, 5.81, 0, 6.21, 6.49, 0, 6.62,
            7.04, 0],
          [160, 5.77, 5.98, 0, 6.15, 6.38, 0, 6.82, 7.13, 0, 7.28,
            7.74, 0],
          [160, 6, 6.37, 0, 6.4, 6.79, 0, 7.07, 7.58, 0, 7.91, 8.48,
            0],
          [160, 5.94, 6.31, 0, 6.34, 6.72, 0, 7, 7.51, 0, 7.83, 8.4,
            0],
          [200, 5.25, 5.42, 0, 5.6, 5.79, 0, 6.19, 6.38, 0, 6.6,
            6.93, 0],
          [200, 5.77, 5.96, 0, 6.15, 6.36, 0, 6.8, 7.01, 0, 7.25,
            7.61, 0],
          [200, 5.99, 6.37, 0, 6.39, 6.79, 0, 7.07, 7.53, 0, 7.91,
            8.43, 0],
          [200, 5.93, 6.31, 0, 6.33, 6.72, 0, 7, 7.46, 0, 7.83,
            8.35, 0],
          [250, 5.25, 5.41, 0, 5.6, 5.77, 0, 6.19, 6.38, 0, 6.6,
            6.93, 0],
          [250, 5.77, 5.94, 0, 6.15, 6.34, 0, 6.8, 7.01, 0, 7.25,
            7.61, 0],
          [250, 5.99, 6.33, 0, 6.39, 6.75, 0, 7.07, 7.45, 0, 7.91,
            8.33, 0],
          [250, 5.93, 6.27, 0, 6.33, 6.68, 0, 7, 6.37, 0, 7.83,
            8.25, 0],
          [315, 5.23, 5.4, 0, 5.59, 5.75, 0, 6.16, 6.32, 0, 6.58,
            6.86, 0],
          [315, 5.75, 5.93, 0, 6.14, 6.32, 0, 6.77, 6.95, 0, 7.23,
            7.54, 0],
          [315, 5.95, 6.26, 0, 6.35, 6.68, 0, 7.07, 7.45, 0, 7.91,
            8.33, 0],
          [315, 5.89, 6.2, 0, 6.29, 6.61, 0, 7, 7.38, 0, 7.83, 8.25,
            0],
          [355, 5.22, 5.39, 0, 5.57, 5.74, 0, 6.16, 6.32, 0, 6.58,
            6.86, 0],
          [355, 5.74, 5.92, 0, 6.12, 6.31, 0, 6.77, 6.95, 0, 7.23,
            7.54, 0],
          [355, 5.94, 6.24, 0, 6.34, 6.66, 0, 7.07, 7.45, 0, 7.91,
            8.33, 0],
          [355, 5.88, 6.18, 0, 6.28, 6.59, 0, 7, 7.38, 0, 7.83,
            8.25, 0],
          [400, 5.21, 5.37, 0, 5.56, 5.73, 0, 6.16, 6.32, 0, 6.58,
            6.86, 0],
          [400, 5.73, 5.9, 0, 6.11, 6.3, 0, 6.77, 6.95, 0, 7.23,
            7.54, 0],
          [400, 5.93, 6.23, 0, 6.33, 6.65, 0, 7.07, 7.45, 0, 7.91,
            8.33, 0],
          [400, 5.87, 6.17, 0, 6.27, 6.58, 0, 7, 7.38, 0, 7.83,
            8.25, 0],
          [450, 5.2, 5.36, 0, 5.55, 5.71, 0, 0, 0, 0, 0, 0, 0],
          [450, 5.71, 5.89, 0, 6.1, 6.28, 0, 0, 0, 0, 0, 0, 0],
          [450, 5.89, 6.16, 0, 6.28, 6.57, 0, 0, 0, 0, 0, 0, 0],
          [450, 5.83, 6.1, 0, 6.22, 6.5, 0, 0, 0, 0, 0, 0, 0],
          [500, 5.2, 5.35, 0, 5.55, 5.71, 0, 0, 0, 0, 0, 0, 0],
          [500, 5.71, 5.88, 0, 6.1, 6.27, 0, 0, 0, 0, 0, 0, 0],
          [500, 5.88, 6.15, 0, 6.27, 6.56, 0, 0, 0, 0, 0, 0, 0],
          [500, 5.82, 6.09, 0, 6.21, 6.49, 0, 0, 0, 0, 0, 0, 0],
          [560, 5.19, 5.34, 0, 5.53, 5.7, 0, 0, 0, 0, 0, 0, 0],
          [560, 5.7, 5.87, 0, 6.08, 6.26, 0, 0, 0, 0, 0, 0, 0],
          [560, 5.87, 6.14, 0, 6.26, 6.55, 0, 0, 0, 0, 0, 0, 0],
          [560, 5.81, 6.08, 0, 6.2, 6.48, 0, 0, 0, 0, 0, 0, 0]],
        T_6: [[0, 0.7, 0.7, 0.8, 0.8, 1, 1, 1.25, 1.25],
          [2.2, 0, 8.2, 0, 8.7, 0, 9.8, 0, 11],
          [2.2, 0, 9.2, 0, 9.8, 0, 11, 0, 12.4],
          [2.2, 0, 10.4, 0, 11.1, 0, 12.4, 0, 14],
          [2.2, 0, 10.3, 0, 11, 0, 12.3, 0, 13.9],
          [3, 0, 8.2, 0, 8.7, 0, 9.8, 0, 11],
          [3, 0, 9.2, 0, 9.8, 0, 11, 0, 12.4],
          [3, 0, 10.4, 0, 11.1, 0, 12.4, 0, 14],
          [3, 0, 10.3, 0, 11, 0, 12.3, 0, 13.9],
          [4, 0, 8.2, 0, 8.7, 0, 9.8, 0, 11],
          [4, 0, 9.2, 0, 9.8, 0, 11, 0, 12.4],
          [4, 0, 10.4, 0, 11.1, 0, 12.4, 0, 14],
          [4, 0, 10.3, 0, 11, 0, 12.3, 0, 13.9],
          [5.5, 0, 8.2, 0, 8.7, 0, 9.8, 0, 11],
          [5.5, 0, 9.2, 0, 9.8, 0, 11, 0, 12.4],
          [5.5, 0, 10.4, 0, 11.1, 0, 12.4, 0, 14],
          [5.5, 0, 10.3, 0, 11, 0, 12.3, 0, 13.9],
          [7.5, 6.9, 7.5, 7.3, 7.9, 8.6, 8.7, 9.5, 9.9],
          [7.5, 7.7, 8.4, 8.2, 8.9, 9.7, 9.9, 10.8, 11.2],
          [7.5, 9.1, 9.6, 9.6, 10.2, 10.8, 11.3, 12.2, 12.8],
          [7.5, 9, 9.5, 9.5, 10.1, 10.7, 11.2, 12.1, 12.7],
          [11, 6.9, 7.5, 7.3, 7.9, 8.6, 8.7, 9.5, 9.9],
          [11, 7.7, 8.4, 8.2, 8.9, 9.7, 9.9, 10.8, 11.2],
          [11, 9.1, 9.6, 9.6, 10.2, 10.8, 11.3, 12.2, 12.8],
          [11, 9, 9.5, 9.5, 10.1, 10.7, 11.2, 12.1, 12.7],
          [15, 6.5, 6.9, 6.9, 7.4, 8.2, 8.3, 9.3, 9.5],
          [15, 7.3, 7.9, 7.7, 8.4, 9.2, 9.4, 10.4, 10.7],
          [15, 8.4, 9, 8.9, 9.5, 10.3, 10.8, 11.6, 12.2],
          [15, 8.3, 8.9, 8.8, 9.4, 10.2, 10.7, 11.5, 12.1],
          [18.5, 6.5, 6.9, 6.9, 7.4, 8.2, 8.3, 9.3, 9.5],
          [18.5, 7.3, 7.9, 7.7, 8.4, 9.2, 9.4, 10.4, 10.7],
          [18.5, 8.4, 9, 8.9, 9.5, 10.3, 10.8, 11.6, 12.2],
          [18.5, 8.3, 8.9, 8.8, 9.4, 10.2, 10.7, 11.5, 12.1],
          [22, 6.2, 6.8, 6.6, 7.2, 7.8, 8.1, 8.7, 9.1],
          [22, 7, 7.6, 7.4, 8.1, 8.8, 9.1, 9.8, 10.2],
          [22, 8, 8.4, 8.5, 8.9, 9.9, 10.3, 11, 11.6],
          [22, 7.9, 8.3, 8.4, 8.8, 9.8, 10.2, 10.9, 11.5],
          [30, 6.2, 6.8, 6.6, 7.2, 7.8, 8.1, 8.7, 9.1],
          [30, 7, 7.6, 7.4, 8.1, 8.8, 9.1, 9.8, 10.2],
          [30, 8, 8.4, 8.5, 8.9, 9.9, 10.3, 11, 11.6],
          [30, 7.9, 8.3, 8.4, 8.8, 9.8, 10.2, 10.9, 11.5],
          [37, 6.2, 6.8, 6.6, 7.2, 7.8, 8.1, 8.7, 9.1],
          [37, 7, 7.6, 7.4, 8.1, 8.8, 9.1, 9.8, 10.2],
          [37, 8, 8.4, 8.5, 8.9, 9.9, 10.3, 11, 11.6],
          [37, 7.9, 8.3, 8.4, 8.8, 9.8, 10.2, 10.9, 11.5],
          [45, 6.2, 6.8, 6.6, 7.2, 7.8, 8.1, 8.7, 9.1],
          [45, 7, 7.6, 7.4, 8.1, 8.8, 9.1, 9.8, 10.2],
          [45, 8, 8.4, 8.5, 8.9, 9.9, 10.3, 11, 11.6],
          [45, 7.9, 8.3, 8.4, 8.8, 9.8, 10.2, 10.9, 11.5],
          [55, 5.8, 6.1, 6.1, 6.5, 7.5, 7.7, 8.4, 8.6],
          [55, 6.5, 6.9, 6.9, 7.3, 8.4, 8.7, 9.4, 9.7],
          [55, 7.6, 7.9, 8.1, 8.4, 9.4, 9.9, 10.5, 11.1],
          [55, 7.5, 7.8, 8, 8.3, 9.3, 9.8, 10.4, 11],
          [63, 5.8, 6.1, 6.1, 6.5, 7.5, 7.7, 8.4, 8.6],
          [63, 6.5, 6.9, 6.9, 7.3, 8.4, 8.7, 9.4, 9.7],
          [63, 7.6, 7.9, 8.1, 8.4, 9.4, 9.9, 10.5, 11.1],
          [63, 7.5, 7.8, 8, 8.3, 9.3, 9.8, 10.4, 11],
          [75, 5.8, 6.1, 6.1, 6.5, 7.5, 7.7, 8.4, 8.6],
          [75, 6.5, 6.9, 6.9, 7.3, 8.4, 8.7, 9.4, 9.7],
          [75, 7.6, 7.9, 8.1, 8.4, 9.4, 9.9, 10.5, 11.1],
          [75, 7.5, 7.8, 8, 8.3, 9.3, 9.8, 10.4, 11],
          [90, 5.8, 6.1, 6.1, 6.5, 7.5, 7.7, 8.4, 8.6],
          [90, 6.5, 6.9, 6.9, 7.3, 8.4, 8.7, 9.4, 9.7],
          [90, 7.6, 7.9, 8.1, 8.4, 9.4, 9.9, 10.5, 11.1],
          [90, 7.5, 7.8, 8, 8.3, 9.3, 9.8, 10.4, 11],
          [110, 5.6, 6, 6, 6.3, 7.2, 7.4, 8.1, 8.4],
          [110, 6.3, 6.7, 6.7, 7.1, 8.1, 8.3, 9.1, 9.4],
          [110, 7.2, 7.6, 7.6, 8.1, 9.1, 9.6, 10.1, 10.7],
          [110, 7.1, 7.5, 7.5, 8, 9, 9.5, 10, 10.6],
          [132, 5.6, 6, 6, 6.3, 7.2, 7.4, 8.1, 8.4],
          [132, 6.3, 6.7, 6.7, 7.1, 8.1, 8.3, 9.1, 9.4],
          [132, 7.2, 7.6, 7.6, 8.1, 9.1, 9.6, 10.1, 10.7],
          [132, 7.1, 7.5, 7.5, 8, 9, 9.5, 10, 10.6],
          [160, 5.6, 6, 6, 6.3, 7.2, 7.4, 8.1, 8.4],
          [160, 6.3, 6.7, 6.7, 7.1, 8.1, 8.3, 9.1, 9.4],
          [160, 7.2, 7.6, 7.6, 8.1, 9.1, 9.6, 10.1, 10.7],
          [160, 7.1, 7.5, 7.5, 8, 9, 9.5, 10, 10.6],
          [200, 5.3, 5.5, 5.7, 5.9, 7, 7.2, 7.8, 8.2],
          [200, 6, 6.2, 6.4, 6.6, 7.9, 8.1, 8.8, 9.2],
          [200, 6.8, 7.2, 7.5, 7.9, 8.9, 9.4, 9.8, 10.5],
          [200, 6.7, 7.1, 7.4, 7.8, 8.8, 9.3, 9.7, 10.4],
          [250, 5.3, 5.5, 5.7, 5.9, 7, 7.2, 7.8, 8.2],
          [250, 6, 6.2, 6.4, 6.6, 7.9, 8.1, 8.8, 9.2],
          [250, 6.8, 7.2, 7.5, 7.9, 8.9, 9.4, 9.8, 10.5],
          [250, 6.7, 7.1, 7.4, 7.8, 8.8, 9.3, 9.7, 10.4],
          [315, 5.3, 5.5, 5.7, 5.9, 7, 7.2, 7.8, 8.2],
          [315, 6, 6.2, 6.4, 6.6, 7.9, 8.1, 8.8, 9.2],
          [315, 6.8, 7.2, 7.5, 7.9, 8.9, 9.4, 9.8, 10.5],
          [315, 6.7, 7.1, 7.4, 7.8, 8.8, 9.3, 9.7, 10.4],
          [355, 5.2, 0, 5.4, 0, 6.7, 0, 7.4, 0],
          [355, 5.8, 0, 6.1, 0, 7.5, 0, 8.3, 0],
          [355, 6.4, 0, 7.1, 0, 8.5, 0, 9.4, 0],
          [355, 6.3, 0, 7, 0, 8.4, 0, 9.3, 0],
          [400, 5.2, 0, 5.4, 0, 6.7, 0, 7.4, 0],
          [400, 5.8, 0, 6.1, 0, 7.5, 0, 8.3, 0],
          [400, 6.4, 0, 7.1, 0, 8.5, 0, 9.4, 0],
          [400, 6.3, 0, 7, 0, 8.4, 0, 9.3, 0],
          [450, 5.2, 0, 5.4, 0, 6.7, 0, 7.4, 0],
          [450, 5.8, 0, 6.1, 0, 7.5, 0, 8.3, 0],
          [450, 6.4, 0, 7.1, 0, 8.5, 0, 9.4, 0],
          [450, 6.3, 0, 7, 0, 8.4, 0, 9.3, 0],
          [500, 5.2, 0, 5.4, 0, 6.7, 0, 7.4, 0],
          [500, 5.8, 0, 6.1, 0, 7.5, 0, 8.3, 0],
          [500, 6.4, 0, 7.1, 0, 8.5, 0, 9.4, 0],
          [500, 6.3, 0, 7, 0, 8.4, 0, 9.3, 0],
          [560, 5.2, 0, 5.4, 0, 6.7, 0, 7.4, 0],
          [560, 5.8, 0, 6.1, 0, 7.5, 0, 8.3, 0],
          [560, 6.4, 0, 7.1, 0, 8.5, 0, 9.4, 0],
          [560, 6.3, 0, 7, 0, 8.4, 0, 9.3, 0],
          [630, 5.2, 0, 5.4, 0, 6.7, 0, 7.4, 0],
          [630, 5.8, 0, 6.1, 0, 7.5, 0, 8.3, 0],
          [630, 6.4, 0, 7.1, 0, 8.5, 0, 9.4, 0],
          [630, 6.3, 0, 7, 0, 8.4, 0, 9.3, 0]],
        T_7_Under1500: [
          [0, 0.4, 0.4, 0.5, 0.5, 0.7, 0.7, 1.0, 1.0],
          [1.5, 0, 0, 0, 0, 8.7, 8.9, 0, 10.6],
          [1.5, 0, 0, 0, 0, 9.6, 9.8, 0, 11.6],
          [1.5, 0, 0, 0, 0, 11.2, 11.7, 0, 13.8],
          [1.5, 0, 0, 0, 0, 11.1, 11.6, 0, 13.7],
          [2.2, 0, 0, 0, 0, 8.5, 8.6, 0, 10.3],
          [2.2, 0, 0, 0, 0, 9.3, 9.5, 0, 11.3],
          [2.2, 0, 0, 0, 0, 10.5, 10.8, 0, 12.8],
          [2.2, 0, 0, 0, 0, 10.4, 10.7, 0, 12.7],
          [3, 0, 0, 0, 0, 8.3, 8.6, 0, 10.1],
          [3, 0, 0, 0, 0, 9.1, 9.4, 0, 11.1],
          [3, 0, 0, 0, 0, 10.5, 10.8, 0, 12.8],
          [3, 0, 0, 0, 0, 10.4, 10.7, 0, 12.7],
          [4, 0, 0, 0, 0, 7.9, 8.2, 0, 9.6],
          [4, 0, 0, 0, 0, 8.7, 9, 0, 10.6],
          [4, 0, 0, 0, 0, 10, 10.3, 0, 12.2],
          [4, 0, 0, 0, 0, 9.9, 10.2, 0, 12.1],
          [5.5, 6.6, 6.7, 0, 7.1, 7.8, 7.9, 0, 9.4],
          [5.5, 7.2, 7.4, 0, 7.8, 8.6, 8.7, 0, 10.3],
          [5.5, 8.4, 8.6, 0, 9, 9.7, 10, 0, 11.7],
          [5.5, 8.3, 8.5, 0, 8.9, 9.6, 9.9, 0, 11.6],
          [7.5, 6.6, 6.7, 0, 7, 7.7, 7.9, 0, 9.3],
          [7.5, 7.2, 7.4, 0, 7.7, 8.5, 8.7, 0, 10.2],
          [7.5, 8.3, 8.6, 0, 8.9, 9.6, 9.9, 0, 11.6],
          [7.5, 8.2, 8.5, 0, 8.8, 9.5, 9.8, 0, 11.5],
          [11, 6.2, 6.5, 0, 6.7, 7.4, 7.6, 0, 0],
          [11, 6.8, 7.1, 0, 7.4, 8.1, 8.3, 0, 0],
          [11, 7.8, 8.2, 0, 8.5, 9.1, 9.5, 0, 0],
          [11, 7.7, 8.1, 0, 8.4, 9, 9.4, 0, 0],
          [15, 6.1, 6.4, 0, 6.6, 7.3, 7.5, 0, 0],
          [15, 6.7, 7, 0, 7.3, 8, 8.2, 0, 0],
          [15, 7.7, 8.1, 0, 8.4, 9, 9.4, 0, 0],
          [15, 7.6, 8, 0, 8.3, 8.9, 9.3, 0, 0],
          [18.5, 6, 6.3, 0, 6.6, 7.2, 7.5, 0, 0],
          [18.5, 6.6, 6.9, 0, 7.3, 7.9, 8.2, 0, 0],
          [18.5, 7.5, 7.8, 0, 8.2, 8.8, 9.1, 0, 0],
          [18.5, 7.4, 7.7, 0, 8.1, 8.7, 9, 0, 0],
          [22, 5.8, 6, 0, 6.4, 6.9, 7.1, 0, 0],
          [22, 6.4, 6.6, 0, 7, 7.6, 7.8, 0, 0],
          [22, 7.2, 7.5, 0, 7.8, 8.5, 8.7, 0, 0],
          [22, 7.1, 7.4, 0, 7.7, 8.4, 8.6, 0, 0],
          [30, 5.7, 6, 0, 6.3, 6.8, 7, 0, 0],
          [30, 6.3, 6.6, 0, 6.9, 7.5, 7.7, 0, 0],
          [30, 7.2, 7.4, 0, 7.7, 8.4, 8.7, 0, 0],
          [30, 7.1, 7.3, 0, 7.6, 8.3, 8.6, 0, 0],
          [37, 5.7, 5.9, 0, 6.2, 6.8, 7, 0, 0],
          [37, 6.3, 6.5, 0, 6.8, 7.5, 7.7, 0, 0],
          [37, 7.2, 7.4, 0, 7.7, 8.4, 8.7, 0, 0],
          [37, 7.1, 7.3, 0, 7.6, 8.3, 8.6, 0, 0],
          [45, 5.6, 5.8, 0, 6.2, 6.7, 6.9, 0, 0],
          [45, 6.2, 6.4, 0, 6.8, 7.4, 7.6, 0, 0],
          [45, 7.1, 7.4, 0, 7.7, 8.4, 8.6, 0, 0],
          [45, 7, 7.3, 0, 7.6, 8.3, 8.5, 0, 0],
          [55, 5.6, 5.6, 0, 0, 6.6, 6.8, 0, 0],
          [55, 6.1, 6.2, 0, 0, 7.3, 7.5, 0, 0],
          [55, 7, 7.1, 0, 0, 8.1, 8.3, 0, 0],
          [55, 6.9, 7, 0, 0, 8, 8.2, 0, 0],
          [63, 5.6, 5.6, 0, 0, 6.6, 6.7, 0, 0],
          [63, 6.1, 6.2, 0, 0, 7.2, 7.4, 0, 0],
          [63, 7, 7.1, 0, 0, 8.1, 8.3, 0, 0],
          [63, 6.9, 7, 0, 0, 8, 8.2, 0, 0],
          [75, 5.6, 5.6, 0, 0, 6.5, 6.6, 0, 0],
          [75, 6.1, 6.2, 0, 0, 7.1, 7.3, 0, 0],
          [75, 7, 7.1, 0, 0, 8.1, 8.3, 0, 0],
          [75, 6.9, 7, 0, 0, 8, 8.2, 0, 0],
          [90, 5.5, 5.6, 0, 0, 6.4, 6.6, 0, 0],
          [90, 6, 6.1, 0, 0, 7, 7.2, 0, 0],
          [90, 6.8, 6.9, 0, 0, 7.9, 8.1, 0, 0],
          [90, 6.7, 6.8, 0, 0, 7.8, 8, 0, 0],
          [110, 5.5, 5.6, 0, 0, 6.4, 6.6, 0, 0],
          [110, 6, 6.1, 0, 0, 7, 7.2, 0, 0],
          [110, 6.8, 6.9, 0, 0, 7.9, 8.1, 0, 0],
          [110, 6.7, 6.8, 0, 0, 7.8, 8, 0, 0],
          [132, 5.3, 5.4, 0, 0, 6.3, 6.6, 0, 0],
          [132, 5.8, 5.9, 0, 0, 6.9, 7.2, 0, 0],
          [132, 6.6, 6.8, 0, 0, 7.6, 8, 0, 0],
          [132, 6.5, 6.7, 0, 0, 7.5, 7.9, 0, 0],
          [160, 5.3, 5.4, 0, 0, 6.3, 6.5, 0, 0],
          [160, 5.8, 5.9, 0, 0, 6.9, 7.1, 0, 0],
          [160, 6.6, 6.7, 0, 0, 7.6, 7.9, 0, 0],
          [160, 6.5, 6.6, 0, 0, 7.5, 7.8, 0, 0]],
        T_7_Up1500: [[0, 0.4, 0.4, 0.5, 0.5, 0.7, 0.7],
          [1.5, 0, 0, 0, 0, 8.8, 9.1],
          [1.5, 0, 0, 0, 0, 9.7, 10],
          [1.5, 0, 0, 0, 0, 11.5, 12.8],
          [1.5, 0, 0, 0, 0, 11.4, 12.7],
          [2.2, 0, 0, 0, 0, 8.6, 8.8],
          [2.2, 0, 0, 0, 0, 9.4, 9.7],
          [2.2, 0, 0, 0, 0, 10.8, 11.1],
          [2.2, 0, 0, 0, 0, 10.7, 11], [3, 0, 0, 0, 0, 8.4, 8.6],
          [3, 0, 0, 0, 0, 9.2, 9.5], [3, 0, 0, 0, 0, 10.8, 11.1],
          [3, 0, 0, 0, 0, 10.7, 11], [4, 0, 0, 0, 0, 8.1, 8.3],
          [4, 0, 0, 0, 0, 8.9, 9.1], [4, 0, 0, 0, 0, 10.3, 10.5],
          [4, 0, 0, 0, 0, 10.2, 10.4],
          [5.5, 6.9, 7.1, 0, 7.5, 7.9, 8.1],
          [5.5, 7.6, 7.8, 0, 8.2, 8.7, 8.9],
          [5.5, 8.8, 9, 0, 9.4, 10, 10.2],
          [5.5, 8.7, 8.9, 0, 9.3, 9.9, 10.1],
          [7.5, 6.8, 7, 0, 7.4, 7.9, 8],
          [7.5, 7.5, 7.7, 0, 8.1, 8.7, 8.8],
          [7.5, 8.7, 8.9, 0, 9.3, 9.9, 10.2],
          [7.5, 8.6, 8.8, 0, 9.2, 9.8, 10.1],
          [11, 6.5, 6.6, 0, 6.9, 7.5, 7.6],
          [11, 7.1, 7.3, 0, 7.6, 8.2, 8.4],
          [11, 8.2, 8.4, 0, 8.8, 9.5, 9.8],
          [11, 8.1, 8.3, 0, 8.7, 9.4, 9.7],
          [15, 6.4, 6.6, 0, 6.9, 7.4, 7.6],
          [15, 7, 7.2, 0, 7.6, 8.1, 8.3],
          [15, 8.1, 8.3, 0, 8.7, 9.4, 9.6],
          [15, 8, 8.2, 0, 8.6, 9.3, 9.5],
          [18.5, 6.3, 6.6, 0, 6.8, 7.3, 7.6],
          [18.5, 6.9, 7.2, 0, 7.5, 8, 8.3],
          [18.5, 7.8, 8.1, 0, 8.4, 9.1, 9.4],
          [18.5, 7.7, 8, 0, 8.3, 9, 9.3],
          [22, 6.1, 6.2, 0, 6.5, 7, 7.2],
          [22, 6.7, 6.8, 0, 7.1, 7.7, 7.9],
          [22, 7.6, 7.7, 0, 8, 8.8, 9.1],
          [22, 7.5, 7.6, 0, 7.9, 8.7, 9],
          [30, 6.1, 6.1, 0, 6.5, 6.9, 7.1],
          [30, 6.7, 6.7, 0, 7.1, 7.6, 7.8],
          [30, 7.5, 7.7, 0, 8, 8.8, 9],
          [30, 7.4, 7.6, 0, 7.9, 8.7, 8.9],
          [37, 6, 6.1, 0, 6.4, 6.9, 7.1],
          [37, 6.6, 6.7, 0, 7, 7.6, 7.8],
          [37, 7.5, 7.7, 0, 8, 8.8, 9],
          [37, 7.4, 7.6, 0, 7.9, 8.7, 8.9],
          [45, 6, 6, 0, 6.4, 6.8, 7],
          [45, 6.6, 6.6, 0, 7, 7.5, 7.7],
          [45, 7.5, 7.6, 0, 7.9, 8.7, 9],
          [45, 7.4, 7.5, 0, 7.8, 8.6, 8.9],
          [55, 5.7, 5.8, 0, 0, 6.7, 6.9],
          [55, 6.3, 6.4, 0, 0, 7.4, 7.6],
          [55, 7.2, 7.3, 0, 0, 8.5, 8.7],
          [55, 7.1, 7.2, 0, 0, 8.4, 8.6],
          [63, 5.7, 5.8, 0, 0, 6.6, 6.8],
          [63, 6.3, 6.4, 0, 0, 7.3, 7.5],
          [63, 7.2, 7.3, 0, 0, 8.5, 8.7],
          [63, 7.1, 7.2, 0, 0, 8.4, 8.6],
          [75, 5.7, 5.8, 0, 0, 6.6, 6.8],
          [75, 6.3, 6.4, 0, 0, 7.2, 7.5],
          [75, 7.2, 7.3, 0, 0, 8.5, 8.7],
          [75, 7.1, 7.2, 0, 0, 8.4, 8.6],
          [90, 5.6, 5.7, 0, 0, 6.5, 6.6],
          [90, 6.2, 6.3, 0, 0, 7.1, 7.3],
          [90, 7, 7.1, 0, 0, 8.3, 8.5],
          [90, 6.9, 7, 0, 0, 8.2, 8.4],
          [110, 5.6, 5.7, 0, 0, 6.5, 6.6],
          [110, 6.2, 6.3, 0, 0, 7.1, 7.3],
          [110, 7, 7.1, 0, 0, 8.3, 8.5],
          [110, 6.9, 7, 0, 0, 8.2, 8.4],
          [132, 5.4, 5.6, 0, 0, 6.4, 6.6],
          [132, 5.9, 6.1, 0, 0, 7, 7.3],
          [132, 6.8, 7, 0, 0, 8, 8.3],
          [132, 6.7, 6.9, 0, 0, 7.9, 8.2],
          [160, 5.4, 5.6, 0, 0, 6.4, 6.6],
          [160, 5.9, 6.1, 0, 0, 7, 7.2],
          [160, 6.7, 7, 0, 0, 7.9, 8.3],
          [160, 6.6, 6.9, 0, 0, 7.8, 8.2]],
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

      },
      P19_T1_T4_nxdj(tab, gl, yl, val) {
        var i = 0, j = 0;
        var nxdj = "";
        for (j = 1; j < tab[0].length; j++) {
          if (yl == tab[0][j]) {
            break;
          }
        }
        if (j >= tab[0].length) {
          return nxdj;
        }
        for (i = 1; i < tab.length; i++) {
          if (gl == tab[i][0]) {
            if (tab[i][j] == 0) {
              nxdj = "任意";
              break;
            }
            if (val <= tab[i][j]) {
              nxdj = "1";
            } else if (val <= tab[i + 1][j]) {
              nxdj = "2";
            } else if (val <= tab[i + 3][j]) {
              nxdj = "3";
            }
            break;
          }
        }
        return nxdj;
      },
      P19_T5_nxdj(tab, gl, yl, slfl, yywy, val) {
        var i = 0, j = 0;
        var nxdj = "";
        for (j = 1; j < tab[0].length; j++) {
          if (yl == tab[0][j]) {
            break;
          }
        }
        if (j >= tab[0].length) {
          return nxdj;
        }
        var idx = 0;
        if ("水冷" == slfl && "有油" == yywy) {
          idx = 0;
        } else if ("水冷" == slfl && "无油" == yywy) {
          idx = 1;
        } else if ("风冷" == slfl && "有油" == yywy) {
          idx = 2;
        } else if ("风冷" == slfl && "无油" == yywy) {
          nxdj = "任意";
        } else {
          return nxdj;
        }
        for (i = 1; i < tab.length; i++) {
          if (gl == tab[i][0]) {
            if (tab[i][j + idx] == 0) {
              nxdj = "任意";
              break;
            }
            if (val <= tab[i][j + idx]) {
              nxdj = "1";
            } else if (val <= tab[i + 1][j + idx]) {
              nxdj = "2";
            } else if (val <= tab[i + 3][j + idx]) {
              nxdj = "3";
            }
            break;
          }
        }
        return nxdj;
      },
      P19_T6_T7_nxdj(tab, gl, yl, slfl, val) {
        var i = 0, j = 0;
        var nxdj = "";
        for (j = 1; j < tab[0].length; j++) {
          if (yl == tab[0][j]) {
            break;
          }
        }
        if (j >= tab[0].length) {
          return nxdj;
        }
        var idx = 0;
        if ("水冷" == slfl) {
          idx = 0;
        } else if ("风冷" == slfl) {
          idx = 1;
        } else {
          return nxdj;
        }
        for (i = 1; i < tab.length; i++) {
          if (gl == tab[i][0]) {
            if (tab[i][j + idx] == 0) {
              nxdj = "任意";
              break;
            }
            if (val <= tab[i][j + idx]) {
              nxdj = "1";
            } else if (val <= tab[i + 1][j + idx]) {
              nxdj = "2";
            } else if (val <= tab[i + 3][j + idx]) {
              nxdj = "3";
            }
            break;
          }
        }
        return nxdj;
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
        var nxdj = "";
        var slfl = this.formRecord.c8
        var ysjs = this.formRecord.c9
        //*驱动电动机输入额定功率
        var gl = this.formRecord.c12;
        //额定排气压力
        var yl = this.formRecord.c13;
        //机组输入比功率 标称值
        var val = this.formRecord.c5;

        if ("一般用喷油滑片空气压缩机" == this.formRecord.c10) {
          if (this.formRecord.c11 <= 1500) {
            nxdj = this.P19_T6_T7_nxdj(this.T_7_Under1500, gl, yl, slfl, val);
          } else {
            nxdj = this.P19_T6_T7_nxdj(this.T_7_Up1500, gl, yl, slfl, val);
          }
        } else if ("一般用喷油单螺杆空气压缩机" == this.formRecord.c10
          || "一般用喷油螺杆空气压缩机" == this.formRecord.c10) {
          nxdj = this.P19_T6_T7_nxdj(this.T_6, gl, yl, slfl, val);
        } else if ("一般用固定的往复活塞空气压缩机" == this.formRecord.c10) {
          var yywy = this.formRecord.c22
          if (gl == "55") {
            if (this.formRecord.c30 != '') {
              var dzyszy = this.formRecord.c30
              if ("单作用空压机" == dzyszy) {
                nxdj = this.P19_T5_nxdj(this.T_5_DZY, gl, yl, slfl, yywy, val);
              } else if ("双作用空压机" == dzyszy) {
                nxdj = this.P19_T5_nxdj(T_5_SZY, gl, yl, slfl, yywy, val);
              }
            }
          } else {
            nxdj = this.P19_T5_nxdj(this.T_5_SZY, gl, yl, slfl, yywy, val);
          }
        } else if ("全无油润滑往复活塞空气压缩机" == this.formRecord.c10) {
          if ("单级" == ysjs) {
            nxdj = this.P19_T1_T4_nxdj(this.T_4_DJ, gl, yl, val);
          } else if ("两级" == ysjs) {
            if ("水冷" == slfl) {
              nxdj = this.P19_T1_T4_nxdj(this.T_4_LJ_SL, gl, yl, val);
            } else if ("风冷" == slfl) {
              nxdj = this.P19_T1_T4_nxdj(this.T_4_LJ_FL, gl, yl, val);
            }
          }
        } else if ("微型往复活塞空气压缩机" == this.formRecord.c10) {
          if ("单级" == ysjs) {
            nxdj = this.P19_T1_T4_nxdj(this.T_3_DJ, gl, yl, val);
          } else if ("两级" == ysjs) {
            nxdj = this.P19_T1_T4_nxdj(this.T_3_LJ, gl, yl, val);
          }
        } else if ("无油润滑直联便携式往复活塞空气压缩机" == this.formRecord.c10) {
          if ("单级" == ysjs) {
            nxdj = this.P19_T1_T4_nxdj(this.T_2_DJ, gl, yl, val);
          } else if ("两级" == ysjs) {
            nxdj = this.P19_T1_T4_nxdj(this.T_2_LJ, gl, yl, val);
          }
        } else if ("直联便携式往复活塞空气压缩机" == this.formRecord.c10) {
          if ("单级" == ysjs) {
            nxdj = this.P19_T1_T4_nxdj(this.T_1_DJ, gl, yl, val);
          } else if ("两级" == ysjs) {
            nxdj = this.P19_T1_T4_nxdj(this.T_1_LJ, gl, yl, val);
          }
        }
        const checkc20 = (rule, value, callback) => {
          if ("" == nxdj || "任意" == nxdj) {
            callback("能效数据不在备案范围");
          }
          if ("任意" != nxdj) {
            if (this.formRecord.c20 != nxdj) {
              callback("所选能效等级与计算结果不符！");
            }
          }
          callback()
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
        } else {
          return {
            c1: [
              {
                required: true,
                trigger: 'change,blur',
                message: '生产者名称不能为空'
              }
            ],
            c2: [
              {
                required: true,
                trigger: 'change,blur',
                message: '商标不能为空'
              }
            ],
            c3: [
              {
                required: true,
                trigger: 'change,blur',
                message: '产品型号不能为空'
              }
            ],
            c4: [
              {
                required: true,
                trigger: 'change,blur',
                message: '制造单位不能为空'
              }
            ],
            c5: [
              {
                required: true,
                trigger: 'change,blur',
                message: '标称值不能为空'
              }
            ],
            c200: [
              {
                required: true,
                trigger: 'change,blur',
                message: '依据国家标准不能为空'
              }
            ],
            c7: [
              {
                required: true,
                message: '初始使用日期不能为空'
              }
            ],
            c8: [
              {
                required: true,
                trigger: 'change,blur',
                message: '冷却方式不能为空'
              }
            ],
            c9: [
              {
                required: true,
                trigger: 'change,blur',
                message: '压缩级数不能为空'
              }
            ],
            c10: [
              {
                required: true,
                trigger: 'change,blur',
                message: '压缩机类型不能为空'
              }
            ],
            c11: [
              {
                required: true,
                trigger: 'change,blur',
                message: '额定转速不能为空'
              }
            ],
            c12: [
              {
                required: true,
                trigger: 'change,blur',
                message: '额定功率不能为空'
              }
            ],
            c13: [
              {
                required: true,
                trigger: 'change,blur',
                message: '额定排气压力不能为空'
              }
            ],
            c14: [
              {
                required: true,
                trigger: 'change,blur',
                message: '公称容积流量不能为空'
              }
            ],
            c15: [
              {
                required: true,
                trigger: 'change,blur',
                message: '运动机构润滑方式不能为空'
              }
            ],
            c16: [
              {
                required: true,
                trigger: 'change,blur',
                message: '气缸润滑方式不能为空'
              }
            ],
            c17: [
              {
                required: true,
                trigger: 'change,blur',
                message: '驱动方式不能为空'
              }
            ],
            c18: [
              {
                required: true,
                trigger: 'change,blur',
                message: '外形尺寸（长）不能为空'
              }
            ],
            c19: [
              {
                required: true,
                trigger: 'change,blur',
                message: '备案方不能为空'
              }
            ],
            c20: [
              {
                required: true,
                trigger: 'change,blur',
                message: '能效等级不能为空'
              },
              {
                validator: checkc20,
                trigger: 'change,blur'
              }
            ],
            c21: [
              {
                required: true,
                trigger: 'change,blur',
                message: '实测值不能为空'
              }
            ],
            c22: [
              {
                required: true,
                trigger: 'change,blur',
                message: '有油无油不能为空'
              }
            ],
            c23: [
              {
                required: true,
                trigger: 'change,blur',
                message: '净重不能为空'
              }
            ],
            c24: [
              {
                required: true,
                trigger: 'change,blur',
                message: '润滑介质名称或代号不能为空'
              }
            ],
            c25: [
              {
                required: true,
                trigger: 'change,blur',
                message: '灌注量不能为空'
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
                message: '频率不能为空'
              }
            ],
            c28: [
              {
                required: true,
                trigger: 'change,blur',
                message: '外形尺寸（宽）不能为空'
              }
            ],
            c29: [
              {
                required: true,
                trigger: 'change,blur',
                message: '外形尺寸（高）不能为空'
              }
            ],
            c30: [
              {
                required: true,
                trigger: 'change,blur',
                message: '单双作用选择不能为空'
              }
            ],
            c31: [
              {
                required: true,
                trigger: 'change,blur',
                message: '不能为空'
              }
            ],
            c32: [
              {
                required: true,
                trigger: 'change,blur',
                message: '不能为空'
              }
            ],
            c33: [
              {
                required: true,
                trigger: 'change,blur',
                message: '不能为空'
              }
            ],
            c34: [
              {
                required: true,
                trigger: 'change,blur',
                message: '不能为空'
              }
            ],
            c35: [
              {
                required: true,
                trigger: 'change,blur',
                message: '不能为空'
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
            c47: [
              {
                required: true,
                trigger: 'change,blur',
                message: '不能为空'
              }
            ],
            c48: [
              {
                required: true,
                trigger: 'change,blur',
                message: '不能为空'
              }
            ],
            c49: [
              {
                required: true,
                trigger: 'change,blur',
                message: '不能为空'
              }
            ],
            c50: [
              {
                required: true,
                trigger: 'change,blur',
                message: '不能为空'
              }
            ],
            c51: [
              {
                required: true,
                trigger: 'change,blur',
                message: '不能为空'
              }
            ],
            c52: [
              {
                required: true,
                trigger: 'change,blur',
                message: '不能为空'
              }
            ],
            c53: [
              {
                required: true,
                trigger: 'change,blur',
                message: '不能为空'
              }
            ],
            c54: [
              {
                required: true,
                trigger: 'change,blur',
                message: '不能为空'
              }
            ],
            c63: [
              {
                required: true,
                trigger: 'change,blur',
                message: '不能为空'
              }
            ],
            c64: [
              {
                required: true,
                trigger: 'change,blur',
                message: '不能为空'
              }
            ],
            c65: [
              {
                required: true,
                trigger: 'change,blur',
                message: '不能为空'
              }
            ],
            c69: [
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
            c81: [
              {
                required: true,
                trigger: 'change,blur',
                message: '不能为空'
              }
            ],
            c82: [
              {
                required: true,
                trigger: 'change,blur',
                message: '不能为空'
              }
            ],
            c83: [
              {
                required: true,
                trigger: 'change,blur',
                message: '不能为空'
              }
            ],
            c84: [
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
            ],
            c90: [
              {
                required: true,
                trigger: 'change,blur',
                message: '不能为空'
              }
            ],
            c91: [
              {
                required: true,
                trigger: 'change,blur',
                message: '不能为空'
              }
            ],
            c92: [
              {
                required: true,
                trigger: 'change,blur',
                message: '不能为空'
              }
            ],
            c93: [
              {
                required: true,
                trigger: 'change,blur',
                message: '不能为空'
              }
            ],
            c94: [
              {
                required: true,
                trigger: 'change,blur',
                message: '不能为空'
              }
            ],
            c101: [
              {
                required: true,
                trigger: 'change,blur',
                message: '不能为空'
              }
            ],
            c102: [
              {
                required: true,
                trigger: 'change,blur',
                message: '不能为空'
              }
            ],
            c103: [
              {
                required: true,
                trigger: 'change,blur',
                message: '不能为空'
              }
            ],
            c104: [
              {
                required: true,
                trigger: 'change,blur',
                message: '不能为空'
              }
            ],
            c105: [
              {
                required: true,
                trigger: 'change,blur',
                message: '不能为空'
              }
            ],
            c106: [
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

  .overwrite1 /deep/ span {
    width: 14px !important;
  }

  .overwrite2 /deep/ .ivu-checkbox-inner {
    width: 14px !important;
  }
</style>
