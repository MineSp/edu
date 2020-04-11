// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'



Vue.prototype.setCookie = function (c_name, value, expiredays) {
  var exdate = new Date()
  exdate.setDate(exdate.getDate() + expiredays)
  document.cookie = c_name + "=" + escape(value) +
    ((expiredays == null) ? "" : ";expires=" + exdate.toGMTString())
};


//获取cookie

Vue.prototype.getCookie = function (c_name) {
  if (document.cookie.length > 0) {
    var c_start = document.cookie.indexOf(c_name + "=")
    if (c_start != -1) {
      c_start = c_start + c_name.length + 1
      var c_end = document.cookie.indexOf(";", c_start)
      if (c_end == -1) c_end = document.cookie.length
      return unescape(document.cookie.substring(c_start, c_end))
    }
  }
  return ""
}

// Vue.prototype.g_useraccount='';

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
      // username: "用户",
      // isUserLoginIn: false,
      // // test:"",
      // userId: 123456,
      // id_id: -2,
      // id_idname: "游客"
    }
  },
  created() {
  },
})
