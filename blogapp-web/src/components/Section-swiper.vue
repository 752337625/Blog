<template>
	<div class="page-swiper">
		<template>
			<swiper :options="swiperOption" ref="mySwiper">
				<swiper-slide>
					<router-link :to="{ name: 'Tbs'}" class="swiper-a"><img src="../assets/img/1.jpg"></router-link>
				</swiper-slide>
				<swiper-slide>
					<router-link :to="{ name: 'Tbs'}" class="swiper-a"><img src="../assets/img/2.jpg"></router-link>
				</swiper-slide>
				<swiper-slide>
					<router-link :to="{ name: 'Tbs'}" class="swiper-a"><img src="../assets/img/3.jpg"></router-link>
				</swiper-slide>
				<swiper-slide>
					<router-link :to="{ name: 'Tbs'}" class="swiper-a"><img src="../assets/img/4.jpg"></router-link>
				</swiper-slide>
				<swiper-slide>
					<router-link :to="{ name: 'Tbs'}" class="swiper-a"><img src="../assets/img/5.jpg"></router-link>
				</swiper-slide>
				<swiper-slide>
					<router-link :to="{ name: 'Tbs'}" class="swiper-a"><img src="../assets/img/6.jpg"></router-link>
				</swiper-slide>
				<swiper-slide>
					<router-link :to="{ name: 'Tbs'}" class="swiper-a"><img src="../assets/img/7.jpg"></router-link>
				</swiper-slide>
				<swiper-slide>
					<router-link :to="{ name: 'Tbs'}" class="swiper-a"><img src="../assets/img/8.jpg"></router-link>
				</swiper-slide>
				<div class="swiper-pagination" slot="pagination"></div>
			</swiper>
		</template>
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
					pagination: {
						el: '.swiper-pagination',
						clickable: true,
						bulletClass: 'my-bullet', //需设置.my-bullet样式
						bulletActiveClass: 'my-bullet-active',
					},
					loop: true, //开启轮播图前后循环模式
					autoplay: true,

				}
			}
		},
		mounted() {}
	}
</script>
<style lang="less" scoped="scoped">
	.page-swiper {
		height: 6.375rem;

		.swiper-a {
			height: 100%;
			width: 100%;
			display: inline-block;

			img {
				width: 100%;
				height: 100%;
			}

		}
	}
</style>
