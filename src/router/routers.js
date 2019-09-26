import Main from '@/view/main'

let menuArr = []
menuArr = [
  {
    path: '/',
    name: 'recordMgr',
    redirect: '/home',
    component: Main,
    meta: {
      hideInMenu: true,
      notCache: true
    },
    children: [
      {
        path: 'home',
        name: 'home',
        component: () => import('@/view/single-page/home')
      },
      {
        path: '/addRecord',
        name: 'addRecord',
        meta: {
          hideInMenu: true,
          notCache: true
        },
        component: () => import('@/view/recordMgr/addRecord')
      }
    ]
  },
  // {
  //   path: '/recordMgr',
  //   name: 'recordMgr',
  //   meta: {
  //     icon: 'ios-folder',
  //     title: '产品备案管理'
  //   },
  //   component: Main,
  //   children: [
  //     {
  //       path: '/addRecord',
  //       name: 'addRecord',
  //       meta: {
  //         icon: 'ios-paper-outline',
  //         title: '新增备案'
  //       },
  //       component: () => import('@/view/recordMgr/addRecord.vue')
  //     },
  //     {
  //       path: '/queryRecord',
  //       name: 'queryRecord',
  //       meta: {
  //         icon: 'ios-paper-outline',
  //         title: '备案查询'
  //       },
  //       component: () => import('@/view/recordMgr/queryRecord.vue')
  //     },
  //     {
  //       path: '/draftBox',
  //       name: 'draftBox',
  //       meta: {
  //         icon: 'ios-paper-outline',
  //         title: '草稿箱'
  //       },
  //       component: () => import('@/view/recordMgr/draftBox.vue')
  //     }
  //   ]
  // },
  // ,
  //     {
  //       "path": "/bindAccount",
  //       "name": "bindAccount",
  //       "meta": {
  //         "icon": "ios-paper-outline",
  //         "title": "绑定备案系统账号"
  //       },
  //       "component": "view/enterpriseInfoMgr/bindAccount"
  //     }
  // {
  //   path:'/',
  //   name:'system',
  //   redirect: '/system/userManage',
  //   meta: {
  //     hideInMenu: true,
  //     notCache: true
  //   },
  //   component: Main,
  //   children: [
  //     {
  //       path: 'userManage',
  //       name: 'userManage',
  //       meta: {
  //         hideInMenu: true,
  //         notCache: true
  //       },
  //       component: resolve => { require(['@/view/system/userManage.vue'], resolve); }
  //     }
  //   ]
  // },
  // {
  //   path:'/system',
  //   name:'system',
  //   meta: {
  //     icon:'android-settings',
  //     title:'系统管理'
  //   },
  //   component: Main,
  //   children: [
  //     {
  //       path: 'userManage',
  //       name: 'userManage',
  //       meta: {
  //         title: '用户管理',
  //         icon: 'android-person'
  //       },
  //       component: resolve => { require(['@/view/system/userManage.vue'], resolve); }
  //     },{
  //       path: 'roleManage',
  //       meta: {
  //         title: '角色管理',
  //         icon: 'ios-people'
  //       },
  //       name: 'roleManage',
  //       component: resolve => { require(['@/view/system/roleManage.vue'], resolve); }
  //     },{
  //         path: 'fuctionManage',
  //         meta: {
  //           title: '功能管理',
  //           icon: 'social-buffer'
  //         },
  //         name: 'fuctionManage',
  //         component: resolve => { require(['@/view/system/functionManage.vue'], resolve); }
  //     },
  //   ]
  // },
  {
    path: '/401',
    name: 'error_401',
    component: () => import('@/view/error-page/401.vue')
  },
  {
    path: '/500',
    name: 'error_500',
    component: () => import('@/view/error-page/500.vue')
  },
  // {
  //   path: '*',
  //   name: 'error_404',
  //   component: () => import('@/view/error-page/404.vue')
  // }
]
export default menuArr
