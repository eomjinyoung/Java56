 package exam.oop3.step04;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

/* Collection API 
 * - 값 목록을 다루는 객체
 * 
 * Map의 도우미 Iterator 소개
 * - Iterator는 Map의 데이터를 꺼내 주는 역할을 한다.
 * - 컬렉션의 종류(List, Set, Map)에 상관없이 일관된 방식으로 데이터를 조회할 수 있다.
 *   hasNext(), next()
 */
public class CollectionTest03 {

	public static void main(String[] args) {
		HashMap map = new HashMap(); // 데이터를 순서에 상관없이 관리한다.
		map.put("1010", "홍길동");
		map.put("2020", "임꺽정");
		map.put("3030", "장길산");
		map.put("4040", "장보고");
		
		displayEntryFromMap(map);
		displayKeysFromMap(map);
		displayValuesFromMap(map);
	}
	
	public static void displayValuesFromMap(HashMap map) {
		System.out.println("----------------------------");
		Iterator iterator = map.values().iterator();

		String value;
		while (iterator.hasNext()) {
			value = (String)iterator.next();
			System.out.println(value);
		}
	}
	
	public static void displayKeysFromMap(HashMap map) {
		System.out.println("----------------------------");
		Iterator iterator = map.keySet().iterator();
		
		String key;
		while (iterator.hasNext()) {
			key = (String)iterator.next();
			System.out.println(key + ":" + map.get(key));
		}
	}
	
	public static void displayEntryFromMap(HashMap map) {
		System.out.println("----------------------------");
		Iterator iterator = map.entrySet().iterator();
		
		Entry entry;
		while (iterator.hasNext()) {
			entry  = (Entry)iterator.next();
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
	}

}











