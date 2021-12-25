package priorityqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


/**
 * @source		: 백준
 * @algorithm	: 이진 탐색 트리
 * @description	: 보석 도둑
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.12.24	시간초과
 * 2021.12.25	성공
 */
public class BOJ_1202 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //보석 정보 개수
		int K = Integer.parseInt(st.nextToken());
		
		//1. 보석의 무게, 가치를 담는 우선순위 큐 정의
		PriorityQueue<int[]> pQ = new PriorityQueue<int[]>((a,b)->{
			if(a[0]-b[0] == 0) {
				return b[1]-a[1]; //가치 내림차순 정렬
			}
			return a[0]-b[0];//무게 오름 차순 정렬
		});
		
		//1-1. 우선순위 큐에 보석 정보 저장	
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int M = Integer.parseInt(st.nextToken()); //보석 무게
			int V = Integer.parseInt(st.nextToken()); //보석 가격
			
			pQ.add(new int[] {M,V});
			
		}
		
		//2. 가방 정보 저장하는 List
		List<Integer> bag = new ArrayList<Integer>();
		for (int i = 0; i < K; i++) {
			int C = Integer.parseInt(br.readLine()); //가방 최대 무게 
			bag.add(C);
		}
		//2-1. 가방 오름차순 정렬
		Collections.sort(bag);
		
		
		//3. 가방에 들어갈 수 있는 무게를 valueQ로 옮긴후 가장 가치가 큰 값을 total에 더한다.
		PriorityQueue<Integer> valueQ = new PriorityQueue<Integer>(Collections.reverseOrder());
		long total = 0;
		for (int i = 0; i < bag.size(); i++) {
			int weight = bag.get(i);
			
			while (!pQ.isEmpty()) {
				 
				if(pQ.peek()[0] <= weight) {
					valueQ.add(pQ.poll()[1]); //가치만 넣는다.
				}else {
					break;
				}
			}
			
			if(valueQ.isEmpty()) continue;
			total += valueQ.poll();
			
			
		}

		
		System.out.println(total);
		
		
	}

}
