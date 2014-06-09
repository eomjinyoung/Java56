//4. 인스턴스 메서드: 인스턴스가 있어야만 호출할 수 있는 메서드
//- 메서드를 호출할 때 반드시 메서드 이름 앞에 인스턴스 주소를 줘야 한다.
//- 인스턴스 주소는 호출되는 메서드의 숨겨진 변수 this에 저장된다.
//- static을 붙여서는 안된다. (static은 클래스 메서드에 붙인다)
package exam.oop.instance;

public class Calculator04 {
	// 인스턴스 변수 선언 - 데이터를 개별적으로 관리하고 싶다면 클래스 변수 대신 인스턴스 변수를 선언하라.
	int result;
	
	public void init(/*Calculator04 this,*/ int value) {
		this.result = value;
	}
	
	public void plus(/*Calculator04 this,*/ int value) {
		this.result += value;
	}

	public void minus(/*Calculator04 this,*/ int value) {
		this.result -= value;
	}
	
	public void multiple(/*Calculator04 this,*/ int value) {
		this.result *= value;
	}
	
	public void divide(/*Calculator04 this,*/ int value) {
		this.result /= value;
	}
}






