//2. 클래스 변수: 함수들의 중간 작업 결과를 보관하는 변수
//- 문법: static 데이터타입 변수명;
package exam.oop.instance;

public class Calculator02 {
	// 클래스 변수 선언 - 클래스를 사용하기 전에 자동으로 해당 변수가 준비된다.
	//              new 명령어를 사용하지 않아도 자동으로 생성된다.
	static int result;
	
	public static void init(int value) {
		Calculator02.result = value;
	}
	
	public static void plus(int value) {
		//Calculator02.result = Calculator02.result + value;
		Calculator02.result += value;
	}

	public static void minus(int value) {
		Calculator02.result -= value;
	}
	
	public static void multiple(int value) {
		Calculator02.result *= value;
	}
	
	public static void divide(int value) {
		Calculator02.result /= value;
	}
}






