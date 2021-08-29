package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @source		: baekjoon
 * @algorithm	: binarysearch
 * @description	: 좌표 압축
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.08.29
 */
public class BOJ_18870 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		int N = Integer.parseInt(br.readLine());
		int[] origin = new int[N];
		int[] arr;
		StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			origin[i] = Integer.parseInt(stringTokenizer.nextToken());
		}
		
		arr = Arrays.stream(origin)
				.distinct()
				.sorted()
				.toArray();
		
		for (int i = 0; i < N; i++) {
			int tar = origin[i];
			
			int st = 0;
			int en = arr.length -1;
			while(st < en) {
				
				int mid = (st+en)/2;
				
				if(arr[mid] > tar) {
					en = mid-1;
				}else if(arr[mid] < tar){
					st = mid+1;
				}else {
					st = mid;
					break;
				}
			}
			
			sb.append(String.valueOf(st)+" ");
			
		}
		
		System.out.println(sb.toString());
		
		
	}

}
