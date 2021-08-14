package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1919 {

	public static void main(String[] args) throws IOException {
		
		int[] alphabet = new int[26];
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] first = br.readLine().toCharArray();
		char[] seccond = br.readLine().toCharArray();
		
		for (char c : first) 	alphabet[c-97]+=1;
		for (char c : seccond) 	alphabet[c-97]-=1;
		
		int result = 0;
		result = Arrays.stream(alphabet)
				.map(v -> {
					return Math.abs(v);	// 음수인 값이 절대값으로 바꿔주고..
					}).sum();
		
		System.out.println(result);
	}

}
