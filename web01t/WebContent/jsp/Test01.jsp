<%-- JSP 주석
1. 템플릿 데이터
=> 출력문으로 생성됨

2. 스크립트릿(scriptlet) : <% 자바코드 %>
=> 순서에 따라 그대로 복사됨.
=> _jspService() 메서드에 들어갈 자바코드 작성

3. 익스프레션 엘리먼트(expression element) : <%= 값 또는 값을 리턴하는 식 %>
=> 출력문을 생성함 => 간단한 값을 출력할 때 사용 
=> ex) out.print(값 또는 값을 리턴하는 식);

4. 선언문(declaration element) : <%! 클래스 멤버(변수와 메서드), 스태틱 블록, 인스턴스 블록 선언 %>
=> 클래스 블록 안에 그대로 복사 

5. 지시문(directive element) : 
<%@ page 특별한 속성들%>
<%@ include 특별한 속성들%>
<%@ taglib 특별한 속성들%>
=> 지시문마다 별도로 정의된 자바 코드를 생성한다.

6. JSP 빌트인 객체 
=> Java 소스가 생성될 때 _jspService() 메서드에 반드시 선언되는 변수
HttpServletRequest request;
HttpServletResponse response;
PageContext pageContext;
ServletContext application;
HttpSession session;
Object page; // 서블릿 인스턴스 주소
ServletConfig config;
JspWriter out;
Throwable error;


 --%>
<%@ page 
    language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%! 
static {
  System.out.println("okok");
}

static final int TEST = 100;

public int plus(int a, int b) {
  return a + b;
}
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%!
private int minus(int a, int b) {
  return a - b;
}
%>
<body>
<h1>템플릿 데이터</h1>
<%
int i = 10;
String result = null;
%>
<h1>스크립트릿 테스트</h1>
<%
if (i < 18) {
  result = "청소년";
} else {
  result = "성인";
}
%>
나이: <%= i %><br>
호칭: <%= result %><br>

파라미터 name = <%= request.getParameter("name") %>

</body>
</html>

<%!
public int multiple(int a, int b) {
  return a * b;
}

int exam;
%>












