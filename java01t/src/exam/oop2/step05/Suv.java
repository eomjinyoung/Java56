package exam.oop2.step05;

public class Suv extends Truck {
	int capacity = 2; //수용인원
	
	public Suv() {
		//super(); // 모든 생성자는 super 클래스의 기본 생성자를 호출하게 되어 있다.
		super(1300); // super클래스에 기본 생성자가 없다면 명시적으로 super클래스의 
		                 // 특정 생성자를 호출하는 코드를 넣어야 한다.반드시!!!
		System.out.println("Suv()");
	}
}
