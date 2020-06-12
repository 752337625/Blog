import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import 'lib-flexible/flexible'
import './assets/css/global.css'
import './assets/fonts/iconfont.css'
import './plugins/vant.js'
process.env.NODE_ENV == 'development' ? window.store = store : ''
process.env.NODE_ENV == 'development' ? window.router = router : ''
Vue.config.productionTip = false
new Vue( {
	router,
	store,
	render: h => h( App )
} ).$mount( '#app' )
