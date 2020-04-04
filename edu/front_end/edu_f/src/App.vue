
<template>
  <div>
    <router-view />
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
  width: 1080;
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: rgb(61, 115, 169);
  margin-top: 60px;
}
.el-col {
  height: 100%;
  width: 100%;
}
.el-aside {
  width: 10%;
  border: 1px solid #eee;
}
.el-header {
  /* margin: auto; */
  border: 1px solid #eee;
  background-color: cadetblue;
  text-align: right;
  font-size: 20px;
}

.el-menu {
  text-align: left;
}
:right {
  width: 100%;
}
</style>
