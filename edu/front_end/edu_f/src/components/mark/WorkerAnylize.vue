<template>
  <div>
    <h1>图表分析</h1>
    <hr />
    <span>
      <!--为echarts准备一个具备大小的容器dom-->
      <div id="echartsTable" style="width: 300px;height: 300px;"></div>
    </span>
    <el-button type="primary" @click.prevent="closeWorkerAnylize(false)">确认</el-button>
  </div>
</template>
<script>
import echarts from "echarts";
export default {
  name: "",
  props: ["temp"],
  data() {
    return {
      charts: "",
      opinion: ["好"],
      opinionData: [
        { name: "好", value: 90 },
        { name: "剩余", value: 10 }
      ]
    };
  },
  created() {
    this.$axios
      .get("http://localhost:8086/comment/anylizeData/" + "1" + "/" + this.temp)
      .then(res => {
        this.opinionData = res.data;
        this.drawPie("echartsTable");
      });
  },
  methods: {
    drawPie(id) {
      this.charts = echarts.init(document.getElementById(id));
      this.charts.setOption({
        tooltip: {
          trigger: "item",
          formatter: "{a}<br/>{b}:{c} ({d}%)"
        },
        legend: {
          orient: "vertical",
          x: "left",
          data: this.opinion
        },
        series: [
          {
            name: "倾向",
            type: "pie",
            radius: ["20%", "70%"],
            avoidLabelOverlap: false,
            label: {
              normal: {
                show: false,
                position: "center"
              },
              emphasis: {
                show: true,
                textStyle: {
                  fontSize: "20",
                  fontWeight: "blod"
                }
              }
            },
            labelLine: {
              normal: {
                show: true
              }
            },

            data: this.opinionData
          }
        ]
      });
    },
    closeWorkerAnylize(doit) {
      console.log("test", this.test);
      //   console.log(props);
      this.$emit("closebox2", doit);
    }
  },
  //调用
  mounted() {
    // this.$nextTick(function() {
    //   this.drawPie("main");
    // });
  }
};
</script>
<style scoped>
* {
  padding: 0;
  list-style: none;
  margin: auto;
}
</style>