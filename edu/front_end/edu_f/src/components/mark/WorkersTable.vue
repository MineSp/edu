<template>
  <div>
    <el-dialog v-if="workerAboutVisible" width="20%" :visible.sync="workerAboutVisible">
      <worker-about :temp="workerid" v-on:closebox="closebox"></worker-about>
    </el-dialog>
    <el-dialog v-if="workerMarkVisible" width="30%" :visible.sync="workerMarkVisible">
      <worker-mark :temp="workerid" v-on:closebox1="closebox1"></worker-mark>
    </el-dialog>

    <el-dialog v-if="workerAnylizeVisible" width="80%" :visible.sync="workerAnylizeVisible">
      <worker-anylize :temp="workerid" v-on:closebox2="closebox2"></worker-anylize>
    </el-dialog>
    <h1>教师列表</h1>
    <hr />
    <el-table :height="550" :data="workerTableData" border style="width: 100%">
      <el-table-column prop="name" label="姓名" width="120"></el-table-column>
      <el-table-column prop="sex" label="性别" width="150"></el-table-column>
      <el-table-column prop="age" label="年龄" width="120"></el-table-column>
      <el-table-column prop="edu" label="学历" width="auto"></el-table-column>
      <el-table-column fixed="right" label="操作" width="200">
        <template slot-scope="scope">
          <el-button @click="aboutButton(scope.row)" type="text" size="small">查看</el-button>
          <el-button @click="markButton(scope.row)" type="text" size="small">评价</el-button>
          <el-button
            v-if="id_id ==2"
            @click="anylizebutton(scope.row)"
            type="text"
            size="small"
          >数据分析</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- <el-pagination
      background
      layout="prev, pager, next"
      :total="total"
      :page-size="pageSize"
      @current-change="page"
    ></el-pagination> -->
  </div>
</template>

<script>
import WorkerAbout from "./WorkerAbout";
import WorkerMark from "./WorkerMark";
import WorkerAnylize from "./WorkerAnylize";
export default {
  components: { WorkerAbout, WorkerMark, WorkerAnylize },
  data() {
    return {
      workerTableData: [],
      total: 10,
      pageSize: 3,
      workerid: 1,
      workerAboutVisible: false,
      workerMarkVisible: false,
      workerAnylizeVisible: false,
      id_id: 0
    };
  },
  created() {
    this.id_id = this.getCookie("id_id");
    const _this = this;
    // this.$axios.get("http://localhost:8086/worker/findAll/0/10").then(res => {
    //   _this.workerTableData = res.data.content;
    //   _this.total = res.data.totalElements;
    //   _this.pageSize = res.data.size;
    // });
    this.$axios
      .get(
        "http://localhost:8086/worker/findAllList/" +
          this.getCookie("useraccount") +
          "/" +
          this.getCookie("id_id")
      )
      .then(res => {
        // console.log(res.data);

        this.workerTableData = res.data;
        // console.log(this.workerTableData);

        _this.total = 0;
        _this.pageSize = 0;
      });
  },
  methods: {
    aboutButton(row) {
      this.workerid = row.id;
      this.workerAboutVisible = true;
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
      this.workerAboutVisible = data;
    },
    closebox1(data) {
      this.workerMarkVisible = data;
    },
    closebox2(data) {
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
          _this.total = res.data.totalElements;
          _this.pageSize = res.data.size;
        });
    }
  }
};
</script>