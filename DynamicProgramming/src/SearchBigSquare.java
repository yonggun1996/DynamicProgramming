

public class SearchBigSquare {
	
	static int[][] st_board;

	public static void main(String[] args) {
		SearchBigSquare sbs = new SearchBigSquare();
		int[][] board = {{1,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1},{0,1,1,1,1}};
		
		int answer = sbs.solution(board);
		System.out.println(answer);
	}
	
	public int solution(int[][] board) {
		int answer = 0;
		int[][] change_board = board;
		
		//1�� �ϳ��� ������ answer�� 1�� �ٲ��ش�
		for(int i = 0; i < board.length; i++) {
			if(board[i][0] == 1) {
				answer = 1;
			}
		}
		
		for(int i = 0; i < board[0].length; i++) {
			if(board[0][i] == 1) {
				answer = 1;
			}
		}
		
		//���� ��, ����, ���ʿ� �̾����� �簢���� �ּ� �� ������ Ȯ���ϴ� for��
		for(int i = 1; i < board.length; i++) {
			for(int j = 1; j < board[0].length; j++) {
				if(board[i][j] == 1) {//���簢���� �����ؾ߸� ������ ������ �� �ִ�.
					int num1 = change_board[i - 1][j - 1];
					int num2 = change_board[i - 1][j];
					int num3 = change_board[i][j - 1];
						
					int min = Math.min(Math.min(num1, num2), num3);
						
					change_board[i][j] = min + 1;
					answer = Math.max(answer, change_board[i][j]);
				}
				
			}//in - for
		}//out - for
		
		
		return answer * answer;
	}
	

}
