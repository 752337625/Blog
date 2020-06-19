<template>
	<header id="page-header">
		<slot name="search"></slot>
	</header>
</template>
<script>
	export default {
		data( ) {
			return {}
		},
		methods: {},
	};
</script>
<style lang="less" scoped="scoped">
	#page-header {
		position: fixed;
		top: 0;
		left: 0;
		right: 0;
		z-index: 1000;
		background-color: rgb(255, 133, 42);
	}
</style>
