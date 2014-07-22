<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>업로드 파일 처리</title>
</head>
<body>
<h1>업로드 파일 정보</h1>
<p>멀티파트 형식으로 전달하는 값은 서블릿(JSP)에서 일반적인 방법으로 꺼낼 수 없다.</p>
<p>다음 출력은 보이지 않는다.<p>
이름: ${param.name}<br>
이메일: ${param.email}<br>
전화: ${param.tel}<br>
암호: ${param.password}<br>
파일: ${param.photo}<br>

<h1>멀티파트 데이터 처리</h1>
<p>멀티파트 데이터를 분석하여 정보를 추출해야 한다. => 전문 외부 라이브러리에게 맡긴다.</p>
<p>www.apache.org의 파일업로드 라이브러리 사용하여 처리</p>

</body>
</html>







