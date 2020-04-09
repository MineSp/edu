
<template>
  <div>
    <div>
      <TopBar />
    </div>
    <router-view />
  </div>
</template>

<script>
// import { menu } from "./components/Menu";
import TopBar from "./components/TopBar";
export default {
  name: "App",
  components: { TopBar }
};
</script>

<style>
#app {
  width: 1080;
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: rgb(61, 115, 169);
  /* margin-top: 60px; */
}
</style>
