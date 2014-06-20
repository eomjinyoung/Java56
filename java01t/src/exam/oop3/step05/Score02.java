/* Entity 역할
 * - 성적 정보를 표현하는 역할 => Value Object(VO)
 */
package exam.oop3.step05;

import java.io.Serializable;

/* Serialize 허용
 * 1) java.io.Serializable 인터페이스를 구현한다.
 * 2) 시리얼 데이터의 버전을 설정한다.(선택사항)
 *    => private static final long serialVersionUID
 *    => 시리얼 데이터를 읽는 쪽에서 이 버전을 체크할 것이다.
 */

public class Score02 implements Serializable  {
  private static final long serialVersionUID = 1L;

  private String name;
	private int kor;
	private int eng;
	private int math;
	private int total;
	private float average;
	
	public Score02() {}
	
	public Score02(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.total = kor + eng + math;
		this.average = this.total / 3.0f;
	}
	
	private void compute() {
		this.total = this.kor + this.eng + this.math;
		this.average = this.total / 3.0f;
	}
	
	public int getTotal() {
		return this.total;
	}
	
	public float getAverage() {
		return this.average;
	}
	
	public void setKor(int kor) {
		this.kor = kor;
		this.compute();
	}
	
	public void setEng(int eng) {
		this.eng = eng;
		this.compute();
	}
	
	public void setMath(int math) {
		this.math = math;
		this.compute();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public int getEng() {
		return eng;
	}

	public int getMath() {
		return math;
	}
	
	
}


















