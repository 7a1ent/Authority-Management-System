<template>
    <div class="loginBody">
        <div class="loginDiv">
            <div class="login-content">
                <h1 class="login-title">用户登录</h1>
                <el-form :model="loginForm" label-width="100px" :rules="rules" ref="loginForm">
                    <el-form-item label="账号" prop="act">
                        <el-input style="width: 220px" v-model="loginForm.act" autocomplete="off"></el-input>
                    </el-form-item>

                    <el-form-item label="密码" prop="password">
                        <el-input style="width: 220px" v-model="loginForm.password" autocomplete="off"
                            show-password="true"></el-input>
                    </el-form-item>

                    <el-form-item label="权限等级" prop="privilege">
                        <el-input style="width: 100px" v-model.number="loginForm.privilege"></el-input>
                    </el-form-item>
                    <el-form-item>
                        <el-button type="primary" @click="confirm()">确 定</el-button>
                    </el-form-item>
                </el-form>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name: "LoginFrame",
    data() {
        return {
            loginForm: {
                act: '',
                password: '',
                privilege: '',
            },
            rules: {

            }
        }
    },
    methods: {
        confirm() {
            this.$axios.get('/api/confirm', {
                params: {
                    act: this.loginForm.act,
                    password: this.loginForm.password,
                    privilege: this.loginForm.privilege
                }
            }).then(res => {
                console.log(res);
                if (res.data === 0)
                    this.$message({
                        type: 'error',
                        message: '登录失败!'
                    });
                else {
                    this.$message({
                        type: 'success',
                        message: '登录成功!'
                    });
                    this.$router.push({
                        path: "/Menu",
                        query: {
                            privilege: this.loginForm.privilege

                        }

                    });
                }

            })

        }
    }
}
</script>

<style scoped>
.loginbBody {
    width: 100%;
    height: 100%;
    background-color: #B3C0D1;
}

.loginDiv {
    position: absolute;
    top: 50%;
    left: 50%;
    margin-top: -200px;
    margin-left: -250px;
    width: 450px;
    height: 330px;
    background: #fff;
    border-radius: 5%;

}

.login-title {
    margin: 20px 0;
    text-align: center;
}

.login-content {
    width: 400px;
    height: 250px;
    position: absolute;
    top: 25px;
    left: 25px;
}
</style>
