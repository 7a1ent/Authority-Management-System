<template>
  <el-row>
    <el-input type="text" placeholder="请输入账号" v-model="inputAct"  show-word-limit>
    </el-input>
    <div style="margin: 20px 0;"></div>
    <el-input type="text" placeholder="请输入密码" v-model="inputPsw" show-password="true" show-word-limit>>
    </el-input>

    <el-button  v-on:click="logTy" id="loginButton" type="primary" round>
      登录
    </el-button>
  </el-row>
</template>

<script>
export default {
  name: "LoginFrame",

  methods:{
    logTy() {
      this.$router.push("/MenuFrame");
    }
  }




}

</script>

<style scoped>
#loginButton {
  top: 350px;
  left: 50%;
  position: absolute;


}

.el-input {
  position: relative;
  width: 330px;
  top: 220px;
  left: 630px;
}
</style>