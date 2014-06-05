// 문제)
// 이름, 직위, 전화번호, 이메일, 회사 정보를 입력 받고 출력하는 프로그래밍르 짜시오!
// 단, 새 데이터 타입을 정의해서 값을 입력 받으시오!
package exam.oop;

import java.util.Scanner;

//1. 새 데이터 타입 정의 : Address
class Address {
	String name;
	String position;
	String tel;
	String email;
	String company;
}

public class Test01_ex1 {

	public static void main(String[] args) {
		//2. Address 레퍼런스 배열 준비
		Address[] addrs = new Address[100];
		
		//3. 키보드 입력 도구 준비
		Scanner scanner = new Scanner(System.in);
		
		//4. 주소 정보 입력 받기
		Address addr;
		int count = 0;
		for (int i = 0; i < addrs.length; i++) {
			addr = new Address();
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
			
			addrs[i] = addr;
			
			count++;
			
			System.out.print("계속 입력하시겠습니까?(y/n)");
			String text = scanner.nextLine();
			if (text.equals("n"))
				break;
		}
		
		//5. 주소 정보 출력 하기
		for (int i = 0; i < count; i++) {
			addr = addrs[i];
			System.out.println(addr.name + "," + addr.tel + "," +
					addr.email + "," + addr.position + "," + 
					addr.company);
			
		}

	}

}







