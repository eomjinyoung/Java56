package exam.oop2.step02;

public class CalculatorTest {

	public static void main(String[] args) {
		Calculator c1 = new Calculator();
		c1.plus(5);
		c1.plus(7);
		c1.minus(3);
		System.out.println(c1.result);

		CalculatorPro c2 = new CalculatorPro();
		c2.plus(5); // Calculator#plus()
		c2.plus(7); // "
		c2.minus(3); // Calculator#minus()
		c2.multiple(3); // CalculatorPro#multiple()
		System.out.println(c2.result); 
		
		CalculatorEnt c3 = new CalculatorEnt();
		c3.plus(5); // Calculator#plus()
		c3.plus(7); // "
		c3.minus(3); // Calculator#minus()
		c3.multiple(3); // CalculatorPro#multiple()
		c3.divide(9); // CalculatorEnt#divide();
		System.out.println(c3.result); 
		
	}

}






