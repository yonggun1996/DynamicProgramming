import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class IntegerTriangleBuffer {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int length = Integer.parseInt(br.readLine());
		
		long[][] arr = new long[length][length];
		for(int i = 0; i < length; i++) {
			Arrays.fill(arr[i], -1);
		}
		
		StringTokenizer st = null;
		for(int i = 0; i < length; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j <= i; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 1; i < length; i++) {
			for(int j = 0; j <= i; j++) {
				if(j == 0) {//������ �� ������ ���� ���� ���� ������ �� �ִ�
					arr[i][j] += arr[i - 1][j];
				}else if(j == i) {// ������ �� ������ ���� �»��� ���� ������ �� �ִ�.
					arr[i][j] += arr[i - 1][j - 1];
				}else {//�� ��� �� �ƴ϶�� ������ �� �� �ִ� ���� ū �ε����� ���� ������ ������Ų��
					long num1 = arr[i - 1][j - 1];
					long num2 = arr[i - 1][j];
					
					if(num1 > num2) {//�»��� ���ڰ� �� ū��� �� �ε����� ���ڸ� ����
						arr[i][j] += num1;
					}else {//�ٷ��� �ε����� ���ڰ� �� ũ�� �� �ε����� ���ڸ� ����
						arr[i][j] += num2;
					}
				}
			}
		}
		
		long max = -1;
		for(int i = 0; i < length; i++) {
			if(max < arr[length - 1][i]) {
				max = arr[length - 1][i];
			}
		}
		
		bw.write(String.valueOf(max));
		bw.flush();
		bw.close();
		
	}

}
