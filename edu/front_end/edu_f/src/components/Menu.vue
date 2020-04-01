   <template>
  <div>
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

          <!-- <router-link v-for="subItem in item.subItems" :key="subItem" to='/home'>
          <el-menu-item index="1-3">{{subItem.title +subItem.path}}</el-menu-item>
          </router-link>-->

          <!-- <el-menu-item index="1-3">信息列表</el-menu-item>
        <el-menu-item index="1-3">商家列表</el-menu-item>
        <el-menu-item index="1-3">食品列表</el-menu-item>
        <el-menu-item index="1-3">订单列表</el-menu-item>
          <el-menu-item index="1-3">管理员列表</el-menu-item>-->
        </el-submenu>

        <!-- <el-submenu index="1">
        <template slot="title">
          <i class="el-icon-document"></i>
          <span>信息系统</span>
        </template>
        <el-menu-item index="1-3">信息列表</el-menu-item>
        <el-menu-item index="1-3">商家列表</el-menu-item>
        <el-menu-item index="1-3">食品列表</el-menu-item>
        <el-menu-item index="1-3">订单列表</el-menu-item>
        <el-menu-item index="1-3">管理员列表</el-menu-item>
        </el-submenu>-->

        <!-- <el-submenu index="2">
        <template slot="title">
          <i class="el-icon-plus"></i>
          <span>评价系统</span>
        </template>
        <router-link to="/">
          <el-menu-item index="1-3">添加商铺</el-menu-item>
        </router-link>
        <el-menu-item index="1-3">添加商铺</el-menu-item>
        <el-menu-item index="1-3">添加商品</el-menu-item>
        </el-submenu>-->

        <!-- <el-submenu index="3">
        <template slot="title">
          <i class="el-icon-star-on"></i>
          <span>个人系统</span>
        </template>
        <el-menu-item index="1-3">用户分布</el-menu-item>
        </el-submenu>-->

        <!-- <el-submenu index="4">
        <template slot="title">
          <i class="el-icon-edit"></i>
          <span>系统操作</span>
        </template>
        <el-menu-item index="1-3">文本编辑</el-menu-item>
        </el-submenu>-->

        <!-- <el-submenu index="5">
        <template slot="title">
          <i class="el-icon-setting"></i>
          <span>设置</span>
        </template>
        <el-menu-item index="1-3">管理员设置</el-menu-item>
        </el-submenu>-->

        <!-- <el-submenu index="6">
        <template slot="title">
          <i class="el-icon-warning"></i>
          <span>说明</span>
        </template>
        <el-menu-item index="1-3">说明</el-menu-item>
        </el-submenu>-->
      </el-menu>
    </el-col>
    <router-view/>
  </div>
</template>

 <script >
// import MenuInfoData from "../data/mock/MenuMock";
export default {
  name: "Menu",
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
              title: "信息列表/home",
              path: "/home"
            }
          ]
        },
        {
          title: "评价系统",
          index: 2,
          subItems: [
            {
              title: "教师列表/about",
              path: "/about"
            },
            {
              title: "课程列表/about",
              path: "/about"
            },
            {
              title: "班级列表/about",
              path: "/about"
            }
          ]
        },
        {
          title: "个人系统",
          index: 3,
          subItems: [
            {
              title: "个人中心/app",
              path: "/app"
            }
          ]
        },
        {
          title: "系统管理",
          index: 4,
          subItems: [
            {
              title: "指标库/test",
              path: "/test"
            },
            {
              title: "系统/test",
              path: "/test"
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

