/* eslint-disable no-unused-vars */
import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import UserView from '@/views/UserView.vue'
import LoginView from '@/views/LoginView.vue'



const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/about',
      name: 'about',
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import('../views/AboutView.vue')
    },
    {
      path: '/user/:id',
      name:'user',
      component: UserView,
      beforeEnter: (to, from) => { 
        console.log(to)
        console.log(from)
      }
    },
    {
      path: '/login',
      name:'login',
      component: LoginView,
      beforeEnter:loginCheck()
    },
  ]
})

function loginCheck(to,from){
  const isLogin=true;
  if(isLogin){ 
    console.log("로그인 상태입니다.")
    return {name:"home"}
  }
}



// to: 이동할 url 정보를 가진 router 객체
// from: 현재 url 정보를 가진 router 객체
// router.beforeEach((to,from)=>{
//   console.log("beforeEach 호출")
//   console.log(to)
//   console.log(from)
// })

// 1. Global Guard : 모든 페이지에서 해야하는 것
// router.beforeEach((to,from)=>{
//   const isLogin=false; //서버에서 로그인 여부 체크

//   if(!isLogin && to.name!=='login'){ //로그인 안했고, 현재 로그인 페이지가 아니라면
//     console.log("로그인이 필요합니다.")
//     return {name:"login"}
//   }
// })



export default router
