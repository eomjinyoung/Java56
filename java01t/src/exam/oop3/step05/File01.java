package exam.oop3.step05;

import java.io.File;
import java.io.IOException;

/* File 클래스 활용
 * 
 */

public class File01 {

  public static void main(String[] args) throws IOException {
    File f = new File("../test.csv");
    
    if (f.exists()) {
      System.out.println("존재한다.!");
    }
    
    System.out.println("getAbsolutePath():" + f.getAbsolutePath());
    System.out.println("getCanonicalPath():" + f.getCanonicalPath());
    System.out.println("getName():" + f.getName());
    System.out.println("getPath():" + f.getPath()); 
    
    File f2 = new File("test2.txt");
    //f2.createNewFile();
    f2.delete();

  }

}











