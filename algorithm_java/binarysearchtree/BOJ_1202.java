package binarysearchtree;

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
 */
public class BOJ_1202 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //보석 정보 개수
		int K = Integer.parseInt(st.nextToken());
		
		PriorityQueue<int[]> pQ = new PriorityQueue<int[]>((a,b)->{
			if(a[0] == b[0]) {
				return a[1]-b[1];
				
			}
			return b[0]-a[0];
		});
				
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int M = Integer.parseInt(st.nextToken()); //보석 무게
			int V = Integer.parseInt(st.nextToken()); //보석 가격
			
			pQ.add(new int[] {V,M});
		}
		
		
		List<Integer> bag = new ArrayList<Integer>();
		for (int i = 0; i < K; i++) {
			int C = Integer.parseInt(br.readLine()); //가방 최대 무게 
			bag.add(C);
		}
		
		Collections.sort(bag);
		
		int total = 0;
		while(!bag.isEmpty() && !pQ.isEmpty()) {
			
			int[] tmp = pQ.poll();
			int targetV = tmp[0]; //가치
			int targetM = tmp[1]; //무게
			
			int lp =0;
			int rp = bag.size();
			
			if(bag.get(bag.size()-1) <targetM) continue;
			
			while (lp<rp) {
				
				int mid = (lp+rp)/2;
				
				if(bag.get(mid) >= targetM) {
					rp = mid-1;
				}else {
					lp = mid;
				}
				
			}
			
			bag.remove(lp);
			total += targetV;
			
		}
		
		System.out.println(total);
		
		
	}

}
