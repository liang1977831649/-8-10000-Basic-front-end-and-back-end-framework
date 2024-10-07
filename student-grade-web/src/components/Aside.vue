<script lang="ts">
export default {
    name: "Aside",
};
</script>

<script lang="ts" setup>
import { Avatar, Location, Menu, Document } from '@element-plus/icons-vue'
import { ref } from 'vue'
import Aside from "@/components/Aside.vue"

const handleOpen = (key, keyPath) => {
    console.log(key, keyPath)
}
const handleClose = (key, keyPath) => {
    console.log(key, keyPath)
}
const iconList = ref({
    "Avatar": Avatar,
    "Menu": Menu,
    "Document": Document,
    "Location": Location
})

// 回应了父类组件传过来的tabs
const props = defineProps({
    tabs: {
        type: Array,
        required: true,
    },
});



</script>
<template>
    <!-- <el-aside style="height: 100vh;width: 200px;">
        <el-menu active-text-color="#ffd04b" background-color="#545c64" default-active="2" text-color="#fff"
            @open="handleOpen" @close="handleClose"> -->

    <div v-for="item in tabs">
        <!-- 如果是一级菜单 -->
        <div v-if="item.menuType == 1">
            <el-menu-item :index="item.path">
                <el-icon>
                    <component :is='iconList[item.icon]' />
                </el-icon>
                <span>{{ item.menuName }}</span>
            </el-menu-item>
        </div>
        <!-- 如果是二级菜单 -->
        <div v-else>
            <el-sub-menu :index="item.path">
                <template #title>
                    <el-icon>
                        <component :is='iconList[item.icon]' />
                    </el-icon>
                    <span>{{ item.menuName }}</span>
                </template>
                <Aside v-if="item.menuList" :tabs="item.menuList" />
            </el-sub-menu>
        </div>
    </div>

    <!-- <el-menu-item index="1">
        <el-icon><icon-menu /></el-icon>
        <span>系统首页</span>
    </el-menu-item>
    <el-sub-menu index="2">
        <template #title>
            <el-icon>
                <location />
            </el-icon>
            <span>课程管理</span>
        </template>
        <el-menu-item index="2-1">课程信息</el-menu-item>
    </el-sub-menu>

    <el-menu-item index="3">
        <el-icon>
            <document />
        </el-icon>
        <span>个人信息</span>
    </el-menu-item> -->
</template>
<style scoped>
.el-aside {
    background-color: #333744;
}
</style>