package servlets.step04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/score/step04/add")
public class ScoreAdd extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // 필터로 대체함
    //request.setCharacterEncoding("UTF-8");
    
    Score score = new Score();
    score.setName(request.getParameter("name"));
    score.setKor(Integer.parseInt(request.getParameter("kor")));
    score.setEng(Integer.parseInt(request.getParameter("eng")));
    score.setMath(Integer.parseInt(request.getParameter("math")));
    
    ServletContext ctx = this.getServletContext();
    ScoreDao scoreDao = (ScoreDao)ctx.getAttribute("scoreDao");
    
    try {
      scoreDao.insert(score);
      
      // i) Refresh 정보를 응답헤더에 넣는다.
      //response.setHeader("Refresh", "1; url=list");
      
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<meta charset=\"UTF-8\">");
      // ii) Refresh 정보를 HTML <head>태그에 넣는다.
      //out.println("<meta http-equiv='Refresh' content='5; url=list'>");
      out.println("<title>성적 등록</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<p>등록 성공입니다.</p>");
      
      RequestDispatcher rd = request.getRequestDispatcher("/score/step03/copyright");
      rd.include(request, response);
      
      out.println("</body>");
      out.println("</html>");
      
      // iii) 웹 브라우저에게 재요청 정보를 전달한다.
      // => 본문 보내지 않는다. => 캐시에 보관된 내용물을 버린다.
      // => 만약 캐시가 꽉 차서 sendRedirect()를 호출하기 전에 이미 일부 내용을 보냈다면?
      // sendRedirect() 할 수 없다.
      
      /* PrintWriter 객체를 통해 출력하면,
       * 출력 내용은 즉시 웹 브라우저로 보내지지 않는다.
       * 출력 효율을 위해 => 임시 메모리(캐시)에 보관하였다가,
       * 캐시가 꽉차면 비로서 출력한다.
       * 또는 메서드 호출이 끝나면 출력한다.
       * 또는 flush()를 호출하면 강제로 방출시킬 수 있다.
       * 보통 캐시 크기는 8kb이다.
       */
      response.sendRedirect("list");
      
    } catch (Exception e) {
      // 오류가 발생하면 /score/step03/error 서블릿으로 위임한다.
      // 요청 배달자를 통해 요청을 해당 서블릿으로 배달한다.
      RequestDispatcher rd = request.getRequestDispatcher("/score/step03/error");
      
      // ErrorServlet에 실행을 위임하기 전에 ServletRequest 보관함에 
      // 오류정보를 담아서 보낸다.
      request.setAttribute("error", e);
      
      rd.forward(request, response);
    }
  }
}














