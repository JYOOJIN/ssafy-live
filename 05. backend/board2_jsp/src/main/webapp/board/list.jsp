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
<h3>글 목록</h3>
<%
	//응답받은 글 목록 객체 가져오기
	List<BoardDto> list=(List<BoardDto>)request.getAttribute("list");
%>
<table border="1">
	<!-- 제목행 -->
	<tr>
		<th>글번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>조회수</th>
		<th>작성시간</th>
	</tr>
	
	<!-- 글 목록 보여주기 반복행 -->
	<%
		for(BoardDto boardDto:list){
	%>
	<tr>
		<!-- 해당 글 항목 보여주기 -->
		<td><%=boardDto.getArticleNo() %></td>
		<!-- 제목을 클릭하면 해당 글 상세조회 요청 -->
		<!-- get 방식으로 넘긴다 -->
		<td><a href="/board/view?articleNo=<%=boardDto.getArticleNo() %>"><%=boardDto.getSubject() %></a></td>
		<td><%=boardDto.getUserId() %></td>
		<td><%=boardDto.getHit() %></td>
		<td><%=boardDto.getRegisterTime() %></td>
	</tr>
	<%
		}
	%>
	
</table>
</body>
</html>