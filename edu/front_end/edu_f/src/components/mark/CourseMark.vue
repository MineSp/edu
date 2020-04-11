<template>
  <div>
    <h1>课程评价</h1>
    <hr />
    <h4>__分数为0~100__</h4>
    <hr />
    <div>
      <el-form height="10" ref="courseMarkForm" :model="courseMarkForm" label-width="80px">
        <el-form-item v-for=" item in indexOpenData" :key="item" :label="item.content">
          <el-input v-model="item.score"></el-input>
        </el-form-item>
        <el-form-item label="留言">
          <el-input v-model="courseMarkForm.mark"></el-input>
        </el-form-item>
      </el-form>
    </div>
    <el-button type="primary" @click.prevent="closeCourseMark(false)">确认</el-button>
  </div>
</template>

<script>
export default {
  props: ["temp"],
  data() {
    return {
      courseMarkForm: {},
      indexOpenData: [
        {
          content: "有趣值"
        }
      ]
    };
  },
  methods: {
    closeCourseMark(doit) {
      this.courseMarkForm.list = this.indexOpenData;
      this.courseMarkForm.id_person = this.getCookie("useraccount");
      this.courseMarkForm.type = 0;
      this.courseMarkForm.id_type = this.temp;
      this.$axios
        .post("http://localhost:8086/comment/saveAll", this.courseMarkForm)
        .then(res => {
          console.log(res.data);
          if (res.data == "success") {
            this.$message("评价成功");
          } else {
            this.$message("评价失败");
          }
        });
        this.$emit("closebox1", doit);
    }
  },
  created() {
    const _this = this;
    this.$axios.get("http://localhost:8086/indexdb/findAllOpen").then(res => {
      _this.indexOpenData = res.data;
    });
  }
};
</script>

<style >
.el-carousel__item {
  background-color: #d8dde4;
}
</style>