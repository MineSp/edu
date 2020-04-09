<template>
  <div id="about">
    <h2>login</h2>
    <div class="formCss">
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="账号" prop="useraccount">
          <el-input placeholder="账号如'123456'" v-model="form.useraccount"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
          <el-input placeholder="密码如'abcde'" type="password" v-model="form.password"></el-input>
        </el-form-item>
      </el-form>
    </div>
    <span>
      <el-button type="primary" @click="loginIn">登录</el-button>
    </span>

    <span>
      <el-button  @click="loginOut">登出</el-button>
    </span>
  </div>
</template>
<script>
export default {
  name: "About",
  data() {
    return {
      form: {
        useraccount: "",
        password: ""
      },
      rules: {
        title: [{ required: true, message: "账号不能为空", trigger: "blur" }],
        content: [{ required: true, message: "密码不能为空", trigger: "blur" }]
      }
    };
  },
  created() {},
  methods: {
    loginIn() {
      const _this = this;
      this.$axios
        .post("http://localhost:8086/user/loginIn", this.form)
        .then(res => {
          this.$message(res.data);
          console.log(res.data);
        });
    },
    loginOut() {}
  }
};
</script>
<style scope>
h2 {
  text-align: center;
  color: rgb(223, 206, 206);
}
.formcss {
  text-align: center;
  float: left;
  margin: auto;
}

.el-form-item {
  margin:  auto;
  font-weight: 700;
  color: #333;
  width: 300px;
}
</style>