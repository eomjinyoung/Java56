package servlets.step03;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/* 웹 애플리케이션이 시작될 때 자동 생성되는 서블릿
 * - 보통 서블릿은 클라이언트에서 최초로 요청할 때 생성된다.
 * - 그러나, web.xml에 설정을 하면 클라이언트가 요청하지 않아도 자동 생성된다.
 * <servlet> 
 *   ....
 *   <load-on-startup>실행순서</load-on-startup>
 * </servlet>
 * - 클라이언트 요청을 처리하는 용도가 아니기 때문에 URL 매핑은 하지 말라!
 * - 모든 서블릿들이 공용으로 이용할 자원을 준비하는 역할을 수행한다.
 */

public class ContextLoaderServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  public void init(ServletConfig config) throws ServletException {
    super.init(config);
    
    try {
      DbConnectionPool dbConnectionPool = new DbConnectionPool(
          "com.mysql.jdbc.Driver",
          "jdbc:mysql://localhost:3306/bitdb?useUnicode=true&characterEncoding=UTF-8",
          "bit", "1111");
      ScoreDao scoreDao = new ScoreDao();
      scoreDao.setDbConnectionPool(dbConnectionPool);
      
      ServletContext ctx = this.getServletContext();
      ctx.setAttribute("dbConnectionPool", dbConnectionPool);
      ctx.setAttribute("scoreDao", scoreDao);
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  @Override
  public void destroy() {
    super.destroy();
    
    ServletContext ctx = this.getServletContext();
    DbConnectionPool dbConnectionPool = 
        (DbConnectionPool)ctx.getAttribute("dbConnectionPool");
    dbConnectionPool.closeAll();
  }
  
  
}










