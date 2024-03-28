## 게시글 JDBC 프로그래밍

0. 게시글 도메인 분석/설계

   - 속성, 타입, 제약, 순서 고려

1. DB 구축 : ssafydb.baord
2. 게시글 관리 기능(요구사항: usecase diagram 설계)
   (1) 등록:  
   글번호(시스템 DB 자동부여),

## SQL

- 등록
  (1) 테이블 스키마 구조 순서대로 누락없이 값을 매핑 지정, null
  insert into 테이블명
  values (값1, 값X...);

(2) 지정한 컬럼과 지정한 값이 매핑,
insert into 테이블명(컬럼명1, 컬럼명X...)
values (값1, 값x...);

(3) 다중 레코드 추가
insert into 테이블명(컬럼명1, 컬럼명X...)
values (값1, 값x...),
(값1, 값x...),
(값1, 값x...);

- 전체조회
  select \* from 테이블명

- 상세조회
  select \* from 테이블명 where 조회조건식;

- 변경
  update 테이블명 set 컬럼명=변경값, 컬럼명x=변경값
  where 변경조건식;

- 변경
  delete from 테이블명
  whrere
