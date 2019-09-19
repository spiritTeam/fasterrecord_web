
<template>
    <Card :bordered="false">
        <p slot="title">
            内容列表
        </p>
        <div style="margin-bottom: 10px">
            <Input v-model="search.functionName" style="width:200px" placeholder="请输入功能名称"></Input>
            <Input v-model="search.action" style="width:200px" placeholder="请输入请求路径"></Input>

            <Button @click="searchSubmit" type="primary">搜索</Button>
            <!--<Button @click=""   type="primary">新增内容</Button>-->
        </div>
        <Table  border :columns="columns"  :data="data6"></Table>
        <Page :total="totals"
              @on-change="changeList"
              style="margin-top:10px; text-align: right">
        </Page>


    </Card>

</template>
<script>
    import axios from 'axios';
    export default {
        name: 'functionManage',
        data () {
            const detalBtn=(h,params)=>h('Button', {
                props: {
                    type: 'primary',
                    size: 'small'
                },
                style: {
                    marginRight: '5px'
                },
                on: {
                    click: () => {
                    this.show(params.row.id)
                }
            }
        }, '编辑');

        const updateBtn=(h,params)=>h('Button', {
            props: {
                type: 'primary',
                size: 'small'
            },
            style: {
                marginRight: '5px'
            },
            on: {
                click: () => {
                    //console.log(params)
                    this.roleHandle(params.row.id);
                    this.modal=true;
                }
            }
        }, '角色分配');
            const delBtn=(h,params)=>h('Button', {
                props: {
                    type: 'error',
                    size: 'small'
                },
                on: {
                    click: () => {
                    this.remove(params.index,params.row)
            }
        }
        }, '删除');
            return {
                totals:10,
                search:{
                    functionName:'',
                    action:''
                },
                columns: [
                    {
                        type: 'index',
                        width: 60,
                        align: 'center',
                        title:'编号'
                    },
                    {
                        title: 'ID',
                        key: 'id',

                    },
                    {
                        title: '父ID',
                        key: 'parentId'
                    },
                    {
                        title: '功能名称',
                        key: 'title'
                    },
                    {
                        title: '请求路径',
                        key: 'path',
                        width:300,
                    },
                    {
                        title: '排序',
                        key: 'desc'
                    },
                    {
                        title: '操作',
                        key: 'action',
                        align:'center',
                        render: (h, params) => {
                            return h('div', [
                                //detalBtn(h,params),
                                //params.row.state=='1'?pubDetailBtn(h,params):'',
                                //previewBtn(h,params),
                                //updateBtn(h,params),
                                delBtn(h,params)
                            ]);
                        }
                    }
                ],
                data6:[]
            }
        },
        methods: {
            handleChange(date){
                this.search.date= date;
            },
            searchSubmit(){
                axios({
                    url:'/function/list.do',
                    params:this.search
                }).then(res=>{
                    this.totals=res.data.total;
                    this.data6=res.data.list
                })
            },
            show (index) {

            },
            remove (index,delMsg) {
                this.$Modal.confirm({
                        title: '删除',
                        content: '是否确定删除？',
                        onOk: () => {
                            axios({
                                url:'/function/delete.do',
                                params:{
                                    id:delMsg.id,
                                    loginName:delMsg.loginName
                                }
                            }).then((res)=>{
                            if(res.data.result){
                                this.data6.splice(index, 1);
                            }else{
                                this.$Message.warning('操作失败');
                            }
                        })
            },
                onCancel: () => {
                    //this.$Message.info('Clicked cancel');
                }
            });

            },
            reqData:function () {
                axios.get('/function/list.do').then((res) => {
                    //console.log(res);
                    //res 为成功回调的响应
                    this.totals=res.data.total;
                    this.data6=res.data.list;
                });
            },
            changeList(pNum){
                axios.get('/function/list.do?pageNum='+pNum).then((res) => {
                    //res 为成功回调的响应
                    this.totals=res.data.total;
                this.data6=res.data.list
            });
            }
        },
        mounted:function(){
            this.reqData();

        }
    }
</script>

