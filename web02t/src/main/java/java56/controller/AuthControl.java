package java56.controller;

import java56.service.StudentService;
import java56.vo.Student;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/auth")
public class AuthControl {
  
  @Autowired
  StudentService studentService;
  
  @RequestMapping(value="/login", method=RequestMethod.GET)
  public String form(
      @CookieValue(required=false) String userEmail, Model model) {
    
    if (userEmail != null) { // 요청 헤더에 userEmail 쿠키가 있다면, 
      // form.jsp에 전달한다.
      model.addAttribute("userEmail", userEmail);
    }
    return "/auth/form";
  }
  
  @RequestMapping(value="/login", method=RequestMethod.POST)
  public String login(
      String email, 
      String password,
      String saveId,
      HttpServletResponse response,
      HttpSession session) throws Exception {
    Student student = studentService.exist(email, password);
    
    if (student != null) {
      session.setAttribute("loginUser", student); // 세션에 Student 객체 보관 
      
      Cookie cookie = null;
      if (saveId != null) { // "ID 저장" 체크 상자를 선택했다면,
        //웹 브라우저에게 로그인 사용자의 ID 정보를 맡김
        cookie = new Cookie("userEmail", student.getEmail());
        //로그인 할 경우에만 사용자 이메일을 서버에 보내도록 한다. => 사용 범위 설정하지 않는다.
        //cookie.setPath("쿠키를 보내야 할 URL 정보");
        cookie.setMaxAge(60 * 60 * 24 * 15); // 사용자의 이메일 정보를 15일 동안 유지 시킴
      } else { // "ID 저장" 체크 상자를 선택하지 않았다면, 기존의 userEmail 쿠키 삭제
        cookie = new Cookie("userEmail", "");
        cookie.setMaxAge(0);
      }
      response.addCookie(cookie);

      return "redirect:../score/step02/list.do";
      
    } else {
      session.invalidate(); // 로그인 실패 => 세션 무효화 => 세션 객체를 삭제한다.
      
      // 로그인 실패하면 기존의 이메일 쿠키를 제거하도록 웹 브라우저에게 알린다.
      Cookie cookie = new Cookie("userEmail", "");
      cookie.setMaxAge(0); // 0이면 쿠키를 삭제하라는 명령이다.
      response.addCookie(cookie);
      
      return "redirect:login.do";
    }
  }
}









