<template>
	<div class="page-grid">
		<div class="kGYGSu"></div>
		<div class="grid-item">
		</div>
	</div>
</template>
<script>
	import {
		Swiper,
		SwiperSlide,
	} from 'vue-awesome-swiper'
	import 'swiper/css/swiper.css'
	export default {
		components: {
			Swiper,
			SwiperSlide
		},
		data() {
			return {
				swiperOption: {
					loop: false, //开启轮播图前后循环模式
					autoplay: false,
					pagination: {
						el: '.swiper-pagination',
						clickable: true,
						bulletClass: 'my-bullet', //需设置.my-bullet样式
						bulletActiveClass: 'my-bullet-active',
					},
					scrollbar:{
						 el: '.swiper-scrollbar',
					},
					

				}
			}
		},
		mounted() {}
	}
</script>
<style lang="less" scoped="scoped">
	@url: '../assets/img/';

	.page-grid {
		height: 11.625rem;
		width: 100%;
		margin-top: -0.625rem;
		position: relative;
		z-index: 100;
		.kGYGSu {
			background-image: url("@{url}/girdTop.png");
			height: 0.625rem;
			width: 100%;
			background-size: 100%;
			margin-bottom: -0.125rem;
			background-repeat: no-repeat;
			background-position: center center;
		}

	}
</style>
