package exam.oop3.step06;

/* Score 클래스도 String 클래스처럼 
 * equals() 메서드가 인스턴스의 값을 비교하게 하자!
 * 
 * Object.equals()는 기본이 인스턴스가 같은지 여부를 비교함. => 주소 비교
 * => 인스턴스의 값이 같은지를 비교하려면 overriding 해야 한다.
 * => String 클래스는 Object로부터 상속받은 equals()를 오버라이딩 했기 때문에
 *    문자열이 같은지 비교하는 것이다.
 */
public class Object05 {

  static class Score /*extends Object*/{
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float average;
    
    @Override
    public String toString() {
      return "[" + name + "," + kor + "," + eng + "," + math + "]";
    }
    
    @Override
    public boolean equals(Object obj) {
      if (obj.getClass() != this.getClass()) return false;
      
      Score other = (Score) obj;
      
      if (!this.name.equals(other.name)) return false;
      
      if (this.kor != other.kor) return false;
      
      if (this.eng != other.eng) return false;
      
      if (this.math != other.math) return false;
      
      return true;
    }
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
    
    
    if (s1 != s2) {
      System.out.println("s1 <> s2: 주소 다르다");
    }
    
    if (s1.equals(s2)) {
      System.out.println("s1.equals(s2): 값은 같다");
    }
    
    System.out.println("해시값 비교-------------------------------------");
    System.out.println(Integer.toHexString(s1.hashCode()));
    System.out.println(Integer.toHexString(s2.hashCode()));
  }

}













