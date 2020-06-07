<template>
	<div id="login">
		<div class="login-header">{{$store.state.loginHeader}}</div>
		<div class="login-content">{{$store.state.loginContent}}</div>
		<div class="login-foot">{{$store.state.loginFoot}}</div>
		<br />
		<div class="login-header">{{loginHeader}}</div>
		<div class="login-content">{{loginContent}}</div>
		<div class="login-foot">{{loginFoot}}</div>
		<br />
		<div class="login-header">{{todos}}</div>
		<div class="login-content"></div>
		<div class="login-foot"></div>
		<br />
		<div class="login-header">{{count}}</div>
		<div class="login-content"></div>
		<div class="login-foot"></div>
		<van-button type="primary" @touchstart="increment">主要按钮</van-button>
	</div>
</template>
<script>
	import {
		mapState,
		mapGetters,
		mapMutations
	} from 'vuex'
	export default {
		mounted( ) {},
		data( ) {
			return {}
		},
		methods: { ...mapMutations( {
				increment: 'increment'
			} )
		},
		computed: { ...mapState( {
				loginHeader: 'loginHeader',
				loginContent: 'loginContent',
				loginFoot: 'loginContent',
				count: 'count',
			} ),
			...mapGetters( {
				todos: 'fileterTods'
			} )
		},
	};
</script>
<style lang="less">
</style>
