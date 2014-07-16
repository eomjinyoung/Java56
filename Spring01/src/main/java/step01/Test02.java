package step01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test02 {
  public static void main(String[] args) {
    ApplicationContext ctx = new ClassPathXmlApplicationContext(
            new String[]{"step01/application-context2.xml"});
    
    // 빈의 아이디로 찾기
    Car c1 = (Car)ctx.getBean("c1"); 
    
    // 빈의 별명으로 찾기
    Car ok1 = (Car)ctx.getBean("ok1");
    Car ok2 = (Car)ctx.getBean("ok2");
    Car ok3 = (Car)ctx.getBean("ok3");
    
    System.out.println(c1);
    
    if (c1 == ok1) System.out.println("c1 == ok1");
    if (c1 == ok2) System.out.println("c1 == ok2");
    if (c1 == ok3) System.out.println("c1 == ok3");
    
    // 빈의 별명으로 찾기
    Car no1 = (Car)ctx.getBean("no1");
    Car no2 = (Car)ctx.getBean("no2");
    Car no3 = (Car)ctx.getBean("no3");
    
    if (no1 == no2) System.out.println("no1 == no2");
    if (no1 == no3) System.out.println("no1 == no3");
    
    
    System.out.println("빈의 이름 출력 ---------------------");
    // 출력 결과: c1(아이디), no1(첫번째 별명)
    // 아이디가 있으면 아이디가 빈의 이름으로 사용된다. name의 값은 별명으로 사용된다.
    // 아이디가 없으면 첫번째 별명이 빈의 이름으로 사용된다. 나머지 name 값은 별명으로 사용된다.
    for (String beanName : ctx.getBeanDefinitionNames()) {
      System.out.println(beanName);
    }
    
    System.out.println("c1의 별명 출력 ---------------------");
    // 출력 결과: ?
    for (String beanAliasName : ctx.getAliases("c1")) {
      System.out.println(beanAliasName);
    }
    
    System.out.println("no1의 별명 출력 ---------------------");
    // 출력 결과: ?
    for (String beanAliasName : ctx.getAliases("no1")) {
      System.out.println(beanAliasName);
    }
    
  }
}







