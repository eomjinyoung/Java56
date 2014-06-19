package exam.oop3.step05;

import java.io.FileReader;
import java.io.IOException;

/* FileReader
 * - 문자 데이터를 읽을 때 사용하는 클래스
 */

public class File04In {

  public static void main(String[] args) throws IOException {
    FileReader in = new FileReader("file04.txt");
    
    char[] buf = new char[100];
    int readSize = 0;
    readSize = in.read(buf, 3, 5);
    System.out.print(buf);

    in.close();
  }
  
  public static void main01(String[] args) throws IOException {
    FileReader in = new FileReader("file04.txt");
    
    if (in.markSupported()) {
      System.out.println("마크 지원한다.");
    } else {
      System.out.println("마크 지원하지 않는다.");
    }
    
    System.out.println( (char)in.read() );
    System.out.println( (char)in.read() );
    
    char[] buf = new char[4];
    int readSize = 0;
    readSize = in.read(buf);
    System.out.print(buf);
    System.out.println("," + readSize);
    
    readSize = in.read(buf);
    System.out.print(buf);
    System.out.println("," + readSize);
    
    readSize = in.read(buf);
    System.out.print(buf);
    System.out.println("," + readSize);
    
    readSize = in.read(buf);
    System.out.print(buf);
    System.out.println("," + readSize);
    
    in.close();
  }

}




















