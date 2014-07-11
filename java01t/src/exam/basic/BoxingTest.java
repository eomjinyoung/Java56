package exam.basic;

/* Auto-boxing
 * => 상황에 따라 자바 기본 타입을 wrapper 객체로 자동 변환하는 것. => Boxing
 * => 상황에 따라 wrapper 객체를 자바 기본 타입으로 자동 변환하는 것. => Unboxing
 * 
 * wrapper 클래스란?
 * => 자바 기본 데이터를 클래스로 다룰 수 있도록 제공하는 유틸리티 클래스
 * => 
 * byte   : java.lang.Byte
 * short  : java.lang.Short
 * int    : java.lang.Integer
 * long   : java.lang.Long
 * float  : java.lang.Float
 * double : java.lang.Double
 * boolean: java.lang.Boolean
 * char   : java.lang.Character
 */
public class BoxingTest {

  public static void main(String[] args) {
    int i = 10;
    Integer obj1 = i;  // => new Integer(i) => boxing
    
    Integer obj2 = new Integer(20);
    int i2 = obj2; // => obj2.intValue() => unboxing
    
    Object obj3 = i; // => new Integer(i) => boxing
  }

}

















