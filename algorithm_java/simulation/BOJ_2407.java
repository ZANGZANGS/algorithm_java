package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;
/**
* @source		: baekjoon
* @algorithm	: ??
* @description	: 조합 
* ==============================================
* DATE			NOTE	
* ==============================================
* 2021.11.11	구현 실패
* 2021.11.12	BigInteger를 사용하여 해결
*/
public class BOJ_2407 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		if(m > n-m) m = n-m;

		BigInteger ans = BigInteger.ONE;
		
		for (int i = 0; i < m; i++) {
			ans = ans.multiply(new BigInteger(String.valueOf(n-i))).divide(new BigInteger(String.valueOf(i+1)));
		}
		
		System.out.println(ans);
		
	}
	

}
