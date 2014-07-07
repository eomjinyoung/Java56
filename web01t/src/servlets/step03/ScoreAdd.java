package servlets.step03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/score/step03/add")
public class ScoreAdd extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // 필터로 대체함
    //request.setCharacterEncoding("UTF-8");
    
    Score score = new Score();
    score.setName(request.getParameter("name"));
    score.setKor(Integer.parseInt(request.getParameter("kor")));
    score.setEng(Integer.parseInt(request.getParameter("eng")));
    score.setMath(Integer.parseInt(request.getParameter("math")));
    
    ServletContext ctx = this.getServletContext();
    ScoreDao scoreDao = (ScoreDao)ctx.getAttribute("scoreDao");
    
    try {
      scoreDao.insert(score);
      
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<meta charset=\"UTF-8\">");
      out.println("<meta http-equiv='Refresh' content='5; url=list'>");
      out.println("<title>성적 등록</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<p>등록 성공입니다.</p>");
      
      RequestDispatcher rd = request.getRequestDispatcher("/score/step03/copyright");
      rd.include(request, response);
      
      out.println("</body>");
      out.println("</html>");
      
    } catch (Exception e) {
      // 오류가 발생하면 /score/step03/error 서블릿으로 위임한다.
      // 요청 배달자를 통해 요청을 해당 서블릿으로 배달한다.
      RequestDispatcher rd = request.getRequestDispatcher("/score/step03/error");
      
      // ErrorServlet에 실행을 위임하기 전에 ServletRequest 보관함에 
      // 오류정보를 담아서 보낸다.
      request.setAttribute("error", e);
      
      rd.forward(request, response);
    }
  }
}














