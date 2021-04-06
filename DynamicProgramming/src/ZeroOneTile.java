import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class ZeroOneTile {
	
	static int[] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		if(N == 1) {
			bw.write(String.valueOf(1));
		}else if(N == 2) {
			bw.write(String.valueOf(2));
		}else {
			arr = new int[N + 1];
			Arrays.fill(arr, -1);
			
			arr[0] = 0;
			arr[1] = 1;
			arr[2] = 2;
			
			int answer = fibonachi(N);
			bw.write(String.valueOf(answer));
		}
		
		bw.flush();
		bw.close();
	}
	
	public static int fibonachi(int n) {
		if(n <= 2) {
			return arr[n];
		}else if(arr[n] != -1) {
			return arr[n];
		}else {
			int n1 = fibonachi(n - 1);
			int n2 = fibonachi(n - 2);
			arr[n] = (n1 + n2) % 15746;
			return arr[n];
		}
	}

}
