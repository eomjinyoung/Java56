/* DbConnectionPool 적용
 * - 외부에서 DB 커넥션 관리자를 주입 받는다.
 * - 의존 객체 주입 => Dependency Injection (의존성 주입)
 */
package exam.jdbc.step03;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ScoreDao {
  DbConnectionPool dbConnectionPool;
  Score currScore;
  
  public void prepare() {
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    try {
      con = dbConnectionPool.getConnection();
      stmt = con.createStatement();
      
      rs = stmt.executeQuery(
          "select sno, name, kor, eng, math "
          + " from scores order by sno desc limit 1");
      
      if (rs.next()) {
        currScore = new Score();
        currScore.setNo( rs.getInt("sno"));
        currScore.setName( rs.getString("name"));
        currScore.setKor( rs.getInt("kor"));
        currScore.setEng( rs.getInt("eng"));
        currScore.setMath( rs.getInt("math"));  
      }
      
    } catch (Exception e) {
      e.printStackTrace();
      
    } finally { 
      try { rs.close();} catch (SQLException e) {}
      try { stmt.close();} catch (SQLException e) {}
      //try { con.close();} catch (SQLException e) {}
      dbConnectionPool.returnConnection(con);
    }
  }

  public void setDbConnectionPool(DbConnectionPool dbConnectionPool) {
    this.dbConnectionPool = dbConnectionPool;
  }

  public void insert(Score score) {
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null; // 자동 생성된 PK 값을 가져오는 역할자
    
    try {
      con = dbConnectionPool.getConnection();
      stmt = con.createStatement();
      
      int count = stmt.executeUpdate(
          "insert into scores (name, kor, eng, math)"
          + " values ('" + score.getName() + "'," + 
              score.getKor() + "," + 
              score.getEng() + "," + 
              score.getMath() + ")", 
          Statement.RETURN_GENERATED_KEYS);
      
      if (count == 1) {
        // 입력 성공 후에 자동 생성된 PK 값 가져오기
        rs = stmt.getGeneratedKeys(); //1) 자동 생성 PK값 가져오는 역할자 얻기 
        rs.next(); // 2) PK 값 가져오기 
        score.setNo( rs.getInt(1)); // 3) DBMS에서 자동 생성된 PK 값을 Score에 저장. 
        currScore = score;
      }
      
    } catch (Exception e) {
      e.printStackTrace();
      
    } finally { 
      try { rs.close();} catch (SQLException e) {}
      try { stmt.close();} catch (SQLException e) {}
      //try { con.close();} catch (SQLException e) {}
      dbConnectionPool.returnConnection(con);
    }
  }

  public Score next() {
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    try {
      con = dbConnectionPool.getConnection();
      stmt = con.createStatement();
      
      rs = stmt.executeQuery(
          "select sno, name, kor, eng, math" +
          " from scores " +
          " where sno = ( select min(sno) from scores where sno > " +
          currScore.getNo() + " )");
      
      if (rs.next()) {
        currScore = new Score();
        currScore.setNo( rs.getInt("sno"));
        currScore.setName( rs.getString("name"));
        currScore.setKor( rs.getInt("kor"));
        currScore.setEng( rs.getInt("eng"));
        currScore.setMath( rs.getInt("math"));   
        return currScore;
        
      } else {
        return null;
      }
      
    } catch (Exception e) {
      e.printStackTrace();
      return null;
      
    } finally { 
      try { rs.close();} catch (SQLException e) {}
      try { stmt.close();} catch (SQLException e) {}
      //try { con.close();} catch (SQLException e) {}
      dbConnectionPool.returnConnection(con);
    }
  }

  public Score previous() {
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    try {
      con = dbConnectionPool.getConnection();
      stmt = con.createStatement();
      
      rs = stmt.executeQuery(
          "select sno, name, kor, eng, math" +
          " from scores " +
          " where sno = ( select max(sno) from scores where sno < " +
          currScore.getNo() + " )");
      
      if (rs.next()) {
        currScore = new Score();
        currScore.setNo( rs.getInt("sno"));
        currScore.setName( rs.getString("name"));
        currScore.setKor( rs.getInt("kor"));
        currScore.setEng( rs.getInt("eng"));
        currScore.setMath( rs.getInt("math"));        
        return currScore;
        
      } else {
        return null;
      }
      
    } catch (Exception e) {
      e.printStackTrace();
      return null;
      
    } finally { 
      try { rs.close();} catch (SQLException e) {}
      try { stmt.close();} catch (SQLException e) {}
      //try { con.close();} catch (SQLException e) {}
      dbConnectionPool.returnConnection(con);
    }
  }
  
  public void delete() {
    Connection con = null;
    Statement stmt = null;
    
    try {
      con = dbConnectionPool.getConnection();
      stmt = con.createStatement();
      
      int count = stmt.executeUpdate(
          "delete from scores where sno = " + currScore.getNo());
      
      if (count == 1) {
        // 정상적으로 삭제했으면 이전 데이터를 가져와야 한다.
 
        Score score = previous();
        if (score == null) {
          score = next();
          if (score == null) {
            currScore = null;
          }
        }
      }
      
    } catch (Exception e) {
      e.printStackTrace();
      
    } finally { 
      try { stmt.close();} catch (SQLException e) {}
      //try { con.close();} catch (SQLException e) {}
      dbConnectionPool.returnConnection(con);
    }
  }

  public void update() {
    Connection con = null;
    Statement stmt = null;
    
    try {
      con = dbConnectionPool.getConnection();
      stmt = con.createStatement();
      
      int count = stmt.executeUpdate(
          "update scores set" +
          " name = '" + currScore.getName() + "'," +
          " kor = " + currScore.getKor() + "," +
          " eng = " + currScore.getEng() + "," +
          " math = " + currScore.getMath() + 
          " where sno = " + currScore.getNo());
      
      if (count == 1) {
        System.out.println("변경 성공!");
      }
      
    } catch (Exception e) {
      e.printStackTrace();
      
    } finally { 
      try { stmt.close();} catch (SQLException e) {}
      //try { con.close();} catch (SQLException e) {}
      dbConnectionPool.returnConnection(con);
    }
  }  
  
  public Score getCurrentScore() {
    return currScore;
  }
}










