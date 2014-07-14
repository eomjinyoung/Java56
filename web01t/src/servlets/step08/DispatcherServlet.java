package servlets.step08;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* 가정!
 * - 실제 요청을 처리할 페이지 컨트롤러는 ServletContext 보관함에 들어 있다.
 * - 페이지 컨트롤러는 PageController 인터페이스 구현체이다.
 * - 페이지 컨트롤러는 URL을 키로 사용하여 보관된다.
 * - 페이지 컨트롤러의 리턴 값은 View(JSP)의 URL 정보이다.
 * 
 */

@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // 1. 클라이언트가 요청한 URL을 먼저 알아낸다.
    // 예) http://localhost:9999/web01t/score/step05/list.do
    // getServletPath()의 리턴 값: /score/step05/list.do
    String pageUrl = request.getServletPath();
    
    // 2. pageUrl로 ServletContext로부터 페이지 컨트롤러를 꺼낸다.
    PageController pageController = 
        (PageController)this.getServletContext().getAttribute(pageUrl);
    
    try {
      
      if (pageController == null) {
        throw new Exception("URL 요청을 처리할 수 없습니다.");
      }
      
      // 3. 페이지 컨트롤러가 사용할 객체를 준비한다.
      // 1) 요청 파라미터 맵을 준비한다.
      Map<String, String[]> paramMap = request.getParameterMap();
          
      // 2) 작업 결과를 담을 바구니를 준비한다.
      Map<String,Object> model = new HashMap<String,Object>();
      
      // 4. 페이지 컨트롤러를 실행한다.
      String viewUrl = pageController.execute(paramMap, model);
      
      // 5. 페이지 컨트롤러가 작업한 결과물을 ServletRequest 보관함에 담는다.
      for (Entry<String,Object> item : model.entrySet()) {
        request.setAttribute(item.getKey(), item.getValue());
      }
      
      // 6. 뷰 컨포넌트(JSP)를 인클루드 한다.
      if (viewUrl.startsWith("redirect:")) {
        response.sendRedirect(viewUrl.substring(9));
      } else {
        response.setContentType("text/html; charset=UTF-8");
        RequestDispatcher rd = request.getRequestDispatcher(viewUrl);
        rd.include(request, response);
      }
    } catch (Exception e) {
      RequestDispatcher rd = request.getRequestDispatcher("/score/step08/error");
      request.setAttribute("error", e);
      rd.forward(request, response);
    }
  }
}

















