package exam.oop3.step04;

import java.util.ArrayList;
import java.util.Date;

/* ArrayList와 Generic
 */
public class GenericTest03 {
	public static void main(String[] args) {
		ArrayList list1 = new ArrayList();
		list1.add(new String("okok"));
		list1.add(new Date());
		list1.add(new Integer(10));
		
		String v1 = (String)list1.get(0);
		Date v2 = (Date)list1.get(1);
		Integer v3 = (Integer)list1.get(2);
		
		ArrayList<String> list2 = new ArrayList<String>();
		list2.add(new String("홍길동"));
		list2.add(new String("임꺽정"));
		//list2.add(new Date()); // 컴파일 오류 발생!
		
		String s1 = list2.get(0); // 자동 형변환
		String s2 = list2.get(1); // 자동 형변환
		
		
	}

}









