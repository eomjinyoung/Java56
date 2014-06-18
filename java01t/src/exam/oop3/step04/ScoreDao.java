/* 배열 대신 ArrayList 적용 
 */
package exam.oop3.step04;

import java.util.ArrayList;

public class ScoreDao {
	ArrayList<Score> scores = new ArrayList<Score>();
	int size;
	int cursor;
	
	public ScoreDao() {
		//size = 0;
	}
	
	public void insert(Score score) {
		if (size < scores.length) {
			scores[size++] = score;
			cursor = size;
		}
	}
	
	public Score nextScore() {
		if (cursor >= size || cursor >= scores.length - 1) 
			return null;
		
		return scores[++cursor];
	}
	
	public Score previousScore() {
		if (cursor <= 0) 
			return null;
		
		return scores[--cursor];
	}
	
	public Score[] toArray() {
		return this.scores;
	}
	
}










