<template>
  <div id="personalcenter">
    <span>
      <img src="@/assets/imgzero.jpg" height="150" width="150" />
    </span>

    <hr />
    <h2>__个人中心__</h2>
    <el-dialog v-if="pwUpdateVisible" width="50%" :visible.sync="pwUpdateVisible">
      <pw-update v-on:closebox="closebox"></pw-update>
    </el-dialog>

    <div id="main">
      <el-form ref="userForm" :model="userForm" :rules="rules" label-width="50%">
        <el-form-item label="用户姓名：" prop="title">
          <i>{{userForm.username}}</i>
        </el-form-item>
        <el-form-item label="账号：" prop="useraccount">
          <i>{{userForm.useraccount}}</i>
        </el-form-item>
        <el-form-item label="身份：" prop="id_idname">
          <i>{{userForm.id_idname}}</i>
        </el-form-item>
        <el-form-item label="性别：" prop="sex">
          <el-input style="width:120px" v-model="userForm.sex"></el-input>
          <!-- <i>{{fristFrom.sex}}</i> -->
        </el-form-item>
        <el-form-item label="年龄：" prop="age">
          <el-input style="width:120px" v-model="userForm.age"></el-input>
        </el-form-item>
        <el-form-item label="邮箱：" prop="email">
          <el-input style="width:200px" v-model="userForm.email"></el-input>
        </el-form-item>
        <el-form-item v-if="this.userForm.classname!=''" label="班级：" prop="classname">
          <i>{{userForm.classname}}</i>
        </el-form-item>
        <el-form-item v-if="this.userForm.specname!=''" label="专业：" prop="specname">
          <i>{{userForm.specname}}</i>
        </el-form-item>
        <el-form-item v-if="this.userForm.collegename!=''" label="学院：" prop="collegename">
          <i>{{userForm.collegename}}</i>
        </el-form-item>
        <el-form-item v-if="this.userForm.edu!=''" label="学历：" prop="edu">
          <i>{{userForm.edu}}</i>
        </el-form-item>
        <el-button type="primary" @click="updateButton('userForm')">修改</el-button>
        <el-button @click="rebackButton('userForm')">返回</el-button>
        <el-button @click="pwButton()">修改密码</el-button>
      </el-form>
    </div>
  </div>
</template>
<script>
import PwUpdate from "./PwUpdate";
export default {
  name: "PersonalCenter",
  components: { PwUpdate },
  data() {
    return {
      userForm: {
        sex: "nv",
        age: "1",
        email: "1111@qq.com",
        phone: "12312312123"
      },
      rules: {
        sex: [
          { required: true, message: "性别不能为空", trigger: "blur" },
          {
            validator: function(rule, value, callback) {
              if (value != "男" && value != "女") {
                callback(new Error("性别填写错误：男/女"));
              } else {
                callback();
              }
            },
            trigger: "blur"
          }
        ],
        age: [
          { required: true, message: "年龄不能为空", trigger: "blur" },
          {
            validator: function(rule, value, callback) {
              if (
                /^\w{1,3}$/i.test(value) == false ||
                value > 100 ||
                value < 10
              ) {
                callback(new Error("年龄填写错误：[10~100]"));
              } else {
                callback();
              }
            },
            trigger: "blur"
          }
        ],
        email: [
          { required: true, message: "请填写邮箱", trigger: "blur" },
          {
            validator: function(rule, value, callback) {
              if (
                /^\w{1,64}@[a-z0-9\-]{1,256}(\.[a-z]{2,6}){1,2}$/i.test(
                  value
                ) == false
              ) {
                callback(new Error("邮箱格式错误"));
              } else {
                callback();
              }
            },
            trigger: "blur"
          }
        ],
        phone: [{ required: true, message: "请填写手机号", trigger: "blur" }]
      },
      fristFrom: {
        // phone:0,
      },
      pwUpdateVisible: false,
      sextemp: "",
      agetemp: "",
      emailtemp: ""
    };
  },

  created() {
    // console.log("useraccount",this.getCookie("useraccount"));
    this.$axios
      .get(
        "http://localhost:8086/user/personalCenter/" +
          this.getCookie("useraccount")
      )
      .then(res => {
        // console.log(res.data);
        this.sextemp = res.data.sex;
        this.agetemp = res.data.age;
        this.emailtemp = res.data.email;
        this.userForm = res.data;
        
        // this.fristFrom = res.data;
      });
  },
  methods: {
    /**
     * test
     */
    updateButton(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
          if (
            this.userForm.sex != this.sextemp ||
            this.userForm.age != this.agetemp ||
            this.userForm.email != this.emailtemp
          ) {
            this.fristFrom.sex = this.userForm.sex;
            this.fristFrom.age = this.userForm.age;
            this.fristFrom.email = this.userForm.email;
            
            this.fristFrom.id_id = this.getCookie("id_id");
            this.fristFrom.userId = this.getCookie("useraccount");
            // console.log("useraccount",this.getCookie("useraccount"));
            // console.log("this" , this.fristFrom.userId);
            this.$axios
              .put("http://localhost:8086/user/updatePersonal", this.fristFrom)
              .then(res => {
                this.$message(res.data);
              });
          }
          console.log(this.fristFrom);
        } else {
        }
      });
    },
    rebackButton(formName) {},
    pwButton() {
      this.pwUpdateVisible = true;
    },
    closebox(data) {
      this.pwUpdateVisible = data;
    }
  }
};
</script>

<style >
.img {
  border: 1px solid #b8b0b0e6;
  border-radius: 50%;
  box-shadow: 10px 2px 9px rgb(17, 17, 16);
}
.el-form-item {
  text-align: left;
}
.div main {
  text-align: center;
}
</style>