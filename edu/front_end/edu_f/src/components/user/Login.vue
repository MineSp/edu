<template>
  <el-dailog title="请登录" width="50%">
    <div>
      <h2>^_^-=-您好-=-^_^</h2>
      <hr />
      <div class="formCss">
        <el-form ref="form" :model="form" :rules="rules" label-width="35%">
          <el-form-item label="账号" prop="useraccount">
            <el-input style="width:50%" placeholder="账号如'123456'" v-model="form.useraccount"></el-input>
          </el-form-item>
          <el-form-item label="密码" prop="password">
            <el-input
              style="width:50%"
              placeholder="密码如'abcdef'"
              type="password"
              v-model="form.password"
            ></el-input>
          </el-form-item>
          <el-button type="primary" @click="loginIn()">登录</el-button>
          <el-button @click="cancelButton(false)">取消</el-button>
        </el-form>
        <!-- <span></span> -->
      </div>
    </div>
  </el-dailog>
</template>
<script>
export default {
  name: "Login",
  data() {
    return {
      form: {
        useraccount: "",
        password: ""
      },
      rules: {
        useraccount: [
          { required: true, message: "账号不能为空", trigger: "blur" }
        ],
        password: [
          { required: true, message: "密码不能为空", trigger: "blur" },
          {
            validator: function(rule, value, callback) {
              if (value.length <= 5) {
                callback(new Error("密码长度过低"));
              } else {
                callback();
              }
            },
            trigger: "blur"
          }
        ]
      },
      dialogVisibleOfLogin: true
    };
  },
  created() {},
  methods: {
    loginIn() {
      const _this = this;
      this.$axios
        .post("http://localhost:8086/user/loginIn", this.form)
        .then(res => {
          console.log(res);
          if (res.data.islogin == 1) {
            if (res.data.id_id == -1) {
              this.$root.id_idname = "管理员";
              this.setCookie("id_idname", "管理员", 1000);
            } else if (res.data.id_id == 0) {
              this.$root.id_idname = "学生";
              this.setCookie("id_idname", "学生", 1000);
            } else if (res.data.id_id == 1) {
              this.$root.id_idname = "教师";
              this.setCookie("id_idname", "教师", 1000);
            } else {
              this.$root.id_idname = "督导员";
              this.setCookie("id_idname", "督导员", 1000);
            }
            this.$message.success("登录成功！");
            this.setCookie("id_id", res.data.id_id, 1000);
            this.setCookie("useraccount", res.data.useraccount, 1000);
            this.setCookie("username", res.data.username, 1000);
            this.setCookie("isUserLoginIn", true, 1000);
            this.setCookie("isUserLogiid_idnIn", res.data.id_id, 1000);
            this.cancelButton(res.data);
            location.reload();
          } else {
            this.$message.error("登录失败");
          }
        });
    },
    cancelButton(data) {
      this.$emit("closeLoginBox", data);
    }
  }
};
</script>
<style scope>
h2 {
  text-align: center;
  color: rgb(9, 204, 248);
}

.formcss {
  text-align: center;
  float: left;
  margin: auto;
}
</style>