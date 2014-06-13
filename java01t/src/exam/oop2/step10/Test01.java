package exam.oop2.step10;

/* 캡슐화가 왜 필요한가?
 * - 추상화의 의미와 관련없는 무효한 데이터의 입력을 제한하는 문법.
 * - 추상화를 무너뜨리지 않기 위해.
 * - 유효하지 않은 값이 들어가면 추상화의 의미가 퇴색된다.
 */

public class Test01 {

	public static void main(String[] args) {
		Customer c = new Customer();
		c.name = "홍길동";
		c.tel = "010-1111-2222";
		//c.age = 300;
		//c.height = 400;
		//c.weight = 800;
		c.setAge(300);
		c.setHeight(400);
		c.setWeight(800);
		
		System.out.println(c.getAge());
		System.out.println(c.getHeight());
		System.out.println(c.getWeight());
		
	}

}









