package simulation;

import java.io.*;
import java.util.*;
/**
 * @source		: baekjoon
 * @algorithm	: 구현
 * @description	: 컨베이어 벨트 위의 로봇 
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.12.02	성공
 */
public class BOJ_20055 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[2*N];
		boolean[] isRobot = new boolean[2*N];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < 2*N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int cur = 0; 
		int step = 0;
		
		while (true) {
			step++;
			
			//step1
			cur--;
			cur = (cur+2*N)%(2*N);
			
			//움직인 커서 기준으로 
			//올리는 위치, 내리는 위치 계산
			int on = cur%(2*N);
			int off = (cur+N-1)%(2*N);
			
			//로봇 하차 체크
			if(isRobot[off]) {
				isRobot[off] = false;
			}
			
			
			//step2 
			for (int i = off-1; i > off-N; i--) {
				
				int here = (i+2*N)%(2*N);
				int next = (i+1+2*N)%(2*N);
				
				if(isRobot[here] && !isRobot[next] && arr[next]>0) {
					isRobot[here] = false;
					isRobot[next] = true;
					arr[next]--;
				}
				
			}
			if(isRobot[off]) {//하차
				isRobot[off] = false;
			}
			
			
			//step3
			if(arr[on]>0 && !isRobot[on]) {//승차
				arr[on]--; 
				isRobot[on] = true;
			}
			
			//step4
			if((int)Arrays.stream(arr).filter(v-> v<=0).count()>=K) break;
			
			
		}
		System.out.println(step);
	}
}
