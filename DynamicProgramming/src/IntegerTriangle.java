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
				if(j == 0) {//������ �� ������ ���� ���� ���� ������ �� �ִ�
					arr[i][j] += arr[i - 1][j];
				}else if(j == i) {// ������ �� ������ ���� �»��� ���� ������ �� �ִ�.
					arr[i][j] += arr[i - 1][j - 1];
				}else {//�� ��� �� �ƴ϶�� ������ �� �� �ִ� ���� ū �ε����� ���� ������ ������Ų��
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
