package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
* @source		: baekjoon
* @algorithm	: ??
* @description	: 조합 
* ==============================================
* DATE			NOTE	
* ==============================================
* 2021.11.11	구현 실패
*/
public class BOJ_2407 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		if(m > n-m) m = n-m;

		long ans=1;
		
		for (int i = 0; i < m; i++) {
			ans = ans*(n-i)/(i+1); 
			
		}
		
		System.out.println(ans);
		
	}
	

}
