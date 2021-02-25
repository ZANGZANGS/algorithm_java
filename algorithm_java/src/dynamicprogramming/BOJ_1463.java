package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1463 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] d = new int[n+1];
		Arrays.fill(d, Integer.MAX_VALUE);
		
		d[1] = 0;
		for (int i = 2; i <= n; i++) {
			//1. X가 3으로 나누어 떨어지면 3으로 나눈다.
			if(i%3 == 0) d[i] = Math.min(d[i], d[i/3]+1);
			//2. X가 2로 나누어 떨어지면 2로 나눈다.
			if(i%2 == 0) d[i] = Math.min(d[i], d[i/2]+1);
			//3. 1을 뺸다.
			d[i] = Math.min(d[i], d[i-1]+1);
		}
		
		System.out.println(d[n]);
		
	}
	

}
