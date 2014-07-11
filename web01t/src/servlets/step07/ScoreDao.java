/* DataSource 사용
 */
package servlets.step07;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class ScoreDao {
  DataSource dataSource;
  SqlSessionFactory sqlSessionFactory;
  
  public void setDataSource(DataSource dataSource) {
    this.dataSource = dataSource;
  }
  
  public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }  

  public List<Score> list() throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      return sqlSession.selectList("servlets.step07.ScoreDao.list"); 
      
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
    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null; // 자동 생성된 PK 값을 가져오는 역할자
    
    try {
      con = dataSource.getConnection();

      stmt = con.prepareStatement(
          "insert into scores (name, kor, eng, math)" +
          " values(?, ?, ?, ?)", 
          Statement.RETURN_GENERATED_KEYS);

      // IN-PARAMETER의 타입에 따라 setXxxx(인덱스, 값) 호출한다.
      stmt.setString(1, score.getName()); 
      stmt.setInt(2, score.getKor());
      stmt.setInt(3, score.getEng());
      stmt.setInt(4, score.getMath());
      
      int count = stmt.executeUpdate();
      
      if (count == 1) {
        // 입력 성공 후에 자동 생성된 PK 값 가져오기
        rs = stmt.getGeneratedKeys(); //1) 자동 생성 PK값 가져오는 역할자 얻기 
        rs.next(); // 2) PK 값 가져오기 
        score.setNo( rs.getInt(1)); // 3) DBMS에서 자동 생성된 PK 값을 Score에 저장. 
      }
      
    } catch (Exception e) {
      throw e;
      
    } finally { 
      try { rs.close();} catch (SQLException e) {}
      try { stmt.close();} catch (SQLException e) {}
      try { con.close();} catch (SQLException e) {}
    }
  }

  public int delete(int no) throws Exception {
    Connection con = null;
    PreparedStatement stmt = null;
    
    try {
      con = dataSource.getConnection();
      stmt = con.prepareStatement( 
          "delete from scores where sno = ?");
      
      stmt.setInt(1, no);
      
      return stmt.executeUpdate();
      
      
    } catch (Exception e) {
      throw e;
      
    } finally { 
      try { stmt.close();} catch (SQLException e) {}
      try { con.close();} catch (SQLException e) {}
    }
  }

  public void update(Score score) throws Exception {
    Connection con = null;
    PreparedStatement stmt = null;
    
    try {
      con = dataSource.getConnection();
      stmt = con.prepareStatement(
          "update scores set name=?, kor=?, eng=?, math=? where sno=?");
      
      stmt.setString(1, score.getName());
      stmt.setInt(2, score.getKor());
      stmt.setInt(3, score.getEng());
      stmt.setInt(4, score.getMath());
      stmt.setInt(5, score.getNo());
      
      stmt.executeUpdate();
      
    } catch (Exception e) {
      throw e;
      
    } finally { 
      try { stmt.close();} catch (SQLException e) {}
      try { con.close();} catch (SQLException e) {}
    }
  }

  
  
}










