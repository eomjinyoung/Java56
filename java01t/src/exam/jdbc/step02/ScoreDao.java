/* close() 정석!
 * - 오류가 발생했을 때도 정상적으로 연결을 끊을 수 있도록 처리한다.
 * - try ... catch ... finally 
 */
package exam.jdbc.step02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ScoreDao {
  Score currScore;
  
  public ScoreDao() {
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    try {
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/bitdb?useUnicode=true&characterEncoding=UTF-8", 
          "bit", "1111"   );
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
      
    } finally { // 정상적으로 수행하든, 오류가 발생하든 간에 반드시 수행하는 블록 
      // 즉, try 블록이나 catch 블록을 나가기 전에 반드시 finally 블록을 수행한다.
      try { rs.close();} catch (SQLException e) {}
      try { stmt.close();} catch (SQLException e) {}
      try { con.close();} catch (SQLException e) {}
    }
  }

  public void insert(Score score) {
    Connection con = null;
    Statement stmt = null;
    
    try {
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/bitdb?useUnicode=true&characterEncoding=UTF-8", 
          "bit", "1111"   );
      stmt = con.createStatement();
      
      int count = stmt.executeUpdate(
          "insert into scores (name, kor, eng, math)"
          + " values ('" + score.getName() + "'," + 
              score.getKor() + "," + 
              score.getEng() + "," + 
              score.getMath() + ")");
      
      if (count == 1) {
        System.out.println("입력 완료!");
      }
      
    } catch (Exception e) {
      e.printStackTrace();
      
    } finally { 
      try { stmt.close();} catch (SQLException e) {}
      try { con.close();} catch (SQLException e) {}
    }
  }

  public Score nextScore() {
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    try {
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/bitdb?useUnicode=true&characterEncoding=UTF-8", 
          "bit", "1111"   );
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
      }
      
      return currScore;
    } catch (Exception e) {
      e.printStackTrace();
      
    } finally { 
      try { rs.close();} catch (SQLException e) {}
      try { stmt.close();} catch (SQLException e) {}
      try { con.close();} catch (SQLException e) {}
    }
    return null;
  }

  public Score previousScore() {
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    try {
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/bitdb?useUnicode=true&characterEncoding=UTF-8", 
          "bit", "1111"   );
      stmt = con.createStatement();
      
      // where 절에 서브 쿼리 적용 
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
      }
      
      return currScore;
    } catch (Exception e) {
      e.printStackTrace();
      
    } finally { 
      try { rs.close();} catch (SQLException e) {}
      try { stmt.close();} catch (SQLException e) {}
      try { con.close();} catch (SQLException e) {}
    }
    return null;
  }

  public Score getCurrentScore() {
    return currScore;
  }
}










