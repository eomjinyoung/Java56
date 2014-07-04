package servlets.step01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 컴파일 한후 .class 파일에 주석 정보가 보관된다.
// why? 그래야만 톰캣 서버가 클래스 파일로부터 URL 정보를 얻을 것이 아니냐...

@WebServlet("/score/list")
public class ScoreList extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    super.doGet(req, resp);
  }

}










