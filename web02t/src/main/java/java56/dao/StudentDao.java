
package java56.dao;

import java.util.HashMap;

import java56.vo.Student;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDao {
  @Autowired
  SqlSessionFactory sqlSessionFactory;
  
  public Student exist(String email, String password) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      HashMap<String,String> paramMap = new HashMap<String,String>();
      paramMap.put("email", email);
      paramMap.put("password", password);
      
      return sqlSession.selectOne("java56.dao.StudentDao.exist", paramMap);
      
    } catch (Exception e) {
      throw e;
      
    } finally { 
      sqlSession.close();
    }
  }
  
  public int insert(Student student) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      int count = sqlSession.insert("java56.dao.StudentDao.insert", student);
      //sqlSession.commit(); 트랜잭션 관리자를 적용하게 되면 commit()은 동작하지 않는다. 따라서 제거한다.
      return count;
      
    } catch (Exception e) {
      //sqlSession.rollback();
      throw e;
      
    } finally {
      sqlSession.close();
    }
  }
}










