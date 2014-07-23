<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 쿠키란? 웹 서버가 웹 브라우저에게 일시적으로 맡기는 데이터.
// 웹 브라우저는 쿠키 설정에 따라 해당 서버에게 요청할 때마다 쿠키를 서버에 보내야 한다.
Cookie cookie = new Cookie("name", URLEncoder.encode("홍길동"));
// 쿠키의 사용 범위 설정
// => 경로를 설정하면 웹 브라우저는 해당 경로의 자원을 요청할 때 쿠키를 서버에 전송한다.
// => 경로가 다르면 서버에 전송하지 않는다.
// => 경로는 하위 경로를 포함한다.
cookie.setPath("/web02t");
response.addCookie(cookie);


Cookie cookie2 = new Cookie("age", "30");
// 쿠키의 사용 범위를 지정하지 않으면
// 다음과 같이 쿠키를 만든 서블릿(JSP)의 경로로 제한된다.
// 즉 이 경우 다음 코드와 같다.
//cookie.setPath("/web02t/cookie");
response.addCookie(cookie2);

Cookie cookie3 = new Cookie("gender", "male");
// 쿠키의 유효 시간(초) 설정하기
// 지정된 시간이 지나면 웹 브라우저는 더이상 서버에 해당 쿠키를 보내지 않는다.
cookie3.setMaxAge(30);
response.addCookie(cookie3);

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>쿠키01</title>
</head>
<body>
<h1>쿠키 보내기</h1>
<p>1) 이 JSP를 요청한 후, 웹브라우저 개발 도구에서 응답 헤더를 확인하기 바랍니다.</p>
<p>2) 다른 경로의 JSP를 실행한 후, 웹브라우저 개발 도구에서 요청 헤더를 확인하기 바랍니다. 
   name, age 쿠키가 있나요?</p>
   
</body>
</html>







