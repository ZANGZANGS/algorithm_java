package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * @source		: baekjoon
 * @algorithm	: 이분탐색 (파라메트릭서치)
 * @description	: 휴게소 세우기
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.11.23	성공
 * 				1.휴게소 거리구하는 방법이 헷갈렸다. -1 해야한다는 걸 생각 못했음.
 * 				2/by zero 런타임에러 : 휴게소 끝에는 새로 못지음 lp,rp 초기화 설정 주의 
 */
public class BOJ_1477 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());//현재 휴게소 개수
		int M = Integer.parseInt(st.nextToken());//더 지을 휴게소 개수
		int L = Integer.parseInt(st.nextToken());//고속도로 길이
		
		int rest[] = new int[N+2]; //+2 이유: 시작점, 끝점 추가
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			rest[i] = Integer.parseInt(st.nextToken());
		}
		//rest[N] = 0; 시작점
		rest[N+1] = L;	//종료점
		
		Arrays.sort(rest);
		
		int lp = 1; //고속도로의 끝에도 휴게소를 세울 수 없다.
		int rp = L;
		
		while (lp<rp) {
			
			int mid = (lp+rp)/2; //신규 휴게소 거리
			
			int cnt = 0;
			
			for (int i = 0; i < rest.length-1; i++) {
				int dist = rest[i+1] - rest[i]; //기존 휴게소 거리차이
				
				if(dist/mid>0) {
					
					if(dist%mid == 0) {
						//기존 거래소 사이에 휴게소랑 딱 맞으니 한개 덜 지어
						cnt += (dist/mid)-1;
					}else {
						cnt += dist/mid;
					}
				}
				
			}
			
			if(cnt>M) { 
				lp = mid+1;//휴게소를 초과하여 지음 : 거리 증가
			}else {
				rp = mid;
			}
			
		}
		
		System.out.println(lp);
	}
		
}
