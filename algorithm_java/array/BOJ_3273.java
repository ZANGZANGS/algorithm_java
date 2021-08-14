package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3273 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int x = Integer.parseInt(br.readLine());
		int count = 0;
		int[] arr = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 정렬함-> 경우의 수를 줄일 수 있음.
		Arrays.sort(arr);
		
		int startIdx = 0;
		int endIdx = n-1;
		
		while (startIdx < endIdx) {
			int sum = arr[startIdx] + arr[endIdx];
			if(sum == x) {
				count++;
				endIdx--;
				startIdx++;
			}
			else if(sum > x) endIdx--;		//합계가 x 보다 크면 종료인덱스  감소
			else if(sum < x) startIdx++;	//합계가 x 보다 작으면 시작인덱스 증가
			
		}
		
		System.out.println(count);
		
	}

}
