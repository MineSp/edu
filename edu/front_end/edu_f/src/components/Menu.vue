<template>
  <div id="app">
    <div class="right">
      <el-col :span="12">
        <el-container>
          <el-aside>
            <el-menu router class="el-menu-vertical-demo" @open="handleOpen" @close="handleClose">
              <router-link to="/">
                <el-menu-item inde="/">
                  <i class="el-icon-menu"></i>
                  <span slot="title">首页</span>
                </el-menu-item>
              </router-link>

              <div v-if="isLogin">
                <el-submenu
                  v-for="(item,index) in $router.options.routes"
                  :key="item"
                  :index="index"
                  v-if="item.show&&((show==-1)||((show!=-2)&&item.open<=show))"
                >
                  <template slot="title">
                    <i class="el-icon-document"></i>
                    <span>{{item.name}}</span>
                  </template>
                  <el-menu-item
                    v-for="subItem in item.children"
                    :key="subItem"
                    :index="subItem.path"
                    :class="$route.path==subItem.path?'is-active':''"
                    v-if="subItem.show&&((show==-1)||((show!=-2)&&subItem.open<=show))"
                  >
                    <span>{{subItem.name}}</span>
                  </el-menu-item>
                </el-submenu>
              </div>
            </el-menu>
          </el-aside>

          <el-container>
            <!-- <HeaderBar /> -->
            <el-main>
              <router-view />
            </el-main>
          </el-container>
        </el-container>
      </el-col>
    </div>
  </div>
</template>

<script>
// import { menu } from "./components/Menu";
import HeaderBar from "../components/HeaderBar";
export default {
  name: "Menu",
  components: { HeaderBar },
  data() {
    return {
      isCollapse: true,
      isLogin: false,
      id_id: -2,
      show: 2
    };
  },
  created() {
    if (
      typeof this.getCookie("isUserLoginIn") != undefined &&
      this.getCookie("useraccount") != 0
    ) {
      this.isLogin = this.getCookie("isUserLoginIn");
      this.show = this.getCookie("id_id");
    } else {
      this.isLogin = false;
      this.id_id = -2;
      this.show = -2;
    }
    // console.log("show", this.show);

    // if(isLogin ==false){
    //   this.$router.push({path:'/login'})
    // }
    // this.setCookie("test","test",365);
  },
  methods: {
    handleOpen(key, keyPath) {
      if (this.show != this.getCookie("id_id")) {
        location.reload();
      }
      // window.console.log(key, keyPath);
      // window.console.log("key ？", key);
      // window.console.log("keypath ?", keyPath);
    },
    handleClose(key, keyPath) {
      // window.console.log(key, keyPath);
    }
  }
};
</script>

<style>
.el-col {
  height: 100%;
  width: 100%;
}
.el-aside {
  width: 10%;
  border: 1px solid #eee;
}

.el-menu {
  text-align: left;
}
:right {
  width: 100%;
}
#id_idname {
  text-align: center;
  background-color: cornflowerblue;
}
#id_idname span {
  font-size: 30px;
}
a {
  text-decoration: none;
}

.router-link-active {
  text-decoration: none;
}
</style>