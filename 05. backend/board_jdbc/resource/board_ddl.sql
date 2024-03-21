/* 게시글 DDL: board_ddl.sql 
	1. 글번호: article_no 정수, 식별키(필수, 중복불가), 자동 1씩 증가
	2. 작성자: 아이디 user_id 가변 문자열(16), 필수
	3. 제목: subject 가변 문자열(100), 필수
	4. 내용: content 가변 문자열(2000), 선택
	5. 작성시간(기본 현재 날짜 시간): register_time, 필수
*/
-- 데이터베이스 사용 지정

use ssafydb;


-- 테이블 생성
create table board(
	article_no int primary key auto_increment,
	user_id varchar(16) not null,
	subject varchar(16) not null,
	content varchar(2000),
	register_time timestamp not null default current_timestamp

);


-- 