package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @source		: binarysearch
 * @algorithm	: 이분탐색
 * @description	: 과자 나눠주기
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.10.28	배열 정렬을 하지 않아서 틀렸다.. 그런데 문제가 좀 헷갈리게 설명되어있네..
 */
public class BOJ_16401 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int max = 0;
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[] snack = new int[N];
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			snack[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(snack);
		
		int start = 1;
		int end = snack[N-1];
		while (start <= end) {
			
			int cnt = 0;
			int mid = (start+ end)/2;

			
			for (int sn : snack) {
				cnt += sn/mid;
			}
			
			if(cnt >= M) {
				max = Math.max(max, mid);
				start = mid+1;
			}else {
				end = mid-1;
			}
			
			
		}
		
		System.out.println(max);
	}

}
