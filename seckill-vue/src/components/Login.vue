<template>
    <div id="login" >
        <div style="margin: 0 auto;width: 30%;margin-top: calc(30vh);">
            <el-form ref="form" :model="form" label-width="80px">
                <el-form-item>
                    <span style="font-family: PingFang SC;font-size: 35px;">秒杀系统的设计与实现</span>
                </el-form-item>
                <el-form-item label="账号">
                    <el-input v-model="form.account"></el-input>
                </el-form-item>
                <el-form-item label="密码">
                    <el-input v-model="form.password"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="onSubmit">登入</el-button>
                    <el-button>取消</el-button>
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
                form: {
                    account: '',
                    password: '',
                }
            }
        },
        methods: {
            onSubmit() {
                console.log('submit!');
            }
        }
    }
</script>

<style scoped>
#login{
    position: absolute;
    width: 100%;
    height: 100%;
    background-size: 100% 100%;
    background: url(../assets/bgc.jpg) no-repeat; background-size:100% 100%; background-attachment:fixed;
}
</style>