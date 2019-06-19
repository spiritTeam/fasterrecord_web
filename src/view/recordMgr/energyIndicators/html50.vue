/*
 * 4、冷水机组 2015版
 * 创建日期：2019年5月28号
 * 创建人：wlq
 * 1548148368400268526
 */
<template>
  <div class="wrapper">
    <Form ref="formRecord" :model="formRecord" label-position="right" :rules="ruleRecord">
      <h1>冷水机组 修订-能源效率标识备案表</h1>
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
                <Input type="text" :value="$store.state.app.labName" />
              </td>
              <td>
                <Input type="text" :value="$store.state.app.barcode" />
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
            <Input type="text" v-model="formRecord.c1" :disabled='disabledoff' placeholder="生产者名称" readonly />
          </FormItem>
          <FormItem prop="c3" label="制造单位" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c3" :disabled='disabledoff' placeholder="制造单位"/>
          </FormItem>
          <FormItem prop="c45" label="备案方" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c45" :disabled='disabledoff' placeholder="备案方" />
          </FormItem>            
          <FormItem prop="c4" label="产品规格型号" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c4" :di1sabled='!disabledoff' placeholder="产品规格型号" disabled/>
          </FormItem>
          <FormItem prop="c2" label="商标" style="width:100%" :label-width="180">
            <Input type="text" v-model="formRecord.c2" :disabled='disabledoff' placeholder="商标"/>
          </FormItem>
          <FormItem prop="c200" label="依据国家标准" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c200" placeholder="依据国家标准" readonly disabled/>
          </FormItem>
          <FormItem prop="c9" label="能效等级" style="width:100%;" :label-width="180">
            <RadioGroup v-model="formRecord.c9">
              <Radio label="1" :disabled='disabledoff'>1级</Radio>
              <Radio label="2" :disabled='disabledoff'>2级</Radio>
              <Radio label="3" :disabled='disabledoff'>3级</Radio>
            </RadioGroup>
          </FormItem>
          <FormItem prop="c300" label="能效等级判定依据" :label-width="180">
            <RadioGroup v-model="formRecord.c300">
              <Radio :disabled='disabledoff' label="性能系数">性能系数</Radio>
              <Radio :disabled='disabledoff' label="综合部分负荷性能系数">综合部分负荷性能系数</Radio>
            </RadioGroup>
          </FormItem>
          <table id="table1">
            <tr>
              <td align="center">制冷量(千瓦)</td>
              <td>
                 <FormItem prop="c5" label="标注值：" style="width:100%;" :label-width="80">
                   <Input type="text" v-model="formRecord.c5"  :disabled='disabledoff || forbidden.c5'/>
                 </FormItem>
              </td>
              <td>
                 <FormItem prop="c50" label="实测值：" style="width:100%;" :label-width="80">
                   <Input type="text" v-model="formRecord.c50" :disabled='disabledoff' />
                 </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center">消耗总电功率(千瓦)</td>
                <td>
                 <FormItem prop="c6" label="标注值：" style="width:100%;" :label-width="80">
                   <Input type="text" v-model="formRecord.c6"  :disabled='disabledoff || forbidden.c6'/>
                 </FormItem>
              </td>
              <td>
                 <FormItem prop="c51" label="实测值：" style="width:100%;" :label-width="80">
                   <Input type="text" v-model="formRecord.c51" :disabled='disabledoff'/>
                 </FormItem>
              </td>
            </tr>
            <tr>
              <td align="center">性能系数</td>
               <td>
                 <FormItem prop="c7" label="标注值：" style="width:100%;" :label-width="80">
                   <Input type="text" v-model="formRecord.c7"  :disabled='disabledoff || forbidden.c7'/>
                 </FormItem>
              </td>
              <td>
                 <FormItem prop="c52" label="实测值：" style="width:100%;" :label-width="80">
                   <Input type="text" v-model="formRecord.c52" :disabled='disabledoff'/>
                 </FormItem>
              </td>
            </tr>
             <tr>
              <td align="center">综合部分负荷性能系数</td>
               <td>
                 <FormItem prop="c8" label="标注值：" style="width:100%;" :label-width="80">
                   <Input type="text" v-model="formRecord.c8"  :disabled='disabledoff || forbidden.c8'/>
                 </FormItem>
              </td>
              <td>
                 <FormItem prop="c53" label="实测值：" style="width:100%;" :label-width="80">
                   <Input type="text" v-model="formRecord.c53" :disabled='disabledoff'/>
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
          <FormItem prop="c10" label="备案标识开始使用日期" style="width:100%;">
            <DatePicker type="date" :options="dataInit" style="width: 200px" v-model="formRecord.c10" :disabled='disabledoff'></DatePicker>
          </FormItem>
        </Card>
      </div>
      <div class="part part5">
        <Card :bordered="false">
          <h2>五、其他信息</h2>
          <br/>
          <h3>样品描述</h3>
          <br/>
          <table id="table3">
            <tr>
              <td align="right"><span class="red">*</span>机器类型</td>
              <td colspan="3">
                <FormItem prop="c11">
                  <RadioGroup v-model="formRecord.c11">
                    <Radio :disabled='disabledoff' label="工商业用和类似用途">工商业用和类似用途</Radio>
                    <Radio :disabled='disabledoff' label="户用和类似用途">户用和类似用途</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span class="red">*</span>冷却方式</td>
              <td colspan="3">
                <FormItem prop="c12">
                  <RadioGroup v-model="formRecord.c12">
                    <Radio :disabled='disabledoff' label="水冷">水冷</Radio>
                    <Radio :disabled='disabledoff' label="风冷">风冷</Radio>
                    <Radio :disabled='disabledoff' label="蒸发冷却式">蒸发冷却式</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
             <tr>
              <td align="right"><span class="red">*</span>模块化</td>
              <td>
                <FormItem prop="c13" style="width:100%">
                  <RadioGroup v-model="formRecord.c13">
                    <Radio :disabled='disabledoff' label="是">是</Radio>
                    <Radio :disabled='disabledoff' label="否">否</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td align="right"><span class="red">*</span>其他载冷剂</td>
              <td>
                <FormItem prop="c14" style="width:100%">
                  <RadioGroup v-model="formRecord.c14">
                    <Radio :disabled='disabledoff' label="有">有</Radio>
                    <Radio :disabled='disabledoff' label="无">无</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
             <tr>
              <td align="right"><span class="red">*</span>热泵功能</td>
              <td>
                <FormItem prop="c15" style="width:100%">
                  <RadioGroup v-model="formRecord.c15">
                    <Radio :disabled='disabledoff' label="有">有</Radio>
                    <Radio :disabled='disabledoff' label="无">无</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td align="right"><span class="red">*</span>部分负荷运行</td>
              <td>
                <FormItem prop="c16" style="width:100%">
                  <RadioGroup v-model="formRecord.c16">
                    <Radio :disabled='disabledoff' label="可以">可以</Radio>
                    <Radio :disabled='disabledoff' label="不可以">不可以</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
             <tr>
              <td align="right"><span class="red">*</span>结构形式</td>
              <td colspan="3">
                <FormItem prop="c17" style="width:100%">
                  <RadioGroup v-model="formRecord.c17">
                    <Radio :disabled='disabledoff' label="整体式">整体式</Radio>
                    <Radio :disabled='disabledoff' label="分体式">分体式</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
             <tr>
              <td align="right"><span class="red">*</span>换热器(水/制冷剂)使用侧</td>
              <td colspan="3">
                <FormItem prop="c18">
                  <CheckboxGroup v-model="formRecord.c18">
                    <Checkbox label="板式换热器" :disabled='disabledoff'>板式换热器</Checkbox>
                    <Checkbox label="套管式换热器" :disabled='disabledoff'>套管式换热器</Checkbox>
                    <Checkbox label="壳管式换热器" :disabled='disabledoff'>壳管式换热器&nbsp;&nbsp;(</Checkbox>
                    <FormItem prop="c41">
                      <CheckboxGroup v-model="formRecord.c41">
                        <Checkbox label="干式蒸发器 " :disabled='disabledoff'>干式蒸发器</Checkbox>
                        <Checkbox label="满液式" :disabled='disabledoff'>满液式</Checkbox>
                        <Checkbox label="喷淋式" :disabled='disabledoff'>喷淋式&nbsp;&nbsp;)</Checkbox>
                      </CheckboxGroup>
                    </FormItem>
                     <Checkbox label="其他" :disabled='disabledoff'>其他</Checkbox>
                  </CheckboxGroup>
                </FormItem>
                <FormItem prop="c57">
                  <Input type="text" v-model="formRecord.c57" :disabled='disabledoff || forbidden.c57'/>
                </FormItem>
              </td>
            </tr>
             <tr>
              <td align="right"><span class="red">*</span>换热器(水/制冷剂)热源侧</td>
              <td colspan="3">
                <FormItem prop="c19">
                  <CheckboxGroup v-model="formRecord.c19">
                    <Checkbox label="板式换热器" :disabled='disabledoff'>板式换热器</Checkbox>
                    <Checkbox label="套管式换热器" :disabled='disabledoff'>套管式换热器</Checkbox>
                    <Checkbox label="壳管式换热器" :disabled='disabledoff'>壳管式换热器</Checkbox>
                    <Checkbox label="其他" :disabled='disabledoff'>其他</Checkbox>
                  </CheckboxGroup>
                </FormItem>
                <FormItem prop="c58">
                  <Input type="text" v-model="formRecord.c58" :disabled='disabledoff || forbidden.c58'/>
                </FormItem>
              </td>
            </tr>
             <tr>
              <td align="right"><span class="red">*</span>膨胀阀类型</td>
              <td colspan="3">
                <FormItem prop="c20">
                  <RadioGroup v-model="formRecord.c20">
                    <Radio :disabled='disabledoff' label="电子膨胀阀">电子膨胀阀</Radio>
                    <Radio :disabled='disabledoff' label="热力膨胀阀">热力膨胀阀</Radio>
                    <Radio :disabled='disabledoff' label="电动调节阀">电动调节阀</Radio>
                    <Radio :disabled='disabledoff' label="毛细管">毛细管</Radio>
                    <Radio :disabled='disabledoff' label="其他">其他</Radio>
                  </RadioGroup>
                </FormItem>
                <FormItem prop="c59">
                  <Input type="text" v-model="formRecord.c59" :disabled='disabledoff || forbidden.c59'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span class="red">*</span>污垢系数</td>
              <td colspan="3">
                <FormItem prop="c21">
                  <Input type="text" v-model="formRecord.c21" :disabled='forbidden.c21'/>
                </FormItem>
              </td>
            </tr>
             <tr>
              <td align="right"><span class="red">*</span>油分离器</td>
              <td>
                <FormItem prop="c22" style="width:100%">
                  <RadioGroup v-model="formRecord.c22">
                    <Radio :disabled='disabledoff' label="有">有</Radio>
                    <Radio :disabled='disabledoff' label="无">无</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td align="right"><span class="red">*</span>储液器</td>
              <td>
                <FormItem prop="c23" style="width:100%">
                  <RadioGroup v-model="formRecord.c23">
                      <Radio :disabled='disabledoff' label="有">有</Radio>
                    <Radio :disabled='disabledoff' label="无">无</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span class="red">*</span>辅助电加热器</td>
              <td>
                <FormItem prop="c24" style="width:100%">
                  <RadioGroup v-model="formRecord.c24">
                    <Radio :disabled='disabledoff' label="有">有</Radio>
                    <Radio :disabled='disabledoff' label="无">无</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td align="right"><span class="red">*</span>热回收功能</td>
              <td>
                <FormItem prop="c25" style="width:100%">
                  <RadioGroup v-model="formRecord.c25">
                      <Radio :disabled='disabledoff' label="有">有</Radio>
                    <Radio :disabled='disabledoff' label="无">无</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span class="red">*</span>制热量</td>
              <td>
                <FormItem prop="c26">
                  <Input type="text" v-model="formRecord.c26" :disabled='forbidden.c26'/>
                </FormItem>
              </td>
              <td align="right"><span class="red">*</span>热泵制热消耗总电功率（kW）</td>
              <td>
                <FormItem prop="c27">
                  <Input type="text" v-model="formRecord.c27" :disabled='forbidden.c27'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span class="red">*</span>制热性能系数（COP）</td>
              <td colspan="3">
                <FormItem prop="c28">
                  <Input type="text" v-model="formRecord.c28" :disabled='forbidden.c28'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span class="red">*</span>电源类型</td>
              <td colspan="3">
                <FormItem prop="c29">
                  <RadioGroup v-model="formRecord.c29">
                    <Radio :disabled='disabledoff' label="交流220V">交流220V</Radio>
                    <Radio :disabled='disabledoff' label="交流380V">交流380V</Radio>
                    <Radio :disabled='disabledoff' label="直流">直流</Radio>
                    <Radio :disabled='disabledoff' label="其他">其他</Radio>
                  </RadioGroup>
                </FormItem>
                <FormItem prop="c60">
                  <Input type="text" v-model="formRecord.c60" :disabled='disabledoff || forbidden.c60'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span class="red">*</span>控制系统</td>
              <td colspan="3">
                <FormItem prop="c30">
                  <RadioGroup v-model="formRecord.c30">
                    <Radio :disabled='disabledoff' label="单片机">单片机</Radio>
                    <Radio :disabled='disabledoff' label="可编程(PLC)控制">可编程(PLC)控制</Radio>
                    <Radio :disabled='disabledoff' label="其他">其他</Radio>
                  </RadioGroup>
                </FormItem>
                <FormItem prop="c61">
                  <Input type="text" v-model="formRecord.c61" :disabled='disabledoff || forbidden.c61'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span class="red">*</span>是否允注制冷剂</td>
              <td colspan="3">
                <FormItem prop="c31" style="width:100%">
                  <RadioGroup v-model="formRecord.c31">
                    <Radio :disabled='disabledoff' label="是">是</Radio>
                    <Radio :disabled='disabledoff' label="否">否</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td align="right"><span class="red">*</span>制冷剂/灌注量(kg)</td>
              <td colspan="3">
                <span class="w70">制冷剂:</span>
                <FormItem prop="c32">
                  <Input type="text" v-model="formRecord.c32" :disabled='disabledoff'/>
                </FormItem>
                  <span class="w70" style="padding-left:100px">灌注量(kg):</span>
                  <FormItem prop="c33">
                    <Input type="text" v-model="formRecord.c33" :disabled='disabledoff'/>
                  </FormItem>
              </td>
            </tr>
             <tr>
              <td align="right"><span class="red">*</span>整机或室内机外形尺寸<br/>(长×宽×高)<br/>(mm×mm×mm)</td>
              <td> 
                <FormItem prop="c34" style="width: 30%">
                  <Input style="vertical-align:top" type="text" v-model="formRecord.c34" :disabled='disabledoff'/>
                </FormItem>
                <FormItem><b>x</b></FormItem>
                <FormItem prop="c35" style="width: 30%">
                  <Input type="text" v-model="formRecord.c35" :disabled='disabledoff'/>
                </FormItem>
                 <FormItem><b>x</b></FormItem>
                <FormItem prop="c36" style="width: 30%">
                  <Input type="text" v-model="formRecord.c36" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td align="right">室外机外形尺寸<br/>(长×宽×高)<br/>(mm×mm×mm)</td>
              <td>
                <FormItem prop="c37" style="width: 30%">
                  <Input style="vertical-align:top" type="text" v-model="formRecord.c37" :disabled='disabledoff'/>
                </FormItem>
                <FormItem><b>x</b></FormItem>
                <FormItem prop="c38" style="width: 30%">
                  <Input type="text" v-model="formRecord.c38" :disabled='disabledoff'/>
                </FormItem>
                <FormItem><b>x</b></FormItem>
                <FormItem prop="c39" style="width: 30%">
                  <Input type="text" v-model="formRecord.c39" :disabled='disabledoff'/>
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
            <thead>
            <tr>
              <th>序号</th>
              <th>部件名称</th>
              <th>规格型号</th>
              <th>技术参数</th>
              <th>生产者（全称）</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td width="80">1</td>
              <td>压缩机</td>
              <td>
                <FormItem prop="c69">
                  <Input type="text" v-model="formRecord.c69" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td width="330">
                <div>
                  <span class="w70">制冷量（瓦）</span>
                  <FormItem prop="c70">
                    <Input type="text" v-model="formRecord.c70" :disabled='disabledoff'/>
                  </FormItem>
                  <br>
                  <span class="w70">输入功率（瓦）</span>
                  <FormItem prop="c72">
                    <Input type="text" v-model="formRecord.c72" :disabled='disabledoff'/>
                  </FormItem>
                 <br>
                  <span class="w70">COP值</span>
                  <FormItem prop="c73">
                    <Input type="text" v-model="formRecord.c73" :disabled='disabledoff'/>
                  </FormItem>
                </div>
              </td>
              <td>
                <FormItem prop="c71">
                  <Input type="text" v-model="formRecord.c71" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
           <tr>
              <td width="80">2</td>
              <td>压缩机</td>
              <td>
                <FormItem prop="c74">
                  <Input type="text" v-model="formRecord.c74" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td width="330">
                <div>
                  <span class="w70">制冷量（瓦）</span>
                  <FormItem prop="c75">
                    <Input type="text" v-model="formRecord.c75" :disabled='disabledoff'/>
                  </FormItem>
                  <br>
                  <span class="w70">输入功率（瓦）</span>
                  <FormItem prop="c77">
                    <Input type="text" v-model="formRecord.c77" :disabled='disabledoff'/>
                  </FormItem>
                  <br>
                  <span class="w70">COP值</span>
                  <FormItem prop="c78">
                    <Input type="text" v-model="formRecord.c78" :disabled='disabledoff'/>
                  </FormItem>
                </div>
              </td>
              <td>
                <FormItem prop="c76">
                  <Input type="text" v-model="formRecord.c76" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td width="80">3</td>
              <td>风机</td>
              <td>
                <FormItem prop="c79">
                  <Input type="text" v-model="formRecord.c79" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td class="tl" width="230">
                <div>
                  <span class="w70">风量（m³/h）</span>
                  <FormItem prop="c80">
                    <Input type="text" v-model="formRecord.c80" :disabled='disabledoff'/>
                  </FormItem>
                  <br>
                  <span class="w70">全压（Pa）</span>
                  <FormItem prop="c82">
                    <Input type="text" v-model="formRecord.c82" :disabled='disabledoff'/>
                  </FormItem>
                  <br>
                  <span class="w70">输入功率（W）</span>
                  <FormItem prop="c83">
                    <Input type="text" v-model="formRecord.c83" :disabled='disabledoff'/>
                  </FormItem>
                </div>
              </td>
              <td>
                <FormItem prop="c81">
                  <Input type="text" v-model="formRecord.c81" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td width="80">4</td>
              <td>
                风机
              </td>
              <td>
                <FormItem prop="c84">
                  <Input type="text" v-model="formRecord.c84" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td class="tl" width="230">
                <div>
                  <span class="w70">风量（m³/h）</span>
                  <FormItem prop="c85">
                    <Input type="text" v-model="formRecord.c85" :disabled='disabledoff'/>
                  </FormItem>
                  <br>
                  <span class="w70">全压（Pa）</span>
                  <FormItem prop="c87">
                    <Input type="text" v-model="formRecord.c87" :disabled='disabledoff'/>
                  </FormItem>
                  <br>
                  <span class="w70">输入功率（W）</span>
                  <FormItem prop="c88">
                    <Input type="text" v-model="formRecord.c88" :disabled='disabledoff'/>
                  </FormItem>
                </div>
              </td>
              <td>
                <FormItem prop="c86">
                  <Input type="text" v-model="formRecord.c86" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td width="80">5</td>
              <td>
                翅片式换热器
              </td>
              <td>
                <FormItem prop="c89">
                  <Input type="text" v-model="formRecord.c89" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td class="tl" width="230">
                <div>
                  <span class="w70">换热面积（㎡）</span>
                  <FormItem prop="c90">
                    <Input type="text" v-model="formRecord.c90" :disabled='disabledoff'/>
                  </FormItem>
                  <br>
                  <span class="w70">铜管直径（mm）</span>
                  <FormItem prop="c92">
                    <Input type="text" v-model="formRecord.c92" :disabled='disabledoff'/>
                  </FormItem>
                </div>
              </td>
              <td>
                <FormItem prop="c91">
                  <Input type="text" v-model="formRecord.c91" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td width="80">6</td>
              <td>
                翅片式换热器
              </td>
              <td>
                <FormItem prop="c93">
                  <Input type="text" v-model="formRecord.c93" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td class="tl" width="230">
                <div>
                  <span class="w70">换热面积（㎡）</span>
                  <FormItem prop="c94">
                    <Input type="text" v-model="formRecord.c94" :disabled='disabledoff'/>
                  </FormItem>
                  <br>
                  <span class="w70">铜管直径（mm）</span>
                  <FormItem prop="c96">
                    <Input type="text" v-model="formRecord.c96" :disabled='disabledoff'/>
                  </FormItem>
                </div>
              </td>
              <td>
                <FormItem prop="c95">
                  <Input type="text" v-model="formRecord.c95" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
             <tr>
              <td width="80">7</td>
              <td>
                换热器
              </td>
              <td>
                <FormItem prop="c97">
                  <Input type="text" v-model="formRecord.c97" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td class="tl" width="230">
                <div>
                  <span class="w70">换热管表面积（㎡）</span>
                  <FormItem prop="c98">
                    <Input type="text" v-model="formRecord.c98" :disabled='disabledoff'/>
                  </FormItem>
                </div>
              </td>
              <td>
                <FormItem prop="c99">
                  <Input type="text" v-model="formRecord.c99" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td width="80">8</td>
              <td>
                换热器
              </td>
              <td>
                <FormItem prop="c100">
                  <Input type="text" v-model="formRecord.c100" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td class="tl" width="230">
                <div>
                  <span class="w70">换热管表面积（㎡）</span>
                  <FormItem prop="c101">
                    <Input type="text" v-model="formRecord.c101" :disabled='disabledoff'/>
                  </FormItem>
                </div>
              </td>
              <td>
                <FormItem prop="c102">
                  <Input type="text" v-model="formRecord.c102" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            </tbody>
          </table>
        </Card>
      </div>
      <div class="part part7">
        <Card :bordered="false">
          <h2>七、其他认证信息</h2>
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
          <div class="application" v-if='$store.state.app.pageType && $store.state.app.pageType!="view"'>
            <span><i class="red">*</i>{{$store.state.app.pageType==="extend"?'扩展':'变更'}}申请书</span>
            <Button type="primary" @click="modal5=true">填写{{$store.state.app.pageType==="extend"?'扩展':'变更'}}申请书</Button>
            <span>{{formRecord.ec_master_kuozhan_text===''?'未填写':'已填写'}}</span>
          </div>
          <table>
            <tr>
              <td><span class="red">*</span>产品正面图片</td>
              <td>(JPG/PNG)</td>
              <td>
                <div class="lookOver" v-show="uploadParam.filePath24"><Button @click="showImg(uploadParam.filePath24)" icon="ios-glasses-outline"  type="primary">查看</Button></div>
                <div v-if='$store.state.app.pageType!="view"'>
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
                根据企业提交的相关能效指标，系统直接生成能效表示样本
                <Button type="primary" @click="showTemplate">查看</Button>
              </td>
              <td colspan="3" v-else>提交备案后，需企业自行上传能效标识样本</td>
            </tr>
            <tr>
              <td><span v-if='$store.state.app.oem' class="red">*</span>OEM声明</td>
              <td>(JPG/PNG)</td>
              <td>
                <div class="lookOver" v-show="uploadParam.filePath26"><Button @click="showImg(uploadParam.filePath26)" icon="ios-glasses-outline"  type="primary">查看</Button></div>
                <div v-if='$store.state.app.pageType!="view"'>
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
                <div v-if='$store.state.app.pageType!="view"'>
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
                <div v-if='$store.state.app.pageType!="view"'>
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
                <div v-if='$store.state.app.pageType!="view"'>
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
              <td>进口商企业信息表</td>
              <td>(PDF)</td>
              <td>
                <div class="lookOver" v-show="uploadParam.filePath30"><Button @click="showImg(uploadParam.filePath30)" icon="ios-glasses-outline"  type="primary">查看</Button></div>
                <div v-if='$store.state.app.pageType!="view"'>
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
              <td>进口商营业执照或登记注册证明复印件</td>
              <td>（PDF）</td>
              <td>
                <div class="lookOver" v-show="uploadParam.filePath31"><Button @click="showImg(uploadParam.filePath31)" icon="ios-glasses-outline"  type="primary">查看</Button></div>
                <div v-if='$store.state.app.pageType!="view"'>
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
              <td>进口商与境外生产者订立的相关合同副本</td>
              <td>(PDF)</td>
              <td>
                <div class="lookOver" v-show="uploadParam.filePath32"><Button @click="showImg(uploadParam.filePath32)" icon="ios-glasses-outline"  type="primary">查看</Button></div>
                <div v-if='$store.state.app.pageType!="view"'>
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
                <div v-if='$store.state.app.pageType!="view"'>
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
          <p class="red">注：保存到草稿时，不保存附件！<br />所有附件上传文件大小需要控制在2M以内。</p>
        </Card>
      </div>
      <div>
        <CheckboxGroup v-model="confirmData">
          <Checkbox label="1"><span style="color:red;font-weight:bold;">我已确认以上数据填写无误！</span></Checkbox>
        </CheckboxGroup>
      </div>
      <div class="tc" v-if="$store.state.app.pageType!='view'">
        <Button type="primary" @click="prevStep">上一步</Button>
        <Button type="primary" @click="saveRecord" v-if='!$store.state.app.pageType' :disabled="saveDisabled">保存到草稿</Button>
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
            <th>原始值</th>
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
      <p v-if="!boolFlag.length" style="font-size:16px;font-weight: bolder; text-align: center">请再次确认备案信息填写无误！</p>
      <p style="font-size:16px;font-weight: bolder;text-align: center">若确认，请点击“提交备案”按钮</p>
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
      <h2>标识型号{{$store.state.app.pageType==="extend"?'扩展':'变更'}}备案申请书</h2>
      <p class="org">中国标准化研究院能效标识管理中心：</p>
      <div class="pro-info">
        我 <span  class="f-company">{{formRecord.c1}}</span>
        公司生产的 <span class="f-brand">{{formRecord.c5}}</span>
        品牌的 <span  class="f-model">{{formRecord.c4}}</span>
        型号的 <span  class="f-product">家用电冰箱-2015版</span>产品。
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
          <Input class="valid" v-model="formRecord.ec_master_kuozhan_text"  type="textarea" :autosize="{minRows: 2,maxRows: 5}" placeholder="描述"/>
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
          <Input class="valid" v-model="formRecord.ec_master_kuozhan_text"  type="textarea" :autosize="{minRows: 2,maxRows: 5}" placeholder="描述"/>
          <b class="color-red">（请删除上述描述中多余的空格和空行，否则可能打印不完整。）</b>
        </dd>
        <dd>
          该型号的相关信息变更后的初始使用日期：
          <span class="f-date">{{formatDate(formRecord[thisDateCV])}}</span>
        </dd>
        <dd>请中国标准化研究院能效标识管理中心核准。</dd>
      </dl>
      <div class="record-attached">附：{{$store.state.app.pageType==="extend"?'扩展':'变更'}}型号产品的能效标识样本{{$store.state.app.pageType==="extend"?'':'以及检测报告'}}</div>
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
    data () {
    const timeDate = this.$store.state.app.dateinit
    return {
      // 当前初始使用日期 对应的C值
      thisDateCV: 'c10',
      // 当前能效等级 对应的C值
      thisLevelCV: 'c9',
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
        c3: '',
        c45: '',
        c4: '',
        c2: '',
        c200: '',
        c9: '',
        c300: '',
        c5: '',
        c50: '',
        c6: '',
        c51: '',
        c7: '',
        c52: '',
        c8: '',
        c53: '',
        c10: new Date(),
        c11: '',
        c12: '',
        c13: '',
        c14: '',
        c15: '',
        c16: '',
        c17: '',
        c18: [],
        c41: [],
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
        c35: '',
        c36: '',
        c37: '',
        c38: '',
        c39: '',
        c57: '',
        c58: '',
        c59: '',
        c60: '',
        c61: '',
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
        c202: '',
        ec_model_no: 50,
        attach_list: ''
      },
      forbidden: {
        c5: true,
        c6: true,
        c7: true,
        c8: true,
        c26: true,
        c27: true,
        c28: true,
        c57: true,
        c58: true,
        c59: true,
        c60: true,
        c61: true
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
      disabledoff(){
        return this.$store.state.app.pageType == "extend"
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
        var jsonPdyj = [{
          type: "wind",
          list: [{
              cool: '<=50',
              itemlist: [{
                  grade: 1,
                  opt: [{
                      opt_type: "iplv",
                      val: 3.80
                  }, {
                      opt_type: "cop",
                      val: 3.20
                  }]
              }, {
                  grade: 2,
                  opt: [{
                      opt_type: "iplv",
                      val: 3.60
                  }, {
                      opt_type: "cop",
                      val: 3.00
                  }]

              }, {
                  grade: 3,
                  iplv: 2.80,
                  cop: 2.50
              }]
          }, {
              cool: '>50',
              itemlist: [{
                  grade: 1,
                  opt: [{
                      opt_type: "iplv",
                      val: 4.00
                  }, {
                      opt_type: "cop",
                      val: 3.40
                  }]
              }, {
                  grade: 2,
                  opt: [{
                      opt_type: "iplv",
                      val: 3.70
                  }, {
                      opt_type: "cop",
                      val: 3.20
                  }]
              }, {
                  grade: 3,
                  iplv: 2.90,
                  cop: 2.70
              }]
          }]
      }, {
          type: "water",
          list: [{
              cool: '<=528',
              itemlist: [{
                  grade: 1,
                  opt: [{
                      opt_type: "iplv",
                      val: 7.20
                  }, {
                      opt_type: "cop",
                      val: 5.60
                  }]
              }, {
                  grade: 2,
                  opt: [{
                      opt_type: "iplv",
                      val: 6.30
                  }, {
                      opt_type: "cop",
                      val: 5.30
                  }]
              }, {
                  grade: 3,
                  iplv: 5.00,
                  cop: 4.20
              }]
          }, {
              cool: '538-1163',
              itemlist: [{
                  grade: 1,
                  opt: [{
                      opt_type: "iplv",
                      val: 7.50
                  }, {
                      opt_type: "cop",
                      val: 6.00
                  }]
              }, {
                  grade: 2,
                  opt: [{
                      opt_type: "iplv",
                      val: 7.00
                  }, {
                      opt_type: "cop",
                      val: 5.60
                  }]
              }, {
                  grade: 3,
                  iplv: 5.50,
                  cop: 4.70
              }]
          }, {
              cool: '>1163',
              itemlist: [{
                  grade: 1,
                  opt: [{
                      opt_type: "iplv",
                      val: 8.10
                  }, {
                      opt_type: "cop",
                      val: 6.30
                  }]
              }, {
                  grade: 2,
                  opt: [{
                      opt_type: "iplv",
                      val: 7.60
                  }, {
                      opt_type: "cop",
                      val: 5.80
                  }]
              }, {
                  grade: 3,
                  iplv: 5.90,
                  cop: 5.20
              }]
          }]
      }]
        //能效等级
        var nxdj = this.formRecord.c9;
        //冷却方式
        var lqfs  = this.formRecord.c12 == "水冷" ? "water" : "wind";
        //综合部分负荷性能系数
        var iplv = parseFloat(this.formRecord.c8);
        //性能系数标注值
        var cop = parseFloat(this.formRecord.c7);
        //制冷量标准值
        var cc = parseFloat(this.formRecord.c5);
        //性能系数实测值
        var copsc = parseFloat(this.formRecord.c52);
        //综合部分负荷性能系数实测值
        var iplvsc = parseFloat(this.formRecord.c53);
        //能效等级判定依据
        var pdyj = this.formRecord.c300 == "性能系数" ? "cop" : "iplv";
        //制冷量标注值
        var zll =(type, val) => {
          if (type == 'wind') {
                if (val <= 50) {
                    return "<=50";
                } else {
                    return ">50";
                }
            } else if (type == 'water') {
                if (val <= 528) {
                    return "<=528";
                } else if (val > 528 && val <= 1163) {
                    return "538-1163";
                } else {
                    return ">1163";
                }
            }
        }
        
        var filterValue =(type, cool, grade, opt_type) => {
            var minVal;
            jsonPdyj.forEach((v, i) => {
                if (v.type == type) {
                    v.list.forEach((v, i) => {
                        if (v.cool == cool) {
                            v.itemlist.forEach((v, i) => {
                                if (v.grade == 1 && grade == 1 || v.grade == 2 && grade == 2) {
                                    v.opt.forEach((v, i) => {
                                        if (v.opt_type == opt_type) {
                                            minVal = v.val;
                                        }
                                    });
                                } else if (v.grade == 3 && grade == 3) {
                                    var arr = [];
                                    arr.push(v.cop);
                                    arr.push(v.iplv);
                                    minVal = arr;
                                }
                            });
                        }
                    })
                }
            });
            return minVal;
        }

        var cool = zll(lqfs, cc);//制冷量标注值
        var minVal = filterValue(lqfs, cool, nxdj, "cop");

        var checkc52a = null
        var checkc52b = null
        var checkc53a = null
        var checkc53b = null

        if (nxdj == 3) {
          var copMin = minVal[0];
          var iplvMin = minVal[1];
          checkc53a = (rule, value, callback) => {
            if (iplv < iplvMin) {
              callback("综合部分负荷性能系数不符合标准")
            }else{
              callback()
            }
          }
          checkc53b = (rule, value, callback) => {
            if (iplvsc < iplvMin) {
              callback("综合部分负荷性能系数实测值不符合标准")
            }else{
              callback()
            }
          }
          checkc52a = (rule, value, callback) => {
            if (cop < copMin) {
              callback("性能系数不符合标准")
            }else{
              callback()
            }
          }
          checkc52b = (rule, value, callback) => {
            if (copsc < copMin){
              callback("性能系数实测值不符合标准")
            }else{
              callback()
            }
          }
        } else if (pdyj == "iplv" && nxdj != 3) {
            checkc53a = (rule, value, callback) => {
              if (iplv < minVal) {
                callback("综合部分负荷性能系数不符合标准")
              }else{
                callback()
              }
            }
            checkc53b = (rule, value, callback) => {
              if (iplvsc < minVal) {
                callback("综合部分负荷性能系数实测值不符合标准")
              }else{
                callback()
              }
            }
        }else if (pdyj == "cop" && nxdj != 3) {
            checkc52a = (rule, value, callback) => {
              if (cop < minVal) {
              callback("性能系数不符合标准")
            }else{
              callback()
            }
          }
          checkc52b = (rule, value, callback) => {
            if (copsc < minVal) {
              callback("性能系数实测值不符合标准")
            }else{
              callback()
            }
          }
        }
        if (this.formRecord.c15 === '有' ) {
          this.forbidden.c26 = false
          this.forbidden.c27 = false
          this.forbidden.c28 = false
        } else {
          this.formRecord.c26 = ''
          this.forbidden.c26 = true
          this.formRecord.c27 = ''
          this.forbidden.c27 = true
          this.formRecord.c28 = ''
          this.forbidden.c28 = true
        }

        if (this.formRecord.c18.join('').indexOf('其他') > -1) {
          this.forbidden.c57 = false
        } else {
          this.formRecord.c57 = ''
          this.forbidden.c57 = true
        }
        if (this.formRecord.c19.join('').indexOf('其他') > -1) {
          this.forbidden.c58 = false
        } else {
          this.formRecord.c58 = ''
          this.forbidden.c58 = true
        }
        if (this.formRecord.c20 === '其他') {
          this.forbidden.c59 = false
        } else {
          this.formRecord.c59 = ''
          this.forbidden.c59 = true
        }

        if (this.formRecord.c29 === '其他') {
          this.forbidden.c60 = false
        } else {
          this.formRecord.c60 = ''
          this.forbidden.c60 = true
        }

        if (this.formRecord.c30 === '其他') {
          this.forbidden.c61 = false
        } else {
          this.formRecord.c61 = ''
          this.forbidden.c61 = true
        }
        return {
          c3: [
            {
              required: true,
              message: '请填写制造单位',
              trigger: 'change,blur'
            }
          ],
          c45: [
            {
              required: true,
              message: '请填写备案方',
              trigger: 'change,blur'
            }
          ],
          c2: [
            {
              required: true,
              message: '请填写商标',
              trigger: 'change,blur'
            }
          ],
          c200: [
            {
              required: true,
              message: '  ',
              trigger: 'change,blur'
            }
          ],
          c9: [
            {
              required: true,
              message: '请选择能效等级',
              trigger: 'change,blur'
            }
          ],
          c300: [
            {
              required: true,
              message: '能效等级判定依据不能为空',
              trigger: 'change,blur'
            }
          ],
          c5: [
            {
              required: true,
              message: '制冷量标准值不能为空',
              trigger: 'change,blur'
            }
          ],
          c50: [
            {
              required: true,
              message: '制冷量实测值不能为空',
              trigger: 'change,blur'
            },
            {
              validator: isNumber,
              trigger: 'change,blur',
            }
          ],
          c6: [
            {
              required: true,
              message: '消耗总电功率标注值不能为空',
              trigger: 'change,blur'
            }
          ],
          c51: [
            {
              required: true,
              message: '消耗总电功率实测值不能为空',
              trigger: 'change,blur'
            },
            {
              validator: isNumber,
              trigger: 'change,blur'
            }
          ],
          c7: [
            {
              required: true,
              message: '性能系数标注值不能为空',
              trigger: 'change,blur'
            },
            {
              validator: twoDecimals,
              trigger: 'change,blur'
            },
            {
              validator: checkc52a,
              trigger: 'change,blur'
            }
          ],
          c52: [
            {
              required: true,
              message: '性能系数实测值不能为空',
              trigger: 'change,blur'
            },
            {
              validator: isNumber,
              trigger: 'change,blur'
            },
            {
              validator: checkc52b,
              trigger: 'change,blur'
            }
          ],
          c8: [
            {
              required: true,
              message: '综合部分负荷性能系数标注值不能为空',
              trigger: 'change,blur'
            },
            {
              validator: twoDecimals,
              trigger: 'change,blur'
            },
            {
              validator: checkc53a,
              trigger: 'change,blur'
            }
          ],
          c53: [
            {
              required: true,
              message: '综合部分负荷性能系数实测值不能为空',
              trigger: 'change,blur'
            },
            {
              validator: isNumber,
              trigger: 'change,blur'
            },
            {
              validator: checkc53b,
              trigger: 'change,blur'
            },
          ],
          c10: [
            {
              required: true,
              message: '备案标识开始使用日期不能为空'
            }
          ],
          c11: [
            {
              required: true,
              message: '机器类型不能为空',
              trigger: 'change,blur'
            }
          ],
          c12: [
            {
              required: true,
              message: '冷却方式不能为空',
              trigger: 'change,blur'
            }
          ],
          c13: [
            {
              required: true,
              message: '模块化不能为空',
              trigger: 'change,blur'
            }
          ],
          c14: [
            {
              required: true,
              message: '其他载冷剂不能为空',
              trigger: 'change,blur'
            }
          ],
          c15: [
            {
              required: true,
              message: '热泵功能不能为空',
              trigger: 'change,blur'
            }
          ],
          c16: [
            {
              required: true,
              message: '部分负荷运行不能为空',
              trigger: 'change,blur'
            }
          ],
          c17: [
            {
              required: true,
              message: '结构形式不能为空',
              trigger: 'change,blur'
            }
          ],
          c18: [
            {
              required: true,
              message: '换热器(水/制冷剂)使用侧不能为空',
            }
          ],
          c19: [
            {
              required: true,
              message: '换热器(水/制冷剂)热源侧不能为空',
            }
          ],
         /* c41: [
            {
              required: true,
              message: '壳管式换热器不能为空',
            }
          ],*/
          c20: [
            {
              required: true,
              message: '膨胀阀类型不能为空',
              trigger: 'change,blur'
            }
          ],
          c21: [
            {
              required: true,
              message: '污垢系数不能为空',
              trigger: 'change,blur'
            }
          ],
          c22: [
            {
              required: true,
              message: '油分离器不能为空',
              trigger: 'change,blur'
            }
          ],
          c23: [
            {
              required: true,
              message: '储液器不能为空',
              trigger: 'change,blur'
            }
          ],
          c24: [
            {
              required: true,
              message: '辅助电加热器不能为空',
              trigger: 'change,blur'
            }
          ],
          c25: [
            {
              required: true,
              message: '热回收功能不能为空',
              trigger: 'change,blur'
            }
          ],
          c29: [
            {
              required: true,
              message: '电源类型不能为空',
              trigger: 'change,blur'
            }
          ],
          c30: [
            {
              required: true,
              message: '控制系统不能为空',
              trigger: 'change,blur'
            }
          ],
          c31: [
            {
              required: true,
              message: '是否允注制冷剂不能为空',
              trigger: 'change,blur'
            }
          ],
          c32: [
            {
              required: true,
              message: '制冷剂/灌注量(kg)不能为空',
              trigger: 'change,blur'
            }
          ],
          c33: [
            {
              required: true,
              message: '灌注量(kg)不能为空',
              trigger: 'change,blur'
            }
          ],
          c34: [
            {
              required: true,
              message: '整机或室内机外形尺寸长不能为空',
              trigger: 'change,blur'
            },
            {
              validator: isNumber,
              trigger: 'change,blur'
            }
          ],
          c35: [
            {
              required: true,
              message: '整机或室内机外形尺寸宽不能为空',
              trigger: 'change,blur'
            },
            {
              validator: isNumber,
              trigger: 'change,blur'
            }
          ],
          c36: [
            {
              required: true,
              message: '整机或室内机外形尺寸高不能为空',
              trigger: 'change,blur'
            },
            {
              validator: isNumber,
              trigger: 'change,blur'
            }
          ],
          c37: [
            {
              required: true,
              message: '室外机外形尺寸长不能为空',
              trigger: 'change,blur'
            },
            {
              validator: isNumber,
              trigger: 'change,blur'
            }
          ],
          c38: [
            {
              required: true,
              message: '室外机外形尺寸宽不能为空',
              trigger: 'change,blur'
            },
            {
              validator: isNumber,
              trigger: 'change,blur'
            }
          ],
          c39: [
            {
              required: true,
              message: '室外机外形尺寸高不能为空',
              trigger: 'change,blur'
            },
            {
              validator: isNumber,
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
          c71: [
            {
              required: true,
              message: '不能为空',
              trigger: 'change,blur'
            }
          ],
          c72: [
            {
              required: true,
              message: '不能为空',
              trigger: 'change,blur'
            }
          ],
          c73: [
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
          c80: [
            {
              required: true,
              message: '不能为空',
              trigger: 'change,blur'
            }
          ],
          c81: [
            {
              required: true,
              message: '不能为空',
              trigger: 'change,blur'
            }
          ],
          c82: [
            {
              required: true,
              message: '不能为空',
              trigger: 'change,blur'
            }
          ],
          c83: [
            {
              required: true,
              message: '不能为空',
              trigger: 'change,blur'
            }
          ],
          c89: [
            {
              required: true,
              message: '不能为空',
              trigger: 'change,blur'
            }
          ],
          c90: [
            {
              required: true,
              message: '不能为空',
              trigger: 'change,blur'
            }
          ],
          c91: [
            {
              required: true,
              message: '不能为空',
              trigger: 'change,blur'
            }
          ],
          c92: [
            {
              required: true,
              message: '不能为空',
              trigger: 'change,blur'
            }
          ],
          c97: [
            {
              required: true,
              message: '不能为空',
              trigger: 'change,blur'
            }
          ],
          c98: [
            {
              required: true,
              message: '不能为空',
              trigger: 'change,blur'
            }
          ],
          c99: [
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
</script>
<style>
  @import '../../../css/comm.css';
</style>
