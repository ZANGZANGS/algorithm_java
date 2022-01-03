package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @source		: 백준
 * @algorithm	: 그리디
 * @description	: 공주님의 정원
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2022.01.03	실패 72%
 * 				//TODO 
 */

/*====반례 ====
2
3 1 11 30
11 30 11 30
->0


3
3 1 5 5
5 5 10 8
10 7 11 30
->0

3
1 1 11 30
11 10 12 5
3 1 12 1
-> 1*/
public class BOJ_2457 {

	public static void main(String[] args)  throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		
		//3월 1일부터 11월 30일까지 매일 꽃이 한 가지 이상 피어 있도록 꽃들을 선택
		
		
		//1.시작일 오름차순 정렬 우선순위 큐 생성
		PriorityQueue<int[]> flowerPQ = new PriorityQueue<>((a,b)->{
			return a[0]-b[0];
		});
		
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
		
			int[] fromToMonthDay = new int[4];
			fromToMonthDay[0] =	Integer.parseInt(st.nextToken())*100 + Integer.parseInt(st.nextToken()); //MMDD 형태의 4자리 숫자
			fromToMonthDay[1] =	Integer.parseInt(st.nextToken())*100 + Integer.parseInt(st.nextToken());
			
			flowerPQ.add(fromToMonthDay);
			
		}
		
		
		//2. 종료일 내림차순 정렬 우선순위 큐 생성
		PriorityQueue<int[]> pQ = new PriorityQueue<>((a,b)->{
			return b[1]-a[1];
			
		});
		

		int count = 0;
		int date =301;
		
		int[] tmp = flowerPQ.poll();
		if(tmp[0] <= 301) pQ.add(tmp);
		
		while (!pQ.isEmpty()) {

			while(!flowerPQ.isEmpty()) {
				if(date < flowerPQ.peek()[0]) break;
				pQ.add(flowerPQ.poll());
			}      
			
			if(!pQ.isEmpty()) {
				date = pQ.poll()[1];
				count++;
			}
			if(date > 1130) break; //꽃 다 심음
		}
		
		
		if(date <= 1130) {
			count = 0;
		}
		
		System.out.println(count);
	
	}
	

}