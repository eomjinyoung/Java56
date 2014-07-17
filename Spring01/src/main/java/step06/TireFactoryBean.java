package step06;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.config.AbstractFactoryBean;

/* 스프링 규격에 맞추어 팩토리 클래스 선언하기
 * => 장점: 스프링 기능을 십분 활용할 수 있다.
 * => 단점: 스프링 라이브러리가 필요하다. POJO가 아니다.
 * => FactoryBean 인터페이스 구현한다.
 * => FactoryBean을 미리 구현한 AbstractFactoryBean을 상속 받는다.
 */

public class TireFactoryBean extends AbstractFactoryBean<Tire> {
  String type;
  String maker;
  Map<String,Integer> radiusMap;

  public String getType() {
    return type;
  }
  public void setType(String type) {
    this.type = type;
  }
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

  // 스프링 IoC 컨테이너에게 팩토리 메서드가 리턴하는 값이 어떤 클래스의 객체인지 알려준다.
  @Override
  public Class<?> getObjectType() {
    return step06.Tire.class;
  }
  
  // 팩토리 메서드의 이름은 createInstance여야 한다. 
  public Tire createInstance() {
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







