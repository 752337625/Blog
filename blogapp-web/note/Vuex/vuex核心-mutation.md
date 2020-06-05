## Mutation 

###Mutation基本使用
>>更改 Vuex 的 store 中的状态的唯一方法是提交 mutation。
>>Vuex 中的 mutation 非常类似于事件：每个 mutation 都有一个字符串的 事件类型 (type) 和 一个 回调函数 (handler)。
>>这个回调函数就是我们实际进行状态更改的地方，并且它会接受 state 作为第一个参数
~~~
Mutation:{
	事件类型：字符串    回调函数：function
	increment (state){}
}
~~~
>>你不能直接调用一个 mutation handler。”要唤醒一个 mutation handler，你需要以相应的 type 调用 store.commit 方法：
~~~
store.commit('increment')
~~~

### Mutation的提交合在
~~~
store.commit('increment'，10)；
Mutation:{
	事件类型：字符串    回调函数：function
	increment (state，payload){}
}
~~~
###开发技巧 mapMutation 辅助函数
~~~
你可以在组件中使用 this.$store.commit('xxx') 提交 mutation，或者使用 mapMutations 辅助函数将组件中的 methods 映射为 store.commit 调用（需要在根节点注入 store）。

import { mapMutations } from 'vuex'

export default {
  // ...
  methods: {
    ...mapMutations([
      'increment', // 将 `this.increment()` 映射为 `this.$store.commit('increment')`

      // `mapMutations` 也支持载荷：
      'incrementBy' // 将 `this.incrementBy(amount)` 映射为 `this.$store.commit('incrementBy', amount)`
    ]),
    ...mapMutations({
      add: 'increment' // 将 `this.add()` 映射为 `this.$store.commit('increment')`
    })
  }
}
~~~
