import { getBreadCrumbList, setTagNavListInLocalstorage, getMenuByRouter, getTagNavListFromLocalstorage, getHomeRoute } from '@/libs/util'
//import routers from '@/router/routers'
import router from '@/router'
export default {
  state: {
    breadCrumbList: [],
    tagNavList: [],
    //homeRoute: getHomeRoute(routers)
    routers:[],
    list: [],
    rid: '',
    barcode:'',
    modelNo: '',
    labName: '',
    defaultData: [],//实验室数据
    ptId: '',
    pltId: '',
    pltPic: '',
    draftData: {},//草稿箱 数据
    requiredStr: '',
    templates:[],//能效二位码模板
    dateinit:'',
    pageType:'',//新增，扩展，变更
    updateId:0,
    gb: '',
    oem:0,
    recordno:'',
    action_token: '',
    subDisabled: false,
  },
  getters: {
    menuList: (state, getters, rootState) => getMenuByRouter(state.routers, rootState.user.access),
    pageType:(state)=>state.pageType,
    recordno:(state)=>state.recordno
  },
  mutations: {
    updateAppRouter (state, routes) {
      state.routers.push(...routes);
      router.addRoutes(routes);
    },
    setRecordNo(state,number){
      state.recordno=number
    },
    setDefaultData (state, list) {
      state.defaultData = list
    },
    setRid (state, id) {
      state.rid = id
    },
    setUpdateId(state,id){
      state.updateId=id;
    },
    setPageType(state,type){
      state.pageType=type
    },
    setDateInit (state, date) {
      state.dateinit = date
    },
    setTemplate (state, arr) {
      state.templates = arr
    },
    setBarcode (state, code) {
      state.barcode = code
    },
    setModelNo (state, model) {
      state.modelNo = model
    },
    setLabName (state, name) {
      state.labName = name
    },
    setPtId (state, id) {
      state.ptId = id
    },
    setPltId (state, id) {
      state.pltId = id
    },
    setPltPic (state, src) {
      state.pltPic = src
    },
    setList (state, list) {
      state.list = list
    },
    setDraftData (state, obj) {
      state.draftData = obj
    },
    setRequiredStr (state, str) {
      state.requiredStr = str
    },
    setGb (state, str) {
      state.gb = str
    },
    setOem(state, num) {
      state.oem = num
    },
    setBreadCrumb (state, routeMetched) {
      state.breadCrumbList = getBreadCrumbList(routeMetched)
    },
    setTagNavList (state, list) {
      if (list) {
        state.tagNavList = [...list]
        setTagNavListInLocalstorage([...list])
      } else state.tagNavList = getTagNavListFromLocalstorage()
    },
    addTag (state, item, type = 'unshift') {
      if (state.tagNavList.findIndex(tag => tag.name === item.name) < 0) {
        if (type === 'push') state.tagNavList.push(item)
        else state.tagNavList.unshift(item)
        setTagNavListInLocalstorage([...state.tagNavList])
      }
    }
  }
}
