package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_9095 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t  = Integer.parseInt(br.readLine());
		//n max = 1
		
		int[] d = new int [12];
		Arrays.fill(d, Integer.MAX_VALUE);
		d[1] = 1;
		d[2] = 2;
		d[3] = 4;
		
		for (int i = 4; i <= 11; i++) {
			d[i] = d[i-1]+d[i-2]+d[i-3];
		}
		
		
		for (int i = 0; i < t; i++) {
			System.out.println(d[Integer.parseInt(br.readLine())]);
		}
		
	}

}
