/* 기본 생성자
 * - 생성자를 선언하지 않으면 컴파일러가 자동으로 기본 생성자를 추가한다.
 * - 기본 생성자란?
 *   파라미터가 없는 생성자
 * - 모든 클래스는 반드시 하나 이상의 생성자가 있어야 한다.
 */
package exam.oop;

public class Score3  {
	String name;
	int kor;
	int eng;
	int math;
	int total;
	float average;
	
	// 기본 생성자 -> 기본 생성자가 없으면 컴파일러가 자동으로 만든다.
	// public Score3() {}
	
	/*
	public Score3() {
		System.out.println("오호라.. 기본 생성자 호출...");
	}*/
}











