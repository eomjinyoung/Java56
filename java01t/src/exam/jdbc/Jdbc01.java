package exam.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/* 역할자
 * - 어떤 기능들을 수행하는 클래스를 지칭 
 * - 기능 = 메서드 
 * - 메서드는 인스턴스를 통해 호출함
 * - 역할자를 "객체"라 부름 
 */

public class Jdbc01 {

  public static void main(String[] args) throws Exception {
    // 1. Driver 역할자(객체)를 로딩
    // Driver 역할자란? 
    // - JDBC 드라이버의 정보를 알려주는 객체 
    // - DBMS와의 연결을 수행하는 객체
    // - java.sql.Driver 인터페이스를 구현한 객체
    // Driver 역할자를 로딩?
    // - java.sql.Driver 구현체(구현한 클래스)를 로딩 
    // - ex) MySQL JDBC Driver => com.mysql.jdbc.Driver
    // 임의로 클래스 로딩 방법?
    // - java.lang.Class.forName("클래스이름");
    // - 클래스 이름은 반드시 패키지 이름을 포함해야 한다.
    Class.forName("com.mysql.jdbc.Driver");
    
    // 2. DriverManager를 통해 Connection 역할자를 얻기
    // - 동작원리
    //   1) DriverManager의 getConnection() 호출
    //   2) DriverManager는 로딩된 com.mysql.jdbc.Driver 인스턴스를 생성한다.
    //   3) com.mysql.jdbc.Driver 객체의 connect() 함수를 호출한다.
    //   4) com.mysql.jdbc.Driver는 MySQL DBMS와의 연결을 관리하는 
    //      Connection 객체를 생성한 후 리턴한다.
    //   5) DriverManager는 com.mysql.jdbc.Driver의 connect()가 리턴한 값을 다시 리턴한다.
    // - Connection 객체
    //   => DBMS 인증 정보를 갖고 있다.
    //   => DBMS와의 연결을 관리한다.
    Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/bitdb", /* DBMS의 접속하는 JDBC URL 주소 => DBMS 마다 URL 규칙이 조금씩 다르다. */ 
        "bit",  /* DBMS 접속할 때 사용할 사용자 아이디 */
        "1111"  /* DBMS 접속할 때 사용할 사용자 암호 */ );
    
    // 3. Connection 역할자를 통해 Statement 역할자를 얻기
    // - Statement 객체
    //   => DBMS에 SQL을 전달하는 역할 수행 
    Statement stmt = con.createStatement();
    
    // 4. Statement 역할자를 통해 SQL 서버에 보냄
    // - SELECT 문 => executeQuery() 또는 execute() 호출
    // - INSERT, UPDATE, DELETE => executeUpdate() 또는 execute() 호출 
    // - executeQuery() 메서드
    //   => 서버로부터 결과 레코드를 가져오는 작업을 수행할 ResultSet 객체 리턴 
    ResultSet rs = stmt.executeQuery("select mno, name, email, tel from members");
    
    // 5. ResultSet 역할자를 통해 서버에서 레코드를 하나씩 가져옴
    // - next() 메서드
    //   => 서버로부터 레코드를 한 개 가져오는 역할 
    //   => 구현체에 따라 미리 약간의 레코드를 서버에서 가져올 수 있음.
    //   => 레코드를 가져왔으면 true, 가져오지 못했으면(없으면) false 리턴
    //   => 가져온 레코드 값은 자신이 갖고 있다.
    // - getXxx() 메서드
    //   => 서버에서 가져온 레코드로부터 컬럼 값을 꺼내는 메서드
    //   => 컬럼의 타입에 따라 적당한 메서드 호출해야 한다. 예)getString(), getInt(), getDate()
    //   => 파라미터 값으로 컬럼의 인덱스(1부터 시작)나 이름을 주면 된다.
    //   => SQL문의 영향을 덜 받으려면 파라미터 값으로 컬럼의 이름을 사용할 것!
    while (rs.next()) {
      System.out.print( rs.getInt("mno") + ",");
      System.out.print( rs.getString("name") + ",");
      System.out.print( rs.getString("email") + ",");
      System.out.println( rs.getString("tel"));
    }
    
    // 객체를 닫을 때는 항상 꺼꾸로 수행한다.
    // 6. ResultSet 역할자 끊기
    rs.close();
    
    // 7. Statement 역할자 끊기
    stmt.close();
    
    // 8. Connection 역할자 끊기
    // - DBMS에 연결하고 작업을 수행했으면 연결을 끊어 줘야 한다.
    //   => 다른 애플리케이션에서 사용할 수 있다.
    // - close()를 호출하지 않는다면?
    //   DBMS는 내부적으로 설정된 시간(timeout) 동안에는 계속 해당 연결을 유지한다.
    //   타임 아웃되면, 그제서야 서버쪽의 연결을 끊는다. 
    con.close();
  }

}






