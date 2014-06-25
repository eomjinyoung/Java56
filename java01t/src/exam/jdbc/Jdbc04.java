package exam.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/* DELETE 처리 
 */

public class Jdbc04 {

  public static void main(String[] args) throws Exception {
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/bitdb", "bit", "1111"   );
    Statement stmt = con.createStatement();
    
    int count = stmt.executeUpdate(
        "delete from members where mno=10");
    
    if (count == 1) {
      System.out.println("삭제 완료!");
    }
    
    stmt.close();
    con.close();
  }

}






