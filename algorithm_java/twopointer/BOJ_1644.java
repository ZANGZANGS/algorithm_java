package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/**
 * @source		: baekjoon
 * @algorithm	: 투 포인터
 * @description	: 소수의 연속합
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.11.22	성공
 *				1. 에라토스테네스의 체 사용하여 소수 구하기
 *				2. N 이 1인 경우 처리
 */
public class BOJ_1644 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		if(N == 1) {
			System.out.println(0);
			return;
		}
		
		int[] primeNumbers = getPrimeNumber(N);
		int sum = primeNumbers[0];
		int count = 0;
		
		int lp = 0;
		int rp = 0;
		
		while (lp < primeNumbers.length && rp < primeNumbers.length) {
			
			while(sum < N && rp < primeNumbers.length-1) {
				sum += primeNumbers[++rp];
			}
			
			if(sum == N) {
				count++;
			}
			
			sum -= primeNumbers[lp++];
		}
		
		System.out.println(count);

	}
	
	private static int[] getPrimeNumber(int N) {
		
		int[] numbers = new int[N+1];;

		for (int i = 2; i <= N; i++) {
			numbers[i] = i;
		}
		
		for (int i = 2; i <= N; i++) {
			if(numbers[i] == 0) continue; //지워진 수
			
			for (int j = i+i; j <= N; j+=i) {
				numbers[j] = 0;
			}
			
		}
		
		return Arrays.stream(numbers).filter(v -> v != 0).toArray();
	}

}
