package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2108 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int size = Integer.parseInt(br.readLine());
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			int temp = Integer.parseInt(br.readLine());
			arr[i] = temp;
		}
		
		//1. Æò±Õ
		int total = 0;
		for(int item: arr) {
			total += item;
		}
		
		System.out.println(Math.round((double)total/size));

		//2. Áß¾Ó°ª
		Arrays.sort(arr);
		System.out.println(arr[(int) Math.floor(size/2.0)]);
		
		//3. ÃÖºó°ª
		int count = 0; //´©Ã´ ÃÖ´ëºóµµ°ª
		int tempCnt = 0; // ÀÓ½Ã ÃÖ´ëºóµµ°ª
		int freqVal = arr[0];
		boolean flag = false; // ºóµµ°ªÀÌ °°À¸¸é
		
		for(int i=0; i < size-1 ; i++) {
			if(arr[i] == arr[i+1]) {
				tempCnt ++ ;
				if(count < tempCnt ) {
					count = tempCnt;
					freqVal = arr[i];
					flag = false;
				}else if( count == tempCnt && !flag){
					flag = true;
					freqVal = arr[i];
				}
				
				
			}else {
				tempCnt = 0;
			}
		}
		if(freqVal == arr[0]) {
			if(size != 1) {
				freqVal = arr[1];
			}
		}
		System.out.println(freqVal);

		//4. ¹üÀ§
		System.out.println(arr[size-1] - arr[0]);
	}

}
