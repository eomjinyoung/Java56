package exam.net.step02;

import java.io.PrintStream;
import java.util.Scanner;

public class Sender extends Thread {
  Scanner keyScan;
  PrintStream out;
  
  public Sender(Scanner keyScan, PrintStream out) {
    this.keyScan = keyScan;
    this.out = out;
  }
  
  public void run() {
    String message = null;
    while (true) {
      message = keyScan.nextLine();
      out.println(message);
      
      if (message.equals("bye")) 
        break;
    }
  }
}














