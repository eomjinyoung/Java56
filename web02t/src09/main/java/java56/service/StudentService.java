package java56.service;

import java56.vo.Student;

/* 페이지 컨트롤러가 사용할 서비스 객체를 인터페이스로 전환함.
 * => 페이지 컨트롤러는 의존 객체의 타입으로 이 인터페이스를 지정해야 함.
 */
public interface StudentService {
  void signup(Student student) throws Exception;
  Student exist(String email, String password) throws Exception;
}












