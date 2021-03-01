package naverfinancial;

public class Solution1 {

	public static void main(String[] args) {
		
		
		int[] ans = new int[] {};
		
		int[] asd = new int[] {};
		
		
		
		
		
		System.out.println(ans.length);
		
		
	}
	
	 public int[] solution(String[] S) {
		 
		 int[] ans = new int[] {};
		 
		 for (int idx = 0; idx < S[0].length(); idx++) { //글자 인덱스
			 if(ans.length > 0) break;
			 for (int i = 0; i < S.length; i++) {
				for (int j = i+1; j < S.length; j++) {
					if(S[i].charAt(idx) == S[j].charAt(idx)) {
						ans= new int[]{i,j,idx};
						break;
					}
				}
			}
			
		 }

	        return ans;      
	    }
	 
}
