<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="count" value="0"/>   
[  
<c:forEach var="score" items="${scores}">
<c:if test="${count > 0}">,</c:if>
<c:set var="count" value="${count + 1}"/>
{
  'no': ${score.no},
  'name': '${score.name}',
  'execDate': '<fmt:formatDate value="${score.execDate}" pattern="yyyy-MM-dd"/>',   
  'kor': ${score.kor},   
  'eng': ${score.eng},   
  'math': ${score.math},   
  'total': ${score.total},   
  'average': ${score.average}  
}
</c:forEach>
]
