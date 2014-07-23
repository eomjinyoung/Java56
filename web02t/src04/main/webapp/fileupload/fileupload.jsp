<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 멀티파트로 전송된 데이터는 다음의 메서드로 한글 처리를 할 수 없다.
request.setCharacterEncoding("utf-8"); %>
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
<hr>

<h1>멀티파트 데이터 처리</h1>
<p>멀티파트 데이터를 분석하여 정보를 추출해야 한다. => 전문 외부 라이브러리에게 맡긴다.</p>
<p>www.apache.org의 파일업로드 라이브러리 사용하여 처리</p>
<%
boolean isMultipart = ServletFileUpload.isMultipartContent(request);
pageContext.setAttribute("isMultipart", isMultipart);
%>
멀티 파트 형식의 데이터인가? ${isMultipart}<br>

<%
// 멀티파트 데이터를 추출하여 임시 보관할 창고 준비
DiskFileItemFactory factory = new DiskFileItemFactory();

// 멀티파트 데이터 추출기
ServletFileUpload upload = new ServletFileUpload(
    factory/*추출된 데이터를 저장할 창고를 지정*/);

// 멀티파트 데이터 추출하기
// 리턴 값 : 각 파트 정보를 담고 있는 객체들의 목록
List<FileItem> items = upload.parseRequest(request);

// 목록에서 파트 정보를 꺼낸다.
for (FileItem item : items) {
  // 일반 파트와 업로드 파트를 구분한다.
  if (item.isFormField()) { // 일반 파트일 경우 %>
    <%=item.getFieldName()%> : <%=item.getString("UTF-8")%><br>
<%} else { //업로드 파트일 경우 
    String uploadDir = application.getRealPath("/fileupload");
    File uploadFile = new File(uploadDir + "/" + item.getName());
    item.write(uploadFile); %>
    <%=item.getFieldName()%> : <%=item.getName()%><br>
    <img src="<%=item.getName()%>"><br>
<%}
}
%>

</body>
</html>







