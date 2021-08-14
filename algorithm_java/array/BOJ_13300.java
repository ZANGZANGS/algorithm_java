package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_13300 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);
		
		int count = 0;
		
		int[][] arr = new int[2][6];
		
		for (int i = 0; i < n; i++) {
			input = br.readLine().split(" ");
			int s = Integer.parseInt(input[0]);	//성별 0:여 1:남
			int y = Integer.parseInt(input[1]);	//학년
			
			arr[s][y-1] += 1;
		}
		
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 6; j++) {
				
				int temp = arr[i][j];
				
				count = count + temp/k;	//k 명당 방 추가
				count = temp%k > 0 ? count+1 : count; //나머지가 있으면 방 1개 추가
			}
		}
		
		System.out.println(count);
	}

}
