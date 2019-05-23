<template>
  <div class="wrapper">
    <Form ref="formRecord" :model="formRecord" label-position="right" :label-width="180" :rules="ruleRecord">
      <h1>家用电冰箱-能源效率标识备案表</h1>
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
                  <Input type="text" :value="$store.state.app.labName" readonly></Input>
                </td>
                <td>
                  <Input type="text" :value="$store.state.app.barcode" readonly></Input>
                </td>
              </tr>
            </tbody>
          </table>
        </Card>
      </div>
      <div class="part part3">
        <Card :bordered="false">
          <h2>三、能源效率标识备案信息</h2>
          <FormItem prop="c1" label="生产者名称" style="width:1000px;">
            <Input type="text" v-model="formRecord.c1" placeholder="生产者名称" readonly></Input>
          </FormItem>
          <FormItem prop="c2" label="制造单位" style="width:1000px;">
            <Input type="text" v-model="formRecord.c2" placeholder="制造单位"></Input>
          </FormItem>
          <FormItem prop="c3" label="备案方" style="width:1000px;">
            <Input type="text" v-model="formRecord.c3" placeholder="备案方"></Input>
          </FormItem>
          <FormItem prop="c4" label="规格型号" style="width:1000px;">
            <Input type="text" v-model="formRecord.c4" placeholder="规格型号" readonly></Input>
          </FormItem>
          <FormItem prop="c5" label="商标" style="width:1000px;">
            <Input type="text" v-model="formRecord.c5" placeholder="商标"></Input>
          </FormItem>
          <FormItem prop="c200" label="依据国家标准" style="width:1000px;">
            <Input type="text" v-model="formRecord.c200" placeholder="依据国家标准" readonly></Input>
          </FormItem>
          <FormItem prop="c7" label="能效等级" style="width:1000px;">
            <RadioGroup v-model="formRecord.c7">
              <Radio label="1">1级</Radio>
              <Radio label="2">2级</Radio>
              <Radio label="3">3级</Radio>
              <Radio label="4">4级</Radio>
              <Radio label="5">5级</Radio>
            </RadioGroup>
          </FormItem>
          <FormItem prop="c21" label="产品类型">
            <RadioGroup v-model="formRecord.c21" @on-change="clearRelevantData">
              <Radio label="冷藏冷冻箱">冷藏冷冻箱</Radio>
              <Radio label="葡萄酒储藏柜">葡萄酒储藏柜</Radio>
              <Radio label="卧式冷藏冷冻柜">卧式冷藏冷冻柜</Radio>
              <Radio label="无星级室的冷藏箱">无星级室的冷藏箱</Radio>
              <Radio label="带1星级室的冷藏箱">带1星级室的冷藏箱</Radio>
              <Radio label="带2星级室的冷藏箱">带2星级室的冷藏箱</Radio>
              <Radio label="带3星级室的冷藏箱">带3星级室的冷藏箱</Radio>
              <Radio label="冷冻食品储藏箱">冷冻食品储藏箱</Radio>
              <Radio label="卧式冷冻箱(柜)">卧式冷冻箱(柜)</Radio>
              <Radio label="立式冷冻箱(柜)">立式冷冻箱(柜)</Radio>
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
              <td>标准耗电量 （kW·h/24h）</td>
              <td>
                <FormItem prop="c8">
                  <Input type="text" v-model="formRecord.c8" :disabled="formRecord.c21===''" placeholder="两位小数"></Input>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c9">
                  <Input type="text" v-model="formRecord.c9" :disabled="formRecord.c21===''" :required="formRecord.c21!==''" placeholder="三位小数"></Input>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c10">
                  <Input type="text" v-model="formRecord.c10" :disabled="formRecord.c21===''"></Input>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>标准能效指数（%）</td>
              <td>
                <FormItem prop="c11">
                  <Input type="text" v-model="formRecord.c11" :disabled="formRecord.c21===''" placeholder="一位小数"></Input>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c12">
                  <Input type="text" v-model="formRecord.c12" :disabled="formRecord.c21===''" placeholder="三位小数"></Input>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c13">
                  <Input type="text" v-model="formRecord.c13" :disabled="formRecord.c21===''"></Input>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>综合耗电量 （kW·h/24h）</td>
              <td>
                <FormItem prop="c14">
                  <Input type="text" v-model="formRecord.c14" :disabled="formRecord.c21!=='冷藏冷冻箱'" placeholder="两位小数"></Input>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c15">
                  <Input type="text" v-model="formRecord.c15" :disabled="formRecord.c21!=='冷藏冷冻箱'" placeholder="三位小数"></Input>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c16">
                  <Input type="text" v-model="formRecord.c16" :disabled="formRecord.c21!=='冷藏冷冻箱'"></Input>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>综合能效指数（%）</td>
              <td>
                <FormItem prop="c17">
                  <Input type="text" v-model="formRecord.c17" :disabled="formRecord.c21!=='冷藏冷冻箱'" placeholder="一位小数"></Input>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c18">
                  <Input type="text" v-model="formRecord.c18" :disabled="formRecord.c21!=='冷藏冷冻箱'" placeholder="三位小数"></Input>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c19">
                  <Input type="text" v-model="formRecord.c19" :disabled="formRecord.c21!=='冷藏冷冻箱'"></Input>
                </FormItem>
              </td>
            </tr>
          </table>
          <table id="table2">
            <tr>
              <th>间室名称</th>
              <th>类型</th>
              <th>标称容积值L</th>
              <th>实测容积值L</th>
              <th width="150px;">设计温度℃</th>
              <th>特性温度℃</th>
              <th>隔热层厚度(mm)</th>
              <th>备注</th>
            </tr>
            <tr>
              <td>冷藏室</td>
              <td>
                <RadioGroup v-model="formRecord.c24">
                  <Radio label="有霜" :disabled="lc">有霜</Radio>
                  <Radio label="无霜" :disabled="lc">无霜</Radio>
                </RadioGroup>
              </td>
              <td><Input type="text" v-model="formRecord.c25" :disabled="formRecord.c24!=='有霜' && formRecord.c24!=='无霜'"></Input></td>
              <td>
                <FormItem prop="c82">
                  <Input type="text" v-model="formRecord.c82" :disabled="formRecord.c24!=='有霜' && formRecord.c24!=='无霜'" placeholder="一位小数"></Input>
                </FormItem>
              </td>
              <td>/</td>
              <td>/</td>
              <td>
                <FormItem prop="c62">
                  <Input type="text" v-model="formRecord.c62" :disabled="formRecord.c24!=='有霜' && formRecord.c24!=='无霜'"></Input>
                </FormItem>
              </td>
              <td><Input type="text" v-model="formRecord.c83" :disabled="formRecord.c24!=='有霜' && formRecord.c24!=='无霜'"></Input></td>
            </tr>
            <tr>
              <td>冷冻室</td>
              <td>
                <RadioGroup v-model="formRecord.c26">
                  <Radio label="有霜" :disabled="ld">有霜</Radio>
                  <Radio label="无霜" :disabled="ld">无霜</Radio>
                </RadioGroup>
              </td>
              <td><Input type="text" v-model="formRecord.c27" :disabled="formRecord.c26!=='有霜' && formRecord.c26!=='无霜'"></Input></td>
              <td>
                <FormItem prop="c84">
                  <Input type="text" v-model="formRecord.c84" :disabled="formRecord.c26!=='有霜' && formRecord.c26!=='无霜'" placeholder="一位小数"></Input>
                </FormItem>
              </td>
              <td>/</td>
              <td>/</td>
              <td>
                <FormItem prop="c63">
                  <Input type="text" v-model="formRecord.c63" :disabled="formRecord.c26!=='有霜' && formRecord.c26!=='无霜'"></Input>
                </FormItem>
              </td>
              <td><Input type="text" v-model="formRecord.c85" :disabled="formRecord.c26!=='有霜' && formRecord.c26!=='无霜'"></Input></td>
            </tr>
            <tr>
              <td>其他间室1<br /><Input type="text" v-model="formRecord.c29" :disabled="otherCompartment"></Input></td>
              <td>
                <RadioGroup v-model="formRecord.c28">
                  <Radio label="有霜" :disabled="otherCompartment">有霜</Radio>
                  <Radio label="无霜" :disabled="otherCompartment">无霜</Radio>
                </RadioGroup>
              </td>
              <td><Input type="text" v-model="formRecord.c30" :disabled="formRecord.c28!=='有霜' && formRecord.c28!=='无霜'"></Input></td>
              <td>
                <FormItem prop="c86">
                  <Input type="text" v-model="formRecord.c86" :disabled="formRecord.c28!=='有霜' && formRecord.c28!=='无霜'" placeholder="一位小数"></Input>
                </FormItem>
              </td>
              <td>
                <label style="display:block;margin-bottom:5px;">
                  <span>低：</span>
                  <FormItem prop="c32">
                    <Input type="text" v-model="formRecord.c32" style="width:50px;" :disabled="formRecord.c28!=='有霜' && formRecord.c28!=='无霜'"></Input>
                  </FormItem>
                </label>
                <label>
                  <span>高：</span>
                  <FormItem prop="c120">
                    <Input type="text" v-model="formRecord.c120" style="width:50px;" :disabled="formRecord.c28!=='有霜' && formRecord.c28!=='无霜'"></Input>
                  </FormItem>
                </label>
              </td>
              <td>
                <FormItem prop="c31">
                  <Input type="text" v-model="formRecord.c31" :disabled="formRecord.c28!=='有霜' && formRecord.c28!=='无霜'"></Input>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c64">
                  <Input type="text" v-model="formRecord.c64" :disabled="formRecord.c28!=='有霜' && formRecord.c28!=='无霜'"></Input>
                </FormItem>
              </td>
              <td><Input type="text" v-model="formRecord.c87" :disabled="formRecord.c28!=='有霜' && formRecord.c28!=='无霜'"></Input></td>
            </tr>
            <tr>
              <td>其他间室2<br /><Input type="text" v-model="formRecord.c34" :disabled="otherCompartment"></Input></td>
              <td>
                <RadioGroup v-model="formRecord.c33">
                  <Radio label="有霜" :disabled="otherCompartment">有霜</Radio>
                  <Radio label="无霜" :disabled="otherCompartment">无霜</Radio>
                </RadioGroup>
              </td>
              <td><Input type="text" v-model="formRecord.c35" :disabled="formRecord.c33!=='有霜' && formRecord.c33!=='无霜'"></Input></td>
              <td>
                <FormItem prop="c88">
                  <Input type="text" v-model="formRecord.c88" :disabled="formRecord.c33!=='有霜' && formRecord.c33!=='无霜'" placeholder="一位小数"></Input>
                </FormItem>
              </td>
              <td>
                <label style="display:block;margin-bottom:5px;">
                  <span>低：</span>
                  <FormItem prop="c37">
                    <Input type="text" v-model="formRecord.c37" style="width:50px;" :disabled="formRecord.c33!=='有霜' && formRecord.c33!=='无霜'"></Input>
                  </FormItem>
                </label>
                <label>
                  <span>高：</span>
                  <FormItem prop="c121">
                    <Input type="text" v-model="formRecord.c121" style="width:50px;" :disabled="formRecord.c33!=='有霜' && formRecord.c33!=='无霜'"></Input>
                  </FormItem>
                </label>
              </td>
              <td>
                <FormItem prop="c36">
                  <Input type="text" v-model="formRecord.c36" :disabled="formRecord.c33!=='有霜' && formRecord.c33!=='无霜'"></Input>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c65">
                  <Input type="text" v-model="formRecord.c65" :disabled="formRecord.c33!=='有霜' && formRecord.c33!=='无霜'"></Input>
                </FormItem>
              </td>
              <td><Input type="text" v-model="formRecord.c89" :disabled="formRecord.c33!=='有霜' && formRecord.c33!=='无霜'"></Input></td>
            </tr>
            <tr>
              <td>其他间室3<br /><Input type="text" v-model="formRecord.c39" :disabled="otherCompartment"></Input></td>
              <td>
                <RadioGroup v-model="formRecord.c38">
                  <Radio label="有霜" :disabled="otherCompartment">有霜</Radio>
                  <Radio label="无霜" :disabled="otherCompartment">无霜</Radio>
                </RadioGroup>
              </td>
              <td><Input type="text" v-model="formRecord.c40" :disabled="formRecord.c38!=='有霜' && formRecord.c38!=='无霜'"></Input></td>
              <td>
                <FormItem prop="c90">
                  <Input type="text" v-model="formRecord.c90" :disabled="formRecord.c38!=='有霜' && formRecord.c38!=='无霜'" placeholder="一位小数"></Input>
                </FormItem>
              </td>
              <td>
                <label style="display:block;margin-bottom:5px;">
                  <span>低：</span>
                  <FormItem prop="c42">
                    <Input type="text" v-model="formRecord.c42" style="width:50px;" :disabled="formRecord.c38!=='有霜' && formRecord.c38!=='无霜'"></Input>
                  </FormItem>
                </label>
                <label>
                  <span>高：</span>
                  <FormItem prop="c122">
                    <Input type="text" v-model="formRecord.c122" style="width:50px;" :disabled="formRecord.c38!=='有霜' && formRecord.c38!=='无霜'"></Input>
                  </FormItem>
                </label>
              </td>
              <td>
                <FormItem prop="c41">
                  <Input type="text" v-model="formRecord.c41" :disabled="formRecord.c38!=='有霜' && formRecord.c38!=='无霜'"></Input>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c66">
                  <Input type="text" v-model="formRecord.c66" :disabled="formRecord.c38!=='有霜' && formRecord.c38!=='无霜'"></Input>
                </FormItem>
              </td>
              <td><Input type="text" v-model="formRecord.c91" :disabled="formRecord.c38!=='有霜' && formRecord.c38!=='无霜'"></Input></td>
            </tr>
            <tr>
              <td>其他间室4<br /><Input type="text" v-model="formRecord.c124" :disabled="otherCompartment"></Input></td>
              <td>
                <RadioGroup v-model="formRecord.c125">
                  <Radio label="有霜" :disabled="otherCompartment">有霜</Radio>
                  <Radio label="无霜" :disabled="otherCompartment">无霜</Radio>
                </RadioGroup>
              </td>
              <td><Input type="text" v-model="formRecord.c126" :disabled="formRecord.c125!=='有霜' && formRecord.c125!=='无霜'"></Input></td>
              <td>
                <FormItem prop="c127">
                  <Input type="text" v-model="formRecord.c127" :disabled="formRecord.c125!=='有霜' && formRecord.c125!=='无霜'" placeholder="一位小数"></Input>
                </FormItem>
              </td>
              <td>
                <label style="display:block;margin-bottom:5px;">
                  <span>低：</span>
                  <FormItem prop="c128">
                    <Input type="text" v-model="formRecord.c128" style="width:50px;" :disabled="formRecord.c125!=='有霜' && formRecord.c125!=='无霜'"></Input>
                  </FormItem>
                </label>
                <label>
                  <span>高：</span>
                  <FormItem prop="c129">
                    <Input type="text" v-model="formRecord.c129" style="width:50px;" :disabled="formRecord.c125!=='有霜' && formRecord.c125!=='无霜'"></Input>
                  </FormItem>
                </label>
              </td>
              <td>
                <FormItem prop="c130">
                  <Input type="text" v-model="formRecord.c130" :disabled="formRecord.c125!=='有霜' && formRecord.c125!=='无霜'"></Input>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c131">
                  <Input type="text" v-model="formRecord.c131" :disabled="formRecord.c125!=='有霜' && formRecord.c125!=='无霜'"></Input>
                </FormItem>
              </td>
              <td><Input type="text" v-model="formRecord.c132" :disabled="formRecord.c125!=='有霜' && formRecord.c125!=='无霜'"></Input></td>
            </tr>
          </table>
          <table>
            <tr>
              <td>总容积</td>
              <td>
                <Button type="info" @click="count43">计算标称值</Button>
                <Input type="text" v-model="formRecord.c43" style="width:150px;" readonly></Input>
                <Button type="info" @click="count123">计算实测值</Button>
                <Input type="text" v-model="formRecord.c123" style="width:150px;" readonly></Input>
              </td>
            </tr>
          </table>
        </Card>
      </div>
      <div class="part part4">
        <Card :bordered="false">
          <h2>四、初始使用日期</h2>
          <!-- <Form ref="formRecord" :model="formRecord" label-position="left" :label-width="180" :rules="ruleRecord"> -->
            <FormItem prop="c20" label="备案标识开始使用日期" style="width:1000px;">
              <DatePicker type="date" style="width: 200px" v-model="formRecord.c20"></DatePicker>
            </FormItem>
        </Card>
      </div>
      <div class="part part5">
        <Card :bordered="false">
          <h2>五、样品描述</h2>
          <table id="table3">
            <tr>
              <td>电源性质</td>
              <td width="40%">
                <FormItem prop="c22">
                  <RadioGroup v-model="formRecord.c22">
                    <Radio label="三相">三相</Radio>
                    <Radio label="单相">单相</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>气候类型</td>
              <td>
                <CheckboxGroup v-model="formRecord.c23">
                  <Checkbox label="SN04">SN</Checkbox>
                  <Checkbox label="N03">N</Checkbox>
                  <Checkbox label="ST02">ST</Checkbox>
                  <Checkbox label="T01">T</Checkbox>
                </CheckboxGroup>
              </td>
            </tr>
            <tr>
              <td>含有15 L及以上容积、具有冰温区功能的变温室</td>
              <td>
                <FormItem prop="c44">
                  <RadioGroup v-model="formRecord.c44">
                    <Radio label="有">有</Radio>
                    <Radio label="无">无</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>含有15 L及以上容积、具有冰温区功能同时具备冷藏功能和三星级或四星级冷冻功能的变温室</td>
              <td>
                <FormItem prop="c45">
                  <RadioGroup v-model="formRecord.c45">
                    <Radio label="有">有</Radio>
                    <Radio label="无">无</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>间室容积大于400 L并带有穿透式自动制冰功能</td>
              <td>
                <FormItem prop="c46">
                  <RadioGroup v-model="formRecord.c46">
                    <Radio label="是">是</Radio>
                    <Radio label="否">否</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>当器具类型为1、2、3、4类型，所有门体均采用透明门体，且从内部往外投影的透明区域总投影面积占所有门体总投影面积的50%以上</td>
              <td>
                <FormItem prop="c47">
                  <RadioGroup v-model="formRecord.c47">
                    <Radio label="是">是</Radio>
                    <Radio label="否">否</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>当器具类型为5、6、7、8、9类型，至少有一个门体采用透明门体，且从内部往外投影的透明区域总投影面积大于所有门体总投影面积的25%</td>
              <td>
                <FormItem prop="c48">
                  <RadioGroup v-model="formRecord.c48">
                    <Radio label="是">是</Radio>
                    <Radio label="否">否</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>嵌入式制冷器具</td>
              <td>
                <FormItem prop="c49">
                  <RadioGroup v-model="formRecord.c49">
                    <Radio label="是">是</Radio>
                    <Radio label="否">否</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>具有环境可控型防凝露加热器</td>
              <td>
                <FormItem prop="c50">
                  <RadioGroup v-model="formRecord.c50">
                    <Radio label="是">是</Radio>
                    <Radio label="否">否</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>冷凝器形式</td>
              <td>
                <FormItem prop="c51">
                  <CheckboxGroup v-model="formRecord.c51" style="display:inline-block;">
                    <Checkbox label="外挂式">外挂式</Checkbox>
                    <Checkbox label="平背式">平背式</Checkbox>
                    <Checkbox label="底冷式">底冷式</Checkbox>
                    <Checkbox label="其他">其他</Checkbox>
                  </CheckboxGroup>
                </FormItem>
                <FormItem prop="c52">
                  <Input type="text" v-model="formRecord.c52" style="width:80px;" :disabled="formRecord.c51.join('').indexOf('其他') === -1"></Input>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>温控器形式</td>
              <td>
                <FormItem prop="c53">
                  <RadioGroup v-model="formRecord.c53">
                    <Radio label="机械">机械</Radio>
                    <Radio label="电子">电子</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>冰箱门数</td>
              <td>
                <FormItem prop="c54">
                  <RadioGroup v-model="formRecord.c54" style="display:inline-block;">
                    <Radio label="单门">单门</Radio>
                    <Radio label="双门">双门</Radio>
                    <Radio label="三门">三门</Radio>
                    <Radio label="多门">多门</Radio>
                  </RadioGroup>
                </FormItem>
                <FormItem prop="c55">
                  <Input type="text" v-model="formRecord.c55" style="width:80px;" :disabled="formRecord.c54 !== '其他'"></Input>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>温控器安装位置</td>
              <td>
                <FormItem prop="c56">
                  <CheckboxGroup v-model="formRecord.c56" style="display:inline-block;">
                    <Checkbox label="冷藏室">冷藏室</Checkbox>
                    <Checkbox label="冷冻室">冷冻室</Checkbox>
                    <Checkbox label="其他">其他</Checkbox>
                  </CheckboxGroup>
                </FormItem>
                <FormItem prop="c57">
                  <Input type="text" v-model="formRecord.c57" style="width:80px;" :disabled="formRecord.c56.join('').indexOf('其他') === -1"></Input>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>照明灯安装位置</td>
              <td>
                <FormItem prop="c58">
                  <CheckboxGroup v-model="formRecord.c58" style="display:inline-block;">
                    <Checkbox label="冷藏室">冷藏室</Checkbox>
                    <Checkbox label="冷冻室">冷冻室</Checkbox>
                    <Checkbox label="其他">其他</Checkbox>
                  </CheckboxGroup>
                </FormItem>
                <FormItem prop="c59">
                  <Input type="text" v-model="formRecord.c59" style="width:80px;" :disabled="formRecord.c58.join('').indexOf('其他') === -1"></Input>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>照明灯额定输入功率（W）</td>
              <td>
                <FormItem prop="c60">
                  <Input type="text" v-model="formRecord.c60"></Input>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>输入总功率（W）</td>
              <td>
                <FormItem prop="c61">
                  <Input type="text" v-model="formRecord.c61"></Input>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>冷冻能力（kg/12h）</td>
              <td>
                <FormItem prop="c67">
                  <Input type="text" v-model="formRecord.c67"></Input>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>外形尺寸(长×宽×高)（mm×mm×mm）</td>
              <td>
                <span style="display: inline-block;height: 32px;line-height: 32px;">长</span>
                <FormItem prop="c68">
                  <Input type="text" v-model="formRecord.c68" style="width:80px;"></Input>
                </FormItem>
                <span style="display: inline-block;height: 32px;line-height: 32px;">宽</span>
                <FormItem prop="c69">
                  <Input type="text" v-model="formRecord.c69" style="width:80px;"></Input>
                </FormItem>
                <span style="display: inline-block;height: 32px;line-height: 32px;">高</span>
                <FormItem prop="c70">
                  <Input type="text" v-model="formRecord.c70" style="width:80px;"></Input>
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
            <tr>
              <th width="50">序号</th>
              <th width="100">部件名称</th>
              <th>型号规格</th>
              <th colspan="3">技术参数</th>
              <th>生产者（全称）</th>
            </tr>
            <tr>
              <td rowspan="3" class="tc">1</td>
              <td rowspan="3">压缩机</td>
              <td class="tc">具体型号</td>
              <td class="tc">制冷量（W）</td>
              <td class="tc">输入功率（W）</td>
              <td class="tc">COP值</td>
              <td class="tc">/</td>
            </tr>
            <tr>
              <td>
                <FormItem prop="c71">
                  <Input type="text" v-model="formRecord.c71"></Input>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c72">
                  <Input type="text" v-model="formRecord.c72"></Input>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c73">
                  <Input type="text" v-model="formRecord.c73"></Input>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c74">
                  <Input type="text" v-model="formRecord.c74"></Input>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c75">
                  <Input type="text" v-model="formRecord.c75"></Input>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td><Input type="text" v-model="formRecord.c94"></Input></td>
              <td><Input type="text" v-model="formRecord.c95"></Input></td>
              <td><Input type="text" v-model="formRecord.c96"></Input></td>
              <td><Input type="text" v-model="formRecord.c97"></Input></td>
              <td><Input type="text" v-model="formRecord.c98"></Input></td>
            </tr>
            <tr>
              <td class="tc">2</td>
              <td>制冷剂</td>
              <td>
                <FormItem prop="c76">
                  <Input type="text" v-model="formRecord.c76"></Input>
                </FormItem>
              </td>
              <td colspan="3">
                <div class="margin-bottom:20px;">
                  <span>主要成分：</span>
                  <FormItem prop="c77">
                    <Input type="text" v-model="formRecord.c77" style="width:300px;"></Input>
                  </FormItem>
                </div>
                <div>
                  <span>重量：</span>
                  <Input type="text" v-model="formRecord.c92" style="width:300px;"></Input>
                </div>
              </td>
              <td>
                <FormItem prop="c78">
                  <Input type="text" v-model="formRecord.c78"></Input>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="tc">3</td>
              <td>制冷剂</td>
              <td><Input type="text" v-model="formRecord.c104"></Input></td>
              <td colspan="3">
                <div><span>主要成分：</span><Input type="text" v-model="formRecord.c105" style="width:300px;"></Input></div>
                <div><span>重量：</span><Input type="text" v-model="formRecord.c106" style="width:300px;"></Input></div>
              </td>
              <td><Input type="text" v-model="formRecord.c107"></Input></td>
            </tr>
            <tr>
              <td class="tc">4</td>
              <td>发泡材料</td>
              <td>
                <FormItem prop="c79">
                  <Input type="text" v-model="formRecord.c79"></Input>
                </FormItem>
              </td>
              <td colspan="3">
                <div class="margin-bottom:20px;">
                  <span>主要成分：</span>
                  <FormItem prop="c80">
                    <Input type="text" v-model="formRecord.c80" style="width:300px;"></Input>
                  </FormItem>
                </div>
                <div><span>比例：</span><Input type="text" v-model="formRecord.c93" style="width:300px;"></Input></div>
              </td>
              <td>
                <FormItem prop="c81">
                  <Input type="text" v-model="formRecord.c81"></Input>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="tc">5</td>
              <td>发泡材料</td>
              <td><Input type="text" v-model="formRecord.c112"></Input></td>
              <td colspan="3">
                <div><span>主要成分：</span><Input type="text" v-model="formRecord.c113" style="width:300px;"></Input></div>
                <div><span>比例：</span><Input type="text" v-model="formRecord.c114" style="width:300px;"></Input></div>
              </td>
              <td><Input type="text" v-model="formRecord.c115"></Input></td>
            </tr>
            <tr>
              <td colspan="7" class="tc">备注：如上述零部件属多个生产者，均应按上述要求逐一填写。</td>
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
              <td><Input type="text" v-model="formRecord.c202"></Input></td>
            </tr>
          </table>
        </Card>
      </div>
      <div class="part part8">
        <Card :bordered="false">
          <h2>八、附件部分</h2>
          <table>
            <tr>
              <td><span class="red">*</span>产品正面图片</td>
              <td>(JPG/PNG)</td>
              <td>
                <Upload
                  :show-upload-list=false
                  :format="['jpg','jpeg','png']"
                  :before-upload="fileHandleBeforeUpload24"
                  :data="uploadParam.fileData24"
                  :on-success="getFile24"
                  style="display:inline-block;"
                  :action="uploadUrl">
                  <Button icon="ios-cloud-upload-outline" type="primary">上传</Button>
                  <Icon type="ios-checkmark" v-show="checkmark24" />
                </Upload>
              </td>
              <td colspan="3">标识样本</td>
            </tr>
            <tr>
              <td>OEM声明</td>
              <td>(JPG/PNG)</td>
              <td>
                <Upload
                  :show-upload-list=false
                  :format="['jpg','jpeg','png']"
                  :before-upload="fileHandleBeforeUpload26"
                  :data="uploadParam.fileData26"
                  :on-success="getFile26"
                  style="display:inline-block;"
                  :action="uploadUrl">
                  <Button icon="ios-cloud-upload-outline" type="primary">上传</Button>
                  <Icon type="ios-checkmark" v-show="checkmark26" />
                </Upload>
              </td>
              <td>关系证明</td>
              <td>（PDF）</td>
              <td>
                <Upload
                  :show-upload-list=false
                  :format="['pdf']"
                  :before-upload="fileHandleBeforeUpload27"
                  :data="uploadParam.fileData27"
                  :on-success="getFile27"
                  style="display:inline-block;"
                  :action="uploadUrl">
                  <Button icon="ios-cloud-upload-outline" type="primary">上传</Button>
                  <Icon type="ios-checkmark" v-show="checkmark27" />
                </Upload>
              </td>
            </tr>
            <tr>
              <td>品牌使用授权书</td>
              <td>(PDF)</td>
              <td>
                <Upload
                  :show-upload-list=false
                  :format="['pdf']"
                  :before-upload="fileHandleBeforeUpload28"
                  :data="uploadParam.fileData28"
                  :on-success="getFile28"
                  style="display:inline-block;"
                  :action="uploadUrl">
                  <Button icon="ios-cloud-upload-outline" type="primary">上传</Button>
                  <Icon type="ios-checkmark" v-show="checkmark28" />
                </Upload>
              </td>
              <td>委托代理文件</td>
              <td>（PDF）</td>
              <td>
                <Upload
                  :show-upload-list=false
                  :format="['pdf']"
                  :before-upload="fileHandleBeforeUpload29"
                  :data="uploadParam.fileData29"
                  :on-success="getFile29"
                  style="display:inline-block;"
                  :action="uploadUrl">
                  <Button icon="ios-cloud-upload-outline" type="primary">上传</Button>
                  <Icon type="ios-checkmark" v-show="checkmark29" />
                </Upload>
              </td>
            </tr>
            <tr>
              <td>进口商企业信息表</td>
              <td>(PDF)</td>
              <td>
                <Upload
                  :show-upload-list=false
                  :format="['pdf']"
                  :before-upload="fileHandleBeforeUpload30"
                  :data="uploadParam.fileData30"
                  :on-success="getFile30"
                  style="display:inline-block;"
                  :action="uploadUrl">
                  <Button icon="ios-cloud-upload-outline" type="primary">上传</Button>
                  <Icon type="ios-checkmark" v-show="checkmark30" />
                </Upload>
              </td>
              <td>进口商营业执照或登记注册证明复印件</td>
              <td>（PDF）</td>
              <td>
                <Upload
                  :show-upload-list=false
                  :format="['pdf']"
                  :before-upload="fileHandleBeforeUpload31"
                  :data="uploadParam.fileData31"
                  :on-success="getFile31"
                  style="display:inline-block;"
                  :action="uploadUrl">
                  <Button icon="ios-cloud-upload-outline" type="primary">上传</Button>
                  <Icon type="ios-checkmark" v-show="checkmark31" />
                </Upload>
              </td>
            </tr>
            <tr>
              <td>进口商与境外生产者订立的相关合同副本</td>
              <td>(PDF)</td>
              <td>
                <Upload
                  :show-upload-list=false
                  :format="['pdf']"
                  :before-upload="fileHandleBeforeUpload32"
                  :data="uploadParam.fileData32"
                  :on-success="getFile32"
                  style="display:inline-block;"
                  :action="uploadUrl">
                  <Button icon="ios-cloud-upload-outline" type="primary">上传</Button>
                  <Icon type="ios-checkmark" v-show="checkmark32" />
                </Upload>
              </td>
              <td><span class="red">*</span>铭牌照片</td>
              <td>（PDF/JPG/PNG）</td>
              <td>
                <Upload
                  :show-upload-list=false
                  :format="['jpg','jpeg','png']"
                  :before-upload="fileHandleBeforeUpload76"
                  :data="uploadParam.fileData76"
                  :on-success="getFile76"
                  style="display:inline-block;"
                  :action="uploadUrl">
                  <Button icon="ios-cloud-upload-outline" type="primary">上传</Button>
                  <Icon type="ios-checkmark" v-show="checkmark76" />
                </Upload>
              </td>
            </tr>
          </table>
          <p class="red">注：保存到草稿时，不保存附件！<br />所有附件上传文件大小需要控制在2M以内。</p>
        </Card>
      </div>
      <div class="tc">
        <Button type="primary">上一步</Button>
        <Button type="primary" @click="saveRecord" :disabled="saveDisabled">保存到草稿</Button>
        <Button type="primary" @click="submitRecord" :disabled="submitDisabled">提交备案审核申请</Button>
      </div>
    </Form>
  </div>
