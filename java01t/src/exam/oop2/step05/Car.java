/* 상속 관계에서 생성자 호출?
 * - super() : 
 *   모든 생성자에 첫 번째로 오는 명령문
 *   수퍼클래스의 기본 생성자를 호출하는 명령문
 *   생략가능 => 생략하면 컴파일 시 자동으로 추가됨
 *   명시적으로 작성할 수 있습니다. => 반드시 그 생성자의 첫 번째 명령문이어야 한다.
 *   
 *             
 */

package exam.oop2.step05;

public class Car {
	String 	model; // 모델명
	int 		cc = 1000; // 배기량
	
	public Car() {
		//super();
		System.out.println("Car()");
	}
	
	public Car(String model) {
		this.model = model;
	}
}










