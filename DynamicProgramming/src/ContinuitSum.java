import java.util.Scanner;

public class ContinuitSum {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int size = in.nextInt();
		int[] arr = new int[size];
		int[] dp = new int[size];
		
		for(int i = 0; i < size; i++) {
			arr[i] = in.nextInt();
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
		
		System.out.println(answer);
	}

}
