import Vue from 'vue'
// import App from './App.vue';
import VueRouter from 'vue-router'
import Login from "../components/Login";
import Seckill from "../components/Seckill";
Vue.use(VueRouter)
//route
const router = new VueRouter({
    routes: [
        { path: '/', component: Login },
        { path: '/login', component: Login },
        { path: '/index', component: Seckill }
    ]
})


export default router