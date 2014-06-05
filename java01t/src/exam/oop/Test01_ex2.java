/* 함수 => 객체지향에서는 "메서드"라 부른다.
 * - 명령어들을 기능 단위로 묶은 것.
 * - 명령어들을 관리하기 쉽다.
 * - 쉽게 재사용할 수 있다.
 * 
 * - 문법
 *   리턴하는데이터의타입 함수명 (값을받을변수선언, ...) {명령들}
 *   
 * - 함수에서 값을 받기 위해 선언하는 변수 => parameter
 *   int plus(int a, int b) { return a + b }
 *   파라미터: a, b
 *   
 * - 함수를 호출할 때 넘겨주는 값 => argument
 *   int result = plus(10, 20);
 *   아규먼트(인자): 10, 20  
 *   
 * - 예1. void, 파라미터 없음.
 *   void print() {...}
 *
 * - 예2. void, 파라미터 있음.
 *   void print(String msg) {...}
 * 
 * - 예3. 리턴 있음. 파라미터 없음
 *   String getName() {return "okoko";}
 * 
 * - 예4. 리턴 있음. 파라미터 있음
 *   int plus(int a, int b) { return a + b; }
 *   
 */
package exam.oop;

import java.util.Scanner;


public class Test01_ex2 {

	public static void main(String[] args) {
		Address[] addrs = new Address[100];
		Scanner scanner = new Scanner(System.in);
		
		Address addr;
		int count = 0;
		
		for (int i = 0; i < addrs.length; i++) {
			addrs[i] = inputAddress(scanner);
			count++;
			if (!isContinue(scanner))
				break;
		}
		
		for (int i = 0; i < count; i++) {
			printAddress(addrs[i]);
		}

	}
	
	static boolean isContinue(Scanner scanner) {
		System.out.print("계속 입력하시겠습니까?(y/n)");
		String text = scanner.nextLine();
		if (text.equals("n"))
			return false;
		else 
			return true;
	}
	
	static Address inputAddress(Scanner scanner) {
		Address addr = new Address();
		System.out.print("이름?");
		addr.name = scanner.nextLine();
		
		System.out.print("직위?");
		addr.position = scanner.nextLine();
		
		System.out.print("전화번호?");
		addr.tel = scanner.nextLine();
		
		System.out.print("이메일?");
		addr.email = scanner.nextLine();
		
		System.out.print("회사?");
		addr.company = scanner.nextLine();
		
		return addr;
	}
	
	static void printAddress(Address addr) {
		System.out.println(addr.name + "," + addr.tel + "," +
				addr.email + "," + addr.position + "," + 
				addr.company);
	}

}







