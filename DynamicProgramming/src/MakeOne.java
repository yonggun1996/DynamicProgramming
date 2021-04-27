import java.util.Scanner;

public class MakeOne {
	
	static int[] arr;
	/* 어떠한 수가 주어지고 -1, /2, /3을 했을 때
	 * 어떠한 방법이 1을 가장 빠르게 만들 수 있는가?
	 * 
	 * 1은 건드리지 않아도 1이기 때문에 0을 인덱스에 넣는다
	 * 2부터 입력받은 숫자까지 어떠한 방법이 빠른지 그 횟수를 넣는다
	 * 다만 숫자가 올라가면 올라갈수록 이전 숫자를 찾아와 연산횟수에 더해 속도를 빠르게 한다
	 */

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