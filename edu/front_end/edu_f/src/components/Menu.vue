<template>
  <div id="app">
    <div class="right">
      <el-col :span="12">
        <el-container>
          <el-aside>
            <el-menu router class="el-menu-vertical-demo" @open="handleOpen" @close="handleClose">
              <el-menu-item id="id_idname">
                
                <span>{{this.$root.id_idname}}</span>
              </el-menu-item>
              <el-menu-item index="/">
                <i class="el-icon-menu"></i>
                <span slot="title">首页</span>
              </el-menu-item>
              <el-submenu v-for="(item,index) in $router.options.routes" :key="item"  :index="index">
                <template slot="title">
                  <i class="el-icon-document"></i>
                  <span>{{item.name}}</span>
                </template>
                <el-menu-item
                  v-for="subItem in item.children"
                  :key="subItem"
                  :index="subItem.path"
                  :class="$route.path==subItem.path?'is-active':''"
                >{{subItem.name}}</el-menu-item>
              </el-submenu>
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
import  HeaderBar  from "../components/HeaderBar";
export default {
  name: "Menu",
  components: { HeaderBar },
  data() {
    return {
      isCollapse: true
    };
  },
  methods: {
    handleOpen(key, keyPath) {
      window.console.log(key, keyPath);
      window.console.log("key ？", key);
      window.console.log("keypath ?", keyPath);
    },
    handleClose(key, keyPath) {
      window.console.log(key, keyPath);
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
#id_idname{
  text-align: center;background-color: cornflowerblue;
}
#id_idname span{
  font-size: 30px;
}
</style>