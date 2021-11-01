package z_coding.test.y2021.nf;

import java.util.*;
import java.io.*;

public class SOL_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a =solution(new String[] {"A B C D", "A D", "A B D", "B D"},2);

		System.out.println(a);
	}
	
	public static int solution(String[] id_list, int k) {
        int answer = 0;
        
        Map<String, Integer> map = new HashMap<String, Integer>();
        
        for (String content : id_list) {
        	String[] temp = content.split(" ");
        	
        	Set<String> set = new HashSet<String>();
        	
        	for (String st : temp) {
        		set.add(st);
			}
        	
        	for (String name : set) {
        		
        		if(!map.containsKey(name)) { //첫구매
        			map.put(name, 1);
        		}else {
        			map.put(name, map.get(name)+1);
        		}

			}
        	
			
		}
        
        for (Integer buyCnt : map.values()) {
        	answer += buyCnt > k ? k : buyCnt;
		}
        
        
        return answer;
    }

}
