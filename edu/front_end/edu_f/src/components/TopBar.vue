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
      <img
        src="http://i0.hdslb.com/bfs/article/824a48e5cc43ce5500941b221cd5b14ee7c1a758.jpg"
        height="50"
        width="50"
      />
      <label>
        欢迎你
        <el-dropdown>
          <span>
            {{this.$root.username}}
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item v-if="this.$root.isUserLoginIn" index='/personalcenter' >
                <el-button type="text">个人中心</el-button>
              </el-dropdown-item>
              <el-dropdown-item>
                <el-button
                  v-if="this.$root.isUserLoginIn==false"
                  type="text"
                  @click="LoginInbutton()"
                >登录</el-button>
              </el-dropdown-item>
              <el-dropdown-item v-if="this.$root.isUserLoginIn">
                <el-button  type="text" @click="LoginOutbutton()">登出</el-button>
              </el-dropdown-item>
            </el-dropdown-menu>
          </span>
        </el-dropdown>
      </label>
      <!--  -->
      <i class="title">教育质量评价与反馈系统</i>
      <hr />
    </span>
  </div>
</template>
<script>
import Login from "../components/user/Login";
export default {
  data() {
    return {
      isUserLoginIn: false,
      isLoginDailogVisable: false
    };
  },
  components: { Login },
  created() {
    console.log(this.$root.isUserLoginIn);
  },
  methods: {
    closeLoginBox(data) {
      this.isLoginDailogVisable = data;
    },
    LoginInbutton() {
      // console.log('yes');

      this.isLoginDailogVisable = true;
    },
    LoginOutbutton() {
      this.$axios
        .post("http://localhost:8086/user/loginOut", {useraccount:this.$root.userId})
        .then(res => {
          console.log( "res",res);
          
          this.$message.success(res.data);
          this.$root.isUserLoginIn = false;
          this.$root.username = "游客";
          this.$root.id_idname = "游客";
          this.$root.id_id = -2;
          this.$root.userId='';
        });
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
</style>
