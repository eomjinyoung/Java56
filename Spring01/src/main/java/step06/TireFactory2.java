package step06;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/* TireFactory2
 * => 팩토리 메서드가 static이 아닐 때 
 * 
 */

public class TireFactory2 {
  String maker;
  Map<String,Integer> radiusMap;

  public String getMaker() {
    return maker;
  }
  public void setMaker(String maker) {
    this.maker = maker;
  }
  public Map<String, Integer> getRadiusMap() {
    return radiusMap;
  }
  public void setRadiusMap(Map<String, Integer> radiusMap) {
    this.radiusMap = radiusMap;
  }

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







