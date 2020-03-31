<template>
  <div id="test">
    <table>
      <tr>
        <td>name</td>
        <td>id</td>
        <td>sex</td>
        <td>age</td>
      </tr>
      <tr v-for="item in stus" :key="item">
        <td>{{item.name}}</td>
        <td>{{item.id}}</td>
        <td>{{item.sex}}</td>
        <td>{{item.age}}</td>
      </tr>
    </table>
  </div>
</template>

<script>
export default {
  name: "Test",
  data() {
    return {
      msg: "this is a Test page",
      stus: [
        { name: "a", id: "12345", sex: "mm", age: "12" },
        { name: "a", id: "12455", sex: "gg", age: "12" },
        { name: "a", id: "44545", sex: "gg", age: "13" },
        { name: "a", id: "23345", sex: "mm", age: "12" }
      ]
    };
  }
};
</script>
<style scoped>
#test {
  background-color: aqua;
  color: rgb(101, 42, 165);
  text-align: center;
}
</style>