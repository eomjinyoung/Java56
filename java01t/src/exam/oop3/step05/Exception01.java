package exam.oop3.step05;

/* 예외처리
 * - 오류가 발생했을 때 시스템의 실행을 멈추지 않게 하는 문법
 * - 즉, 오류가 발생하면 적절한 조치를 취한 후 계속 실행하게 한다.
 */
public class Exception01 {

  // before 예외처리
  // - 예외처리 문법이 없을 때는 
  //   작업을 수행하다가 예외 상황이 발생했을 때 리턴값으로 호출자에게 알렸다.
  //   문제는! 그 리턴 값이 정상적인 계산 결과일 수 있다는 것이다.
  public static int divide(int a, int b) { 
    if (b == 0)
      return -999999;
    
    return a / b; 
  }
  
  public static void main(String[] args) {
    int result = divide(999999, -1);
    
    // 항상 메서드의 리턴 값을 조사해야만 했다.
    if (result != -999999) { 
      System.out.println(result);
    } else {
      System.out.println("0으로 나눌 수 없습니다.");
    }
    
  }

}











