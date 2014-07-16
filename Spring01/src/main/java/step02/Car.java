package step02;

public class Car {
  String  maker;
  String  model;
  int     capacity;
  
  public Car() { }
  
  public Car(String maker, String model) {
    this.maker = maker;
    this.model = model;
  }
  
  public Car(String maker, String model, int capacity) {
    this(maker, model);
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
    this.maker = maker;
  }
  public String getModel() {
    return model;
  }
  public void setModel(String model) {
    this.model = model;
  }
  public int getCapacity() {
    return capacity;
  }
  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }
}
