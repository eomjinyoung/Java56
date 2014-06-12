/* 상속과 오버라이딩
 * - 오버라이딩: 
 *   상속 받는 메서드를 해당 클래스의 역할에 맞추어 재정의 하는 것
 *   super 클래스의 메서드 시그너처(signature)와 같게 선언해야 한다.
 * - 메서드 시그너처 => C에서는 function prototype
 *   이름, 리턴타입, 파라미터 타입 
 *   
 * - super 변수
 *    오버라이딩 전의 변수나 메서드를 가리키는 레퍼런스
 */
package exam.oop2.step06;

public class CalculatorEnt extends CalculatorPro {
	public void divide(int value) {
		result /= value;
	}
	
	// 기존의 plus(String)는 오로지 숫자로 구성된 문자열일 때만 가능했다.
	// 그러나, 기업용은 돈을 주로 다루기 때문에 숫자 앞에 $, 원 표시가 있을 수 있다.
	// 그래서 더하기 전에 해당 화폐 표시 문자를 제거하도록 개선해야 한다.
	// 기존 기능 재정의 : 오버라이딩(overriding)
	public void plus(String value) {
	  // super.오버라이딩하기 전에 메서드명()
	  super.plus(removeMonetaryUnitChar(value.trim()));
	}
	
	private String removeMonetaryUnitChar(String value) {
		char firstChar = value.charAt(0);
	  if (firstChar < '0' || firstChar > '9') {
	  	return value.substring(1);
	  }
	  return value;
	}
}













