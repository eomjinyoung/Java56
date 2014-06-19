package exam.oop3.step05;

import java.io.FileWriter;
import java.io.IOException;

/* FileWriter
 * - 문자 데이터를 출력할 때 사용하는 클래스
 * 
 */
public class File04Out {

  public static void main(String[] args) throws IOException {
    FileWriter out = new FileWriter("file04.txt");
    
    out.write('가');
    out.write('A');
    /*
    char[] buf = new char[10];
    buf[0] = 'A';
    buf[1] = 'B';
    */
    //char[] buf = new char[]{'가','나','A','B'};
    out.write(new char[]{'가','나','A','B'});
    out.write(new String("가나다ABC123"));
    
    out.close();
  }

  
}















