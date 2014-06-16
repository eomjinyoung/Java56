package exam.oop3.step02;

/* 이벤트 리스너를 inner class로 만들기 
 * - local inner class
 *   > 메서드 안에 클래스 선언.
 *   > 클래스가 선언된 메서드 안에서만 사용 가능.
 *   
 */

import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ScoreFrame  extends Frame {
	
	public ScoreFrame() {
		// 로컬 이너 클래스 
		class MyWindowListener4 extends WindowAdapter {
		  public void windowClosing(WindowEvent e) {
			  System.exit(0);
		  }
		}
			
		this.setTitle("비트 성적관리 시스템");
		this.setSize(400, 300);
		this.addWindowListener(new MyWindowListener4());
		
		this.setLayout(new FlowLayout());
		
		Label label = new Label("이름");
		// FlowLayout에서는 각 UI 컴포넌트의 x, y 좌표와 width, height를 무시한다.
		label.setBounds(20, 40, 40, 25); // x, y, width, height
		// FlowLayout에서 UI 컴포넌트의 크기를 설정하고 싶다면,
		// 다음과 같이 PreferredSize를 설정해야 한다.
		label.setPreferredSize(new Dimension(50, 40));
		this.add(label);
		
		TextField tf = new TextField(20);
		tf.setBounds(70, 40, 80, 25);
		tf.setPreferredSize(new Dimension(100, 40));
		this.add(tf);
		
		Button btn = new Button("추가");
		btn.setBounds(20, 80, 60, 25);
		btn.setPreferredSize(new Dimension(80, 40));
		this.add(btn);
		
		
	}

}






