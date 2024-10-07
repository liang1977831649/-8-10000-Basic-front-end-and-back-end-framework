<script  setup>
import {
    CaretBottom,
    User,
    Crop,
    EditPen,
    SwitchButton,
    UserFilled,
    Document,
    Menu as IconMenu,
    Location,
    Setting
} from '@element-plus/icons-vue'
import { ref } from "vue"
import Aside from "@/components/Aside.vue"
import Header from "@/components/Header.vue"
import {loadMenuServer} from "@/api/menuApi"

//头像的下拉菜单
const handleCommand = () => {

}

const tabs = ref([])
// 加载菜单的MenuList
const loadMenu=async ()=>{
  const result= await loadMenuServer();
  tabs.value=result.data
  console.log(result.data);
}
loadMenu();


</script>

<template>
    <el-container class="home-container">
        <!-- 头部区 -->
        <el-header>
            <Header />
        </el-header>
        <!-- 页面主体区域 -->
        <el-container>
            <!-- 侧边栏 -->
            <el-aside style="height: 100vh;width: 200px;">
                <el-menu active-text-color="#ffd04b" background-color="#545c64" default-active="2" text-color="#fff"
                    @open="handleOpen" @close="handleClose">
                    <Aside :tabs="tabs"/>
                </el-menu>
            </el-aside>
            <!-- 右侧内容主体 -->
            <el-main>Main</el-main>
        </el-container>
    </el-container>
</template>
   
<style lang="less" scoped>
.home-container {
    height: 100%;
}

.el-header {
    background-color: #373d41;
    display: flex; //设置显示为flex布局
    justify-content: space-between; //设置为flex左右布局
    padding-left: 0; //左内边距为0（Logo贴左边）
    align-items: center; //元素上下居中（防止右边按钮贴上下边）
    color: #fff;
    font-size: 20px;

    >div {
        //内嵌的div样式
        display: flex;
        align-items: center; //Logo和文字上下居中

        span {
            margin-left: 15px; //文字左侧设置间距，防止与Logo紧贴
        }
    }
}

.el-main {
    background-color: #eaedf1;
}

.el-aside {
    background-color: #333744;
}
</style>