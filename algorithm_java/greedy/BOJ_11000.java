package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/**
 * @source		: 백준
 * @algorithm	: 그리디
 * @description	: 강의실 배정
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.12.29	성공
 */
public class BOJ_11000 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] schedule = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			schedule[i][0] = Integer.parseInt(st.nextToken());
			schedule[i][1] = Integer.parseInt(st.nextToken());
			
		}
		
		Arrays.sort(schedule, (a,b)->{
			if(a[0]==b[0]) {
				return a[1]-b[1]; //종료 시간 오름차순
			}
			return a[0]-b[0]; //시작 시간 오름차순
		});
		
		
		PriorityQueue<Integer> pQ = new PriorityQueue<Integer>(); //시작시간
		pQ.add(schedule[0][1]); //종료시간 담기
		
		for (int i = 1; i < N; i++) {
			if(schedule[i][0] >= pQ.peek()) {
				pQ.poll();				
			}
			pQ.add(schedule[i][1]);
			
		}
		
		System.out.println(pQ.size());
	}

}
