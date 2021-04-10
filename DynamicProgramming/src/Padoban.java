import java.util.Scanner;

public class Padoban {
	
	static long[] fibonachi_arr = new long[100];

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		fibonachi_arr[0] = 1; fibonachi_arr[1] = 1; fibonachi_arr[2] = 1;
		
		for(int i = 0; i < T; i++) {
			int N = in.nextInt();
			
			if(N <= 3) {
				System.out.println(1);
			}else {
				long result = P(N - 4) + P(N - 3);//피보나치 함수로 이동
				System.out.println(result);
			}
		}
	}
	
	public static long P(int num) {
		if(num == 2 || num == 1 || num == 0) {
			return fibonachi_arr[num];
		}else if(fibonachi_arr[num] != 0){
			return fibonachi_arr[num];
		}else {
			long num1 = P(num - 3);
			long num2 = P(num - 2);
			fibonachi_arr[num] = num1 + num2;
			
			return num1 + num2;
		}
	}

}
