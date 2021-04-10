import java.util.Scanner;
public class RGBload {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		int[][]cost = new int[N][3];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < 3; j++) {
				cost[i][j] = in.nextInt();
			}
		}
		
		int[][] sum = new int[N][3];
		sum[0][0] = cost[0][0];
		sum[0][1] = cost[0][1];
		sum[0][2] = cost[0][2];
		
		int line = 1;
		while(line != N) {
			for(int i = 0; i < 3; i++) {
				int min = 2147483647;
				
				for(int j = 0; j < 3; j++) {
					if(i != j) {
						if(min > sum[line - 1][j]) {
							min = sum[line - 1][j];
						}
					}
				}//in-for
				
				sum[line][i] = min + cost[line][i];
			}//out-for
			line++;
		}//while
		
		int answer = 2147483647;
		for(int i = 0; i < 3; i++) {
			if(answer > sum[N - 1][i]) {
				answer = sum[N - 1][i];
			}
		}
		
		System.out.println(answer);
		
	}

}
