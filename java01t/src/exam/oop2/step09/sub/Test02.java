package exam.oop2.step09.sub;

import exam.oop2.step09.sub.A;

/* A 클래스와 같은 패키지에 있는 Test02에서 접근 */

public class Test02 {

	public static void main(String[] args) {
		A p = new A();
		p.a = 20;
		p.b = 30;
		p.c = 40; 
		//p.d = 50; // 비공개
		
		p.m1();
		p.m2(); // default
		p.m3(); // protected
		//p.m4(); // private 
		
	}

}












