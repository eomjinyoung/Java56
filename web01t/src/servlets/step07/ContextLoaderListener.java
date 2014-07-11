package servlets.step07;

import java.io.InputStream;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

// myBatis 도입
public class ContextLoaderListener implements ServletContextListener {
  static Logger logger = Logger.getLogger(ContextLoaderListener.class);
  
  @Override
  public void contextInitialized(ServletContextEvent event) {
    logger.debug("contextInitialized 호출됨...");
    try {
      ServletContext ctx = event.getServletContext();
      
      // 서버의 자원을 찾아주는 도구 준비
      Context initCtx = new InitialContext();
      // lookup(): 서버 자원을 찾아서 리턴함.
      DataSource dataSource = (DataSource)initCtx.lookup(
          "java:/comp/env/jdbc/bitdb");
      
      // MyBatis 데이터 처리 대행 객체 준비
      // 1) 설정 파일을 읽어들일 때 사용할 도구(InputStream)를 준비한다.
      // 2) SqlSessionBuilder를 준비한다.
      // 3) SqlSessionBuilder로부터 SqlSessionFactory를 얻는다.
      // 4) SqlSessionFactory로부터 SqlSession을 얻는다.
      // ex) 망치 <- 망치공장 <-망치공장건설사 + 설계도면 
      String resource = "servlets/step07/mybatis-config.xml";
      // 자바 클래스 경로(classpath)에서 MyBatis 설정파일을 찾는다.
      InputStream inputStream = Resources.getResourceAsStream(resource);
      SqlSessionFactory sqlSessionFactory = 
          new SqlSessionFactoryBuilder().build(inputStream);
      
      ScoreDao scoreDao = new ScoreDao();
      scoreDao.setDataSource(dataSource);
      scoreDao.setSqlSessionFactory(sqlSessionFactory);
      
      // 페이지 컨트롤러를 ServletContext에 보관함.
      ScoreList scoreList = new ScoreList();
      scoreList.setScoreDao(scoreDao);
      ctx.setAttribute("/score/step07/list.do", scoreList);
      
      ScoreAdd scoreAdd = new ScoreAdd();
      scoreAdd.setScoreDao(scoreDao);
      ctx.setAttribute("/score/step07/add.do", scoreAdd);
      
      ScoreDelete scoreDelete = new ScoreDelete();
      scoreDelete.setScoreDao(scoreDao);
      ctx.setAttribute("/score/step07/delete.do", scoreDelete);
      
      ScoreUpdate scoreUpdate = new ScoreUpdate();
      scoreUpdate.setScoreDao(scoreDao);
      ctx.setAttribute("/score/step07/update.do", scoreUpdate);
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  @Override
  public void contextDestroyed(ServletContextEvent event) {
    logger.debug("contextDestroyed 호출됨...");
  }
}












