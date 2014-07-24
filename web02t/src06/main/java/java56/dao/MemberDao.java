package java56.dao;

import java56.vo.Member;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDao {
  @Autowired
  SqlSessionFactory sqlSessionFactory;
  
  public int insert(Member member) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      int count = sqlSession.insert("java56.dao.MemberDao.insert", member);
      //sqlSession.commit(); // 트랜잭션 관리자 도입으로 이 코드 제거.
      return count;
      
    } catch (Exception e) {
      //sqlSession.rollback(); 
      throw e;
      
    } finally {
      sqlSession.close();
    }
  }
}










