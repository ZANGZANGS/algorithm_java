package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_10845 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		Queue<String> que = new LinkedList<>();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		
		String back = "";
		
		for (int i = 0; i < n; i++) {
			String[] input = bf.readLine().split(" ");
			
			if(input[0].equals("push")) {
				
				back = input[1];
				que.add(input[1]);
				
			}else if(input[0].equals("pop")) {
				System.out.println(que.isEmpty()? "-1" : que.poll());
			}else if(input[0].equals("size")) {
				System.out.println(que.size());
			}else if(input[0].equals("empty")) {
				System.out.println(que.isEmpty()? "1" : "0");
			}else if(input[0].equals("front")) {
				System.out.println(que.isEmpty()? "-1" : que.peek());
			}else if(input[0].equals("back")) {
				System.out.println(que.isEmpty()? "-1" : back);
			}
			
		}
	}

}
