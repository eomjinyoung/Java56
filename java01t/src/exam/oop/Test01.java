// 클래스
// 1) 새로운 데이터 타입 정의
// 2) 함수를 묶는 용도
package exam.oop;

import java.util.Scanner;

// 학생의 성적 데이터를 표현하는 데이터 타입 정의 
// 새로운 데이터 타입의 이름은 Score
// => 개발자가 임의적으로 정의하는 데이터 타입 => 사용자 정의 데이터 타입
class Score {
	// Score가 준비하는 메모리를 선언
	String name;
	int kor;
	int eng;
	int math;
	int total;
	float average;
}


public class Test01 {
	public static void main01(String[] args) {
		int i; // 정수 값을 담을 4byte 메모리를 준비
		
		// * 사용자 정의 데이터 타입의 메모리를 준비하려면 배열처럼 new 연산자를 사용해야 한다.
		// 문법: new 사용자정의데이터타입();
		// * 이렇게 준비된 메모리를 사용하려면 메모리의 주소를 변수에 저장해야 한다.
		// 문법: 사용자장의데이터타입 변수;
		Score s = new Score();
		s.name = "홍길동";
		s.kor = 100;
		s.eng = 90;
		s.math = 100;
		s.total = s.kor + s.eng + s.math;
		s.average = s.total / 3.0f;
		
	}
	
	public static void main02(String[] args) {
		// 레퍼런스 배열 사용 전
		Score s1 = new Score();
		Score s2 = new Score();
		Score s3 = new Score();
		
		// 레퍼런스 배열 선언
		Score[] list = new Score[3]; // 레퍼런스 배열 준비
		list[0] = new Score(); // 인스턴스 생성 -> 주소를 배열에 넣는다.
		list[1] = new Score(); // 인스턴스 생성 -> 주소를 배열에 넣는다.
		list[2] = new Score(); // 인스턴스 생성 -> 주소를 배열에 넣는다.
		
		// Score 객체를 1만개 만들기 
		Score[] list2 = new Score[10000];
		for (int i = 0; i < list2.length; i++) {
			list2[i] = new Score(); // 인스턴스를 만들고, 그 주소를 레퍼런스 배열 항목에 넣는다.
		}
	}
	
	public static void main(String[] args) {
		Score[] scores = new Score[100];
		int count = 0;
		
		Scanner scanner = new Scanner(System.in);
		
		Score s; // 반복문 내에서 인스턴스 주소를 담기 위해 사용할 레퍼런스 변수
		for (int i = 0; i < scores.length; i++) {
			s = new Score(); // 학생의 성정 정보를 입력 받을 인스턴스 준비
			
			System.out.print("이름?");
			s.name = scanner.nextLine();
			
			System.out.print("국어?");
			s.kor = Integer.parseInt(scanner.nextLine());
			
			System.out.print("영어?");
			s.eng = Integer.parseInt(scanner.nextLine());
			
			System.out.print("수학?");
			s.math = Integer.parseInt(scanner.nextLine());
			
			s.total = s.kor + s.eng + s.math;
			s.average = s.total / 3.0f;
			
			scores[i] = s;
			
			count++;
			
			System.out.print("계속 하시겠습니까?(y/n)");
			String text = scanner.nextLine();
			if (text.equals("n"))
				break;
		}
		
		for(int i = 0; i < count; i++) {
			s = scores[i];
			System.out.println(s.name + "님의 평균과 총점은 다음과 같습니다.");
			System.out.println("총점: " + s.total + ", 평균: " + s.average);
		}
		
	}
}









