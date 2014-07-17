package step05;

public class Test02 {
  public static void main(String[] args) {
    TireFactory factory = new TireFactory();
    Tire t1 = factory.createTire("sports", "금호타이어");
    
    System.out.println(t1);
        
  }
}
