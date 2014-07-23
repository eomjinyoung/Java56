package java56.service;

import java56.dao.MemberDao;
import java56.dao.StudentDao;
import java56.vo.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/* Business Layer
 * => 복잡한 업무 처리 절차를 캡슐화 한다. => 페이지 컨트롤러는 복잡한 업무 처리 과정을 알 필요가 없다.
 * => 스프링 MVC 프레임워크가 아니라도 어디에서든 사용할 수 있다.
 */

@Service
public class StudentService {
  @Autowired
  MemberDao   memberDao;
  
  @Autowired
  StudentDao  studentDao;
  
  @Transactional(
      propagation=Propagation.REQUIRED, 
      rollbackFor={Throwable.class})
  public void signup(Student student) throws Exception {
    memberDao.insert(student);
    studentDao.insert(student);
  }
}












