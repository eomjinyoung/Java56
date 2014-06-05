/* 배열
 * - 같은 종류의 메모리를 여러개 만드는 것
 *  
 */
package exam.basic;

public class Array01_t01 {

	public static void main(String[] args) {
		int[] arr = new int[3];
		// new int[3] -> 연속된 4byte int 형 메모리 3개 준비
		// int[] arr -> int 배열의 주소를 저장하는 레퍼런스 (변수)
		//arr = 20; //주소가 아닌 값을 넣을 수 없다. 임의의 주소도 넣을 수 없다.
		
	}
	
	public static void mainx(String[] args) {
		int[] kor = new int[10];
		//int kor[] = new int[10]; //ok
		int[] eng = new int[10];
		int[] math = new int[10];
		int[] soc = new int[10];
		int[] tot = new int[10];
		float[] aver = new float[10];
		
		kor = 108;
		eng = 90;
		math = 90;
		soc = 100;
		sci = 100;
		
		tot = kor + eng + math + soc + sci;
		aver = tot / 5.0f;
		
		System.out.println("평균:" + aver);

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






