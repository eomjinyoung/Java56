<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
<h1>학생 등록 확인</h1>
<h2>기본정보</h2>
이름: ${student.name}<br>
이메일: ${student.email}<br>
전화: ${student.tel}<br>
암호: ${student.password }<br>
사진: ${student.photoPath}<br>
<img src="../fileupload/${student.photoPath}"><br>
<hr>
</body>
</html>






