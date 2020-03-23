import axios from 'axios'

axios.defaults.baseURL = "http://127.0.0.1:8080/blog/"
    // 请求头拦截
axios.interceptors.request.use(config => {
    //NProgress.start()
    config.headers.Authorization = window.sessionStorage.getItem('token')
    return config
})

/**
 * 创建统一封装过的 axios 实例
 * @return {AxiosInstance}
 */
export default axios