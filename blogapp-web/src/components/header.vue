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
<style lang="less">
	@url: '../assets/img/';

	#page-header {
		position: fixed;
		top: 0;
		left: 0;
		right: 0;
		z-index: 1000;
		background-color: rgb(255, 133, 42);

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
