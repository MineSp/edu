<template>
  <div>
    <h1>添加指标</h1>
    <hr />
    <el-form>
      <el-form ref="indexdbAddForm" :model="indexdbAddForm" :rules="rules" label-width="30%">
        <el-form-item label="内容：" prop="content">
          <el-input style="width:70%" type="text" v-model="indexdbAddForm.content"></el-input>
        </el-form-item>
        <el-button type="primary" @click="IndexdbAddSubmit('indexdbAddForm')">确定</el-button>
        <el-button @click="backButton(false)">取消</el-button>
      </el-form>
    </el-form>
    <hr />
  </div>
</template>

<script>
export default {
  data() {
    return {
      indexdbAddForm: {
        content: ""
      },
      rules: {
        content: [{ required: true, message: "内容不能为空", trigger: "blur" }]
      }
    };
  },
  methods: {
    IndexdbAddSubmit(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
            console.log(this.indexdbAddForm);
            this.$axios.post("http://localhost:8086/indexdb/save" ,this.indexdbAddForm).then(res=>{
                this.$message.success(res.data);
                this.backButton(false);
            })
        } else {
            this.$message.error("请按照要求填写！");
        }
      });
    },

    backButton(doit) {
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