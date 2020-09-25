package mission_johyein;

import java.util.ArrayList;
import java.util.HashMap;

public class testJava {
	public static void main(String[] args) {
		
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		map.put("a", 1);
		map.put("b", 1);
		
		ArrayList<String> arr = keyOfValue(map, 1);
		System.out.println(arr);
		
	}
	
	public static ArrayList<String> keyOfValue(HashMap<String,Integer> map, int value) {
		
		ArrayList<String> arr = new ArrayList<String>();
		for(String key : map.keySet()) {
			if (value==map.get(key)) {
				arr.add(key);
				
			}
		}
		return arr;
	}
}
