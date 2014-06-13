package exam.oop2.step07;

public class CarTest {

	public static void main(String[] args) {
		Car car = new Car();
		Truck truck = new Truck();
		Suv suv = new Suv();
		
		Object obj;
		obj = car;
		obj = truck;
		obj = suv;
		/* 레퍼런스 변수는 그 자신의 인스턴스 뿐만아니라 자식 인스턴스도 가리킬 수 있다.
		 * => 다형적 변수
		 */
		Car c;
		c = car;
		c = truck;
		c = suv;
		
		// 레퍼런스 변수는 상위 클래스의 인스턴스를 가리킬 수 없다.
		// => 레퍼런스 변수의 타입을 기준으로 인스턴스를 사용하기 때문이다.
		Truck t;
		/*
		t = (Truck)car; // error
		t.model = "포터";
		t.cc = 2800;
		t.weight = 1500; // 실제 존재하지 않는 메모리를 사용하려 시도할 수 있다.
											// 상위 클래스의 인스턴스를 가리켜서는 안된다.
		*/
		t = truck;
		t = suv;
		
		Suv s;
		//s = car; //error
		//s = truck; //error
		s = suv;
	}

}







