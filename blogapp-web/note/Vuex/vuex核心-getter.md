### Getter
>取值器，对要去数据进行过滤等操作
~~~
 getters: {
    doneTodos: state => {
      return state.todos.filter(todo => todo.done)
    }
  }
  store.getters.doneTodos // -> [{ id: 1, text: '...', done: true }]
~~~
### mapGetters 辅助函数
~~~
...mapGetters({
  // 把 `this.doneCount` 映射为 `this.$store.getters.doneTodosCount`
  doneCount: 'doneTodosCount'
})
~~~