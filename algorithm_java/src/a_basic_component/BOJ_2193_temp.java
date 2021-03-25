package a_basic_component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2193_temp  {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		long[] arr = new long[n+1];
		
		if(n == 1) {
			System.out.println(1);
		}else {
			arr[1] = 1;
			arr[2] = 1;
			
			for (int i = 3; i <=n ; i++) {
				arr[i] = arr[i-1] + arr[i-2];
			}
			
			System.out.println(arr[n]);
		}
		
	}

}
