
<template>
    <Card :bordered="false">
        <p slot="title">
            内容列表
        </p>
        <div style="margin-bottom: 10px">
            <Input v-model="search.loginName" style="width:200px" placeholder="请输入账号"></Input>
            <Input v-model="search.displayName" style="width:200px" placeholder="请输入姓名"></Input>

            <Button @click="searchSubmit" type="primary">搜索</Button>
            <!--<Button @click=""   type="primary">新增内容</Button>-->
        </div>
        <Table  border :columns="columns"  :data="data6"></Table>
        <Page :total="totals"
              @on-change="changeList"
              style="margin-top:10px; text-align: right">
        </Page>


        <Modal
            v-model="modal"
            title="角色列表"
            @on-ok="okHandle"
            @on-cancel="">
            <Tree ref="tree" :data="dataTree" show-checkbox></Tree>
        </Modal>
        <Modal
            v-model="resetModal"
            title="重置密码："
            @on-ok="okHandle"
            @on-cancel="">
            密码已重置为：{{resetPassword}}
        </Modal>


    </Card>

</template>
<script>
    import axios from 'axios';
    export default {
        name: 'userManage',
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
        const resetBtn=(h,params)=>h('Button', {
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
                    //this.roleHandle(params.row.id);
                    //this.modal=true;
                    this.resetHandle(params.row.loginName);
                }
            }
        }, '重置密码');
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
                modal:false,
                resetModal:false,
                resetPassword:'',
                currId:0,
                search:{
                    loginName:'',
                    displayName:''
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
                        title: '账号',
                        key: 'loginName'
                    },
                    {
                        title: '姓名',
                        key: 'displayName'
                    },
                    {
                        title: '邮箱',
                        key: 'email'
                    },
                    {
                        title: '电话',
                        key: 'contactPhone'
                    },
                    {
                        title: '操作',
                        key: 'action',
                        width:220,
                        align: 'left',
                        render: (h, params) => {
                            return h('div', [
                                //detalBtn(h,params),
                                //params.row.state=='1'?pubDetailBtn(h,params):'',
                                //previewBtn(h,params),
                                //updateBtn(h,params),
                                resetBtn(h,params)
                                //delBtn(h,params)

                            ]);
                        }
                    }
                ],
                data6:[],
                dataTree:[]
            }
        },
        methods: {
            handleChange(date){
                this.search.date= date;
            },
            okHandle(){

                let nodes=this.$refs.tree.getCheckedNodes();
                let arr=[];
                nodes.map((item,idx)=>{
                    arr.push(item.id);
                })
                axios({
                    url:'/user/checkRoles.do',
                    methods:'POST',
                    params:{
                        id:this.currId,
                        roleIds:arr.join()
                    }
                }).then(res =>{
                    if(res.data.result){
                        this.$Message.info('操作成功');
                    }else{
                        this.$Message.info(res.data.err)
                    }
                })
            },
            searchSubmit(){
                axios({
                    url:'/user/list.do',
                    params:this.search
                }).then(res=>{
                    this.totals=res.data.total;
                    this.data6=res.data.list
                })
            },
            show (index) {

            },
            resetHandle(rowloginname){
                 let cont='是否确定重置<span style="color:red">'+rowloginname+'</span>密码？'
                 this.$Modal.confirm({
                    title: '删除',
                    content:cont,
                    onOk: () => {
                        axios({
                            url:'/user/reset.do',
                            params:{
                                loginName:rowloginname
                            },
                            methods:"get"
                        }).then(res => {
                            if(res.data.result){
                                this.resetModal=true;
                            }else{
                                this.resetModal=false
                            }
                            this.resetPassword=res.data.msg;
                        })
                    },
                    onCancel: () => {
                        //this.$Message.info('Clicked cancel');
                    }
                 })
            },
            roleHandle(rowid){
                this.currId=rowid;
                axios({
                    url:'/user/roleList2.do',
                    params:{
                        id:rowid
                    },
                    methods:"get"
                }).then(res => {
                    this.dataTree=res.data;
                })
            },
            remove (index,delMsg) {
                this.$Modal.confirm({
                        title: '删除',
                        content: '是否确定删除？',
                        onOk: () => {
                            axios({
                                url:'/user/delete.do',
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
                axios.get('/user/list.do').then((res) => {
                    //console.log(res);
                    //res 为成功回调的响应
                    this.totals=res.data.total;
                    this.data6=res.data.list;
                });
            },
            changeList(pNum){
                axios.get('/user/list.do?pageNum='+pNum).then((res) => {
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

