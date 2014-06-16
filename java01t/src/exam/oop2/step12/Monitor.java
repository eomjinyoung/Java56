package exam.oop2.step12;

public class Monitor {

	public void display(String contents) {
		System.out.println("-----------------------------");
	  System.out.println(contents);
	  System.out.println("-----------------------------");
  }

	public void mute() {
		for (int i = 0; i < 25; i++) {
			System.out.println();
		}
  }

}
