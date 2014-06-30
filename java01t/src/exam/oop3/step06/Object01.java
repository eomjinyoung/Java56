package exam.oop3.step06;

public class Object01 {

  static class Score /*extends Object*/{
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float average;
  }
  
  public static void main(String[] args) {
    Score s1 = new Score();
    s1.name = "홍길동";
    s1.kor = 100;
    s1.eng = 100;
    s1.math = 100;
    
    Score s2 = new Score();
    s2.name = "홍길동";
    s2.kor = 100;
    s2.eng = 100;
    s2.math = 100;
    
    System.out.println(s1.toString()); 
    System.out.println(s2.toString()); 
    
    /* Object.toString()
     * - 클래스 이름(+패키지명)@인스턴스ID(해시코드)
     */
    
    System.out.println(s1); // println()은 내부에서 s1의 toString() 호출함.
    System.out.println(s2); // 
    
    /* Object.hashCode()
     * - 인스턴스를 구분하는 아이디 값 리턴 
     */
    System.out.println(Integer.toHexString(s1.hashCode()));
    System.out.println(Integer.toHexString(s2.hashCode()));
  }

}













