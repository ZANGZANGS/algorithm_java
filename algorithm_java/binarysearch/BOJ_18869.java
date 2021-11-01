package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @source		: backjoon
 * @algorithm	: 좌표압축
 * @description	: 멀티버스 2
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.11.01	이분탐색 응용니 좌표압축을 사용한다.
 * 				부르트포스를 사용하게 될경우 M*M * N*N 이되어 시간초과가 발생한다.
 */
public class BOJ_18869 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int total = 0;
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[][] space = new int[M][N];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				space[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
	
		//좌표압축
		int[][] spaceZip = zip(M,N,space);
		
		for (int i = 0; i < M; i++) {
			
			for (int j = i+1; j < M; j++) {
//				System.out.println("i & j :" + i +" , " + j );

				boolean isMultibus = true;
				for (int k = 0; k < N; k++) {
					if(spaceZip[i][k] != spaceZip[j][k]) {
						isMultibus = false;
						break;
					}
				}
				
				if(isMultibus) total++;
				
			}
			
		}
		
		
		System.out.println(total);

	}

	private static int[][] zip(int M, int N, int[][] array){
		
		int[][] result = new int[M][N];
		
		
		for (int i = 0 ; i < M ; i++) {
			
			int[] temp = Arrays.copyOf(array[i], N);
			Arrays.sort(temp);
			
			for(int j=0; j<N ;j++) {
				int tar = array[i][j];
				
				int st = 0;
				int ed = N-1;
				while (st<=ed) {
					
					int mid = (st+ed)/2;
					
					if(temp[mid] >= tar) {
						ed = mid-1;
					}else {
						st = mid+1;
					}
					
				}
				
//				System.out.println("target is " +tar +"\tst "+st + "\ted:"+ed);
				result[i][j] = st;
			}
			
			
		}
				
		
		
		
		return result;
	}
}
