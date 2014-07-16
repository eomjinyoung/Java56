package step04;

import java.util.ArrayList;

public class Car2 {
  String  maker;
  String  model;
  int     capacity;
  Engine  engine;
  ArrayList<Tire>  tires;
  
  public Car2() { 
    System.out.println("Car() 호출");
  }
  
  public Car2(String maker, String model) {
    System.out.println("Car(maker,model) 호출");
    this.maker = maker;
    this.model = model;
  }
  
  public Car2(String maker, String model, int capacity) {
    this(maker, model);
    System.out.println("Car(maker,model,capacity) 호출");
    this.capacity = capacity;
  }
  
  @Override
  public String toString() {
    return "Car2 [maker=" + maker + ", model=" + model + ", capacity="
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
  public ArrayList<Tire> getTires() {
    return tires;
  }
  public void setTires(ArrayList<Tire> tires) {
    this.tires = tires;
  }
}








