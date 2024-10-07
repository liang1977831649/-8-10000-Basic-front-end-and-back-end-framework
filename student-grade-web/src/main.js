import "@/assets/global.css"
import ElementPlus from "element-plus"
import 'element-plus/dist/index.css'
import locale from 'element-plus/dist/locale/zh-cn.js'
import { createApp } from 'vue'
import App from './App.vue'
import router from "@/router"
import {createPinia} from 'pinia'
import {createPersistedState} from 'pinia-persistedstate-plugin'


const app =createApp(App)
const pinia= createPinia();
const piniaSist=createPersistedState()

app.use(pinia)
pinia.use(piniaSist)
app.use(ElementPlus,{locale});
app.use(router)
app.mount('#app')