package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1475 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] input = br.readLine().toCharArray();
		int[] numbers = new int[10];
		
		for (char item : input) {
			numbers[item-'0'] +=1;
		}
	
		int num69 = numbers[6] + numbers[9];
		num69 = num69%2 > 0 ? num69/2+1 : num69/2;
		numbers[6] = num69;
		numbers[9] = num69;
		
		//최대 값 체크
		int max = 0;
		for (int i : numbers) {
			max = Math.max(max, i);
		}
		
		System.out.println(max);
	}

}
