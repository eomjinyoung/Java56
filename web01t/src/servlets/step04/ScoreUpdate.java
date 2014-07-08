package servlets.step04;

import java.io.IOException;
import java.io.PrintWriter;

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
      PrintWriter out = response.getWriter();
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<meta charset=\"UTF-8\">");
      out.println("<title>성적 변경폼</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>성적 변경</h1>");
      out.println("<form action=\"update\" method=\"post\">");
      out.format("번호: <input type=\"text\" name=\"no\" value='%1$s' readonly><br>", 
          score.getNo());
      out.format("이름: <input type=\"text\" name=\"name\" value='%1$s'><br>", 
          score.getName());
      out.format("국어: <input type=\"text\" name=\"kor\" value='%1$d'><br>",
          score.getKor());
      out.format("영어: <input type=\"text\" name=\"eng\" value='%1$d'><br>",
          score.getEng());
      out.format("수학 : <input type=\"text\" name=\"math\" value='%1$d'><br>",
          score.getMath());
      out.println("<input type=\"submit\" value=\"변경\">");
      out.println("</form>");
      
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
  
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // 필터로 대체함
    //request.setCharacterEncoding("UTF-8");
    
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
      
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<meta charset=\"UTF-8\">");
      out.println("<meta http-equiv='Refresh' content='1; url=list'>");
      out.println("<title>성적 변경</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<p>변경 성공입니다.</p>");
      
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














