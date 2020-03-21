import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '../views/Login'
import Home from '../views/Home'



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
        component: Home
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