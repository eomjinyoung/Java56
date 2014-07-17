package step06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test03 {
  public static void main(String[] args) {
    ApplicationContext ctx = new ClassPathXmlApplicationContext(
            new String[]{"step06/application-context3.xml"});
    
    // 스프링 IoC 컨테이너가 빈을 꺼낼 때, 클래스 타입이 FactoryBean 구현체일 경우
    // createInstance()를 호출하여 그 리턴 값을 준다.
    Tire t1 = (Tire)ctx.getBean("tire");
    System.out.println(t1);
  }
}






