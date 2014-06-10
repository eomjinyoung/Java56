// 자바의 메모리 관리
// - 기본 4가지 영역으로 데이터를 관리한다.
// 1) Method Area: 클래스가 놓여진다. 클래스 변수.
// 2) Heap: 인스턴스가 준비된다.
// 3) Stack: 로컬 변수가 준비된다.
// 4) Constant Pool: 상수 값이 놓여진다.

// 스택 영역
// - 메서드 호출 시 로컬 변수가 준비된다.
// - 메서드 호출이 끝나면 로컬 변수는 제거된다.
package exam.oop;

public class Test05 {
	public static void main(String[] args) {
	  int v = 100;
	  m1(v);
	  m2(v);
  }
	
	public static int m1(int v) {
		int result = v * 2;
		return result;
	}
	
	public static void m2(int v) {
		m3(v * 2); 
	}
	
	public static void m3(int v) {
		m4(v);
	}
	
	public static void m4(int v) {
		v = 20;
	}
}
















