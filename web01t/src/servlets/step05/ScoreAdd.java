package servlets.step05;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/score/step05/add")
public class ScoreAdd extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    Score score = new Score();
    score.setName(request.getParameter("name"));
    score.setKor(Integer.parseInt(request.getParameter("kor")));
    score.setEng(Integer.parseInt(request.getParameter("eng")));
    score.setMath(Integer.parseInt(request.getParameter("math")));
    
    ServletContext ctx = this.getServletContext();
    ScoreDao scoreDao = (ScoreDao)ctx.getAttribute("scoreDao");
    
    try {
      scoreDao.insert(score);
      response.sendRedirect("list");
      
    } catch (Exception e) {
      RequestDispatcher rd = request.getRequestDispatcher("/score/step04/error");
      request.setAttribute("error", e);
      rd.forward(request, response);
    }
  }
}














