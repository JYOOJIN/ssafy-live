<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib
prefix="c" uri="jakarta.tags.core" %>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
  </head>
  <body>
    <h3>Hello Spring MVC !!!</h3>
    <h2><%=application.getInitParameter("ssafyTitle") %></h2>
    <h1>안녕 ${name}</h1>
    <h3>파라미터 테스트</h3>
    <a href="${root}/parameter">파라미터</a>
  </body>
</html>
