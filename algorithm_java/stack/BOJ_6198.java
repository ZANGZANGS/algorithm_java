package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_6198 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		long result = 0;	// (1+80000) /2 * 80000 > Integer.MAX_VALUE
		//System.out.println(Integer.MAX_VALUE);
		//> 2147483647
		int temp;	
		
		
		Stack<Integer> stack = new Stack<>();
		
		for (int i = 0; i < n; i++) {
			temp = Integer.parseInt(br.readLine());
			
			// 해당 건물 높이보다 같거나 작으면 삭제하여 처리한다.
			while(!stack.isEmpty() && stack.peek() <= temp) { //같은 층도 볼 수 없다.
				stack.pop();
			}
			
			result += stack.size();
			stack.push(temp);
				
		}
		
		System.out.println(result);
	}

}
