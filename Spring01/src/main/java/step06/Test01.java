package step06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
  public static void main(String[] args) {
    ApplicationContext ctx = new ClassPathXmlApplicationContext(
            new String[]{"step06/application-context.xml"});
    
    // 주의!!!!
    // => tire 이름으로 리턴되는 것은 TireFactory 객체가 아니라
    //    TireFactory의 createTire() 리턴 값이다.
    Tire t1 = (Tire)ctx.getBean("tire");
    Tire t2 = (Tire)ctx.getBean("tire");
    if (t1 == t2) {
      System.out.println("t1 == t2");
    }
    System.out.println(t1);
  }
}






