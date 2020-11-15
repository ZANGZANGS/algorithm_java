package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;


public class BOJ_10866 {

	public static void main(String[] args) throws IOException {
		
		Deque<Integer> deque = new LinkedList<Integer>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int round = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < round; i++) {
			String commend = br.readLine();
			String cmd = commend.split(" ")[0];
			switch (cmd) {
			
			case "push_front":
				deque.addFirst(Integer.parseInt(commend.split(" ")[1]));
				break;
			
			case "push_back":
				deque.addLast(Integer.parseInt(commend.split(" ")[1]));
				break;
			
			case "pop_front":
				if(deque.isEmpty()) {
					System.out.println(-1);
				}else {
					System.out.println( deque.pollFirst());
				}
				break;
				
			case "pop_back":
				if(deque.isEmpty()) {
					System.out.println(-1);
				}else {
					System.out.println( deque.pollLast());
				}
				break;
				
			case "size":
				System.out.println( deque.size());
				break;
				
			case "empty":
				if(deque.isEmpty()) {
					System.out.println( 1);
				}else {
					System.out.println( 0);
				}
				break;
				
			case "front":
				if(deque.isEmpty()) {
					System.out.println( -1);
				}else {
					System.out.println(deque.peekFirst());
				}
				break;
				
			case "back":
				if(deque.isEmpty()) {
					System.out.println(-1);
				}else {
					System.out.println(deque.peekLast());
				}
				break;
			
			default:
				break;
			}
		}
		
		
	}
	
}
