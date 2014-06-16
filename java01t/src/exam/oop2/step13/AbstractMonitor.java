/* 인터페이스 대신 추상 클래스를 사용한다면?
 * - 못은 사람의 이마(차력사)로도 박을 수 있다.
 * - 못은 삽으로 박을 수 있다.
 * - 못은 돌맹이로도 박을 수 있다.
 * - 규칙은 인터페이스, 공통 기능 상속은 추상 클래스 
 */
package exam.oop2.step13;

public abstract class AbstractMonitor {
	public static final int TYPE_DSUB = 1;
	public static final int TYPE_DVI = 2;
	public static final int	TYPE_HDMI = 3;
	
	public abstract void display(String contents);
	public abstract void mute();
	public void m() {} // 추상 클래스는 일반 메서드도 가질 수 있다.
}












