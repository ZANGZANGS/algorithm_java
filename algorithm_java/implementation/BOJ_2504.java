package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_2504 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		
		Stack<String> stack = new Stack<>();
		int num = 0;
		boolean isGood = true;
		
		for (int i = 0; i < input.length(); i++) {
			
			
			String at = input.substring(i, i+1);
			if("(".equals(at)) {
				stack.push(")");
				continue;
			}
			
			if("[".equals(at)) {
				stack.push("]");
				continue;
			}
			
			while(true) {
				if(stack.isEmpty()) {
					isGood = false;
					break;
				}
				
				if(isNumber(stack.peek())) {
					num += Integer.parseInt(stack.pop());
				}else {
					if(at.equals(stack.peek())) {
						stack.pop();
						if(num != 0) {
							if(")".equals(at)) {
								stack.push(Integer.toString(2*num));
								num = 0;
							}else {	//"]"
								stack.push(Integer.toString(3*num));
								num = 0;
							}
						}else {
							if(")".equals(at)) {
								stack.push(Integer.toString(2));
							}else {	//"]"
								stack.push(Integer.toString(3));
							}
						}
						break;
					}else {
						isGood= false;
						break;
					}
				}
			}
			if(!isGood) break;
			
			
		}
		
		int result=0;
		while (!stack.empty()) {
			if(isNumber(stack.peek())) {
				result += Integer.parseInt(stack.pop());
			}else {
				isGood = false;
				break;
			}
		}
		result = isGood ? result : 0 ;
		System.out.println(result);
		
	}

	public static boolean isNumber(String input) {
		if(")".equals(input) || "]".equals(input)) {
			return false;
		}else {
			return true;
		}
	}
}
