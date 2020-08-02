module.exports = {
	plugins: {
		autoprefixer: {
			browsers: [ 'Android >= 4.0', 'iOS >= 5' ],
		},
		'postcss-pxtorem': {
			rootValue: 37.5,
			propList: [ '*' ],//使用默认设置，仅定位与字体相关的属性。所以配置这个属性将所有以PX为单位的转化为rem。淘宝以IPhone6为图
			exclude: /node_modules/i
		},
	},
};
