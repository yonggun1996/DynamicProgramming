import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BackpackBuffer {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int max_weight = Integer.parseInt(st.nextToken());
		int[] weight = new int[max_weight + 1];
		
		int[][] arr = new int[N][2];
		
		st = null;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = max_weight; j - arr[i][0] >= 0; j--) {
				if(weight[j] < weight[j - arr[i][0]] + arr[i][1]) {//기존 무게의 최대 가치가 최대무게 - 들어온 무게 의 인덱스 와 새로 들어온 가치를 더한 값보다 작으면 갱신
					weight[j] = weight[j - arr[i][0]] + arr[i][1];
				}
			}
		}
		
		bw.write(String.valueOf(weight[max_weight]));
		bw.flush();
		
	}
	
}
