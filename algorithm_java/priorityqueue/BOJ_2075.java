package priorityqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/**
 * @source		: 백준
 * @algorithm	: 우선순위 큐
 * @description	: N번째 큰 수
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2022.01.11	성공
 */
public class BOJ_2075 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pQ = new PriorityQueue<>();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken()); 
				pQ.add(num);
				if(pQ.size()>N) pQ.poll();
			}
		}
		System.out.println(pQ.poll());
	}
}