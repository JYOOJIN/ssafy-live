<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FIA</title>
</head>
<body>
<h1>Filter VS Interceptor VS AOP</h1>
<div>Console을 확인해 주세요.</div>
</body>
</html>
<%
System.out.println("INFO : index.jsp ==> View Rendering");
%>