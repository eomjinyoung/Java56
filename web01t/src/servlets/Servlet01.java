package servlets;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Servlet01 extends GenericServlet {
  private static final long serialVersionUID = 1L;

  // 클라이언트에서 GET으로 요청하든지, POST로 요청하든지 간에 
  // 서블릿 컨테이너는 service()를 호출한다.
  @Override
  public void service(ServletRequest arg0, ServletResponse arg1)
      throws ServletException, IOException {
    System.out.println("okok");

  }

}
