import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class ContinuitSumBuffer {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int size = Integer.parseInt(br.readLine());
		int[] arr = new int[size];
		int[] dp = new int[size];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < size; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0] = arr[0];
		int answer = dp[0];
		
		//������ ���ؿ� ���� �迭�� ����� ���� ���� ū ���� dp���̺� �����Ѵ�
		for(int i = 1; i < size; i++) {
			int num = dp[i - 1] + arr[i];
			
			if(num > arr[i]) {
				dp[i] = num;
			}else {
				dp[i] = arr[i];
			}
			
			//dp���̺� ����� ������ �����س��� answer�� ���� dp������ answer���� ũ�� answer�� �����Ѵ�
			if(answer < dp[i]) {
				answer = dp[i];
			}
		}
		
		bw.write(String.valueOf(answer));
		bw.flush();
	}

}
