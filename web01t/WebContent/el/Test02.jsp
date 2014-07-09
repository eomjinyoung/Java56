<%@page import="servlets.step04.Score"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EL 검색 범위</title>
</head>
<body>
<h1>EL 검색 범위</h1>
<%-- 
${객체명.프로퍼티명} => 객체를 찾는 순서
=> 로컬 변수에서는 찾지 않는다.
=> JspContext => ServletRequest => HttpSession => ServletContext

구체적으로 객체를 찾는 보관소를 지정할 수 있다.
=> pageScope(JspContext), requestScope(ServletRequest), 
   sessionScope(HttpSession), applicationScope(ServletContext)
${pageScope.객체명.프로퍼티명}
 --%>

<jsp:useBean id="score" class="servlets.step04.Score" scope="session"/>
  <jsp:setProperty name="score" property="name" value="홍길동"/>
  <jsp:setProperty name="score" property="kor" value="100"/>
  <jsp:setProperty name="score" property="eng" value="90"/>
  <jsp:setProperty name="score" property="math" value="80"/>

<%
Score temp = new Score();
temp.setName("임꺽정");
request.setAttribute("score", temp);
%>
  
pageScope: ${pageScope.score.name}<br>
requestScope: ${requestScope.score.name}<br>
sessionScope: ${sessionScope.score.name}<br>
applicationScope: ${applicationScope.score.name}<br>
보관소 지정하지 않음: ${score.name}<br>
보관소에 없는 객체를 지정하기: ${okok.name}<br> 
<%-- 객체를 찾지 못해도(null) 오류 발생하지 않는다. --%>

<%-- NullPointException 발생 --%>
<%-- 
<%=((Score)request.getAttribute("okok")).getName()%><br>
--%>
 
 
 
</body>
</html>







