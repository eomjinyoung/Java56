package step02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test02 {
  public static void main(String[] args) {
    ApplicationContext ctx = new ClassPathXmlApplicationContext(
            new String[]{"step02/application-context2.xml"});
    
    Car c1 = (Car)ctx.getBean("c1"); 
    Car c2 = (Car)ctx.getBean("c2");
    Car c3 = (Car)ctx.getBean("c3"); 
    
    System.out.println(c1);
    System.out.println(c2);
    System.out.println(c3);
  }
}





