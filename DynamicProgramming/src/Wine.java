import java.util.Arrays;
import java.util.Scanner;

public class Wine {
	
	static int[] map;
	
	public static void main(String[] args) {
		Wine w = new Wine();
		Scanner in = new Scanner(System.in);
		
		int size = in.nextInt();
		int[] arr = new int[size + 1];
		map = new int[size + 1];
		
		for(int i = 1; i <= size; i++) {
			arr[i] = in.nextInt();
		}
		
		if(size >= 1) {
			map[1] = arr[1];
		}
		
		if(size >= 2) {
			map[2] = arr[1] + arr[2];
		}
		
		/*if(size >= 3) {
			int max = Math.max(arr[0], arr[1]);
			map[3] = max + arr[2];
		}*/
		
		if(size <= 3) {
			System.out.println(map[size]);
		}else {
			/*for(int i = 4; i <= size; i++) {
				int num1 = map[i - 3] + arr[i - 2] + arr[i - 1];
				int num2 = map[i - 2] + arr[i - 1];
				int num3 = map[i - 1];
				
				map[i] = Math.max(Math.max(num1, num2), num3);
			}
			
			System.out.println(map[size]);
		}*/
			for(int i = 3; i <= size; i++) {
				int num1 = map[i - 1];
				int num2 = map[i - 2] + arr[i];
				int num3 = map[i - 3] + arr[i - 1] + arr[i];
			
				int max = Math.max(Math.max(num1, num2), num3);
				map[i] = max;
			}
			System.out.println(map[size]);
		}
		
	}
	
}
