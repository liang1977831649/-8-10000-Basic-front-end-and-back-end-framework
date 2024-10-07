<script setup>
import { ref } from "vue"
const defaultAvatar = ref("https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png")

//头像的下拉菜单
const handleCommand = () => {

}
</script>
<template>
        <div>
            <span>学生成绩管理系统</span>
        </div>
        <div>
            <div style="float: left; margin-right: 20px;margin-top: 5px;"><strong>admin</strong></div>
            <el-dropdown style="float: right;" placement="bottom-end" @command="handleCommand">
                <el-avatar :src="defaultAvatar" />
                <template #dropdown>
                    <el-dropdown-menu>
                        <el-dropdown-item command="info" :icon="User">基本资料</el-dropdown-item>
                        <el-dropdown-item command="avatar" :icon="Crop">更换头像</el-dropdown-item>
                        <el-dropdown-item command="password" :icon="EditPen">重置密码</el-dropdown-item>
                        <el-dropdown-item command="logout" :icon="SwitchButton">退出登录</el-dropdown-item>
                    </el-dropdown-menu>
                </template>
            </el-dropdown>
        </div>
</template>
<style lang="less" scoped>
.el-dropdown__box {
    display: flex;
    align-items: center;

    .el-icon {
        color: #999;
        margin-left: 10px;
    }

    &:active,
    &:focus {
        outline: none;
    }
}
</style>