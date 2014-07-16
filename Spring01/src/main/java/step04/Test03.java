package step04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test03 {
  public static void main(String[] args) {
    ApplicationContext ctx = new ClassPathXmlApplicationContext(
            new String[]{"step04/application-context3.xml"});
    
    Car3 c1 = (Car3)ctx.getBean("c1"); 
    System.out.println(c1);
    
  }
}






