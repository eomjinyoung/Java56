package exam.oop3.step04;

import java.util.Date;

public class MyArrayList {
	Object[] objs = new Object[1000];
	int size;
	
	public void add(Object obj) {
		objs[size++] = obj;
	}
	
	public Object get(int index) {
		return objs[index];
	}
	
	public static void main(String[] args) {
	  MyArrayList list = new MyArrayList();
	  list.add(new String("okok"));
	  list.add(new Score());
	  list.add(new Date());
	  
	  String name = (String)list.get(0);
	  System.out.println(name.substring(2));
	  
	  Score score = (Score)list.get(1);
	  
  }
}












