package exam.jdbc.step01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ScoreDao03
{
	private int cursor;

	public ScoreDao03()
	{
		try
		{
			setMaxCursor();
		} catch (Exception e)
		{
			System.out.println("로드 에러");
			e.printStackTrace();
		}

	}

	public void insert(Score score)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
			    "jdbc:mysql://localhost:3306/bitdb", "bit", "1111");

			Statement stmt = con.createStatement();

			int count = stmt
			    .executeUpdate("insert into scores (name, kor, eng, math) "
			        + " values ('" + score.getName() + "'," + score.getKor() + ","
			        + score.getEng() + "," + score.getMath() + ")");

			if (count == 1)
				System.out.println("성적 입력 완료!!!");

			stmt.close();
			con.close();

			setMaxCursor();
		} catch (Exception e)
		{
			e.printStackTrace();
		}

	}

	public Score nextScore()
	{
		Score sc = new Score();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
			    "jdbc:mysql://localhost:3306/bitdb", "bit", "1111");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from scores where sno >= "
			    + ++cursor + " order by sno asc limit 1");

			if (!rs.next())
			{
				cursor--;
				return null;
			}

			if (this.cursor != rs.getInt("sno"))
				this.cursor = rs.getInt("sno");

			sc.setName(rs.getString("name"));
			sc.setKor(rs.getInt("kor"));
			sc.setEng(rs.getInt("eng"));
			sc.setMath(rs.getInt("math"));

			rs.close();
			stmt.close();
			con.close();
		} catch (Exception e)
		{
			System.out.println("예외발생");
			e.printStackTrace();
		}

		return sc;
	}

	public Score previousScore()
	{
		Score sc = new Score();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
			    "jdbc:mysql://localhost:3306/bitdb", "bit", "1111");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from scores where sno <= "
			    + --cursor + " order by sno desc limit 1");

			if (!rs.next())
			{
				cursor++;
				return null;
			}

			if (this.cursor != rs.getInt("sno"))
				this.cursor = rs.getInt("sno");

			sc.setName(rs.getString("name"));
			sc.setKor(rs.getInt("kor"));
			sc.setEng(rs.getInt("eng"));
			sc.setMath(rs.getInt("math"));

			rs.close();
			stmt.close();
			con.close();
		} catch (Exception e)
		{
			System.out.println("예외발생");
			e.printStackTrace();
		}

		return sc;
	}

	private void setMaxCursor() throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(
		    "jdbc:mysql://localhost:3306/bitdb", "bit", "1111");
		Statement stmt;
		stmt = con.createStatement();
		ResultSet rs = stmt
		    .executeQuery("select * from scores where SNO = (select MAX(SNO) from scores)");
		if (rs.next())
		{
			this.cursor = rs.getInt("SNO") + 1;
		} else
			return;
	}

}
