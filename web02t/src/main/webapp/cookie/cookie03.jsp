<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>쿠키03</title>
</head>
<body>
<h1>요청헤더에서 쿠키 값 꺼내기</h1>
<%
Cookie[] cookies = request.getCookies();
if (cookies != null) {
	for (Cookie cookie : cookies) {%>

<%=cookie.getName()%> => <%=URLDecoder.decode(cookie.getValue())%><br>	
  
<%}
}
%>
</body>
</html>






