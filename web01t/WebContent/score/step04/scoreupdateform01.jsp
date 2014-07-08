<%@page import="servlets.step04.Score"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성적 변경폼</title>
</head>
<body>
<h1>성적 변경</h1>
<%
Score score = (Score)request.getAttribute("score");
%>
<form action="update" method="post">
번호: <input type="text" name="no" value='<%=score.getNo()%>' readonly><br>
이름: <input type="text" name="name" value='<%=score.getName()%>'><br>
국어: <input type="text" name="kor" value='<%=score.getKor()%>'><br>
영어: <input type="text" name="eng" value='<%=score.getEng()%>'><br>
수학 : <input type="text" name="math" value='<%=score.getMath()%>'><br>
<input type="submit" value="변경">
</form>
</body>
</html>
    
    
    
    
    
    