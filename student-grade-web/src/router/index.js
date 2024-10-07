import { createRouter, createWebHistory } from "vue-router";

import Login from "@/components/Login.vue"
import Home from "@/components/Home.vue"

const routers=[
    {
        path:'/',
        component:Login
    },
    {
        path:'/home',
        component:Home
    }
]
const router=createRouter({
    history:createWebHistory(),
    routes:routers
})

export default router;
