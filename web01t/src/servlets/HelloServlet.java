package servlets;

/* Servlet 인터페이스
 * - 서블릿 컨테이너가 실행하는 클래스는 반드시 이 인터페이스를 구현해야 한다.
 */

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloServlet implements Servlet {
  ServletConfig config;
  
  // 서블릿 생명주기와 관련된 메서드: init(), destroy(), service()
  // 서블릿 인스턴스가 생성될 때 호출된다.
  @Override
  public void init(ServletConfig config) throws ServletException {
    System.out.println("init()....");
    this.config = config;
  }
  
  // 서블릿 컨테이너가 종료되거나 웹 애플리케이션이 중지될 때 호출된다.
  @Override
  public void destroy() {
    System.out.println("destroy()....");
  }
  
  // 클라이언트가 요청할 때 마다 호출된다.
  @Override
  public void service(ServletRequest arg0, ServletResponse arg1)
      throws ServletException, IOException {
    System.out.println("service()....오호라....^^");
  }

  // 서블릿 컨테이너의 관리자 기능을 수행할 때 호출된다.
  // - 서블릿의 설정정보를 다루는 도구를 리턴한다.
  // - 보통 init()에서 파라미터로 받은 도구를 그대로 리턴한다.
  @Override
  public ServletConfig getServletConfig() {
    System.out.println("getServletConfig()....");
    return this.config;
  }

  // 서블릿 컨테이너의 관리자 기능을 수행할 때 호출된다.
  // - 서블릿 정보를 간단하게 문자열로 리턴한다.
  @Override
  public String getServletInfo() {
    System.out.println("getServletInfo()....");
    return "버나드 엄의 서블릿";
  }

  

 

}
