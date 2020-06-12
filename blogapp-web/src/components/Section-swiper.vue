<template>
	<div class="page-swiper">
		<template>
			<swiper :options="swiperOption" ref="mySwiper" >
				<swiper-slide>I'm Slide 1</swiper-slide>
				<swiper-slide>I'm Slide 2</swiper-slide>
				<swiper-slide>I'm Slide 3</swiper-slide>
				<swiper-slide>I'm Slide 4</swiper-slide>
				<swiper-slide>I'm Slide 5</swiper-slide>
				<swiper-slide>I'm Slide 6</swiper-slide>
				<swiper-slide>I'm Slide 7</swiper-slide>
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
				swiperOption: {
				}
			}
		},
		computed: {
			swiper( ) {
				return this.$refs.mySwiper.swiper
			}
		},
		mounted( ) {
			// current swiper instance
			// 然后你就可以使用当前上下文内的swiper对象去做你想做的事了
			console.log( 'this is current swiper instance object', this.swiper )
			this.swiper.slideTo( 3, 1000, false )
		}
	}
</script>
<style lang="less">
</style>
