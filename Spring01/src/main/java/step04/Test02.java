package step04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test02 {
  public static void main(String[] args) {
    ApplicationContext ctx = new ClassPathXmlApplicationContext(
            new String[]{"step04/application-context2.xml"});
    
    Car2 c1 = (Car2)ctx.getBean("c1"); 
    System.out.println(c1);
    
  }
}






