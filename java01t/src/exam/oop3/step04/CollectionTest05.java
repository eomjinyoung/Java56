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
 * Collection 인터페이스를 구현한 객체로부터 값 꺼내거나, 배열로부터 값을 꺼낼 때 
 * - for (타입 변수 : 컬렉션 또는 배열 객체) {
 *   }
 */
public class CollectionTest05 {

	public static void main(String[] args) {
		HashMap<String,String> map = new HashMap<String,String>(); // 데이터를 순서에 상관없이 관리한다.
		map.put("1010", "홍길동");
		map.put("2020", "임꺽정");
		map.put("3030", "장길산");
		map.put("4040", "장보고");
		
		displayEntryFromMap(map);
		displayKeysFromMap(map);
		displayValuesFromMap(map);
	}
	
	public static void displayValuesFromMap(HashMap<String,String> map) {
		System.out.println("----------------------------");
		for (String value : map.values()) {
			System.out.println(value);
		}
	}
	
	public static void displayKeysFromMap(HashMap<String,String> map) {
		System.out.println("----------------------------");
		for (String key : map.keySet()) {
			System.out.println(key + ":" + map.get(key));
		}
	}
	
	public static void displayEntryFromMap(HashMap<String,String> map) {
		System.out.println("----------------------------");
		for (Entry<String,String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
	}

}











