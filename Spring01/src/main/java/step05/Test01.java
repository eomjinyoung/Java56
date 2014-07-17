package step05;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test01 {

  public static void main(String[] args) {
    Tire t1 = new Tire();
    t1.setMaker("금호타이어");
    t1.setRadius(28);
    SimpleDateFormat formatter = new SimpleDateFormat("yyww");
    t1.setCreatedDate(formatter.format(new Date()));
    
    System.out.println(t1);
  }

}









