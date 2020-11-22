package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_10799 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		System.out.println(lazer(input));
	}
	
	static public int lazer(String input) {
		
		Stack<Character> stack = new Stack<Character>();
		int result = 0;
		
		for (int i = 0; i < input.length(); i++) {
			
			char at = input.charAt(i);
			
			switch (at) {
			case '(':
				stack.add(at);
				break;
				
			case ')':
				if(input.charAt(i-1) == '(') {// 레이저임 절단 고고
					stack.pop();
					result += stack.size();
				}else {// 쇠막대기 끝남
					stack.pop();
					result +=1;
				}
				break;
				

			default:
				break;
			}
			
		}
		
		
		return result;
	}

}

		