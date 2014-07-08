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
<%
ArrayList<Score> scores = (ArrayList<Score>)request.getAttribute("scores");
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
</body>
</html>








    