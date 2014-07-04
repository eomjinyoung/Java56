package servlets.step01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/score/delete")
public class ScoreDelete  extends HttpServlet {
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
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    int no = Integer.parseInt(request.getParameter("no"));
    
    try {
      scoreDao.delete(no);
      
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<meta charset=\"UTF-8\">");
      
      // 웹 브라우저에게 1초 후에 list를 요청할 것을 알리는 명령 심는다.
      out.println("<meta http-equiv='Refresh' content='5; list'>");
      
      out.println("<title>성적 삭제</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<p>삭제 성공입니다.</p>");
      out.println("</body>");
      out.println("</html>");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}














