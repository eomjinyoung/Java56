package step06;

import java.text.SimpleDateFormat;
import java.util.Date;

/* 
 * 스프링 IoC 컨테이너에서 사용할 팩토리 클래스 만들기
 * => 팩토리 메서드는 반드시 static 이어야 한다.
 */

public class TireFactory {

  // static으로 선언해야 스프링 IoC 컨테이너에서 호출할 수 있다.
  public static Tire createTire(String type, String maker) {
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







