<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>연산자</title>
</head>
<body>
<h1>EL 산술 연산자</h1>
${10 + 20}<br>
${10 - 20}<br>
${10 / 20}<br>
${10 * 20}<br>
${10 % 20}<br>
${10 div 20}<br>
${10 mod 20}<br>

<h1>EL 논리 연산자</h1>
${true && false }<br>
${true and false }<br>
${true || false }<br>
${true or false }<br>
${not false }<br>
${!false }<br>

<h1>관계 연산자</h1>
${10 == 20}<br>
${10 eq 20}<br>
${10 != 20}<br>
${10 ne 20}<br>
${10 < 20}<br>
${10 lt 20}<br>
${10 > 20}<br>
${10 gt 20}<br>
${10 <= 20}<br>
${10 le 20}<br>
${10 >= 20}<br>
${10 ge 20}<br>

<h1>empty 연산자</h1>
<%
pageContext.setAttribute("name", "홍길동");
%>
${empty okok}<br>
${empty name}<br>

<h1>조건 연산자</h1>
${(empty okok)? "비어있다" : name}<br>
</body>
</html>










