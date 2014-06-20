package exam.oop3.step05.decorator;

public abstract class Machine {
  /* 추상 메서드
   * - 서브클래스에게 강제적으로 특정 메서드를 반드시 구현하게 하고 싶을 때 
   * - 추상 메서드는 오로지 추상 클래스 만이 가질 수 있다.
   */
  public abstract void move();
}
