package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2504 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		String temp = String.valueOf(input);
		
		int strLength = 0;
		while (temp.length() != strLength) {
			strLength = temp.length();

			temp = temp.replace("()", "");	
			temp = temp.replace("[]", "");	
		}
		
		if("".equals(temp)) {
			System.out.println(0);
		}else {
			input = input.replace("()", "2");
			input = input.replace("[]", "3");
		}
		
		//(()[[]])([]))
		
		//(2[3])(3))
		
		//(()[[]])([]))
		
	}

}
