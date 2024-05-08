<script setup>
import {ref} from "vue"
import IconMain from "@/components/icons/IconMain.vue"
import MainChild from "@/components/main/MainChild.vue";

const msg = ref("SSAFY에 오신것을 환영합니다.")
const name = ref("안효인")

const upMoney = () => {
  console.log("용돈 올려줄거야!!!!")
  msg.value = name.value + " 용돈 올려줄거야!!!!"
}

const upMyMoney = (...val) => {
  console.log(val)
  msg.value = name.value + " " + val[3] + "만원 용돈 올려줄거야!!!!"
}

const changeName = (cname) => {
  name.value = cname
}

</script>

<template>
  <div class="main">
    <h1><IconMain /> 화면입니다.</h1>
    <!-- <MainChild @money-event="upMoney" my-msg="SSAFY에 오신것을 환영합니다." /> -->
    <MainChild 
      :msg="1"
      @money-event="upMoney" 
      @up-money="upMyMoney" 
      @change-name="changeName" 
      :my-name="name"
      :my-msg="msg" />
  </div>
</template>

<style scoped></style>
