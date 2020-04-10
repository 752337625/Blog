import Vue from 'vue'
import App from './App.vue'
import router from './router'
import './plugins/element.js'
import "core-js/stable";
import "regenerator-runtime/runtime";

import { fontRate } from './assets/js/comment.js'
import { date } from './assets/js/date.js'
//全局样式
import './assets/css/global.css'
//全局iconfont
import './assets/fonts/iconfont.css'

//axios
import qs from 'qs'
import axios from './assets/js/axios'

// //自定义事件时间modul
// import{date} from './assets/js/date'
Vue.prototype.$date = date
Vue.prototype.$http = axios
Vue.prototype.$qs = qs
Vue.prototype.$fontRate = fontRate
Vue.config.productionTip = false
new Vue({
    router,
    render: h => h(App)
}).$mount('#app')