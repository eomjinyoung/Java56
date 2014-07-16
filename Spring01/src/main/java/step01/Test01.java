package step01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {

  // 스프링 IoC 컨테이너 사용 후
  // 빈 컨테이너 종류
  // 1. ClassPathXmlApplicationContext => 자바 클래스 패스에서 설정 파일을 찾아서 로딩한다.
  // 2. FileSystemXmlApplicationContext => 직접 지정한 폴더에서 설정 파일을 찾아 로딩한다.
  // 3. WebApplicationContext => 웹 애플리케이션에서 사용하는 빈 컨테이너.
  //
  // 클래스 패스란? 자바에서 클래스를 찾을 때 사용하는 경로
  // 1) 부트스트랩(bootstrap) - JRE에서 제공하는 라이브러리 ex)rt.jar, i18n.jar 등
  // 2) 자바 확장 라이브러리 - JRE 폴더 /lib/ext
  // 3) JVM 실행할 때 사용하는 CLASSPATH 환경 변수에 등록된 폴더 
  public static void main(String[] args) {
    ApplicationContext ctx = new ClassPathXmlApplicationContext(
            new String[]{"step01/application-context.xml"});
    
    Car c1 = (Car)ctx.getBean("c1"); // 기본 생성자 호출한 빈
    Car c2 = (Car)ctx.getBean("c2"); // setter까지 호출한 빈 
    
    System.out.println(c1);
    System.out.println(c2);
  }
  
  // 스프링 IoC 컨테이너를 사용하기 전
  public static void main01(String[] args) {
    Car c1 = new Car();
    c1.setMaker("현대자동차");
    c1.setModel("소나타");
    c1.setCapacity(5);
    
    Car c2 = new Car();
    c2.setMaker("기아자동차");
    c2.setModel("K5");
    c2.setCapacity(5);
    
    System.out.println(c1);
    System.out.println(c2);
  }

}
