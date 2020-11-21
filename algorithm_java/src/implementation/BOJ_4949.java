package implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BOJ_4949 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Character> stack = new Stack<>();
				
		while (true) {
			stack.clear();
			String input = br.readLine();
			
			if(input.equals(".")) {
				bw.flush();
				break;
			}
			
			for (int i = 0; i < input.length(); i++) {
				char at = input.charAt(i);
				if(at == '(') {
					stack.add(at);
				}else if(at == '[') {
					stack.add(at);
					
				}else if(at == ')') {
					if(!stack.isEmpty() && stack.peek() == '(') {
						stack.pop();
					}else {
						bw.write("no\n");
						break;
					}
					
				}else if(at == ']') {
					if(!stack.isEmpty() && stack.peek() == '[') {
						stack.pop();
					}else {
						bw.write("no\n");
						break;
					}
				}
				
				if(i == input.length()-1) {
					String result = stack.empty() ? "yes\n" : "no\n";
					bw.write(result);
				}
			}
		}
	}
}
