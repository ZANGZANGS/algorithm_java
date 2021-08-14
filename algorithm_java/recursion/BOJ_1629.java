/**
 * a^b %c
 */
package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1629 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input, " ");
		
		long a = Integer.parseInt(st.nextToken());
		long b = Integer.parseInt(st.nextToken());
		long c = Integer.parseInt(st.nextToken());
		
		//System.out.println((long)(Math.pow(a, b)%c));
		
		long result = pow(a,b,c);
		
		System.out.println(result);
		
	}
	
	public static long pow(long a, long b, long c) {
		if(b==1) {
			return a%c;
		}else {
			long val = pow(a,b/2,c);
			val = (val*val) %c;
			
			if(b%2 == 0) {
				return val;
			}else {
				return (val*a) %c;
			}
		}
	}
}

