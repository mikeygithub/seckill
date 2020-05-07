import Vue from 'vue'
import App from './App.vue'
import VueCookie from 'vue-cookie'            // api: https://github.com/alfhen/vue-cookie
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
//http
import {http, httpFile} from '@/http/httpRequest' // api: https://github.com/axios/axios
//route
import router from '@/router/router'
Vue.prototype.$http = http // ajax请求方法
Vue.prototype.$httpFile = httpFile // ajax请求方法
// 一些默认的参数

Vue.use(ElementUI);
Vue.use(VueCookie);
Vue.config.productionTip = false

//example
new Vue({
  router,
  render: h => h(App),
}).$mount('#app')
