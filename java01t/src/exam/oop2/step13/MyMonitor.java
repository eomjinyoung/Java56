package exam.oop2.step13;

/* 인터페이스 구현
 * - 인터페이스에 선언된 메서드를 모두 구현해야 한다.
 * - 하나의 클래스는 여러 개의 인터페이스를 구현할 수 있다.
 */

public class MyMonitor implements Monitor {

	public void display(String contents) {
		System.out.println(">>" + contents);

	}

	public void mute() {
		for (int i = 0; i < 25; i++) {
			System.out.println();
		}
	}

}







