import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class PadobanBuffer {
	
	static long[] fibonachi_arr = new long[100];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		fibonachi_arr[0] = 1; fibonachi_arr[1] = 1; fibonachi_arr[2] = 1;
		
		StringTokenizer st = null;
		for(int i = 0 ; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			if(N <= 3) {
				bw.write(String.valueOf(1));
				bw.newLine();
			}else {
				long result = P(N - 4) + P(N - 3);//피보나치 함수로 이동
				bw.write(String.valueOf(result));
				bw.newLine();
			}
		}
		
		bw.flush();
		bw.close();
	}
	
	public static long P(int num) {
		if(num == 2 || num == 1 || num == 0) {
			return fibonachi_arr[num];
		}else if(fibonachi_arr[num] != 0){
			return fibonachi_arr[num];
		}else {
			long num1 = P(num - 3);
			long num2 = P(num - 2);
			fibonachi_arr[num] = num1 + num2;
			
			return num1 + num2;
		}
	}

}
