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

<h2>추가정보</h2>
우편번호: ${student.postNo}<br>
기본주소: ${student.baseAddress}<br>
상세주소: ${student.detailAddress}<br>
학교: ${student.school}<br>
학년: ${student.grade}<br>
전공: ${student.major}<br>
재직자: ${student.working}<br>
회사: ${student.company}<br>
사업자번호: ${student.companyNo}<br>

<form action="signupComplete.do" method="post">
<input type="submit" value="등록">
<input type="button" value="취소" onclick="location.href='../auth/login.do';">
</form>
</body>
</html>