</template>
<script>
import axios from 'axios'
export default {
  data () {
    return {
      saveDisabled: false,
      submitDisabled: false,
      uploadUrl: '',
      uploadParam: {
        fileData24: {},
        uploadFileList24: [],
        fileData26: {},
        uploadFileList26: [],
        fileData27: {},
        uploadFileList27: [],
        fileData28: {},
        uploadFileList28: [],
        fileData29: {},
        uploadFileList29: [],
        fileData30: {},
        uploadFileList30: [],
        fileData31: {},
        uploadFileList31: [],
        fileData32: {},
        uploadFileList32: [],
        fileData76: {},
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
        c20: new Date(),
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
        c51: [],
        c52: '',
        c53: '',
        c54: '',
        c55: '',
        c56: [],
        c57: '',
        c58: [],
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
        c104: '',
        c105: '',
        c106: '',
        c107: '',
        c112: '',
        c113: '',
        c114: '',
        c115: '',
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
        c200: this.$store.state.app.gb,
        c202: '',
        ec_model_no: 47,
        attach_list: ''
      },
      laboratory: '请选择实验室名称',
      laboratoryList: [
        {
          value: '',
          label: '请选择实验室名称'
        },
        {
          value: '111',
          label: '浙江华美电器制造有限公司'
        },
        {
          value: '124',
          label: '宁波韩电电器有限公司'
        },
        {
          value: '1066',
          label: '合肥通用机电产品检测院有限公司（国家压缩机制冷设备质量监督检验中心）'
        },
        {
          value: '6387',
          label: '威凯检测技术有限公司'
        },
        {
          value: '6389',
          label: '六安索伊电器制造有限公司'
        },
        {
          value: '6390',
          label: '中家院（北京）检测认证有限公司（中国家用电器检测所）'
        },
        {
          value: '6394',
          label: '杭州华日家电有限公司'
        },
        {
          value: '6395',
          label: '博西华家用电器有限公司'
        },
        {
          value: '6398',
          label: '河南新飞电器有限公司'
        },
        {
          value: '6401',
          label: '中国赛宝实验室'
        },
        {
          value: '6405',
          label: '青岛海尔股份有限公司'
        },
        {
          value: '6412',
          label: '合肥华凌股份有限公司'
        },
        {
          value: '6427',
          label: '海信容声（广东）冰箱有限公司'
        },
        {
          value: '6430',
          label: '青岛中海博睿检测技术服务有限公司'
        },
        {
          value: '6432',
          label: '浙江省检验检疫科学技术研究院（浙江立德产品技术有限公司）'
        },
        {
          value: '6437',
          label: '惠而浦（中国）股份有限公司'
        },
        {
          value: '6438',
          label: '长虹美菱股份有限公司中心实验室'
        },
        {
          value: '6442',
          label: '合肥晶弘电器有限公司'
        },
        {
          value: '6447',
          label: '澳柯玛股份有限公司'
        },
        {
          value: '6451',
          label: '上海出入境检验检疫局机电产品检测技术中心'
        },
        {
          value: '6453',
          label: '青岛海容商用冷链股份有限公司'
        },
        {
          value: '6464',
          label: '浙江星星冷链集成股份有限公司'
        },
        {
          value: '6473',
          label: '东芝家用电器制造（南海）有限公司'
        },
        {
          value: '6480',
          label: '无锡松下冷机有限公司'
        },
        {
          value: '6523',
          label: '重庆市电子电器商品质量监督检验站/中国商业联合会产（商）品质量监督检测中心（重庆）'
        },
        {
          value: '6525',
          label: '江苏双鹿电器有限公司'
        },
        {
          value: '6546',
          label: 'TCL家用电器（合肥）有限公司'
        },
        {
          value: '6548',
          label: '合肥雪祺电气有限公司'
        },
        {
          value: '6551',
          label: 'Daewoo Electronics Co.， Ltd.'
        },
        {
          value: '6554',
          label: '江苏白雪电器股份有限公司'
        },
        {
          value: '6556',
          label: '安徽尊贵电器集团有限公司'
        },
        {
          value: '6564',
          label: '苏州三星电子有限公司'
        },
        {
          value: '6566',
          label: '安徽中认倍佳科技有限公司'
        },
        {
          value: '6583',
          label: '广州万宝集团冰箱有限公司'
        },
        {
          value: '6590',
          label: '南京创维家用电器有限公司'
        },
        {
          value: '6593',
          label: '安徽康佳同创电器有限公司'
        },
        {
          value: '6596',
          label: '广东奥马冰箱有限公司'
        },
        {
          value: '6607',
          label: '青岛市产品质量监督检验研究院(国家电子电器安全质量监督检验中心)'
        },
        {
          value: '6643',
          label: '中国质量认证中心华南实验室'
        },
        {
          value: '6653',
          label: '杭州金松优诺电器有限公司'
        },
        {
          value: '6659',
          label: '广东产品质量监督检验研究院(国家电器产品安全质量监督检验中心)'
        },
        {
          value: '6661',
          label: '中山格兰仕日用电器有限公司'
        },
        {
          value: '6665',
          label: '广东惠晟检验科技有限公司'
        },
        {
          value: '6726',
          label: '浙江方正家用电器质量检测有限公司(国家轻工业家用电器质量监督检测杭州站)'
        },
        {
          value: '6764',
          label: '山东宏泰电器有限公司'
        },
        {
          value: '6824',
          label: 'FISHER &amp; PAYKEL APPLIANCES LIMITED'
        },
        {
          value: '6828',
          label: '宁波华彩电器有限公司'
        },
        {
          value: '6843',
          label: '浙江方圆检测集团股份有限公司'
        },
        {
          value: '6850',
          label: '上海市质量监督检验技术研究院(国家电器能效与安全质量监督检验中心)'
        },
        {
          value: '6864',
          label: '宁波奇红电器有限公司'
        },
        {
          value: '6884',
          label: '宁波海浪电器有限公司'
        },
        {
          value: '6963',
          label: '安徽省万爱电器科技有限公司'
        },
        {
          value: '6987',
          label: '浙江港通电器有限公司'
        },
        {
          value: '7143',
          label: '佛山市津晶电器有限公司'
        },
        {
          value: '7183',
          label: '河南香雪海家电科技有限公司'
        },
        {
          value: '7207',
          label: '山东省产品质量检验研究院（国家节能产品质量监督检验中心）'
        },
        {
          value: '7246',
          label: '青岛新星家用电器有限公司'
        },
        {
          value: '7252',
          label: '合肥市产品质量监督检验所（国家家用电器产品质量监督检验中心（安徽））'
        },
        {
          value: '7326',
          label: '宁波日樱电器有限公司'
        },
        {
          value: '7424',
          label: '国家市场监督管理总局能效水效工程技术研究中心'
        },
        {
          value: '7604',
          label: '宁波出入检验检疫局检验检疫技术中心/宁波中盛产品检测有限公司'
        },
        {
          value: '7634',
          label: '广东惠晟检验科技有限公司中山检测中心'
        },
        {
          value: '7705',
          label: '合肥美科制冷技术有限公司'
        },
        {
          value: '7827',
          label: '中家院(慈溪)电器检测服务有限公司'
        },
        {
          value: '8023',
          label: '莱茵技术-商检（青岛）有限公司'
        },
        {
          value: '8387',
          label: '滁州韩上电器有限公司'
        }
      ]
    }
  },
  mounted () {
    this.removeStyle()
  },
  methods: {
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
          fileObj.ec_attach_path = res.data.host + _this.dir + file.name
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
          fileObj.ec_attach_path = res.data.host + _this.dir + file.name
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
          fileObj.ec_attach_path = res.data.host + _this.dir + file.name
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
          fileObj.ec_attach_path = res.data.host + _this.dir + file.name
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
          fileObj.ec_attach_path = res.data.host + _this.dir + file.name
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
          fileObj.ec_attach_path = res.data.host + _this.dir + file.name
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
          fileObj.ec_attach_path = res.data.host + _this.dir + file.name
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
          fileObj.ec_attach_path = res.data.host + _this.dir + file.name
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
          fileObj.ec_attach_path = res.data.host + _this.dir + file.name
          _this.filesArr.push(fileObj)
          resolve()
        })
      })
    },
    removeStyle () {
      let eArr1 = document.getElementById('table1').getElementsByClassName('ivu-form-item-content')
      let eArr2 = document.getElementById('table2').getElementsByClassName('ivu-form-item-content')
      let eArr3 = document.getElementById('table3').getElementsByClassName('ivu-form-item-content')
      let eArr4 = document.getElementById('table4').getElementsByClassName('ivu-form-item-content')
      for (let i=0;i<eArr1.length;i++) {
        eArr1[i].removeAttribute("style")
      }
      for (let i=0;i<eArr2.length;i++) {
        eArr2[i].removeAttribute("style")
      }
      for (let i=0;i<eArr3.length;i++) {
        eArr3[i].removeAttribute("style")
      }
      for (let i=0;i<eArr4.length;i++) {
        eArr4[i].removeAttribute("style")
      }
    },
    fillDraftData (data) {
      let that = this
      for(let i in data) {
        if (i === 'title' || i === 'result_code') {

        } else if (i === 'marking') {
          that.$store.commit('setPtId', data[i].ptid)
          that.$store.commit('setPltId', data[i].pltId)
          that.$store.commit('setRid', data[i].ec_labreport_id)
          that.$store.commit('setBarcode', data[i].ec_labreport_no)
          that.$store.commit('setLabName', data[i].ec_labname)
          that.formRecord.id = data[i].id
        } else {
          if (i === 'c23' || i === 'c51' || i === 'c56' || i === 'c58') {
            that.formRecord[i] = []
            data[i].split(',').forEach((v) => {
              that.formRecord[i].push(v)
            })
          } else {
            that.formRecord[i] = data[i]
          }
        }
      }
    },
    fillDefaultData () {
      let that = this
      this.$store.state.app.defaultData.forEach((e) => {
        if (e.recId === 'c23' || e.recId === 'c51' || e.recId === 'c56' || e.recId === 'c58') {
          that.formRecord[e.recId] = []
          if (e.labValue === '/'  || e.labValue == null) {
            return
          }
          e.labValue.split(',').forEach((v) => {
            that.formRecord[e.recId].push(v)
          })
        } else if (e.recId === 'c24' || e.recId === 'c26' || e.recId === 'c28' || e.recId === 'c33' || e.recId === 'c38' || e.recId === 'c125') {
          if (e.labValue !== '有霜' || e.labValue !== '无霜') {
            that.formRecord[e.recId] = ''
          }
        } else {
          if (e.labValue === '/'  || e.labValue == null) {
            that.formRecord[e.recId] = ''
          } else {
            if (e.recId === 'c7') {
              if (parseInt(e.labValue) !== 1 && parseInt(e.labValue) !== 2 && parseInt(e.labValue) !== 3 && parseInt(e.labValue) !== 4 && parseInt(e.labValue) !== 5) {
                that.formRecord[e.recId] = '1'
              } else {
                that.formRecord[e.recId] = parseInt(e.labValue).toString()
              }
            } else if (e.recId === 'c20' && isNaN(e.labValue)) {
              that.formRecord[e.recId] = new Date()
            } else {
              that.formRecord[e.recId] = e.labValue
            }
          }
        }
      })
    },
    checkFun () {
      let flag = true
      let count_b = 0
      let count_s = 0
      let vv = Math.pow(10,1)
      if (this.formRecord.c24 === '有霜' || this.formRecord.c24 === '无霜') {
        if (!isNaN(this.formRecord.c25)) {
          count_b += Number(this.formRecord.c25)
        }
        if (!isNaN(this.formRecord.c82)) {
          count_s += Number(this.formRecord.c82)
        }
      }
      if (this.formRecord.c26 === '有霜' || this.formRecord.c26 === '无霜') {
        if (!isNaN(this.formRecord.c27)) {
          count_b += Number(this.formRecord.c27)
        }
        if (!isNaN(this.formRecord.c84)) {
          count_s += Number(this.formRecord.c84)
        }
      }
      if (this.formRecord.c28 === '有霜' || this.formRecord.c28 === '无霜') {
        if (!isNaN(this.formRecord.c30)) {
          count_b += Number(this.formRecord.c30)
        }
        if (!isNaN(this.formRecord.c86)) {
          count_s += Number(this.formRecord.c86)
        }
      }
      if (this.formRecord.c33 === '有霜' || this.formRecord.c33 === '无霜') {
        if (!isNaN(this.formRecord.c35)) {
          count_b += Number(this.formRecord.c35)
        }
        if (!isNaN(this.formRecord.c88)) {
          count_s += Number(this.formRecord.c88)
        }
      }
      if (this.formRecord.c28 === '有霜' || this.formRecord.c28 === '无霜') {
        if (!isNaN(this.formRecord.c40)) {
          count_b += Number(this.formRecord.c40)
        }
        if (!isNaN(this.formRecord.c90)) {
          count_s += Number(this.formRecord.c90)
        }
      }
      if (this.formRecord.c125 === '有霜' || this.formRecord.c125 === '无霜') {
        if (!isNaN(this.formRecord.c126)) {
          count_b += Number(this.formRecord.c126)
        }
        if (!isNaN(this.formRecord.c127)) {
          count_s += Number(this.formRecord.c127)
        }
      }
      count_b = Math.round(count_b*vv)/vv
      this.formRecord.c43 = count_b
      count_s = Math.round(count_s * vv) / vv;
      this.formRecord.c123 = count_s
      //能效等级
      let nxdjch = this.formRecord.c7
      //类型
      let lx = this.formRecord.c21
      //标准能效指数额定值
      let c11 = parseFloat(this.formRecord.c11)
      //标准能效指数实测值
      let c12 = parseFloat(this.formRecord.c12)
      //综合能效指数额定值
      let c17 = parseFloat(this.formRecord.c17)
      //综合能效指数实测值
      let c18 = parseFloat(this.formRecord.c18)
      //总容积额定值
      let c43 = this.formRecord.c43
      //总容积实测值
      let c123 = this.formRecord.c123

      //标准耗电量额定值
      let c8 = parseFloat(this.formRecord.c8)
      //标准耗电量实测值
      let c9 = parseFloat(this.formRecord.c9)
      if (c9 > c8 * 1.15) {
          this.$Message.warning("标准耗电量实测值不应大于其额定值的 115%")
          flag = false
          return flag
      }
      if (c12 > c11 * 1.05) {
          this.$Message.warning("标准能效指数实测值不大于额定值的105%")
          flag = false
          return flag
      }
      if (c18 > c17 * 1.05) {
          this.$Message.warning("综合能效指数实测值不大于额定值的105%");
          flag = false
          return flag
      }
      if (c123 == "" || c43 == "") {
          this.$Message.warning("总容积额定计算值或者实测计算值不能为空");
          flag = false
          return flag
      }
      //额定能效指数（C76）≥实测能效指数（C77）
      if (count_b > count_s) {
          let dc = count_b - count_s
          let c = 0
          if (count_b * 0.03 < 1) {
              c = 1
          } else {
              c = count_b * 0.03;
          }
          if (dc > c) {
              this.$Message.warning("当总容积的实测值小于额定值时，实测值与额定值的差值不应大于额定值的3%或1L（取较大值）");
              flag = false
              return flag
          }
      }

      // 能效等级校验
      let nxdj = "";
      // 类型 let lx = $('input[name="c21"]:checked').val();
      if (lx != "") {
          if (lx == "冷藏冷冻箱") {
              //综合耗电量额定值
              let c14 = parseFloat(this.formRecord.c14)
              //综合耗电量实测值
              let c15 = parseFloat(this.formRecord.c15)
              if (c15 > c14 * 1.15) {
                  this.$Message.warning("综合耗电量值实测不应大于其额定值的 115%");
                  flag = false
                  return flag
              }
              let nxdj1 = "";
              let nxdj2 = "";
              //标准能效指数
              if (c11 <= 25) {
                  nxdj1 = "1";
              } else if (c11 > 25 && c11 <= 35) {
                  nxdj1 = "2";
              } else if (c11 > 35 && c11 <= 50) {
                  nxdj1 = "3";
              } else if (c11 > 50 && c11 <= 60) {
                  nxdj1 = "4";
              } else if (c11 > 60 && c11 <= 70) {
                  nxdj1 = "5";
              } else {
                  nxdj1 = "";
              }
              //综合能效指数
              if (c17 <= 50) {
                  nxdj2 = "1";
              } else if (c17 > 50 && c17 <= 60) {
                  nxdj2 = "2";
              } else if (c17 > 60 && c17 <= 70) {
                  nxdj2 = "3";
              } else if (c17 > 70 && c17 <= 80) {
                  nxdj2 = "4";
              } else if (c17 > 80 && c17 <= 90) {
                  nxdj2 = "5";
              } else {
                  nxdj2 = "";
              }

              //0427
              if (nxdj1 == "" || nxdj2 == "") {
                  nxdj = ""
              } else if (nxdj1 > nxdj2) {
                  nxdj = nxdj1
              } else {
                  nxdj = nxdj2
              }
              //0427
          } else if (lx == "葡萄酒储藏柜") {
              if (c11 <= 55) {
                  nxdj = "1"
              } else if (c11 > 55 && c11 <= 70) {
                  nxdj = "2"
              } else if (c11 > 70 && c11 <= 80) {
                  nxdj = "3"
              } else if (c11 > 80 && c11 <= 90) {
                  nxdj = "4"
              } else if (c11 > 90 && c11 <= 100) {
                  nxdj = "5"
              } else {
                  nxdj = ""
              }
          } else if (lx == "卧式冷藏冷冻柜") {
              if (c11 <= 35) {
                  nxdj = "1"
              } else if (c11 > 35 && c11 <= 45) {
                  nxdj = "2"
              } else if (c11 > 45 && c11 <= 55) {
                  nxdj = "3"
              } else if (c11 > 55 && c11 <= 65) {
                  nxdj = "4"
              } else if (c11 > 65 && c11 <= 75) {
                  nxdj = "5"
              } else {
                  nxdj = ""
              }
          } else {
              if (c11 <= 45) {
                  nxdj = "1"
              } else if (c11 > 45 && c11 <= 55) {
                  nxdj = "2"
              } else if (c11 > 55 && c11 <= 65) {
                  nxdj = "3"
              } else if (c11 > 65 && c11 <= 75) {
                  nxdj = "4"
              } else if (c11 > 75 && c11 <= 85) {
                  nxdj = "5"
              } else {
                  nxdj = ""
              }
          }
      }
      if (nxdj == "") {
          this.$Message.warning("能效数据不在备案范围")
          flag = false
          return flag
      }
      if (nxdjch != nxdj) {
          this.$Message.warning("所选能效等级与计算结果不符！")
          flag = false
          return flag
      }
      return flag
    },
    count43 () {
      let count_b = 0
      let vv = Math.pow(10,1)
      if (this.formRecord.c24 === '有霜' || this.formRecord.c24 === '无霜') {
        if (!isNaN(this.formRecord.c25)) {
          count_b += Number(this.formRecord.c25)
        }
      }
      if (this.formRecord.c26 === '有霜' || this.formRecord.c26 === '无霜') {
        if (!isNaN(this.formRecord.c27)) {
          count_b += Number(this.formRecord.c27)
        }
      }
      if (this.formRecord.c28 === '有霜' || this.formRecord.c28 === '无霜') {
        if (!isNaN(this.formRecord.c30)) {
          count_b += Number(this.formRecord.c30)
        }
      }
      if (this.formRecord.c33 === '有霜' || this.formRecord.c33 === '无霜') {
        if (!isNaN(this.formRecord.c35)) {
          count_b += Number(this.formRecord.c35)
        }
      }
      if (this.formRecord.c28 === '有霜' || this.formRecord.c28 === '无霜') {
        if (!isNaN(this.formRecord.c40)) {
          count_b += Number(this.formRecord.c40)
        }
      }
      if (this.formRecord.c125 === '有霜' || this.formRecord.c125 === '无霜') {
        if (!isNaN(this.formRecord.c126)) {
          count_b += Number(this.formRecord.c126)
        }
      }
      count_b = Math.round(count_b*vv)/vv
      this.formRecord.c43 = count_b
    },
    count123 () {
      let count_s = 0
      let vv = Math.pow(10,1)
      if (this.formRecord.c24 === '有霜' || this.formRecord.c24 === '无霜') {
        if (!isNaN(this.formRecord.c82)) {
          count_s += Number(this.formRecord.c82)
        }
      }
      if (this.formRecord.c26 === '有霜' || this.formRecord.c26 === '无霜') {
        if (!isNaN(this.formRecord.c84)) {
          count_s += Number(this.formRecord.c84)
        }
      }
      if (this.formRecord.c28 === '有霜' || this.formRecord.c28 === '无霜') {
        if (!isNaN(this.formRecord.c86)) {
          count_s += Number(this.formRecord.c86)
        }
      }
      if (this.formRecord.c33 === '有霜' || this.formRecord.c33 === '无霜') {
        if (!isNaN(this.formRecord.c88)) {
          count_s += Number(this.formRecord.c88)
        }
      }
      if (this.formRecord.c28 === '有霜' || this.formRecord.c28 === '无霜') {
        if (!isNaN(this.formRecord.c90)) {
          count_s += Number(this.formRecord.c90)
        }
      }
      if (this.formRecord.c125 === '有霜' || this.formRecord.c125 === '无霜') {
        if (!isNaN(this.formRecord.c127)) {
          count_s += Number(this.formRecord.c127)
        }
      }
      count_s = Math.round(count_s * vv) / vv;
      this.formRecord.c123 = count_s
    },
    clearRelevantData () {
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
      this.formRecord.c24 = ''
      this.formRecord.c25 = ''
      this.formRecord.c82 = ''
      this.formRecord.c83 = ''
      this.formRecord.c62 = ''
      this.formRecord.c26 = ''
      this.formRecord.c27 = ''
      this.formRecord.c84 = ''
      this.formRecord.c63 = ''
      this.formRecord.c85 = ''
      this.formRecord.c29 = ''
      this.formRecord.c28 = ''
      this.formRecord.c30 = ''
      this.formRecord.c86 = ''
      this.formRecord.c32 = ''
      this.formRecord.c120 = ''
      this.formRecord.c31 = ''
      this.formRecord.c64 = ''
      this.formRecord.c87 = ''
      this.formRecord.c34 = ''
      this.formRecord.c33 = ''
      this.formRecord.c35 = ''
      this.formRecord.c88 = ''
      this.formRecord.c37 = ''
      this.formRecord.c121 = ''
      this.formRecord.c36 = ''
      this.formRecord.c65 = ''
      this.formRecord.c89 = ''
      this.formRecord.c39 = ''
      this.formRecord.c38 = ''
      this.formRecord.c40 = ''
      this.formRecord.c90 = ''
      this.formRecord.c42 = ''
      this.formRecord.c122 = ''
      this.formRecord.c41 = ''
      this.formRecord.c66 = ''
      this.formRecord.c91 = ''
      this.formRecord.c124 = ''
      this.formRecord.c125 = ''
      this.formRecord.c126 = ''
      this.formRecord.c127 = ''
      this.formRecord.c128 = ''
      this.formRecord.c129 = ''
      this.formRecord.c130 = ''
      this.formRecord.c131 = ''
      this.formRecord.c132 = ''
      this.formRecord.c43 = ''
      this.formRecord.c123 = ''
    },
    submitRecord () {
      this.submitDisabled = true
      let _this = this
      this.formRecord.ptid = this.$store.state.app.ptId
      this.formRecord.pltId = this.$store.state.app.pltId
      this.formRecord.record_type = 0
      this.formRecord.ec_labreport_id = this.$store.state.app.rid
      this.formRecord.ec_labreport_no = this.$store.state.app.barcode
      this.formRecord.ec_labname = this.$store.state.app.labName
      this.formRecord.attach_list = JSON.stringify(this.filesArr)
      if (this.uploadParam.uploadFileList24.length === 0) {
        this.$Message.warning('请上传产品正面图片！')
        this.submitDisabled = false
        return false
      }
      if (this.uploadParam.uploadFileList76.length === 0) {
        this.$Message.warning('请上传铭牌图片！')
        this.submitDisabled = false
        return false
      }
      this.$refs.formRecord.validate((valid) => {
        if (valid) {
          //this.formRecord.c20 = this.formatDate(this.formRecord.c20)
          if (_this.checkFun()) {
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
            })
            .then(res => {
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
          } else {
            _this.submitDisabled = false
          }
        } else {
          //_this.$Message.error(res.data.result_msg)
          _this.submitDisabled = false
        }
      })
    },
    saveRecord () {
      this.saveDisabled = true
      let _this = this
      //this.formRecord.c20 = this.formatDate(this.formRecord.c20)
      this.formRecord.ptid = this.$store.state.app.ptId
      this.formRecord.pltId = this.$store.state.app.pltId
      this.formRecord.record_type = 0
      this.formRecord.ec_labreport_id = this.$store.state.app.rid
      this.formRecord.ec_labreport_no = this.$store.state.app.barcode
      this.formRecord.ec_labname = this.$store.state.app.labName
      //axios.post('/marking/saveDraft.do',pa)
      // axios({
      //   url: '/marking/saveDraft.do',
      //   method: 'POST',
      //   params: this.formRecord,
      //   headers: {
      //     contentType: 'application/json charset=utf-8'
      //   }
      // })
      axios({
        url: '/marking/saveDraft.do',
        method: 'POST',
        data: this.formRecord,
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
          this.$Message.warning(res.data.message)
          this.saveDisabled = false
        }
      })
    },
    formatDate (d) {
      let date = new Date(d)
      let year = date.getFullYear()
      let month = data.getMonth() + 1
      let day = date.getDate()
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
    },
    getFile2 () {},
    getFile3 () {},
    getFile4 () {},
    getFile5 () {},
    getFile6 () {},
    getFile7 () {},
    getFile8 () {},
    getFile9 () {}
  },
  computed: {
    lc () {
      if (this.formRecord.c21 === '葡萄酒储藏柜' ||
          this.formRecord.c21 === '卧式冷冻箱(柜)' ||
          this.formRecord.c21 === '立式冷冻箱(柜)' ||
          this.formRecord.c21 === '') {
        return true
      } else {
        return false
      }
    },
    ld () {
      if (this.formRecord.c21 === '冷藏冷冻箱' ||
          this.formRecord.c21 === '卧式冷藏冷冻柜' ||
          this.formRecord.c21 === '冷冻食品储藏箱' ||
          this.formRecord.c21 === '卧式冷冻箱(柜)' ||
          this.formRecord.c21 === '立式冷冻箱(柜)') {
            return false
      } else {
        return true
      }
    },
    otherCompartment () {
      if (this.formRecord.c21 === '卧式冷冻箱(柜)' ||
          this.formRecord.c21 === '立式冷冻箱(柜)' ||
          this.formRecord.c21 === '') {
        return true
      } else {
        return false
      }
    },
    ruleRecord () {
      let decimal1 =/^(([1-9]{1}\d*)|(0{1}))(\.\d{1})$/
      let decimal2 = /^(([1-9]{1}\d*)|(0{1}))(\.\d{2})$/
      let decimal3 = /^(([1-9]{1}\d*)|(0{1}))(\.\d{3})$/
      return {
        c2: [
          {
            required: true,
            message: '请填写制造单位'
          }
        ],
        c3: [
          {
            required: true,
            message: '请填写备案方'
          }
        ],
        c5: [
          {
            required: true,
            message: '请填写商标'
          }
        ],
        c7: [
          {
            required: true,
            message: '请选择能效等级'
          }
        ],
        c8: [
          {
            required: this.formRecord.c21 !== '',
            message: '请填写额定值'
          },
          {
            pattern: decimal2,
            message: '两位小数'
          }
        ],
        c14: [
          {
            required: this.formRecord.c21 === '冷藏冷冻箱',
            message: '请填写额定值'
          },
          {
            pattern: decimal2,
            message: '两位小数'
          }
        ],
        c9: [
          {
            required: this.formRecord.c21 !== '',
            message: '请填写实测值'
          },
          {
            pattern: decimal3,
            message: '三位小数'
          }
        ],
        c12: [
          {
            required: this.formRecord.c21 !== '',
            message: '请填写实测值'
          },
          {
            pattern: decimal3,
            message: '三位小数'
          }
        ],
        c15: [
          {
            required: this.formRecord.c21 === '冷藏冷冻箱',
            message: '请填写实测值'
          },
          {
            pattern: decimal3,
            message: '三位小数'
          }
        ],
        c18: [
          {
            required: this.formRecord.c21 === '冷藏冷冻箱',
            message: '请填写实测值'
          },
          {
            pattern: decimal3,
            message: '三位小数'
          }
        ],
        c11: [
          {
            required: this.formRecord.c21 === '冷藏冷冻箱',
            message: '请填写额定值'
          },
          {
            pattern: decimal1,
            message: '一位小数'
          }
        ],
        c17: [
          {
            required: this.formRecord.c21 === '冷藏冷冻箱',
            message: '请填写额定值'
          },
          {
            pattern: decimal1,
            message: '一位小数'
          }
        ],
        c82: [
          {
            required: this.formRecord.c24 === '有霜' || this.formRecord.c24 === '无霜',
            message: '不能为空'
          },
          {
            pattern: decimal1,
            message: '一位小数'
          }
        ],
        c62: [
          {
            required: this.formRecord.c24 === '有霜' || this.formRecord.c24 === '无霜',
            message: '不能为空'
          }
        ],
        c84: [
          {
            required: this.formRecord.c26 === '有霜' || this.formRecord.c26 === '无霜',
            message: '不能为空'
          },
          {
            pattern: decimal1,
            message: '一位小数'
          }
        ],
        c63: [
          {
            required: this.formRecord.c26 === '有霜' || this.formRecord.c26 === '无霜',
            message: '不能为空'
          }
        ],
        c86: [
          {
            required: this.formRecord.c28 === '有霜' || this.formRecord.c28 === '无霜',
            message: '一位小数'
          },
          {
            pattern: decimal1,
            message: '一位小数'
          }
        ],
        c31: [
          {
            required: this.formRecord.c28 === '有霜' || this.formRecord.c28 === '无霜',
            message: '不能为空'
          }
        ],
        c32: [
          {
            required: this.formRecord.c28 === '有霜' || this.formRecord.c28 === '无霜',
            message: '不能为空'
          }
        ],
        c64: [
          {
            required: this.formRecord.c28 === '有霜' || this.formRecord.c28 === '无霜',
            message: '不能为空'
          }
        ],
        c120: [
          {
            required: this.formRecord.c28 === '有霜' || this.formRecord.c28 === '无霜',
            message: '不能为空'
          }
        ],
        c88: [
          {
            required: this.formRecord.c33 === '有霜' || this.formRecord.c33 === '无霜',
            message: '一位小数'
          },
          {
            pattern: decimal1,
            message: '一位小数'
          }
        ],
        c36: [
          {
            required: this.formRecord.c33 === '有霜' || this.formRecord.c33 === '无霜',
            message: '不能为空'
          }
        ],
        c37: [
          {
            required: this.formRecord.c33 === '有霜' || this.formRecord.c33 === '无霜',
            message: '不能为空'
          }
        ],
        c65: [
          {
            required: this.formRecord.c33 === '有霜' || this.formRecord.c33 === '无霜',
            message: '不能为空'
          }
        ],
        c121: [
          {
            required: this.formRecord.c33 === '有霜' || this.formRecord.c33 === '无霜',
            message: '不能为空'
          }
        ],
        c90: [
          {
            required: this.formRecord.c38 === '有霜' || this.formRecord.c38 === '无霜',
            message: '一位小数'
          },
          {
            pattern: decimal1,
            message: '一位小数'
          }
        ],
        c41: [
          {
            required: this.formRecord.c38 === '有霜' || this.formRecord.c38 === '无霜',
            message: '不能为空'
          }
        ],
        c42: [
          {
            required: this.formRecord.c38 === '有霜' || this.formRecord.c38 === '无霜',
            message: '不能为空'
          }
        ],
        c66: [
          {
            required: this.formRecord.c38 === '有霜' || this.formRecord.c38 === '无霜',
            message: '不能为空'
          }
        ],
        c122: [
          {
            required: this.formRecord.c38 === '有霜' || this.formRecord.c38 === '无霜',
            message: '不能为空'
          }
        ],
        c127: [
          {
            required: this.formRecord.c125 === '有霜' || this.formRecord.c125 === '无霜',
            message: '一位小数'
          },
          {
            pattern: decimal1,
            message: '一位小数'
          }
        ],
        c128: [
          {
            required: this.formRecord.c125 === '有霜' || this.formRecord.c125 === '无霜',
            message: '不能为空'
          }
        ],
        c129: [
          {
            required: this.formRecord.c125 === '有霜' || this.formRecord.c125 === '无霜',
            message: '不能为空'
          }
        ],
        c130: [
          {
            required: this.formRecord.c125 === '有霜' || this.formRecord.c125 === '无霜',
            message: '不能为空'
          }
        ],
        c131: [
          {
            required: this.formRecord.c125 === '有霜' || this.formRecord.c125 === '无霜',
            message: '不能为空'
          }
        ],
        c22: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c44: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c45: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c46: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c47: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c48: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c49: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c50: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c51: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c52: [
          {
            required: this.formRecord.c51.join('').indexOf('其他') > -1,
            message: '不能为空'
          }
        ],
        c53: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c54: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c55: [
          {
            required: this.formRecord.c54 === '多门',
            message: '不能为空'
          }
        ],
        c56: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c57: [
          {
            required: this.formRecord.c56.join('').indexOf('其他') > -1,
            message: '不能为空'
          }
        ],
        c58: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c59: [
          {
            required: this.formRecord.c58.join('').indexOf('其他') > -1,
            message: '不能为空'
          }
        ],
        c60: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c61: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c67: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c68: [
          {
            required: true,
            message: '不能为空'
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
        c74: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c75: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c76: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c77: [
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
        fileField24: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        fileField26: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        fileField27: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        fileField28: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        fileField29: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        fileField30: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        fileField31: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        fileField32: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        fileField76: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c43: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c123: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c20: [
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
h1{
  font-size:20px;
}
h2{
  font-size:18px;
  margin:10px 0;
}
.part{
  background:#eee;
  padding: 15px;
  margin: 15px 0;
}
.part1 p{
  text-indent:2em;
  font-size:16px;
  line-height:36px;
}
table{
  width:1000px;
  border-collapse:collapse;
  margin-bottom:10px;
}
table th{
  background-color: rgb(245, 245, 246);
}
table td,table th{
  border:1px solid #dddee1;
  padding:10px;
}
.part6 td>div{
  margin-bottom:5px;
}
.part6 td span{
  display:inline-block;width:100px;text-align:center;
}
.tc{
  text-align:center;
}
.part8 td{
  text-align:center;
}
.red{
  color:red;
}
#table1 td,#table2 td,#table3 td,#table4 td{
  padding:20px 10px;
}
#table1 .ivu-form-item,#table2 .ivu-form-item,#table3 .ivu-form-item,#table4 .ivu-form-item{
  margin-bottom:0!important;
}
#table2 .ivu-form-item,#table3 .ivu-form-item,#table4 .ivu-form-item{
  display:inline-block;
}
</style>
