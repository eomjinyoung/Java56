package exam.thread;

/* 스레드?
 * - 독립적으로 수행하고 싶은 명령어들을 묶어 놓은 것.
 * 스레드 준비
 * 1) Thread 클래스를 상속 받고, run() 메서드를 오버라이딩 한다.
 *    run() 메서드에 독립적으로 실행할 코드를 넣는다.
 * 2) Runnable 인터페이스를 구현한다. run() 메서드를 오버라이딩 한다.
 *    run() 메서드에 독립적으로 실행할 코드를 넣는다.
 */

public class Thread01 {

  // 스레드 생성 방법 1)
  static class MyThread extends Thread {
    @Override
    public void run() {
      System.out.println("반복문 1.---------------------------");
      
      for (int i = 0; i < 10000; i++) {
        System.out.println("1 => " + i);
      }
    }
  }
  
  // 스레드 생성 방법 2)
  // - 스레드에 의해 실행될 코드를 정의한다. 
  // - 실행은 Thread 객체를 통해 실행한다.
  //   => Thread가 호출할 run() 메서드를 갖고 있다.
  //   => Runnable 규칙에 따라 작성된 run() 메서드를 갖고 있다.
  // - 스레드를 상속 받지 않기 때문에 이 방법을 많이 사용한다.
  //   => 다른 클래스를 상속 받을 수 있기 때문이다.
  static class MyThread2 implements Runnable {
    @Override
    public void run() {
      System.out.println("반복문 1.---------------------------");
      
      for (int i = 0; i < 10000; i++) {
        System.out.println("1 => " + i);
      }
    }
  }
  
  //스레드 사용 후
 public static void main(String[] args) {
   // Runnable 구현체를 스레드로 실행 
   Thread t1 = new Thread(new MyThread2()); // 생성자에 Runnable 구현체를 넘긴다.
   t1.start();
   
   System.out.println("반복문 2.---------------------------");
   
   for (int i = 0; i < 10000; i++) {
     System.out.println("2 : " + i);
   }

 }
 
  // 스레드 사용 후
  public static void main02(String[] args) {
    // 스레드 실행 
    MyThread t1 = new MyThread();
    t1.start();
    
    System.out.println("반복문 2.---------------------------");
    
    for (int i = 0; i < 10000; i++) {
      System.out.println("2 : " + i);
    }

  }
  
  // 스레드 사용 전
  public static void main01(String[] args) {
    System.out.println("반복문 1.---------------------------");
    
    for (int i = 0; i < 10000; i++) {
      System.out.println("1 => " + i);
    }
    
    System.out.println("반복문 2.---------------------------");
    
    for (int i = 0; i < 10000; i++) {
      System.out.println("2 : " + i);
    }

  }

}







