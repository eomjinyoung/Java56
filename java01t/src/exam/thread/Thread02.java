package exam.thread;

public class Thread02 {

  public static void main(String[] args) {
    Thread main = Thread.currentThread();
    System.out.println(main.getName());
    
    ThreadGroup mainGroup = main.getThreadGroup();
    System.out.println(mainGroup.getName());
    
    ThreadGroup systemGroup = mainGroup.getParent();
    System.out.println(systemGroup.getName());

    /* 자식 스레드 그룹 목록 얻기 */
    /*
    ThreadGroup[] groupList = new ThreadGroup[50];
    int count = mainGroup.enumerate(groupList, false);
    for (int i = 0; i < count; i++) {
      System.out.println(groupList[i].getName());
    }
    */
    
    Thread t2 = new Thread("okok");
    t2.start();
    
    // 그룹에 소속된 스레드 목록 얻기 
    System.out.println("System TG ----------------------");
    Thread[] threadList = new Thread[50];
    int count = systemGroup.enumerate(threadList, false);
    for (int i = 0; i < count; i++) {
      System.out.println(threadList[i].getName());
    }
    
    System.out.println("Main TG ----------------------");
    count = mainGroup.enumerate(threadList, false);
    for (int i = 0; i < count; i++) {
      System.out.println(threadList[i].getName());
    }
    
  }

}










