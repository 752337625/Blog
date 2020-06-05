<template>
	<div id="login">
		<div class="login_header">{{$store.state.loginHeader}}</div>
		<div class="login_content">{{$store.state.loginContent}}</div>
		<div class="login_foot">{{$store.state.loginFoot}}</div>
		<br />
		<div class="login_header">{{loginHeader}}</div>
		<div class="login_content">{{loginContent}}</div>
		<div class="login_foot">{{loginFoot}}</div>
		<br />
		<div class="login_header">{{todos}}</div>
		<div class="login_content"></div>
		<div class="login_foot"></div>
		<br />
		<div class="login_header">{{count}}</div>
		<div class="login_content"></div>
		<div class="login_foot"></div>
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
