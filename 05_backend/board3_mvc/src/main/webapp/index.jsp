<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String root = request.getContextPath(); // 현재 컨텍스트 패스 가져오기
// index.jsp 시작 페이지에서 현재 컨텍스트를 가져와서 application(ServletContext)에 설정하기
// application(ServletContext)에 설정한 정보는 모든 jsp/servlet에서 공유 가능
%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>SSAFY</title>
  </head>
  <body>
    <div align="center">
      <h3>SSAFY 게시판 - MVC ver.1.0</h3>
      <!-- 이제 절대로 버튼 등을 눌러서 이동할 때 jsp로 가면 절대 안된다 -->
      <!-- a 태그는 get 방식이다 -->
      <a href="<%= root %>/article?action=mvwrite">글쓰기</a><br />
      <a href="<%= root %>/article?action=list">글목록</a>
    </div>
  </body>
</html>