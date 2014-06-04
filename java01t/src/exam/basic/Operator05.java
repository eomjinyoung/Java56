package exam.basic;

//////////////////////////////////////////////////////
//주제 : 논리 연산자(Logical Operator)
//////////////////////////////////////////////////////
//
//만든이 :		엄진영

/* 논리 연산자(Logical Operator)
 * - AND : Operand 둘다 true 일때만 연산 결과가 true 가 됨.
 *		a && b (만약 a가 false 이면 b는 따져보지도 않고 결과값 false를 내 놓는다)
 *		a & b (a 가 false 일지라도, b 까지 따져보고 결과를 내 놓는다)
 * - OR : 두개의 Operand중 하나라도 true이면 결과는 true가 된다)
 *      a || b (a 가 true이면 b는 따져 보지도 않고 결과값 true를 내 놓는다)
 *		a | b (a 가 true일지라도 b 까지 따져보고 결과를 내 놓는다)
 * - NOT : Operand가 true이면 false, false이면 true가 된다.
 *		 !a (a 의 값이  true -> false 바뀌고, false -> true)
 */
public class Operator05
{
	public static void main(String[] args) 
	{
		/* 테스트 1 : 기본 테스트
		boolean b = true;
		boolean b2 = false;
		
		System.out.println("b && b2 = " + (b && b2));
		System.out.println("b || b2 = " + (b || b2));
		System.out.println("b & b2 = " + (b & b2));
		System.out.println("b | b2 = " + (b | b2));
		System.out.println("!b = " + !b);
		 */

		/* 테스트 2 : &&, || 와 & , |의 차이점을 알아보자!
		boolean r = false;
		boolean b2 = false;
		boolean s = b2 & (r = true);  
		// &&, || 는 앞의 결과로 최종 결과를 확정할 수 있다면, 뒤의 명령문은 수행하지 않는다.
		// &, | 앞의 결과에 상관없이 묵묵히 뒤의 명령어를 수행한다.
		
		System.out.println("s = " + s);
		System.out.println("r = " + r);
		 */
		/* 해설
		 * - '&' 연산자는 피연산자 b2 와 (r = true) 를 모두 수행한다.
		 */

		/* 테스트 3
		boolean r = false;
		boolean b2 = false;
		boolean s = b2 && (r = true);
		
		System.out.println("s = " + s);
		System.out.println("r = " + r);
		 */
		/* 해설
		 * - '&&' 연산자는 피연산자 b2가 false이면 이미 결과가 false이므로
		 *   다른 피연산자인 (r = true)를 수행하지 않는다.
		 */


		/* 테스트 4
		boolean r = false;
		boolean b = true;
		boolean s = b | (r = true);
		
		System.out.println("s = " + s);
		System.out.println("r = " + r);
		 */
		/* 해설
		 * - '|' 연산자는 피연산자 b 와 (r = true) 모두 수행한다.
		 */

		/* 테스트 5
		boolean r = false;
		boolean b = true;
		boolean s = b || (r = true);
		
		System.out.println("s = " + s);
		System.out.println("r = " + r);
		 */
		/* 해설
		 * - '||' 연산자는 피연산자 b가 true이면 이미 결과가 true이므로
		 *   다른 피연산자 (r = true)를 수행하지 않는다.
		 */

		/* 테스트 6 : 논리연산자의 피연산자는 boolean type만 될수 있다.
		int i = 10, i2 = 20;
		boolean r = i && i2;
		 */

		/* 테스트 7 : &와 | 는 비트 연산자로서도 사용되는 이중성을 가진다.
		int i = 10, i2 = 20;
		boolean r = i & i2;

		// '&' 는 비트 연산자로서 사용됨으로써 결과는 정수가 되고, 
		//  따라서, int 값을 boolean 변수에 할당 할수 없다. type이 맞지않는다.
		 */
	}
}









