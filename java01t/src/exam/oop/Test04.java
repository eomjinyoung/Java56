/* 변수, 메서드 용어 정리
 * 
 */
package exam.oop;

// 클래스
public class Test04 {
	// 클래스 변수: 클래스가 로딩될 때 자동으로 준비되는 변수
	// 사용법: Test04.age = 20;
	static int age;
	
	// 인스턴스 변수: new 명령을 통해 준비되는 변수
	// Test04 p = new Test04();
	// p.name = 20;
	String name;
	
	// 클래스 메서드: 클래스 이름으로 바로 호출할 수 있는 메서드
	// Test04.minus(10, 20);
	public static int minus(int a, int b) {
		// 함수의 인자 값을 저장하는 로컬 변수 => 파라미터 => a, b
		
		// 함수 내부에 선언된 변수 => 로컬 변수 (파라미터도 포함) => result, a, b
		int result = a - b;
		
		return result;
	}
	
	// 인스턴스 메서드 : 인스턴스 주소로 호출하는 메서드
	// Test04 p = new Test04();
	// p.plus(10, 20);
	public int plus(int a, int b) {
		return a + b;
	}
	
	// 기본 생성자: 인스턴스가 생성된 후 즉시 자동 호출되는 메서드
	// Test04 p = new Test04();
	public Test04() {
		
	}
}




