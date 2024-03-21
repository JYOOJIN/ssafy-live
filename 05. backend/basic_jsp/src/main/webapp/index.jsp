<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String root= request.getContextPath(); %>
<%= request.getContextPath() %>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>SSAFY</title>
  </head>
  <body>
  	<h1>JSP</h1>
  	<!-- / 하면 basic_servlet까지 뜻한다 -->
  	<!-- /bs 하면 webapp 까지 -->
    <a href="<%=root %>/ssafy.jsp">Hello Servlet</a>
    <a href="<%=root %>/parameter.jsp">Parameter Test</a>
  </body>
</html>