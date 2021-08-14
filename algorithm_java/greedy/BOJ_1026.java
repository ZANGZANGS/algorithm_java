package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_1026 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum = 0;
		int n = Integer.parseInt(br.readLine()); 
		
		Integer[] a = new Integer[n];
		Integer[] b = new Integer[n];
		
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st1.nextToken());
			b[i] = Integer.parseInt(st2.nextToken());
		}
		
		Arrays.sort(a);
		Arrays.sort(b, Collections.reverseOrder());
		
		for (int i = 0; i < n; i++) {
			sum += a[i]*b[i];
		}
		System.out.println(sum);
	}

}
