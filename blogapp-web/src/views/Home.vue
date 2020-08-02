<template>
	<div class="home">
		<div class="home-header">{{$store.state.Home.header}}</div>
		<div class="home-content">{{$store.state.Home.content}}</div>
		<div class="home-foot">{{$store.state.Home.foot}}</div>
		<br />
		<div class="login-header">{{header}}</div>
		<div class="login-content">{{content}}</div>
		<div class="login-foot">{{foot}}</div>
		<br />
		<div class="login-header">{{fileterTods}}</div>
		
		<br />
		<div class="login-header">{{count}}</div>
		<div class="login-content"></div>
		<div class="login-foot"></div>
		<van-button type="primary" @touchstart="homeincrement">主要按钮</van-button>
	</div>
</template>
<script>
	import {mapState,mapGetters,mapMutations} from 'vuex'
	export default {
		mounted( ) {
			console.log(this.$store)
		},
		methods:{
			...mapMutations({
				homeincrement:'homeincrement'
			})
		},
		computed: {
			...mapState({
				count:state=>state.Home.count,
				header:state=>state.Home.header,
				content:state=>state.Home.content,
				foot:state=>state.Home.foot
			}),
			...mapGetters({
				 fileterTods:'homeFileterTods'
			})
		},
	}
</script>
<style lang="less">
</style>
