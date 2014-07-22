package java56.controller;

import java.io.File;
import java56.dao.MemberDao;
import java56.dao.StudentDao;
import java56.vo.Student;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/member")
public class StudentControl {
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
      Model model) throws Exception {
    
    //업로드 파일을 임시 폴더에서 저장 폴더로 옮긴다.
    String uploadDir = servletContext.getRealPath("/fileupload");
    File uploadFile = new File(uploadDir + "/" + photo.getOriginalFilename());
    photo.transferTo(uploadFile);
    
    student.setPhotoPath(photo.getOriginalFilename());
    
    model.addAttribute("student", student);

    return "/member/MemberSignup2.jsp";
  }
}












