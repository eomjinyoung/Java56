package step04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
  public static void main(String[] args) {
    ApplicationContext ctx = new ClassPathXmlApplicationContext(
            new String[]{"step04/application-context.xml"});
    
    Car c1 = (Car)ctx.getBean("c1"); 
    System.out.println(c1);
    
  }
}






