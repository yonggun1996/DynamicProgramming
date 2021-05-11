import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class LCSBuffer {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str1 = br.readLine();
		String str2 = br.readLine();
		
		int[][] arr = new int[str1.length() + 1][str2.length() + 1];
		
		for(int i = 1; i <= str1.length(); i++) {
			for(int j = 1; j <= str2.length(); j++) {
				if(str1.charAt(i - 1) == str2.charAt(j - 1)) {//���ڰ� ���� ��� �� ���ھ� �� ����� 1�� ���� �����Ѵ�
					arr[i][j] = arr[i - 1][j - 1] + 1;
				}else {//�׷��� ���� ��� �����̳� ��ܿ� �� �� �� ū ���� �����Ѵ�
					int num1 = arr[i - 1][j];
					int num2 = arr[i][j - 1];
					
					if(num1 > num2) {
						arr[i][j] = num1;
					}else {
						arr[i][j] = num2;
					}
				}
			}
		}
		
		bw.write(String.valueOf(arr[str1.length()][str2.length()]));
		bw.flush();
	}

}
