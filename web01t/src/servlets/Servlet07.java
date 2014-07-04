package servlets;

// 싱글 라인 주석 => 컴파일러가 무시 => .class 파일에 주석이 없음.
/*
 * 멀티 라인 주석 => 컴파일러가 무시 => .class 파일에 주석이 없음.
 */
/* @XXXX 애노테이션
 * - 컴파일러나, JVM에게 전달하는 특별한 주석 
 * - .class 파일에 주석을 남길 수 있음 => .class 파일에 있는 애노테이션을 추출할 수 있음
 */

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/step04/UnitConv")
@SuppressWarnings("serial")
public class Servlet07 extends HttpServlet {
  static final String[] units = {"cm", "inch", "yd", "km"};
  
  /* @Override => 컴파일러에 전달하는 주석 => .class 파일에 포함되지 않는다.
   * - 수퍼 클래스의 메서드를 오버라이딩 한 것임을 선언.
   * - 컴파일러는 해당 메서드가 정말 수퍼 클래스에 있는지 검사한다.  
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    float value = 0;
    try {
      value = Float.parseFloat(request.getParameter("v"));
    } catch (Exception e) {}
    
    int from = 0, to = 0;
    String[] fromSelected = {"", "", "", ""};
    String[] toSelected = {"", "", "", ""};
    
    try {
      from = Integer.parseInt(request.getParameter("from"));
      fromSelected[from] = "selected";
    } catch (Exception e) {}
    try {
      to = Integer.parseInt(request.getParameter("to"));
      toSelected[to] = "selected";
    } catch (Exception e) {}
    
    float result = 0;
    if (from == 0 && to == 1) { // cm -> inch 
      result = value * 0.39f;
    }
    
    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset=\"UTF-8\">");
    out.println("<title>단위 변환</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>단위 변환</h1>");
    out.println("<form action='UnitConv' method='post'>");
    if (value == 0) {
      out.println("<input type=\"text\" name=\"v\">");
    } else {
      out.println("<input type=\"text\" name=\"v\" value='" + value + "'>");
    }
    out.println("<select name='from'>");
    out.println("  <option value='0' " + fromSelected[0] + ">cm</option>");
    out.println("  <option value='1' " + fromSelected[1] + ">inch</option>");
    out.println("  <option value='2' " + fromSelected[2] + ">yd</option>");
    out.println("  <option value='3' " + fromSelected[3] + ">km</option>");
    out.println("</select>");
    out.println("<select name=\"to\">");
    out.println("  <option value='0' " + toSelected[0] + ">cm</option>");
    out.println("  <option value='1' " + toSelected[1] + ">inch</option>");
    out.println("  <option value='2' " + toSelected[2] + ">yd</option>");
    out.println("  <option value='3' " + toSelected[3] + ">km</option>");
    out.println("</select>");
    out.println("<input type=\"submit\" value=\"변환\">");
    out.println("</form>");
    if (value != 0) {
      out.format("<p>%1$.1f %2$s -> %3$.1f %4$s</p>", 
          value, units[from], result, units[to]);
    }
    out.println("</body>");
    out.println("</html>");
    
  }
  
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }
}













