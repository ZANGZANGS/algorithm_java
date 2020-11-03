/**
 * Z 로 방문하기
 */
package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1074 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input, " ");
		
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		System.out.println(zVisit(N, r, c));
	}
	
	public static int zVisit(int N, int r, int c) {
		
		if(N == 0){
			return 0;
		} else {
			int dist = 1<<(N-1);	// 좌표를 움직일 거리
			
			if(r<dist && c<dist) return zVisit(N-1, r, c);								//1 
			else if(r<dist && c>=dist) return (dist*dist) + zVisit(N-1, r, c-dist);		//2
			else if(r>=dist && c<dist) return (dist*dist)*2 + zVisit(N-1, r-dist, c);	//3
			else return (dist*dist)*3 + zVisit(N-1, r-dist, c-dist);					//4
		}
	}
}




//package recursion;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class BOJ_1074 {
//
//	static int count;
//	static int r;
//	static int c;
//	static boolean isFind;
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String input = br.readLine();
//		StringTokenizer st = new StringTokenizer(input, " ");
//		
//		int N = Integer.parseInt(st.nextToken());
//		r = Integer.parseInt(st.nextToken());
//		c = Integer.parseInt(st.nextToken());
//		
//		int dot = 1<<(N-1);
//		goZ(N, dot, dot);
//		
//		//System.out.println("COUNT: "+count);
//	}
//	
////		(1<<n * 1<<n)/4		z그리기 횟수
////		n=1  2*2=4			1			1,1
////		n=2  4*4=16  		4			2,2
////		n=3  8*8=64  		16			4,4
////		n=4  16*16= 		64			8,8	
//	
//	//n 번째에 
//	public static void goZ(int n, int rDot, int cDot) {
//		if(!isFind) {
//			if(n == 1) {
//				zMove(rDot, cDot);			//4, 4
//			} else {
//				int moveDot = 1<<(n-2);	//상하좌우로 움직이는 칸수
//				
//				goZ(n-1, rDot-moveDot, cDot-moveDot);	// 2 2
//				goZ(n-1, rDot-moveDot, cDot+moveDot);	// 2 6
//				goZ(n-1, rDot+moveDot, cDot-moveDot);	// 6 2
//				goZ(n-1, rDot+moveDot, cDot+moveDot);	// 6 6
//			}
//		}
//			
//		
//	}
//	public static void zMove(int rDot, int cDot) {
//		if(r == rDot-1 && c == cDot-1) {
//			System.out.println(count); 
//			isFind = true;
//		}
//		count++;
//		if(r == rDot-1 && c == cDot) {
//			System.out.println(count); 
//			isFind = true;
//		}
//		count++;
//		if(r == rDot && c == cDot-1)  {
//			System.out.println(count); 
//			isFind = true;
//		}
//		count++;
//		if(r == rDot && c == cDot) {
//			System.out.println(count); 
//			isFind = true;
//		}
//		count++;
//	}
//}
