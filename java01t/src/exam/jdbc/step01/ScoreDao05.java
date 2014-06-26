/* 배열 대신 ArrayList 적용   
 */

package exam.jdbc.step01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ScoreDao05 {
    int currSno;
    int lastRowSno;
    Score score = new Score();


    public ScoreDao05() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bitdb",
                "bit", "1111");
            Statement stmtSelect = con.createStatement();
            ResultSet rs = stmtSelect.executeQuery("select sno, name from scores");
            while (rs.next()) {
                currSno = rs.getInt("sno");
                lastRowSno = rs.getInt("sno");
            }
            currSno += 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("initialization of currSno, lastRowSno in ScoreDao : "
            + currSno + ", " + lastRowSno);
    }

    public void insert(Score score) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bitdb",
                "bit", "1111");

            // insert
            Statement stmt = con.createStatement();
            int count = stmt
                .executeUpdate("insert into scores(name, kor, eng, math)  "
                    + "values('" + score.getName() + "'," + score.getKor() + ","
                    + score.getEng() + "," + score.getMath() + ")");

            // select to get "getRow"
            Statement stmtSelect = con.createStatement();
            ResultSet rs = stmtSelect.executeQuery("select sno, name from scores");
            while (rs.next()) {
                currSno = rs.getInt("sno");
                lastRowSno = rs.getInt("sno");
                // System.out.println("SNO : "+rs.getInt("sno"));
                // System.out.println("rs.getRow() : "+rs.getRow());
                // System.out.println("NAME : "+rs.getString("name"));
            }

            System.out.println("currSno : " + currSno);
            System.out.println("lastRowSno : " + lastRowSno);

            if (count == 1) {
                System.out.println("success!");
                // cursor = rs.getInt(rs.getRow());
            }

            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Score previousScore() {
//      System.out.println("previousScore of currSno, lastRowSno in ScoreDao : "
//          + currSno + ", " + lastRowSno);
        
        System.out.println("forhead previous" + currSno);
        if (currSno < 0) {
            return null;
        }else{
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/bitdb", "bit", "1111");

                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select sno, name, kor, eng, math "
                        + "from scores where sno <" + currSno + " order by sno desc limit 1");
                while (rs.next()) {
                    System.out.println("previous" + currSno);
                    score.setName(rs.getString("name"));
                    score.setKor(rs.getInt("kor"));
                    score.setEng(rs.getInt("Eng"));
                    score.setMath(rs.getInt("Math"));
                    currSno = rs.getInt("sno");
                }
                //--currSno;

                rs.close();
                stmt.close();
                con.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return score;
    }

    public Score nextScore() {
        if (currSno > lastRowSno) {
            return null;
        }else{
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/bitdb", "bit", "1111");

                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select sno, name, kor, eng, math "
                        + "from scores where sno >" + currSno + " order by sno limit 1");
                while (rs.next()) {
                    score.setName(rs.getString("name"));
                    score.setKor(rs.getInt("kor"));
                    score.setEng(rs.getInt("Eng"));
                    score.setMath(rs.getInt("Math"));
                    currSno = rs.getInt("sno");
                }

                rs.close();
                stmt.close();
                con.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return score;
    }

}