package exam.oop3.step01;

/* 절대 좌표로 UI 컴포넌트 배치 
 * - 레이아웃 매니저를 설정하지 않는다. => setLayout(null);
 * - 각 UI 컴포넌트는 x, y, width, height 값을 가져야 한다. 
 */

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;

public class ScoreFrame02  extends Frame {
	
	public ScoreFrame02() {
		this.setTitle("비트 성적관리 시스템");
		this.setSize(400, 300);
		this.addWindowListener(new MyWindowListener());
		
		// UI 레이아웃 관리자를 고용하지 않는다. => 절대 좌표 배치
		this.setLayout(null);
		
		Label label = new Label("이름");
		label.setBounds(20, 40, 40, 25); // x, y, width, height
		this.add(label);
		
		TextField tf = new TextField(20);
		tf.setBounds(70, 40, 80, 25);
		this.add(tf);
		
		Button btn = new Button("추가");
		btn.setBounds(20, 80, 60, 25);
		this.add(btn);
	}

}






