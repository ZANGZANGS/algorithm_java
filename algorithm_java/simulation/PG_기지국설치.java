package simulation;
//
/**
 * @source		: 프로그래머스
 * @algorithm	: 구현
 * @description	: 기지국 설치
 * ==============================================
 * DATE			NOTE	
 * ==============================================
 * 2021.12.23	성공
 */
public class PG_기지국설치 {

	public static void main(String[] args) {

		PG_기지국설치 pg = new PG_기지국설치();
		
		pg.solution(11, new int[] {4,11}, 1);
		pg.solution(16, new int[] {9}, 2);
	}

	public int solution(int n, int[] stations, int w) {
        int answer = 0;
        
        int width = 2*w +1;
        int len = stations.length;
        
		
        //첫 안테나 이후 ~ 마지막 안테나 이전
		for (int i = 0; i < stations.length; i++) {
			
			int bk = i-1 < 0 ? 0 : stations[i-1] + w;
			int ft = stations[i] - w; 
			
			if(ft> bk) {
				answer += (ft-bk-1)/width ; 
				if((ft-bk-1) % width != 0) answer++;
			}
			
		}
		//마지막 안테나 이후
		if(stations[len-1]+w < n) {
			answer += (n-(stations[len-1]+w))/width;
			if((n-(stations[len-1]+w)) % width != 0) answer++;
		}
        
         System.out.println(answer);
        return answer;
    }
}
