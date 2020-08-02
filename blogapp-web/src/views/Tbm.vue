<template>
	<div class="tb_1">
		<Header>
			<template v-slot:search>
				<div class="header-bd">
					<router-link :to="{ name: 'Tbs'}" class="placeholder">
						<span class="text iconfont iconsearch">寻找宝贝店铺</span>
					</router-link>
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
	@url: '../assets/img/';
	.tb_1 {
		height: 100%;
		width: 100%;
		.header-bd {
			width: 100%;
			padding-right: 0.5625rem;
			padding-left: 2.625rem;
			padding-top: 0.375rem;
			padding-bottom: 0.375rem;
			background-image: url("@{url}/tb.png");
			background-size: 1.6875rem 1.25rem;
			background-repeat: no-repeat;
			background-position: 0.5625rem center;
		}
		
		.placeholder {
			display: block;
			font-size: 0px;
			background-color: rgb(255, 78, 34);
			text-align: center;
			border-radius: 4px;
		
			.text {
				height: 1.5625rem;
				line-height: 1.5625rem;
				font-size: 0.8125rem;
				display: inline-block;
				color: rgb(240, 224, 220);
		
				&:before {
					font-size: 0.9375rem;
					display: inline-block;
					color: rgb(255, 255, 255);
					margin-right: 5px;
				}
			}
		}
	}
</style>
