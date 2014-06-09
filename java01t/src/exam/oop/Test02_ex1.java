/* 연습: 인스턴스 생성
 * - 클래스의 인스턴스를 생성하고 인스턴스에 값 할당 방법
 * - Garbage : 인스턴스의 주소를 잃어 버려 더 이상 사용할 수 없는 메모리
 * - Garbage Collector : 가비지 수집기
 *    1) idle time, 2) 메모리 부족
 */

package exam.oop;

public class Test02_ex1 {
	public static void main(String[] args) {
	  // 레퍼런스 변수 없다.
		new Address(); // 인스턴스 생성
	  
		// 레퍼런스 변수에 인스턴스의 주소 저장
	  Address addr1 = new Address(); // 인스턴스 생성 -> 그 주소를 변수에 보관
	  Address addr2 = new Address();
	  
	  // 레퍼런스 변수를 통해 인스턴스에 값 할당
	  addr1.name = "홍길동";
	  addr1.email = "hong@test.com";
	  
	  addr2.name = "임꺽정";
	  addr2.email = "leem@test.com";
	  
	  // 레퍼런스 변수를 통해 인스턴스의 변수 값을 추출
	  // 레퍼런스.인스턴스변수명
	  System.out.println(addr1.name);
	  System.out.println(addr1.email);
	  
	  System.out.println(addr2.name);
	  System.out.println(addr2.email);
	  
	  // 레퍼런스 변수에 다른 주소 할당 
	  Address addr3 = addr2;
	  System.out.println(addr3.name);
	  
	  addr1 = addr2;
	  System.out.println(addr1.name);
	  
	  // 용서 받지 못 할 코드
	  // null? 주소 없음을 의미하는 값
	  Address addr4 = null;
	  //System.out.println(addr4.name);
	  
	  // 용서 받지 못 할 코드 (by 컴파일러)
	  //Address addr5 = new Board();
  }
}









