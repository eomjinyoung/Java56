package step05;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/* 
 * 3. TireFactoryBuilder로부터 생성되도록 변경
 */

public class TireFactory3 {
  String maker;
  Map<String,Integer> radiusMap;

  //팩토리 메서드 
  public Tire createTire(String type) {
    Tire tire = new Tire();
    tire.setMaker(maker);
    
    if (radiusMap.get(type) != null) {
      tire.setRadius(radiusMap.get(type));
    } else {
      tire.setRadius(radiusMap.get("other"));
    }
    
    SimpleDateFormat df = new SimpleDateFormat("yyww");
    tire.setCreatedDate( df.format(new Date()) );
    
    return tire;
  }
}







