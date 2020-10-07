package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int size = Integer.parseInt(br.readLine());
		
		String[] arr = new String[size];
		
		for(int i=0; i<size ; i++) {
			arr[i] = br.readLine();
		} 
		
		for(int i=0; i<arr[0].length() ; i++) {
			for (int j = 0; j < arr.length-1; j++) {
				if(arr[j].charAt(i) != arr[j+1].charAt(i)) {
					arr[0] = arr[0].substring(0, i) + "?" + arr[0].substring(i+1, arr[0].length());
					break;
				}
			}
		}
		System.out.println(arr[0]);
	}
}
