package exam.oop;

public class Car {
	// 공통 데이터 => 클래스 변수
	static int count;
	
	// 클래스 변수 초기화 => 스태틱 블록 
	static {
		/*Car.*/count = 100;
	}
	
	// 개별 데이터 => 인스턴스 변수
	int		serialNo;
	String	model;
	String 	carNo;
	int		cc;
	int		weight;
	int		capacity;
	
	// 인스턴스 변수 초기화 => 생성자
	public Car(String model, String carNo) {
		this.serialNo = ++/*Car.*/count;
		this.model = model;
		this.carNo = carNo;
	}
}











