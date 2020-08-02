import axios from 'axios'
axios.defaults.baseURL = "http://localhost:8082/blog/"
axios.defaults.withCredentials = true;
axios.defaults.timeout = 5000;
//axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
//axios.defaults.headers.get['Content-Type'] = 'application/x-www-form-urlencoded';
// 请求头拦截
axios.interceptors.request.use( response => {
  // 在发送请求之前做些什么
  //config.headers.Authorization = window.localStorage.getItem('token')
  return response
}, function ( error ) {
  // 对请求错误做些什么
  return Promise.reject( error );
} );
// 添加响应拦截器
axios.interceptors.response.use( function ( response ) {
  // 对响应数据做点什么
  return response;
}, function ( error ) {
  // 对响应错误做点什么
  return Promise.reject( error );
} );
export default axios
