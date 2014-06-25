/* 배열 대신 ArrayList 적용 
 */
package exam.jdbc.step01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;

public class ScoreDao {

  public ScoreDao() {
  }

  public void insert(Score score) {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/bitdb?useUnicode=true&characterEncoding=UTF-8", 
          "bit", "1111"   );
      Statement stmt = con.createStatement();
      
      // executeUpdate() : INSERT, UPDATE, DELETE 문 수행 
      // - 리턴 값은 생성되거나, 변경되거나, 삭제된 레코드의 수
      int count = stmt.executeUpdate(
          "insert into members (name, email, tel, pwd)"
          + " values ('윤봉길', 's11@test.com', '111-1010', '1111')");
      
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
    return null;
  }

}










