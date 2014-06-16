package exam.oop3.step03;

/* 성적 등록 폼 만들기
 * - Panel 사용 
 *   > 여러 개의 UI 컴포넌트를 묶을 때 사용하는 윈도우 
 */

import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ScoreFrame  extends Frame {
	
	public ScoreFrame() {
		this.setTitle("비트 성적관리 시스템");
		this.setSize(400, 300);
		
		this.addWindowListener(new WindowAdapter() {
		  public void windowClosing(WindowEvent e) {
			  System.exit(0);
		  }
		});
		
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		this.add( createTextInputPanel("이름", 20) );
		this.add( createTextInputPanel("국어", 5) );
		this.add( createTextInputPanel("영어", 5) );
		this.add( createTextInputPanel("수학", 5) );
		
		Button btn = new Button("추가");
		btn.setPreferredSize(new Dimension(80, 40));
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 과제
				System.out.println("이름, 국어, 영어, 수학 입력 값을 출력하라!");
				
			}
		});
		
		this.add(btn);
		
		
	}
	
	private Panel createTextInputPanel(String title, int textSize) {
		// Panel의 기본 레이아웃 매니저 => FlowLayout(FlowLayout.CENTER)
		Panel panel = new Panel(); 
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel.setPreferredSize(new Dimension(300, 25));
		
		Label label = new Label(title);
		label.setPreferredSize(new Dimension(50, 25));
		panel.add(label);
		
		TextField tf = new TextField(textSize);
		panel.add(tf);
		
		return panel;
	}

}



















