package exam.oop2.step04;

public class CarTest {

	public static void main(String[] args) {
		Suv c3 = new Suv();
		/* Suv 인스턴스 생성 후 변수 초기화 절차 
		 * 1) 인스턴스 생성
		 * [(model=null)(cc=0)(weight=0)(capacity=0)]
		 * 2) 초기화 문장 수행
		 * [(model=null)(cc=1000)(weight=1000)(capacity=2)]
		 * 3) 생성자 호출 
		 */
		
		c3.model = "코란도스포츠";
		c3.capacity = 4;
		
		System.out.println(c3.model);
		System.out.println(c3.cc);
		System.out.println(c3.weight);
		System.out.println(c3.capacity);

	}

}







