//1. 클래스 용도 : 메서드들의 묶음.
// - 클래스에 묶이는 메서드는 static으로 선언한다.
// - 메서드 호출 시 클래스 이름으로 호출한다.
package exam.oop.instance;

public class Calculator01 {

	public static int plus(int a, int b) {
		return a + b;
	}

	public static int minus(int a, int b) {
		return a - b;
	}
	
	public static int multiple(int a, int b) {
		return a * b;
	}
	
	
	public static int divide(int a, int b) {
		return a / b;
	}
}
