package exam.jdbc.step01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ScoreDao04 {

	Connection con;
	Statement stmt;
	ResultSet rs;

	int cursor;

	public ScoreDao04() {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bitdb",
			    "bit", "1111");
			stmt = con.createStatement();
			rs = stmt.executeQuery("select max(sno) from scores");
			if (rs.next()) {
				cursor = rs.getInt("max(sno)") + 1;
			}
			//stmt.close();
			//con.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void insert(Score score) {
		try {

			int count = stmt
			    .executeUpdate("insert into scores (name, kor, eng, math)"
			        + " values ('" + score.getName() + "'," + score.getKor() + ","
			        + score.getEng() + "," + score.getMath() + ")");

			if (count == 1) {
				System.out.println("입력 완료!");
			}
			rs = stmt.executeQuery("select max(sno) from scores");
			if (rs.next()) {
				cursor = rs.getInt("max(sno)") + 1;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Score nextScore() {
		Score score = new Score();
		try {
			rs = stmt
			    .executeQuery("select sno,name, kor, eng, math from scores where sno > "
			        + cursor + " ORDER BY sno ASC LIMIT 1");

			if (rs.next()) {
				score.setName(rs.getString("name"));
				score.setKor(rs.getInt("kor"));
				score.setEng(rs.getInt("eng"));
				score.setMath(rs.getInt("math"));
				cursor = rs.getInt("sno");
				rs.close();
				return score;
			}

		} catch (Exception e) {
			System.out.println("RS 에러");
		}
		return null;
	}

	public Score previousScore() {
		Score score = new Score();
		try {
			rs = stmt
			    .executeQuery("select sno, name, kor, eng, math from scores where sno < "
			        + cursor + " ORDER BY sno DESC LIMIT 1");

			if (rs.next()) {
				score.setName(rs.getString("name"));
				score.setKor(rs.getInt("kor"));
				score.setEng(rs.getInt("eng"));
				score.setMath(rs.getInt("math"));
				cursor = rs.getInt("sno");

				rs.close();
				return score;
			}
		} catch (Exception e) {
			System.out.println("RS 에러");
		}
		return null;
	}

}
