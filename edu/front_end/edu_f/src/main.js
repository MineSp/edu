// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'

import axios from 'axios';
Vue.prototype.$axios = axios;

// 引入echarts
import 'echarts/lib/chart/line'

// 引入提示框组件、标题组件、工具箱组件。
import 'echarts/lib/component/tooltip'
import 'echarts/lib/component/title'
import 'echarts/lib/component/toolbox'
import echarts from 'echarts'
Vue.prototype.$echarts = echarts

// 引入ElementUI
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
Vue.use(ElementUI);
Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>',
  data() {
  return {
      // isLoginDailogVisable:false,
      username:"用户",
      isUserLoginIn:false,
      // test:"",
      userId:123456,
      id_id:-2, 
      id_idname:"游客"
    }
  },
})
