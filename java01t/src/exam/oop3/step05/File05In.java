package exam.oop3.step05;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/* 버퍼 vs non 버퍼
 * 
 * BufferedReader
 * - 버퍼 기능을 제공하는 도우미 클래스 
 * - FileReader => BufferedReader ---> read()
 */

public class File05In {
  public static void main(String[] args) throws IOException {
    FileReader in = new FileReader("naver.html");
    BufferedReader in2 = new BufferedReader(in);
    
    long startMilliSec = System.currentTimeMillis();
    
    int ch;
    int count = 0;
    while ( (ch = in2.read()) != -1) {
      if ((++count % 10000) == 0) {
        System.out.print(".");
      }
    }
    
    long endMilliSec = System.currentTimeMillis();
    System.out.println("\n" + (endMilliSec - startMilliSec));
    
    in2.close();
    in.close();
  }
  
  public static void main02(String[] args) throws IOException {
    FileReader in = new FileReader("naver.html");
    
    long startMilliSec = System.currentTimeMillis();
    
    char[] buf = new char[10000];
    int size = 0;
    while ((size = in.read(buf)) != -1) {
      System.out.print(".");
    }
    
    long endMilliSec = System.currentTimeMillis();
    System.out.println("\n" + (endMilliSec - startMilliSec));

    in.close();
  }
  
  public static void main01(String[] args) throws IOException {
    FileReader in = new FileReader("naver.html");
    
    long startMilliSec = System.currentTimeMillis();
    
    int ch;
    int count = 0;
    while ((ch = in.read()) != -1) {
      if ((++count % 10000) == 0) {
        System.out.print(".");
      }
    }
    
    long endMilliSec = System.currentTimeMillis();
    System.out.println("\n" + (endMilliSec - startMilliSec));

    in.close();
  }
}




















