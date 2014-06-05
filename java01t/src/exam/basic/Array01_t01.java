/* 배열
 * - 같은 종류의 메모리를 여러개 만드는 것
 *  
 */
package exam.basic;

public class Array01_t01 {

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






