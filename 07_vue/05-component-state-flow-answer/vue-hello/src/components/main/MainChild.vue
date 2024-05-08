<script setup>
import MainChidItem from "@/components/main/MainChildItem.vue"
// 1. props 배열 선언
// defineProps(['myMsg'])

// 2. props 객체 선언
const props = defineProps({
    myMsg: String,
    myName: String,
    msg: Number
})


console.log(props)
console.log(props.msg)
// props.myMsg = "aaaa";

const childMsg = "child에서 가공 : " + props.myMsg;

const emit = defineEmits(['upMoney', 'changeName'])

const upMoney = () => {
    emit("upMoney", 10, 20, 30, 40)
}

const changeName = (name) => {
    emit("changeName", name)
}
</script>

<template>
    <div class="child">
        <h1>MainChild 입니다.</h1>
        <h3>{{ myName }}</h3>
        <div>MainChild : {{ myMsg }}</div>
        <button @click="$emit('moneyEvent')">용돈업</button>
        <button @click="upMoney">용돈10만업</button>
        <MainChidItem @change-name="changeName" :child-msg="childMsg" v-for="(i) in 3"/>
    </div>
</template>

<style scoped>
.child {
    background-color: antiquewhite;
}
</style>