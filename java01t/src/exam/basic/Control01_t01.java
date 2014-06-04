package exam.basic;

import java.util.Scanner;

public class Control01_t01 {
	public static void main(String[] args) {
		//문제3) 단, 연산자 조건 검사에 switch문 사용하세요.
		// 다음과 같이 동작하도록 코드를 구현하세요.
		// 첫 번째 수를 입력하세요? 10
		// 연산자를 입력하세요? +
		// 두 번째 수를 입력하세요? 2
		// 계산 결과는 5입니다.
		Scanner scanner = new Scanner(System.in);
		int v1, v2;
		String op;
		
		System.out.print("첫 번째 수를 입력하세요?");
		String text = scanner.nextLine();
		v1 = Integer.parseInt(text);
		
		System.out.print("연산자를 입력하세요?");
		op = scanner.nextLine();
		
		System.out.print("두 번째 수를 입력하세요?");
		text = scanner.nextLine();
		v2 = Integer.parseInt(text);
		
		int result;
		switch(op) {
		case "+":
			result = v1 + v2;
			break;
		case "-":
			result = v1 - v2;
			break;
		case "*":
			result = v1 * v2;
			break;
		case "/":
			result = v1 / v2;
			break;
		default:
			System.out.println("지원하지 않는 연산자입니다.");
			return;
		}
		
		System.out.println("계산 결과는 " + result + "입니다");
		
		
	}
	
	public static void main03(String[] args) {
		//문제3) 단, 연산자 조건 검사에 switch문 사용하세요.
		// 다음과 같이 동작하도록 코드를 구현하세요.
		// 첫 번째 수를 입력하세요? 10
		// 연산자를 입력하세요?+(0),-(1),*(2),/(3) 3
		// 두 번째 수를 입력하세요? 2
		// 계산 결과는 5입니다.
		Scanner scanner = new Scanner(System.in);
		int v1, v2, op;
		System.out.print("첫 번째 수를 입력하세요?");
		String text = scanner.nextLine();
		v1 = Integer.parseInt(text);
		
		System.out.print("연산자를 입력하세요?+(0),-(1),*(2),/(3)");
		text = scanner.nextLine();
		op = Integer.parseInt(text);
		
		System.out.print("두 번째 수를 입력하세요?");
		text = scanner.nextLine();
		v2 = Integer.parseInt(text);
		
		int result;
		switch(op) {
		case 0:
			result = v1 + v2;
			break;
		case 1:
			result = v1 - v2;
			break;
		case 2:
			result = v1 * v2;
			break;
		case 3:
			result = v1 / v2;
			break;
		default:
			System.out.println("지원하지 않는 연산자입니다.");
			return;
		}
		
		System.out.println("계산 결과는 " + result + "입니다");
		
		
	}
	
	public static void main02(String[] args) {
		//문제2)
		// 다음과 같이 동작하도록 코드를 구현하세요.
		// 첫 번째 수를 입력하세요? 10
		// 연산자를 입력하세요?+(0),-(1),*(2),/(3) 3
		// 두 번째 수를 입력하세요? 2
		// 계산 결과는 5입니다.
		Scanner scanner = new Scanner(System.in);
		int v1, v2, op;
		System.out.print("첫 번째 수를 입력하세요?");
		String text = scanner.nextLine();
		v1 = Integer.parseInt(text);
		
		System.out.print("연산자를 입력하세요?+(0),-(1),*(2),/(3)");
		text = scanner.nextLine();
		op = Integer.parseInt(text);
		
		System.out.print("두 번째 수를 입력하세요?");
		text = scanner.nextLine();
		v2 = Integer.parseInt(text);
		
		int result;
		if (op == 0) {
			result = v1 + v2;
		} else if (op == 1) {
			result = v1 - v2;
		} else if (op == 2) {
			result = v1 * v2;
		} else if (op == 3) {
			result = v1 / v2;
		} else {
			System.out.println("지원하지 않는 연산자입니다.");
			return;
		}
		
		System.out.println("계산 결과는 " + result + "입니다");
		
		
	}
	
	public static void main01(String[] args) {
		System.out.print("당신의 나이는?");
		Scanner scanner = new Scanner(System.in);
		String text = scanner.nextLine();
		int age = Integer.parseInt(text);
		
		System.out.println("당신의 나이는: " + age + "입니다.");
		
		//문제1)
		// 7세 이하는 "유아입니다" 출력
		// 8세 이상 ~ 18세 미만 "청소년입니다" 출력
		// 18세 이상 ~ 30세 미만 "청년입니다" 출력
		// 30세 이상 ~ 50세 미만 "장년입니다" 출력
		// 50세 이상 ~ 60세 미만 "중년입니다" 출력
		// 그 밖에 "노인입니다" 출력 
		if (age <= 7) {
			System.out.println("유아입니다.");
		} else if (age >= 8 && age < 18) {
			System.out.println("청소년입니다.");
		} else if (age >= 18 && age < 30) {
			System.out.println("청년입니다.");
		} else if (age >= 30 && age < 50) {
			System.out.println("장년입니다.");
		} else if (age >= 50 && age < 60) {
			System.out.println("중년입니다.");
		} else {
			System.out.println("노인입니다.");
		}
		
		
		
		
	}

}














