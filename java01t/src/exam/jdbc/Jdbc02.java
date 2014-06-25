package exam.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/* INSERT 처리 
 */

public class Jdbc02 {

  public static void main(String[] args) throws Exception {
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/bitdb", "bit", "1111"   );
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
  }

}






