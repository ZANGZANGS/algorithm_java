package stack;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2493 {

	public static void main(String[] args) throws IOException{
		int height, n;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		br.close();

		Stack<int[]> stack = new Stack<int[]>();//인덱스(앞의 타워 개수) ,타워 높이 저

		for (int i = 1; i <= n; i++) {
			height = Integer.parseInt(st.nextToken());
			
			while (!stack.isEmpty() && stack.peek()[1] < height) {
				stack.pop();
			}
			
			bw.write(stack.isEmpty() ? "0 " : String.valueOf(stack.peek()[0])+ " ");
			
			stack.push(new int[] {i, height});

		}
		
		bw.flush();
		bw.close();
		
	}

}
