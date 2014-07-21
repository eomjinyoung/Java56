package java56.controller;

import java56.dao.StudentDao;
import java56.vo.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/auth")
public class AuthControl {
  
  @Autowired
  StudentDao studentDao;
  
  @RequestMapping(value="/login", method=RequestMethod.GET)
  public String form() {
    return "/auth/form.jsp";
  }
  
  @RequestMapping(value="/login", method=RequestMethod.POST)
  public String login(String email, String password) throws Exception {
    Student student = studentDao.exist(email, password);
    
    if (student != null) {
      return "redirect:../score/step02/list.do";
      
    } else {
      return "redirect:login.do";
    }
  }
}









