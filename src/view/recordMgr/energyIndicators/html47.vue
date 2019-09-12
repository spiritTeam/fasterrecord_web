<template>
  <div class="wrapper">
    <Form ref="formRecord" :model="formRecord" label-position="right" :rules="pageType!='extend'?ruleRecord:extendRule">
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
                <th><i class="red">*</i>实验室名称</th>
                <th><i class="red">*</i>检测报告条形码</th>
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
          <FormItem prop="c1" label="生产者名称" style="width:1000px;" :label-width="180">
            <Input type="text" v-model="formRecord.c1" disabled placeholder="生产者名称" ></Input>

          </FormItem>
          <FormItem prop="c2" label="制造单位" style="width:1000px;" :label-width="180">
            <Input type="text" v-model="formRecord.c2" :disabled='disabledoff' placeholder="制造单位" ></Input>

          </FormItem>
          <FormItem prop="c3" label="备案方" style="width:1000px;" :label-width="180">
            <Input type="text" v-model="formRecord.c3" :disabled='disabledoff' placeholder="备案方" ></Input>
          </FormItem>
          <FormItem prop="c4" label="规格型号" style="width:1000px;" :label-width="180">
            <Input type="text" v-model="formRecord.c4" :disabled='!disabledoff'  placeholder="规格型号"  ></Input>

          </FormItem>
          <FormItem prop="c5" label="商标" style="width:1000px;" :label-width="180">
            <Input type="text" v-model="formRecord.c5" :disabled='pageType=="view"' placeholder="商标" ></Input>

          </FormItem>
          <FormItem prop="c200" label="依据国家标准" style="width:1000px;" :label-width="180">
            <Input type="text" v-model="formRecord.c200" placeholder="依据国家标准" readonly disabled></Input>

          </FormItem>
          <FormItem prop="c7" label="能效等级" style="width:1000px;" :label-width="180">
            <RadioGroup v-model="formRecord.c7">
              <Radio label="1" :disabled='disabledoff'>1级</Radio>
              <Radio label="2" :disabled='disabledoff'>2级</Radio>
              <Radio label="3" :disabled='disabledoff'>3级</Radio>
              <Radio label="4" :disabled='disabledoff'>4级</Radio>
              <Radio label="5" :disabled='disabledoff'>5级</Radio>
            </RadioGroup>

          </FormItem>
          <FormItem prop="c21" label="产品类型" :label-width="180">
            <RadioGroup v-model="formRecord.c21" >
              <Radio :disabled='disabledoff' label="冷藏冷冻箱" >冷藏冷冻箱</Radio>
              <Radio :disabled='disabledoff' label="葡萄酒储藏柜" >葡萄酒储藏柜</Radio>
              <Radio :disabled='disabledoff' label="卧式冷藏冷冻柜" >卧式冷藏冷冻柜</Radio>
              <Radio :disabled='disabledoff' label="无星级室的冷藏箱" >无星级室的冷藏箱</Radio>
              <Radio :disabled='disabledoff' label="带1星级室的冷藏箱" >带1星级室的冷藏箱</Radio>
              <Radio :disabled='disabledoff' label="带2星级室的冷藏箱" >带2星级室的冷藏箱</Radio>
              <Radio :disabled='disabledoff' label="带3星级室的冷藏箱" >带3星级室的冷藏箱</Radio>
              <Radio :disabled='disabledoff' label="冷冻食品储藏箱" >冷冻食品储藏箱</Radio>
              <Radio :disabled='disabledoff' label="卧式冷冻箱(柜)" >卧式冷冻箱(柜)</Radio>
              <Radio :disabled='disabledoff' label="立式冷冻箱(柜)" >立式冷冻箱(柜)</Radio>
            </RadioGroup>

          </FormItem>
          <table id="table1">
            <tr>
              <th>项目</th>
              <th><i class="red">*</i>额定值</th>
              <th><i class="red">*</i>实测值</th>
              <th>备注</th>
            </tr>
            <tr>
              <td>标准耗电量 （kW·h/24h）</td>
              <td>
                <FormItem prop="c8">
                  <Input type="text" v-model="formRecord.c8" :disabled='disabledoff' placeholder="两位小数"></Input>

                </FormItem>
              </td>
              <td>
                <FormItem prop="c9">
                  <Input type="text" v-model="formRecord.c9" :disabled='disabledoff' :required="formRecord.c21!==''" placeholder="三位小数"></Input>

                </FormItem>
              </td>
              <td>
                <FormItem prop="c10">
                  <Input type="text" v-model="formRecord.c10" :disabled='disabledoff' ></Input>

                </FormItem>
              </td>
            </tr>
            <tr>
              <td>标准能效指数（%）</td>
              <td>
                <FormItem prop="c11">
                  <Input type="text" v-model="formRecord.c11" :disabled='disabledoff'  placeholder="一位小数"></Input>

                </FormItem>
              </td>
              <td>
                <FormItem prop="c12">
                  <Input type="text" v-model="formRecord.c12" :disabled='disabledoff'  placeholder="三位小数"></Input>

                </FormItem>
              </td>
              <td>
                <FormItem prop="c13">
                  <Input type="text" v-model="formRecord.c13" :disabled='disabledoff' ></Input>
                </FormItem>
              </td>
            </tr>
            <tr>
              <td>综合耗电量 （kW·h/24h）</td>
              <td>
                <FormItem prop="c14">
                  <Input type="text" v-model="formRecord.c14"  :disabled='disabledoff' placeholder="两位小数"></Input>

                </FormItem>
              </td>
              <td>
                <FormItem prop="c15">
                  <Input type="text" v-model="formRecord.c15" :disabled='disabledoff'  placeholder="三位小数"></Input>

                </FormItem>
              </td>
              <td>
                <FormItem prop="c16">
                  <Input type="text" v-model="formRecord.c16" :disabled='disabledoff' ></Input>

                </FormItem>
              </td>
            </tr>
            <tr>
              <td>综合能效指数（%）</td>
              <td>
                <FormItem prop="c17">
                  <Input type="text" v-model="formRecord.c17" :disabled='disabledoff' placeholder="一位小数"></Input>

                </FormItem>
              </td>
              <td>
                <FormItem prop="c18">
                  <Input type="text" v-model="formRecord.c18" :disabled='disabledoff'  placeholder="三位小数"></Input>

                </FormItem>
              </td>
              <td>
                <FormItem prop="c19">
                  <Input type="text" v-model="formRecord.c19" :disabled='disabledoff' ></Input>

                </FormItem>
              </td>
            </tr>
          </table>
          <table id="table2">
            <tr>
              <th><i class="red">*</i>间室名称</th>
              <th><i class="red">*</i>类型</th>
              <th><i class="red">*</i>标称容积值L</th>
              <th><i class="red">*</i>实测容积值L</th>
              <th width="150px;"><i class="red">*</i>设计温度℃</th>
              <th><i class="red">*</i>特性温度℃</th>
              <th><i class="red">*</i>隔热层厚度(mm)</th>
              <th>备注</th>
            </tr>
            <tr>
              <td>冷藏室</td>
              <td>
                <RadioGroup v-model="formRecord.c24" >
                  <Radio label="有霜" :disabled='disabledoff' >有霜</Radio>
                  <Radio label="无霜" :disabled='disabledoff' >无霜</Radio>
                </RadioGroup>

              </td>
              <td>
                <FormItem prop="c25">
                  <Input type="text" v-model="formRecord.c25" :disabled='disabledoff' ></Input>

                </FormItem>
              </td>
              <td>
                <FormItem prop="c82">
                  <Input type="text" v-model="formRecord.c82" :disabled='disabledoff' placeholder="一位小数"></Input>

                </FormItem>
              </td>
              <td>/</td>
              <td>/</td>
              <td>
                <FormItem prop="c62">
                  <Input type="text" v-model="formRecord.c62" :disabled='disabledoff' ></Input>

                </FormItem>
              </td>
              <td>
                <FormItem prop="c83">
                  <Input type="text" v-model="formRecord.c83" :disabled='disabledoff' ></Input>

                </FormItem>
              </td>
            </tr>
            <tr>
              <td>冷冻室</td>
              <td>
                <RadioGroup v-model="formRecord.c26" >
                  <Radio label="有霜" :disabled='disabledoff'>有霜</Radio>
                  <Radio label="无霜" :disabled='disabledoff'>无霜</Radio>
                </RadioGroup>

              </td>
              <td>
                <FormItem prop="c27">
                  <Input type="text" v-model="formRecord.c27" :disabled='disabledoff' ></Input>

                </FormItem>
              </td>
              <td>
                <FormItem prop="c84">
                  <Input type="text" v-model="formRecord.c84" :disabled='disabledoff'  placeholder="一位小数"></Input>

                </FormItem>
              </td>
              <td>/</td>
              <td>/</td>
              <td>
                <FormItem prop="c63">
                  <Input type="text" v-model="formRecord.c63" :disabled='disabledoff' ></Input>

                </FormItem>
              </td>
              <td>
                <FormItem prop="c85">
                  <Input type="text" v-model="formRecord.c85" :disabled='disabledoff'></Input>

                </FormItem>
              </td>
            </tr>
            <tr>
              <td>其它间室1<br /><Input type="text" v-model="formRecord.c29" :disabled='disabledoff' ></Input></td>
              <td>
                <FormItem prop="c28">
                  <RadioGroup v-model="formRecord.c28">
                    <Radio label="有霜" :disabled='disabledoff' >有霜</Radio>
                    <Radio label="无霜" :disabled='disabledoff' >无霜</Radio>
                  </RadioGroup>

                </FormItem>
              </td>
              <td>
                <FormItem prop="c30">
                  <Input type="text" v-model="formRecord.c30" :disabled='disabledoff'></Input>

                </FormItem>
              </td>
              <td>
                <FormItem prop="c86">
                  <Input type="text" v-model="formRecord.c86" :disabled='disabledoff' placeholder="一位小数"></Input>

                </FormItem>
              </td>
              <td>
                <label style="display:block;margin-bottom:5px;">
                  <span>低：</span>
                  <FormItem prop="c32">
                    <Input type="text" v-model="formRecord.c32" :disabled='disabledoff' style="width:50px;" ></Input>

                  </FormItem>
                </label>
                <label>
                  <span>高：</span>
                  <FormItem prop="c120">
                    <Input type="text" v-model="formRecord.c120" :disabled='disabledoff' style="width:50px;" ></Input>

                  </FormItem>
                </label>
              </td>
              <td>
                <FormItem prop="c31">
                  <Input type="text" v-model="formRecord.c31" :disabled='disabledoff' ></Input>

                </FormItem>
              </td>
              <td>
                <FormItem prop="c64">
                  <Input type="text" v-model="formRecord.c64" :disabled='disabledoff' ></Input>

                </FormItem>
              </td>
              <td>
                <Input type="text" v-model="formRecord.c87" :disabled='disabledoff' ></Input>

              </td>
            </tr>
            <tr>
              <td>其它间室2<br />
                <FormItem prop="c34">
                  <Input type="text" v-model="formRecord.c34" :disabled='disabledoff'></Input>

                </FormItem>
              </td>
              <td>
                <FormItem prop="c33">
                  <RadioGroup v-model="formRecord.c33">
                    <Radio label="有霜" :disabled='disabledoff'>有霜</Radio>
                    <Radio label="无霜" :disabled='disabledoff'>无霜</Radio>
                  </RadioGroup>

                </FormItem>
              </td>
              <td>
                <FormItem prop="c35">
                  <Input type="text" v-model="formRecord.c35" :disabled='disabledoff'></Input>

                </FormItem>
              </td>
              <td>
                <FormItem prop="c88">
                  <Input type="text" v-model="formRecord.c88" :disabled='disabledoff'  placeholder="一位小数"></Input>

                </FormItem>
              </td>
              <td>
                <label style="display:block;margin-bottom:5px;">
                  <span>低：</span>
                  <FormItem prop="c37">
                    <Input type="text" v-model="formRecord.c37" style="width:50px;" :disabled='disabledoff'></Input>

                  </FormItem>
                </label>
                <label>
                  <span>高：</span>
                  <FormItem prop="c121">
                    <Input type="text" v-model="formRecord.c121" :disabled='disabledoff' style="width:50px;" ></Input>

                  </FormItem>
                </label>
              </td>
              <td>
                <FormItem prop="c36">
                  <Input type="text" v-model="formRecord.c36" :disabled='disabledoff' ></Input>

                </FormItem>
              </td>
              <td>
                <FormItem prop="c65">
                  <Input type="text" v-model="formRecord.c65" :disabled='disabledoff'></Input>

                </FormItem>
              </td>
              <td>
                <Input type="text" v-model="formRecord.c89" :disabled='disabledoff'></Input>

              </td>
            </tr>
            <tr>
              <td>其它间室3<br />
                <FormItem prop="c39">
                  <Input type="text" v-model="formRecord.c39" :disabled='disabledoff'></Input>

                </FormItem>
              </td>
              <td>
                <FormItem prop="c38">
                  <RadioGroup v-model="formRecord.c38">
                    <Radio label="有霜" :disabled='disabledoff'>有霜</Radio>
                    <Radio label="无霜" :disabled='disabledoff' >无霜</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c40">
                  <Input type="text" v-model="formRecord.c40" :disabled='disabledoff'></Input>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c90">
                  <Input type="text" v-model="formRecord.c90" :disabled='disabledoff' placeholder="一位小数"></Input>

                </FormItem>
              </td>
              <td>
                <label style="display:block;margin-bottom:5px;">
                  <span>低：</span>
                  <FormItem prop="c42">
                    <Input type="text" v-model="formRecord.c42" :disabled='disabledoff' style="width:50px;" ></Input>

                  </FormItem>
                </label>
                <label>
                  <span>高：</span>
                  <FormItem prop="c122">
                    <Input type="text" v-model="formRecord.c122" :disabled='disabledoff' style="width:50px;" ></Input>

                  </FormItem>
                </label>
              </td>
              <td>
                <FormItem prop="c41">
                  <Input type="text" v-model="formRecord.c41" :disabled='disabledoff'></Input>

                </FormItem>
              </td>
              <td>
                <FormItem prop="c66">
                  <Input type="text" v-model="formRecord.c66" :disabled='disabledoff'></Input>

                </FormItem>
              </td>
              <td>
                <Input type="text" v-model="formRecord.c91" :disabled='disabledoff'></Input>

              </td>
            </tr>
            <tr>
              <td>其它间室4<br />
                <FormItem prop="c124">
                  <Input type="text" v-model="formRecord.c124" :disabled='disabledoff'></Input>

                </FormItem>
              </td>
              <td>
                <FormItem prop="c125">
                  <RadioGroup v-model="formRecord.c125">
                    <Radio label="有霜" :disabled='disabledoff'>有霜</Radio>
                    <Radio label="无霜" :disabled='disabledoff'>无霜</Radio>
                  </RadioGroup>
                </FormItem>
              </td>
              <td>
                <FormItem prop="c126">
                  <Input type="text" v-model="formRecord.c126" :disabled='disabledoff'></Input>

                </FormItem>
              </td>
              <td>
                <FormItem prop="c127">
                  <Input type="text" v-model="formRecord.c127" :disabled='disabledoff' placeholder="一位小数"></Input>

                </FormItem>
              </td>
              <td>
                <label style="display:block;margin-bottom:5px;">
                  <span>低：</span>
                  <FormItem prop="c128">
                    <Input type="text" v-model="formRecord.c128" :disabled='disabledoff' style="width:50px;" ></Input>

                  </FormItem>
                </label>
                <label>
                  <span>高：</span>
                  <FormItem prop="c129">
                    <Input type="text" v-model="formRecord.c129" :disabled='disabledoff' style="width:50px;" ></Input>

                  </FormItem>
                </label>
              </td>
              <td>
                <FormItem prop="c130">
                  <Input type="text" v-model="formRecord.c130" :disabled='disabledoff'></Input>

                </FormItem>
              </td>
              <td>
                <FormItem prop="c131">
                  <Input type="text" v-model="formRecord.c131" :disabled='disabledoff'></Input>

                </FormItem>
              </td>
              <td>
                <FormItem prop="c132">
                  <Input type="text" v-model="formRecord.c132" :disabled='disabledoff'></Input>

                </FormItem>
              </td>
            </tr>
          </table>
          <table id="table5">
            <tr>
              <td><i class="red">*</i>总容积</td>
              <td>
                <Button type="info" @click="count43">计算标称值</Button>
                <FormItem prop="c43">
                  <Input type="text" v-model="formRecord.c43" style="width:150px;" readonly ></Input>

                </FormItem>
                <Button type="info" @click="count123">计算实测值</Button>
                <FormItem prop="c123">
                  <Input type="text" v-model="formRecord.c123" style="width:150px;" readonly ></Input>

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
            <FormItem prop="c20" label="备案标识开始使用日期" style="width:1000px;">
              <DatePicker type="date" :options="dataInit" style="width: 200px" v-model="formRecord.c20" ></DatePicker>
            </FormItem>
        </Card>
      </div>
      <div class="part part5">
        <Card :bordered="false">
          <h2>五、样品描述</h2>
          <table id="table3">
            <tr>
              <td><i class="red">*</i>电源性质</td>
              <td width="40%">
                <FormItem prop="c22">
                  <RadioGroup v-model="formRecord.c22">
                    <Radio label="三相" :disabled='disabledoff'>三相</Radio>
                    <Radio label="单相" :disabled='disabledoff'>单相</Radio>
                  </RadioGroup>

                </FormItem>
              </td>
            </tr>
            <tr>
              <td><i class="red">*</i>气候类型</td>
              <td>
                <FormItem prop="c23">
                  <CheckboxGroup v-model="formRecord.c23">
                    <Checkbox label="SN" :disabled='disabledoff'>SN</Checkbox>
                    <Checkbox label="N" :disabled='disabledoff'>N</Checkbox>
                    <Checkbox label="ST" :disabled='disabledoff'>ST</Checkbox>
                    <Checkbox label="T" :disabled='disabledoff'>T</Checkbox>
                  </CheckboxGroup>

                </FormItem>
              </td>
            </tr>
            <tr>
              <td><i class="red">*</i>含有15 L及以上容积、具有冰温区功能的变温室</td>
              <td>
                <FormItem prop="c44">
                  <RadioGroup v-model="formRecord.c44">
                    <Radio label="有" :disabled='disabledoff'>有</Radio>
                    <Radio label="无" :disabled='disabledoff'>无</Radio>
                  </RadioGroup>

                </FormItem>
              </td>
            </tr>
            <tr>
              <td><i class="red">*</i>含有15 L及以上容积、具有冰温区功能同时具备冷藏功能和三星级或四星级冷冻功能的变温室</td>
              <td>
                <FormItem prop="c45">
                  <RadioGroup v-model="formRecord.c45">
                    <Radio label="有" :disabled='disabledoff'>有</Radio>
                    <Radio label="无" :disabled='disabledoff'>无</Radio>
                  </RadioGroup>

                </FormItem>
              </td>
            </tr>
            <tr>
              <td><i class="red">*</i>间室容积大于400 L并带有穿透式自动制冰功能</td>
              <td>
                <FormItem prop="c46">
                  <RadioGroup v-model="formRecord.c46">
                    <Radio label="是" :disabled='disabledoff'>是</Radio>
                    <Radio label="否" :disabled='disabledoff'>否</Radio>
                  </RadioGroup>

                </FormItem>
              </td>
            </tr>
            <tr>
              <td><i class="red">*</i>当器具类型为1、2、3、4类型，所有门体均采用透明门体，且从内部往外投影的透明区域总投影面积占所有门体总投影面积的50%以上</td>
              <td>
                <FormItem prop="c47">
                  <RadioGroup v-model="formRecord.c47">
                    <Radio label="是" :disabled='disabledoff'>是</Radio>
                    <Radio label="否" :disabled='disabledoff'>否</Radio>
                  </RadioGroup>

                </FormItem>
              </td>
            </tr>
            <tr>
              <td><i class="red">*</i>当器具类型为5、6、7、8、9类型，至少有一个门体采用透明门体，且从内部往外投影的透明区域总投影面积大于所有门体总投影面积的25%</td>
              <td>
                <FormItem prop="c48">
                  <RadioGroup v-model="formRecord.c48">
                    <Radio label="是" :disabled='disabledoff'>是</Radio>
                    <Radio label="否" :disabled='disabledoff'>否</Radio>
                  </RadioGroup>

                </FormItem>
              </td>
            </tr>
            <tr>
              <td><i class="red">*</i>嵌入式制冷器具</td>
              <td>
                <FormItem prop="c49">
                  <RadioGroup v-model="formRecord.c49">
                    <Radio label="是" :disabled='disabledoff'>是</Radio>
                    <Radio label="否" :disabled='disabledoff'>否</Radio>
                  </RadioGroup>

                </FormItem>
              </td>
            </tr>
            <tr>
              <td><i class="red">*</i>具有环境可控型防凝露加热器</td>
              <td>
                <FormItem prop="c50">
                  <RadioGroup v-model="formRecord.c50">
                    <Radio label="是" :disabled='disabledoff'>是</Radio>
                    <Radio label="否" :disabled='disabledoff'>否</Radio>
                  </RadioGroup>

                </FormItem>
              </td>
            </tr>
            <tr>
              <td><i class="red">*</i>冷凝器形式</td>
              <td>
                <FormItem prop="c51">
                  <CheckboxGroup v-model="formRecord.c51" style="display:inline-block;">
                    <Checkbox label="外挂式" :disabled='disabledoff'>外挂式</Checkbox>
                    <Checkbox label="平背式" :disabled='disabledoff'>平背式</Checkbox>
                    <Checkbox label="底冷式" :disabled='disabledoff'>底冷式</Checkbox>
                    <Checkbox label="其它" :disabled='disabledoff'>其它</Checkbox>
                  </CheckboxGroup>

                </FormItem>
                <FormItem prop="c52">
                  <Input type="text" v-model="formRecord.c52" :disabled='disabledoff' style="width:80px;" ></Input>

                </FormItem>
              </td>
            </tr>
            <tr>
              <td><i class="red">*</i>温控器形式</td>
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
              <td><i class="red">*</i>冰箱门数</td>
              <td>
                <FormItem prop="c54">
                  <RadioGroup v-model="formRecord.c54" style="display:inline-block;">
                    <Radio label="单门" :disabled='disabledoff'>单门</Radio>
                    <Radio label="双门" :disabled='disabledoff'>双门</Radio>
                    <Radio label="三门" :disabled='disabledoff'>三门</Radio>
                    <Radio label="多门" :disabled='disabledoff'>多门</Radio>
                  </RadioGroup>

                </FormItem>
                <FormItem prop="c55">
                  <Input type="text" v-model="formRecord.c55" :disabled='disabledoff' style="width:80px;" ></Input>

                </FormItem>
              </td>
            </tr>
            <tr>
              <td><i class="red">*</i>温控器安装位置</td>
              <td>
                <FormItem prop="c56">
                  <CheckboxGroup v-model="formRecord.c56" style="display:inline-block;">
                    <Checkbox label="冷藏室" :disabled='disabledoff'>冷藏室</Checkbox>
                    <Checkbox label="冷冻室" :disabled='disabledoff'>冷冻室</Checkbox>
                    <Checkbox label="其它" :disabled='disabledoff'>其它</Checkbox>
                  </CheckboxGroup>

                </FormItem>
                <FormItem prop="c57">
                  <Input type="text" v-model="formRecord.c57" style="width:80px;" :disabled='disabledoff'></Input>

                </FormItem>
              </td>
            </tr>
            <tr>
              <td><i class="red">*</i>照明灯安装位置</td>
              <td>
                <FormItem prop="c58">
                  <CheckboxGroup v-model="formRecord.c58" style="display:inline-block;">
                    <Checkbox label="冷藏室" :disabled='disabledoff'>冷藏室</Checkbox>
                    <Checkbox label="冷冻室" :disabled='disabledoff'>冷冻室</Checkbox>
                    <Checkbox label="其它" :disabled='disabledoff'>其它</Checkbox>
                  </CheckboxGroup>

                </FormItem>
                <FormItem prop="c59">
                  <Input type="text" v-model="formRecord.c59" :disabled='disabledoff' style="width:80px;" ></Input>

                </FormItem>
              </td>
            </tr>
            <tr>
              <td><i class="red">*</i>照明灯额定输入功率（W）</td>
              <td>
                <FormItem prop="c60">
                  <Input type="text" v-model="formRecord.c60" :disabled='disabledoff' ></Input>

                </FormItem>
              </td>
            </tr>
            <tr>
              <td><i class="red">*</i>输入总功率（W）</td>
              <td>
                <FormItem prop="c61">
                  <Input type="text" v-model="formRecord.c61" :disabled='disabledoff'></Input>

                </FormItem>
              </td>
            </tr>
            <tr>
              <td><i class="red">*</i>冷冻能力（kg/12h）</td>
              <td>
                <FormItem prop="c67">
                  <Input type="text" v-model="formRecord.c67" :disabled='disabledoff'></Input>

                </FormItem>
              </td>
            </tr>
            <tr>
              <td><i class="red">*</i>外形尺寸(长×宽×高)（mm×mm×mm）</td>
              <td>
                <span style="display: inline-block;height: 32px;line-height: 32px;">长</span>
                <FormItem prop="c68">
                  <Input type="text" v-model="formRecord.c68" :disabled='disabledoff' style="width:80px;" ></Input>

                </FormItem>
                <span style="display: inline-block;height: 32px;line-height: 32px;">宽</span>
                <FormItem prop="c69">
                  <Input type="text" v-model="formRecord.c69" :disabled='disabledoff' style="width:80px;" ></Input>

                </FormItem>
                <span style="display: inline-block;height: 32px;line-height: 32px;">高</span>
                <FormItem prop="c70">
                  <Input type="text" v-model="formRecord.c70" :disabled='disabledoff' style="width:80px;" ></Input>

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
                  <i class="red">*</i>
                  <Input type="text" v-model="formRecord.c71" :disabled='disabledoff' ></Input>

                </FormItem>
              </td>
              <td>
                <FormItem prop="c72">
                  <i class="red">*</i>
                  <Input type="text" v-model="formRecord.c72" :disabled='disabledoff' ></Input>

                </FormItem>
              </td>
              <td>
                <FormItem prop="c73">
                  <i class="red">*</i>
                  <Input type="text" v-model="formRecord.c73" :disabled='disabledoff' ></Input>

                </FormItem>
              </td>
              <td>
                <FormItem prop="c74">
                  <i class="red">*</i>
                  <Input type="text" v-model="formRecord.c74" :disabled='disabledoff' ></Input>

                </FormItem>
              </td>
              <td>
                <FormItem prop="c75">
                  <i class="red">*</i>
                  <Input type="text" v-model="formRecord.c75" :disabled='disabledoff' ></Input>

                </FormItem>
              </td>
            </tr>
            <tr>
              <td>
                <Input type="text" v-model="formRecord.c94" :disabled='disabledoff' ></Input>

              </td>
              <td>
                <Input type="text" v-model="formRecord.c95" :disabled='disabledoff' ></Input>

              </td>
              <td>
                <Input type="text" v-model="formRecord.c96" :disabled='disabledoff' ></Input>

              </td>
              <td>
                <Input type="text" v-model="formRecord.c97" :disabled='disabledoff' ></Input>

              </td>
              <td>
                <Input type="text" v-model="formRecord.c98" :disabled='disabledoff' ></Input>

              </td>
            </tr>
            <tr>
              <td class="tc">2</td>
              <td>制冷剂</td>
              <td>
                <FormItem prop="c76">
                  <i class="red">*</i>
                  <Input type="text" v-model="formRecord.c76" :disabled='disabledoff' ></Input>

                </FormItem>
              </td>
              <td colspan="3">
                <div style="margin-bottom:25px">
                  <span><i class="red">*</i>主要成分：</span>
                  <FormItem prop="c77">
                    <Input type="text" v-model="formRecord.c77" :disabled='disabledoff' style="width:300px;" ></Input>

                  </FormItem>
                </div>
                <div>
                  <span><i class="red">*</i>重量：</span>
                  <FormItem prop="c92">
                    <Input type="text" v-model="formRecord.c92" :disabled='disabledoff' style="width:300px;" ></Input>
                  </FormItem>
                </div>
              </td>
              <td>
                <FormItem prop="c78">
                  <i class="red">*</i>
                  <Input type="text" v-model="formRecord.c78" :disabled='disabledoff' ></Input>

                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="tc">3</td>
              <td>制冷剂</td>
              <td>
                <Input type="text" v-model="formRecord.c104" :disabled='disabledoff' ></Input>

              </td>
              <td colspan="3">
                <div>
                  <span>主要成分：</span>
                  <Input type="text" v-model="formRecord.c105" :disabled='disabledoff' style="width:300px;" ></Input>

                </div>
                <div>
                  <span>重量：</span>
                  <Input type="text" v-model="formRecord.c106" :disabled='disabledoff' style="width:300px;" ></Input>

                </div>
              </td>
              <td>
                <Input type="text" v-model="formRecord.c107" :disabled='disabledoff' ></Input>

              </td>
            </tr>
            <tr>
              <td class="tc">4</td>
              <td>发泡材料</td>
              <td>
                <FormItem prop="c79">
                  <i class="red">*</i>
                  <Input type="text" v-model="formRecord.c79" :disabled='disabledoff' ></Input>

                </FormItem>
              </td>
              <td colspan="3">
                <div style="margin-bottom:25px">
                  <span><i class="red">*</i>主要成分：</span>
                  <FormItem prop="c80">
                    <Input type="text" v-model="formRecord.c80" :disabled='disabledoff' style="width:300px;" ></Input>

                  </FormItem>
                </div>
                <div>
                  <span><i class="red">*</i>比例：</span>
                  <FormItem prop="c93">
                    <Input type="text" v-model="formRecord.c93" :disabled='disabledoff' style="width:300px;" ></Input>
                  </FormItem>
                </div>
              </td>
              <td>
                <FormItem prop="c81">
                  <i class="red">*</i>
                  <Input type="text" v-model="formRecord.c81" :disabled='disabledoff' ></Input>

                </FormItem>
              </td>
            </tr>
            <tr>
              <td class="tc">5</td>
              <td>发泡材料</td>
              <td>
                <Input type="text" v-model="formRecord.c112" :disabled='disabledoff' ></Input>

              </td>
              <td colspan="3">
                <div>
                  <span>主要成分：</span>
                  <Input type="text" v-model="formRecord.c113" :disabled='disabledoff' style="width:300px;" ></Input>

                </div>
                <div>
                  <span>比例：</span>
                  <Input type="text" v-model="formRecord.c114" :disabled='disabledoff' style="width:300px;" ></Input>

                </div>
              </td>
              <td>
                <Input type="text" v-model="formRecord.c115" :disabled='disabledoff' ></Input>

              </td>
            </tr>
            <tr>
              <td colspan="7" class="tc">备注：如上述零部件属多个生产者，均应按上述要求逐一填写。</td>
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
              <td><Input type="text" v-model="formRecord.c202" :disabled='disabledoff'></Input></td>
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
              <td>关系证明 <p class="red" v-if="pageType!='view'">境外生产者请上传该附件</p></td>
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
              <td>进口商与境外生产者订立的相关合同副本
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
          <p class="red" v-if="pageType!='view'">注：<br />1、标“*”内容为必填项；
                  <br />2、所有附件上传文件大小需要控制在2M以内。</p>
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
          公司生产的 <span class="f-brand">{{formRecord.c5}}</span>
          品牌的 <span  class="f-model">{{pageType==='extend'?mainModel:formRecord.c4}}</span>
          型号的 <span  class="f-product">家用电冰箱-2015版</span>产品{{pageType==="update"?'已通过能效标识备案':''}}。
       </div>
       <div v-if="pageType==='extend'" class="org regress">
          <p><span></span>正在办理能效标识备案</p>
          <p><span class="bgs"></span>已通过能效标识备案</p>
       </div>
       <div class="org">备案编号:{{recordno}}</div>
       <dl v-if="pageType==='extend'">
          <dt>
              现提出型号扩展备案申请的 <span class="f-model">{{formRecord.c4}}</span>
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
              <span class="f-date">{{formatDate(formRecord.c20)}}</span>
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
              <span class="f-date">{{formatDate(formRecord.c20)}}</span>
          </dd>
          <dd>请中国标准化研究院能效标识管理中心核准。</dd>
      </dl>
      <div class="record-attached">附：{{pageType==="extend"?'扩展':'变更'}}型号产品的能效标识样本{{pageType==="extend"?'':'以及检测报告'}}</div>
    </Modal>
  </div>

