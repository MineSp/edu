<template>
  <div>
    <h1>课程列表</h1>
    <hr />
    <!-- about -->
    <el-dialog v-if="classAboutVisible" width="30%" :visible.sync="classAboutVisible">
      <class-about :temp="classid" v-on:closebox="closebox"></class-about>
      <!-- <course-about></course-about> -->
    </el-dialog>
    <!-- marka table -->
    <el-dialog v-if="classMarkAboutVisible" width="30%" :visible.sync="classMarkAboutVisible">
      <class-mark-table :temp="classid" v-on:closebox1="closebox1"></class-mark-table>
      <!-- <course-mark ></course-mark> -->
    </el-dialog>
    <el-table :height="550" :data="classTableData" border style="width: 100%">
      <el-table-column prop="id" label="序号" width="50"></el-table-column>
      <el-table-column prop="name" label="班级" width="auto"></el-table-column>
      <!-- <el-table-column prop="id_spec" label="专业" width="300"></el-table-column>
      <el-table-column prop="id_college" label="学院" width="300"></el-table-column>
      <el-table-column prop="id_worker" label="班主任" width="auto"></el-table-column>-->
      <el-table-column fixed="right" label="操作" width="150">
        <template slot-scope="scope">
          <el-button @click="aboutButton(scope.row)" type="text" size="small">查看</el-button>
          <el-button @click="markAboutButton(scope.row)" type="text" size="small">评价信息</el-button>
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
import ClassAbout from "./ClassAbout";
import ClassMarkTable from "./ClassMarkTable";
export default {
  components: { ClassAbout, ClassMarkTable },
  data() {
    return {
      classTableData: [],
      total: 100,
      pageSize: 10,
      classAboutVisible: false,
      classMarkAboutVisible: false,
      classid: 0
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
    aboutButton(row) {
      this.classid = row.id;
      this.classAboutVisible = true;
      // console.log(row);
    },
    markAboutButton(row) {
      this.classid = row.id;
      this.classMarkAboutVisible = true;
    },

    closebox(data) {
      this.classAboutVisible = false;
    },
    closebox1(data) {
      this.classMarkAboutVisible= false;
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