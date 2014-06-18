package exam.oop3.step04;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;

/* Collection API 
 * - 값 목록을 다루는 객체
 * 
 * Queue
 * - 데이터 목록 다루는 것.
 * - 먼저 들어간 데이터가 먼저 나온다. (First In First Out)
 * - add() / poll()
 */
public class CollectionTest07 {

	public static void main(String[] args) {
		PriorityQueue<String> queue = new PriorityQueue<String>(); 
		queue.add("111");
		queue.add("222");
		queue.add("333");
		queue.add("444");
		
		System.out.println("--------------------------");
		for (String value : queue) {
			System.out.println(value);
		}
		
		// poll() => 제일 처음 추가한 값을 꺼낸다. (꺼낸 값은 큐에서 삭제한다)
		System.out.println("--------------------------");
		while(!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
		
	}
	
	

}











