package step06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test02 {
  public static void main(String[] args) {
    ApplicationContext ctx = new ClassPathXmlApplicationContext(
            new String[]{"step06/application-context2.xml"});
    
    Tire t1 = (Tire)ctx.getBean("tire");
    System.out.println(t1);
  }
}






