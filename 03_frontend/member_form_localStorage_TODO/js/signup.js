/* signup.js */

// js 파일 로딩 확인하기
//alert("loading signup.js");
//console.log('loading signup.js');

let id = ["fds", "asf", "123"];
localStorage.setItem("idList", id);

/* 비밀번호 보이기/감추기 */

// checkbox 엘리먼트 가져오기
let isShowMemberPwElement = document.getElementById("isShowMemberPw");
//alert(isShowMemberPwElement);

// 어떤 이벤트가 발생될지 모를 때 이벤트 핸들러 붙여놓기
// click 이벤트가 발생하면
isShowMemberPwElement.addEventListener("click", function () {
  // 배열 선언 및 할당
  let text = ["보이기", "감추기"];

  // 보이기/감추기 엘리먼트 가져오기
  let isShowMemberPwTextElement = document.getElementById("isShowMemberPwText");

  // 비밀번호, 비밀번호 확인 엘리먼트 가져오기
  let memberPwElement = document.querySelector("#memberPw");
  let memberPwConfirmElement = document.getElementById("memberPwConfirm");

  // 체크박스 엘리먼트가 체크 여부 : Checkbox 속성 : checked (true/false)
  if (isShowMemberPwElement.checked) {
    // 보이기 설정
    memberPwElement.type = "text";
    memberPwConfirmElement.type = "text";
    isShowMemberPwTextElement.innerText = text[1];
  } else {
    // 감추기 설정
    memberPwElement.type = "password";
    memberPwConfirmElement.type = "password";
    isShowMemberPwTextElement.innerText = text[0];
  }
});

/* 비밀번호 show/hide 이미지 */

// 보이기/감추기 이미지 엘리먼트 가져오기
let isShowMemberPwImgElement = document.getElementById("isShowMemberPwImg");

// 보이기/감추기 설정 여부 위한 변수 설정
let isShow = true;
// 이미지 엘리먼트에 이벤트 리스터 작성하기
isShowMemberPwImgElement.addEventListener("click", function () {
  //배열 선언 및 할당
  let imgFile = ["./img/hide.png", "./img/show.png"];
  let imgTitle = ["비밀번호 감추기", "비밀번호 보이기"];

  // 비밀번호, 비밀번호 확인 엘리먼트 가져오기
  let memberPwElement = document.querySelector("#memberPw");
  let memberPwConfirmElement = document.getElementById("memberPwConfirm");

  // 이미지 보이기/감추기 여부 체킹
  if (isShow) {
    // 보이기 이미지 처리
    memberPwElement.type = "text";
    memberPwConfirmElement.type = "text";
    isShowMemberPwImgElement.src = imgFile[0];
    isShowMemberPwImgElement.title = imgTitle[0];
    isShow = false; // 이미지 토글 위한 설정
  } else {
    // 감추기 이미지 처리
    memberPwElement.type = "password";
    memberPwConfirmElement.type = "password";
    isShowMemberPwImgElement.src = imgFile[1];
    isShowMemberPwImgElement.title = imgTitle[1];
    isShow = true; // 이미지 토글 위한 설정
  }
});

/* 비밀번호, 비밀번호 확인 매핑하기 */
let memberPwElement = document.getElementById("memberPw");
let memberPwConfirmElement = document.getElementById("memberPwConfirm");

memberPwConfirmElement.addEventListener("keyup", function () {
  // 비밀번호 입력값, 비밀번호 확인 입력값 가져오기: element.value 속성(set/get)
  let memberPwValue = document.getElementById("memberPw").value;
  let memberPwConfirmValue = document.getElementById("memberPwConfirm").value;

  // 비밀번호 동일여부 결과 메세지 엘리먼트 가져오기
  let memberPwMessageElement = document.getElementById("memberPwMessage");

  // 비밀번호 확인: 데이터 입력 시에 비교
  if (memberPwConfirmValue.trim().length > 0) {
    if (memberPwValue.trim() === memberPwConfirmValue.trim()) {
      //동일한 경우
      memberPwMessageElement.innerText = "비밀번호 일치";
      memberPwMessageElement.style.color = "green";
      memberPwMessageElement.style.fontWeight = "bold";
    } else {
      //동일하지 않은 경우
      memberPwMessageElement.innerText = "비밀번호 불일치";
      memberPwMessageElement.style.color = "red";
      memberPwMessageElement.style.fontWeight = "bold";
      memberPwConfirmElement.focus();
    }
  } else {
    //비밀번호 확인 미입력 상태
    memberPwMessageElement.innerText = "";
  }
});

/* 휴대폰 중간번호 다음 입력항목 이동하기 */
let mobile2Element = document.getElementById("mobile2");

mobile2Element.addEventListener("keyup", function () {
  let mobile2Value = mobile2Element.value.trim();
  let mobile3Element = document.getElementById("mobile3");
  if (mobile2Value.length == 4) {
    mobile3Element.focus();
  }
});

/* 휴대폰 끝번호 다음 입력항목 이동하기 */
let mobile3Element = document.getElementById("mobile3");
mobile3Element.addEventListener("keyup", function () {
  let mobile3Value = mobile3Element.value.trim();
  let email1Element = document.getElementById("email1");
  if (mobile3Value.length == 4) {
    email1Element.focus();
  }
});

/* 이메일 선택 및 이메일 직접입력 */
// email2: 이메일 도메인 엘리먼트 가져오기
// emailChoose: 이메일 도메인 선택(select) 가져오기
let email2Element = document.getElementById("email2");
let emailChooseElement = document.getElementById("emailChoose");

// select는 change 할 때마다 확인해주어야 한다
// input은 keyup, 버튼은 click
emailChooseElement.addEventListener("change", function () {
  // email1(이메일 아이디) 입력 여부 데이터 가져오기
  let email1Element = document.getElementById("email1");
  let email1Value = document.getElementById("email1").value.trim();

  //email1(이메일 아이디) 입력 여부 체킹
  if (email1Value == null || email1Value.length == 0) {
    email1Element.placeholder = "이메일 아이디를 입력하세요";
    email1Element.focus();

    // select 첫번째 선택으로 초기화
    emailChooseElement.selectedIndex = 0;
  } else {
    // select에서 선택한 값 가져오기
    // let emailChooseValue = document.getElementById("emailChoose").value;
    let emailChooseValue = emailChooseElement.value;

    switch (emailChooseValue) {
      case "NONE":
        email2Element.value = "";
        email2Element.readOnly = true;
        break;
      case "USER_INPUT":
        email2Element.value = "";
        email2Element.readOnly = false;
        email2Element.focus();
        break;
      default:
        email2Element.value = emailChooseValue;
        email2Element.readOnly = true;
    }
  }
});

/* ID 중복확인 새창 열기 */
document.getElementById("idCheckOpen").addEventListener("click", function () {
  window.open("idcheck.html", "idcheck", "width=450,height=250,top=300,left=400");
});
/* 회원 사용자 객체 : 생성자 함수 선언 */

/* 회원객체 정보 */

/* 회원 가입 이벤트 리스너 */

/* 취소버튼 처리 : 회원가입양식 초기화, 아이디 항목 포커스 이동하기 */
