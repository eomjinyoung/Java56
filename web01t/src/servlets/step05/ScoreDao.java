/* PreparedStatement 적용 
 * - SQL 템플릿을 정의한 후, IN-PARAMETER에 값을 넣는 방법
 * - 장점
 *   1) SQL문이 간결해진다.
 *   2) IN-PARAMETER를 통해 값을 입력하기 때문에 SQL문을 조작할 수 없다.
 *   3) 바이너리 데이터를 입력할 수 있다.
 *   4) 반복하여 작업을 수행할 때 속도가 빠르다.
 *      => 이유: SQL문을 미리 만들어 놓고 값만 입력하여 실행하기 때문이다.
 */
package servlets.step05;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ScoreDao {
  DbConnectionPool dbConnectionPool;
  
  public void setDbConnectionPool(DbConnectionPool dbConnectionPool) {
    this.dbConnectionPool = dbConnectionPool;
  }
  
  public ArrayList<Score> list() throws Exception {
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    try {
      con = dbConnectionPool.getConnection();
      stmt = con.createStatement();
      
      rs = stmt.executeQuery(
          "select sno, name, kor, eng, math "
          + " from scores order by sno desc");
      
      ArrayList<Score> scores = new ArrayList<Score>();
      Score score = null;
      
      while (rs.next()) {
        score = new Score();
        score.setNo( rs.getInt("sno"));
        score.setName( rs.getString("name"));
        score.setKor( rs.getInt("kor"));
        score.setEng( rs.getInt("eng"));
        score.setMath( rs.getInt("math")); 
        scores.add(score);
      }
      
      return scores;
      
    } catch (Exception e) {
      throw e;
      
    } finally { 
      try { rs.close();} catch (SQLException e) {}
      try { stmt.close();} catch (SQLException e) {}
      //try { con.close();} catch (SQLException e) {}
      dbConnectionPool.returnConnection(con);
    }
  }

  public Score selectOne(int no) throws Exception {
    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    try {
      con = dbConnectionPool.getConnection();
      stmt = con.prepareStatement(
          "select sno, name, kor, eng, math from scores where sno=?");
      stmt.setInt(1, no);
      rs = stmt.executeQuery();
      
      if (rs.next()) {
        Score score = new Score();
        score.setNo( rs.getInt("sno"));
        score.setName( rs.getString("name"));
        score.setKor( rs.getInt("kor"));
        score.setEng( rs.getInt("eng"));
        score.setMath( rs.getInt("math"));
        return score;
        
      } else {
        return null;
      }
      
    } catch (Exception e) {
      throw e;
      
    } finally { 
      try { rs.close();} catch (SQLException e) {}
      try { stmt.close();} catch (SQLException e) {}
      //try { con.close();} catch (SQLException e) {}
      dbConnectionPool.returnConnection(con);
    }
  }

  public void insert(Score score) throws Exception {
    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null; // 자동 생성된 PK 값을 가져오는 역할자
    
    try {
      con = dbConnectionPool.getConnection();

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
      //try { con.close();} catch (SQLException e) {}
      dbConnectionPool.returnConnection(con);
    }
  }

  public int delete(int no) throws Exception {
    Connection con = null;
    PreparedStatement stmt = null;
    
    try {
      con = dbConnectionPool.getConnection();
      stmt = con.prepareStatement( 
          "delete from scores where sno = ?");
      
      stmt.setInt(1, no);
      
      return stmt.executeUpdate();
      
      
    } catch (Exception e) {
      throw e;
      
    } finally { 
      try { stmt.close();} catch (SQLException e) {}
      //try { con.close();} catch (SQLException e) {}
      dbConnectionPool.returnConnection(con);
    }
  }

  public void update(Score score) throws Exception {
    Connection con = null;
    PreparedStatement stmt = null;
    
    try {
      con = dbConnectionPool.getConnection();
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
      //try { con.close();} catch (SQLException e) {}
      dbConnectionPool.returnConnection(con);
    }
  }  
  
}










