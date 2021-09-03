package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source		: backjoon
 * @algorithm	: parametric search
 * @description	: 랜선자르기
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.09.03
 */
public class BOJ_1654 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stzr = new StringTokenizer(br.readLine());
		
		int K = Integer.parseInt(stzr.nextToken()); // 1 ~ 10,000
		int N = Integer.parseInt(stzr.nextToken()); // 1 ~ 1,000,000

		int[] arr = new int[K];
		
		for (int i = 0; i < K; i++) {
			arr[i] =Integer.parseInt(br.readLine()); 
		}
		
		
		long st = 1;
		long en = Integer.MAX_VALUE;
		
		while (st < en) {
			int total = 0;
			long mid = (st+en+1)/2; // +1 을 하는 이유 : mid를 올림처리
			
			for (int length : arr) {
				total += length/mid;
			}
			
			if(total >= N) { //길이 증가
				st = mid;
			}else {//길이 감소
				en = mid-1;
			}
		
		}
		
		System.out.println(st);
		
	}
}
