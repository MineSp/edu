<template>
  <div id="HeaderBar">
    <el-header>
      <el-dropdown>
        <span>
          王小虎
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item>个人中心</el-dropdown-item>
            <el-dropdown-item>登录</el-dropdown-item>
            <el-dropdown-item>退出登录</el-dropdown-item>
          </el-dropdown-menu>
        </span>
      </el-dropdown>
    </el-header>
  </div>
</template>

<style >
.el-header {
  border: 1px solid #eee;
  background-color: rgba(112, 133, 133, 0.279);
  text-align: right;
  font-size: 20px;
  float: none;

  
}

</style>