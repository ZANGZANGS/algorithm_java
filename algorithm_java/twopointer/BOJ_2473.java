package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @source		: baekjoon
 * @algorithm	: 투 포인터
 * @description	: 세 용액
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.11.19	성공
 * 				1. 용액 하나 선택
 * 				2. 투 포인터를 사용해 3개 용액 합이 0에 가까운지 반복하며 확인
 * 				3. 3개 용액의 합이 int 자료형의 범위인 21억을 넘길 수 있으므로 총합 계산 변수 value는 long으로 선언
 */
public class BOJ_2473 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] result = new int[3];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		long value = 3000000000l;
		
		for (int i = 0; i < N; i++) {
			
			int lp=0;
			int rp=N-1;
			while (lp<rp) {
				
				if(lp == i) {
					lp++;
					continue;
				}
				if(rp == i) {
					rp--;
					continue;
				}
				
				long sum = (long)arr[i] + arr[lp] + arr[rp];
				
				
				if( Math.abs(value) > Math.abs(sum)) {
					value = sum;
					result[0] = arr[i];
					result[1] = arr[lp];
					result[2] = arr[rp];
				}
				if(sum == 0) break;
				if(sum > 0) rp--;
				if(sum < 0) lp++;
				
			}
			
			if(value == 0) break;
		}
		
		Arrays.sort(result);
		System.out.println(result[0]+ " " + result[1] + " " + result[2]);
	}

}
