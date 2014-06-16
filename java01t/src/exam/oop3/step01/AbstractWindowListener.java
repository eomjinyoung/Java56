package exam.oop3.step01;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/* 추상 클래스의 활용
 * - 추상 클래스는 공통 기능을 서브 클래스에 상속해주기 위해 존재
 * - WindowListener 인터페이스의 메서드 구현을 서브 클래스에 상속해주기 위해 
 *   다음 클래스를 작성한다.
 * - 추상 클래스는 인스턴스를 생성할 수 없다.
 * - 추상 클래스는 추상 메서드를 가질 수 있다. => 일반 클래스는 추상 메서드를 갖지 못한다.
 */

public abstract class AbstractWindowListener 
		implements WindowListener {
	public void windowOpened(WindowEvent e) {}
  public void windowClosing(WindowEvent e) {}
  public void windowClosed(WindowEvent e) {}
  public void windowIconified(WindowEvent e) {}
  public void windowDeiconified(WindowEvent e) {}
  public void windowActivated(WindowEvent e) {}
  public void windowDeactivated(WindowEvent e) {}
}

















