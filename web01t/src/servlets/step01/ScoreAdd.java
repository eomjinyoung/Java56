package servlets.step01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/score/add")
public class ScoreAdd extends HttpServlet {
  private static final long serialVersionUID = 1L;
  DbConnectionPool dbConnectionPool;
  ScoreDao scoreDao;
  
  @Override
  public void init(ServletConfig config) throws ServletException {
    super.init(config);
    
    try {
      dbConnectionPool = new DbConnectionPool(
          "com.mysql.jdbc.Driver",
          "jdbc:mysql://localhost:3306/bitdb?useUnicode=true&characterEncoding=UTF-8",
          "bit", "1111");
      scoreDao = new ScoreDao();
      scoreDao.setDbConnectionPool(dbConnectionPool);
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  @Override
  public void destroy() {
    super.destroy();
    
    dbConnectionPool.closeAll();
  }
  
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    
    Score score = new Score();
    score.setName(request.getParameter("name"));
    score.setKor(Integer.parseInt(request.getParameter("kor")));
    score.setEng(Integer.parseInt(request.getParameter("eng")));
    score.setMath(Integer.parseInt(request.getParameter("math")));
    
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
    out.println("</body>");
    out.println("</html>");
  }
}














