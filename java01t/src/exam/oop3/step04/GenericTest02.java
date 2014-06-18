package exam.oop3.step04;

/* Generic 문법을 사용하여 특정 엔진만 장착되게 할 수 있다.
 * 엔진 값을 꺼낼 때 형변환을 자동화시킬 수 있다.
 * 
 * Generic 클래스를 사용하는 측의 이점
 * - 다루는 객체를 특정 타입으로 제한할 수 있다.
 * - 자동 형변환된다. 
 * 
 * Generic 클래스를 만드는 측의 이점
 * - 타입 별로 클래스를 만들 필요가 없다. => 코딩 절약!
 */
public class GenericTest02 {

	/* Generic 문법이 없다면 엔진 별로 Car 클래스를 생성해야 한다. */
	static class KiaEngineCar {
		KiaEngine engine;
		
		public void setEngine(KiaEngine engine) {
			this.engine = engine;
		}
		
		public KiaEngine getEngine() {
			return this.engine;
		}
	}
	
	static class HyundaiEngineCar {
		HyundaiEngine engine;
		
		public void setEngine(HyundaiEngine engine) {
			this.engine = engine;
		}
		
		public HyundaiEngine getEngine() {
			return this.engine;
		}
	}
	
	static class GMEngineCar {
		GMEngine engine;
		
		public void setEngine(GMEngine engine) {
			this.engine = engine;
		}
		
		public GMEngine getEngine() {
			return this.engine;
		}
	}
	
	// 위에서처럼 각 엔진 별로 Car를 만들기 싫다면 다음과 같이 Object 참조변수를 사용해야 한다.
	// => 대신, 해당 Car에 특정 엔진만 장착하게 할 수 없다. 
	// => 엔진 객체를 꺼낼 때 만다 형변환을 해야한다.
	static class GeneralCar {
		Object engine;
		
		public void setEngine(Object engine) {
			this.engine = engine;
		}
		
		public Object getEngine() {
			return this.engine;
		}
	}
	
	// 엔진의 타입을 변수화시킨다.
	static class Car<T> {
		T engine;
		
		public void setEngine(T engine) {
			this.engine = engine;
		}
		
		public T getEngine() {
			return this.engine;
		}
	}
	
	static class KiaEngine {}
	static class HyundaiEngine {}
	static class GMEngine {}
	
	public static void main(String[] args) {
		Car<KiaEngine> c1 = new Car<KiaEngine>();
		
		// 오로지 KiaEngine만 장착가능 <= 특정 객체로 제한할 수 있다.
		c1.setEngine(new KiaEngine());
		// 자동 형변환이 일어난다.
		KiaEngine e1 = c1.getEngine();
		
		// KiaEngine이 아니면 setEngine()에 값을 넣을 수 없다.
		// => 원치 않는 객체가 할당되는 것을 막을 수 있다.
		//c1.setEngine(new HyundaiEngine()); 
		//HyundaiEngine e2 = (HyundaiEngine)c1.getEngine();
		
		//c1.setEngine(new GMEngine());
		//GMEngine e3 = (GMEngine)c1.getEngine();
	}

}









