package queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_10845 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		Queue<String> que = new LinkedList<>();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(bf.readLine());
		
		String back = "";
		
		for (int i = 0; i < n; i++) {
			String[] input = bf.readLine().split(" ");
			
			if(input[0].equals("push")) {
				
				back = input[1];
				que.add(input[1]);
			}else if(input[0].equals("pop")) {
				bw.write(que.isEmpty()? "-1" : que.poll());
				bw.newLine();
			}else if(input[0].equals("size")) {
				bw.write(String.valueOf(que.size()));
				bw.newLine();
			}else if(input[0].equals("empty")) {
				bw.write(que.isEmpty()? "1" : "0");
				bw.newLine();
			}else if(input[0].equals("front")) {
				bw.write(que.isEmpty()? "-1" : que.peek());
				bw.newLine();
			}else if(input[0].equals("back")) {
				bw.write(que.isEmpty()? "-1" : back);
				bw.newLine();
			}
			
		}
		
		bw.flush();
		bw.close();
	}

}
