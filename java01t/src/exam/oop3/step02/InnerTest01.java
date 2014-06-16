package exam.oop3.step02;

import javax.swing.text.AbstractDocument;

// Top level inner class 사용 전!
class Layout {
	public static final int main_layout = 1;
	public static final int input_window_layout = 2;
}

class Icon {
	public static final String icon16x16 = "a.png";
	public static final String icon64x64 = "b.png";
	public static final String icon128x128 = "c.png";
}

class Label {
	public static final String hello = "안녕하세요";
	public static final String title = "비트 성적관리 시스템";
}

class ResourceX {
	static Layout layout;
	static Icon icon;
	static Label label;
}

//Top level inner class 사용 후!
// package member class
class Resource {
	// Top level inner class
	public static class layout {
		public static final int main_layout = 1;
		public static final int input_window_layout = 2;
	}
	
	public static class icon {
		public static final String icon16x16 = "a.png";
		public static final String icon64x64 = "b.png";
		public static final String icon128x128 = "c.png";
	}
	
	public static class label {
		public static final String hello = "안녕하세요";
		public static final String title = "비트 성적관리 시스템";
	}
}

public class InnerTest01 {
	public static void main(String[] args) {
		// OGNL(Object Graph Navigation Language)
		// - 자바 프로퍼티의 값을 꺼내고 설정하는 문법
		// 일반 클래스로 OGNL 흉내 내기
		System.out.println(ResourceX.layout.main_layout);
		System.out.println(ResourceX.icon.icon128x128);
		System.out.println(ResourceX.label.hello);
		
		// top level inner class
		// - OGNL 표기법을 흉내 낼 수 있다. 
		// - 작은 클래스들을 묶을 때 사용.
		System.out.println(Resource.layout.main_layout);
		System.out.println(Resource.icon.icon128x128);
		System.out.println(Resource.label.hello);

	}

}








