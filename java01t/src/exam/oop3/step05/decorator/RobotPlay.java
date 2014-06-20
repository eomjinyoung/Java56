package exam.oop3.step05.decorator;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.LineNumberInputStream;

public class RobotPlay {

  public static void main(String[] args) throws Exception {
    /* Data Sink Stream class */
    FileInputStream in = new FileInputStream("test.txt");
    
    /* Data Processing Stream class => Decorator 역할 */
    BufferedInputStream buf = new BufferedInputStream(in);
    LineNumberInputStream line = new LineNumberInputStream(buf);
    DataInputStream in2 = new DataInputStream(line);
    
    in2.readInt();
    
  }
  
  public static void main01(String[] args) {
    Robot robot = new Robot();
    //InvisibleDecorator robot3 = new InvisibleDecorator(robot);
    GunDecorator gun = new GunDecorator(robot);
    FlyDecorator robot2 = new FlyDecorator(gun);
    robot2.move();
    

  }

}
