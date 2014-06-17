/* Entity 역할
 * - 데이터의 저장과 조회, 변경, 삭제 관리
 * - 데이터의 지속성(Persistence) 관리
 * - Data Access Object(DAO)
 */
package exam.oop3.step03;

public class ScoreDao {
	Score[] scores = new Score[100];
	int size;
	
	public ScoreDao() {
		//size = 0;
	}
	
	public void insert(Score score) {
		if (size < scores.length) {
			scores[size++] = score;
		}
	}
	
	public Score[] toArray() {
		return this.scores;
	}
	
}










