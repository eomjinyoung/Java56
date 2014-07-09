<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>       
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSTL 태그</title>
</head>
<body>
<h1>c:out 태그 : 값 출력</h1>
<c:out value="출력합니다."/><br>
<c:out value="${null}"/><br>
<c:out value="출력합니다.">이것은 뭥미!</c:out><br>
<c:out value="${null}">이것은 뭥미!</c:out><br>

<h1>c:set 태그 : 값을 보관소에 등록</h1>
<c:set var="name" value="홍긷롱" scope="page"/>
${name}<br>
${pageScope.name}<br>
${requestScope.name}<br>

<jsp:useBean id="score" class="servlets.step04.Score" scope="page"/>
<jsp:setProperty name="score" property="name" value="홍길동"/>
<c:set target="${score}" property="name" value="임꺽정"/>
score.name => ${score.name}<br>

<h1>c:remove 태그 : 보관소에 저장된 객체 제거</h1>
<c:set var="name" value="오호라" scope="page"/>
제거 전: ${name}<br>
<c:remove var="name" scope="page"/>
제거 후: ${name}<br>

<h1>c:if 태그 : 조건문 태그</h1>
<c:set var="name" value="홍길동" scope="page"/>
<c:if test="${name == '홍길동'}" var="result" scope="page">
오호라.. 그렇군요..: ${result}<br>
</c:if>

<h1>c:choose 태그 : 조건이 여러 개일 경우 사용</h1>
<c:set var="level" value="3" scope="page"/>
<c:choose>
  <c:when test="${level == '0'}">손님</c:when>
  <c:when test="${level == '1'}">회원</c:when>
  <c:when test="${level == '2'}">관리자</c:when>
  <c:otherwise>레벨 없음!</c:otherwise>
</c:choose>

<h1>c:forEach 태그: 반복문</h1>
<%
pageContext.setAttribute("names", new String[]{"홍길동","임꺽정","장보고","유관순"});
%>
<%-- forEach의 items에는 다음 객체를 지정할 수있다.
배열, Collection(ArrayList, LinkedList 등 구현체), Iterator, Enumeration, Map
콤마로 구분된 문자열("홍길동,임꺽정,장보고,유관순")
 --%>
<c:forEach var="name" items="${names}" begin="1" end="2">
이름: ${name}<br>
</c:forEach>

<c:set var="names2" value="홍길동,유관순,임꺽정,장길산,아이언맨" scope="page"/>
<ul>
<c:forEach var="name" items="${names2}">
  <li>${name}</li>
</c:forEach>
</ul>

<h1>c:forToken 태그 : 문자열을 특정 단어를 기준으로 쪼개기</h1>
<c:set var="data" value="name=홍길동&age=30&tel=111-1111" scope="page"/>
<c:forTokens items="${data}" delims="&" var="item">
==> ${item}<br>
</c:forTokens>

<h1>c:url 태그: URL을 쉽게 작성</h1>
<c:url var="searchUrl" value="http://search.naver.com/search.naver">
  <c:param name="where" value="nexearch"/>
  <c:param name="query" value="홍길동"/>
  <c:param name="sm" value="top_hty"/>
  <c:param name="fbm" value="1"/>
  <c:param name="ie" value="utf8"/>
</c:url>
<a href="${searchUrl}">네이버 검색(홍길동)</a><br>

<h1>c:import 태그: 특정 URL의 응답 결과를 가져오기</h1>
<div><c:import url="http://www.google.com"/></div>

<h1>c:redirect 태그: 특정 URL로 리다이렉트 하기</h1>
<c:set var="name" value="홍길동2" scope="page"/>
<c:if test="${name == '홍길동'}">
  <c:redirect url="http://localhost:9999/web01t/score/list"/>
</c:if>

<h1>fmt:parseDate 태그: 문자열을 읽어서 날짜 객체(java.util.Date)로 만든다.</h1>
<fmt:parseDate var="date1" value="2014-7-9" pattern="yyyy-MM-dd" />
${date1.year + 1900}<br>

<h1>fmt:formatDate 태그: 날짜 객체로부터 문자열을 만든다.</h1>
<%
pageContext.setAttribute("date2", new Date()); // 현재 날짜와 시간을 가진 객체 생성
%>
<fmt:formatDate value="${date2}" pattern="MM/dd/yyyy hh:mm:ss"/><br>



</body>
</html>













