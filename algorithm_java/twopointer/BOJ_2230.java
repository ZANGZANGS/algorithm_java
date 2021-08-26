package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.stream.Stream;

/**
 * @source		: baekjoon
 * @algorithm	: two pointer
 * @description	: 수 고르기
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.08.26
 */
public class BOJ_2230 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		int en=0;
		int result = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			while (en < N && arr[en]-arr[i] < M ) {
				en++;
			}
			if(en == N) break;
			result = Math.min(result, arr[en]-arr[i]);
		}
			
		System.out.println(result);
		
	}

}
