import router from './router'
import store from './store'
import Vue from 'vue';
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import App from './App.vue';
import axios from 'axios'
// import VueAxios from "vue-axios";



Vue.use(ElementUI);
// Vue.use(VueAxios, axios);
Vue.prototype.axios = axios;
Vue.config.productionTip = false




new Vue({
  axios,
  router,
  store,
  render: h => h(App)
}).$mount('#app')
