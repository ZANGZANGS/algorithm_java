package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1748 {

	public static void main(String[] args) throws IOException {
		String input;
		int len;
		int result;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		input = br.readLine();
		len = input.length();
		result = 0;
		
			// 1~9  		9개
			// 10~99 		90개
			// 100 ~ 999 	900개
			// 1000~ 9999	9000개
			for (int i = 0; i < len-1; i++) {
				result +=  9* Math.pow(10, i)* (i+1);
			}
			
			result += ((Integer.parseInt(input )- (int)(Math.pow(10, len-1))+1) * len);
		System.out.println(result);
	}
}
