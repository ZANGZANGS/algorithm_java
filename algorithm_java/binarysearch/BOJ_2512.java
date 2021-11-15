package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
* @source		: baekjoon
* @algorithm	: 이분탐색
* @description	: 예산 
* ==============================================
* DATE			NOTE	
* ==============================================
* 2021.11.15	성공
*/
public class BOJ_2512 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine()); //전체 국가 예산
		
		
		if(Arrays.stream(arr).sum() > M) {
		
			int start = 0;
			int end = M;
			
			int max = 0;
			
			while (start <= end) {
				
				int mid = (start+end)/2;
				int sum = 0;
				
				for (int money : arr) {
					sum += money>mid ? mid : money;
				}
				
				if(sum > M) {
					end = mid-1;
				}else if(sum <= M) {
					max = Math.max(max, mid);
					start = mid+1;
				}
				
			}
			
			System.out.println(max);
			
		}else {
			System.out.println(Arrays.stream(arr).max().getAsInt());
		}
		
	}

}
