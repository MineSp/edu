<template>
  <div>
    <el-dialog v-if="workerAboutVisible" width="20%" :visible.sync="workerAboutVisible">
      <worker-about :temp="workerid" v-on:closebox="closebox"></worker-about>
    </el-dialog>
    <el-dialog v-if="workerMarkVisible" width="30%" :visible.sync="workerMarkVisible">
      <worker-mark :temp="workerid" v-on:closebox1="closebox1"></worker-mark>
    </el-dialog>
    
    <el-dialog v-if="workerAnylizeVisible" width="80%" :visible.sync="workerAnylizeVisible">
      <worker-anylize :temp="workerid" v-on:closebox2="closebox2"> </worker-anylize>
    </el-dialog>
    <h1>教师列表</h1>
    <hr />
    <el-table :height="550" :data="workerTableData" border style="width: 100%">
      <el-table-column prop="name" label="姓名" width="120"></el-table-column>
      <el-table-column prop="sex" label="性别" width="300"></el-table-column>
      <el-table-column prop="age" label="年龄" width="120"></el-table-column>
      <el-table-column prop="edu" label="学历" width="150"></el-table-column>
      <el-table-column fixed="right" label="操作" width="200">
        <template slot-scope="scope">
          <el-button @click="aboutButton(scope.row)" type="text" size="small">查看</el-button>
          <el-button @click="markButton(scope.row)" type="text" size="small">评价</el-button>
          <el-button  @click="anylizebutton(scope.row)" type="text" size="small">数据分析</el-button>
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
import WorkerAbout from "./WorkerAbout";
import WorkerMark from "./WorkerMark";
import WorkerAnylize from "./WorkerAnylize";
export default {
  components: { WorkerAbout, WorkerMark,WorkerAnylize },
  data() {
    // testmsg:"";
    return {
      workerTableData: [],
      total: 10,
      pageSize: 3,
      workerid: 1,
      workerAboutVisible: false,
      workerMarkVisible: false,
      workerAnylizeVisible: false,
      id_id: 2
    };
  },
  created() {
    const _this = this;
    this.$axios.get("http://localhost:8086/worker/findAll/0/10").then(res => {
      _this.workerTableData = res.data.content;
      _this.total = res.data.totalElements;
      _this.pageSize = res.data.size;
    });
  },
  methods: {
    aboutButton(row) {
      // console.log(row);
      this.workerid = row.id;
      // this.workerTableData = true;
      this.workerAboutVisible = true;
      // console.log(this.workerAboutVisible);
    },
    markButton(row) {
      this.workerid = row.id;
      this.workerMarkVisible = true;
    },
    anylizebutton(row) {
      this.workerid = row.id;
      this.workerAnylizeVisible = true;
    },

    closebox(data) {
      // console.log(data);
      this.workerAboutVisible = data;
    },
    closebox1(data) {
      // console.log(data);
      this.workerMarkVisible = data;
    },
    closebox2(data) {
      // console.log(data);
      this.workerAnylizeVisible = data;
    },
    page(currentPage) {
      // this.tempRow = {};
      // this.currentPageTemp = currentPage;
      const _this = this;
      this.$axios
        .get(
          "http://localhost:8086/worker/findAll/" + (currentPage - 1) + "/10"
        )
        .then(res => {
          _this.workerTableData = res.data.content;
          // console.log(res.data);
          _this.total = res.data.totalElements;
          _this.pageSize = res.data.size;
        });
    }
  }
};
</script>