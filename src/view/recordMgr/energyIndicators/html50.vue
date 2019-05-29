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
            <Input type="text" v-model="formRecord.c1" :disabled='disabledoff' placeholder="生产者名称" readonly/>
          </FormItem>
          <FormItem prop="c3" label="制造单位" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c3" :disabled='disabledoff' placeholder="制造单位"/>
          </FormItem>
          <FormItem prop="c45" label="备案方" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c45" :disabled='disabledoff' placeholder="备案方"/>
          </FormItem>
          <FormItem prop="c4" label="产品规格型号" style="width:100%;" :label-width="180">
            <Input type="text" v-model="formRecord.c4" :disabled='!disabledoff' placeholder="产品规格型号"/>
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
                   <Input type="text" v-model="formRecord.c5" readonly disabled/>
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
                   <Input type="text" v-model="formRecord.c6"  readonly disabled/>
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
                   <Input type="text" v-model="formRecord.c7"  readonly disabled/>
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
                   <Input type="text" v-model="formRecord.c8"  readonly disabled/>
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
                <label class="mb7">
                  <FormItem prop="c11">
                    <RadioGroup v-model="formRecord.c11">
                      <Radio :disabled='disabledoff' label="工商业用和类似用途">工商业用和类似用途</Radio>
                      <Radio :disabled='disabledoff' label="户用和类似用途">户用和类似用途</Radio>
                    </RadioGroup>
                  </FormItem>
                </label>
              </td>
            </tr>
            <tr>
              <td align="right"><span class="red">*</span>冷却方式</td>
              <td colspan="3">
                <label class="mb7">
                  <FormItem prop="c12">
                    <RadioGroup v-model="formRecord.c12">
                      <Radio :disabled='disabledoff' label="水冷">水冷</Radio>
                      <Radio :disabled='disabledoff' label="风冷">风冷</Radio>
                      <Radio :disabled='disabledoff' label="蒸发冷却式">蒸发冷却式</Radio>
                    </RadioGroup>
                  </FormItem>
                </label>
              </td>
            </tr>
             <tr>
              <td align="right"><span class="red">*</span>模块化</td>
              <td>
                <label class="mb7">
                  <FormItem prop="c13">
                    <RadioGroup v-model="formRecord.c13">
                      <Radio :disabled='disabledoff' label="是">是</Radio>
                      <Radio :disabled='disabledoff' label="否">否</Radio>
                    </RadioGroup>
                  </FormItem>
                </label>
              </td>
              <td align="right"><span class="red">*</span>其他载冷剂</td>
              <td>
                <label class="mb7">
                  <FormItem prop="c14">
                    <RadioGroup v-model="formRecord.c14">
                      <Radio :disabled='disabledoff' label="有">有</Radio>
                      <Radio :disabled='disabledoff' label="无">无</Radio>
                    </RadioGroup>
                  </FormItem>
                </label>
              </td>
            </tr>
             <tr>
              <td align="right"><span class="red">*</span>热泵功能</td>
              <td>
                <label class="mb7">
                  <FormItem prop="c15">
                    <RadioGroup v-model="formRecord.c15">
                      <Radio :disabled='disabledoff' label="有">有</Radio>
                      <Radio :disabled='disabledoff' label="无">无</Radio>
                    </RadioGroup>
                  </FormItem>
                </label>
              </td>
              <td align="right"><span class="red">*</span>部分负荷运行</td>
              <td>
                <label class="mb7">
                  <FormItem prop="c16">
                    <RadioGroup v-model="formRecord.c16">
                      <Radio :disabled='disabledoff' label="可以">可以</Radio>
                      <Radio :disabled='disabledoff' label="不可以">不可以</Radio>
                    </RadioGroup>
                  </FormItem>
                </label>
              </td>
            </tr>
             <tr>
              <td align="right"><span class="red">*</span>结构形式</td>
              <td colspan="3">
                <label class="mb7">
                  <FormItem prop="c17">
                    <RadioGroup v-model="formRecord.c17">
                      <Radio :disabled='disabledoff' label="整体式">整体式</Radio>
                      <Radio :disabled='disabledoff' label="分体式">分体式</Radio>
                    </RadioGroup>
                  </FormItem>
                </label>
              </td>
            </tr>
             <tr>
              <td align="right"><span class="red">*</span>换热器(水/制冷剂)使用侧</td>
              <td colspan="3">
                <label class="mb7">
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
                <FormItem prop="c18">
                  <Input type="text" v-model="formRecord.c18" :disabled='forbidden.c18'/>
                </FormItem>
                </label>
              </td>
            </tr>
             <tr>
              <td align="right"><span class="red">*</span>换热器(水/制冷剂)热源侧</td>
              <td colspan="3">
                <label class="mb7">
                  <FormItem prop="c19">
                  <CheckboxGroup v-model="formRecord.c19">
                    <Checkbox label="板式换热器" :disabled='disabledoff'>板式换热器</Checkbox>
                    <Checkbox label="套管式换热器" :disabled='disabledoff'>套管式换热器</Checkbox>
                    <Checkbox label="壳管式换热器" :disabled='disabledoff'>壳管式换热器</Checkbox>
                    <Checkbox label="其他" :disabled='disabledoff'>其他</Checkbox>
                  </CheckboxGroup>
                </FormItem>
                <FormItem prop="c19">
                  <Input type="text" v-model="formRecord.c19" :disabled='forbidden.c19'/>
                </FormItem>
                </label>
              </td>
            </tr>
             <tr>
              <td align="right"><span class="red">*</span>膨胀阀类型</td>
              <td colspan="3">
                <label class="mb7">
                  <FormItem prop="c20">
                    <RadioGroup v-model="formRecord.c20">
                      <Radio :disabled='disabledoff' label="电子膨胀阀">电子膨胀阀</Radio>
                      <Radio :disabled='disabledoff' label="热力膨胀阀">热力膨胀阀</Radio>
                      <Radio :disabled='disabledoff' label="电动调节阀">电动调节阀</Radio>
                      <Radio :disabled='disabledoff' label="毛细管">毛细管</Radio>
                      <Radio :disabled='disabledoff' label="其他">其他</Radio>
                    </RadioGroup>
                  </FormItem>
                  <FormItem prop="c20">
                    <Input type="text" v-model="formRecord.c20" :disabled='disabledoff || forbidden.c20'/>
                  </FormItem>
                </label>
              </td>
            </tr>
            <tr>
              <td align="right"><span class="red">*</span>污垢系数</td>
              <td colspan="3">
                <label class="mb7">
                  <FormItem prop="c21">
                    <Input type="text" v-model="formRecord.c21" :disabled='forbidden.c21'/>
                  </FormItem>
                </label>
              </td>
            </tr>
             <tr>
              <td align="right"><span class="red">*</span>油分离器</td>
              <td>
                <label class="mb7">
                  <FormItem prop="c22">
                    <RadioGroup v-model="formRecord.c22">
                      <Radio :disabled='disabledoff' label="有">有</Radio>
                      <Radio :disabled='disabledoff' label="无">无</Radio>
                    </RadioGroup>
                  </FormItem>
                </label>
              </td>
              <td align="right"><span class="red">*</span>储液器</td>
              <td>
                <label class="mb7">
                  <FormItem prop="c23">
                    <RadioGroup v-model="formRecord.c23">
                        <Radio :disabled='disabledoff' label="有">有</Radio>
                      <Radio :disabled='disabledoff' label="无">无</Radio>
                    </RadioGroup>
                  </FormItem>
                </label>
              </td>
            </tr>
            <tr>
              <td align="right"><span class="red">*</span>辅助电加热器</td>
              <td>
                <label class="mb7">
                  <FormItem prop="c24">
                    <RadioGroup v-model="formRecord.c24">
                      <Radio :disabled='disabledoff' label="有">有</Radio>
                      <Radio :disabled='disabledoff' label="无">无</Radio>
                    </RadioGroup>
                  </FormItem>
                </label>
              </td>
              <td align="right"><span class="red">*</span>热回收功能</td>
              <td>
                <label class="mb7">
                  <FormItem prop="c25">
                    <RadioGroup v-model="formRecord.c25">
                        <Radio :disabled='disabledoff' label="有">有</Radio>
                      <Radio :disabled='disabledoff' label="无">无</Radio>
                    </RadioGroup>
                  </FormItem>
                </label>
              </td>
            </tr>
            <tr>
              <td align="right"><span class="red">*</span>制热量</td>
              <td>
                <label class="mb7">
                  <FormItem prop="c26">
                    <Input type="text" v-model="formRecord.c26" :disabled='forbidden.c26'/>
                  </FormItem>
                </label>
              </td>
              <td align="right"><span class="red">*</span>热泵制热消耗总电功率（kW）</td>
              <td>
                <label class="mb7">
                  <FormItem prop="c27">
                    <Input type="text" v-model="formRecord.c27" :disabled='forbidden.c27'/>
                  </FormItem>
                </label>
              </td>
            </tr>
            <tr>
              <td align="right"><span class="red">*</span>制热性能系数（COP）</td>
              <td colspan="3">
                <label class="mb7">
                  <FormItem prop="c28">
                    <Input type="text" v-model="formRecord.c28" :disabled='forbidden.c28'/>
                  </FormItem>
                </label>
              </td>
            </tr>
            <tr>
              <td align="right"><span class="red">*</span>电源类型</td>
              <td colspan="3">
                <label class="mb7">
                  <FormItem prop="c29">
                    <RadioGroup v-model="formRecord.c29">
                      <Radio :disabled='disabledoff' label="交流220V">交流220V</Radio>
                      <Radio :disabled='disabledoff' label="交流380V">交流380V</Radio>
                      <Radio :disabled='disabledoff' label=" 直流">直流</Radio>
                      <Radio :disabled='disabledoff' label=" 其他">其他</Radio>
                    </RadioGroup>
                  </FormItem>
                  <FormItem prop="c29">
                    <Input type="text" v-model="formRecord.c29" :disabled='forbidden.c29'/>
                  </FormItem>
                </label>
              </td>
            </tr>
            <tr>
              <td align="right"><span class="red">*</span>控制系统</td>
              <td colspan="3">
                <label class="mb7">
                  <FormItem prop="c30">
                    <RadioGroup v-model="formRecord.c30">
                      <Radio :disabled='disabledoff' label="单片机">单片机</Radio>
                      <Radio :disabled='disabledoff' label="可编程(PLC)控制">可编程(PLC)控制</Radio>
                      <Radio :disabled='disabledoff' label=" 其他">其他</Radio>
                    </RadioGroup>
                  </FormItem>
                  <FormItem prop="c30">
                    <Input type="text" v-model="formRecord.c30" :disabled='forbidden.c30'/>
                  </FormItem>
                </label>
              </td>
            </tr>
            <tr>
              <td align="right"><span class="red">*</span>是否允注制冷剂</td>
              <td colspan="3">
                <label class="mb7">
                  <FormItem prop="c31">
                    <RadioGroup v-model="formRecord.c31">
                      <Radio :disabled='disabledoff' label="是">是</Radio>
                      <Radio :disabled='disabledoff' label="否">否</Radio>
                    </RadioGroup>
                  </FormItem>
                </label>
              </td>
            </tr>
            <tr>
              <td align="right"><span class="red">*</span>制冷剂/灌注量(kg)</td>
              <td colspan="3">
                <label class="mb7">
                  <span class="w70">制冷剂:</span>
                  <FormItem prop="c32">
                    <Input type="text" v-model="formRecord.c32" :disabled='disabledoff'/>
                  </FormItem>
                </label>
                <label class="mb7" style="padding-left:100px">
                  <span class="w70">灌注量(kg):</span>
                  <FormItem prop="c33">
                    <Input type="text" v-model="formRecord.c33" :disabled='disabledoff'/>
                  </FormItem>
                </label>
              </td>
            </tr>
             <tr>
              <td align="right"><span class="red">*</span>整机或室内机外形尺寸<br/>(长×宽×高)<br/>(mm×mm×mm)</td>
              <td> <label class="mb7">
                <FormItem><b>长</b></FormItem>
                <FormItem prop="c34" style="width: 27%">
                  <Input style="vertical-align:top" type="text" v-model="formRecord.c34" :disabled='disabledoff'/>
                </FormItem>
                <FormItem><b>宽</b></FormItem>
                <FormItem prop="c35" style="width: 27%">
                  <Input type="text" v-model="formRecord.c35" :disabled='disabledoff'/>
                </FormItem>
                 <FormItem><b>高</b></FormItem>
                <FormItem prop="c36" style="width: 27%">
                  <Input type="text" v-model="formRecord.c36" :disabled='disabledoff'/>
                </FormItem></label>
              </td>
              <td align="right">室外机外形尺寸<br/>(长×宽×高)<br/>(mm×mm×mm)</td>
              <td>
                <FormItem><b>长</b></FormItem>
                <FormItem prop="c37" style="width: 27%">
                  <Input style="vertical-align:top" type="text" v-model="formRecord.c37" :disabled='disabledoff'/>
                </FormItem>
                <FormItem><b>宽</b></FormItem>
                <FormItem prop="c38" style="width: 27%">
                  <Input type="text" v-model="formRecord.c38" :disabled='disabledoff'/>
                </FormItem>
                <FormItem><b>高</b></FormItem>
                <FormItem prop="c39" style="width: 27%">
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
                  <label class="mb7">
                    <span class="w70">制冷量（瓦）</span>
                    <FormItem prop="c70">
                      <Input type="text" v-model="formRecord.c70" :disabled='disabledoff'/>
                    </FormItem>
                  </label><br>
                  <label class="mb7">
                    <span class="w70">输入功率（瓦）</span>
                    <FormItem prop="c72">
                      <Input type="text" v-model="formRecord.c72" :disabled='disabledoff'/>
                    </FormItem>
                  </label><br>
                  <label class="mb7">
                    <span class="w70">COP值</span>
                    <FormItem prop="c73">
                      <Input type="text" v-model="formRecord.c73" :disabled='disabledoff'/>
                    </FormItem>
                  </label>
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
                  <label class="mb7">
                    <span class="w70">制冷量（瓦）</span>
                    <FormItem prop="c75">
                      <Input type="text" v-model="formRecord.c75" :disabled='disabledoff'/>
                    </FormItem>
                  </label><br>
                  <label class="mb7">
                    <span class="w70">输入功率（瓦）</span>
                    <FormItem prop="c77">
                      <Input type="text" v-model="formRecord.c77" :disabled='disabledoff'/>
                    </FormItem>
                  </label><br>
                  <label class="mb7">
                    <span class="w70">COP值</span>
                    <FormItem prop="c78">
                      <Input type="text" v-model="formRecord.c78" :disabled='disabledoff'/>
                    </FormItem>
                  </label>
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
                  <label class="mb7">
                    <span class="w70">风量（m³/h）</span>
                    <FormItem prop="c80">
                      <Input type="text" v-model="formRecord.c80" :disabled='disabledoff'/>
                    </FormItem>
                  </label><br>
                  <label class="mb7">
                    <span class="w70">全压（Pa）</span>
                    <FormItem prop="c82">
                      <Input type="text" v-model="formRecord.c82" :disabled='disabledoff'/>
                    </FormItem>
                  </label><br>
                  <label><span class="w70">输入功率（W）</span>
                    <FormItem prop="c83">
                      <Input type="text" v-model="formRecord.c83" :disabled='disabledoff'/>
                    </FormItem>
                  </label>
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
                   <label class="mb7">
                    <span class="w70">风量（m³/h）</span>
                    <FormItem prop="c85">
                      <Input type="text" v-model="formRecord.c85" :disabled='disabledoff'/>
                    </FormItem>
                  </label><br>
                  <label class="mb7">
                    <span class="w70">全压（Pa）</span>
                    <FormItem prop="c87">
                      <Input type="text" v-model="formRecord.c87" :disabled='disabledoff'/>
                    </FormItem>
                  </label><br>
                  <label><span class="w70">输入功率（W）</span>
                    <FormItem prop="c88">
                      <Input type="text" v-model="formRecord.c88" :disabled='disabledoff'/>
                    </FormItem>
                  </label>
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
                   <label class="mb7">
                    <span class="w70">换热面积（㎡）</span>
                    <FormItem prop="c90">
                      <Input type="text" v-model="formRecord.c90" :disabled='disabledoff'/>
                    </FormItem>
                  </label><br>
                  <label class="mb7">
                    <span class="w70">铜管直径（mm）</span>
                    <FormItem prop="c92">
                      <Input type="text" v-model="formRecord.c92" :disabled='disabledoff'/>
                    </FormItem>
                  </label>
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
                   <label class="mb7">
                    <span class="w70">换热面积（㎡）</span>
                    <FormItem prop="c94">
                      <Input type="text" v-model="formRecord.c94" :disabled='disabledoff'/>
                    </FormItem>
                  </label><br>
                  <label class="mb7">
                    <span class="w70">铜管直径（mm）</span>
                    <FormItem prop="c96">
                      <Input type="text" v-model="formRecord.c96" :disabled='disabledoff'/>
                    </FormItem>
                  </label>
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
                   <label class="mb7">
                    <span class="w70">换热管表面积（㎡）</span>
                    <FormItem prop="c98">
                      <Input type="text" v-model="formRecord.c98" :disabled='disabledoff'/>
                    </FormItem>
                  </label>
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
                   <label class="mb7">
                    <span class="w70">换热管表面积（㎡）</span>
                    <FormItem prop="c101">
                      <Input type="text" v-model="formRecord.c101" :disabled='disabledoff'/>
                    </FormItem>
                  </label>
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
                    :before-upload="fileHandleBeforeUpload24"
                    :data="uploadParam.fileData24"
                    :on-success="getFile24"
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
                    :before-upload="fileHandleBeforeUpload26"
                    :data="uploadParam.fileData26"
                    :on-success="getFile26"
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
                    :before-upload="fileHandleBeforeUpload27"
                    :data="uploadParam.fileData27"
                    :on-success="getFile27"
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
                    :before-upload="fileHandleBeforeUpload28"
                    :data="uploadParam.fileData28"
                    :on-success="getFile28"
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
                    :before-upload="fileHandleBeforeUpload29"
                    :data="uploadParam.fileData29"
                    :on-success="getFile29"
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
                    :before-upload="fileHandleBeforeUpload30"
                    :data="uploadParam.fileData30"
                    :on-success="getFile30"
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
                    :before-upload="fileHandleBeforeUpload31"
                    :data="uploadParam.fileData31"
                    :on-success="getFile31"
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
                    :before-upload="fileHandleBeforeUpload32"
                    :data="uploadParam.fileData32"
                    :on-success="getFile32"
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
                    :before-upload="fileHandleBeforeUpload76"
                    :data="uploadParam.fileData76"
                    :on-success="getFile76"
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
        <Button type="primary" @click="saveRecord" v-if='!$store.state.app.pageType' :disabled="saveDisabled">保存到草稿
        </Button>
        <!-- <Button type="primary" @click="submitRecord" :disabled="submitDisabled">提交备案审核申请</Button> -->
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
    <!--<Modal v-model="modal2" title="提交工单" @on-ok="submitWorkorder">
      <p style="font-size:18px;margin-bottom:10px;">实验室数值：{{currentValue}}</p>
      <Input type="textarea" :rows="3" placeholder="请描述问题" v-model="qus"/>
    </Modal>-->
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
        c18: true,
        c19: true,
        c20: true,
        c26: true,
        c27: true,
        c28: true,
        c29: true,
        c30: true
      }
    }
  },
  mounted () {
    this.disabledoff = this.$store.state.app.pageType == 'extend'
  },
  methods: {
    showTemplate () {
      this.templatePic = this.$store.state.app.pltPic
      this.modal3 = true
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
          fileObj.ec_attach_path = _this.uploadParam.filePath24 = res.data.host + _this.dir + file.name
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
          fileObj.ec_attach_path = _this.uploadParam.filePath26 = res.data.host + _this.dir + file.name
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
          fileObj.ec_attach_path = _this.uploadParam.filePath27 = res.data.host + _this.dir + file.name
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
          fileObj.ec_attach_path = _this.uploadParam.filePath28 = res.data.host + _this.dir + file.name
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
          fileObj.ec_attach_path = _this.uploadParam.filePath29 = res.data.host + _this.dir + file.name
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
          fileObj.ec_attach_path = _this.uploadParam.filePath30 = res.data.host + _this.dir + file.name
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
          fileObj.ec_attach_path = _this.uploadParam.filePath31 = res.data.host + _this.dir + file.name
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
          fileObj.ec_attach_path = _this.uploadParam.filePath32 = res.data.host + _this.dir + file.name
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
          fileObj.ec_attach_path = _this.uploadParam.filePath76 = res.data.host + _this.dir + file.name
          _this.filesArr.push(fileObj)
          resolve()
        })
      })
    },
    /* 数据来源  扩展备案 */
    fillExtendData (params) {
      let that = this
      let data = params.data
      let mark = params.marking
      that.$store.commit('setPtId', mark.ptid)
      that.$store.commit('setPltId', mark.pltId)
      that.$store.commit('setRid', mark.ec_labreport_id)
      that.$store.commit('setBarcode', mark.ec_labreport_no)
      that.$store.commit('setLabName', mark.ec_labname)
      that.formRecord.id = mark.id
      for (let i in data) {
        if (that.formRecord[i] != null && that.formRecord[i].constructor === Array) {
          that.formRecord[i] = []
          data[i].split(';').forEach((v) => {
            that.formRecord[i].push(v)
          })
        } else if (i === that.thisDateCV) {
          // this.$store.commit('setDateInit', data[i])
          if (data[i] != undefined) that.formRecord[i] = that.formatDate(data[i])
        } else {
          that.formRecord[i] = data[i]
        }
      }
    },
    /* 数据来源 草稿箱 */
    fillDraftData (params) {
      let that = this
      let data = params.data
      let mark = params.marking
      let attachList = this.filesArr = params.attachList
      attachList.forEach((item, idx) => {
        if (item.ec_attach_id == 25) {
          this.$store.commit('setPltPic', item.ec_attach_path)
        } else {
          that.uploadParam['filePath' + item.ec_attach_id] = item.ec_attach_path
        }
      })

      that.$store.commit('setDefaultData', params.lab.params)
      that.$store.commit('setPtId', mark.ptid)
      that.$store.commit('setPltId', mark.pltId)
      that.$store.commit('setRid', mark.ec_labreport_id)
      that.$store.commit('setBarcode', mark.ec_labreport_no)
      that.$store.commit('setLabName', mark.ec_labname)
      that.formRecord.id = mark.id
      for (let i in data) {
        if (that.formRecord[i] != null && that.formRecord[i].constructor === Array) {
          that.formRecord[i] = []
          data[i].split(';').forEach((v) => {
            that.formRecord[i].push(v)
          })
        } else if (i === that.thisDateCV) {
          // this.$store.commit('setDateInit', data[i])
          if (data[i] != undefined) that.formRecord[i] = that.formatDate(data[i])
        } else {
          that.formRecord[i] = data[i]
        }
      }
    },
    showImg (path) {
      this.uploadPic = path
      this.modal4 = true
    },
    /* 数据来源 新增备案 */
    fillDefaultData () {
      let that = this
      that.formRecord.c200 = that.$store.state.app.gb
      that.$store.state.app.defaultData.forEach((e) => {
        if (that.formRecord[i] != null && that.formRecord[i].constructor === Array) {
          that.formRecord[e.recId] = []
          if (e.labValue === '/' || e.labValue == null || e.labValue == '') {
            return
          }
          that.formRecord[e.recId] = e.labValue.replace(/\s+/g, '').split(';')
        } else {
          if (e.labValue === '/' || e.labValue == null || e.labValue == '') {
            that.formRecord[e.recId] = ''
          } else {
            let labVal = e.labValue.replace(/（/g, '(').replace(/）/g, ')')
            if (e.recId === this.thisLevelCV) {
              if (parseInt(labVal) !== 1 && parseInt(labVal) !== 2 && parseInt(labVal) !== 3 && parseInt(labVal) !== 4 && parseInt(labVal) !== 5) {
                that.formRecord[e.recId] = '1'
              } else {
                that.formRecord[e.recId] = parseInt(labVal).toString()
              }
            } else if (e.recId === that.thisDateCV && isNaN(labVal)) {
              that.formRecord[e.recId] = new Date()
            } else {
              that.formRecord[e.recId] = labVal
            }
          }
        }
      })
    },

    showConfirm () {
      let _this = this
      let pageType = _this.$store.state.app.pageType
      if (_this.uploadParam.filePath24 === '') {
        _this.$Message.warning('请上传产品正面图片！')
        return false
      }
      if (_this.uploadParam.filePath76 === '') {
        _this.$Message.warning('请上传铭牌图片！')
        return false
      }
      if (pageType === 'extend' || pageType === 'update') {
        if (_this.formRecord.ec_master_kuozhan_text === '') {
          let text = pageType === 'extend' ? '扩展' : '变更'
          _this.$Message.warning('请填写' + text + '申请书！')
        } else {
          _this.modal1 = true
        }
        return
      }
      this.$refs['formRecord'].validate((valid) => {
        if (valid) {
          if (_this.confirmData.join('') == 1) {
            _this.boolFlag = _this.diffRecord(_this.$store.state.app.defaultData, _this.formRecord)
            _this.modal1 = true
          } else {
            _this.$Message.warning('请勾选我已确认以上数据填写无误选项')
          }
        }
      })
    },
    diffRecord (orgin, target) {
      let newArr = []
      for (let i = 0; i < orgin.length; i++) {
        let v = orgin[i]
        if (target.hasOwnProperty(v.recId)) {
          if (Object.prototype.toString.call(target[v.recId]) == '[object Array]') {
            let oldarr = (v.labValue).split(';').sort().join(';'),
              newarr = (target[v.recId]).sort().join(';')
            if (oldarr != newarr) {
              v.updateVal = target[v.recId]
              newArr.push(v)
            }
          } else {
            if (v.labValue != target[v.recId]) {
              if (v.recId == this.thisLevelCV) {
                if (parseInt(v.labValue) != target[v.recId]) {
                  v.updateVal = target[v.recId] + '级'
                  newArr.push(v)
                }
              } else {
                v.updateVal = target[v.recId]
                newArr.push(v)
              }
            }
          }
        }
      }

      return newArr
    },
    submitBasic () {
    },

    submitRecord () {
      let _this = this
      let pageType = _this.$store.state.app.pageType
      _this.formRecord[_this.thisDateCV] = _this.formatDate(_this.formRecord[_this.thisDateCV])
      _this.formRecord.ptid = _this.$store.state.app.ptId
      _this.formRecord.pltId = _this.$store.state.app.pltId
      _this.formRecord.record_type = 0
      _this.formRecord.ec_labreport_id = _this.$store.state.app.rid
      _this.formRecord.ec_labreport_no = _this.$store.state.app.barcode
      _this.formRecord.ec_labname = _this.$store.state.app.labName
      let file25 = {
        ec_attach_id: '25',
        ec_attach_originalname: '',
        ec_attach_file: '',
        ec_attach_path: _this.$store.state.app.pltPic
      }
      let flag = false
      _this.filesArr.forEach(item => {
        if (item.ec_attach_id == 25) {
          flag = true
        }
      })
      if (!flag) {
        _this.filesArr.push(file25)
      }
      _this.formRecord.attach_list = JSON.stringify(_this.filesArr)
      _this.formRecord.id = _this.$store.state.app.updateId || 0
      if (pageType === 'extend' || pageType === 'update') {
        let submitUrl = pageType === 'extend' ? '/marking/saveExpand.do' : '/marking/saveChange.do'
        axios({
          url: submitUrl,
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
        }).then(res => {
          if (res.data.result_code === '1') {
            // let txt = _this.$store.state.app.pltId === 244 ? '请自行上传标识图' : '备案正在自动公告中。'
            _this.$Modal.success({
              title: '提交成功',
              content: '<p>备案数据已经提交成功！</p>',
              okText: '查看详情',
              onOk () {
                _this.$router.push('/queryRecord')
              }
            })
          } else {
            _this.$Message.warning(res.data.message)
            // _this.submitDisabled = false
          }
        })
      } else {
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
        }).then(res => {
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
      }
    },
    /* 保存草稿箱 */
    saveRecord () {
      let _this = this
      _this.saveDisabled = true
      _this.formRecord[_this.thisDateCV] = _this.formatDate(_this.formRecord[_this.thisDateCV])
      _this.formRecord.ptid = _this.$store.state.app.ptId
      _this.formRecord.pltId = _this.$store.state.app.pltId
      _this.formRecord.record_type = 0
      _this.formRecord.ec_labreport_id = _this.$store.state.app.rid
      _this.formRecord.ec_labreport_no = _this.$store.state.app.barcode
      _this.formRecord.ec_labname = _this.$store.state.app.labName
      var file25 = {
        ec_attach_id: '25',
        ec_attach_originalname: '',
        ec_attach_file: '',
        ec_attach_path: _this.$store.state.app.pltPic
      }
      _this.filesArr.push(file25)
      _this.formRecord.attach_list = JSON.stringify(_this.filesArr)

      axios({
        url: '/marking/saveDraft.do',
        method: 'POST',
        data: _this.formRecord,
        // 只适用于 POST,PUT,PATCH，transformRequest`
        // 允许在向服务器发送前，修改请求数据。后面数组中的函数必须返回一个字符串，
        // 或 ArrayBuffer，或 Stream
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
            _this.$Message.warning(res.data.message)
            _this.saveDisabled = false
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
    requiredStr () {
      return this.$store.state.app.requiredStr
    },
    ruleRecord () {
      if (this.formRecord.c25 === '2') {
          this.forbidden.c26 = false
        } else {
          this.formRecord.c26 = ''
          this.forbidden.c26 = true
        }


      // let decimal1 =/^(([1-9]{1}\d*)|(0{1}))(\.\d{1})$/
      let decimal2 = /^(([1-9]{1}\d*)|(0{1}))(\.\d{2})$/
      let decimal3 = /^(([1-9]{1}\d*)|(0{1}))(\.\d{3})$/
      let significantDigits2 = /^[1-9]\d{1}$|^[1-9]\.\d{1}$|^0\.0*[0-9]{2}$/
      let significantDigits3 = /^[1-9]\.?\d{2}$|^[1-9]{2}\.\d{1}$|^0\.0*[0-9]{3}$/

      const threeDecimals = (rule, vaule, callback) => {
        decimal3.test(vaule) ? callback() : callback('三位小数')
      }
      const twoDecimals = (rule, vaule, callback) => {
        decimal2.test(vaule) ? callback() : callback('两位小数')
      }
      // const oneDecimals=(rule, vaule, callback)=>{
      //   decimal1.test(vaule)? callback(): callback('一位小数');
      // }
      const significantDigits22 = (rule, vaule, callback) => {
        significantDigits2.test(vaule) ? callback() : callback('两位有效数字')
      }
      const significantDigits33 = (rule, vaule, callback) => {
        significantDigits3.test(vaule) ? callback() : callback('三位有效数字')
      }

      // 能效等级
      var nxdj = this.formRecord.c7
      // 类型
      var lx = this.formRecord.c8
      // 能源效率（cd/W）标注值
      var energyVal = parseFloat(this.formRecord.c9)
      // 能源效率（cd/W）实测值
      var energyValsh = parseFloat(this.formRecord.c12)
      // 关闭状态功率(W)标注值
      var closeVal = parseFloat(this.formRecord.c10)
      // 关闭状态功率(W)实测值
      var closeValsh = parseFloat(this.formRecord.c13)
      // 睡眠状态功率(W)标注值
      var sleepVal = parseFloat(this.formRecord.c11)
      // 睡眠状态功率(W)实测值
      var sleepValsh = parseFloat(this.formRecord.c14)
      var nxdjst = ''

      const checkc9 = (rule, value, callback) => {
        if (energyVal > energyValsh) {
          callback('能源效率标注值应小于等于实测值')
        } else {
          callback()
        }
      }
      const checkc10 = (rule, value, callback) => {
        if (closeValsh > closeVal) {
          callback('关闭状态功率标注值应大于等于实测值')
        } else {
          callback()
        }
      }
      const checkc11 = (rule, value, callback) => {
        if (sleepValsh > sleepVal) {
          callback('睡眠状态功率标注值应大于等于实测值')
        } else {
          callback()
        }
      }
      var checkc10a
      var checkc10b
      var checkc10c
      var checkc11a
      if (lx != '') {
        if (lx == '标准显示器') {
          checkc10a = (rule, value, callback) => {
            if (closeVal > 0.5) {
              callback('关闭状态功率(W)标注值应小于等于0.50W')
            } else {
              callback()
            }
          }
          checkc10b = (rule, value, callback) => {
            if (sleepVal > 0.5) {
              callback('关闭状态功率(W)标注值应小于等于0.50W')
            } else {
              callback()
            }
          }
          if (energyVal != '') {
            if (energyVal >= 2.0) {
              nxdjst = '1'
            }
            if (energyVal >= 1.5 && energyVal < 2.0) {
              nxdjst = '2'
            }
            if (energyVal >= 1.0 && energyVal < 1.5) {
              nxdjst = '3'
            }
          }
        } else if (lx == '高性能显示器') {
          checkc10c = (rule, value, callback) => {
            if (closeVal > 0.5) {
              callback('关闭状态功率(W)标注值应小于等于0.50W')
            } else {
              callback()
            }
          }
          checkc11a = (rule, value, callback) => {
            if (sleepVal > 1.2) {
              callback('睡眠状态功率(W)标注值应小于等于1.20W')
            } else {
              callback()
            }
          }
          if (energyVal != '') {
            if (energyVal >= 1.5) {
              nxdjst = '1'
            }
            if (energyVal >= 1.0 && energyVal < 1.5) {
              nxdjst = '2'
            }
            if (energyVal >= 0.50 && energyVal < 1.0) {
              nxdjst = '3'
            }
          }
        } else {
          nxdjst = ''
        }
      }

      const checkc7a = (rule, value, callback) => {
        if (nxdjst == '') {
          callback('能效数据不在备案范围')
        } else {
          callback()
        }
      }
      const checkc7b = (rule, value, callback) => {
        if (nxdjst != nxdj) {
          callback('所选能效等级与计算结果不符！')
        } else {
          callback()
        }
      }

      return {
        c3: [
          {
            required: true,
            message: '请填写制造单位'
          }
        ],
        c45: [
          {
            required: true,
            message: '请填写备案方'
          }
        ],
        c2: [
          {
            required: true,
            message: '请填写商标'
          }
        ],
        c200: [
          {
            required: true,
            message: '  '
          }
        ],
        c9: [
          {
            required: true,
            message: '请选择能效等级'
          },
          {
            validator: checkc7a,
            trigger: 'blur'
          },
          {
            validator: checkc7a,
            trigger: 'blur'
          }
        ],
        c300: [
          {
            required: true,
            message: '能效等级判定依据不能为空'
          }
        ],
        c5: [
          {
            required: true,
            message: '制冷量标准值不能为空'
          }
        ],
        c50: [
          {
            required: true,
            message: '制冷量实测值不能为空'
          }
        ],
        c6: [
          {
            required: true,
            message: '消耗总电功率标注值不能为空'
          }
        ],
        c51: [
          {
            required: true,
            message: '消耗总电功率实测值不能为空'
          }
        ],
        c7: [
          {
            required: true,
            message: '性能系数标注值不能为空'
          },
          {
            validator: twoDecimals,
            trigger: 'blur'
          }
        ],
        c52: [
          {
            required: true,
            message: '性能系数实测值不能为空'
          }
        ],
        c8: [
          {
            required: true,
            message: '综合部分负荷性能系数标注值不能为空'
          },
          {
            validator: twoDecimals,
            trigger: 'blur'
          }
        ],
        c53: [
          {
            required: true,
            message: '综合部分负荷性能系数实测值不能为空'
          }
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
            message: '机器类型不能为空'
          }
        ],
        c12: [
          {
            required: true,
            message: '冷却方式不能为空'
          }
        ],
        c13: [
          {
            required: true,
            message: '模块化不能为空'
          }
        ],
        c14: [
          {
            required: true,
            message: '其他载冷剂不能为空'
          }
        ],
        c15: [
          {
            required: true,
            message: '热泵功能不能为空'
          }
        ],
        c16: [
          {
            required: true,
            message: '部分负荷运行不能为空'
          }
        ],
        c17: [
          {
            required: true,
            message: '结构形式不能为空'
          }
        ],
        c18: [
          {
            required: true,
            message: '换热器(水/制冷剂)使用侧不能为空'
          }
        ],
        c19: [
          {
            required: true,
            message: '换热器(水/制冷剂)热源侧不能为空'
          }
        ],
        c20: [
          {
            required: true,
            message: '膨胀阀类型不能为空'
          }
        ],
        c21: [
          {
            required: true,
            message: '污垢系数不能为空'
          }
        ],
        c22: [
          {
            required: true,
            message: '油分离器不能为空'
          }
        ],
        c23: [
          {
            required: true,
            message: '储液器不能为空'
          }
        ],
        c24: [
          {
            required: true,
            message: '辅助电加热器不能为空'
          }
        ],
        c25: [
          {
            required: true,
            message: '热回收功能不能为空'
          }
        ],
        c26: [
          {
            required: true,
            message: '制热量不能为空'
          }
        ],
        c27: [
          {
            required: true,
            message: '热泵制热消耗总电功率（kW）不能为空'
          }
        ],
        c28: [
          {
            required: true,
            message: '制热性能系数（COP）不能为空'
          }
        ],
        c29: [
          {
            required: true,
            message: '电源类型不能为空'
          }
        ],
        c30: [
          {
            required: true,
            message: '控制系统不能为空'
          }
        ],
        c31: [
          {
            required: true,
            message: '是否允注制冷剂不能为空'
          }
        ],
        c32: [
          {
            required: true,
            message: '制冷剂/灌注量(kg)不能为空'
          }
        ],
        c33: [
          {
            required: true,
            message: '灌注量(kg)不能为空'
          }
        ],
        c34: [
          {
            required: true,
            message: '整机或室内机外形尺寸长不能为空'
          }
        ],
        c35: [
          {
            required: true,
            message: '整机或室内机外形尺寸宽不能为空'
          }
        ],
        c36: [
          {
            required: true,
            message: '整机或室内机外形尺寸高不能为空'
          }
        ],
        c37: [
          {
            required: true,
            message: '室外机外形尺寸长不能为空'
          }
        ],
        c38: [
          {
            required: true,
            message: '室外机外形尺寸宽不能为空'
          }
        ],
        c39: [
          {
            required: true,
            message: '室外机外形尺寸高不能为空'
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
        c72: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c73: [
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
        c80: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c81: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c82: [
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
        c92: [
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
        c98: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c99: [
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
  @import '../../../css/comm.css';
</style>
