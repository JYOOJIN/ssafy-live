<script setup>
// @하면 src 경로
import IconMain from "@/components/icons/IconMain.vue"
import MainChild from "@/components/main/MainChild.vue";
import {ref} from "vue"


const msg=ref('SSAFY에 오신 여러분들 환영합니다.')
const name=ref("정유진")

const upMoney=()=>{
  console.log("용돈 UP")
  msg.value=name.value+" 용돈 UP"
}

//...val => 배열
const upMyMoney=(...val)=>{
  console.log(val)
  msg.value=name.value+" "+val[0]+"만원 용돈 UP"
}
 

const changeName=(cname)=>{
  name.value=cname;
}

</script>

<template>
  <div class="main">
    <h1><IconMain /> 화면입니다.</h1>
    <!-- <MainChild @money-event="upMoney"  my-msg="SSAFY에 오신 여러분들 환영합니다."/> -->
    <MainChild 
    @money-event="upMoney" 
    @up-money="upMyMoney" 
    @change-name="changeName"    
    :my-msg="msg"/>

  </div>
</template>

<style scoped></style>
