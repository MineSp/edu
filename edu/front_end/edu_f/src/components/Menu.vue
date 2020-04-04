<template>
  <div id="app">
    <div class="right">
      <el-col :span="12">
        <el-container>
          <el-aside>
            <el-menu router class="el-menu-vertical-demo" @open="handleOpen" @close="handleClose">
              <el-menu-item index="/">
                <i class="el-icon-menu"></i>
                <span slot="title">首页</span>
              </el-menu-item>

              <el-submenu v-for="(item,index) in $router.options.routes" :key="item" :index="index">
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
            <el-header>
              <el-dropdown>
                <i class="el-icon-setting" style="margin-right: 15px"></i>
                <el-dropdown-menu slot="dropdown">
                  <el-dropdown-item>个人中心</el-dropdown-item>
                  <el-dropdown-item>登录</el-dropdown-item>
                  <el-dropdown-item>退出登录</el-dropdown-item>
                </el-dropdown-menu>
              </el-dropdown>
              <span>王小虎</span>
            </el-header>
            <el-main>
              <router-view />
            </el-main>
          </el-container>
        </el-container>
      </el-col>
    </div>
  </div>
</template>