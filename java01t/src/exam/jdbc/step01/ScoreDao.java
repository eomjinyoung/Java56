/* 배열 대신 ArrayList 적용 
 */
package exam.jdbc.step01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ScoreDao {
  Score currScore;
  
  public ScoreDao() {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/bitdb?useUnicode=true&characterEncoding=UTF-8", 
          "bit", "1111"   );
      Statement stmt = con.createStatement();
      
      ResultSet rs = stmt.executeQuery(
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
      
      stmt.close();
      con.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void insert(Score score) {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/bitdb?useUnicode=true&characterEncoding=UTF-8", 
          "bit", "1111"   );
      Statement stmt = con.createStatement();
      
      int count = stmt.executeUpdate(
          "insert into scores (name, kor, eng, math)"
          + " values ('" + score.getName() + "'," + 
              score.getKor() + "," + 
              score.getEng() + "," + 
              score.getMath() + ")");
      
      if (count == 1) {
        System.out.println("입력 완료!");
      }
      
      stmt.close();
      con.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public Score nextScore() {
    return null;
  }

  public Score previousScore() {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/bitdb?useUnicode=true&characterEncoding=UTF-8", 
          "bit", "1111"   );
      Statement stmt = con.createStatement();
      
      ResultSet rs = stmt.executeQuery(
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
      
      stmt.close();
      con.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public Score getCurrentScore() {
    return currScore;
  }
}










