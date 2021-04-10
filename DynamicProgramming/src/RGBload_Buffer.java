import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class RGBload_Buffer {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[][] cost = new int[N][3];
		
		StringTokenizer st = null;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
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
		
		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}

}
