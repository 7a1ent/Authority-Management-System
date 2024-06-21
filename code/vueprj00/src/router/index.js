import Vue from 'vue'
import VueRouter from 'vue-router'

import LoginFrame from '../views/LoginFrame.vue';
import MenuFrame from "@/views/MenuFrame";

Vue.use(VueRouter)

const routes = [

  {
    path: '/',
    name: 'LoginFrame',
    component: LoginFrame
  },
  {
    path: '/Menu',
    name: 'MenuFrame',
    component: MenuFrame
  }
]

const router = new VueRouter({
  routes
})

export default router
