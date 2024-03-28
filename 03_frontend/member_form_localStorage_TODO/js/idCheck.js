/* idcheck.js */

/* 페이지 load 이벤트 핸들러 함수
        메인윈도우 정보 가져오기 :
        window.opener : open() 메소드로 윈도우를 연 문서가 있는 부모윈도우 객체
*/
window.onload = function () {
  //부모창에서 입력한 아이디 정보 가져오기
  let memberId = window.opener.document.getElementById("memberId").value;
  //현재창(자식창)의 아이디 입력항목의 초기값으로
  //부모창에서 입력한 아이디 초기화 수행
  document.getElementById("memberIdCheck").value = memberId;
};

/* 아이디 존재 유무 검사 메서드
        -- 아규먼트로 전달받은 아이디가 존재하는지 검사해서 존재하면 true 반환
*/
function isExist() {
  let memberIdString = localStorage.getItem("idList");

  let memberIdList = JSON.parse(memberIdString);
  for (let i = 0; i < memberIdList.length; i++) {
    if (memberIdList[i].includes(memberId)) {
      return true; //아이디가 중복된다
    }
  }

  // if (memberIdList == null) {
  //   return true;
  // } else {
  //   // 지금 여기 들어와서 문제 생긴다.
  //   // 문제를 잘못 이해한것 같다. 아이디 존재 유무 검사 메서드가 localstorage에서 가져와서 비교하는 메서드를 말하는 것같다.
  //   // 이 메서드를 이용해서 중복확인 버튼을 눌렀을 때 ~~~
  //   if (!memberIdString.includes(memberId)) {
  //     alert("중복없음");
  //     return true;
  //   } else {
  //     alert("중복있음");
  //     return false;
  //   }
  // }
}

/*  "아이디 중복확인" 요청 이벤트 리스너: 콜백함수 바인딩 
    - 함수이름 idCheckClick
    - id="memberIdCheckButton"
*/

function idCheckClick() {
  if (!isExist()) {
    //사용가능하다면
    document.getElementById("resultMessage").innerHTML = "아이디 사용 가능";
    document.getElementById("resultMessage").style.color = "green";
    document.getElementById("resultMessage").style.fontWeight = "bold";
    idCommit();
  } else {
    //사용 불가능하다면
    document.getElementById("resultMessage").innerHTML = "아이디 사용 불가능";
    document.getElementById("resultMessage").style.color = "red";
    document.getElementById("resultMessage").style.fontWeight = "bold";
  }
}

document.getElementById("memberIdCheckButton").addEventListener("click", function () {
  idCheckClick();
});

/* 검증받은 아이디 사용하기 : 
    idCheck.html (id="idCommitButton")
    함수이름: idCommit()
    검증받은 아이디로 부모윈도우(회원가입)의 아이디를 설정한후에
    현재윈도우(아이디검증) 닫고 부모윈도우(회원가입페이지)으로 이동 

*/

function idCommit() {
  let idCommitButtonElement = document.getElementById("idCommitButton");
  idCommitButtonElement.disabled = false;

  idCommitButtonElement.addEventListener("click", function () {
    window.opener.document.getElementById("memberId").value =
      document.getElementById("memberIdCheck").value;
    window.opener.document.getElementById("memberId").disabled = true;
    window.close();
  });
}

/* 취소 버튼 초기화 */
document.getElementById("resetButton").addEventListener("click", function () {
  document.getElementById("memberIdCheck").value = null;
  document.getElementById("memberIdCheck").focus();
});

/* memberIdCheck 키입력 이벤트 */
document.getElementById("memberIdCheck").addEventListener("keyup", function () {
  idCheckClick();
});
