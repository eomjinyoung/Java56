package exam.oop2.step06;

public class CalculatorTest {

	public static void main(String[] args) {
		CalculatorEnt c3 = new CalculatorEnt();
		c3.plus(5); // Calculator#plus(int)
		c3.plus("$700"); // Calculator#plus(String)
		c3.minus(3); // Calculator#minus()
		c3.multiple(3); // CalculatorPro#multiple()
		c3.divide(9); // CalculatorEnt#divide();
		System.out.println(c3.result); 
		
	}

}






