package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @source		: baekjoon
 * @algorithm	: 이분탐색
 * @description	: 차집합
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.10.27	성공
 */
public class BOJ_1822 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int[] setA = new int[a];
		int[] setB = new int[b];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < a; i++) {
			setA[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < b; i++) {
			setB[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(setB);
		
		List<Integer> result = new ArrayList<>();
		
		for (int i = 0; i < a; i++) {
			//target is setA[i]
			int start = 0;
			int end = setB.length-1;
			
			boolean isHave = false;
			
			while(start <= end) {
				int mid = (start+end) / 2;
				
				
				if(setB[mid] == setA[i]) {
					isHave = true;
					break;
				}
				
				if(setB[mid] > setA[i]) {
					end = mid-1;
					
				}
					
				if(setB[mid] < setA[i]) {
					start = mid+1;
				}
				
			}
			
			if(!isHave) {
				result.add(setA[i]);
			}
			
		}
		
		Collections.sort(result);
		
		if(result.size() == 0) {
			System.out.println(0);
		}else {
			sb.append(result.size());
			sb.append("\n");
			
			for (Integer item : result) {
				sb.append(item);
				sb.append(" ");
			}
			
			System.out.println(sb.toString());
		}
	}
}
