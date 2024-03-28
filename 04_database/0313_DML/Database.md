## Database

나만의 언어로 정의해 놓기

- Data
- DataBase
- Information
- DBMS
- RDBMS
- ERD(Entity Relation Diagram)
- Table/Row(Record)/Column/Field

## SQL(Structure Query Language)

- ANSI 표준
- RDBMS 데이터 처리를 위한 표준 언어
- SQL 구분(종류)

  1. DDL : 객체 생성(CREATE), 변경(ALTER), 삭제(DROP)
  2. DML : 레코드 추가(INSERT), 조회(SELECT), 변경(UPDATE), 삭제(DELETE)
  3. DCL : DB 서버 제어, 사용자 생성(CREATE), 사용자 권한 부여(GRANT)/권한 삭제(REVOKE)
  4. TCL : 트랜잭션 제어, COMMIT(영속반영), ROLLBACK(복구), SAVEPOINT(복구 지점 지정)\
  5. DQL : 조회(SELECT)

## SQL 식별자(identifier) 규칙

- 테이블 명, 컬럼명, 제약명
- 영문자 시작, 숫자, \_(밑줄), $
- 한글 사용 가능, 특수문자 사용 가능 -> 권장은 x
- 길에 제한 : 64 max length
- 대소문자 구분하지 않음: 예약어(명령어)
- 데이터(값)은 DB의 설정에 따라 대소문자 구분하지 않음

  > MYSQL 테스트

  > ORACLE : 값은 대소문자 구분함

- 공백불가, 예약어 사용 불가
- 예약어를 식별자로 사용해야 하는 경우에는 ` 사용

  > \`예약어\` : `(빽틱)으로 감싸면 예약어 사용 및 대소문자 구분가능함

  ### 주문 테이블 설계

  ```
  create table 테이블명-order (...);
  ```

## 데이터 타입

- 문자열
  - varchar(가변길이)
  - char(고정길이)
- 숫자
- 날짜
  - char(고정길이)
  - date

## SELECT 기본 구문

1. SELECT 조회항목, 조회항목 - 나열;
2. SELECT 조회항목, 조회항목 - 나열
   FROM 테이블명1, [, 테이블명X;]
   - dummy table : dual
   - mysql은 from 구문 생략 가능 but ORACLE, MSSQL 등은 필수
     select 조회항목, 조회항목 - 나열
     from dual;

## SELECT 전체 구문

```
SELECT 조회항목, 조회항목 - 나열
FROM 테이블명1, [, 테이블명X;]
WHERE 조건식1[AND|OR|NOT] 조건식X
GROUP BY 그룹핑컬럼명1, 컬럼명X
HAVING 그룹핑 결과에 대한 조건식
ORDER BY 정렬 컬럼명1 정렬방식(ASC/DESC), 정렬 컬럼명X ;
```

### 올림 정렬 순서

- 숫자: 0~9
- 문자: 가~하, A~Z
- 날짜: 2000, 2001, ~2024

## SELECT 조회 항목

- \* : 모든 컬럼, db table 구조(schema) 순서대로 조회
- 컬럼명-A, 컬럼명-B : 지정한 컬럼명, 지정한 순서대로 조회
- distinct 컬럼명-A, 컬럼명-B : 중복을 제거한 레코드 조회
- 함수() : 함수 수행 결과를 조회
- 수식 : 수식 수행 결과를 조회
- (sub-query) : 서브 쿼리
- 텍스트 : 텍스트 조회

## DataBase(SQL) 잘하는 방법

1. SQL 명령어 외우기 → 실행하기 → 결과 올바른지 확인
2. DB Modeling : 테이블 관계 및 도메인 분석/설계 이해하기
3. 입력 데이터 => 서비스(args) => 출력 데이터(return type)
4. 데이터 저장
   - 영속성 : DB Modeling(물리적 저장소-Store)
   - 임시(일회성, 요청~응답, 로그인~로그아웃, 어플리케이션 구동~어플리케이션 종료) : 객체(Memory)
