package servlets;

/* 목표: 웹 브라우저가 보낸 데이터 읽기
 * 1) 한글 오류 처리 
 * - 웹 브라우저가 보낸 문자열을 ISO-8859-1로 취급한다.
 * - 각 바이트에 무식하게 그냥 00을 붙여서 유니코드로 만든다.
 * - 영어가 아닌 글자는 잘못된 유니코드로 바뀌기 때문에 글자가 깨지게 된다.
 * - 해결책: 값을 꺼내기 전(getParameter() 호출 전)에 문자열의 characterset을 알려준다.
 *   GET => 서블릿 컨테이너의 매뉴얼에 따라 처리하라!
 *   POST => request.setCharacterEncoding("UTF-8") 호출한다. 
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet04")
public class Servlet04 extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // HttpServletRequest : 요청 정보를 다룰 때 사용할 도구가 들어 있음.
    String name = request.getParameter("name");
    
    
    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println(name + "님 반갑습니다.");
  }
  
}












