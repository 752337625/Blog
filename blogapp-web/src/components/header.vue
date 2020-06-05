<template>
	<div id="header">
		
	</div>
</template>
<script>
	export default {
		data( ) {
			return {}
		},
		methods: {
			increment( ) {
				this.$store.commit( 'increment' )
				console.log( this.$store.state.count )
			}
		},
	};
</script>
<style lang="less">
</style>