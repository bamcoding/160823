package net.gondor;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.xml.crypto.dsig.spec.HMACParameterSpec;

public class MapTest {
	public static void main(String[] args) {
		Map<String, String> fruits = new HashMap<String, String>();
		fruits.put("banana","바나나");
		fruits.put("apple","사과");
		fruits.put("melon","멜론");
		
		System.out.println(fruits.get("banana"));
		System.out.println(fruits.get("apple"));
		System.out.println(fruits.get("grape"));	//존재하지 않는 키는 null을 리턴한다.
		
		boolean a =fruits.containsKey("banana");
		boolean b = fruits.containsValue("사과");
		System.out.println(a);
		System.out.println(b);
		
		fruits.clear();
		System.out.println(fruits.get("banana"));
		fruits.put("apple","사과");
		fruits.put("melon","멜론");
		
		fruits.remove("apple");
		fruits.remove("melon", "멜론");
		
		Map<String, List<String>> test = new HashMap<String, List<String>>();
		List<String> values = new ArrayList<String>();
		
		//그저 그런 방법
		test.put("abc", values);
		// 더 나은 방법
		test.put("abcd", new ArrayList<String>());
		
		test.get("abc").add("안녕1");
		test.get("abc").add("안녕2");
		test.get("abc").add("안녕3");
		test.get("abc").add("안녕4");
		for (int i = 0; i < test.get("abc").size(); i++) {
			System.out.println(test.get("abc").get(i));
		}
	}
}
