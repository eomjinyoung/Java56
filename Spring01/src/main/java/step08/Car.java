package step08;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/* @Component 
 * => 스프링 IoC 컨테이너에 의해 인스턴스가 자동 생성된다.
 * 
 * @Autowired
 * => setter 메서드 앞에 선언하거나 인스턴스 변수 앞에 선언한다.
 * => 스프링 IoC 컨테이너가 해당 타입의 객체를 찾아서 자동 주입한다.
 * => Autowired는 기본으로 필수 입력이다. 따라서 의존 객체가 없으면 오류가 발생한다.
 * => required 속성을 false로 하면 선택 입력으로 바뀐다. 즉 의존 객체가 없더라도 오류가 발생하지 않는다.
 * 
 * @Qualifier
 * => 같은 타입의 의존 객체가 여러 개일 경우, 자동 주입할 때 오류가 발생한다.
 * => 스프링 IoC 컨테이너는 어떤 객체를 주입해야 할지 결정할 수 없기 때문이다.
 * => 해결책: 이 애노테이션을 사용하여 주입할 객체의 이름을 지정한다.
 */

//@Component(value="car")
@Component("car") // value 속성 이름 생략 가능
public class Car {
  String  maker;
  String  model;
  int     capacity;
  Engine  engine;
  Tire[]  tires;
  Map<String,Object> options;
  
  public Car() { 
    System.out.println("Car() 호출");
  }
  
  public Car(String maker, String model) {
    System.out.println("Car(maker,model) 호출");
    this.maker = maker;
    this.model = model;
  }
  
  public Car(String maker, String model, int capacity) {
    this(maker, model);
    System.out.println("Car(maker,model,capacity) 호출");
    this.capacity = capacity;
  }
  

  @Override
  public String toString() {
    return "Car [maker=" + maker + ", model=" + model + ", capacity="
        + capacity + ", engine=" + engine + ", tires=" + Arrays.toString(tires)
        + ", options=" + options + "]";
  }

  public String getMaker() {
    return maker;
  }
  public void setMaker(String maker) {
    System.out.println("setMaker() 호출");
    this.maker = maker;
  }
  public String getModel() {
    return model;
  }
  public void setModel(String model) {
    System.out.println("setModel() 호출");
    this.model = model;
  }
  public int getCapacity() {
    return capacity;
  }
  public void setCapacity(int capacity) {
    System.out.println("setCapacity() 호출");
    this.capacity = capacity;
  }
  public Engine getEngine() {
    return engine;
  }
  
  @Autowired
  @Qualifier("e2") // 주입할 의존 객체 이름을 지정
  public void setEngine(Engine engine) {
    System.out.println("setEngine() 호출");
    this.engine = engine;
  }
  
  public Tire[] getTires() {
    return tires;
  }
  public void setTires(Tire[] tires) {
    this.tires = tires;
  }
  public Map<String, Object> getOptions() {
    return options;
  }
  public void setOptions(Map<String, Object> options) {
    this.options = options;
  }
}








