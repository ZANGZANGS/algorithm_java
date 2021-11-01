package z_coding.test.y2021.nf;

public class SOL_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution(5, 3); //정답: 5,2
		//solution(3, 10); //정답: 5,2

	}

	 public static int[] solution(int n, int jump) {
        int[] answer = {};

        
        int[] arr = new int[n*n];
        
        
        int idx = 0; //현재 돌고 있는 idx
        int ord = 1; //점프 순서
        int jmpCnt=1;
        
        while (ord <= n*n) {
			
        		
    		if(idx >= n*n) {
        		idx = idx - (n*n);
        	}
    		
    		if(arr[idx] == 0) {
    			jmpCnt--;
    			
    			if(jmpCnt == 0) {
    				arr[idx] = ord++;
    				jmpCnt = jump;
    			}
    			
    		}
			
    		idx++;
		}
       
        
        int y = 1;
        int x = 1;
        
        boolean xUp = true;
        boolean yUp = true;
        
        int size = n;
        
        
        
        
        return answer;
        
        //
    }
}
