<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="java.util.Date, java.sql.*" 
    import ="java.text.*"%>

<!-- 반드시 import 마다 띄어쓰기 있어야한다 -->
    
<%! 
String name="정유진";
Date date=new Date();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>HELLO SSAFY JSP</h1>
<h1>안녕 싸피!! 좋은 아침이야</h1>
<h3><%out.println(name+"님 안녕하세요"); %></h3>
<h3><%=name %>님 안녕</h3>
<div>오늘은 <%= date %></div>
</body>
</html>