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
import VueQuillEditor from 'vue-quill-editor'

import 'quill/dist/quill.core.css' // import styles
import 'quill/dist/quill.snow.css' // for snow theme
import 'quill/dist/quill.bubble.css' // for bubble theme

Vue.use(VueQuillEditor, /* { default global options } */ )
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