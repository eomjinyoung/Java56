package exam.net.step01;

import java.util.Scanner;

public class Client01 {

  public static void main(String[] args) {
    //System.in <= 키보드 
    //Scanner <= 텍스트 입력 스트림을 다루는 객체
    Scanner keyScan = new Scanner(System.in);
    
    String message = null;
    while (true) {
      message = keyScan.nextLine();
      System.out.println("==>" + message);
      
      if (message.equals("quit"))
        break;
    }
    
    keyScan.close();

  }

}
