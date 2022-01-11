package priorityqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/**
 * @source		: 백준
 * @algorithm	: 우선순위 큐
 * @description	: 파일 합치기 3
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2022.01.11	성공
 */
public class BOJ_13975 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			long totalCost = 0;
			int K = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			PriorityQueue<Long> pQ = new PriorityQueue<Long>();
			
			for (int j = 0; j < K; j++) {
				pQ.add(Long.parseLong(st.nextToken()));				
			}
					
			while (pQ.size()>1) {
				long cost = pQ.poll()+pQ.poll();
				totalCost += cost;
				pQ.add(cost);
			}
			
			sb.append(totalCost);
			sb.append("\n");
			
		}
		System.out.println(sb.toString());
	}
}