package z.coding.text.y2020.NHN;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Sol1 {
  private static void solution(int numOfAllPlayers, int numOfQuickPlayers, char[] namesOfQuickPlayers, int numOfGames, int[] numOfMovesPerGame){
	  
	  //numOfQuickPlayers ���� ����� �ֵ� ��
	  //namesOfQuickPlayers �����ֵ� �̸�
	  // numOfGames ���� ���� Ƚ��
	  // numOfMovesPerGame ���Ӻ� ��ĭ �����̴��� 
	  
	  List<Gamer> list = new ArrayList<Gamer>();
	  int peek = 0;	//���� ��ġ
	  
	
	  // ���� ���ϱ� ó���� A
	  Gamer sulre = new Gamer('A', 1, false);
	  for (int j = 0; j < numOfQuickPlayers; j++) {
		  if(namesOfQuickPlayers[j] == 'A') {
			  sulre.fast = true;
		  }
	  }
	  
	  // ������ ���ϱ�
	  for (int i = 0; i < numOfAllPlayers-1; i++) {
		  list.add(new Gamer((char)('B'+i), 0, false));
		  
		  for (int j = 0; j < numOfQuickPlayers; j++) {
			  if(namesOfQuickPlayers[j] == (char)('B'+i)) {
				  list.get(i).fast= true;
			  }
		}
	}
	  
	 //���� ����
	  for (int i = 0; i < numOfGames; i++) {
		  int runCnt = numOfMovesPerGame[i];
		  
		  // ������ ���̰�,,
		  runCnt %= (numOfAllPlayers-1);
		  
		  // ���� ���� ��ġ Ȯ���ϰ�,,
		 if(peek+ runCnt > (numOfAllPlayers-1)) {
			 peek = (peek+ runCnt) - (numOfAllPlayers-1);
		 }else if(peek+ runCnt < 0) {
			 peek = (numOfAllPlayers-1) + (peek+ runCnt);
		 }else {
			 peek += runCnt;
		 }
		 //System.out.println("peek:"+peek);
		 // ���� �ٲ��� Ȯ���ϴ� �ڵ�,,
		 Gamer target = list.get(peek);
		 
		 if(target.fast) {
			 sulre.count +=1;
		  }else {
			  target.count +=1;
			  
			  char nameTemp;
			  int countTemp;
			  boolean fastTemp;
			  
			  nameTemp = target.name;
			  countTemp = target.count;
			  fastTemp = target.fast;
			  
			  list.get(peek).name  = sulre.name;
			  list.get(peek).count = sulre.count;
			  list.get(peek).fast  = sulre.fast;
			  
			  sulre.name = nameTemp;
			  sulre.count = countTemp;
			  sulre.fast = fastTemp;
		  }
		 
		 
	}
	  
	  for (int i = 0; i < list.size(); i++) {
		  System.out.println(list.get(i).name+ " "+ list.get(i).count);
	}
	  
	  System.out.println(sulre.name+ " "+ sulre.count);
	  
  }

  private static class InputData {
    int numOfAllPlayers;
    int numOfQuickPlayers;
    char[] namesOfQuickPlayers;
    int numOfGames;
    int[] numOfMovesPerGame;
  }

  private static InputData processStdin() {
    InputData inputData = new InputData();

    try (Scanner scanner = new Scanner(System.in)) {
      inputData.numOfAllPlayers = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

      inputData.numOfQuickPlayers = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
      inputData.namesOfQuickPlayers = new char[inputData.numOfQuickPlayers];
      System.arraycopy(scanner.nextLine().trim().replaceAll("\\s+", "").toCharArray(), 0, inputData.namesOfQuickPlayers, 0, inputData.numOfQuickPlayers);

      inputData.numOfGames = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
      inputData.numOfMovesPerGame = new int[inputData.numOfGames];
      String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
      for(int i = 0; i < inputData.numOfGames ; i++){
        inputData.numOfMovesPerGame[i] = Integer.parseInt(buf[i]);
      }
    } catch (Exception e) {
      throw e;
    }

    return inputData;
  }
  

  public static void main(String[] args) throws Exception {
    InputData inputData = processStdin();

    solution(inputData.numOfAllPlayers, inputData.numOfQuickPlayers, inputData.namesOfQuickPlayers, inputData.numOfGames, inputData.numOfMovesPerGame);
  }
  
  private static class Gamer {
		char name;
		int count;
		boolean fast;
		
		Gamer(char n, int c, boolean f){
			this.name = n;
			this.count = c;
			this.fast = f;
		}
	}
  
}



