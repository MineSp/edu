<template>
  <div>
    <h1>消息列表</h1>
    <hr width=50% />
    <!-- 添加按钮 -->
    <span>
      <el-button type="text" @click="addMsgDailog">添加</el-button>
    </span>
    <hr width=100% />

    <!-- 表格 -->
    <el-table :height="500" :data="msgTableData" border style=" width: 100%">
      <el-table-column fixed prop="time_publish" label="日期" width="100"></el-table-column>
      <el-table-column prop="title" label="标题" width="120"></el-table-column>
      <el-table-column prop="content" label="内容" width="auto"></el-table-column>
      <!-- <el-table-column prop="address" label="发布学院" width="150"></el-table-column> -->
      <!-- <el-table-column prop="id_person" label="发布人" width="120"></el-table-column> -->
      <!-- <el-table-column prop="enclosure" label="附件" width="150"></el-table-column> -->
      <el-table-column fixed="right" label="操作" width="130">
        <template slot-scope="scope">
          <el-button @click="showMsgAbout(scope.row)" type="text" size="small">查看</el-button>
          <el-button type="text" size="small" @click="updateMsg(scope.row)">修改</el-button>
          <el-button type="text" size="small" @click="DelMsg(scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <!-- 分页器 -->
    <el-pagination
      background
      layout="prev, pager, next"
      :total="total"
      :page-size="pageSize"
      @current-change="page"
    ></el-pagination>

    <!-- 模态对话框实现添加 修改 查看-->
    <el-dialog
      :title="dialogTitle"
      :visible.sync="dialogVisible"
      width="50%"
      @close="handleClose()"
    >
      <span>
        <el-form ref="msgForm" :model="msgForm" :rules="rules" label-width="80px">
          <el-form-item label="标题" prop="title">
            <el-input :readonly="isReadOnly ?  'readonly':false" v-model="msgForm.title"></el-input>
          </el-form-item>

          <el-form-item label="信息内容" prop="content">
            <el-input
              :readonly="isReadOnly ?  'readonly':false"
              type="textarea"
              rows="9px"
              cols="15px"
              v-model="msgForm.content"
            ></el-input>
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
        </el-form>
      </span>
      <span slot="footer" class="dialog-footer">
        <el-button type="primary" @click="isSubmit?onAdd('msgForm'):onUpdate('msgForm'  )">确定</el-button>
        <el-button @click="resetForm('msgForm')">返回</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
export default {
  data() {
    const _this = this;
    return {
      msgForm: {
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
      },

      /**
       * 记录当前页面位置
       */
      currentPageTemp: "",
      /**
       * input元素是否只读
       */
      isReadOnly: false,
      /**
       * 判断是提交还是修改
       * ture 提交
       * fales 修改
       */
      isSubmit: true,
      /**
       * 当前模态对话框的标题
       */
      dialogTitle: "",
      /**
       *total 数据总量
       */
      total: "10",
      /**
       * pageSize 每页要展示的最大数据条数
       */
      pageSize: "10",
      /**
       * msgTableData 数据绑定变量
       */
      dialogVisible: false,
      /**
       * table数据主体
       */
      msgTableData: [],
      tempRow: {}
    };
  },
  created() {
    const _this = this;
    this.$axios.get("http://localhost:8086/msg/findAll/0/10").then(res => {
      _this.msgTableData = res.data.content;
      _this.total = res.data.totalElements;
      _this.pageSize = res.data.size;
    });
  },
  methods: {
    /**
     * 页面跳转
     */
    page(currentPage) {
      this.tempRow = {};
      this.currentPageTemp = currentPage;
      const _this = this;
      this.$axios
        .get("http://localhost:8086/msg/findAll/" + (currentPage - 1) + "/10")
        .then(res => {
          _this.msgTableData = res.data.content;
          console.log(res.data);
          _this.total = res.data.totalElements;
          _this.pageSize = res.data.size;
        });
    },

    /**
     *打开模态窗口
     */
    addMsgDailog() {
      this.isReadOnly = false;
      this.dialogTitle = "添加信息";
      this.dialogVisible = true;
    },
    /**
     * 查看信息按钮函数
     */
    showMsgAbout(row) {
      //row 当前行的对象
      this.dialogTitle = "信息详情";
      this.isReadOnly = true;
      this.dialogVisible = true;
      this.$axios
        .get("http://localhost:8086/msg/findById/" + row.id)
        .then(res => {
          console.log(res);
          this.msgForm.title = res.data.title;
          this.msgForm.content = res.data.content;
        });
      // console.log(row);
    },
    /**
     * 修改信息按钮函数
     */
    updateMsg(row) {
      this.dialogTitle = "信息修改";
      this.isSubmit = false;
      this.isReadOnly = false;
      this.dialogVisible = true;
      this.$axios
        .get("http://localhost:8086/msg/findById/" + row.id)
        .then(res => {
          // console.log(res);
          this.tempRow = res.data;
          console.log(this.tempRow);
          this.msgForm.title = res.data.title;
          this.msgForm.content = res.data.content;
        });
    },

    /**
     * 删除按钮函数
     */
    DelMsg(row) {
      const _this = this;
      this.$axios
        .delete("http://localhost:8086/msg/deleteById/" + row.id)
        .then(res => {
          if (res.status == 200) {
            this.$message("删除成功!");
            _this.page(1);
          }
          // console.log(res);
        });
    },
    /**
     * 确定函数之--添加
     */
    onAdd(formName) {
      if (this.dialogTitle != "信息详情") {
        this.isSubmit = true;
        const _this = this;
        this.$refs[formName].validate(valid => {
          if (valid) {
            this.$axios
              .post("http://localhost:8086/msg/save", this.msgForm)
              .then(res => {
                console.log(res);
                if (res.data == "success") {
                  this.$message("添加成功");
                  _this.dialogVisible = false;
                  _this.page(_this.currentPageTemp);
                } else {
                  this.$message("添加失败");
                }
              });
            // console.log(_this.form);
          } else {
            this.$message("请不要留空!!!");
          }
        });
      } else {
        this.dialogVisible = false;
      }
    },

    /**
     * 确定按钮之--修改
     */
    onUpdate(formName) {
      this.isSubmit = false;
      const _this = this;
      this.$refs[formName].validate(valid => {
        if (valid) {
          this.tempRow.title = this.msgForm.title;
          this.tempRow.content = this.msgForm.content;
          this.$axios
            .put("http://localhost:8086/msg/update", this.tempRow)
            .then(res => {
              console.log(res);
              if (res.data == "success") {
                this.$message("修改成功");
                _this.page(_this.currentPageTemp);
                _this.dialogVisible = false;
              } else {
                this.$message("修改失败");
              }
            });
        } else {
          this.$message("请不要留空!!!");
        }
      });
    },
    /**
     * 重置对话表单
     */
    resetForm(formName) {
      this.$refs[formName].resetFields();
      this.dialogVisible = false;
    },
    /**
     * 对话框关闭后重置数据
     */
    handleClose() {
      this.$refs["msgForm"].resetFields();
      dialogVisible: false;
    }
  }
};
</script>