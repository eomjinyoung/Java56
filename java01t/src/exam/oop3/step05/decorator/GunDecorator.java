package exam.oop3.step05.decorator;

public class GunDecorator extends Machine {
  Machine base;
  
  public GunDecorator(Machine base) {
    this.base = base;
  }
  
  @Override
  public void move() {
    base.move();
    System.out.println("따따따.... 따다다......");
  }

}
