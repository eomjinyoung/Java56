package util;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class MyHttpClient {

  public static void main(String[] args) throws Exception {
    Socket socket = new Socket("www.naver.com", 80);
    
    PrintStream out = new PrintStream(socket.getOutputStream());
    Scanner in = new Scanner(socket.getInputStream());
    
    out.println("GET / HTTP/1.1");
    out.println("Host: www.naver.com");
    out.println();
    
    String line = null;
    while(true) {
      line = in.nextLine();
      System.out.println(line);
      if (line.equals(""))
        break;
    }
    
    while(true) {
      try {
        System.out.println(in.next());
      } catch (Exception e) {
        break;
      }
    }
    
    
    out.close();
    in.close();
    socket.close();
  }

}











