package nf;

public class SQL1 {

	public static void main(String[] args) {

		
		System.out.println(solution("aabab"));
		System.out.println(solution("dog"));
		System.out.println(solution("baaaa"));
		System.out.println(solution("aa"));
		System.out.println(solution("ab"));

		
		System.out.println(solution("a"));
		
	}
	
	 static public int solution(String S) {

		 if(S.indexOf("aaa") != -1) {
			 return -1;
		 }

		 int aCnt = 0;
		 int tatol = 0;
		 
		 if(S.length() == 1) {
			 return S.equals("a") ? 1 : 2;
		 }
		 
		 
		 // a 개수 세기
		 for (int i = 0; i < S.length(); i++) {
			
			 char alphabet = S.charAt(i);
			
			 //처음부터 중간
			 if(alphabet == 'a') {
				 aCnt++;
			 }else {
				 tatol = tatol + (2-aCnt);
				 aCnt = 0;
			 }
			 
			 //마지막 글자
			 if(S.length()-1 == i) {
				 if(S.charAt(S.length()-1) != 'a') {
					 tatol+=2;
				 }else {
					 if(S.charAt(S.length()-2) != 'a') {
						 tatol+=1;
					 }
				 }
			 }
		}

	 
		 return tatol;
	 }

}
