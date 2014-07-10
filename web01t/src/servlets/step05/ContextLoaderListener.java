package servlets.step05;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

// PageController 객체를 준비한다.
public class ContextLoaderListener implements ServletContextListener {

  @Override
  public void contextInitialized(ServletContextEvent event) {
    try {
      ServletContext ctx = event.getServletContext();
      DbConnectionPool dbConnectionPool = new DbConnectionPool(
          ctx.getInitParameter("driver"),
          ctx.getInitParameter("url"),
          ctx.getInitParameter("username"), 
          ctx.getInitParameter("password"));
      ScoreDao scoreDao = new ScoreDao();
      scoreDao.setDbConnectionPool(dbConnectionPool);
      
      // 페이지 컨트롤러를 ServletContext에 보관함.
      ScoreList scoreList = new ScoreList();
      scoreList.setScoreDao(scoreDao);
      ctx.setAttribute("/score/step05/list.do", scoreList);
      
      ScoreAdd scoreAdd = new ScoreAdd();
      scoreAdd.setScoreDao(scoreDao);
      ctx.setAttribute("/score/step05/add.do", scoreAdd);
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    
  }
  
  @Override
  public void contextDestroyed(ServletContextEvent event) {
    ServletContext ctx = event.getServletContext();
    DbConnectionPool dbConnectionPool = 
        (DbConnectionPool)ctx.getAttribute("dbConnectionPool");
    dbConnectionPool.closeAll();
    
  }
}












