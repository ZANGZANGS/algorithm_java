package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
* @source		: baekjoon
* @algorithm	: 투포인터
* @description	: 용액 합성하기 
* ==============================================
* DATE			NOTE	
* ==============================================
* 2021.11.16	성공
*/
public class BOJ_14921 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long result = Long.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 0;
		int right = N-1;
		
		while (left < right) {
			
			int sum = arr[left] + arr[right];
			
			if(Math.abs(sum) < Math.abs(result)) {
				result = sum;
			}
		
			if(sum <= 0) {
				left++;
			}else {
				right--;
			}
			
		}
		System.out.println(result);
		
	}

}
