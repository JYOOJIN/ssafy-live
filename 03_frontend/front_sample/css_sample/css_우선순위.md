## css 우선순위

## 선택자(selector)

## 일반 선택자

    - 공통: *
    - 타입(태그): 태그 명
    - 클래스: 태그명.클래스명 or .클래스명
    - 아이디: #아이디명 or 태그명#아이디명

## 복합 선택자

    - 다중 선택자: 태그명1, 태그명2
    - 후손(자손): 태그명1 자손태그명
    - 자식: 태그명 > 자식태그명
    - 형제(인접): 태그명 + 인접형제 태그명(형제 태그 다중 존재시에 첫번째 형제 태그 선택)
    - 모든 형제 태그: 태그명 ~ 형제 태그명(형제 태그 다중 존재시에 모든 형제 태그 선택)

## 가상 클래스 선택자

    :link -> 방문 전 링크
    :visited -> 방문 후 링크
    :hover -> 마우스 올림
    :active -> 클릭하는 순간

    :focus -> input 요소에 포커스 온 경우

    :first-child -> 첫번째 자식 태그
    :last-child -> 마지막 자식 태그
    :nth-child(N) -> N은 1부터 시작(자식 노드 순서)
    :nth-last-child(N) -> 뒤에서부터 N 번째 자식 노드(뒤에서 1번부터 시작)

    :checked -> 지정요소가 체킹(checked) 요소 선택
    :disabled -> 읽기 전용 (서버 요청시에 제외됨)
    :read-only -> 읽기 전용 (서버 요청시에 데이터 전송)
    :required -> 필수 input 요소 (required 지정)

## 속성 선택자

    [속성명]: 해당 속성을 갖는 모든 요소
    [속성명="속성값"]: 해당 속성명 중 속성값 일치 하는 요소

    [속성명 ^="시작값"]: "시작값"으로 시작하는 속성 요소
    [속성명 $="종료값"]: "종료값"으로 종료하는 속성 요소
    [속성명 *="포함값"]: "포함값"이 있는 속성 요소
    [속성명 ~="단어"]: "단어"를 포함하는 속성 요소

## css를 통해 input 요소에서 submit, reset, button 요소의 크기를 80px 설정

    input[type="submit"].normal, input[type="reset"], input[type="button"]{
        width: 80px;
    }

## 일반 선택자 우선순위

    1. 공통: *
    2. 태그(타입) 선택자: p, a, div
    3. .클래스 선택자: 태그명.className(해당된 태그의 지정한 클래스), .className(지정한 클래스), 그룹, 다중 class="item item1 color"
    4. #아이디 선택자: unique

## 예시

    a.common { text- decoration: none; }
    a.color1 { color: green; }
    a.color2 { color: dark-gray; }
    a.bold { font-weight: bold; }

    <a href="" class="common"> SSAFY HOME </a>
    <a href="" class="common color1 bold"> 로그인 </a>
    <a href="" class="common bold"> 회원가입 </a>
    <a href="" class="common color2"> 아이디/비밀번호 찾기 </a>
    <a href="" class="common"> 공지사항 </a>
