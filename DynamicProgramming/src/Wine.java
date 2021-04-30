import java.util.Arrays;
import java.util.Scanner;

public class Wine {
	
	static int[] map;
	
	public static void main(String[] args) {
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
		
		if(size <= 2) {
			System.out.println(map[size]);
		}else {
			for(int i = 3; i <= size; i++) {
				/*
				 * 출처 : https://st-lab.tistory.com/135
				 * https://www.youtube.com/watch?v=-MyiVOsrjCw&t=185s
				 */
				
				int num1 = map[i - 1];//기존에 구했던 최댓값
				int num2 = map[i - 2] + arr[i];//해당 인덱스를 선택하고 2칸 전의 최대값을 선택한 경우
				int num3 = map[i - 3] + arr[i - 1] + arr[i];//해당 인덱스와 그 이전 인덱스를 선택하고 3칸 뒤의 합계를 선택한 경우
			
				int max = Math.max(Math.max(num1, num2), num3);
				map[i] = max;
			}
			System.out.println(map[size]);
		}
		
	}
	
}
