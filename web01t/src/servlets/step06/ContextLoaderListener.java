package servlets.step06;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

// 1. DataSource 가져오기
// => InitialContext 객체의 lookup("자원경로") 사용하여 서버에서 관리하는 객체를 얻는다.
//
// 2. Log4J 사용하기
// => 6단계로 로그 출력을 관리한다.
// 1) FATAL : 애플리케이션을 중지해야 할 심각한 오류
// 2) ERROR : 오류가 발생했지만 계속 실행할 수 있는 상태
// 3) WARN : 잠재적인 위험을 안고 있는 상태
// 4) INFO : 애플리케이션의 주요 실행 정보
// 5) DEBUG : 애플리케이션의 상세 실행 상태를 표현
// 6) TRACE : 디버그보다 더 상세한 로그 출력할 때 
// 
// 3. log4j 설정파일 (log4j.properties)
// 1) 기본 로거의 레벨을 설정, 출력 도구 이름 선언
//    log4j.rootLogger=레벨, 출력도구1, 출력도구2, 출력도구3, ...
//    ex) log4j.rootLogger=WARN, A1
// 
// 2) 출력 도구 지정
//    log4j.appender.출력도구이름=도구유형
//    ex) log4j.appender.A1=org.apache.log4j.ConsoleAppender
//    => 도구유형
//       org.apache.log4j.ConsoleAppender : 콘솔창으로 출력
//       org.apache.log4j.FileAppender : 파일로 출력
//       org.apache.log4j.net.SocketAppender : 소켓으로 출력
//
// 3) 로그 출력형식 지정
//    log4j.appender.출력도구이름.layout=출력형식
//    ex) log4j.appender.A1.layout=org.apache.log4j.PatternLayout
//    => 출력 형식
//       org.apache.log4j.SimpleLayout : "출력레벨 - 메시지" 형태로 출력한다.
//       org.apache.log4j.HTMLLayout : HTML 테이블 형식으로 출력
//       org.apache.log4j.PatternLayout : 지정된 패턴 형식에 따라 로그 출력
//       org.apache.log4j.xml.XMLLayout : log4j.dtd 규칙에 따라 XML 문서 출력
//
// 4) PatternLayout을 사용하는 경우 다음과 같이 패턴 형식을 지정할 수 있다.
//    ex) log4j.appender.A1.layout.ConversionPattern=%5p [%t] %c - %m%n
//    %5p : 로그 레벨을 5자리 문자로 출력 
//    %t : 스레드 이름을 출력
//    %c : 로그를 출력한 클래스
//    %m : 로그 메시지 
//    %n : new line
// 
// 5) 특정 패키지나 클래스에 대해 별도로 로그 출력 레블을 지정할 수 있다.
//    log4j.logger.패키지명 또는 클래스명(패키지명 포함)=로그레벨
//    ex) log4j.logger.servlets.step06.ScoreList=INFO
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
      
      ScoreDao scoreDao = new ScoreDao();
      scoreDao.setDataSource(dataSource);
      
      // 페이지 컨트롤러를 ServletContext에 보관함.
      ScoreList scoreList = new ScoreList();
      scoreList.setScoreDao(scoreDao);
      ctx.setAttribute("/score/step06/list.do", scoreList);
      
      ScoreAdd scoreAdd = new ScoreAdd();
      scoreAdd.setScoreDao(scoreDao);
      ctx.setAttribute("/score/step06/add.do", scoreAdd);
      
      ScoreDelete scoreDelete = new ScoreDelete();
      scoreDelete.setScoreDao(scoreDao);
      ctx.setAttribute("/score/step06/delete.do", scoreDelete);
      
      ScoreUpdate scoreUpdate = new ScoreUpdate();
      scoreUpdate.setScoreDao(scoreDao);
      ctx.setAttribute("/score/step06/update.do", scoreUpdate);
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  @Override
  public void contextDestroyed(ServletContextEvent event) {
    logger.debug("contextDestroyed 호출됨...");
  }
}












