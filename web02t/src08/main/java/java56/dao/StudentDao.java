
package java56.dao;

import java.util.Map;
import java56.vo.Student;

public interface StudentDao {
  Student exist(Map<String,Object> paramMap) throws Exception;
  int insert(Student student) throws Exception;
}










