package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
public class BOJ_1874 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		
		int target;
		int number = 1;
		boolean fail = false;
		
		for (int i=0; i<n ; i++) {
			target = Integer.parseInt(br.readLine());
			
			while (true) {
				//1.stack 최상단 확인
				if(!stack.isEmpty() && stack.peek() == target) {
					stack.pop();
					sb.append("-\n");
					break;
				}
				
				//2. 넣지 않은 수 number 확인
				if(target >= number) {
					stack.push(number);
					sb.append("+\n");
					number++;
					continue; //while 계속 진행 
				}
				
				//3. 찾는 수가 스택 안쪽으로 들어가버린 경우
				if(target < number) {
					fail = true;
					break;
				}
				
			}
			
			if(fail) break; //fail 플래그가 true 가되면 for문을 멈춘다.
		}
		
		
		//결과 출력 
		if(fail) {
			System.out.println("NO");
		}else {
			System.out.println(sb.toString());
		}
		
		
	}

}
