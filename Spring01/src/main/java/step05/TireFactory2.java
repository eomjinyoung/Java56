package step05;

import java.text.SimpleDateFormat;
import java.util.Date;

/* 
 * 2. Singleton 패턴
 * => 문제: 인스턴스를 한 개만 생성하여 사용하고 싶다.
 * => 해결책: 인스턴스 생성을 메서드에 맡긴다.
 */

public class TireFactory2 {
  
  // 1. 외부에서 생성자를 호출할 수 없도록 막는다.
  private TireFactory2() {}
  
  // 2. 객체 주소를 저장할 변수 선언 => static 변수로 선언한다.
  private static TireFactory2 instance;
  
  // 3. 객체 생성 메서드를 만든다. => 외부에서 인스턴스 없이 바로 호출할 수 있도록 static으로 선언한다.
  public static TireFactory2 getInstance() {
    if (instance == null) {
      instance = new TireFactory2();
    }
    return instance;
  }
  
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







