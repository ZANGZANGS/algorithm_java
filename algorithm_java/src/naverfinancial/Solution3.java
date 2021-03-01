package naverfinancial;

import java.util.Arrays;

public class Solution3 {

	public static void main(String[] args) {
		
		
		solution(new int[] {3, 2, -2, 5, -3});
		
		
		System.out.println(solution(new int[] {3, 2, -2, 5, -3}));
		
		
	}
	
	 static public int solution(int[] A) {
	     
		 Arrays.sort(A);
		 int r = A.length-1;
		 int l = 0;
		 
		 while (l+1 <r) {
			if(A[r] + A[l] == 0) {
				return A[r];
			}
			
			if(A[r] + A[l] > 0) {
				r--;
			}else if(A[r] + A[l] < 0){
				l++;
			}
			
			
		}
		 
		 return 0;
	   }
}