</template>
<script>
import axios from 'axios'
import { mapGetters } from 'vuex'
export default {

  data () {
    const timeDate = parseInt(this.$store.state.app.dateinit)
    return {
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
      mainModel: '',
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
        c200: '',
        c202: '',
        ec_model_no: 47,
        attach_list: '',
        action_token:''
      }
    }
  },
  created(){
    let that=this
    this.getActionToken().then(res=>{
        that.action_token=res.data.action_token
    })
  },
  mounted () {
    // console.log(this.pageType)

  },
  methods: {
    showTemplate () {
      this.templatePic = this.$store.state.app.pltPic
      this.modal3 = true
    },
    getActionToken(){
        return axios.get('/ads/getToken.do')
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
    handleFormatError (file, id) {
      this.$Spin.hide();
      this.uploadParam['filePath' + id] = ''
      this.filesArr.splice(this.filesArr.indexOf(id), 1)
      this.$Notice.warning({
        title: '上传文件，类型错误',
        desc: '请选择正确的类型文件'
      })
    },
    fileHandleBeforeUpload (file, id) {
      console.log(id)
      let _this = this
      let fileObj = {}
      _this.uploadParam['uploadFileList' + id] = []
      const Fname = file.name
      const seat = Fname.lastIndexOf('.')
      const extension = Fname.substring(seat).toLowerCase()
      const gname = this.getRandom(extension)
      fileObj.ec_attach_id = id
      fileObj.ec_attach_originalname = file.name
      fileObj.ec_attach_file = gname
      Object.defineProperty(file, 'name', {
        writable: true,
        value: gname
      })
      return new Promise(function (resolve, reject) {
        axios.get('/oss/token.do').then(res => {
          if (_this.uploadParam['uploadFileList' + id].length > 0) {
            _this.$Notice.warning({
              title: '最多上传1个附件'
            })
            return false
          }
          _this.handleSpinCustom()
          let reader = new FileReader()
          reader.readAsDataURL(file)
          reader.onloadend = (e) => {
            file.url = reader.result
            // console.log(_this.uploadParam['uploadFileList'+id])
            _this.uploadParam['uploadFileList' + id].push(file)
          }
          _this.getImgPath(res.data.dir)
          _this.uploadParam['fileData' + id]['key'] = _this.dir + file.name
          _this.uploadParam['fileData' + id]['policy'] = res.data.policy
          _this.uploadParam['fileData' + id]['OSSAccessKeyId'] = res.data.accessid
          _this.uploadParam['fileData' + id]['success_action_status'] = '200'
          _this.uploadParam['fileData' + id]['signature'] = res.data.signature
          _this.uploadParam['fileData' + id]['callback']=res.data.callback
          _this.uploadUrl = res.data.host
          fileObj.ec_attach_path = _this.uploadParam['filePath' + id] = res.data.host + _this.dir + file.name
          _this.filesArr.push(fileObj)
          resolve()
        })
      })
    },
    handleSpinCustom () {
        this.$Spin.show({
            render: (h) => {
                return h('div', [
                    h('Icon', {
                        'class': 'demo-spin-icon-load',
                        props: {
                            type: 'ios-loading',
                            size: 18
                        }
                    }),
                    h('div', '上传中···')
                ])
            }
        });
    },
    viewClose () {
      this.$router.replace({
        name: 'queryRecord',
        params: {
          pageNum: this.$route.params.pageNum
        }
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
        if (i === 'c23' || i === 'c51' || i === 'c56' || i === 'c58') {
          that.formRecord[i] = []
          data[i].split(';').forEach((v) => {
            that.formRecord[i].push(v)
          })
        } else if (i === 'c20') {
          // this.$store.commit('setDateInit', data[i])
          if (data[i] != undefined) that.formRecord[i] = that.formatDate(parseInt(data[i]))
        } else {
          that.formRecord[i] = data[i]
          if (i == 'c4') that.mainModel = data[i]
        }
      }
    },
    /* 数据来源 草稿箱 */
    fillDraftData (params) {
      let that = this
      let data = params.data
      let mark = params.marking
      let attachList = this.filesArr = params.attachList
      if (attachList && attachList.length > 0) {
        attachList.forEach((item, idx) => {
          if (item.ec_attach_id == 25) {
            this.$store.commit('setPltPic', item.ec_attach_path)
          } else {
            that.uploadParam['filePath' + item.ec_attach_id] = item.ec_attach_path
          }
        })
      }

      if (params.lab) {
        that.$store.commit('setDefaultData', params.lab.params)
      }
      that.$store.commit('setPtId', mark.ptid)
      that.$store.commit('setPltId', mark.pltId)
      that.$store.commit('setRid', mark.ec_labreport_id)
      that.$store.commit('setBarcode', mark.ec_labreport_no)
      that.$store.commit('setLabName', mark.ec_labname)
      that.formRecord.id = mark.id
      for (let i in data) {
        if (i === 'c23' || i === 'c51' || i === 'c56' || i === 'c58') {
          that.formRecord[i] = []
          data[i].split(';').forEach((v) => {
            that.formRecord[i].push(v)
          })
        } else if (i === 'c20') {
          // this.$store.commit('setDateInit', data[i])
          if (data[i] != undefined) that.formRecord[i] = that.formatDate(parseInt(data[i]))
        } else {
          that.formRecord[i] = data[i]
        }
      }
    },
    showImg (path) {
      this.uploadPic = path
      this.modal4 = true
    },
     templateLoad(){
      this.loadText=false;
    },
    /* 数据来源 新增备案 */
    fillDefaultData () {
      let that = this
      that.formRecord.c200 = that.$store.state.app.gb
      // console.log();
      that.$store.state.app.defaultData.forEach((e) => {
        if (e.recId === 'c23' || e.recId === 'c51' || e.recId === 'c56' || e.recId === 'c58') {
          that.formRecord[e.recId] = []
          if (e.labValue === '/' || e.labValue == null || e.labValue == '') {
            return
          }
          that.formRecord[e.recId] = e.labValue.replace(/\s+/g, '').split(';')
        } else if (e.recId === 'c24' || e.recId === 'c26' || e.recId === 'c28' || e.recId === 'c33' || e.recId === 'c38' || e.recId === 'c125') {
          if (e.labValue !== '有霜' || e.labValue !== '无霜') {
            that.formRecord[e.recId] = e.labValue
          } else {

          }
        } else {
          if (e.labValue === '/' || e.labValue == null || e.labValue == '') {
            that.formRecord[e.recId] = ''
          } else {
            // let labVal = e.labValue.replace(/（/g,'(').replace(/）/g,')')
            let labVal = e.labValue
            if (e.recId === 'c7') {
              if (parseInt(labVal) !== 1 && parseInt(labVal) !== 2 && parseInt(labVal) !== 3 && parseInt(labVal) !== 4 && parseInt(labVal) !== 5) {
                that.formRecord[e.recId] = '1'
              } else {
                that.formRecord[e.recId] = parseInt(labVal).toString()
              }
            } else if (e.recId === 'c20' && isNaN(labVal)) {
              that.formRecord[e.recId] = new Date()
            } else if (e.recId === 'c1' || e.recId === 'c2' || e.recId === 'c3') {
              console.log(e.labValue)
              that.formRecord[e.recId] = e.labValue
            } else {
              that.formRecord[e.recId] = labVal
            }
          }
        }
      })
    },
    count43 () {
      let count_b = 0
      let vv = Math.pow(10, 1)
      if (!isNaN(this.formRecord.c25)) {
        count_b += Number(this.formRecord.c25)
      }
      if (!isNaN(this.formRecord.c27)) {
        count_b += Number(this.formRecord.c27)
      }
      if (!isNaN(this.formRecord.c30)) {
        count_b += Number(this.formRecord.c30)
      }
      if (!isNaN(this.formRecord.c35)) {
        count_b += Number(this.formRecord.c35)
      }
      if (!isNaN(this.formRecord.c40)) {
        count_b += Number(this.formRecord.c40)
      }
      if (!isNaN(this.formRecord.c126)) {
        count_b += Number(this.formRecord.c126)
      }
      count_b = Math.round(count_b * vv) / vv
      this.formRecord.c43 = count_b
    },
    count123 () {
      let count_s = 0
      let vv = Math.pow(10, 1)
      if (!isNaN(this.formRecord.c82)) {
        count_s += Number(this.formRecord.c82)
      }
      if (!isNaN(this.formRecord.c84)) {
        count_s += Number(this.formRecord.c84)
      }
      if (!isNaN(this.formRecord.c86)) {
        count_s += Number(this.formRecord.c86)
      }
      if (!isNaN(this.formRecord.c88)) {
        count_s += Number(this.formRecord.c88)
      }
      if (!isNaN(this.formRecord.c90)) {
        count_s += Number(this.formRecord.c90)
      }
      if (!isNaN(this.formRecord.c127)) {
        count_s += Number(this.formRecord.c127)
      }
      count_s = Math.round(count_s * vv) / vv
      this.formRecord.c123 = count_s
    },

    showConfirm () {
      let _this = this
      let pageType = _this.pageType
      if (_this.uploadParam.filePath24 === '') {
        _this.$Message.warning('请上传产品正面图片！')
        return false
      }
      if (_this.uploadParam.filePath76 === '') {
        _this.$Message.warning('请上传铭牌图片！')
        return false
      }
      // if (_this.$store.state.app.oem &&_this.uploadParam.filePath26 === '') {
      //   _this.$Message.warning('请上传oem声明！')
      //   return false
      // }
      if (pageType === 'extend' || pageType === 'update') {
        if (_this.formRecord.ec_master_kuozhan_text === '') {
          let text = pageType === 'extend' ? '扩展' : '变更'
          _this.$Message.warning('请填写' + text + '申请书！')
          return
        }
        // }else {
        //    _this.modal1 = true;
        // }
      }

      _this.count43()
      _this.count123()

      this.$refs['formRecord'].validate((valid) => {
        if (valid) {
          if (_this.confirmData.join('') == 1) {
            if (pageType !== 'extend') {
              _this.boolFlag = _this.diffRecord(_this.$store.state.app.defaultData, _this.formRecord)
            }
            _this.$store.state.app.subDisabled = true
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
              if (v.recId == 'c7') {
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
      if (!this.$store.state.app.subDisabled){
        return false
      }
      this.$store.state.app.subDisabled = false
      let _this = this
      let pageType = _this.pageType
      _this.formRecord.c20 = _this.formatDate(this.formRecord.c20)
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
      _this.formRecord.id = this.formRecord.id || _this.$store.state.app.updateId || 0
      if (pageType === 'extend' || pageType === 'update') {
        let submitUrl = pageType === 'extend' ? '/marking/saveExpand.do?action_token='+_this.action_token : '/marking/saveChange.do?action_token='+_this.action_token
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
          } else if (res.data.msg) {
            _this.$Message.warning(res.data.msg)
            _this.saveDisabled = false
          } else {
            _this.$Message.warning(res.data.message)
            // _this.submitDisabled = false
          }
          if (res.data.result_code !== '1'){
            axios.get('/ads/getToken.do').then(res => {
              that.$store.state.app.action_token = res.data.action_token
            })
          }
        })
      } else {
        axios({
          url: '/marking/save.do?action_token='+this.action_token,
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
          } else if (res.data.msg) {
            _this.$Message.warning(res.data.msg)
            _this.saveDisabled = false
          } else {
            _this.$Message.warning(res.data.message)
            _this.submitDisabled = false
          }
          if (res.data.result_code !== '1'){
            axios.get('/ads/getToken.do').then(res => {
              that.$store.state.app.action_token = res.data.action_token
            })
          }
        })
      }
    },
    /* 保存草稿箱 */
    saveRecord () {
      let _this = this
      _this.saveDisabled = true
      _this.formRecord.c20 = _this.formatDate(this.formRecord.c20)
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
        url: '/marking/saveDraft.do?action_token='+_this.action_token,
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
          } else if (res.data.msg) {
            _this.$Message.warning(res.data.msg)
            _this.saveDisabled = false
          } else {
            _this.$Message.warning(res.data.message)
            _this.saveDisabled = false
          }
          if (res.data.result_code !== '1'){
            axios.get('/ads/getToken.do').then(res => {
              that.$store.state.app.action_token = res.data.action_token
            })
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
    getFile (res, file, id) {
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
    disabledoff () {
      return this.pageType === 'extend' || this.pageType === 'view'
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
    disabled25 () {
      return this.formRecord.c24 !== '有霜' && this.formRecord.c24 !== '无霜' && this.$store.state.app.requiredStr.indexOf('c25,') === -1
    },
    disabled27 () {
      return this.formRecord.c26 !== '有霜' && this.formRecord.c26 !== '无霜' && this.$store.state.app.requiredStr.indexOf('c27,') === -1
    },
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
    extendRule() {
      return {
        c4: [
          {
            trigger: 'change,blur', required: true,
            message: '产品规格型号不能为空'
          },
          {
            validator: (rule, value, callback) => {
              this.pageType === 'extend' && this.mainModel === this.formRecord.c4? callback('扩展备案需要变更型号名称') : callback()
            },
            trigger: 'change,blur'
          }
        ]
      }
    },
    ruleRecord () {
      let decimal1 = /^(([1-9]{1}\d*)|(0{1}))(\.\d{1})$/
      let decimal2 = /^(([1-9]{1}\d*)|(0{1}))(\.\d{2})$/
      let decimal3 = /^(([1-9]{1}\d*)|(0{1}))(\.\d{3})$/
      // 能效等级
      let nxdjch = this.formRecord.c7
      // 类型
      let lx = this.formRecord.c21
      // 标准能效指数额定值
      let c11 = parseFloat(this.formRecord.c11)
      // 标准能效指数实测值
      let c12 = parseFloat(this.formRecord.c12)
      // 综合耗电量额定值
      let c14 = parseFloat(this.formRecord.c14)
      // 综合耗电量实测值
      let c15 = parseFloat(this.formRecord.c15)
      // 综合能效指数额定值
      let c17 = parseFloat(this.formRecord.c17)
      // 综合能效指数实测值
      let c18 = parseFloat(this.formRecord.c18)
      // 总容积额定值
      let c43 = this.formRecord.c43
      // 总容积实测值
      let c123 = this.formRecord.c123
      // 标准耗电量额定值
      let c8 = parseFloat(this.formRecord.c8)
      // 标准耗电量实测值
      let c9 = parseFloat(this.formRecord.c9)

      const threeDecimals = (rule, vaule, callback) => {
        decimal3.test(vaule) ? callback() : callback('三位小数')
      }
      const twoDecimals = (rule, vaule, callback) => {
        decimal2.test(vaule) ? callback() : callback('两位小数')
      }
      const oneDecimals = (rule, vaule, callback) => {
        decimal1.test(vaule) ? callback() : callback('一位小数')
      }
      const checkc9 = (rule, vaule, callback) => {
        if (c9 > c8 * 1.15) {
          callback('标准耗电量实测值不应大于其额定值的 115%')
        } else {
          callback()
        }
      }
      const checkc12 = (rule, value, callback) => {
        if (c12 > c11 * 1.05) {
          callback('标准能效指数实测值不大于额定值的105%')
        } else {
          callback()
        }
      }
      const checkc15 = (rule, value, callback) => {
        if (lx === '冷藏冷冻箱') {
          if (c15 > c14 * 1.15) {
            callback('综合耗电量值实测不应大于其额定值的 115%')
          } else {
            callback()
          }
        } else {
          callback()
        }
      }
      const checkc18 = (rule, value, callback) => {
        if (lx === '冷藏冷冻箱') {
          if (c18 > c17 * 1.05) {
            callback('综合能效指数实测值不大于额定值的105%')
          } else {
            callback()
          }
        } else {
          callback()
        }
      }
      const checkc123 = (rule, value, callback) => {
        if (c43 > c123) {
          let dc = c43 - c123
          let c = 0
          if (c43 * 0.03 < 1) {
            c = 1
          } else {
            c = c43 * 0.03
          }
          if (dc > c) {
            callback('当总容积的实测值小于额定值时，实测值与额定值的差值不应大于额定值的3%或1L（取较大值）')
          } else {
            callback()
          }
        } else {
          callback()
        }
      }
      const checkc11 = (rule, value, callback) => {
        // 能效等级校验
        let nxdj = ''
        let rangec11 = ''
        let rangec17 = ''
        if (lx == '冷藏冷冻箱') {
          let nxdj1 = ''
          let nxdj2 = ''
          // 标准能效指数
          if (c11 <= 25) {
            nxdj1 = '1'
          } else if (c11 > 25 && c11 <= 35) {
            nxdj1 = '2'
          } else if (c11 > 35 && c11 <= 50) {
            nxdj1 = '3'
          } else if (c11 > 50 && c11 <= 60) {
            nxdj1 = '4'
          } else if (c11 > 60 && c11 <= 70) {
            nxdj1 = '5'
          } else {
            nxdj1 = ''
          }
          switch (nxdjch) {
            case '1' : rangec11 = '<= 25'; break
            case '2' : rangec11 = '>25或<=35'; break
            case '3' : rangec11 = '>35或<=50'; break
            case '4' : rangec11 = '>50或<=60'; break
            case '5' : rangec11 = '>60或<=70'; break
          }
          // 综合能效指数
          if (c17 <= 50) {
            nxdj2 = '1'
          } else if (c17 > 50 && c17 <= 60) {
            nxdj2 = '2'
          } else if (c17 > 60 && c17 <= 70) {
            nxdj2 = '3'
          } else if (c17 > 70 && c17 <= 80) {
            nxdj2 = '4'
          } else if (c17 > 80 && c17 <= 90) {
            nxdj2 = '5'
          } else {
            nxdj2 = ''
          }
          switch (nxdjch) {
            case '1' : rangec17 = '<=50'; break
            case '2' : rangec17 = '>50或<=60'; break
            case '3' : rangec17 = '>60或<=70'; break
            case '4' : rangec17 = '>70或<=80'; break
            case '5' : rangec17 = '>80或<=90'; break
          }
          if (nxdj1 == '' || nxdj2 == '') {
            nxdj = ''
          } else if (nxdj1 > nxdj2) {
            nxdj = nxdj1
          } else {
            nxdj = nxdj2
          }
        } else if (lx == '葡萄酒储藏柜') {
          if (c11 <= 55) {
            nxdj = '1'
          } else if (c11 > 55 && c11 <= 70) {
            nxdj = '2'
          } else if (c11 > 70 && c11 <= 80) {
            nxdj = '3'
          } else if (c11 > 80 && c11 <= 90) {
            nxdj = '4'
          } else if (c11 > 90 && c11 <= 100) {
            nxdj = '5'
          } else {
            nxdj = ''
          }
          switch (nxdjch) {
            case '1' : rangec11 = '<=55'; break
            case '2' : rangec11 = '>55或<=70'; break
            case '3' : rangec11 = '>70或<=80'; break
            case '4' : rangec11 = '>80或<=90'; break
            case '5' : rangec11 = '>90或<=100'; break
          }
        } else if (lx == '卧式冷藏冷冻柜') {
          if (c11 <= 35) {
            nxdj = '1'
          } else if (c11 > 35 && c11 <= 45) {
            nxdj = '2'
          } else if (c11 > 45 && c11 <= 55) {
            nxdj = '3'
          } else if (c11 > 55 && c11 <= 65) {
            nxdj = '4'
          } else if (c11 > 65 && c11 <= 75) {
            nxdj = '5'
          } else {
            nxdj = ''
          }
          switch (nxdjch) {
            case '1' : rangec11 = '<=35'; break
            case '2' : rangec11 = '>35或<=45'; break
            case '3' : rangec11 = '>45或<=55'; break
            case '4' : rangec11 = '>55或<=65'; break
            case '5' : rangec11 = '>65或<=75'; break
          }
        } else {
          if (c11 <= 45) {
            nxdj = '1'
          } else if (c11 > 45 && c11 <= 55) {
            nxdj = '2'
          } else if (c11 > 55 && c11 <= 65) {
            nxdj = '3'
          } else if (c11 > 65 && c11 <= 75) {
            nxdj = '4'
          } else if (c11 > 75 && c11 <= 85) {
            nxdj = '5'
          } else {
            nxdj = ''
          }
          switch (nxdjch) {
            case '1' : rangec11 = '<=45'; break
            case '2' : rangec11 = '>45或<=55'; break
            case '3' : rangec11 = '>55或<=65'; break
            case '4' : rangec11 = '>65或<=75'; break
            case '5' : rangec11 = '>75或<=85'; break
          }
        }
        // if (nxdj == "") {
        //   callback("能效数据不在备案范围(标准能效指数需" + rangec11 + ")")
        // }
        if (nxdjch != nxdj) {
          if (lx === '冷藏冷冻箱') {
            callback('所选能效等级与计算结果(' + nxdj + '级)不符！标准能效指数额定值需' + rangec11 + ',综合能效指数额定值需' + rangec17)
          } else {
            callback('所选能效等级与计算结果(' + nxdj + '级)不符！标准能效指数额定值需' + rangec11)
          }
        } else {
          callback()
        }
      }
      const checkc17 = (rule, value, callback) => {
        // 能效等级校验
        let nxdj = ''
        let rangec11 = ''
        let rangec17 = ''
        if (lx === '冷藏冷冻箱') {
          let nxdj1 = ''
          let nxdj2 = ''
          // 标准能效指数
          if (c11 <= 25) {
            nxdj1 = '1'
          } else if (c11 > 25 && c11 <= 35) {
            nxdj1 = '2'
          } else if (c11 > 35 && c11 <= 50) {
            nxdj1 = '3'
          } else if (c11 > 50 && c11 <= 60) {
            nxdj1 = '4'
          } else if (c11 > 60 && c11 <= 70) {
            nxdj1 = '5'
          } else {
            nxdj1 = ''
          }
          rangec11 = '<=70'
          // 综合能效指数
          if (c17 <= 50) {
            nxdj2 = '1'
          } else if (c17 > 50 && c17 <= 60) {
            nxdj2 = '2'
          } else if (c17 > 60 && c17 <= 70) {
            nxdj2 = '3'
          } else if (c17 > 70 && c17 <= 80) {
            nxdj2 = '4'
          } else if (c17 > 80 && c17 <= 90) {
            nxdj2 = '5'
          } else {
            nxdj2 = ''
          }
          switch (nxdjch) {
            case '1' : rangec17 = '<=50'; break
            case '2' : rangec17 = '>50或<=60'; break
            case '3' : rangec17 = '>60或<=70'; break
            case '4' : rangec17 = '>70或<=80'; break
            case '5' : rangec17 = '>80或<=90'; break
          }
          if (nxdj1 == '' || nxdj2 == '') {
            nxdj = ''
          } else if (nxdj1 > nxdj2) {
            nxdj = nxdj1
          } else {
            nxdj = nxdj2
          }
        } else {
          callback()
        }
        // if (nxdj === "") {
        //   callback("能效数据不在备案范围(综合能效指数额定值需" + rangec17 + ")")
        // }
        if (nxdjch !== nxdj) {
          callback('所选能效等级与计算结果(' + nxdj + '级)不符！综合能效指数额定值需' + rangec17)
        } else {
          callback()
        }
      }
      const checkc25 = (rule, value, callback) => {
        if (this.$store.state.app.requiredStr.indexOf('c25,') > -1 && this.formRecord.c25 === '') {
          callback('模板要求必填')
        } else {
          callback()
        }
      }
      const checkc27 = (rule, value, callback) => {
        if (this.$store.state.app.requiredStr.indexOf('c27,') > -1 && this.formRecord.c27 === '') {
          callback('模板要求必填')
        } else {
          callback()
        }
      }
      return {
        c1: [
          {
            required: true,
            message: '不能为空'
          }
        ],
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
        c4: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c21: [
          {
            required: true,
            message: '不能为空'
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
            validator: twoDecimals,
            trigger: 'blur'
          }
        ],
        c14: [
          {
            required: this.formRecord.c21 === '冷藏冷冻箱',
            message: '请填写额定值'
          },
          {
            validator: (this.formRecord.c21 === '冷藏冷冻箱' && twoDecimals),
            trigger: 'blur'
          }
        ],
        c9: [
          {
            required: this.formRecord.c21 !== '',
            message: '请填写实测值'
          },
          {
            validator: checkc9,
            trigger: 'blur'
          },
          {
            validator: threeDecimals,
            trigger: 'blur'
          }
        ],
        c12: [
          {
            required: this.formRecord.c21 !== '',
            message: '请填写实测值'
          },
          {
            validator: checkc12,
            trigger: 'blur'
          },
          {
            validator: threeDecimals,
            trigger: 'blur'
          }
        ],
        c15: [
          {
            required: this.formRecord.c21 === '冷藏冷冻箱',
            message: '请填写实测值'
          },
          {
            validator: checkc15,
            trigger: 'blur'
          },
          {
            validator: (this.formRecord.c21 === '冷藏冷冻箱' && threeDecimals),
            trigger: 'blur'
          }
        ],
        c18: [
          {
            required: this.formRecord.c21 === '冷藏冷冻箱',
            message: '请填写实测值'
          },
          {
            validator: checkc18,
            trigger: 'blur'
          },
          {
            validator: (this.formRecord.c21 === '冷藏冷冻箱' && threeDecimals),
            trigger: 'blur'
          }
        ],
        c11: [
          {
            required: this.formRecord.c21 !== '',
            message: '请填写额定值'
          },
          {
            validator: checkc11,
            trigger: 'blur'
          },
          {
            validator: oneDecimals,
            trigger: 'blur'
          }
        ],
        c17: [
          {
            required: this.formRecord.c21 === '冷藏冷冻箱',
            message: '请填写额定值'
          },
          {
            validator: checkc17,
            trigger: 'blur'
          },
          {
            validator: (this.formRecord.c21 === '冷藏冷冻箱' && oneDecimals),
            trigger: 'blur'
          }
        ],
        c82: [
          {
            required: this.formRecord.c24 === '有霜' || this.formRecord.c24 === '无霜',
            message: '不能为空'
          },
          {
            validator: oneDecimals,
            trigger: 'blur'
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
            validator: oneDecimals,
            trigger: 'blur'
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
          }
          /* {
            validator: oneDecimals,
            trigger: 'blur'
          } */
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
          }
          /* {
            validator: oneDecimals,
            trigger: 'blur'
          } */
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
          }
          /* {
            validator: oneDecimals,
            trigger: 'blur'
          } */
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
            message: '不能为空'
          }
          /* {
            validator: oneDecimals,
            trigger: 'blur'
          } */
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
        c23: [
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
            required: this.formRecord.c51.join('').indexOf('其它') > -1,
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
            required: this.formRecord.c56.join('').indexOf('其它') > -1,
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
            required: this.formRecord.c58.join('').indexOf('其它') > -1,
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
          },

          {
            validator: checkc123,
            trigger: 'blur'
          }
        ],
        c20: [
          {
            required: true,
            message: '不能为空'
          }
        ],
        c25: [
          {
            required: this.$store.state.app.requiredStr.indexOf('c25,') > -1,
            message: '模板要求不能为空'
          }
        ],
        c27: [
          {
            required: this.$store.state.app.requiredStr.indexOf('c27,') > -1,
            message: '模板要求不能为空'
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
/deep/  #table4  .ivu-form-item-content{ display: flex;}
.part{
  background:#eee;
  padding: 15px;
  margin: 15px 0;
}
.lookPdf{

  margin: 40px auto;
  display: block;
  border: 1px solid #ccc;
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
  margin-right: 5px;
}
.submitTips{
  font-size:16px;font-weight: bolder; text-align: center
}
#table1 td,#table2 td,#table3 td,#table4 td{
  padding:20px 10px;
}
#table1 .ivu-form-item,#table2 .ivu-form-item,#table3 .ivu-form-item,#table4 .ivu-form-item,#table5 .ivu-form-item{
  margin-bottom:0!important;
}
#table2 .ivu-form-item,#table3 .ivu-form-item,#table4 .ivu-form-item,#table5 .ivu-form-item{
  display:inline-block;
}

.ivu-icon-ios-help-circle-outline{
  position:absolute;
  top:-8px;
  right:-2px;
  display: none;
}
.ivu-icon-ios-help-circle-outline:before{
  content:"\F446";
}
.diffList { margin:20px 0;}
.diffList table{
  width: 100%;
}
.lookOver{
  margin-bottom: 10px;
}
.org, .basic-info dl{
    font-size: 16px;
}
.basic-info .valid{ width: 100%;margin: 10px 0;}
.textarea-annotation,.color-red{
    font-weight: normal;
    font-size: 14px;
}
.color-red{
    color: red;
}
.pro-info, .basic-info .record-number {
    height: auto;
    line-height: 24px;
}
.basic-info span[class^="f-"],.pro-info span[class^="f-"]{
    font-weight: bold;
    padding: 0px 5px;
}
.application{ margin: 10px 0;}
.regress span{
  display:inline-block;
  width: 14px;
  height: 14px;
  margin-right: 10px;
  border: 1px solid #2b85e4;
}
.regress .bgs{
  background-color: #2b85e4;
}

</style>
