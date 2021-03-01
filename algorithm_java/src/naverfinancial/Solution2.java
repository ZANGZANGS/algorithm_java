package naverfinancial;

public class Solution2 {

	public static void main(String[] args) {
		
		
		int result =solution(new int[]{1,2,5,9,9},5);
		
		
		System.out.println(result);
		
		
	}
	
	 static  int solution(int[] A, int X) {
		 int N = A.length;
	        if (N == 0) {
	            return -1;
	        }
	        int l = 0;
	        int r = N - 1;
	        while (l < r) {
	            int m = (l + r) / 2 +1;
	            if (A[m] > X) {
	                r = m - 1;
	            } else {
	                l = m;
	            }
	        }
//	        System.out.println("l:"+l);
//	        System.out.println("r:"+r);
	        if (A[l] == X) {
	            return l;
	        }
	        return -1;
	    }
	 
}
