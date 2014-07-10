<%--
Expression Language (EL)
=> OGNL 표기법과 유사 => 객체를 찾고 객체의 프로퍼티 값을 꺼내기가 쉽다.

* 프로퍼티 명과 인스턴스 명
class Score {
  int _no;
  String _name;
  
  public void setNo(int _no) { this._no = _no;}
  public int getNo() {return this._no;}
  
  public void setName(String _name) {this._name = _name;}
  public String getName() {return this._name;}
}
1) 인스턴스 명: _no, _name
2) 프로퍼티 명: no, name
겟터/셋터 메서드 이름에서 get/set을 제거 => 나머지 이름에서 첫 글자를 소문자로 만든다.
getNo() => No => no
getName() => Name => name
getFirstName()가 있다면, => FirstName => firstName  

 --%>
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
<h1>성적 변경(EL)</h1>
<form action="update.do" method="post">
번호: <input type="text" name="no" value='${requestScope.score.no}' readonly><br>
이름: <input type="text" name="name" value='${score.name}'><br>
국어: <input type="text" name="kor" value='${score.kor}'><br>
영어: <input type="text" name="eng" value='${score.eng}'><br>
수학 : <input type="text" name="math" value='${score.math}'><br>
<input type="submit" value="변경">
</form>

<jsp:include page="/score/step07/copyright.jsp"/>

</body>
</html>
    
    
    
    
    
    