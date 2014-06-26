package exam.jdbc.step01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class ScoreDao02 {
	
	static int cursor;
	Connection con;
	Statement stmt;
	ResultSet rs;

  public ScoreDao02() {
	  try{
		  Class.forName("com.mysql.jdbc.Driver");
		  
		    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bitdb", "bit","1111" );
		    stmt = con.createStatement();
		    rs = stmt.executeQuery("select* from scores where sno = (select max(SNO) from scores);");
		    
		    if(rs.next()){
		    	 cursor = rs.getInt("sno")+1;
		    }
		    rs.close();
		    stmt.close();
		    con.close();
	  } catch(Exception e){
		  e.printStackTrace();
	  }
  }

  public void insert(Score score) {
	  try{
		  Class.forName("com.mysql.jdbc.Driver");
		  
		    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bitdb", "bit","1111" );
		    stmt = con.createStatement();
		    
		    int count = stmt.executeUpdate(
		    		"insert into scores (name, kor, eng, math) "
		    		+ " values('"+ score.getName()+ "',"+
		    				score.getKor()+ ","+
		    				score.getEng()+","+
		    				score.getMath()+")");
		    
		    if(count == 1){
		    	System.out.println("입력완료!");
		    }

		    stmt.close();
		    con.close();
	  } catch(Exception e){
		  e.printStackTrace(); //어떤예외가 발생했는지 상세하게 출력
	  }
	 
  }

  public Score nextScore() {
	 Score score = new Score();
	 
	  try{
		  Class.forName("com.mysql.jdbc.Driver");
		   
		   con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bitdb", "bit","1111" );
		   stmt = con.createStatement();
		   rs = stmt.executeQuery("select* from scores where sno >" + cursor++ +" order by sno asc Limit 1");
		    
		   if(!rs.next()){
			   cursor--;
			   return null;
		    }
		    score.setName(rs.getString("name"));
		    score.setKor(rs.getInt("kor"));
		    score.setEng(rs.getInt("eng"));
		    score.setMath(rs.getInt("math"));
		   
		    rs.close();
		    stmt.close();
		    con.close();
		    
	  } catch(Exception e){
		  e.printStackTrace(); //어떤예외가 발생했는지 상세하게 출력
	  }
	  return score;
  }

  public Score previousScore() {
	  
	  Score score = new Score();
	  
	  try{ 
		  Class.forName("com.mysql.jdbc.Driver");
		   
		    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bitdb", "bit","1111" );
		    stmt = con.createStatement();
		    rs = stmt.executeQuery("select* from scores where sno <" + cursor-- +" order by sno desc Limit 1");
		 
		   if(!rs.next()){
			   cursor = 1;
			   return null;	
		    }
		   score.setName(rs.getString("name"));
		   score.setKor(rs.getInt("kor"));
		   score.setEng(rs.getInt("eng"));
		   score.setMath(rs.getInt("math"));
		   
		    rs.close();
		    stmt.close();
		    con.close();
		    
	} catch(Exception e){
		  e.printStackTrace(); //어떤예외가 발생했는지 상세하게 출력
	}
	return score;
  }
	 
}
