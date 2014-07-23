package java56.controller;

import java.io.File;

import java56.dao.MemberDao;
import java56.dao.StudentDao;
import java56.vo.Student;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

/* 트랜잭션 적용
 * => 코딩으로 직접 특랜잭션 관리하기 (잘 사용하지 않는다)
 */

//@Controller
@RequestMapping("/member")
@SessionAttributes({"student"}) // 모델 보관소에 저장되는 객체들 중에서 세션에 들어갈 객체를 지정한다.
public class StudentControl01 {
  @Autowired
  PlatformTransactionManager txManager;
  
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
    
    // @SessionAttributes 에 선언한대로 student 이름을 객체를 모델에 보관하면
    // 해당 객체는 세션에 보관될 것이다.
    model.addAttribute("student", student);
    
    return "/member/MemberSignup2.jsp";
  }
 
  // @SessionAttributes로 지정된 값 꺼내기
  // => 요청 핸들러(요청이 들어 왔을 때 호출되는 메서드)를 정의할 때,
  //    파라미터의 타입이 @SessionAttributes에 선언된 객체와 같다면
  //    메서드가 호출될 때 세션에 보관된 객체가 넘어온다.
  @RequestMapping(value="/signup3", method=RequestMethod.POST)
  public String signup3(
      /* 이 파라미터의 값으로 세션에 저장된 "student" 객체가 자동으로 넘어온다.*/
      Student studentok) {
    
    // 굳이 모델 객체에 저장할 필요가 없다. 왜냐하면 이미 student 객체는 세션에 보관되어 있기 때문이다.
    //model.addAttribute("student", studentok);
    
    return "/member/MemberSignup3.jsp";
  }
  
  @RequestMapping(value="/signupComplete", method=RequestMethod.POST)
  public String signupComplete(Student student) throws Exception {
    // 아래의 두 개 작업을 하나의 트랜잭션 그룹으로 묶는다.
    // 1) 트랜잭션 정의 
    DefaultTransactionDefinition def = new DefaultTransactionDefinition();
    def.setName("tx1");
    def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
    
    // 2) 트랜잭션 정의에 따라 상태를 관리할 객체 준비
    TransactionStatus status = txManager.getTransaction(def);
    
    try {
      memberDao.insert(student); // 학생 기본 정보 입력
      studentDao.insert(student); // 학생 추가 정보 입력
      
      //3) 오류가 없으면 지금까지 수행한 작업을 승인한다.
      txManager.commit(status);
      
    } catch (Exception e) {
      //4) 만약 오류가 있다면, 지금까지 수행한 작업을 취소한다.
      txManager.rollback(status);
      throw e;
    }
    
    return "/member/MemberSignupComplete.jsp";
  }
}












