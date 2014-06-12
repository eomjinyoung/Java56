/* 상속
 * - 다른 클래스의 기능을 사용하는 것.
 * - 상속해 주는 클래스: parent, super 클래스
 * - 상속을 받는 클래스: child, sub 클래스 
 * - 특별한 제약없이 super 클래스의 기능을 쉽게 사용할 수 있다.
 * - 이점: 
 * 		기존 코드를 손대지 않고 기능을 확장할 수 있다.
 *    기존 코드를 쉽게 재활용 할 수 있다.
 * - 단점:
 * 		상속 받을 기능을 취사선택할 수 없다. 
 *    무조건 100% 상속 => 상속 단계가 깊어질 수록 코드가 무거워진다.
 * - 좀 더 유지보수에 유연한 시스템을 개발하려면 상속 대신 다른 방법을 사용하라.
 *   의존 방식, 프록시 방식 등 특별한 설계 방법으로 해결한다.    
 *        
 */
package exam.oop2.step02;

public class CalculatorPro extends Calculator {
	// 새로 추가할 기능: 곱하기
	public void multiple(int value) {
		result *= value;
	}
}













