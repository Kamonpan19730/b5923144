import Vue from 'vue'
import VueRouter from 'vue-router'
import App from './App'
import RateUP from './components/RateUP'
import Member from './components/Member'
import addVideo from './components/addVideo'
import AddBook from './components/AddBook'
import borrow from './components/borrow'

import Remand from './components/Remand'

import ShowMember from './components/ShowMember'
import home from './components/home'
Vue.use(VueRouter)

const router = new VueRouter({
    mode: 'history',
    routes:[
        {
            path: '',
            component: App,
            children:[
                {
                    path: '',
                    redirect: 'home'
                },
                {
                    path:'remand',
                    component: Remand
                },
                {
                    path: 'rates',
                    component: RateUP,
                },

                
                {
                    path: 'Member',
                    component: Member,
                },

                {
                    path: 'addVideo',
                    component: addVideo,
                },
                {
                    path: 'borrow',
                    component: borrow,
                },
                {
                    path: 'AddBook',
                    component: AddBook
                }
                ,
                {
                    path: 'ShowMember',
                    component: ShowMember,
                },
                {
                    path: 'home',
                    component: home,
                }


            ]

        }
    ] 

})
export default router;