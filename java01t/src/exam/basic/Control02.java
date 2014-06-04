package exam.basic;

//////////////////////////////////////////////////////
//주제 : 흐름 제어문 : 조건문 - switch
//////////////////////////////////////////////////////
//
//만든이 :		엄진영

/* << 조건문 : switch >>
 * switch(식) {
 *		case 상수식1: 문장1
 *			break;
 *		case 상수식2: 문장2
 *			break;
 *		case 상수식3: 문장3
 *			break;
 *		default: 문장0
 * }
 *
 * : '식'의 결과값이 '상수식1' 이면 '문장1'을 수행하고 'break'문은 switch문을 빠져나간다.
 *   '식'의 결과값이 '상수식2' 이면 '문장2'을 수행하고 'break'문은 switch문을 빠져나간다.
 *	 '식'의 결과값이 '상수식3' 이면 '문장3'을 수행하고 'break'문은 switch문을 빠져나간다.
 *	 만약, '식'의 결과값에 해당하는 경우가 없다면 'default:' 의 '문장0' 를 실행한다.
 *
 * - '식' 과 '상수식' 에는 int 형 값만 올 수 있다.
 * - JDK7에서는 String 값이 올 수 있다.
 */

public class Control02
{
	public static void main(String[] args) 
	{
		/* 테스트 1 : 기본 테스트
		// a 값을 10 또는 20, 그외의 숫자를 주어 테스트 해보라!
		int a = 400;
		
		switch(a * 5) {
		case 50:
			System.out.println("a * 5는 50입니다.");
			System.out.println("따라서, a는 10입니다.");
			break;
		case (20 * 100):
			System.out.println("a * 5는 2000입니다.");
			System.out.println("따라서, a는 400입니다.");
			break;
		default:
			System.out.println("a는 5의 배수이겠지요");
			a = 0;
		}
		 */

		/* 테스트 2 : 만약 '식'이 int형이 아닌 다른 data type일 경우
		// - byte, short, char 인 경우 연산시에 int형으로 취급되기 때문에 문제가 없다.
		// - long, float, double, boolean 등 int형이 아닌 type은 올 수 없다.
		long a = 10L;
		switch(a) {
		case 10L:
			System.out.println("컴파일 될까요?");
		}
		// Error : '식'에는 int 값 외에 올 수 없다.
		// 위의 예제를 long type 외에 float, double, boolean을 대입시켜보라!
		 */

		/* 테스트 3 : char 인 경우,
		// 문제없다! 어차피 char 형도 정수값을 의미하고, 'A'의 의미도 [대문자 A 에 대응하는
		// 유니코드 숫자] 를 의미하기 때문이다. 결국은 int 형 값인 것이다.
		char c = 'A';
		switch(c) {
		case 'A':
			System.out.println("A 입니다.");
			break;
		case 'B' + 'C':
			System.out.println("B 입니다.");
			break;
		}
		// 'B' + 'C', 허~~~ 문자도 더할수가 있나요? 
		// - 이것의 의미는 'B'에 대응하는 유니코드 값(0x0042) 와 'C'에 대응하는 
		//	 유니코드 값(0x0043)을 더하는 것이기 때문이다. 즉, 0x0042 +  0x0043 = 0x0085
		 */

		/* 테스트 4 : break 문이 없는 경우
		// a 값이 3일경우, 2, 1, 그외의 수 일경우를 테스트 해보라!
		int a = 3;
		switch(a) {
		case 3:
			System.out.println("[SCJP 자격증]이 있습니다.");
		case 2:
			System.out.println("[정보처리 자격증]이 있습니다.");
		case 1:
			System.out.println("[전자상거래 자격증]이 있습니다.");
		default:
			System.out.println("[운전면허증]이 있습니다.");
		}
		// case 문은 break 문을 만날 때 까지 수행하기 때문에 사용시 유의해야 한다.
		// 오히려 위의 예처럼 '값에 따라 결과를 누적할 경우' break 문을 빼는 경우가 있다.
		 */
	}
}

