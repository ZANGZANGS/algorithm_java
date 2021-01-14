package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10807 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		int[] arr = new int[101]; // 0 ~ 100 까지 0 인덱스는 사용안
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		String[] input = br.readLine().split(" ");
		
		for (String num : input) {
			int idx = Integer.parseInt(num);
			
			arr[idx] = arr[idx]+1;
			
		}
		
		int at = Integer.parseInt(br.readLine());
		
		System.out.println(arr[at]);
	}

}
