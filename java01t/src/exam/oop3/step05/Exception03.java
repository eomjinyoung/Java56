package exam.oop3.step05;

/* 예외처리 - 
 */
public class Exception03 {

  // 상황1. 가벼운 오류 발생
  // - 메서드 내에서 처리한다.
  public static void 청소하라() {  
    try {
      // 청소를 수행하다가 변기에 똥 묻은 경우가 발생되다.
      throw new Throwable("변기에 똥 묻다.");
    } catch (Throwable e) {
      System.out.println(e.getMessage());
      System.out.println("닦는다.");
    }
  }
  
  //상황2. 치명적인 오류 발생
  // - 메서드 호출자에게 보고하라!
  public static void 청소하라2() throws Throwable {    
    // 청소를 수행하다가 화장실 변기 깨졌다.
    throw new Throwable("변기 깨짐.");
  }
  
  public static void 청소하라3() throws Throwable {    
    try {
      // 청소를 수행하다가 화장실 불난것 발견
      throw new Throwable("화장실 불났으~~~");
      
    } catch (Throwable e) {
      System.out.println("불끈다..");
      throw e; // 보고한다.
    }
  }
  
  public static void main(String[] args) {
    청소하라();
   
    try {
      청소하라2();
    } catch (Throwable e) {
      System.out.println("외부업체에 의뢰하여 변기 고침");
    }
    
    try {
      청소하라3();
    } catch (Throwable e) {
      System.out.println("누가 불냈는지... CCTV를 조사한다.");
    }
  }

}











