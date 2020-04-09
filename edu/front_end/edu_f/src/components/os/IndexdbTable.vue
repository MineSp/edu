<template>
  <div>
    <h1>这个是指标库页面儿</h1>
    <hr />
    <el-dialog v-if="indexdbAddVisible" width="30%" :visible.sync="indexdbAddVisible">
      <indexdb-add v-on:closebox="closebox"></indexdb-add>
    </el-dialog>

    <el-button @click="indexdbAddButton()" type="text">添加</el-button>
    <el-table :height="500" :data="indexTableData" border style="width: 100%">
      <el-table-column fixed prop="content" label="内容" width="auto"></el-table-column>
      <el-table-column fixed="right" label="操作" width="50">
        <template slot-scope="scope">
          <el-button @click="deleteButton(scope.row)" type="text" size="small">删除</el-button>
        </template>
      </el-table-column>
      <el-table-column fixed="right" label="是否启用" width="80">
        <template slot-scope="scope">
          <el-button
            v-if="scope.row.open==0"
            @click="startOpenButton(scope.row)"
            type="text"
            size="small"
          >启用</el-button>
          <el-button
            v-if="scope.row.open==1"
            @click="stopOpenButton(scope.row)"
            type="text"
            size="small"
          >停止</el-button>
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
import IndexdbAdd from "./IndexdbAdd";
export default {
  components: { IndexdbAdd },
  data() {
    return {
      indexTableData: [],
      total: 100,
      pageSize: 10,
      indexdbAddVisible: false
    };
  },
  created() {
    this.restarIndexdbTable();
  },
  methods: {
    /**
     * 初始化列表
     */
    restarIndexdbTable() {
      const _this = this;
      this.$axios
        .get("http://localhost:8086/indexdb/findAll/0/10")
        .then(res => {
          _this.indexTableData = res.data.content;
          _this.total = res.data.totalElements;
          _this.pageSize = res.data.size;
        });
    },
    indexdbAddButton() {
      this.indexdbAddVisible = true;
    },
    closebox(data) {
      this.indexdbAddVisible = data;
      this.restarIndexdbTable();
    },
    /**
     * 删除
     */
    deleteButton(row) {
      console.log(row);
      this.$axios
        .delete("http://localhost:8086/indexdb/delete/" + row.id)
        .then(res => {
          if (res.status == 200) {
            this.$message.success("删除成功!");
            this.restarIndexdbTable();
          }
        });
    },

    updateOpen(row, open) {
      row.open = open;
      this.$axios
        .put("http://localhost:8086/indexdb/updateOpen", row)
        .then(res => {
          this.$message.success(res.data);
          this.restarIndexdbTable();
        });
    },
    startOpenButton(row) {
      this.updateOpen(row, 1);
    },
    stopOpenButton(row) {
      this.updateOpen(row, 0);
    },
    page(currentPage) {
      // this.tempRow = {};
      // this.currentPageTemp = currentPage;
      const _this = this;
      this.$axios
        .get(
          "http://localhost:8086/indexdb/findAll/" + (currentPage - 1) + "/10"
        )
        .then(res => {
          _this.indexTableData = res.data.content;
          console.log(res.data);
          _this.total = res.data.totalElements;
          _this.pageSize = res.data.size;
        });
    }
  }
};
</script>

<style >
/* .el-table{
    margin: auto;
    text-align: center;
  } */
</style>