package priorityqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
/**
 * @source		: 백준
 * @algorithm	: 우선순위 큐
 * @description	: 카드 정렬하기
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2022.01.10	성공
 */
public class BOJ_1715 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Long> pQ = new PriorityQueue<>();
		int count = 0;
		
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			pQ.add(Long.parseLong(br.readLine()));
		}
		
		while (pQ.size()>1) {
			
			long num = pQ.poll() + pQ.poll();
			
			count += num;

			pQ.add(num);
			
		}
		
		System.out.println(count);
		
	}

}
