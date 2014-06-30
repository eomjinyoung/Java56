package exam.thread;

public class Account {
  long balance;
  
  public Account(long balance) {
    this.balance = balance;
  }
  
  // 여러 스레드가 메서드를 동시에 수행하면
  // => 공유 메모리에 접근 시에 값을 덮어쓰는 문제가 발생한다.
  // 여러 스레드가 접근했을 때 문제가 발생하는 코드들
  // => 스레드에 안전하지 않는 코드 영역
  // => "Critical Section(임계 구역)"
  //    => 여러 스레드가 동시에 접근하지 말아야 할 코드 영역.
  // Critical Section이 올바르게 실행되도록 하는 방법?
  // => 스레드 안전(Thread Safe)하게 하는 방법?
  // => 한 번에 한 스레드만이 임계 구역에 진입하게 한다.
  //    진입한 스레드는 locking. 
  //    임계 구역을 실행 완료한 후 unlocking.
  //    "Mutex" 
  // Semaphore(세마포어)
  // => 임계 구역에 진입할 수 있는 스레드 수가 1이상 일 때 
  // MUTEX(뮤텍스)
  // => 임계 구역에 진입할 수 있는 스레드 수는 1만 가능.
  synchronized public long withdraw(long money) {
    long temp = this.balance;
    if ((temp - money) >= 0) {
      temp = temp - money;
      // 시간을 지연시키기 위한 코드 
      // => CPU 사용권을 뺏기게 할려고 
      long x = (long)(Math.random() * 50) + 1;
      for (long i = 0; i < x; i++) {
        double d = i * 3.14159 / 0.345676;
      }
      // 
      this.balance = temp;
      return money;
    }
    
    return 0;
  }
}







