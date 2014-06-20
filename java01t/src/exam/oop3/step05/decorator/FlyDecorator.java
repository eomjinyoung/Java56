package exam.oop3.step05.decorator;

public class FlyDecorator extends Machine {
  Machine base;
  
  public FlyDecorator(Machine base) {
    this.base = base;
  }
  
  @Override
  public void move() {
    base.move();
    System.out.println("난다...~~~ 날아..~~~ 슈~~~욱...");
  }

}
