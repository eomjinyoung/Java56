/* 상속과 오버로딩(overloading)
 * - 기능 중복
 *        
 */
package exam.oop2.step06;

public class CalculatorPro extends Calculator {
	// 새로 추가할 기능: 곱하기
	public void multiple(int value) {
		result *= value;
	}
	
	// 상속 받는 메서드의 이름과 같은 이름의 메서드를 중복(파라미터는 다름)해서 만들기: 오버로딩
	// 문자열로 이루어진 숫자를 더하는 것
	public void plus(String value) {
		/* 개선 전 
		int temp = Integer.parseInt(value);
		result += temp;
		*/
		
		// 코드 개선(refactoring) : replace temp with query
		result += Integer.parseInt(value);
	}
}













