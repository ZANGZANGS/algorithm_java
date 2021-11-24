package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
/**
 * @source		: baekjoon
 * @algorithm	: 투포인터
 * @description	: 대표선수
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.11.24	성공
 * 				1.모든 선수를 능력치 순서로 정렬한다.
 * 				1-1. 이때 선수들의 학급정보를 알 수 있어야 한다.
 * 				2.투 포인터로 모든 학급의 학생이 포함되는 범위를 찾는다.
 * 				3.최소 값을 비교하여 값을 갱신한다.
 */
public class BOJ_2461 {

	static int N,M;
	static int count[];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		st= new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());//학급
		M = Integer.parseInt(st.nextToken());//학급별 학생 수
		count = new int[N];
		
		List<int[]> student = new ArrayList<>();  
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < M; j++) {
				student.add(new int[] {i,Integer.parseInt(st.nextToken())}); //학급,능력치
			}
		}

		student.sort((a,b)-> a[1]-b[1]); // 능력치 순서로 정렬
		
		int lp = 0;
		int rp = 0;

		int diff= Integer.MAX_VALUE;
		
		while (lp < N*M-1 && rp < N*M-1) {

			while (rp < N*M-1) {
				
				count[student.get(rp++)[0]]++;
				
				if(haveAllClass()) break;
			}
			
			while (count[student.get(lp)[0]]>1) {
				count[student.get(lp++)[0]]--;
			}

			if(haveAllClass()) {
				int min = Integer.MAX_VALUE;
				int max = Integer.MIN_VALUE;
				
				for (int i = lp; i < rp; i++) {
					min = Math.min(min, student.get(i)[1]);
					max = Math.max(max, student.get(i)[1]);
				}
				diff = Math.min(diff, max-min);
			}
			
			//lp 오른쪽으로 한칸 이동
			count[student.get(lp++)[0]]--;
			
		}
		
		
		System.out.println(diff);
		
	}

	private static boolean haveAllClass() {

		for (int cnt : count) {
			if(cnt == 0) return false;
		}
		
		return true;
	}
}
