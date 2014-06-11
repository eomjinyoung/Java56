/* Entity 역할
 * - 성적 정보를 표현하는 역할 => Value Object(VO)
 */
package exam.oop.score;

public class Score  {
	// Score가 준비하는 메모리를 선언
	String name;
	int kor;
	int eng;
	int math;
	int total;
	float average;
	
	public Score() {}
	
	// 이미 생성자가 있기 때문에 기본 생성자가 자동으로 추가되지 않는다.
	/*
	public Score(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.total = kor + eng + math;
		this.average = this.total / 3.0f;
	}
	*/
}
