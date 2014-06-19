package exam.oop3.step05;

import java.io.File;
import java.io.FilenameFilter;

/* 디렉토리 다루기 */
public class File02 {

  public static void main(String[] args) {
    File f = new File("c:\\");
    
    if (f.isDirectory()) {
      System.out.println("디렉토리다!");
    }
    
    System.out.println("디렉토리와 파일을 모두 출력--------------"); 
    for (String name : f.list()) {
      System.out.println(name);
    }
    
    System.out.println("디렉토리만 출력-------------------------");
    class DirectoryFilter implements FilenameFilter {
      public boolean accept(File dir, String name) {
        //File f = new File(dir.getAbsolutePath() + "\\" + name);
        /*File f = new File(dir, name);
        if (f.isDirectory()) {
          
        }*/
        if ( new File(dir, name).isDirectory() ) return true;
        else return false;
      }
    }
    for (String name : f.list(new DirectoryFilter())) {
      System.out.println(name);
    }
    
    
    System.out.println("(실무)디렉토리만 출력-------------------------");
    for (String name : f.list( new FilenameFilter() {
        public boolean accept(File dir, String name) {
          if ( new File(dir, name).isDirectory() ) return true;
          else return false;
        }
      } )) {
      System.out.println(name);
    }
    
    System.out.println("listFiles() 사용 ------------------------");
    

  }

}












