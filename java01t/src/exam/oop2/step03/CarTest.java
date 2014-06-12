package exam.oop2.step03;

public class CarTest {

	public static void main(String[] args) {
		Car c1 = new Car();
		
		Truck c2 = new Truck();
		
		Suv c3 = new Suv();
		
		
		c1.model = "티코";
		c1.cc = 800;
		
		c2.model = "포터";
		c2.cc = 1998;
		c2.weight = 1500;
		
		c3.model = "코란도스포츠";
		c3.cc = 3000;
		c3.weight = 800;
		c3.capacity = 4;
		
		System.out.println(c1.model);
		System.out.println(c2.model);
		System.out.println(c3.model);
	}

}







