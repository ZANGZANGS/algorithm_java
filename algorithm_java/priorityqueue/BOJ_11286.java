package priorityqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
/**
 * @source		: 백준
 * @algorithm	: 우선순위 큐
 * @description	: 절댓값 힙
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2022.01.10	성공
 */
public class BOJ_11286 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pQ = new PriorityQueue<>((a,b)-> {
			if(Math.abs(a)==Math.abs(b)) {
				return a-b;
			}
			return Math.abs(a)-Math.abs(b);
		});
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(br.readLine());
						
			if(tmp == 0) {
				if(pQ.isEmpty()) {
					sb.append(0);
				}else {
					sb.append(pQ.poll());
				}
				sb.append("\n");
			}else {
				pQ.add(tmp);
			}

		}
		
		System.out.println(sb.toString());
		
	}

}
