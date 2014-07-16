package step02;

public class Car {
  String  maker;
  String  model;
  int     capacity;
  
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
        + capacity + "]";
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
}
