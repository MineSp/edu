<template>
  <div>
    <h1>课程列表</h1>
    <hr />
    <el-table :height="550" :data="classTableData" border style="width: 100%">
      <el-table-column prop="name" label="班级" width="250"></el-table-column>
      <el-table-column prop="id_spec" label="专业" width="300"></el-table-column>
      <el-table-column prop="id_college" label="学院" width="300"></el-table-column>
      <el-table-column prop="id_worker" label="班主任" width="auto"></el-table-column>
      <el-table-column fixed="right" label="操作" width="50">
        <template slot-scope="scope">
          <el-button @click="handleClick(scope.row)" type="text" size="small">查看</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      background
      layout="prev, pager, next"
      :total="total"
      :page-size="pageSize"
      @current-change="page"
    ></el-pagination>
  </div>
</template>

<script>
export default {
  data() {
    return {
      classTableData: [],
      total: 100,
      pageSize: 10
    };
  },
  created() {
    const _this = this;
    this.$axios.get("http://localhost:8086/class/findAll/0/10").then(res => {
      _this.classTableData = res.data.content;
      console.log(res.data.content);
      _this.total = res.data.totalElements;
      _this.pageSize = res.data.size;
    });
  },
  methods: {
    handleClick(row) {
      console.log(row);
    },
    page(currentPage) {
      // this.tempRow = {};
      // this.currentPageTemp = currentPage;
      const _this = this;
      this.$axios
        .get("http://localhost:8086/class/findAll/" + (currentPage - 1) + "/10")
        .then(res => {
          _this.classTableData = res.data.content;
          // console.log(res.data);
          _this.total = res.data.totalElements;
          _this.pageSize = res.data.size;
        });
    }
  }
};
</script>