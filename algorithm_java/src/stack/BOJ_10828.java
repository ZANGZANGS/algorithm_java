package stack;

import java.io.*;
import java.util.*;
public class BOJ_10828 {

	public static void main(String[] args) throws IOException{
		
		Stack<String> stack = new Stack<String>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String cmd = st.nextToken();
			if("push".equals(cmd)) {
				stack.push(st.nextToken());
			}else if("pop".equals(cmd)) {
				//System.out.println(stack.isEmpty() ? "-1" :stack.pop());
				bw.write(stack.isEmpty() ? "-1" :stack.pop());
				bw.newLine();
			}else if("size".equals(cmd)) {
				//System.out.println(stack.size());
				bw.write(stack.size()+"");
				bw.newLine();
			}else if("empty".equals(cmd)) {
				//System.out.println(stack.isEmpty() ? "1" : "0");
				bw.write(stack.isEmpty() ? "1" : "0");
				bw.newLine();
			}else if("top".equals(cmd)) {
				//System.out.println(stack.isEmpty() ? "-1" :stack.peek());
				bw.write(stack.isEmpty() ? "-1" :stack.peek());
				bw.newLine();
			}

		}
		br.close();
		
		bw.flush();
		bw.close();
	}

}
