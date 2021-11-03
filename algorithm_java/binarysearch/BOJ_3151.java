package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
* @source		: baekjoon
* @algorithm	: 이분탐색 , 투포인터
* @description	: 합이 0
* ==============================================
* DATE			NOTE	
* ==============================================
* 2021.11.03	투포인터 풀이 실패 ㅠㅠ
*/
public class BOJ_3151 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int count = 0;
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		

		for (int i = 0; i < N-2; i++) {
			int tar = -arr[i];
            
            //if(tar > 0) break; // 0을 넘어가면 팀 합 0이 안됨!
			
			int start = i+1;
			int end = N-1;
			
			int mx_idx = N;
		
			while (start < end) {
				
				if(arr[start] + arr[end] < tar) {
					start++;
				}else if(arr[start] + arr[end] > tar) {
					end--;
				}else { //합이 0인 경우
					
					if(arr[start] == arr[end]) {
						count += end-start;
					}else {
						
						if(mx_idx > end) {
							mx_idx = end;
							while (mx_idx >= 0 && arr[mx_idx-1] == arr[end]) {
								mx_idx--;
							}
							
						}
						count += end - mx_idx+1; //개수 만큼 더하기
						
					}
					
					start++;
				}
					
			}
		}
							
		
		System.out.println(count);
	}

}
