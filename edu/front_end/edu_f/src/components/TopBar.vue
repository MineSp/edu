<template>
  <div id="topBar">
    <el-dialog
      v-if="isLoginDailogVisable"
      title="请登录"
      :visible.sync="isLoginDailogVisable"
      width="50%"
    >
      <Login v-on:closeLoginBox="closeLoginBox" />
    </el-dialog>
    <span>
      <img src="../assets/imgzero.jpg" height="50" width="50" />
      <label>
        欢迎你
        <el-dropdown>
          <span>
            {{username}}
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item v-if="isUserLoginIn">
                <router-link to="/personalcenter">个人中心</router-link>
                <!-- <el-button type="text"></el-button> -->
              </el-dropdown-item>
              <el-dropdown-item v-if="!isUserLoginIn">
                <el-button type="text" @click="LoginInbutton()">登录</el-button>
              </el-dropdown-item>
              <el-dropdown-item v-else>
                <el-button type="text" @click="LoginOutbutton()">登出</el-button>
              </el-dropdown-item>
            </el-dropdown-menu>
          </span>
        </el-dropdown>
        ——你是【{{id_idname}}】
      </label>
      <!--  -->
      <i class="title">教育质量评价与反馈系统</i>
    </span>
  </div>
</template>
<script>
import Login from "../components/user/Login";
export default {
  data() {
    return {
      isUserLoginIn: false,
      isLoginDailogVisable: false,
      username: "",
      id_idname: "",
    };
  },
  components: { Login },
  created() {
    if (
      typeof this.getCookie("useraccount") == undefined ||
      this.getCookie("useraccount") == 0
    ) {
      this.isUserLoginIn == false;
      this.username = "用户";
      this.id_idname = "";
    } else {
      this.getCookie("useraccount");
      if (typeof this.getCookie("username") == undefined) {
      } else {
        this.username = this.getCookie("username");
        this.id_idname = this.getCookie("id_idname");
      }
      this.isUserLoginIn = this.getCookie("isUserLoginIn");
    }
  },
  methods: {
    closeLoginBox(data) {
      // console.log("ccc", this.g_useraccount);

      this.isUserLoginIn = true;
      this.isLoginDailogVisable = false;
      this.username = data.username;
      this.id_idname = this.getCookie("id_idname");
    },
    LoginInbutton() {
      // console.log('yes');
      this.isLoginDailogVisable = true;
    },
    LoginOutbutton() {
      // console.log("res", console.log("res"));
      this.$axios
        .post("http://localhost:8086/user/loginOut", {
          useraccount: this.getCookie("useraccount")
        })
        .then(res => {
          // console.log("res");
          this.isUserLoginIn = false;
          this.setCookie("useraccount", 0, 1000);
          this.setCookie("isUserLoginIn", false, 1000);
          this.setCookie("id_id", -2, 1000);
          this.setCookie("username", "用户", 1000);
          this.setCookie("id_idname", "游客", 1000);
          this.username = this.getCookie("username");
          this.id_idname = this.getCookie("id_idname");
          this.$message.success(res.data);
          this.$router.push('/')
          window.location.reload();
          console.log("finish!");
          
        });
      // 
    }
  }
};
</script>

<style scoped>
#topBar {
  margin: 0;
  background-color: cornflowerblue;
}
#topBar span img {
  margin: 0 10px 0 40px;
  border: 1px solid #e7dddde6;
  border-radius: 50%;
  box-shadow: 2px 2px 9px rgb(133, 133, 121);
}
.title {
  float: right;
  margin: 10px 30px 0px 10px;
  font: 30px sans-serif;
  text-align: center;
  text-shadow: 1px 1px 1px black;
}
#topBar span hr {
  margin-top: 0%;
  /* height: 10px; */
  margin-bottom: 0%;
}
a {
  text-decoration: none;
}

.router-link-active {
  text-decoration: none;
}
</style>
