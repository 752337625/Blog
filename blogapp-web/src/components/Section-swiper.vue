<template>
	<div class="page-swiper">
		<template>
			<swiper ref="mySwiper" :options="swiperOptions">
				<swiper-slide>Slide 1</swiper-slide>
				<swiper-slide>Slide 2</swiper-slide>
				<swiper-slide>Slide 3</swiper-slide>
				<swiper-slide>Slide 4</swiper-slide>
				<swiper-slide>Slide 5</swiper-slide>
				<swiper-slide>Slide 6</swiper-slide>
				<swiper-slide>Slide 7</swiper-slide>
				<swiper-slide>Slide 8</swiper-slide>
				<swiper-slide>Slide 9</swiper-slide>
				<swiper-slide>Slide 10</swiper-slide>
			</swiper>
		</template>
	</div>
</template>
<script>
	import {
		swiper,
		swiperSlide
	} from 'vue-awesome-swiper'
	import 'swiper/dist/css/swiper.css'
	export default {
		components: {
			swiper,
			swiperSlide,
		},
		data( ) {
			return {
				swiperOptions: {
					slideClass: 'my-slide'
				},
			}
		},
		mounted( ) {},
		methods: {},
		computed: {},
	}
</script>
<style lang="less">
</style>
