/* 배열
 * - 같은 종류의 메모리를 여러개 만드는 것
 *  
 */
package exam.basic;

import java.util.Scanner;

public class Array01_t01 {

	public static void main(String[] args) {
		String[] name = new String[3];
		int[] kor = new int[3];
		int[] eng = new int[3];
		int[] math = new int[3];
		int[] tot = new int[3];
		float[] aver = new float[3];
		
		//문제1) 다음과 같이 실행되도록 작성하시오!
		// 이름? 홍길동
		// 국어? 100
		// 영어? 100
		// 수학? 100
		// 이름? 임꺽정
		// 국어? 90
		// 영어? 90
		// 수학? 90
		// 이름? 장길산
		// 국어? 80
		// 영어? 80
		// 수학? 80
		// 홍길동: 총점 = 300, 평균 = 100.0
		// 임꺽정: 총점 = 270, 평균 = 90.0
		// 장길산: 총점 = 240, 평균 = 80.0
		Scanner scanner = new Scanner(System.in);
		System.out.print("이름?");
		name[0] = scanner.nextLine();
		
		System.out.print("국어?");
		kor[0] = Integer.parseInt(scanner.nextLine());
		
		System.out.print("영어?");
		eng[0] = Integer.parseInt(scanner.nextLine());
		
		System.out.print("수학?");
		math[0] = Integer.parseInt(scanner.nextLine());
		
		tot[0] = kor[0] + eng[0] + math[0];
		aver[0] = tot[0] / 3.0f;
		
		System.out.println(name[0] + "님의 평균과 총점은 다음과 같습니다.");
		System.out.println("총점: " + tot[0] + ", 평균: " + aver[0]);
	}
	
	public static void main05(String[] args) {
		String[] name = new String[10];
		int[] kor = new int[10];
		int[] eng = new int[10];
		int[] math = new int[10];
		int[] tot = new int[10];
		float[] aver = new float[10];
		
		//문제1) 다음과 같이 실행되도록 작성하시오!
		// 이름? 홍길동
		// 국어? 100
		// 영어? 100
		// 수학? 100
		// 홍길동 님의 총점과 평균은 다음과 같습니다.
		// 총점 = 300, 평균 = 100.0
		Scanner scanner = new Scanner(System.in);
		System.out.print("이름?");
		name[0] = scanner.nextLine();
		
		System.out.print("국어?");
		kor[0] = Integer.parseInt(scanner.nextLine());
		
		System.out.print("영어?");
		eng[0] = Integer.parseInt(scanner.nextLine());
		
		System.out.print("수학?");
		math[0] = Integer.parseInt(scanner.nextLine());
		
		tot[0] = kor[0] + eng[0] + math[0];
		aver[0] = tot[0] / 3.0f;
		
		System.out.println(name[0] + "님의 평균과 총점은 다음과 같습니다.");
		System.out.println("총점: " + tot[0] + ", 평균: " + aver[0]);
	}
	
	
	public static void main03(String[] args) {
		// 배열 선언과 동시에 초기 값 할당 
		// 배열의 크기는 중괄호에 선언된 값들의 개수이다.
		int[] arr = new int[]{10, 20, 30};
		
		/* 다음은 오류!
		int[] arr2 = new int[3];
		arr2 = {10,20,30};
		*/
		
		/* 다음은 허용!
		int[] arr3;
		arr3 = new int[]{10,20,30};
		*/
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
	}
	
	public static void main02(String[] args) {
		int[] arr = new int[3];
		// new int[3] -> 연속된 4byte int 형 메모리 3개 준비
		// int[] arr -> int 배열의 주소를 저장하는 레퍼런스 (변수)
		//arr = 20; //주소가 아닌 값을 넣을 수 없다. 임의의 주소도 넣을 수 없다.
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
		//arr[3] = 40;
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
	}
	
	public static void main04(String[] args) {
		String[] name = new String[10];
		int[] kor = new int[10];
		//int kor[] = new int[10]; //ok
		int[] eng = new int[10];
		int[] math = new int[10];
		int[] tot = new int[10];
		float[] aver = new float[10];
		
		name[0] = "홍길동";
		kor[0] = 100;
		eng[0] = 90;
		math[0] = 100;
		tot[0] = kor[0] + eng[0] + math[0];
		aver[0] = tot[0] / 3.0f;
		
		System.out.println(name[0] + "님의 평균 점수는 " + aver[0] + "입니다.");
	}
	
	public static void main01(String[] args) {
		int kor, eng, math, soc, sci, tot;
		//int kor2, eng2, math2, soc2, sci2, tot2;
		//int kor3, eng3, math3, soc3, sci3, tot3;
		float aver;
		
		kor = 108;
		eng = 90;
		math = 90;
		soc = 100;
		sci = 100;
		
		tot = kor + eng + math + soc + sci;
		aver = tot / 5.0f;
		
		System.out.println("평균:" + aver);

	}

}






