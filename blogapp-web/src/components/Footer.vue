<template>
	<footer id="page-footer">
		<van-tabbar v-model="active" active-color="#FF852A" inactive-color="#000">
			<van-tabbar-item icon="wap-home-o">首页</van-tabbar-item>
			<van-tabbar-item icon="shopping-cart-o">购物车</van-tabbar-item>
			<van-tabbar-item icon="shopping-cart-o">订单列表</van-tabbar-item>
			<van-tabbar-item icon="manager-o">我的淘宝</van-tabbar-item>
			<van-tabbar-item icon="ellipsis">更多</van-tabbar-item>
		</van-tabbar>
	</footer>
</template>
<script>
	export default {
		data( ) {
			return {
				active: 0,
			};
		},
	};
</script>
<style lang="less">
	#page-footer {}
</style>
