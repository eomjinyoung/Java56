package java56.controller;

import java.io.File;
import java56.dao.MemberDao;
import java56.dao.StudentDao;
import java56.vo.Student;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

//@Controller
@RequestMapping("/member")
public class StudentControl01 {
  @Autowired
  ServletContext servletContext;
  
  @Autowired
  MemberDao memberDao;
  
  @Autowired
  StudentDao studentDao;
  
  @RequestMapping("/signup")
  public String signup() {
    return "/member/MemberSignup.jsp";
  }
  
  @RequestMapping(value="/signup2", method=RequestMethod.POST)
  public String signup2(
      Student student, 
      MultipartFile photo,
      HttpSession session,
      Model model) throws Exception {
    
    //업로드 파일을 임시 폴더에서 저장 폴더로 옮긴다.
    String uploadDir = servletContext.getRealPath("/fileupload");
    File uploadFile = new File(uploadDir + "/" + photo.getOriginalFilename());
    photo.transferTo(uploadFile);
    
    student.setPhotoPath(photo.getOriginalFilename());
    
    model.addAttribute("student", student);
    
    // 다음 요청에서 학생 기본 정보를 사용할 수 있도록 세션에 보관한다.
    session.setAttribute("student", student);

    return "/member/MemberSignup2.jsp";
  }
  
  @RequestMapping(value="/signup3", method=RequestMethod.POST)
  public String signup3(Student student, HttpSession session, Model model) {
    // 세션에 보관된 학생 정보 객체를 꺼낸다.
    Student studentBasicInfo = (Student) session.getAttribute("student");
    
    // 세션에서 꺼낸 학생 기본 정보를 추가 정보를 담고 있는 객체에 복사한다.
    student.setName(studentBasicInfo.getName());
    student.setTel(studentBasicInfo.getTel());
    student.setEmail(studentBasicInfo.getEmail());
    student.setPassword(studentBasicInfo.getPassword());
    student.setPhotoPath(studentBasicInfo.getPhotoPath());
    
    model.addAttribute("student", student);
    
    return "/member/MemberSignup3.jsp";
  }
}












