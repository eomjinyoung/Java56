/* 문제: 동시에 여러 개의 계산을 수행하다면?
 * - 클래스 변수는 오로지 하나만 존재한다. => 여러 개의 계산 불가! 
 */
package exam.oop.instance;

public class CalcTest03 {

	public static void main(String[] args) {
		// 5 + 3 * 7 (전제조건: 연산자 우선 순위 무시)
		// 6 - 2 + 3 
		Calculator03 calc1 = new Calculator03();
		Calculator03 calc2 = new Calculator03();
		
		Calculator03.init(calc1, 5);
		Calculator03.init(calc2, 6);
		
		Calculator03.plus(calc1, 3);
		Calculator03.minus(calc2, 2);
		
		Calculator03.multiple(calc1, 7);
		Calculator03.plus(calc2, 3);
		
		System.out.println(calc1.result);
		System.out.println(calc2.result);
	}

}
