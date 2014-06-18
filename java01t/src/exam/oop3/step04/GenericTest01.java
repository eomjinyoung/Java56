package exam.oop3.step04;

public class GenericTest01 {

	static class Car {
		Object engine;
		
		public void setEngine(Object engine) {
			this.engine = engine;
		}
		
		public Object getEngine() {
			return this.engine;
		}
	}
	
	static class KiaEngine {}
	static class HyundaiEngine {}
	static class GMEngine {}
	
	public static void main(String[] args) {
		Car c1 = new Car();
		
		c1.setEngine(new KiaEngine());
		KiaEngine e1 = (KiaEngine)c1.getEngine();
		
		c1.setEngine(new HyundaiEngine());
		HyundaiEngine e2 = (HyundaiEngine)c1.getEngine();
		
		c1.setEngine(new GMEngine());
		GMEngine e3 = (GMEngine)c1.getEngine();
		
		// Car에 다양한 타입의 엔진을 장착하기 위해 Object 참조 변수로 엔진을 가리킨다.
		// 문제점:
		// 1) 값을 꺼낼 때마다 매번 정확한 형식을 알려줘야 하나. => 형변환 => 귀찮다.
		// 2) Object 레퍼런스의 특성 상 어떤 타입의 객체라도 담을 수 있다.
		//			=> 특정 타입으로 제한할 수 없다.
		
	}

}









