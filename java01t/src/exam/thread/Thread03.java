package exam.thread;

public class Thread03 {
  
  public static void main(String[] args) {
    Account account = new Account(10000000);
    
    ATM t1 = new ATM("강남", account);
    ATM t2 = new ATM("양재", account);
    ATM t3 = new ATM("종로", account);

    t1.start();
    t2.start();
    t3.start();
  } 

}
