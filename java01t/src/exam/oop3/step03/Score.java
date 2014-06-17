/* Entity 역할
 * - 성적 정보를 표현하는 역할 => Value Object(VO)
 */
package exam.oop3.step03;

public class Score  {
	String name;
	int kor;
	int eng;
	int math;
	private int total;
	private float average;
	
	public Score() {}
	
	public Score(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.total = kor + eng + math;
		this.average = this.total / 3.0f;
	}
	
	public void compute() {
		this.total = this.kor + this.eng + this.math;
		this.average = this.total / 3.0f;
	}
	
	public int getTotal() {
		return this.total;
	}
	
	public float getAverage() {
		return this.average;
	}
}


















