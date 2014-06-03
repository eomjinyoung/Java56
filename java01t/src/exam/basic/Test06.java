/* 6. 자바의 기본 연산은 int 이다.
 * - byte 끼리의 연산 결과도 int
 * - short 끼리의 연산 결과 int
 * - long 끼리의 연산 결과 long
 * - 서로 다른 타입의 데이터를 연산할 때 다음의 규칙에 따라 데이터 형을 일치시켜서 연산을 수행한다.
 *   (암시적 형변환)
 *   {byte, short, char} > int > long > float > double
 */
package exam.basic;

public class Test06 {

	public static void main(String[] args) {
		byte b1 = 56; // 상수인 경우 변수에 저장할 수 있다면 승인한다. 
		//byte b2 = 128; // 상수 128을 b2 변수에 저장할 수 없다. 오류!
		
		// byte 끼리의 연산 결과는 int 이다.
		byte b2 = 56;
		byte b3 = 10;
		
		// 기본 연산은 int 이기 때문에 byte값을 임시 int 변수에 저장한 다음 계산 수행
		//byte b4 = b2 + b3; // 내부적으로 b2와 b3 값을 저장할 int 메모리가 준비된다. 
		int i1 = b2 + b3;
		
		short s1 = 10;
		short s2 = 20;
		//short s3 = s1 + s2; // 위와 똑 같다.
		int i2 = s1 + s2;
		
		// 항상 같은 타입끼리만 연산 가능 
		int i3 = b1 + s1; // b1 -> int, s1 -> int 
		long l1 = 30;
		long l2 = i1 + l1; // i1 -> long
		
		float f1 = 3.14f;
		float f2 = f1 + l1; // l1 -> float 
		
		double d1 = 3.14;
		double d2 = b1 + s1 + i1 + l1 +  f1 + d1;
		/* 자바 컴파일러는 위의 명령을 다음과 같이 변경한다.
		 * int t1 = b1;
		 * int t2 = s1;
		 * int t3 = t1 + t3;
		 * int t4 = t3 + i1;
		 * long t5 = t4;
		 * long t6 = t5 + l1;
		 * float t7 = t6;
		 * float t8 = t7 + f1;
		 * double t9 = t8;
		 * t9 + d1 = double 값 
		 */
		/* Implicit Type Conversion(암시적 형변환)
		 * 서로 다른 두 타입의 값을 연산하기 위해서 
		 * 둘 중 하나의 값을 다른 쪽에 맞추는 것.
		 * - 암시적 형변환의 규칙
		 *   {byte, short, char} > int > long > float > double
		 */
	}

}











