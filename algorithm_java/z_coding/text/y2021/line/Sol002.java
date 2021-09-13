package z_coding.text.y2021.line;

public class Sol002 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println('z' - 'a');
	}

	
	 public static String solution(String[] research, int n, int k) {
	     // n일동안 k번 검색
		 // 2* n*k
		 
		 int len = research.length;
		 int[] keywordCount = new int[26];
		 int[][] dayCount = new int[research.length][26];
		 
		 for (int i = 0; i < research.length ; i++) {
			 String word = research[i];
			 
			for (int j = 0; j < word.length(); j++) {
				char at = word.charAt(j);
//				keywordCount[at-'a']++; 
				
				dayCount[i][at-'a']++; // i번째날 검색어 횟수 j.
			}
		}
		 
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < 26; j++) {
				
			}
		}
		 
		 
		 
		 
		 
		 
		 
		String answer="";
		 
		 return answer;
	 }
}
