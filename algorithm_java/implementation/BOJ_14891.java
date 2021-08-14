/**
 * Åé´Ï¹ÙÄû
 */
package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_14891 {
	static int[][] wheel;
	public static void main(String[] args) throws IOException {
		
		int round; 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		wheel = new int[4][8];
		
		for (int i = 0; i < 4; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < 8; j++) {
				wheel[i][j] = temp[j]-'0';
			}
		}
		
		round = Integer.parseInt(br.readLine());
		for (int i = 0; i < round; i++) {
			String temp = br.readLine();
			int target = Integer.parseInt(temp.split(" ")[0])-1;//¹è¿­ÀÌ¶ó 1 –A´Ù.
			int direction= Integer.parseInt(temp.split(" ")[1]);
			
			left(target-1, -direction);
			right(target+1, -direction);
			rotateWheel(target, direction);
			
		}
		
		//Á¡¼ö °è»ê
//		1¹ø Åé´Ï¹ÙÄûÀÇ 12½Ã¹æÇâÀÌ N±ØÀÌ¸é 0Á¡, S±ØÀÌ¸é 1Á¡
//		2¹ø Åé´Ï¹ÙÄûÀÇ 12½Ã¹æÇâÀÌ N±ØÀÌ¸é 0Á¡, S±ØÀÌ¸é 2Á¡
//		3¹ø Åé´Ï¹ÙÄûÀÇ 12½Ã¹æÇâÀÌ N±ØÀÌ¸é 0Á¡, S±ØÀÌ¸é 4Á¡
//		4¹ø Åé´Ï¹ÙÄûÀÇ 12½Ã¹æÇâÀÌ N±ØÀÌ¸é 0Á¡, S±ØÀÌ¸é 8Á¡
		int result = 0;
		for (int i = 0; i < 4; i++) {
			result += wheel[i][0] * (1<<i);
			
		}
		System.out.println(result);
	}
	
	public static void left(int target, int direction) {
		if (target <0) return;
		
		if(wheel[target][2] != wheel[target+1][6]) {
			left(target-1, -direction);
			rotateWheel(target, direction);
		}
		
	}
	
	public static void right(int target, int direction) {
		if (target >3) return;
		
		if(wheel[target][6] != wheel[target-1][2]) {
			right(target+1, -direction);
			rotateWheel(target, direction);
			
		}
	}
	
	public static void rotateWheel(int target, int direction) {
		int temp;
		if(direction == 1) {// ½Ã°è¹æÇâ È¸Àü
			temp = wheel[target][7];
			for (int i = 7; i > 0; i--) {
				wheel[target][i] = wheel[target][i-1];
			}
			wheel[target][0] = temp;
			
		}else if(direction == -1){// ¹Ý½Ã°è
			temp = wheel[target][0];
			for (int i = 0; i <7 ; i++) {
				wheel[target][i] = wheel[target][i+1];
			}
			wheel[target][7] = temp;
		}
	}
}

