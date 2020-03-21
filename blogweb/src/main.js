import Vue from 'vue'
import App from './App.vue'
import router from './router'
import './plugins/element.js'
//全局样式
import './assets/css/global.css'
//全局iconfont
import './assets/fonts/iconfont.css'
//axios
import axios from 'axios'
axios.defaults.baseURL = "http://127.0.0.1:8080/blog/"
Vue.prototype.$http = axios

Vue.config.productionTip = false

new Vue({
    router,
    render: h => h(App)
}).$mount('#app')