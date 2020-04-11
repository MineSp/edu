<template>
  <div>
    <h1>评价</h1>
    <hr />
    <h4>__分数为0~100__</h4>
    <hr />
    <div>
      <el-form height="10" ref="workerMarkForm" :model="workerMarkForm" label-width="80px">
        <el-form-item v-for=" item in indexOpenData" :key="item" :label="item.content">
          <el-input v-model="item.score"></el-input>
        </el-form-item>
        <el-form-item label="留言">
          <el-input v-model="workerMarkForm.mark"></el-input>
        </el-form-item>
      </el-form>
    </div>
    <el-button type="primary" @click.prevent="closeWorkerMark(false)">确认</el-button>
  </div>
</template>

<script>
export default {
  props: ["temp"],
  data() {
    return {
      workerMarkForm: {},
      indexOpenData: [
        {
          id: 1,
          content: "有趣值"
        },
        {
          content: "活跃值"
        }
      ]
    };
  },
  methods: {
    closeWorkerMark(doit) {
      this.workerMarkForm.list = this.indexOpenData;
      this.workerMarkForm.id_person = this.getCookie("useraccount");
      this.workerMarkForm.type = 1;
      this.workerMarkForm.id_type = this.temp;
      // console.log("?", this.workerMarkForm);
      // console.log("??", this.indexOpenData);
      this.$axios
        .post("http://localhost:8086/comment/saveAll", this.workerMarkForm)
        .then(res => {
          console.log(res.data);
          if (res.data == "success") {
            this.$message("评价成功");
            this.$emit("closebox1", doit);
          }else{
            this.$message("评价失败")
          }
        });
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