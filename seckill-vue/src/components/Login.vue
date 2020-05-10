<template>
    <div id="login">
        <div style="margin: 0 auto;width: 40%;margin-top: calc(30vh);">
            <el-form :model="dataForm" label-width="80px" :rules="dataRule" ref="dataForm"
                     @keyup.enter.native="dataFormSubmit()" status-icon>
                <el-form-item>
                    <span style="font-family: PingFang SC;font-size: 35px;">Design and implementation of SecKill system</span>
                </el-form-item>
                <el-form-item label="账号" prop="account">
                    <el-input v-model="dataForm.account" placeholder="请输入账号"></el-input>
                </el-form-item>
                <el-form-item label="密码" prop="password">
                    <el-input v-model="dataForm.password" type="password" placeholder="请输入密码"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-button class="login-btn-submit" type="primary" @click="dataFormSubmit('login')"
                               :loading="loginLoading">登录
                    </el-button>
                    <el-button class="login-btn-submit" type="primary" @click="dataFormSubmit('register')"
                               :loading="loginLoading">注册
                    </el-button>
                </el-form-item>
            </el-form>
        </div>
    </div>
</template>

<script>
    export default {
        name: "Login",
        data() {
            return {
                dataForm: {
                    account: '',
                    password: '',
                },
                loginLoading: false,
                dataRule: {
                    account: [
                        {required: true, message: '帐号不能为空', trigger: 'blur'}
                    ],
                    password: [
                        {required: true, message: '密码不能为空', trigger: 'blur'}
                    ]
                },
            }

        },
        methods: {
            // 提交表单
            dataFormSubmit(type) {
                this.$refs['dataForm'].validate((valid) => {
                    console.log(type === 'login')
                    if (valid) {
                        this.loginLoading = true
                        this.$http({
                            url: this.$http.adornUrl(type === 'login' ? 'sys/login' : 'sys/register'),
                            method: 'post',
                            data: this.$http.adornData({
                                'username': this.dataForm.account,
                                'password': this.dataForm.password,
                            })
                        }).then(({data}) => {
                            this.loginLoading = false
                            if (data && data.code === 0) {
                                this.$notify({
                                    title: '系统提示',
                                    message: '操作成功',
                                    type: 'success'
                                })
                                if (type === 'login') {
                                    this.$cookie.set('token', data.token)
                                    // 登入成功
                                    this.$nextTick(function () {
                                        this.$router.replace('index')
                                    })
                                }
                            } else {
                                this.$message.error(data.msg)
                            }
                        })
                        this.loginLoading = false
                    }
                })
            },
        }
    }
</script>

<style scoped>
    #login {
        position: absolute;
        width: 100%;
        height: 100%;
        background-size: 100% 100%;
        background: url(../assets/bgc.jpg) no-repeat;
        background-size: 100% 100%;
        background-attachment: fixed;
    }
</style>