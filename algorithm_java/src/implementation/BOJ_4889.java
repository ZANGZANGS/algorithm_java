package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
 
public class BOJ_4889 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Character> stack = new Stack<Character>();
		int result;
		int round =0;
		
		while (true) {
			stack.clear();
			result = 0;
			round++;
			
			String input = br.readLine();

			if(!"".equals(input) && input.charAt(0) == '-') {
				break;
			}
			
			for (int i = 0; i < input.length(); i++) {
				
				char at = input.charAt(i);
				
				switch (at) {
				case '{':
					stack.add(at);
					break;
				case '}':
					if(!stack.isEmpty() && stack.peek()=='{') {
						stack.pop();
					}else {
						stack.add(at);
					}
					break;
				default:
					break;
				}
			}
			
			while (!stack.empty()) {
				char temp1 = stack.pop();
				char temp2 = stack.pop();
				if(temp1 != temp2) {
					result += 2;
				}else {
					result += 1;
				}
			}
			System.out.println(round+". "+result);
		}
	}
}