import Vue from 'vue'
import Router from 'vue-router'
import { normalizeURL, decode } from 'ufo'
import { interopDefault } from './utils'
import scrollBehavior from './router.scrollBehavior.js'

<<<<<<< Updated upstream
const _43d35769 = () => interopDefault(import('..\\pages\\acerca-de.vue' /* webpackChunkName: "pages/acerca-de" */))
const _899fa6ea = () => interopDefault(import('..\\pages\\lista.vue' /* webpackChunkName: "pages/lista" */))
const _24f6018c = () => interopDefault(import('..\\pages\\lista-componente.vue' /* webpackChunkName: "pages/lista-componente" */))
const _3c423c82 = () => interopDefault(import('..\\pages\\nuevo.vue' /* webpackChunkName: "pages/nuevo" */))
const _58129b4c = () => interopDefault(import('..\\pages\\index.vue' /* webpackChunkName: "pages/index" */))
=======
const _cdb09dda = () => interopDefault(import('..\\pages\\lista.vue' /* webpackChunkName: "pages/lista" */))
const _2ed2d5b2 = () => interopDefault(import('..\\pages\\lista-componente.vue' /* webpackChunkName: "pages/lista-componente" */))
const _301961df = () => interopDefault(import('..\\pages\\nosotros.vue' /* webpackChunkName: "pages/nosotros" */))
const _80533372 = () => interopDefault(import('..\\pages\\nuevo.vue' /* webpackChunkName: "pages/nuevo" */))
const _9c23923c = () => interopDefault(import('..\\pages\\index.vue' /* webpackChunkName: "pages/index" */))
>>>>>>> Stashed changes

const emptyFn = () => {}

Vue.use(Router)

export const routerOptions = {
  mode: 'history',
  base: '/',
  linkActiveClass: 'nuxt-link-active',
  linkExactActiveClass: 'nuxt-link-exact-active',
  scrollBehavior,

  routes: [{
<<<<<<< Updated upstream
    path: "/acerca-de",
    component: _43d35769,
    name: "acerca-de"
  }, {
=======
>>>>>>> Stashed changes
    path: "/lista",
    component: _899fa6ea,
    name: "lista"
  }, {
    path: "/lista-componente",
    component: _24f6018c,
    name: "lista-componente"
  }, {
    path: "/nosotros",
    component: _301961df,
    name: "nosotros"
  }, {
    path: "/nuevo",
    component: _3c423c82,
    name: "nuevo"
  }, {
    path: "/",
    component: _58129b4c,
    name: "index"
  }],

  fallback: false
}

export function createRouter (ssrContext, config) {
  const base = (config._app && config._app.basePath) || routerOptions.base
  const router = new Router({ ...routerOptions, base  })

  // TODO: remove in Nuxt 3
  const originalPush = router.push
  router.push = function push (location, onComplete = emptyFn, onAbort) {
    return originalPush.call(this, location, onComplete, onAbort)
  }

  const resolve = router.resolve.bind(router)
  router.resolve = (to, current, append) => {
    if (typeof to === 'string') {
      to = normalizeURL(to)
    }
    return resolve(to, current, append)
  }

  return router
}
