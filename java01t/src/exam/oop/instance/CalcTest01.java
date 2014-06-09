package exam.oop.instance;

public class CalcTest01 {

	public static void main(String[] args) {
		// 5 + 3 * 7 (전제조건: 연산자 우선 순위 무시)
		int result = 0;
		result = Calculator01.plus(5, 3);
		result = Calculator01.multiple(result, 7);
		System.out.println(result);

	}

}
