import java.util.Scanner;

public class Fibonachi {
	
	static int[][] static_arr = new int[41][2];
	
	public int[] fibonachi(int n) {
		if(n == 0) {
			int[] arr = {1,0};
			return arr;
		}else if(n == 1) {
			int[] arr = {0,1};
			return arr;
		}else if(static_arr[n][0] != 0 && static_arr[n][1] != 0) {
			int num1 = static_arr[n][0];
			int num2 = static_arr[n][1];
			int[] arr = {num1, num2};
			return arr;
		}else {
			int[] arr1 = fibonachi(n - 1);
			int[] arr2 = fibonachi(n - 2);
			
			int[] arr = new int[2];
			for(int i = 0; i < 2; i++) {
				arr[i] = arr1[i] + arr2[i];
				static_arr[n][i] = arr1[i] + arr2[i];
			}
			
			return arr;
		}
	}

	public static void main(String[] args) {
		Fibonachi f = new Fibonachi();
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		
		static_arr[1][1] = 1;
		static_arr[0][0] = 1;
		
		for(int i = 0; i < N; i++) {
			int n = in.nextInt();
			
			int[] arr = f.fibonachi(n);
			
			for(int j = 0; j < 2; j++) {
				System.out.print(arr[j] + " ");
			}
			System.out.println();
			
		}
	}//main

}
