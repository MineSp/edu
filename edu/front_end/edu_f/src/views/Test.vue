<template>
  <div id="test">
    <el-main>
      <el-table :data="tableData">
        <el-table-column prop="date" label="日期" width="140"></el-table-column>
        <el-table-column prop="name" label="姓名" width="120"></el-table-column>
        <el-table-column prop="address" label="地址"></el-table-column>
      </el-table>
    </el-main>
    
    <table>
      <tr>
        <td>name</td>
        <td>id</td>
        <td>sex</td>
        <td>age</td>
      </tr>
      <tr v-for="item in stus" :key="item">
        <td>{{item.name}}</td>
        <td>{{item.id}}</td>
        <td>{{item.sex}}</td>
        <td>{{item.age}}</td>
      </tr>
    </table>
  </div>
</template>

<script>
export default {
  name: "Test",
  data() {
    const item = {
      date: "2016-05-02",
      name: "王小虎",
      address: "上海市普陀区金沙江路 1518 弄"
    };
    return {
      msg: "this is a Test page",
      stus: [
        { name: "a", id: "12345", sex: "mm", age: "12" },
        { name: "a", id: "12455", sex: "gg", age: "12" },
        { name: "a", id: "44545", sex: "gg", age: "13" },
        { name: "a", id: "23345", sex: "mm", age: "12" }
      ],
      tableData: Array(20).fill(item)
    };
  },
  created() {
    // alert(123),

    const _this = this;
    _this.$axios.get("http://localhost:8086/stu/findAll").then(function(res) {
      // alert(res),
      // console.log(res)
      _this.stus = res.data;
    });
  }
};
</script>
<style scoped>
#test {
  background-color: aqua;
  color: rgb(101, 42, 165);
  text-align: center;
}
</style>