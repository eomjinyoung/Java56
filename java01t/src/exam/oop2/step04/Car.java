/* 상속 받아서 만든 인스턴스 변수의 초기화 절차 
 * - 초기화 문장(initializer):
 * 		class A {
 * 			int v = 20; // 초기화 문장
 * 	  }
 * - 생성자(constructor):
 * 		class A {
 * 			int a;
 * 			public A() { // 생성자에서 초기화 
 * 				a = 20;
 * 			}
 * 		}
 * - 인스턴스 변수는 생성 직후, 기본으로 0으로 초기화 된다.
 * 		정수: 0, 실수: 0.0, 불린: false, 문자: '\u0000'
 *		결국 모든 비트가 0으로 설정된다.
 */

package exam.oop2.step04;

public class Car {
	String 	model; // 모델명
	int 		cc = 1000; // 배기량
}










