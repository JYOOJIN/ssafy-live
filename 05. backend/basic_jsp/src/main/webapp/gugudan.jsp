<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>구구단</h1>
<!-- 제목행: 2단 3단 4단 ... 9단 -->
<table border=1>
<tr>
	<% for(int i=2;i<=9;i++){ %>
	<th><%=i %> 단</th>
	<%} %>
<tr>

<%
for(int i=1;i<=9;i++){
%>
<tr>
<% 
	for(int j=2;j<=9;j++){
%>
	<td><%=j %> x <%=i %> = <%=i*j %></td>
<%	
	}
%>
</tr>
<% 
}
%>

</table>

</body>
</html>