import router from './router'
import store from './store'
import Vue from 'vue';
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import App from './App.vue';
import axios from 'axios'
import VueAxios from 'vue-axios';




Vue.use(ElementUI);
Vue.use(VueAxios,axios)
Vue.config.productionTip = false
axios.defaults.baseURL = '/api'
Vue.prototype.$axios= axios


new Vue({
  axios,
  router,
  store,
  render: h => h(App)
}).$mount('#app')
