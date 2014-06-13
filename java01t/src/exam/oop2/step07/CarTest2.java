package exam.oop2.step07;

public class CarTest2 {

	public static void main(String[] args) {
		Car car = new Car();
		Truck truck = new Truck();
		Suv suv = new Suv();
		
		// 다형적 변수의 활용 예
		// 다양한 타입의 인스턴스 주소를 관리할 때 사용.
		Car[] cars = new Car[10];
		cars[0] = car;
		cars[1] = truck;
		cars[2] = suv;
		
	}

}







