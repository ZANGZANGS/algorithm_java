package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10808 {

	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringBuilder sb = new StringBuilder();
		int[] freq = new int[26];
		
		for (int i = 0; i < input.length(); i++) {
			freq[(int)input.charAt(i)-97] +=1;
		}

		for (int i = 0; i < freq.length; i++) {
			sb.append(String.valueOf(freq[i])+"\n"); 
		}
		
		System.out.println(sb.toString());
		
	}

}
