package exam.oop2.step09;

import exam.oop2.step09.sub.A;

/* A 클래스와 다른 패키지에 있는 Test01에서 접근 */

public class Test01 {

	public static void main(String[] args) {
		A p = new A();
		p.a = 20;
		//p.b = 30; // 패키지가 달라서
		//p.c = 40; // 패키지도 다르고, 자식 클래스도 아님
		//p.d = 50; // 비공개
		
		p.m1();
		//p.m2(); // default
		//p.m3(); // protected
		//p.m4(); // private 
		
	}

}












