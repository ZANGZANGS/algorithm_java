package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2193  {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n+1];
		arr[1] = 1;
		arr[2] = 1;
		
		//오사마
		for (int i = 3; i <= n; i++) {
			arr[i] = arr[i-1]  + arr[i-2] ;
		}
		
		System.out.println(arr[n]);
		
		/*
		 1 -> 1
		 //1
		  * 
		 2 -> 1
		 //10
		  * 
		 3 -> 2
		 //100
		 //101
		  * 
		 4 ->1 + 1+1 =3
		 //1000
		  
		 //1010
		 //1001

		5 -> 1 + 2+ 1 = 4
		//10000 1
		
		//10100	//3번이네?
		//10101
		
		//10010	//2번이네?
		//10001	//1번이네?
		 
		 */
		
		
		
		
	}

}
