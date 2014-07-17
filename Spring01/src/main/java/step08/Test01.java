package step08;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
  public static void main(String[] args) {
    ApplicationContext ctx = new ClassPathXmlApplicationContext(
            new String[]{"step08/application-context.xml"});
    
    Car car = (Car)ctx.getBean("car");
    System.out.println(car);
  }
}






