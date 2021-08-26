package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source		: baekjoon
 * @algorithm	: two pointer
 * @description	: 부분합
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.08.27
 */
public class BOJ_1806 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stz = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(stz.nextToken());
		int S = Integer.parseInt(stz.nextToken());
		int[] arr = new int[N];
		
		stz = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(stz.nextToken());
		}
		
		int en = 0;
		long total = arr[0];
		int result = 100001;
		
		for (int st = 0; st < N; st++) {
			while (en < N && total < S) {
				en++;
				if(en != N) {
					total += arr[en];
				}
			}
			if(en == N) break; //범위 체크 
			result = Math.min(result, en - st+1);
			total -= arr[st];
		}
		
		if(result == 100001) {
			result = 0;
		}
		System.out.println(result);
	}

}
