<template>
  <div id="msgAdd">
    <h1>This is a message about</h1>
    <el-form ref="form" :model="form" :rules="rules" label-width="80px">
      <el-form-item label="标题" prop="title">
        <el-input v-model="form.title"></el-input>
      </el-form-item>

      <el-form-item label="信息内容" prop="content">
        <el-input type="textarea" rows="10px" cols="20px" v-model="form.content"></el-input>
      </el-form-item>

      <el-upload
        class="upload-demo"
        drag
        action="https://jsonplaceholder.typicode.com/posts/"
        multiple
      >
        <i class="el-icon-upload"></i>
        <div class="el-upload__text">
          将文件拖到此处，或
          <em>点击上传</em>
        </div>
        <div class="el-upload__tip" slot="tip">上传文件不超过1M</div>
      </el-upload>
      <el-form-item>
        <el-button type="primary" @click="onSubmit('form')">发布</el-button>
        <el-button @click="resetForm('form')">取消</el-button>
        <el-button @click="test">test</el-button>
      </el-form-item>
    </el-form>
  </div>
</template> 


<script>
export default {
  data() {
    return {
      form: {
        title: "",
        content: ""
      },
      rules: {
        title: [
          { required: true, message: "请为新信息提供标题", trigger: "blur" }
        ],
        content: [
          { required: true, message: "通知内容不能为空", trigger: "blur" }
        ]
      }
    };
  },
  methods: {
    test() {
      console.log(this.form);
    },
    //重置表单
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
    //提交表单
    onSubmit(formName) {
      const _this = this;
      this.$refs[formName].validate(valid => {
        if (valid) {
         console.log(_this.form);
        }
      });
    }
  }
};
</script>

<style>
#msgadd {
  width: 1000px;
}
</style>