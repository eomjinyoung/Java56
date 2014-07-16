package step03;

public class Engine {
  String type;
  int cc;
  
  @Override
  public String toString() {
    return "Engine [type=" + type + ", cc=" + cc + "]";
  }
  
  public String getType() {
    return type;
  }
  public void setType(String type) {
    this.type = type;
  }
  public int getCc() {
    return cc;
  }
  public void setCc(int cc) {
    this.cc = cc;
  }
  
  
}
