<template>
	<div class="tb_1">
		<Header>
			<template v-slot:search>
				<div class="header-bd">
					<router-link :to="{ name: 'Tbs'}" class="placeholder"><span class="text iconfont iconsearch">寻找宝贝店铺</span></router-link>
				</div>
			</template>
		</Header>
		<Section></Section>
		<Footer></Footer>
	</div>
</template>
<script>
	import Header from '../components/Header'
	import Section from '../components/Section'
	import Footer from '../components/Footer'
	export default {
		data( ) {
			return {
				count: 0
			}
		},
		components: {
			Header,
			Section,
			Footer
		}
	}
</script>
<style lang="less" scoped="scoped">
	.tb_1 {
		height: 100%;
		width: 100%;
		background-color: burlywood;
	}
</style>
