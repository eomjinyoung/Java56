package exam.oop2.step12;

public class Computer01 {
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
	  Computer01 computer = new Computer01();
	  computer.monitor = new Monitor();
	  
	  computer.start();
	  
	  Thread.currentThread().sleep(3000);
	  
	  computer.timeout();
	  
	  Thread.currentThread().sleep(3000);
	  
	  computer.wakeUp();
	  
  }
}











