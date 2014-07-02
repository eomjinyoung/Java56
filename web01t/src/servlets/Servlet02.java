package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet02 extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  // 처리되어야 할 요청 명령에 해당하는 메서드를 재정의하라!
  // 만약 GET 요청을 처리해야 한다면 doGet() 오버라이딩 한다.
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    System.out.println("Servlet02.doGet().....");
  }
  
  // 만약 POST 요청도 처리해야 한다면 doPost()도 오버라이딩 하라!
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    System.out.println("Servlet02.doPost().....");
  }
}










