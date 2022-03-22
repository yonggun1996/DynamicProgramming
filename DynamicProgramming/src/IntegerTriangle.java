import java.util.Arrays;
import java.util.Scanner;

public class IntegerTriangle {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int length = in.nextInt();
		
		long[][] arr = new long[length][length];
		for(int i = 0; i < length; i++) {
			Arrays.fill(arr[i], -1);
		}
		
		for(int i = 0; i < length; i++) {
			for(int j = 0; j <= i; j++) {
				arr[i][j] = in.nextInt();
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
					
					if(num1 > num2) {
						arr[i][j] += num1;
					}else {
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
		System.out.println(max);
	}

}
