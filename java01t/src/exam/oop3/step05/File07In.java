package exam.oop3.step05;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/* FileInputStream을 사용하여 숫자 읽기
 * - 1바이트씩만 읽을 수 있다. 바이트 배열을 사용할 수도 있다.
 * 
 * DataInputStream
 * - 바이트 배열을 읽어서 기본 데이터형으로 값을 변환하여 리턴한다.
 */
public class File07In {
  // 데이터 프로세싱 스트림 클래스 도입
  // - DataInputStream의 readXXX() 사용하여 값 읽기
  public static void main(String[] args) throws IOException {
    FileInputStream in = new FileInputStream("file07_x.dat");
    DataInputStream in2 = new DataInputStream(in);
    
    int kor = in2.readInt();
    int eng = in2.readInt();
    int math = in2.readInt();
    
    in2.close();
    in.close();
    
    System.out.println(kor);
    System.out.println(eng);
    System.out.println(math);
  }
  
  public static void main01(String[] args) throws IOException {
    FileInputStream in = new FileInputStream("file07.dat");
    
    int kor = 0, eng = 0, math = 0;
    
    kor = kor | in.read() << 24;
    kor |= in.read() << 16;
    kor |= in.read() << 8;
    kor |= in.read();
    
    eng |= in.read() << 24;
    eng |= in.read() << 16;
    eng |= in.read() << 8;
    eng |= in.read();
    
    math |= in.read() << 24;
    math |= in.read() << 16;
    math |= in.read() << 8;
    math |= in.read();
    
    in.close();
    
    System.out.println(kor);
    System.out.println(eng);
    System.out.println(math);
  }

}














