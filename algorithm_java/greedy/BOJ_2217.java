package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
/**
 * @source		: 백준
 * @algorithm	: 그리디
 * @description	: 로프
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.12.27	재풀이
 */
public class BOJ_2217 {

	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());	
		Integer[] rope = new Integer[N];
		int[] weight = new int[N]; 	//무게 저장 배열
		
		for (int i = 0; i < N; i++) {
			rope[i] = Integer.parseInt(br.readLine());	//로프 중량 정보
		}
		
        Arrays.sort(rope, Collections.reverseOrder());
		
		for (int i = 0; i < N; i++) {
			weight[i] = rope[i]*(i+1);
		}
		
		System.out.println(Arrays.stream(weight).max().getAsInt());

	}

}
