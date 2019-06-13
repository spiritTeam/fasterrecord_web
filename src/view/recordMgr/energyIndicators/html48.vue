/*
*家用燃气快速热水器/燃气采暖热水炉-能源效率标识备案表
*创建人：yph
*创建时间：5.28
*/
<template>
  <div class="wrapper">
    <Form ref="formRecord" :model="formRecord" label-position="right" :rules="ruleRecord">
      <h1>家用燃气快速热水器/燃气采暖热水炉-能源效率标识备案表</h1>
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
          <FormItem prop="c7" label="能效等级" style="width:100%;" :label-width="180">
            <RadioGroup v-model="formRecord.c7">
              <Radio label="1" :disabled='disabledoff'>1级</Radio>
              <Radio label="2" :disabled='disabledoff'>2级</Radio>
              <Radio label="3" :disabled='disabledoff'>3级</Radio>
            </RadioGroup>
          </FormItem>
          <FormItem prop="c27" label="产品类型" :label-width="180">
            <RadioGroup v-model="formRecord.c27">
              <Radio :disabled='disabledoff' label="家用燃气快速热水器">家用燃气快速热水器</Radio>
              <Radio :disabled='disabledoff' label="燃气采暖热水炉(单采暖型)">燃气采暖热水炉(单采暖型)</Radio>
              <Radio :disabled='disabledoff' label=" 燃气采暖热水炉(两用型)"> 燃气采暖热水炉(两用型)</Radio>
            </RadioGroup>
          </FormItem>
          <table id="table1">
            <tr>
              <th>项目</th>
              <th>额定值</th>
              <th>实测值</th>
              <th>备注</th>
            </tr>
            <tr>
              <td>额定热水热负荷</td>
              <td>
                <FormItem prop="c8">
                  <Input type="text" v-model="formRecord.c8" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c9">
                  <Input type="text" v-model="formRecord.c9" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c10">
                  <Input type="text" v-model="formRecord.c10" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>额定供暖热负荷</td>
              <td>
                <FormItem prop="c11">
                  <Input type="text" v-model="formRecord.c11" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c12">
                  <Input type="text" v-model="formRecord.c12" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c13">
                  <Input type="text" v-model="formRecord.c13" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>额定热负荷热水热效率</td>
              <td>
                <FormItem prop="c14">
                  <Input type="text" v-model="formRecord.c14" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c15">
                  <Input type="text" v-model="formRecord.c15" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c16">
                  <Input type="text" v-model="formRecord.c16" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>50%额定热负荷热水热效率</td>
              <td>
                <FormItem prop="c17">
                  <Input type="text" v-model="formRecord.c17" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c18">
                  <Input type="text" v-model="formRecord.c18" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c19">
                  <Input type="text" v-model="formRecord.c19" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>额定热负荷供暖热效率</td>
              <td>
                <FormItem prop="c20">
                  <Input type="text" v-model="formRecord.c20" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c21">
                  <Input type="text" v-model="formRecord.c21" :disabled='disabledoff' />
                </FormItem>
              </td>
              <td>
                <FormItem prop="c22">
                  <Input type="text" v-model="formRecord.c22" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
             <tr>
              <td>30%额定热负荷供暖热效率	</td>
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
              <td>
                <FormItem prop="c25">
                  <Input type="text" v-model="formRecord.c25" :disabled='disabledoff'/>
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
          <FormItem prop="c26" label="备案标识开始使用日期" style="width:100%;">
            <DatePicker type="date" :options="dataInit" style="width: 200px" v-model="formRecord.c26"
                        :disabled='disabledoff'></DatePicker>
          </FormItem>
        </Card>
      </div>
      <div class="part part5">
        <Card :bordered="false">
          <h2>五、样品描述</h2>
          <table id="table3">
            <tr>
              <td>是否冷凝式</td>
              <td>
                <FormItem prop="c28">
                  <RadioGroup v-model="formRecord.c28">
                    <Radio label="是" :disabled='disabledoff'>是</Radio>
                    <Radio label="否" :disabled='disabledoff'>否</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>燃气类别</td>
              <td>
                <FormItem prop="c29">
                  <RadioGroup v-model="formRecord.c29">
                    <Radio label="人工煤气" :disabled='disabledoff'>人工煤气</Radio>（
                      <FormItem prop="c30">
                        <RadioGroup v-model="formRecord.c30">
                          <Radio label="5R" :disabled='disabledoff'>5R</Radio>
                          <Radio label="6R" :disabled='disabledoff'>6R</Radio>
                          <Radio label="7R" :disabled='disabledoff'>7R</Radio>
                        </RadioGroup>
                      </FormItem>）<br><br>
                    <Radio label="天然气" :disabled='disabledoff'> 天然气</Radio>（
                      <FormItem prop="c31">
                        <RadioGroup v-model="formRecord.c31">
                          <Radio label="4T" :disabled='disabledoff'>4T</Radio>
                          <Radio label="6T" :disabled='disabledoff'>6T</Radio>
                          <Radio label="10T" :disabled='disabledoff'>10T</Radio>
                          <Radio label="12T" :disabled='disabledoff'>12T</Radio>
                        </RadioGroup>
                      </FormItem>）<br><br>
                    <Radio label="液化石油气" :disabled='disabledoff'>液化石油气</Radio>（
                      <FormItem prop="c32">
                        <RadioGroup v-model="formRecord.c32">
                        <Radio label="19Y" :disabled='disabledoff'>19Y</Radio>
                        <Radio label="20Y" :disabled='disabledoff'>20Y</Radio>
                        <Radio label="22Y" :disabled='disabledoff'>22Y</Radio>
                      </RadioGroup>
                    </FormItem>）<br><br>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>供电电压（V）</td>
              <td>
                <FormItem prop="c33">
                  <Input type="text" style="width: 440px" v-model="formRecord.c33" :disabled='disabledoff' width="100px"/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>额定热负荷（kW）</td>
              <td>
                <FormItem prop="c34">
                  <CheckboxGroup v-model="formRecord.c34">
                    <Checkbox label="热水" :disabled='disabledoff'></Checkbox>
                    <FormItem prop="c35">
                      <Input type="text" v-model="formRecord.c35" :disabled='disabledoff || forbidden.c35' style="width:80px;" />（kW）
                    </FormItem>
                    <Checkbox label="供暖" :disabled='disabledoff'></Checkbox>
                    <FormItem prop="c36">
                      <Input type="text" v-model="formRecord.c36" :disabled='disabledoff || forbidden.c36' style="width:80px;" />（kW）
                    </FormItem>
                  </CheckboxGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>供暖热输出（kW）</td>
              <td>
                <FormItem prop="c37">
                  <Input type="text" style="width: 440px" v-model="formRecord.c37" :disabled='disabledoff' width="100px"/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>供暖系统结构型式</td>
              <td>
                <FormItem prop="c38">
                  <RadioGroup v-model="formRecord.c38">
                    <Radio label="封闭式" :disabled='disabledoff'>封闭式</Radio>
                    <Radio label="敞开式" :disabled='disabledoff'>敞开式</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>产热水能力（kg/min）</td>
              <td>
                <FormItem prop="c39">
                  <Input type="text" style="width: 440px" v-model="formRecord.c39" :disabled='disabledoff' width="100px"/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>额定燃气压力（kPa）</td>
              <td>
                <FormItem prop="c40">
                  <Input type="text" style="width: 440px" v-model="formRecord.c40" :disabled='disabledoff' width="100px"/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>系统适用水压（MPa）</td>
              <td>
                <FormItem prop="c41">
                  <CheckboxGroup v-model="formRecord.c41" style="display:inline-block;">
                    <Checkbox label="热水" :disabled='disabledoff'>热水</Checkbox>
                    <FormItem prop="c42">
                      <Input type="text" v-model="formRecord.c42" :disabled='disabledoff || forbidden.c42' style="width:80px;" />（kW）
                    </FormItem>
                    <Checkbox label="供暖" :disabled='disabledoff'>供暖</Checkbox>
                    <FormItem prop="c43">
                      <Input type="text" v-model="formRecord.c43" :disabled='disabledoff || forbidden.c43' style="width:80px;" />（kW）
                    </FormItem>
                  </CheckboxGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>华白数（MJ/m3）</td>
              <td>
                <FormItem prop="c44">
                  <Input type="text" style="width: 440px" v-model="formRecord.c44" :disabled='disabledoff' width="100px"/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>燃烧势</td>
              <td>
                <FormItem prop="c45">
                  <Input type="text" style="width: 440px" v-model="formRecord.c45" :disabled='disabledoff' width="100px"/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>安装位置</td>
              <td>
                <FormItem prop="c46">
                  <RadioGroup v-model="formRecord.c46">
                    <Radio label="室内型" :disabled='disabledoff'>室内型</Radio>
                    <Radio label="室外型" :disabled='disabledoff'>室外型</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>给排气方式</td>
              <td>
                <FormItem prop="c47">
                  <RadioGroup v-model="formRecord.c47">
                    <Radio label="自然给排气" :disabled='disabledoff'>自然给排气</Radio>
                    <Radio label="自然排气" :disabled='disabledoff'>自然排气</Radio>
                    <Radio label="强制给排气" :disabled='disabledoff'>强制给排气</Radio>
                    <Radio label="强制排气" :disabled='disabledoff'>强制排气</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>热水系统自动恒温功能</td>
              <td>
                <FormItem prop="c48">
                  <RadioGroup v-model="formRecord.c48">
                    <Radio label="有" :disabled='disabledoff'>有</Radio>
                    <Radio label="无" :disabled='disabledoff'>无</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>热水系统温度显示</td>
              <td>
                <FormItem prop="c49">
                  <RadioGroup v-model="formRecord.c49">
                    <Radio label="有" :disabled='disabledoff'>有</Radio>
                    <Radio label="无" :disabled='disabledoff'>无</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>燃气稳压装置</td>
              <td>
                <FormItem prop="c50">
                  <RadioGroup v-model="formRecord.c50">
                    <Radio label="有" :disabled='disabledoff'>有</Radio>
                    <Radio label="无" :disabled='disabledoff'>无</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>烟气倒流保护装置</td>
              <td>
                <FormItem prop="c51">
                  <RadioGroup v-model="formRecord.c51">
                    <Radio label="有" :disabled='disabledoff'>有</Radio>
                    <Radio label="无" :disabled='disabledoff'>无</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>小火燃烧器</td>
              <td>
                <FormItem prop="c52">
                  <RadioGroup v-model="formRecord.c52">
                    <Radio label="有" :disabled='disabledoff'>有</Radio>
                    <Radio label="无" :disabled='disabledoff'>无</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>控制器形式</td>
              <td>
                <FormItem prop="c53">
                  <RadioGroup v-model="formRecord.c53">
                    <Radio label="机械" :disabled='disabledoff'>机械</Radio>
                    <Radio label="电子" :disabled='disabledoff'>电子</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>风压开关（Q、G）</td>
              <td>
                <FormItem prop="c54">
                  <RadioGroup v-model="formRecord.c54">
                    <Radio label="有" :disabled='disabledoff'>有</Radio>
                    <Radio label="无" :disabled='disabledoff'>无</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>燃烧室压力（Q、G）</td>
              <td>
                <FormItem prop="c55">
                  <RadioGroup v-model="formRecord.c55">
                    <Radio label="正" :disabled='disabledoff'>正</Radio>
                    <Radio label="负" :disabled='disabledoff'>负</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>安全装置</td>
              <td>
                <FormItem prop="c56">
                  <CheckboxGroup v-model="formRecord.c56" style="display:inline-block;">
                    <Checkbox label="熄火保护装置" :disabled='disabledoff'>熄火保护装置</Checkbox>
                    <Checkbox label="烟道堵塞安全装置" :disabled='disabledoff'>烟道堵塞安全装置</Checkbox>
                    <Checkbox label="再点火安全装置" :disabled='disabledoff'>再点火安全装置</Checkbox><br>
                    <Checkbox label="防过热安全装置" :disabled='disabledoff'>防过热安全装置</Checkbox>
                    <Checkbox label="泄压安全装置" :disabled='disabledoff'>泄压安全装置</Checkbox>
                    <Checkbox label="风压过大安全装置" :disabled='disabledoff'>风压过大安全装置</Checkbox><br>
                    <Checkbox label="自动排气装置" :disabled='disabledoff'>自动排气装置</Checkbox>
                    <Checkbox label="燃烧室损伤安全装置" :disabled='disabledoff'>燃烧室损伤安全装置</Checkbox>
                    <Checkbox label="自动防冻安全装置" :disabled='disabledoff'>自动防冻安全装置</Checkbox><br>
                    <Checkbox label="其他" :disabled='disabledoff'>其他</Checkbox>
                    <FormItem prop="c57">
                      <Input type="text" v-model="formRecord.c57" :disabled='disabledoff || forbidden.c57' style="width:80px;" />
                    </FormItem>
                  </CheckboxGroup>
                </FormItem>
              </td>
            </tr> 
            <tr>
              <td>外形尺寸(长×宽×高)（mm×mm×mm）</td>
              <td>
                <span style="display: inline-block;height: 32px;line-height: 32px;">长</span>
                <FormItem prop="c58">
                  <Input type="text" v-model="formRecord.c58" :disabled='disabledoff' style="width:80px;" />
                </FormItem>
                <span style="display: inline-block;height: 32px;line-height: 32px;">宽</span>
                <FormItem prop="c59">
                  <Input type="text" v-model="formRecord.c59" :disabled='disabledoff' style="width:80px;" />
                </FormItem>
                <span style="display: inline-block;height: 32px;line-height: 32px;">高</span>
                <FormItem prop="c60">
                  <Input type="text" v-model="formRecord.c60" :disabled='disabledoff' style="width:80px;" />
                </FormItem>
              </td>
            </tr>
          </table>
        </Card>
      </div>
      <div class="part part6">
        <Card :bordered="false">
          <h2>六、关键零部件清单</h2>
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
              <td>燃烧器</td>
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
              <td>
                <FormItem prop="c63">
                  <Input type="text" v-model="formRecord.c63" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td width="80">2</td>
              <td>燃烧器</td>
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
              <td>
                <FormItem prop="c72">
                  <Input type="text" v-model="formRecord.c72" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td width="80">3</td>
              <td>燃烧器</td>
              <td>
                <FormItem prop="c73">
                  <Input type="text" v-model="formRecord.c73" :disabled='disabledoff'/>
                </FormItem>
              </td>
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
            </tr>
            <tr>
              <td width="80">4</td>
              <td>热交换器</td>
              <td>
                <FormItem prop="c64">
                  <Input type="text" v-model="formRecord.c64" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c65">
                  <Input type="text" v-model="formRecord.c65" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c66">
                  <Input type="text" v-model="formRecord.c66" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td width="80">5</td>
              <td>热交换器</td>
              <td>
                <FormItem prop="c76">
                  <Input type="text" v-model="formRecord.c76" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c77">
                  <Input type="text" v-model="formRecord.c77" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c78">
                  <Input type="text" v-model="formRecord.c78" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td width="80">6</td>
              <td>热交换器</td>
              <td>
                <FormItem prop="c79">
                  <Input type="text" v-model="formRecord.c79" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
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
              <td width="80">7</td>
              <td>燃气比例阀</td>
              <td>
                <FormItem prop="c67">
                  <Input type="text" v-model="formRecord.c67" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c68">
                  <Input type="text" v-model="formRecord.c68" :disabled='disabledoff'/>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c69">
                  <Input type="text" v-model="formRecord.c69" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td width="80">8</td>
              <td>燃气比例阀</td>
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
              <td>
                <FormItem prop="c84">
                  <Input type="text" v-model="formRecord.c84" :disabled='disabledoff'/>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td width="80">9</td>
              <td>燃气比例阀</td>
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
              <td>
                <FormItem prop="c87">
                  <Input type="text" v-model="formRecord.c87" :disabled='disabledoff'/>
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
              <td class="tc">生产许可证证书编号</td>
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
    significantDigits33
  } from '@/libs/utilExt'

