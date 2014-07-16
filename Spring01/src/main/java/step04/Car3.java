package step04;

import java.util.ArrayList;
import java.util.HashSet;

public class Car3 {
  String  maker;
  String  model;
  int     capacity;
  Engine  engine;
  HashSet<Tire>  tires;
  
  public Car3() { 
    System.out.println("Car() 호출");
  }
  
  public Car3(String maker, String model) {
    System.out.println("Car(maker,model) 호출");
    this.maker = maker;
    this.model = model;
  }
  
  public Car3(String maker, String model, int capacity) {
    this(maker, model);
    System.out.println("Car(maker,model,capacity) 호출");
    this.capacity = capacity;
  }
  
  @Override
  public String toString() {
    return "Car3 [maker=" + maker + ", model=" + model + ", capacity="
        + capacity + ", engine=" + engine + ", tires=" + tires + "]";
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
  public HashSet<Tire> getTires() {
    return tires;
  }
  public void setTires(HashSet<Tire> tires) {
    this.tires = tires;
  }
}








