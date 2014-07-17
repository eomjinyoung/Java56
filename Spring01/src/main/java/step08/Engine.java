package step08;


//@Component("engine")
public class Engine {
  String type;
  int cc;
  
  public Engine() {
    System.out.println("Engine() 호출");
  }
  
  @Override
  public String toString() {
    return "Engine [type=" + type + ", cc=" + cc + "]";
  }
  
  public String getType() {
    return type;
  }
  public void setType(String type) {
    System.out.println("setType() 호출");
    this.type = type;
  }
  public int getCc() {
    return cc;
  }
  public void setCc(int cc) {
    System.out.println("setCc() 호출");
    this.cc = cc;
  }
}






