/* DataSource 사용
 */
package servlets.step07;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class ScoreDao {
  SqlSessionFactory sqlSessionFactory;
  
  public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }  

  public List<Score> list(int pageNo, int pageSize, String order) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      HashMap<String,Object> params = new HashMap<String,Object>();
      params.put("pageStartIndex", (pageNo - 1) * pageSize);
      params.put("pageSize", pageSize);
      params.put("order", order);
      
      return sqlSession.selectList("servlets.step07.ScoreDao.list", params);
      
    } catch (Exception e) {
      throw e;
      
    } finally {
      sqlSession.close();
    }
  }
  
  public List<Score> list(int pageNo, int pageSize, 
      String columnName, String orderType) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      HashMap<String,Object> params = new HashMap<String,Object>();
      params.put("pageStartIndex", (pageNo - 1) * pageSize);
      params.put("pageSize", pageSize);
      params.put("orderType", orderType);
      params.put("columnName", columnName);
      
      return sqlSession.selectList("servlets.step07.ScoreDao.list2", params);
      
    } catch (Exception e) {
      throw e;
      
    } finally {
      sqlSession.close();
    }
  }

  public int countAll() throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      return sqlSession.selectOne("servlets.step07.ScoreDao.countAll");
      
    } catch (Exception e) {
      throw e;
      
    } finally {
      sqlSession.close();
    }
  }
  
  public Score selectOne(int no) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      return sqlSession.selectOne("servlets.step07.ScoreDao.selectOne", no);
      
    } catch (Exception e) {
      throw e;
      
    } finally { 
      sqlSession.close();
    }
  }

  public void insert(Score score) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    try {
      sqlSession.insert("servlets.step07.ScoreDao.insert", score);
      sqlSession.commit();
      
    } catch (Exception e) {
      sqlSession.rollback();
      throw e;
      
    } finally {
      sqlSession.close();
    }
  }

  public int delete(int no) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    try {
      int count = sqlSession.delete("servlets.step07.ScoreDao.delete", no);
      sqlSession.commit();
      return count;
      
    } catch (Exception e) {
      sqlSession.rollback();
      throw e;
      
    } finally { 
      sqlSession.close();
    }
  }

  public void update(Score score) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    try {
      sqlSession.update("servlets.step07.ScoreDao.update", score);
      sqlSession.commit();
      
    } catch (Exception e) {
      sqlSession.rollback();
      throw e;
      
    } finally { 
      sqlSession.close();
    }
  }

  
  
}










