package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Optional;
import java.util.StringTokenizer;

public class BOJ_1932 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		

		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		int[] result = new int[n];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j <= i; j++) {
				int Number = Integer.parseInt(st.nextToken());				
				if(j == 0) {
					result[j] = arr[j]+ Number;
					continue;
				}
				if(j == i) {
					result[j] = arr[j-1]+ Number;
					continue;
				}
				
				result[j] =Math.max(arr[j-1]+ Number, arr[j]+Number);
				
				
			}
			arr = result.clone();
		}
		Arrays.stream(result).max();
		
		System.out.println(result[n-1]);
		
		
	}

}
