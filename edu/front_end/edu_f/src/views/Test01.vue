<template>
    <el-carousel indicator-position="outside">
    <el-carousel-item v-for="item in 4" :key="item">
      <h3>{{ item }}</h3>
    </el-carousel-item>
  </el-carousel>
</template>

<script>
export default {
    
}
</script>

<style>
 /* .el-carousel__item h3 {
    color: #475669;
    font-size: 90px;
    opacity: 0.75;
    line-height: 300px;
    margin: 0;
  }
  
  .el-carousel__item:nth-child(2n) {
    background-color: #0f68e4;
  }
  
  .el-carousel__item:nth-child(2n+1) {
    background-color: #e91818;
  } */
</style>

