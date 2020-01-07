import Vue from 'vue'
import VueRouter from 'vue-router'
import App from './App'
import addVideo from './components/addVideo'
import Member from './components/Member'
Vue.use(VueRouter)

const router = new VueRouter({
    mode: 'history',
    routes:[
        {
            path: '',
            component: App,


            children : [
                {
                    path: 'addVideo',
                    component: addVideo,
                },

                {
                    path: 'Member',
                    component: Member,
                },


                
            ]

        }
    ] 

})
export default router;