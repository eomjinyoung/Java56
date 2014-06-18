package exam.oop3.step04;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

/* Collection API 
 * - 값 목록을 다루는 객체
 * 
 * Generic
 * - 넣고 뺄 데이터의 타입을 지정할 수 있다.
 *   => 값을 꺼낼 때 형변환 할 필요가 없다.
 *   => 값을 넣을 때 지정된 타입만 넣을 수 있다. 넣을 값을 데이터 타입을 제한!
 */
public class CollectionTest05 {

	public static void main(String[] args) {
		HashMap<String,String> map = new HashMap<String,String>(); // 데이터를 순서에 상관없이 관리한다.
		map.put("1010", "홍길동");
		map.put("2020", "임꺽정");
		map.put("3030", "장길산");
		map.put("4040", "장보고");
		//map.put("5050", new Date());
		
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











