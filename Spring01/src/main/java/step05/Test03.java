package step05;

public class Test03 {
  public static void main(String[] args) {
    TireFactory2 factory = TireFactory2.getInstance();
    Tire t1 = factory.createTire("sports", "금호타이어");
    
    System.out.println(t1);
        
  }
}
