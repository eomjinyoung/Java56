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

@WebServlet("/score/step03/delete")
public class ScoreDelete  extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    int no = Integer.parseInt(request.getParameter("no"));
    
    try {
      ServletContext ctx = this.getServletContext();
      ScoreDao scoreDao = (ScoreDao)ctx.getAttribute("scoreDao");
      scoreDao.delete(no);
      
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<meta charset=\"UTF-8\">");
      
      // 웹 브라우저에게 1초 후에 list를 요청할 것을 알리는 명령 심는다.
      out.println("<meta http-equiv='Refresh' content='5; url=list'>");
      
      out.println("<title>성적 삭제</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<p>삭제 성공입니다.</p>");
      
      RequestDispatcher rd = request.getRequestDispatcher("/score/step03/copyright");
      rd.include(request, response);
      
      out.println("</body>");
      out.println("</html>");
    } catch (Exception e) {
      RequestDispatcher rd = request.getRequestDispatcher("/score/step03/error");
      request.setAttribute("error", e);
      rd.forward(request, response);
    }
  }

}