export default {
  data () {
    const timeDate = this.$store.state.app.dateinit
    return {
      // 当前初始使用日期 对应的C值
      thisDateCV: 'c26',
      // 当前能效等级 对应的C值
      thisLevelCV: 'c7',
      modal3: false,
      modal4: false,
      modal5: false,
      templatePic: '',
      //disabledoff: true,
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
        c7: '1',
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
        c26: new Date(),
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
        c37: '',
        c38: '',
        c39: '',
        c40: '',
        c41: [],
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
        c56: [],
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
        c202: '',
        ec_model_no: 48,
        attach_list: ''
      },
      forbidden: {
        c35: true,
        c36: true
      }
    }
  },
  mounted () {
    //this.disabledoff = this.$store.state.app.pageType == 'extend'
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
    disabledoff(){
      return  this.$store.state.app.pageType==='extend';
    },   
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
     //产品类型
      var lx = this.formRecord.c27
      //能效等级
      var nxdjch = this.formRecord.c7
      //额定热负荷热水热效率
      var valueers = parseFloat(this.formRecord.c14);
      //额定热负荷供暖热效率
      var valueegn = parseFloat(this.formRecord.c20);
      //50%额定热负荷效率值
      var value50 = parseFloat(this.formRecord.c17);
      //30%额定热负荷效率值
      var value30 = parseFloat(this.formRecord.c23);
      if (this.formRecord.c34.join('').indexOf('热水') > -1) {
        this.forbidden.c35 = false
      } else {
        this.formRecord.c35 = ''
        this.forbidden.c35 = true
      }
      if (this.formRecord.c34.join('').indexOf('供暖') > -1) {
        this.forbidden.c36 = false
      } else {
        this.formRecord.c36 = ''
        this.forbidden.c36 = true
      }
      if (this.formRecord.c41.join('').indexOf('供暖') > -1) {
        this.forbidden.c43 = false
      } else {
        this.formRecord.c43 = ''
        this.forbidden.c43 = true
      }
      if (this.formRecord.c41.join('').indexOf('热水') > -1) {
        this.forbidden.c42 = false
      } else {
        this.formRecord.c42 = ''
        this.forbidden.c42 = true
      }
      if (this.formRecord.c56.join('').indexOf('其他') > -1) {
        this.forbidden.c57 = false
      } else {
        this.formRecord.c57 = ''
        this.forbidden.c57 = true
      }
      var nxdj = "";
      var n1 = "";
      var n2 = "";
      var n3 = "";
      var n4 = "";
      var n1val = "";
      var n2val = "";
      var nxdj1 = "";
      var nxdj2 = "";
      var nxdj3 = "";
      var nxdj4 = "";
      var nxdjMidd1 = "";
      var nxdjMidd2 = "";
      if (lx != "") {
        if (lx == "家用燃气快速热水器") {
          if (valueers > value50) {
              n1val = valueers;
              n2val = value50;
          } else {
              n1val = value50;
              n2val = valueers;
          }
          if (n1val != "" && n2val != "") {
            //能效等级1
            if (n1val >= 98) {
                nxdj1 = "1";
            } else if (n1val >= 89 && n1val < 98) {
                nxdj1 = "2";
            } else if (n1val >= 86 && n1val < 89) {
                nxdj1 = "3";
            } else {
                nxdj1 = "";
            }
            //能效等级2
            if (n2val >= 94) {
                nxdj2 = "1";
            } else if (n2val >= 85 && n2val < 94) {
                nxdj2 = "2";
            } else if (n2val >= 82 && n2val < 85) {
                nxdj2 = "3";
            } else {
                nxdj2 = "";
            }
            if (nxdj1 == "" || nxdj2 == "") {
                nxdj = "";
            } else {
                if (nxdj1 > nxdj2) {
                    nxdj = nxdj1;
                } else {
                    nxdj = nxdj2;
                }
            }
          }
        } else if (lx == "燃气采暖热水炉单采暖型") {
            if (valueegn > value30) {
                n1val = valueegn;
                n2val = value30;
            } else {
                n1val = value30;
                n2val = valueegn;
            }
            if (n1val != "" && n2val != "") {
                //能效等级1
                if (n1val >= 99) {
                    nxdj1 = "1";
                } else if (n1val >= 89 && n1val < 99) {
                    nxdj1 = "2";
                } else if (n1val >= 86 && n1val < 89) {
                    nxdj1 = "3";
                } else {
                    nxdj1 = "";
                }
                //能效等级2
                if (n2val >= 95) {
                    nxdj2 = "1";
                } else if (n2val >= 85 && n2val < 95) {
                    nxdj2 = "2";
                } else if (n2val >= 82 && n2val < 85) {
                    nxdj2 = "3";
                } else {
                    nxdj2 = "";
                }
                if (nxdj1 == "" || nxdj2 == "") {
                    nxdj = "";
                } else {
                    if (nxdj1 > nxdj2) {
                        nxdj = nxdj1;
                    } else {
                        nxdj = nxdj2;
                    }
                }

            }
        } else if (lx == "燃气采暖热水炉两用型") {
            //热水
            if (valueers > value50) {
                n1 = valueers;
                n2 = value50;
            } else {
                n1 = value50;
                n2 = valueers;
            }
            //能效等级1
            if (n1 >= 96) {
                nxdj1 = "1";
            } else if (n1 >= 89 && n1 < 96) {
                nxdj1 = "2";
            } else if (n1 >= 86 && n1 < 89) {
                nxdj1 = "3";
            } else {
                nxdj1 = "";
            }
            //能效等级2
          if (n2 >= 92) {
              nxdj2 = "1";
          } else if (n2 >= 85 && n2 < 92) {
              nxdj2 = "2";
          } else if (n2 >= 82 && n2 < 85) {
              nxdj2 = "3";
          } else {
              nxdj2 = "";
          }
          //采暖
          if (valueegn > value30) {
              n3 = valueegn;
                        } else {
            n3 = value30;
              n4 = valueegn;
            }
          //能效等级1
          if (n3 >= 99) {
              nxdj3 = "1";
          } else if (n3 >= 89 && n3 < 99) {
              nxdj3 = "2";
          } else if (n3 >= 86 && n3 < 89) {
              nxdj3 = "3";
            } else {
              nxdj3 = "";
          }
            //能效等级2
          if (n4 >= 95) {
              nxdj4 = "1";
          } else if (n4 >= 85 && n4 < 95) {
              nxdj4 = "2";
          } else if (n4 >= 82 && n4 < 85) {
              nxdj4 = "3";
          } else {
              nxdj4 = "";
          }
          //四个能效值比较出最大值
            if (nxdj1 == "" || nxdj2 == "" || nxdj3 == "" || nxdj4 == "") {                        nxdj = "";
          } else {
              if (nxdj1 > nxdj2) {
                  nxdjMidd1 = nxdj1;
              } else {
                  nxdjMidd1 = nxdj2;
              }
              if (nxdj3 > nxdj4) {
                  nxdjMidd2 = nxdj3;
              } else {
                  nxdjMidd2 = nxdj4;
                }
              if (nxdjMidd1 != "" && nxdjMidd2 != "") {
                    if (nxdjMidd1 > nxdjMidd2) {
                        nxdj = nxdjMidd1;
                    } else {
                      nxdj = nxdjMidd2;
                  }
              }
          }
      } else {
        var nxdj = "";
    }
  }
       const checkc7a = (rule, value, callback) => {
         if (nxdj == "") {
          callback('能效数据不在备案范围')
         } else {
           callback()
         }
      }
      const checkc7b = (rule, value, callback) => {
        if (nxdj != nxdjch) {
           callback('所选能效等级与计算结果不符！')
        } else {
          callback()
        }
      }
      return {
        c1: [
          {
            trigger: 'change,blur',required: true,
            message: '生产者名称不能为空'
          }
        ],
        c2: [
          {
            trigger: 'change,blur',required: true,
            message: '制造单位不能为空'
          }
        ],
        c3: [
          {
            trigger: 'change,blur',required: true,
            message: '备案方不能为空'
          }
        ],
        c4: [
          {
            trigger: 'change,blur',required: true,
            message: '规格型号不能为空'
          }
        ],
        c7: [
          {
            trigger: 'change,blur',required: true,
            message: '能源效率等级不能为空'
          },
          {
            validator: checkc7a,
            trigger: 'blur'
          },
          {
            validator: checkc7b,
            trigger: 'blur'
          }
        ],
        c8: [
          {
            trigger: 'change,blur',required: true,
            message: '额定热水热负荷额定值不能为空'
          }
        ],
        c9: [
          {
            trigger: 'change,blur',required: true,
            message: '额定热水热负荷实测值不能为空'
          }
        ],
        c11: [
          {
            trigger: 'change,blur',required: true,
            message: '额定供暖热负荷额定值不能为空'
          }
        ],
        c12: [
          {
            trigger: 'change,blur',required: true,
            message: '额定供暖热负荷实测值不能为空'
          }
        ],
        c14: [
          {
            trigger: 'change,blur',required: true,
            message: '额定热负荷热水热效率额定值不能为空'
          },
        ],
        c15: [
          {
            trigger: 'change,blur',required: true,
            message: '额定热负荷热水热效率实测值不能为空'
          }
        ],
        c17: [
          {
            trigger: 'change,blur',required: true,
            message: '50%额定热负荷热水热效率额定值不能为空'
          }
        ],
        c18: [
          {
            trigger: 'change,blur',required: true,
            message: '50%额定热负荷热水热效率实测值不能为空'
          }
        ],
        c20: [
          {
            trigger: 'change,blur',required: true,
            message: '额定热负荷供暖热效率额定值不能为空'
          }
        ],
        c21: [
          {
            trigger: 'change,blur',required: true,
            message: '额定热负荷供暖热效率实测值不能为空'
          }
        ],
        c23: [
          {
            trigger: 'change,blur',required: true,
            message: '30%额定热负荷供暖热效率额定值不能为空'
          }
        ],
        c24: [
          {
            trigger: 'change,blur',required: true,
            message: '30%额定热负荷供暖热效率实测值不能为空'
          }
        ],
        c26: [
          {
            trigger: 'change,blur',required: this.formRecord.c25 === '2',
            message: '初始使用日期不能为空'
          }
        ],
        c27: [
          {
            trigger: 'change,blur',required: true,
            message: '产品类别不能为空'
          }
        ],
        c28: [
          {
            trigger: 'change,blur',required: true,
            message: '是否冷凝式不能为空'
          }
        ],
        c29: [
          {
            trigger: 'change,blur',required: true,
            message: '燃气类别不能为空'
          }
        ],
        c30: [
          {
            trigger: 'change,blur',required: this.formRecord.c29 === '人工煤气',
            message: '人工煤气不能为空'
          }
        ],
        c31: [
          {
            trigger: 'change,blur',required: this.formRecord.c29 === '天然气',
            message: '天然气不能为空'
          }
        ],
        c32: [
          {
            trigger: 'change,blur',required: this.formRecord.c29 === '液化石油气',
            message: '液化石油气不能为空'
          }
        ],
        c33: [
          {
            trigger: 'change,blur',required: true,
            message: '供电电压不能为空'
          }
        ],
        c35: [
          {
            trigger: 'change,blur',required: this.formRecord.c34.join('').indexOf('热水') > -1,
            message: '额定热负荷(kW)热水值不能为空'
          }
        ],
        c36: [
          {
            trigger: 'change,blur',required: this.formRecord.c34.join('').indexOf('供暖') > -1,
            message: '额定热负荷(kW)供暖值不能为空'
          }
        ],
        c37: [
          {
            trigger: 'change,blur',required: true,
            message: '供暖热输出不能为空'
          }
        ],
        c39: [
          {
            trigger: 'change,blur',required: true,
            message: '产热水能力不能为空'
          }
        ],
        c40: [
          {
            trigger: 'change,blur',required: true,
            message: '额定燃气压力不能为空'
          }
        ],
        c41: [
          {
            trigger: 'change,blur',required: true,
            message: '系统适用水压不能为空'
          }
        ],
        c42: [
          {
            trigger: 'change,blur',required: this.formRecord.c41.join('').indexOf('热水') > -1,
            message: '系统适用水压(MPa)热水值不能为空'
          }
        ],
        c43: [
          {
            trigger: 'change,blur',required: this.formRecord.c41.join('').indexOf('供暖') > -1,
            message: '系统适用水压(MPa)供暖值不能为空'
          }
        ],
        c44: [
          {
            trigger: 'change,blur',required: true,
            message: '华白数不能为空'
          }
        ],
        c45: [
          {
            trigger: 'change,blur',required: true,
            message: '燃烧势不能为空'
          }
        ],
        c46: [
          {
            trigger: 'change,blur',required: true,
            message: '安装位置不能为空'
          }
        ],
        c47: [
          {
            trigger: 'change,blur',required: true,
            message: '给排气方式不能为空'
          }
        ],
        c48: [
          {
            trigger: 'change,blur',required: true,
            message: '热水系统自动恒温功能不能为空'
          }
        ],
        c49: [
          {
            trigger: 'change,blur',required: true,
            message: '热水系统温度显示不能为空'
          }
        ],
        c50: [
          {
            trigger: 'change,blur',required: true,
            message: '燃气稳压装置不能为空'
          }
        ],
        c51: [
          {
            trigger: 'change,blur',required: true,
            message: '烟气倒流保护装置不能为空'
          }
        ],
        c56: [
          {
            trigger: 'change,blur',required: true,
            message: '安全装置不能为空'
          }
        ],
        c57: [
          {
            trigger: 'change,blur',required: this.formRecord.c56.join('').indexOf('其他') > -1,
            message: '安全装置其他值不能为空'
          }
        ],
        c58: [
          {
            trigger: 'change,blur',required: true,
            message: '外形尺寸(长)不能为空'
          }
        ],
        c59: [
          {
            trigger: 'change,blur',required: true,
            message: '外形尺寸(宽)不能为空'
          }
        ],
        c60: [
          {
            trigger: 'change,blur',required: true,
            message: '外形尺寸(高)不能为空'
          }
        ],
        c61: [
          {
            trigger: 'change,blur',required: true,
            message: '燃烧器型号规格1不能为空'
          }
        ],
        c62: [
          {
            trigger: 'change,blur',required: true,
            message: '燃烧器技术参数1不能为空'
          }
        ],
        c63: [
          {
            trigger: 'change,blur',required: true,
            message: '燃烧器生产者(全称)1不能为空'
          }
        ],
        c64: [
          {
            trigger: 'change,blur',required: true,
            message: '热交换器型号规格1不能为空'
          }
        ],
        c65: [
          {
            trigger: 'change,blur',required: true,
            message: '热交换器技术参数1不能为空'
          }
        ],
        c66: [
          {
            trigger: 'change,blur',required: true,
            message: '热交换器生产者(全称)1不能为空'
          }
        ],
        c67: [
          {
            trigger: 'change,blur',required: true,
            message: '燃气比例阀型号规格1不能为空'
          }
        ],
        c68: [
          {
            trigger: 'change,blur',required: true,
            message: '燃气比例阀技术参数1不能为空'
          }
        ],
        c69: [
          {
            trigger: 'change,blur',required: true,
            message: '燃气比例阀生产者(全称)1不能为空'
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
