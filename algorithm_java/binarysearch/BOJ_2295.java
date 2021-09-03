package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @source		: backjoon
 * @algorithm	: binarysearch
 * @description	: 세 수의 합
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.09.03	
 */
public class BOJ_2295 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		List<Integer> two = new ArrayList<Integer>();
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				two.add(arr[i] + arr[j]);
			}
		}
		
		Collections.sort(two);
		
		int result = 0;
		
		for (int i = N-1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				
				int target = arr[i]-arr[j];
				int st = 0;
				int en = two.size();
				
				while(st < en) {
					int mid = (st+en)/2;
					
					if(target == two.get(mid)) {
						result = Math.max(result, arr[i]);
						break;
					}
					
					if(two.get(mid)>target) {
						en = mid;
					}else {
						st = mid+1;
					}
				}
			}
		}
		System.out.println(result);
	}
}
