import Vue from 'vue'
import VueRouter from 'vue-router'
import Tbm from '../views/Tbm'
Vue.use( VueRouter )
const routes = [ {
	path: "/",
	redirect: "Tbm",
	beforeEnter: ( to, from, next ) => {
		console.log( to, from )
	}
},{
	path:'/Tbm',
	component:Tbm
}]
const router = new VueRouter( {
	mode: 'history',
	base: process.env.BASE_URL,
	routes
} )
export default router
