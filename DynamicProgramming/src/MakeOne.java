import java.util.Scanner;

public class MakeOne {
	
	static int[] arr;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int num = in.nextInt();
		arr = new int[num + 1];
		arr[1] = 0;
		
		for(int i = 2; i <=num; i++) {
			int n = search(i, 0);
			arr[i] = n;
		}
		
		
		System.out.println(arr[num]);
	}
	
	public static int search(int num, int depth) {
		if(num == 1) {
			return depth;
		}else if(arr[num] != 0) {
			return arr[num] + depth;
		}else {
			int num1 = search(num - 1, depth + 1);
			
			int num2 = 2147483647;
			if(num % 2 == 0) {
				num2 = search(num / 2, depth + 1);
			}
			
			int num3 = 2147483647;
			if(num % 3 == 0) {
				num3 = search(num / 3, depth + 1);
			}
			
			int min = 0;
			if(num1 <= num2 && num1 <= num3) {
				min = num1;
			}else if(num2 <= num1 && num2 <= num3) {
				min = num2;
			}else if(num3 <= num1 && num3 <= num2) {
				min = num3;
			}
			
			return min;
		}
	}

}