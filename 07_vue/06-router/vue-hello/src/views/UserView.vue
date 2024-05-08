<!-- eslint-disable no-unused-vars -->
<script setup>
import {ref} from "vue"
import { useRoute,useRouter, onBeforeRouteLeave, onBeforeRouteUpdate} from 'vue-router';
const route=useRoute()
const router=useRouter()

//component 처음 load 될때만 실행
const userId=ref(route.params.id)

//뒤로가기 가능. stack에 쌓기
const goHome1=()=>{
    router.push({name:"home"})
}

//뒤로가기 불가능. 단순한 화면 전환
const goHome2=()=>{
    router.replace({name:"home"})
}

onBeforeRouteLeave((to,from)=>{
    const flag=window.confirm("정말 떠나니?")
    if(flag===false){
        return false;
    }
})

const changeUser=()=>{
    router.push({name:"user",params:{id:"kim"}})
}

onBeforeRouteUpdate((to,from)=>{
    userId.value=to.params.id
})

</script>

<template>
    <div>
        <h1>User View</h1>
        <!-- template 안에서는 $ 사용 지양 -->
        <h2>{{ $route.params.id }} 님 프로필 입니다.</h2>
        <h2>{{ userId }} 님 프로필 입니다.</h2>

        <button @click="goHome1">홈으로(push)</button> &nbsp;
        <button @click="goHome2">홈으로(replace)</button>
        <button @click="changeUser">사용자 전환</button>
    </div>
</template>

<style scoped>

</style>