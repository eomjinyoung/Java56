package exam.oop2.step11;

/* 엄진영 인터뷰이는 Interviewee 규칙을 이행한다.
 * - 클래스가 인터페이스 규칙을 따른다는 것은 
 *   인터페이스에 선언된 모든 메서드를 구현한다는 의미.
 */

public class EomInterviewee implements Interviewee{
	public void hi() {
		System.out.println("오호라..안녕");
	}
	
	public void bye() {
		System.out.println("잘가!");
	}
}
