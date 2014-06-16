package exam.oop3.step01;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MyWindowListener02 extends AbstractWindowListener {
  public void windowClosing(WindowEvent e) {
		System.out.println("windowClosing");
	  System.exit(0);
  }
}
