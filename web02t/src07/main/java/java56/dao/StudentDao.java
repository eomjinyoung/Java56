
package java56.dao;

import java56.vo.Student;

public interface StudentDao {
  Student exist(String email, String password) throws Exception;
  int insert(Student student) throws Exception;
}










