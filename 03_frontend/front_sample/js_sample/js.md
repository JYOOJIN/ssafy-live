## JavaScript 객체 Tree 구조

    Window (window 내장 객체) : 최상위 객체, window.alert("경고_확인메세지"); alert("메세지");
        ㄴ Document (document 내장객체)
            ㄴ Form (name=”” id=””)
                ㄴ Text (name=”” id=””)
                ㄴ Password
                ㄴCheckbox
                ㄴRadio
                ㄴSubmit
                ㄴReset
                ㄴSelect
                ㄴButton
            ㄴ Location (location 내장객체)
            ㄴ Image

## 이벤트 처리

1. 이벤트 소스: Text, Password, Checkbox, Window, Image 등
2. 이벤트: click, keydown, keyup, focus, change, load, submit, reset
3. 이벤트 핸들러: onClick(onclick) ="xxx", onKeydown, onChange, onSubmit

## 윈도우가 로드될때 이벤트 처리

    window.onload = function(){
        // 윈도우 초기화 설정
        // 초기화 함수 호출
        initLoad();
    }

    /* 윈도우 초기화 설정 함수 */
    function initLoad(){
        // 윈도우 초기화 설정
    }

## 내장함수

- window 객체의 함수
- window.함수명() / 함수명(): window.생략가능

1. alert("경고 또는 Modal 확인 메세지");

2. result = prompt("메세지", ["초기값"])

   - 초기값: 생략 가능. 브라우저에 따라서 미지정 시에 "", undefined

3. result=confirm("확인 메세지");

   - 확인/취소: boolean(true/false)

4. result = isNan(데이터);

   - 문자 데이터/숫자 데이터 여부 체킹
   - 문자 데이터: true
   - 숫자 데이터: false

5. intVar = parseInt(숫자 데이터);

   - int 형 변환

6. floatVar = parseFloat(숫자 데이터);

   - float 형 변환

7. result = eval(문자열 수식 or json 형식의 문자열);

## 내장함수 활용

- 사용자에게 상품의 수량을 입력받아서 상품의 주문금액을 출력하는 프로그램
- 데이터 검증: 오류 처리
  1. 미입력
  2. 공백 입력
  3. 문자 데이터 입력
  4. 음수 입력

## DOM 사용하기

- takeElement: document.getElementById("아이디명");
- takeElement: document.querySelector("#아이디명");

## Element property 동적 제어하기

- innerHTML: html 파싱 처리
- innerText: plain text

## 자바스크립트 배열

1. json 표기법 배열
   let 배열명 = [1,2];

2. let 배열명 = new Array(1,2);

## 연산자

- ==, != : 값만을 비교 ex) 1=="1" -> true
- ===, !== : 값과 타입 동일 여부 비교 ex) 1==="1" -> false
- % 연산자 없음!!!! -> mod(arg1,arg2) 함수 사용
