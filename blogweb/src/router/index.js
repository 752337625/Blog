import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '../views/Login'
import Register from '../views/Register'
import Home from '../views/Home'
import BlogOdometer from '../components/pc_components/pc_main_small_components/blogOdometer'
import BlogUser from '../components/pc_components/pc_main_small_components/blogUser'
import BlogUserAdd from '../components/pc_components/pc_main_small_components/blogUserAdd'
import BlogLocationMap from '../components/pc_components/pc_main_small_components/blogLocationMap'
import BlogMenuList from '../components/pc_components/pc_main_small_components/blogMenuList'



Vue.use(VueRouter)

const routes = [{
        path: "*",
        redirect: "Home"
    }, {
        path: "/",
        redirect: "Login"
    },
    {
        path: "/Login",
        component: Login
    },
    {
        path: "/Register",
        component: Register
    },

    {
        path: "/Home",
        component: Home,
        redirect: '/odometer',
        children: [{
                path: '/odometer',
                component: BlogOdometer

            }, {
                path: '/blogUserAdd',
                component: BlogUserAdd
            }, {
                path: '/blogUserList',
                component: BlogUser
            }, {
                path: '/locationMap',
                component: BlogLocationMap
            },
            {
                path: '/mneuList',
                component: BlogMenuList
            },
        ]
    }
]

const router = new VueRouter({
    routes
})
router.beforeEach((to, from, next) => {
    if (to.path === '/Login') return next()
    if (to.path === '/Register') return next()
    let tokenStr = 5
    if (!tokenStr) return next('/Login')
    next()
})

export default router