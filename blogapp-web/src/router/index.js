import Vue from 'vue'
import VueRouter from 'vue-router'
import Tbm from '../views/Tbm'
import Tbs from '../views/Tbs'
Vue.use( VueRouter )
const routes = [ {
	path: "/",
	redirect: "Tbm",
	beforeEnter: ( to, from, next ) => {
		console.log( to, from )
	}
},{
	path:'/Tbm',
	name:'Tbm',
	component:Tbm
},{
	path:'/Tbs',
	name:'Tbs',
	component:Tbs
}]
const router = new VueRouter( {
	mode: 'hash',
	base: process.env.BASE_URL,
	routes
} )
export default router
