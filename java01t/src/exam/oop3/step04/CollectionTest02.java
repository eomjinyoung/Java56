package exam.oop3.step04;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

/* Collection API 
 * - 값 목록을 다루는 객체
 * 
 * HashMap / Hashtable
 * - 인스턴스의 주소들을 key-value 형식으로 다룬다.
 * - 키를 사용하여 값을 조회한다.
 * - HashMap은 키와 값에 대해 null을 허용한다.
 * - Hashtable은 키와 값이 null이 될 수 없다. 동기화 지원,
 */
public class CollectionTest02 {

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
		Collection coll = map.values();
		Object[] list = coll.toArray();
		
		String value;
		for (int i = 0; i < list.length; i++) {
			value = (String)list[i];
			System.out.println(value);
		}
	}
	
	public static void displayKeysFromMap(HashMap map) {
		System.out.println("----------------------------");
		Set set = map.keySet();
		Object[] list = set.toArray();
		String key;
		for (int i = 0; i < list.length; i++) {
			key = (String)list[i];
			System.out.println(key + ":" + map.get(key));
		}
	}
	
	public static void displayEntryFromMap(HashMap map) {
		System.out.println("----------------------------");
		Set set = map.entrySet();
		Object[] list = set.toArray();
		
		Entry entry;
		for (int i = 0; i < list.length; i++) {
			entry  = (Entry)list[i];
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
	}

}











