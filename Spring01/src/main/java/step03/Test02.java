package step03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test02 {
  public static void main(String[] args) {
    ApplicationContext ctx = new ClassPathXmlApplicationContext(
            new String[]{"step03/application-context2.xml"});
    
    Car c1 = (Car)ctx.getBean("c1"); 
    Car c2 = (Car)ctx.getBean("c2"); 
    Engine e1 = (Engine)ctx.getBean("e1");
    Engine e2 = (Engine)ctx.getBean("e1");
    Engine e3 = (Engine)ctx.getBean("e1");
    
    System.out.println(c1);
    System.out.println(c2);
    
    // scope이 prototype인 경우, getBean() 호출 때마다 생성된다.
    // 따라서 다음은 조건은 거짓이다.
    if (e1 == c1.getEngine()) System.out.println("e1 == c1.getEngine()");
    if (e1 == c2.getEngine()) System.out.println("e1 == c2.getEngine()");
    
  }
}






