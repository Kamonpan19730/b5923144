import Vue from 'vue'
import App from './App'
import vuetify from './plugins/vuetify';
import router from './router'
import VueLogger from 'vuejs-logger';
Vue.config.productionTip = false


const options = {
  isEnabled: true,
  logLevel : 'debug',
  stringifyArguments : false,
  showLogLevel : true,
  showMethodName : false,
  separator: '|',
  showConsoleColors: true
};

Vue.use(VueLogger, options);

/* eslint-disable no-new */
new Vue({
  router,
  vuetify,
  render: h => h(App)
}).$mount('#app')
