<script setup>
import { ref } from "vue"

const name = ref("")

defineProps({
    childMsg: String
})

const emit = defineEmits(['changeName'])
const changeName = () => {
    emit('changeName', name.value)
}
</script>

<template>
    <div class="child-item">
        <h1>MainChildItem입니다.</h1>
        <div>{{ childMsg }}</div>
        <div>자식이름 : <input type="text" v-model="name" @keyup.enter="changeName"></div>
    </div>
</template>

<style scoped>
.child-item {
    background-color: aqua;
}
</style>