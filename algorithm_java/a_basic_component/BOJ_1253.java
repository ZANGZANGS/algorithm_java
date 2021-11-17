package a_basic_component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @source		: baekjoon
 * @algorithm	: 투포인터
 * @description	: 좋다
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.11.17	성공
 * 				체크할 항목들
 * 				1.투포인터 사용을 위한 정렬
 * 				2.자기 자신에 해당하는 수를 사용하지 않도록 처리
 */
public class BOJ_1253 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int total = 0;
		int N = Integer.parseInt(br.readLine());
		int numbers[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(numbers); //1.투포인터 사용을 위한 정렬
		
		for (int i = 0; i < N; i++) {
			int target = numbers[i];
			
			int left = 0;
			int right = N-1;
			while ( left < right) {
				
				//2.자기 자신에 해당하는 수를 사용하지 않도록 처리
				if(left == i) {
					left++;
					continue;
				}
				if(right == i) {
					right--;
					continue;
				}
				
				int temp = numbers[left] + numbers[right];
				if(temp == target) {
					total++;
					break;
				}else if(temp <= target) {
					left++;
				}else {
					right--;
				}
			}
			
		}
		
		System.out.println(total);
		
	}

}
