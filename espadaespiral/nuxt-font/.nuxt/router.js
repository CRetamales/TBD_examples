import Vue from 'vue'
import Router from 'vue-router'
import { normalizeURL, decode } from 'ufo'
import { interopDefault } from './utils'
import scrollBehavior from './router.scrollBehavior.js'

const _550455b6 = () => interopDefault(import('..\\pages\\acerca-de.vue' /* webpackChunkName: "pages/acerca-de" */))
const _640b3e1c = () => interopDefault(import('..\\pages\\actualizar.vue' /* webpackChunkName: "pages/actualizar" */))
const _e7d31ce6 = () => interopDefault(import('..\\pages\\eliminar.vue' /* webpackChunkName: "pages/eliminar" */))
const _0b522f72 = () => interopDefault(import('..\\pages\\lista.vue' /* webpackChunkName: "pages/lista" */))
const _b4bb23aa = () => interopDefault(import('..\\pages\\nosotros.vue' /* webpackChunkName: "pages/nosotros" */))
const _21059d7b = () => interopDefault(import('..\\pages\\nuevo.vue' /* webpackChunkName: "pages/nuevo" */))
const _01ddf032 = () => interopDefault(import('..\\pages\\delete\\id.vue' /* webpackChunkName: "pages/delete/id" */))
const _9fccb560 = () => interopDefault(import('..\\pages\\update\\id.vue' /* webpackChunkName: "pages/update/id" */))
const _131d6e16 = () => interopDefault(import('..\\pages\\index.vue' /* webpackChunkName: "pages/index" */))

const emptyFn = () => {}

Vue.use(Router)

export const routerOptions = {
  mode: 'history',
  base: '/',
  linkActiveClass: 'nuxt-link-active',
  linkExactActiveClass: 'nuxt-link-exact-active',
  scrollBehavior,

  routes: [{
    path: "/acerca-de",
    component: _550455b6,
    name: "acerca-de"
  }, {
    path: "/actualizar",
    component: _640b3e1c,
    name: "actualizar"
  }, {
    path: "/eliminar",
    component: _e7d31ce6,
    name: "eliminar"
  }, {
    path: "/lista",
    component: _0b522f72,
    name: "lista"
  }, {
    path: "/nosotros",
    component: _b4bb23aa,
    name: "nosotros"
  }, {
    path: "/nuevo",
    component: _21059d7b,
    name: "nuevo"
  }, {
    path: "/delete/id",
    component: _01ddf032,
    name: "delete-id"
  }, {
    path: "/update/id",
    component: _9fccb560,
    name: "update-id"
  }, {
    path: "/",
    component: _131d6e16,
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
