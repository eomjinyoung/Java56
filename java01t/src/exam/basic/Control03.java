package exam.basic;

//////////////////////////////////////////////////////
//주제 : 흐름 제어문 : 반복문 - do... while, while
//////////////////////////////////////////////////////
//
//만든이 :		엄진영

/* 1) do ... while
 *		do {
 *			문장1
 *		}while(조건식);
 * 
 * : 일단 '문장1'을 수행후 '조건식'의 값이 true이면 계속 do { } 문을 반복하여 수행한다.
 *
 * 2) while
 *		while(조건식) {
 *			문장1
 *		}
 * : '조건식'의 값이 참일때만 while문의 { } 문을 수행한다.
 *
 * 즉, do... while 문은 1 이상을 반복하고, while 문은 0 이상을 반복한다.
 */

public class Control03
{
	public static void main(String[] args) 
	{
		/* 테스트 1 : do... while
		int a = 0;
		do{
			System.out.println("a = " + a);
			a++;
		}while (a < 10);
		 */

		/* 테스트 2 : while
		int a = 0;
		while(a < 10) {
			System.out.println("a = " + a);
			a++;
		}
		 */

		// 테스트 1, 2 에서 a 값을 10을 주고 테스트 해보라!
		// do... while 문은 10 값을 출력하고, while문은 아무런 수행을 하지 않는다.
	}
}

