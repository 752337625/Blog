import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '../views/Login'
import Home from '../views/Home'
import BlogOdometer from '../components/pc_components/pc_main_small_components/blogOdometer'
import BlogAdd from '../components/pc_components/pc_main_small_components/blogAdd'
import BlogListOperation from '../components/pc_components/pc_main_small_components/blogListOperation'


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
        redirect: '/odometer',
        children: [{
                path: '/odometer',
                component: BlogOdometer
            }, {
                path: '/addBlog',
                component: BlogAdd
            },
            {
                path: '/listOperationBlog',
                component: BlogListOperation
            }
        ]
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