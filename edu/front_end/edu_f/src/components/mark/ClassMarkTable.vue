<template>
  <div>
    <h1>classmarktable</h1>
    <el-button type="text" @click.prevent="closeClassMarkTable(false)">返回</el-button>
    <hr />
    <el-table :height="550" :data="classMarkTableData" border style="width: 100%">
      <el-table-column fixed prop="id" label="序号" width="50"></el-table-column>
      <el-table-column prop="mark" label="留言内容" width="auto"></el-table-column>
      <el-table-column prop="type" label="留言所属" width="150"></el-table-column>
      <!-- <el-table-column fixed="right" label="操作" width="50">
        <template slot-scope="scope">
          <el-button @click="deleteButton(scope.row)" type="text" size="small">删除</el-button>
        </template>
      </el-table-column>-->
    </el-table>
  </div>
</template>

<script>
export default {
  props: ["temp"],
  data() {
    return {
      classMarkTableData: []
    };
  },
  methods: {
    starcomponent() {
      this.$axios
        .get("http://localhost:8086/mark/findAllByClass/" + this.temp)
        .then(res => {
          this.classMarkTableData = res.data;
        });
    },
    closeClassMarkTable(data) {
      this.$emit("closebox1", data);
    }
  },
  created() {
    this.starcomponent();
  }
};
</script>