/* 배열 대신 ArrayList 적용 
 */
package exam.oop3.step04;

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

}










