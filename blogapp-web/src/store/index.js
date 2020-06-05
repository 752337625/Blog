import Vue from 'vue'
import Vuex from 'vuex'
import Home from './home'
Vue.use( Vuex )
export default new Vuex.Store( {
	state: {
		count: 0,
		loginHeader: '我是头',
		loginContent: '我是内容',
		loginFoot: '我是尾',
		todos: [ {
			id: 1,
			text: '...',
			done: true
		}, {
			id: 2,
			text: '...',
			done: false
		} ]
	},
	mutations: {
		increment( state ) {
			state.count++
		}
	},
	actions: {},
	getters: {
		fileterTods( state ) {
			return state.todos.filter( ( item, index ) => {
				return item.done
			} )
		}
	},
	modules: {
		Home
	},
} )
