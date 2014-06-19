package exam.oop3.step05;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* FileOutputStream을 사용하여 숫자 출력
 * - 다양한 크기의 숫자를 출력하기 위해서는 비트 이동 연산자를 사용해야 하는 불편함이 있다.
 * 
 * DataOutputStream : 기본 데이터형의 값을 바이트 배열로 변환해주는 도우미 클래스 
 * - writeXXX();
 */

public class File07Out {

  // 데이터 프로세싱 스트림 클래스 도입 
  // - 기본 데이터형의 값을 바이트 배열로 쉽게 바꿀 수 있다.
  public static void main(String[] args) throws IOException {
    FileOutputStream out = new FileOutputStream("file07_x.dat");
    DataOutputStream out2 = new DataOutputStream(out);
    
    int kor = 980; // 0x03d4
    int eng = 300; // 0x012c
    int math = 550; // 0x0226
    
    out2.writeInt(kor);
    out2.writeInt(eng);
    out2.writeInt(math);
   
    out2.close();
    out.close();
  }
  
  public static void main01(String[] args) throws IOException {
    FileOutputStream out = new FileOutputStream("file07.dat");
    
    int kor = 980; // 0x03d4
    int eng = 300; // 0x012c
    int math = 550; // 0x0226
    
    /* 1) 마지막 바이트만 출력되기 때문에 데이터가 정확하게 저장되지 않는다. */
    /*
    out.write(kor); // 마지막 1바이트 출력
    out.write(eng);
    out.write(math);
    */
    
    /* 2) 비트 이동 연산자를 통해 모든 바이트를 정확하게 저장한다.*/
    out.write(kor >> 24); // 첫번째 바이트 
    out.write(kor >> 16); // 두번째 바이트 
    out.write(kor >> 8); // 세번째 바이트 
    out.write(kor); // 네번째 바이트 
    
    out.write(eng >> 24);
    out.write(eng >> 16);
    out.write(eng >> 8);
    out.write(eng);
    
    out.write(math >> 24);
    out.write(math >> 16);
    out.write(math >> 8);
    out.write(math);
    
    out.close();
  }

}











