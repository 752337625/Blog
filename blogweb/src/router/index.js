import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '../views/Login'
import Register from '../views/Register'
import Home from '../views/Home'
import Resume from '../views/resume'
import BlogOdometer from '../components/pc_components/pc_main_small_components/blogOdometer'
import BlogUser from '../components/pc_components/pc_main_small_components/blogUser'
import BlogUserAdd from '../components/pc_components/pc_main_small_components/blogUserAdd'
import BlogLocationMap from '../components/pc_components/pc_main_small_components/blogLocationMap'
import BlogMenuList from '../components/pc_components/pc_main_small_components/blogMenuList'
import BlogDplayer from '../components/pc_components/pc_main_small_components/blogDplayer.vue'
Vue.use(VueRouter)
const routes = [{
  path: "*",
  redirect: "Home"，,
  beforeEnter: (to, from, next) => {
    // ...
  }
}, {
  path: "/",
  redirect: "Login",
  meta: {
    keepAlive: true
  }
}, {
  path: "/Login",
  component: Login,
  meta: {
    keepAlive: true
  }
}, {
  path: "/Register",
  component: Register,
  meta: {
    keepAlive: true
  }
}, {
  path: "/Resume",
  component: Resume,
  meta: {
    keepAlive: true
  }
}, {
  path: "/Home",
  component: Home,
  redirect: '/odometer',
  children: [{
    path: '/odometer',
    component: BlogOdometer,
    meta: {
      keepAlive: false
    }
  }, {
    path: '/blogUserAdd',
    component: BlogUserAdd,
    meta: {
      keepAlive: false
    }
  }, {
    path: '/blogUserList',
    component: BlogUser,
    meta: {
      keepAlive: false
    }
  }, {
    path: '/locationMap',
    component: BlogLocationMap,
    meta: {
      keepAlive: true
    }
  }, {
    path: '/mneuList',
    component: BlogMenuList,
    meta: {
      keepAlive: false
    }
  }, {
    path: '/dplayer',
    component: BlogDplayer,
    meta: {
      keepAlive: true
    }
  }]
}]
const router = new VueRouter({
  routes
})
router.beforeEach((to, from, next) => {
  if (to.path === '/Login') return next()
  if (to.path === '/Register') return next()
  let token = window.localStorage.getItem('token')
  if (!token) return next('/Login')
  next()
})
router.beforeResolve((to, from, next) => {
  // ...
})
router.afterEach((to, from) => {
  // ...
})

export default router
