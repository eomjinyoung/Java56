package exam.oop2.step08;

/* 1. 다른 패키지의 클래스 사용 테스트.
 * 2. import 명령
 * - 클래스의 경로를 컴파일러에게 알려주는 명령어
 */

/* 클래스의 경로 지정 */
// import는 컴파일러가 참고하는 정보이다. 따라서 컴파일 후 제거된다.
// import 문이 많으면 컴파일한 후 바이트코드(.class)가 커진다는 착각을 하지 말 것!
import exam.oop2.step08.sub.B;

public class Test01 {

	public static void main(String[] args) {
		//=> import 사용 전
		// - 다른 패키지의 클래스를 사용할 때는 반드시 클래스의 경로를 정확하게 지정해야 한다.
		// - 단, java.lang 패키지는 컴파일러가 자동으로 인식한다.
		//			=> 즉, java.lang 패키지의 클래스는 경로를 지정하지 않고 바로 사용할 수 있다.
		//      예) String, System, Object, ...
		//exam.oop2.step08.sub.A p1; // 오류! A의 접근 제한자가 default이다.
		exam.oop2.step08.sub.B p2; // 성공! B의 접근 제한자는 public이다.
		java.lang.String s = "오호라";
		String s2 = "오호~~라";
		
		
		//=> import 사용 후
		// 클래스 선언 위에 import 명령을 사용해서 다음과 같이 클래스 경로를 지정한다.
		// 예1) import exam.oop2.step08.sub.A;
		
		// 클래스 이름을 빼고 패키지 이름만 지정할 수 있다.
		//  ==> 해당 패키지의 있는 모든 클래스를 사용할 수 있다.
		// 예2) import exam.oop2.step08.sub.*;
		
		// 권고=> 가능한 클래스 이름까지 지정하라! 
		//    => 소스 코드를 읽을 때 빠르게 클래스의 경로를 파악할 수 있다. 
		B p3; // import 문을 선언했기 때문에 패키지 명 생략가능!
		
	}

}










