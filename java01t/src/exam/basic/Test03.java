/* 3. 변수의 선언 
 * - 데이터를 저장하기 위한 메모리 준비 
 * - 사용자가 입력한 값, 중간 계산 결과를 저장
 * - 문법
 *   메모리종류 메모리를_가리키는_이름;
 * - 변수란? 메모리를 가리키는 이름
 * - 메모리타입? 어떤 크기의 어떤 종류의 데이터를 저장할 것인지 선언 
 * -      메모리를 효율적으로 관리하기 8개의 기본 타입을 제공.
 * - 정수메모리: byte(1), short(2), int(4), long(8)
 * - 실수메모리: float(4), double(8)
 * - 문자메모리: char(2)
 * - 논리값메모리: boolean(1)
 * - 문법 용어:
 *   데이터타입 변수;
 */
package exam.basic;

public class Test03 {

	public static void main(String[] args) {
		//문제1. 사람의 나이를 저장할 메모리를 준비하시오!
		byte age;
		age = 120;
		
		short age2 = 130;
		
		//문제2. 학생의 수학 점수를 저장할 메모리를 준비하시오!
		short math, kor, eng;
		math = 130;
		kor = 400;
		eng = 500;
		
		//문제3. 빌게이츠의 돈을 저장할 메모리를 준비하시오!
		long money = 50000000000L;
		
		//문제4. 파이 값을 저장할 메모리를 준비하시오!
		// float: 유효자리수 6자리 (single-precision, 단정도)
		// double: 유효자리수 15자리 (double-precision, 배정도)
		
		float pi = 3.14159f;
		
		double pi2 = 3.14159;
		
		//문제5. 한글 음절을 저장할 메모리를 준비하시오!
		//char: 2byte 양의 정수값
		char ch = 44032; // 10진수 - '가'
		char ch2 = 0xAC00; // 16진수 - '가'
		char ch3 = 0126000; // 8진수 - '가'
		char ch4 = '가'; // 가 문자의 코드 값 리턴
		
		System.out.println(ch);
		System.out.println(ch2);
		System.out.println(ch3);
		System.out.println(ch4);
		
		
		//문제6. 결혼 여부를 저장할 메모리를 준비하시오!
		boolean married = true;
	}

}








