import Vue from 'vue'
import Router from 'vue-router'
// import HelloWorld from '@/components/HelloWorld'
// import About from '../views/About'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: ()=>import('@/components/HelloWorld')
    },{
      path:'/about',
      name: 'About',
      component: ()=>import('@/views/About')
    },{
      path:'/home',
      name: 'Home',
      component: ()=>import('@/views/Home')
    },
    {
      path:'/test',
      name:'Test',
      component:()=>import('@/views/Test.vue')
    },{
      path:'/test01',
      name:'Test01',
      component:()=>import('@/views/Test01.vue')
    },{
      path:'/dataanylize',
      name:'Dataanylize',
      component:()=>import('@/views/Dataanylize.vue')
    },{
      path:'/menu',
      name:'Menu',
      component:()=>import('@/components/Menu.vue')
    }
  ]
})
