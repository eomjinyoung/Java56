/* 4. Literal (값의 표현)
 * - 정수 값 표현
 *   1) 32비트 정수 값: 32, 120
 *   2) 64비트 정수 값: 32L, 32l, 11L, 11l
 *   
 * - 실수 값 표현
 *   1) 32비트 실수 값: 3.14f, 3.14F
 *   2) 64비트 실수 값: 3.14
 *   
 * - 문자 값 표현
 * 	 1) 문자에 대해 정의된 코드 값: 44032, 0xAC00, 0126000, '가', '\uAC00' 
 * 
 * - 논리 값
 *   true, false
 *   
 *    
 */
package exam.basic;

public class Test04 {

	public static void main(String[] args) {
		int i = 32;
		//int i2 = 32L;
		
		long l = 32;
		long l2 = 32L;
		
		float f = 3.14f;
		//float f2 = 3.14;

		double d = 3.14f;
		double d2 = 3.14;
		
		char c = '가';
		char c2 = 44032;
		char c3 = 0xAC00;
		char c4 = 0126000;
		char c5 = '\uAC00';
		
		System.out.println(c);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c4);
		System.out.println(c5);
		
	}

}











