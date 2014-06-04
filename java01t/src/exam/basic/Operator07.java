package exam.basic;

//////////////////////////////////////////////////////
//주제 : 조건 연산자(Conditional Operator)
//////////////////////////////////////////////////////
//
//만든이 :		엄진영

/* 조건 연산자(Conditional Operator)
 * - 형식
 *		식 ? Operand_1 : Operand_2
 *	식 : true 또는 false 값을 가진다.
 *	식이 참이면, 결과값 Operand_1
 *  식이 거짓이면, 결과값 Operand_2
 *
 */

public class Operator07
{
	public static void main(String[] args) 
	{
		int 정수1 = 10;
		int 정수2 = 20;

		int 최대값 = 정수1 > 정수2 ? 정수1 : 정수2;

		/*
		if (정수1 > 정수2) {
			최대값 = 정수1;
		} else {
			최대값 = 정수2;
		}
		*/
		
		System.out.println("최대값은 : " + 최대값);
	}
}











