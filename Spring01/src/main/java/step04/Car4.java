package step04;

import java.util.Arrays;
import java.util.Map;

public class Car4 {
  String  maker;
  String  model;
  int     capacity;
  Engine  engine;
  Tire[]  tires;
  Map<String,Object> options;
  
  public Car4() { 
    System.out.println("Car() 호출");
  }
  
  public Car4(String maker, String model) {
    System.out.println("Car(maker,model) 호출");
    this.maker = maker;
    this.model = model;
  }
  
  public Car4(String maker, String model, int capacity) {
    this(maker, model);
    System.out.println("Car(maker,model,capacity) 호출");
    this.capacity = capacity;
  }
  
  @Override
  public String toString() {
    return "Car4 [maker=" + maker + ", model=" + model + ", capacity="
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








