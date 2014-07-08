<%--
JSP 액션 태그
=> 특정 자바 코드를 생성하는 태그이다.

1. <jsp:useBean> : 
=> 자바 객체를 생성
=> ServletContext(application), HttpSession(session), 
   ServletRequest(request), PageContext(page) 보관소에서 객체 꺼내기

<jsp:useBean 
    id="레퍼런스변수이름" 
    type="레퍼런스변수의 타입(패키지명 포함)"
    class="객체생성 클래스(패키지명 포함)"
    scope="객체보관소 이름(application,session,request,page)"/>
* type 속성을 생략하면 class 속성을 사용한다.
* class 속성을 생략하면, 보관소에 값이 없을 때 인스턴스를 생성할 수 없다.
예1)
<jsp:useBean id="score" type="servlets.step04.Score" 
    class="servlets.step04.Score" scope="request"/>
=> 위의 태그는 다음의 자바코드와 같다.
servlets.step04.Score score = (servlets.step04.Score)request.getAttribute("score");
if (score == null) {
  score = new servlets.step04.Score();
  request.setAttribute("score", score);
}

 --%>
<%@ page import="servlets.step04.Score"%>
<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성적 관리</title>
<style type="text/css">
table {
  font-family: verdana,arial,sans-serif;
  font-size:11px;
  color:#333333;
  border-width: 1px;
  border-color: #666666;
  border-collapse: collapse;
}
table th {
  border-width: 1px;
  padding: 8px;
  border-style: solid;
  border-color: #666666;
  background-color: #dedede;
}
table td {
  border-width: 1px;
  padding: 8px;
  border-style: solid;
  border-color: #666666;
  background-color: #ffffff;
}
</style>
</head>
<body>
<h1>성적 관리(MVC)</h1>
<a href='scoreform.html'>추가</a>
<table>
<tr>
  <th>번호</th> 
  <th>이름</th> 
  <th>국어</th> 
  <th>영어</th> 
  <th>수학</th> 
  <th>합계</th> 
  <th>평균</th>
  <th></th>
</tr>
<jsp:useBean id="scores" type="java.util.ArrayList<Score>" scope="request"/>
<%--
위의 태그는 다음 자바코드와 같다.
java.util.ArrayList<Score> scores = 
  (java.util.ArrayList<Score>)request.getAttribute("scores");
 --%>
<%
for (Score score : scores) {
%>
<tr>
  <td><a href='update?no=<%=score.getNo()%>'><%=score.getNo()%></a></td>   
  <td><%=score.getName()%></td>   
  <td><%=score.getKor()%></td>   
  <td><%=score.getEng()%></td>   
  <td><%=score.getMath()%></td>   
  <td><%=score.getTotal()%></td>   
  <td><%=score.getAverage()%></td>  
  <td><a href='delete?no=<%=score.getNo()%>'>삭제</a></td>
</tr>
<%} %>
</table>

<%-- 
<jsp:include> or <jsp:forward>
=> RequestDispatcher rd = request.getRequestDispatcher("url");
rd.include(request, response); 
또는
rd.forward(request, response);
 --%>
<jsp:include page="/score/step04/copyright.jsp"/>

</body>
</html>








    