package array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_11328 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//		System.out.println((int)'a'); // a 는 97
//		System.out.println((int)'z'); // z 는 122
		
		
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");
			String first = input[0];
			String second = input[1];
			
			int[] alphabet = new int[26];
			boolean isPossible = true;
			
			// 1. 배열에 알파벳 개수 세어 넣는다.
			for (int j = 0; j < first.length(); j++) {
				alphabet[(int)first.charAt(j)-97] +=1;	// 증가하고
			}
			for (int j = 0; j < second.length(); j++) {
				alphabet[(int)second.charAt(j)-97] -=1;	// 감소한다.
			}
			
			// 2. 배열 값 체크한다.
			for (int item : alphabet) {
				if(item != 0) {	// 배열에 0이 아니면 갯수가 맞지 않음으로 Impossible
					isPossible = false;
					break;
				}
			}
			
			// 3. 결과 누적
			bw.append(isPossible ? "Possible" : "Impossible");
			bw.newLine();
		}
		bw.flush();
	}

}
