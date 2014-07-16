package step01;

public class Car {
  String  maker;
  String  model;
  int     capacity;
  
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
