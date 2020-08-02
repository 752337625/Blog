var Home = {
	state: () => ({
		count:0,
		header: '我是header',
		content: '我是content',
		foot: '我是foot',
		todos: [ {
			id: 1,
			text: '...',
			done: true
		}, {
			id: 2,
			text: '...',
			done: false
		} ]
	}),
	mutations: {
		homeincrement( state ) {
			state.count++
		}
	},
	actions: {},
	getters: {
		homeFileterTods(state) {
			return state.todos.filter((item, index) => {
				return item.done
			})
		}
	},
	modules: {}
}
export default Home
