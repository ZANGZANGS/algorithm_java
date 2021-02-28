package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11047 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		// 동전 종류 입력
		int[] coin = new int[n];//동전 종류 저장
		int cnt = 0;	//동전 사용횟수 저장
		
		for (int i = 0; i < n; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		
		//풀이
		for (int i = n-1; i >= 0; i--) {
			if(k == 0) break;
			if(k/coin[i] == 0) continue;

			cnt += k/coin[i];
			k=k%coin[i];
			
		}
		
		System.out.println(cnt);
		
	}

}
