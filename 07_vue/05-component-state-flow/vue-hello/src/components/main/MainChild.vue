<script setup>
import MainChildItem from "@/components/main/MainChildItem.vue"

// 1. props 배열 선언
//defineProps(['myMsg'])

// 2. props 객체 선언
const props= defineProps({
    myMsg:String,
})

console.log(props);

const childMsg="child에서 가공: "+props.myMsg;

const emit=defineEmits(['upMoney','changeName'])

const upMoney=()=>{
    // 인자값 전달
    emit("upMoney",10)
}


const changeName=(name)=>{
    emit("changeName",name)
}

</script>

<template>
    <div class="child">
        <h1>MainChild 입니다.</h1>
        <div>MainChild : {{ myMsg }}</div>
        <button @click="$emit('moneyEvent')">용돈 UP</button>
        <button @click="upMoney">용돈 10만원 UP</button>

        <!-- v-bind로 넘겨주면 childMsg가 변수가 된다 -->
        <MainChildItem @change-name="changeName"  :child-msg="childMsg" v-for="(i) in 3" :key="i"/>
    </div>
</template>

<style scoped>
.child{
    background-color: aquamarine;
}
</style>