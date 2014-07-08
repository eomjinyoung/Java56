package servlets.step04;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 출력을 JSP에게 위임하기

@WebServlet("/score/step04/list")
public class ScoreList extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      ServletContext ctx = this.getServletContext();
      ScoreDao scoreDao = (ScoreDao)ctx.getAttribute("scoreDao");
      ArrayList<Score> scores = scoreDao.list();
      
      response.setContentType("text/html; charset=UTF-8");
      
      RequestDispatcher rd = request.getRequestDispatcher(
          "/score/step04/ScoreList.jsp");
      request.setAttribute("scores", scores);
      rd.include(request, response);
      
    } catch (Exception e) {
      RequestDispatcher rd = request.getRequestDispatcher("/score/step04/error");
      request.setAttribute("error", e);
      rd.forward(request, response);
    }
  }

}










