package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_13015 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());

		System.out.print( new String(new char[num]).replace("\0", "*") );
		System.out.print( new String(new char[2*(num-1)-1]).replace("\0", " "));
		System.out.println( new String(new char[num]).replace("\0", "*"));
		
		for (int i = 0; i < num-2; i++) {
			System.out.print( new String(new char[i+1]).replace("\0", " ") );
			System.out.print("*");
			System.out.print( new String(new char[num-2]).replace("\0", " ") );
			System.out.print("*");
			System.out.print( new String(new char[2*(num-2-i)-1]).replace("\0", " ") );
			System.out.print("*");
			System.out.print( new String(new char[num-2]).replace("\0", " ") );
			System.out.println("*");
		}
		
		System.out.print( new String(new char[num-1]).replace("\0", " ") );
		System.out.print("*");
		System.out.print( new String(new char[num-2]).replace("\0", " "));
		System.out.print("*");
		System.out.print( new String(new char[num-2]).replace("\0", " "));
		System.out.println("*");
		
		for (int i = num-3; i >= 0; i--) {
			System.out.print( new String(new char[i+1]).replace("\0", " ") );
			System.out.print("*");
			System.out.print( new String(new char[num-2]).replace("\0", " ") );
			System.out.print("*");
			System.out.print( new String(new char[2*(num-2-i)-1]).replace("\0", " ") );
			System.out.print("*");
			System.out.print( new String(new char[num-2]).replace("\0", " ") );
			System.out.println("*");
		}
		
		System.out.print( new String(new char[num]).replace("\0", "*") );
		System.out.print( new String(new char[2*(num-1)-1]).replace("\0", " "));
		System.out.println( new String(new char[num]).replace("\0", "*"));
		
	}
}
