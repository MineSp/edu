<template>
  <div>
    <h1>密码修改</h1>
    <hr />
    <div>
      <el-form ref="updatePwForm" :model="updatePwForm" :rules="rules" label-width="40%">
        <el-form-item label="旧的密码：" prop="oldpw">
          <el-input style="width:200px" type="password" v-model="updatePwForm.oldpw"></el-input>
        </el-form-item>
        <el-form-item label="新的密码：" prop="newpw">
          <el-input style="width:200px" type="password" v-model="updatePwForm.newpw"></el-input>
        </el-form-item>
        <el-form-item label="再输一次：" prop="newpw2nd">
          <el-input style="width:200px" type="password" v-model="updatePwForm.newpw2nd"></el-input>
        </el-form-item>
      </el-form>
      <el-button  type="primary" @click="submitButton()">确定</el-button>
      <el-button @click="backButton(false)">取消</el-button>
    </div>
    <hr />
  </div>
</template>

<script>
export default {
  name: "PwUpdate",
  data() {
    return {
      updatePwForm: {
        oldpw: "",
        newpw: "",
        newpw2nd: ""
      },
      rules: {
        oldpw: [{ required: true, message: "原密码不能为空", trigger: "blur" }],
        newpw: [
          { required: true, message: "新密码不能为空", trigger: "blur" },
          {
            validator: function(rule, value, callback) {
              if (value.length <= 5) {
                callback(new Error("新密码长度不低于6"));
              } else {
                callback();
              }
            },
            trigger: "blur"
          }
        ],
        newpw2nd: [
          { required: true, message: "请再一次输入新密码", trigger: "blur" },
          {
            validator: function(rule, value, callback) {
              if (value.length <= 5) {
                callback(new Error("新密码长度不低于6"));
              } else {
                callback();
              }
            },
            trigger: "blur"
          }
        ]
      }
    };
  },
  methods: {
    submitButton() {
      if (this.updatePwForm.oldpw == this.updatePwForm.newpw) {
        this.$message.error("新密码与旧密码相同！");
      } else if (this.updatePwForm.newpw != this.updatePwForm.newpw2nd) {
        this.$message.error("两次输入密码不一致！");
      } else {
        this.updatePwForm.userid = this.$root.userId;
        // console.log(this.updatePwForm);
        this.$axios
          .put("http://localhost:8086/user/upDatePW", this.updatePwForm)
          .then(res => {
            this.$message(res.data);
          });
          this.backButton(false);
      }
    },
    backButton(doit) {
      this.$emit("closebox", doit);
    }
  }
};
</script>