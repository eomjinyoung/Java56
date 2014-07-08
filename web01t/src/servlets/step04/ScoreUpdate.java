package servlets.step04;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/score/step04/update")
public class ScoreUpdate extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    int no = Integer.parseInt(request.getParameter("no"));
    
    try {
      ServletContext ctx = this.getServletContext();
      ScoreDao scoreDao = (ScoreDao)ctx.getAttribute("scoreDao");
      Score score = scoreDao.selectOne(no);
      
      response.setContentType("text/html; charset=UTF-8");
      
      RequestDispatcher rd = request.getRequestDispatcher(
          "/score/step04/scoreupdateform.jsp");
      request.setAttribute("score", score);
      rd.include(request, response);
      
    } catch (Exception e) {
      RequestDispatcher rd = request.getRequestDispatcher("/score/step04/error");
      request.setAttribute("error", e);
      rd.forward(request, response);
    }
    
  }
  
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    Score score = new Score();
    score.setNo(Integer.parseInt(request.getParameter("no")));
    score.setName(request.getParameter("name"));
    score.setKor(Integer.parseInt(request.getParameter("kor")));
    score.setEng(Integer.parseInt(request.getParameter("eng")));
    score.setMath(Integer.parseInt(request.getParameter("math")));
    
    ServletContext ctx = this.getServletContext();
    ScoreDao scoreDao = (ScoreDao)ctx.getAttribute("scoreDao");
    
    try {
      scoreDao.update(score);
      response.sendRedirect("list");
            
    } catch (Exception e) {
      RequestDispatcher rd = request.getRequestDispatcher("/score/step04/error");
      request.setAttribute("error", e);
      rd.forward(request, response);
    }
  }
}














