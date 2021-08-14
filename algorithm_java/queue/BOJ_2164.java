package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2164 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Queue<Integer> que = new LinkedList<>();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		
		for (int i = 1; i < n+1; i++) {
			que.add(i);
		}
		
		while (que.size()>2) {
			que.poll();//
			que.add(que.poll());
			
		}
		
		if(que.size() > 1) que.remove();
		
		System.out.println(que.peek());
		
	}

}
