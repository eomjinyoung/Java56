/*생성자
 * - 인스턴스가 생성된 후 자동으로 호출되는 함수
 * - 용도
 *   인스턴스 변수의 값을 초기화.
 *   인스턴스가 사용되기 전에 최소한의 값을 설정한다.
 * - 문법: 리턴타입 없다. 함수 이름이 클래스 이름과 같다. 
 *   클래스명() { ... }
 */

package exam.oop;

public class Test02 {
	public static void main(String[] args) {
		// 생성자 사용 전 
		Score2 s1 = new Score2();
		s1.name = "홍길동";
		s1.kor = 100;
		s1.eng = 100;
		s1.math = 100;
		s1.total = s1.kor + s1.eng + s1.math;
		s1.average = s1.total / 3.0f;
		
		// 생성자 사용 후 
		//Score2 s2 = new Score2("임꺽정", 100, 98, 88);
  }
}









