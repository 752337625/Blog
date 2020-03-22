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
import axios from 'axios'
axios.defaults.baseURL = "http://127.0.0.1:8080/blog/"
    // 请求头拦截
axios.interceptors.request.use(config => {
    NProgress.start()
    config.headers.Authorization = window.sessionStorage.getItem('token')
    return config
})
Vue.prototype.$http = axios


Vue.config.productionTip = false

new Vue({
    router,
    render: h => h(App)
}).$mount('#app')