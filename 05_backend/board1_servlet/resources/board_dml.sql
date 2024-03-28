/* 게시글 DML: board_dml.sql 
	1. 글번호: article_no 정수, 식별키(필수, 중복불가), 자동 1씩 증가
	2. 작성자: 아이디 user_id 가변 문자열(16), 필수
	3. 제목: subject 가변 문자열(100), 필수
	4. 내용: content 가변 문자열(2000), 선택
	5. 작성시간(기본 현재 날짜 시간): register_time, 필수
*/

# 추가: 아이디, 제목, 내용 / 시스템: 글번호, 작성시간

insert into board(user_id,subject,content) values(?,?,?);

insert into board(user_id, subject, content)
values('ssafy','jdbc 과제변경','게시글 관리 jdbc 프로그래밍 구현하기'),
values('yoojin','장덕동 맛집','오늘 저녁은 장덕동 삼산회관입니다');


# 전체조회
# 최신글부터 보려면 내림차순으로 해야한다
select * from board
order by register_time desc; 

# 상세조회
select * from board
where article_no=1;

# 변경
update board set
content=""
where article_no=2;

 
# 삭제
delete from board
where article_no=2;