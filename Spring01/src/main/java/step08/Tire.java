package step08;

import org.springframework.stereotype.Component;

@Component("tire")
public class Tire {
  String  maker;
  int     radius;
  
  public Tire() {
    System.out.println("Tire() 호출");
  }
  
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
