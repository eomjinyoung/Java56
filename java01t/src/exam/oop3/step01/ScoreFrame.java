package exam.oop3.step01;

/* FlowLayout 배치 관리자 사용 
 * - Panel의 기본 레이아웃 관리자 => Frame에서 사용하려면 다음과 같이 명시적으로 설정해야 한다.
 *   setLayout(new FlowLayout());
 * - 왼쪽에서 오르쪽으로 배치하고, 오른쪽에 더이상 배치할 수 없으면 다음 라인에 배치한다.
 * - 컴포넌트의 x, y 좌표는 무시한다.
 * - 컴포너트의 너비, 높이 정보는 PreferedSize를 사용한다.
 */

import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;

public class ScoreFrame  extends Frame {
	
	public ScoreFrame() {
		this.setTitle("비트 성적관리 시스템");
		this.setSize(400, 300);
		this.addWindowListener(new MyWindowListener());
		
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






