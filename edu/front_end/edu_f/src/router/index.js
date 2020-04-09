import Vue from 'vue'
import Router from 'vue-router'
import Menu from '../components/Menu'
// import HelloWorld from '@/components/HelloWorld'
// import About from '../views/About'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: '消息系统',
      component: Menu,
      children: [
        {
          path: '/massagetable',
          name: '信息列表',
          component: () => import('@/components/msg/MsgTable')
        }
        // }, {
        //   path: '/msgeadd',
        //   name: '信息添加',
        //   component: () => import('@/components/msg/MsgAddPage')
        // },{
        //   path: '/msgAbout',
        //   name: '信息详情',
        //   component: () => import('@/components/msg/MsgAbout')
        // }
      ]
    }, {
      path: '/mark',
      name: '评分系统',
      component: Menu,
      children: [
        {
          path: '/classestable',
          name: '班级列表',
          component: () => import('@/components/mark/ClassesTable')
        }, {
          path: '/coursestable',
          name: '课程列表',
          component: () => import('@/components/mark/CoursesTable')
        }, {
          path: '/workerstable',
          name: '教师列表',
          component: () => import('@/components/mark/WorkersTable')
        }
      ]
    },
    {
      path: '/person',
      name: '个人相关',
      component: Menu,
      children: [
        {
          path: '/personalcenter',
          name: '个人中心',
          component: () => import('@/components/user/PersonalCenter')
        }
      ]
    }, {
      path: '/os',
      name: '系统操作',
      component: Menu,
      children: [
        {
          path: '/indexdbtable',
          name: '指标库',
          component: () => import('@/components/os/IndexdbTable')
        }, {
          path: '/settingpage',
          name: '系统设置',
          component: () => import('@/components/os/SettingPage')
        }
      ]
    }
  ]
})
