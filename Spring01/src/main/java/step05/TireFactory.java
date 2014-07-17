package step05;

import java.text.SimpleDateFormat;
import java.util.Date;

/* 디자인 패턴(Design Pattern)
 * => 실무에서 사용되고 검증된 최상의 설계 방법
 * => 설계의 Best Practice
 * => 어떤 문제에 대해 어떻게 클래스를 만들면 좋은지 설계 방법을 보여준다.
 * 
 * 1. Factory Method 패턴
 * => 객체를 생성하는 방법
 * => new 명령이 아닌 메서드를 통해 객체를 생성한다.
 * => 문제: 객체 생성 과정이 복잡하다.
 * => 해결책: 복잡한 객체 생성 과정을 메서드에 감춘다. => 코드를 간결하게 유지할 수 있다.
 */

public class TireFactory {
  
  //팩토리 메서드 
  public Tire createTire(String type, String maker) {
    Tire tire = new Tire();
    tire.setMaker(maker);
    
    switch(type) {
    case "sports":
      tire.setRadius(28);
      break;
    case "regular":
      tire.setRadius(26);
      break;
    default:
      tire.setRadius(24);
    }
    
    SimpleDateFormat df = new SimpleDateFormat("yyww");
    tire.setCreatedDate( df.format(new Date()) );
    
    return tire;
  }
}







