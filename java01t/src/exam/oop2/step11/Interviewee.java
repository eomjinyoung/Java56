package exam.oop2.step11;

/* Interviewer와 인터뷰이 사이의 규칙 정의 
 * - hi(), bye()
 * - 인터페이스는 호출될 메서드의 규칙만 정의
 *   => 구현되어서는 안된다.
 */
public interface Interviewee {
	public abstract void hi();
	public abstract void bye();
}
