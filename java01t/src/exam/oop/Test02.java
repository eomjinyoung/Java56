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
		/*
		Score2 s1 = new Score2(); // Score2에는 기본 생성자가 없다! 오류!
		s1.name = "홍길동";
		s1.kor = 100;
		s1.eng = 100;
		s1.math = 100;
		s1.total = s1.kor + s1.eng + s1.math;
		s1.average = s1.total / 3.0f;
		*/
		
		// 생성자 사용 후 
		// 생성자는 인스턴스를 생성할 때 바로 호출해야 한다. 나중에 따로 호출할 수 없다.
		// 생성자를 호출할 때 생성자에 선언된 파라미터 값을 반드시 넘겨야 한다.
		// 생성자를 호출하든 메서드를 호출하든 값을 넘길 때 반드시 파라미터 순서를 지켜야 한다.
		Score2 s2 = new Score2("임꺽정", 80, 80, 80);
		//s2.Score2("임꺽정", 20, 20, 20); // 나중에 생성자 호출할 수 없다. 문법 오류!
		System.out.println(s2.total);
		System.out.println(s2.average);
  }
}









