package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class BOJ_2217 {

	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());	//로프 개수
		
		Integer[] arr = new Integer[n];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());	//로프 중량 정보
		}
		
		//로프 정보 정렬
        Arrays.sort(arr, Collections.reverseOrder());
		
		int maxWeight = 0;
		int[] w = new int[n]; //누적 합 저장
		
		for (int i = 0; i < arr.length; i++) {
			w[i] += arr[i];
			int k = i+1; //사용하는 밧줄 개수
			int temp = w[i]/k; //w/k 의 무게 계산
			
			//분산된 무게가 최저 밧줄보다 크다면 들 수 없다. 밧줄이 끊어질 것이다. 다음으로 넘어간다.
			if(temp >w[i]) continue;
			//현재 밧줄의 무게 *k             
			maxWeight = Math.max(maxWeight, arr[i] * k);
		}
		
		System.out.println(maxWeight);

	}

}
