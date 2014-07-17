package step07;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
  public static void main(String[] args) {
    ApplicationContext ctx = new ClassPathXmlApplicationContext(
            new String[]{"step07/application-context.xml"});
    
    Car car = (Car)ctx.getBean("car");
    //Engine engine = (Engine)ctx.getBean("engine");
    //Tire tire = (Tire)ctx.getBean("tire");
    
    System.out.println(car);
    //System.out.println(engine);
    //System.out.println(tire);
    
  }
}






