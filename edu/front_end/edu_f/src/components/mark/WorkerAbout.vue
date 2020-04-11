<template>
  <div>
    <h1>{{workerAboutForm.name}}</h1>
    <hr />
    <hr />
    <div>
      <el-form height="10" ref="workerAboutForm" :model="workerAboutForm" label-width="80px">
        <el-form-item label="学院：">
          <i>{{workerAboutForm.collegename}}</i>
        </el-form-item>
        <el-form-item label="工号：">
          <i>{{workerAboutForm.workerid}}</i>
        </el-form-item>
        <el-form-item label="性别：">
          <i>{{workerAboutForm.sex}}</i>
        </el-form-item>
        <el-form-item label="年龄：">
          <i>{{workerAboutForm.age}}</i>
        </el-form-item>
        <el-form-item label="手机号：">
          <i>{{workerAboutForm.phone}}</i>
        </el-form-item>
        <el-form-item label="邮箱：">
          <i>{{workerAboutForm.email}}</i>
        </el-form-item>
        <el-form-item label="学历：">
          <i>{{workerAboutForm.edu}}</i>
        </el-form-item>
      </el-form>
    </div>
    <el-button type="primary" @click.prevent="closeWorkerAbout(false)">确认</el-button>
  </div>
</template>

<script>
export default {
  name: "workerAbout",
  props: ["temp"],
  data() {
    return {
      workerAboutForm: {
        id: 1,
        workerid: 1,
        name: "name",
        sex: "女",
        age: 11,
        phone: 1,
        email: "11111@qq.com",
        collegename: "zz",
        edu: "bengke"
      }
    };
  },
  created() {
    console.log("created");
    const _this = this;
    console.log(this.temp);
    this.$axios
      .get("http://localhost:8086/worker/findById/" + this.temp)
      .then(res => {
        console.log(res);
        _this.workerAboutForm = res.data;
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