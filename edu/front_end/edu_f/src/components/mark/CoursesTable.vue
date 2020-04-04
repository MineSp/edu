<template>
  <div>
    <h1>这个是班级页面儿</h1>
    <el-table :data="msgTableData" border style="width: 100%">
      <el-table-column fixed prop="time_publish" label="日期" width="100"></el-table-column>
      <el-table-column prop="title" label="标题" width="120"></el-table-column>
      <el-table-column prop="content" label="内容" width="auto"></el-table-column>
      <el-table-column prop="address" label="发布学院" width="150"></el-table-column>
      <el-table-column prop="id_person" label="发布人" width="120"></el-table-column>
      <el-table-column prop="enclosure" label="附件" width="150"></el-table-column>
      <el-table-column fixed="right" label="操作" width="130">
        <template slot-scope="scope">
          <el-button @click="handleClick(scope.row)" type="text" size="small">查看</el-button>
          <el-button type="text" size="small">编辑</el-button>
          <el-button type="text" size="small">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination background layout="prev, pager, next" :total="1000"></el-pagination>
  </div>
</template>

<script>
export default {
  methods: {
    handleClick(row) {
      console.log(row);
    }
  },

  data() {
    return {
      msgTableData: [
        {
          time_publish: "2016-05-02",
          title: "王小虎",
          content: "上海",
          id_person: "普陀区",
          address: "上海市普陀区金沙江路 1518 弄",
          enclosure: 200333
        },
        {
          time_publish: "2016-05-04",
          title: "王小虎",
          content: "上海",
          id_person: "普陀区",
          address: "上海市普陀区金沙江路 1517 弄",
          enclosure: 200333
        },
        {
          time_publish: "2016-05-01",
          title: "王小虎",
          content: "上海",
          id_person: "普陀区",
          address: "上海市普陀区金沙江路 1519 弄",
          enclosure: 200333
        },
        {
          time_publish: "2016-05-03",
          title: "王小虎",
          content: "上海",
          id_person: "普陀区",
          address: "上海市普陀区金沙江路 1516 弄",
          enclosure: 200333
        }
      ]
    };
  },
  created() {
   const _this = this;
    this.$axios.get("http://localhost:8086/msg/findAll").then(function(res) {
      //  alert(res.data.time_publish),
      _this.msgTableData = res.data;
    });
  },
};
</script>