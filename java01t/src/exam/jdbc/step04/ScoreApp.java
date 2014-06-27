package exam.jdbc.step04;

/* ScoreFrame 사용
 * - 상속 기법을 이용하여 Frame 기능을 확장함.
 * 
 */

public class ScoreApp {

  public static void main(String[] args) throws Exception {
    ScoreFrame f = new ScoreFrame();
    
    DbConnectionPool dbPool = new DbConnectionPool(
        "com.mysql.jdbc.Driver",
        "jdbc:mysql://localhost:3306/bitdb?useUnicode=true&characterEncoding=UTF-8",
        "bit", "1111");
    
    ScoreDao scoreDao = new ScoreDao();
    scoreDao.setDbConnectionPool(dbPool); // Dependency Injection
    scoreDao.prepare();
    
    f.setScoreDao(scoreDao); // DI
    f.setVisible(true);
  }

}









