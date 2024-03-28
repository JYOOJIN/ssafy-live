[1] BackEnd WebApplication Maven Project  
Dynamic Web Project 생성:
project name: board1_servlet
web content root : board
Configure > Convert to Maven > Finish
https://mvnrepository.com/
mysql > 1. MySQL Connector/J > 8.0.33
pom.xml </build> <dependencies>

<!-- https://mvnrepository.com/artifact/com.mysql/mysql-connector-j -->
<dependency>
<groupId>com.mysql</groupId>
<artifactId>mysql-connector-j</artifactId>
<version>8.0.33</version>
</dependency>
</dependencies>
Maven > Update Project > (체킹) Force Update ..
[2] 배포 파일 import
board0_form : board_schema.sql
resources:
src: main\java>, main\webapp>
[3] DataBase 만들기
database: ssafyweb
SQL Script 실행하기: board_schema.sql
tables
members : ssafy/1234, admin/1234
board
memo
board : PK(article_no), FK(user_id)
article_no INT NOT NULL AUTO_INCREMENT,
user_id VARCHAR(16) NULL DEFAULT NULL,
subject VARCHAR(100) NULL DEFAULT NULL,
content VARCHAR(2000) NULL DEFAULT NULL,
hit INT NULL DEFAULT 0,
register_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
members : PK(user_id)
user_id VARCHAR(16) NOT NULL,
user_name VARCHAR(20) NOT NULL,
user_password VARCHAR(16) NOT NULL,
email_id VARCHAR(20) NULL DEFAULT NULL,
email_domain VARCHAR(45) NULL DEFAULT NULL,
join_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
memo : PK(memo_no), FK(user_id), FK(user_id)
memo_no INT NOT NULL AUTO_INCREMENT,
user_id VARCHAR(16) NULL DEFAULT NULL,
comment VARCHAR(500) NULL DEFAULT NULL,
memo_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
article_no INT NULL DEFAULT NULL,
[3] 게시글 관련 Web Application 요구사항
Web Context Path : board
시작페이지: index.html
게시글관리
글쓰기 : board/write.html
글목록
글상세
글변경
글삭제
다중조건 조회
회원관리
회원가입
로그인
로그아웃
내정보조회
내정보변경
탈퇴
댓글관리
댓글 쓰기
댓글 조회
댓글 변경
댓글 삭제
[4] 요청 ~ 응답 흐름 요청
View: 시작페이지
View: 요청 화면
View: 서블릿 요청
Controller: 서블릿 요청데이터 추출 및 Model(Service) 요청 의뢰
Model(Service) : 서비스 로직 처리 및 필요시 Model(DAO)에게 DB 요청
Model(DAO) : DAO/DTO 클래스 작성하기
Controller: 서블릿에서 Model 요청결과를 받아서 응답위한 설정
Controller: 서블릿에서 응답페이지 출력스트림 이용한 동적 작성 및 응답페이지 이동하기(forward, redirect)
View: 응답 화면(결과 화면 처리하기)
[5] 게시글 관련 SQL Script 파일
게시글 등록
insert into board(user_id, subject, content)
values('ssafy', 'test1 subject', 'test1 content')
;
글목록 전체
select _
from board
order by register_time desc
;
상세 조회
select _
from board
where article_no=1
;
글조회 할때마다 조회수 변경하기
update board set
hit=hit+1
where article_no=1
;
글 변경
update board set
subject='제목변경', content='내용변경'
where article_no=1
;

글 삭제
delete from board
where article_no=1
;
[6] 게시글 등록하기
View: 시작페이지(index.html) <!-- 수정 내용 -->
<a href="/board/board/write.html">글쓰기</a><br /> <!-- <a href="/board/board/list.html">글목록</a> -->
<a href="/board/list">글목록</a>
View: 요청 화면(write.html) <form id="form-register" method="POST" action="">
작성자 ID : <input name="userid">
제목 : <input name="subject">
내용 : <input name="content">

     <button type="button" id="btn-register">글작성</button>

 </form>

 <script>
   let form = document.querySelector("#form-register");
   form.setAttribute("action", "/board/register");
   form.submit();
 </script>

View: 서블릿 요청
form.setAttribute("action", "/board/register");
Controller: 서블릿 요청데이터 추출 및 Model(Service) 요청 의뢰
게시글 등록 서블릿 작성하기
BoardRegisterServlet.java
web.xml: <url-pattern>/register</url-pattern>
servler annotation : @WebServlet("/register")
doPost() 재정의
Model(Service) : 서비스 로직 처리 및 필요시 Model(DAO)에게 DB 요청
미작성
Model(DAO/DTO) : DAO/DTO 클래스 작성하기
BoardDao > BoardDaoImpl
DBUtil
BoardDto
Controller: 서블릿에서 Model 요청결과를 받아서 응답위한 설정
미구현
Controller: 서블릿에서 응답페이지 출력스트림 이용한 동적 작성 및 응답페이지 이동하기(forward, redirect)
출력스트림 이용한 동적 응답 하기
jsp 페이지로 이동하기
View: 응답 화면(결과 화면 처리하기)
jsp 페이지에서 응답 결과 처리하기
