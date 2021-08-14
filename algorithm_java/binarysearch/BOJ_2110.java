package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2110 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n =  Integer.parseInt(st.nextToken());
		int c =  Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		//1. 정렬 : 이진 탐색은 정렬된 상태에서 사용 가능
		Arrays.sort(arr);
		
		//2. 이진탐색 
		int dist = 0;
		int minDist = 1;
		int maxDist = arr[n-1] - arr[0];
		int result = 0;
		
		while (minDist <=maxDist) {
			
			int start = arr[0];
			int cNum =1;	//거리에 따른 공유기 개수를 담음	
			int tempDist = (minDist+maxDist)/2;	//거리 기준
			
			//dist에 따라 공유기를 설치
			for (int i = 1; i < n; i++) {
				dist = arr[i]-start;
				if(tempDist <= dist) {// 거리가 중간점(중간 거리)보다 크다면
					cNum++;			// 공유기를 하나 설치한다.
					start = arr[i]; // 시작점을 현재 공유기 설치한 곳으로 바꾼다.
				}
			}
			
			if(cNum >= c) {//공유기 개수가 너무 많다면 간격()
				result = tempDist;//일단, 최대 거리 저장
				minDist = tempDist+1;
			}else {
				maxDist = tempDist-1;
			}
			
		}
		
		System.out.println(result);
		
	}

}
