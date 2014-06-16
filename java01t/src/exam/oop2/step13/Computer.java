package exam.oop2.step13;

public class Computer {
	Monitor monitor;
	
	public void start() {
		monitor.display("부팅중......");
		monitor.display("메인화면");
	}
	
	public void timeout() {
		monitor.mute();
	}
	
	public void wakeUp() {
		monitor.display("이전화면..");
	}
	
	public static void main(String[] args) throws Exception {
	  Computer computer = new Computer();
	  
	  // Monitor 규칙을 준수하는 클래스의 인스턴스라면 
	  // monitor 변수에 인스턴스 주소를 할당할 수 있다.
	  // ==> 객체의 대체 가능 범위를 확장한 것! => 상속을 통한 대체 기법 보다 더 나은 방식
	  computer.monitor = new MyMonitor();
	  
	  computer.start();
	  
	  Thread.currentThread().sleep(3000);
	  
	  computer.timeout();
	  
	  Thread.currentThread().sleep(3000);
	  
	  computer.wakeUp();
	  
  }
}











