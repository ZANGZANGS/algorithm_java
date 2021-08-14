package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2577 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		int[] arr = new int[10];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());
		int result = a*b*c;
		
		while (result >0) {
			int temp = result%10;
			result /= 10;
			arr[temp] = arr[temp]+1;
		}
		
		
		Arrays.stream(arr).forEach(v->sb.append(v + "\n"));
		
		System.out.println(sb.toString());
	}

}
