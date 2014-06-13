package exam.oop3.step01;

/* 윈도우 이벤트 처리를 위한 WindowListener 사용
 * - 윈도우 이벤트가 발생했을 때 호출되는 메서드 규칙을 정한 것이다.
 * - 자바의 인터페이스 문법으로 정의했다.
 * - 인터페이스 문법
 *   interface 규칙이름 {
 *     메서드 시그너처;
 *     ...
 *   }
 * 
 */

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;

public class ScoreApp02 {

	public static void main(String[] args) {
		Frame f = new Frame();
		f.setTitle("비트 성적관리 시스템");
		f.setSize(400, 300);
		f.addWindowListener(new MyWindowListener());
		
		f.add(new Label("이름"));
		f.add(new TextField(20));
		f.add(new Button("추가"));
		
		f.setVisible(true);

	}

}









