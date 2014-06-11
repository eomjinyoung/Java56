/* 클래스 로딩
 * - JVM은 파일 시스템에서 읽은 바이트코드를 Method Area에 올린다.
 * - JVM은 HDD읽은 .class 파일을 Method Area에 올린다.
 * - 실행 순서
 *   1) 파일 시스템에서 클래스를 찾는다. (classpath 환경 변수에 설정된 디렉토리를 뒤진다)
 *   2) 바이트코드(클래스파일)를 검증한다.
 *   3) 바이트코드를 Method Area에 로딩한다.
 *   				- 클래스 변수(static 변수) 및 클래스 블록(static 블록)을 순차적으로 실행한다.
 *   4) 로딩된 바이트코드에서 main() 메서드를 찾아 호출한다.
 */
package exam.oop;

public class Test06 {
	// 클래스 변수
	// - 모든 인스턴스들이 공유하는 데이터 보관
	static int a = 20;
	
	// 스태틱 블록
	// - 생성자처럼 클래스 변수를 초기화 하는 작업
	static {
		System.out.println(a);
		//System.out.println(b);
	}
	
	static int b = 30;
	
	public static void main(String[] args) {
		System.out.println("Hello");

	}
	
	// 스태틱 블록
	static {
		System.out.println(b);
	}

}









