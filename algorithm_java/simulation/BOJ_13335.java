package simulation;

import java.io.*;
import java.util.*;
/**
 * @source		: baekjoon
 * @algorithm	: 구현
 * @description	: 트럭
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.11.30	성공
 */
public class BOJ_13335 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());	//트럭의 수
		int w = Integer.parseInt(st.nextToken());	//다리의 길이
		int L = Integer.parseInt(st.nextToken());	//다리의 최대하중
		
		int bridgeW = 0; //현재 다리위 트럭 무게 총합
		int time = 0;
		
		Queue<Integer> truckQ = new LinkedList<>(); 
		Queue<int[]> bridgeQ = new LinkedList<>();
		
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			truckQ.add(Integer.parseInt(st.nextToken()));
		}
		
		
		
		while (!truckQ.isEmpty() || !bridgeQ.isEmpty()) {
			
			int len = bridgeQ.size();
			for (int i = 0; i < len; i++) {
				int[] tmp = bridgeQ.poll();
				tmp[1]--; //다리 위 위치 감소
				if(tmp[1] > 0) {
					bridgeQ.add(tmp);
				}else {
					bridgeW -= tmp[0]; //다리위 트럭 지나감
				}
			}
			
			if(bridgeW <L && !truckQ.isEmpty()) {
				int next = truckQ.peek();
				
				if(bridgeW + next <= L) {
					truckQ.poll();
					bridgeQ.add(new int[] {next, w});
					bridgeW += next;
				}
			}
			
			time++;
			
		}
		
		System.out.println(time);
		
	}
}
