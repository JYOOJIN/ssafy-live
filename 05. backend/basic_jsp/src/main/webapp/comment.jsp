<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>comment</title>
</head>
<body>
<h2>jsp 주석</h2>

<!-- html 주석 -->

<%
	// java 한줄 주석
	/* 
		java 
	   	여러줄 주석
	*/
%>

<%-- 
	jsp 주석
 --%>
 
 세션 아이디: <%=session.getId() %><br>
 세션 신규 여부: <%=session.isNew() %><br>
 
 
 
 
</body>
</html>