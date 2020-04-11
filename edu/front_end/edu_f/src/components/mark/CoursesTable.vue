<template>
  <div>
    <!-- about -->
    <el-dialog v-if="courseAboutVisible" width="50%" :visible.sync="courseAboutVisible">
      <course-about :temp="courseid" v-on:closebox="closebox"></course-about>
    </el-dialog>
    <!-- mark -->
    <el-dialog v-if="courseMarkVisible" width="30%" :visible.sync="courseMarkVisible">
      <course-mark :temp="courseid" v-on:closebox1="closebox1"></course-mark>
    </el-dialog>
    <!-- anylize -->
    <el-dialog v-if="courseAnylizeVisible" width="80%" :visible.sync="courseAnylizeVisible">
      <course-anylize :temp="courseid" v-on:closebox2="closebox2"></course-anylize>
    </el-dialog>
    <h1>课程列表</h1>
    <hr />

    <el-table :height="550" :data="courseTableData" border style="width: 100%">
      <el-table-column fixed prop="courseid" label="课程号" width="100"></el-table-column>
      <el-table-column prop="name" label="课程名字" width="200"></el-table-column>
      <!-- <el-table-column prop="type" label="课程类型" width="150"></el-table-column> -->
      <el-table-column prop="addr" label="上课地点" width="auto"></el-table-column>
      <el-table-column prop="time_week" label="上课时间" width="200"></el-table-column>
      <el-table-column fixed="right" label="操作" width="200">
        <template slot-scope="scope">
          <el-button @click="aboutButton(scope.row)" type="text" size="small">查看</el-button>
          <el-button @click="markButton(scope.row)" type="text" size="small">评价</el-button>
          <el-button v-if="id_id==2" @click="anylizeButton(scope.row)" type="text" size="small">数据分析图</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- <el-pagination
      background
      layout="prev, pager, next"
      :total="total"
      :page-size="pageSize"
      @current-change="page"
    ></el-pagination> -->
  </div>
</template>

<script>
import CourseAbout from "./CourseAbout";
import CourseMark from "./CourseMark";
import CourseAnylize from "./CourseAnylize";
export default {
  components: { CourseAbout, CourseMark, CourseAnylize },
  methods: {
    aboutButton(row) {
      this.courseid = row.id;
      // console.log(row);
      this.courseAboutVisible = true;
    },
    markButton(row) {
      this.courseid = row.id;
      this.courseMarkVisible = true;
    },
    anylizeButton(row) {
      this.courseid = row.id;
      this.courseAnylizeVisible = true;
    },

    closebox(data) {
      this.courseAboutVisible = data;
    },
    closebox1(data) {
      this.courseMarkVisible = data;
    },
    closebox2(data) {
      this.courseAnylizeVisible = data;
    },

    // page(currentPage) {
    //   const _this = this;
    //   this.$axios
    //     .get(
    //       "http://localhost:8086/course/findAll/" + (currentPage - 1) + "/10"
    //     )
    //     .then(res => {
    //       _this.courseTableData = res.data.content;
    //       // console.log(res.data);
    //       _this.total = res.data.totalElements;
    //       _this.pageSize = res.data.size;
    //     });
    // }
  },

  data() {
    return {
      courseTableData: [],
      pageSize: 10,
      total: 100,
      courseid: 0,
      courseAboutVisible: false,
      courseMarkVisible: false,
      courseAnylizeVisible: false,
      id_id :0,
    };
  },
  created() {
    this.id_id = this.getCookie("id_id");
    const _this = this;
    // this.$axios.get("http://localhost:8086/course/findAll/0/10").then(res => {
    //   _this.courseTableData = res.data.content;
    //   _this.total = res.data.totalElements;
    //   _this.pageSize = res.data.size;
    // });
        this.$axios.get("http://localhost:8086/course/findAllList/"+this.getCookie("useraccount")+"/"+this.getCookie("id_id")).then(res => {
      _this.courseTableData = res.data;
      // _this.total = res.data.totalElements;
      // _this.pageSize = res.data.size;
    });
  }
};
</script>