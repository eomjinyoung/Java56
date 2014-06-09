/* 문제: 메서드 호출할 때 마다 인스턴스의 주소 넘기기가 귀찮다.
 * - 인스턴스 메서드 등장!
 *   인스턴스주소.메서드명(....);
 * - 인스턴스 메서드 문법: static을 붙이지 않는다.
 *   리턴타입 메서드명(파라미터들...) {
 *   }
 * - 인스턴스 주소는 메서드 호출 시, 메서드 이름 앞에 준다.
 * - 그 인스턴스 주소는 해당 메서드의 숨겨진 변수(this)에 저장된다.
 */
package exam.oop.instance;

public class CalcTest04 {

	public static void main(String[] args) {
		// 5 + 3 * 7 (전제조건: 연산자 우선 순위 무시)
		// 6 - 2 + 3 
		Calculator04 calc1 = new Calculator04();
		Calculator04 calc2 = new Calculator04();
		
		calc1.init(5);
		calc2.init(6);
		
		calc1.plus(3);
		calc2.minus(2);
		
		calc1.multiple(7);
		calc2.plus(3);
		
		System.out.println(calc1.result);
		System.out.println(calc2.result);
	}

}
