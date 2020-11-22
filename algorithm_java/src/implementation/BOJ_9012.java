package implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BOJ_9012 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int round = Integer.parseInt(br.readLine());
		
		Stack<Character> stack =  new Stack<Character>();
		for (int i = 0; i < round; i++) {
			
			String  input = br.readLine();
			stack.clear();
			
			for (int j = 0; j < input.length(); j++) {
				char at = input.charAt(j);
				
				switch (at) {
				
				case '(':
					stack.add(at);
					break;
					
				case ')':
					if(!stack.empty() && stack.peek() == '(') {
						stack.pop();
					}else {
						stack.add(at);
					}
					
					break;

				default:
					break;
				}
			}
			
			if(stack.empty()) {
				bw.write("YES\n");
			}else {
				bw.write("NO\n");
			}
		}
		
		bw.flush();
		bw.close();
	}
}
