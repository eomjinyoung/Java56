// 자바의 메모리 관리
// - 기본 4가지 영역으로 데이터를 관리한다.
// 1) Method Area: 클래스가 놓여진다. 클래스 변수.
// 2) Heap: 인스턴스가 준비된다.
// 3) Stack: 로컬 변수가 준비된다.
// 4) Constant Pool: 상수 값이 놓여진다.

// 상수 풀 영역
// - 상수 객체가 준비되는 영역
// - 메모리 절약을 위해 같은 값의 상수는 중복해서 생성되지 않는다.
// - 상수 문자열: "문자열" 
//        내부적으로 String 인스턴스를 상수 풀에 생성한다.
// - String#intern() : 상수 풀에 스트링 인스턴스 생성
package exam.oop;

public class Test05_ex2 {
	
	public static void main(String[] args) {
	  String s1 = new String("홍길동"); // 힙 영역에 생성
	  String s2 = new String("홍길동"); // 힙 영역에 생성
	  String s3 = "홍길동"; // 상수 풀 영역에 생성
	  String s4 = "홍길동"; // 기존 상수 풀 영역에 생성된 객체를 가리킴.
	  
	  if (s1 == s2) { // 주소가 다르다
	  	System.out.println("s1 == s2");
	  }
	  
	  if (s3 == s4) { // 주소가 같다
	  	System.out.println("s3 == s4");
	  }
	  
	  String s5 = s1.intern();
	  
	  if (s3 == s5) {
	  	System.out.println("s3 == s5");
	  }
  }

}
















