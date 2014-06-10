package exam.oop;

class A {
	static int value = 100;
	
	static {
		System.out.println("A: value=" + value);
		System.out.println("A: B.value=" + B.value);
		value = 111;
	}
}

class B {
	static int value = 100;
	
	static {
		System.out.println("B: value=" + value);
		System.out.println("B: A.value=" + A.value);
		value = 222;
	}
}

public class Test06_ex1 {

	public static void main(String[] args) {
		//문제1. 클래스는 로딩 시점.
		// - 레퍼런스 변수를 선언하면 로딩 되는가? 레퍼런스 변수의 선언은 클래스를 로딩하지 않는다.
		A p = null; // null은 메모리를 0으로 설정하라는 의미.
		
		// - new 명령을 통해 인스턴스를 생성
		//new A();
		
		// - 클래스 변수나 메서드 사용 
		System.out.println(A.value);
		
	}

}












