package z_coding.text.y2021.line;

public class Sol001 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		solution(new int[] {0,1,0,0}, 1);		//6
		solution(new int[] {0,1,0,0,1,1,0}, 2);		//8
		solution(new int[] {0,1,0}, 2);		//2
	}

	static int je;
	static boolean[] isused;
	
	 public static int solution(int[] student, int k) {
	        
		 isused = new boolean[student.length];
		 
		 int answer = -1;
	        return answer;
	 }
	 
//	 public static func(int[] arr, int k, int step) {
//		 if(k == step) {
//			 
//			 return 0;
//		 }
//		 
//		 return 0;
//	 }
}
