import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '../views/Login'
import Home from '../views/Home'
import Main from '../components/pc_components/blogMain'
import BlogAdd from '../components/pc_components/pc_main_small_components/blogAdd'


Vue.use(VueRouter)

const routes = [{
        path: "/",
        redirect: "Login"
    },
    {
        path: "/Login",
        component: Login
    },
    {
        path: "/Home",
        component: Home,
        redirect: '/Main',
        children: [{
            path: '/Main',
            component: Main
        }, {
            path: '/addBlog',
            component: BlogAdd
        }]
    }

]

const router = new VueRouter({
    routes
})
router.beforeEach((to, from, next) => {
    if (to.path === '/Login') return next()
    const tokenStr = window.sessionStorage.getItem('token')
    if (!tokenStr) return next('/Login')
    next()
})

export default router