package step03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test03 {
  public static void main(String[] args) {
    ApplicationContext ctx = new ClassPathXmlApplicationContext(
            new String[]{"step03/application-context3.xml"});
    
    Car c1 = (Car)ctx.getBean("c1"); 
    Car c2 = (Car)ctx.getBean("c2"); 
    
    if (c1.getEngine() == c2.getEngine()) 
      System.out.println("c1.getEngine() == c1.getEngine()");
    
  }
}






