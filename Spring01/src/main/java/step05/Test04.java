package step05;

import java.util.Properties;

public class Test04 {
  public static void main(String[] args) {
    //1. 타이어 공장(TireFactory)을 짓는데 필요한 정보를 준비한다.
    Properties props = new Properties();
    props.setProperty("maker", "비트타이어");
    props.setProperty("radius", "32,36,26");
 
    //2. 타이어 공장을 만든다.
    TireFactory3 factory = new TireFactoryBuilder().build(props);
    
    //3. 타이어 공장으로부터 타이어를 얻는다.
    Tire t1 = factory.createTire("sports");
    
    System.out.println(t1);
        
  }
}
