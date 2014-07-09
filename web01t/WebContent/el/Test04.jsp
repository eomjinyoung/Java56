<%@page import="servlets.step04.Score"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>값 꺼내기</title>
</head>
<body>
<h1>배열값 꺼내기</h1>
<%
pageContext.setAttribute("names", new String[]{"홍길동","임꺽정","장보고"});
String[] names2 = new String[]{"aaa", "bbb", "ccc"};
%>
${names[1]}<br>
${names2[1]}<br> <%-- 로컬 변수는 사용할 수 없다. --%>

<h1>List 객체에서 값 꺼내기</h1>
<%
ArrayList<String> nameList = new ArrayList<String>();
nameList.add("홍길동");
nameList.add("임꺽정");
nameList.add("장보고");
request.setAttribute("nameList", nameList);
%>
${nameList[1]}<br>

<h1>Map 객체로부터 값 꺼내기</h1>
<%
HashMap<String,String> map = new HashMap<String,String>();
map.put("s1", "홍길동");
map.put("s2", "임꺽정");
map.put("s3", "장보고");
session.setAttribute("map", map);
%>
${map.s2}<br>

<h1>자바 일반 객체로부터 값 꺼내기</h1>
<%
Score score = new Score();
score.setName("aaaa");
score.setKor(100);
score.setEng(90);
application.setAttribute("score", score);
%>
${score.eng}<br>
</body>
</html>











