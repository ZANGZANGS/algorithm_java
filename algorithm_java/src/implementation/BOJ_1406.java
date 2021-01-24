package implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.ListIterator;

public class BOJ_1406 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input = br.readLine();
		LinkedList<Character> list = new LinkedList<Character>();
		
		//����Ʈ�� �Է°� �ֱ�
		for (int i = 0; i < input.length(); i++) {
			list.add(input.charAt(i));
		}
		
		//����
		int round = Integer.parseInt(br.readLine());
		ListIterator<Character> liter = list.listIterator();
		
		while (liter.hasNext()) {//커서를 마지막으로 이동
			liter.next();
		}
		
		for (int i = 0; i < round; i++) {
			String commend = br.readLine();
			char cmd = commend.charAt(0);
			
			if('L' == cmd) {
				if(liter.hasPrevious()) liter.previous();
			}else if('D' == cmd) {
				if(liter.hasNext()) liter.next();
			}else if('B' == cmd) {
				if(liter.hasPrevious()) {
					liter.previous();
					liter.remove();
				}
			}else if('P' == cmd) {
				liter.add(commend.charAt(2));
			}
		}
		
		for(char c : list) {
			bw.append(c);
		}
		
		bw.flush();
		bw.close();
	}

}
