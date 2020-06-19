<template>
	<div class="tb_1">
		<Header>
			<template v-slot:search>
				<div class="header-bd">
					<van-nav-bar @click-right="onClickRight">
						<template #title>
							<van-field v-model="text" clearable label-width="50px" label-class="label-class" label="宝贝" autofocu />
						</template>
						<template #right>
							<p>取消</p>
						</template>
					</van-nav-bar>
				</div>
			</template>
		</Header>
	</div>
</template>
<script>
	import Header from '../components/Header'
	export default {
		data( ) {
			return {
				count: 0,
				text: ''
			}
		},
		components: {
			Header
		},
		methods: {
			onClickLeft( ) {},
			onClickRight( ) {
				this.$router.push( {
					path: 'Tbm'
				} )
			},
		},
	}
</script>
<style lang="less" scoped="scoped">
	.page-container {
		padding-top: 0
	}

	.tb_1 {
		height: 100%;
		width: 100%;

		.van-icon {
			font-size: 1.25rem;
		}

		.van-nav-bar {
			height: 2.3125rem;
			padding: 0.2rem 0;
		}

		.van-cell {
			font-size: 0.875rem;
		}

		.van-field {
			background-color: #e3e3e5;
			height: 100%;
			padding: 0.2rem 0.42667rem;
			border-radius: 0.25rem;
		}
	}
</style>
