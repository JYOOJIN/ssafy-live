# board_dml.sql
# 게시글 관리 sql script 

# database 
use ssafyweb;

# 게시글 등록
insert into board(user_id, subject, content)
values('ssafy', 'test1 subject', 'test1 content')
;

# 글목록 전체
select *
from board
order by register_time desc
;

# 상세 조회
select *
from board
where article_no=1
;

# 글조회 할때마다 조회수 변경하기
update board set
hit=hit+1
where article_no=1
;

# 글 변경
update board set
subject='제목변경', content='내용변경'
where article_no=1
;
 
# 글 삭제
delete from board
where article_no=1
;

# 전체 글삭제(초기화)
delete from board;

# db 영속 반영
commit;
