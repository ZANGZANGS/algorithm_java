package z_coding.text.y2021.kmong;

import java.util.*;
import java.io.*;

public class SOL_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(new String[] {"pizza", "coke", "noodles"}, new String[] {"pizza", "noodles"}));
		System.out.println(solution(new String[] {"noodles", "pizza", "steak", "pizza", "salad"}, new String[] {"steak", "noodles", "pizza", "pizza"}));
		System.out.println(solution(new String[] {"noodles", "pizza", "steak", "pizza", "pizza"}, new String[] {"steak", "noodles", "pizza", "pizza"}));
	}
	
	private static String solution(String[] foods, String[] delivered) {

		String answer="";
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		for (String dvFood : delivered) {
			if(null == map.get(dvFood)) {
				map.put(dvFood, 1);
			}else {
				map.put(dvFood, map.get(dvFood)+1);
			}
		}
		
		for (String food : foods) {
			if(null == map.get(food) || 0 == map.get(food)) {
				answer = food;
				break;
			}else {
				map.put(food, map.get(food)-1);
			}
		}
		
		return answer;
	}

}
