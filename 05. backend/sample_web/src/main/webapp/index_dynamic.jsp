<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h1>dynamic jsp contents</h1>
	<ul>
		<li>1</li>
		<li>2</li>
		<li>3</li>
		<li>4</li>
		<li>5</li>
	</ul>
	<div>총합: 15</div>
	<hr>
	
	<ul>
	<!-- jsp: scriptlet tab: 동적 화면 구성 서비스 tag -->
	<%
		int total=0;
		for(int i=1;i<=10;i++){		
			total+=i;
	%>
		<!-- jsp: expression tag: 수식 결과를 출력(응답) 하는 서비스 tag -->
		<li><%=i%></li>
	<%
		}
	%>
	</ul>
	<div>총합: <%=total %></div>
</body>
</html>