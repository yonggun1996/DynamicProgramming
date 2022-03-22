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
				if(j == 0) {//라인의 맨 왼쪽의 수는 위의 수만 참고할 수 있다
					arr[i][j] += arr[i - 1][j];
				}else if(j == i) {// 라인의 맨 오른쪽 수는 좌상방면 수만 참고할 수 있다.
					arr[i][j] += arr[i - 1][j - 1];
				}else {//두 경우 다 아니라면 위에서 올 수 있는 수중 큰 인덱스의 수를 선택해 누적시킨다
					long num1 = arr[i - 1][j - 1];
					long num2 = arr[i - 1][j];
					
					if(num1 > num2) {//좌상방면 숫자가 더 큰경우 그 인덱스의 숫자를 누적
						arr[i][j] += num1;
					}else {//바로위 인덱스의 숫자가 더 크면 그 인덱스의 숫자를 누적
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
