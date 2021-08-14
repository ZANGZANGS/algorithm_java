package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1182 {

	static int n,s,count;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		s = Integer.parseInt(input[1]);
		
		arr = new int[n];
	
		input = br.readLine().split(" ");
		for (int i = 0; i < input.length; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}
		
		func(0,0);
		if(s == 0) count--;	//s가 0이면 처음 시작시에 하나가 추가되버린다.
		
		System.out.println(count);
	}
	
	private static void func(int cur, int sum) {//합계
		
		if(n ==cur) {
			if(s == sum) {// 1.맨 마지막까지 왔는지 2.합이 s와 동일하면 count 증가
				count++;
			}
			return; //이때 리턴하지 않으면 cur이 n보다 커지는 문제가 발생한다. 주의!
		}
		
		//1. 지금꺼 안 더하고 다음꺼 더하기
		func(cur+1, sum);
		
		//2. 지금꺼 더하고 다음꺼 더하기
		func(cur+1,  sum+arr[cur]);
			
	}

}
