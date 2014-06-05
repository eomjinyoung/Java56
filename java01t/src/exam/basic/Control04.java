package exam.basic;

//////////////////////////////////////////////////////
//주제 : 흐름 제어문 : 반복문 - for
//////////////////////////////////////////////////////
//
//만든이 :		엄진영

/* for
 * - 보통 어떤 인덱스 값을 사용하여 반복처리를 할 때 유용.
 *
 *		for(초기화 문장; 조건식; 증가문)
 *			문장1
 *	
 * : 초기화 문장 - 보통 인덱스 값을 초기화 시키는 문장이 온다.
 * : 조건식 - true 이면 for문의 { } 문장을 수행하고, false 이면 for 문을 빠져나간다.
 * : 증가문 - 보통 인덱스 값을 증가시키는 문장이 온다.
 */

public class Control04
{
	public static void main(String[] args) 
	{
		/* 테스트 1 : 기본 사용
		for(int index = 0; index < 10; index++) 
			System.out.println("index = " + index);
		
		// 만약 for문 밖에서 index 값을 사용하려 한다면?
		// 아래 문장을 주석을 풀고 컴파일 해보라!
		// System.out.println("마지막 index 값 = " + index);
		// 오~~ My God! for문에서 선언된 변수는 for문 밖에서는 사용할 수 없다.
		 */

		/* 테스트 2 : 초기화 문장을 빼도 상관없다!
		int index = 0;
		for( ; index < 10; index++)
			System.out.println("index = " + index);
		System.out.println("마지막 index 값 = " + index);
		 */

		/* 테스트 3 : 증가문을 빼도 상관없다!
		int index = 0;
		for( ; index < 10; ){
			System.out.println("index = " + index);
			index++;
		}
		System.out.println("마지막 index 값 = " + index);
		 */

		/* 테스트 4 : 조건식 마저 뺀다면... 그리고, 'break' 문의 사용
		int index = 0;
		for( ; ; ){
			if(index >= 10)
				break;	// for문의 실행을 멈추고 빠져나간다.
		
			System.out.println("index = " + index);
			index++;
		}
		System.out.println("마지막 index 값 = " + index);
		 */

		/* 테스트 5 : 중첩된 반복문
		// label의 사용 과 break문
		AAA:
		{
			for(int i = 1; i < 10; i++) {
				System.out.println("구구단 " + i + " 단");
				for(int j = 1; j < 10; j++){
					if(i > 5)
						break AAA;
					System.out.println(i + " * " + j + " = " + i * j);
				}
			}
			System.out.println("반복문 끝");
		}
		
		System.out.println("끝");		
		 */

		/* 테스트 6 : continue 문
		// 0 에서 9까지 출력하되 단, i 값이 5이면 더이상 그 이하는 수행하지 않고
		// 막바로 for문의 증가문에서 수행을 계속한다.
		for(int i = 0; i < 9; i++) {
			if(i == 5)
				continue;
			System.out.println("i = " + i);
		}
		 */

		/* 테스트 7 : continue 레이블;
		// continue 문에 '레이블'명을 명시하게 되면, 지정된 레이블로 가서 
		// 실행을 계속한다.
		AAA:
		for(int i = 1; i < 10; i++) {
			for(int j = 1; j < 10; j++) {
				if(j == 5)
					continue AAA;
				System.out.println(i + " * " + j + " = " + i * j);;
			}
			System.out.println("*************************************");
		}
		 */
		
	}
}

