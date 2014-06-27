package exam.net.step02;

import java.util.Scanner;

public class Receiver extends Thread{
  Scanner in;
  
  public Receiver(Scanner in) {
    this.in = in;
  }
  
  public void run() {
    String message = null;
    while (true) {
      message = in.nextLine();
      System.out.println("===> " + message);
      
      if (message.equals("bye"))
        break;
    }
  }

}
