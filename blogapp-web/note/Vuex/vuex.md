##为什么使用Vuex？什么时候使用？
~~~
如果您不打算开发大型单页应用，使用 Vuex 可能是繁琐冗余的。
确实是如此——如果您的应用够简单，您最好不要使用 Vuex。
一个简单的 store模式就足够您所需了。
但是，如果您需要构建一个中大型单页应用，您很可能会考虑如何更好地在组件外部管理状态，Vuex 将会成为自然而然的选择。
~~~
##Vuex的核心store（仓库）。
~~~
Vuex的核心store，他包含应用中的大部分状态（state）Vuex 和单纯的全局对象有以下两点不同：
1.Vuex 的状态存储是响应式的。当 Vue 组件从 store 中读取状态的时候，若 store 中的状态发生变化，那么相应的组件也会相应地得到高效更新。
2.你不能直接改变 store 中的状态。改变 store 中的状态的唯一途径就是显式地提交 (commit) mutation。这样使得我们可以方便地跟踪每一个状态的变化，从而让我们能够实现一些工具帮助我们更好地了解我们的应用。
~~~
##使用步骤
~~~
1.安装Vuex 之后，让我们来创建一个 store。创建过程直截了当——仅需要提供一个初始 state 对象和一些 mutations对象：
import Vue from 'vue'
import Vuex from 'vuex'

const store = new Vuex.Store({
  state: {
    count: 0
  },
  mutations: {
    increment (state) {
      state.count++
    }
  }
})
2.为了在 Vue 组件中访问 this.$store property，你需要为 Vue 实例提供创建好的 store。Vuex 提供了一个从根组件向所有子组件，以 store 选项的方式“注入”该 store 的机制：
new Vue({
  el: '#app',
  store,
})
3.现在我们可以从组件的方法提交一个变更：
methods: {
  increment() {
    this.$store.commit('increment')
    console.log(this.$store.state.count)
  }
}
~~~
### 官方强调
~~~
再次强调，我们通过提交 mutation 的方式，而非直接改变 store.state.count，是因为我们想要更明确地追踪到状态的变化。
这个简单的约定能够让你的意图更加明显，这样你在阅读代码的时候能更容易地解读应用内部的状态改变。
此外，这样也让我们有机会去实现一些能记录每次状态改变，保存状态快照的调试工具。
有了它，我们甚至可以实现如时间穿梭般的调试体验。

>由于 store 中的状态是响应式的，在组件中调用 store 中的状态简单到仅需要在计算属性中返回即可。
>触发变化也仅仅是在组件的 methods 中提交 mutation。
~~~