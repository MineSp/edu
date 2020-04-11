<template>
  <div>
    <h1>{{classAboutForm.name}}</h1>
    <hr />
    <div>
      <el-form height="10" ref="classAboutForm" :model="classAboutForm" label-width="25%">
        <!-- <el-form-item label="课程类型：">{{classAboutForm.name}}</el-form-item> -->
        <el-form-item label="所属学院：">
          <i>{{classAboutForm.collegename}}</i>
        </el-form-item>
        <el-form-item label="任课教师：">
          <i>{{classAboutForm.workername}}</i>
        </el-form-item>
        <!-- <el-form-item label="任课教师：">{{classAboutForm.specname}}</el-form-item>
        <el-form-item label="上课地点：">{{classAboutForm.addr}}</el-form-item>
        <el-form-item label="上课时间：">{{classAboutForm.time_week}}</el-form-item>-->
        <!-- <el-form-item label="学历：">{{classAboutForm.edu}}</el-form-item> -->
      </el-form>
    </div>
    <el-button type="primary" @click.prevent="closeClassAbout(false)">确认</el-button>
  </div>
</template>

<script>
export default {
  props: ["temp"],
  data() {
    return {
      classAboutForm: {}
    };
  },
  methods: {
    startComponent() {
      this.$axios
        .get("http://localhost:8086/class/findById/" + this.temp)
        .then(res => {
          this.classAboutForm = res.data;
        });
    },

    closeClassAbout(data) {
      this.$emit("closebox", data);
    }
  },
  created() {
    this.startComponent();
  }
};
</script>

<style >
.el-form-item {
  text-align: left;
}
</style>