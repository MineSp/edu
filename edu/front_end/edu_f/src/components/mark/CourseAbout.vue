<template>
  <div>
    <h1>{{courseAboutForm.name}}</h1>
    <hr />
    <hr />
    <div>
      <el-form height="10" ref="courseAboutForm" :model="courseAboutForm" label-width="100px">
        <el-form-item label="课程类型：">
          <i>{{courseAboutForm.typename}}</i>
        </el-form-item>
        <el-form-item label="开设时间：">
          <i>{{courseAboutForm.time_start}}</i>
        </el-form-item>
        <el-form-item label="所属学院：">
          <i>{{courseAboutForm.collegename}}</i>
        </el-form-item>
        <el-form-item label="任课教师：">
          <i>{{courseAboutForm.workername}}</i>
        </el-form-item>
        <el-form-item label="上课地点：">
          <i>{{courseAboutForm.addr}}</i>
        </el-form-item>
        <el-form-item label="上课时间：">
          <i>{{courseAboutForm.time_week}}</i>
        </el-form-item>
        <!-- <el-form-item label="学历：">{{courseAboutForm.edu}}</el-form-item> -->
      </el-form>
    </div>
    <el-button type="primary" @click.prevent="closeWorkerAbout(false)">确认</el-button>
  </div>
</template>


<script>
export default {
  name: "CourseAbout",
  props: ["temp"],
  data() {
    return {
      courseAboutForm: {
        id: 1,
        courseid: 1,
        name: "name",
        typename: "女",
        time_start: "",
        collegename: "zz",
        workername: 11,
        addr: "教三",
        time_week: "mon 1 2, thur 5 6"
      }
    };
  },
  created() {
    console.log("created");
    const _this = this;
    console.log(this.temp);
    this.$axios
      .get("http://localhost:8086/course/findById/" + this.temp)
      .then(res => {
        console.log(res);
        _this.courseAboutForm = res.data;
      });
  },
  methods: {
    closeWorkerAbout(doit) {
      console.log("test", this.test);
      //   console.log(props);
      this.$emit("closebox", doit);
    }
  }
};
</script>

<style >
.el-form-item {
  text-align: left;
}
</style>