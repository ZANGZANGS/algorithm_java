package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11726 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());

		if(n == 1) {
			System.out.println(1);
		}else {
			int[] d = new int[n+1];
			
			d[1] = 1;
			d[2] = 2;
			for (int i = 3; i <= n; i++) {
				
				d[i] = Math.floorMod(d[i-1]+d[i-2],10007);
			}
			
			System.out.println(d[n]);
		}
		
	}

}
