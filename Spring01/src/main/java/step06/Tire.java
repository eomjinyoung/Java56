package step06;

public class Tire {
  String  maker;
  int     radius;
  String  createdDate; // format yyww
  
  @Override
  public String toString() {
    return "Tire [maker=" + maker + ", radius=" + radius + ", createdDate="
        + createdDate + "]";
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
  public String getCreatedDate() {
    return createdDate;
  }
  public void setCreatedDate(String createdDate) {
    this.createdDate = createdDate;
  }
}
