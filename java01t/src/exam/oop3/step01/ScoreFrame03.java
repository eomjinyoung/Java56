package exam.oop3.step01;

/* BorderLayout 배치 관리자 사용 
 * - Frame의 기본 레이아웃 관리자 => 별도로 설정할 필요가 없다.
 * - 동/서/남/북/가운데
 * - add(UI컴포넌트, 위치정보); 
 */

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;

public class ScoreFrame03  extends Frame {
	
	public ScoreFrame03() {
		this.setTitle("비트 성적관리 시스템");
		this.setSize(400, 300);
		this.addWindowListener(new MyWindowListener());
		
		Label label = new Label("이름");
		// BorderLayout에서는 각 UI 컴포넌트의 x, y 좌표와 width, height를 무시한다.
		label.setBounds(20, 40, 40, 25); // x, y, width, height
		this.add(label, BorderLayout.NORTH);
		
		TextField tf = new TextField(20);
		tf.setBounds(70, 40, 80, 25);
		this.add(tf, BorderLayout.CENTER);
		
		Button btn = new Button("추가");
		btn.setBounds(20, 80, 60, 25);
		this.add(btn, BorderLayout.SOUTH);
	}

}






