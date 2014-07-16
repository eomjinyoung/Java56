package step01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test03 {
  public static void main(String[] args) {
    ApplicationContext ctx = new ClassPathXmlApplicationContext(
            new String[]{"step01/application-context3.xml"});
    
    System.out.println("빈의 이름 출력 ---------------------");
    // 출력 결과: step01.Car#0, step01.Car#1
    for (String beanName : ctx.getBeanDefinitionNames()) {
      System.out.println(beanName);
    }
    
    System.out.println("step01.Car#0 빈의 별명 출력 ---------------------");
    // 출력 결과: 
    for (String beanAliasName : ctx.getAliases("step01.Car#0")) {
      System.out.println(beanAliasName);
    }
    
    System.out.println("step01.Car#1 빈의 별명 출력 ---------------------");
    // 출력 결과: 
    for (String beanAliasName : ctx.getAliases("step01.Car#1")) {
      System.out.println(beanAliasName);
    }
    
    
    Car c1 = (Car)ctx.getBean("step01.Car#0");
    Car c2 = (Car)ctx.getBean("step01.Car#1");
    Car c3 = (Car)ctx.getBean("step01.Car"); // 같은 클래스의 인스턴스가 여러 개 있을 경우, 첫 번째 빈을 가리킨다.
    
    // 클래스 정보로 빈 찾기 
    Car c4 = ctx.getBean(step01.Car.class); // 해당 클래스의 빈이 하나만 있을 경우 정상 수행
    
  }
}







