// const px2rem = require('postcss-px2rem');
// const postcss = px2rem({
//     remUnit: 75 // 基准大小 baseSize，需要和rem.js中相同
// })

module.exports = {
    chainWebpack: config => {
        // 修复HMR
        config.resolve.symlinks(true);

    },
}