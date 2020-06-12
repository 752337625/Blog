<template>
	<section id="page-section">
		<div class="section-items">
			<div class="section-item">
				<section-swiper>
				</section-swiper>
			</div>
			<div class="section-item-foot">
			</div>
		</div>
	</section>
</template>
<script>
	import SectionSwiper from './Section-swiper'
	export default {
		components: {
			SectionSwiper,
		},
		mounted( ) {},
		data( ) {
			return {}
		},
		computed: {},
	}
</script>
<style lang="less" scoped="scoped">
	#page-section {
		width: 100%;
		height: 100%;
		overflow: hidden;

		.section-items {
			height: 625rem;
			position: absolute;
			width: 100%;
		}
	}
</style>
