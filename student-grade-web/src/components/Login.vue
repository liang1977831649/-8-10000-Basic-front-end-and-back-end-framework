
<script setup>
import { Lock, User } from "@element-plus/icons-vue"
import { ref } from 'vue'
import { ElMessage } from 'element-plus'
import { useRouter } from "vue-router"
import { loginService } from "@/api/loginApi.js"
import { useToken } from "@/store/token.js"
const router = useRouter();
const token = useToken();

const isRegister = ref(false);
const loginBody = ref({
  id: '',
  password: ''
})
const registerBody = ref({
  id: '',
  password: '',
  rePassword: ''
})
const clearLoginForm = () => {
  loginForm.value.username = ''
  loginForm.value.password = '';
}


const checkPassword = (rule, value, callback) => {
  if (value !== registerBody.value.rePassword) {
    ElMessage.error('前后密码不一致');
  } else {
    callback();
  }
}
const rules = {
  id: [
    { required: true, message: '请输入用户名', trigger: 'blur' },
    { pattern: /^(\d){6}$/, message: '用户名仅为数字且长度在6位', trigger: 'blur' }
  ],
  password: [
    { required: true, message: '请输入密码', trigger: 'blur' },
    { pattern: /^(\d){6,}$/, message: '密码长度最少在6位', trigger: 'blur' }
  ],
  rePassword: [
    { required: true, message: '请输入密码', trigger: 'blur' },
    { validator: checkPassword, trigger: 'blur' }
  ]
}
// 校验的变量
const form = ref(null);
const form2 = ref(null)
const register = () => {
  console.log(registerBody.value);
}
const login = () => {
  form.value.validate((async valid => {
    if (valid) {
      // const result = await loginService(loginBody)
      // console.log("result=",result);
      // if (result.data !== null) {
      //   token.setToken(result.data)
      //   router.push("/home")
      // } else {
      //   ElMessage.error("账号或密码错误");
      // }
      router.push("/home")
    }
  }))

}
</script>

<template>
  <div>
    <el-row class="elRow">
      <el-col>
        <h1>欢迎使用学生成绩管理系统</h1>
        <!-- 注册表单 -->
        <el-form v-if="isRegister" :model="registerBody" :rules="rules" ref="form2">
          <el-form-item>
            <h2>注册</h2>
          </el-form-item>
          <el-form-item class="forItem" prop="id">
            <el-input :prefix-icon="User" placeholder="请输入用户名" v-model="registerBody.id">
            </el-input>
          </el-form-item>
          <el-form-item prop="password">
            <el-input :prefix-icon="Lock" type="password" placeholder="请输入密码" v-model="registerBody.password">
            </el-input>
          </el-form-item>
          <el-form-item prop="rePassword">
            <el-input :prefix-icon="Lock" type="Password" placeholder="请输入再次密码" v-model="registerBody.rePassword">
            </el-input>
          </el-form-item>
          <!-- 注册按钮 -->
          <el-form-item>
            <el-button type="primary" @click="register">
              注册
            </el-button>
            <el-link style="margin-left: 20px;" type="info" @click="isRegister = false">
              ← 返回
            </el-link>
          </el-form-item>
        </el-form>
        <!-- 登录表单 -->
        <el-form v-else :model="loginBody" :rules="rules" ref="form">
          <el-form-item>
            <h2>登录</h2>
          </el-form-item>
          <el-form-item prop="id">
            <el-input :prefix-icon="User" placeholder="请输入用户名" v-model="loginBody.id"></el-input>
          </el-form-item>
          <el-form-item prop="password">
            <el-input :prefix-icon="Lock" type="password" placeholder="请输入密码" v-model="loginBody.password"></el-input>
          </el-form-item>

          <!-- 登录按钮 -->
          <el-form-item>
            <el-button type="primary" @click="login">登录</el-button>
            <el-link style="margin-left: 20px;" type="info" :underline="false" @click="isRegister = true">
              注册 →
            </el-link>
          </el-form-item>

        </el-form>
      </el-col>
    </el-row>
  </div>
</template>


<style>
.el-form-item {
  width: 250px;
}

.elRow {
  width: 400px;
  background-color: white;
  margin: 150px 0px 0px 550px;
}
</style>