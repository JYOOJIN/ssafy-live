<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import ="java.util.List" %>
<%@ page import ="com.ssafy.board.model.BoardDto" %>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
      crossorigin="anonymous"
    />
    <link href="../assets/css/app.css" rel="stylesheet" />
    <title>SSAFY</title>
  </head>
<body>
<h3>상세조회</h3>
<%
	//응답받은 글 객체 가져오기
	BoardDto boardDto=(BoardDto)request.getAttribute("boardDto");
%>
<div>글번호:&nbsp<%=boardDto.getArticleNo() %></div>
<div>제목:&nbsp<%=boardDto.getSubject() %></div>
<div>내용:&nbsp<%=boardDto.getContent() %></div>
<div>작성자:&nbsp<%=boardDto.getUserId() %></div>
<div>조회수:&nbsp<%=boardDto.getHit() %></div>

</body>
</html>