package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;



public class BOJ_2751 {
	
	public static int[] arr;
	public static int[] tmp;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		arr  = new int[n];
		tmp  = new int[n];
		
		//숫자 배열에 입력
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		br.close();
		
		mergeSort(0, n-1);
		
		printArr(arr);
		

	}
	
	public static void mergeSort(int start, int end) {
		if(start< end) {
			int mid = (start+end)/2;
			mergeSort(start, mid); //분할
			mergeSort(mid+1, end);
			merge(start,end);//병합
		}
	
	}
	
	public static void merge(int start, int end) {
		
		int mid = (start+end)/2 +1;
		int lidx = start;
		int ridx = mid;
		
		int i = start;
		
		while (lidx <= mid && ridx <= end) {

			if(arr[lidx] < arr[ridx]) tmp[i] = arr[lidx++];
			else tmp[i] = arr[ridx++];
			
			i++;
		}
		if(ridx > end) {
			while (lidx <= mid) {
				tmp[i] = arr[lidx++];
				i++;
			}
		}

		if(lidx > mid) {
			while (ridx <= end) {
				tmp[i] = arr[ridx++];
				i++;
			}
		}
		
		
		
		
		for (int j = start; j <= end; j++) {
			arr[j] = tmp[j];
		}
		
		
	}
	
	public static void printArr(int[] array) {
		StringBuilder sb = new StringBuilder();
		
		Arrays.stream(array)
		.forEach(v-> sb.append(v).append(" "));
		
		System.out.println(sb.toString());
	}

}
