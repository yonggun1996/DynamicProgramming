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
		
		int[][] sum = new int[N][3];//앞서 칠했던 색과 비용을 합친 값을 담은 배열
		sum[0][0] = cost[0][0];
		sum[0][1] = cost[0][1];
		sum[0][2] = cost[0][2];
		
		int line = 1;//sum배열에 데이터를 삽입하기 위한 변수
		while(line != N) {
			for(int i = 0; i < 3; i++) {//sum배열에 데이터를 넣기 위한 for문
				int min = 2147483647;//이전 집 비용중 최소비용을 구하기 위한 변수
				
				for(int j = 0; j < 3; j++) {//이전 집 비용중 최소비용을 확인하기 위한 for문
					if(i != j) {
						if(min > sum[line - 1][j]) {//이전집과 중복되지 않으면서, 제일 작은값을 구한다
							min = sum[line - 1][j];
						}
					}
				}//in-for
				
				sum[line][i] = min + cost[line][i];
			}//out-for
			line++;
		}//while
		
		int answer = 2147483647;
		for(int i = 0; i < 3; i++) {//마지막 집 까지 비용을 구할 때 가장 작은값을 구하는 for문
			if(answer > sum[N - 1][i]) {
				answer = sum[N - 1][i];
			}
		}
		
		System.out.println(answer);
		
	}

}
