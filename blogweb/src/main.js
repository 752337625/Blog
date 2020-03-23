import Vue from 'vue'
import App from './App.vue'
import router from './router'
import './plugins/element.js'
//Layout 布局隐藏
import 'element-ui/lib/theme-chalk/display.css';
//全局样式
import './assets/css/global.css'
//全局iconfont
import './assets/fonts/iconfont.css'
//axios
import axios from './assets/js/axios'
// //自定义事件时间modul
// import{date} from './assets/js/date'
// Vue.prototype.$date = date

Vue.prototype.$http = axios

Vue.config.productionTip = false

new Vue({
    router,
    render: h => h(App)
}).$mount('#app')