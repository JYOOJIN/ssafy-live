<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- jstl taglib 선언 -->
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page import="java.util.List"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL/JSTL</title>
</head>
<body>
	<h1>EL/JSTL</h1>
	
	<!-- 변수 선언 -->
	<c:set var="name" value="ssafy11 광주5반" />

	<!-- 값 출력 -->
	<c:out value="${name}" /><br>
	과정명: ${name}<br>
	
	<!-- 요청 시 전달받은 parameter 가져오기 -->
	<!-- ?name=정유진 -->
	이름: ${param.name}<br> <!-- 이건 전달받은 paramter의 key값의 value. key값은 내가 설정 가능 -->
	이름: <c:out value="${name}" default="guset"/><br> <!-- 이거는 위에서 선언했던 변수 -->
	이름: <c:out value="${param.name}" default="guset"/><br>
	
	
	<!-- 조건: true면 수행하기 -->
	<c:if test="${empty param.loginid}"> <!-- loginid가 empty면 login하지 않은 것 -->
		<a href="#">로그인</a>
	</c:if>
	<c:if test="${!empty param.loginid}"> <!-- loginid가 empty가 아니면 login한 것 -->
		<a href="#">등록</a>
		<a href="#">목록조회</a>
		<a href="#">로그아웃</a>
	</c:if>
	
	<hr>
	
	<!-- 다중 조건: A(관리자), S(우수회원), G(일반회원), 기본(비회원) -->
	<c:set var="grade" value="s" scope="session"/>
	<c:choose>
		<c:when test="${sessionScope.grade == 'A' or sessionScope.grade == 'a'}">관리자 서비스</c:when> 
		<c:when test="${grade == 'S' || grade == 's'}">우수회원 서비스</c:when>
		<c:when test="${grade == 'G' || grade == 'g'}">일반회원 서비스</c:when>
		<c:otherwise>기본 서비스</c:otherwise>		
	</c:choose>
	<br>
	<!-- 반복 하기: 반복횟수 지정 -->
	<!-- 1~10 까지 덧셈 -->
	<c:set var="total" value="0" />
	<c:forEach var="no" begin="1" end="10" step="1">
		<c:set var="total" value="${total+no}"/>
	</c:forEach>
	
	1~10 까지 더한 결과 <c:out value="${total}"/>/${total}<br><br>
		

	<!-- 반복 하기: Collection 크기 만큼 자동 반복 -->
	<%
		List<String> names=new ArrayList<String>();
		names.add("정유진");
		names.add("알파카");
		names.add("파이리");
		names.add("꼬부기");
		
		request.setAttribute("list", names);
	%>
	<ul>
	<c:forEach var="name" items="${list}">
		<li><c:out value="${name}"/>
	</c:forEach>
	<ul>
	
	
	
	
</body>
</html>