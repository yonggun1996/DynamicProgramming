import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Fibonachi {
	
	static int[][] static_arr = new int[41][2]; //피보나치 함수에서 구한 연산을 담는 배열을 먼저 선언
	
	public int[] fibonachi(int n) {
		if(n == 0) {
			int[] arr = {1,0};//f(0)은 0이 1번 호출된다
			return arr;
		}else if(n == 1) {
			int[] arr = {0,1};//f(1)은 1이 1번 호출된다
			return arr;
		}else if(static_arr[n][0] != 0 && static_arr[n][1] != 0) {//이미 계산한 값이 있다면
			int num1 = static_arr[n][0];//0이 호출된 수
			int num2 = static_arr[n][1];//1이 호출된 수
			int[] arr = {num1, num2};
			return arr;
		}else {
			int[] arr1 = fibonachi(n - 1);//f(n-1)이 0과 1을 몇 번 호출했는지 확인
			int[] arr2 = fibonachi(n - 2);//f(n-2)가 0과 1을 몇 번 호출했는지 확인
			
			int[] arr = new int[2];
			for(int i = 0; i < 2; i++) {
				//각각 0이 호출된 수와 1이 호출된 수를 더해 선언한 배열에 저장한다
				arr[i] = arr1[i] + arr2[i];
				static_arr[n][i] = arr1[i] + arr2[i];
			}
			
			return arr;
		}
	}

	public static void main(String[] args) throws IOException {
		Fibonachi f = new Fibonachi();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		static_arr[1][1] = 1;
		static_arr[0][0] = 1;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			
			int[] arr = f.fibonachi(n);
			
			for(int j = 0; j < 2; j++) {
				bw.write(String.valueOf(arr[j]) + " ");
			}
			bw.newLine();
			
		}
		
		bw.flush();
		bw.close();
	}//main

}
