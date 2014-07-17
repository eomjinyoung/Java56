package step05;

import java.util.HashMap;
import java.util.Properties;

/* Builder 패턴
 * => 여러 객체를 조립하여 하나의 객체를 생성할 경우 사용
 * => 문제: 객체를 생성하기 위해 여러 객체를 사용해야 한다.
 * => 해결책: 객체 조립을 수행하는 클래스(Builder)를 정의한다.
 */
public class TireFactoryBuilder {
  
  // Properties에 설정된 정보를 바탕으로 TireFactory3를 만들어준다.
  public TireFactory3 build(Properties props) {
    TireFactory3 factory = new TireFactory3();
    factory.maker = props.getProperty("maker");
    
    String radiusInfo = props.getProperty("radius"); //ex) 26,28,24
    String[] radiusList = radiusInfo.split(",");
    HashMap<String,Integer> radiusMap = new HashMap<String,Integer>();
    radiusMap.put("regular", new Integer(radiusList[0]));
    radiusMap.put("sports", new Integer(radiusList[1]));
    radiusMap.put("other", new Integer(radiusList[2]));
    factory.radiusMap = radiusMap;
    
    return factory;
  }
}
