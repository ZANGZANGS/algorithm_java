package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_17413 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		StringBuilder sb = new StringBuilder();
		
		Stack<Character> stack = new Stack<Character>();
		
		boolean isTag = false;
		
		for (int i = 0; i < input.length(); i++) {
			
			if('<' == input.charAt(i)){
				isTag = true;
			}
			if('>' == input.charAt(i)) {
				isTag = false;
			}
			
			
			if(isTag) {
				while (!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				sb.append(input.charAt(i));
			}else {
				if(' ' == input.charAt(i)) {
					while (!stack.isEmpty()) {
						sb.append(stack.pop());
					}
					sb.append(input.charAt(i));
				}else if('>' == input.charAt(i)){
					sb.append(input.charAt(i));
				}else{
				
					stack.push(input.charAt(i));
				}
				
			}
		}
		
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		System.out.println(sb.toString());
		
	}

}
