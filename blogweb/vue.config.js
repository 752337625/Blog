// const px2rem = require('postcss-px2rem');
// const postcss = px2rem({
//     remUnit: 75 // 基准大小 baseSize，需要和rem.js中相同
// })

module.exports = {
    chainWebpack: config => {
        // 修复HMR
        config.resolve.symlinks(true);

    },
    configureWebpack: {
        externals: {
            'AMap': 'AMap' // 高德地图配置
        }
    },
    transpileDependencies: [] // 需要编译的依赖包名
}