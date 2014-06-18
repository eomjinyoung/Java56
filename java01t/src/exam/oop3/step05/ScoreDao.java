/* 배열 대신 ArrayList 적용 
 */
package exam.oop3.step05;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ScoreDao {
  ArrayList<Score> scores = new ArrayList<Score>();
  int cursor;

  public ScoreDao() {
  }

  public void insert(Score score) {
    scores.add(score);
    cursor = scores.size();
  }

  public Score nextScore() {
    if (cursor >= scores.size() - 1) 
      return null;

    return scores.get(++cursor);
  }

  public Score previousScore() {
    if (cursor <= 0) 
      return null;

    return scores.get(--cursor);
  }

  public Object[] toArray() {
    return this.scores.toArray();
  }

  public void save() throws IOException {
    File data = new File("test.csv");
    FileWriter out = new FileWriter(data);
    
    for (Score score : scores) {
      out.write(score.getName() + "," + 
          score.getKor() + "," +
          score.getEng() + "," +
          score.getMath() + "\n");
    }
    
    out.close();
  }

  public void load() {
    try {
      File data = new File("test.csv");
      FileReader in = new FileReader(data);
      StringBuffer buf = new StringBuffer(); // mutable Object
      int ch;
      while ((ch = in.read()) != -1) {
        buf.append((char)ch);
      }
      in.close();
      
      String contents = buf.toString();
      String[] rows = contents.split("\n");
      String[] cols = null;
      Score score = null;
      for (String row : rows) {
        cols = row.split(",");
        
        //Score 인스턴스 생성 -> 값 할당 -> ArrayList에 보관 
        score = new Score();
        
        score.setName(cols[0]);
        score.setKor(Integer.parseInt(cols[1]));
        score.setEng(Integer.parseInt(cols[2]));
        score.setMath(Integer.parseInt(cols[3]));
        
        this.insert(score);
      }
    } catch (FileNotFoundException ex) {
      System.out.println("file not found!");
    } catch (IOException ex) {
      System.out.println("read error!");
    }
    
  }

}










