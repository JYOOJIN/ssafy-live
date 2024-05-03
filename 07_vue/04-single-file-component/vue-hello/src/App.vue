<script setup>
import AppBoard from "./components/AppBoard.vue";
import AppHeader from "./components/AppHeader.vue";
import AppMain from "./components/AppMain.vue";
import { ref } from "vue";

const view=ref('main')
</script>

<template>
  <div>
    <AppHeader/>
    <div>
      <button @click="view='main'">main</button>
      <button @click="view='board'">게시판</button>
    </div>
    <AppMain v-if="view=='main'"/>
    <AppBoard v-if="view=='board'"/>
  </div>
</template>

<style scoped>

</style>