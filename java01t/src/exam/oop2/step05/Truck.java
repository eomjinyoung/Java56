package exam.oop2.step05;

public class Truck extends Car {
	int weight = 1000; // 중량
	
	// 생성자가 없다면 기본 생성자를 자동으로 만든다. 있다면 안 만든다.
	//public Truck() {}
	
	public Truck(int weight) {
		//super();
		super("오호라"); // super 클래스의 생성자 중에서 호출될 생성자를 선택할 수 있다.
		System.out.println("Truck()");
		this.weight = weight;
	}
}
