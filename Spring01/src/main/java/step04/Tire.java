package step04;

public class Tire {
  String  maker;
  int     radius;
  
  @Override
  public String toString() {
    return "Tire [maker=" + maker + ", radius=" + radius + "]";
  }
  
  public String getMaker() {
    return maker;
  }
  public void setMaker(String maker) {
    this.maker = maker;
  }
  public int getRadius() {
    return radius;
  }
  public void setRadius(int radius) {
    this.radius = radius;
  }
  
  
}
