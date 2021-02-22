package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_2751 {
	
	public static ArrayList<Integer> arr;
	public static int[] tmp;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		arr  = new ArrayList<Integer>();
		tmp  = new int[n];
		
		//숫자 배열에 입력
		for (int i = 0; i < n; i++) {
			arr.add(Integer.parseInt(br.readLine()));
		}
		br.close();

		Collections.sort(arr);
		
		printArr(arr);
		

	}

	
	public static void printArr(ArrayList<Integer> array) {
		StringBuilder sb = new StringBuilder();
		
		array.stream()
		.forEach(v-> sb.append(v+" "));
		
		System.out.println(sb.toString());
	}

}
