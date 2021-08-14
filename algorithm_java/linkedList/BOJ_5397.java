package linkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class BOJ_5397 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < n; i++) {
			char[] input = br.readLine().toCharArray();

			LinkedList<Character> lnkList = new LinkedList<Character>();
			ListIterator<Character> listIter = lnkList.listIterator(); 
			
			for (int j = 0; j < input.length; j++) {
				char key = input[j];
				//System.out.println("key: "+key+ " nextIdx: "+listIter.nextIndex());
				
				if(key == '<') {
					if(listIter.hasPrevious()) listIter.previous(); 
				}else if(key == '>') {
					if(listIter.hasNext()) listIter.next();
				}else if(key == '-') {
					if(listIter.hasPrevious()) {
						listIter.previous();
						listIter.remove();
					}
				}else {
					listIter.add(key);
				}
			}
			lnkList.peek();
			lnkList.forEach(v-> sb.append(v));
			sb.append("\n");
			
		}
		
		
		System.out.println(sb.toString());
	}

}
