<template>
  <div id="app">
    <!-- <div id>
      <router-link to="/home">Home</router-link>
      <router-link to="/">helloworld</router-link>
      <router-link to="/about">About</router-link>
      <router-link to="/test">Test</router-link>
      <router-link to="/test01">Test01</router-link>
      <router-link to="/dataanylize">Dataanylize</router-link>
      <router-link to="/menu">Menu</router-link>
    </div>
    <img src="./assets/logo.png">-->
    <!-- <div>
      <router-view />
    </div>-->
    <div class="right">
      <el-col :span="12">
        <el-menu
          router
          default-active
          class="el-menu-vertical-demo"
          @open="handleOpen"
          @close="handleClose"
        >
          <el-menu-item index="2">
            <i class="el-icon-menu"></i>
            <span slot="title">首页</span>
          </el-menu-item>

          <el-submenu v-for="item in MenuInfoData " :key="item" index="index">
            <template slot="title">
              <i class="el-icon-document"></i>
              <span>{{item.title }}</span>
            </template>

            <el-menu-item
              v-for="subItem in item.subItems"
              :key="subItem"
              :index="subItem.path"
            >{{subItem.title +"?"+ subItem.path}}</el-menu-item>
          </el-submenu>
        </el-menu>
      </el-col>
    </div>
    <div>
      <router-view />
    </div>
  </div>
</template>

<script>
import { menu } from "./components/Menu";
export default {
  name: "App",
  data() {
    return {
      isCollapse: true,
      //样例
      a: "/home",
      MenuInfoData: [
        {
          title: "系统信息",
          index: 1,
          subItems: [
            {
              title: "信息列表",
              path: "/massagetable"
            }
          ]
        },
        {
          title: "评价系统",
          index: 2,
          subItems: [
            {
              title: "教师列表",
              path: "/workerstable"
            },
            {
              title: "课程列表",
              path: "/coursestable"
            },
            {
              title: "班级列表",
              path: "/classestable"
            }
          ]
        },
        {
          title: "个人系统",
          index: 3,
          subItems: [
            {
              title: "个人中心",
              path: "/personalcenter"
            }
          ]
        },
        {
          title: "系统管理",
          index: 4,
          subItems: [
            {
              title: "指标库",
              path: "/indextable"
            },
            {
              title: "系统",
              path: "/settingpage"
            }
          ]
        }
      ]
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
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: rgb(61, 115, 169);
  margin-top: 60px;
}
.el-menu {
  text-align: left;
  width: 30%;
  border: 1px solid #f00;
}
:right{
  margin: auto;
}
</style>
