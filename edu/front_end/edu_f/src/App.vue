<template>
  <div id="app">
    
    <div id>
      <router-link to="/home">Home</router-link>
      <router-link to="/">helloworld</router-link>
      <router-link to="/about">About</router-link>
      <router-link to="/test">Test</router-link>
      <router-link to="/test01">Test01</router-link>
      <router-link to="/dataanylize">Dataanylize</router-link>
      <router-link to="/menu">Menu</router-link>
    </div>
    <!-- <img src="./assets/logo.png"> -->
    <router-view />
  </div>
</template>

<script>
export default {
  name: "App"
};
</script>

<style>
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: rgb(red, green, blue);
  margin-top: 60px;
}
</style>
