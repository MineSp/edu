<template>
  <div>
    <h1>留言列表</h1>
    <hr />
    <el-table :height="550" :data="markTableData" border style="width: 100%">
      <el-table-column fixed prop="id" label="序号" width="50"></el-table-column>
      <el-table-column prop="mark" label="留言内容" width="auto"></el-table-column>
      <el-table-column prop="type" label="留言所属" width="150"></el-table-column>
      <el-table-column fixed="right" label="操作" width="50">
        <template slot-scope="scope">
          <el-button @click="deleteButton(scope.row)" type="text" size="small">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
export default {
  data() {
    return {
      markTableData: [
        {
          id: 1,
          type: "course",
          mark: "这个课程真好玩0"
        },
        {
          id: 2,
          type: "course",
          mark: "这个课程真好玩1"
        },
        {
          id: 3,
          type: "worker",
          mark: "这个老师真厉害"
        }
      ]
    };
  },
  created() {
    this.tableStart();
  },
  methods: {
    tableStart() {
      this.$axios.get("http://localhost:8086/mark/findAll").then(res => {
        this.markTableData = res.data;
      });
    },
    deleteButton(row) {
      this.$axios
        .delete("http://localhost:8086/mark/delete/" + row.id)
        .then(res => {
          if (res.status == 200) {
            this.$message.success("删除成功!");
            this.tableStart();
          } else {
            this.this.$message.error("删除成功!");
          }
        });
    }
  }
};
</script>